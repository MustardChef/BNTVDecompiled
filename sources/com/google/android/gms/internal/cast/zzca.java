package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzca extends zzcf {
    final /* synthetic */ zzcg zza;
    final /* synthetic */ zzcb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzca(zzcb zzcbVar, zzcg zzcgVar) {
        this.zzb = zzcbVar;
        this.zza = zzcgVar;
    }

    @Override // com.google.android.gms.internal.cast.zzcg
    public final void zzb(int i) throws RemoteException {
        Logger logger;
        CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks;
        CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks2;
        logger = zzcb.zze;
        logger.m369d("onRemoteDisplayEnded", new Object[0]);
        zzcg zzcgVar = this.zza;
        if (zzcgVar != null) {
            zzcgVar.zzb(i);
        }
        castRemoteDisplaySessionCallbacks = this.zzb.zzf;
        if (castRemoteDisplaySessionCallbacks != null) {
            castRemoteDisplaySessionCallbacks2 = this.zzb.zzf;
            castRemoteDisplaySessionCallbacks2.onRemoteDisplayEnded(new Status(i));
        }
    }
}
