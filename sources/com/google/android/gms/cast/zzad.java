package com.google.android.gms.cast;

import com.google.android.gms.cast.CastRemoteDisplayLocalService;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzad implements Runnable {
    final /* synthetic */ CastRemoteDisplayLocalService.NotificationSettings zza;
    final /* synthetic */ CastRemoteDisplayLocalService zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(CastRemoteDisplayLocalService castRemoteDisplayLocalService, CastRemoteDisplayLocalService.NotificationSettings notificationSettings) {
        this.zzb = castRemoteDisplayLocalService;
        this.zza = notificationSettings;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CastRemoteDisplayLocalService.zzi(this.zzb, this.zza);
    }
}
