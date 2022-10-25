package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzgd implements Runnable {
    private final /* synthetic */ zzz zza;
    private final /* synthetic */ zzfz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgd(zzfz zzfzVar, zzz zzzVar) {
        this.zzb = zzfzVar;
        this.zza = zzzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkl zzklVar;
        zzkl zzklVar2;
        zzkl zzklVar3;
        zzklVar = this.zzb.zza;
        zzklVar.zzr();
        if (this.zza.zzc.zza() == null) {
            zzklVar3 = this.zzb.zza;
            zzklVar3.zzb(this.zza);
            return;
        }
        zzklVar2 = this.zzb.zza;
        zzklVar2.zza(this.zza);
    }
}
