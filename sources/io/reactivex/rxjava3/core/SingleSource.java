package io.reactivex.rxjava3.core;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface SingleSource<T> {
    void subscribe(SingleObserver<? super T> observer);
}
