package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bao */
/* loaded from: classes2.dex */
public final class bao extends azo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bao() {
        super(bda.class, new bam(bfn.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static final void m4215m(bdc bdcVar) throws GeneralSecurityException {
        if (bdcVar.m4102a() < 12 || bdcVar.m4102a() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: a */
    public final azm mo4173a() {
        return new ban(this, bdb.class);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boj mo4172b(bls blsVar) throws bnm {
        return bda.m4117d(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: f */
    public final String mo4171f() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: j */
    public final int mo4168j() {
        return bea.f5537b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: l */
    public final void mo4170h(bda bdaVar) throws GeneralSecurityException {
        bfv.m3735b(bdaVar.m4120a());
        bfv.m3736a(bdaVar.m4115f().mo3054d());
        m4215m(bdaVar.m4116e());
    }
}
