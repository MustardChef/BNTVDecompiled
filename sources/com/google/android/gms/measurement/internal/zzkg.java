package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzkg extends zzai {
    private final /* synthetic */ zzkl zza;
    private final /* synthetic */ zzkh zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkg(zzkh zzkhVar, zzgt zzgtVar, zzkl zzklVar) {
        super(zzgtVar);
        this.zzb = zzkhVar;
        this.zza = zzklVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzai
    public final void zza() {
        this.zzb.zze();
        this.zzb.zzq().zzw().zza("Starting upload from DelayedRunnable");
        this.zza.zzo();
    }
}
