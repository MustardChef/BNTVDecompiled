package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzmo implements zzmp {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Boolean> zzb;
    private static final zzdh<Boolean> zzc;
    private static final zzdh<Long> zzd;

    @Override // com.google.android.gms.internal.measurement.zzmp
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.sdk.dynamite.allow_remote_dynamite3", true);
        zzb = zzdmVar.zza("measurement.collection.init_params_control_enabled", true);
        zzc = zzdmVar.zza("measurement.sdk.dynamite.use_dynamite3", true);
        zzd = zzdmVar.zza("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }
}
