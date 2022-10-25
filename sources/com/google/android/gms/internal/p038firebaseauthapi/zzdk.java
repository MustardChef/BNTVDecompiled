package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdk */
/* loaded from: classes3.dex */
public final class zzdk {
    public static final /* synthetic */ int zza = 0;
    private static final String zzb = "zzdk";
    private final zzav zzc;
    private final zzag zzd;
    private final zzau zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdk(zzdj zzdjVar, zzdi zzdiVar) throws GeneralSecurityException, IOException {
        this.zzc = zzdj.zze(zzdjVar);
        this.zzd = zzdj.zzf(zzdjVar);
        this.zze = zzdj.zzg(zzdjVar);
    }

    public final synchronized zzat zza() throws GeneralSecurityException {
        return this.zze.zzc();
    }
}
