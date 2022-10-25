package io.reactivex.rxjava3.core;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface ObservableConverter<T, R> {
    R apply(Observable<T> upstream);
}
