package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C3282C;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.fm */
/* loaded from: classes2.dex */
public final class C2705fm extends AbstractC2665e {

    /* renamed from: d */
    public static final /* synthetic */ int f7235d = 0;

    /* renamed from: A */
    private final C2699fg f7236A;

    /* renamed from: B */
    private C3101ud f7237B;

    /* renamed from: b */
    final C3146vv f7238b;

    /* renamed from: c */
    final C2561as f7239c;

    /* renamed from: e */
    private final AbstractC3145vu f7240e;

    /* renamed from: f */
    private final InterfaceC2605bu f7241f;

    /* renamed from: g */
    private final C2715fw f7242g;

    /* renamed from: h */
    private final C2612ca f7243h;

    /* renamed from: i */
    private final CopyOnWriteArraySet f7244i;

    /* renamed from: j */
    private final C2583az f7245j;

    /* renamed from: k */
    private final List f7246k;

    /* renamed from: l */
    private final boolean f7247l;

    /* renamed from: m */
    private final C2785il f7248m;

    /* renamed from: n */
    private final Looper f7249n;

    /* renamed from: o */
    private final InterfaceC3153wb f7250o;

    /* renamed from: p */
    private final InterfaceC2598bn f7251p;

    /* renamed from: q */
    private int f7252q;

    /* renamed from: r */
    private int f7253r;

    /* renamed from: s */
    private boolean f7254s;

    /* renamed from: t */
    private int f7255t;

    /* renamed from: u */
    private C2561as f7256u;

    /* renamed from: v */
    private C2546ah f7257v;

    /* renamed from: w */
    private C2546ah f7258w;

    /* renamed from: x */
    private C2731gl f7259x;

    /* renamed from: y */
    private int f7260y;

    /* renamed from: z */
    private long f7261z;

    static {
        C2544af.m5676b("media3.exoplayer");
    }

    public C2705fm(InterfaceC2737gr[] interfaceC2737grArr, AbstractC3145vu abstractC3145vu, C2682eq c2682eq, InterfaceC3153wb interfaceC3153wb, C2785il c2785il, boolean z, C2740gu c2740gu, C2681ep c2681ep, long j, InterfaceC2598bn interfaceC2598bn, Looper looper, final InterfaceC2567aw interfaceC2567aw, C2561as c2561as) {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = C2628cq.f6965e;
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 36 + String.valueOf(str).length());
        sb.append("Init ");
        sb.append(hexString);
        sb.append(" [AndroidXMedia/1.0.0-alpha] [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        int length = interfaceC2737grArr.length;
        C2616ce.m2685h(true);
        InterfaceC2737gr[] interfaceC2737grArr2 = (InterfaceC2737gr[]) C2616ce.m2689d(interfaceC2737grArr);
        C2616ce.m2689d(abstractC3145vu);
        this.f7240e = abstractC3145vu;
        this.f7250o = interfaceC3153wb;
        this.f7248m = c2785il;
        this.f7247l = z;
        this.f7249n = looper;
        this.f7251p = interfaceC2598bn;
        this.f7243h = new C2612ca(looper, interfaceC2598bn, new InterfaceC2609by() { // from class: com.google.ads.interactivemedia.v3.internal.ff
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2609by
            /* renamed from: a */
            public final void mo2092a(Object obj, C2908n c2908n) {
                int i = C2705fm.f7235d;
                ((InterfaceC2564at) obj).mo2046p();
            }
        });
        this.f7244i = new CopyOnWriteArraySet();
        this.f7246k = new ArrayList();
        this.f7237B = new C3101ud();
        C3146vv c3146vv = new C3146vv(new C2739gt[2], new InterfaceC3142vr[2], C2596bl.f5989a, null);
        this.f7238b = c3146vv;
        this.f7245j = new C2583az();
        C2560ar c2560ar = new C2560ar();
        c2560ar.m4740d(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 20, 30);
        abstractC3145vu.mo788f();
        c2560ar.m4739e(29, true);
        c2560ar.m4741c(c2561as);
        C2561as m4743a = c2560ar.m4743a();
        this.f7239c = m4743a;
        C2560ar c2560ar2 = new C2560ar();
        c2560ar2.m4741c(m4743a);
        c2560ar2.m4742b(4);
        c2560ar2.m4742b(10);
        this.f7256u = c2560ar2.m4743a();
        this.f7257v = C2546ah.f4036a;
        this.f7258w = C2546ah.f4036a;
        this.f7260y = -1;
        this.f7241f = interfaceC2598bn.mo2614b(looper, null);
        C2699fg c2699fg = new C2699fg(this);
        this.f7236A = c2699fg;
        this.f7259x = C2731gl.m2206h(c3146vv);
        if (c2785il != null) {
            c2785il.m2068aa(interfaceC2567aw, looper);
            m2371v(c2785il);
            interfaceC3153wb.mo754g(new Handler(looper), c2785il);
        }
        this.f7242g = new C2715fw(interfaceC2737grArr, abstractC3145vu, c3146vv, c2682eq, interfaceC3153wb, c2785il, c2740gu, c2681ep, j, looper, interfaceC2598bn, c2699fg);
    }

