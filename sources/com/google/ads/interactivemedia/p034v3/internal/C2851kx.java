package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kx */
/* loaded from: classes2.dex */
public final class C2851kx implements InterfaceC2850kw {

    /* renamed from: a */
    private final C3221yp f7945a;

    /* renamed from: b */
    private final long f7946b;

    public C2851kx(C3221yp c3221yp, long j) {
        this.f7945a = c3221yp;
        this.f7946b = j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: a */
    public final long mo1660a(long j, long j2) {
        return this.f7945a.f9516a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: b */
    public final long mo1659b(long j, long j2) {
        return this.f7945a.f9519d[(int) j];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: c */
    public final long mo1658c(long j, long j2) {
        return 0L;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: d */
    public final long mo1657d() {
        return 0L;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: e */
    public final long mo1656e(long j, long j2) {
        return C3282C.TIME_UNSET;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: f */
    public final long mo1655f(long j) {
        return this.f7945a.f9516a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: g */
    public final long mo1654g(long j, long j2) {
        return this.f7945a.m513a(j + this.f7946b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: h */
    public final long mo1653h(long j) {
        return this.f7945a.f9520e[(int) j] - this.f7946b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: i */
    public final C2871lq mo1652i(long j) {
        C3221yp c3221yp = this.f7945a;
        int i = (int) j;
        return new C2871lq(null, c3221yp.f9518c[i], c3221yp.f9517b[i]);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: j */
    public final boolean mo1651j() {
        return true;
    }
}
