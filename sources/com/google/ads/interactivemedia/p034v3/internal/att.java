package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.att */
/* loaded from: classes2.dex */
final class att implements Iterator {

    /* renamed from: a */
    final Iterator f5082a;

    /* renamed from: b */
    Collection f5083b;

    /* renamed from: c */
    Iterator f5084c;

    /* renamed from: d */
    final /* synthetic */ auf f5085d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public att(auf aufVar, byte[] bArr) {
        this(aufVar);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5082a.hasNext() || this.f5084c.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f5084c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f5082a.next();
            entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.f5083b = collection;
            this.f5084c = collection.iterator();
        }
        return this.f5084c.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f5084c.remove();
        Collection collection = this.f5083b;
        collection.getClass();
        if (collection.isEmpty()) {
            this.f5082a.remove();
        }
        auf.m4576r(this.f5085d);
    }

    att(auf aufVar) {
        Map map;
        this.f5085d = aufVar;
        map = aufVar.f5105a;
        this.f5082a = map.entrySet().iterator();
        this.f5083b = null;
        this.f5084c = avz.f5199a;
    }
}
