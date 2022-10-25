package com.google.android.gms.cast;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzw extends zzy {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ com.google.android.gms.internal.cast.zzbz zzb;
    final /* synthetic */ CastRemoteDisplayClient zzc;
    final /* synthetic */ zzae zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzw(CastRemoteDisplayClient castRemoteDisplayClient, TaskCompletionSource taskCompletionSource, com.google.android.gms.internal.cast.zzbz zzbzVar, zzae zzaeVar, byte[] bArr) {
        super(null);
        this.zzc = castRemoteDisplayClient;
        this.zza = taskCompletionSource;
        this.zzb = zzbzVar;
        this.zzd = zzaeVar;
    }

    @Override // com.google.android.gms.cast.zzy, com.google.android.gms.internal.cast.zzcd
    public final void zzb(int i, int i2, Surface surface) throws RemoteException {
        Logger logger;
        VirtualDisplay virtualDisplay;
        VirtualDisplay virtualDisplay2;
        Logger logger2;
        Logger logger3;
        Logger logger4;
        Logger logger5;
        logger = this.zzc.zza;
        logger.m369d("onConnected", new Object[0]);
        DisplayManager displayManager = (DisplayManager) this.zzc.getApplicationContext().getSystemService("display");
        if (displayManager == null) {
            logger5 = this.zzc.zza;
            logger5.m367e("Unable to get the display manager", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        CastRemoteDisplayClient.zzb(this.zzc);
        int min = Math.min(i, i2);
        this.zzc.zzb = displayManager.createVirtualDisplay("private_display", i, i2, (min * 320) / 1080, surface, 2);
        virtualDisplay = this.zzc.zzb;
        if (virtualDisplay == null) {
            logger4 = this.zzc.zza;
            logger4.m367e("Unable to create virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        virtualDisplay2 = this.zzc.zzb;
        Display display = virtualDisplay2.getDisplay();
        if (display == null) {
            logger3 = this.zzc.zza;
            logger3.m367e("Virtual display does not have a display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        try {
            ((com.google.android.gms.internal.cast.zzce) this.zzb.getService()).zzh(this, display.getDisplayId());
        } catch (RemoteException | IllegalStateException unused) {
            logger2 = this.zzc.zza;
            logger2.m367e("Unable to provision the route's new virtual Display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
        }
    }

    @Override // com.google.android.gms.cast.zzy, com.google.android.gms.internal.cast.zzcd
    public final void zzc() {
        Logger logger;
        VirtualDisplay virtualDisplay;
        VirtualDisplay virtualDisplay2;
        Logger logger2;
        Logger logger3;
        logger = this.zzc.zza;
        logger.m369d("onConnectedWithDisplay", new Object[0]);
        virtualDisplay = this.zzc.zzb;
        if (virtualDisplay == null) {
            logger3 = this.zzc.zza;
            logger3.m367e("There is no virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        virtualDisplay2 = this.zzc.zzb;
        Display display = virtualDisplay2.getDisplay();
        if (display != null) {
            TaskUtil.setResultOrApiException(Status.RESULT_SUCCESS, display, this.zza);
            return;
        }
        logger2 = this.zzc.zza;
        logger2.m367e("Virtual display no longer has a display", new Object[0]);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
    }

    @Override // com.google.android.gms.cast.zzy, com.google.android.gms.internal.cast.zzcd
    public final void zzd(int i) throws RemoteException {
        Logger logger;
        logger = this.zzc.zza;
        logger.m369d("onError: %d", Integer.valueOf(i));
        CastRemoteDisplayClient.zzb(this.zzc);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
    }

    @Override // com.google.android.gms.cast.zzy, com.google.android.gms.internal.cast.zzcd
    public final void zze(boolean z) {
        Logger logger;
        WeakReference weakReference;
        logger = this.zzc.zza;
        logger.m369d("onRemoteDisplayMuteStateChanged: %b", Boolean.valueOf(z));
        zzae zzaeVar = this.zzd;
        if (zzaeVar != null) {
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzaeVar.zza;
            StringBuilder sb = new StringBuilder(38);
            sb.append("onRemoteDisplayMuteStateChanged: ");
            sb.append(z);
            castRemoteDisplayLocalService.zzx(sb.toString());
            weakReference = zzaeVar.zza.zzf;
            CastRemoteDisplayLocalService.Callbacks callbacks = (CastRemoteDisplayLocalService.Callbacks) weakReference.get();
            if (callbacks != null) {
                callbacks.zza();
            }
        }
    }
}
