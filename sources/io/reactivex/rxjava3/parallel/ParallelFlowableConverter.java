package io.reactivex.rxjava3.parallel;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface ParallelFlowableConverter<T, R> {
    R apply(ParallelFlowable<T> upstream);
}
