package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzoe implements zzof {
    private static final zzdh<Long> zza;
    private static final zzdh<Boolean> zzb;
    private static final zzdh<Boolean> zzc;
    private static final zzdh<Boolean> zzd;
    private static final zzdh<Long> zze;

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zza() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zzb() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.id.lifecycle.app_in_background_parameter", 0L);
        zzb = zzdmVar.zza("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzdmVar.zza("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzdmVar.zza("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzdmVar.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }
}
