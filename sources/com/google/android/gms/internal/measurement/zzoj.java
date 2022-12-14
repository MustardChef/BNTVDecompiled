package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzoj implements zzog {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Boolean> zzb;

    @Override // com.google.android.gms.internal.measurement.zzog
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzog
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzog
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.sdk.screen.manual_screen_view_logging", true);
        zzb = zzdmVar.zza("measurement.sdk.screen.disabling_automatic_reporting", true);
    }
}
