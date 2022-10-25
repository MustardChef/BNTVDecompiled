package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xx */
/* loaded from: classes2.dex */
public final class C3202xx {

    /* renamed from: a */
    private final Handler f9458a;

    /* renamed from: b */
    private final InterfaceC3203xy f9459b;

    public C3202xx(Handler handler, InterfaceC3203xy interfaceC3203xy) {
        this.f9458a = interfaceC3203xy == null ? null : handler;
        this.f9459b = interfaceC3203xy;
    }

    /* renamed from: a */
    public final void m594a(final String str, final long j, final long j2) {
        Handler handler = this.f9458a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.xw
                @Override // java.lang.Runnable
                public final void run() {
                    C3202xx.this.m588g(str, j, j2);
                }
            });
        }
    }

    /* renamed from: b */
    public final void m593b(final String str) {
        Handler handler = this.f9458a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.xv
                @Override // java.lang.Runnable
                public final void run() {
                    C3202xx.this.m587h(str);
                }
            });
        }
    }

    /* renamed from: c */
    public final void m592c(C2679en c2679en) {
        c2679en.m2422a();
        Handler handler = this.f9458a;
        if (handler != null) {
            handler.post(new RunnableC3197xs(this, c2679en, 1));
        }
    }

    /* renamed from: d */
    public final void m591d(int i, long j) {
        Handler handler = this.f9458a;
        if (handler != null) {
            handler.post(new RunnableC3194xp(this, i, j, 1));
        }
    }

    /* renamed from: e */
    public final void m590e(C2679en c2679en) {
        Handler handler = this.f9458a;
        if (handler != null) {
            handler.post(new RunnableC3197xs(this, c2679en, 0));
        }
    }

    /* renamed from: f */
    public final void m589f(final C2962p c2962p, final C2680eo c2680eo) {
        Handler handler = this.f9458a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.xq
                @Override // java.lang.Runnable
                public final void run() {
                    C3202xx.this.m583l(c2962p, c2680eo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final /* synthetic */ void m588g(String str, long j, long j2) {
        InterfaceC3203xy interfaceC3203xy = this.f9459b;
        int i = C2628cq.f6961a;
        interfaceC3203xy.mo571K(str, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final /* synthetic */ void m587h(String str) {
        InterfaceC3203xy interfaceC3203xy = this.f9459b;
        int i = C2628cq.f6961a;
        interfaceC3203xy.mo570L(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public final /* synthetic */ void m586i(C2679en c2679en) {
        c2679en.m2422a();
        InterfaceC3203xy interfaceC3203xy = this.f9459b;
        int i = C2628cq.f6961a;
        interfaceC3203xy.mo569M(c2679en);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final /* synthetic */ void m585j(int i, long j) {
        InterfaceC3203xy interfaceC3203xy = this.f9459b;
        int i2 = C2628cq.f6961a;
        interfaceC3203xy.mo574H(i, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final /* synthetic */ void m584k(C2679en c2679en) {
        InterfaceC3203xy interfaceC3203xy = this.f9459b;
        int i = C2628cq.f6961a;
        interfaceC3203xy.mo568N(c2679en);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public final /* synthetic */ void m583l(C2962p c2962p, C2680eo c2680eo) {
        int i = C2628cq.f6961a;
        this.f9459b.mo566P(c2962p, c2680eo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public final /* synthetic */ void m582m(Object obj, long j) {
        InterfaceC3203xy interfaceC3203xy = this.f9459b;
        int i = C2628cq.f6961a;
        interfaceC3203xy.mo573I(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public final /* synthetic */ void m581n(long j, int i) {
        InterfaceC3203xy interfaceC3203xy = this.f9459b;
        int i2 = C2628cq.f6961a;
        interfaceC3203xy.mo567O(j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public final /* synthetic */ void m580o(Exception exc) {
        InterfaceC3203xy interfaceC3203xy = this.f9459b;
        int i = C2628cq.f6961a;
        interfaceC3203xy.mo572J(exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public final /* synthetic */ void m579p(C2597bm c2597bm) {
        InterfaceC3203xy interfaceC3203xy = this.f9459b;
        int i = C2628cq.f6961a;
        interfaceC3203xy.mo565x(c2597bm);
    }

    /* renamed from: q */
    public final void m578q(final Object obj) {
        if (this.f9458a != null) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f9458a.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.xu
                @Override // java.lang.Runnable
                public final void run() {
                    C3202xx.this.m582m(obj, elapsedRealtime);
                }
            });
        }
    }

    /* renamed from: r */
    public final void m577r(long j, int i) {
        Handler handler = this.f9458a;
        if (handler != null) {
            handler.post(new RunnableC3194xp(this, j, i, 0));
        }
    }

    /* renamed from: s */
    public final void m576s(final Exception exc) {
        Handler handler = this.f9458a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.xt
                @Override // java.lang.Runnable
                public final void run() {
                    C3202xx.this.m580o(exc);
                }
            });
        }
    }

    /* renamed from: t */
    public final void m575t(final C2597bm c2597bm) {
        Handler handler = this.f9458a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.xr
                @Override // java.lang.Runnable
                public final void run() {
                    C3202xx.this.m579p(c2597bm);
                }
            });
        }
    }
}
