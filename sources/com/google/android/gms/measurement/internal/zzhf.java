package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
final class zzhf implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhf(zzhb zzhbVar, boolean z) {
        this.zzb = zzhbVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zzaa = this.zzb.zzy.zzaa();
        boolean zzz = this.zzb.zzy.zzz();
        this.zzb.zzy.zza(this.zza);
        if (zzz == this.zza) {
            this.zzb.zzy.zzq().zzw().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzy.zzaa() == zzaa || this.zzb.zzy.zzaa() != this.zzb.zzy.zzz()) {
            this.zzb.zzy.zzq().zzj().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzaa));
        }
        this.zzb.zzal();
    }
}
