package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.yq */
/* loaded from: classes2.dex */
public class C3222yq implements InterfaceC3250zr {

    /* renamed from: a */
    private final long f9522a;

    /* renamed from: b */
    private final long f9523b;

    /* renamed from: c */
    private final int f9524c;

    /* renamed from: d */
    private final long f9525d;

    /* renamed from: e */
    private final int f9526e;

    /* renamed from: f */
    private final long f9527f;

    public C3222yq(long j, long j2, int i, int i2) {
        long m511b;
        this.f9522a = j;
        this.f9523b = j2;
        this.f9524c = i2 == -1 ? 1 : i2;
        this.f9526e = i;
        if (j == -1) {
            this.f9525d = -1L;
            m511b = C3282C.TIME_UNSET;
        } else {
            this.f9525d = j - j2;
            m511b = m511b(j, j2, i);
        }
        this.f9527f = m511b;
    }

    /* renamed from: b */
    private static long m511b(long j, long j2, int i) {
        return (Math.max(0L, j - j2) * 8000000) / i;
    }

    /* renamed from: C */
    public final long m512C(long j) {
        return m511b(j, this.f9523b, this.f9526e);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: e */
    public final long mo447e() {
        return this.f9527f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: g */
    public final C3248zp mo446g(long j) {
        long j2 = this.f9525d;
        int i = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
        if (i != 0) {
            int i2 = this.f9526e;
            long j3 = this.f9524c;
            long j4 = (((i2 * j) / 8000000) / j3) * j3;
            if (i != 0) {
                j4 = Math.min(j4, j2 - j3);
            }
            long max = this.f9523b + Math.max(j4, 0L);
            long m512C = m512C(max);
            C3251zs c3251zs = new C3251zs(m512C, max);
            if (this.f9525d != -1 && m512C < j) {
                long j5 = max + this.f9524c;
                if (j5 < this.f9522a) {
                    return new C3248zp(c3251zs, new C3251zs(m512C(j5), j5));
                }
            }
            return new C3248zp(c3251zs, c3251zs);
        }
        C3251zs c3251zs2 = new C3251zs(0L, this.f9523b);
        return new C3248zp(c3251zs2, c3251zs2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: h */
    public final boolean mo445h() {
        return this.f9525d != -1;
    }
}
