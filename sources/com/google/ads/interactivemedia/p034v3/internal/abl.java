package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Pair;
import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abl */
/* loaded from: classes2.dex */
final class abl implements abo {

    /* renamed from: a */
    private final long[] f3070a;

    /* renamed from: b */
    private final long[] f3071b;

    /* renamed from: c */
    private final long f3072c;

    private abl(long[] jArr, long[] jArr2, long j) {
        this.f3070a = jArr;
        this.f3071b = jArr2;
        this.f3072c = j == C3282C.TIME_UNSET ? C2628cq.m2515s(jArr2[jArr2.length - 1]) : j;
    }

    /* renamed from: c */
    public static abl m5905c(long j, aas aasVar, long j2) {
        int length = aasVar.f2924d.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += aasVar.f2922b + aasVar.f2924d[i3];
            j3 += aasVar.f2923c + aasVar.f2925e[i3];
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new abl(jArr, jArr2, j2);
    }

    /* renamed from: d */
    private static Pair m5904d(long j, long[] jArr, long[] jArr2) {
        int m2540ap = C2628cq.m2540ap(jArr, j, true);
        long j2 = jArr[m2540ap];
        long j3 = jArr2[m2540ap];
        int i = m2540ap + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? 0.0d : (j - j2) / (j4 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abo
    /* renamed from: a */
    public final long mo449a() {
        return -1L;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abo
    /* renamed from: b */
    public final long mo448b(long j) {
        return C2628cq.m2515s(((Long) m5904d(j, this.f3070a, this.f3071b).second).longValue());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: e */
    public final long mo447e() {
        return this.f3072c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: g */
    public final C3248zp mo446g(long j) {
        Pair m5904d = m5904d(C2628cq.m2511w(C2628cq.m2519o(j, 0L, this.f3072c)), this.f3071b, this.f3070a);
        long longValue = ((Long) m5904d.first).longValue();
        C3251zs c3251zs = new C3251zs(C2628cq.m2515s(longValue), ((Long) m5904d.second).longValue());
        return new C3248zp(c3251zs, c3251zs);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: h */
    public final boolean mo445h() {
        return true;
    }
}
