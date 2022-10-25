package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes4.dex */
public final class CompletableResumeNext extends Completable {
    final Function<? super Throwable, ? extends CompletableSource> errorMapper;
    final CompletableSource source;

    public CompletableResumeNext(CompletableSource completableSource, Function<? super Throwable, ? extends CompletableSource> function) {
        this.source = completableSource;
        this.errorMapper = function;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        completableObserver.onSubscribe(sequentialDisposable);
        this.source.subscribe(new ResumeNext(completableObserver, sequentialDisposable));
    }

    /* loaded from: classes4.dex */
    final class ResumeNext implements CompletableObserver {

        /* renamed from: s */
        final CompletableObserver f10136s;

        /* renamed from: sd */
        final SequentialDisposable f10137sd;

        ResumeNext(CompletableObserver completableObserver, SequentialDisposable sequentialDisposable) {
            this.f10136s = completableObserver;
            this.f10137sd = sequentialDisposable;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f10136s.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            try {
                CompletableSource apply = CompletableResumeNext.this.errorMapper.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
                    nullPointerException.initCause(th);
                    this.f10136s.onError(nullPointerException);
                    return;
                }
                apply.subscribe(new OnErrorObserver());
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f10136s.onError(new CompositeException(th2, th));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.f10137sd.update(disposable);
        }

        /* loaded from: classes4.dex */
        final class OnErrorObserver implements CompletableObserver {
            OnErrorObserver() {
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                ResumeNext.this.f10136s.onComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                ResumeNext.this.f10136s.onError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                ResumeNext.this.f10137sd.update(disposable);
            }
        }
    }
}
