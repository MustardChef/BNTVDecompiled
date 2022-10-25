package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Iterator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpo */
/* loaded from: classes2.dex */
final class bpo implements Iterator {

    /* renamed from: a */
    final Iterator f6395a;

    /* renamed from: b */
    final /* synthetic */ bpp f6396b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bpo(bpp bppVar) {
        bnu bnuVar;
        this.f6396b = bppVar;
        bnuVar = bppVar.f6397a;
        this.f6395a = bnuVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6395a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f6395a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
