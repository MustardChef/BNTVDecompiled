package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkk */
/* loaded from: classes3.dex */
public final class zzkk implements zzea {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzkk(byte[] bArr) throws GeneralSecurityException {
        zzkr.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher zzb = zzb();
        zzb.init(1, secretKeySpec);
        byte[] zza = zzjl.zza(zzb.doFinal(new byte[16]));
        this.zzb = zza;
        this.zzc = zzjl.zza(zza);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        return zzjy.zza.zza("AES/ECB/NoPadding");
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzea
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] zze;
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher zzb = zzb();
        zzb.init(1, this.zza);
        int length = bArr.length;
        int max = Math.max(1, (int) Math.ceil(length / 16.0d));
        if (max * 16 == length) {
            zze = zzjm.zzc(bArr, (max - 1) * 16, this.zzb, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) * 16, length);
            int length2 = copyOfRange.length;
            if (length2 >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
            copyOf[length2] = Byte.MIN_VALUE;
            zze = zzjm.zze(copyOf, this.zzc);
        }
        byte[] bArr2 = new byte[16];
        for (int i2 = 0; i2 < max - 1; i2++) {
            bArr2 = zzb.doFinal(zzjm.zzc(bArr2, 0, bArr, i2 * 16, 16));
        }
        return Arrays.copyOf(zzb.doFinal(zzjm.zze(zze, bArr2)), i);
    }
}
