package com.google.android.gms.internal.p038firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
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

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzju */
/* loaded from: classes3.dex */
public final class zzju {
    private final ECPrivateKey zza;

    public zzju(ECPrivateKey eCPrivateKey) {
        this.zza = eCPrivateKey;
    }

    public final byte[] zza(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i, int i2) throws GeneralSecurityException {
        ECPoint eCPoint;
        ECPoint eCPoint2;
        ECParameterSpec params;
        ECParameterSpec params2;
        boolean z;
        ECParameterSpec params3 = this.zza.getParams();
        EllipticCurve curve = params3.getCurve();
        int zzc = zzjw.zzc(curve);
        int i3 = i2 - 1;
        int i4 = 1;
        try {
            if (i3 == 0) {
                int length = bArr.length;
                if (length != zzc + zzc + 1) {
                    throw new GeneralSecurityException("invalid point size");
                }
                if (bArr[0] != 4) {
                    throw new GeneralSecurityException("invalid point format");
                }
                int i5 = zzc + 1;
                eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i5)), new BigInteger(1, Arrays.copyOfRange(bArr, i5, length)));
                zzjw.zza(eCPoint, curve);
            } else if (i3 != 2) {
                BigInteger zzb = zzjw.zzb(curve);
                int length2 = bArr.length;
                if (length2 != zzc + 1) {
                    throw new GeneralSecurityException("compressed point has wrong length");
                }
                byte b = bArr[0];
                if (b == 2) {
                    z = false;
                } else if (b != 3) {
                    throw new GeneralSecurityException("invalid format");
                } else {
                    z = true;
                }
                BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, length2));
                if (bigInteger.signum() == -1 || bigInteger.compareTo(zzb) >= 0) {
                    throw new GeneralSecurityException("x is out of range");
                }
                eCPoint2 = new ECPoint(bigInteger, zzjw.zzd(bigInteger, z, curve));
                ECPublicKey eCPublicKey = (ECPublicKey) zzjy.zzg.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint2, params3));
                ECPrivateKey eCPrivateKey = this.zza;
                params = eCPublicKey.getParams();
                params2 = eCPrivateKey.getParams();
                if (params.getCurve().equals(params2.getCurve()) || !params.getGenerator().equals(params2.getGenerator()) || !params.getOrder().equals(params2.getOrder()) || params.getCofactor() != params2.getCofactor()) {
                    throw new GeneralSecurityException("invalid public key spec");
                }
                ECPoint w = eCPublicKey.getW();
                zzjw.zza(w, eCPrivateKey.getParams().getCurve());
                PublicKey generatePublic = zzjy.zzg.zza("EC").generatePublic(new ECPublicKeySpec(w, eCPrivateKey.getParams()));
                KeyAgreement zza = zzjy.zze.zza("ECDH");
                zza.init(eCPrivateKey);
                try {
                    zza.doPhase(generatePublic, true);
                    byte[] generateSecret = zza.generateSecret();
                    EllipticCurve curve2 = eCPrivateKey.getParams().getCurve();
                    BigInteger bigInteger2 = new BigInteger(1, generateSecret);
                    if (bigInteger2.signum() == -1 || bigInteger2.compareTo(zzjw.zzb(curve2)) >= 0) {
                        throw new GeneralSecurityException("shared secret is out of range");
                    }
                    zzjw.zzd(bigInteger2, true, curve2);
                    byte[] zzb2 = zzjm.zzb(bArr, generateSecret);
                    Mac zza2 = zzjy.zzb.zza(str);
                    if (i <= zza2.getMacLength() * 255) {
                        if (bArr2 == null || bArr2.length == 0) {
                            zza2.init(new SecretKeySpec(new byte[zza2.getMacLength()], str));
                        } else {
                            zza2.init(new SecretKeySpec(bArr2, str));
                        }
                        byte[] bArr4 = new byte[i];
                        zza2.init(new SecretKeySpec(zza2.doFinal(zzb2), str));
                        byte[] bArr5 = new byte[0];
                        int i6 = 0;
                        while (true) {
                            zza2.update(bArr5);
                            zza2.update((byte[]) null);
                            zza2.update((byte) i4);
                            bArr5 = zza2.doFinal();
                            int length3 = bArr5.length;
                            int i7 = i6 + length3;
                            if (i7 < i) {
                                System.arraycopy(bArr5, 0, bArr4, i6, length3);
                                i4++;
                                i6 = i7;
                            } else {
                                System.arraycopy(bArr5, 0, bArr4, i6, i - i6);
                                return bArr4;
                            }
                        }
                    } else {
                        throw new GeneralSecurityException("size too large");
                    }
                } catch (IllegalStateException e) {
                    throw new GeneralSecurityException(e.toString());
                }
            } else {
                int length4 = bArr.length;
                if (length4 != zzc + zzc) {
                    throw new GeneralSecurityException("invalid point size");
                }
                eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, zzc)), new BigInteger(1, Arrays.copyOfRange(bArr, zzc, length4)));
                zzjw.zza(eCPoint, curve);
            }
            params = eCPublicKey.getParams();
            params2 = eCPrivateKey.getParams();
            if (params.getCurve().equals(params2.getCurve())) {
            }
            throw new GeneralSecurityException("invalid public key spec");
        } catch (IllegalArgumentException | NullPointerException e2) {
            throw new GeneralSecurityException(e2.toString());
        }
        eCPoint2 = eCPoint;
        ECPublicKey eCPublicKey2 = (ECPublicKey) zzjy.zzg.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint2, params3));
        ECPrivateKey eCPrivateKey2 = this.zza;
    }
}
