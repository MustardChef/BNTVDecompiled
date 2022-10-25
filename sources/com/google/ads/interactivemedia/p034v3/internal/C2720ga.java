package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.MediaPeriodQueue;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ga */
/* loaded from: classes2.dex */
final class C2720ga {

    /* renamed from: a */
    public final InterfaceC3066sw f7341a;

    /* renamed from: b */
    public final Object f7342b;

    /* renamed from: d */
    public boolean f7344d;

    /* renamed from: e */
    public boolean f7345e;

    /* renamed from: f */
    public C2721gb f7346f;

    /* renamed from: g */
    public boolean f7347g;

    /* renamed from: i */
    private final InterfaceC2738gs[] f7349i;

    /* renamed from: j */
    private final AbstractC3145vu f7350j;

    /* renamed from: k */
    private final C2730gk f7351k;

    /* renamed from: l */
    private C2720ga f7352l;

    /* renamed from: n */
    private C3146vv f7354n;

    /* renamed from: o */
    private long f7355o;

    /* renamed from: m */
    private C2588bd f7353m = C2588bd.f5439a;

    /* renamed from: c */
    public final InterfaceC3098ua[] f7343c = new InterfaceC3098ua[2];

    /* renamed from: h */
    private final boolean[] f7348h = new boolean[2];

    public C2720ga(InterfaceC2738gs[] interfaceC2738gsArr, long j, AbstractC3145vu abstractC3145vu, C3154wc c3154wc, C2730gk c2730gk, C2721gb c2721gb, C3146vv c3146vv) {
        this.f7349i = interfaceC2738gsArr;
        this.f7355o = j;
        this.f7350j = abstractC3145vu;
        this.f7351k = c2730gk;
        this.f7342b = c2721gb.f7356a.f4115a;
        this.f7346f = c2721gb;
        this.f7354n = c3146vv;
        C3067sx c3067sx = c2721gb.f7356a;
        long j2 = c2721gb.f7357b;
        long j3 = c2721gb.f7359d;
        InterfaceC3066sw m2222m = c2730gk.m2222m(c3067sx, c3154wc, j2);
        this.f7341a = j3 != C3282C.TIME_UNSET ? new C3041ry(m2222m, j3) : m2222m;
    }

    /* renamed from: u */
    private final void m2273u() {
        if (!m2271w()) {
            return;
        }
        int i = 0;
        while (true) {
            C3146vv c3146vv = this.f7354n;
            if (i >= c3146vv.f9243a) {
                return;
            }
            boolean m782b = c3146vv.m782b(i);
            InterfaceC3142vr interfaceC3142vr = this.f7354n.f9245c[i];
            if (m782b && interfaceC3142vr != null) {
                interfaceC3142vr.mo805m();
            }
            i++;
        }
    }

    /* renamed from: v */
    private final void m2272v() {
        if (!m2271w()) {
            return;
        }
        int i = 0;
        while (true) {
            C3146vv c3146vv = this.f7354n;
            if (i >= c3146vv.f9243a) {
                return;
            }
            boolean m782b = c3146vv.m782b(i);
            InterfaceC3142vr interfaceC3142vr = this.f7354n.f9245c[i];
            if (m782b && interfaceC3142vr != null) {
                interfaceC3142vr.mo804n();
            }
            i++;
        }
    }

    /* renamed from: w */
    private final boolean m2271w() {
        return this.f7352l == null;
    }

    /* renamed from: a */
    public final long m2293a(C3146vv c3146vv, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= c3146vv.f9243a) {
                break;
            }
            boolean[] zArr2 = this.f7348h;
            if (z || !c3146vv.m783a(this.f7354n, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            InterfaceC2738gs[] interfaceC2738gsArr = this.f7349i;
            if (i2 >= 2) {
                break;
            }
            interfaceC2738gsArr[i2].mo2170b();
            i2++;
        }
        m2273u();
        this.f7354n = c3146vv;
        m2272v();
        long mo1027f = this.f7341a.mo1027f(c3146vv.f9245c, this.f7348h, this.f7343c, zArr, j);
        int i3 = 0;
        while (true) {
            InterfaceC2738gs[] interfaceC2738gsArr2 = this.f7349i;
            if (i3 >= 2) {
                break;
            }
            interfaceC2738gsArr2[i3].mo2170b();
            i3++;
        }
        this.f7345e = false;
        int i4 = 0;
        while (true) {
            InterfaceC3098ua[] interfaceC3098uaArr = this.f7343c;
            if (i4 >= interfaceC3098uaArr.length) {
                return mo1027f;
            }
            if (interfaceC3098uaArr[i4] != null) {
                C2616ce.m2685h(c3146vv.m782b(i4));
                this.f7349i[i4].mo2170b();
                this.f7345e = true;
            } else {
                C2616ce.m2685h(c3146vv.f9245c[i4] == null);
            }
            i4++;
        }
    }

