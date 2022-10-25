package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromCompletable;

/* loaded from: classes4.dex */
public final class CompletableToObservable<T> extends Observable<T> {
    final CompletableSource source;

    public CompletableToObservable(CompletableSource source) {
        this.source = source;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ObservableFromCompletable.FromCompletableObserver(observer));
    }
}
