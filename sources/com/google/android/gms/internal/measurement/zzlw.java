package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzlw implements zzlx {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Boolean> zzb;

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.androidId.delete_feature", true);
        zzb = zzdmVar.zza("measurement.log_androidId_enabled", false);
    }
}
