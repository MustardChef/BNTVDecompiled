package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbo implements com.google.android.gms.cast.internal.zzak {
    final /* synthetic */ RemoteMediaClient zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbo(RemoteMediaClient remoteMediaClient, zzam zzamVar) {
        this.zza = remoteMediaClient;
    }

    private final void zzl() {
        RemoteMediaClient.ParseAdsInfoCallback parseAdsInfoCallback;
        MediaStatus mediaStatus;
        RemoteMediaClient.ParseAdsInfoCallback parseAdsInfoCallback2;
        RemoteMediaClient.ParseAdsInfoCallback parseAdsInfoCallback3;
        parseAdsInfoCallback = this.zza.zzk;
        if (parseAdsInfoCallback == null || (mediaStatus = this.zza.getMediaStatus()) == null) {
            return;
        }
        MediaStatus.Writer writer = mediaStatus.getWriter();
        parseAdsInfoCallback2 = this.zza.zzk;
        writer.setIsPlayingAd(parseAdsInfoCallback2.parseIsPlayingAdFromMediaStatus(mediaStatus));
        parseAdsInfoCallback3 = this.zza.zzk;
        List<AdBreakInfo> parseAdBreaksFromMediaStatus = parseAdsInfoCallback3.parseAdBreaksFromMediaStatus(mediaStatus);
        MediaInfo mediaInfo = this.zza.getMediaInfo();
        if (mediaInfo != null) {
            mediaInfo.getWriter().setAdBreaks(parseAdBreaksFromMediaStatus);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzak
    public final void zza() {
        List<RemoteMediaClient.Listener> list;
        zzl();
        RemoteMediaClient.zzj(this.zza);
        list = this.zza.zzh;
        for (RemoteMediaClient.Listener listener : list) {
            listener.onStatusUpdated();
        }
        for (RemoteMediaClient.Callback callback : this.zza.zza) {
            callback.onStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzak
    public final void zzb() {
        List<RemoteMediaClient.Listener> list;
        zzl();
        list = this.zza.zzh;
        for (RemoteMediaClient.Listener listener : list) {
            listener.onMetadataUpdated();
        }
        for (RemoteMediaClient.Callback callback : this.zza.zza) {
            callback.onMetadataUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzak
    public final void zzc() {
        List<RemoteMediaClient.Listener> list;
        list = this.zza.zzh;
        for (RemoteMediaClient.Listener listener : list) {
            listener.onQueueStatusUpdated();
        }
        for (RemoteMediaClient.Callback callback : this.zza.zza) {
            callback.onQueueStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzak
    public final void zzd() {
        List<RemoteMediaClient.Listener> list;
        list = this.zza.zzh;
        for (RemoteMediaClient.Listener listener : list) {
            listener.onPreloadStatusUpdated();
        }
        for (RemoteMediaClient.Callback callback : this.zza.zza) {
            callback.onPreloadStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzak
    public final void zze() {
        List<RemoteMediaClient.Listener> list;
        list = this.zza.zzh;
        for (RemoteMediaClient.Listener listener : list) {
            listener.onAdBreakStatusUpdated();
        }
        for (RemoteMediaClient.Callback callback : this.zza.zza) {
            callback.onAdBreakStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzak
    public final void zzf(MediaError mediaError) {
        for (RemoteMediaClient.Callback callback : this.zza.zza) {
            callback.onMediaError(mediaError);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzak
    public final void zzg(int[] iArr) {
        for (RemoteMediaClient.Callback callback : this.zza.zza) {
            callback.zza(iArr);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzak
    public final void zzh(int[] iArr, int i) {
        for (RemoteMediaClient.Callback callback : this.zza.zza) {
            callback.zzb(iArr, i);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzak
    public final void zzi(int[] iArr) {
        for (RemoteMediaClient.Callback callback : this.zza.zza) {
            callback.zzc(iArr);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzak
    public final void zzj(int[] iArr) {
        for (RemoteMediaClient.Callback callback : this.zza.zza) {
            callback.zzd(iArr);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzak
    public final void zzk(MediaQueueItem[] mediaQueueItemArr) {
        for (RemoteMediaClient.Callback callback : this.zza.zza) {
            callback.zze(mediaQueueItemArr);
        }
    }
}
