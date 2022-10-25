package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adv */
/* loaded from: classes2.dex */
public final class adv implements adx {

    /* renamed from: a */
    private C2962p f3538a;

    /* renamed from: b */
    private C2626co f3539b;

    /* renamed from: c */
    private InterfaceC3253zu f3540c;

    public adv(String str) {
        C2935o c2935o = new C2935o();
        c2935o.m1532ae(str);
        this.f3538a = c2935o.m1506v();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adx
    /* renamed from: a */
    public final void mo5751a(C2621cj c2621cj) {
        C2616ce.m2688e(this.f3539b);
        int i = C2628cq.f6961a;
        long m2588d = this.f3539b.m2588d();
        long m2587e = this.f3539b.m2587e();
        if (m2588d == C3282C.TIME_UNSET || m2587e == C3282C.TIME_UNSET) {
            return;
        }
        C2962p c2962p = this.f3538a;
        if (m2587e != c2962p.f8376p) {
            C2935o m1426b = c2962p.m1426b();
            m1426b.m1528ai(m2587e);
            C2962p m1506v = m1426b.m1506v();
            this.f3538a = m1506v;
            this.f3540c.mo443b(m1506v);
        }
        int m2641a = c2621cj.m2641a();
        this.f3540c.mo442e(c2621cj, m2641a);
        this.f3540c.mo441f(m2588d, 1, m2641a, 0, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adx
    /* renamed from: b */
    public final void mo5750b(C2626co c2626co, InterfaceC3233za interfaceC3233za, aej aejVar) {
        this.f3539b = c2626co;
        aejVar.m5729c();
        InterfaceC3253zu mo489be = interfaceC3233za.mo489be(aejVar.m5731a(), 5);
        this.f3540c = mo489be;
        mo489be.mo443b(this.f3538a);
    }
}
