package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.em */
/* loaded from: classes2.dex */
public abstract class AbstractC2678em implements InterfaceC2737gr, InterfaceC2738gs {

    /* renamed from: a */
    private final int f7116a;

    /* renamed from: c */
    private C2739gt f7118c;

    /* renamed from: d */
    private int f7119d;

    /* renamed from: e */
    private int f7120e;

    /* renamed from: f */
    private InterfaceC3098ua f7121f;

    /* renamed from: g */
    private C2962p[] f7122g;

    /* renamed from: h */
    private long f7123h;

    /* renamed from: j */
    private boolean f7125j;

    /* renamed from: k */
    private boolean f7126k;

    /* renamed from: b */
    private final C2717fy f7117b = new C2717fy();

    /* renamed from: i */
    private long f7124i = Long.MIN_VALUE;

    public AbstractC2678em(int i) {
        this.f7116a = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: A */
    public final void mo2186A() {
        this.f7125j = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: B */
    public final void mo2185B(int i) {
        this.f7119d = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: C */
    public /* synthetic */ void mo668C(float f, float f2) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: D */
    public final void mo2184D() throws C2685et {
        C2616ce.m2685h(this.f7120e == 1);
        this.f7120e = 2;
        mo622v();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: E */
    public final void mo2183E() {
        C2616ce.m2685h(this.f7120e == 2);
        this.f7120e = 1;
        mo621w();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: F */
    public final boolean mo2182F() {
        return this.f7124i == Long.MIN_VALUE;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: G */
    public final boolean mo2181G() {
        return this.f7125j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: H */
    public final boolean m2430H() {
        if (mo2182F()) {
            return this.f7125j;
        }
        InterfaceC3098ua interfaceC3098ua = this.f7121f;
        C2616ce.m2689d(interfaceC3098ua);
        return interfaceC3098ua.mo883g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: I */
    public final C2962p[] m2429I() {
        return (C2962p[]) C2616ce.m2689d(this.f7122g);
    }

    /* renamed from: J */
    protected void mo848J(long j, long j2) throws C2685et {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: aY */
    public final int mo2180aY() {
        return this.f7120e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aZ */
    public final int m2428aZ(C2717fy c2717fy, C2669ed c2669ed, int i) {
        InterfaceC3098ua interfaceC3098ua = this.f7121f;
        C2616ce.m2689d(interfaceC3098ua);
        int mo890a = interfaceC3098ua.mo890a(c2717fy, c2669ed, i);
        if (mo890a == -4) {
            if (c2669ed.m2462g()) {
                this.f7124i = Long.MIN_VALUE;
                return this.f7125j ? -4 : -3;
            }
            long j = c2669ed.f7094d + this.f7123h;
            c2669ed.f7094d = j;
            this.f7124i = Math.max(this.f7124i, j);
        } else if (mo890a == -5) {
            C2962p c2962p = c2717fy.f7335b;
            C2616ce.m2689d(c2962p);
            long j2 = c2962p.f8376p;
            if (j2 != Long.MAX_VALUE) {
                C2935o m1426b = c2962p.m1426b();
                m1426b.m1528ai(j2 + this.f7123h);
                c2717fy.f7335b = m1426b.m1506v();
                return -5;
            }
        }
        return mo890a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2738gs
    /* renamed from: b */
    public final int mo2170b() {
        return this.f7116a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ba */
    public final C2685et m2427ba(Throwable th, C2962p c2962p, int i) {
        return m2425h(th, c2962p, false, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final int m2426d(long j) {
        InterfaceC3098ua interfaceC3098ua = this.f7121f;
        C2616ce.m2689d(interfaceC3098ua);
        return interfaceC3098ua.mo889b(j - this.f7123h);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2738gs
    /* renamed from: e */
    public int mo1221e() throws C2685et {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: f */
    public final long mo2179f() {
        return this.f7124i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public final C2685et m2425h(Throwable th, C2962p c2962p, boolean z, int i) {
        int i2;
        if (c2962p != null && !this.f7126k) {
            this.f7126k = true;
            try {
                int m2166b = C2742gw.m2166b(mo845O(c2962p));
                this.f7126k = false;
                i2 = m2166b;
            } catch (C2685et unused) {
                this.f7126k = false;
            } catch (Throwable th2) {
                this.f7126k = false;
                throw th2;
            }
            return C2685et.m2397b(th, mo667K(), this.f7119d, c2962p, i2, z, i);
        }
        i2 = 4;
        return C2685et.m2397b(th, mo667K(), this.f7119d, c2962p, i2, z, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public final C2717fy m2424i() {
        this.f7117b.m2296a();
        return this.f7117b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: j */
    public InterfaceC2718fz mo1829j() {
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: k */
    public final InterfaceC2738gs mo2178k() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public final C2739gt m2423l() {
        C2739gt c2739gt = this.f7118c;
        C2616ce.m2689d(c2739gt);
        return c2739gt;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: m */
    public final InterfaceC3098ua mo2177m() {
        return this.f7121f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: n */
    public final void mo2176n() {
        C2616ce.m2685h(this.f7120e == 1);
        this.f7117b.m2296a();
        this.f7120e = 0;
        this.f7121f = null;
        this.f7122g = null;
        this.f7125j = false;
        mo626r();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: o */
    public final void mo2175o(C2739gt c2739gt, C2962p[] c2962pArr, InterfaceC3098ua interfaceC3098ua, long j, boolean z, boolean z2, long j2, long j3) throws C2685et {
        C2616ce.m2685h(this.f7120e == 0);
        this.f7118c = c2739gt;
        this.f7120e = 1;
        mo625s(z, z2);
        mo2173x(c2962pArr, interfaceC3098ua, j2, j3);
        mo624t(j, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2733gn
    /* renamed from: p */
    public void mo627p(int i, Object obj) throws C2685et {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: q */
    public final void mo2174q() throws IOException {
        InterfaceC3098ua interfaceC3098ua = this.f7121f;
        C2616ce.m2689d(interfaceC3098ua);
        interfaceC3098ua.mo886d();
    }

    /* renamed from: r */
    protected void mo626r() {
        throw null;
    }

    /* renamed from: s */
    protected void mo625s(boolean z, boolean z2) throws C2685et {
    }

    /* renamed from: t */
    protected void mo624t(long j, boolean z) throws C2685et {
        throw null;
    }

    /* renamed from: u */
    protected void mo623u() {
    }

    /* renamed from: v */
    protected void mo622v() throws C2685et {
    }

    /* renamed from: w */
    protected void mo621w() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: x */
    public final void mo2173x(C2962p[] c2962pArr, InterfaceC3098ua interfaceC3098ua, long j, long j2) throws C2685et {
        C2616ce.m2685h(!this.f7125j);
        this.f7121f = interfaceC3098ua;
        if (this.f7124i == Long.MIN_VALUE) {
            this.f7124i = j;
        }
        this.f7122g = c2962pArr;
        this.f7123h = j2;
        mo848J(j, j2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: y */
    public final void mo2172y() {
        C2616ce.m2685h(this.f7120e == 0);
        this.f7117b.m2296a();
        mo623u();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: z */
    public final void mo2171z(long j) throws C2685et {
        this.f7125j = false;
        this.f7124i = j;
        mo624t(j, false);
    }
}
