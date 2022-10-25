package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* compiled from: IMASDK */
@Deprecated
/* renamed from: com.google.ads.interactivemedia.v3.internal.gz */
/* loaded from: classes2.dex */
public final class C2745gz extends AbstractC2665e implements InterfaceC2567aw {

    /* renamed from: A */
    private boolean f7453A;

    /* renamed from: B */
    private boolean f7454B;

    /* renamed from: C */
    private C2773i f7455C;

    /* renamed from: D */
    private final age f7456D;

    /* renamed from: b */
    protected final InterfaceC2737gr[] f7457b;

    /* renamed from: c */
    private final Context f7458c;

    /* renamed from: d */
    private final C2705fm f7459d;

    /* renamed from: e */
    private final SurfaceHolder$CallbackC2743gx f7460e;

    /* renamed from: f */
    private final C2744gy f7461f;

    /* renamed from: g */
    private final CopyOnWriteArraySet f7462g;

    /* renamed from: h */
    private final C2785il f7463h;

    /* renamed from: i */
    private final C2673eh f7464i;

    /* renamed from: j */
    private final C2677el f7465j;

    /* renamed from: k */
    private final C2751he f7466k;

    /* renamed from: l */
    private final C2752hf f7467l;

    /* renamed from: m */
    private final C2753hg f7468m;

    /* renamed from: n */
    private final long f7469n;

    /* renamed from: o */
    private AudioTrack f7470o;

    /* renamed from: p */
    private Object f7471p;

    /* renamed from: q */
    private Surface f7472q;

    /* renamed from: r */
    private SurfaceHolder f7473r;

    /* renamed from: s */
    private boolean f7474s;

    /* renamed from: t */
    private int f7475t;

    /* renamed from: u */
    private int f7476u;

    /* renamed from: v */
    private int f7477v;

    /* renamed from: w */
    private int f7478w;

    /* renamed from: x */
    private C2611c f7479x;

    /* renamed from: y */
    private float f7480y;

