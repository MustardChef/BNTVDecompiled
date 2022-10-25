package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bbo */
/* loaded from: classes2.dex */
public final class bbo implements azb {

    /* renamed from: a */
    private static final ThreadLocal f5394a = new bbn();

    /* renamed from: b */
    private final SecretKey f5395b;

    public bbo(byte[] bArr) throws GeneralSecurityException {
        bfv.m3736a(bArr.length);
        this.f5395b = new SecretKeySpec(bArr, "AES");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azb
    /* renamed from: a */
    public final byte[] mo3767a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        AlgorithmParameterSpec ivParameterSpec;
        int length = bArr.length;
        if (length <= 2147483619) {
            byte[] bArr3 = new byte[length + 28];
            byte[] m3737b = bfu.m3737b(12);
            System.arraycopy(m3737b, 0, bArr3, 0, 12);
            int length2 = m3737b.length;
            try {
                Class.forName("javax.crypto.spec.GCMParameterSpec");
                ivParameterSpec = new GCMParameterSpec(128, m3737b, 0, length2);
            } catch (ClassNotFoundException unused) {
                if (axd.m4401k()) {
                    ivParameterSpec = new IvParameterSpec(m3737b, 0, length2);
                } else {
                    throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
                }
            }
            ThreadLocal threadLocal = f5394a;
            ((Cipher) threadLocal.get()).init(1, this.f5395b, ivParameterSpec);
            int length3 = bArr.length;
            int doFinal = ((Cipher) threadLocal.get()).doFinal(bArr, 0, length3, bArr3, 12);
            if (doFinal == length3 + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(doFinal - length3)));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
