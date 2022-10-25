package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzmb implements zzly {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzly
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzly
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.service.directly_maybe_log_error_events", false);
        zzb = zzdmVar.zza("measurement.id.service.directly_maybe_log_error_events", 0L);
    }
}
