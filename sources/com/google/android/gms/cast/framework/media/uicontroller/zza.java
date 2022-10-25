package com.google.android.gms.cast.framework.media.uicontroller;

import android.text.format.DateUtils;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.text.DateFormat;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zza {
    RemoteMediaClient zza;

    private zza() {
    }

    public static zza zza() {
        return new zza();
    }

    private final MediaMetadata zzo() {
        MediaInfo mediaInfo;
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || (mediaInfo = this.zza.getMediaInfo()) == null) {
            return null;
        }
        return mediaInfo.getMetadata();
    }

    private static final String zzp(long j) {
        if (j >= 0) {
            return DateUtils.formatElapsedTime(j / 1000);
        }
        String valueOf = String.valueOf(DateUtils.formatElapsedTime((-j) / 1000));
        return valueOf.length() != 0 ? "-".concat(valueOf) : new String("-");
    }

    public final int zzb() {
        MediaInfo media;
        RemoteMediaClient remoteMediaClient = this.zza;
        long j = 1;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            RemoteMediaClient remoteMediaClient2 = this.zza;
            if (!remoteMediaClient2.isLiveStream()) {
                if (remoteMediaClient2.isLoadingNextItem()) {
                    MediaQueueItem loadingItem = remoteMediaClient2.getLoadingItem();
                    if (loadingItem != null && (media = loadingItem.getMedia()) != null) {
                        j = Math.max(media.getStreamDuration(), 1L);
                    }
                } else {
                    j = Math.max(remoteMediaClient2.getStreamDuration(), 1L);
                }
            } else {
                Long zzj = zzj();
                if (zzj != null) {
                    j = zzj.longValue();
                } else {
                    Long zzl = zzl();
                    if (zzl != null) {
                        j = zzl.longValue();
                    } else {
                        j = Math.max(remoteMediaClient2.getApproximateStreamPosition(), 1L);
                    }
                }
            }
        }
        return Math.max((int) (j - zzh()), 1);
    }

    public final int zzc() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return 0;
        }
        RemoteMediaClient remoteMediaClient2 = this.zza;
        if (remoteMediaClient2.isLiveStream() || !remoteMediaClient2.isLoadingNextItem()) {
            int approximateStreamPosition = (int) (remoteMediaClient2.getApproximateStreamPosition() - zzh());
            if (remoteMediaClient2.zzh()) {
                approximateStreamPosition = CastUtils.zzc(approximateStreamPosition, zzf(), zzg());
            }
            return CastUtils.zzc(approximateStreamPosition, 0, zzb());
        }
        return 0;
    }

    public final boolean zzd(long j) {
        RemoteMediaClient remoteMediaClient = this.zza;
        return remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.zza.zzh() && (((long) zzg()) + zzh()) - j < 10000;
    }

    public final boolean zze() {
        return zzd(zzc() + zzh());
    }

    public final int zzf() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.zza.isLiveStream() && this.zza.zzh()) {
            return CastUtils.zzc((int) (((Long) Preconditions.checkNotNull(zzk())).longValue() - zzh()), 0, zzb());
        }
        return 0;
    }

    public final int zzg() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream()) {
            return zzb();
        }
        if (this.zza.zzh()) {
            return CastUtils.zzc((int) (((Long) Preconditions.checkNotNull(zzl())).longValue() - zzh()), 0, zzb());
        }
        return 0;
    }

    public final long zzh() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.zza.isLiveStream()) {
            RemoteMediaClient remoteMediaClient2 = this.zza;
            Long zzi = zzi();
            if (zzi != null) {
                return zzi.longValue();
            }
            Long zzk = zzk();
            if (zzk != null) {
                return zzk.longValue();
            }
            return remoteMediaClient2.getApproximateStreamPosition();
        }
        return 0L;
    }

    public final Long zzi() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.zza.isLiveStream()) {
            RemoteMediaClient remoteMediaClient2 = this.zza;
            MediaInfo mediaInfo = remoteMediaClient2.getMediaInfo();
            MediaMetadata zzo = zzo();
            if (mediaInfo != null && zzo != null && zzo.containsKey(MediaMetadata.KEY_SECTION_START_TIME_IN_MEDIA) && (zzo.containsKey(MediaMetadata.KEY_SECTION_DURATION) || remoteMediaClient2.zzh())) {
                return Long.valueOf(zzo.getTimeMillis(MediaMetadata.KEY_SECTION_START_TIME_IN_MEDIA));
            }
        }
        return null;
    }

    public final Long zzj() {
        MediaMetadata zzo;
        Long zzi;
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream() || (zzo = zzo()) == null || !zzo.containsKey(MediaMetadata.KEY_SECTION_DURATION) || (zzi = zzi()) == null) {
            return null;
        }
        return Long.valueOf(zzi.longValue() + zzo.getTimeMillis(MediaMetadata.KEY_SECTION_DURATION));
    }

    final Long zzk() {
        RemoteMediaClient remoteMediaClient;
        MediaStatus mediaStatus;
        RemoteMediaClient remoteMediaClient2 = this.zza;
        if (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !this.zza.isLiveStream() || !this.zza.zzh() || (mediaStatus = (remoteMediaClient = this.zza).getMediaStatus()) == null || mediaStatus.getLiveSeekableRange() == null) {
            return null;
        }
        return Long.valueOf(remoteMediaClient.getApproximateLiveSeekableRangeStart());
    }

    final Long zzl() {
        RemoteMediaClient remoteMediaClient;
        MediaStatus mediaStatus;
        RemoteMediaClient remoteMediaClient2 = this.zza;
        if (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !this.zza.isLiveStream() || !this.zza.zzh() || (mediaStatus = (remoteMediaClient = this.zza).getMediaStatus()) == null || mediaStatus.getLiveSeekableRange() == null) {
            return null;
        }
        return Long.valueOf(remoteMediaClient.getApproximateLiveSeekableRangeEnd());
    }

    public final String zzm(long j) {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return null;
        }
        RemoteMediaClient remoteMediaClient2 = this.zza;
        if (((remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !this.zza.isLiveStream() || zzn() == null) ? 1 : 2) - 1 != 1) {
            if (!remoteMediaClient2.isLiveStream() || zzi() != null) {
                return zzp(j - zzh());
            }
            return zzp(j);
        }
        return DateFormat.getTimeInstance().format(new Date(((Long) Preconditions.checkNotNull(zzn())).longValue() + j));
    }

    final Long zzn() {
        MediaInfo mediaInfo;
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream() || (mediaInfo = this.zza.getMediaInfo()) == null || mediaInfo.getStartAbsoluteTime() == -1) {
            return null;
        }
        return Long.valueOf(mediaInfo.getStartAbsoluteTime());
    }
}
