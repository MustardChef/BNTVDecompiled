package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
final class zzjk implements Runnable {
    private final /* synthetic */ zzei zza;
    private final /* synthetic */ zzjl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjk(zzjl zzjlVar, zzei zzeiVar) {
        this.zzb = zzjlVar;
        this.zza = zzeiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzaa()) {
                this.zzb.zza.zzq().zzw().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
