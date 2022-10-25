package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ou */
/* loaded from: classes2.dex */
public final class C2956ou implements InterfaceC3066sw, InterfaceC2964pb, InterfaceC2996qg {

    /* renamed from: a */
    private final InterfaceC2954os f8309a;

    /* renamed from: b */
    private final InterfaceC3000qk f8310b;

    /* renamed from: c */
    private final InterfaceC2659du f8311c;

    /* renamed from: d */
    private final InterfaceC2921nm f8312d;

    /* renamed from: e */
    private final C2915ng f8313e;

    /* renamed from: f */
    private final C3076tf f8314f;

    /* renamed from: j */
    private InterfaceC3065sv f8318j;

    /* renamed from: k */
    private int f8319k;

    /* renamed from: l */
    private C2588bd f8320l;

    /* renamed from: o */
    private int f8323o;

    /* renamed from: q */
    private final C2944oi f8325q;

    /* renamed from: r */
    private final C3154wc f8326r;

    /* renamed from: s */
    private final C3161wj f8327s;

    /* renamed from: t */
    private final C3161wj f8328t;

    /* renamed from: i */
    private final int f8317i = 1;

    /* renamed from: p */
    private InterfaceC3100uc f8324p = C3161wj.m735f(new InterfaceC3100uc[0]);

    /* renamed from: g */
    private final IdentityHashMap f8315g = new IdentityHashMap();

    /* renamed from: h */
    private final C2972pj f8316h = new C2972pj();

    /* renamed from: m */
    private C2967pe[] f8321m = new C2967pe[0];

    /* renamed from: n */
    private C2967pe[] f8322n = new C2967pe[0];

    public C2956ou(InterfaceC2954os interfaceC2954os, InterfaceC3000qk interfaceC3000qk, C2944oi c2944oi, InterfaceC2659du interfaceC2659du, InterfaceC2921nm interfaceC2921nm, C2915ng c2915ng, C3161wj c3161wj, C3076tf c3076tf, C3154wc c3154wc, C3161wj c3161wj2, int i, byte[] bArr, byte[] bArr2) {
        this.f8309a = interfaceC2954os;
        this.f8310b = interfaceC3000qk;
        this.f8325q = c2944oi;
        this.f8311c = interfaceC2659du;
        this.f8312d = interfaceC2921nm;
        this.f8313e = c2915ng;
        this.f8327s = c3161wj;
        this.f8314f = c3076tf;
        this.f8326r = c3154wc;
        this.f8328t = c3161wj2;
    }

