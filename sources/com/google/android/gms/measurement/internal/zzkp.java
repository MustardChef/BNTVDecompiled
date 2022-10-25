package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzml;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzkp implements Callable<String> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzkl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkp(zzkl zzklVar, zzn zznVar) {
        this.zzb = zzklVar;
        this.zza = zznVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        if (zzml.zzb() && this.zzb.zzb().zza(zzas.zzci) && (!this.zzb.zza(this.zza.zza).zze() || !zzac.zza(this.zza.zzw).zze())) {
            this.zzb.zzq().zzw().zza("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        zzf zzc = this.zzb.zzc(this.zza);
        if (zzc == null) {
            this.zzb.zzq().zzh().zza("App info was null when attempting to get app instance id");
            return null;
        }
        return zzc.zzd();
    }
}
