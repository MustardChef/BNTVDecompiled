package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ar */
/* loaded from: classes2.dex */
public final class C2560ar {

    /* renamed from: a */
    private final C2881m f4922a = new C2881m();

    /* renamed from: a */
    public final C2561as m4743a() {
        return new C2561as(this.f4922a.m1662a());
    }

    /* renamed from: b */
    public final void m4742b(int i) {
        this.f4922a.m1661b(i);
    }

    /* renamed from: c */
    public final void m4741c(C2561as c2561as) {
        C2908n c2908n;
        C2881m c2881m = this.f4922a;
        c2908n = c2561as.f4971a;
        for (int i = 0; i < c2908n.m1597b(); i++) {
            c2881m.m1661b(c2908n.m1598a(i));
        }
    }

    /* renamed from: d */
    public final void m4740d(int... iArr) {
        C2881m c2881m = this.f4922a;
        for (int i : iArr) {
            c2881m.m1661b(i);
        }
    }

    /* renamed from: e */
    public final void m4739e(int i, boolean z) {
        C2881m c2881m = this.f4922a;
        if (z) {
            c2881m.m1661b(i);
        }
    }
}
