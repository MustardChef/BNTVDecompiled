package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractSet;
import java.util.Iterator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhv */
/* loaded from: classes2.dex */
final class bhv extends AbstractSet {

    /* renamed from: a */
    final /* synthetic */ bhy f5745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bhv(bhy bhyVar) {
        this.f5745a = bhyVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f5745a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f5745a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new bhu(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        return this.f5745a.m3665d(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5745a.f5761c;
    }
}
