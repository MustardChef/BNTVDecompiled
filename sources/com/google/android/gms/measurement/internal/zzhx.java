package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzhx implements Runnable {
    private final /* synthetic */ zzac zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ int zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzhb zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhx(zzhb zzhbVar, zzac zzacVar, long j, int i, long j2, boolean z) {
        this.zzf = zzhbVar;
        this.zza = zzacVar;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzf.zza(this.zza);
        this.zzf.zza(this.zzb, false);
        this.zzf.zza(this.zza, this.zzc, this.zzd, true, this.zze);
    }
}
