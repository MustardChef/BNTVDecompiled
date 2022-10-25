package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzgg implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzfz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgg(zzfz zzfzVar, zzn zznVar) {
        this.zzb = zzfzVar;
        this.zza = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkl zzklVar;
        zzkl zzklVar2;
        zzklVar = this.zzb.zza;
        zzklVar.zzr();
        zzklVar2 = this.zzb.zza;
        zzklVar2.zza(this.zza);
    }
}
