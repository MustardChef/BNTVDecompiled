package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public final class BlockingDisposableMultiObserver<T> extends CountDownLatch implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver, Disposable {
    Throwable error;
    final SequentialDisposable upstream;
    T value;

    public BlockingDisposableMultiObserver() {
        super(1);
        this.upstream = new SequentialDisposable();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
        countDown();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onSubscribe(Disposable d) {
        DisposableHelper.setOnce(this.upstream, d);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(T t) {
        this.value = t;
        this.upstream.lazySet(Disposable.CC.disposed());
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onError(Throwable e) {
        this.error = e;
        this.upstream.lazySet(Disposable.CC.disposed());
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onComplete() {
        this.upstream.lazySet(Disposable.CC.disposed());
        countDown();
    }

    public void blockingConsume(CompletableObserver observer) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                observer.onError(e);
                return;
            }
        }
        if (isDisposed()) {
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    public void blockingConsume(SingleObserver<? super T> observer) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                observer.onError(e);
                return;
            }
        }
        if (isDisposed()) {
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onSuccess((T) this.value);
        }
    }

    public void blockingConsume(MaybeObserver<? super T> observer) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                observer.onError(e);
                return;
            }
        }
        if (isDisposed()) {
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            observer.onError(th);
            return;
        }
        Object obj = (T) this.value;
        if (obj == null) {
            observer.onComplete();
        } else {
            observer.onSuccess(obj);
        }
    }
}
