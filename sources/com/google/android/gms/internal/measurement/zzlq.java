package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzlq implements zzlr {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Boolean> zzb;
    private static final zzdh<Boolean> zzc;
    private static final zzdh<Long> zzd;

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlr
    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.client.ad_impression", true);
        zzb = zzdmVar.zza("measurement.service.separate_public_internal_event_blacklisting", true);
        zzc = zzdmVar.zza("measurement.service.ad_impression", true);
        zzd = zzdmVar.zza("measurement.id.service.ad_impression", 0L);
    }
}
