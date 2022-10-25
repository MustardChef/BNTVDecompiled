package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.baw */
/* loaded from: classes2.dex */
final class baw extends azm {

    /* renamed from: a */
    final /* synthetic */ bax f5382a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public baw(bax baxVar, Class cls) {
        super(cls);
        this.f5382a = baxVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boj mo4177a(bls blsVar) throws bnm {
        return bdj.m4055c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4176c(boj bojVar) throws GeneralSecurityException {
        bep m4058g = bdi.m4058g();
        m4058g.m3851U(bls.m3504t(bfu.m3737b(((bdj) bojVar).m4057a())));
        m4058g.m3850V();
        return (bdi) m4058g.mo3179aR();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: d */
    public final Map mo4175d() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM_SIV", bax.m4212k(16, 1));
        hashMap.put("AES128_GCM_SIV_RAW", bax.m4212k(16, 3));
        hashMap.put("AES256_GCM_SIV", bax.m4212k(32, 1));
        hashMap.put("AES256_GCM_SIV_RAW", bax.m4212k(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ void mo4174e(boj bojVar) throws GeneralSecurityException {
        bfv.m3736a(((bdj) bojVar).m4057a());
    }
}
