package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzmi implements zzmj {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Boolean> zzb;
    private static final zzdh<Long> zzc;

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.service.configurable_service_limits", true);
        zzb = zzdmVar.zza("measurement.client.configurable_service_limits", true);
        zzc = zzdmVar.zza("measurement.id.service.configurable_service_limits", 0L);
    }
}
