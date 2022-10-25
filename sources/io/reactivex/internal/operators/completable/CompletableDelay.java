package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class CompletableDelay extends Completable {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final CompletableSource source;
    final TimeUnit unit;

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.source = completableSource;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new Delay(new CompositeDisposable(), completableObserver));
    }

    /* loaded from: classes4.dex */
    final class Delay implements CompletableObserver {

        /* renamed from: s */
        final CompletableObserver f10122s;
        private final CompositeDisposable set;

        Delay(CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.set = compositeDisposable;
            this.f10122s = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.set.add(CompletableDelay.this.scheduler.scheduleDirect(new OnComplete(), CompletableDelay.this.delay, CompletableDelay.this.unit));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.set.add(CompletableDelay.this.scheduler.scheduleDirect(new OnError(th), CompletableDelay.this.delayError ? CompletableDelay.this.delay : 0L, CompletableDelay.this.unit));
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
            this.f10122s.onSubscribe(this.set);
        }

        /* loaded from: classes4.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.f10122s.onComplete();
            }
        }

        /* loaded from: classes4.dex */
        final class OnError implements Runnable {

            /* renamed from: e */
            private final Throwable f10123e;

            OnError(Throwable th) {
                this.f10123e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.f10122s.onError(this.f10123e);
            }
        }
    }
}
