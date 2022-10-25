package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bal */
/* loaded from: classes2.dex */
public final class bal extends azo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bal() {
        super(bcy.class, new baj(azb.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* bridge */ /* synthetic */ azl m4218k(int i, int i2, int i3, int i4) {
        bep m4103h = bdb.m4103h();
        bep m4098e = bdc.m4098e();
        m4098e.m3839af();
        m4103h.m3837ah((bdc) m4098e.mo3179aR());
        m4103h.m3838ag(i);
        bep m3958h = bdy.m3958h();
        bep m3951g = bdz.m3951g();
        m3951g.m3804t(i3);
        m3951g.m3805s(i2);
        m3958h.m3802v((bdz) m3951g.mo3179aR());
        m3958h.m3803u(32);
        bep m4123g = bcz.m4123g();
        m4123g.m3833al((bdb) m4103h.mo3179aR());
        m4123g.m3832am((bdy) m3958h.mo3179aR());
        return new azl((bcz) m4123g.mo3179aR(), i4);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: a */
    public final azm mo4173a() {
        return new bak(this, bcz.class);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boj mo4172b(bls blsVar) throws bnm {
        return bcy.m4136c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: f */
    public final String mo4171f() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ void mo4170h(boj bojVar) throws GeneralSecurityException {
        bcy bcyVar = (bcy) bojVar;
        bfv.m3735b(bcyVar.m4138a());
        new bao().mo4170h(bcyVar.m4135d());
        new bcq();
        bcq.m4166l(bcyVar.m4134e());
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
