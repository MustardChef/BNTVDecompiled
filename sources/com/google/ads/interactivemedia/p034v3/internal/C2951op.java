package com.google.ads.interactivemedia.p034v3.internal;

import android.os.SystemClock;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.op */
/* loaded from: classes2.dex */
final class C2951op extends AbstractC3131vg {

    /* renamed from: d */
    private int f8257d;

    public C2951op(C2587bc c2587bc, int[] iArr) {
        super(c2587bc, iArr);
        this.f8257d = mo837c(c2587bc.m4193b(iArr[0]));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: g */
    public final int mo797g() {
        return this.f8257d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: h */
    public final int mo796h() {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: i */
    public final void mo795i() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: j */
    public final void mo794j(long j, long j2, List list, InterfaceC3125va[] interfaceC3125vaArr) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (mo799s(this.f8257d, elapsedRealtime)) {
            int i = this.f9167b;
            do {
                i--;
                if (i < 0) {
                    throw new IllegalStateException();
                }
            } while (mo799s(i, elapsedRealtime));
            this.f8257d = i;
        }
    }
}
