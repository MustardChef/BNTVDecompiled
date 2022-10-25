package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorComplete;

/* loaded from: classes4.dex */
public final class SingleOnErrorComplete<T> extends Maybe<T> {
    final Predicate<? super Throwable> predicate;
    final Single<T> source;

    public SingleOnErrorComplete(Single<T> source, Predicate<? super Throwable> predicate) {
        this.source = source;
        this.predicate = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        this.source.subscribe(new MaybeOnErrorComplete.OnErrorCompleteMultiObserver(observer, this.predicate));
    }
}
