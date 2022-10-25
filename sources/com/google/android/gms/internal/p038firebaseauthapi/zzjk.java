package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjk */
/* loaded from: classes3.dex */
public final class zzjk implements zzag {
    private static final ThreadLocal<Cipher> zza = new zzjj();
    private final SecretKey zzb;

    public zzjk(byte[] bArr) throws GeneralSecurityException {
        zzkr.zza(bArr.length);
        this.zzb = new SecretKeySpec(bArr, "AES");
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzag
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzag
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        AlgorithmParameterSpec gCMParameterSpec;
        int length = bArr.length;
        if (length >= 28) {
            if (!zzkq.zza() || zzkq.zzb() > 19) {
                gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
            } else {
                gCMParameterSpec = new IvParameterSpec(bArr, 0, 12);
            }
            ThreadLocal<Cipher> threadLocal = zza;
            threadLocal.get().init(2, this.zzb, gCMParameterSpec);
            if (bArr2.length != 0) {
                threadLocal.get().updateAAD(bArr2);
            }
            return threadLocal.get().doFinal(bArr, 12, length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