    /* renamed from: t */
    private final C2967pe m1440t(int i, Uri[] uriArr, C2962p[] c2962pArr, C2962p c2962p, List list, Map map, long j) {
        return new C2967pe(i, this, new C2953or(this.f8309a, this.f8310b, uriArr, c2962pArr, this.f8325q, this.f8311c, this.f8316h, list), map, this.f8326r, j, c2962p, this.f8312d, this.f8313e, this.f8327s, this.f8314f, 1, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: a */
    public final long mo1030a(long j, C2740gu c2740gu) {
        return j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: bg */
    public final long mo888bg() {
        return this.f8324p.mo888bg();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: c */
    public final long mo887c() {
        return this.f8324p.mo887c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: d */
    public final long mo1029d() {
        return C3282C.TIME_UNSET;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: e */
    public final long mo1028e(long j) {
        C2967pe[] c2967peArr = this.f8322n;
        if (c2967peArr.length > 0) {
            boolean m1414D = c2967peArr[0].m1414D(j, false);
            int i = 1;
            while (true) {
                C2967pe[] c2967peArr2 = this.f8322n;
                if (i >= c2967peArr2.length) {
                    break;
                }
                c2967peArr2[i].m1414D(j, m1414D);
                i++;
            }
            if (m1414D) {
                this.f8316h.m1381b();
            }
        }
        return j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: f */
    public final long mo1027f(InterfaceC3142vr[] interfaceC3142vrArr, boolean[] zArr, InterfaceC3098ua[] interfaceC3098uaArr, boolean[] zArr2, long j) {
        int length;
        InterfaceC3098ua[] interfaceC3098uaArr2 = interfaceC3098uaArr;
        int length2 = interfaceC3142vrArr.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i = 0;
        while (true) {
            length = interfaceC3142vrArr.length;
            if (i >= length) {
                break;
            }
            InterfaceC3098ua interfaceC3098ua = interfaceC3098uaArr2[i];
            iArr[i] = interfaceC3098ua == null ? -1 : ((Integer) this.f8315g.get(interfaceC3098ua)).intValue();
            iArr2[i] = -1;
            InterfaceC3142vr interfaceC3142vr = interfaceC3142vrArr[i];
            if (interfaceC3142vr != null) {
                C2587bc f = interfaceC3142vr.mo834f();
                int i2 = 0;
                while (true) {
                    C2967pe[] c2967peArr = this.f8321m;
                    if (i2 >= c2967peArr.length) {
                        break;
                    } else if (c2967peArr[i2].m1396g().m4122a(f) != -1) {
                        iArr2[i] = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            i++;
        }
        this.f8315g.clear();
        InterfaceC3098ua[] interfaceC3098uaArr3 = new InterfaceC3098ua[length];
        InterfaceC3098ua[] interfaceC3098uaArr4 = new InterfaceC3098ua[length];
        InterfaceC3142vr[] interfaceC3142vrArr2 = new InterfaceC3142vr[length];
        C2967pe[] c2967peArr2 = new C2967pe[this.f8321m.length];
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        while (i4 < this.f8321m.length) {
            for (int i5 = 0; i5 < interfaceC3142vrArr.length; i5++) {
                InterfaceC3142vr interfaceC3142vr2 = null;
                interfaceC3098uaArr4[i5] = iArr[i5] == i4 ? interfaceC3098uaArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    interfaceC3142vr2 = interfaceC3142vrArr[i5];
                }
                interfaceC3142vrArr2[i5] = interfaceC3142vr2;
            }
            C2967pe c2967pe = this.f8321m[i4];
            int i6 = i3;
            int i7 = length;
            int i8 = i4;
            InterfaceC3142vr[] interfaceC3142vrArr3 = interfaceC3142vrArr2;
            C2967pe[] c2967peArr3 = c2967peArr2;
            InterfaceC3098ua[] interfaceC3098uaArr5 = interfaceC3098uaArr4;
            boolean m1413E = c2967pe.m1413E(interfaceC3142vrArr2, zArr, interfaceC3098uaArr4, zArr2, j, z);
            int i9 = 0;
            boolean z2 = false;
            while (true) {
                if (i9 >= interfaceC3142vrArr.length) {
                    break;
                }
                InterfaceC3098ua interfaceC3098ua2 = interfaceC3098uaArr5[i9];
                if (iArr2[i9] == i8) {
                    C2616ce.m2689d(interfaceC3098ua2);
                    interfaceC3098uaArr3[i9] = interfaceC3098ua2;
                    this.f8315g.put(interfaceC3098ua2, Integer.valueOf(i8));
                    z2 = true;
                } else if (iArr[i9] == i8) {
                    C2616ce.m2685h(interfaceC3098ua2 == null);
                }
                i9++;
            }
            if (z2) {
                c2967peArr3[i6] = c2967pe;
                i3 = i6 + 1;
                if (i6 == 0) {
                    c2967pe.m1385y(true);
                    if (!m1413E) {
                        C2967pe[] c2967peArr4 = this.f8322n;
                        if (c2967peArr4.length != 0 && c2967pe == c2967peArr4[0]) {
                        }
                    }
                    this.f8316h.m1381b();
                    z = true;
                } else {
                    c2967pe.m1385y(i8 < this.f8323o);
                }
            } else {
                i3 = i6;
            }
            i4 = i8 + 1;
            c2967peArr2 = c2967peArr3;
            length = i7;
            interfaceC3142vrArr2 = interfaceC3142vrArr3;
            interfaceC3098uaArr4 = interfaceC3098uaArr5;
            interfaceC3098uaArr2 = interfaceC3098uaArr;
        }
        System.arraycopy(interfaceC3098uaArr3, 0, interfaceC3098uaArr2, 0, length);
        C2967pe[] c2967peArr5 = (C2967pe[]) C2628cq.m2549ag(c2967peArr2, i3);
        this.f8322n = c2967peArr5;
        this.f8324p = C3161wj.m735f(c2967peArr5);
        return j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3099ub
    /* renamed from: g */
    public final /* bridge */ /* synthetic */ void mo934g(InterfaceC3100uc interfaceC3100uc) {
        this.f8318j.mo934g(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: h */
    public final C2588bd mo1025h() {
        C2588bd c2588bd = this.f8320l;
        C2616ce.m2689d(c2588bd);
        return c2588bd;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: i */
    public final void mo1024i() throws IOException {
        for (C2967pe c2967pe : this.f8321m) {
            c2967pe.m1390r();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2996qg
    /* renamed from: j */
    public final void mo1324j() {
        for (C2967pe c2967pe : this.f8321m) {
            c2967pe.m1388u();
        }
        this.f8318j.mo934g(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v3 */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo1022k(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3065sv r23, long r24) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2956ou.mo1022k(com.google.ads.interactivemedia.v3.internal.sv, long):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: l */
    public final void mo878l(long j) {
        this.f8324p.mo878l(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2964pb
    /* renamed from: m */
    public final void mo1422m(Uri uri) {
        this.f8310b.mo1313t(uri);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2964pb
    /* renamed from: n */
    public final void mo1421n() {
        C2967pe[] c2967peArr;
        int i = this.f8319k - 1;
        this.f8319k = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (C2967pe c2967pe : this.f8321m) {
            i2 += c2967pe.m1396g().f5440b;
        }
        C2587bc[] c2587bcArr = new C2587bc[i2];
        int i3 = 0;
        for (C2967pe c2967pe2 : this.f8321m) {
            int i4 = c2967pe2.m1396g().f5440b;
            int i5 = 0;
            while (i5 < i4) {
                c2587bcArr[i3] = c2967pe2.m1396g().m4121b(i5);
                i5++;
                i3++;
            }
        }
        this.f8320l = new C2588bd(c2587bcArr);
        this.f8318j.mo1104bd(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: o */
    public final boolean mo875o(long j) {
        if (this.f8320l == null) {
            for (C2967pe c2967pe : this.f8321m) {
                c2967pe.m1393k();
            }
            return false;
        }
        return this.f8324p.mo875o(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: p */
    public final boolean mo874p() {
        return this.f8324p.mo874p();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: q */
    public final void mo1020q(long j) {
        for (C2967pe c2967pe : this.f8322n) {
            c2967pe.m1412F(j);
        }
    }

    /* renamed from: r */
    public final void m1441r() {
        this.f8310b.mo1312u(this);
        for (C2967pe c2967pe : this.f8321m) {
            c2967pe.m1387v();
        }
        this.f8318j = null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2996qg
    /* renamed from: s */
    public final boolean mo1323s(Uri uri, C3159wh c3159wh, boolean z) {
        boolean z2 = true;
        for (C2967pe c2967pe : this.f8321m) {
            z2 &= c2967pe.m1415C(uri, c3159wh, z);
        }
        this.f8318j.mo934g(this);
        return z2;
    }
}
