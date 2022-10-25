package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awu */
/* loaded from: classes2.dex */
final class awu extends avg {

    /* renamed from: a */
    private final transient Object[] f5220a;

    /* renamed from: b */
    private final transient int f5221b;

    /* renamed from: c */
    private final transient int f5222c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public awu(Object[] objArr, int i, int i2) {
        this.f5220a = objArr;
        this.f5221b = i;
        this.f5222c = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: e */
    public final boolean mo4423e() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        atm.m4613i(i, this.f5222c);
        Object obj = this.f5220a[i + i + this.f5221b];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5222c;
    }
}
