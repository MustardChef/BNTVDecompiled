package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.gk */
/* loaded from: classes2.dex */
public final class C2730gk {

    /* renamed from: d */
    private final InterfaceC2729gj f7397d;

    /* renamed from: e */
    private final C3076tf f7398e;

    /* renamed from: f */
    private final C2915ng f7399f;

    /* renamed from: g */
    private final HashMap f7400g;

    /* renamed from: h */
    private final Set f7401h;

    /* renamed from: i */
    private boolean f7402i;

    /* renamed from: j */
    private InterfaceC2659du f7403j;

    /* renamed from: k */
    private C3101ud f7404k = new C3101ud();

    /* renamed from: b */
    private final IdentityHashMap f7395b = new IdentityHashMap();

    /* renamed from: c */
    private final Map f7396c = new HashMap();

    /* renamed from: a */
    private final List f7394a = new ArrayList();

    public C2730gk(InterfaceC2729gj interfaceC2729gj, C2785il c2785il, Handler handler) {
        this.f7397d = interfaceC2729gj;
        C3076tf c3076tf = new C3076tf();
        this.f7398e = c3076tf;
        C2915ng c2915ng = new C2915ng();
        this.f7399f = c2915ng;
        this.f7400g = new HashMap();
        this.f7401h = new HashSet();
        if (c2785il != null) {
            c3076tf.m1089b(handler, c2785il);
            c2915ng.m1595b(handler, c2785il);
        }
    }

    /* renamed from: p */
    private final void m2219p(int i, int i2) {
        while (i < this.f7394a.size()) {
            ((C2728gi) this.f7394a.get(i)).f7392d += i2;
            i++;
        }
    }

    /* renamed from: q */
    private final void m2218q(C2728gi c2728gi) {
        C2727gh c2727gh = (C2727gh) this.f7400g.get(c2728gi);
        if (c2727gh != null) {
            c2727gh.f7386a.mo1101A(c2727gh.f7387b);
        }
    }

    /* renamed from: r */
    private final void m2217r() {
        Iterator it = this.f7401h.iterator();
        while (it.hasNext()) {
            C2728gi c2728gi = (C2728gi) it.next();
            if (c2728gi.f7391c.isEmpty()) {
                m2218q(c2728gi);
                it.remove();
            }
        }
    }

    /* renamed from: s */
    private final void m2216s(C2728gi c2728gi) {
        if (c2728gi.f7393e && c2728gi.f7391c.isEmpty()) {
            C2727gh c2727gh = (C2727gh) this.f7400g.remove(c2728gi);
            C2616ce.m2689d(c2727gh);
            c2727gh.f7386a.mo1098G(c2727gh.f7387b);
            c2727gh.f7386a.mo1096I(c2727gh.f7388c);
            c2727gh.f7386a.mo1097H(c2727gh.f7388c);
            this.f7401h.remove(c2728gi);
        }
    }

    /* renamed from: t */
    private final void m2215t(C2728gi c2728gi) {
        C3063st c3063st = c2728gi.f7389a;
        InterfaceC3068sy interfaceC3068sy = new InterfaceC3068sy() { // from class: com.google.ads.interactivemedia.v3.internal.gf
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3068sy
            /* renamed from: a */
            public final void mo1102a(InterfaceC3069sz interfaceC3069sz, AbstractC2586bb abstractC2586bb) {
                C2730gk.this.m2221n();
            }
        };
        C2726gg c2726gg = new C2726gg(this, c2728gi);
        this.f7400g.put(c2728gi, new C2727gh(c3063st, interfaceC3068sy, c2726gg));
        c3063st.mo1092z(C2628cq.m2581B(), c2726gg);
        c3063st.mo1093y(C2628cq.m2581B(), c2726gg);
        c3063st.mo1099E(interfaceC3068sy, this.f7403j);
    }

