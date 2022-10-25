package com.google.ads.interactivemedia.p034v3.internal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bbx */
/* loaded from: classes2.dex */
final class bbx extends azn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bbx(Class cls) {
        super(cls);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azn
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ Object mo4178b(Object obj) throws GeneralSecurityException {
        bds bdsVar = (bds) obj;
        bdr m3999b = bdsVar.m4006d().m3999b();
        bdu m4015d = m3999b.m4015d();
        int m4185c = bci.m4185c(m4015d.m3984e());
        byte[] m3509C = bdsVar.m4005e().m3509C();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) ((KeyFactory) bfj.f5648e.m3766a("EC")).generatePrivate(new ECPrivateKeySpec(new BigInteger(1, m3509C), bfo.m3755f(m4185c)));
        new bcj(m3999b.m4018a().m4026c());
        m4015d.m3986c().m3509C();
        bci.m4186b(m4015d.m3983f());
        bci.m4184d(m3999b.m4012g());
        return new bfe();
    }
}
