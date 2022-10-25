package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bcq */
/* loaded from: classes2.dex */
public final class bcq extends azo {
    public bcq() {
        super(bdx.class, new bco(azs.class));
    }

    /* renamed from: l */
    public static final void m4166l(bdx bdxVar) throws GeneralSecurityException {
        bfv.m3735b(bdxVar.m3975a());
        if (bdxVar.m3970f().mo3054d() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        m4164n(bdxVar.m3971e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public static /* bridge */ /* synthetic */ azl m4165m(int i, int i2, int i3, int i4) {
        bep m3958h = bdy.m3958h();
        bep m3951g = bdz.m3951g();
        m3951g.m3804t(i3);
        m3951g.m3805s(i2);
        m3958h.m3802v((bdz) m3951g.mo3179aR());
        m3958h.m3803u(i);
        return new azl((bdy) m3958h.mo3179aR(), i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static void m4164n(bdz bdzVar) throws GeneralSecurityException {
        if (bdzVar.m3957a() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i = bdw.f5517a;
        int m3953e = bdzVar.m3953e();
        int i2 = m3953e - 2;
        if (m3953e == 0) {
            throw null;
        }
        if (i2 == 1) {
            if (bdzVar.m3957a() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i2 == 2) {
            if (bdzVar.m3957a() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i2 == 3) {
            if (bdzVar.m3957a() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i2 == 4) {
            if (bdzVar.m3957a() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i2 == 5) {
            if (bdzVar.m3957a() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("unknown hash type");
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: a */
    public final azm mo4173a() {
        return new bcp(this, bdy.class);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boj mo4172b(bls blsVar) throws bnm {
        return bdx.m3972d(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: f */
    public final String mo4171f() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azo
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ void mo4170h(boj bojVar) throws GeneralSecurityException {
        m4166l((bdx) bojVar);
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
