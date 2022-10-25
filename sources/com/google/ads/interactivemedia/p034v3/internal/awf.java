package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awf */
/* loaded from: classes2.dex */
final class awf extends AbstractCollection {

    /* renamed from: a */
    final Map f5202a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public awf(Map map) {
        this.f5202a = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f5202a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5202a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f5202a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new awc(this.f5202a.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException unused) {
            for (Map.Entry entry : this.f5202a.entrySet()) {
                if (anx.m4882b(obj, entry.getValue())) {
                    this.f5202a.remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        try {
            atm.m4612j(collection);
            return super.removeAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet m4409c = axd.m4409c();
            for (Map.Entry entry : this.f5202a.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    m4409c.add(entry.getKey());
                }
            }
            return this.f5202a.keySet().removeAll(m4409c);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        try {
            atm.m4612j(collection);
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet m4409c = axd.m4409c();
            for (Map.Entry entry : this.f5202a.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    m4409c.add(entry.getKey());
                }
            }
            return this.f5202a.keySet().retainAll(m4409c);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f5202a.size();
    }
}
