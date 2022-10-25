package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes4.dex */
public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {
    final Action onAfterTerminate;
    final Action onCompleteCall;
    final Action onDisposeCall;
    final Consumer<? super Throwable> onErrorCall;
    final Consumer<? super Disposable> onSubscribeCall;
    final Consumer<? super T> onSuccessCall;

    public MaybePeek(MaybeSource<T> source, Consumer<? super Disposable> onSubscribeCall, Consumer<? super T> onSuccessCall, Consumer<? super Throwable> onErrorCall, Action onCompleteCall, Action onAfterTerminate, Action onDispose) {
        super(source);
        this.onSubscribeCall = onSubscribeCall;
        this.onSuccessCall = onSuccessCall;
        this.onErrorCall = onErrorCall;
        this.onCompleteCall = onCompleteCall;
        this.onAfterTerminate = onAfterTerminate;
        this.onDisposeCall = onDispose;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        this.source.subscribe(new MaybePeekObserver(observer, this));
    }

    /* loaded from: classes4.dex */
    static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> downstream;
        final MaybePeek<T> parent;
        Disposable upstream;

        MaybePeekObserver(MaybeObserver<? super T> actual, MaybePeek<T> parent) {
            this.downstream = actual;
            this.parent = parent;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            try {
                this.parent.onDisposeCall.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                try {
                    this.parent.onSubscribeCall.accept(d);
                    this.upstream = d;
                    this.downstream.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    d.dispose();
                    this.upstream = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th, this.downstream);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            if (this.upstream == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.parent.onSuccessCall.accept(value);
                this.upstream = DisposableHelper.DISPOSED;
                this.downstream.onSuccess(value);
                onAfterTerminate();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onErrorInner(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            if (this.upstream == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(e);
            } else {
                onErrorInner(e);
            }
        }

        void onErrorInner(Throwable e) {
            try {
                this.parent.onErrorCall.accept(e);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                e = new CompositeException(e, th);
            }
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(e);
            onAfterTerminate();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            if (this.upstream == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.parent.onCompleteCall.run();
                this.upstream = DisposableHelper.DISPOSED;
                this.downstream.onComplete();
                onAfterTerminate();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onErrorInner(th);
            }
        }

        void onAfterTerminate() {
            try {
                this.parent.onAfterTerminate.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }
}
