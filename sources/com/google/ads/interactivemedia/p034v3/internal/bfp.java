package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfp */
/* loaded from: classes2.dex */
public final class bfp implements bcu {

    /* renamed from: a */
    public static final int f5655a = bbp.f5396a;

    /* renamed from: b */
    private final SecretKey f5656b;

    /* renamed from: c */
    private byte[] f5657c;

    /* renamed from: d */
    private byte[] f5658d;

    public bfp(byte[] bArr) throws GeneralSecurityException {
        bfv.m3736a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f5656b = secretKeySpec;
        Cipher m3744b = m3744b();
        m3744b.init(1, secretKeySpec);
        byte[] m3749l = bfo.m3749l(m3744b.doFinal(new byte[16]));
        this.f5657c = m3749l;
        this.f5658d = bfo.m3749l(m3749l);
    }

    /* renamed from: b */
    private static Cipher m3744b() throws GeneralSecurityException {
        if (!bbp.m4200a(f5655a)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        return (Cipher) bfj.f5644a.m3766a("AES/ECB/NoPadding");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bcu
    /* renamed from: a */
    public final byte[] mo3742a(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] m3752i;
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher m3744b = m3744b();
        m3744b.init(1, this.f5656b);
        int length = bArr.length;
        int max = Math.max(1, (int) Math.ceil(length / 16.0d));
        if (max * 16 == length) {
            m3752i = bfo.m3751j(bArr, (max - 1) * 16, this.f5657c, 0, 16);
        } else {
            m3752i = bfo.m3752i(bfo.m3750k(Arrays.copyOfRange(bArr, (max - 1) * 16, length)), this.f5658d);
        }
        byte[] bArr2 = new byte[16];
        for (int i2 = 0; i2 < max - 1; i2++) {
            bArr2 = m3744b.doFinal(bfo.m3751j(bArr2, 0, bArr, i2 * 16, 16));
        }
        return Arrays.copyOf(m3744b.doFinal(bfo.m3752i(m3752i, bArr2)), i);
    }
}
