package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bey */
/* loaded from: classes2.dex */
public final class bey implements aze {

    /* renamed from: a */
    public static final int f5620a = bbp.f5396a;

    /* renamed from: b */
    private static final Collection f5621b = Arrays.asList(64);

    /* renamed from: c */
    private static final byte[] f5622c = new byte[16];

    /* renamed from: d */
    private final bfp f5623d;

    /* renamed from: e */
    private final byte[] f5624e;

    public bey(byte[] bArr) throws GeneralSecurityException {
        if (bbp.m4200a(f5620a)) {
            Collection collection = f5621b;
            int length = bArr.length;
            if (!collection.contains(Integer.valueOf(length))) {
                StringBuilder sb = new StringBuilder(59);
                sb.append("invalid key size: ");
                sb.append(length);
                sb.append(" bytes; key must have 64 bytes");
                throw new InvalidKeyException(sb.toString());
            }
            int i = length >> 1;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, i);
            this.f5624e = Arrays.copyOfRange(bArr, i, length);
            this.f5623d = new bfp(copyOfRange);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aze
    /* renamed from: a */
    public final byte[] mo3781a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] m3752i;
        if (bArr.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipher = (Cipher) bfj.f5644a.m3766a("AES/CTR/NoPadding");
        byte[][] bArr3 = {bArr2, bArr};
        byte[] mo3742a = this.f5623d.mo3742a(f5622c, 16);
        for (int i = 0; i <= 0; i++) {
            byte[] bArr4 = bArr3[i];
            if (bArr4 == null) {
                bArr4 = new byte[0];
            }
            mo3742a = bfo.m3752i(bfo.m3749l(mo3742a), this.f5623d.mo3742a(bArr4, 16));
        }
        byte[] bArr5 = bArr3[1];
        int length = bArr5.length;
        if (length >= 16) {
            int length2 = mo3742a.length;
            if (length < length2) {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            int i2 = length - length2;
            m3752i = Arrays.copyOf(bArr5, length);
            for (int i3 = 0; i3 < mo3742a.length; i3++) {
                int i4 = i2 + i3;
                m3752i[i4] = (byte) (m3752i[i4] ^ mo3742a[i3]);
            }
        } else {
            m3752i = bfo.m3752i(bfo.m3750k(bArr5), bfo.m3749l(mo3742a));
        }
        byte[] mo3742a2 = this.f5623d.mo3742a(m3752i, 16);
        byte[] bArr6 = (byte[]) mo3742a2.clone();
        bArr6[8] = (byte) (bArr6[8] & Byte.MAX_VALUE);
        bArr6[12] = (byte) (bArr6[12] & Byte.MAX_VALUE);
        cipher.init(1, new SecretKeySpec(this.f5624e, "AES"), new IvParameterSpec(bArr6));
        return bfo.m3753h(mo3742a2, cipher.doFinal(bArr));
    }
}
