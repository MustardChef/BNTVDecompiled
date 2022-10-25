package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbq {
    final /* synthetic */ RemoteMediaClient zza;
    private final Set<RemoteMediaClient.ProgressListener> zzb = new HashSet();
    private final long zzc;
    private final Runnable zzd;
    private boolean zze;

    public zzbq(RemoteMediaClient remoteMediaClient, long j) {
        this.zza = remoteMediaClient;
        this.zzc = j;
        this.zzd = new zzbp(this, remoteMediaClient);
    }

    public final long zza() {
        return this.zzc;
    }

    public final void zzb(RemoteMediaClient.ProgressListener progressListener) {
        this.zzb.add(progressListener);
    }

    public final void zzc(RemoteMediaClient.ProgressListener progressListener) {
        this.zzb.remove(progressListener);
    }

    public final boolean zzd() {
        return !this.zzb.isEmpty();
    }

    public final void zze() {
        RemoteMediaClient.zzp(this.zza).removeCallbacks(this.zzd);
        this.zze = true;
        RemoteMediaClient.zzp(this.zza).postDelayed(this.zzd, this.zzc);
    }

    public final void zzf() {
        RemoteMediaClient.zzp(this.zza).removeCallbacks(this.zzd);
        this.zze = false;
    }

    public final boolean zzg() {
        return this.zze;
    }
}
