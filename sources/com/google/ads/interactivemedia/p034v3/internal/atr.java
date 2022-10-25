package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.atr */
/* loaded from: classes2.dex */
final class atr implements Iterator {

    /* renamed from: a */
    final Iterator f5077a;

    /* renamed from: b */
    Collection f5078b;

    /* renamed from: c */
    final /* synthetic */ ats f5079c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public atr(ats atsVar) {
        this.f5079c = atsVar;
        this.f5077a = atsVar.f5080a.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5077a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f5077a.next();
        this.f5078b = (Collection) entry.getValue();
        return this.f5079c.m4602a(entry);
    }

    @Override // java.util.Iterator
    public final void remove() {
        atm.m4614h(this.f5078b != null, "no calls to next() since the last call to remove()");
        this.f5077a.remove();
        auf.m4574t(this.f5079c.f5081b, this.f5078b.size());
        this.f5078b.clear();
        this.f5078b = null;
    }
}
