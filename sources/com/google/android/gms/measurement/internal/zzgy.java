package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzgy {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    com.google.android.gms.internal.measurement.zzae zzg;
    boolean zzh;
    Long zzi;

    public zzgy(Context context, com.google.android.gms.internal.measurement.zzae zzaeVar, Long l) {
        this.zzh = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzaeVar != null) {
            this.zzg = zzaeVar;
            this.zzb = zzaeVar.zzf;
            this.zzc = zzaeVar.zze;
            this.zzd = zzaeVar.zzd;
            this.zzh = zzaeVar.zzc;
            this.zzf = zzaeVar.zzb;
            if (zzaeVar.zzg != null) {
                this.zze = Boolean.valueOf(zzaeVar.zzg.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
