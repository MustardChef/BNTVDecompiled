package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.uy */
/* loaded from: classes2.dex */
public abstract class AbstractC3122uy extends AbstractC3112uo {

    /* renamed from: o */
    public final long f9146o;

    public AbstractC3122uy(InterfaceC2637cz interfaceC2637cz, C2642dd c2642dd, C2962p c2962p, int i, long j, long j2, long j3) {
        super(interfaceC2637cz, c2642dd, 1, c2962p, i, j, j2);
        C2616ce.m2689d(c2962p);
        this.f9146o = j3;
    }

    /* renamed from: g */
    public abstract boolean mo849g();

    /* renamed from: s */
    public long mo853s() {
        long j = this.f9146o;
        if (j != -1) {
            return j + 1;
        }
        return -1L;
    }
}
