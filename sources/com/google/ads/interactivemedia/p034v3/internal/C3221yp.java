package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.yp */
/* loaded from: classes2.dex */
public final class C3221yp implements InterfaceC3250zr {

    /* renamed from: a */
    public final int f9516a;

    /* renamed from: b */
    public final int[] f9517b;

    /* renamed from: c */
    public final long[] f9518c;

    /* renamed from: d */
    public final long[] f9519d;

    /* renamed from: e */
    public final long[] f9520e;

    /* renamed from: f */
    private final long f9521f;

    public C3221yp(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f9517b = iArr;
        this.f9518c = jArr;
        this.f9519d = jArr2;
        this.f9520e = jArr3;
        int length = iArr.length;
        this.f9516a = length;
        if (length <= 0) {
            this.f9521f = 0L;
            return;
        }
        int i = length - 1;
        this.f9521f = jArr2[i] + jArr3[i];
    }

    /* renamed from: a */
    public final int m513a(long j) {
        return C2628cq.m2540ap(this.f9520e, j, true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: e */
    public final long mo447e() {
        return this.f9521f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: g */
    public final C3248zp mo446g(long j) {
        int m513a = m513a(j);
        C3251zs c3251zs = new C3251zs(this.f9520e[m513a], this.f9518c[m513a]);
        if (c3251zs.f9616b >= j || m513a == this.f9516a - 1) {
            return new C3248zp(c3251zs, c3251zs);
        }
        int i = m513a + 1;
        return new C3248zp(c3251zs, new C3251zs(this.f9520e[i], this.f9518c[i]));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: h */
    public final boolean mo445h() {
        return true;
    }

    public final String toString() {
        int i = this.f9516a;
        String arrays = Arrays.toString(this.f9517b);
        String arrays2 = Arrays.toString(this.f9518c);
        String arrays3 = Arrays.toString(this.f9520e);
        String arrays4 = Arrays.toString(this.f9519d);
        int length = String.valueOf(arrays).length();
        int length2 = String.valueOf(arrays2).length();
        StringBuilder sb = new StringBuilder(length + 71 + length2 + String.valueOf(arrays3).length() + String.valueOf(arrays4).length());
        sb.append("ChunkIndex(length=");
        sb.append(i);
        sb.append(", sizes=");
        sb.append(arrays);
        sb.append(", offsets=");
        sb.append(arrays2);
        sb.append(", timeUs=");
        sb.append(arrays3);
        sb.append(", durationsUs=");
        sb.append(arrays4);
        sb.append(")");
        return sb.toString();
    }
}
