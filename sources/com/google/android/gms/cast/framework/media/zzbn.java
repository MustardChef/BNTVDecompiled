package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzbn implements RemoteMediaClient.MediaChannelResult {
    private final Status zza;
    private final JSONObject zzb;
    private final MediaError zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbn(Status status, JSONObject jSONObject, MediaError mediaError) {
        this.zza = status;
        this.zzb = jSONObject;
        this.zzc = mediaError;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.MediaChannelResult
    public final JSONObject getCustomData() {
        return this.zzb;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.MediaChannelResult
    public final MediaError getMediaError() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
