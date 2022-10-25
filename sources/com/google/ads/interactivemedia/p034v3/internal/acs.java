package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.acs */
/* loaded from: classes2.dex */
final class acs {

    /* renamed from: a */
    public final acp f3263a;

    /* renamed from: b */
    public final int f3264b;

    /* renamed from: c */
    public final long[] f3265c;

    /* renamed from: d */
    public final int[] f3266d;

    /* renamed from: e */
    public final int f3267e;

    /* renamed from: f */
    public final long[] f3268f;

    /* renamed from: g */
    public final int[] f3269g;

    /* renamed from: h */
    public final long f3270h;

    public acs(acp acpVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        int length = iArr.length;
        int length2 = jArr2.length;
        C2616ce.m2687f(length == length2);
        int length3 = jArr.length;
        C2616ce.m2687f(length3 == length2);
        int length4 = iArr2.length;
        C2616ce.m2687f(length4 == length2);
        this.f3263a = acpVar;
        this.f3265c = jArr;
        this.f3266d = iArr;
        this.f3267e = i;
        this.f3268f = jArr2;
        this.f3269g = iArr2;
        this.f3270h = j;
        this.f3264b = length3;
        if (length4 > 0) {
            int i2 = length4 - 1;
            iArr2[i2] = iArr2[i2] | 536870912;
        }
    }

    /* renamed from: a */
    public final int m5822a(long j) {
        for (int m2540ap = C2628cq.m2540ap(this.f3268f, j, false); m2540ap >= 0; m2540ap--) {
            if ((this.f3269g[m2540ap] & 1) != 0) {
                return m2540ap;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public final int m5821b(long j) {
        for (int m2543am = C2628cq.m2543am(this.f3268f, j, true); m2543am < this.f3268f.length; m2543am++) {
            if ((this.f3269g[m2543am] & 1) != 0) {
                return m2543am;
            }
        }
        return -1;
    }
}
