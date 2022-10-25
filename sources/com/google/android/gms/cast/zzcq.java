package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzcq extends zzdg {
    final /* synthetic */ int zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcq(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = i;
        this.zzb = jSONObject;
    }

    @Override // com.google.android.gms.cast.zzdg
    protected final void zza(com.google.android.gms.cast.internal.zzw zzwVar) throws com.google.android.gms.cast.internal.zzal {
        com.google.android.gms.cast.internal.zzan zzanVar;
        zzanVar = this.zzc.zzb;
        zzanVar.zzE(zzb(), 0, -1L, null, 0, false, Integer.valueOf(this.zza), this.zzb);
    }
}
