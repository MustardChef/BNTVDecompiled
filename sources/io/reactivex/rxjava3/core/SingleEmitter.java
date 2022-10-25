package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Cancellable;

/* loaded from: classes4.dex */
public interface SingleEmitter<T> {
    boolean isDisposed();

    void onError(Throwable t);

    void onSuccess(T t);

    void setCancellable(Cancellable c);

    void setDisposable(Disposable d);

    boolean tryOnError(Throwable t);
}
