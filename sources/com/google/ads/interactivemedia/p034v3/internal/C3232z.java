package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.z */
/* loaded from: classes2.dex */
public final class C3232z {

    /* renamed from: a */
    public final long f9545a;

    /* renamed from: b */
    public final long f9546b;

    /* renamed from: c */
    public final long f9547c;

    /* renamed from: d */
    public final float f9548d;

    /* renamed from: e */
    public final float f9549e;

    @Deprecated
    public C3232z(long j, long j2, long j3, float f, float f2) {
        this.f9545a = j;
        this.f9546b = j2;
        this.f9547c = j3;
        this.f9548d = f;
        this.f9549e = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ C3232z(com.google.ads.interactivemedia.p034v3.internal.C3205y r10) {
        /*
            r9 = this;
            long r1 = com.google.ads.interactivemedia.p034v3.internal.C3205y.m560e(r10)
            long r3 = com.google.ads.interactivemedia.p034v3.internal.C3205y.m561d(r10)
            long r5 = com.google.ads.interactivemedia.p034v3.internal.C3205y.m562c(r10)
            float r7 = com.google.ads.interactivemedia.p034v3.internal.C3205y.m563b(r10)
            float r8 = com.google.ads.interactivemedia.p034v3.internal.C3205y.m564a(r10)
            r0 = r9
            r0.<init>(r1, r3, r5, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3232z.<init>(com.google.ads.interactivemedia.v3.internal.y):void");
    }

    /* renamed from: a */
    public final C3205y m490a() {
        return new C3205y(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3232z) {
            C3232z c3232z = (C3232z) obj;
            return this.f9545a == c3232z.f9545a && this.f9546b == c3232z.f9546b && this.f9547c == c3232z.f9547c && this.f9548d == c3232z.f9548d && this.f9549e == c3232z.f9549e;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f9545a;
        long j2 = this.f9546b;
        long j3 = this.f9547c;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31;
        float f = this.f9548d;
        int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.f9549e;
        return floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }
}
