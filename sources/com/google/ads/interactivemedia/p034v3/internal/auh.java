package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.auh */
/* loaded from: classes2.dex */
final class auh extends AbstractCollection {

    /* renamed from: a */
    final /* synthetic */ aui f5107a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public auh(aui auiVar) {
        this.f5107a = auiVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f5107a.mo4463o();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        for (Collection collection : this.f5107a.mo4460w().values()) {
            if (collection.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.f5107a.mo4572f();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f5107a.mo4464d();
    }
}