    /* renamed from: u */
    private final void m2214u(int i, int i2) {
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            }
            C2728gi c2728gi = (C2728gi) this.f7394a.remove(i2);
            this.f7396c.remove(c2728gi.f7390b);
            m2219p(i2, -c2728gi.f7389a.m1108j().mo923c());
            c2728gi.f7393e = true;
            if (this.f7402i) {
                m2216s(c2728gi);
            }
        }
    }

    /* renamed from: a */
    public final int m2234a() {
        return this.f7394a.size();
    }

    /* renamed from: b */
    public final AbstractC2586bb m2233b() {
        if (this.f7394a.isEmpty()) {
            return AbstractC2586bb.f5384a;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f7394a.size(); i2++) {
            C2728gi c2728gi = (C2728gi) this.f7394a.get(i2);
            c2728gi.f7392d = i;
            i += c2728gi.f7389a.m1108j().mo923c();
        }
        return new C2735gp(this.f7394a, this.f7404k);
    }

    /* renamed from: e */
    public final void m2230e(InterfaceC2659du interfaceC2659du) {
        C2616ce.m2685h(!this.f7402i);
        this.f7403j = interfaceC2659du;
        for (int i = 0; i < this.f7394a.size(); i++) {
            C2728gi c2728gi = (C2728gi) this.f7394a.get(i);
            m2215t(c2728gi);
            this.f7401h.add(c2728gi);
        }
        this.f7402i = true;
    }

    /* renamed from: f */
    public final void m2229f() {
        for (C2727gh c2727gh : this.f7400g.values()) {
            try {
                c2727gh.f7386a.mo1098G(c2727gh.f7387b);
            } catch (RuntimeException e) {
                C2613cb.m2698a("MediaSourceList", "Failed to release child source.", e);
            }
            c2727gh.f7386a.mo1096I(c2727gh.f7388c);
            c2727gh.f7386a.mo1097H(c2727gh.f7388c);
        }
        this.f7400g.clear();
        this.f7401h.clear();
        this.f7402i = false;
    }

    /* renamed from: g */
    public final void m2228g(InterfaceC3066sw interfaceC3066sw) {
        C2728gi c2728gi = (C2728gi) this.f7395b.remove(interfaceC3066sw);
        C2616ce.m2689d(c2728gi);
        c2728gi.f7389a.mo1006o(interfaceC3066sw);
        c2728gi.f7391c.remove(((C3060sq) interfaceC3066sw).f8854a);
        if (!this.f7395b.isEmpty()) {
            m2217r();
        }
        m2216s(c2728gi);
    }

    /* renamed from: h */
    public final boolean m2227h() {
        return this.f7402i;
    }

    /* renamed from: i */
    public final AbstractC2586bb m2226i(int i, List list, C3101ud c3101ud) {
        if (!list.isEmpty()) {
            this.f7404k = c3101ud;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                C2728gi c2728gi = (C2728gi) list.get(i2 - i);
                if (i2 > 0) {
                    C2728gi c2728gi2 = (C2728gi) this.f7394a.get(i2 - 1);
                    c2728gi.m2236c(c2728gi2.f7392d + c2728gi2.f7389a.m1108j().mo923c());
                } else {
                    c2728gi.m2236c(0);
                }
                m2219p(i2, c2728gi.f7389a.m1108j().mo923c());
                this.f7394a.add(i2, c2728gi);
                this.f7396c.put(c2728gi.f7390b, c2728gi);
                if (this.f7402i) {
                    m2215t(c2728gi);
                    if (this.f7395b.isEmpty()) {
                        this.f7401h.add(c2728gi);
                    } else {
                        m2218q(c2728gi);
                    }
                }
            }
        }
        return m2233b();
    }

    /* renamed from: j */
    public final AbstractC2586bb m2225j(int i, int i2, C3101ud c3101ud) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= m2234a()) {
            z = true;
        }
        C2616ce.m2687f(z);
        this.f7404k = c3101ud;
        m2214u(i, i2);
        return m2233b();
    }

    /* renamed from: k */
    public final AbstractC2586bb m2224k(List list, C3101ud c3101ud) {
        m2214u(0, this.f7394a.size());
        return m2226i(this.f7394a.size(), list, c3101ud);
    }

    /* renamed from: l */
    public final AbstractC2586bb m2223l(C3101ud c3101ud) {
        int m2234a = m2234a();
        if (c3101ud.m931c() != m2234a) {
            c3101ud = c3101ud.m928f().m927g(0, m2234a);
        }
        this.f7404k = c3101ud;
        return m2233b();
    }

    /* renamed from: m */
    public final InterfaceC3066sw m2222m(C3067sx c3067sx, C3154wc c3154wc, long j) {
        Object y = C2735gp.m2440y(c3067sx.f4115a);
        C3067sx m1103c = c3067sx.m1103c(C2735gp.m2441x(c3067sx.f4115a));
        C2728gi c2728gi = (C2728gi) this.f7396c.get(y);
        C2616ce.m2689d(c2728gi);
        this.f7401h.add(c2728gi);
        C2727gh c2727gh = (C2727gh) this.f7400g.get(c2728gi);
        if (c2727gh != null) {
            c2727gh.f7386a.mo1100C(c2727gh.f7387b);
        }
        c2728gi.f7391c.add(m1103c);
        C3060sq mo1004q = c2728gi.f7389a.mo1004q(m1103c, c3154wc, j);
        this.f7395b.put(mo1004q, c2728gi);
        m2217r();
        return mo1004q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public final /* synthetic */ void m2221n() {
        this.f7397d.mo2235h();
    }

    /* renamed from: o */
    public final AbstractC2586bb m2220o() {
        C2616ce.m2687f(m2234a() >= 0);
        this.f7404k = null;
        return m2233b();
    }
}
