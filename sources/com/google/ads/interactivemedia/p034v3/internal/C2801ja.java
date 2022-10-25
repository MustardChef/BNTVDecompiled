package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ja */
/* loaded from: classes2.dex */
public final class C2801ja {

    /* renamed from: a */
    private final Handler f7642a;

    /* renamed from: b */
    private final InterfaceC2802jb f7643b;

    public C2801ja(Handler handler, InterfaceC2802jb interfaceC2802jb) {
        this.f7642a = interfaceC2802jb == null ? null : handler;
        this.f7643b = interfaceC2802jb;
    }

    /* renamed from: a */
    public final void m1973a(Exception exc) {
        Handler handler = this.f7642a;
        if (handler != null) {
            handler.post(new RunnableC2796iw(this, exc, 1));
        }
    }

    /* renamed from: b */
    public final void m1972b(Exception exc) {
        Handler handler = this.f7642a;
        if (handler != null) {
            handler.post(new RunnableC2796iw(this, exc, 0));
        }
    }

    /* renamed from: c */
    public final void m1971c(final String str, final long j, final long j2) {
        Handler handler = this.f7642a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.iy
                @Override // java.lang.Runnable
                public final void run() {
                    C2801ja.this.m1964j(str, j, j2);
                }
            });
        }
    }

    /* renamed from: d */
    public final void m1970d(final String str) {
        Handler handler = this.f7642a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.ix
                @Override // java.lang.Runnable
                public final void run() {
                    C2801ja.this.m1963k(str);
                }
            });
        }
    }

    /* renamed from: e */
    public final void m1969e(C2679en c2679en) {
        c2679en.m2422a();
        Handler handler = this.f7642a;
        if (handler != null) {
            handler.post(new RunnableC2795iv(this, c2679en, 1));
        }
    }

    /* renamed from: f */
    public final void m1968f(C2679en c2679en) {
        Handler handler = this.f7642a;
        if (handler != null) {
            handler.post(new RunnableC2795iv(this, c2679en, 0));
        }
    }

    /* renamed from: g */
    public final void m1967g(final C2962p c2962p, final C2680eo c2680eo) {
        Handler handler = this.f7642a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.iu
                @Override // java.lang.Runnable
                public final void run() {
                    C2801ja.this.m1960n(c2962p, c2680eo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final /* synthetic */ void m1966h(Exception exc) {
        InterfaceC2802jb interfaceC2802jb = this.f7643b;
        int i = C2628cq.f6961a;
        interfaceC2802jb.mo1945y(exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public final /* synthetic */ void m1965i(Exception exc) {
        InterfaceC2802jb interfaceC2802jb = this.f7643b;
        int i = C2628cq.f6961a;
        interfaceC2802jb.mo1948F(exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final /* synthetic */ void m1964j(String str, long j, long j2) {
        InterfaceC2802jb interfaceC2802jb = this.f7643b;
        int i = C2628cq.f6961a;
        interfaceC2802jb.mo1944z(str, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final /* synthetic */ void m1963k(String str) {
        InterfaceC2802jb interfaceC2802jb = this.f7643b;
        int i = C2628cq.f6961a;
        interfaceC2802jb.mo1953A(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public final /* synthetic */ void m1962l(C2679en c2679en) {
        c2679en.m2422a();
        InterfaceC2802jb interfaceC2802jb = this.f7643b;
        int i = C2628cq.f6961a;
        interfaceC2802jb.mo1952B(c2679en);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public final /* synthetic */ void m1961m(C2679en c2679en) {
        InterfaceC2802jb interfaceC2802jb = this.f7643b;
        int i = C2628cq.f6961a;
        interfaceC2802jb.mo1951C(c2679en);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public final /* synthetic */ void m1960n(C2962p c2962p, C2680eo c2680eo) {
        int i = C2628cq.f6961a;
        this.f7643b.mo1950D(c2962p, c2680eo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public final /* synthetic */ void m1959o(long j) {
        InterfaceC2802jb interfaceC2802jb = this.f7643b;
        int i = C2628cq.f6961a;
        interfaceC2802jb.mo1949E(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public final /* synthetic */ void m1958p(boolean z) {
        InterfaceC2802jb interfaceC2802jb = this.f7643b;
        int i = C2628cq.f6961a;
        interfaceC2802jb.mo1946v(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public final /* synthetic */ void m1957q(int i, long j, long j2) {
        InterfaceC2802jb interfaceC2802jb = this.f7643b;
        int i2 = C2628cq.f6961a;
        interfaceC2802jb.mo1947G(i, j, j2);
    }

    /* renamed from: r */
    public final void m1956r(final long j) {
        Handler handler = this.f7642a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.it
                @Override // java.lang.Runnable
                public final void run() {
                    C2801ja.this.m1959o(j);
                }
            });
        }
    }

    /* renamed from: s */
    public final void m1955s(final boolean z) {
        Handler handler = this.f7642a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.iz
                @Override // java.lang.Runnable
                public final void run() {
                    C2801ja.this.m1958p(z);
                }
            });
        }
    }

    /* renamed from: t */
    public final void m1954t(final int i, final long j, final long j2) {
        Handler handler = this.f7642a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.is
                @Override // java.lang.Runnable
                public final void run() {
                    C2801ja.this.m1957q(i, j, j2);
                }
            });
        }
    }
}
