package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.acw */
/* loaded from: classes2.dex */
public final class acw implements InterfaceC3229yx {

    /* renamed from: a */
    private final acx f3281a = new acx();

    /* renamed from: b */
    private final C2621cj f3282b = new C2621cj(2786);

    /* renamed from: c */
    private boolean f3283c;

    static {
        acy acyVar = acy.f3296a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
        if ((r4 - r3) < 8192) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
        r8.mo494h();
        r4 = r4 + 1;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo433D(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy r8) throws java.io.IOException {
        /*
            r7 = this;
            com.google.ads.interactivemedia.v3.internal.cj r0 = new com.google.ads.interactivemedia.v3.internal.cj
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.m2642H()
            r8.mo496f(r4, r2, r1)
            r0.m2644F(r2)
            int r4 = r0.m2631k()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L5f
            r8.mo494h()
            r8.mo497e(r3)
            r4 = r3
        L23:
            r1 = 0
        L24:
            byte[] r5 = r0.m2642H()
            r6 = 6
            r8.mo496f(r5, r2, r6)
            r0.m2644F(r2)
            int r5 = r0.m2629m()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L47
            r8.mo494h()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.148E-41)
            if (r1 < r5) goto L43
            return r2
        L43:
            r8.mo497e(r4)
            goto L23
        L47:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L4d
            return r5
        L4d:
            byte[] r5 = r0.m2642H()
            int r5 = com.google.ads.interactivemedia.p034v3.internal.C3210ye.m552b(r5)
            r6 = -1
            if (r5 != r6) goto L59
            return r2
        L59:
            int r5 = r5 + (-6)
            r8.mo497e(r5)
            goto L24
        L5f:
            r4 = 3
            r0.m2643G(r4)
            int r4 = r0.m2634h()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.mo497e(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.acw.mo433D(com.google.ads.interactivemedia.v3.internal.yy):boolean");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: a */
    public final int mo432a(InterfaceC3230yy interfaceC3230yy, C3247zo c3247zo) throws IOException {
        int mo501a = interfaceC3230yy.mo501a(this.f3282b.m2642H(), 0, 2786);
        if (mo501a == -1) {
            return -1;
        }
        this.f3282b.m2644F(0);
        this.f3282b.m2645E(mo501a);
        if (!this.f3283c) {
            this.f3281a.mo5768d(0L, 4);
            this.f3283c = true;
        }
        this.f3281a.mo5771a(this.f3282b);
        return 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: b */
    public final void mo431b(InterfaceC3233za interfaceC3233za) {
        this.f3281a.mo5770b(interfaceC3233za, new aej(0, 1));
        interfaceC3233za.mo488m();
        interfaceC3233za.mo487w(new C3249zq(C3282C.TIME_UNSET));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: c */
    public final void mo430c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: d */
    public final void mo429d(long j, long j2) {
        this.f3283c = false;
        this.f3281a.mo5767e();
    }
}
