package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bar */
/* loaded from: classes2.dex */
public final class bar extends azo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bar() {
        super(bdd.class, new bap(azb.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* bridge */ /* synthetic */ azl m4214k(int i, int i2) {
        bep m4082g = bde.m4082g();
        m4082g.m3844aa(i);
        bep m4077e = bdf.m4077e();
        m4077e.m3846Z();
        m4082g.m3843ab((bdf) m4077e.mo3179aR());
        return new azl((bde) m4082g.mo3179aR(), i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: a */
    public final azm mo4173a() {
        return new baq(this, bde.class);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boj mo4172b(bls blsVar) throws bnm {
        return bdd.m4095c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: f */
    public final String mo4171f() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ void mo4170h(boj bojVar) throws GeneralSecurityException {
        bdd bddVar = (bdd) bojVar;
        bfv.m3735b(bddVar.m4097a());
        bfv.m3736a(bddVar.m4093e().mo3054d());
        if (bddVar.m4094d().m4081a() != 12 && bddVar.m4094d().m4081a() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: j */
    public final int mo4168j() {
        return bea.f5537b;
    }
}
