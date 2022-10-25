package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bba */
/* loaded from: classes2.dex */
public final class bba extends azo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bba() {
        super(bdm.class, new bay(azb.class));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: a */
    public final azm mo4173a() {
        return new baz(this, bdn.class);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boj mo4172b(bls blsVar) throws bnm {
        return bdm.m4038c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: f */
    public final String mo4171f() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ void mo4170h(boj bojVar) throws GeneralSecurityException {
        bdm bdmVar = (bdm) bojVar;
        bfv.m3735b(bdmVar.m4040a());
        if (bdmVar.m4037d().mo3054d() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: j */
    public final int mo4168j() {
        return bea.f5537b;
    }
}
