package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.zq */
/* loaded from: classes2.dex */
public final class C3249zq implements InterfaceC3250zr, abo {

    /* renamed from: a */
    private final long f9613a;

    /* renamed from: b */
    private final C3248zp f9614b;

    public C3249zq(long j) {
        this(j, 0L);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abo
    /* renamed from: a */
    public final long mo449a() {
        return -1L;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abo
    /* renamed from: b */
    public final long mo448b(long j) {
        return 0L;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: e */
    public final long mo447e() {
        return this.f9613a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: g */
    public final C3248zp mo446g(long j) {
        return this.f9614b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: h */
    public final boolean mo445h() {
        return false;
    }

    public C3249zq(long j, long j2) {
        this.f9613a = j;
        C3251zs c3251zs = j2 == 0 ? C3251zs.f9615a : new C3251zs(0L, j2);
        this.f9614b = new C3248zp(c3251zs, c3251zs);
    }

    public C3249zq() {
        this(C3282C.TIME_UNSET);
    }
}
