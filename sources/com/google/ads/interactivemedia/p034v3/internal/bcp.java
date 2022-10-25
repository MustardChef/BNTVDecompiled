package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bcp */
/* loaded from: classes2.dex */
final class bcp extends azm {

    /* renamed from: a */
    final /* synthetic */ bcq f5419a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bcp(bcq bcqVar, Class cls) {
        super(cls);
        this.f5419a = bcqVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boj mo4177a(bls blsVar) throws bnm {
        return bdy.m3962d(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4176c(boj bojVar) throws GeneralSecurityException {
        bdy bdyVar = (bdy) bojVar;
        bep m3966k = bdx.m3966k();
        m3966k.m3799y();
        m3966k.m3800x(bdyVar.m3961e());
        m3966k.m3801w(bls.m3504t(bfu.m3737b(bdyVar.m3965a())));
        return (bdx) m3966k.mo3179aR();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: d */
    public final Map mo4175d() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", bcq.m4165m(32, 16, bdw.f5520d, 1));
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", bcq.m4165m(32, 16, bdw.f5520d, 3));
        hashMap.put("HMAC_SHA256_256BITTAG", bcq.m4165m(32, 32, bdw.f5520d, 1));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", bcq.m4165m(32, 32, bdw.f5520d, 3));
        hashMap.put("HMAC_SHA512_128BITTAG", bcq.m4165m(64, 16, bdw.f5521e, 1));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", bcq.m4165m(64, 16, bdw.f5521e, 3));
        hashMap.put("HMAC_SHA512_256BITTAG", bcq.m4165m(64, 32, bdw.f5521e, 1));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", bcq.m4165m(64, 32, bdw.f5521e, 3));
        hashMap.put("HMAC_SHA512_512BITTAG", bcq.m4165m(64, 64, bdw.f5521e, 1));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", bcq.m4165m(64, 64, bdw.f5521e, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ void mo4174e(boj bojVar) throws GeneralSecurityException {
        bdy bdyVar = (bdy) bojVar;
        if (bdyVar.m3965a() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        bcq.m4164n(bdyVar.m3961e());
    }
}
