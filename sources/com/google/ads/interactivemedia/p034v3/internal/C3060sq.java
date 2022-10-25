package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.sq */
/* loaded from: classes2.dex */
public final class C3060sq implements InterfaceC3066sw, InterfaceC3065sv {

    /* renamed from: a */
    public final C3067sx f8854a;

    /* renamed from: b */
    private final long f8855b;

    /* renamed from: c */
    private InterfaceC3069sz f8856c;

    /* renamed from: d */
    private InterfaceC3066sw f8857d;

    /* renamed from: e */
    private InterfaceC3065sv f8858e;

    /* renamed from: f */
    private long f8859f = C3282C.TIME_UNSET;

    /* renamed from: g */
    private final C3154wc f8860g;

    public C3060sq(C3067sx c3067sx, C3154wc c3154wc, long j) {
        this.f8854a = c3067sx;
        this.f8860g = c3154wc;
        this.f8855b = j;
    }

    /* renamed from: u */
    private final long m1115u(long j) {
        long j2 = this.f8859f;
        return j2 != C3282C.TIME_UNSET ? j2 : j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: a */
    public final long mo1030a(long j, C2740gu c2740gu) {
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        int i = C2628cq.f6961a;
        return interfaceC3066sw.mo1030a(j, c2740gu);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3065sv
    /* renamed from: bd */
    public final void mo1104bd(InterfaceC3066sw interfaceC3066sw) {
        InterfaceC3065sv interfaceC3065sv = this.f8858e;
        int i = C2628cq.f6961a;
        interfaceC3065sv.mo1104bd(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: bg */
    public final long mo888bg() {
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        int i = C2628cq.f6961a;
        return interfaceC3066sw.mo888bg();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: c */
    public final long mo887c() {
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        int i = C2628cq.f6961a;
        return interfaceC3066sw.mo887c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: d */
    public final long mo1029d() {
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        int i = C2628cq.f6961a;
        return interfaceC3066sw.mo1029d();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: e */
    public final long mo1028e(long j) {
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        int i = C2628cq.f6961a;
        return interfaceC3066sw.mo1028e(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: f */
    public final long mo1027f(InterfaceC3142vr[] interfaceC3142vrArr, boolean[] zArr, InterfaceC3098ua[] interfaceC3098uaArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.f8859f;
        if (j3 == C3282C.TIME_UNSET || j != this.f8855b) {
            j2 = j;
        } else {
            this.f8859f = C3282C.TIME_UNSET;
            j2 = j3;
        }
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        int i = C2628cq.f6961a;
        return interfaceC3066sw.mo1027f(interfaceC3142vrArr, zArr, interfaceC3098uaArr, zArr2, j2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3099ub
    /* renamed from: g */
    public final /* bridge */ /* synthetic */ void mo934g(InterfaceC3100uc interfaceC3100uc) {
        InterfaceC3066sw interfaceC3066sw = (InterfaceC3066sw) interfaceC3100uc;
        InterfaceC3065sv interfaceC3065sv = this.f8858e;
        int i = C2628cq.f6961a;
        interfaceC3065sv.mo934g(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: h */
    public final C2588bd mo1025h() {
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        int i = C2628cq.f6961a;
        return interfaceC3066sw.mo1025h();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: i */
    public final void mo1024i() throws IOException {
        try {
            InterfaceC3066sw interfaceC3066sw = this.f8857d;
            if (interfaceC3066sw != null) {
                interfaceC3066sw.mo1024i();
                return;
            }
            InterfaceC3069sz interfaceC3069sz = this.f8856c;
            if (interfaceC3069sz != null) {
                interfaceC3069sz.mo1008h();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    /* renamed from: j */
    public final long m1121j() {
        return this.f8859f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: k */
    public final void mo1022k(InterfaceC3065sv interfaceC3065sv, long j) {
        this.f8858e = interfaceC3065sv;
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        if (interfaceC3066sw != null) {
            interfaceC3066sw.mo1022k(this, m1115u(this.f8855b));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: l */
    public final void mo878l(long j) {
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        int i = C2628cq.f6961a;
        interfaceC3066sw.mo878l(j);
    }

    /* renamed from: m */
    public final long m1120m() {
        return this.f8855b;
    }

    /* renamed from: n */
    public final void m1119n(C3067sx c3067sx) {
        long m1115u = m1115u(this.f8855b);
        InterfaceC3069sz interfaceC3069sz = this.f8856c;
        C2616ce.m2689d(interfaceC3069sz);
        InterfaceC3066sw mo1004q = interfaceC3069sz.mo1004q(c3067sx, this.f8860g, m1115u);
        this.f8857d = mo1004q;
        if (this.f8858e != null) {
            mo1004q.mo1022k(this, m1115u);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: o */
    public final boolean mo875o(long j) {
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        return interfaceC3066sw != null && interfaceC3066sw.mo875o(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: p */
    public final boolean mo874p() {
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        return interfaceC3066sw != null && interfaceC3066sw.mo874p();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: q */
    public final void mo1020q(long j) {
        InterfaceC3066sw interfaceC3066sw = this.f8857d;
        int i = C2628cq.f6961a;
        interfaceC3066sw.mo1020q(j);
    }

    /* renamed from: r */
    public final void m1118r(long j) {
        this.f8859f = j;
    }

    /* renamed from: s */
    public final void m1117s() {
        if (this.f8857d != null) {
            InterfaceC3069sz interfaceC3069sz = this.f8856c;
            C2616ce.m2689d(interfaceC3069sz);
            interfaceC3069sz.mo1006o(this.f8857d);
        }
    }

    /* renamed from: t */
    public final void m1116t(InterfaceC3069sz interfaceC3069sz) {
        C2616ce.m2685h(this.f8856c == null);
        this.f8856c = interfaceC3069sz;
    }
}
