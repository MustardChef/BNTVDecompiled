package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzn extends com.google.android.gms.cast.zzp {
    final /* synthetic */ CastSession zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzn(CastSession castSession, zzi zziVar) {
        this.zza = castSession;
    }

    @Override // com.google.android.gms.cast.zzp
    public final void zza() {
        zzx zzxVar;
        Logger logger;
        RemoteMediaClient remoteMediaClient;
        zzx zzxVar2;
        RemoteMediaClient remoteMediaClient2;
        zzxVar = this.zza.zze;
        if (zzxVar == null) {
            return;
        }
        try {
            remoteMediaClient = this.zza.zzi;
            if (remoteMediaClient != null) {
                remoteMediaClient2 = this.zza.zzi;
                remoteMediaClient2.zzb();
            }
            zzxVar2 = this.zza.zze;
            zzxVar2.zze(null);
        } catch (RemoteException e) {
            logger = CastSession.zzb;
            logger.m368d(e, "Unable to call %s on %s.", "onConnected", zzx.class.getSimpleName());
        }
    }

    @Override // com.google.android.gms.cast.zzp
    public final void zzb(int i) {
        zzx zzxVar;
        Logger logger;
        zzx zzxVar2;
        zzxVar = this.zza.zze;
        if (zzxVar == null) {
            return;
        }
        try {
            zzxVar2 = this.zza.zze;
            zzxVar2.zzg(new ConnectionResult(i));
        } catch (RemoteException e) {
            logger = CastSession.zzb;
            logger.m368d(e, "Unable to call %s on %s.", "onConnectionFailed", zzx.class.getSimpleName());
        }
    }

    @Override // com.google.android.gms.cast.zzp
    public final void zzc(int i) {
        zzx zzxVar;
        Logger logger;
        zzx zzxVar2;
        zzxVar = this.zza.zze;
        if (zzxVar == null) {
            return;
        }
        try {
            zzxVar2 = this.zza.zze;
            zzxVar2.zzf(i);
        } catch (RemoteException e) {
            logger = CastSession.zzb;
            logger.m368d(e, "Unable to call %s on %s.", "onConnectionSuspended", zzx.class.getSimpleName());
        }
    }

    @Override // com.google.android.gms.cast.zzp
    public final void zzd(int i) {
        zzx zzxVar;
        Logger logger;
        zzx zzxVar2;
        zzxVar = this.zza.zze;
        if (zzxVar == null) {
            return;
        }
        try {
            zzxVar2 = this.zza.zze;
            zzxVar2.zzg(new ConnectionResult(i));
        } catch (RemoteException e) {
            logger = CastSession.zzb;
            logger.m368d(e, "Unable to call %s on %s.", "onDisconnected", zzx.class.getSimpleName());
        }
    }
}
