package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.yk */
/* loaded from: classes2.dex */
public final class C3216yk {

    /* renamed from: a */
    private final long f9500a;

    /* renamed from: b */
    private final long f9501b;

    /* renamed from: c */
    private final long f9502c;

    /* renamed from: d */
    private long f9503d = 0;

    /* renamed from: e */
    private long f9504e;

    /* renamed from: f */
    private long f9505f;

    /* renamed from: g */
    private long f9506g;

    /* renamed from: h */
    private long f9507h;

    /* JADX INFO: Access modifiers changed from: protected */
    public C3216yk(long j, long j2, long j3, long j4, long j5, long j6) {
        this.f9500a = j;
        this.f9501b = j2;
        this.f9504e = j3;
        this.f9505f = j4;
        this.f9506g = j5;
        this.f9502c = j6;
        this.f9507h = m533f(j2, 0L, j3, j4, j5, j6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public static long m533f(long j, long j2, long j3, long j4, long j5, long j6) {
        if (j4 + 1 >= j5 || 1 + j2 >= j3) {
            return j4;
        }
        long j7 = ((float) (j - j2)) * (((float) (j5 - j4)) / ((float) (j3 - j2)));
        return C2628cq.m2519o(((j4 + j7) - j6) - (j7 / 20), j4, (-1) + j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* bridge */ /* synthetic */ void m532g(C3216yk c3216yk, long j, long j2) {
        c3216yk.f9504e = j;
        c3216yk.f9506g = j2;
        c3216yk.m530i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static /* bridge */ /* synthetic */ void m531h(C3216yk c3216yk, long j, long j2) {
        c3216yk.f9503d = j;
        c3216yk.f9505f = j2;
        c3216yk.m530i();
    }

    /* renamed from: i */
    private final void m530i() {
        this.f9507h = m533f(this.f9501b, this.f9503d, this.f9504e, this.f9505f, this.f9506g, this.f9502c);
    }
}
