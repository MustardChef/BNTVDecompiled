package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.baz */
/* loaded from: classes2.dex */
final class baz extends azm {

    /* renamed from: a */
    final /* synthetic */ bba f5383a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public baz(bba bbaVar, Class cls) {
        super(cls);
        this.f5383a = bbaVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boj mo4177a(bls blsVar) throws bnm {
        return bdn.m4031c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4176c(boj bojVar) throws GeneralSecurityException {
        bdn bdnVar = (bdn) bojVar;
        bep m4034g = bdm.m4034g();
        m4034g.m3856P();
        m4034g.m3857O(bls.m3504t(bfu.m3737b(32)));
        return (bdm) m4034g.mo3179aR();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: d */
    public final Map mo4175d() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("CHACHA20_POLY1305", new azl(bdn.m4032b(), 1));
        hashMap.put("CHACHA20_POLY1305_RAW", new azl(bdn.m4032b(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ void mo4174e(boj bojVar) throws GeneralSecurityException {
        bdn bdnVar = (bdn) bojVar;
    }
}
