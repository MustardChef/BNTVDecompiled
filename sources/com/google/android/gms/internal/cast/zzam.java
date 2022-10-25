package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzam extends UIController implements RemoteMediaClient.ProgressListener {
    private final CastSeekBar zza;
    private final long zzb;
    private final com.google.android.gms.cast.framework.media.uicontroller.zza zzc;

    public zzam(CastSeekBar castSeekBar, long j, com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar) {
        this.zza = castSeekBar;
        this.zzb = j;
        this.zzc = zzaVar;
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final RemoteMediaClient getRemoteMediaClient() {
        return super.getRemoteMediaClient();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener
    public final void onProgressUpdated(long j, long j2) {
        zzc();
        zzb();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        if (super.getRemoteMediaClient() != null) {
            super.getRemoteMediaClient().addProgressListener(this, this.zzb);
        }
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        if (super.getRemoteMediaClient() != null) {
            super.getRemoteMediaClient().removeProgressListener(this);
        }
        super.onSessionEnded();
        zza();
    }

    final void zza() {
        int min;
        zzc();
        ArrayList arrayList = null;
        if (super.getRemoteMediaClient() != null) {
            MediaInfo mediaInfo = super.getRemoteMediaClient().getMediaInfo();
            if (!super.getRemoteMediaClient().hasMediaSession() || super.getRemoteMediaClient().isLoadingNextItem() || mediaInfo == null) {
                this.zza.zza(null);
            } else {
                CastSeekBar castSeekBar = this.zza;
                List<AdBreakInfo> adBreaks = mediaInfo.getAdBreaks();
                if (adBreaks != null) {
                    arrayList = new ArrayList();
                    for (AdBreakInfo adBreakInfo : adBreaks) {
                        if (adBreakInfo != null) {
                            long playbackPositionInMs = adBreakInfo.getPlaybackPositionInMs();
                            if (playbackPositionInMs == -1000) {
                                min = this.zzc.zzb();
                            } else {
                                min = Math.min((int) (playbackPositionInMs - this.zzc.zzh()), this.zzc.zzb());
                            }
                            if (min >= 0) {
                                arrayList.add(new com.google.android.gms.cast.framework.media.widget.zzc(min, (int) adBreakInfo.getDurationInMs(), adBreakInfo.isExpanded()));
                            }
                        }
                    }
                }
                castSeekBar.zza(arrayList);
            }
        } else {
            this.zza.zza(null);
        }
        zzb();
    }

    final void zzb() {
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.isPlayingAd()) {
            CastSeekBar castSeekBar = this.zza;
            castSeekBar.zzb = null;
            castSeekBar.postInvalidate();
            return;
        }
        int approximateAdBreakClipPositionMs = (int) remoteMediaClient.getApproximateAdBreakClipPositionMs();
        MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
        AdBreakClipInfo currentAdBreakClip = mediaStatus != null ? mediaStatus.getCurrentAdBreakClip() : null;
        int durationInMs = currentAdBreakClip != null ? (int) currentAdBreakClip.getDurationInMs() : approximateAdBreakClipPositionMs;
        if (approximateAdBreakClipPositionMs < 0) {
            approximateAdBreakClipPositionMs = 0;
        }
        if (durationInMs < 0) {
            durationInMs = 1;
        }
        if (approximateAdBreakClipPositionMs > durationInMs) {
            durationInMs = approximateAdBreakClipPositionMs;
        }
        CastSeekBar castSeekBar2 = this.zza;
        castSeekBar2.zzb = new com.google.android.gms.cast.framework.media.widget.zzd(approximateAdBreakClipPositionMs, durationInMs);
        castSeekBar2.postInvalidate();
    }

    final void zzc() {
        int zzc;
        int zzc2;
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        boolean z = true;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || remoteMediaClient.isPlayingAd()) {
            this.zza.setEnabled(false);
        } else {
            this.zza.setEnabled(true);
        }
        com.google.android.gms.cast.framework.media.widget.zzf zzfVar = new com.google.android.gms.cast.framework.media.widget.zzf();
        zzfVar.zza = this.zzc.zzc();
        zzfVar.zzb = this.zzc.zzb();
        zzfVar.zzc = (int) (-this.zzc.zzh());
        RemoteMediaClient remoteMediaClient2 = super.getRemoteMediaClient();
        if (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !remoteMediaClient2.zzh()) {
            zzc = this.zzc.zzc();
        } else {
            zzc = this.zzc.zzf();
        }
        zzfVar.zzd = zzc;
        RemoteMediaClient remoteMediaClient3 = super.getRemoteMediaClient();
        if (remoteMediaClient3 == null || !remoteMediaClient3.hasMediaSession() || !remoteMediaClient3.zzh()) {
            zzc2 = this.zzc.zzc();
        } else {
            zzc2 = this.zzc.zzg();
        }
        zzfVar.zze = zzc2;
        RemoteMediaClient remoteMediaClient4 = super.getRemoteMediaClient();
        zzfVar.zzf = (remoteMediaClient4 != null && remoteMediaClient4.hasMediaSession() && remoteMediaClient4.zzh()) ? false : false;
        this.zza.zzb(zzfVar);
    }
}
