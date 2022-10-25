package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
final class zzfd implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfa zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfd(zzfa zzfaVar, boolean z) {
        this.zzb = zzfaVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkl zzklVar;
        zzklVar = this.zzb.zzb;
        zzklVar.zza(this.zza);
    }
}
