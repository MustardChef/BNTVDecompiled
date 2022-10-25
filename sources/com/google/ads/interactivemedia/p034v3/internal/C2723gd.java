package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.util.Pair;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.MediaPeriodQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.gd */
/* loaded from: classes2.dex */
public final class C2723gd {

    /* renamed from: a */
    private final C2583az f7368a = new C2583az();

    /* renamed from: b */
    private final C2585ba f7369b = new C2585ba();

    /* renamed from: c */
    private final C2785il f7370c;

    /* renamed from: d */
    private final Handler f7371d;

    /* renamed from: e */
    private long f7372e;

    /* renamed from: f */
    private int f7373f;

    /* renamed from: g */
    private boolean f7374g;

    /* renamed from: h */
    private C2720ga f7375h;

    /* renamed from: i */
    private C2720ga f7376i;

    /* renamed from: j */
    private C2720ga f7377j;

    /* renamed from: k */
    private int f7378k;

    /* renamed from: l */
    private Object f7379l;

    /* renamed from: m */
    private long f7380m;

    public C2723gd(C2785il c2785il, Handler handler) {
        this.f7370c = c2785il;
        this.f7371d = handler;
    }

    /* renamed from: A */
    private final boolean m2268A(AbstractC2586bb abstractC2586bb, C3067sx c3067sx) {
        if (m2266C(c3067sx)) {
            return abstractC2586bb.m4205o(abstractC2586bb.mo2442n(c3067sx.f4115a, this.f7368a).f5314c, this.f7369b).f5362p == abstractC2586bb.mo925a(c3067sx.f4115a);
        }
        return false;
    }

    /* renamed from: B */
    private final boolean m2267B(AbstractC2586bb abstractC2586bb) {
        C2720ga c2720ga = this.f7375h;
        if (c2720ga == null) {
            return true;
        }
        int mo925a = abstractC2586bb.mo925a(c2720ga.f7342b);
        while (true) {
            mo925a = abstractC2586bb.m4209i(mo925a, this.f7368a, this.f7369b, this.f7373f, this.f7374g);
            while (c2720ga.m2285i() != null && !c2720ga.f7346f.f7362g) {
                c2720ga = c2720ga.m2285i();
            }
            C2720ga m2285i = c2720ga.m2285i();
            if (mo925a == -1 || m2285i == null || abstractC2586bb.mo925a(m2285i.f7342b) != mo925a) {
                break;
            }
            c2720ga = m2285i;
        }
        boolean m2254l = m2254l(c2720ga);
        c2720ga.f7346f = m2259g(abstractC2586bb, c2720ga.f7346f);
        return !m2254l;
    }

    /* renamed from: C */
    private static final boolean m2266C(C3067sx c3067sx) {
        return !c3067sx.m5216b() && c3067sx.f4119e == -1;
    }

    /* renamed from: s */
    private final long m2247s(AbstractC2586bb abstractC2586bb, Object obj, int i) {
        abstractC2586bb.mo2442n(obj, this.f7368a);
        this.f7368a.m4295g(i);
        this.f7368a.m4293i(i);
        return 0L;
    }

