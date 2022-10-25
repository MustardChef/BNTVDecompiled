package com.google.android.gms.cast.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzaj implements zzap {
    final /* synthetic */ zzap zza;
    final /* synthetic */ zzan zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(zzan zzanVar, zzap zzapVar) {
        this.zzb = zzanVar;
        this.zza = zzapVar;
    }

    @Override // com.google.android.gms.cast.internal.zzap
    public final void zza(long j) {
        zzap zzapVar = this.zza;
        if (zzapVar != null) {
            zzapVar.zza(j);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzap
    public final void zzb(long j, int i, Object obj) {
        this.zzb.zzy = null;
        zzap zzapVar = this.zza;
        if (zzapVar != null) {
            zzapVar.zzb(j, i, obj);
        }
    }
}
