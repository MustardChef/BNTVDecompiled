package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.yi */
/* loaded from: classes2.dex */
public final class C3214yi implements InterfaceC3250zr {

    /* renamed from: a */
    private final InterfaceC3217yl f9494a;

    /* renamed from: b */
    private final long f9495b;

    /* renamed from: c */
    private final long f9496c;

    /* renamed from: d */
    private final long f9497d;

    /* renamed from: e */
    private final long f9498e;

    /* renamed from: f */
    private final long f9499f;

    public C3214yi(InterfaceC3217yl interfaceC3217yl, long j, long j2, long j3, long j4, long j5) {
        this.f9494a = interfaceC3217yl;
        this.f9495b = j;
        this.f9496c = j2;
        this.f9497d = j3;
        this.f9498e = j4;
        this.f9499f = j5;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: e */
    public final long mo447e() {
        return this.f9495b;
    }

    /* renamed from: f */
    public final long m539f(long j) {
        return this.f9494a.mo529a(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: g */
    public final C3248zp mo446g(long j) {
        C3251zs c3251zs = new C3251zs(j, C3216yk.m533f(this.f9494a.mo529a(j), 0L, this.f9496c, this.f9497d, this.f9498e, this.f9499f));
        return new C3248zp(c3251zs, c3251zs);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: h */
    public final boolean mo445h() {
        return true;
    }
}
