package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bbm */
/* loaded from: classes2.dex */
public final class bbm {

    /* renamed from: a */
    public static final int f5391a = bbp.f5397b;

    /* renamed from: b */
    private static final ThreadLocal f5392b = new bbl();

    /* renamed from: c */
    private final SecretKey f5393c;

    public bbm(byte[] bArr) throws GeneralSecurityException {
        if (!bbp.m4200a(f5391a)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        bfv.m3736a(bArr.length);
        this.f5393c = new SecretKeySpec(bArr, "AES");
    }

    /* renamed from: a */
    public final byte[] m4202a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        AlgorithmParameterSpec gCMParameterSpec;
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        int length = bArr2.length;
        if (length <= 2147483619) {
            byte[] bArr3 = new byte[length + 28];
            System.arraycopy(bArr, 0, bArr3, 0, 12);
            if (!axd.m4401k() || axd.m4402j() > 19) {
                gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
            } else {
                gCMParameterSpec = new IvParameterSpec(bArr, 0, 12);
            }
            ThreadLocal threadLocal = f5392b;
            ((Cipher) threadLocal.get()).init(1, this.f5393c, gCMParameterSpec);
            int doFinal = ((Cipher) threadLocal.get()).doFinal(bArr2, 0, length, bArr3, 12);
            if (doFinal == length + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(doFinal - length)));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