    /* renamed from: b */
    public final long m2292b() {
        if (this.f7344d) {
            long mo888bg = this.f7345e ? this.f7341a.mo888bg() : Long.MIN_VALUE;
            return mo888bg == Long.MIN_VALUE ? this.f7346f.f7360e : mo888bg;
        }
        return this.f7346f.f7357b;
    }

    /* renamed from: c */
    public final long m2291c() {
        if (this.f7344d) {
            return this.f7341a.mo887c();
        }
        return 0L;
    }

    /* renamed from: d */
    public final long m2290d() {
        return this.f7355o;
    }

    /* renamed from: e */
    public final long m2289e() {
        return this.f7346f.f7357b + this.f7355o;
    }

    /* renamed from: f */
    public final long m2288f(long j) {
        return j - this.f7355o;
    }

    /* renamed from: g */
    public final long m2287g(long j) {
        return j + this.f7355o;
    }

    /* renamed from: h */
    public final C2588bd m2286h() {
        return this.f7353m;
    }

    /* renamed from: i */
    public final C2720ga m2285i() {
        return this.f7352l;
    }

    /* renamed from: j */
    public final C3146vv m2284j() {
        return this.f7354n;
    }

    /* renamed from: k */
    public final C3146vv m2283k(float f, AbstractC2586bb abstractC2586bb) throws C2685et {
        InterfaceC3142vr[] interfaceC3142vrArr;
        C3146vv m785i = this.f7350j.m785i(this.f7349i, this.f7353m, this.f7346f.f7356a, abstractC2586bb);
        for (InterfaceC3142vr interfaceC3142vr : m785i.f9245c) {
            if (interfaceC3142vr != null) {
                interfaceC3142vr.mo803o(f);
            }
        }
        return m785i;
    }

    /* renamed from: l */
    public final void m2282l(long j) {
        C2616ce.m2685h(m2271w());
        this.f7341a.mo875o(m2288f(j));
    }

    /* renamed from: m */
    public final void m2281m(float f, AbstractC2586bb abstractC2586bb) throws C2685et {
        this.f7344d = true;
        this.f7353m = this.f7341a.mo1025h();
        C3146vv m2283k = m2283k(f, abstractC2586bb);
        C2721gb c2721gb = this.f7346f;
        long j = c2721gb.f7357b;
        long j2 = c2721gb.f7360e;
        if (j2 != C3282C.TIME_UNSET && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        long m2275s = m2275s(m2283k, j);
        long j3 = this.f7355o;
        C2721gb c2721gb2 = this.f7346f;
        this.f7355o = j3 + (c2721gb2.f7357b - m2275s);
        this.f7346f = c2721gb2.m2269b(m2275s);
    }

    /* renamed from: n */
    public final void m2280n(long j) {
        C2616ce.m2685h(m2271w());
        if (this.f7344d) {
            this.f7341a.mo878l(m2288f(j));
        }
    }

    /* renamed from: o */
    public final void m2279o() {
        m2273u();
        C2730gk c2730gk = this.f7351k;
        InterfaceC3066sw interfaceC3066sw = this.f7341a;
        try {
            if (interfaceC3066sw instanceof C3041ry) {
                c2730gk.m2228g(((C3041ry) interfaceC3066sw).f8791a);
            } else {
                c2730gk.m2228g(interfaceC3066sw);
            }
        } catch (RuntimeException e) {
            C2613cb.m2698a("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    /* renamed from: p */
    public final void m2278p(C2720ga c2720ga) {
        if (c2720ga == this.f7352l) {
            return;
        }
        m2273u();
        this.f7352l = c2720ga;
        m2272v();
    }

    /* renamed from: q */
    public final void m2277q() {
        InterfaceC3066sw interfaceC3066sw = this.f7341a;
        if (interfaceC3066sw instanceof C3041ry) {
            long j = this.f7346f.f7359d;
            if (j == C3282C.TIME_UNSET) {
                j = Long.MIN_VALUE;
            }
            ((C3041ry) interfaceC3066sw).m1178m(j);
        }
    }

    /* renamed from: r */
    public final boolean m2276r() {
        return this.f7344d && (!this.f7345e || this.f7341a.mo888bg() == Long.MIN_VALUE);
    }

    /* renamed from: s */
    public final long m2275s(C3146vv c3146vv, long j) {
        return m2293a(c3146vv, j, false, new boolean[2]);
    }

    /* renamed from: t */
    public final void m2274t() {
        this.f7355o = MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US;
    }
}
