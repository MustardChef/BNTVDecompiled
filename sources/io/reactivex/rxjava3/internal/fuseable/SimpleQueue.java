package io.reactivex.rxjava3.internal.fuseable;

/* loaded from: classes4.dex */
public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(T value);

    boolean offer(T v1, T v2);

    T poll() throws Throwable;
}
