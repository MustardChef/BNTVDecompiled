package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.C3282C;
import java.util.concurrent.TimeoutException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.go */
/* loaded from: classes2.dex */
public final class C2734go {

    /* renamed from: a */
    private final InterfaceC2733gn f7425a;

    /* renamed from: b */
    private final InterfaceC2732gm f7426b;

    /* renamed from: c */
    private final InterfaceC2598bn f7427c;

    /* renamed from: d */
    private final AbstractC2586bb f7428d;

    /* renamed from: e */
    private int f7429e;

    /* renamed from: f */
    private Object f7430f;

    /* renamed from: g */
    private final Looper f7431g;

    /* renamed from: h */
    private final int f7432h;

    /* renamed from: i */
    private final long f7433i = C3282C.TIME_UNSET;

    /* renamed from: j */
    private final boolean f7434j = true;

    /* renamed from: k */
    private boolean f7435k;

    /* renamed from: l */
    private boolean f7436l;

    /* renamed from: m */
    private boolean f7437m;

    public C2734go(InterfaceC2732gm interfaceC2732gm, InterfaceC2733gn interfaceC2733gn, AbstractC2586bb abstractC2586bb, int i, InterfaceC2598bn interfaceC2598bn, Looper looper) {
        this.f7426b = interfaceC2732gm;
        this.f7425a = interfaceC2733gn;
        this.f7428d = abstractC2586bb;
        this.f7431g = looper;
        this.f7427c = interfaceC2598bn;
        this.f7432h = i;
    }

    /* renamed from: a */
    public final int m2203a() {
        return this.f7432h;
    }

    /* renamed from: b */
    public final int m2202b() {
        return this.f7429e;
    }

    /* renamed from: c */
    public final long m2201c() {
        return C3282C.TIME_UNSET;
    }

    /* renamed from: d */
    public final Looper m2200d() {
        return this.f7431g;
    }

    /* renamed from: e */
    public final AbstractC2586bb m2199e() {
        return this.f7428d;
    }

    /* renamed from: f */
    public final InterfaceC2733gn m2198f() {
        return this.f7425a;
    }

    /* renamed from: g */
    public final Object m2197g() {
        return this.f7430f;
    }

    /* renamed from: h */
    public final synchronized void m2196h(boolean z) {
        this.f7436l = z | this.f7436l;
        this.f7437m = true;
        notifyAll();
    }

    /* renamed from: i */
    public final boolean m2195i() {
        return true;
    }

    /* renamed from: j */
    public final synchronized void m2194j(long j) throws InterruptedException, TimeoutException {
        C2616ce.m2685h(this.f7435k);
        C2616ce.m2685h(this.f7431g.getThread() != Thread.currentThread());
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        while (!this.f7437m) {
            if (j > 0) {
                wait(j);
                j = elapsedRealtime - SystemClock.elapsedRealtime();
            } else {
                throw new TimeoutException("Message delivery timed out.");
            }
        }
    }

    /* renamed from: k */
    public final synchronized void m2193k() {
    }

    /* renamed from: l */
    public final void m2192l() {
        C2616ce.m2685h(!this.f7435k);
        C2616ce.m2687f(true);
        this.f7435k = true;
        this.f7426b.mo2204l(this);
    }

    /* renamed from: m */
    public final void m2191m(Object obj) {
        C2616ce.m2685h(!this.f7435k);
        this.f7430f = obj;
    }

    /* renamed from: n */
    public final void m2190n(int i) {
        C2616ce.m2685h(!this.f7435k);
        this.f7429e = i;
    }
}
