package com.google.ads.interactivemedia.p034v3.internal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfh */
/* loaded from: classes2.dex */
public final class bfh {

    /* renamed from: a */
    private final ECPublicKey f5641a;

    public bfh(ECPublicKey eCPublicKey) {
        this.f5641a = eCPublicKey;
    }

    /* renamed from: a */
    public final bfg m3768a(String str, byte[] bArr, byte[] bArr2, int i, int i2) throws GeneralSecurityException {
        BigInteger bigInteger;
        char c;
        int i3;
        byte[] bArr3;
        int i4;
        byte[] bArr4;
        KeyPair m3758c = bfo.m3758c(this.f5641a.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) m3758c.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) m3758c.getPrivate();
        ECPublicKey eCPublicKey2 = this.f5641a;
        try {
            ECParameterSpec params = eCPublicKey2.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            if (!params.getCurve().equals(params2.getCurve()) || !params.getGenerator().equals(params2.getGenerator()) || !params.getOrder().equals(params2.getOrder()) || params.getCofactor() != params2.getCofactor()) {
                throw new GeneralSecurityException("invalid public key spec");
            }
            ECPoint w = eCPublicKey2.getW();
            bfo.m3757d(w, eCPrivateKey.getParams().getCurve());
            PublicKey generatePublic = ((KeyFactory) bfj.f5648e.m3766a("EC")).generatePublic(new ECPublicKeySpec(w, eCPrivateKey.getParams()));
            KeyAgreement keyAgreement = (KeyAgreement) bfj.f5646c.m3766a("ECDH");
            keyAgreement.init(eCPrivateKey);
            int i5 = 1;
            try {
                keyAgreement.doPhase(generatePublic, true);
                byte[] generateSecret = keyAgreement.generateSecret();
                EllipticCurve curve = eCPrivateKey.getParams().getCurve();
                BigInteger bigInteger2 = new BigInteger(1, generateSecret);
                if (bigInteger2.signum() == -1 || bigInteger2.compareTo(bfo.m3759b(curve)) >= 0) {
                    throw new GeneralSecurityException("shared secret is out of range");
                }
                BigInteger m3759b = bfo.m3759b(curve);
                BigInteger mod = bigInteger2.multiply(bigInteger2).add(curve.getA()).multiply(bigInteger2).add(curve.getB()).mod(m3759b);
                if (m3759b.signum() != 1) {
                    throw new InvalidAlgorithmParameterException("p must be positive");
                }
                BigInteger mod2 = mod.mod(m3759b);
                if (mod2.equals(BigInteger.ZERO)) {
                    bigInteger = BigInteger.ZERO;
                } else {
                    BigInteger bigInteger3 = null;
                    if (!m3759b.testBit(0) || !m3759b.testBit(1)) {
                        if (m3759b.testBit(0) && !m3759b.testBit(1)) {
                            BigInteger bigInteger4 = BigInteger.ONE;
                            BigInteger shiftRight = m3759b.subtract(BigInteger.ONE).shiftRight(1);
                            int i6 = 0;
                            while (true) {
                                BigInteger mod3 = bigInteger4.multiply(bigInteger4).subtract(mod2).mod(m3759b);
                                if (mod3.equals(BigInteger.ZERO)) {
                                    bigInteger = bigInteger4;
                                    break;
                                }
                                BigInteger modPow = mod3.modPow(shiftRight, m3759b);
                                if (!modPow.add(BigInteger.ONE).equals(m3759b)) {
                                    if (modPow.equals(BigInteger.ONE)) {
                                        bigInteger4 = bigInteger4.add(BigInteger.ONE);
                                        i6++;
                                        if (i6 == 128 && !m3759b.isProbablePrime(80)) {
                                            throw new InvalidAlgorithmParameterException("p is not prime");
                                        }
                                        i5 = 1;
                                    } else {
                                        throw new InvalidAlgorithmParameterException("p is not prime");
                                    }
                                } else {
                                    BigInteger shiftRight2 = m3759b.add(BigInteger.ONE).shiftRight(i5);
                                    BigInteger bigInteger5 = BigInteger.ONE;
                                    BigInteger bigInteger6 = bigInteger4;
                                    for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                                        BigInteger multiply = bigInteger6.multiply(bigInteger5);
                                        BigInteger mod4 = bigInteger6.multiply(bigInteger6).add(bigInteger5.multiply(bigInteger5).mod(m3759b).multiply(mod3)).mod(m3759b);
                                        BigInteger mod5 = multiply.add(multiply).mod(m3759b);
                                        if (shiftRight2.testBit(bitLength)) {
                                            BigInteger mod6 = mod4.multiply(bigInteger4).add(mod5.multiply(mod3)).mod(m3759b);
                                            bigInteger5 = bigInteger4.multiply(mod5).add(mod4).mod(m3759b);
                                            bigInteger6 = mod6;
                                        } else {
                                            bigInteger6 = mod4;
                                            bigInteger5 = mod5;
                                        }
                                    }
                                    bigInteger3 = bigInteger6;
                                }
                            }
                        }
                    } else {
                        bigInteger3 = mod2.modPow(m3759b.add(BigInteger.ONE).shiftRight(2), m3759b);
                    }
                    if (bigInteger3 != null && bigInteger3.multiply(bigInteger3).mod(m3759b).compareTo(mod2) != 0) {
                        throw new GeneralSecurityException("Could not find a modular square root");
                    }
                    bigInteger = bigInteger3;
                }
                if (!bigInteger.testBit(0)) {
                    m3759b.subtract(bigInteger).mod(m3759b);
                }
                EllipticCurve curve2 = eCPublicKey.getParams().getCurve();
                ECPoint w2 = eCPublicKey.getW();
                bfo.m3757d(w2, curve2);
                int bitLength2 = (bfo.m3759b(curve2).subtract(BigInteger.ONE).bitLength() + 7) / 8;
                int i7 = i2 - 1;
                if (i7 != 0) {
                    if (i7 != 2) {
                        int i8 = bitLength2 + 1;
                        bArr4 = new byte[i8];
                        byte[] byteArray = w2.getAffineX().toByteArray();
                        int length = byteArray.length;
                        c = 0;
                        System.arraycopy(byteArray, 0, bArr4, i8 - length, length);
                        bArr4[0] = true != w2.getAffineY().testBit(0) ? (byte) 2 : (byte) 3;
                    } else {
                        int i9 = bitLength2 + bitLength2;
                        bArr4 = new byte[i9];
                        byte[] byteArray2 = w2.getAffineX().toByteArray();
                        int length2 = byteArray2.length;
                        if (length2 > bitLength2) {
                            byteArray2 = Arrays.copyOfRange(byteArray2, length2 - bitLength2, length2);
                        }
                        byte[] byteArray3 = w2.getAffineY().toByteArray();
                        int length3 = byteArray3.length;
                        if (length3 > bitLength2) {
                            byteArray3 = Arrays.copyOfRange(byteArray3, length3 - bitLength2, length3);
                        }
                        int length4 = byteArray3.length;
                        c = 0;
                        System.arraycopy(byteArray3, 0, bArr4, i9 - length4, length4);
                        int length5 = byteArray2.length;
                        System.arraycopy(byteArray2, 0, bArr4, bitLength2 - length5, length5);
                    }
                    bArr3 = bArr4;
                    i4 = 2;
                    i3 = 1;
                } else {
                    c = 0;
                    i3 = 1;
                    int i10 = bitLength2 + bitLength2 + 1;
                    bArr3 = new byte[i10];
                    byte[] byteArray4 = w2.getAffineX().toByteArray();
                    byte[] byteArray5 = w2.getAffineY().toByteArray();
                    int length6 = byteArray5.length;
                    System.arraycopy(byteArray5, 0, bArr3, i10 - length6, length6);
                    int length7 = byteArray4.length;
                    System.arraycopy(byteArray4, 0, bArr3, (bitLength2 + 1) - length7, length7);
                    bArr3[0] = 4;
                    i4 = 2;
                }
                byte[][] bArr5 = new byte[i4];
                bArr5[c] = bArr3;
                bArr5[i3] = generateSecret;
                byte[] m3753h = bfo.m3753h(bArr5);
                Mac mac = (Mac) bfj.f5645b.m3766a(str);
                if (i <= mac.getMacLength() * 255) {
                    if (bArr == null || bArr.length == 0) {
                        mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
                    } else {
                        mac.init(new SecretKeySpec(bArr, str));
                    }
                    byte[] doFinal = mac.doFinal(m3753h);
                    byte[] bArr6 = new byte[i];
                    mac.init(new SecretKeySpec(doFinal, str));
                    byte[] bArr7 = new byte[0];
                    int i11 = 0;
                    while (true) {
                        mac.update(bArr7);
                        mac.update(bArr2);
                        mac.update((byte) i3);
                        byte[] doFinal2 = mac.doFinal();
                        int length8 = doFinal2.length;
                        int i12 = i11 + length8;
                        if (i12 < i) {
                            System.arraycopy(doFinal2, 0, bArr6, i11, length8);
                            i3++;
                            bArr7 = doFinal2;
                            i11 = i12;
                        } else {
                            System.arraycopy(doFinal2, 0, bArr6, i11, i - i11);
                            return new bfg(bArr3, bArr6);
                        }
                    }
                } else {
                    throw new GeneralSecurityException("size too large");
                }
            } catch (IllegalStateException e) {
                throw new GeneralSecurityException(e.toString());
            }
        } catch (IllegalArgumentException | NullPointerException e2) {
            throw new GeneralSecurityException(e2.toString());
        }
    }
}
