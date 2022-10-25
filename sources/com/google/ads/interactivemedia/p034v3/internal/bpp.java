package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpp */
/* loaded from: classes2.dex */
public final class bpp extends AbstractList implements RandomAccess, bnu {

    /* renamed from: a */
    private final bnu f6397a;

    public bpp(bnu bnuVar) {
        this.f6397a = bnuVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnu
    /* renamed from: e */
    public final bnu mo2939e() {
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnu
    /* renamed from: f */
    public final Object mo2938f(int i) {
        return this.f6397a.mo2938f(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((bnt) this.f6397a).get(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnu
    /* renamed from: h */
    public final List mo2937h() {
        return this.f6397a.mo2937h();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnu
    /* renamed from: i */
    public final void mo2936i(bls blsVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new bpo(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new bpn(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6397a.size();
    }
}