    /* renamed from: z */
    private boolean f7481z;

    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.ads.interactivemedia.v3.internal.wb, java.lang.Object] */
    public C2745gz(C2691ez c2691ez) {
        C2745gz c2745gz;
        SurfaceHolder$CallbackC2743gx surfaceHolder$CallbackC2743gx;
        C2744gy c2744gy;
        Handler handler;
        C2705fm c2705fm;
        age ageVar = new age();
        this.f7456D = ageVar;
        try {
            Context applicationContext = c2691ez.f7188a.getApplicationContext();
            this.f7458c = applicationContext;
            C2785il c2785il = (C2785il) c2691ez.f7195h.mo1308a();
            this.f7463h = c2785il;
            this.f7479x = c2691ez.f7197j;
            this.f7475t = c2691ez.f7198k;
            this.f7481z = false;
            this.f7469n = c2691ez.f7204q;
            surfaceHolder$CallbackC2743gx = new SurfaceHolder$CallbackC2743gx(this);
            this.f7460e = surfaceHolder$CallbackC2743gx;
            c2744gy = new C2744gy(null);
            this.f7461f = c2744gy;
            this.f7462g = new CopyOnWriteArraySet();
            handler = new Handler(c2691ez.f7196i);
            InterfaceC2737gr[] m5041a = ((C2690ey) c2691ez.f7190c).f7187a.m5041a(handler, surfaceHolder$CallbackC2743gx, surfaceHolder$CallbackC2743gx);
            this.f7457b = m5041a;
            this.f7480y = 1.0f;
            if (C2628cq.f6961a < 21) {
                AudioTrack audioTrack = this.f7470o;
                if (audioTrack != null && audioTrack.getAudioSessionId() != 0) {
                    this.f7470o.release();
                    this.f7470o = null;
                }
                if (this.f7470o == null) {
                    this.f7470o = new AudioTrack(3, 4000, 4, 2, 2, 0, 0);
                }
                this.f7478w = this.f7470o.getAudioSessionId();
            } else {
                this.f7478w = C2628cq.m2530d(applicationContext);
            }
            Collections.emptyList();
            this.f7453A = true;
            C2560ar c2560ar = new C2560ar();
            int[] iArr = new int[8];
            iArr[0] = 21;
            iArr[1] = 22;
            iArr[2] = 23;
            try {
                iArr[3] = 24;
                iArr[4] = 25;
                iArr[5] = 26;
                iArr[6] = 27;
                iArr[7] = 28;
                c2560ar.m4740d(iArr);
                C2561as m4743a = c2560ar.m4743a();
                Object mo1308a = c2691ez.f7192e.mo1308a();
                c2691ez.f7191d.mo1308a();
                C2682eq c2682eq = (C2682eq) c2691ez.f7193f.mo1308a();
                c2705fm = new C2705fm(m5041a, (AbstractC3145vu) mo1308a, c2682eq, c2691ez.f7194g.mo1308a(), c2785il, c2691ez.f7199l, c2691ez.f7200m, c2691ez.f7206s, c2691ez.f7203p, c2691ez.f7189b, c2691ez.f7196i, this, m4743a);
                c2745gz = this;
            } catch (Throwable th) {
                th = th;
                c2745gz = this;
            }
        } catch (Throwable th2) {
            th = th2;
            c2745gz = this;
        }
        try {
            c2745gz.f7459d = c2705fm;
            c2705fm.m2371v(surfaceHolder$CallbackC2743gx);
            c2705fm.m2372u(surfaceHolder$CallbackC2743gx);
            C2673eh c2673eh = new C2673eh(c2691ez.f7188a, handler, surfaceHolder$CallbackC2743gx);
            c2745gz.f7464i = c2673eh;
            c2673eh.m2439a();
            C2677el c2677el = new C2677el(c2691ez.f7188a, handler, surfaceHolder$CallbackC2743gx);
            c2745gz.f7465j = c2677el;
            c2677el.m2434e(null);
            C2751he c2751he = new C2751he(c2691ez.f7188a, handler, surfaceHolder$CallbackC2743gx);
            c2745gz.f7466k = c2751he;
            int i = c2745gz.f7479x.f6919c;
            c2751he.m2101f(3);
            C2752hf c2752hf = new C2752hf(c2691ez.f7188a);
            c2745gz.f7467l = c2752hf;
            c2752hf.m2097a();
            C2753hg c2753hg = new C2753hg(c2691ez.f7188a);
            c2745gz.f7468m = c2753hg;
            c2753hg.m2095a();
            c2745gz.f7455C = m2138Y(c2751he);
            c2745gz.m2135ab(1, 10, Integer.valueOf(c2745gz.f7478w));
            c2745gz.m2135ab(2, 10, Integer.valueOf(c2745gz.f7478w));
            c2745gz.m2135ab(1, 3, c2745gz.f7479x);
            c2745gz.m2135ab(2, 4, Integer.valueOf(c2745gz.f7475t));
            c2745gz.m2135ab(2, 5, 0);
            c2745gz.m2135ab(1, 9, Boolean.valueOf(c2745gz.f7481z));
            c2745gz.m2135ab(2, 7, c2744gy);
            c2745gz.m2135ab(6, 8, c2744gy);
            ageVar.m5362f();
        } catch (Throwable th3) {
            th = th3;
            c2745gz.f7456D.m5362f();
            throw th;
        }
    }

    /* renamed from: A */
    public static /* bridge */ /* synthetic */ void m2162A(C2745gz c2745gz, C2773i c2773i) {
        c2745gz.f7455C = c2773i;
    }

    /* renamed from: D */
    public static /* bridge */ /* synthetic */ void m2159D(C2745gz c2745gz) {
        c2745gz.f7463h.mo2040v(c2745gz.f7481z);
        Iterator it = c2745gz.f7462g.iterator();
        while (it.hasNext()) {
            ((InterfaceC2565au) it.next()).mo2040v(c2745gz.f7481z);
        }
    }

    /* renamed from: F */
    public static /* bridge */ /* synthetic */ void m2157F(C2745gz c2745gz, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        c2745gz.m2134ac(surface);
        c2745gz.f7472q = surface;
    }

    /* renamed from: I */
    public static /* bridge */ /* synthetic */ void m2154I(C2745gz c2745gz) {
        int m2118r = c2745gz.m2118r();
        if (m2118r == 2 || m2118r == 3) {
            c2745gz.m2132ae();
            c2745gz.f7459d.m2388E();
            C2752hf c2752hf = c2745gz.f7467l;
            c2745gz.m2141V();
            c2752hf.m2096b();
            C2753hg c2753hg = c2745gz.f7468m;
            c2745gz.m2141V();
            c2753hg.m2094b();
            return;
        }
        c2745gz.f7467l.m2096b();
        c2745gz.f7468m.m2094b();
    }

    /* renamed from: X */
    public static int m2139X(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    /* renamed from: Y */
    public static C2773i m2138Y(C2751he c2751he) {
        return new C2773i(c2751he.m2105b(), c2751he.m2106a());
    }

    /* renamed from: Z */
    public final void m2137Z(int i, int i2) {
        if (i == this.f7476u && i2 == this.f7477v) {
            return;
        }
        this.f7476u = i;
        this.f7477v = i2;
        this.f7463h.mo2039w(i, i2);
        Iterator it = this.f7462g.iterator();
        while (it.hasNext()) {
            ((InterfaceC2565au) it.next()).mo2039w(i, i2);
        }
    }

    /* renamed from: aa */
    private final void m2136aa() {
        SurfaceHolder surfaceHolder = this.f7473r;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f7460e);
            this.f7473r = null;
        }
    }

    /* renamed from: ab */
    public final void m2135ab(int i, int i2, Object obj) {
        InterfaceC2737gr[] interfaceC2737grArr = this.f7457b;
        int length = interfaceC2737grArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            InterfaceC2737gr interfaceC2737gr = interfaceC2737grArr[i3];
            if (interfaceC2737gr.mo2170b() == i) {
                C2734go m2373t = this.f7459d.m2373t(interfaceC2737gr);
                m2373t.m2190n(i2);
                m2373t.m2191m(obj);
                m2373t.m2192l();
            }
        }
    }

    /* renamed from: ac */
    public final void m2134ac(Object obj) {
        ArrayList<C2734go> arrayList = new ArrayList();
        InterfaceC2737gr[] interfaceC2737grArr = this.f7457b;
        int length = interfaceC2737grArr.length;
        boolean z = false;
        for (int i = 0; i < 2; i++) {
            InterfaceC2737gr interfaceC2737gr = interfaceC2737grArr[i];
            if (interfaceC2737gr.mo2170b() == 2) {
                C2734go m2373t = this.f7459d.m2373t(interfaceC2737gr);
                m2373t.m2190n(1);
                m2373t.m2191m(obj);
                m2373t.m2192l();
                arrayList.add(m2373t);
            }
        }
        Object obj2 = this.f7471p;
        if (obj2 != null && obj2 != obj) {
            try {
                for (C2734go c2734go : arrayList) {
                    c2734go.m2194j(this.f7469n);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z = true;
            }
            Object obj3 = this.f7471p;
            Surface surface = this.f7472q;
            if (obj3 == surface) {
                surface.release();
                this.f7472q = null;
            }
        }
        this.f7471p = obj;
        if (z) {
            this.f7459d.m2385H(C2685et.m2395d(new C2716fx(3), 1003));
        }
    }

    /* renamed from: ad */
    public final void m2133ad(boolean z, int i, int i2) {
        int i3 = 1;
        boolean z2 = z && i != -1;
        this.f7459d.m2389D(z2, (!z2 || i == 1) ? 0 : 0, i2);
    }

    /* renamed from: ae */
    private final void m2132ae() {
        this.f7456D.m5364d();
        if (Thread.currentThread() != m2116t().getThread()) {
            String m2577F = C2628cq.m2577F("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), m2116t().getThread().getName());
            if (this.f7453A) {
                throw new IllegalStateException(m2577F);
            }
            C2613cb.m2697b("SimpleExoPlayer", m2577F, this.f7454B ? null : new IllegalStateException());
            this.f7454B = true;
        }
    }

    /* renamed from: u */
    public static /* bridge */ /* synthetic */ C2773i m2115u(C2745gz c2745gz) {
        return c2745gz.f7455C;
    }

    /* renamed from: v */
    public static /* bridge */ /* synthetic */ C2773i m2114v(C2751he c2751he) {
        return m2138Y(c2751he);
    }

    /* renamed from: w */
    public static /* bridge */ /* synthetic */ C2751he m2113w(C2745gz c2745gz) {
        return c2745gz.f7466k;
    }

    /* renamed from: z */
    public static /* bridge */ /* synthetic */ CopyOnWriteArraySet m2110z(C2745gz c2745gz) {
        return c2745gz.f7462g;
    }

    /* renamed from: J */
    public final void m2153J(InterfaceC2787in interfaceC2787in) {
        C2616ce.m2689d(interfaceC2787in);
        this.f7463h.m2075T(interfaceC2787in);
    }

    /* renamed from: K */
    public final void m2152K(InterfaceC2565au interfaceC2565au) {
        C2616ce.m2689d(interfaceC2565au);
        this.f7462g.add(interfaceC2565au);
        C2616ce.m2689d(interfaceC2565au);
        this.f7459d.m2371v(interfaceC2565au);
    }

    @Deprecated
    /* renamed from: L */
    public final void m2151L(InterfaceC3069sz interfaceC3069sz) {
        m2132ae();
        List singletonList = Collections.singletonList(interfaceC3069sz);
        m2132ae();
        this.f7459d.m2386G(singletonList);
        m2132ae();
        boolean m2141V = m2141V();
        int m2437b = this.f7465j.m2437b(m2141V, 2);
        m2133ad(m2141V, m2437b, m2139X(m2141V, m2437b));
        this.f7459d.m2392A();
    }

    /* renamed from: M */
    public final void m2150M() {
        AudioTrack audioTrack;
        m2132ae();
        if (C2628cq.f6961a < 21 && (audioTrack = this.f7470o) != null) {
            audioTrack.release();
            this.f7470o = null;
        }
        this.f7464i.m2439a();
        this.f7466k.m2102e();
        this.f7467l.m2096b();
        this.f7468m.m2094b();
        this.f7465j.m2435d();
        this.f7459d.m2391B();
        this.f7463h.m2072X();
        m2136aa();
        Surface surface = this.f7472q;
        if (surface != null) {
            surface.release();
            this.f7472q = null;
        }
        Collections.emptyList();
    }

    /* renamed from: N */
    public final void m2149N(InterfaceC2787in interfaceC2787in) {
        this.f7463h.m2071Y(interfaceC2787in);
    }

    /* renamed from: O */
    public final void m2148O(InterfaceC2565au interfaceC2565au) {
        C2616ce.m2689d(interfaceC2565au);
        this.f7462g.remove(interfaceC2565au);
        this.f7459d.m2390C(interfaceC2565au);
    }

    /* renamed from: P */
    public final void m2147P(boolean z) {
        m2132ae();
        int m2437b = this.f7465j.m2437b(z, m2118r());
        m2133ad(z, m2437b, m2139X(z, m2437b));
    }

    /* renamed from: Q */
    public final void m2146Q(SurfaceHolder surfaceHolder) {
        m2132ae();
        if (surfaceHolder == null) {
            m2132ae();
            m2136aa();
            m2134ac(null);
            m2137Z(0, 0);
            return;
        }
        m2136aa();
        this.f7474s = true;
        this.f7473r = surfaceHolder;
        surfaceHolder.addCallback(this.f7460e);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            m2134ac(null);
            m2137Z(0, 0);
            return;
        }
        m2134ac(surface);
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        m2137Z(surfaceFrame.width(), surfaceFrame.height());
    }

    /* renamed from: R */
    public final void m2145R(SurfaceView surfaceView) {
        m2132ae();
        m2146Q(surfaceView == null ? null : surfaceView.getHolder());
    }

    /* renamed from: S */
    public final void m2144S() {
        m2132ae();
        this.f7465j.m2437b(m2141V(), 1);
        this.f7459d.m2385H(null);
        Collections.emptyList();
    }

    /* renamed from: V */
    public final boolean m2141V() {
        m2132ae();
        return this.f7459d.m2387F();
    }

    /* renamed from: W */
    public final void m2140W() {
        m2132ae();
        m2136aa();
        m2134ac(null);
        m2137Z(0, 0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: e */
    public final int mo2131e() {
        m2132ae();
        return this.f7459d.mo2131e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: f */
    public final int mo2130f() {
        m2132ae();
        return this.f7459d.mo2130f();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: g */
    public final int mo2129g() {
        m2132ae();
        return this.f7459d.mo2129g();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: h */
    public final int mo2128h() {
        m2132ae();
        return this.f7459d.mo2128h();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: i */
    public final long mo2127i() {
        m2132ae();
        return this.f7459d.mo2127i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: j */
    public final long mo2126j() {
        m2132ae();
        return this.f7459d.mo2126j();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: k */
    public final long mo2125k() {
        m2132ae();
        return this.f7459d.mo2125k();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: l */
    public final AbstractC2586bb mo2124l() {
        m2132ae();
        return this.f7459d.mo2124l();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: m */
    public final boolean mo2123m() {
        m2132ae();
        return this.f7459d.mo2123m();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: n */
    public final void mo2122n() {
        m2132ae();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: o */
    public final void mo2121o() {
        m2132ae();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2567aw
    /* renamed from: p */
    public final void mo2120p(int i) {
        m2132ae();
        this.f7463h.m2073V();
        this.f7459d.mo2120p(i);
    }

    /* renamed from: r */
    public final int m2118r() {
        m2132ae();
        return this.f7459d.m2376q();
    }

    /* renamed from: s */
    public final long m2117s() {
        m2132ae();
        return this.f7459d.m2375r();
    }

    /* renamed from: t */
    public final Looper m2116t() {
        return this.f7459d.m2374s();
    }
}
