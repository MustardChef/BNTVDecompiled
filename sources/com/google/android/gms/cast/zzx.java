package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzx extends zzy {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ CastRemoteDisplayClient zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzx(CastRemoteDisplayClient castRemoteDisplayClient, TaskCompletionSource taskCompletionSource) {
        super(null);
        this.zzb = castRemoteDisplayClient;
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.cast.zzy, com.google.android.gms.internal.cast.zzcd
    public final void zzd(int i) throws RemoteException {
        Logger logger;
        logger = this.zzb.zza;
        logger.m369d("onError: %d", Integer.valueOf(i));
        CastRemoteDisplayClient.zzb(this.zzb);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, this.zza);
    }

    @Override // com.google.android.gms.cast.zzy, com.google.android.gms.internal.cast.zzcd
    public final void zzf() throws RemoteException {
        Logger logger;
        logger = this.zzb.zza;
        logger.m369d("onDisconnected", new Object[0]);
        CastRemoteDisplayClient.zzb(this.zzb);
        TaskUtil.setResultOrApiException(Status.RESULT_SUCCESS, this.zza);
    }
}
