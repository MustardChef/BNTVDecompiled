package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bau */
/* loaded from: classes2.dex */
public final class bau extends azo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bau() {
        super(bdg.class, new bas(azb.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* bridge */ /* synthetic */ azl m4213k(int i, int i2) {
        bep m4065e = bdh.m4065e();
        m4065e.m3849W(i);
        return new azl((bdh) m4065e.mo3179aR(), i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: a */
    public final azm mo4173a() {
        return new bat(this, bdh.class);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boj mo4172b(bls blsVar) throws bnm {
        return bdg.m4074c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: f */
    public final String mo4171f() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ void mo4170h(boj bojVar) throws GeneralSecurityException {
        bdg bdgVar = (bdg) bojVar;
        bfv.m3735b(bdgVar.m4076a());
        bfv.m3736a(bdgVar.m4073d().mo3054d());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: i */
    public final int mo4169i() {
        return bbp.f5397b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: j */
    public final int mo4168j() {
        return bea.f5537b;
    }
}
