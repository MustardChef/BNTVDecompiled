package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.MediaPeriodQueue;
import com.google.android.exoplayer2.PlaybackException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.fw */
/* loaded from: classes2.dex */
public final class C2715fw implements Handler.Callback, InterfaceC3065sv, InterfaceC2729gj, InterfaceC2683er, InterfaceC2732gm {

    /* renamed from: C */
    private boolean f7296C;

    /* renamed from: D */
    private boolean f7297D;

    /* renamed from: E */
    private boolean f7298E;

    /* renamed from: F */
    private int f7299F;

    /* renamed from: G */
    private C2714fv f7300G;

    /* renamed from: H */
    private long f7301H;

    /* renamed from: I */
    private int f7302I;

    /* renamed from: J */
    private boolean f7303J;

    /* renamed from: K */
    private C2685et f7304K;

    /* renamed from: L */
    private final C2682eq f7305L;

    /* renamed from: M */
    private final C2699fg f7306M;

    /* renamed from: N */
    private final C2681ep f7307N;

    /* renamed from: a */
    private final InterfaceC2737gr[] f7308a;

    /* renamed from: b */
    private final Set f7309b;

    /* renamed from: c */
    private final InterfaceC2738gs[] f7310c;

    /* renamed from: d */
    private final AbstractC3145vu f7311d;

    /* renamed from: e */
    private final C3146vv f7312e;

    /* renamed from: f */
    private final InterfaceC3153wb f7313f;

    /* renamed from: g */
    private final InterfaceC2605bu f7314g;

    /* renamed from: h */
    private final HandlerThread f7315h;

    /* renamed from: i */
    private final Looper f7316i;

    /* renamed from: j */
    private final C2585ba f7317j;

    /* renamed from: k */
    private final C2583az f7318k;

    /* renamed from: l */
    private final long f7319l;

    /* renamed from: m */
    private final C2684es f7320m;

    /* renamed from: n */
    private final ArrayList f7321n;

    /* renamed from: o */
    private final InterfaceC2598bn f7322o;

    /* renamed from: p */
    private final C2723gd f7323p;

    /* renamed from: q */
    private final C2730gk f7324q;

    /* renamed from: r */
    private final long f7325r;

    /* renamed from: s */
    private C2740gu f7326s;

    /* renamed from: t */
    private C2731gl f7327t;

    /* renamed from: u */
    private C2712ft f7328u;

    /* renamed from: v */
    private boolean f7329v;

    /* renamed from: x */
    private boolean f7331x;

    /* renamed from: y */
    private boolean f7332y;

    /* renamed from: z */
    private boolean f7333z;

    /* renamed from: A */
    private int f7294A = 0;

    /* renamed from: B */
    private boolean f7295B = false;

    /* renamed from: w */
    private boolean f7330w = false;

