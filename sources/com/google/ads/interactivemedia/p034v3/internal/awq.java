package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awq */
/* loaded from: classes2.dex */
public final class awq extends avg {

    /* renamed from: a */
    static final avg f5211a = new awq(new Object[0], 0);

    /* renamed from: b */
    final transient Object[] f5212b;

    /* renamed from: c */
    private final transient int f5213c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public awq(Object[] objArr, int i) {
        this.f5212b = objArr;
        this.f5213c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: a */
    public final int mo4435a() {
        return this.f5213c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: b */
    public final int mo4434b() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: e */
    public final boolean mo4423e() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: f */
    public final Object[] mo4433f() {
        return this.f5212b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avg, com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: g */
    final int mo4422g(Object[] objArr) {
        System.arraycopy(this.f5212b, 0, objArr, 0, this.f5213c);
        return this.f5213c;
    }

    @Override // java.util.List
    public final Object get(int i) {
        atm.m4613i(i, this.f5213c);
        Object obj = this.f5212b[i];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5213c;
    }
}
