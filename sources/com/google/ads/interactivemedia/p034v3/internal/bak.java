package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bak */
/* loaded from: classes2.dex */
final class bak extends azm {

    /* renamed from: a */
    final /* synthetic */ bal f5378a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bak(bal balVar, Class cls) {
        super(cls);
        this.f5378a = balVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boj mo4177a(bls blsVar) throws bnm {
        return bcz.m4128b(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4176c(boj bojVar) throws GeneralSecurityException {
        bcz bczVar = (bcz) bojVar;
        Object mo4176c = new bao().mo4173a().mo4176c(bczVar.m4127c());
        Object mo4176c2 = new bcq().mo4173a().mo4176c(bczVar.m4126d());
        bep m4130j = bcy.m4130j();
        m4130j.m3831an((bda) mo4176c);
        m4130j.m3830ao((bdx) mo4176c2);
        m4130j.m3829ap(0);
        return (bcy) m4130j.mo3179aR();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: d */
    public final Map mo4175d() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", bal.m4218k(16, 16, bdw.f5520d, 1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", bal.m4218k(16, 16, bdw.f5520d, 3));
        hashMap.put("AES256_CTR_HMAC_SHA256", bal.m4218k(32, 32, bdw.f5520d, 1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", bal.m4218k(32, 32, bdw.f5520d, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ void mo4174e(boj bojVar) throws GeneralSecurityException {
        bcz bczVar = (bcz) bojVar;
        new bao().mo4173a().mo4174e(bczVar.m4127c());
        new bcq().mo4173a().mo4174e(bczVar.m4126d());
        bfv.m3736a(bczVar.m4127c().m4110a());
    }
}
