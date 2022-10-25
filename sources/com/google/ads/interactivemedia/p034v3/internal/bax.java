package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bax */
/* loaded from: classes2.dex */
public final class bax extends azo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bax() {
        super(bdi.class, new bav(azb.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* bridge */ /* synthetic */ azl m4212k(int i, int i2) {
        bep m4053e = bdj.m4053e();
        m4053e.m3852T(i);
        return new azl((bdj) m4053e.mo3179aR(), i2);
    }

    /* renamed from: l */
    public static void m4211l() throws GeneralSecurityException {
        if (m4210m()) {
            bae.m4229n(new bax());
        }
    }

    /* renamed from: m */
    private static boolean m4210m() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: a */
    public final azm mo4173a() {
        return new baw(this, bdj.class);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boj mo4172b(bls blsVar) throws bnm {
        return bdi.m4062c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: f */
    public final String mo4171f() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ void mo4170h(boj bojVar) throws GeneralSecurityException {
        bdi bdiVar = (bdi) bojVar;
        bfv.m3735b(bdiVar.m4064a());
        bfv.m3736a(bdiVar.m4061d().mo3054d());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: j */
    public final int mo4168j() {
        return bea.f5537b;
    }
}
