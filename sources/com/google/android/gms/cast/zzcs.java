package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzcs extends zzdg {
    final /* synthetic */ int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcs(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, long j, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = i;
        this.zzb = j;
        this.zzc = jSONObject;
    }

    @Override // com.google.android.gms.cast.zzdg
    protected final void zza(com.google.android.gms.cast.internal.zzw zzwVar) throws com.google.android.gms.cast.internal.zzal {
        com.google.android.gms.cast.internal.zzan zzanVar;
        if (RemoteMediaPlayer.zzg(this.zzd, this.zza) == -1) {
            setResult((zzcs) new zzdf(this, new Status(0)));
            return;
        }
        zzanVar = this.zzd.zzb;
        zzanVar.zzE(zzb(), this.zza, this.zzb, null, 0, false, null, this.zzc);
    }
}