    /* renamed from: t */
    private final C2721gb m2246t(AbstractC2586bb abstractC2586bb, C2720ga c2720ga, long j) {
        long j2;
        C2721gb c2721gb = c2720ga.f7346f;
        long m2290d = (c2720ga.m2290d() + c2721gb.f7360e) - j;
        if (c2721gb.f7362g) {
            long j3 = 0;
            int m4209i = abstractC2586bb.m4209i(abstractC2586bb.mo925a(c2721gb.f7356a.f4115a), this.f7368a, this.f7369b, this.f7373f, this.f7374g);
            if (m4209i == -1) {
                return null;
            }
            int i = abstractC2586bb.mo922d(m4209i, this.f7368a, true).f5314c;
            Object obj = this.f7368a.f5313b;
            long j4 = c2721gb.f7356a.f4118d;
            if (abstractC2586bb.m4205o(i, this.f7369b).f5361o == m4209i) {
                Pair m4207l = abstractC2586bb.m4207l(this.f7369b, this.f7368a, i, C3282C.TIME_UNSET, Math.max(0L, m2290d));
                if (m4207l == null) {
                    return null;
                }
                obj = m4207l.first;
                long longValue = ((Long) m4207l.second).longValue();
                C2720ga m2285i = c2720ga.m2285i();
                if (m2285i != null && m2285i.f7342b.equals(obj)) {
                    j4 = m2285i.f7346f.f7356a.f4118d;
                } else {
                    j4 = this.f7372e;
                    this.f7372e = 1 + j4;
                }
                j2 = longValue;
                j3 = C3282C.TIME_UNSET;
            } else {
                j2 = 0;
            }
            return m2245u(abstractC2586bb, m2242x(abstractC2586bb, obj, j2, j4, this.f7368a), j3, j2);
        }
        C3067sx c3067sx = c2721gb.f7356a;
        abstractC2586bb.mo2442n(c3067sx.f4115a, this.f7368a);
        if (c3067sx.m5216b()) {
            int i2 = c3067sx.f4116b;
            if (this.f7368a.m4301a(i2) == -1) {
                return null;
            }
            int m4297e = this.f7368a.m4297e(i2, c3067sx.f4117c);
            if (m4297e < 0) {
                return m2244v(abstractC2586bb, c3067sx.f4115a, i2, m4297e, c2721gb.f7358c, c3067sx.f4118d);
            }
            long j5 = c2721gb.f7358c;
            if (j5 == C3282C.TIME_UNSET) {
                C2585ba c2585ba = this.f7369b;
                C2583az c2583az = this.f7368a;
                Pair m4207l2 = abstractC2586bb.m4207l(c2585ba, c2583az, c2583az.f5314c, C3282C.TIME_UNSET, Math.max(0L, m2290d));
                if (m4207l2 == null) {
                    return null;
                }
                j5 = ((Long) m4207l2.second).longValue();
            }
            m2247s(abstractC2586bb, c3067sx.f4115a, c3067sx.f4116b);
            return m2243w(abstractC2586bb, c3067sx.f4115a, Math.max(0L, j5), c2721gb.f7358c, c3067sx.f4118d);
        }
        int m4298d = this.f7368a.m4298d(c3067sx.f4119e);
        if (m4298d == this.f7368a.m4301a(c3067sx.f4119e)) {
            m2247s(abstractC2586bb, c3067sx.f4115a, c3067sx.f4119e);
            return m2243w(abstractC2586bb, c3067sx.f4115a, 0L, c2721gb.f7360e, c3067sx.f4118d);
        }
        return m2244v(abstractC2586bb, c3067sx.f4115a, c3067sx.f4119e, m4298d, c2721gb.f7360e, c3067sx.f4118d);
    }

    /* renamed from: u */
    private final C2721gb m2245u(AbstractC2586bb abstractC2586bb, C3067sx c3067sx, long j, long j2) {
        abstractC2586bb.mo2442n(c3067sx.f4115a, this.f7368a);
        if (c3067sx.m5216b()) {
            return m2244v(abstractC2586bb, c3067sx.f4115a, c3067sx.f4116b, c3067sx.f4117c, j, c3067sx.f4118d);
        }
        return m2243w(abstractC2586bb, c3067sx.f4115a, j2, j, c3067sx.f4118d);
    }

    /* renamed from: v */
    private final C2721gb m2244v(AbstractC2586bb abstractC2586bb, Object obj, int i, int i2, long j, long j2) {
        C3067sx c3067sx = new C3067sx(obj, i, i2, j2);
        long m4296f = abstractC2586bb.mo2442n(c3067sx.f4115a, this.f7368a).m4296f(c3067sx.f4116b, c3067sx.f4117c);
        if (i2 == this.f7368a.m4298d(i)) {
            this.f7368a.m4294h();
        }
        this.f7368a.m4292j(c3067sx.f4116b);
        long j3 = 0;
        if (m4296f != C3282C.TIME_UNSET && m4296f <= 0) {
            j3 = Math.max(0L, (-1) + m4296f);
        }
        return new C2721gb(c3067sx, j3, j, C3282C.TIME_UNSET, m4296f, false, false, false, false);
    }

    /* renamed from: w */
    private final C2721gb m2243w(AbstractC2586bb abstractC2586bb, Object obj, long j, long j2, long j3) {
        long j4;
        long j5;
        long j6;
        long j7 = j;
        abstractC2586bb.mo2442n(obj, this.f7368a);
        int m4300b = this.f7368a.m4300b(j7);
        C3067sx c3067sx = new C3067sx(obj, j3, m4300b);
        boolean m2266C = m2266C(c3067sx);
        boolean m2268A = m2268A(abstractC2586bb, c3067sx);
        boolean m2240z = m2240z(abstractC2586bb, c3067sx, m2266C);
        if (m4300b != -1) {
            this.f7368a.m4292j(m4300b);
        }
        if (m4300b != -1) {
            this.f7368a.m4295g(m4300b);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != C3282C.TIME_UNSET) {
            j6 = 0;
            j5 = 0;
        } else {
            j5 = this.f7368a.f5315d;
            j6 = j4;
        }
        if (j5 != C3282C.TIME_UNSET && j7 >= j5) {
            j7 = Math.max(0L, (-1) + j5);
        }
        return new C2721gb(c3067sx, j7, j2, j6, j5, false, m2266C, m2268A, m2240z);
    }

