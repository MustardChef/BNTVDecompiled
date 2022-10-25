package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzgo implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzfz zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgo(zzfz zzfzVar, String str, String str2, String str3, long j) {
        this.zze = zzfzVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkl zzklVar;
        zzkl zzklVar2;
        String str = this.zza;
        if (str != null) {
            zzij zzijVar = new zzij(this.zzc, str, this.zzd);
            zzklVar = this.zze.zza;
            zzklVar.zzu().zzu().zza(this.zzb, zzijVar);
            return;
        }
        zzklVar2 = this.zze.zza;
        zzklVar2.zzu().zzu().zza(this.zzb, (zzij) null);
    }
}
