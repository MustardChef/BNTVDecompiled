package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkn */
/* loaded from: classes3.dex */
public final class zzkn implements zzay {
    private final zzea zza;
    private final int zzb;

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzay
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!zzjm.zza(this.zza.zza(bArr2, this.zzb), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    public zzkn(zzea zzeaVar, int i) throws GeneralSecurityException {
        this.zza = zzeaVar;
        this.zzb = i;
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        zzeaVar.zza(new byte[0], i);
    }
}
