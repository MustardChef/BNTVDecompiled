package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzgk implements Callable<byte[]> {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzfz zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgk(zzfz zzfzVar, zzaq zzaqVar, String str) {
        this.zzc = zzfzVar;
        this.zza = zzaqVar;
        this.zzb = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        zzkl zzklVar;
        zzkl zzklVar2;
        zzklVar = this.zzc.zza;
        zzklVar.zzr();
        zzklVar2 = this.zzc.zza;
        return zzklVar2.zzg().zza(this.zza, this.zzb);
    }
}
