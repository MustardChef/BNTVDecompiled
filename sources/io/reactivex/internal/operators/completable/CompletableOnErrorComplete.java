package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

/* loaded from: classes4.dex */
public final class CompletableOnErrorComplete extends Completable {
    final Predicate<? super Throwable> predicate;
    final CompletableSource source;

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.source = completableSource;
        this.predicate = predicate;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new OnError(completableObserver));
    }

    /* loaded from: classes4.dex */
    final class OnError implements CompletableObserver {

        /* renamed from: s */
        private final CompletableObserver f10134s;

        OnError(CompletableObserver completableObserver) {
            this.f10134s = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f10134s.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            try {
                if (CompletableOnErrorComplete.this.predicate.test(th)) {
                    this.f10134s.onComplete();
                } else {
                    this.f10134s.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f10134s.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.f10134s.onSubscribe(disposable);
        }
    }
}
