package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzgl implements Runnable {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzfz zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgl(zzfz zzfzVar, zzaq zzaqVar, String str) {
        this.zzc = zzfzVar;
        this.zza = zzaqVar;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkl zzklVar;
        zzkl zzklVar2;
        zzklVar = this.zzc.zza;
        zzklVar.zzr();
        zzklVar2 = this.zzc.zza;
        zzklVar2.zza(this.zza, this.zzb);
    }
}