    /* renamed from: x */
    private static C3067sx m2242x(AbstractC2586bb abstractC2586bb, Object obj, long j, long j2, C2583az c2583az) {
        abstractC2586bb.mo2442n(obj, c2583az);
        int m4299c = c2583az.m4299c(j);
        if (m4299c == -1) {
            return new C3067sx(obj, j2, c2583az.m4300b(j));
        }
        return new C3067sx(obj, m4299c, c2583az.m4298d(m4299c), j2);
    }

    /* renamed from: y */
    private final void m2241y() {
        if (this.f7370c != null) {
            final avm m4509t = avg.m4509t();
            for (C2720ga c2720ga = this.f7375h; c2720ga != null; c2720ga = c2720ga.m2285i()) {
                m4509t.m4498f(c2720ga.f7346f.f7356a);
            }
            C2720ga c2720ga2 = this.f7376i;
            final C3067sx c3067sx = c2720ga2 == null ? null : c2720ga2.f7346f.f7356a;
            this.f7371d.post(new Runnable(m4509t, c3067sx, null) { // from class: com.google.ads.interactivemedia.v3.internal.gc

                /* renamed from: b */
                public final /* synthetic */ C3067sx f7366b;

                /* renamed from: c */
                public final /* synthetic */ avm f7367c;

                @Override // java.lang.Runnable
                public final void run() {
                    C2723gd.this.m2248r(this.f7367c, this.f7366b);
                }
            });
        }
    }

    /* renamed from: z */
    private final boolean m2240z(AbstractC2586bb abstractC2586bb, C3067sx c3067sx, boolean z) {
        int mo925a = abstractC2586bb.mo925a(c3067sx.f4115a);
        return !abstractC2586bb.m4205o(abstractC2586bb.m4206m(mo925a, this.f7368a).f5314c, this.f7369b).f5355i && abstractC2586bb.m4209i(mo925a, this.f7368a, this.f7369b, this.f7373f, this.f7374g) == -1 && z;
    }

    /* renamed from: a */
    public final C2720ga m2265a() {
        C2720ga c2720ga = this.f7375h;
        if (c2720ga == null) {
            return null;
        }
        if (c2720ga == this.f7376i) {
            this.f7376i = c2720ga.m2285i();
        }
        this.f7375h.m2279o();
        int i = this.f7378k - 1;
        this.f7378k = i;
        if (i == 0) {
            this.f7377j = null;
            C2720ga c2720ga2 = this.f7375h;
            this.f7379l = c2720ga2.f7342b;
            this.f7380m = c2720ga2.f7346f.f7356a.f4118d;
        }
        this.f7375h = this.f7375h.m2285i();
        m2241y();
        return this.f7375h;
    }

    /* renamed from: b */
    public final C2720ga m2264b() {
        C2720ga c2720ga = this.f7376i;
        boolean z = false;
        if (c2720ga != null && c2720ga.m2285i() != null) {
            z = true;
        }
        C2616ce.m2685h(z);
        this.f7376i = this.f7376i.m2285i();
        m2241y();
        return this.f7376i;
    }

    /* renamed from: c */
    public final C2720ga m2263c() {
        return this.f7377j;
    }

    /* renamed from: d */
    public final C2720ga m2262d() {
        return this.f7375h;
    }

    /* renamed from: e */
    public final C2720ga m2261e() {
        return this.f7376i;
    }

