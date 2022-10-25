package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.base.Objects;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public interface Player {
    public static final int COMMAND_ADJUST_DEVICE_VOLUME = 26;
    public static final int COMMAND_CHANGE_MEDIA_ITEMS = 20;
    public static final int COMMAND_GET_AUDIO_ATTRIBUTES = 21;
    public static final int COMMAND_GET_CURRENT_MEDIA_ITEM = 16;
    public static final int COMMAND_GET_DEVICE_VOLUME = 23;
    public static final int COMMAND_GET_MEDIA_ITEMS_METADATA = 18;
    public static final int COMMAND_GET_TEXT = 28;
    public static final int COMMAND_GET_TIMELINE = 17;
    public static final int COMMAND_GET_TRACK_INFOS = 30;
    public static final int COMMAND_GET_VOLUME = 22;
    public static final int COMMAND_INVALID = -1;
    public static final int COMMAND_PLAY_PAUSE = 1;
    public static final int COMMAND_PREPARE = 2;
    public static final int COMMAND_SEEK_BACK = 11;
    public static final int COMMAND_SEEK_FORWARD = 12;
    public static final int COMMAND_SEEK_IN_CURRENT_MEDIA_ITEM = 5;
    @Deprecated
    public static final int COMMAND_SEEK_IN_CURRENT_WINDOW = 5;
    public static final int COMMAND_SEEK_TO_DEFAULT_POSITION = 4;
    public static final int COMMAND_SEEK_TO_MEDIA_ITEM = 10;
    public static final int COMMAND_SEEK_TO_NEXT = 9;
    public static final int COMMAND_SEEK_TO_NEXT_MEDIA_ITEM = 8;
    @Deprecated
    public static final int COMMAND_SEEK_TO_NEXT_WINDOW = 8;
    public static final int COMMAND_SEEK_TO_PREVIOUS = 7;
    public static final int COMMAND_SEEK_TO_PREVIOUS_MEDIA_ITEM = 6;
    @Deprecated
    public static final int COMMAND_SEEK_TO_PREVIOUS_WINDOW = 6;
    @Deprecated
    public static final int COMMAND_SEEK_TO_WINDOW = 10;
    public static final int COMMAND_SET_DEVICE_VOLUME = 25;
    public static final int COMMAND_SET_MEDIA_ITEMS_METADATA = 19;
    public static final int COMMAND_SET_REPEAT_MODE = 15;
    public static final int COMMAND_SET_SHUFFLE_MODE = 14;
    public static final int COMMAND_SET_SPEED_AND_PITCH = 13;
    public static final int COMMAND_SET_TRACK_SELECTION_PARAMETERS = 29;
    public static final int COMMAND_SET_VIDEO_SURFACE = 27;
    public static final int COMMAND_SET_VOLUME = 24;
    public static final int COMMAND_STOP = 3;
    public static final int DISCONTINUITY_REASON_AUTO_TRANSITION = 0;
    public static final int DISCONTINUITY_REASON_INTERNAL = 5;
    public static final int DISCONTINUITY_REASON_REMOVE = 4;
    public static final int DISCONTINUITY_REASON_SEEK = 1;
    public static final int DISCONTINUITY_REASON_SEEK_ADJUSTMENT = 2;
    public static final int DISCONTINUITY_REASON_SKIP = 3;
    public static final int EVENT_AVAILABLE_COMMANDS_CHANGED = 13;
    public static final int EVENT_IS_LOADING_CHANGED = 3;
    public static final int EVENT_IS_PLAYING_CHANGED = 7;
    public static final int EVENT_MAX_SEEK_TO_PREVIOUS_POSITION_CHANGED = 18;
    public static final int EVENT_MEDIA_ITEM_TRANSITION = 1;
    public static final int EVENT_MEDIA_METADATA_CHANGED = 14;
    public static final int EVENT_PLAYBACK_PARAMETERS_CHANGED = 12;
    public static final int EVENT_PLAYBACK_STATE_CHANGED = 4;
    public static final int EVENT_PLAYBACK_SUPPRESSION_REASON_CHANGED = 6;
    public static final int EVENT_PLAYER_ERROR = 10;
    public static final int EVENT_PLAYLIST_METADATA_CHANGED = 15;
    public static final int EVENT_PLAY_WHEN_READY_CHANGED = 5;
    public static final int EVENT_POSITION_DISCONTINUITY = 11;
    public static final int EVENT_REPEAT_MODE_CHANGED = 8;
    public static final int EVENT_SEEK_BACK_INCREMENT_CHANGED = 16;
    public static final int EVENT_SEEK_FORWARD_INCREMENT_CHANGED = 17;
    public static final int EVENT_SHUFFLE_MODE_ENABLED_CHANGED = 9;
    public static final int EVENT_TIMELINE_CHANGED = 0;
    public static final int EVENT_TRACKS_CHANGED = 2;
    public static final int EVENT_TRACK_SELECTION_PARAMETERS_CHANGED = 19;
    public static final int MEDIA_ITEM_TRANSITION_REASON_AUTO = 1;
    public static final int MEDIA_ITEM_TRANSITION_REASON_PLAYLIST_CHANGED = 3;
    public static final int MEDIA_ITEM_TRANSITION_REASON_REPEAT = 0;
    public static final int MEDIA_ITEM_TRANSITION_REASON_SEEK = 2;
    public static final int PLAYBACK_SUPPRESSION_REASON_NONE = 0;
    public static final int PLAYBACK_SUPPRESSION_REASON_TRANSIENT_AUDIO_FOCUS_LOSS = 1;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_AUDIO_BECOMING_NOISY = 3;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_AUDIO_FOCUS_LOSS = 2;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_END_OF_MEDIA_ITEM = 5;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_REMOTE = 4;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_USER_REQUEST = 1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_OFF = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;
    public static final int TIMELINE_CHANGE_REASON_PLAYLIST_CHANGED = 0;
    public static final int TIMELINE_CHANGE_REASON_SOURCE_UPDATE = 1;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Command {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface DiscontinuityReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Event {
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface EventListener {

        /* renamed from: com.google.android.exoplayer2.Player$EventListener$-CC  reason: invalid class name */
        /* loaded from: classes2.dex */
        public final /* synthetic */ class CC {
            public static void $default$onAvailableCommandsChanged(EventListener eventListener, Commands commands) {
            }

            public static void $default$onEvents(EventListener eventListener, Player player, Events events) {
            }

            public static void $default$onIsLoadingChanged(EventListener eventListener, boolean z) {
            }

            public static void $default$onIsPlayingChanged(EventListener eventListener, boolean z) {
            }

            @Deprecated
            public static void $default$onLoadingChanged(EventListener eventListener, boolean z) {
            }

            public static void $default$onMaxSeekToPreviousPositionChanged(EventListener eventListener, long j) {
            }

            public static void $default$onMediaItemTransition(EventListener eventListener, MediaItem mediaItem, int i) {
            }

            public static void $default$onMediaMetadataChanged(EventListener eventListener, MediaMetadata mediaMetadata) {
            }

            public static void $default$onPlayWhenReadyChanged(EventListener eventListener, boolean z, int i) {
            }

            public static void $default$onPlaybackParametersChanged(EventListener eventListener, PlaybackParameters playbackParameters) {
            }

            public static void $default$onPlaybackStateChanged(EventListener eventListener, int i) {
            }

            public static void $default$onPlaybackSuppressionReasonChanged(EventListener eventListener, int i) {
            }

            public static void $default$onPlayerError(EventListener eventListener, PlaybackException playbackException) {
            }

            public static void $default$onPlayerErrorChanged(EventListener eventListener, PlaybackException playbackException) {
            }

            @Deprecated
            public static void $default$onPlayerStateChanged(EventListener eventListener, boolean z, int i) {
            }

            public static void $default$onPlaylistMetadataChanged(EventListener eventListener, MediaMetadata mediaMetadata) {
            }

            @Deprecated
            public static void $default$onPositionDiscontinuity(EventListener eventListener, int i) {
            }

            public static void $default$onPositionDiscontinuity(EventListener eventListener, PositionInfo positionInfo, PositionInfo positionInfo2, int i) {
            }

            public static void $default$onRepeatModeChanged(EventListener eventListener, int i) {
            }

            public static void $default$onSeekBackIncrementChanged(EventListener eventListener, long j) {
            }

            public static void $default$onSeekForwardIncrementChanged(EventListener eventListener, long j) {
            }

            @Deprecated
            public static void $default$onSeekProcessed(EventListener eventListener) {
            }

            public static void $default$onShuffleModeEnabledChanged(EventListener eventListener, boolean z) {
            }

            public static void $default$onTimelineChanged(EventListener eventListener, Timeline timeline, int i) {
            }

            public static void $default$onTrackSelectionParametersChanged(EventListener eventListener, TrackSelectionParameters trackSelectionParameters) {
            }

            @Deprecated
            public static void $default$onTracksChanged(EventListener eventListener, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }

            public static void $default$onTracksInfoChanged(EventListener eventListener, TracksInfo tracksInfo) {
            }
        }

        void onAvailableCommandsChanged(Commands commands);

        void onEvents(Player player, Events events);

        void onIsLoadingChanged(boolean z);

        void onIsPlayingChanged(boolean z);

        @Deprecated
        void onLoadingChanged(boolean z);

        void onMaxSeekToPreviousPositionChanged(long j);

        void onMediaItemTransition(MediaItem mediaItem, int i);

        void onMediaMetadataChanged(MediaMetadata mediaMetadata);

        void onPlayWhenReadyChanged(boolean z, int i);

        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);

        void onPlaybackStateChanged(int i);

        void onPlaybackSuppressionReasonChanged(int i);

        void onPlayerError(PlaybackException playbackException);

        void onPlayerErrorChanged(PlaybackException playbackException);

        @Deprecated
        void onPlayerStateChanged(boolean z, int i);

        void onPlaylistMetadataChanged(MediaMetadata mediaMetadata);

        @Deprecated
        void onPositionDiscontinuity(int i);

        void onPositionDiscontinuity(PositionInfo positionInfo, PositionInfo positionInfo2, int i);

        void onRepeatModeChanged(int i);

        void onSeekBackIncrementChanged(long j);

        void onSeekForwardIncrementChanged(long j);

        @Deprecated
        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z);

        void onTimelineChanged(Timeline timeline, int i);

        void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters);

        @Deprecated
        void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);

        void onTracksInfoChanged(TracksInfo tracksInfo);
    }

    /* loaded from: classes2.dex */
    public interface Listener extends EventListener {

        /* renamed from: com.google.android.exoplayer2.Player$Listener$-CC  reason: invalid class name */
        /* loaded from: classes2.dex */
        public final /* synthetic */ class CC {
            public static void $default$onAudioAttributesChanged(Listener listener, AudioAttributes audioAttributes) {
            }

            public static void $default$onAudioSessionIdChanged(Listener listener, int i) {
            }

            public static void $default$onAvailableCommandsChanged(Listener listener, Commands commands) {
            }

            public static void $default$onCues(Listener listener, List list) {
            }

            public static void $default$onDeviceInfoChanged(Listener listener, DeviceInfo deviceInfo) {
            }

            public static void $default$onDeviceVolumeChanged(Listener listener, int i, boolean z) {
            }

            public static void $default$onEvents(Listener listener, Player player, Events events) {
            }

            public static void $default$onIsLoadingChanged(Listener listener, boolean z) {
            }

            public static void $default$onIsPlayingChanged(Listener listener, boolean z) {
            }

            public static void $default$onMediaItemTransition(Listener listener, MediaItem mediaItem, int i) {
            }

            public static void $default$onMediaMetadataChanged(Listener listener, MediaMetadata mediaMetadata) {
            }

            public static void $default$onMetadata(Listener listener, Metadata metadata) {
            }

            public static void $default$onPlayWhenReadyChanged(Listener listener, boolean z, int i) {
            }

            public static void $default$onPlaybackParametersChanged(Listener listener, PlaybackParameters playbackParameters) {
            }

            public static void $default$onPlaybackStateChanged(Listener listener, int i) {
            }

            public static void $default$onPlaybackSuppressionReasonChanged(Listener listener, int i) {
            }

            public static void $default$onPlayerError(Listener listener, PlaybackException playbackException) {
            }

            public static void $default$onPlayerErrorChanged(Listener listener, PlaybackException playbackException) {
            }

            public static void $default$onPlaylistMetadataChanged(Listener listener, MediaMetadata mediaMetadata) {
            }

            public static void $default$onPositionDiscontinuity(Listener listener, PositionInfo positionInfo, PositionInfo positionInfo2, int i) {
            }

            public static void $default$onRenderedFirstFrame(Listener listener) {
            }

            public static void $default$onRepeatModeChanged(Listener listener, int i) {
            }

            public static void $default$onSeekBackIncrementChanged(Listener listener, long j) {
            }

            public static void $default$onSeekForwardIncrementChanged(Listener listener, long j) {
            }

            public static void $default$onShuffleModeEnabledChanged(Listener listener, boolean z) {
            }

            public static void $default$onSkipSilenceEnabledChanged(Listener listener, boolean z) {
            }

            public static void $default$onSurfaceSizeChanged(Listener listener, int i, int i2) {
            }

            public static void $default$onTimelineChanged(Listener listener, Timeline timeline, int i) {
            }

            public static void $default$onTracksInfoChanged(Listener listener, TracksInfo tracksInfo) {
            }

            public static void $default$onVideoSizeChanged(Listener listener, VideoSize videoSize) {
            }

            public static void $default$onVolumeChanged(Listener listener, float f) {
            }
        }

        void onAudioAttributesChanged(AudioAttributes audioAttributes);

        void onAudioSessionIdChanged(int i);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onAvailableCommandsChanged(Commands commands);

        void onCues(List<Cue> list);

        void onDeviceInfoChanged(DeviceInfo deviceInfo);

        void onDeviceVolumeChanged(int i, boolean z);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onEvents(Player player, Events events);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onIsLoadingChanged(boolean z);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onIsPlayingChanged(boolean z);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onMediaItemTransition(MediaItem mediaItem, int i);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onMediaMetadataChanged(MediaMetadata mediaMetadata);

        void onMetadata(Metadata metadata);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onPlayWhenReadyChanged(boolean z, int i);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onPlaybackStateChanged(int i);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onPlaybackSuppressionReasonChanged(int i);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onPlayerError(PlaybackException playbackException);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onPlayerErrorChanged(PlaybackException playbackException);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onPlaylistMetadataChanged(MediaMetadata mediaMetadata);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onPositionDiscontinuity(PositionInfo positionInfo, PositionInfo positionInfo2, int i);

        void onRenderedFirstFrame();

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onRepeatModeChanged(int i);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onSeekBackIncrementChanged(long j);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onSeekForwardIncrementChanged(long j);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onShuffleModeEnabledChanged(boolean z);

        void onSkipSilenceEnabledChanged(boolean z);

        void onSurfaceSizeChanged(int i, int i2);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onTimelineChanged(Timeline timeline, int i);

        @Override // com.google.android.exoplayer2.Player.EventListener
        void onTracksInfoChanged(TracksInfo tracksInfo);

        void onVideoSizeChanged(VideoSize videoSize);

        void onVolumeChanged(float f);
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface MediaItemTransitionReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface PlayWhenReadyChangeReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface PlaybackSuppressionReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface RepeatMode {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface State {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface TimelineChangeReason {
    }

    void addListener(Listener listener);

    void addMediaItem(int i, MediaItem mediaItem);

    void addMediaItem(MediaItem mediaItem);

    void addMediaItems(int i, List<MediaItem> list);

    void addMediaItems(List<MediaItem> list);

    boolean canAdvertiseSession();

    void clearMediaItems();

    void clearVideoSurface();

    void clearVideoSurface(Surface surface);

    void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder);

    void clearVideoSurfaceView(SurfaceView surfaceView);

    void clearVideoTextureView(TextureView textureView);

    void decreaseDeviceVolume();

    Looper getApplicationLooper();

    AudioAttributes getAudioAttributes();

    Commands getAvailableCommands();

    int getBufferedPercentage();

    long getBufferedPosition();

    long getContentBufferedPosition();

    long getContentDuration();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    List<Cue> getCurrentCues();

    long getCurrentLiveOffset();

    Object getCurrentManifest();

    MediaItem getCurrentMediaItem();

    int getCurrentMediaItemIndex();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    Timeline getCurrentTimeline();

    @Deprecated
    TrackGroupArray getCurrentTrackGroups();

    @Deprecated
    TrackSelectionArray getCurrentTrackSelections();

    TracksInfo getCurrentTracksInfo();

    @Deprecated
    int getCurrentWindowIndex();

    DeviceInfo getDeviceInfo();

    int getDeviceVolume();

    long getDuration();

    long getMaxSeekToPreviousPosition();

    MediaItem getMediaItemAt(int i);

    int getMediaItemCount();

    MediaMetadata getMediaMetadata();

    int getNextMediaItemIndex();

    @Deprecated
    int getNextWindowIndex();

    boolean getPlayWhenReady();

    PlaybackParameters getPlaybackParameters();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    PlaybackException getPlayerError();

    MediaMetadata getPlaylistMetadata();

    int getPreviousMediaItemIndex();

    @Deprecated
    int getPreviousWindowIndex();

    int getRepeatMode();

    long getSeekBackIncrement();

    long getSeekForwardIncrement();

    boolean getShuffleModeEnabled();

    long getTotalBufferedDuration();

    TrackSelectionParameters getTrackSelectionParameters();

    VideoSize getVideoSize();

    float getVolume();

    @Deprecated
    boolean hasNext();

    boolean hasNextMediaItem();

    @Deprecated
    boolean hasNextWindow();

    @Deprecated
    boolean hasPrevious();

    boolean hasPreviousMediaItem();

    @Deprecated
    boolean hasPreviousWindow();

    void increaseDeviceVolume();

    boolean isCommandAvailable(int i);

    boolean isCurrentMediaItemDynamic();

    boolean isCurrentMediaItemLive();

    boolean isCurrentMediaItemSeekable();

    @Deprecated
    boolean isCurrentWindowDynamic();

    @Deprecated
    boolean isCurrentWindowLive();

    @Deprecated
    boolean isCurrentWindowSeekable();

    boolean isDeviceMuted();

    boolean isLoading();

    boolean isPlaying();

    boolean isPlayingAd();

    void moveMediaItem(int i, int i2);

    void moveMediaItems(int i, int i2, int i3);

    @Deprecated
    void next();

    void pause();

    void play();

    void prepare();

    @Deprecated
    void previous();

    void release();

    void removeListener(Listener listener);

    void removeMediaItem(int i);

    void removeMediaItems(int i, int i2);

    void seekBack();

    void seekForward();

    void seekTo(int i, long j);

    void seekTo(long j);

    void seekToDefaultPosition();

    void seekToDefaultPosition(int i);

    void seekToNext();

    void seekToNextMediaItem();

    @Deprecated
    void seekToNextWindow();

    void seekToPrevious();

    void seekToPreviousMediaItem();

    @Deprecated
    void seekToPreviousWindow();

    void setDeviceMuted(boolean z);

    void setDeviceVolume(int i);

    void setMediaItem(MediaItem mediaItem);

    void setMediaItem(MediaItem mediaItem, long j);

    void setMediaItem(MediaItem mediaItem, boolean z);

    void setMediaItems(List<MediaItem> list);

    void setMediaItems(List<MediaItem> list, int i, long j);

    void setMediaItems(List<MediaItem> list, boolean z);

    void setPlayWhenReady(boolean z);

    void setPlaybackParameters(PlaybackParameters playbackParameters);

    void setPlaybackSpeed(float f);

    void setPlaylistMetadata(MediaMetadata mediaMetadata);

    void setRepeatMode(int i);

    void setShuffleModeEnabled(boolean z);

    void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters);

    void setVideoSurface(Surface surface);

    void setVideoSurfaceHolder(SurfaceHolder surfaceHolder);

    void setVideoSurfaceView(SurfaceView surfaceView);

    void setVideoTextureView(TextureView textureView);

    void setVolume(float f);

    void stop();

    @Deprecated
    void stop(boolean z);

    /* loaded from: classes2.dex */
    public static final class Events {
        private final FlagSet flags;

        public Events(FlagSet flagSet) {
            this.flags = flagSet;
        }

        public boolean contains(int i) {
            return this.flags.contains(i);
        }

        public boolean containsAny(int... iArr) {
            return this.flags.containsAny(iArr);
        }

        public int size() {
            return this.flags.size();
        }

        public int get(int i) {
            return this.flags.get(i);
        }

        public int hashCode() {
            return this.flags.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Events) {
                return this.flags.equals(((Events) obj).flags);
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static final class PositionInfo implements Bundleable {
        public static final Bundleable.Creator<PositionInfo> CREATOR = $$Lambda$Player$PositionInfo$0Jai4hp00qCDar7e3EwkonPWjA.INSTANCE;
        private static final int FIELD_AD_GROUP_INDEX = 5;
        private static final int FIELD_AD_INDEX_IN_AD_GROUP = 6;
        private static final int FIELD_CONTENT_POSITION_MS = 4;
        private static final int FIELD_MEDIA_ITEM = 1;
        private static final int FIELD_MEDIA_ITEM_INDEX = 0;
        private static final int FIELD_PERIOD_INDEX = 2;
        private static final int FIELD_POSITION_MS = 3;
        public final int adGroupIndex;
        public final int adIndexInAdGroup;
        public final long contentPositionMs;
        public final MediaItem mediaItem;
        public final int mediaItemIndex;
        public final int periodIndex;
        public final Object periodUid;
        public final long positionMs;
        @Deprecated
        public final int windowIndex;
        public final Object windowUid;

        @Deprecated
        public PositionInfo(Object obj, int i, Object obj2, int i2, long j, long j2, int i3, int i4) {
            this(obj, i, MediaItem.EMPTY, obj2, i2, j, j2, i3, i4);
        }

        public PositionInfo(Object obj, int i, MediaItem mediaItem, Object obj2, int i2, long j, long j2, int i3, int i4) {
            this.windowUid = obj;
            this.windowIndex = i;
            this.mediaItemIndex = i;
            this.mediaItem = mediaItem;
            this.periodUid = obj2;
            this.periodIndex = i2;
            this.positionMs = j;
            this.contentPositionMs = j2;
            this.adGroupIndex = i3;
            this.adIndexInAdGroup = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PositionInfo positionInfo = (PositionInfo) obj;
            return this.mediaItemIndex == positionInfo.mediaItemIndex && this.periodIndex == positionInfo.periodIndex && this.positionMs == positionInfo.positionMs && this.contentPositionMs == positionInfo.contentPositionMs && this.adGroupIndex == positionInfo.adGroupIndex && this.adIndexInAdGroup == positionInfo.adIndexInAdGroup && Objects.equal(this.windowUid, positionInfo.windowUid) && Objects.equal(this.periodUid, positionInfo.periodUid) && Objects.equal(this.mediaItem, positionInfo.mediaItem);
        }

        public int hashCode() {
            return Objects.hashCode(this.windowUid, Integer.valueOf(this.mediaItemIndex), this.mediaItem, this.periodUid, Integer.valueOf(this.periodIndex), Long.valueOf(this.positionMs), Long.valueOf(this.contentPositionMs), Integer.valueOf(this.adGroupIndex), Integer.valueOf(this.adIndexInAdGroup));
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(keyForField(0), this.mediaItemIndex);
            bundle.putBundle(keyForField(1), BundleableUtil.toNullableBundle(this.mediaItem));
            bundle.putInt(keyForField(2), this.periodIndex);
            bundle.putLong(keyForField(3), this.positionMs);
            bundle.putLong(keyForField(4), this.contentPositionMs);
            bundle.putInt(keyForField(5), this.adGroupIndex);
            bundle.putInt(keyForField(6), this.adIndexInAdGroup);
            return bundle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static PositionInfo fromBundle(Bundle bundle) {
            return new PositionInfo(null, bundle.getInt(keyForField(0), -1), (MediaItem) BundleableUtil.fromNullableBundle(MediaItem.CREATOR, bundle.getBundle(keyForField(1))), null, bundle.getInt(keyForField(2), -1), bundle.getLong(keyForField(3), C3282C.TIME_UNSET), bundle.getLong(keyForField(4), C3282C.TIME_UNSET), bundle.getInt(keyForField(5), -1), bundle.getInt(keyForField(6), -1));
        }

        private static String keyForField(int i) {
            return Integer.toString(i, 36);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Commands implements Bundleable {
        private static final int FIELD_COMMANDS = 0;
        private final FlagSet flags;
        public static final Commands EMPTY = new Builder().build();
        public static final Bundleable.Creator<Commands> CREATOR = $$Lambda$Player$Commands$9wfIGaCsSPvbzymZpUY6mofx72A.INSTANCE;

        /* loaded from: classes2.dex */
        public static final class Builder {
            private static final int[] SUPPORTED_COMMANDS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
            private final FlagSet.Builder flagsBuilder;

            public Builder() {
                this.flagsBuilder = new FlagSet.Builder();
            }

            private Builder(Commands commands) {
                FlagSet.Builder builder = new FlagSet.Builder();
                this.flagsBuilder = builder;
                builder.addAll(commands.flags);
            }

            public Builder add(int i) {
                this.flagsBuilder.add(i);
                return this;
            }

            public Builder addIf(int i, boolean z) {
                this.flagsBuilder.addIf(i, z);
                return this;
            }

            public Builder addAll(int... iArr) {
                this.flagsBuilder.addAll(iArr);
                return this;
            }

            public Builder addAll(Commands commands) {
                this.flagsBuilder.addAll(commands.flags);
                return this;
            }

            public Builder addAllCommands() {
                this.flagsBuilder.addAll(SUPPORTED_COMMANDS);
                return this;
            }

            public Builder remove(int i) {
                this.flagsBuilder.remove(i);
                return this;
            }

            public Builder removeIf(int i, boolean z) {
                this.flagsBuilder.removeIf(i, z);
                return this;
            }

            public Builder removeAll(int... iArr) {
                this.flagsBuilder.removeAll(iArr);
                return this;
            }

            public Commands build() {
                return new Commands(this.flagsBuilder.build());
            }
        }

        private Commands(FlagSet flagSet) {
            this.flags = flagSet;
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean contains(int i) {
            return this.flags.contains(i);
        }

        public int size() {
            return this.flags.size();
        }

        public int get(int i) {
            return this.flags.get(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Commands) {
                return this.flags.equals(((Commands) obj).flags);
            }
            return false;
        }

        public int hashCode() {
            return this.flags.hashCode();
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < this.flags.size(); i++) {
                arrayList.add(Integer.valueOf(this.flags.get(i)));
            }
            bundle.putIntegerArrayList(keyForField(0), arrayList);
            return bundle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Commands fromBundle(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(keyForField(0));
            if (integerArrayList == null) {
                return EMPTY;
            }
            Builder builder = new Builder();
            for (int i = 0; i < integerArrayList.size(); i++) {
                builder.add(integerArrayList.get(i).intValue());
            }
            return builder.build();
        }

        private static String keyForField(int i) {
            return Integer.toString(i, 36);
        }
    }
}
