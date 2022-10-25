package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class LruCache<T, Y> {
    private final Map<T, Entry<Y>> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSize(Y y) {
        return 1;
    }

    protected void onItemEvicted(T t, Y y) {
    }

    public LruCache(long j) {
        this.initialMaxSize = j;
        this.maxSize = j;
    }

    public synchronized void setSizeMultiplier(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(((float) this.initialMaxSize) * f);
        evict();
    }

    protected synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized boolean contains(T t) {
        return this.cache.containsKey(t);
    }

    public synchronized Y get(T t) {
        Entry<Y> entry;
        entry = this.cache.get(t);
        return entry != null ? entry.value : null;
    }

    public synchronized Y put(T t, Y y) {
        int size = getSize(y);
        long j = size;
        if (j >= this.maxSize) {
            onItemEvicted(t, y);
            return null;
        }
        if (y != null) {
            this.currentSize += j;
        }
        Entry<Y> put = this.cache.put(t, y == null ? null : new Entry<>(y, size));
        if (put != null) {
            this.currentSize -= put.size;
            if (!put.value.equals(y)) {
                onItemEvicted(t, put.value);
            }
        }
        evict();
        return put != null ? put.value : null;
    }

    public synchronized Y remove(T t) {
        Entry<Y> remove = this.cache.remove(t);
        if (remove == null) {
            return null;
        }
        this.currentSize -= remove.size;
        return remove.value;
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Iterator<Map.Entry<T, Entry<Y>>> it = this.cache.entrySet().iterator();
            Map.Entry<T, Entry<Y>> next = it.next();
            Entry<Y> value = next.getValue();
            this.currentSize -= value.size;
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value.value);
        }
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Entry<Y> {
        final int size;
        final Y value;

        Entry(Y y, int i) {
            this.value = y;
            this.size = i;
        }
    }
}
