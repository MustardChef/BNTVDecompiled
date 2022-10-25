package com.google.android.gms.cast;

import android.content.Context;
import android.content.ServiceConnection;
import android.view.Display;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzaf implements OnCompleteListener<Display> {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Display> task) {
        Logger logger;
        Object obj;
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        AtomicBoolean atomicBoolean;
        Context context;
        ServiceConnection serviceConnection;
        Logger logger2;
        Logger logger3;
        Logger logger4;
        if (!task.isSuccessful()) {
            logger4 = CastRemoteDisplayLocalService.zza;
            logger4.m367e("Connection was not successful", new Object[0]);
            CastRemoteDisplayLocalService.zzk(this.zza);
            return;
        }
        logger = CastRemoteDisplayLocalService.zza;
        logger.m369d("startRemoteDisplay successful", new Object[0]);
        obj = CastRemoteDisplayLocalService.zzc;
        synchronized (obj) {
            castRemoteDisplayLocalService = CastRemoteDisplayLocalService.zzu;
            if (castRemoteDisplayLocalService == null) {
                logger3 = CastRemoteDisplayLocalService.zza;
                logger3.m369d("Remote Display started but session already cancelled", new Object[0]);
                CastRemoteDisplayLocalService.zzk(this.zza);
                return;
            }
            CastRemoteDisplayLocalService.zzn(this.zza, task.getResult());
            atomicBoolean = CastRemoteDisplayLocalService.zzd;
            atomicBoolean.set(false);
            context = this.zza.zzn;
            serviceConnection = this.zza.zzo;
            if (context != null && serviceConnection != null) {
                try {
                    ConnectionTracker.getInstance().unbindService(context, serviceConnection);
                } catch (IllegalArgumentException unused) {
                    logger2 = CastRemoteDisplayLocalService.zza;
                    logger2.m369d("No need to unbind service, already unbound", new Object[0]);
                }
            }
            this.zza.zzo = null;
            this.zza.zzn = null;
        }
    }
}
