package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bcn */
/* loaded from: classes2.dex */
public final class bcn extends azo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bcn() {
        super(bcv.class, new bcl(azs.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static void m4180m(bcx bcxVar) throws GeneralSecurityException {
        if (bcxVar.m4143a() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (bcxVar.m4143a() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static void m4179n(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: a */
    public final azm mo4173a() {
        return new bcm(bcw.class);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boj mo4172b(bls blsVar) throws bnm {
        return bcv.m4157c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: f */
    public final String mo4171f() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ void mo4170h(boj bojVar) throws GeneralSecurityException {
        bcv bcvVar = (bcv) bojVar;
        bfv.m3735b(bcvVar.m4159a());
        m4179n(bcvVar.m4155e().mo3054d());
        m4180m(bcvVar.m4156d());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: j */
    public final int mo4168j() {
        return bea.f5537b;
    }
}
