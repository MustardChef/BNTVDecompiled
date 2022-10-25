package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bbt */
/* loaded from: classes2.dex */
public final class bbt extends azo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bbt() {
        super(bdk.class, new bbr(aze.class));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: a */
    public final azm mo4173a() {
        return new bbs(this, bdl.class);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boj mo4172b(bls blsVar) throws bnm {
        return bdk.m4050c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: f */
    public final String mo4171f() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ void mo4170h(boj bojVar) throws GeneralSecurityException {
        bdk bdkVar = (bdk) bojVar;
        bfv.m3735b(bdkVar.m4052a());
        if (bdkVar.m4049d().mo3054d() == 64) {
            return;
        }
        int mo3054d = bdkVar.m4049d().mo3054d();
        StringBuilder sb = new StringBuilder(61);
        sb.append("invalid key size: ");
        sb.append(mo3054d);
        sb.append(". Valid keys must have 64 bytes.");
        throw new InvalidKeyException(sb.toString());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: j */
    public final int mo4168j() {
        return bea.f5537b;
    }
}
