package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.atu */
/* loaded from: classes2.dex */
final class atu implements Iterator {

    /* renamed from: a */
    Map.Entry f5086a;

    /* renamed from: b */
    final /* synthetic */ Iterator f5087b;

    /* renamed from: c */
    final /* synthetic */ atv f5088c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public atu(atv atvVar, Iterator it) {
        this.f5088c = atvVar;
        this.f5087b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5087b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.f5087b.next();
        this.f5086a = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        atm.m4614h(this.f5086a != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.f5086a.getValue();
        this.f5087b.remove();
        auf.m4574t(this.f5088c.f5089a, collection.size());
        collection.clear();
        this.f5086a = null;
    }
}
