package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public final class MaybeFilterSingle<T> extends Maybe<T> {
    final Predicate<? super T> predicate;
    final SingleSource<T> source;

    public MaybeFilterSingle(SingleSource<T> singleSource, Predicate<? super T> predicate) {
        this.source = singleSource;
        this.predicate = predicate;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new FilterMaybeObserver(maybeObserver, this.predicate));
    }

    /* loaded from: classes4.dex */
    static final class FilterMaybeObserver<T> implements SingleObserver<T>, Disposable {
        final MaybeObserver<? super T> actual;

        /* renamed from: d */
        Disposable f10272d;
        final Predicate<? super T> predicate;

        FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.actual = maybeObserver;
            this.predicate = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable = this.f10272d;
            this.f10272d = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f10272d.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10272d, disposable)) {
                this.f10272d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            try {
                if (this.predicate.test(t)) {
                    this.actual.onSuccess(t);
                } else {
                    this.actual.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.actual.onError(th);
        }
    }
}
