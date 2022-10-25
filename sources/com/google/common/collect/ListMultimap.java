package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes3.dex */
public interface ListMultimap<K, V> extends Multimap<K, V> {
    @Override // 
    Map<K, Collection<V>> asMap();

    @Override // 
    boolean equals(@NullableDecl Object obj);

    @Override // 
    List<V> get(@NullableDecl K k);

    @Override // 
    List<V> removeAll(@NullableDecl Object obj);

    @Override // 
    List<V> replaceValues(K k, Iterable<? extends V> iterable);
}
