package io.reactivex.rxjava3.internal.subscriptions;

import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    static final int CANCELLED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    protected final Subscriber<? super T> downstream;
    protected T value;

    public DeferredScalarSubscription(Subscriber<? super T> downstream) {
        this.downstream = downstream;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long n) {
        T t;
        if (SubscriptionHelper.validate(n)) {
            do {
                int i = get();
                if ((i & (-2)) != 0) {
                    return;
                }
                if (i == 1) {
                    if (!compareAndSet(1, 3) || (t = this.value) == null) {
                        return;
                    }
                    this.value = null;
                    Subscriber<? super T> subscriber = this.downstream;
                    subscriber.onNext(t);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public final void complete(T v) {
        int i = get();
        while (i != 8) {
            if ((i & (-3)) != 0) {
                return;
            }
            if (i == 2) {
                lazySet(3);
                Subscriber<? super T> subscriber = this.downstream;
                subscriber.onNext(v);
                if (get() != 4) {
                    subscriber.onComplete();
                    return;
                }
                return;
            }
            this.value = v;
            if (compareAndSet(0, 1)) {
                return;
            }
            i = get();
            if (i == 4) {
                this.value = null;
                return;
            }
        }
        this.value = v;
        lazySet(16);
        Subscriber<? super T> subscriber2 = this.downstream;
        subscriber2.onNext(v);
        if (get() != 4) {
            subscriber2.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
    public final int requestFusion(int mode) {
        if ((mode & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public final T poll() {
        if (get() == 16) {
            lazySet(32);
            T t = this.value;
            this.value = null;
            return t;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    public final boolean isCancelled() {
        return get() == 4;
    }

    public final boolean tryCancel() {
        return getAndSet(4) != 4;
    }
}
