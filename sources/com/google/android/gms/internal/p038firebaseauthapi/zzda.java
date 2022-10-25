package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzda */
/* loaded from: classes3.dex */
public final class zzda {
    @Deprecated
    public static final zzix zza;
    @Deprecated
    public static final zzix zzb;
    @Deprecated
    public static final zzix zzc;

    static {
        new zzcz();
        new zzcx();
        zza = zzix.zza();
        zzb = zzix.zza();
        zzc = zzix.zza();
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzbm.zza();
        zzbk.zzb(new zzcx(), new zzcz(), true);
        zzbk.zzc(new zzdc());
        zzbk.zzc(new zzde());
    }
}
