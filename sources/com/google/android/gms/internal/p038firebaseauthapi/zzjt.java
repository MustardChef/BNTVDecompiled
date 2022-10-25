package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjt */
/* loaded from: classes3.dex */
public final class zzjt implements zzal {
    private final zzjv zza;
    private final String zzb;
    private final byte[] zzc;
    private final zzjr zzd;

    public zzjt(ECPublicKey eCPublicKey, byte[] bArr, String str, int i, zzjr zzjrVar) throws GeneralSecurityException {
        zzjw.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zza = new zzjv(eCPublicKey);
        this.zzc = bArr;
        this.zzb = str;
        this.zzd = zzjrVar;
    }
}
