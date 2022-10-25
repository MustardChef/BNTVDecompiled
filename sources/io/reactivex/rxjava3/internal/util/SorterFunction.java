package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes4.dex */
public final class SorterFunction<T> implements Function<List<T>, List<T>> {
    final Comparator<? super T> comparator;

    @Override // io.reactivex.rxjava3.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object t) throws Throwable {
        return apply((List) ((List) t));
    }

    public SorterFunction(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public List<T> apply(List<T> t) {
        Collections.sort(t, this.comparator);
        return t;
    }
}
