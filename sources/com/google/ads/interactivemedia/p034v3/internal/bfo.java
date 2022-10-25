package com.google.ads.interactivemedia.p034v3.internal;

import com.google.common.base.Ascii;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfo */
/* loaded from: classes2.dex */
public final class bfo {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m3760a(byte[] bArr, byte[] bArr2) {
        long m3748m = m3748m(bArr, 0, 0);
        long m3748m2 = m3748m(bArr, 3, 2) & 67108611;
        long m3748m3 = m3748m(bArr, 6, 4) & 67092735;
        long m3748m4 = m3748m(bArr, 9, 6) & 66076671;
        long m3748m5 = m3748m(bArr, 12, 8) & 1048575;
        long j = m3748m2 * 5;
        long j2 = m3748m3 * 5;
        long j3 = m3748m4 * 5;
        long j4 = m3748m5 * 5;
        int i = 17;
        byte[] bArr3 = new byte[17];
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        int i2 = 0;
        while (true) {
            int length = bArr2.length;
            if (i2 < length) {
                int min = Math.min(16, length - i2);
                System.arraycopy(bArr2, i2, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, i, (byte) 0);
                }
                long m3748m6 = j9 + m3748m(bArr3, 0, 0);
                long m3748m7 = j6 + m3748m(bArr3, 3, 2);
                long m3748m8 = j5 + m3748m(bArr3, 6, 4);
                long m3748m9 = j7 + m3748m(bArr3, 9, 6);
                long m3748m10 = j8 + (m3748m(bArr3, 12, 8) | (bArr3[16] << Ascii.CAN));
                long j10 = (m3748m6 * m3748m) + (m3748m7 * j4) + (m3748m8 * j3) + (m3748m9 * j2) + (m3748m10 * j);
                long j11 = (m3748m6 * m3748m2) + (m3748m7 * m3748m) + (m3748m8 * j4) + (m3748m9 * j3) + (m3748m10 * j2) + (j10 >> 26);
                long j12 = (m3748m6 * m3748m3) + (m3748m7 * m3748m2) + (m3748m8 * m3748m) + (m3748m9 * j4) + (m3748m10 * j3) + (j11 >> 26);
                long j13 = (m3748m6 * m3748m4) + (m3748m7 * m3748m3) + (m3748m8 * m3748m2) + (m3748m9 * m3748m) + (m3748m10 * j4) + (j12 >> 26);
                long j14 = (m3748m6 * m3748m5) + (m3748m7 * m3748m4) + (m3748m8 * m3748m3) + (m3748m9 * m3748m2) + (m3748m10 * m3748m) + (j13 >> 26);
                j8 = j14 & 67108863;
                long j15 = (j10 & 67108863) + ((j14 >> 26) * 5);
                j9 = j15 & 67108863;
                j6 = (j11 & 67108863) + (j15 >> 26);
                i2 += 16;
                j7 = j13 & 67108863;
                j5 = j12 & 67108863;
                i = 17;
            } else {
                long j16 = j5 + (j6 >> 26);
                long j17 = j16 & 67108863;
                long j18 = j7 + (j16 >> 26);
                long j19 = j18 & 67108863;
                long j20 = j8 + (j18 >> 26);
                long j21 = j20 & 67108863;
                long j22 = j9 + ((j20 >> 26) * 5);
                long j23 = j22 & 67108863;
                long j24 = (j6 & 67108863) + (j22 >> 26);
                long j25 = j23 + 5;
                long j26 = (j25 >> 26) + j24;
                long j27 = j17 + (j26 >> 26);
                long j28 = j19 + (j27 >> 26);
                long j29 = (j21 + (j28 >> 26)) - 67108864;
                long j30 = j29 >> 63;
                long j31 = ~j30;
                long j32 = (j24 & j30) | (j26 & 67108863 & j31);
                long j33 = (j17 & j30) | (j27 & 67108863 & j31);
                long j34 = (j19 & j30) | (j28 & 67108863 & j31);
                long m3747n = (((j23 & j30) | (j25 & 67108863 & j31) | (j32 << 26)) & 4294967295L) + m3747n(bArr, 16);
                long m3747n2 = (((j32 >> 6) | (j33 << 20)) & 4294967295L) + m3747n(bArr, 20) + (m3747n >> 32);
                long m3747n3 = (((j33 >> 12) | (j34 << 14)) & 4294967295L) + m3747n(bArr, 24) + (m3747n2 >> 32);
                long m3747n4 = m3747n(bArr, 28);
                byte[] bArr4 = new byte[16];
                m3746o(bArr4, m3747n & 4294967295L, 0);
                m3746o(bArr4, m3747n2 & 4294967295L, 4);
                m3746o(bArr4, m3747n3 & 4294967295L, 8);
                m3746o(bArr4, ((((((j29 & j31) | (j21 & j30)) << 8) | (j34 >> 18)) & 4294967295L) + m3747n4 + (m3747n3 >> 32)) & 4294967295L, 12);
                return bArr4;
            }
        }
    }

    /* renamed from: b */
    public static BigInteger m3759b(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        ECField field = ellipticCurve.getField();
        if (field instanceof ECFieldFp) {
            return ((ECFieldFp) field).getP();
        }
        throw new GeneralSecurityException("Only curves over prime order fields are supported");
    }

    /* renamed from: c */
    public static KeyPair m3758c(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) bfj.f5647d.m3766a("EC");
        keyPairGenerator.initialize(eCParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static void m3757d(ECPoint eCPoint, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger m3759b = m3759b(ellipticCurve);
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        if (affineX == null || affineY == null) {
            throw new GeneralSecurityException("point is at infinity");
        }
        if (affineX.signum() == -1 || affineX.compareTo(m3759b) >= 0) {
            throw new GeneralSecurityException("x is out of range");
        }
        if (affineY.signum() == -1 || affineY.compareTo(m3759b) >= 0) {
            throw new GeneralSecurityException("y is out of range");
        }
        if (!affineY.multiply(affineY).mod(m3759b).equals(affineX.multiply(affineX).add(ellipticCurve.getA()).multiply(affineX).add(ellipticCurve.getB()).mod(m3759b))) {
            throw new GeneralSecurityException("Point is not on curve");
        }
    }

    /* renamed from: e */
    public static ECPublicKey m3756e(int i, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ECParameterSpec m3755f = m3755f(i);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, bArr), new BigInteger(1, bArr2));
        m3757d(eCPoint, m3755f.getCurve());
        return (ECPublicKey) ((KeyFactory) bfj.f5648e.m3766a("EC")).generatePublic(new ECPublicKeySpec(eCPoint, m3755f));
    }

    /* renamed from: g */
    public static final void m3754g(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (i < 0 || byteBuffer2.remaining() < i || byteBuffer3.remaining() < i || byteBuffer.remaining() < i) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    /* renamed from: h */
    public static byte[] m3753h(byte[]... bArr) throws GeneralSecurityException {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            int length = bArr2.length;
            if (i > Integer.MAX_VALUE - length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i += length;
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            int length2 = bArr4.length;
            System.arraycopy(bArr4, 0, bArr3, i2, length2);
            i2 += length2;
        }
        return bArr3;
    }

    /* renamed from: i */
    public static final byte[] m3752i(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length != bArr2.length) {
            throw new IllegalArgumentException("The lengths of x and y should match.");
        }
        return m3751j(bArr, 0, bArr2, 0, length);
    }

    /* renamed from: j */
    public static final byte[] m3751j(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr.length - i3 < i || bArr2.length - i3 < i2) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr3[i4] = (byte) (bArr[i4 + i] ^ bArr2[i4 + i2]);
        }
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static byte[] m3750k(byte[] bArr) {
        int length = bArr.length;
        if (length >= 16) {
            throw new IllegalArgumentException("x must be smaller than a block.");
        }
        byte[] copyOf = Arrays.copyOf(bArr, 16);
        copyOf[length] = Byte.MIN_VALUE;
        return copyOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static byte[] m3749l(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            byte b2 = (byte) ((b + b) & 254);
            bArr2[i] = b2;
            if (i < 15) {
                bArr2[i] = (byte) (((bArr[i + 1] >> 7) & 1) | b2);
            }
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
        return bArr2;
    }

    /* renamed from: m */
    private static long m3748m(byte[] bArr, int i, int i2) {
        return (m3747n(bArr, i) >> i2) & 67108863;
    }

    /* renamed from: n */
    private static long m3747n(byte[] bArr, int i) {
        return (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16)) & 4294967295L;
    }

    /* renamed from: o */
    private static void m3746o(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) (255 & j);
            i2++;
            j >>= 8;
        }
    }

    /* renamed from: p */
    private static ECParameterSpec m3745p(String str, String str2, String str3, String str4, String str5) {
        BigInteger bigInteger = new BigInteger(str);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigInteger), bigInteger.subtract(new BigInteger("3")), new BigInteger(str3, 16)), new ECPoint(new BigInteger(str4, 16), new BigInteger(str5, 16)), new BigInteger(str2), 1);
    }

    /* renamed from: f */
    public static ECParameterSpec m3755f(int i) throws NoSuchAlgorithmException {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 1) {
                return m3745p("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
            }
            return m3745p("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
        }
        return m3745p("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
    }
}
