package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzbv extends zzbt {
    final /* synthetic */ zzbw zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbv(zzbw zzbwVar) {
        this.zza = zzbwVar;
    }

    @Override // com.google.android.gms.internal.cast.zzbt, com.google.android.gms.internal.cast.zzcd
    public final void zzd(int i) throws RemoteException {
        Logger logger;
        logger = zzby.zza;
        logger.m369d("onError: %d", Integer.valueOf(i));
        zzby.zzb(this.zza.zzc);
        this.zza.setResult((zzbw) new zzbx(Status.RESULT_INTERNAL_ERROR));
    }

    @Override // com.google.android.gms.internal.cast.zzbt, com.google.android.gms.internal.cast.zzcd
    public final void zzf() throws RemoteException {
        Logger logger;
        logger = zzby.zza;
        logger.m369d("onDisconnected", new Object[0]);
        zzby.zzb(this.zza.zzc);
        this.zza.setResult((zzbw) new zzbx(Status.RESULT_SUCCESS));
    }
}
