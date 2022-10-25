package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapCompletable;
import org.reactivestreams.Publisher;

/* loaded from: classes4.dex */
public final class FlowableSwitchMapCompletablePublisher<T> extends Completable {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final Publisher<T> source;

    public FlowableSwitchMapCompletablePublisher(Publisher<T> source, Function<? super T, ? extends CompletableSource> mapper, boolean delayErrors) {
        this.source = source;
        this.mapper = mapper;
        this.delayErrors = delayErrors;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        this.source.subscribe(new FlowableSwitchMapCompletable.SwitchMapCompletableObserver(observer, this.mapper, this.delayErrors));
    }
}
