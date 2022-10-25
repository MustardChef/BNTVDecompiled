package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

/* loaded from: classes4.dex */
public final class CompletableError extends Completable {
    final Throwable error;

    public CompletableError(Throwable error) {
        this.error = error;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        EmptyDisposable.error(this.error, observer);
    }
}
