package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.baq */
/* loaded from: classes2.dex */
final class baq extends azm {

    /* renamed from: a */
    final /* synthetic */ bar f5380a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public baq(bar barVar, Class cls) {
        super(cls);
        this.f5380a = barVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boj mo4177a(bls blsVar) throws bnm {
        return bde.m4086c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4176c(boj bojVar) throws GeneralSecurityException {
        bde bdeVar = (bde) bojVar;
        bep m4089j = bdd.m4089j();
        m4089j.m3842ac(bls.m3504t(bfu.m3737b(bdeVar.m4088a())));
        m4089j.m3841ad(bdeVar.m4085d());
        m4089j.m3840ae();
        return (bdd) m4089j.mo3179aR();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: d */
    public final Map mo4175d() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", bar.m4214k(16, 1));
        hashMap.put("AES128_EAX_RAW", bar.m4214k(16, 3));
        hashMap.put("AES256_EAX", bar.m4214k(32, 1));
        hashMap.put("AES256_EAX_RAW", bar.m4214k(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ void mo4174e(boj bojVar) throws GeneralSecurityException {
        bde bdeVar = (bde) bojVar;
        bfv.m3736a(bdeVar.m4088a());
        if (bdeVar.m4085d().m4081a() != 12 && bdeVar.m4085d().m4081a() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
