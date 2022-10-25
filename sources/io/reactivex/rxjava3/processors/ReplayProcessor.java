package io.reactivex.rxjava3.processors;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplaySubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    private static final Object[] EMPTY_ARRAY = new Object[0];
    static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
    static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable ex);

        Throwable getError();

        T getValue();

        T[] getValues(T[] array);

        boolean isDone();

        void next(T value);

        void replay(ReplaySubscription<T> rs);

        int size();

        void trimHead();
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create(int capacityHint) {
        ObjectHelper.verifyPositive(capacityHint, "capacityHint");
        return new ReplayProcessor<>(new UnboundedReplayBuffer(capacityHint));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithSize(int maxSize) {
        ObjectHelper.verifyPositive(maxSize, SDKConstants.PARAM_CONTEXT_MAX_SIZE);
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(maxSize));
    }

    @CheckReturnValue
    static <T> ReplayProcessor<T> createUnbounded() {
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTime(long maxAge, TimeUnit unit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(maxAge, "maxAge");
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, maxAge, unit, scheduler));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long maxAge, TimeUnit unit, Scheduler scheduler, int maxSize) {
        ObjectHelper.verifyPositive(maxSize, SDKConstants.PARAM_CONTEXT_MAX_SIZE);
        ObjectHelper.verifyPositive(maxAge, "maxAge");
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(maxSize, maxAge, unit, scheduler));
    }

    ReplayProcessor(ReplayBuffer<T> buffer) {
        this.buffer = buffer;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(s, this);
        s.onSubscribe(replaySubscription);
        if (add(replaySubscription) && replaySubscription.cancelled) {
            remove(replaySubscription);
        } else {
            this.buffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        if (this.done) {
            s.cancel();
        } else {
            s.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.done) {
            return;
        }
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.next(t);
        for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable t) {
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (this.done) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.done = true;
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.error(t);
        for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.complete();
        for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    @CheckReturnValue
    int subscriberCount() {
        return this.subscribers.get().length;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        if (replayBuffer.isDone()) {
            return replayBuffer.getError();
        }
        return null;
    }

    public void cleanupBuffer() {
        this.buffer.trimHead();
    }

    @CheckReturnValue
    public T getValue() {
        return this.buffer.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @CheckReturnValue
    public T[] getValues(T[] array) {
        return this.buffer.getValues(array);
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        return replayBuffer.isDone() && replayBuffer.getError() == null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        return replayBuffer.isDone() && replayBuffer.getError() != null;
    }

    @CheckReturnValue
    public boolean hasValue() {
        return this.buffer.size() != 0;
    }

    @CheckReturnValue
    int size() {
        return this.buffer.size();
    }

    boolean add(ReplaySubscription<T> rs) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription<T>[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.subscribers.get();
            if (replaySubscriptionArr == TERMINATED) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[length + 1];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = rs;
        } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void remove(ReplaySubscription<T> rs) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.subscribers.get();
            if (replaySubscriptionArr == TERMINATED || replaySubscriptionArr == EMPTY) {
                return;
            }
            int length = replaySubscriptionArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (replaySubscriptionArr[i2] == rs) {
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
                replaySubscriptionArr2 = EMPTY;
            } else {
                ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i);
                System.arraycopy(replaySubscriptionArr, i + 1, replaySubscriptionArr3, i, (length - i) - 1);
                replaySubscriptionArr2 = replaySubscriptionArr3;
            }
        } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        long emitted;
        Object index;
        final AtomicLong requested = new AtomicLong();
        final ReplayProcessor<T> state;

        ReplaySubscription(Subscriber<? super T> actual, ReplayProcessor<T> state) {
            this.downstream = actual;
            this.state = state;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                this.state.buffer.replay(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.remove(this);
        }
    }

    /* loaded from: classes4.dex */
    static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {
        final List<T> buffer;
        volatile boolean done;
        Throwable error;
        volatile int size;

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
        }

        UnboundedReplayBuffer(int capacityHint) {
            this.buffer = new ArrayList(capacityHint);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void next(T value) {
            this.buffer.add(value);
            this.size++;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable ex) {
            this.error = ex;
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            int i = this.size;
            if (i == 0) {
                return null;
            }
            return this.buffer.get(i - 1);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] array) {
            int i = this.size;
            if (i == 0) {
                if (array.length != 0) {
                    array[0] = null;
                }
                return array;
            }
            List<T> list = this.buffer;
            if (array.length < i) {
                array = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                array[i2] = list.get(i2);
            }
            if (array.length > i) {
                array[i] = null;
            }
            return array;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
            if (r10 != 0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
            if (r14.cancelled == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
            r14.index = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
            r7 = r13.done;
            r8 = r13.size;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
            if (r7 == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:
            if (r3 != r8) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
            r14.index = null;
            r14.cancelled = true;
            r14 = r13.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
            if (r14 != null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
            r1.onError(r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x007c, code lost:
            r14.index = java.lang.Integer.valueOf(r3);
            r14.emitted = r4;
            r6 = r14.addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
            return;
         */
        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void replay(io.reactivex.rxjava3.processors.ReplayProcessor.ReplaySubscription<T> r14) {
            /*
                r13 = this;
                int r0 = r14.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                java.util.List<T> r0 = r13.buffer
                org.reactivestreams.Subscriber<? super T> r1 = r14.downstream
                java.lang.Object r2 = r14.index
                java.lang.Integer r2 = (java.lang.Integer) r2
                r3 = 0
                if (r2 == 0) goto L17
                int r3 = r2.intValue()
                goto L1d
            L17:
                java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
                r14.index = r2
            L1d:
                long r4 = r14.emitted
                r2 = 1
                r6 = 1
            L21:
                java.util.concurrent.atomic.AtomicLong r7 = r14.requested
                long r7 = r7.get()
            L27:
                r9 = 0
                int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
                if (r10 == 0) goto L5b
                boolean r11 = r14.cancelled
                if (r11 == 0) goto L33
                r14.index = r9
                return
            L33:
                boolean r11 = r13.done
                int r12 = r13.size
                if (r11 == 0) goto L4b
                if (r3 != r12) goto L4b
                r14.index = r9
                r14.cancelled = r2
                java.lang.Throwable r14 = r13.error
                if (r14 != 0) goto L47
                r1.onComplete()
                goto L4a
            L47:
                r1.onError(r14)
            L4a:
                return
            L4b:
                if (r3 != r12) goto L4e
                goto L5b
            L4e:
                java.lang.Object r9 = r0.get(r3)
                r1.onNext(r9)
                int r3 = r3 + 1
                r9 = 1
                long r4 = r4 + r9
                goto L27
            L5b:
                if (r10 != 0) goto L7c
                boolean r7 = r14.cancelled
                if (r7 == 0) goto L64
                r14.index = r9
                return
            L64:
                boolean r7 = r13.done
                int r8 = r13.size
                if (r7 == 0) goto L7c
                if (r3 != r8) goto L7c
                r14.index = r9
                r14.cancelled = r2
                java.lang.Throwable r14 = r13.error
                if (r14 != 0) goto L78
                r1.onComplete()
                goto L7b
            L78:
                r1.onError(r14)
            L7b:
                return
            L7c:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
                r14.index = r7
                r14.emitted = r4
                int r6 = -r6
                int r6 = r14.addAndGet(r6)
                if (r6 != 0) goto L21
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.ReplayProcessor.UnboundedReplayBuffer.replay(io.reactivex.rxjava3.processors.ReplayProcessor$ReplaySubscription):void");
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return this.size;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T value) {
            this.value = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T value, long time) {
            this.value = value;
            this.time = time;
        }
    }

    /* loaded from: classes4.dex */
    static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile Node<T> head;
        final int maxSize;
        int size;
        Node<T> tail;

        SizeBoundReplayBuffer(int maxSize) {
            this.maxSize = maxSize;
            Node<T> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void next(T value) {
            Node<T> node = new Node<>(value);
            Node<T> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable ex) {
            this.error = ex;
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.head.value != null) {
                Node<T> node = new Node<>(null);
                node.lazySet(this.head.get());
                this.head = node;
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            Node<T> node = this.head;
            while (true) {
                Node<T> node2 = node.get();
                if (node2 == null) {
                    return node.value;
                }
                node = node2;
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] array) {
            Node<T> node = this.head;
            Node<T> node2 = node;
            int i = 0;
            while (true) {
                node2 = node2.get();
                if (node2 == null) {
                    break;
                }
                i++;
            }
            if (array.length < i) {
                array = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                node = node.get();
                array[i2] = node.value;
            }
            if (array.length > i) {
                array[i] = null;
            }
            return array;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> rs) {
            int i;
            if (rs.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = rs.downstream;
            Node<T> node = (Node) rs.index;
            if (node == null) {
                node = this.head;
            }
            long j = rs.emitted;
            int i2 = 1;
            do {
                long j2 = rs.requested.get();
                while (true) {
                    i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (rs.cancelled) {
                        rs.index = null;
                        return;
                    } else {
                        boolean z = this.done;
                        Node<T> node2 = node.get();
                        boolean z2 = node2 == null;
                        if (z && z2) {
                            rs.index = null;
                            rs.cancelled = true;
                            Throwable th = this.error;
                            if (th == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th);
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            subscriber.onNext((T) node2.value);
                            j++;
                            node = node2;
                        }
                    }
                }
                if (i == 0) {
                    if (rs.cancelled) {
                        rs.index = null;
                        return;
                    } else if (this.done && node.get() == null) {
                        rs.index = null;
                        rs.cancelled = true;
                        Throwable th2 = this.error;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                rs.index = node;
                rs.emitted = j;
                i2 = rs.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            Node<T> node = this.head;
            int i = 0;
            while (i != Integer.MAX_VALUE && (node = node.get()) != null) {
                i++;
            }
            return i;
        }
    }

    /* loaded from: classes4.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile TimedNode<T> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int maxSize, long maxAge, TimeUnit unit, Scheduler scheduler) {
            this.maxSize = maxSize;
            this.maxAge = maxAge;
            this.unit = unit;
            this.scheduler = scheduler;
            TimedNode<T> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> timedNode = this.head;
            while (this.size > 1) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2.time > now) {
                    this.head = timedNode;
                    return;
                } else {
                    this.size--;
                    timedNode = timedNode2;
                }
            }
            this.head = timedNode;
        }

        void trimFinal() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    if (timedNode.value != null) {
                        this.head = new TimedNode<>(null, 0L);
                        return;
                    } else {
                        this.head = timedNode;
                        return;
                    }
                } else if (timedNode2.time > now) {
                    if (timedNode.value != null) {
                        TimedNode<T> timedNode3 = new TimedNode<>(null, 0L);
                        timedNode3.lazySet(timedNode.get());
                        this.head = timedNode3;
                        return;
                    }
                    this.head = timedNode;
                    return;
                } else {
                    timedNode = timedNode2;
                }
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.head.value != null) {
                TimedNode<T> timedNode = new TimedNode<>(null, 0L);
                timedNode.lazySet(this.head.get());
                this.head = timedNode;
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void next(T value) {
            TimedNode<T> timedNode = new TimedNode<>(value, this.scheduler.now(this.unit));
            TimedNode<T> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable ex) {
            trimFinal();
            this.error = ex;
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            trimFinal();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    break;
                }
                timedNode = timedNode2;
            }
            if (timedNode.time < this.scheduler.now(this.unit) - this.maxAge) {
                return null;
            }
            return timedNode.value;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] array) {
            TimedNode<T> head = getHead();
            int size = size(head);
            if (size == 0) {
                if (array.length != 0) {
                    array[0] = null;
                }
            } else {
                if (array.length < size) {
                    array = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), size));
                }
                for (int i = 0; i != size; i++) {
                    head = head.get();
                    array[i] = head.value;
                }
                if (array.length > size) {
                    array[size] = null;
                }
            }
            return array;
        }

        TimedNode<T> getHead() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.head;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> timedNode3 = timedNode2.get();
            while (true) {
                TimedNode<T> timedNode4 = timedNode3;
                timedNode = timedNode2;
                timedNode2 = timedNode4;
                if (timedNode2 == null || timedNode2.time > now) {
                    break;
                }
                timedNode3 = timedNode2.get();
            }
            return timedNode;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> rs) {
            int i;
            if (rs.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = rs.downstream;
            TimedNode<T> timedNode = (TimedNode) rs.index;
            if (timedNode == null) {
                timedNode = getHead();
            }
            long j = rs.emitted;
            int i2 = 1;
            do {
                long j2 = rs.requested.get();
                while (true) {
                    i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (rs.cancelled) {
                        rs.index = null;
                        return;
                    } else {
                        boolean z = this.done;
                        TimedNode<T> timedNode2 = timedNode.get();
                        boolean z2 = timedNode2 == null;
                        if (z && z2) {
                            rs.index = null;
                            rs.cancelled = true;
                            Throwable th = this.error;
                            if (th == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th);
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            subscriber.onNext((T) timedNode2.value);
                            j++;
                            timedNode = timedNode2;
                        }
                    }
                }
                if (i == 0) {
                    if (rs.cancelled) {
                        rs.index = null;
                        return;
                    } else if (this.done && timedNode.get() == null) {
                        rs.index = null;
                        rs.cancelled = true;
                        Throwable th2 = this.error;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                rs.index = timedNode;
                rs.emitted = j;
                i2 = rs.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return size(getHead());
        }

        int size(TimedNode<T> h) {
            int i = 0;
            while (i != Integer.MAX_VALUE && (h = h.get()) != null) {
                i++;
            }
            return i;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }
    }
}
