package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bco */
/* loaded from: classes2.dex */
final class bco extends azn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bco(Class cls) {
        super(cls);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azn
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ Object mo4178b(Object obj) throws GeneralSecurityException {
        bdx bdxVar = (bdx) obj;
        int m3953e = bdxVar.m3971e().m3953e();
        SecretKeySpec secretKeySpec = new SecretKeySpec(bdxVar.m3970f().m3509C(), "HMAC");
        int m3957a = bdxVar.m3971e().m3957a();
        int i = m3953e - 2;
        int i2 = bdw.f5517a;
        if (m3953e != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                return new bfs(new bfr("HMACSHA224", secretKeySpec), m3957a);
                            }
                            throw new GeneralSecurityException("unknown hash");
                        }
                        return new bfs(new bfr("HMACSHA512", secretKeySpec), m3957a);
                    }
                    return new bfs(new bfr("HMACSHA256", secretKeySpec), m3957a);
                }
                return new bfs(new bfr("HMACSHA384", secretKeySpec), m3957a);
            }
            return new bfs(new bfr("HMACSHA1", secretKeySpec), m3957a);
        }
        throw null;
    }
}
