package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ue */
/* loaded from: classes2.dex */
public final class C3102ue extends AbstractC2586bb {

    /* renamed from: b */
    private static final Object f9048b = new Object();

    /* renamed from: c */
    private final long f9049c;

    /* renamed from: d */
    private final long f9050d;

    /* renamed from: e */
    private final long f9051e;

    /* renamed from: f */
    private final long f9052f;

    /* renamed from: g */
    private final long f9053g;

    /* renamed from: h */
    private final long f9054h;

    /* renamed from: i */
    private final boolean f9055i;

    /* renamed from: j */
    private final boolean f9056j;

    /* renamed from: k */
    private final boolean f9057k;

    /* renamed from: l */
    private final Object f9058l;

    /* renamed from: m */
    private final C2543ae f9059m;

    /* renamed from: n */
    private final C3232z f9060n;

    static {
        C3043s c3043s = new C3043s();
        c3043s.m1176b("SinglePeriodTimeline");
        c3043s.m1173e(Uri.EMPTY);
        c3043s.m1177a();
    }

    public C3102ue(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2, boolean z3, Object obj, C2543ae c2543ae, C3232z c3232z) {
        this.f9049c = j;
        this.f9050d = j2;
        this.f9051e = j3;
        this.f9052f = j4;
        this.f9053g = j5;
        this.f9054h = j6;
        this.f9055i = z;
        this.f9056j = z2;
        this.f9057k = z3;
        this.f9058l = obj;
        this.f9059m = c2543ae;
        this.f9060n = c3232z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: a */
    public final int mo925a(Object obj) {
        return f9048b.equals(obj) ? 0 : -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: b */
    public final int mo924b() {
        return 1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: c */
    public final int mo923c() {
        return 1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: d */
    public final C2583az mo922d(int i, C2583az c2583az, boolean z) {
        C2616ce.m2683j(i, 1);
        return c2583az.m4291k(null, z ? f9048b : null, this.f9051e, -this.f9053g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r1 > r6) goto L9;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.p034v3.internal.C2585ba mo921e(int r27, com.google.ads.interactivemedia.p034v3.internal.C2585ba r28, long r29) {
        /*
            r26 = this;
            r0 = r26
            r1 = 1
            r2 = r27
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2683j(r2, r1)
            long r1 = r0.f9054h
            boolean r3 = r0.f9056j
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 == 0) goto L2d
            boolean r3 = r0.f9057k
            if (r3 != 0) goto L2d
            r6 = 0
            int r3 = (r29 > r6 ? 1 : (r29 == r6 ? 0 : -1))
            if (r3 == 0) goto L2d
            long r6 = r0.f9052f
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 != 0) goto L26
        L23:
            r19 = r4
            goto L2f
        L26:
            long r1 = r1 + r29
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 <= 0) goto L2d
            goto L23
        L2d:
            r19 = r1
        L2f:
            java.lang.Object r7 = com.google.ads.interactivemedia.p034v3.internal.C2585ba.f5346a
            com.google.ads.interactivemedia.v3.internal.ae r8 = r0.f9059m
            java.lang.Object r9 = r0.f9058l
            long r10 = r0.f9049c
            long r12 = r0.f9050d
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            boolean r1 = r0.f9055i
            r16 = r1
            boolean r1 = r0.f9056j
            r17 = r1
            com.google.ads.interactivemedia.v3.internal.z r1 = r0.f9060n
            r18 = r1
            long r1 = r0.f9052f
            r21 = r1
            r23 = 0
            long r1 = r0.f9053g
            r24 = r1
            r6 = r28
            r6.m4249c(r7, r8, r9, r10, r12, r14, r16, r17, r18, r19, r21, r23, r24)
            return r28
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3102ue.mo921e(int, com.google.ads.interactivemedia.v3.internal.ba, long):com.google.ads.interactivemedia.v3.internal.ba");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: f */
    public final Object mo920f(int i) {
        C2616ce.m2683j(i, 1);
        return f9048b;
    }
}
