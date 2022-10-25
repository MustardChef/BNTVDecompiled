package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bet */
/* loaded from: classes2.dex */
public final class bet implements bfn {

    /* renamed from: a */
    public static final int f5606a = bbp.f5397b;

    /* renamed from: b */
    private static final ThreadLocal f5607b = new bes();

    /* renamed from: c */
    private final SecretKeySpec f5608c;

    /* renamed from: d */
    private final int f5609d;

    /* renamed from: e */
    private final int f5610e;

    public bet(byte[] bArr, int i) throws GeneralSecurityException {
        if (!bbp.m4200a(f5606a)) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        bfv.m3736a(bArr.length);
        this.f5608c = new SecretKeySpec(bArr, "AES");
        int blockSize = ((Cipher) f5607b.get()).getBlockSize();
        this.f5610e = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f5609d = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bfn
    /* renamed from: a */
    public final byte[] mo3761a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.f5609d;
        int i2 = Integer.MAX_VALUE - i;
        if (length > i2) {
            StringBuilder sb = new StringBuilder(43);
            sb.append("plaintext length can not exceed ");
            sb.append(i2);
            throw new GeneralSecurityException(sb.toString());
        }
        byte[] bArr2 = new byte[i + length];
        byte[] m3737b = bfu.m3737b(i);
        System.arraycopy(m3737b, 0, bArr2, 0, this.f5609d);
        int i3 = this.f5609d;
        Cipher cipher = (Cipher) f5607b.get();
        byte[] bArr3 = new byte[this.f5610e];
        System.arraycopy(m3737b, 0, bArr3, 0, this.f5609d);
        cipher.init(1, this.f5608c, new IvParameterSpec(bArr3));
        if (cipher.doFinal(bArr, 0, length, bArr2, i3) == length) {
            return bArr2;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
