package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aww */
/* loaded from: classes2.dex */
public final class aww extends avo {

    /* renamed from: a */
    static final aww f5227a;

    /* renamed from: d */
    private static final Object[] f5228d;

    /* renamed from: b */
    final transient Object[] f5229b;

    /* renamed from: c */
    final transient Object[] f5230c;

    /* renamed from: e */
    private final transient int f5231e;

    /* renamed from: f */
    private final transient int f5232f;

    /* renamed from: g */
    private final transient int f5233g;

    static {
        Object[] objArr = new Object[0];
        f5228d = objArr;
        f5227a = new aww(objArr, 0, objArr, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aww(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f5229b = objArr;
        this.f5231e = i;
        this.f5230c = objArr2;
        this.f5232f = i2;
        this.f5233g = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: a */
    public final int mo4435a() {
        return this.f5233g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: b */
    public final int mo4434b() {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        Object[] objArr = this.f5230c;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int m4417E = axd.m4417E(obj);
        while (true) {
            int i = m4417E & this.f5232f;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            m4417E = i + 1;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: d */
    public final axf iterator() {
        return mo4425c().listIterator();
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
        return this.f5229b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: g */
    public final int mo4422g(Object[] objArr) {
        System.arraycopy(this.f5229b, 0, objArr, 0, this.f5233g);
        return this.f5233g;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo
    /* renamed from: h */
    final boolean mo4439h() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f5231e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo
    /* renamed from: i */
    final avg mo4438i() {
        return avg.m4518k(this.f5229b, this.f5233g);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5233g;
    }
}
