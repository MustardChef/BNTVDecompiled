package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzoq implements zzor {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Double> zzb;
    private static final zzdh<Long> zzc;
    private static final zzdh<Long> zzd;
    private static final zzdh<String> zze;

    @Override // com.google.android.gms.internal.measurement.zzor
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final double zzb() {
        return zzb.zzc().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final long zzc() {
        return zzc.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final long zzd() {
        return zzd.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final String zze() {
        return zze.zzc();
    }

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.test.boolean_flag", false);
        zzb = zzdmVar.zza("measurement.test.double_flag", -3.0d);
        zzc = zzdmVar.zza("measurement.test.int_flag", -2L);
        zzd = zzdmVar.zza("measurement.test.long_flag", -1L);
        zze = zzdmVar.zza("measurement.test.string_flag", "---");
    }
}
