package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.atv */
/* loaded from: classes2.dex */
public class atv extends awe {

    /* renamed from: a */
    final /* synthetic */ auf f5089a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public atv(auf aufVar, Map map) {
        super(map);
        this.f5089a = aufVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awe, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        axd.m4388x(iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return this.f5201d.keySet().containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return this == obj || this.f5201d.keySet().equals(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f5201d.keySet().hashCode();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awe, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new atu(this, this.f5201d.entrySet().iterator());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awe, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Collection collection = (Collection) this.f5201d.remove(obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            auf.m4574t(this.f5089a, size);
            return size > 0;
        }
        return false;
    }
}
