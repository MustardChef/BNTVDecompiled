package io.reactivex;

/* loaded from: classes4.dex */
public interface MaybeConverter<T, R> {
    R apply(Maybe<T> maybe);
}
