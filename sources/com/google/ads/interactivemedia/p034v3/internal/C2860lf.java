package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lf */
/* loaded from: classes2.dex */
public final class C2860lf implements InterfaceC3253zu {

    /* renamed from: a */
    final /* synthetic */ C2861lg f7983a;

    /* renamed from: b */
    private final C3096tz f7984b;

    /* renamed from: c */
    private final C2717fy f7985c = new C2717fy();

    /* renamed from: e */
    private final C2669ed f7987e = new C2669ed();

    /* renamed from: d */
    private long f7986d = C3282C.TIME_UNSET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2860lf(C2861lg c2861lg, C3154wc c3154wc) {
        this.f7983a = c2861lg;
        this.f7984b = C3096tz.m970O(c3154wc);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: a */
    public final /* synthetic */ int mo444a(InterfaceC2746h interfaceC2746h, int i, boolean z) {
        return C2539ab.m5959e(this, interfaceC2746h, i, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: b */
    public final void mo443b(C2962p c2962p) {
        this.f7984b.mo443b(c2962p);
    }

    /* renamed from: c */
    public final void m1724c(AbstractC3112uo abstractC3112uo) {
        long j = this.f7986d;
        if (j == C3282C.TIME_UNSET || abstractC3112uo.f9102m > j) {
            this.f7986d = abstractC3112uo.f9102m;
        }
        this.f7983a.m1714h();
    }

    /* renamed from: d */
    public final void m1723d() {
        this.f7984b.m984A();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: e */
    public final /* synthetic */ void mo442e(C2621cj c2621cj, int i) {
        C2539ab.m5958f(this, c2621cj, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x000a A[SYNTHETIC] */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo441f(long r8, int r10, int r11, int r12, com.google.ads.interactivemedia.p034v3.internal.C3252zt r13) {
        /*
            r7 = this;
            com.google.ads.interactivemedia.v3.internal.tz r0 = r7.f7984b
            r1 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r0.mo441f(r1, r3, r4, r5, r6)
        La:
            com.google.ads.interactivemedia.v3.internal.tz r8 = r7.f7984b
            r9 = 0
            boolean r8 = r8.m974K(r9)
            if (r8 == 0) goto L9a
            com.google.ads.interactivemedia.v3.internal.ed r8 = r7.f7987e
            r8.mo1278b()
            com.google.ads.interactivemedia.v3.internal.tz r8 = r7.f7984b
            com.google.ads.interactivemedia.v3.internal.fy r10 = r7.f7985c
            com.google.ads.interactivemedia.v3.internal.ed r11 = r7.f7987e
            int r8 = r8.m946o(r10, r11, r9, r9)
            r10 = -4
            if (r8 != r10) goto L2d
            com.google.ads.interactivemedia.v3.internal.ed r8 = r7.f7987e
            r8.m2447m()
            com.google.ads.interactivemedia.v3.internal.ed r8 = r7.f7987e
            goto L2e
        L2d:
            r8 = 0
        L2e:
            if (r8 == 0) goto La
            long r10 = r8.f7094d
            com.google.ads.interactivemedia.v3.internal.lg r12 = r7.f7983a
            com.google.ads.interactivemedia.v3.internal.aab r12 = com.google.ads.interactivemedia.p034v3.internal.C2861lg.m1719c(r12)
            com.google.ads.interactivemedia.v3.internal.ak r8 = r12.m425a(r8)
            if (r8 == 0) goto La
            com.google.ads.interactivemedia.v3.internal.aj r8 = r8.m5126b(r9)
            com.google.ads.interactivemedia.v3.internal.aaa r8 = (com.google.ads.interactivemedia.p034v3.internal.aaa) r8
            java.lang.String r12 = r8.f2873a
            java.lang.String r13 = r8.f2874b
            java.lang.String r0 = "urn:mpeg:dash:event:2012"
            boolean r12 = r0.equals(r12)
            r0 = 1
            if (r12 == 0) goto L6b
            java.lang.String r12 = "1"
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L6a
            java.lang.String r12 = "2"
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L6a
            java.lang.String r12 = "3"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L6b
            goto L6d
        L6a:
            r9 = 1
        L6b:
            if (r9 == 0) goto La
        L6d:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            byte[] r8 = r8.f2877e     // Catch: com.google.ads.interactivemedia.p034v3.internal.C2555ao -> L7d
            java.lang.String r8 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.m2576G(r8)     // Catch: com.google.ads.interactivemedia.p034v3.internal.C2555ao -> L7d
            long r8 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.m2514t(r8)     // Catch: com.google.ads.interactivemedia.p034v3.internal.C2555ao -> L7d
            goto L7e
        L7d:
            r8 = r12
        L7e:
            int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r1 == 0) goto La
            com.google.ads.interactivemedia.v3.internal.ld r12 = new com.google.ads.interactivemedia.v3.internal.ld
            r12.<init>(r10, r8)
            com.google.ads.interactivemedia.v3.internal.lg r8 = r7.f7983a
            android.os.Handler r9 = com.google.ads.interactivemedia.p034v3.internal.C2861lg.m1721a(r8)
            android.os.Handler r8 = com.google.ads.interactivemedia.p034v3.internal.C2861lg.m1721a(r8)
            android.os.Message r8 = r8.obtainMessage(r0, r12)
            r9.sendMessage(r8)
            goto La
        L9a:
            com.google.ads.interactivemedia.v3.internal.tz r8 = r7.f7984b
            r8.m939v()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2860lf.mo441f(long, int, int, int, com.google.ads.interactivemedia.v3.internal.zt):void");
    }

    /* renamed from: g */
    public final boolean m1722g(AbstractC3112uo abstractC3112uo) {
        long j = this.f7986d;
        boolean z = false;
        if (j != C3282C.TIME_UNSET && j < abstractC3112uo.f9101l) {
            z = true;
        }
        return this.f7983a.m1715g(z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: h */
    public final int mo440h(InterfaceC2746h interfaceC2746h, int i, boolean z) throws IOException {
        return C2539ab.m5959e(this.f7984b, interfaceC2746h, i, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: i */
    public final void mo439i(C2621cj c2621cj, int i) {
        C2539ab.m5958f(this.f7984b, c2621cj, i);
    }
}
