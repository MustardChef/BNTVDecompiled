package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnt */
/* loaded from: classes2.dex */
public final class bnt extends bld implements RandomAccess, bnu {

    /* renamed from: a */
    private static final bnt f6294a;

    /* renamed from: b */
    private final List f6295b;

    static {
        bnt bntVar = new bnt(10);
        f6294a = bntVar;
        bntVar.mo3270b();
    }

    public bnt() {
        this(10);
    }

    /* renamed from: j */
    private static String m3238j(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof bls) {
            return ((bls) obj).m3498z();
        }
        return bnk.m3263f((byte[]) obj);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        m3538a();
        this.f6295b.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        m3538a();
        if (collection instanceof bnu) {
            collection = ((bnu) collection).mo2937h();
        }
        boolean addAll = this.f6295b.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        m3538a();
        this.f6295b.clear();
        this.modCount++;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnj
    /* renamed from: d */
    public final /* bridge */ /* synthetic */ bnj mo3117d(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.f6295b);
        return new bnt(arrayList);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnu
    /* renamed from: e */
    public final bnu mo2939e() {
        return mo3269c() ? new bpp(this) : this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnu
    /* renamed from: f */
    public final Object mo2938f(int i) {
        return this.f6295b.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g */
    public final String get(int i) {
        Object obj = this.f6295b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof bls) {
            bls blsVar = (bls) obj;
            String m3498z = blsVar.m3498z();
            if (blsVar.mo3043o()) {
                this.f6295b.set(i, m3498z);
            }
            return m3498z;
        }
        byte[] bArr = (byte[]) obj;
        String m3263f = bnk.m3263f(bArr);
        if (bnk.m3261h(bArr)) {
            this.f6295b.set(i, m3263f);
        }
        return m3263f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnu
    /* renamed from: h */
    public final List mo2937h() {
        return Collections.unmodifiableList(this.f6295b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnu
    /* renamed from: i */
    public final void mo2936i(bls blsVar) {
        m3538a();
        this.f6295b.add(blsVar);
        this.modCount++;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        m3538a();
        Object remove = this.f6295b.remove(i);
        this.modCount++;
        return m3238j(remove);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        m3538a();
        return m3238j(this.f6295b.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6295b.size();
    }

    public bnt(int i) {
        this(new ArrayList(i));
    }

    private bnt(ArrayList arrayList) {
        this.f6295b = arrayList;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
