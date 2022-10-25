package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vb */
/* loaded from: classes2.dex */
public final class C3126vb extends AbstractC3106ui {

    /* renamed from: c */
    private final int f9148c;

    /* renamed from: d */
    private final C2962p f9149d;

    /* renamed from: e */
    private long f9150e;

    /* renamed from: p */
    private boolean f9151p;

    public C3126vb(InterfaceC2637cz interfaceC2637cz, C2642dd c2642dd, C2962p c2962p, int i, long j, long j2, long j3, int i2, C2962p c2962p2) {
        super(interfaceC2637cz, c2642dd, c2962p, i, j, j2, C3282C.TIME_UNSET, C3282C.TIME_UNSET, j3);
        this.f9148c = i2;
        this.f9149d = c2962p2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: e */
    public final void mo701e() throws IOException {
        C3108uk m910c = m910c();
        m910c.m906a(0L);
        InterfaceC3253zu m904c = m910c.m904c(this.f9148c);
        m904c.mo443b(this.f9149d);
        try {
            long mo1127b = this.f9103n.mo1127b(this.f9096g.m2489b(this.f9150e));
            if (mo1127b != -1) {
                mo1127b += this.f9150e;
            }
            C3223yr c3223yr = new C3223yr(this.f9103n, this.f9150e, mo1127b);
            for (int i = 0; i != -1; i = m904c.mo444a(c3223yr, Integer.MAX_VALUE, true)) {
                this.f9150e += i;
            }
            m904c.mo441f(this.f9101l, 1, (int) this.f9150e, 0, null);
            C2616ce.m2682k(this.f9103n);
            this.f9151p = true;
        } catch (Throwable th) {
            C2616ce.m2682k(this.f9103n);
            throw th;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3122uy
    /* renamed from: g */
    public final boolean mo849g() {
        return this.f9151p;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: r */
    public final void mo700r() {
    }
}
