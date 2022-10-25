package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjf */
/* loaded from: classes3.dex */
public final class zzjf implements zzki {
    private static final ThreadLocal<Cipher> zza = new zzje();
    private final SecretKeySpec zzb;
    private final int zzc;
    private final int zzd;

    public zzjf(byte[] bArr, int i) throws GeneralSecurityException {
        zzkr.zza(bArr.length);
        this.zzb = new SecretKeySpec(bArr, "AES");
        int blockSize = zza.get().getBlockSize();
        this.zzd = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzki
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzc;
        if (length >= i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            int i2 = this.zzc;
            int i3 = length - i2;
            byte[] bArr3 = new byte[i3];
            Cipher cipher = zza.get();
            byte[] bArr4 = new byte[this.zzd];
            System.arraycopy(bArr2, 0, bArr4, 0, this.zzc);
            cipher.init(2, this.zzb, new IvParameterSpec(bArr4));
            if (cipher.doFinal(bArr, i2, i3, bArr3, 0) == i3) {
                return bArr3;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
