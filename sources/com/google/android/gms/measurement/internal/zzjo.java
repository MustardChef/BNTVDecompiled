package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
final class zzjo implements Runnable {
    private final /* synthetic */ zzjl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjo(zzjl zzjlVar) {
        this.zza = zzjlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza.zzb = null;
        this.zza.zza.zzam();
    }
}
