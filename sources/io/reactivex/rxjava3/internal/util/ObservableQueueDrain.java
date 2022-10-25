package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;

/* loaded from: classes4.dex */
public interface ObservableQueueDrain<T, U> {
    void accept(Observer<? super U> a, T v);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int m);
}
