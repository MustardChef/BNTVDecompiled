package com.google.android.gms.internal.cast;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzbu extends zzbt {
    final /* synthetic */ zzbw zza;
    private final zzcb zzb;

    public zzbu(zzbw zzbwVar, zzcb zzcbVar) {
        this.zza = zzbwVar;
        this.zzb = zzcbVar;
    }

    @Override // com.google.android.gms.internal.cast.zzbt, com.google.android.gms.internal.cast.zzcd
    public final void zzb(int i, int i2, Surface surface) {
        Logger logger;
        VirtualDisplay virtualDisplay;
        VirtualDisplay virtualDisplay2;
        Logger logger2;
        VirtualDisplay virtualDisplay3;
        Logger logger3;
        Logger logger4;
        Logger logger5;
        logger = zzby.zza;
        logger.m369d("onConnected", new Object[0]);
        DisplayManager displayManager = (DisplayManager) this.zzb.getContext().getSystemService("display");
        if (displayManager == null) {
            logger5 = zzby.zza;
            logger5.m367e("Unable to get the display manager", new Object[0]);
            this.zza.setResult((zzbw) new zzbx(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        zzby.zzb(this.zza.zzc);
        this.zza.zzc.zzc = displayManager.createVirtualDisplay("private_display", i, i2, ((i < i2 ? i : i2) * 320) / 1080, surface, 2);
        virtualDisplay = this.zza.zzc.zzc;
        if (virtualDisplay == null) {
            logger4 = zzby.zza;
            logger4.m367e("Unable to create virtual display", new Object[0]);
            this.zza.setResult((zzbw) new zzbx(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        virtualDisplay2 = this.zza.zzc.zzc;
        if (virtualDisplay2.getDisplay() == null) {
            logger3 = zzby.zza;
            logger3.m367e("Virtual display does not have a display", new Object[0]);
            this.zza.setResult((zzbw) new zzbx(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        try {
            zzcb zzcbVar = this.zzb;
            virtualDisplay3 = this.zza.zzc.zzc;
            ((zzce) zzcbVar.getService()).zzh(this, virtualDisplay3.getDisplay().getDisplayId());
        } catch (RemoteException | IllegalStateException unused) {
            logger2 = zzby.zza;
            logger2.m367e("Unable to provision the route's new virtual Display", new Object[0]);
            this.zza.setResult((zzbw) new zzbx(Status.RESULT_INTERNAL_ERROR));
        }
    }

    @Override // com.google.android.gms.internal.cast.zzbt, com.google.android.gms.internal.cast.zzcd
    public final void zzc() {
        Logger logger;
        VirtualDisplay virtualDisplay;
        VirtualDisplay virtualDisplay2;
        Logger logger2;
        Logger logger3;
        logger = zzby.zza;
        logger.m369d("onConnectedWithDisplay", new Object[0]);
        virtualDisplay = this.zza.zzc.zzc;
        if (virtualDisplay == null) {
            logger3 = zzby.zza;
            logger3.m367e("There is no virtual display", new Object[0]);
            this.zza.setResult((zzbw) new zzbx(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        virtualDisplay2 = this.zza.zzc.zzc;
        Display display = virtualDisplay2.getDisplay();
        if (display != null) {
            this.zza.setResult((zzbw) new zzbx(display));
            return;
        }
        logger2 = zzby.zza;
        logger2.m367e("Virtual display no longer has a display", new Object[0]);
        this.zza.setResult((zzbw) new zzbx(Status.RESULT_INTERNAL_ERROR));
    }

    @Override // com.google.android.gms.internal.cast.zzbt, com.google.android.gms.internal.cast.zzcd
    public final void zzd(int i) throws RemoteException {
        Logger logger;
        logger = zzby.zza;
        logger.m369d("onError: %d", Integer.valueOf(i));
        zzby.zzb(this.zza.zzc);
        this.zza.setResult((zzbw) new zzbx(Status.RESULT_INTERNAL_ERROR));
    }
}
