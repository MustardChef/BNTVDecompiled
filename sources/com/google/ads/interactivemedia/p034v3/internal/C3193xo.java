package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xo */
/* loaded from: classes2.dex */
public final class C3193xo {

    /* renamed from: a */
    private final C3182xd f9418a = new C3182xd();

    /* renamed from: b */
    private final InterfaceC3189xk f9419b;

    /* renamed from: c */
    private final Choreographer$FrameCallbackC3192xn f9420c;

    /* renamed from: d */
    private boolean f9421d;

    /* renamed from: e */
    private Surface f9422e;

    /* renamed from: f */
    private float f9423f;

    /* renamed from: g */
    private float f9424g;

    /* renamed from: h */
    private float f9425h;

    /* renamed from: i */
    private float f9426i;

    /* renamed from: j */
    private int f9427j;

    /* renamed from: k */
    private long f9428k;

    /* renamed from: l */
    private long f9429l;

    /* renamed from: m */
    private long f9430m;

    /* renamed from: n */
    private long f9431n;

    /* renamed from: o */
    private long f9432o;

    /* renamed from: p */
    private long f9433p;

    /* renamed from: q */
    private long f9434q;

    public C3193xo(Context context) {
        InterfaceC3189xk interfaceC3189xk;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            interfaceC3189xk = C2628cq.f6961a >= 17 ? C3191xm.m615c(applicationContext) : null;
            if (interfaceC3189xk == null) {
                interfaceC3189xk = C3190xl.m618c(applicationContext);
            }
        } else {
            interfaceC3189xk = null;
        }
        this.f9419b = interfaceC3189xk;
        this.f9420c = interfaceC3189xk != null ? Choreographer$FrameCallbackC3192xn.m613a() : null;
        this.f9428k = C3282C.TIME_UNSET;
        this.f9429l = C3282C.TIME_UNSET;
        this.f9423f = -1.0f;
        this.f9426i = 1.0f;
        this.f9427j = 0;
    }

    /* renamed from: b */
    public static /* synthetic */ void m609b(C3193xo c3193xo, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            c3193xo.f9428k = refreshRate;
            c3193xo.f9429l = (refreshRate * 80) / 100;
            return;
        }
        Log.w("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        c3193xo.f9428k = C3282C.TIME_UNSET;
        c3193xo.f9429l = C3282C.TIME_UNSET;
    }

    /* renamed from: m */
    private final void m598m() {
        Surface surface;
        if (C2628cq.f6961a < 30 || (surface = this.f9422e) == null || this.f9427j == Integer.MIN_VALUE || this.f9425h == 0.0f) {
            return;
        }
        this.f9425h = 0.0f;
        C3188xj.m619a(surface, 0.0f);
    }

    /* renamed from: n */
    private final void m597n() {
        this.f9430m = 0L;
        this.f9433p = -1L;
        this.f9431n = -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0055, code lost:
        if (java.lang.Math.abs(r0 - r10.f9424g) >= r2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0060, code lost:
        if (r10.f9418a.m674b() >= 30) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0063, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0064, code lost:
        if (r3 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0067, code lost:
        return;
     */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m596o() {
        /*
            r10 = this;
            int r0 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.f6961a
            r1 = 30
            if (r0 < r1) goto L6d
            android.view.Surface r0 = r10.f9422e
            if (r0 != 0) goto Lb
            goto L6d
        Lb:
            com.google.ads.interactivemedia.v3.internal.xd r0 = r10.f9418a
            boolean r0 = r0.m669g()
            if (r0 == 0) goto L1a
            com.google.ads.interactivemedia.v3.internal.xd r0 = r10.f9418a
            float r0 = r0.m675a()
            goto L1c
        L1a:
            float r0 = r10.f9423f
        L1c:
            float r2 = r10.f9424g
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L23
            return
        L23:
            r3 = 1
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L58
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L58
            com.google.ads.interactivemedia.v3.internal.xd r1 = r10.f9418a
            boolean r1 = r1.m669g()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L4b
            com.google.ads.interactivemedia.v3.internal.xd r1 = r10.f9418a
            long r6 = r1.m672d()
            r8 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L4b
            r2 = 1017370378(0x3ca3d70a, float:0.02)
        L4b:
            float r1 = r10.f9424g
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L63
            goto L64
        L58:
            if (r6 != 0) goto L68
            com.google.ads.interactivemedia.v3.internal.xd r2 = r10.f9418a
            int r2 = r2.m674b()
            if (r2 < r1) goto L63
            goto L64
        L63:
            r3 = 0
        L64:
            if (r3 == 0) goto L67
            goto L68
        L67:
            return
        L68:
            r10.f9424g = r0
            r10.m595p(r5)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3193xo.m596o():void");
    }

    /* renamed from: p */
    private final void m595p(boolean z) {
        Surface surface;
        if (C2628cq.f6961a < 30 || (surface = this.f9422e) == null || this.f9427j == Integer.MIN_VALUE) {
            return;
        }
        float f = 0.0f;
        if (this.f9421d) {
            float f2 = this.f9424g;
            if (f2 != -1.0f) {
                f = this.f9426i * f2;
            }
        }
        if (z || this.f9425h != f) {
            this.f9425h = f;
            C3188xj.m619a(surface, f);
        }
    }

    /* renamed from: a */
    public final long m610a(long j) {
        long j2;
        if (this.f9433p != -1 && this.f9418a.m669g()) {
            long m673c = this.f9434q + (((float) (this.f9418a.m673c() * (this.f9430m - this.f9433p))) / this.f9426i);
            if (Math.abs(j - m673c) <= 20000000) {
                j = m673c;
            } else {
                m597n();
            }
        }
        this.f9431n = this.f9430m;
        this.f9432o = j;
        Choreographer$FrameCallbackC3192xn choreographer$FrameCallbackC3192xn = this.f9420c;
        if (choreographer$FrameCallbackC3192xn == null || this.f9428k == C3282C.TIME_UNSET) {
            return j;
        }
        long j3 = choreographer$FrameCallbackC3192xn.f9413a;
        if (j3 == C3282C.TIME_UNSET) {
            return j;
        }
        long j4 = this.f9428k;
        long j5 = j3 + (((j - j3) / j4) * j4);
        if (j <= j5) {
            j2 = j5 - j4;
        } else {
            j5 = j4 + j5;
            j2 = j5;
        }
        if (j5 - j >= j - j2) {
            j5 = j2;
        }
        return j5 - this.f9429l;
    }

    /* renamed from: c */
    public final void m608c() {
        InterfaceC3189xk interfaceC3189xk = this.f9419b;
        if (interfaceC3189xk != null) {
            interfaceC3189xk.mo617a();
            Choreographer$FrameCallbackC3192xn choreographer$FrameCallbackC3192xn = this.f9420c;
            C2616ce.m2689d(choreographer$FrameCallbackC3192xn);
            choreographer$FrameCallbackC3192xn.m611c();
        }
    }

    /* renamed from: d */
    public final void m607d() {
        if (this.f9419b != null) {
            Choreographer$FrameCallbackC3192xn choreographer$FrameCallbackC3192xn = this.f9420c;
            C2616ce.m2689d(choreographer$FrameCallbackC3192xn);
            choreographer$FrameCallbackC3192xn.m612b();
            this.f9419b.mo616b(new C3187xi(this));
        }
    }

    /* renamed from: e */
    public final void m606e(float f) {
        this.f9423f = f;
        this.f9418a.m670f();
        m596o();
    }

    /* renamed from: f */
    public final void m605f(long j) {
        long j2 = this.f9431n;
        if (j2 != -1) {
            this.f9433p = j2;
            this.f9434q = this.f9432o;
        }
        this.f9430m++;
        this.f9418a.m671e(j * 1000);
        m596o();
    }

    /* renamed from: g */
    public final void m604g(float f) {
        this.f9426i = f;
        m597n();
        m595p(false);
    }

    /* renamed from: h */
    public final void m603h() {
        m597n();
    }

    /* renamed from: i */
    public final void m602i() {
        this.f9421d = true;
        m597n();
        m595p(false);
    }

    /* renamed from: j */
    public final void m601j() {
        this.f9421d = false;
        m598m();
    }

    /* renamed from: k */
    public final void m600k(Surface surface) {
        if (true == (surface instanceof C3180xb)) {
            surface = null;
        }
        if (this.f9422e == surface) {
            return;
        }
        m598m();
        this.f9422e = surface;
        m595p(true);
    }

    /* renamed from: l */
    public final void m599l(int i) {
        if (this.f9427j == i) {
            return;
        }
        this.f9427j = i;
        m595p(true);
    }
}
