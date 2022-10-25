package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzkk implements Runnable {
    private final /* synthetic */ zzks zza;
    private final /* synthetic */ zzkl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkk(zzkl zzklVar, zzks zzksVar) {
        this.zzb = zzklVar;
        this.zza = zzksVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
