package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aub */
/* loaded from: classes2.dex */
class aub implements Iterator {

    /* renamed from: a */
    final Iterator f5095a;

    /* renamed from: b */
    final Collection f5096b;

    /* renamed from: c */
    final /* synthetic */ auc f5097c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aub(auc aucVar) {
        Iterator it;
        this.f5097c = aucVar;
        this.f5096b = aucVar.f5099b;
        Collection collection = aucVar.f5099b;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.f5095a = it;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aub(auc aucVar, Iterator it) {
        this.f5097c = aucVar;
        this.f5096b = aucVar.f5099b;
        this.f5095a = it;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m4592a() {
        this.f5097c.m4590b();
        if (this.f5097c.f5099b != this.f5096b) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        m4592a();
        return this.f5095a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        m4592a();
        return this.f5095a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f5095a.remove();
        auf.m4576r(this.f5097c.f5102e);
        this.f5097c.m4589c();
    }
}
