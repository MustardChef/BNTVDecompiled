package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bbs */
/* loaded from: classes2.dex */
final class bbs extends azm {

    /* renamed from: a */
    final /* synthetic */ bbt f5401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bbs(bbt bbtVar, Class cls) {
        super(cls);
        this.f5401a = bbtVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boj mo4177a(bls blsVar) throws bnm {
        return bdl.m4043c(blsVar, bmr.m3341a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4176c(boj bojVar) throws GeneralSecurityException {
        bep m4046g = bdk.m4046g();
        m4046g.m3854R(bls.m3504t(bfu.m3737b(((bdl) bojVar).m4045a())));
        m4046g.m3853S();
        return (bdk) m4046g.mo3179aR();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: d */
    public final Map mo4175d() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        bep m4041e = bdl.m4041e();
        m4041e.m3855Q();
        hashMap.put("AES256_SIV", new azl((bdl) m4041e.mo3179aR(), 1));
        bep m4041e2 = bdl.m4041e();
        m4041e2.m3855Q();
        hashMap.put("AES256_SIV_RAW", new azl((bdl) m4041e2.mo3179aR(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azm
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ void mo4174e(boj bojVar) throws GeneralSecurityException {
        bdl bdlVar = (bdl) bojVar;
        if (bdlVar.m4045a() == 64) {
            return;
        }
        int m4045a = bdlVar.m4045a();
        StringBuilder sb = new StringBuilder(61);
        sb.append("invalid key size: ");
        sb.append(m4045a);
        sb.append(". Valid keys must have 64 bytes.");
        throw new InvalidAlgorithmParameterException(sb.toString());
    }
}
