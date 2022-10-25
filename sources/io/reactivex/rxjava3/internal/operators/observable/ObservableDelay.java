package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public ObservableDelay(ObservableSource<T> source, long delay, TimeUnit unit, Scheduler scheduler, boolean delayError) {
        super(source);
        this.delay = delay;
        this.unit = unit;
        this.scheduler = scheduler;
        this.delayError = delayError;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> t) {
        this.source.subscribe(new DelayObserver(this.delayError ? t : new SerializedObserver(t), this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }

    /* loaded from: classes4.dex */
    static final class DelayObserver<T> implements Observer<T>, Disposable {
        final long delay;
        final boolean delayError;
        final Observer<? super T> downstream;
        final TimeUnit unit;
        Disposable upstream;

        /* renamed from: w */
        final Scheduler.Worker f10557w;

        DelayObserver(Observer<? super T> actual, long delay, TimeUnit unit, Scheduler.Worker w, boolean delayError) {
            this.downstream = actual;
            this.delay = delay;
            this.unit = unit;
            this.f10557w = w;
            this.delayError = delayError;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(final T t) {
            this.f10557w.schedule(new OnNext(t), this.delay, this.unit);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(final Throwable t) {
            this.f10557w.schedule(new OnError(t), this.delayError ? this.delay : 0L, this.unit);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.f10557w.schedule(new OnComplete(), this.delay, this.unit);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.f10557w.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.f10557w.isDisposed();
        }

        /* loaded from: classes4.dex */
        final class OnNext implements Runnable {

            /* renamed from: t */
            private final T f10558t;

            OnNext(T t) {
                this.f10558t = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelayObserver.this.downstream.onNext((T) this.f10558t);
            }
        }

        /* loaded from: classes4.dex */
        final class OnError implements Runnable {
            private final Throwable throwable;

            OnError(Throwable throwable) {
                this.throwable = throwable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.downstream.onError(this.throwable);
                } finally {
                    DelayObserver.this.f10557w.dispose();
                }
            }
        }

        /* loaded from: classes4.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.downstream.onComplete();
                } finally {
                    DelayObserver.this.f10557w.dispose();
                }
            }
        }
    }
}