    /* renamed from: I */
    private final int m2384I() {
        if (this.f7259x.f7406a.m4204p()) {
            return this.f7260y;
        }
        C2731gl c2731gl = this.f7259x;
        return c2731gl.f7406a.mo2442n(c2731gl.f7407b.f4115a, this.f7245j).f5314c;
    }

    /* renamed from: J */
    private final long m2383J(C2731gl c2731gl) {
        if (c2731gl.f7406a.m4204p()) {
            return C2628cq.m2515s(this.f7261z);
        }
        if (c2731gl.f7407b.m5216b()) {
            return c2731gl.f7424s;
        }
        return m2381L(c2731gl.f7406a, c2731gl.f7407b, c2731gl.f7424s);
    }

    /* renamed from: K */
    private static long m2382K(C2731gl c2731gl) {
        C2585ba c2585ba = new C2585ba();
        C2583az c2583az = new C2583az();
        c2731gl.f7406a.mo2442n(c2731gl.f7407b.f4115a, c2583az);
        long j = c2731gl.f7408c;
        return j == C3282C.TIME_UNSET ? c2731gl.f7406a.m4205o(c2583az.f5314c, c2585ba).f5359m : c2583az.f5316e + j;
    }

    /* renamed from: L */
    private final long m2381L(AbstractC2586bb abstractC2586bb, C3067sx c3067sx, long j) {
        abstractC2586bb.mo2442n(c3067sx.f4115a, this.f7245j);
        return j + this.f7245j.f5316e;
    }

    /* renamed from: M */
    private final Pair m2380M(AbstractC2586bb abstractC2586bb, int i, long j) {
        if (abstractC2586bb.m4204p()) {
            this.f7260y = i;
            if (j == C3282C.TIME_UNSET) {
                j = 0;
            }
            this.f7261z = j;
            return null;
        }
        if (i == -1 || i >= abstractC2586bb.mo923c()) {
            i = abstractC2586bb.mo1131g(false);
            j = abstractC2586bb.m4205o(i, this.f7080a).m4251a();
        }
        return abstractC2586bb.m4208k(this.f7080a, this.f7245j, i, C2628cq.m2515s(j));
    }

