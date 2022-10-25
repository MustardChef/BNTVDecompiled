package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.sd */
/* loaded from: classes2.dex */
public final class C3047sd implements InterfaceC3100uc {

    /* renamed from: a */
    protected final InterfaceC3100uc[] f8817a;

    public C3047sd(InterfaceC3100uc[] interfaceC3100ucArr) {
        this.f8817a = interfaceC3100ucArr;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: bg */
    public final long mo888bg() {
        long j = Long.MAX_VALUE;
        for (InterfaceC3100uc interfaceC3100uc : this.f8817a) {
            long mo888bg = interfaceC3100uc.mo888bg();
            if (mo888bg != Long.MIN_VALUE) {
                j = Math.min(j, mo888bg);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: c */
    public final long mo887c() {
        long j = Long.MAX_VALUE;
        for (InterfaceC3100uc interfaceC3100uc : this.f8817a) {
            long mo887c = interfaceC3100uc.mo887c();
            if (mo887c != Long.MIN_VALUE) {
                j = Math.min(j, mo887c);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: l */
    public final void mo878l(long j) {
        for (InterfaceC3100uc interfaceC3100uc : this.f8817a) {
            interfaceC3100uc.mo878l(j);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: o */
    public final boolean mo875o(long j) {
        InterfaceC3100uc[] interfaceC3100ucArr;
        boolean z;
        boolean z2 = false;
        do {
            long mo887c = mo887c();
            if (mo887c == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (InterfaceC3100uc interfaceC3100uc : this.f8817a) {
                long mo887c2 = interfaceC3100uc.mo887c();
                boolean z3 = mo887c2 != Long.MIN_VALUE && mo887c2 <= j;
                if (mo887c2 == mo887c || z3) {
                    z |= interfaceC3100uc.mo875o(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: p */
    public final boolean mo874p() {
        for (InterfaceC3100uc interfaceC3100uc : this.f8817a) {
            if (interfaceC3100uc.mo874p()) {
                return true;
            }
        }
        return false;
    }
}
