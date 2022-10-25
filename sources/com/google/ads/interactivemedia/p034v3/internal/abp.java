package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abp */
/* loaded from: classes2.dex */
final class abp implements abo {

    /* renamed from: a */
    private final long[] f3093a;

    /* renamed from: b */
    private final long[] f3094b;

    /* renamed from: c */
    private final long f3095c;

    /* renamed from: d */
    private final long f3096d;

    private abp(long[] jArr, long[] jArr2, long j, long j2) {
        this.f3093a = jArr;
        this.f3094b = jArr2;
        this.f3095c = j;
        this.f3096d = j2;
    }

    /* renamed from: c */
    public static abp m5896c(long j, long j2, C3240zh c3240zh, C2621cj c2621cj) {
        int m2633i;
        c2621cj.m2643G(10);
        int m2637e = c2621cj.m2637e();
        if (m2637e <= 0) {
            return null;
        }
        int i = c3240zh.f9566d;
        long m2512v = C2628cq.m2512v(m2637e, (i >= 32000 ? 1152 : 576) * 1000000, i);
        int m2629m = c2621cj.m2629m();
        int m2629m2 = c2621cj.m2629m();
        int m2629m3 = c2621cj.m2629m();
        c2621cj.m2643G(2);
        long j3 = j2 + c3240zh.f9565c;
        long[] jArr = new long[m2629m];
        long[] jArr2 = new long[m2629m];
        int i2 = 0;
        long j4 = j2;
        while (i2 < m2629m) {
            int i3 = m2629m2;
            long j5 = j3;
            jArr[i2] = (i2 * m2512v) / m2629m;
            jArr2[i2] = Math.max(j4, j5);
            if (m2629m3 == 1) {
                m2633i = c2621cj.m2633i();
            } else if (m2629m3 == 2) {
                m2633i = c2621cj.m2629m();
            } else if (m2629m3 == 3) {
                m2633i = c2621cj.m2631k();
            } else if (m2629m3 != 4) {
                return null;
            } else {
                m2633i = c2621cj.m2630l();
            }
            j4 += m2633i * i3;
            i2++;
            j3 = j5;
            m2629m2 = i3;
        }
        if (j != -1 && j != j4) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("VBRI data size mismatch: ");
            sb.append(j);
            sb.append(", ");
            sb.append(j4);
            Log.w("VbriSeeker", sb.toString());
        }
        return new abp(jArr, jArr2, m2512v, j4);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abo
    /* renamed from: a */
    public final long mo449a() {
        return this.f3096d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abo
    /* renamed from: b */
    public final long mo448b(long j) {
        return this.f3093a[C2628cq.m2540ap(this.f3094b, j, true)];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: e */
    public final long mo447e() {
        return this.f3095c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: g */
    public final C3248zp mo446g(long j) {
        int m2540ap = C2628cq.m2540ap(this.f3093a, j, true);
        C3251zs c3251zs = new C3251zs(this.f3093a[m2540ap], this.f3094b[m2540ap]);
        if (c3251zs.f9616b < j) {
            long[] jArr = this.f3093a;
            if (m2540ap != jArr.length - 1) {
                int i = m2540ap + 1;
                return new C3248zp(c3251zs, new C3251zs(jArr[i], this.f3094b[i]));
            }
        }
        return new C3248zp(c3251zs, c3251zs);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: h */
    public final boolean mo445h() {
        return true;
    }
}
