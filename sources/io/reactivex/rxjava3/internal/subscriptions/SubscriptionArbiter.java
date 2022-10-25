package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    Subscription actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    long requested;
    protected boolean unbounded;
    final AtomicReference<Subscription> missedSubscription = new AtomicReference<>();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicLong missedProduced = new AtomicLong();

    public SubscriptionArbiter(boolean cancelOnReplace) {
        this.cancelOnReplace = cancelOnReplace;
    }

    public final void setSubscription(Subscription s) {
        if (this.cancelled) {
            s.cancel();
            return;
        }
        Objects.requireNonNull(s, "s is null");
        if (get() == 0 && compareAndSet(0, 1)) {
            Subscription subscription = this.actual;
            if (subscription != null && this.cancelOnReplace) {
                subscription.cancel();
            }
            this.actual = s;
            long j = this.requested;
            if (decrementAndGet() != 0) {
                drainLoop();
            }
            if (j != 0) {
                s.request(j);
                return;
            }
            return;
        }
        Subscription andSet = this.missedSubscription.getAndSet(s);
        if (andSet != null && this.cancelOnReplace) {
            andSet.cancel();
        }
        drain();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long n) {
        if (!SubscriptionHelper.validate(n) || this.unbounded) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j = this.requested;
            if (j != Long.MAX_VALUE) {
                long addCap = BackpressureHelper.addCap(j, n);
                this.requested = addCap;
                if (addCap == Long.MAX_VALUE) {
                    this.unbounded = true;
                }
            }
            Subscription subscription = this.actual;
            if (decrementAndGet() != 0) {
                drainLoop();
            }
            if (subscription != null) {
                subscription.request(n);
                return;
            }
            return;
        }
        BackpressureHelper.add(this.missedRequested, n);
        drain();
    }

    public final void produced(long n) {
        if (this.unbounded) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j = this.requested;
            if (j != Long.MAX_VALUE) {
                long j2 = j - n;
                if (j2 < 0) {
                    SubscriptionHelper.reportMoreProduced(j2);
                    j2 = 0;
                }
                this.requested = j2;
            }
            if (decrementAndGet() == 0) {
                return;
            }
            drainLoop();
            return;
        }
        BackpressureHelper.add(this.missedProduced, n);
        drain();
    }

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        drain();
    }

    final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    final void drainLoop() {
        int i = 1;
        Subscription subscription = null;
        long j = 0;
        do {
            Subscription subscription2 = this.missedSubscription.get();
            if (subscription2 != null) {
                subscription2 = this.missedSubscription.getAndSet(null);
            }
            long j2 = this.missedRequested.get();
            if (j2 != 0) {
                j2 = this.missedRequested.getAndSet(0L);
            }
            long j3 = this.missedProduced.get();
            if (j3 != 0) {
                j3 = this.missedProduced.getAndSet(0L);
            }
            Subscription subscription3 = this.actual;
            if (this.cancelled) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.actual = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j4 = this.requested;
                if (j4 != Long.MAX_VALUE) {
                    j4 = BackpressureHelper.addCap(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        j4 -= j3;
                        if (j4 < 0) {
                            SubscriptionHelper.reportMoreProduced(j4);
                            j4 = 0;
                        }
                    }
                    this.requested = j4;
                }
                if (subscription2 != null) {
                    if (subscription3 != null && this.cancelOnReplace) {
                        subscription3.cancel();
                    }
                    this.actual = subscription2;
                    if (j4 != 0) {
                        j = BackpressureHelper.addCap(j, j4);
                        subscription = subscription2;
                    }
                } else if (subscription3 != null && j2 != 0) {
                    j = BackpressureHelper.addCap(j, j2);
                    subscription = subscription3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            subscription.request(j);
        }
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }
}
