package com.google.android.gms.cast.internal;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzs implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ zzy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(zzv zzvVar, zzw zzwVar, zzy zzyVar) {
        this.zza = zzwVar;
        this.zzb = zzyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzw.zzT(this.zza, this.zzb);
    }
}
