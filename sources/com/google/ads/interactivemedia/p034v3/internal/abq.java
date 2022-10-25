package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abq */
/* loaded from: classes2.dex */
public final class abq implements abo {

    /* renamed from: a */
    private final long f3097a;

    /* renamed from: b */
    private final int f3098b;

    /* renamed from: c */
    private final long f3099c;

    /* renamed from: d */
    private final long f3100d;

    /* renamed from: e */
    private final long f3101e;

    /* renamed from: f */
    private final long[] f3102f;

    private abq(long j, int i, long j2, long j3, long[] jArr) {
        this.f3097a = j;
        this.f3098b = i;
        this.f3099c = j2;
        this.f3102f = jArr;
        this.f3100d = j3;
        this.f3101e = j3 != -1 ? j + j3 : -1L;
    }

    /* renamed from: c */
    public static abq m5895c(long j, long j2, C3240zh c3240zh, C2621cj c2621cj) {
        int m2630l;
        int i = c3240zh.f9569g;
        int i2 = c3240zh.f9566d;
        int m2637e = c2621cj.m2637e();
        if ((m2637e & 1) != 1 || (m2630l = c2621cj.m2630l()) == 0) {
            return null;
        }
        long m2512v = C2628cq.m2512v(m2630l, i * 1000000, i2);
        if ((m2637e & 6) != 6) {
            return new abq(j2, c3240zh.f9565c, m2512v, -1L, null);
        }
        long m2626p = c2621cj.m2626p();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = c2621cj.m2633i();
        }
        if (j != -1) {
            long j3 = j2 + m2626p;
            if (j != j3) {
                StringBuilder sb = new StringBuilder(67);
                sb.append("XING data size mismatch: ");
                sb.append(j);
                sb.append(", ");
                sb.append(j3);
                Log.w("XingSeeker", sb.toString());
            }
        }
        return new abq(j2, c3240zh.f9565c, m2512v, m2626p, jArr);
    }

    /* renamed from: d */
    private final long m5894d(int i) {
        return (this.f3099c * i) / 100;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abo
    /* renamed from: a */
    public final long mo449a() {
        return this.f3101e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abo
    /* renamed from: b */
    public final long mo448b(long j) {
        long j2 = j - this.f3097a;
        if (!mo445h() || j2 <= this.f3098b) {
            return 0L;
        }
        long[] jArr = (long[]) C2616ce.m2688e(this.f3102f);
        double d = (j2 * 256.0d) / this.f3100d;
        int m2540ap = C2628cq.m2540ap(jArr, (long) d, true);
        long m5894d = m5894d(m2540ap);
        long j3 = jArr[m2540ap];
        int i = m2540ap + 1;
        long m5894d2 = m5894d(i);
        long j4 = m2540ap == 99 ? 256L : jArr[i];
        return m5894d + Math.round((j3 == j4 ? 0.0d : (d - j3) / (j4 - j3)) * (m5894d2 - m5894d));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: e */
    public final long mo447e() {
        return this.f3099c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: g */
    public final C3248zp mo446g(long j) {
        long[] jArr;
        if (!mo445h()) {
            C3251zs c3251zs = new C3251zs(0L, this.f3097a + this.f3098b);
            return new C3248zp(c3251zs, c3251zs);
        }
        long m2519o = C2628cq.m2519o(j, 0L, this.f3099c);
        double d = (m2519o * 100.0d) / this.f3099c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                double d3 = ((long[]) C2616ce.m2688e(this.f3102f))[i];
                d2 = d3 + ((d - i) * ((i == 99 ? 256.0d : jArr[i + 1]) - d3));
            }
        }
        C3251zs c3251zs2 = new C3251zs(m2519o, this.f3097a + C2628cq.m2519o(Math.round((d2 / 256.0d) * this.f3100d), this.f3098b, this.f3100d - 1));
        return new C3248zp(c3251zs2, c3251zs2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: h */
    public final boolean mo445h() {
        return this.f3102f != null;
    }
}
