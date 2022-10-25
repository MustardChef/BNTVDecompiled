package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.acz */
/* loaded from: classes2.dex */
public final class acz implements InterfaceC3229yx {

    /* renamed from: a */
    private final ada f3302a = new ada(null);

    /* renamed from: b */
    private final C2621cj f3303b = new C2621cj(16384);

    /* renamed from: c */
    private boolean f3304c;

    static {
        acy acyVar = acy.f3296a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
        r15.mo494h();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
        if ((r4 - r3) < 8192) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
        return false;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo433D(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy r15) throws java.io.IOException {
        /*
            r14 = this;
            com.google.ads.interactivemedia.v3.internal.cj r0 = new com.google.ads.interactivemedia.v3.internal.cj
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.m2642H()
            r15.mo496f(r4, r2, r1)
            r0.m2644F(r2)
            int r4 = r0.m2631k()
            r5 = 4801587(0x494433, float:6.728456E-39)
            r6 = 3
            if (r4 == r5) goto L96
            r15.mo494h()
            r15.mo497e(r3)
            r4 = r3
        L24:
            r1 = 0
        L25:
            byte[] r5 = r0.m2642H()
            r7 = 7
            r15.mo496f(r5, r2, r7)
            r0.m2644F(r2)
            int r5 = r0.m2629m()
            r8 = 44096(0xac40, float:6.1792E-41)
            r9 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r8) goto L4e
            if (r5 == r9) goto L4e
            r15.mo494h()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.148E-41)
            if (r1 < r5) goto L4a
            return r2
        L4a:
            r15.mo497e(r4)
            goto L24
        L4e:
            r8 = 1
            int r1 = r1 + r8
            r10 = 4
            if (r1 < r10) goto L54
            return r8
        L54:
            byte[] r8 = r0.m2642H()
            int r11 = com.google.ads.interactivemedia.p034v3.internal.C3212yg.f9486a
            int r11 = r8.length
            r12 = -1
            if (r11 >= r7) goto L60
            r11 = -1
            goto L8d
        L60:
            r11 = 2
            r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r13 = r8[r6]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r11 = r11 | r13
            r13 = 65535(0xffff, float:9.1834E-41)
            if (r11 != r13) goto L87
            r10 = r8[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 16
            r11 = 5
            r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r10 = r10 | r11
            r11 = 6
            r8 = r8[r11]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r11 = r10 | r8
            goto L88
        L87:
            r7 = 4
        L88:
            if (r5 != r9) goto L8c
            int r7 = r7 + 2
        L8c:
            int r11 = r11 + r7
        L8d:
            if (r11 != r12) goto L90
            return r2
        L90:
            int r11 = r11 + (-7)
            r15.mo497e(r11)
            goto L25
        L96:
            r0.m2643G(r6)
            int r4 = r0.m2634h()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r15.mo497e(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.acz.mo433D(com.google.ads.interactivemedia.v3.internal.yy):boolean");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: a */
    public final int mo432a(InterfaceC3230yy interfaceC3230yy, C3247zo c3247zo) throws IOException {
        int mo501a = interfaceC3230yy.mo501a(this.f3303b.m2642H(), 0, 16384);
        if (mo501a == -1) {
            return -1;
        }
        this.f3303b.m2644F(0);
        this.f3303b.m2645E(mo501a);
        if (!this.f3304c) {
            this.f3302a.mo5768d(0L, 4);
            this.f3304c = true;
        }
        this.f3302a.mo5771a(this.f3303b);
        return 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: b */
    public final void mo431b(InterfaceC3233za interfaceC3233za) {
        this.f3302a.mo5770b(interfaceC3233za, new aej(0, 1));
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
        this.f3304c = false;
        this.f3302a.mo5767e();
    }
}
