package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzfw implements Runnable {
    private final /* synthetic */ zzgy zza;
    private final /* synthetic */ zzfu zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfw(zzfu zzfuVar, zzgy zzgyVar) {
        this.zzb = zzfuVar;
        this.zza = zzgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
