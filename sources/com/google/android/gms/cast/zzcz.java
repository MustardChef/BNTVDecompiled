package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzcz extends zzdg {
    final /* synthetic */ double zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcz(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, double d, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = d;
        this.zzb = jSONObject;
    }

    @Override // com.google.android.gms.cast.zzdg
    protected final void zza(com.google.android.gms.cast.internal.zzw zzwVar) throws com.google.android.gms.cast.internal.zzal {
        com.google.android.gms.cast.internal.zzan zzanVar;
        zzanVar = this.zzc.zzb;
        zzanVar.zzp(zzb(), this.zza, this.zzb);
    }
}
