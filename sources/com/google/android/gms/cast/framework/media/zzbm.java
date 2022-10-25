package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzbm extends BasePendingResult<RemoteMediaClient.MediaChannelResult> {
    private com.google.android.gms.cast.internal.zzap zza;
    private final boolean zzb;
    final /* synthetic */ RemoteMediaClient zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbm(RemoteMediaClient remoteMediaClient, boolean z) {
        super((GoogleApiClient) null);
        this.zzg = remoteMediaClient;
        this.zzb = z;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ RemoteMediaClient.MediaChannelResult createFailedResult(Status status) {
        return new zzbl(this, status);
    }

    abstract void zza() throws com.google.android.gms.cast.internal.zzal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.cast.internal.zzap zzb() {
        if (this.zza == null) {
            this.zza = new zzbk(this);
        }
        return this.zza;
    }

    public final void zzc() {
        Object obj;
        List<RemoteMediaClient.Listener> list;
        if (!this.zzb) {
            list = this.zzg.zzh;
            for (RemoteMediaClient.Listener listener : list) {
                listener.onSendingRemoteMediaRequest();
            }
            for (RemoteMediaClient.Callback callback : this.zzg.zza) {
                callback.onSendingRemoteMediaRequest();
            }
        }
        try {
            obj = this.zzg.zzb;
            synchronized (obj) {
                zza();
            }
        } catch (com.google.android.gms.cast.internal.zzal unused) {
            setResult(new zzbl(this, new Status(2100)));
        }
    }
}
