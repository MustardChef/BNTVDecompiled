package com.lagradost.cloudstream3.p041ui.player;

import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.TracksInfo;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CS3IPlayer.kt */
@Metadata(m108d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, m107d2 = {"com/lagradost/cloudstream3/ui/player/CS3IPlayer$loadExo$3", "Lcom/google/android/exoplayer2/Player$Listener;", "onIsPlayingChanged", "", "isPlaying", "", "onPlaybackStateChanged", "playbackState", "", "onPlayerError", "error", "Lcom/google/android/exoplayer2/PlaybackException;", "onPlayerStateChanged", "playWhenReady", "onRenderedFirstFrame", "onTracksInfoChanged", "tracksInfo", "Lcom/google/android/exoplayer2/TracksInfo;", "onVideoSizeChanged", "videoSize", "Lcom/google/android/exoplayer2/video/VideoSize;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.CS3IPlayer$loadExo$3 */
/* loaded from: classes3.dex */
public final class CS3IPlayer$loadExo$3 implements Player.Listener {
    final /* synthetic */ CS3IPlayer this$0;

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        Player.Listener.CC.$default$onAudioAttributesChanged(this, audioAttributes);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onAudioSessionIdChanged(int i) {
        Player.Listener.CC.$default$onAudioSessionIdChanged(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
        Player.Listener.CC.$default$onAvailableCommandsChanged(this, commands);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onCues(List list) {
        Player.Listener.CC.$default$onCues(this, list);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        Player.Listener.CC.$default$onDeviceInfoChanged(this, deviceInfo);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
        Player.Listener.CC.$default$onDeviceVolumeChanged(this, i, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onEvents(Player player, Player.Events events) {
        Player.Listener.CC.$default$onEvents(this, player, events);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onIsLoadingChanged(boolean z) {
        Player.Listener.CC.$default$onIsLoadingChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onLoadingChanged(boolean z) {
        Player.EventListener.CC.$default$onLoadingChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
        Player.EventListener.CC.$default$onMaxSeekToPreviousPositionChanged(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
        Player.Listener.CC.$default$onMediaItemTransition(this, mediaItem, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        Player.Listener.CC.$default$onMediaMetadataChanged(this, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
        Player.Listener.CC.$default$onMetadata(this, metadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
        Player.Listener.CC.$default$onPlayWhenReadyChanged(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        Player.Listener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        Player.Listener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
        Player.Listener.CC.$default$onPlayerErrorChanged(this, playbackException);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        Player.Listener.CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPositionDiscontinuity(int i) {
        Player.EventListener.CC.$default$onPositionDiscontinuity(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        Player.Listener.CC.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onRepeatModeChanged(int i) {
        Player.Listener.CC.$default$onRepeatModeChanged(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onSeekBackIncrementChanged(long j) {
        Player.Listener.CC.$default$onSeekBackIncrementChanged(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
        Player.Listener.CC.$default$onSeekForwardIncrementChanged(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onSeekProcessed() {
        Player.EventListener.CC.$default$onSeekProcessed(this);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
        Player.Listener.CC.$default$onShuffleModeEnabledChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
        Player.Listener.CC.$default$onSkipSilenceEnabledChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
        Player.Listener.CC.$default$onSurfaceSizeChanged(this, i, i2);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
        Player.Listener.CC.$default$onTimelineChanged(this, timeline, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        Player.EventListener.CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onVolumeChanged(float f) {
        Player.Listener.CC.$default$onVolumeChanged(this, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CS3IPlayer$loadExo$3(CS3IPlayer cS3IPlayer) {
        this.this$0 = cS3IPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onTracksInfoChanged$isSubtitle(Format format) {
        String str = format.sampleMimeType;
        if ((str == null || StringsKt.contains$default((CharSequence) str, (CharSequence) "video/", false, 2, (Object) null)) ? false : true) {
            String str2 = format.sampleMimeType;
            if ((str2 == null || StringsKt.contains$default((CharSequence) str2, (CharSequence) "audio/", false, 2, (Object) null)) ? false : true) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onTracksInfoChanged(TracksInfo tracksInfo) {
        Intrinsics.checkNotNullParameter(tracksInfo, "tracksInfo");
        ArchComponentExt.normalSafeApiCall(new CS3IPlayer$loadExo$3$onTracksInfoChanged$1(this.this$0, tracksInfo));
        Player.Listener.CC.$default$onTracksInfoChanged(this, tracksInfo);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        ExoPlayer exoPlayer;
        Functions functions;
        Function1 function1;
        boolean z2;
        CSPlayerLoading cSPlayerLoading;
        exoPlayer = this.this$0.exoPlayer;
        if (exoPlayer != null) {
            CS3IPlayer cS3IPlayer = this.this$0;
            function1 = cS3IPlayer.updateIsPlaying;
            if (function1 != null) {
                z2 = cS3IPlayer.isPlaying;
                CSPlayerLoading cSPlayerLoading2 = z2 ? CSPlayerLoading.IsPlaying : CSPlayerLoading.IsPaused;
                if (i == 2) {
                    cSPlayerLoading = CSPlayerLoading.IsBuffering;
                } else {
                    cSPlayerLoading = exoPlayer.isPlaying() ? CSPlayerLoading.IsPlaying : CSPlayerLoading.IsPaused;
                }
                function1.invoke(new Tuples(cSPlayerLoading2, cSPlayerLoading));
            }
            cS3IPlayer.isPlaying = exoPlayer.isPlaying();
        }
        if (i == 3) {
            this.this$0.onRenderFirst();
        }
        if (z) {
            if (i == 2) {
                this.this$0.updatedTime();
            } else if (i != 3) {
                if (i != 4) {
                    return;
                }
                this.this$0.handleEvent(CSPlayerEvent.NextEpisode);
            } else {
                functions = this.this$0.requestAutoFocus;
                if (functions != null) {
                    functions.invoke();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(PlaybackException error) {
        Function1 function1;
        ExoPlayer exoPlayer;
        ExoPlayer exoPlayer2;
        Intrinsics.checkNotNullParameter(error, "error");
        if (error.errorCode == 1002) {
            exoPlayer = this.this$0.exoPlayer;
            if (exoPlayer != null) {
                exoPlayer.seekToDefaultPosition();
            }
            exoPlayer2 = this.this$0.exoPlayer;
            if (exoPlayer2 != null) {
                exoPlayer2.prepare();
                return;
            }
            return;
        }
        function1 = this.this$0.playerError;
        if (function1 != null) {
            function1.invoke(error);
        }
        error.printStackTrace();
        Player.Listener.CC.$default$onPlayerError(this, error);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onIsPlayingChanged(boolean z) {
        Player.Listener.CC.$default$onIsPlayingChanged(this, z);
        if (z) {
            this.this$0.onRenderFirst();
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackStateChanged(int i) {
        Functions functions;
        Player.Listener.CC.$default$onPlaybackStateChanged(this, i);
        if (i == 2) {
            this.this$0.updatedTime();
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            this.this$0.handleEvent(CSPlayerEvent.NextEpisode);
        } else {
            functions = this.this$0.requestAutoFocus;
            if (functions != null) {
                functions.invoke();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onVideoSizeChanged(VideoSize videoSize) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        Player.Listener.CC.$default$onVideoSizeChanged(this, videoSize);
        function1 = this.this$0.playerDimensionsLoaded;
        if (function1 != null) {
            function1.invoke(new Tuples(Integer.valueOf(videoSize.width), Integer.valueOf(videoSize.height)));
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onRenderedFirstFrame() {
        this.this$0.updatedTime();
        Player.Listener.CC.$default$onRenderedFirstFrame(this);
        this.this$0.onRenderFirst();
    }
}
