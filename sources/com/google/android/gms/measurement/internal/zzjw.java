package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
final class zzjw implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjw(zzjx zzjxVar, long j) {
        this.zzb = zzjxVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjx.zza(this.zzb, this.zza);
    }
}
