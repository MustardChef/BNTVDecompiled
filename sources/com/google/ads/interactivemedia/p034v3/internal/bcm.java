package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bcm */
/* loaded from: classes2.dex */
final class bcm extends azm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bcm(Class cls) {
        super(cls);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boj mo4177a(bls blsVar) throws bnm {
        return bcw.m4148c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4176c(boj bojVar) throws GeneralSecurityException {
        bcw bcwVar = (bcw) bojVar;
        bep m4151j = bcv.m4151j();
        m4151j.m3823av();
        m4151j.m3825at(bls.m3504t(bfu.m3737b(bcwVar.m4150a())));
        m4151j.m3824au(bcwVar.m4147d());
        return (bcv) m4151j.mo3179aR();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: d */
    public final Map mo4175d() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        bep m4144g = bcw.m4144g();
        m4144g.m3827ar();
        bep m4139e = bcx.m4139e();
        m4139e.m3828aq();
        m4144g.m3826as((bcx) m4139e.mo3179aR());
        hashMap.put("AES_CMAC", new azl((bcw) m4144g.mo3179aR(), 1));
        bep m4144g2 = bcw.m4144g();
        m4144g2.m3827ar();
        bep m4139e2 = bcx.m4139e();
        m4139e2.m3828aq();
        m4144g2.m3826as((bcx) m4139e2.mo3179aR());
        hashMap.put("AES256_CMAC", new azl((bcw) m4144g2.mo3179aR(), 1));
        bep m4144g3 = bcw.m4144g();
        m4144g3.m3827ar();
        bep m4139e3 = bcx.m4139e();
        m4139e3.m3828aq();
        m4144g3.m3826as((bcx) m4139e3.mo3179aR());
        hashMap.put("AES256_CMAC_RAW", new azl((bcw) m4144g3.mo3179aR(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ void mo4174e(boj bojVar) throws GeneralSecurityException {
        bcw bcwVar = (bcw) bojVar;
        bcn.m4180m(bcwVar.m4147d());
        bcn.m4179n(bcwVar.m4150a());
    }
}
