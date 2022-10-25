package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzim implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzii zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzim(zzii zziiVar, long j) {
        this.zzb = zziiVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzd().zza(this.zza);
        this.zzb.zza = null;
    }
}
