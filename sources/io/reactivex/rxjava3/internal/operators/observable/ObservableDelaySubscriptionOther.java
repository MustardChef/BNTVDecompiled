package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes4.dex */
public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {
    final ObservableSource<? extends T> main;
    final ObservableSource<U> other;

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> main, ObservableSource<U> other) {
        this.main = main;
        this.other = other;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(final Observer<? super T> child) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        child.onSubscribe(sequentialDisposable);
        this.other.subscribe(new DelayObserver(sequentialDisposable, child));
    }

    /* loaded from: classes4.dex */
    final class DelayObserver implements Observer<U> {
        final Observer<? super T> child;
        boolean done;
        final SequentialDisposable serial;

        DelayObserver(SequentialDisposable serial, Observer<? super T> child) {
            this.serial = serial;
            this.child = child;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            this.serial.update(d);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(U t) {
            onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            if (this.done) {
                RxJavaPlugins.onError(e);
                return;
            }
            this.done = true;
            this.child.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            ObservableDelaySubscriptionOther.this.main.subscribe(new OnComplete());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public final class OnComplete implements Observer<T> {
            OnComplete() {
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable d) {
                DelayObserver.this.serial.update(d);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(T value) {
                DelayObserver.this.child.onNext(value);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable e) {
                DelayObserver.this.child.onError(e);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                DelayObserver.this.child.onComplete();
            }
        }
    }
}
