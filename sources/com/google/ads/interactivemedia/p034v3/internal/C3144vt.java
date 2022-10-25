package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vt */
/* loaded from: classes2.dex */
public final class C3144vt {

    /* renamed from: a */
    private final int f9237a;

    /* renamed from: b */
    private final int[] f9238b;

    /* renamed from: c */
    private final C2588bd[] f9239c;

    /* renamed from: d */
    private final int[][][] f9240d;

    /* renamed from: e */
    private final C2588bd f9241e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3144vt(int[] iArr, C2588bd[] c2588bdArr, int[][][] iArr2, C2588bd c2588bd) {
        this.f9238b = iArr;
        this.f9239c = c2588bdArr;
        this.f9240d = iArr2;
        this.f9241e = c2588bd;
        this.f9237a = iArr.length;
    }

    /* renamed from: a */
    public final int m793a() {
        return this.f9237a;
    }

    /* renamed from: b */
    public final int m792b(int i) {
        return this.f9238b[i];
    }

    /* renamed from: c */
    public final int m791c(int i, int i2, int i3) {
        return C2742gw.m2166b(this.f9240d[i][i2][i3]);
    }

    /* renamed from: d */
    public final C2588bd m790d(int i) {
        return this.f9239c[i];
    }

    /* renamed from: e */
    public final C2588bd m789e() {
        return this.f9241e;
    }
}
