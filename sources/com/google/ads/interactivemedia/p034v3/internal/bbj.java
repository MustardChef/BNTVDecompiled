package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bbj */
/* loaded from: classes2.dex */
final class bbj extends azm {

    /* renamed from: a */
    final /* synthetic */ bbk f5390a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bbj(bbk bbkVar, Class cls) {
        super(cls);
        this.f5390a = bbkVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boj mo4177a(bls blsVar) throws bnm {
        return ber.m3788c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4176c(boj bojVar) throws GeneralSecurityException {
        ber berVar = (ber) bojVar;
        bep m3796b = beq.m3796b();
        m3796b.m3822b();
        m3796b.m3845a(bls.m3504t(bfu.m3737b(32)));
        return (beq) m3796b.mo3179aR();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: d */
    public final Map mo4175d() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", new azl(ber.m3789b(), 1));
        hashMap.put("XCHACHA20_POLY1305_RAW", new azl(ber.m3789b(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ void mo4174e(boj bojVar) throws GeneralSecurityException {
        ber berVar = (ber) bojVar;
    }
}
