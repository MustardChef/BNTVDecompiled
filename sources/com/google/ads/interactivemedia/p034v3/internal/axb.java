package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axb */
/* loaded from: classes2.dex */
public final class axb extends avo {

    /* renamed from: a */
    final transient Object f5241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public axb(Object obj) {
        atm.m4612j(obj);
        this.f5241a = obj;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: c */
    public final avg mo4425c() {
        return avg.m4514o(this.f5241a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5241a.equals(obj);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: d */
    public final axf iterator() {
        return new avy(this.f5241a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: e */
    public final boolean mo4423e() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: g */
    public final int mo4422g(Object[] objArr) {
        objArr[0] = this.f5241a;
        return 1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f5241a.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.f5241a.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}
