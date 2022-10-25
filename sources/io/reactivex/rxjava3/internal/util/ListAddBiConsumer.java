package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.BiFunction;
import java.util.List;

/* loaded from: classes4.dex */
public enum ListAddBiConsumer implements BiFunction<List, Object, List> {
    INSTANCE;

    public static <T> BiFunction<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.rxjava3.functions.BiFunction
    public List apply(List t1, Object t2) {
        t1.add(t2);
        return t1;
    }
}
