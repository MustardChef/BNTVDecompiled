package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzgm implements Callable<List<zzkw>> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzfz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgm(zzfz zzfzVar, zzn zznVar) {
        this.zzb = zzfzVar;
        this.zza = zznVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzkw> call() throws Exception {
        zzkl zzklVar;
        zzkl zzklVar2;
        zzklVar = this.zzb.zza;
        zzklVar.zzr();
        zzklVar2 = this.zzb.zza;
        return zzklVar2.zze().zza(this.zza.zza);
    }
}