    /* renamed from: f */
    public final C2721gb m2260f(long j, C2731gl c2731gl) {
        C2720ga c2720ga = this.f7377j;
        return c2720ga == null ? m2245u(c2731gl.f7406a, c2731gl.f7407b, c2731gl.f7408c, c2731gl.f7424s) : m2246t(c2731gl.f7406a, c2720ga, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.p034v3.internal.C2721gb m2259g(com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb r19, com.google.ads.interactivemedia.p034v3.internal.C2721gb r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.ads.interactivemedia.v3.internal.sx r3 = r2.f7356a
            boolean r12 = m2266C(r3)
            boolean r13 = r0.m2268A(r1, r3)
            boolean r14 = r0.m2240z(r1, r3, r12)
            com.google.ads.interactivemedia.v3.internal.sx r4 = r2.f7356a
            java.lang.Object r4 = r4.f4115a
            com.google.ads.interactivemedia.v3.internal.az r5 = r0.f7368a
            r1.mo2442n(r4, r5)
            boolean r1 = r3.m5216b()
            r4 = -1
            r5 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L37
            int r1 = r3.f4119e
            if (r1 != r4) goto L30
            goto L37
        L30:
            com.google.ads.interactivemedia.v3.internal.az r9 = r0.f7368a
            r9.m4295g(r1)
            r9 = r5
            goto L38
        L37:
            r9 = r7
        L38:
            boolean r1 = r3.m5216b()
            if (r1 == 0) goto L4b
            com.google.ads.interactivemedia.v3.internal.az r1 = r0.f7368a
            int r5 = r3.f4116b
            int r6 = r3.f4117c
            long r5 = r1.m4296f(r5, r6)
        L48:
            r7 = r9
            r9 = r5
            goto L57
        L4b:
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L52
            r7 = r5
            r9 = r7
            goto L57
        L52:
            com.google.ads.interactivemedia.v3.internal.az r1 = r0.f7368a
            long r5 = r1.f5315d
            goto L48
        L57:
            boolean r1 = r3.m5216b()
            if (r1 == 0) goto L65
            com.google.ads.interactivemedia.v3.internal.az r1 = r0.f7368a
            int r4 = r3.f4116b
            r1.m4292j(r4)
            goto L6e
        L65:
            int r1 = r3.f4119e
            if (r1 == r4) goto L6e
            com.google.ads.interactivemedia.v3.internal.az r4 = r0.f7368a
            r4.m4292j(r1)
        L6e:
            com.google.ads.interactivemedia.v3.internal.gb r15 = new com.google.ads.interactivemedia.v3.internal.gb
            long r4 = r2.f7357b
            long r1 = r2.f7358c
            r11 = 0
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2723gd.m2259g(com.google.ads.interactivemedia.v3.internal.bb, com.google.ads.interactivemedia.v3.internal.gb):com.google.ads.interactivemedia.v3.internal.gb");
    }

    /* renamed from: h */
    public final C3067sx m2258h(AbstractC2586bb abstractC2586bb, Object obj, long j) {
        long j2;
        int mo925a;
        int i = abstractC2586bb.mo2442n(obj, this.f7368a).f5314c;
        Object obj2 = this.f7379l;
        if (obj2 == null || (mo925a = abstractC2586bb.mo925a(obj2)) == -1 || abstractC2586bb.m4206m(mo925a, this.f7368a).f5314c != i) {
            C2720ga c2720ga = this.f7375h;
            while (true) {
                if (c2720ga == null) {
                    C2720ga c2720ga2 = this.f7375h;
                    while (true) {
                        if (c2720ga2 != null) {
                            int mo925a2 = abstractC2586bb.mo925a(c2720ga2.f7342b);
                            if (mo925a2 != -1 && abstractC2586bb.m4206m(mo925a2, this.f7368a).f5314c == i) {
                                j2 = c2720ga2.f7346f.f7356a.f4118d;
                                break;
                            }
                            c2720ga2 = c2720ga2.m2285i();
                        } else {
                            j2 = this.f7372e;
                            this.f7372e = 1 + j2;
                            if (this.f7375h == null) {
                                this.f7379l = obj;
                                this.f7380m = j2;
                            }
                        }
                    }
                } else if (c2720ga.f7342b.equals(obj)) {
                    j2 = c2720ga.f7346f.f7356a.f4118d;
                    break;
                } else {
                    c2720ga = c2720ga.m2285i();
                }
            }
        } else {
            j2 = this.f7380m;
        }
        return m2242x(abstractC2586bb, obj, j, j2, this.f7368a);
    }

    /* renamed from: i */
    public final void m2257i() {
        if (this.f7378k == 0) {
            return;
        }
        C2720ga c2720ga = this.f7375h;
        C2616ce.m2688e(c2720ga);
        this.f7379l = c2720ga.f7342b;
        this.f7380m = c2720ga.f7346f.f7356a.f4118d;
        while (c2720ga != null) {
            c2720ga.m2279o();
            c2720ga = c2720ga.m2285i();
        }
        this.f7375h = null;
        this.f7377j = null;
        this.f7376i = null;
        this.f7378k = 0;
        m2241y();
    }

    /* renamed from: j */
    public final void m2256j(long j) {
        C2720ga c2720ga = this.f7377j;
        if (c2720ga != null) {
            c2720ga.m2280n(j);
        }
    }

    /* renamed from: k */
    public final boolean m2255k(InterfaceC3066sw interfaceC3066sw) {
        C2720ga c2720ga = this.f7377j;
        return c2720ga != null && c2720ga.f7341a == interfaceC3066sw;
    }

    /* renamed from: l */
    public final boolean m2254l(C2720ga c2720ga) {
        boolean z = false;
        C2616ce.m2685h(c2720ga != null);
        if (c2720ga.equals(this.f7377j)) {
            return false;
        }
        this.f7377j = c2720ga;
        while (c2720ga.m2285i() != null) {
            c2720ga = c2720ga.m2285i();
            if (c2720ga == this.f7376i) {
                this.f7376i = this.f7375h;
                z = true;
            }
            c2720ga.m2279o();
            this.f7378k--;
        }
        this.f7377j.m2278p(null);
        m2241y();
        return z;
    }

    /* renamed from: m */
    public final boolean m2253m() {
        C2720ga c2720ga = this.f7377j;
        if (c2720ga != null) {
            return !c2720ga.f7346f.f7364i && c2720ga.m2276r() && this.f7377j.f7346f.f7360e != C3282C.TIME_UNSET && this.f7378k < 100;
        }
        return true;
    }

    /* renamed from: n */
    public final boolean m2252n(AbstractC2586bb abstractC2586bb, long j, long j2) {
        C2721gb c2721gb;
        boolean z;
        C2720ga c2720ga = null;
        for (C2720ga c2720ga2 = this.f7375h; c2720ga2 != null; c2720ga2 = c2720ga2.m2285i()) {
            C2721gb c2721gb2 = c2720ga2.f7346f;
            if (c2720ga == null) {
                c2721gb = m2259g(abstractC2586bb, c2721gb2);
            } else {
                C2721gb m2246t = m2246t(abstractC2586bb, c2720ga, j);
                if (m2246t == null) {
                    return !m2254l(c2720ga);
                } else if (c2721gb2.f7357b != m2246t.f7357b || !c2721gb2.f7356a.equals(m2246t.f7356a)) {
                    return !m2254l(c2720ga);
                } else {
                    c2721gb = m2246t;
                }
            }
            c2720ga2.f7346f = c2721gb.m2270a(c2721gb2.f7358c);
            long j3 = c2721gb2.f7360e;
            long j4 = c2721gb.f7360e;
            if (j3 == C3282C.TIME_UNSET || j3 == j4) {
                c2720ga = c2720ga2;
            } else {
                c2720ga2.m2277q();
                long j5 = c2721gb.f7360e;
                long m2287g = j5 == C3282C.TIME_UNSET ? Long.MAX_VALUE : c2720ga2.m2287g(j5);
                if (c2720ga2 == this.f7376i) {
                    boolean z2 = c2720ga2.f7346f.f7361f;
                    if (j2 == Long.MIN_VALUE || j2 >= m2287g) {
                        z = true;
                        return m2254l(c2720ga2) && !z;
                    }
                }
                z = false;
                if (m2254l(c2720ga2)) {
                }
            }
        }
        return true;
    }

    /* renamed from: o */
    public final boolean m2251o(AbstractC2586bb abstractC2586bb, int i) {
        this.f7373f = i;
        return m2267B(abstractC2586bb);
    }

    /* renamed from: p */
    public final boolean m2250p(AbstractC2586bb abstractC2586bb, boolean z) {
        this.f7374g = z;
        return m2267B(abstractC2586bb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public final /* synthetic */ void m2248r(avm avmVar, C3067sx c3067sx) {
        this.f7370c.m2067ab(avmVar.m4499e(), c3067sx);
    }

    /* renamed from: q */
    public final C2720ga m2249q(InterfaceC2738gs[] interfaceC2738gsArr, AbstractC3145vu abstractC3145vu, C3154wc c3154wc, C2730gk c2730gk, C2721gb c2721gb, C3146vv c3146vv) {
        C2720ga c2720ga = this.f7377j;
        C2720ga c2720ga2 = new C2720ga(interfaceC2738gsArr, c2720ga == null ? MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : (c2720ga.m2290d() + this.f7377j.f7346f.f7360e) - c2721gb.f7357b, abstractC3145vu, c3154wc, c2730gk, c2721gb, c3146vv);
        C2720ga c2720ga3 = this.f7377j;
        if (c2720ga3 != null) {
            c2720ga3.m2278p(c2720ga2);
        } else {
            this.f7375h = c2720ga2;
            this.f7376i = c2720ga2;
        }
        this.f7379l = null;
        this.f7377j = c2720ga2;
        this.f7378k++;
        m2241y();
        return c2720ga2;
    }
}
