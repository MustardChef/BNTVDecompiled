package io.reactivex.rxjava3.internal.observers;

/* loaded from: classes4.dex */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        this.value = t;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable t) {
        this.value = null;
        this.error = t;
        countDown();
    }
}
