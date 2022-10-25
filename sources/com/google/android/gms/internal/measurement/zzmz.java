package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzmz implements zzmw {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Boolean> zzb;
    private static final zzdh<Boolean> zzc;
    private static final zzdh<Boolean> zzd;

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final boolean zzc() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final boolean zzd() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzdmVar.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzdmVar.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzdmVar.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
