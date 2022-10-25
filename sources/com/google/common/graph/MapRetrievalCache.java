package com.google.common.graph;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes3.dex */
class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {
    @NullableDecl
    private transient CacheEntry<K, V> cacheEntry1;
    @NullableDecl
    private transient CacheEntry<K, V> cacheEntry2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapRetrievalCache(Map<K, V> map) {
        super(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.MapIteratorCache
    public V get(@NullableDecl Object obj) {
        V ifCached = getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        V withoutCaching = getWithoutCaching(obj);
        if (withoutCaching != null) {
            addToCache(obj, withoutCaching);
        }
        return withoutCaching;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.graph.MapIteratorCache
    public V getIfCached(@NullableDecl Object obj) {
        V v = (V) super.getIfCached(obj);
        if (v != null) {
            return v;
        }
        CacheEntry<K, V> cacheEntry = this.cacheEntry1;
        if (cacheEntry != null && cacheEntry.key == obj) {
            return cacheEntry.value;
        }
        CacheEntry<K, V> cacheEntry2 = this.cacheEntry2;
        if (cacheEntry2 == null || cacheEntry2.key != obj) {
            return null;
        }
        addToCache(cacheEntry2);
        return cacheEntry2.value;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.graph.MapIteratorCache
    public void clearCache() {
        super.clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    private void addToCache(K k, V v) {
        addToCache(new CacheEntry<>(k, v));
    }

    private void addToCache(CacheEntry<K, V> cacheEntry) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = cacheEntry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class CacheEntry<K, V> {
        final K key;
        final V value;

        CacheEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }
}
