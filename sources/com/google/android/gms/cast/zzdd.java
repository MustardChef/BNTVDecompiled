package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzdd implements com.google.android.gms.cast.internal.zzao {
    final /* synthetic */ RemoteMediaPlayer zza;
    private GoogleApiClient zzb;
    private long zzc = 0;

    public zzdd(RemoteMediaPlayer remoteMediaPlayer) {
        this.zza = remoteMediaPlayer;
    }

    public final void zza(GoogleApiClient googleApiClient) {
        this.zzb = googleApiClient;
    }

    @Override // com.google.android.gms.cast.internal.zzao
    public final long zzc() {
        long j = this.zzc + 1;
        this.zzc = j;
        return j;
    }

    @Override // com.google.android.gms.cast.internal.zzao
    public final void zzb(String str, String str2, long j, String str3) {
        if (this.zzb == null) {
            throw new IllegalStateException("No GoogleApiClient available");
        }
        Cast.CastApi.sendMessage(this.zzb, str, str2).setResultCallback(new zzdc(this, j));
    }
}
