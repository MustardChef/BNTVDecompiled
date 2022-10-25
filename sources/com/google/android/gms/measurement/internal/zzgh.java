package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzgh implements Callable<List<zzz>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzfz zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgh(zzfz zzfzVar, String str, String str2, String str3) {
        this.zzd = zzfzVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzz> call() throws Exception {
        zzkl zzklVar;
        zzkl zzklVar2;
        zzklVar = this.zzd.zza;
        zzklVar.zzr();
        zzklVar2 = this.zzd.zza;
        return zzklVar2.zze().zzb(this.zza, this.zzb, this.zzc);
    }
}
