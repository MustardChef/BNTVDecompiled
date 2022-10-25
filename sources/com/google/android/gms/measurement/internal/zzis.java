package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzis implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzku zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ zzir zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzis(zzir zzirVar, boolean z, zzku zzkuVar, zzn zznVar) {
        this.zzd = zzirVar;
        this.zza = z;
        this.zzb = zzkuVar;
        this.zzc = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzei zzeiVar;
        zzeiVar = this.zzd.zzb;
        if (zzeiVar == null) {
            this.zzd.zzq().zze().zza("Discarding data. Failed to set user property");
            return;
        }
        this.zzd.zza(zzeiVar, this.zza ? null : this.zzb, this.zzc);
        this.zzd.zzaj();
    }
}
