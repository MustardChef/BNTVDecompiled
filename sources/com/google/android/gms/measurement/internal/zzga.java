package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzga implements Runnable {
    private final /* synthetic */ zzz zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzfz zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzga(zzfz zzfzVar, zzz zzzVar, zzn zznVar) {
        this.zzc = zzfzVar;
        this.zza = zzzVar;
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkl zzklVar;
        zzkl zzklVar2;
        zzkl zzklVar3;
        zzklVar = this.zzc.zza;
        zzklVar.zzr();
        if (this.zza.zzc.zza() == null) {
            zzklVar3 = this.zzc.zza;
            zzklVar3.zzb(this.zza, this.zzb);
            return;
        }
        zzklVar2 = this.zzc.zza;
        zzklVar2.zza(this.zza, this.zzb);
    }
}
