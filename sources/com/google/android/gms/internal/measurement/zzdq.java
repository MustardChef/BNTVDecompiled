package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzdq {
    private final boolean zza;

    public zzdq(zzdt zzdtVar) {
        zzeb.zza(zzdtVar, "BuildInfo must be non-null");
        this.zza = !zzdtVar.zza();
    }

    public final boolean zza(String str) {
        zzeb.zza(str, "flagName must not be null");
        if (this.zza) {
            return zzds.zza.zza().zza(str);
        }
        return true;
    }
}
