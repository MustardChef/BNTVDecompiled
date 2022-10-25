package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lw */
/* loaded from: classes2.dex */
public final class C2877lw extends AbstractC2875lu {

    /* renamed from: e */
    final C2884mc f8068e;

    /* renamed from: f */
    final C2884mc f8069f;

    /* renamed from: g */
    final long f8070g;

    public C2877lw(C2871lq c2871lq, long j, long j2, long j3, long j4, long j5, List list, long j6, C2884mc c2884mc, C2884mc c2884mc2, long j7, long j8) {
        super(c2871lq, j, j2, j3, j5, list, j6, j7, j8);
        this.f8068e = c2884mc;
        this.f8069f = c2884mc2;
        this.f8070g = j4;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2875lu
    /* renamed from: c */
    public final long mo1665c(long j) {
        List list = this.f8063c;
        if (list != null) {
            return list.size();
        }
        long j2 = this.f8070g;
        if (j2 != -1) {
            return (j2 - this.f8061a) + 1;
        }
        if (j != C3282C.TIME_UNSET) {
            return axi.m4383a(BigInteger.valueOf(j).multiply(BigInteger.valueOf(this.f8076i)), BigInteger.valueOf(this.f8062b).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
        }
        return -1L;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2875lu
    /* renamed from: g */
    public final C2871lq mo1664g(AbstractC2874lt abstractC2874lt, long j) {
        List list = this.f8063c;
        long j2 = list != null ? ((C2878lx) list.get((int) (j - this.f8061a))).f8071a : (j - this.f8061a) * this.f8062b;
        C2884mc c2884mc = this.f8069f;
        C2962p c2962p = abstractC2874lt.f8057b;
        return new C2871lq(c2884mc.m1649b(c2962p.f8361a, j, c2962p.f8368h, j2), 0L, -1L);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C2880lz
    /* renamed from: i */
    public final C2871lq mo1663i(AbstractC2874lt abstractC2874lt) {
        C2884mc c2884mc = this.f8068e;
        if (c2884mc != null) {
            C2962p c2962p = abstractC2874lt.f8057b;
            return new C2871lq(c2884mc.m1649b(c2962p.f8361a, 0L, c2962p.f8368h, 0L), 0L, -1L);
        }
        return this.f8075h;
    }
}
