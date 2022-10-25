package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Looper;
import android.util.SparseArray;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import java.io.IOException;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.il */
/* loaded from: classes2.dex */
public final class C2785il implements InterfaceC2565au, InterfaceC2802jb, InterfaceC3203xy, InterfaceC3077tg, InterfaceC3152wa, InterfaceC2916nh {

    /* renamed from: a */
    private final InterfaceC2598bn f7591a;

    /* renamed from: b */
    private final C2583az f7592b;

    /* renamed from: c */
    private final C2585ba f7593c;

    /* renamed from: d */
    private final C2784ik f7594d;

    /* renamed from: e */
    private final SparseArray f7595e;

    /* renamed from: f */
    private C2612ca f7596f;

    /* renamed from: g */
    private InterfaceC2567aw f7597g;

    /* renamed from: h */
    private InterfaceC2605bu f7598h;

    /* renamed from: i */
    private boolean f7599i;

    public C2785il(InterfaceC2598bn interfaceC2598bn) {
        C2616ce.m2689d(interfaceC2598bn);
        this.f7591a = interfaceC2598bn;
        this.f7596f = new C2612ca(C2628cq.m2580C(), interfaceC2598bn, C2782ii.f7583a);
        C2583az c2583az = new C2583az();
        this.f7592b = c2583az;
        this.f7593c = new C2585ba();
        this.f7594d = new C2784ik(c2583az);
        this.f7595e = new SparseArray();
    }

    /* renamed from: S */
    public static /* synthetic */ void m2076S(C2785il c2785il) {
        C2786im m2078Q = c2785il.m2078Q();
        c2785il.m2070Z(m2078Q, AnalyticsListener.EVENT_PLAYER_RELEASED, new C2759hm(m2078Q, 5));
        c2785il.f7596f.m2702e();
    }

    /* renamed from: ac */
    private final C2786im m2066ac(C3067sx c3067sx) {
        C2616ce.m2689d(this.f7597g);
        AbstractC2586bb m2091a = c3067sx == null ? null : this.f7594d.m2091a(c3067sx);
        if (c3067sx == null || m2091a == null) {
            int mo2129g = this.f7597g.mo2129g();
            AbstractC2586bb mo2124l = this.f7597g.mo2124l();
            if (mo2129g >= mo2124l.mo923c()) {
                mo2124l = AbstractC2586bb.f5384a;
            }
            return m2077R(mo2124l, mo2129g, null);
        }
        return m2077R(m2091a, m2091a.mo2442n(c3067sx.f4115a, this.f7592b).f5314c, c3067sx);
    }

    /* renamed from: ad */
    private final C2786im m2065ad(int i, C3067sx c3067sx) {
        C2616ce.m2689d(this.f7597g);
        if (c3067sx != null) {
            if (this.f7594d.m2091a(c3067sx) != null) {
                return m2066ac(c3067sx);
            }
            return m2077R(AbstractC2586bb.f5384a, i, c3067sx);
        }
        AbstractC2586bb mo2124l = this.f7597g.mo2124l();
        if (i >= mo2124l.mo923c()) {
            mo2124l = AbstractC2586bb.f5384a;
        }
        return m2077R(mo2124l, i, null);
    }

    /* renamed from: ae */
    private final C2786im m2064ae() {
        return m2066ac(this.f7594d.m2088d());
    }

