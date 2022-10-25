package com.google.android.gms.internal.cast;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzck extends zzcp {
    final /* synthetic */ zzcl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzck(zzcl zzclVar) {
        this.zza = zzclVar;
    }

    @Override // com.google.android.gms.internal.cast.zzcp
    public final void zza(long j) {
        zzcl.zzc(this.zza);
        zzcl zzclVar = this.zza;
        if (zzclVar.zza(zzclVar.zza) || this.zza.zza.isStarted() || zzcl.zzd(this.zza)) {
            return;
        }
        this.zza.zza.start();
    }
}
