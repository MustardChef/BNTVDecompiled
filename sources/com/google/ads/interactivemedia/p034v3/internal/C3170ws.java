package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ws */
/* loaded from: classes2.dex */
public final class C3170ws implements InterfaceC3163wl {

    /* renamed from: a */
    public final long f9315a;

    /* renamed from: b */
    public final C2642dd f9316b;

    /* renamed from: c */
    public final int f9317c;

    /* renamed from: d */
    private final C2658dt f9318d;

    /* renamed from: e */
    private final InterfaceC3169wr f9319e;

    /* renamed from: f */
    private volatile Object f9320f;

    public C3170ws(InterfaceC2637cz interfaceC2637cz, Uri uri, int i, InterfaceC3169wr interfaceC3169wr) {
        C2641dc c2641dc = new C2641dc();
        c2641dc.m2492i(uri);
        c2641dc.m2499b(1);
        C2642dd m2500a = c2641dc.m2500a();
        this.f9318d = new C2658dt(interfaceC2637cz);
        this.f9316b = m2500a;
        this.f9317c = i;
        this.f9319e = interfaceC3169wr;
        this.f9315a = C3059sp.m1122a();
    }

    /* renamed from: a */
    public final long m713a() {
        return this.f9318d.m2471g();
    }

    /* renamed from: c */
    public final Uri m712c() {
        return this.f9318d.m2470h();
    }

    /* renamed from: d */
    public final Object m711d() {
        return this.f9320f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: e */
    public final void mo701e() throws IOException {
        this.f9318d.m2468j();
        C2640db c2640db = new C2640db(this.f9318d, this.f9316b);
        try {
            c2640db.m2502a();
            Uri mo1126c = this.f9318d.mo1126c();
            C2616ce.m2689d(mo1126c);
            this.f9320f = this.f9319e.mo714a(mo1126c, c2640db);
        } finally {
            C2628cq.m2566Q(c2640db);
        }
    }

    /* renamed from: f */
    public final Map m710f() {
        return this.f9318d.m2469i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: r */
    public final void mo700r() {
    }
}
