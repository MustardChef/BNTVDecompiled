package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import io.reactivex.rxjava3.internal.subscriptions.ScalarSubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public final class FlowableJust<T> extends Flowable<T> implements ScalarSupplier<T> {
    private final T value;

    public FlowableJust(final T value) {
        this.value = value;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        s.onSubscribe(new ScalarSubscription(s, this.value));
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.ScalarSupplier, io.reactivex.rxjava3.functions.Supplier
    public T get() {
        return this.value;
    }
}
