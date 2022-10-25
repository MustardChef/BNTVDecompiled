package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicReference<Subscriber<? super T>> downstream = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();
    final BasicIntQueueSubscription<T> wip = new UnicastQueueSubscription();
    final AtomicLong requested = new AtomicLong();

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(bufferSize(), null, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int capacityHint) {
        ObjectHelper.verifyPositive(capacityHint, "capacityHint");
        return new UnicastProcessor<>(capacityHint, null, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(boolean delayError) {
        return new UnicastProcessor<>(bufferSize(), null, delayError);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int capacityHint, Runnable onTerminate) {
        return create(capacityHint, onTerminate, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int capacityHint, Runnable onTerminate, boolean delayError) {
        Objects.requireNonNull(onTerminate, "onTerminate");
        ObjectHelper.verifyPositive(capacityHint, "capacityHint");
        return new UnicastProcessor<>(capacityHint, onTerminate, delayError);
    }

    UnicastProcessor(int capacityHint, Runnable onTerminate, boolean delayError) {
        this.queue = new SpscLinkedArrayQueue<>(capacityHint);
        this.onTerminate = new AtomicReference<>(onTerminate);
        this.delayError = delayError;
    }

    void doTerminate() {
        Runnable andSet = this.onTerminate.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    void drainRegular(Subscriber<? super T> a) {
        int i;
        long j;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean z = !this.delayError;
        int i2 = 1;
        while (true) {
            long j2 = this.requested.get();
            long j3 = 0;
            while (true) {
                i = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i == 0) {
                    j = j3;
                    break;
                }
                boolean z2 = this.done;
                T poll = spscLinkedArrayQueue.poll();
                boolean z3 = poll == null;
                j = j3;
                if (checkTerminated(z, z2, z3, a, spscLinkedArrayQueue)) {
                    return;
                }
                if (z3) {
                    break;
                }
                a.onNext(poll);
                j3 = 1 + j;
            }
            if (i == 0 && checkTerminated(z, this.done, spscLinkedArrayQueue.isEmpty(), a, spscLinkedArrayQueue)) {
                return;
            }
            if (j != 0 && j2 != Long.MAX_VALUE) {
                this.requested.addAndGet(-j);
            }
            i2 = this.wip.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
    }

    void drainFused(Subscriber<? super T> a) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int i = 1;
        boolean z = !this.delayError;
        while (!this.cancelled) {
            boolean z2 = this.done;
            if (z && z2 && this.error != null) {
                spscLinkedArrayQueue.clear();
                this.downstream.lazySet(null);
                a.onError(this.error);
                return;
            }
            a.onNext(null);
            if (z2) {
                this.downstream.lazySet(null);
                Throwable th = this.error;
                if (th != null) {
                    a.onError(th);
                    return;
                } else {
                    a.onComplete();
                    return;
                }
            }
            i = this.wip.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        this.downstream.lazySet(null);
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        Subscriber<? super T> subscriber = this.downstream.get();
        while (subscriber == null) {
            i = this.wip.addAndGet(-i);
            if (i == 0) {
                return;
            }
            subscriber = this.downstream.get();
        }
        if (this.enableOperatorFusion) {
            drainFused(subscriber);
        } else {
            drainRegular(subscriber);
        }
    }

    boolean checkTerminated(boolean failFast, boolean d, boolean empty, Subscriber<? super T> a, SpscLinkedArrayQueue<T> q) {
        if (this.cancelled) {
            q.clear();
            this.downstream.lazySet(null);
            return true;
        } else if (d) {
            if (failFast && this.error != null) {
                q.clear();
                this.downstream.lazySet(null);
                a.onError(this.error);
                return true;
            } else if (empty) {
                Throwable th = this.error;
                this.downstream.lazySet(null);
                if (th != null) {
                    a.onError(th);
                } else {
                    a.onComplete();
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        if (this.done || this.cancelled) {
            s.cancel();
        } else {
            s.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.done || this.cancelled) {
            return;
        }
        this.queue.offer(t);
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable t) {
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (this.done || this.cancelled) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.error = t;
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done || this.cancelled) {
            return;
        }
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            s.onSubscribe(this.wip);
            this.downstream.set(s);
            if (this.cancelled) {
                this.downstream.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), s);
    }

    /* loaded from: classes4.dex */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            return UnicastProcessor.this.queue.poll();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.queue.isEmpty();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastProcessor.this.queue.clear();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int requestedMode) {
            if ((requestedMode & 2) != 0) {
                UnicastProcessor.this.enableOperatorFusion = true;
                return 2;
            }
            return 0;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(UnicastProcessor.this.requested, n);
                UnicastProcessor.this.drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (UnicastProcessor.this.cancelled) {
                return;
            }
            UnicastProcessor.this.cancelled = true;
            UnicastProcessor.this.doTerminate();
            UnicastProcessor.this.downstream.lazySet(null);
            if (UnicastProcessor.this.wip.getAndIncrement() == 0) {
                UnicastProcessor.this.downstream.lazySet(null);
                if (UnicastProcessor.this.enableOperatorFusion) {
                    return;
                }
                UnicastProcessor.this.queue.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.downstream.get() != null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }
}