    /* renamed from: N */
    private final C2731gl m2379N(C2731gl c2731gl, AbstractC2586bb abstractC2586bb, Pair pair) {
        C3067sx c3067sx;
        C3146vv c3146vv;
        int i;
        C2731gl m2212b;
        C2616ce.m2687f(abstractC2586bb.m4204p() || pair != null);
        AbstractC2586bb abstractC2586bb2 = c2731gl.f7406a;
        C2731gl m2207g = c2731gl.m2207g(abstractC2586bb);
        if (abstractC2586bb.m4204p()) {
            C3067sx m2205i = C2731gl.m2205i();
            long m2515s = C2628cq.m2515s(this.f7261z);
            C2731gl m2213a = m2207g.m2212b(m2205i, m2515s, m2515s, m2515s, 0L, C2588bd.f5439a, this.f7238b, avg.m4515n()).m2213a(m2205i);
            m2213a.f7422q = m2213a.f7424s;
            return m2213a;
        }
        Object obj = m2207g.f7407b.f4115a;
        int i2 = C2628cq.f6961a;
        boolean z = !obj.equals(pair.first);
        C3067sx c3067sx2 = z ? new C3067sx(pair.first) : m2207g.f7407b;
        long longValue = ((Long) pair.second).longValue();
        long m2515s2 = C2628cq.m2515s(mo2127i());
        if (!abstractC2586bb2.m4204p()) {
            m2515s2 -= abstractC2586bb2.mo2442n(obj, this.f7245j).f5316e;
        }
        if (z || longValue < m2515s2) {
            C2616ce.m2685h(!c3067sx2.m5216b());
            C2588bd c2588bd = z ? C2588bd.f5439a : m2207g.f7413h;
            if (z) {
                c3067sx = c3067sx2;
                c3146vv = this.f7238b;
            } else {
                c3067sx = c3067sx2;
                c3146vv = m2207g.f7414i;
            }
            C2731gl m2213a2 = m2207g.m2212b(c3067sx, longValue, longValue, longValue, 0L, c2588bd, c3146vv, z ? avg.m4515n() : m2207g.f7415j).m2213a(c3067sx);
            m2213a2.f7422q = longValue;
            return m2213a2;
        }
        if (i == 0) {
            int mo925a = abstractC2586bb.mo925a(m2207g.f7416k.f4115a);
            if (mo925a != -1 && abstractC2586bb.m4206m(mo925a, this.f7245j).f5314c == abstractC2586bb.mo2442n(c3067sx2.f4115a, this.f7245j).f5314c) {
                return m2207g;
            }
            abstractC2586bb.mo2442n(c3067sx2.f4115a, this.f7245j);
            long m4296f = c3067sx2.m5216b() ? this.f7245j.m4296f(c3067sx2.f4116b, c3067sx2.f4117c) : this.f7245j.f5315d;
            m2212b = m2207g.m2212b(c3067sx2, m2207g.f7424s, m2207g.f7424s, m2207g.f7409d, m4296f - m2207g.f7424s, m2207g.f7413h, m2207g.f7414i, m2207g.f7415j).m2213a(c3067sx2);
            m2212b.f7422q = m4296f;
        } else {
            C2616ce.m2685h(!c3067sx2.m5216b());
            long max = Math.max(0L, m2207g.f7423r - (longValue - m2515s2));
            long j = m2207g.f7422q;
            if (m2207g.f7416k.equals(m2207g.f7407b)) {
                j = longValue + max;
            }
            m2212b = m2207g.m2212b(c3067sx2, longValue, longValue, longValue, max, m2207g.f7413h, m2207g.f7414i, m2207g.f7415j);
            m2212b.f7422q = j;
        }
        return m2212b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x0447, code lost:
        if (r6.m4205o(mo2129g(), r38.f7080a).f5355i != false) goto L105;
     */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04dd A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0289  */
    /* renamed from: O */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m2378O(final com.google.ads.interactivemedia.p034v3.internal.C2731gl r39, final int r40, final int r41, boolean r42, boolean r43, final int r44, long r45, int r47) {
        /*
            Method dump skipped, instructions count: 1246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2705fm.m2378O(com.google.ads.interactivemedia.v3.internal.gl, int, int, boolean, boolean, int, long, int):void");
    }

    /* renamed from: P */
    private static boolean m2377P(C2731gl c2731gl) {
        return c2731gl.f7410e == 3 && c2731gl.f7417l && c2731gl.f7418m == 0;
    }

    /* renamed from: A */
    public final void m2392A() {
        C2731gl c2731gl = this.f7259x;
        if (c2731gl.f7410e != 1) {
            return;
        }
        C2731gl m2209e = c2731gl.m2209e(null);
        C2731gl m2208f = m2209e.m2208f(true != m2209e.f7406a.m4204p() ? 2 : 4);
        this.f7252q++;
        this.f7242g.m2312j();
        m2378O(m2208f, 1, 1, false, false, 5, C3282C.TIME_UNSET, -1);
    }

    /* renamed from: B */
    public final void m2391B() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = C2628cq.f6965e;
        String m5677a = C2544af.m5677a();
        int length = String.valueOf(hexString).length();
        StringBuilder sb = new StringBuilder(length + 42 + String.valueOf(str).length() + String.valueOf(m5677a).length());
        sb.append("Release ");
        sb.append(hexString);
        sb.append(" [AndroidXMedia/1.0.0-alpha] [");
        sb.append(str);
        sb.append("] [");
        sb.append(m5677a);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        if (!this.f7242g.m2308o()) {
            this.f7243h.m2700g(10, C2697fe.f7223b);
        }
        this.f7243h.m2702e();
        this.f7241f.mo2604f();
        C2785il c2785il = this.f7248m;
        if (c2785il != null) {
            this.f7250o.mo753h(c2785il);
        }
        C2731gl m2208f = this.f7259x.m2208f(1);
        this.f7259x = m2208f;
        C2731gl m2213a = m2208f.m2213a(m2208f.f7407b);
        this.f7259x = m2213a;
        m2213a.f7422q = m2213a.f7424s;
        this.f7259x.f7423r = 0L;
    }

    /* renamed from: C */
    public final void m2390C(InterfaceC2564at interfaceC2564at) {
        this.f7243h.m2701f(interfaceC2564at);
    }

    /* renamed from: D */
    public final void m2389D(boolean z, int i, int i2) {
        C2731gl c2731gl = this.f7259x;
        if (c2731gl.f7417l == z && c2731gl.f7418m == i) {
            return;
        }
        this.f7252q++;
        C2731gl m2210d = c2731gl.m2210d(z, i);
        this.f7242g.m2310m(z, i);
        m2378O(m2210d, 0, i2, false, false, 5, C3282C.TIME_UNSET, -1);
    }

    /* renamed from: E */
    public final boolean m2388E() {
        return this.f7259x.f7421p;
    }

    /* renamed from: F */
    public final boolean m2387F() {
        return this.f7259x.f7417l;
    }

    /* renamed from: G */
    public final void m2386G(List list) {
        m2384I();
        mo2126j();
        this.f7252q++;
        if (!this.f7246k.isEmpty()) {
            int size = this.f7246k.size();
            for (int i = size - 1; i >= 0; i--) {
                this.f7246k.remove(i);
            }
            this.f7237B = this.f7237B.m926h(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            C2728gi c2728gi = new C2728gi((InterfaceC3069sz) list.get(i2), this.f7247l);
            arrayList.add(c2728gi);
            this.f7246k.add(i2, new C2704fl(c2728gi.f7390b, c2728gi.f7389a.m1108j()));
        }
        this.f7237B = this.f7237B.m927g(0, arrayList.size());
        C2735gp c2735gp = new C2735gp(this.f7246k, this.f7237B);
        if (c2735gp.m4204p() || c2735gp.mo923c() >= 0) {
            int mo1131g = c2735gp.mo1131g(false);
            C2731gl m2379N = m2379N(this.f7259x, c2735gp, m2380M(c2735gp, mo1131g, C3282C.TIME_UNSET));
            int i3 = m2379N.f7410e;
            if (mo1131g != -1 && i3 != 1) {
                i3 = (c2735gp.m4204p() || mo1131g >= c2735gp.mo923c()) ? 4 : 2;
            }
            C2731gl m2208f = m2379N.m2208f(i3);
            this.f7242g.m2307p(arrayList, mo1131g, C2628cq.m2515s(C3282C.TIME_UNSET), this.f7237B);
            m2378O(m2208f, 0, 1, false, (this.f7259x.f7407b.f4115a.equals(m2208f.f7407b.f4115a) || this.f7259x.f7406a.m4204p()) ? false : true, 4, m2383J(m2208f), -1);
            return;
        }
        throw new C2989q();
    }

    /* renamed from: H */
    public final void m2385H(C2685et c2685et) {
        C2731gl c2731gl = this.f7259x;
        C2731gl m2213a = c2731gl.m2213a(c2731gl.f7407b);
        m2213a.f7422q = m2213a.f7424s;
        m2213a.f7423r = 0L;
        C2731gl m2208f = m2213a.m2208f(1);
        if (c2685et != null) {
            m2208f = m2208f.m2209e(c2685et);
        }
        C2731gl c2731gl2 = m2208f;
        this.f7252q++;
        this.f7242g.m2309n();
        m2378O(c2731gl2, 0, 1, false, c2731gl2.f7406a.m4204p() && !this.f7259x.f7406a.m4204p(), 4, m2383J(c2731gl2), -1);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: e */
    public final int mo2131e() {
        if (mo2123m()) {
            return this.f7259x.f7407b.f4116b;
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: f */
    public final int mo2130f() {
        if (mo2123m()) {
            return this.f7259x.f7407b.f4117c;
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: g */
    public final int mo2129g() {
        int m2384I = m2384I();
        if (m2384I == -1) {
            return 0;
        }
        return m2384I;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: h */
    public final int mo2128h() {
        if (this.f7259x.f7406a.m4204p()) {
            return 0;
        }
        C2731gl c2731gl = this.f7259x;
        return c2731gl.f7406a.mo925a(c2731gl.f7407b.f4115a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: i */
    public final long mo2127i() {
        if (mo2123m()) {
            C2731gl c2731gl = this.f7259x;
            c2731gl.f7406a.mo2442n(c2731gl.f7407b.f4115a, this.f7245j);
            C2731gl c2731gl2 = this.f7259x;
            long j = c2731gl2.f7408c;
            if (j == C3282C.TIME_UNSET) {
                return c2731gl2.f7406a.m4205o(mo2129g(), this.f7080a).m4251a();
            }
            return C2628cq.m2511w(j) + C2628cq.m2511w(this.f7245j.f5316e);
        }
        return mo2126j();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: j */
    public final long mo2126j() {
        return C2628cq.m2511w(m2383J(this.f7259x));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: k */
    public final long mo2125k() {
        return C2628cq.m2511w(this.f7259x.f7423r);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: l */
    public final AbstractC2586bb mo2124l() {
        return this.f7259x.f7406a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: m */
    public final boolean mo2123m() {
        return this.f7259x.f7407b.m5216b();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: n */
    public final void mo2122n() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: o */
    public final void mo2121o() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: p */
    public final void mo2120p(int i) {
        AbstractC2586bb abstractC2586bb = this.f7259x.f7406a;
        if (i >= 0 && (abstractC2586bb.m4204p() || i < abstractC2586bb.mo923c())) {
            this.f7252q++;
            if (mo2123m()) {
                Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                C2712ft c2712ft = new C2712ft(this.f7259x);
                c2712ft.m2361a(1);
                this.f7236A.m2394a(c2712ft);
                return;
            }
            int i2 = m2376q() != 1 ? 2 : 1;
            int mo2129g = mo2129g();
            C2731gl m2379N = m2379N(this.f7259x.m2208f(i2), abstractC2586bb, m2380M(abstractC2586bb, i, 0L));
            this.f7242g.m2311k(abstractC2586bb, i, C2628cq.m2515s(0L));
            m2378O(m2379N, 0, 1, true, true, 1, m2383J(m2379N), mo2129g);
            return;
        }
        throw new C2989q();
    }

    /* renamed from: q */
    public final int m2376q() {
        return this.f7259x.f7410e;
    }

    /* renamed from: r */
    public final long m2375r() {
        if (!mo2123m()) {
            AbstractC2586bb l = mo2124l();
            return l.m4204p() ? C3282C.TIME_UNSET : C2628cq.m2511w(l.m4205o(mo2129g(), this.f7080a).f5360n);
        }
        C2731gl c2731gl = this.f7259x;
        C3067sx c3067sx = c2731gl.f7407b;
        c2731gl.f7406a.mo2442n(c3067sx.f4115a, this.f7245j);
        return C2628cq.m2511w(this.f7245j.m4296f(c3067sx.f4116b, c3067sx.f4117c));
    }

    /* renamed from: s */
    public final Looper m2374s() {
        return this.f7249n;
    }

    /* renamed from: t */
    public final C2734go m2373t(InterfaceC2733gn interfaceC2733gn) {
        return new C2734go(this.f7242g, interfaceC2733gn, this.f7259x.f7406a, mo2129g(), this.f7251p, this.f7242g.m2317b());
    }

    /* renamed from: u */
    public final void m2372u(InterfaceC2686eu interfaceC2686eu) {
        this.f7244i.add(interfaceC2686eu);
    }

    /* renamed from: v */
    public final void m2371v(InterfaceC2564at interfaceC2564at) {
        this.f7243h.m2705b(interfaceC2564at);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public final /* synthetic */ void m2370w(C2712ft c2712ft) {
        long j;
        boolean z;
        long j2;
        int i = this.f7252q - c2712ft.f7279b;
        this.f7252q = i;
        boolean z2 = true;
        if (c2712ft.f7280c) {
            this.f7253r = c2712ft.f7281d;
            this.f7254s = true;
        }
        if (c2712ft.f7282e) {
            this.f7255t = c2712ft.f7283f;
        }
        if (i == 0) {
            AbstractC2586bb abstractC2586bb = c2712ft.f7278a.f7406a;
            if (!this.f7259x.f7406a.m4204p() && abstractC2586bb.m4204p()) {
                this.f7260y = -1;
                this.f7261z = 0L;
            }
            if (!abstractC2586bb.m4204p()) {
                List m2189A = ((C2735gp) abstractC2586bb).m2189A();
                C2616ce.m2685h(m2189A.size() == this.f7246k.size());
                for (int i2 = 0; i2 < m2189A.size(); i2++) {
                    ((C2704fl) this.f7246k.get(i2)).f7234b = (AbstractC2586bb) m2189A.get(i2);
                }
            }
            if (this.f7254s) {
                if (c2712ft.f7278a.f7407b.equals(this.f7259x.f7407b) && c2712ft.f7278a.f7409d == this.f7259x.f7424s) {
                    z2 = false;
                }
                if (z2) {
                    if (abstractC2586bb.m4204p() || c2712ft.f7278a.f7407b.m5216b()) {
                        j2 = c2712ft.f7278a.f7409d;
                    } else {
                        C2731gl c2731gl = c2712ft.f7278a;
                        j2 = m2381L(abstractC2586bb, c2731gl.f7407b, c2731gl.f7409d);
                    }
                    j = j2;
                } else {
                    j = -9223372036854775807L;
                }
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.f7254s = false;
            m2378O(c2712ft.f7278a, 1, this.f7255t, false, z, this.f7253r, j, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public final /* synthetic */ void m2369x(final C2712ft c2712ft) {
        this.f7241f.mo2605e(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.fh
            @Override // java.lang.Runnable
            public final void run() {
                C2705fm.this.m2370w(c2712ft);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y */
    public final /* synthetic */ void m2368y(InterfaceC2564at interfaceC2564at) {
        interfaceC2564at.mo2069a(this.f7256u);
    }
}
