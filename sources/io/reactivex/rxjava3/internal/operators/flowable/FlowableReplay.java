package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    static final Supplier DEFAULT_UNBOUNDED_FACTORY = new DefaultUnboundedFactory();
    final Supplier<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    /* loaded from: classes4.dex */
    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable e);

        void next(T value);

        void replay(InnerSubscription<T> output);
    }

    public static <U, R> Flowable<R> multicastSelector(final Supplier<? extends ConnectableFlowable<U>> connectableFactory, final Function<? super Flowable<U>, ? extends Publisher<R>> selector) {
        return new MulticastFlowable(connectableFactory, selector);
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> source) {
        return create(source, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source, final int bufferSize, boolean eagerTruncate) {
        if (bufferSize == Integer.MAX_VALUE) {
            return createFrom(source);
        }
        return create(source, new ReplayBufferSupplier(bufferSize, eagerTruncate));
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source, long maxAge, TimeUnit unit, Scheduler scheduler, boolean eagerTruncate) {
        return create(source, maxAge, unit, scheduler, Integer.MAX_VALUE, eagerTruncate);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source, final long maxAge, final TimeUnit unit, final Scheduler scheduler, final int bufferSize, boolean eagerTruncate) {
        return create(source, new ScheduledReplayBufferSupplier(bufferSize, maxAge, unit, scheduler, eagerTruncate));
    }

    static <T> ConnectableFlowable<T> create(Flowable<T> source, final Supplier<? extends ReplayBuffer<T>> bufferFactory) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowableReplay(new ReplayPublisher(atomicReference, bufferFactory), source, atomicReference, bufferFactory));
    }

    private FlowableReplay(Publisher<T> onSubscribe, Flowable<T> source, final AtomicReference<ReplaySubscriber<T>> current, final Supplier<? extends ReplayBuffer<T>> bufferFactory) {
        this.onSubscribe = onSubscribe;
        this.source = source;
        this.current = current;
        this.bufferFactory = bufferFactory;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.onSubscribe.subscribe(s);
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void reset() {
        ReplaySubscriber<T> replaySubscriber = this.current.get();
        if (replaySubscriber == null || !replaySubscriber.isDisposed()) {
            return;
        }
        this.current.compareAndSet(replaySubscriber, null);
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> connection) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.current.get();
            if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                break;
            }
            try {
                ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.bufferFactory.get());
                if (this.current.compareAndSet(replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break;
                }
            } finally {
                Exceptions.throwIfFatal(th);
                RuntimeException wrapOrThrow = ExceptionHelper.wrapOrThrow(th);
            }
        }
        boolean z = !replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true);
        try {
            connection.accept(replaySubscriber);
            if (z) {
                this.source.subscribe((FlowableSubscriber) replaySubscriber);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (z) {
                replaySubscriber.shouldConnect.compareAndSet(true, false);
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final ReplayBuffer<T> buffer;
        boolean done;
        long requestedFromUpstream;
        final AtomicInteger management = new AtomicInteger();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        ReplaySubscriber(ReplayBuffer<T> buffer) {
            this.buffer = buffer;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.subscribers.set(TERMINATED);
            SubscriptionHelper.cancel(this);
        }

        boolean add(InnerSubscription<T> producer) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = producer;
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void remove(InnerSubscription<T> p) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (innerSubscriptionArr[i2].equals(p)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = EMPTY;
                } else {
                    InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                    System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                    System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription p) {
            if (SubscriptionHelper.setOnce(this, p)) {
                manageRequests();
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                this.buffer.replay(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable e) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(e);
                for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(innerSubscription);
                }
                return;
            }
            RxJavaPlugins.onError(e);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerSubscription);
            }
        }

        void manageRequests() {
            AtomicInteger atomicInteger = this.management;
            if (atomicInteger.getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            while (!isDisposed()) {
                Subscription subscription = get();
                if (subscription != null) {
                    long j = this.requestedFromUpstream;
                    long j2 = j;
                    for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                        j2 = Math.max(j2, innerSubscription.totalRequested.get());
                    }
                    long j3 = j2 - j;
                    if (j3 != 0) {
                        this.requestedFromUpstream = j2;
                        subscription.request(j3);
                    }
                }
                i = atomicInteger.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        InnerSubscription(ReplaySubscriber<T> parent, Subscriber<? super T> child) {
            this.parent = parent;
            this.child = child;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (!SubscriptionHelper.validate(n) || BackpressureHelper.addCancel(this, n) == Long.MIN_VALUE) {
                return;
            }
            BackpressureHelper.add(this.totalRequested, n);
            this.parent.manageRequests();
            this.parent.buffer.replay(this);
        }

        public long produced(long n) {
            return BackpressureHelper.producedCancel(this, n);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
                this.index = null;
            }
        }

        <U> U index() {
            return (U) this.index;
        }
    }

    /* loaded from: classes4.dex */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        UnboundedReplayBuffer(int capacityHint) {
            super(capacityHint);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void next(T value) {
            add(NotificationLite.next(value));
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void error(Throwable e) {
            add(NotificationLite.error(e));
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void replay(InnerSubscription<T> output) {
            synchronized (output) {
                if (output.emitting) {
                    output.missed = true;
                    return;
                }
                output.emitting = true;
                Subscriber<? super T> subscriber = output.child;
                while (!output.isDisposed()) {
                    int i = this.size;
                    Integer num = (Integer) output.index();
                    int intValue = num != null ? num.intValue() : 0;
                    long j = output.get();
                    long j2 = j;
                    long j3 = 0;
                    while (j2 != 0 && intValue < i) {
                        Object obj = get(intValue);
                        try {
                            if (NotificationLite.accept(obj, subscriber) || output.isDisposed()) {
                                return;
                            }
                            intValue++;
                            j2--;
                            j3++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            output.dispose();
                            if (!NotificationLite.isError(obj) && !NotificationLite.isComplete(obj)) {
                                subscriber.onError(th);
                                return;
                            } else {
                                RxJavaPlugins.onError(th);
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        output.index = Integer.valueOf(intValue);
                        if (j != Long.MAX_VALUE) {
                            output.produced(j3);
                        }
                    }
                    synchronized (output) {
                        if (!output.missed) {
                            output.emitting = false;
                            return;
                        }
                        output.missed = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        Node(Object value, long index) {
            this.value = value;
            this.index = index;
        }
    }

    /* loaded from: classes4.dex */
    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        final boolean eagerTruncate;
        long index;
        int size;
        Node tail;

        Object enterTransform(Object value, boolean terminal) {
            return value;
        }

        Object leaveTransform(Object value) {
            return value;
        }

        abstract void truncate();

        BoundedReplayBuffer(boolean eagerTruncate) {
            this.eagerTruncate = eagerTruncate;
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        final void addLast(Node n) {
            this.tail.set(n);
            this.tail = n;
            this.size++;
        }

        final void removeFirst() {
            Node node = get().get();
            if (node == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            setFirst(node);
        }

        final void removeSome(int n) {
            Node node = get();
            while (n > 0) {
                node = node.get();
                n--;
                this.size--;
            }
            setFirst(node);
            Node node2 = get();
            if (node2.get() == null) {
                this.tail = node2;
            }
        }

        final void setFirst(Node n) {
            if (this.eagerTruncate) {
                Node node = new Node(null, n.index);
                node.lazySet(n.get());
                n = node;
            }
            set(n);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T value) {
            Object enterTransform = enterTransform(NotificationLite.next(value), false);
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(Throwable e) {
            Object enterTransform = enterTransform(NotificationLite.error(e), true);
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.complete(), true);
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        final void trimHead() {
            Node node = get();
            if (node.value != null) {
                Node node2 = new Node(null, 0L);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x0082, code lost:
            if (r11 != 0) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
            if (r14.isDisposed() == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x008a, code lost:
            r14.index = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x008c, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
            if (r8 == 0) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0091, code lost:
            r14.index = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0093, code lost:
            if (r4 != false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
            r14.produced(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0098, code lost:
            monitor-enter(r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x009b, code lost:
            if (r14.missed != false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x009d, code lost:
            r14.emitting = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x009f, code lost:
            monitor-exit(r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a0, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
            r14.missed = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00a3, code lost:
            monitor-exit(r14);
         */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r14) {
            /*
                r13 = this;
                monitor-enter(r14)
                boolean r0 = r14.emitting     // Catch: java.lang.Throwable -> La9
                r1 = 1
                if (r0 == 0) goto La
                r14.missed = r1     // Catch: java.lang.Throwable -> La9
                monitor-exit(r14)     // Catch: java.lang.Throwable -> La9
                return
            La:
                r14.emitting = r1     // Catch: java.lang.Throwable -> La9
                monitor-exit(r14)     // Catch: java.lang.Throwable -> La9
            Ld:
                long r2 = r14.get()
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r0 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L1d
                r4 = 1
                goto L1e
            L1d:
                r4 = 0
            L1e:
                java.lang.Object r5 = r14.index()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r5
                r6 = 0
                if (r5 != 0) goto L35
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r5 = r13.getHead()
                r14.index = r5
                java.util.concurrent.atomic.AtomicLong r8 = r14.totalRequested
                long r9 = r5.index
                io.reactivex.rxjava3.internal.util.BackpressureHelper.add(r8, r9)
            L35:
                r8 = r6
            L36:
                r10 = 0
                int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r11 == 0) goto L82
                boolean r12 = r14.isDisposed()
                if (r12 == 0) goto L44
                r14.index = r10
                return
            L44:
                java.lang.Object r12 = r5.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r12 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r12
                if (r12 == 0) goto L82
                java.lang.Object r5 = r12.value
                java.lang.Object r5 = r13.leaveTransform(r5)
                org.reactivestreams.Subscriber<? super T> r11 = r14.child     // Catch: java.lang.Throwable -> L63
                boolean r11 = io.reactivex.rxjava3.internal.util.NotificationLite.accept(r5, r11)     // Catch: java.lang.Throwable -> L63
                if (r11 == 0) goto L5d
                r14.index = r10     // Catch: java.lang.Throwable -> L63
                return
            L5d:
                r10 = 1
                long r8 = r8 + r10
                long r2 = r2 - r10
                r5 = r12
                goto L36
            L63:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r14.index = r10
                r14.dispose()
                boolean r1 = io.reactivex.rxjava3.internal.util.NotificationLite.isError(r5)
                if (r1 != 0) goto L7e
                boolean r1 = io.reactivex.rxjava3.internal.util.NotificationLite.isComplete(r5)
                if (r1 != 0) goto L7e
                org.reactivestreams.Subscriber<? super T> r14 = r14.child
                r14.onError(r0)
                goto L81
            L7e:
                io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r0)
            L81:
                return
            L82:
                if (r11 != 0) goto L8d
                boolean r2 = r14.isDisposed()
                if (r2 == 0) goto L8d
                r14.index = r10
                return
            L8d:
                int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r2 == 0) goto L98
                r14.index = r5
                if (r4 != 0) goto L98
                r14.produced(r8)
            L98:
                monitor-enter(r14)
                boolean r2 = r14.missed     // Catch: java.lang.Throwable -> La6
                if (r2 != 0) goto La1
                r14.emitting = r0     // Catch: java.lang.Throwable -> La6
                monitor-exit(r14)     // Catch: java.lang.Throwable -> La6
                return
            La1:
                r14.missed = r0     // Catch: java.lang.Throwable -> La6
                monitor-exit(r14)     // Catch: java.lang.Throwable -> La6
                goto Ld
            La6:
                r0 = move-exception
                monitor-exit(r14)     // Catch: java.lang.Throwable -> La6
                throw r0
            La9:
                r0 = move-exception
                monitor-exit(r14)     // Catch: java.lang.Throwable -> La9
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer.replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }

        void truncateFinal() {
            trimHead();
        }

        final void collect(Collection<? super T> output) {
            Node head = getHead();
            while (true) {
                head = head.get();
                if (head == null) {
                    return;
                }
                Object leaveTransform = leaveTransform(head.value);
                if (NotificationLite.isComplete(leaveTransform) || NotificationLite.isError(leaveTransform)) {
                    return;
                }
                output.add((Object) NotificationLite.getValue(leaveTransform));
            }
        }

        boolean hasError() {
            return this.tail.value != null && NotificationLite.isError(leaveTransform(this.tail.value));
        }

        boolean hasCompleted() {
            return this.tail.value != null && NotificationLite.isComplete(leaveTransform(this.tail.value));
        }

        Node getHead() {
            return get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int limit, boolean eagerTruncate) {
            super(eagerTruncate);
            this.limit = limit;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final Scheduler scheduler;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int limit, long maxAge, TimeUnit unit, Scheduler scheduler, boolean eagerTruncate) {
            super(eagerTruncate);
            this.scheduler = scheduler;
            this.limit = limit;
            this.maxAge = maxAge;
            this.unit = unit;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object enterTransform(Object value, boolean terminal) {
            return new Timed(value, terminal ? Long.MAX_VALUE : this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object leaveTransform(Object value) {
            return ((Timed) value).value();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node2 = (Node) get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (this.size > 1) {
                    if (this.size > this.limit) {
                        i++;
                        this.size--;
                        node3 = node2.get();
                    } else if (((Timed) node2.value).time() > now) {
                        break;
                    } else {
                        i++;
                        this.size--;
                        node3 = node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncateFinal() {
            Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node2 = (Node) get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (this.size <= 1 || ((Timed) node2.value).time() > now) {
                    break;
                }
                i++;
                this.size--;
                node3 = node2.get();
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Node getHead() {
            Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node2 = (Node) get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    Timed timed = (Timed) node2.value;
                    if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value()) || timed.time() > now) {
                        break;
                    }
                    node3 = node2.get();
                } else {
                    break;
                }
            }
            return node;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class MulticastFlowable<R, U> extends Flowable<R> {
        private final Supplier<? extends ConnectableFlowable<U>> connectableFactory;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> selector;

        MulticastFlowable(Supplier<? extends ConnectableFlowable<U>> connectableFactory, Function<? super Flowable<U>, ? extends Publisher<R>> selector) {
            this.connectableFactory = connectableFactory;
            this.selector = selector;
        }

        @Override // io.reactivex.rxjava3.core.Flowable
        protected void subscribeActual(Subscriber<? super R> child) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ExceptionHelper.nullCheck(this.connectableFactory.get(), "The connectableFactory returned a null ConnectableFlowable.");
                try {
                    Publisher publisher = (Publisher) ExceptionHelper.nullCheck(this.selector.apply(connectableFlowable), "The selector returned a null Publisher.");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(child);
                    publisher.subscribe(subscriberResourceWrapper);
                    connectableFlowable.connect(new DisposableConsumer(subscriberResourceWrapper));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, child);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, child);
            }
        }

        /* loaded from: classes4.dex */
        final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> srw;

            DisposableConsumer(SubscriberResourceWrapper<R> srw) {
                this.srw = srw;
            }

            @Override // io.reactivex.rxjava3.functions.Consumer
            public void accept(Disposable r) {
                this.srw.setResource(r);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class ReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {
        final int bufferSize;
        final boolean eagerTruncate;

        ReplayBufferSupplier(int bufferSize, boolean eagerTruncate) {
            this.bufferSize = bufferSize;
            this.eagerTruncate = eagerTruncate;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public ReplayBuffer<T> get() {
            return new SizeBoundReplayBuffer(this.bufferSize, this.eagerTruncate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class ScheduledReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {
        private final int bufferSize;
        final boolean eagerTruncate;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        ScheduledReplayBufferSupplier(int bufferSize, long maxAge, TimeUnit unit, Scheduler scheduler, boolean eagerTruncate) {
            this.bufferSize = bufferSize;
            this.maxAge = maxAge;
            this.unit = unit;
            this.scheduler = scheduler;
            this.eagerTruncate = eagerTruncate;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public ReplayBuffer<T> get() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler, this.eagerTruncate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class ReplayPublisher<T> implements Publisher<T> {
        private final Supplier<? extends ReplayBuffer<T>> bufferFactory;
        private final AtomicReference<ReplaySubscriber<T>> curr;

        ReplayPublisher(AtomicReference<ReplaySubscriber<T>> curr, Supplier<? extends ReplayBuffer<T>> bufferFactory) {
            this.curr = curr;
            this.bufferFactory = bufferFactory;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> child) {
            ReplaySubscriber<T> replaySubscriber;
            while (true) {
                replaySubscriber = this.curr.get();
                if (replaySubscriber != null) {
                    break;
                }
                try {
                    ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.bufferFactory.get());
                    if (this.curr.compareAndSet(null, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, child);
                    return;
                }
            }
            InnerSubscription<T> innerSubscription = new InnerSubscription<>(replaySubscriber, child);
            child.onSubscribe(innerSubscription);
            replaySubscriber.add(innerSubscription);
            if (innerSubscription.isDisposed()) {
                replaySubscriber.remove(innerSubscription);
                return;
            }
            replaySubscriber.manageRequests();
            replaySubscriber.buffer.replay(innerSubscription);
        }
    }

    /* loaded from: classes4.dex */
    static final class DefaultUnboundedFactory implements Supplier<Object> {
        DefaultUnboundedFactory() {
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() {
            return new UnboundedReplayBuffer(16);
        }
    }
}
