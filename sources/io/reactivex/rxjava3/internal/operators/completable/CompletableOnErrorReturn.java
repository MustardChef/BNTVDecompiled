package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class CompletableOnErrorReturn<T> extends Maybe<T> {
    final CompletableSource source;
    final Function<? super Throwable, ? extends T> valueSupplier;

    public CompletableOnErrorReturn(CompletableSource source, Function<? super Throwable, ? extends T> valueSupplier) {
        this.source = source;
        this.valueSupplier = valueSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        this.source.subscribe(new OnErrorReturnMaybeObserver(observer, this.valueSupplier));
    }

    /* loaded from: classes4.dex */
    static final class OnErrorReturnMaybeObserver<T> implements CompletableObserver, Disposable {
        final MaybeObserver<? super T> downstream;
        final Function<? super Throwable, ? extends T> itemSupplier;
        Disposable upstream;

        OnErrorReturnMaybeObserver(MaybeObserver<? super T> actual, Function<? super Throwable, ? extends T> itemSupplier) {
            this.downstream = actual;
            this.itemSupplier = itemSupplier;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            try {
                T apply = this.itemSupplier.apply(e);
                Objects.requireNonNull(apply, "The itemSupplier returned a null value");
                this.downstream.onSuccess(apply);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(new CompositeException(e, th));
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.downstream.onComplete();
        }
    }
}
