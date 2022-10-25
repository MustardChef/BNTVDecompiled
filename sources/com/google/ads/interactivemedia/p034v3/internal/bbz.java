package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bbz */
/* loaded from: classes2.dex */
public final class bbz extends azy {

    /* renamed from: a */
    private static final byte[] f5405a = new byte[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public bbz() {
        super(bds.class, new bbx(azf.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static /* bridge */ /* synthetic */ azl m4195l(int i, int i2, int i3, azk azkVar, byte[] bArr, int i4) {
        int i5;
        bep m4019e = bdq.m4019e();
        bep m3980j = bdu.m3980j();
        m3980j.m3871A(i);
        m3980j.m3870B(i2);
        m3980j.m3798z(bls.m3504t(bArr));
        bdu bduVar = (bdu) m3980j.mo3179aR();
        bep m3929j = bed.m3929j();
        m3929j.m3811m(azkVar.m4277a());
        m3929j.m3810n(bls.m3504t(azkVar.m4276b()));
        int m4275c = azkVar.m4275c() - 1;
        if (m4275c == 0) {
            i5 = ben.f5591b;
        } else if (m4275c == 1) {
            i5 = ben.f5592c;
        } else if (m4275c != 2) {
            i5 = ben.f5594e;
        } else {
            i5 = ben.f5593d;
        }
        m3929j.m3809o(i5);
        bep m4024e = bdp.m4024e();
        m4024e.m3858N((bed) m3929j.mo3179aR());
        bep m4010j = bdr.m4010j();
        m4010j.m3861K(bduVar);
        m4010j.m3862J((bdp) m4024e.mo3179aR());
        m4010j.m3860L(i3);
        m4019e.m3859M((bdr) m4010j.mo3179aR());
        return new azl((bdq) m4019e.mo3179aR(), i4);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: a */
    public final azm mo4173a() {
        return new bby(this, bdq.class);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boj mo4172b(bls blsVar) throws bnm {
        return bds.m4007c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: f */
    public final String mo4171f() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ void mo4170h(boj bojVar) throws GeneralSecurityException {
        bds bdsVar = (bds) bojVar;
        if (bdsVar.m4005e().m3510B()) {
            throw new GeneralSecurityException("invalid ECIES private key");
        }
        bfv.m3735b(bdsVar.m4009a());
        bci.m4187a(bdsVar.m4006d().m3999b());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: j */
    public final int mo4168j() {
        return bea.f5538c;
    }
}
