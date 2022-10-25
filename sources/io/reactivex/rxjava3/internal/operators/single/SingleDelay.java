package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class SingleDelay<T> extends Single<T> {
    final boolean delayError;
    final Scheduler scheduler;
    final SingleSource<? extends T> source;
    final long time;
    final TimeUnit unit;

    public SingleDelay(SingleSource<? extends T> source, long time, TimeUnit unit, Scheduler scheduler, boolean delayError) {
        this.source = source;
        this.time = time;
        this.unit = unit;
        this.scheduler = scheduler;
        this.delayError = delayError;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(final SingleObserver<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.source.subscribe(new Delay(sequentialDisposable, observer));
    }

    /* loaded from: classes4.dex */
    final class Delay implements SingleObserver<T> {
        final SingleObserver<? super T> downstream;

        /* renamed from: sd */
        private final SequentialDisposable f10572sd;

        Delay(SequentialDisposable sd, SingleObserver<? super T> observer) {
            this.f10572sd = sd;
            this.downstream = observer;
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.f10572sd.replace(d);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(final T value) {
            this.f10572sd.replace(SingleDelay.this.scheduler.scheduleDirect(new OnSuccess(value), SingleDelay.this.time, SingleDelay.this.unit));
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(final Throwable e) {
            this.f10572sd.replace(SingleDelay.this.scheduler.scheduleDirect(new OnError(e), SingleDelay.this.delayError ? SingleDelay.this.time : 0L, SingleDelay.this.unit));
        }

        /* loaded from: classes4.dex */
        final class OnSuccess implements Runnable {
            private final T value;

            OnSuccess(T value) {
                this.value = value;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.downstream.onSuccess((T) this.value);
            }
        }

        /* loaded from: classes4.dex */
        final class OnError implements Runnable {

            /* renamed from: e */
            private final Throwable f10573e;

            OnError(Throwable e) {
                this.f10573e = e;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.downstream.onError(this.f10573e);
            }
        }
    }
}
