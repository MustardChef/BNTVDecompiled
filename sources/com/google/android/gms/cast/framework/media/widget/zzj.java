package com.google.android.gms.cast.framework.media.widget;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzj implements Runnable {
    final /* synthetic */ zzk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(zzk zzkVar) {
        this.zza = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzk zzkVar = this.zza;
        zzkVar.zzb.zzq(zzkVar.zza);
    }
}
