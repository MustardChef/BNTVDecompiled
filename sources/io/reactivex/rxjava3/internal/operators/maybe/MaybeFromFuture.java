package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class MaybeFromFuture<T> extends Maybe<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public MaybeFromFuture(Future<? extends T> future, long timeout, TimeUnit unit) {
        this.future = future;
        this.timeout = timeout;
        this.unit = unit;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        Object obj;
        Disposable empty = Disposable.CC.empty();
        observer.onSubscribe(empty);
        if (empty.isDisposed()) {
            return;
        }
        try {
            long j = this.timeout;
            if (j <= 0) {
                obj = (T) this.future.get();
            } else {
                obj = (T) this.future.get(j, this.unit);
            }
            if (empty.isDisposed()) {
                return;
            }
            if (obj == null) {
                observer.onComplete();
            } else {
                observer.onSuccess(obj);
            }
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
            if (th instanceof ExecutionException) {
                th = th.getCause();
            }
            Exceptions.throwIfFatal(th);
            if (empty.isDisposed()) {
                return;
            }
            observer.onError(th);
        }
    }
}
