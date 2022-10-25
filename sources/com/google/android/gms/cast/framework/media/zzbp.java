package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import java.util.Set;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbp extends TimerTask {
    final /* synthetic */ RemoteMediaClient zza;
    final /* synthetic */ zzbq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbp(zzbq zzbqVar, RemoteMediaClient remoteMediaClient) {
        this.zzb = zzbqVar;
        this.zza = remoteMediaClient;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Set set;
        Handler handler;
        long j;
        zzbq zzbqVar = this.zzb;
        RemoteMediaClient remoteMediaClient = zzbqVar.zza;
        set = zzbqVar.zzb;
        remoteMediaClient.zzr(set);
        handler = this.zzb.zza.zzc;
        j = this.zzb.zzc;
        handler.postDelayed(this, j);
    }
}
