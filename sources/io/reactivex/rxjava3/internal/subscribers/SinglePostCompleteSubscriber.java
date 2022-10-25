package io.reactivex.rxjava3.internal.subscribers;

import com.google.android.exoplayer2.C3282C;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final Subscriber<? super R> downstream;
    protected long produced;
    protected Subscription upstream;
    protected R value;

    protected void onDrop(R n) {
    }

    public SinglePostCompleteSubscriber(Subscriber<? super R> downstream) {
        this.downstream = downstream;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        if (SubscriptionHelper.validate(this.upstream, s)) {
            this.upstream = s;
            this.downstream.onSubscribe(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void complete(R n) {
        long j = this.produced;
        if (j != 0) {
            BackpressureHelper.produced(this, j);
        }
        while (true) {
            long j2 = get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                onDrop(n);
                return;
            } else if ((j2 & Long.MAX_VALUE) != 0) {
                lazySet(C3282C.TIME_UNSET);
                this.downstream.onNext(n);
                this.downstream.onComplete();
                return;
            } else {
                this.value = n;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                }
                this.value = null;
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long n) {
        long j;
        if (SubscriptionHelper.validate(n)) {
            do {
                j = get();
                if ((j & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, C3282C.TIME_UNSET)) {
                        this.downstream.onNext((R) this.value);
                        this.downstream.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j, BackpressureHelper.addCap(j, n)));
            this.upstream.request(n);
        }
    }

    public void cancel() {
        this.upstream.cancel();
    }
}
