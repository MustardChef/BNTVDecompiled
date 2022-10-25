package com.google.common.cache;

/* loaded from: classes3.dex */
public interface RemovalListener<K, V> {
    void onRemoval(RemovalNotification<K, V> removalNotification);
}
