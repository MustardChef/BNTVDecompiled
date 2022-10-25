package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
@Deprecated
/* renamed from: com.google.ads.interactivemedia.v3.internal.azt */
/* loaded from: classes2.dex */
public final class azt {
    @Deprecated
    /* renamed from: a */
    public static final azp m4262a(byte[] bArr) throws GeneralSecurityException {
        try {
            beg m3913d = beg.m3913d(bArr, bmr.m3341a());
            for (bef befVar : m3913d.m3912e()) {
                if (befVar.m3921b().m3942g() == bea.f5536a || befVar.m3921b().m3942g() == bea.f5537b || befVar.m3921b().m3942g() == bea.f5538c) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return azp.m4267a(m3913d);
        } catch (bnm unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
