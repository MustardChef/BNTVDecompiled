package com.google.android.gms.cast;

import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzdh implements RemoteMediaPlayer.MediaChannelResult {
    private final Status zza;
    private final JSONObject zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdh(Status status, JSONObject jSONObject) {
        this.zza = status;
        this.zzb = jSONObject;
    }

    @Override // com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult
    public final JSONObject getCustomData() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
