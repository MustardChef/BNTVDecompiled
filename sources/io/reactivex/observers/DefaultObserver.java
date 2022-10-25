package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;

/* loaded from: classes4.dex */
public abstract class DefaultObserver<T> implements Observer<T> {

    /* renamed from: s */
    private Disposable f10488s;

    protected void onStart() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.validate(this.f10488s, disposable, getClass())) {
            this.f10488s = disposable;
            onStart();
        }
    }

    protected final void cancel() {
        Disposable disposable = this.f10488s;
        this.f10488s = DisposableHelper.DISPOSED;
        disposable.dispose();
    }
}
