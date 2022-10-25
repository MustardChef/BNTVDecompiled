package com.google.android.gms.cast;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzab implements ServiceConnection {
    final /* synthetic */ String zza;
    final /* synthetic */ CastDevice zzb;
    final /* synthetic */ CastRemoteDisplayLocalService.Options zzc;
    final /* synthetic */ CastRemoteDisplayLocalService.NotificationSettings zzd;
    final /* synthetic */ Context zze;
    final /* synthetic */ CastRemoteDisplayLocalService.Callbacks zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(String str, CastDevice castDevice, CastRemoteDisplayLocalService.Options options, CastRemoteDisplayLocalService.NotificationSettings notificationSettings, Context context, CastRemoteDisplayLocalService.Callbacks callbacks) {
        this.zza = str;
        this.zzb = castDevice;
        this.zzc = options;
        this.zzd = notificationSettings;
        this.zze = context;
        this.zzf = callbacks;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Logger logger;
        AtomicBoolean atomicBoolean;
        Logger logger2;
        if (CastRemoteDisplayLocalService.zze(((zzah) iBinder).zza, this.zza, this.zzb, this.zzc, this.zzd, this.zze, this, this.zzf)) {
            return;
        }
        logger = CastRemoteDisplayLocalService.zza;
        logger.m367e("Connected but unable to get the service instance", new Object[0]);
        this.zzf.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
        atomicBoolean = CastRemoteDisplayLocalService.zzd;
        atomicBoolean.set(false);
        try {
            ConnectionTracker.getInstance().unbindService(this.zze, this);
        } catch (IllegalArgumentException unused) {
            logger2 = CastRemoteDisplayLocalService.zza;
            logger2.m369d("No need to unbind service, already unbound", new Object[0]);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Logger logger;
        AtomicBoolean atomicBoolean;
        Logger logger2;
        logger = CastRemoteDisplayLocalService.zza;
        logger.m369d("onServiceDisconnected", new Object[0]);
        this.zzf.onRemoteDisplaySessionError(new Status((int) CastStatusCodes.ERROR_SERVICE_DISCONNECTED, "Service Disconnected"));
        atomicBoolean = CastRemoteDisplayLocalService.zzd;
        atomicBoolean.set(false);
        try {
            ConnectionTracker.getInstance().unbindService(this.zze, this);
        } catch (IllegalArgumentException unused) {
            logger2 = CastRemoteDisplayLocalService.zza;
            logger2.m369d("No need to unbind service, already unbound", new Object[0]);
        }
    }
}
