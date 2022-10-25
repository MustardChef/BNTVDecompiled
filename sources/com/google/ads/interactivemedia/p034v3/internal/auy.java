package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractSet;
import java.util.Iterator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.auy */
/* loaded from: classes2.dex */
abstract class auy extends AbstractSet {

    /* renamed from: b */
    final auz f5134b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public auy(auz auzVar) {
        this.f5134b = auzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract Object mo4557a(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f5134b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new aux(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5134b.f5137c;
    }
}
