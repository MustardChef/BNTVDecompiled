package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbm */
/* loaded from: classes3.dex */
public final class zzbm {
    public static final String zza;
    public static final String zzb;
    @Deprecated
    public static final zzix zzc;
    @Deprecated
    public static final zzix zzd;
    @Deprecated
    public static final zzix zze;

    static {
        new zzbt();
        zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
        new zzcc();
        zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
        new zzcf();
        new zzbz();
        new zzcl();
        new zzcp();
        new zzci();
        new zzcs();
        zzix zza2 = zzix.zza();
        zzc = zza2;
        zzd = zza2;
        zze = zza2;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzdw.zza();
        zzbk.zza(new zzbt(), true);
        zzbk.zza(new zzbz(), true);
        zzbk.zza(new zzcc(), true);
        zzcf.zzj(true);
        zzbk.zza(new zzci(), true);
        zzbk.zza(new zzcl(), true);
        zzbk.zza(new zzcp(), true);
        zzbk.zza(new zzcs(), true);
        zzbk.zzc(new zzbq());
    }
}