    /* renamed from: af */
    private final C2786im m2063af() {
        return m2066ac(this.f7594d.m2087e());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: A */
    public final void mo1953A(String str) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, 1013, new C2777id(m2063af, str, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: B */
    public final void mo1952B(C2679en c2679en) {
        C2786im m2064ae = m2064ae();
        m2070Z(m2064ae, 1014, new C2770hx(m2064ae, c2679en, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: C */
    public final void mo1951C(C2679en c2679en) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, 1008, new C2770hx(m2063af, c2679en, 0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: D */
    public final void mo1950D(C2962p c2962p, C2680eo c2680eo) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, 1010, new C2761ho(m2063af, c2962p, c2680eo, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: E */
    public final void mo1949E(final long j) {
        final C2786im m2063af = m2063af();
        m2070Z(m2063af, 1011, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.hl
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                ((InterfaceC2787in) obj).mo1990j();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: F */
    public final void mo1948F(Exception exc) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, 1018, new C2775ib(m2063af, exc, 0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: G */
    public final void mo1947G(int i, long j, long j2) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, 1012, new C2756hj(m2063af, i, j, j2, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: H */
    public final void mo574H(int i, long j) {
        C2786im m2064ae = m2064ae();
        m2070Z(m2064ae, AnalyticsListener.EVENT_DROPPED_VIDEO_FRAMES, new C2760hn(m2064ae, i, j, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: I */
    public final void mo573I(final Object obj, final long j) {
        final C2786im m2063af = m2063af();
        m2070Z(m2063af, AnalyticsListener.EVENT_RENDERED_FIRST_FRAME, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.ic
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj2) {
                ((InterfaceC2787in) obj2).mo2019S();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: J */
    public final void mo572J(Exception exc) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, AnalyticsListener.EVENT_VIDEO_CODEC_ERROR, new C2775ib(m2063af, exc, 3));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: K */
    public final void mo571K(String str, long j, long j2) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, 1021, new C2778ie(m2063af, str, j2, j, 0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: L */
    public final void mo570L(String str) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, 1024, new C2777id(m2063af, str, 0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: M */
    public final void mo569M(C2679en c2679en) {
        C2786im m2064ae = m2064ae();
        m2070Z(m2064ae, 1025, new C2770hx(m2064ae, c2679en, 2));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: N */
    public final void mo568N(C2679en c2679en) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, 1020, new C2770hx(m2063af, c2679en, 3));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: O */
    public final void mo567O(long j, int i) {
        C2786im m2064ae = m2064ae();
        m2070Z(m2064ae, AnalyticsListener.EVENT_VIDEO_FRAME_PROCESSING_OFFSET, new C2760hn(m2064ae, j, i, 0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: P */
    public final void mo566P(C2962p c2962p, C2680eo c2680eo) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, AnalyticsListener.EVENT_VIDEO_INPUT_FORMAT_CHANGED, new C2761ho(m2063af, c2962p, c2680eo, 0));
    }

    /* renamed from: Q */
    protected final C2786im m2078Q() {
        return m2066ac(this.f7594d.m2090b());
    }

    /* renamed from: R */
    protected final C2786im m2077R(AbstractC2586bb abstractC2586bb, int i, C3067sx c3067sx) {
        boolean z = true;
        C3067sx c3067sx2 = true == abstractC2586bb.m4204p() ? null : c3067sx;
        long mo2615a = this.f7591a.mo2615a();
        z = (abstractC2586bb.equals(this.f7597g.mo2124l()) && i == this.f7597g.mo2129g()) ? false : false;
        long j = 0;
        if (c3067sx2 == null || !c3067sx2.m5216b()) {
            if (z) {
                j = this.f7597g.mo2127i();
            } else if (!abstractC2586bb.m4204p()) {
                j = abstractC2586bb.m4205o(i, this.f7593c).m4251a();
            }
        } else if (z && this.f7597g.mo2131e() == c3067sx2.f4116b && this.f7597g.mo2130f() == c3067sx2.f4117c) {
            j = this.f7597g.mo2126j();
        }
        return new C2786im(mo2615a, abstractC2586bb, i, c3067sx2, j, this.f7597g.mo2124l(), this.f7597g.mo2129g(), this.f7594d.m2090b(), this.f7597g.mo2126j(), this.f7597g.mo2125k());
    }

    /* renamed from: T */
    public final void m2075T(InterfaceC2787in interfaceC2787in) {
        C2616ce.m2689d(interfaceC2787in);
        this.f7596f.m2705b(interfaceC2787in);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: U */
    public final /* synthetic */ void m2074U(InterfaceC2567aw interfaceC2567aw, InterfaceC2787in interfaceC2787in, C2908n c2908n) {
        new C2742gw(c2908n, this.f7595e);
        interfaceC2787in.mo2037A();
    }

    /* renamed from: V */
    public final void m2073V() {
        if (this.f7599i) {
            return;
        }
        C2786im m2078Q = m2078Q();
        this.f7599i = true;
        m2070Z(m2078Q, -1, new C2759hm(m2078Q, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3152wa
    /* renamed from: W */
    public final void mo769W(int i, long j, long j2) {
        C2786im m2066ac = m2066ac(this.f7594d.m2089c());
        m2070Z(m2066ac, 1006, new C2756hj(m2066ac, i, j, j2, 0));
    }

    /* renamed from: X */
    public final void m2072X() {
        InterfaceC2605bu interfaceC2605bu = this.f7598h;
        C2616ce.m2688e(interfaceC2605bu);
        interfaceC2605bu.mo2605e(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.ij
            @Override // java.lang.Runnable
            public final void run() {
                C2785il.m2076S(C2785il.this);
            }
        });
    }

    /* renamed from: Y */
    public final void m2071Y(InterfaceC2787in interfaceC2787in) {
        this.f7596f.m2701f(interfaceC2787in);
    }

    /* renamed from: Z */
    protected final void m2070Z(C2786im c2786im, int i, InterfaceC2608bx interfaceC2608bx) {
        this.f7595e.put(i, c2786im);
        this.f7596f.m2700g(i, interfaceC2608bx);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: a */
    public final void mo2069a(final C2561as c2561as) {
        final C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 13, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.ht
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                ((InterfaceC2787in) obj).mo1987m();
            }
        });
    }

    /* renamed from: aa */
    public final void m2068aa(final InterfaceC2567aw interfaceC2567aw, Looper looper) {
        boolean z = true;
        if (this.f7597g != null && !C2784ik.m2086f(this.f7594d).isEmpty()) {
            z = false;
        }
        C2616ce.m2685h(z);
        this.f7597g = interfaceC2567aw;
        this.f7598h = this.f7591a.mo2614b(looper, null);
        this.f7596f = this.f7596f.m2706a(looper, new InterfaceC2609by() { // from class: com.google.ads.interactivemedia.v3.internal.ih
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2609by
            /* renamed from: a */
            public final void mo2092a(Object obj, C2908n c2908n) {
                C2785il.this.m2074U(interfaceC2567aw, (InterfaceC2787in) obj, c2908n);
            }
        });
    }

    /* renamed from: ab */
    public final void m2067ab(List list, C3067sx c3067sx) {
        C2784ik c2784ik = this.f7594d;
        InterfaceC2567aw interfaceC2567aw = this.f7597g;
        C2616ce.m2689d(interfaceC2567aw);
        c2784ik.m2084h(list, c3067sx, interfaceC2567aw);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: ag */
    public final void mo1070ag(int i, C3067sx c3067sx, C3064su c3064su) {
        C2786im m2065ad = m2065ad(i, c3067sx);
        m2070Z(m2065ad, 1004, new C2774ia(m2065ad, c3064su, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: ah */
    public final void mo2062ah(boolean z) {
        C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 3, new C2779if(m2078Q, z, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: ai */
    public final void mo2061ai(boolean z) {
        C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 7, new C2779if(m2078Q, z, 0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: aj */
    public final void mo2060aj(final C2543ae c2543ae, final int i) {
        final C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 1, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.hp
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                ((InterfaceC2787in) obj).mo2029I();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: ak */
    public final void mo2059ak(final C2546ah c2546ah) {
        final C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 14, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.hq
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                ((InterfaceC2787in) obj).mo2028J();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: al */
    public final void mo2058al(boolean z, int i) {
        C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 5, new C2780ig(m2078Q, z, i, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: am */
    public final void mo2057am(final C2559aq c2559aq) {
        final C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 12, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.hs
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                ((InterfaceC2787in) obj).mo2026L();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: an */
    public final void mo2056an(int i) {
        C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 4, new C2754hh(m2078Q, i, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: ao */
    public final void mo2055ao(int i) {
        C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 6, new C2754hh(m2078Q, i, 0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: ap */
    public final void mo2054ap(final C2556ap c2556ap) {
        C2547ai c2547ai;
        final C2786im c2786im = null;
        if ((c2556ap instanceof C2685et) && (c2547ai = ((C2685et) c2556ap).f7181h) != null) {
            c2786im = m2066ac(new C3067sx(c2547ai));
        }
        if (c2786im == null) {
            c2786im = m2078Q();
        }
        m2070Z(c2786im, 10, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.hr
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                ((InterfaceC2787in) obj).mo2011a(C2786im.this, c2556ap);
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: aq */
    public final void mo1069aq(int i, C3067sx c3067sx, C3064su c3064su) {
        C2786im m2065ad = m2065ad(i, c3067sx);
        m2070Z(m2065ad, 1005, new C2774ia(m2065ad, c3064su, 0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2565au
    /* renamed from: ar */
    public final /* synthetic */ void mo2053ar() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2565au
    /* renamed from: as */
    public final /* synthetic */ void mo2052as() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: at */
    public final /* synthetic */ void mo1172at() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: b */
    public final void mo1171b(int i, C3067sx c3067sx) {
        C2786im m2065ad = m2065ad(i, c3067sx);
        m2070Z(m2065ad, AnalyticsListener.EVENT_DRM_KEYS_LOADED, new C2759hm(m2065ad, 0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: c */
    public final void mo1170c(int i, C3067sx c3067sx) {
        C2786im m2065ad = m2065ad(i, c3067sx);
        m2070Z(m2065ad, AnalyticsListener.EVENT_DRM_KEYS_RESTORED, new C2759hm(m2065ad, 2));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: d */
    public final void mo1169d(int i, C3067sx c3067sx, int i2) {
        C2786im m2065ad = m2065ad(i, c3067sx);
        m2070Z(m2065ad, AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, new C2754hh(m2065ad, i2, 3));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: e */
    public final void mo1168e(int i, C3067sx c3067sx, Exception exc) {
        C2786im m2065ad = m2065ad(i, c3067sx);
        m2070Z(m2065ad, AnalyticsListener.EVENT_DRM_SESSION_MANAGER_ERROR, new C2775ib(m2065ad, exc, 2));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: f */
    public final void mo1167f(int i, C3067sx c3067sx) {
        C2786im m2065ad = m2065ad(i, c3067sx);
        m2070Z(m2065ad, AnalyticsListener.EVENT_DRM_SESSION_RELEASED, new C2759hm(m2065ad, 3));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: g */
    public final void mo1068g(int i, C3067sx c3067sx, C3059sp c3059sp, C3064su c3064su) {
        C2786im m2065ad = m2065ad(i, c3067sx);
        m2070Z(m2065ad, 1002, new C2771hy(m2065ad, c3059sp, c3064su, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: h */
    public final void mo1067h(int i, C3067sx c3067sx, C3059sp c3059sp, C3064su c3064su) {
        C2786im m2065ad = m2065ad(i, c3067sx);
        m2070Z(m2065ad, 1001, new C2771hy(m2065ad, c3059sp, c3064su, 0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: i */
    public final void mo1066i(int i, C3067sx c3067sx, final C3059sp c3059sp, final C3064su c3064su, final IOException iOException, final boolean z) {
        final C2786im m2065ad = m2065ad(i, c3067sx);
        m2070Z(m2065ad, 1003, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.hz
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                ((InterfaceC2787in) obj).mo2032F();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: j */
    public final void mo1065j(int i, C3067sx c3067sx, C3059sp c3059sp, C3064su c3064su) {
        C2786im m2065ad = m2065ad(i, c3067sx);
        m2070Z(m2065ad, 1000, new C2771hy(m2065ad, c3059sp, c3064su, 2));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: k */
    public final void mo2051k(boolean z, int i) {
        C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, -1, new C2780ig(m2078Q, z, i, 0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: l */
    public final void mo2050l(final C2566av c2566av, final C2566av c2566av2, final int i) {
        if (i == 1) {
            this.f7599i = false;
            i = 1;
        }
        C2784ik c2784ik = this.f7594d;
        InterfaceC2567aw interfaceC2567aw = this.f7597g;
        C2616ce.m2689d(interfaceC2567aw);
        c2784ik.m2085g(interfaceC2567aw);
        final C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 11, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.hk
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                int i2 = i;
                InterfaceC2787in interfaceC2787in = (InterfaceC2787in) obj;
                interfaceC2787in.mo2021Q();
                interfaceC2787in.mo2020R(i2);
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: m */
    public final void mo2049m() {
        C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, -1, new C2759hm(m2078Q, 4));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: n */
    public final void mo2048n(final C2588bd c2588bd, final C2590bf c2590bf) {
        final C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 2, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.hu
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                ((InterfaceC2787in) obj).mo2013Y();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: o */
    public final void mo2047o(final C2596bl c2596bl) {
        final C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 2, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.hv
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                ((InterfaceC2787in) obj).mo2012Z();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: p */
    public final /* synthetic */ void mo2046p() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: q */
    public final /* synthetic */ void mo2045q() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: r */
    public final /* synthetic */ void mo2044r() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: s */
    public final /* synthetic */ void mo2043s() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: t */
    public final void mo2042t(int i) {
        C2784ik c2784ik = this.f7594d;
        InterfaceC2567aw interfaceC2567aw = this.f7597g;
        C2616ce.m2689d(interfaceC2567aw);
        c2784ik.m2083i(interfaceC2567aw);
        C2786im m2078Q = m2078Q();
        m2070Z(m2078Q, 0, new C2754hh(m2078Q, i, 2));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2565au
    /* renamed from: u */
    public final /* synthetic */ void mo2041u() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2565au
    /* renamed from: v */
    public final void mo2040v(boolean z) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, 1017, new C2779if(m2063af, z, 2));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2565au
    /* renamed from: w */
    public final void mo2039w(final int i, final int i2) {
        final C2786im m2063af = m2063af();
        m2070Z(m2063af, AnalyticsListener.EVENT_SURFACE_SIZE_CHANGED, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.hi
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                ((InterfaceC2787in) obj).mo2015W();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2565au
    /* renamed from: x */
    public final void mo2038x(final C2597bm c2597bm) {
        final C2786im m2063af = m2063af();
        m2070Z(m2063af, AnalyticsListener.EVENT_VIDEO_SIZE_CHANGED, new InterfaceC2608bx() { // from class: com.google.ads.interactivemedia.v3.internal.hw
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
            /* renamed from: a */
            public final void mo2093a(Object obj) {
                C2597bm c2597bm2 = c2597bm;
                InterfaceC2787in interfaceC2787in = (InterfaceC2787in) obj;
                interfaceC2787in.mo1999al();
                int i = c2597bm2.f6057b;
                int i2 = c2597bm2.f6058c;
                int i3 = c2597bm2.f6059d;
                float f = c2597bm2.f6060e;
                interfaceC2787in.mo2000ak();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: y */
    public final void mo1945y(Exception exc) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, AnalyticsListener.EVENT_AUDIO_CODEC_ERROR, new C2775ib(m2063af, exc, 1));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: z */
    public final void mo1944z(String str, long j, long j2) {
        C2786im m2063af = m2063af();
        m2070Z(m2063af, 1009, new C2778ie(m2063af, str, j2, j, 1));
    }
}
