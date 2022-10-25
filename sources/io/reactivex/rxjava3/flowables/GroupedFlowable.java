package io.reactivex.rxjava3.flowables;

import io.reactivex.rxjava3.core.Flowable;

/* loaded from: classes4.dex */
public abstract class GroupedFlowable<K, T> extends Flowable<T> {
    final K key;

    /* JADX INFO: Access modifiers changed from: protected */
    public GroupedFlowable(K key) {
        this.key = key;
    }

    public K getKey() {
        return this.key;
    }
}
