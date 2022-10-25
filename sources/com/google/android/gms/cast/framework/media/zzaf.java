package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.TextTrackStyle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzaf extends zzbm {
    final /* synthetic */ TextTrackStyle zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaf(RemoteMediaClient remoteMediaClient, TextTrackStyle textTrackStyle) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = textTrackStyle;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbm
    protected final void zza() throws com.google.android.gms.cast.internal.zzal {
        com.google.android.gms.cast.internal.zzan zzanVar;
        zzanVar = this.zzb.zzd;
        zzanVar.zzu(zzb(), this.zza);
    }
}
