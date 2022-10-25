package io.reactivex.rxjava3.core;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface MaybeOperator<Downstream, Upstream> {
    MaybeObserver<? super Upstream> apply(MaybeObserver<? super Downstream> observer) throws Throwable;
}
