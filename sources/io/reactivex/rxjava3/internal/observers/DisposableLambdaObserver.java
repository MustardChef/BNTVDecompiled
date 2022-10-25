package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes4.dex */
public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> downstream;
    final Action onDispose;
    final Consumer<? super Disposable> onSubscribe;
    Disposable upstream;

    public DisposableLambdaObserver(Observer<? super T> actual, Consumer<? super Disposable> onSubscribe, Action onDispose) {
        this.downstream = actual;
        this.onSubscribe = onSubscribe;
        this.onDispose = onDispose;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable d) {
        try {
            this.onSubscribe.accept(d);
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            d.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, this.downstream);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable t) {
        if (this.upstream != DisposableHelper.DISPOSED) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(t);
            return;
        }
        RxJavaPlugins.onError(t);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (this.upstream != DisposableHelper.DISPOSED) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        Disposable disposable = this.upstream;
        if (disposable != DisposableHelper.DISPOSED) {
            this.upstream = DisposableHelper.DISPOSED;
            try {
                this.onDispose.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            disposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }
}
