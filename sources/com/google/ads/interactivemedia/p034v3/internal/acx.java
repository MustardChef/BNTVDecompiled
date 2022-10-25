package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.acx */
/* loaded from: classes2.dex */
public final class acx implements adg {

    /* renamed from: a */
    private final C2620ci f3284a;

    /* renamed from: b */
    private final C2621cj f3285b;

    /* renamed from: c */
    private final String f3286c;

    /* renamed from: d */
    private String f3287d;

    /* renamed from: e */
    private InterfaceC3253zu f3288e;

    /* renamed from: f */
    private int f3289f;

    /* renamed from: g */
    private int f3290g;

    /* renamed from: h */
    private boolean f3291h;

    /* renamed from: i */
    private long f3292i;

    /* renamed from: j */
    private C2962p f3293j;

    /* renamed from: k */
    private int f3294k;

    /* renamed from: l */
    private long f3295l;

    public acx() {
        this(null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: a */
    public final void mo5771a(C2621cj c2621cj) {
        C2616ce.m2688e(this.f3288e);
        while (c2621cj.m2641a() > 0) {
            int i = this.f3289f;
            if (i == 0) {
                while (true) {
                    if (c2621cj.m2641a() <= 0) {
                        break;
                    } else if (!this.f3291h) {
                        this.f3291h = c2621cj.m2633i() == 11;
                    } else {
                        int m2633i = c2621cj.m2633i();
                        if (m2633i == 119) {
                            this.f3291h = false;
                            this.f3289f = 1;
                            C2621cj c2621cj2 = this.f3285b;
                            c2621cj2.m2642H()[0] = 11;
                            c2621cj2.m2642H()[1] = 119;
                            this.f3290g = 2;
                            break;
                        }
                        this.f3291h = m2633i == 11;
                    }
                }
            } else if (i == 1) {
                byte[] m2642H = this.f3285b.m2642H();
                int min = Math.min(c2621cj.m2641a(), 128 - this.f3290g);
                c2621cj.m2649A(m2642H, this.f3290g, min);
                int i2 = this.f3290g + min;
                this.f3290g = i2;
                if (i2 == 128) {
                    this.f3284a.m2657g(0);
                    C3209yd m549e = C3210ye.m549e(this.f3284a);
                    C2962p c2962p = this.f3293j;
                    if (c2962p == null || m549e.f9473c != c2962p.f8385y || m549e.f9472b != c2962p.f8386z || !C2628cq.m2563T(m549e.f9471a, c2962p.f8372l)) {
                        C2935o c2935o = new C2935o();
                        c2935o.m1545S(this.f3287d);
                        c2935o.m1532ae(m549e.f9471a);
                        c2935o.m1556H(m549e.f9473c);
                        c2935o.m1531af(m549e.f9472b);
                        c2935o.m1542V(this.f3286c);
                        C2962p m1506v = c2935o.m1506v();
                        this.f3293j = m1506v;
                        this.f3288e.mo443b(m1506v);
                    }
                    this.f3294k = m549e.f9474d;
                    this.f3292i = (m549e.f9475e * 1000000) / this.f3293j.f8386z;
                    this.f3285b.m2644F(0);
                    this.f3288e.mo442e(this.f3285b, 128);
                    this.f3289f = 2;
                }
            } else {
                int min2 = Math.min(c2621cj.m2641a(), this.f3294k - this.f3290g);
                this.f3288e.mo442e(c2621cj, min2);
                int i3 = this.f3290g + min2;
                this.f3290g = i3;
                int i4 = this.f3294k;
                if (i3 == i4) {
                    long j = this.f3295l;
                    if (j != C3282C.TIME_UNSET) {
                        this.f3288e.mo441f(j, 1, i4, 0, null);
                        this.f3295l += this.f3292i;
                    }
                    this.f3289f = 0;
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: b */
    public final void mo5770b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        aejVar.m5729c();
        this.f3287d = aejVar.m5730b();
        this.f3288e = interfaceC3233za.mo489be(aejVar.m5731a(), 1);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: c */
    public final void mo5769c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: d */
    public final void mo5768d(long j, int i) {
        if (j != C3282C.TIME_UNSET) {
            this.f3295l = j;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: e */
    public final void mo5767e() {
        this.f3289f = 0;
        this.f3290g = 0;
        this.f3291h = false;
        this.f3295l = C3282C.TIME_UNSET;
    }

    public acx(String str) {
        C2620ci c2620ci = new C2620ci(new byte[128]);
        this.f3284a = c2620ci;
        this.f3285b = new C2621cj(c2620ci.f6942a);
        this.f3289f = 0;
        this.f3295l = C3282C.TIME_UNSET;
        this.f3286c = str;
    }
}
