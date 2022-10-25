package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.e */
/* loaded from: classes2.dex */
public abstract class AbstractC2665e implements InterfaceC2567aw {

    /* renamed from: a */
    protected final C2585ba f7080a = new C2585ba();

    /* renamed from: q */
    private final void m2452q() {
        mo2122n();
    }

    /* renamed from: a */
    public final boolean m2456a() {
        AbstractC2586bb l = mo2124l();
        if (!l.m4204p()) {
            int g = mo2129g();
            m2452q();
            mo2121o();
            if (l.mo1129j(g, 0, false) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final boolean m2455b() {
        AbstractC2586bb l = mo2124l();
        if (l.m4204p()) {
            return false;
        }
        int g = mo2129g();
        m2452q();
        mo2121o();
        return l.mo1128q(g) != -1;
    }

    /* renamed from: c */
    public final boolean m2454c() {
        AbstractC2586bb l = mo2124l();
        return !l.m4204p() && l.m4205o(mo2129g(), this.f7080a).m4250b();
    }

    /* renamed from: d */
    public final boolean m2453d() {
        AbstractC2586bb l = mo2124l();
        return !l.m4204p() && l.m4205o(mo2129g(), this.f7080a).f5354h;
    }
}
