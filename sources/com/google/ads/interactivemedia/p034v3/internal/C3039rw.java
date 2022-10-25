package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.rw */
/* loaded from: classes2.dex */
public final class C3039rw implements InterfaceC3078th {

    /* renamed from: a */
    private final InterfaceC3236zd f8785a;

    /* renamed from: b */
    private InterfaceC3229yx f8786b;

    /* renamed from: c */
    private InterfaceC3230yy f8787c;

    public C3039rw(InterfaceC3236zd interfaceC3236zd) {
        this.f8785a = interfaceC3236zd;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3078th
    /* renamed from: a */
    public final int mo1064a(C3247zo c3247zo) throws IOException {
        InterfaceC3229yx interfaceC3229yx = this.f8786b;
        C2616ce.m2689d(interfaceC3229yx);
        InterfaceC3230yy interfaceC3230yy = this.f8787c;
        C2616ce.m2689d(interfaceC3230yy);
        return interfaceC3229yx.mo432a(interfaceC3230yy, c3247zo);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3078th
    /* renamed from: b */
    public final long mo1063b() {
        InterfaceC3230yy interfaceC3230yy = this.f8787c;
        if (interfaceC3230yy != null) {
            return interfaceC3230yy.mo498d();
        }
        return -1L;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3078th
    /* renamed from: c */
    public final void mo1062c() {
        InterfaceC3229yx interfaceC3229yx = this.f8786b;
        if (interfaceC3229yx instanceof abn) {
            ((abn) interfaceC3229yx).m5903f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        if (r8.mo498d() != r10) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
        if (r8.mo498d() != r10) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006f, code lost:
        r1 = false;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3078th
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo1061d(com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h r7, android.net.Uri r8, java.util.Map r9, long r10, long r12, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3233za r14) throws java.io.IOException {
        /*
            r6 = this;
            com.google.ads.interactivemedia.v3.internal.yr r8 = new com.google.ads.interactivemedia.v3.internal.yr
            r0 = r8
            r1 = r7
            r2 = r10
            r4 = r12
            r0.<init>(r1, r2, r4)
            r6.f8787c = r8
            com.google.ads.interactivemedia.v3.internal.yx r7 = r6.f8786b
            if (r7 == 0) goto L10
            return
        L10:
            com.google.ads.interactivemedia.v3.internal.zd r7 = r6.f8785a
            com.google.ads.interactivemedia.v3.internal.yx[] r7 = com.google.ads.interactivemedia.p034v3.internal.C3235zc.m486a(r7)
            int r9 = r7.length
            r12 = 0
            r13 = 1
            if (r9 != r13) goto L20
            r7 = r7[r12]
            r6.f8786b = r7
            goto L7f
        L20:
            r0 = 0
        L21:
            if (r0 >= r9) goto L7b
            r1 = r7[r0]
            boolean r2 = r1.mo433D(r8)     // Catch: java.lang.Throwable -> L4c java.io.EOFException -> L61
            if (r2 == 0) goto L3f
            r6.f8786b = r1     // Catch: java.lang.Throwable -> L4c java.io.EOFException -> L61
            if (r1 != 0) goto L37
            long r0 = r8.mo498d()
            int r9 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r9 != 0) goto L38
        L37:
            r12 = 1
        L38:
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2685h(r12)
            r8.mo494h()
            goto L7b
        L3f:
            com.google.ads.interactivemedia.v3.internal.yx r1 = r6.f8786b
            if (r1 != 0) goto L71
            long r1 = r8.mo498d()
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 != 0) goto L6f
            goto L71
        L4c:
            r7 = move-exception
            com.google.ads.interactivemedia.v3.internal.yx r9 = r6.f8786b
            if (r9 != 0) goto L59
            long r0 = r8.mo498d()
            int r9 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r9 != 0) goto L5a
        L59:
            r12 = 1
        L5a:
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2685h(r12)
            r8.mo494h()
            throw r7
        L61:
            com.google.ads.interactivemedia.v3.internal.yx r1 = r6.f8786b
            if (r1 != 0) goto L71
            long r1 = r8.mo498d()
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 != 0) goto L6f
            goto L71
        L6f:
            r1 = 0
            goto L72
        L71:
            r1 = 1
        L72:
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2685h(r1)
            r8.mo494h()
            int r0 = r0 + 1
            goto L21
        L7b:
            com.google.ads.interactivemedia.v3.internal.yx r8 = r6.f8786b
            if (r8 == 0) goto L85
        L7f:
            com.google.ads.interactivemedia.v3.internal.yx r7 = r6.f8786b
            r7.mo431b(r14)
            return
        L85:
            com.google.ads.interactivemedia.v3.internal.uh r8 = new com.google.ads.interactivemedia.v3.internal.uh
            java.lang.String r7 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.m2573J(r7)
            java.lang.String r9 = java.lang.String.valueOf(r7)
            int r9 = r9.length()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            int r9 = r9 + 58
            r10.<init>(r9)
            java.lang.String r9 = "None of the available extractors ("
            r10.append(r9)
            r10.append(r7)
            java.lang.String r7 = ") could read the stream."
            r10.append(r7)
            java.lang.String r7 = r10.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3039rw.mo1061d(com.google.ads.interactivemedia.v3.internal.h, android.net.Uri, java.util.Map, long, long, com.google.ads.interactivemedia.v3.internal.za):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3078th
    /* renamed from: e */
    public final void mo1060e() {
        if (this.f8786b != null) {
            this.f8786b = null;
        }
        this.f8787c = null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3078th
    /* renamed from: f */
    public final void mo1059f(long j, long j2) {
        InterfaceC3229yx interfaceC3229yx = this.f8786b;
        C2616ce.m2689d(interfaceC3229yx);
        interfaceC3229yx.mo429d(j, j2);
    }
}
