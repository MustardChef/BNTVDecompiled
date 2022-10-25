package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableWindow<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long size;
    final long skip;

    public FlowableWindow(Flowable<T> source, long size, long skip, int bufferSize) {
        super(source);
        this.size = size;
        this.skip = skip;
        this.bufferSize = bufferSize;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> s) {
        long j = this.skip;
        long j2 = this.size;
        if (j == j2) {
            this.source.subscribe((FlowableSubscriber) new WindowExactSubscriber(s, this.size, this.bufferSize));
        } else if (j > j2) {
            this.source.subscribe((FlowableSubscriber) new WindowSkipSubscriber(s, this.size, this.skip, this.bufferSize));
        } else {
            this.source.subscribe((FlowableSubscriber) new WindowOverlapSubscriber(s, this.size, this.skip, this.bufferSize));
        }
    }

    /* loaded from: classes4.dex */
    static final class WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        final int bufferSize;
        final Subscriber<? super Flowable<T>> downstream;
        long index;
        final AtomicBoolean once;
        final long size;
        Subscription upstream;
        UnicastProcessor<T> window;

        WindowExactSubscriber(Subscriber<? super Flowable<T>> actual, long size, int bufferSize) {
            super(1);
            this.downstream = actual;
            this.size = size;
            this.once = new AtomicBoolean();
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept;
            long j = this.index;
            UnicastProcessor<T> unicastProcessor = this.window;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.bufferSize, this);
                this.window = unicastProcessor;
                flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                this.downstream.onNext(flowableWindowSubscribeIntercept);
            } else {
                flowableWindowSubscribeIntercept = null;
            }
            long j2 = j + 1;
            unicastProcessor.onNext(t);
            if (j2 == this.size) {
                this.index = 0L;
                this.window = null;
                unicastProcessor.onComplete();
            } else {
                this.index = j2;
            }
            if (flowableWindowSubscribeIntercept == null || !flowableWindowSubscribeIntercept.tryAbandon()) {
                return;
            }
            flowableWindowSubscribeIntercept.window.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(t);
            }
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                this.upstream.request(BackpressureHelper.multiplyCap(this.size, n));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        final int bufferSize;
        final Subscriber<? super Flowable<T>> downstream;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        final long size;
        final long skip;
        Subscription upstream;
        UnicastProcessor<T> window;

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> actual, long size, long skip, int bufferSize) {
            super(1);
            this.downstream = actual;
            this.size = size;
            this.skip = skip;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept;
            long j = this.index;
            UnicastProcessor<T> unicastProcessor = this.window;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.bufferSize, this);
                this.window = unicastProcessor;
                flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                this.downstream.onNext(flowableWindowSubscribeIntercept);
            } else {
                flowableWindowSubscribeIntercept = null;
            }
            long j2 = j + 1;
            if (unicastProcessor != null) {
                unicastProcessor.onNext(t);
            }
            if (j2 == this.size) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            if (j2 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j2;
            }
            if (flowableWindowSubscribeIntercept == null || !flowableWindowSubscribeIntercept.tryAbandon()) {
                return;
            }
            flowableWindowSubscribeIntercept.window.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(t);
            }
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                    this.upstream.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(this.size, n), BackpressureHelper.multiplyCap(this.skip - this.size, n - 1)));
                    return;
                }
                this.upstream.request(BackpressureHelper.multiplyCap(this.skip, n));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final Subscriber<? super Flowable<T>> downstream;
        Throwable error;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        long produced;
        final SpscLinkedArrayQueue<UnicastProcessor<T>> queue;
        final AtomicLong requested;
        final long size;
        final long skip;
        Subscription upstream;
        final ArrayDeque<UnicastProcessor<T>> windows;
        final AtomicInteger wip;

        WindowOverlapSubscriber(Subscriber<? super Flowable<T>> actual, long size, long skip, int bufferSize) {
            super(1);
            this.downstream = actual;
            this.size = size;
            this.skip = skip;
            this.queue = new SpscLinkedArrayQueue<>(bufferSize);
            this.windows = new ArrayDeque<>();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            UnicastProcessor<T> unicastProcessor;
            long j = this.index;
            if (j != 0 || this.cancelled) {
                unicastProcessor = null;
            } else {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.bufferSize, this);
                this.windows.offer(unicastProcessor);
            }
            long j2 = j + 1;
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (unicastProcessor != null) {
                this.queue.offer(unicastProcessor);
                drain();
            }
            long j3 = this.produced + 1;
            if (j3 == this.size) {
                this.produced = j3 - this.skip;
                UnicastProcessor<T> poll = this.windows.poll();
                if (poll != null) {
                    poll.onComplete();
                }
            } else {
                this.produced = j3;
            }
            if (j2 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j2;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onError(t);
            }
            this.windows.clear();
            this.error = t;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.windows.clear();
            this.done = true;
            drain();
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
            if (r10 != 0) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
            if (r15.cancelled == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
            if (checkTerminated(r15.done, r1.isEmpty(), r0, r1) == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0073, code lost:
            if (r8 == 0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007c, code lost:
            if (r4 == Long.MAX_VALUE) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x007e, code lost:
            r15.requested.addAndGet(-r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x000f, code lost:
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x000f, code lost:
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                r15 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r15.wip
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L9
                return
            L9:
                org.reactivestreams.Subscriber<? super io.reactivex.rxjava3.core.Flowable<T>> r0 = r15.downstream
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<io.reactivex.rxjava3.processors.UnicastProcessor<T>> r1 = r15.queue
                r2 = 1
                r3 = 1
            Lf:
                boolean r4 = r15.cancelled
                if (r4 == 0) goto L1f
            L13:
                java.lang.Object r4 = r1.poll()
                io.reactivex.rxjava3.processors.UnicastProcessor r4 = (io.reactivex.rxjava3.processors.UnicastProcessor) r4
                if (r4 == 0) goto L84
                r4.onComplete()
                goto L13
            L1f:
                java.util.concurrent.atomic.AtomicLong r4 = r15.requested
                long r4 = r4.get()
                r6 = 0
                r8 = r6
            L28:
                int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r10 == 0) goto L5d
                boolean r11 = r15.done
                java.lang.Object r12 = r1.poll()
                io.reactivex.rxjava3.processors.UnicastProcessor r12 = (io.reactivex.rxjava3.processors.UnicastProcessor) r12
                if (r12 != 0) goto L38
                r13 = 1
                goto L39
            L38:
                r13 = 0
            L39:
                boolean r14 = r15.cancelled
                if (r14 == 0) goto L3e
                goto Lf
            L3e:
                boolean r11 = r15.checkTerminated(r11, r13, r0, r1)
                if (r11 == 0) goto L45
                return
            L45:
                if (r13 == 0) goto L48
                goto L5d
            L48:
                io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowSubscribeIntercept r10 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowSubscribeIntercept
                r10.<init>(r12)
                r0.onNext(r10)
                boolean r10 = r10.tryAbandon()
                if (r10 == 0) goto L59
                r12.onComplete()
            L59:
                r10 = 1
                long r8 = r8 + r10
                goto L28
            L5d:
                if (r10 != 0) goto L71
                boolean r10 = r15.cancelled
                if (r10 == 0) goto L64
                goto Lf
            L64:
                boolean r10 = r15.done
                boolean r11 = r1.isEmpty()
                boolean r10 = r15.checkTerminated(r10, r11, r0, r1)
                if (r10 == 0) goto L71
                return
            L71:
                int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r10 == 0) goto L84
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r10 == 0) goto L84
                java.util.concurrent.atomic.AtomicLong r4 = r15.requested
                long r5 = -r8
                r4.addAndGet(r5)
            L84:
                java.util.concurrent.atomic.AtomicInteger r4 = r15.wip
                int r3 = -r3
                int r3 = r4.addAndGet(r3)
                if (r3 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow.WindowOverlapSubscriber.drain():void");
        }

        boolean checkTerminated(boolean d, boolean empty, Subscriber<?> a, SpscLinkedArrayQueue<?> q) {
            if (d) {
                Throwable th = this.error;
                if (th != null) {
                    q.clear();
                    a.onError(th);
                    return true;
                } else if (empty) {
                    a.onComplete();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                    this.upstream.request(BackpressureHelper.addCap(this.size, BackpressureHelper.multiplyCap(this.skip, n - 1)));
                } else {
                    this.upstream.request(BackpressureHelper.multiplyCap(this.skip, n));
                }
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true)) {
                run();
            }
            drain();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }
}
