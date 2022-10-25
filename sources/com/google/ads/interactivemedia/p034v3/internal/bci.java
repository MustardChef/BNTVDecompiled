package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bci */
/* loaded from: classes2.dex */
final class bci {
    /* renamed from: a */
    public static void m4187a(bdr bdrVar) throws GeneralSecurityException {
        bfo.m3755f(m4185c(bdrVar.m4015d().m3984e()));
        m4186b(bdrVar.m4015d().m3983f());
        if (bdrVar.m4012g() == bdo.f5483a) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        bae.m4231l(bdrVar.m4018a().m4026c());
    }

    /* renamed from: b */
    public static String m4186b(int i) throws NoSuchAlgorithmException {
        int i2 = bdo.f5483a;
        int i3 = bdv.f5510a;
        int i4 = i - 2;
        int i5 = bdw.f5517a;
        if (i != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                String valueOf = String.valueOf(i != 0 ? Integer.toString(bdw.m3977a(i)) : "null");
                                String.valueOf(valueOf).length();
                                throw new NoSuchAlgorithmException("hash unsupported for HMAC: ".concat(String.valueOf(valueOf)));
                            }
                            return "HmacSha224";
                        }
                        return "HmacSha512";
                    }
                    return "HmacSha256";
                }
                return "HmacSha384";
            }
            return "HmacSha1";
        }
        throw null;
    }

    /* renamed from: c */
    public static int m4185c(int i) throws GeneralSecurityException {
        int i2 = bdo.f5483a;
        int i3 = bdv.f5510a;
        int i4 = i - 2;
        int i5 = bdw.f5517a;
        if (i != 0) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        String valueOf = String.valueOf(i != 0 ? Integer.toString(bdv.m3979a(i)) : "null");
                        String.valueOf(valueOf).length();
                        throw new GeneralSecurityException("unknown curve type: ".concat(String.valueOf(valueOf)));
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        throw null;
    }

    /* renamed from: d */
    public static int m4184d(int i) throws GeneralSecurityException {
        int i2 = bdo.f5483a;
        int i3 = bdv.f5510a;
        int i4 = i - 2;
        int i5 = bdw.f5517a;
        if (i != 0) {
            int i6 = 1;
            if (i4 != 1) {
                i6 = 2;
                if (i4 != 2) {
                    i6 = 3;
                    if (i4 != 3) {
                        String valueOf = String.valueOf(i != 0 ? Integer.toString(bdo.m4030a(i)) : "null");
                        String.valueOf(valueOf).length();
                        throw new GeneralSecurityException("unknown point format: ".concat(String.valueOf(valueOf)));
                    }
                }
            }
            return i6;
        }
        throw null;
    }
}
