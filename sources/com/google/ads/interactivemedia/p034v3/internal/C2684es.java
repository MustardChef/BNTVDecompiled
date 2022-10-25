package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.es */
/* loaded from: classes2.dex */
final class C2684es implements InterfaceC2718fz {

    /* renamed from: a */
    private final C2747ha f7170a;

    /* renamed from: b */
    private final InterfaceC2683er f7171b;

    /* renamed from: c */
    private InterfaceC2737gr f7172c;

    /* renamed from: d */
    private InterfaceC2718fz f7173d;

    /* renamed from: e */
    private boolean f7174e = true;

    /* renamed from: f */
    private boolean f7175f;

    public C2684es(InterfaceC2683er interfaceC2683er, InterfaceC2598bn interfaceC2598bn) {
        this.f7171b = interfaceC2683er;
        this.f7170a = new C2747ha(interfaceC2598bn);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2718fz
    /* renamed from: a */
    public final long mo1835a() {
        throw null;
    }

    /* renamed from: b */
    public final long m2404b(boolean z) {
        InterfaceC2737gr interfaceC2737gr = this.f7172c;
        if (interfaceC2737gr == null || interfaceC2737gr.mo846M() || (!this.f7172c.mo666N() && (z || this.f7172c.mo2182F()))) {
            this.f7174e = true;
            if (this.f7175f) {
                this.f7170a.m2108d();
            }
        } else {
            InterfaceC2718fz interfaceC2718fz = this.f7173d;
            C2616ce.m2689d(interfaceC2718fz);
            long mo1835a = interfaceC2718fz.mo1835a();
            if (this.f7174e) {
                if (mo1835a < this.f7170a.mo1835a()) {
                    this.f7170a.m2107e();
                } else {
                    this.f7174e = false;
                    if (this.f7175f) {
                        this.f7170a.m2108d();
                    }
                }
            }
            this.f7170a.m2109b(mo1835a);
            C2559aq mo1831c = interfaceC2718fz.mo1831c();
            if (!mo1831c.equals(this.f7170a.mo1831c())) {
                this.f7170a.mo1830g(mo1831c);
                this.f7171b.mo2330a(mo1831c);
            }
        }
        if (this.f7174e) {
            return this.f7170a.mo1835a();
        }
        InterfaceC2718fz interfaceC2718fz2 = this.f7173d;
        C2616ce.m2689d(interfaceC2718fz2);
        return interfaceC2718fz2.mo1835a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2718fz
    /* renamed from: c */
    public final C2559aq mo1831c() {
        InterfaceC2718fz interfaceC2718fz = this.f7173d;
        return interfaceC2718fz != null ? interfaceC2718fz.mo1831c() : this.f7170a.mo1831c();
    }

    /* renamed from: d */
    public final void m2403d(InterfaceC2737gr interfaceC2737gr) {
        if (interfaceC2737gr == this.f7172c) {
            this.f7173d = null;
            this.f7172c = null;
            this.f7174e = true;
        }
    }

    /* renamed from: e */
    public final void m2402e(InterfaceC2737gr interfaceC2737gr) throws C2685et {
        InterfaceC2718fz interfaceC2718fz;
        InterfaceC2718fz mo1829j = interfaceC2737gr.mo1829j();
        if (mo1829j == null || mo1829j == (interfaceC2718fz = this.f7173d)) {
            return;
        }
        if (interfaceC2718fz == null) {
            this.f7173d = mo1829j;
            this.f7172c = interfaceC2737gr;
            mo1829j.mo1830g(this.f7170a.mo1831c());
            return;
        }
        throw C2685et.m2395d(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
    }

    /* renamed from: f */
    public final void m2401f(long j) {
        this.f7170a.m2109b(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2718fz
    /* renamed from: g */
    public final void mo1830g(C2559aq c2559aq) {
        InterfaceC2718fz interfaceC2718fz = this.f7173d;
        if (interfaceC2718fz != null) {
            interfaceC2718fz.mo1830g(c2559aq);
            c2559aq = this.f7173d.mo1831c();
        }
        this.f7170a.mo1830g(c2559aq);
    }

    /* renamed from: h */
    public final void m2400h() {
        this.f7175f = true;
        this.f7170a.m2108d();
    }

    /* renamed from: i */
    public final void m2399i() {
        this.f7175f = false;
        this.f7170a.m2107e();
    }
}
