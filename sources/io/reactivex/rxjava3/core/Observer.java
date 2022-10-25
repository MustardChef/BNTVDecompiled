package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.disposables.Disposable;

/* loaded from: classes4.dex */
public interface Observer<T> {
    void onComplete();

    void onError(Throwable e);

    void onNext(T t);

    void onSubscribe(Disposable d);
}
