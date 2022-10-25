package com.google.android.gms.internal.cast;

import android.app.Activity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzx implements com.google.android.gms.cast.framework.internal.featurehighlight.zzg {
    final /* synthetic */ zzy zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(zzy zzyVar) {
        this.zza = zzyVar;
    }

    @Override // com.google.android.gms.cast.framework.internal.featurehighlight.zzg
    public final void zza() {
        boolean z;
        Activity activity;
        com.google.android.gms.cast.framework.internal.featurehighlight.zzh zzhVar;
        z = this.zza.zzg;
        if (z) {
            activity = this.zza.zzb;
            com.google.android.gms.cast.framework.zzaq.zza(activity);
            zzhVar = this.zza.zze;
            zzhVar.zze(new zzv(this));
        }
    }

    @Override // com.google.android.gms.cast.framework.internal.featurehighlight.zzg
    public final void zzb() {
        boolean z;
        Activity activity;
        com.google.android.gms.cast.framework.internal.featurehighlight.zzh zzhVar;
        z = this.zza.zzg;
        if (z) {
            activity = this.zza.zzb;
            com.google.android.gms.cast.framework.zzaq.zza(activity);
            zzhVar = this.zza.zze;
            zzhVar.zzd(new zzw(this));
        }
    }
}
