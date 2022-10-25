package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzgb implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzfz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgb(zzfz zzfzVar, zzn zznVar) {
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
        zzn zznVar = this.zza;
        zzklVar2.zzp().zzc();
        zzklVar2.zzn();
        Preconditions.checkNotEmpty(zznVar.zza);
        zzklVar2.zzc(zznVar);
    }
}
