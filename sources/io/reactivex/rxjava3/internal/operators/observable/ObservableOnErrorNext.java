package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes4.dex */
public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;

    public ObservableOnErrorNext(ObservableSource<T> source, Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier) {
        super(source);
        this.nextSupplier = nextSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> t) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(t, this.nextSupplier);
        t.onSubscribe(onErrorNextObserver.arbiter);
        this.source.subscribe(onErrorNextObserver);
    }

    /* loaded from: classes4.dex */
    static final class OnErrorNextObserver<T> implements Observer<T> {
        final SequentialDisposable arbiter = new SequentialDisposable();
        boolean done;
        final Observer<? super T> downstream;
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;
        boolean once;

        OnErrorNextObserver(Observer<? super T> actual, Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier) {
            this.downstream = actual;
            this.nextSupplier = nextSupplier;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            this.arbiter.replace(d);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (this.once) {
                if (this.done) {
                    RxJavaPlugins.onError(t);
                    return;
                } else {
                    this.downstream.onError(t);
                    return;
                }
            }
            this.once = true;
            try {
                ObservableSource<? extends T> apply = this.nextSupplier.apply(t);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("Observable is null");
                    nullPointerException.initCause(t);
                    this.downstream.onError(nullPointerException);
                    return;
                }
                apply.subscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(new CompositeException(t, th));
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.once = true;
            this.downstream.onComplete();
        }
    }
}
