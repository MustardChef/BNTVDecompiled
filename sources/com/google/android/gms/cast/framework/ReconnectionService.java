package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class ReconnectionService extends Service {
    private static final Logger zza = new Logger("ReconnectionService");
    private zzae zzb;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        zzae zzaeVar = this.zzb;
        if (zzaeVar != null) {
            try {
                return zzaeVar.zzg(intent);
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "onBind", zzae.class.getSimpleName());
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        CastContext sharedInstance = CastContext.getSharedInstance(this);
        zzae zzd = com.google.android.gms.internal.cast.zzm.zzd(this, sharedInstance.getSessionManager().zzd(), sharedInstance.zzc().zza());
        this.zzb = zzd;
        if (zzd != null) {
            try {
                zzd.zze();
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "onCreate", zzae.class.getSimpleName());
            }
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        zzae zzaeVar = this.zzb;
        if (zzaeVar != null) {
            try {
                zzaeVar.zzh();
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "onDestroy", zzae.class.getSimpleName());
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        zzae zzaeVar = this.zzb;
        if (zzaeVar != null) {
            try {
                return zzaeVar.zzf(intent, i, i2);
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "onStartCommand", zzae.class.getSimpleName());
            }
        }
        return 2;
    }
}
