package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adt */
/* loaded from: classes2.dex */
public final class adt implements adg {

    /* renamed from: a */
    private final C2621cj f3521a;

    /* renamed from: b */
    private final C3240zh f3522b;

    /* renamed from: c */
    private final String f3523c;

    /* renamed from: d */
    private InterfaceC3253zu f3524d;

    /* renamed from: e */
    private String f3525e;

    /* renamed from: f */
    private int f3526f;

    /* renamed from: g */
    private int f3527g;

    /* renamed from: h */
    private boolean f3528h;

    /* renamed from: i */
    private boolean f3529i;

    /* renamed from: j */
    private long f3530j;

    /* renamed from: k */
    private int f3531k;

    /* renamed from: l */
    private long f3532l;

    public adt() {
        this(null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: a */
    public final void mo5771a(C2621cj c2621cj) {
        C3240zh c3240zh;
        C2616ce.m2688e(this.f3524d);
        while (c2621cj.m2641a() > 0) {
            int i = this.f3526f;
            if (i == 0) {
                byte[] m2642H = c2621cj.m2642H();
                int m2639c = c2621cj.m2639c();
                int m2638d = c2621cj.m2638d();
                while (true) {
                    if (m2639c < m2638d) {
                        byte b = m2642H[m2639c];
                        boolean z = (b & 255) == 255;
                        boolean z2 = this.f3529i && (b & 224) == 224;
                        this.f3529i = z;
                        if (z2) {
                            c2621cj.m2644F(m2639c + 1);
                            this.f3529i = false;
                            this.f3521a.m2642H()[1] = m2642H[m2639c];
                            this.f3527g = 2;
                            this.f3526f = 1;
                            break;
                        }
                        m2639c++;
                    } else {
                        c2621cj.m2644F(m2638d);
                        break;
                    }
                }
            } else if (i == 1) {
                int min = Math.min(c2621cj.m2641a(), 4 - this.f3527g);
                c2621cj.m2649A(this.f3521a.m2642H(), this.f3527g, min);
                int i2 = this.f3527g + min;
                this.f3527g = i2;
                if (i2 >= 4) {
                    this.f3521a.m2644F(0);
                    if (this.f3522b.m480a(this.f3521a.m2637e())) {
                        this.f3531k = this.f3522b.f9565c;
                        if (!this.f3528h) {
                            this.f3530j = (c3240zh.f9569g * 1000000) / c3240zh.f9566d;
                            C2935o c2935o = new C2935o();
                            c2935o.m1545S(this.f3525e);
                            c2935o.m1532ae(this.f3522b.f9564b);
                            c2935o.m1541W(4096);
                            c2935o.m1556H(this.f3522b.f9567e);
                            c2935o.m1531af(this.f3522b.f9566d);
                            c2935o.m1542V(this.f3523c);
                            this.f3524d.mo443b(c2935o.m1506v());
                            this.f3528h = true;
                        }
                        this.f3521a.m2644F(0);
                        this.f3524d.mo442e(this.f3521a, 4);
                        this.f3526f = 2;
                    } else {
                        this.f3527g = 0;
                        this.f3526f = 1;
                    }
                }
            } else {
                int min2 = Math.min(c2621cj.m2641a(), this.f3531k - this.f3527g);
                this.f3524d.mo442e(c2621cj, min2);
                int i3 = this.f3527g + min2;
                this.f3527g = i3;
                int i4 = this.f3531k;
                if (i3 >= i4) {
                    long j = this.f3532l;
                    if (j != C3282C.TIME_UNSET) {
                        this.f3524d.mo441f(j, 1, i4, 0, null);
                        this.f3532l += this.f3530j;
                    }
                    this.f3527g = 0;
                    this.f3526f = 0;
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: b */
    public final void mo5770b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        aejVar.m5729c();
        this.f3525e = aejVar.m5730b();
        this.f3524d = interfaceC3233za.mo489be(aejVar.m5731a(), 1);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: c */
    public final void mo5769c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: d */
    public final void mo5768d(long j, int i) {
        if (j != C3282C.TIME_UNSET) {
            this.f3532l = j;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: e */
    public final void mo5767e() {
        this.f3526f = 0;
        this.f3527g = 0;
        this.f3529i = false;
        this.f3532l = C3282C.TIME_UNSET;
    }

    public adt(String str) {
        this.f3526f = 0;
        C2621cj c2621cj = new C2621cj(4);
        this.f3521a = c2621cj;
        c2621cj.m2642H()[0] = -1;
        this.f3522b = new C3240zh();
        this.f3532l = C3282C.TIME_UNSET;
        this.f3523c = str;
    }
}
