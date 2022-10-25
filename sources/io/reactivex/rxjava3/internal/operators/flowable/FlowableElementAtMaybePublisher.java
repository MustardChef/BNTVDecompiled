package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableElementAtMaybe;
import org.reactivestreams.Publisher;

/* loaded from: classes4.dex */
public final class FlowableElementAtMaybePublisher<T> extends Maybe<T> {
    final long index;
    final Publisher<T> source;

    public FlowableElementAtMaybePublisher(Publisher<T> source, long index) {
        this.source = source;
        this.index = index;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        this.source.subscribe(new FlowableElementAtMaybe.ElementAtSubscriber(observer, this.index));
    }
}
