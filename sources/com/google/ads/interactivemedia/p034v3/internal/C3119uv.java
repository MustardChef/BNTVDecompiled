package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.uv */
/* loaded from: classes2.dex */
public final class C3119uv extends AbstractC3106ui {

    /* renamed from: c */
    private final int f9134c;

    /* renamed from: d */
    private final long f9135d;

    /* renamed from: e */
    private final InterfaceC3113up f9136e;

    /* renamed from: p */
    private long f9137p;

    /* renamed from: q */
    private volatile boolean f9138q;

    /* renamed from: r */
    private boolean f9139r;

    public C3119uv(InterfaceC2637cz interfaceC2637cz, C2642dd c2642dd, C2962p c2962p, int i, long j, long j2, long j3, long j4, long j5, int i2, long j6, InterfaceC3113up interfaceC3113up) {
        super(interfaceC2637cz, c2642dd, c2962p, i, j, j2, j3, j4, j5);
        this.f9134c = i2;
        this.f9135d = j6;
        this.f9136e = interfaceC3113up;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: e */
    public final void mo701e() throws IOException {
        if (this.f9137p == 0) {
            C3108uk m910c = m910c();
            m910c.m906a(this.f9135d);
            InterfaceC3113up interfaceC3113up = this.f9136e;
            long j = this.f9067a;
            long j2 = j == C3282C.TIME_UNSET ? -9223372036854775807L : j - this.f9135d;
            long j3 = this.f9068b;
            interfaceC3113up.mo895e(m910c, j2, j3 == C3282C.TIME_UNSET ? -9223372036854775807L : j3 - this.f9135d);
        }
        try {
            C2642dd m2489b = this.f9096g.m2489b(this.f9137p);
            C2658dt c2658dt = this.f9103n;
            C3223yr c3223yr = new C3223yr(c2658dt, m2489b.f7015e, c2658dt.mo1127b(m2489b));
            while (!this.f9138q && this.f9136e.mo897c(c3223yr)) {
            }
            this.f9137p = c3223yr.mo498d() - this.f9096g.f7015e;
            C2616ce.m2682k(this.f9103n);
            this.f9139r = !this.f9138q;
        } catch (Throwable th) {
            C2616ce.m2682k(this.f9103n);
            throw th;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3122uy
    /* renamed from: g */
    public final boolean mo849g() {
        return this.f9139r;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: r */
    public final void mo700r() {
        this.f9138q = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3122uy
    /* renamed from: s */
    public final long mo853s() {
        return this.f9146o + this.f9134c;
    }
}
