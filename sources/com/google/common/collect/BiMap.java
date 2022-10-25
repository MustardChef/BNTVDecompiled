package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes3.dex */
public interface BiMap<K, V> extends Map<K, V> {
    @NullableDecl
    V forcePut(@NullableDecl K k, @NullableDecl V v);

    BiMap<V, K> inverse();

    @Override // com.google.common.collect.BiMap
    @NullableDecl
    V put(@NullableDecl K k, @NullableDecl V v);

    @Override // com.google.common.collect.BiMap
    void putAll(Map<? extends K, ? extends V> map);

    @Override // com.google.common.collect.BiMap
    Set<V> values();
}
