package com.google.ads.interactivemedia.p034v3.internal;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ik */
/* loaded from: classes2.dex */
public final class C2784ik {

    /* renamed from: a */
    private final C2583az f7585a;

    /* renamed from: b */
    private avg f7586b = avg.m4515n();

    /* renamed from: c */
    private avj f7587c = avj.m4504d();

    /* renamed from: d */
    private C3067sx f7588d;

    /* renamed from: e */
    private C3067sx f7589e;

    /* renamed from: f */
    private C3067sx f7590f;

    public C2784ik(C2583az c2583az) {
        this.f7585a = c2583az;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* bridge */ /* synthetic */ avg m2086f(C2784ik c2784ik) {
        return c2784ik.f7586b;
    }

    /* renamed from: j */
    private static C3067sx m2082j(InterfaceC2567aw interfaceC2567aw, avg avgVar, C3067sx c3067sx, C2583az c2583az) {
        AbstractC2586bb mo2124l = interfaceC2567aw.mo2124l();
        int mo2128h = interfaceC2567aw.mo2128h();
        Object mo920f = mo2124l.m4204p() ? null : mo2124l.mo920f(mo2128h);
        int m4300b = (interfaceC2567aw.mo2123m() || mo2124l.m4204p()) ? -1 : mo2124l.m4206m(mo2128h, c2583az).m4300b(C2628cq.m2515s(interfaceC2567aw.mo2126j()) - c2583az.f5316e);
        for (int i = 0; i < avgVar.size(); i++) {
            C3067sx c3067sx2 = (C3067sx) avgVar.get(i);
            if (m2079m(c3067sx2, mo920f, interfaceC2567aw.mo2123m(), interfaceC2567aw.mo2131e(), interfaceC2567aw.mo2130f(), m4300b)) {
                return c3067sx2;
            }
        }
        if (avgVar.isEmpty() && c3067sx != null) {
            if (m2079m(c3067sx, mo920f, interfaceC2567aw.mo2123m(), interfaceC2567aw.mo2131e(), interfaceC2567aw.mo2130f(), m4300b)) {
                return c3067sx;
            }
        }
        return null;
    }

    /* renamed from: k */
    private final void m2081k(avh avhVar, C3067sx c3067sx, AbstractC2586bb abstractC2586bb) {
        if (c3067sx == null) {
            return;
        }
        if (abstractC2586bb.mo925a(c3067sx.f4115a) != -1) {
            avhVar.mo4491a(c3067sx, abstractC2586bb);
            return;
        }
        AbstractC2586bb abstractC2586bb2 = (AbstractC2586bb) this.f7587c.get(c3067sx);
        if (abstractC2586bb2 != null) {
            avhVar.mo4491a(c3067sx, abstractC2586bb2);
        }
    }

    /* renamed from: l */
    private final void m2080l(AbstractC2586bb abstractC2586bb) {
        avh avhVar = new avh();
        if (!this.f7586b.isEmpty()) {
            for (int i = 0; i < this.f7586b.size(); i++) {
                m2081k(avhVar, (C3067sx) this.f7586b.get(i), abstractC2586bb);
            }
            if (!this.f7586b.contains(this.f7588d)) {
                m2081k(avhVar, this.f7588d, abstractC2586bb);
            }
        } else {
            m2081k(avhVar, this.f7589e, abstractC2586bb);
            if (!anx.m4882b(this.f7590f, this.f7589e)) {
                m2081k(avhVar, this.f7590f, abstractC2586bb);
            }
            if (!anx.m4882b(this.f7588d, this.f7589e) && !anx.m4882b(this.f7588d, this.f7590f)) {
                m2081k(avhVar, this.f7588d, abstractC2586bb);
            }
        }
        this.f7587c = avhVar.mo4489c();
    }

    /* renamed from: m */
    private static boolean m2079m(C3067sx c3067sx, Object obj, boolean z, int i, int i2, int i3) {
        if (c3067sx.f4115a.equals(obj)) {
            if (z) {
                if (c3067sx.f4116b != i || c3067sx.f4117c != i2) {
                    return false;
                }
            } else if (c3067sx.f4116b != -1 || c3067sx.f4119e != i3) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final AbstractC2586bb m2091a(C3067sx c3067sx) {
        return (AbstractC2586bb) this.f7587c.get(c3067sx);
    }

    /* renamed from: b */
    public final C3067sx m2090b() {
        return this.f7588d;
    }

    /* renamed from: c */
    public final C3067sx m2089c() {
        if (this.f7586b.isEmpty()) {
            return null;
        }
        return (C3067sx) axd.m4386z(this.f7586b);
    }

    /* renamed from: d */
    public final C3067sx m2088d() {
        return this.f7589e;
    }

    /* renamed from: e */
    public final C3067sx m2087e() {
        return this.f7590f;
    }

    /* renamed from: g */
    public final void m2085g(InterfaceC2567aw interfaceC2567aw) {
        this.f7588d = m2082j(interfaceC2567aw, this.f7586b, this.f7589e, this.f7585a);
    }

    /* renamed from: h */
    public final void m2084h(List list, C3067sx c3067sx, InterfaceC2567aw interfaceC2567aw) {
        this.f7586b = avg.m4517l(list);
        if (!list.isEmpty()) {
            this.f7589e = (C3067sx) list.get(0);
            C2616ce.m2689d(c3067sx);
            this.f7590f = c3067sx;
        }
        if (this.f7588d == null) {
            this.f7588d = m2082j(interfaceC2567aw, this.f7586b, this.f7589e, this.f7585a);
        }
        m2080l(interfaceC2567aw.mo2124l());
    }

    /* renamed from: i */
    public final void m2083i(InterfaceC2567aw interfaceC2567aw) {
        this.f7588d = m2082j(interfaceC2567aw, this.f7586b, this.f7589e, this.f7585a);
        m2080l(interfaceC2567aw.mo2124l());
    }
}
