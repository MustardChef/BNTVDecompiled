package com.google.android.gms.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzaa implements Runnable {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.zza;
        z = castRemoteDisplayLocalService.zzr;
        StringBuilder sb = new StringBuilder(59);
        sb.append("onCreate after delay. The local service been started: ");
        sb.append(z);
        castRemoteDisplayLocalService.zzx(sb.toString());
        z2 = this.zza.zzr;
        if (z2) {
            return;
        }
        CastRemoteDisplayLocalService.zza.m367e("[Instance: %s] %s", this.zza, "The local service has not been been started, stopping it");
        this.zza.stopSelf();
    }
}
