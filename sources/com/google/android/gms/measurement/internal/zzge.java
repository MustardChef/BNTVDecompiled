package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzge implements Callable<List<zzz>> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzfz zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzge(zzfz zzfzVar, zzn zznVar, String str, String str2) {
        this.zzd = zzfzVar;
        this.zza = zznVar;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzz> call() throws Exception {
        zzkl zzklVar;
        zzkl zzklVar2;
        zzklVar = this.zzd.zza;
        zzklVar.zzr();
        zzklVar2 = this.zzd.zza;
        return zzklVar2.zze().zzb(this.zza.zza, this.zzb, this.zzc);
    }
}
