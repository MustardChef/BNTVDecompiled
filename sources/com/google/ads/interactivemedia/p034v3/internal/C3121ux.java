package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ux */
/* loaded from: classes2.dex */
public final class C3121ux extends AbstractC3112uo {

    /* renamed from: a */
    private final InterfaceC3113up f9142a;

    /* renamed from: b */
    private long f9143b;

    /* renamed from: c */
    private volatile boolean f9144c;

    /* renamed from: d */
    private C3108uk f9145d;

    public C3121ux(InterfaceC2637cz interfaceC2637cz, C2642dd c2642dd, C2962p c2962p, int i, InterfaceC3113up interfaceC3113up) {
        super(interfaceC2637cz, c2642dd, 2, c2962p, i, C3282C.TIME_UNSET, C3282C.TIME_UNSET);
        this.f9142a = interfaceC3113up;
    }

    /* renamed from: a */
    public final void m854a(C3108uk c3108uk) {
        this.f9145d = c3108uk;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: e */
    public final void mo701e() throws IOException {
        if (this.f9143b == 0) {
            this.f9142a.mo895e(this.f9145d, C3282C.TIME_UNSET, C3282C.TIME_UNSET);
        }
        try {
            C2642dd m2489b = this.f9096g.m2489b(this.f9143b);
            C2658dt c2658dt = this.f9103n;
            C3223yr c3223yr = new C3223yr(c2658dt, m2489b.f7015e, c2658dt.mo1127b(m2489b));
            while (!this.f9144c && this.f9142a.mo897c(c3223yr)) {
            }
            this.f9143b = c3223yr.mo498d() - this.f9096g.f7015e;
        } finally {
            C2616ce.m2682k(this.f9103n);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: r */
    public final void mo700r() {
        this.f9144c = true;
    }
}
