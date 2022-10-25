package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.p045ws.WebSocketProtocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbh implements com.google.android.gms.cast.internal.zzao {
    final /* synthetic */ RemoteMediaClient zza;
    private com.google.android.gms.cast.zzq zzb;
    private final AtomicLong zzc = new AtomicLong((CastUtils.zzb() & WebSocketProtocol.PAYLOAD_SHORT_MAX) * 10000);

    public zzbh(RemoteMediaClient remoteMediaClient) {
        this.zza = remoteMediaClient;
    }

    public final void zza(com.google.android.gms.cast.zzq zzqVar) {
        this.zzb = zzqVar;
    }

    @Override // com.google.android.gms.cast.internal.zzao
    public final long zzc() {
        return this.zzc.getAndIncrement();
    }

    @Override // com.google.android.gms.cast.internal.zzao
    public final void zzb(String str, String str2, final long j, String str3) {
        com.google.android.gms.cast.zzq zzqVar = this.zzb;
        if (zzqVar == null) {
            throw new IllegalStateException("Device is not connected");
        }
        zzqVar.zze(str, str2).addOnFailureListener(new OnFailureListener(this, j) { // from class: com.google.android.gms.cast.framework.media.zzbg
            private final zzbh zza;
            private final long zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = j;
            }

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                com.google.android.gms.cast.internal.zzan zzanVar;
                zzbh zzbhVar = this.zza;
                long j2 = this.zzb;
                int statusCode = exc instanceof ApiException ? ((ApiException) exc).getStatusCode() : 13;
                zzanVar = zzbhVar.zza.zzd;
                zzanVar.zzN(j2, statusCode);
            }
        });
    }
}
