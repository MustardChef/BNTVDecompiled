package io.reactivex.parallel;

/* loaded from: classes4.dex */
public interface ParallelFlowableConverter<T, R> {
    R apply(ParallelFlowable<T> parallelFlowable);
}
