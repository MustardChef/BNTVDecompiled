package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bew */
/* loaded from: classes2.dex */
public final class bew implements azb {

    /* renamed from: a */
    public static final int f5611a = bbp.f5396a;

    /* renamed from: b */
    private static final ThreadLocal f5612b = new beu();

    /* renamed from: c */
    private static final ThreadLocal f5613c = new bev();

    /* renamed from: d */
    private final byte[] f5614d;

    /* renamed from: e */
    private final byte[] f5615e;

    /* renamed from: f */
    private final SecretKeySpec f5616f;

    /* renamed from: g */
    private final int f5617g;

    public bew(byte[] bArr, int i) throws GeneralSecurityException {
        if (!bbp.m4200a(f5611a)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i == 12 || i == 16) {
            this.f5617g = i;
            bfv.m3736a(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.f5616f = secretKeySpec;
            Cipher cipher = (Cipher) f5612b.get();
            cipher.init(1, secretKeySpec);
            byte[] m3784b = m3784b(cipher.doFinal(new byte[16]));
            this.f5614d = m3784b;
            this.f5615e = m3784b(m3784b);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    /* renamed from: b */
    private static byte[] m3784b(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            byte b = bArr[i];
            int i2 = i + 1;
            bArr2[i] = (byte) (((b + b) ^ ((bArr[i2] & 255) >>> 7)) & 255);
            i = i2;
        }
        byte b2 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (b2 + b2));
        return bArr2;
    }

    /* renamed from: c */
    private final byte[] m3783c(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        int length;
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(m3782d(bArr3, this.f5614d));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        int i5 = 0;
        while (i3 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                doFinal[i6] = (byte) (doFinal[i6] ^ bArr[(i2 + i5) + i6]);
            }
            doFinal = cipher.doFinal(doFinal);
            i5 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = m3782d(copyOfRange, this.f5614d);
        } else {
            byte[] copyOf = Arrays.copyOf(this.f5615e, 16);
            while (true) {
                length = copyOfRange.length;
                if (i4 >= length) {
                    break;
                }
                copyOf[i4] = (byte) (copyOf[i4] ^ copyOfRange[i4]);
                i4++;
            }
            copyOf[length] = (byte) (copyOf[length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(m3782d(doFinal, bArr2));
    }

    /* renamed from: d */
    private static byte[] m3782d(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azb
    /* renamed from: a */
    public final byte[] mo3767a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.f5617g;
        if (length > (Integer.MAX_VALUE - i) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[i + length + 16];
        byte[] m3737b = bfu.m3737b(i);
        System.arraycopy(m3737b, 0, bArr3, 0, this.f5617g);
        Cipher cipher = (Cipher) f5612b.get();
        cipher.init(1, this.f5616f);
        byte[] m3783c = m3783c(cipher, 0, m3737b, 0, m3737b.length);
        byte[] m3783c2 = m3783c(cipher, 1, bArr2, 0, 0);
        Cipher cipher2 = (Cipher) f5613c.get();
        cipher2.init(1, this.f5616f, new IvParameterSpec(m3783c));
        cipher2.doFinal(bArr, 0, length, bArr3, this.f5617g);
        byte[] m3783c3 = m3783c(cipher, 2, bArr3, this.f5617g, length);
        int i2 = length + this.f5617g;
        for (int i3 = 0; i3 < 16; i3++) {
            bArr3[i2 + i3] = (byte) ((m3783c2[i3] ^ m3783c[i3]) ^ m3783c3[i3]);
        }
        return bArr3;
    }
}
