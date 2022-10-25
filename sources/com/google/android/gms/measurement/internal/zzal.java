package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzal implements Runnable {
    private final /* synthetic */ zzgt zza;
    private final /* synthetic */ zzai zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(zzai zzaiVar, zzgt zzgtVar) {
        this.zzb = zzaiVar;
        this.zza = zzgtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzt();
        if (zzw.zza()) {
            this.zza.zzp().zza(this);
            return;
        }
        boolean zzb = this.zzb.zzb();
        this.zzb.zzd = 0L;
        if (zzb) {
            this.zzb.zza();
        }
    }
}
