package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adb */
/* loaded from: classes2.dex */
public final class adb implements InterfaceC3229yx {

    /* renamed from: a */
    private final int f3318a;

    /* renamed from: b */
    private final adc f3319b;

    /* renamed from: c */
    private final C2621cj f3320c;

    /* renamed from: d */
    private final C2621cj f3321d;

    /* renamed from: e */
    private final C2620ci f3322e;

    /* renamed from: f */
    private InterfaceC3233za f3323f;

    /* renamed from: g */
    private long f3324g;

    /* renamed from: h */
    private long f3325h;

    /* renamed from: i */
    private int f3326i;

    /* renamed from: j */
    private boolean f3327j;

    /* renamed from: k */
    private boolean f3328k;

    static {
        acy acyVar = acy.f3296a;
    }

    public adb() {
        this(null);
    }

    /* renamed from: f */
    private final int m5816f(InterfaceC3230yy interfaceC3230yy) throws IOException {
        int i = 0;
        while (true) {
            interfaceC3230yy.mo496f(this.f3321d.m2642H(), 0, 10);
            this.f3321d.m2644F(0);
            if (this.f3321d.m2631k() != 4801587) {
                break;
            }
            this.f3321d.m2643G(3);
            int m2634h = this.f3321d.m2634h();
            i += m2634h + 10;
            interfaceC3230yy.mo497e(m2634h);
        }
        interfaceC3230yy.mo494h();
        interfaceC3230yy.mo497e(i);
        if (this.f3325h == -1) {
            this.f3325h = i;
        }
        return i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: D */
    public final boolean mo433D(InterfaceC3230yy interfaceC3230yy) throws IOException {
        int m5816f = m5816f(interfaceC3230yy);
        int i = m5816f;
        int i2 = 0;
        int i3 = 0;
        do {
            interfaceC3230yy.mo496f(this.f3321d.m2642H(), 0, 2);
            this.f3321d.m2644F(0);
            if (adc.m5815f(this.f3321d.m2629m())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                interfaceC3230yy.mo496f(this.f3321d.m2642H(), 0, 4);
                this.f3322e.m2657g(14);
                int m2661c = this.f3322e.m2661c(13);
                if (m2661c <= 6) {
                    i++;
                    interfaceC3230yy.mo494h();
                    interfaceC3230yy.mo497e(i);
                } else {
                    interfaceC3230yy.mo497e(m2661c - 6);
                    i3 += m2661c;
                }
            } else {
                i++;
                interfaceC3230yy.mo494h();
                interfaceC3230yy.mo497e(i);
            }
            i2 = 0;
            i3 = 0;
        } while (i - m5816f < 8192);
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: a */
    public final int mo432a(InterfaceC3230yy interfaceC3230yy, C3247zo c3247zo) throws IOException {
        C2616ce.m2688e(this.f3323f);
        int mo501a = interfaceC3230yy.mo501a(this.f3320c.m2642H(), 0, 2048);
        if (!this.f3328k) {
            this.f3323f.mo487w(new C3249zq(C3282C.TIME_UNSET));
            this.f3328k = true;
        }
        if (mo501a == -1) {
            return -1;
        }
        this.f3320c.m2644F(0);
        this.f3320c.m2645E(mo501a);
        if (!this.f3327j) {
            this.f3319b.mo5768d(this.f3324g, 4);
            this.f3327j = true;
        }
        this.f3319b.mo5771a(this.f3320c);
        return 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: b */
    public final void mo431b(InterfaceC3233za interfaceC3233za) {
        this.f3323f = interfaceC3233za;
        this.f3319b.mo5770b(interfaceC3233za, new aej(0, 1));
        interfaceC3233za.mo488m();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: c */
    public final void mo430c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: d */
    public final void mo429d(long j, long j2) {
        this.f3327j = false;
        this.f3319b.mo5767e();
        this.f3324g = j2;
    }

    public adb(byte[] bArr) {
        this.f3318a = 0;
        this.f3319b = new adc(true, null);
        this.f3320c = new C2621cj(2048);
        this.f3326i = -1;
        this.f3325h = -1L;
        C2621cj c2621cj = new C2621cj(10);
        this.f3321d = c2621cj;
        this.f3322e = new C2620ci(c2621cj.m2642H());
    }
}
