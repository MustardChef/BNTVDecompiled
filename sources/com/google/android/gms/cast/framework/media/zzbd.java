package com.google.android.gms.cast.framework.media;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbd extends zzbm {
    final /* synthetic */ double zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbd(RemoteMediaClient remoteMediaClient, double d, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = d;
        this.zzb = jSONObject;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbm
    protected final void zza() throws com.google.android.gms.cast.internal.zzal {
        com.google.android.gms.cast.internal.zzan zzanVar;
        zzanVar = this.zzc.zzd;
        zzanVar.zzp(zzb(), this.zza, this.zzb);
    }
}
