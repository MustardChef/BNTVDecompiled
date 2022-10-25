package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class SerialDisposable implements Disposable {
    final AtomicReference<Disposable> resource;

    public SerialDisposable() {
        this.resource = new AtomicReference<>();
    }

    public SerialDisposable(Disposable initialDisposable) {
        this.resource = new AtomicReference<>(initialDisposable);
    }

    public boolean set(Disposable next) {
        return DisposableHelper.set(this.resource, next);
    }

    public boolean replace(Disposable next) {
        return DisposableHelper.replace(this.resource, next);
    }

    public Disposable get() {
        Disposable disposable = this.resource.get();
        return disposable == DisposableHelper.DISPOSED ? Disposable.CC.disposed() : disposable;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.resource);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.resource.get());
    }
}
