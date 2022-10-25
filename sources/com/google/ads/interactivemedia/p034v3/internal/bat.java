package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bat */
/* loaded from: classes2.dex */
final class bat extends azm {

    /* renamed from: a */
    final /* synthetic */ bau f5381a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bat(bau bauVar, Class cls) {
        super(cls);
        this.f5381a = bauVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boj mo4177a(bls blsVar) throws bnm {
        return bdh.m4067c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4176c(boj bojVar) throws GeneralSecurityException {
        bep m4070g = bdg.m4070g();
        m4070g.m3848X(bls.m3504t(bfu.m3737b(((bdh) bojVar).m4069a())));
        m4070g.m3847Y();
        return (bdg) m4070g.mo3179aR();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: d */
    public final Map mo4175d() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", bau.m4213k(16, 1));
        hashMap.put("AES128_GCM_RAW", bau.m4213k(16, 3));
        hashMap.put("AES256_GCM", bau.m4213k(32, 1));
        hashMap.put("AES256_GCM_RAW", bau.m4213k(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ void mo4174e(boj bojVar) throws GeneralSecurityException {
        bfv.m3736a(((bdh) bojVar).m4069a());
    }
}
