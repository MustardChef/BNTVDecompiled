package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableFlatMapSingle<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayErrors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final int maxConcurrency;

    public FlowableFlatMapSingle(Flowable<T> source, Function<? super T, ? extends SingleSource<? extends R>> mapper, boolean delayError, int maxConcurrency) {
        super(source);
        this.mapper = mapper;
        this.delayErrors = delayError;
        this.maxConcurrency = maxConcurrency;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        this.source.subscribe((FlowableSubscriber) new FlatMapSingleSubscriber(s, this.mapper, this.delayErrors, this.maxConcurrency));
    }

    /* loaded from: classes4.dex */
    static final class FlatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;
        volatile boolean cancelled;
        final boolean delayErrors;
        final Subscriber<? super R> downstream;
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;
        final int maxConcurrency;
        Subscription upstream;
        final AtomicLong requested = new AtomicLong();
        final CompositeDisposable set = new CompositeDisposable();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<SpscLinkedArrayQueue<R>> queue = new AtomicReference<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        public FlatMapSingleSubscriber(Subscriber<? super R> actual, Function<? super T, ? extends SingleSource<? extends R>> mapper, boolean delayErrors, int maxConcurrency) {
            this.downstream = actual;
            this.mapper = mapper;
            this.delayErrors = delayErrors;
            this.maxConcurrency = maxConcurrency;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    s.request(Long.MAX_VALUE);
                } else {
                    s.request(i);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                SingleSource<? extends R> apply = this.mapper.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                SingleSource<? extends R> singleSource = apply;
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.cancelled || !this.set.add(innerObserver)) {
                    return;
                }
                singleSource.subscribe(innerObserver);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            this.active.decrementAndGet();
            if (this.errors.tryAddThrowableOrReport(t)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
            this.errors.tryTerminateAndReport();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        void innerSuccess(FlatMapSingleSubscriber<T, R>.InnerObserver inner, R value) {
            this.set.delete(inner);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    if (this.requested.get() != 0) {
                        this.downstream.onNext(value);
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
                        if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                            this.errors.tryTerminateConsumer(this.downstream);
                            return;
                        }
                        BackpressureHelper.produced(this.requested, 1L);
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.upstream.request(1L);
                        }
                    } else {
                        SpscLinkedArrayQueue<R> orCreateQueue = getOrCreateQueue();
                        synchronized (orCreateQueue) {
                            orCreateQueue.offer(value);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                }
            }
            SpscLinkedArrayQueue<R> orCreateQueue2 = getOrCreateQueue();
            synchronized (orCreateQueue2) {
                orCreateQueue2.offer(value);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        SpscLinkedArrayQueue<R> getOrCreateQueue() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
            if (spscLinkedArrayQueue != null) {
                return spscLinkedArrayQueue;
            }
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
            return this.queue.compareAndSet(null, spscLinkedArrayQueue2) ? spscLinkedArrayQueue2 : this.queue.get();
        }

        void innerError(FlatMapSingleSubscriber<T, R>.InnerObserver inner, Throwable e) {
            this.set.delete(inner);
            if (this.errors.tryAddThrowableOrReport(e)) {
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    this.set.dispose();
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(1L);
                }
                this.active.decrementAndGet();
                drain();
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void clear() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
            if (r13 != 0) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
            if (r17.cancelled == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
            clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
            if (r17.delayErrors != false) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0081, code lost:
            if (r17.errors.get() == null) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
            clear();
            r17.errors.tryTerminateConsumer(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x008b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0090, code lost:
            if (r2.get() != 0) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0094, code lost:
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x009b, code lost:
            if (r7 == null) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a1, code lost:
            if (r7.isEmpty() == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a3, code lost:
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a4, code lost:
            if (r6 == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a6, code lost:
            if (r12 == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a8, code lost:
            r17.errors.tryTerminateConsumer(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00ad, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b0, code lost:
            if (r10 == 0) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00b2, code lost:
            io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r17.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00bc, code lost:
            if (r17.maxConcurrency == Integer.MAX_VALUE) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00be, code lost:
            r17.upstream.request(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c3, code lost:
            r5 = addAndGet(-r5);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                r17 = this;
                r0 = r17
                org.reactivestreams.Subscriber<? super R> r1 = r0.downstream
                java.util.concurrent.atomic.AtomicInteger r2 = r0.active
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<R>> r3 = r0.queue
                r4 = 1
                r5 = 1
            La:
                java.util.concurrent.atomic.AtomicLong r6 = r0.requested
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L13:
                r12 = 0
                int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r13 == 0) goto L6b
                boolean r14 = r0.cancelled
                if (r14 == 0) goto L20
                r17.clear()
                return
            L20:
                boolean r14 = r0.delayErrors
                if (r14 != 0) goto L39
                io.reactivex.rxjava3.internal.util.AtomicThrowable r14 = r0.errors
                java.lang.Object r14 = r14.get()
                java.lang.Throwable r14 = (java.lang.Throwable) r14
                if (r14 == 0) goto L39
                r17.clear()
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r0.errors
                org.reactivestreams.Subscriber<? super R> r2 = r0.downstream
                r1.tryTerminateConsumer(r2)
                return
            L39:
                int r14 = r2.get()
                if (r14 != 0) goto L41
                r14 = 1
                goto L42
            L41:
                r14 = 0
            L42:
                java.lang.Object r15 = r3.get()
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue r15 = (io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue) r15
                if (r15 == 0) goto L4f
                java.lang.Object r15 = r15.poll()
                goto L50
            L4f:
                r15 = 0
            L50:
                if (r15 != 0) goto L55
                r16 = 1
                goto L57
            L55:
                r16 = 0
            L57:
                if (r14 == 0) goto L61
                if (r16 == 0) goto L61
                io.reactivex.rxjava3.internal.util.AtomicThrowable r2 = r0.errors
                r2.tryTerminateConsumer(r1)
                return
            L61:
                if (r16 == 0) goto L64
                goto L6b
            L64:
                r1.onNext(r15)
                r12 = 1
                long r10 = r10 + r12
                goto L13
            L6b:
                if (r13 != 0) goto Lae
                boolean r6 = r0.cancelled
                if (r6 == 0) goto L75
                r17.clear()
                return
            L75:
                boolean r6 = r0.delayErrors
                if (r6 != 0) goto L8c
                io.reactivex.rxjava3.internal.util.AtomicThrowable r6 = r0.errors
                java.lang.Object r6 = r6.get()
                java.lang.Throwable r6 = (java.lang.Throwable) r6
                if (r6 == 0) goto L8c
                r17.clear()
                io.reactivex.rxjava3.internal.util.AtomicThrowable r2 = r0.errors
                r2.tryTerminateConsumer(r1)
                return
            L8c:
                int r6 = r2.get()
                if (r6 != 0) goto L94
                r6 = 1
                goto L95
            L94:
                r6 = 0
            L95:
                java.lang.Object r7 = r3.get()
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue r7 = (io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue) r7
                if (r7 == 0) goto La3
                boolean r7 = r7.isEmpty()
                if (r7 == 0) goto La4
            La3:
                r12 = 1
            La4:
                if (r6 == 0) goto Lae
                if (r12 == 0) goto Lae
                io.reactivex.rxjava3.internal.util.AtomicThrowable r2 = r0.errors
                r2.tryTerminateConsumer(r1)
                return
            Lae:
                int r6 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r6 == 0) goto Lc3
                java.util.concurrent.atomic.AtomicLong r6 = r0.requested
                io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r6, r10)
                int r6 = r0.maxConcurrency
                r7 = 2147483647(0x7fffffff, float:NaN)
                if (r6 == r7) goto Lc3
                org.reactivestreams.Subscription r6 = r0.upstream
                r6.request(r10)
            Lc3:
                int r5 = -r5
                int r5 = r0.addAndGet(r5)
                if (r5 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapSingle.FlatMapSingleSubscriber.drainLoop():void");
        }

        /* loaded from: classes4.dex */
        final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this, d);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R value) {
                FlatMapSingleSubscriber.this.innerSuccess(this, value);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable e) {
                FlatMapSingleSubscriber.this.innerError(this, e);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
