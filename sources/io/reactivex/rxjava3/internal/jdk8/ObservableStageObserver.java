package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
abstract class ObservableStageObserver<T> extends CompletableFuture<T> implements Observer<T> {
    final AtomicReference<Disposable> upstream = new AtomicReference<>();
    T value;

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable d) {
        DisposableHelper.setOnce(this.upstream, d);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable t) {
        clear();
        if (completeExceptionally(t)) {
            return;
        }
        RxJavaPlugins.onError(t);
    }

    protected final void disposeUpstream() {
        DisposableHelper.dispose(this.upstream);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void clear() {
        this.value = null;
        this.upstream.lazySet(DisposableHelper.DISPOSED);
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean mayInterruptIfRunning) {
        disposeUpstream();
        return super.cancel(mayInterruptIfRunning);
    }

    @Override // java.util.concurrent.CompletableFuture
    public final boolean complete(T value) {
        disposeUpstream();
        return super.complete(value);
    }

    @Override // java.util.concurrent.CompletableFuture
    public final boolean completeExceptionally(Throwable ex) {
        disposeUpstream();
        return super.completeExceptionally(ex);
    }
}
