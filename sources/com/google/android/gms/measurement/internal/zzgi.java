package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzgi implements Runnable {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzfz zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgi(zzfz zzfzVar, zzaq zzaqVar, zzn zznVar) {
        this.zzc = zzfzVar;
        this.zza = zzaqVar;
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkl zzklVar;
        zzkl zzklVar2;
        zzaq zzb = this.zzc.zzb(this.zza, this.zzb);
        zzklVar = this.zzc.zza;
        zzklVar.zzr();
        zzklVar2 = this.zzc.zza;
        zzklVar2.zza(zzb, this.zzb);
    }
}
