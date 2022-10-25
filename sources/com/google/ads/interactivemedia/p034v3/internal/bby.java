package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bby */
/* loaded from: classes2.dex */
final class bby extends azm {

    /* renamed from: a */
    final /* synthetic */ bbz f5404a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bby(bbz bbzVar, Class cls) {
        super(cls);
        this.f5404a = bbzVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boj mo4177a(bls blsVar) throws bnm {
        return bdq.m4022b(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4176c(boj bojVar) throws GeneralSecurityException {
        bdq bdqVar = (bdq) bojVar;
        KeyPair m3758c = bfo.m3758c(bfo.m3755f(bci.m4185c(bdqVar.m4021c().m4015d().m3984e())));
        ECPoint w = ((ECPublicKey) m3758c.getPublic()).getW();
        bep m3989m = bdt.m3989m();
        m3989m.m3868D();
        m3989m.m3869C(bdqVar.m4021c());
        m3989m.m3867E(bls.m3504t(w.getAffineX().toByteArray()));
        m3989m.m3866F(bls.m3504t(w.getAffineY().toByteArray()));
        bep m4001j = bds.m4001j();
        m4001j.m3863I();
        m4001j.m3864H((bdt) m3989m.mo3179aR());
        m4001j.m3865G(bls.m3504t(((ECPrivateKey) m3758c.getPrivate()).getS().toByteArray()));
        return (bds) m4001j.mo3179aR();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: d */
    public final Map mo4175d() throws GeneralSecurityException {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        byte[] bArr7;
        byte[] bArr8;
        byte[] bArr9;
        HashMap hashMap = new HashMap();
        int i = bdv.f5511b;
        int i2 = bdw.f5520d;
        int i3 = bdo.f5484b;
        azk m4248a = bac.m4248a("AES128_GCM");
        bArr = bbz.f5405a;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", bbz.m4195l(i, i2, i3, m4248a, bArr, 1));
        int i4 = bdv.f5511b;
        int i5 = bdw.f5520d;
        int i6 = bdo.f5484b;
        azk m4248a2 = bac.m4248a("AES128_GCM");
        bArr2 = bbz.f5405a;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", bbz.m4195l(i4, i5, i6, m4248a2, bArr2, 3));
        int i7 = bdv.f5511b;
        int i8 = bdw.f5520d;
        int i9 = bdo.f5485c;
        azk m4248a3 = bac.m4248a("AES128_GCM");
        bArr3 = bbz.f5405a;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", bbz.m4195l(i7, i8, i9, m4248a3, bArr3, 1));
        int i10 = bdv.f5511b;
        int i11 = bdw.f5520d;
        int i12 = bdo.f5485c;
        azk m4248a4 = bac.m4248a("AES128_GCM");
        bArr4 = bbz.f5405a;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", bbz.m4195l(i10, i11, i12, m4248a4, bArr4, 3));
        int i13 = bdv.f5511b;
        int i14 = bdw.f5520d;
        int i15 = bdo.f5485c;
        azk m4248a5 = bac.m4248a("AES128_GCM");
        bArr5 = bbz.f5405a;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", bbz.m4195l(i13, i14, i15, m4248a5, bArr5, 3));
        int i16 = bdv.f5511b;
        int i17 = bdw.f5520d;
        int i18 = bdo.f5484b;
        azk m4248a6 = bac.m4248a("AES128_CTR_HMAC_SHA256");
        bArr6 = bbz.f5405a;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", bbz.m4195l(i16, i17, i18, m4248a6, bArr6, 1));
        int i19 = bdv.f5511b;
        int i20 = bdw.f5520d;
        int i21 = bdo.f5484b;
        azk m4248a7 = bac.m4248a("AES128_CTR_HMAC_SHA256");
        bArr7 = bbz.f5405a;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", bbz.m4195l(i19, i20, i21, m4248a7, bArr7, 3));
        int i22 = bdv.f5511b;
        int i23 = bdw.f5520d;
        int i24 = bdo.f5485c;
        azk m4248a8 = bac.m4248a("AES128_CTR_HMAC_SHA256");
        bArr8 = bbz.f5405a;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", bbz.m4195l(i22, i23, i24, m4248a8, bArr8, 1));
        int i25 = bdv.f5511b;
        int i26 = bdw.f5520d;
        int i27 = bdo.f5485c;
        azk m4248a9 = bac.m4248a("AES128_CTR_HMAC_SHA256");
        bArr9 = bbz.f5405a;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", bbz.m4195l(i25, i26, i27, m4248a9, bArr9, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ void mo4174e(boj bojVar) throws GeneralSecurityException {
        bci.m4187a(((bdq) bojVar).m4021c());
    }
}