    public C2715fw(InterfaceC2737gr[] interfaceC2737grArr, AbstractC3145vu abstractC3145vu, C3146vv c3146vv, C2682eq c2682eq, InterfaceC3153wb interfaceC3153wb, C2785il c2785il, C2740gu c2740gu, C2681ep c2681ep, long j, Looper looper, InterfaceC2598bn interfaceC2598bn, C2699fg c2699fg) {
        this.f7306M = c2699fg;
        this.f7308a = interfaceC2737grArr;
        this.f7311d = abstractC3145vu;
        this.f7312e = c3146vv;
        this.f7305L = c2682eq;
        this.f7313f = interfaceC3153wb;
        int i = 0;
        this.f7326s = c2740gu;
        this.f7307N = c2681ep;
        this.f7325r = j;
        this.f7322o = interfaceC2598bn;
        this.f7319l = c2682eq.m2414a();
        C2731gl m2206h = C2731gl.m2206h(c3146vv);
        this.f7327t = m2206h;
        this.f7328u = new C2712ft(m2206h);
        int length = interfaceC2737grArr.length;
        this.f7310c = new InterfaceC2738gs[2];
        while (true) {
            int length2 = interfaceC2737grArr.length;
            if (i < 2) {
                interfaceC2737grArr[i].mo2185B(i);
                this.f7310c[i] = interfaceC2737grArr[i].mo2178k();
                i++;
            } else {
                this.f7320m = new C2684es(this, interfaceC2598bn);
                this.f7321n = new ArrayList();
                this.f7309b = axd.m4407e();
                this.f7317j = new C2585ba();
                this.f7318k = new C2583az();
                abstractC3145vu.m784j(interfaceC3153wb);
                this.f7303J = true;
                Handler handler = new Handler(looper);
                this.f7323p = new C2723gd(c2785il, handler);
                this.f7324q = new C2730gk(this, c2785il, handler);
                HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                this.f7315h = handlerThread;
                handlerThread.start();
                Looper looper2 = handlerThread.getLooper();
                this.f7316i = looper2;
                this.f7314g = interfaceC2598bn.mo2614b(looper2, this);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:193:0x0364, code lost:
        if (m2326ad() != false) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x03d1, code lost:
        if (r36.f7305L.m2410e(m2304s(), r36.f7320m.mo1831c().f4868b, r36.f7332y, r27) == false) goto L288;
     */
    /* JADX WARN: Removed duplicated region for block: B:242:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x04be  */
    /* renamed from: A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m2356A() throws com.google.ads.interactivemedia.p034v3.internal.C2685et, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2715fw.m2356A():void");
    }

    /* renamed from: B */
    private final void m2355B() throws C2685et {
        int length = this.f7308a.length;
        m2354C(new boolean[2]);
    }

    /* renamed from: C */
    private final void m2354C(boolean[] zArr) throws C2685et {
        C2720ga m2261e = this.f7323p.m2261e();
        C3146vv m2284j = m2261e.m2284j();
        int i = 0;
        while (true) {
            int length = this.f7308a.length;
            if (i >= 2) {
                break;
            }
            if (!m2284j.m782b(i) && this.f7309b.remove(this.f7308a[i])) {
                this.f7308a[i].mo2172y();
            }
            i++;
        }
        int i2 = 0;
        while (true) {
            int length2 = this.f7308a.length;
            if (i2 < 2) {
                if (m2284j.m782b(i2)) {
                    boolean z = zArr[i2];
                    InterfaceC2737gr interfaceC2737gr = this.f7308a[i2];
                    if (!m2327ac(interfaceC2737gr)) {
                        C2720ga m2261e2 = this.f7323p.m2261e();
                        boolean z2 = m2261e2 == this.f7323p.m2262d();
                        C3146vv m2284j2 = m2261e2.m2284j();
                        C2739gt c2739gt = m2284j2.f9244b[i2];
                        C2962p[] m2321ai = m2321ai(m2284j2.f9245c[i2]);
                        boolean z3 = m2323ag() && this.f7327t.f7410e == 3;
                        boolean z4 = !z && z3;
                        this.f7299F++;
                        this.f7309b.add(interfaceC2737gr);
                        interfaceC2737gr.mo2175o(c2739gt, m2321ai, m2261e2.f7343c[i2], this.f7301H, z4, z2, m2261e2.m2289e(), m2261e2.m2290d());
                        interfaceC2737gr.mo627p(11, new C2708fp(this));
                        this.f7320m.m2402e(interfaceC2737gr);
                        if (z3) {
                            interfaceC2737gr.mo2184D();
                        }
                    }
                }
                i2++;
            } else {
                m2261e.f7347g = true;
                return;
            }
        }
    }

    /* renamed from: D */
    private final void m2353D(IOException iOException, int i) {
        C2685et m2396c = C2685et.m2396c(iOException, i);
        C2720ga m2262d = this.f7323p.m2262d();
        if (m2262d != null) {
            m2396c = m2396c.m2398a(m2262d.f7346f.f7356a);
        }
        C2613cb.m2698a("ExoPlayerImplInternal", "Playback error", m2396c);
        m2336U(false, false);
        this.f7327t = this.f7327t.m2209e(m2396c);
    }

    /* renamed from: E */
    private final void m2352E(boolean z) {
        long m2292b;
        C2720ga m2263c = this.f7323p.m2263c();
        C3067sx c3067sx = m2263c == null ? this.f7327t.f7407b : m2263c.f7346f.f7356a;
        boolean z2 = !this.f7327t.f7416k.equals(c3067sx);
        if (z2) {
            this.f7327t = this.f7327t.m2213a(c3067sx);
        }
        C2731gl c2731gl = this.f7327t;
        if (m2263c == null) {
            m2292b = c2731gl.f7424s;
        } else {
            m2292b = m2263c.m2292b();
        }
        c2731gl.f7422q = m2292b;
        this.f7327t.f7423r = m2304s();
        if ((z2 || z) && m2263c != null && m2263c.f7344d) {
            m2332Y(m2263c.m2286h(), m2263c.m2284j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03cb  */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r26v10 */
    /* JADX WARN: Type inference failed for: r26v15 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* renamed from: F */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m2351F(com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb r37, boolean r38) throws com.google.ads.interactivemedia.p034v3.internal.C2685et {
        /*
            Method dump skipped, instructions count: 978
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2715fw.m2351F(com.google.ads.interactivemedia.v3.internal.bb, boolean):void");
    }

    /* renamed from: G */
    private final void m2350G(C2559aq c2559aq, boolean z) throws C2685et {
        m2349H(c2559aq, c2559aq.f4868b, true, z);
    }

    /* renamed from: H */
    private final void m2349H(C2559aq c2559aq, float f, boolean z, boolean z2) throws C2685et {
        int i;
        C2715fw c2715fw = this;
        if (z) {
            if (z2) {
                c2715fw.f7328u.m2361a(1);
            }
            C2731gl c2731gl = c2715fw.f7327t;
            c2715fw = this;
            c2715fw.f7327t = new C2731gl(c2731gl.f7406a, c2731gl.f7407b, c2731gl.f7408c, c2731gl.f7409d, c2731gl.f7410e, c2731gl.f7411f, c2731gl.f7412g, c2731gl.f7413h, c2731gl.f7414i, c2731gl.f7415j, c2731gl.f7416k, c2731gl.f7417l, c2731gl.f7418m, c2559aq, c2731gl.f7422q, c2731gl.f7423r, c2731gl.f7424s, c2731gl.f7420o, c2731gl.f7421p);
        }
        float f2 = c2559aq.f4868b;
        C2720ga m2262d = c2715fw.f7323p.m2262d();
        while (true) {
            i = 0;
            if (m2262d == null) {
                break;
            }
            InterfaceC3142vr[] interfaceC3142vrArr = m2262d.m2284j().f9245c;
            int length = interfaceC3142vrArr.length;
            while (i < length) {
                InterfaceC3142vr interfaceC3142vr = interfaceC3142vrArr[i];
                if (interfaceC3142vr != null) {
                    interfaceC3142vr.mo803o(f2);
                }
                i++;
            }
            m2262d = m2262d.m2285i();
        }
        InterfaceC2737gr[] interfaceC2737grArr = c2715fw.f7308a;
        int length2 = interfaceC2737grArr.length;
        while (i < 2) {
            InterfaceC2737gr interfaceC2737gr = interfaceC2737grArr[i];
            if (interfaceC2737gr != null) {
                interfaceC2737gr.mo668C(f, c2559aq.f4868b);
            }
            i++;
        }
    }

    /* renamed from: I */
    private final void m2348I() {
        boolean m2407h;
        if (m2328ab()) {
            C2720ga m2263c = this.f7323p.m2263c();
            long m2303t = m2303t(m2263c.m2291c());
            if (m2263c == this.f7323p.m2262d()) {
                m2263c.m2288f(this.f7301H);
            } else {
                m2263c.m2288f(this.f7301H);
                long j = m2263c.f7346f.f7357b;
            }
            m2407h = this.f7305L.m2407h(m2303t, this.f7320m.mo1831c().f4868b);
        } else {
            m2407h = false;
        }
        this.f7333z = m2407h;
        if (m2407h) {
            this.f7323p.m2263c().m2282l(this.f7301H);
        }
        m2334W();
    }

    /* renamed from: J */
    private final void m2347J() {
        boolean z;
        this.f7328u.m2359c(this.f7327t);
        z = this.f7328u.f7284g;
        if (z) {
            this.f7306M.m2394a(this.f7328u);
            this.f7328u = new C2712ft(this.f7327t);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m2346K(boolean r30, boolean r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2715fw.m2346K(boolean, boolean, boolean, boolean):void");
    }

    /* renamed from: L */
    private final void m2345L() {
        C2720ga m2262d = this.f7323p.m2262d();
        boolean z = false;
        if (m2262d != null && m2262d.f7346f.f7363h && this.f7330w) {
            z = true;
        }
        this.f7331x = z;
    }

    /* renamed from: M */
    private final void m2344M(long j) throws C2685et {
        InterfaceC3142vr[] interfaceC3142vrArr;
        C2720ga m2262d = this.f7323p.m2262d();
        long m2287g = m2262d == null ? j + MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : m2262d.m2287g(j);
        this.f7301H = m2287g;
        this.f7320m.m2401f(m2287g);
        InterfaceC2737gr[] interfaceC2737grArr = this.f7308a;
        int length = interfaceC2737grArr.length;
        for (int i = 0; i < 2; i++) {
            InterfaceC2737gr interfaceC2737gr = interfaceC2737grArr[i];
            if (m2327ac(interfaceC2737gr)) {
                interfaceC2737gr.mo2171z(this.f7301H);
            }
        }
        for (C2720ga m2262d2 = this.f7323p.m2262d(); m2262d2 != null; m2262d2 = m2262d2.m2285i()) {
            for (InterfaceC3142vr interfaceC3142vr : m2262d2.m2284j().f9245c) {
            }
        }
    }

    /* renamed from: N */
    private final void m2343N(AbstractC2586bb abstractC2586bb, AbstractC2586bb abstractC2586bb2) {
        if (abstractC2586bb.m4204p() && abstractC2586bb2.m4204p()) {
            return;
        }
        int size = this.f7321n.size();
        while (true) {
            size--;
            if (size >= 0) {
                if (!m2324af((C2711fs) this.f7321n.get(size), abstractC2586bb, abstractC2586bb2, this.f7294A, this.f7295B, this.f7317j, this.f7318k)) {
                    ((C2711fs) this.f7321n.get(size)).f7274a.m2196h(false);
                    this.f7321n.remove(size);
                }
            } else {
                Collections.sort(this.f7321n);
                return;
            }
        }
    }

    /* renamed from: O */
    private final void m2342O(long j, long j2) {
        this.f7314g.mo2603g();
        this.f7314g.mo2601i(j + j2);
    }

    /* renamed from: P */
    private final void m2341P(boolean z) throws C2685et {
        C3067sx c3067sx = this.f7323p.m2262d().f7346f.f7356a;
        long m2301v = m2301v(c3067sx, this.f7327t.f7424s, true, false);
        if (m2301v != this.f7327t.f7424s) {
            C2731gl c2731gl = this.f7327t;
            this.f7327t = m2298y(c3067sx, m2301v, c2731gl.f7408c, c2731gl.f7409d, z, 5);
        }
    }

    /* renamed from: Q */
    private final void m2340Q(C2734go c2734go) throws C2685et {
        if (c2734go.m2200d() == this.f7316i) {
            m2320aj(c2734go);
            int i = this.f7327t.f7410e;
            if (i == 3 || i == 2) {
                this.f7314g.mo2602h(2);
                return;
            }
            return;
        }
        this.f7314g.mo2608b(15, c2734go).mo2613a();
    }

    /* renamed from: R */
    private final void m2339R(boolean z, int i, boolean z2, int i2) throws C2685et {
        InterfaceC3142vr[] interfaceC3142vrArr;
        this.f7328u.m2361a(z2 ? 1 : 0);
        this.f7328u.m2360b(i2);
        this.f7327t = this.f7327t.m2210d(z, i);
        this.f7332y = false;
        for (C2720ga m2262d = this.f7323p.m2262d(); m2262d != null; m2262d = m2262d.m2285i()) {
            for (InterfaceC3142vr interfaceC3142vr : m2262d.m2284j().f9245c) {
            }
        }
        if (!m2323ag()) {
            m2335V();
            m2331Z();
            return;
        }
        int i3 = this.f7327t.f7410e;
        if (i3 == 3) {
            m2337T();
            this.f7314g.mo2602h(2);
        } else if (i3 == 2) {
            this.f7314g.mo2602h(2);
        }
    }

    /* renamed from: S */
    private final void m2338S(int i) {
        C2731gl c2731gl = this.f7327t;
        if (c2731gl.f7410e != i) {
            this.f7327t = c2731gl.m2208f(i);
        }
    }

    /* renamed from: T */
    private final void m2337T() throws C2685et {
        this.f7332y = false;
        this.f7320m.m2400h();
        InterfaceC2737gr[] interfaceC2737grArr = this.f7308a;
        int length = interfaceC2737grArr.length;
        for (int i = 0; i < 2; i++) {
            InterfaceC2737gr interfaceC2737gr = interfaceC2737grArr[i];
            if (m2327ac(interfaceC2737gr)) {
                interfaceC2737gr.mo2184D();
            }
        }
    }

    /* renamed from: U */
    private final void m2336U(boolean z, boolean z2) {
        m2346K(z || !this.f7296C, false, true, false);
        this.f7328u.m2361a(z2 ? 1 : 0);
        this.f7305L.m2411d();
        m2338S(1);
    }

    /* renamed from: V */
    private final void m2335V() throws C2685et {
        this.f7320m.m2399i();
        InterfaceC2737gr[] interfaceC2737grArr = this.f7308a;
        int length = interfaceC2737grArr.length;
        for (int i = 0; i < 2; i++) {
            InterfaceC2737gr interfaceC2737gr = interfaceC2737grArr[i];
            if (m2327ac(interfaceC2737gr)) {
                m2319ak(interfaceC2737gr);
            }
        }
    }

    /* renamed from: W */
    private final void m2334W() {
        C2720ga m2263c = this.f7323p.m2263c();
        boolean z = this.f7333z || (m2263c != null && m2263c.f7341a.mo874p());
        C2731gl c2731gl = this.f7327t;
        if (z != c2731gl.f7412g) {
            this.f7327t = new C2731gl(c2731gl.f7406a, c2731gl.f7407b, c2731gl.f7408c, c2731gl.f7409d, c2731gl.f7410e, c2731gl.f7411f, z, c2731gl.f7413h, c2731gl.f7414i, c2731gl.f7415j, c2731gl.f7416k, c2731gl.f7417l, c2731gl.f7418m, c2731gl.f7419n, c2731gl.f7422q, c2731gl.f7423r, c2731gl.f7424s, c2731gl.f7420o, c2731gl.f7421p);
        }
    }

    /* renamed from: X */
    private final void m2333X(AbstractC2586bb abstractC2586bb, C3067sx c3067sx, AbstractC2586bb abstractC2586bb2, C3067sx c3067sx2, long j) {
        if (abstractC2586bb.m4204p() || !m2322ah(abstractC2586bb, c3067sx)) {
            float f = this.f7320m.mo1831c().f4868b;
            C2559aq c2559aq = this.f7327t.f7419n;
            if (f != c2559aq.f4868b) {
                this.f7320m.mo1830g(c2559aq);
                return;
            }
            return;
        }
        abstractC2586bb.m4205o(abstractC2586bb.mo2442n(c3067sx.f4115a, this.f7318k).f5314c, this.f7317j);
        C2681ep c2681ep = this.f7307N;
        C3232z c3232z = this.f7317j.f5357k;
        int i = C2628cq.f6961a;
        c2681ep.m2418d(c3232z);
        if (j != C3282C.TIME_UNSET) {
            this.f7307N.m2417e(m2305r(abstractC2586bb, c3067sx.f4115a, j));
            return;
        }
        if (C2628cq.m2563T(!abstractC2586bb2.m4204p() ? abstractC2586bb2.m4205o(abstractC2586bb2.mo2442n(c3067sx2.f4115a, this.f7318k).f5314c, this.f7317j).f5348b : null, this.f7317j.f5348b)) {
            return;
        }
        this.f7307N.m2417e(C3282C.TIME_UNSET);
    }

    /* renamed from: Y */
    private final void m2332Y(C2588bd c2588bd, C3146vv c3146vv) {
        this.f7305L.m2408g(this.f7308a, c3146vv.f9245c);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e7 A[LOOP:1: B:43:0x00cb->B:53:0x00e7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009b -> B:30:0x009c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00ca -> B:43:0x00cb). Please submit an issue!!! */
    /* renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m2331Z() throws com.google.ads.interactivemedia.p034v3.internal.C2685et {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2715fw.m2331Z():void");
    }

    /* renamed from: aa */
    private final synchronized void m2329aa(atn atnVar, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        boolean z = false;
        while (!((Boolean) atnVar.mo1308a()).booleanValue() && j > 0) {
            try {
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = elapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* renamed from: ab */
    private final boolean m2328ab() {
        C2720ga m2263c = this.f7323p.m2263c();
        return (m2263c == null || m2263c.m2291c() == Long.MIN_VALUE) ? false : true;
    }

    /* renamed from: ac */
    private static boolean m2327ac(InterfaceC2737gr interfaceC2737gr) {
        return interfaceC2737gr.mo2180aY() != 0;
    }

    /* renamed from: ad */
    private final boolean m2326ad() {
        C2720ga m2262d = this.f7323p.m2262d();
        long j = m2262d.f7346f.f7360e;
        if (m2262d.f7344d) {
            return j == C3282C.TIME_UNSET || this.f7327t.f7424s < j || !m2323ag();
        }
        return false;
    }

    /* renamed from: ae */
    private static boolean m2325ae(C2731gl c2731gl, C2583az c2583az) {
        C3067sx c3067sx = c2731gl.f7407b;
        AbstractC2586bb abstractC2586bb = c2731gl.f7406a;
        return abstractC2586bb.m4204p() || abstractC2586bb.mo2442n(c3067sx.f4115a, c2583az).f5317f;
    }

    /* renamed from: af */
    private static boolean m2324af(C2711fs c2711fs, AbstractC2586bb abstractC2586bb, AbstractC2586bb abstractC2586bb2, int i, boolean z, C2585ba c2585ba, C2583az c2583az) {
        Object obj = c2711fs.f7277d;
        if (obj == null) {
            c2711fs.f7274a.m2201c();
            c2711fs.f7274a.m2201c();
            Pair m2299x = m2299x(abstractC2586bb, new C2714fv(c2711fs.f7274a.m2199e(), c2711fs.f7274a.m2203a(), C2628cq.m2515s(C3282C.TIME_UNSET)), false, i, z, c2585ba, c2583az);
            if (m2299x == null) {
                return false;
            }
            c2711fs.m2362a(abstractC2586bb.mo925a(m2299x.first), ((Long) m2299x.second).longValue(), m2299x.first);
            c2711fs.f7274a.m2201c();
            return true;
        }
        int mo925a = abstractC2586bb.mo925a(obj);
        if (mo925a == -1) {
            return false;
        }
        c2711fs.f7274a.m2201c();
        c2711fs.f7275b = mo925a;
        abstractC2586bb2.mo2442n(c2711fs.f7277d, c2583az);
        if (c2583az.f5317f && abstractC2586bb2.m4205o(c2583az.f5314c, c2585ba).f5361o == abstractC2586bb2.mo925a(c2711fs.f7277d)) {
            Pair m4208k = abstractC2586bb.m4208k(c2585ba, c2583az, abstractC2586bb.mo2442n(c2711fs.f7277d, c2583az).f5314c, c2711fs.f7276c + c2583az.f5316e);
            c2711fs.m2362a(abstractC2586bb.mo925a(m4208k.first), ((Long) m4208k.second).longValue(), m4208k.first);
        }
        return true;
    }

    /* renamed from: ag */
    private final boolean m2323ag() {
        C2731gl c2731gl = this.f7327t;
        return c2731gl.f7417l && c2731gl.f7418m == 0;
    }

    /* renamed from: ah */
    private final boolean m2322ah(AbstractC2586bb abstractC2586bb, C3067sx c3067sx) {
        if (!c3067sx.m5216b() && !abstractC2586bb.m4204p()) {
            abstractC2586bb.m4205o(abstractC2586bb.mo2442n(c3067sx.f4115a, this.f7318k).f5314c, this.f7317j);
            if (this.f7317j.m4250b()) {
                C2585ba c2585ba = this.f7317j;
                if (c2585ba.f5355i && c2585ba.f5352f != C3282C.TIME_UNSET) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ai */
    private static C2962p[] m2321ai(InterfaceC3142vr interfaceC3142vr) {
        int d = interfaceC3142vr != null ? interfaceC3142vr.mo836d() : 0;
        C2962p[] c2962pArr = new C2962p[d];
        for (int i = 0; i < d; i++) {
            c2962pArr[i] = interfaceC3142vr.mo835e(i);
        }
        return c2962pArr;
    }

    /* renamed from: aj */
    private static final void m2320aj(C2734go c2734go) throws C2685et {
        c2734go.m2193k();
        try {
            c2734go.m2198f().mo627p(c2734go.m2202b(), c2734go.m2197g());
        } finally {
            c2734go.m2196h(true);
        }
    }

    /* renamed from: ak */
    private static final void m2319ak(InterfaceC2737gr interfaceC2737gr) throws C2685et {
        if (interfaceC2737gr.mo2180aY() == 2) {
            interfaceC2737gr.mo2183E();
        }
    }

    /* renamed from: al */
    private static final void m2318al(InterfaceC2737gr interfaceC2737gr) {
        interfaceC2737gr.mo2186A();
        if (interfaceC2737gr instanceof C3127vc) {
            C3127vc c3127vc = (C3127vc) interfaceC2737gr;
            throw null;
        }
    }

    /* renamed from: e */
    static Object m2314e(C2585ba c2585ba, C2583az c2583az, int i, boolean z, Object obj, AbstractC2586bb abstractC2586bb, AbstractC2586bb abstractC2586bb2) {
        int mo925a = abstractC2586bb.mo925a(obj);
        int mo924b = abstractC2586bb.mo924b();
        int i2 = 0;
        int i3 = mo925a;
        int i4 = -1;
        while (true) {
            if (i2 >= mo924b || i4 != -1) {
                break;
            }
            i3 = abstractC2586bb.m4209i(i3, c2583az, c2585ba, i, z);
            if (i3 == -1) {
                i4 = -1;
                break;
            }
            i4 = abstractC2586bb2.mo925a(abstractC2586bb.mo920f(i3));
            i2++;
        }
        if (i4 == -1) {
            return null;
        }
        return abstractC2586bb2.mo920f(i4);
    }

    /* renamed from: r */
    private final long m2305r(AbstractC2586bb abstractC2586bb, Object obj, long j) {
        abstractC2586bb.m4205o(abstractC2586bb.mo2442n(obj, this.f7318k).f5314c, this.f7317j);
        C2585ba c2585ba = this.f7317j;
        if (c2585ba.f5352f != C3282C.TIME_UNSET && c2585ba.m4250b()) {
            C2585ba c2585ba2 = this.f7317j;
            if (c2585ba2.f5355i) {
                return C2628cq.m2515s(C2628cq.m2517q(c2585ba2.f5353g) - this.f7317j.f5352f) - (j + this.f7318k.f5316e);
            }
        }
        return C3282C.TIME_UNSET;
    }

    /* renamed from: s */
    private final long m2304s() {
        return m2303t(this.f7327t.f7422q);
    }

    /* renamed from: t */
    private final long m2303t(long j) {
        C2720ga m2263c = this.f7323p.m2263c();
        if (m2263c == null) {
            return 0L;
        }
        return Math.max(0L, j - m2263c.m2288f(this.f7301H));
    }

    /* renamed from: u */
    private final long m2302u(C3067sx c3067sx, long j, boolean z) throws C2685et {
        return m2301v(c3067sx, j, this.f7323p.m2262d() != this.f7323p.m2261e(), z);
    }

    /* renamed from: v */
    private final long m2301v(C3067sx c3067sx, long j, boolean z, boolean z2) throws C2685et {
        m2335V();
        this.f7332y = false;
        if (z2 || this.f7327t.f7410e == 3) {
            m2338S(2);
        }
        C2720ga m2262d = this.f7323p.m2262d();
        C2720ga c2720ga = m2262d;
        while (c2720ga != null && !c3067sx.equals(c2720ga.f7346f.f7356a)) {
            c2720ga = c2720ga.m2285i();
        }
        if (z || m2262d != c2720ga || (c2720ga != null && c2720ga.m2287g(j) < 0)) {
            InterfaceC2737gr[] interfaceC2737grArr = this.f7308a;
            int length = interfaceC2737grArr.length;
            for (int i = 0; i < 2; i++) {
                m2297z(interfaceC2737grArr[i]);
            }
            if (c2720ga != null) {
                while (this.f7323p.m2262d() != c2720ga) {
                    this.f7323p.m2265a();
                }
                this.f7323p.m2254l(c2720ga);
                c2720ga.m2274t();
                m2355B();
            }
        }
        if (c2720ga != null) {
            this.f7323p.m2254l(c2720ga);
            if (!c2720ga.f7344d) {
                c2720ga.f7346f = c2720ga.f7346f.m2269b(j);
            } else if (c2720ga.f7345e) {
                j = c2720ga.f7341a.mo1028e(j);
                c2720ga.f7341a.mo1020q(j - this.f7319l);
            }
            m2344M(j);
            m2348I();
        } else {
            this.f7323p.m2257i();
            m2344M(j);
        }
        m2352E(false);
        this.f7314g.mo2602h(2);
        return j;
    }

    /* renamed from: w */
    private final Pair m2300w(AbstractC2586bb abstractC2586bb) {
        long j = 0;
        if (abstractC2586bb.m4204p()) {
            return Pair.create(C2731gl.m2205i(), 0L);
        }
        Pair m4208k = abstractC2586bb.m4208k(this.f7317j, this.f7318k, abstractC2586bb.mo1131g(this.f7295B), C3282C.TIME_UNSET);
        C3067sx m2258h = this.f7323p.m2258h(abstractC2586bb, m4208k.first, 0L);
        long longValue = ((Long) m4208k.second).longValue();
        if (m2258h.m5216b()) {
            abstractC2586bb.mo2442n(m2258h.f4115a, this.f7318k);
            if (m2258h.f4117c == this.f7318k.m4298d(m2258h.f4116b)) {
                this.f7318k.m4294h();
            }
        } else {
            j = longValue;
        }
        return Pair.create(m2258h, Long.valueOf(j));
    }

    /* renamed from: x */
    private static Pair m2299x(AbstractC2586bb abstractC2586bb, C2714fv c2714fv, boolean z, int i, boolean z2, C2585ba c2585ba, C2583az c2583az) {
        Pair m4208k;
        Object m2314e;
        AbstractC2586bb abstractC2586bb2 = c2714fv.f7291a;
        if (abstractC2586bb.m4204p()) {
            return null;
        }
        AbstractC2586bb abstractC2586bb3 = true == abstractC2586bb2.m4204p() ? abstractC2586bb : abstractC2586bb2;
        try {
            m4208k = abstractC2586bb3.m4208k(c2585ba, c2583az, c2714fv.f7292b, c2714fv.f7293c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (abstractC2586bb.equals(abstractC2586bb3)) {
            return m4208k;
        }
        if (abstractC2586bb.mo925a(m4208k.first) != -1) {
            return (abstractC2586bb3.mo2442n(m4208k.first, c2583az).f5317f && abstractC2586bb3.m4205o(c2583az.f5314c, c2585ba).f5361o == abstractC2586bb3.mo925a(m4208k.first)) ? abstractC2586bb.m4208k(c2585ba, c2583az, abstractC2586bb.mo2442n(m4208k.first, c2583az).f5314c, c2714fv.f7293c) : m4208k;
        }
        if (z && (m2314e = m2314e(c2585ba, c2583az, i, z2, m4208k.first, abstractC2586bb3, abstractC2586bb)) != null) {
            return abstractC2586bb.m4208k(c2585ba, c2583az, abstractC2586bb.mo2442n(m2314e, c2583az).f5314c, C3282C.TIME_UNSET);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.ads.interactivemedia.p034v3.internal.C2731gl m2298y(com.google.ads.interactivemedia.p034v3.internal.C3067sx r17, long r18, long r20, long r22, boolean r24, int r25) {
        /*
            r16 = this;
            r0 = r16
            r2 = r17
            r5 = r20
            boolean r1 = r0.f7303J
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L21
            com.google.ads.interactivemedia.v3.internal.gl r1 = r0.f7327t
            long r7 = r1.f7424s
            int r1 = (r18 > r7 ? 1 : (r18 == r7 ? 0 : -1))
            if (r1 != 0) goto L21
            com.google.ads.interactivemedia.v3.internal.gl r1 = r0.f7327t
            com.google.ads.interactivemedia.v3.internal.sx r1 = r1.f7407b
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L1f
            goto L21
        L1f:
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            r0.f7303J = r1
            r16.m2345L()
            com.google.ads.interactivemedia.v3.internal.gl r1 = r0.f7327t
            com.google.ads.interactivemedia.v3.internal.bd r7 = r1.f7413h
            com.google.ads.interactivemedia.v3.internal.vv r8 = r1.f7414i
            java.util.List r1 = r1.f7415j
            com.google.ads.interactivemedia.v3.internal.gk r9 = r0.f7324q
            boolean r9 = r9.m2227h()
            if (r9 == 0) goto L97
            com.google.ads.interactivemedia.v3.internal.gd r1 = r0.f7323p
            com.google.ads.interactivemedia.v3.internal.ga r1 = r1.m2262d()
            if (r1 != 0) goto L42
            com.google.ads.interactivemedia.v3.internal.bd r7 = com.google.ads.interactivemedia.p034v3.internal.C2588bd.f5439a
            goto L46
        L42:
            com.google.ads.interactivemedia.v3.internal.bd r7 = r1.m2286h()
        L46:
            if (r1 != 0) goto L4b
            com.google.ads.interactivemedia.v3.internal.vv r8 = r0.f7312e
            goto L4f
        L4b:
            com.google.ads.interactivemedia.v3.internal.vv r8 = r1.m2284j()
        L4f:
            com.google.ads.interactivemedia.v3.internal.vr[] r9 = r8.f9245c
            com.google.ads.interactivemedia.v3.internal.avm r10 = new com.google.ads.interactivemedia.v3.internal.avm
            r11 = 0
            r10.<init>(r11)
            int r11 = r9.length
            r12 = 0
            r13 = 0
        L5a:
            if (r12 >= r11) goto L7a
            r14 = r9[r12]
            if (r14 == 0) goto L77
            com.google.ads.interactivemedia.v3.internal.p r14 = r14.mo835e(r3)
            com.google.ads.interactivemedia.v3.internal.ak r14 = r14.f8370j
            if (r14 != 0) goto L73
            com.google.ads.interactivemedia.v3.internal.ak r14 = new com.google.ads.interactivemedia.v3.internal.ak
            com.google.ads.interactivemedia.v3.internal.aj[] r15 = new com.google.ads.interactivemedia.p034v3.internal.InterfaceC2548aj[r3]
            r14.<init>(r15)
            r10.m4498f(r14)
            goto L77
        L73:
            r10.m4498f(r14)
            r13 = 1
        L77:
            int r12 = r12 + 1
            goto L5a
        L7a:
            if (r13 == 0) goto L81
            com.google.ads.interactivemedia.v3.internal.avg r3 = r10.m4499e()
            goto L85
        L81:
            com.google.ads.interactivemedia.v3.internal.avg r3 = com.google.ads.interactivemedia.p034v3.internal.avg.m4515n()
        L85:
            if (r1 == 0) goto L95
            com.google.ads.interactivemedia.v3.internal.gb r4 = r1.f7346f
            long r9 = r4.f7358c
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 == 0) goto L95
            com.google.ads.interactivemedia.v3.internal.gb r4 = r4.m2270a(r5)
            r1.f7346f = r4
        L95:
            r13 = r3
            goto Lae
        L97:
            com.google.ads.interactivemedia.v3.internal.gl r3 = r0.f7327t
            com.google.ads.interactivemedia.v3.internal.sx r3 = r3.f7407b
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto Lad
            com.google.ads.interactivemedia.v3.internal.bd r1 = com.google.ads.interactivemedia.p034v3.internal.C2588bd.f5439a
            com.google.ads.interactivemedia.v3.internal.vv r3 = r0.f7312e
            com.google.ads.interactivemedia.v3.internal.avg r4 = com.google.ads.interactivemedia.p034v3.internal.avg.m4515n()
            r11 = r1
            r12 = r3
            r13 = r4
            goto Lb0
        Lad:
            r13 = r1
        Lae:
            r11 = r7
            r12 = r8
        Lb0:
            if (r24 == 0) goto Lb9
            com.google.ads.interactivemedia.v3.internal.ft r1 = r0.f7328u
            r3 = r25
            r1.m2358d(r3)
        Lb9:
            com.google.ads.interactivemedia.v3.internal.gl r1 = r0.f7327t
            long r9 = r16.m2304s()
            r2 = r17
            r3 = r18
            r5 = r20
            r7 = r22
            com.google.ads.interactivemedia.v3.internal.gl r1 = r1.m2212b(r2, r3, r5, r7, r9, r11, r12, r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2715fw.m2298y(com.google.ads.interactivemedia.v3.internal.sx, long, long, long, boolean, int):com.google.ads.interactivemedia.v3.internal.gl");
    }

    /* renamed from: z */
    private final void m2297z(InterfaceC2737gr interfaceC2737gr) throws C2685et {
        if (m2327ac(interfaceC2737gr)) {
            this.f7320m.m2403d(interfaceC2737gr);
            m2319ak(interfaceC2737gr);
            interfaceC2737gr.mo2176n();
            this.f7299F--;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2683er
    /* renamed from: a */
    public final void mo2330a(C2559aq c2559aq) {
        this.f7314g.mo2608b(16, c2559aq).mo2613a();
    }

    /* renamed from: b */
    public final Looper m2317b() {
        return this.f7316i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3065sv
    /* renamed from: bd */
    public final void mo1104bd(InterfaceC3066sw interfaceC3066sw) {
        this.f7314g.mo2608b(8, interfaceC3066sw).mo2613a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ Boolean m2315d() {
        return Boolean.valueOf(this.f7329v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void m2313f(C2734go c2734go) {
        try {
            m2320aj(c2734go);
        } catch (C2685et e) {
            C2613cb.m2698a("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3099ub
    /* renamed from: g */
    public final /* bridge */ /* synthetic */ void mo934g(InterfaceC3100uc interfaceC3100uc) {
        this.f7314g.mo2608b(9, (InterfaceC3066sw) interfaceC3100uc).mo2613a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2729gj
    /* renamed from: h */
    public final void mo2235h() {
        this.f7314g.mo2602h(22);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        boolean z;
        C2720ga m2261e;
        int i;
        long j;
        boolean z2;
        C3067sx c3067sx;
        long j2;
        Throwable th;
        long j3;
        long j4;
        long m2302u;
        boolean z3;
        long j5;
        C2731gl c2731gl;
        int i2;
        C2731gl m2298y;
        int i3;
        int i4;
        List list;
        C3101ud c3101ud;
        List list2;
        C3101ud c3101ud2;
        int i5;
        long j6;
        List list3;
        C3101ud c3101ud3;
        try {
            switch (message.what) {
                case 0:
                    this.f7328u.m2361a(1);
                    m2346K(false, false, false, true);
                    this.f7305L.m2413b();
                    m2338S(true != this.f7327t.f7406a.m4204p() ? 2 : 4);
                    this.f7324q.m2230e(this.f7313f.mo755f());
                    this.f7314g.mo2602h(2);
                    break;
                case 1:
                    m2339R(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    m2356A();
                    break;
                case 3:
                    C2714fv c2714fv = (C2714fv) message.obj;
                    this.f7328u.m2361a(1);
                    Pair m2299x = m2299x(this.f7327t.f7406a, c2714fv, true, this.f7294A, this.f7295B, this.f7317j, this.f7318k);
                    if (m2299x == null) {
                        Pair m2300w = m2300w(this.f7327t.f7406a);
                        j = -9223372036854775807L;
                        j2 = ((Long) m2300w.second).longValue();
                        z2 = !this.f7327t.f7406a.m4204p();
                        c3067sx = (C3067sx) m2300w.first;
                    } else {
                        Object obj = m2299x.first;
                        long longValue = ((Long) m2299x.second).longValue();
                        j = c2714fv.f7293c == C3282C.TIME_UNSET ? -9223372036854775807L : longValue;
                        C3067sx m2258h = this.f7323p.m2258h(this.f7327t.f7406a, obj, longValue);
                        if (m2258h.m5216b()) {
                            this.f7327t.f7406a.mo2442n(m2258h.f4115a, this.f7318k);
                            if (this.f7318k.m4298d(m2258h.f4116b) == m2258h.f4117c) {
                                this.f7318k.m4294h();
                            }
                            j2 = 0;
                            c3067sx = m2258h;
                            z2 = true;
                        } else {
                            j = j;
                            z2 = c2714fv.f7293c == C3282C.TIME_UNSET;
                            c3067sx = m2258h;
                            j2 = longValue;
                        }
                    }
                    try {
                        if (this.f7327t.f7406a.m4204p()) {
                            this.f7300G = c2714fv;
                        } else if (m2299x == null) {
                            if (this.f7327t.f7410e != 1) {
                                m2338S(4);
                            }
                            m2346K(false, true, false, true);
                        } else {
                            try {
                                if (c3067sx.equals(this.f7327t.f7407b)) {
                                    C2720ga m2262d = this.f7323p.m2262d();
                                    j4 = (m2262d == null || !m2262d.f7344d || j2 == 0) ? j2 : m2262d.f7341a.mo1030a(j2, this.f7326s);
                                    if (C2628cq.m2511w(j4) == C2628cq.m2511w(this.f7327t.f7424s) && ((i2 = (c2731gl = this.f7327t).f7410e) == 2 || i2 == 3)) {
                                        long j7 = c2731gl.f7424s;
                                        m2298y = m2298y(c3067sx, j7, j, j7, z2, 2);
                                        this.f7327t = m2298y;
                                        break;
                                    }
                                } else {
                                    j4 = j2;
                                }
                                C2731gl c2731gl2 = this.f7327t;
                                AbstractC2586bb abstractC2586bb = c2731gl2.f7406a;
                                m2333X(abstractC2586bb, c3067sx, abstractC2586bb, c2731gl2.f7407b, j);
                                z2 = z3;
                                j5 = m2302u;
                                m2298y = m2298y(c3067sx, j5, j, j5, z2, 2);
                                this.f7327t = m2298y;
                            } catch (Throwable th2) {
                                z2 = z3;
                                j3 = m2302u;
                                th = th2;
                                this.f7327t = m2298y(c3067sx, j3, j, j3, z2, 2);
                                throw th;
                            }
                            m2302u = m2302u(c3067sx, j4, this.f7327t.f7410e == 4);
                            z3 = z2 | (j2 != m2302u);
                        }
                        j5 = j2;
                        m2298y = m2298y(c3067sx, j5, j, j5, z2, 2);
                        this.f7327t = m2298y;
                    } catch (Throwable th3) {
                        th = th3;
                        j3 = j2;
                    }
                    break;
                case 4:
                    this.f7320m.mo1830g((C2559aq) message.obj);
                    m2350G(this.f7320m.mo1831c(), true);
                    break;
                case 5:
                    this.f7326s = (C2740gu) message.obj;
                    break;
                case 6:
                    m2336U(false, true);
                    break;
                case 7:
                    m2346K(true, false, true, false);
                    this.f7305L.m2412c();
                    m2338S(1);
                    this.f7315h.quit();
                    synchronized (this) {
                        this.f7329v = true;
                        notifyAll();
                    }
                    return true;
                case 8:
                    if (this.f7323p.m2255k((InterfaceC3066sw) message.obj)) {
                        C2720ga m2263c = this.f7323p.m2263c();
                        m2263c.m2281m(this.f7320m.mo1831c().f4868b, this.f7327t.f7406a);
                        m2332Y(m2263c.m2286h(), m2263c.m2284j());
                        if (m2263c == this.f7323p.m2262d()) {
                            m2344M(m2263c.f7346f.f7357b);
                            m2355B();
                            C2731gl c2731gl3 = this.f7327t;
                            C3067sx c3067sx2 = c2731gl3.f7407b;
                            long j8 = m2263c.f7346f.f7357b;
                            this.f7327t = m2298y(c3067sx2, j8, c2731gl3.f7408c, j8, false, 5);
                        }
                        m2348I();
                        break;
                    }
                    break;
                case 9:
                    if (this.f7323p.m2255k((InterfaceC3066sw) message.obj)) {
                        this.f7323p.m2256j(this.f7301H);
                        m2348I();
                        break;
                    }
                    break;
                case 10:
                    float f = this.f7320m.mo1831c().f4868b;
                    C2720ga m2262d2 = this.f7323p.m2262d();
                    C2720ga m2261e2 = this.f7323p.m2261e();
                    boolean z4 = true;
                    while (m2262d2 != null && m2262d2.f7344d) {
                        C3146vv m2283k = m2262d2.m2283k(f, this.f7327t.f7406a);
                        C3146vv m2284j = m2262d2.m2284j();
                        if (m2284j != null && m2284j.f9245c.length == m2283k.f9245c.length) {
                            for (int i6 = 0; i6 < m2283k.f9245c.length; i6++) {
                                if (m2283k.m783a(m2284j, i6)) {
                                }
                            }
                            z4 &= m2262d2 != m2261e2;
                            m2262d2 = m2262d2.m2285i();
                        }
                        if (z4) {
                            C2720ga m2262d3 = this.f7323p.m2262d();
                            boolean m2254l = this.f7323p.m2254l(m2262d3);
                            int length = this.f7308a.length;
                            boolean[] zArr = new boolean[2];
                            long m2293a = m2262d3.m2293a(m2283k, this.f7327t.f7424s, m2254l, zArr);
                            C2731gl c2731gl4 = this.f7327t;
                            boolean z5 = (c2731gl4.f7410e == 4 || m2293a == c2731gl4.f7424s) ? false : true;
                            C2731gl c2731gl5 = this.f7327t;
                            i3 = 2;
                            this.f7327t = m2298y(c2731gl5.f7407b, m2293a, c2731gl5.f7408c, c2731gl5.f7409d, z5, 5);
                            if (z5) {
                                m2344M(m2293a);
                            }
                            int length2 = this.f7308a.length;
                            boolean[] zArr2 = new boolean[2];
                            int i7 = 0;
                            while (true) {
                                InterfaceC2737gr[] interfaceC2737grArr = this.f7308a;
                                int length3 = interfaceC2737grArr.length;
                                if (i7 < 2) {
                                    InterfaceC2737gr interfaceC2737gr = interfaceC2737grArr[i7];
                                    boolean m2327ac = m2327ac(interfaceC2737gr);
                                    zArr2[i7] = m2327ac;
                                    InterfaceC3098ua interfaceC3098ua = m2262d3.f7343c[i7];
                                    if (m2327ac) {
                                        if (interfaceC3098ua != interfaceC2737gr.mo2177m()) {
                                            m2297z(interfaceC2737gr);
                                        } else if (zArr[i7]) {
                                            interfaceC2737gr.mo2171z(this.f7301H);
                                        }
                                    }
                                    i7++;
                                } else {
                                    m2354C(zArr2);
                                }
                            }
                        } else {
                            i3 = 2;
                            this.f7323p.m2254l(m2262d2);
                            if (m2262d2.f7344d) {
                                m2262d2.m2275s(m2283k, Math.max(m2262d2.f7346f.f7357b, m2262d2.m2288f(this.f7301H)));
                            }
                        }
                        m2352E(true);
                        if (this.f7327t.f7410e != 4) {
                            m2348I();
                            m2331Z();
                            this.f7314g.mo2602h(i3);
                            break;
                        }
                    }
                    break;
                case 11:
                    int i8 = message.arg1;
                    this.f7294A = i8;
                    if (!this.f7323p.m2251o(this.f7327t.f7406a, i8)) {
                        m2341P(true);
                    }
                    m2352E(false);
                    break;
                case 12:
                    boolean z6 = message.arg1 != 0;
                    this.f7295B = z6;
                    if (!this.f7323p.m2250p(this.f7327t.f7406a, z6)) {
                        m2341P(true);
                    }
                    m2352E(false);
                    break;
                case 13:
                    boolean z7 = message.arg1 != 0;
                    AtomicBoolean atomicBoolean = (AtomicBoolean) message.obj;
                    if (this.f7296C != z7) {
                        this.f7296C = z7;
                        if (!z7) {
                            InterfaceC2737gr[] interfaceC2737grArr2 = this.f7308a;
                            int length4 = interfaceC2737grArr2.length;
                            for (int i9 = 0; i9 < 2; i9++) {
                                InterfaceC2737gr interfaceC2737gr2 = interfaceC2737grArr2[i9];
                                if (!m2327ac(interfaceC2737gr2) && this.f7309b.remove(interfaceC2737gr2)) {
                                    interfaceC2737gr2.mo2172y();
                                }
                            }
                        }
                    }
                    if (atomicBoolean != null) {
                        synchronized (this) {
                            atomicBoolean.set(true);
                            notifyAll();
                        }
                        break;
                    }
                    break;
                case 14:
                    C2734go c2734go = (C2734go) message.obj;
                    c2734go.m2201c();
                    m2340Q(c2734go);
                    break;
                case 15:
                    final C2734go c2734go2 = (C2734go) message.obj;
                    Looper m2200d = c2734go2.m2200d();
                    if (!m2200d.getThread().isAlive()) {
                        Log.w("TAG", "Trying to send message on a dead thread.");
                        c2734go2.m2196h(false);
                        break;
                    } else {
                        this.f7322o.mo2614b(m2200d, null).mo2605e(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.fo
                            @Override // java.lang.Runnable
                            public final void run() {
                                C2715fw.this.m2313f(c2734go2);
                            }
                        });
                        break;
                    }
                case 16:
                    m2350G((C2559aq) message.obj, false);
                    break;
                case 17:
                    C2709fq c2709fq = (C2709fq) message.obj;
                    this.f7328u.m2361a(1);
                    i4 = c2709fq.f7267b;
                    if (i4 != -1) {
                        list2 = c2709fq.f7266a;
                        c3101ud2 = c2709fq.f7269d;
                        C2735gp c2735gp = new C2735gp(list2, c3101ud2);
                        i5 = c2709fq.f7267b;
                        j6 = c2709fq.f7268c;
                        this.f7300G = new C2714fv(c2735gp, i5, j6);
                    }
                    C2730gk c2730gk = this.f7324q;
                    list = c2709fq.f7266a;
                    c3101ud = c2709fq.f7269d;
                    m2351F(c2730gk.m2224k(list, c3101ud), false);
                    break;
                case 18:
                    C2709fq c2709fq2 = (C2709fq) message.obj;
                    int i10 = message.arg1;
                    this.f7328u.m2361a(1);
                    C2730gk c2730gk2 = this.f7324q;
                    if (i10 == -1) {
                        i10 = c2730gk2.m2234a();
                    }
                    list3 = c2709fq2.f7266a;
                    c3101ud3 = c2709fq2.f7269d;
                    m2351F(c2730gk2.m2226i(i10, list3, c3101ud3), false);
                    break;
                case 19:
                    C2710fr c2710fr = (C2710fr) message.obj;
                    this.f7328u.m2361a(1);
                    C2730gk c2730gk3 = this.f7324q;
                    int i11 = c2710fr.f7270a;
                    int i12 = c2710fr.f7271b;
                    int i13 = c2710fr.f7272c;
                    C3101ud c3101ud4 = c2710fr.f7273d;
                    m2351F(c2730gk3.m2220o(), false);
                    break;
                case 20:
                    this.f7328u.m2361a(1);
                    m2351F(this.f7324q.m2225j(message.arg1, message.arg2, (C3101ud) message.obj), false);
                    break;
                case 21:
                    this.f7328u.m2361a(1);
                    m2351F(this.f7324q.m2223l((C3101ud) message.obj), false);
                    break;
                case 22:
                    m2351F(this.f7324q.m2233b(), true);
                    break;
                case 23:
                    this.f7330w = message.arg1 != 0;
                    m2345L();
                    if (this.f7331x && this.f7323p.m2261e() != this.f7323p.m2262d()) {
                        m2341P(true);
                        m2352E(false);
                        break;
                    }
                    break;
                case 24:
                    boolean z8 = message.arg1 == 1;
                    if (z8 != this.f7298E) {
                        this.f7298E = z8;
                        C2731gl c2731gl6 = this.f7327t;
                        int i14 = c2731gl6.f7410e;
                        if (!z8 && i14 != 4 && i14 != 1) {
                            this.f7314g.mo2602h(2);
                            break;
                        }
                        this.f7327t = c2731gl6.m2211c(z8);
                    }
                    break;
                case 25:
                    m2341P(true);
                    break;
                default:
                    return false;
            }
        } catch (C2555ao e) {
            int i15 = e.f4773b;
            if (i15 == 1) {
                i = true != e.f4772a ? PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED : PlaybackException.ERROR_CODE_PARSING_CONTAINER_MALFORMED;
            } else if (i15 == 4) {
                i = true != e.f4772a ? PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED : PlaybackException.ERROR_CODE_PARSING_MANIFEST_MALFORMED;
            } else {
                i = 1000;
            }
            m2353D(e, i);
        } catch (C2639da e2) {
            m2353D(e2, e2.f6996a);
        } catch (C2685et e3) {
            C2685et c2685et = e3;
            if (c2685et.f7176c == 1 && (m2261e = this.f7323p.m2261e()) != null) {
                c2685et = c2685et.m2398a(m2261e.f7346f.f7356a);
            }
            if (!c2685et.f7182i || this.f7304K != null) {
                C2685et c2685et2 = this.f7304K;
                if (c2685et2 != null) {
                    c2685et = c2685et2;
                }
                C2613cb.m2698a("ExoPlayerImplInternal", "Playback error", c2685et);
                z = true;
                m2336U(true, false);
                this.f7327t = this.f7327t.m2209e(c2685et);
            } else {
                C2613cb.m2697b("ExoPlayerImplInternal", "Recoverable renderer error", c2685et);
                this.f7304K = c2685et;
                InterfaceC2605bu interfaceC2605bu = this.f7314g;
                interfaceC2605bu.mo2600j(interfaceC2605bu.mo2608b(25, c2685et));
            }
        } catch (C2909na e4) {
            m2353D(e4, e4.f8170a);
        } catch (C3038rv e5) {
            m2353D(e5, 1002);
        } catch (IOException e6) {
            m2353D(e6, 2000);
        } catch (RuntimeException e7) {
            C2685et m2395d = C2685et.m2395d(e7, ((e7 instanceof IllegalStateException) || (e7 instanceof IllegalArgumentException)) ? 1004 : 1000);
            C2613cb.m2698a("ExoPlayerImplInternal", "Playback error", m2395d);
            m2336U(true, false);
            this.f7327t = this.f7327t.m2209e(m2395d);
        }
        z = true;
        m2347J();
        return z;
    }

    /* renamed from: j */
    public final void m2312j() {
        this.f7314g.mo2609a(0).mo2613a();
    }

    /* renamed from: k */
    public final void m2311k(AbstractC2586bb abstractC2586bb, int i, long j) {
        this.f7314g.mo2608b(3, new C2714fv(abstractC2586bb, i, j)).mo2613a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2732gm
    /* renamed from: l */
    public final synchronized void mo2204l(C2734go c2734go) {
        if (!this.f7329v && this.f7315h.isAlive()) {
            this.f7314g.mo2608b(14, c2734go).mo2613a();
            return;
        }
        Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        c2734go.m2196h(false);
    }

    /* renamed from: m */
    public final void m2310m(boolean z, int i) {
        this.f7314g.mo2606d(z ? 1 : 0, i).mo2613a();
    }

    /* renamed from: n */
    public final void m2309n() {
        this.f7314g.mo2609a(6).mo2613a();
    }

    /* renamed from: o */
    public final synchronized boolean m2308o() {
        if (!this.f7329v && this.f7315h.isAlive()) {
            this.f7314g.mo2602h(7);
            m2329aa(new atn() { // from class: com.google.ads.interactivemedia.v3.internal.fn
                @Override // com.google.ads.interactivemedia.p034v3.internal.atn
                /* renamed from: a */
                public final Object mo1308a() {
                    return C2715fw.this.m2315d();
                }
            }, this.f7325r);
            return this.f7329v;
        }
        return true;
    }

    /* renamed from: p */
    public final void m2307p(List list, int i, long j, C3101ud c3101ud) {
        this.f7314g.mo2608b(17, new C2709fq(list, c3101ud, i, j)).mo2613a();
    }
}
