package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzmc implements zzmd {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzmd
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmd
    public final long zzb() {
        return zzb.zzc().longValue();
    }

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.sdk.attribution.cache", true);
        zzb = zzdmVar.zza("measurement.sdk.attribution.cache.ttl", 604800000L);
    }
}
