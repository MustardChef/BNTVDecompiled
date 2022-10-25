package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bht */
/* loaded from: classes2.dex */
final class bht extends AbstractSet {

    /* renamed from: a */
    final /* synthetic */ bhy f5744a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bht(bhy bhyVar) {
        this.f5744a = bhyVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f5744a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj instanceof Map.Entry) && this.f5744a.m3667b((Map.Entry) obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new bhs(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        bhx m3667b;
        if ((obj instanceof Map.Entry) && (m3667b = this.f5744a.m3667b((Map.Entry) obj)) != null) {
            this.f5744a.m3664e(m3667b, true);
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5744a.f5761c;
    }
}
