package io.reactivex.rxjava3.core;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface CompletableConverter<R> {
    R apply(Completable upstream);
}
