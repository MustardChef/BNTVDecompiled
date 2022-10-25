package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class ObservableDefer<T> extends Observable<T> {
    final Supplier<? extends ObservableSource<? extends T>> supplier;

    public ObservableDefer(Supplier<? extends ObservableSource<? extends T>> supplier) {
        this.supplier = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            ObservableSource<? extends T> observableSource = this.supplier.get();
            Objects.requireNonNull(observableSource, "The supplier returned a null ObservableSource");
            observableSource.subscribe(observer);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
