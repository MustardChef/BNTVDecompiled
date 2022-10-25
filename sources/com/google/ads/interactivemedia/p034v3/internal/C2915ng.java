package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ng */
/* loaded from: classes2.dex */
public final class C2915ng {

    /* renamed from: a */
    public final int f8182a;

    /* renamed from: b */
    public final C3067sx f8183b;

    /* renamed from: c */
    private final CopyOnWriteArrayList f8184c;

    public C2915ng() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    private C2915ng(CopyOnWriteArrayList copyOnWriteArrayList, int i, C3067sx c3067sx) {
        this.f8184c = copyOnWriteArrayList;
        this.f8182a = i;
        this.f8183b = c3067sx;
    }

    /* renamed from: a */
    public final C2915ng m1596a(int i, C3067sx c3067sx) {
        return new C2915ng(this.f8184c, i, c3067sx);
    }

    /* renamed from: b */
    public final void m1595b(Handler handler, InterfaceC2916nh interfaceC2916nh) {
        C2616ce.m2689d(handler);
        C2616ce.m2689d(interfaceC2916nh);
        this.f8184c.add(new C2914nf(handler, interfaceC2916nh));
    }

    /* renamed from: c */
    public final void m1594c() {
        Iterator it = this.f8184c.iterator();
        while (it.hasNext()) {
            C2914nf c2914nf = (C2914nf) it.next();
            C2628cq.m2537as(c2914nf.f8180a, new RunnableC2911nc(this, c2914nf.f8181b, 1));
        }
    }

    /* renamed from: d */
    public final void m1593d() {
        Iterator it = this.f8184c.iterator();
        while (it.hasNext()) {
            C2914nf c2914nf = (C2914nf) it.next();
            C2628cq.m2537as(c2914nf.f8180a, new RunnableC2911nc(this, c2914nf.f8181b, 0));
        }
    }

    /* renamed from: e */
    public final void m1592e(final int i) {
        Iterator it = this.f8184c.iterator();
        while (it.hasNext()) {
            C2914nf c2914nf = (C2914nf) it.next();
            final InterfaceC2916nh interfaceC2916nh = c2914nf.f8181b;
            C2628cq.m2537as(c2914nf.f8180a, new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.nd
                @Override // java.lang.Runnable
                public final void run() {
                    C2915ng c2915ng = C2915ng.this;
                    InterfaceC2916nh interfaceC2916nh2 = interfaceC2916nh;
                    int i2 = i;
                    interfaceC2916nh2.mo1172at();
                    interfaceC2916nh2.mo1169d(c2915ng.f8182a, c2915ng.f8183b, i2);
                }
            });
        }
    }

    /* renamed from: f */
    public final void m1591f(final Exception exc) {
        Iterator it = this.f8184c.iterator();
        while (it.hasNext()) {
            C2914nf c2914nf = (C2914nf) it.next();
            final InterfaceC2916nh interfaceC2916nh = c2914nf.f8181b;
            C2628cq.m2537as(c2914nf.f8180a, new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.ne
                @Override // java.lang.Runnable
                public final void run() {
                    C2915ng c2915ng = C2915ng.this;
                    interfaceC2916nh.mo1168e(c2915ng.f8182a, c2915ng.f8183b, exc);
                }
            });
        }
    }

    /* renamed from: g */
    public final void m1590g() {
        Iterator it = this.f8184c.iterator();
        while (it.hasNext()) {
            C2914nf c2914nf = (C2914nf) it.next();
            C2628cq.m2537as(c2914nf.f8180a, new RunnableC2911nc(this, c2914nf.f8181b, 2));
        }
    }

    /* renamed from: h */
    public final void m1589h(InterfaceC2916nh interfaceC2916nh) {
        Iterator it = this.f8184c.iterator();
        while (it.hasNext()) {
            C2914nf c2914nf = (C2914nf) it.next();
            if (c2914nf.f8181b == interfaceC2916nh) {
                this.f8184c.remove(c2914nf);
            }
        }
    }
}
