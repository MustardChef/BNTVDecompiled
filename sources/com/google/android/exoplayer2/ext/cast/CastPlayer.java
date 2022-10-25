package com.google.android.exoplayer2.ext.cast;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.TracksInfo;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class CastPlayer extends BasePlayer {
    private static final long[] EMPTY_TRACK_ID_ARRAY;
    private static final TrackSelectionArray EMPTY_TRACK_SELECTION_ARRAY;
    public static final float MAX_SPEED_SUPPORTED = 2.0f;
    public static final float MIN_SPEED_SUPPORTED = 0.5f;
    static final Player.Commands PERMANENT_AVAILABLE_COMMANDS;
    private static final long PROGRESS_REPORT_PERIOD_MS = 1000;
    private static final int RENDERER_COUNT = 3;
    private static final int RENDERER_INDEX_AUDIO = 1;
    private static final int RENDERER_INDEX_TEXT = 2;
    private static final int RENDERER_INDEX_VIDEO = 0;
    private static final String TAG = "CastPlayer";
    private Player.Commands availableCommands;
    private final CastContext castContext;
    private CastTimeline currentTimeline;
    private TrackGroupArray currentTrackGroups;
    private TrackSelectionArray currentTrackSelection;
    private TracksInfo currentTracksInfo;
    private int currentWindowIndex;
    private long lastReportedPositionMs;
    private final ListenerSet<Player.EventListener> listeners;
    private final MediaItemConverter mediaItemConverter;
    private Player.PositionInfo pendingMediaItemRemovalPosition;
    private int pendingSeekCount;
    private long pendingSeekPositionMs;
    private int pendingSeekWindowIndex;
    private final Timeline.Period period;
    private final StateHolder<Boolean> playWhenReady;
    private final StateHolder<PlaybackParameters> playbackParameters;
    private int playbackState;
    private RemoteMediaClient remoteMediaClient;
    private final StateHolder<Integer> repeatMode;
    private final long seekBackIncrementMs;
    private final long seekForwardIncrementMs;
    private final SeekResultCallback seekResultCallback;
    private SessionAvailabilityListener sessionAvailabilityListener;
    private final StatusListener statusListener;
    private final CastTimelineTracker timelineTracker;

    private static int getRendererIndexForTrackType(int i) {
        if (i == 2) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return i == 3 ? 2 : -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurface() {
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurface(Surface surface) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoTextureView(TextureView textureView) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void decreaseDeviceVolume() {
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getDeviceVolume() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getMaxSeekToPreviousPosition() {
        return C3282C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackException getPlayerError() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    public float getVolume() {
        return 1.0f;
    }

    @Override // com.google.android.exoplayer2.Player
    public void increaseDeviceVolume() {
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isDeviceMuted() {
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
    }

    @Override // com.google.android.exoplayer2.Player
    public void setDeviceMuted(boolean z) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void setDeviceVolume(int i) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurface(Surface surface) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurfaceView(SurfaceView surfaceView) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoTextureView(TextureView textureView) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVolume(float f) {
    }

    static /* synthetic */ int access$1106(CastPlayer castPlayer) {
        int i = castPlayer.pendingSeekCount - 1;
        castPlayer.pendingSeekCount = i;
        return i;
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.cast");
        PERMANENT_AVAILABLE_COMMANDS = new Player.Commands.Builder().addAll(1, 2, 3, 4, 10, 15, 13, 16, 17, 18, 19, 20, 30).build();
        EMPTY_TRACK_SELECTION_ARRAY = new TrackSelectionArray(null, null, null);
        EMPTY_TRACK_ID_ARRAY = new long[0];
    }

    public CastPlayer(CastContext castContext) {
        this(castContext, new DefaultMediaItemConverter());
    }

    public CastPlayer(CastContext castContext, MediaItemConverter mediaItemConverter) {
        this(castContext, mediaItemConverter, 5000L, C3282C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
    }

    public CastPlayer(CastContext castContext, MediaItemConverter mediaItemConverter, long j, long j2) {
        Assertions.checkArgument(j > 0 && j2 > 0);
        this.castContext = castContext;
        this.mediaItemConverter = mediaItemConverter;
        this.seekBackIncrementMs = j;
        this.seekForwardIncrementMs = j2;
        this.timelineTracker = new CastTimelineTracker();
        this.period = new Timeline.Period();
        StatusListener statusListener = new StatusListener();
        this.statusListener = statusListener;
        this.seekResultCallback = new SeekResultCallback();
        this.listeners = new ListenerSet<>(Looper.getMainLooper(), Clock.DEFAULT, new ListenerSet.IterationFinishedEvent() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$FJJBSccQsGzcJ5pkHXCMuWFGNDs
            @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
            public final void invoke(Object obj, FlagSet flagSet) {
                CastPlayer.this.lambda$new$0$CastPlayer((Player.EventListener) obj, flagSet);
            }
        });
        this.playWhenReady = new StateHolder<>(false);
        this.repeatMode = new StateHolder<>(0);
        this.playbackParameters = new StateHolder<>(PlaybackParameters.DEFAULT);
        this.playbackState = 1;
        this.currentTimeline = CastTimeline.EMPTY_CAST_TIMELINE;
        this.currentTrackGroups = TrackGroupArray.EMPTY;
        this.currentTrackSelection = EMPTY_TRACK_SELECTION_ARRAY;
        this.currentTracksInfo = TracksInfo.EMPTY;
        this.availableCommands = new Player.Commands.Builder().addAll(PERMANENT_AVAILABLE_COMMANDS).build();
        this.pendingSeekWindowIndex = -1;
        this.pendingSeekPositionMs = C3282C.TIME_UNSET;
        SessionManager sessionManager = castContext.getSessionManager();
        sessionManager.addSessionManagerListener(statusListener, CastSession.class);
        CastSession currentCastSession = sessionManager.getCurrentCastSession();
        setRemoteMediaClient(currentCastSession != null ? currentCastSession.getRemoteMediaClient() : null);
        updateInternalStateAndNotifyIfChanged();
    }

    public /* synthetic */ void lambda$new$0$CastPlayer(Player.EventListener eventListener, FlagSet flagSet) {
        eventListener.onEvents(this, new Player.Events(flagSet));
    }

    public MediaQueueItem getItem(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null || this.currentTimeline.getIndexOfPeriod(Integer.valueOf(i)) == -1) {
            return null;
        }
        return mediaStatus.getItemById(i);
    }

    public boolean isCastSessionAvailable() {
        return this.remoteMediaClient != null;
    }

    public void setSessionAvailabilityListener(SessionAvailabilityListener sessionAvailabilityListener) {
        this.sessionAvailabilityListener = sessionAvailabilityListener;
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return Looper.getMainLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.Listener listener) {
        addListener((Player.EventListener) listener);
    }

    @Deprecated
    public void addListener(Player.EventListener eventListener) {
        this.listeners.add(eventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.Listener listener) {
        removeListener((Player.EventListener) listener);
    }

    @Deprecated
    public void removeListener(Player.EventListener eventListener) {
        this.listeners.remove(eventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, boolean z) {
        setMediaItems(list, z ? 0 : getCurrentMediaItemIndex(), z ? C3282C.TIME_UNSET : getContentPosition());
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, int i, long j) {
        setMediaItemsInternal(toMediaQueueItems(list), i, j, this.repeatMode.value.intValue());
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(int i, List<MediaItem> list) {
        Assertions.checkArgument(i >= 0);
        addMediaItemsInternal(toMediaQueueItems(list), i < this.currentTimeline.getWindowCount() ? ((Integer) this.currentTimeline.getWindow(i, this.window).uid).intValue() : 0);
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItems(int i, int i2, int i3) {
        Assertions.checkArgument(i >= 0 && i <= i2 && i2 <= this.currentTimeline.getWindowCount() && i3 >= 0 && i3 < this.currentTimeline.getWindowCount());
        int i4 = i2 - i;
        int min = Math.min(i3, this.currentTimeline.getWindowCount() - i4);
        if (i == i2 || i == min) {
            return;
        }
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iArr[i5] = ((Integer) this.currentTimeline.getWindow(i5 + i, this.window).uid).intValue();
        }
        moveMediaItemsInternal(iArr, i, min);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItems(int i, int i2) {
        Assertions.checkArgument(i >= 0 && i2 >= i);
        int min = Math.min(i2, this.currentTimeline.getWindowCount());
        if (i == min) {
            return;
        }
        int i3 = min - i;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i4] = ((Integer) this.currentTimeline.getWindow(i4 + i, this.window).uid).intValue();
        }
        removeMediaItemsInternal(iArr);
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.Commands getAvailableCommands() {
        return this.availableCommands;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.playbackState;
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        if (this.remoteMediaClient == null) {
            return;
        }
        setPlayerStateAndNotifyIfChanged(z, 1, this.playbackState);
        this.listeners.flushEvents();
        PendingResult<RemoteMediaClient.MediaChannelResult> play = z ? this.remoteMediaClient.play() : this.remoteMediaClient.pause();
        this.playWhenReady.pendingResultCallback = new ResultCallback<RemoteMediaClient.MediaChannelResult>() { // from class: com.google.android.exoplayer2.ext.cast.CastPlayer.1
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
                if (CastPlayer.this.remoteMediaClient != null) {
                    CastPlayer.this.updatePlayerStateAndNotifyIfChanged(this);
                    CastPlayer.this.listeners.flushEvents();
                }
            }
        };
        play.setResultCallback(this.playWhenReady.pendingResultCallback);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.playWhenReady.value.booleanValue();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i, long j) {
        MediaStatus mediaStatus = getMediaStatus();
        if (j == C3282C.TIME_UNSET) {
            j = 0;
        }
        if (mediaStatus != null) {
            if (getCurrentMediaItemIndex() != i) {
                this.remoteMediaClient.queueJumpToItem(((Integer) this.currentTimeline.getPeriod(i, this.period).uid).intValue(), j, null).setResultCallback(this.seekResultCallback);
            } else {
                this.remoteMediaClient.seek(j).setResultCallback(this.seekResultCallback);
            }
            final Player.PositionInfo currentPositionInfo = getCurrentPositionInfo();
            this.pendingSeekCount++;
            this.pendingSeekWindowIndex = i;
            this.pendingSeekPositionMs = j;
            final Player.PositionInfo currentPositionInfo2 = getCurrentPositionInfo();
            this.listeners.queueEvent(11, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$VnNK_k6hn7dwl_EGkEYYE6w2XNA
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    CastPlayer.lambda$seekTo$1(Player.PositionInfo.this, currentPositionInfo2, (Player.EventListener) obj);
                }
            });
            if (currentPositionInfo.mediaItemIndex != currentPositionInfo2.mediaItemIndex) {
                final MediaItem mediaItem = getCurrentTimeline().getWindow(i, this.window).mediaItem;
                this.listeners.queueEvent(1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$hptm7fi6jPT_3A2ul3wECSbI6IE
                    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.EventListener) obj).onMediaItemTransition(MediaItem.this, 2);
                    }
                });
            }
            updateAvailableCommandsAndNotifyIfChanged();
        } else if (this.pendingSeekCount == 0) {
            this.listeners.queueEvent(-1, $$Lambda$AUixTKH215bERtTSFavke1jDtE.INSTANCE);
        }
        this.listeners.flushEvents();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$seekTo$1(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.EventListener eventListener) {
        eventListener.onPositionDiscontinuity(1);
        eventListener.onPositionDiscontinuity(positionInfo, positionInfo2, 1);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekBackIncrement() {
        return this.seekBackIncrementMs;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekForwardIncrement() {
        return this.seekForwardIncrementMs;
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters.value;
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop() {
        stop(false);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void stop(boolean z) {
        this.playbackState = 1;
        RemoteMediaClient remoteMediaClient = this.remoteMediaClient;
        if (remoteMediaClient != null) {
            remoteMediaClient.stop();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        SessionManager sessionManager = this.castContext.getSessionManager();
        sessionManager.removeSessionManagerListener(this.statusListener, CastSession.class);
        sessionManager.endCurrentSession(false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (this.remoteMediaClient == null) {
            return;
        }
        PlaybackParameters playbackParameters2 = new PlaybackParameters(Util.constrainValue(playbackParameters.speed, 0.5f, 2.0f));
        setPlaybackParametersAndNotifyIfChanged(playbackParameters2);
        this.listeners.flushEvents();
        PendingResult<RemoteMediaClient.MediaChannelResult> playbackRate = this.remoteMediaClient.setPlaybackRate(playbackParameters2.speed, null);
        this.playbackParameters.pendingResultCallback = new ResultCallback<RemoteMediaClient.MediaChannelResult>() { // from class: com.google.android.exoplayer2.ext.cast.CastPlayer.2
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
                if (CastPlayer.this.remoteMediaClient != null) {
                    CastPlayer.this.updatePlaybackRateAndNotifyIfChanged(this);
                    CastPlayer.this.listeners.flushEvents();
                }
            }
        };
        playbackRate.setResultCallback(this.playbackParameters.pendingResultCallback);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i) {
        if (this.remoteMediaClient == null) {
            return;
        }
        setRepeatModeAndNotifyIfChanged(i);
        this.listeners.flushEvents();
        PendingResult<RemoteMediaClient.MediaChannelResult> queueSetRepeatMode = this.remoteMediaClient.queueSetRepeatMode(getCastRepeatMode(i), null);
        this.repeatMode.pendingResultCallback = new ResultCallback<RemoteMediaClient.MediaChannelResult>() { // from class: com.google.android.exoplayer2.ext.cast.CastPlayer.3
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
                if (CastPlayer.this.remoteMediaClient != null) {
                    CastPlayer.this.updateRepeatModeAndNotifyIfChanged(this);
                    CastPlayer.this.listeners.flushEvents();
                }
            }
        };
        queueSetRepeatMode.setResultCallback(this.repeatMode.pendingResultCallback);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.repeatMode.value.intValue();
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        return this.currentTrackGroups;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        return this.currentTrackSelection;
    }

    @Override // com.google.android.exoplayer2.Player
    public TracksInfo getCurrentTracksInfo() {
        return this.currentTracksInfo;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionParameters getTrackSelectionParameters() {
        return TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata getMediaMetadata() {
        return MediaMetadata.EMPTY;
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata getPlaylistMetadata() {
        return MediaMetadata.EMPTY;
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        return this.currentTimeline;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        return getCurrentMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentMediaItemIndex() {
        int i = this.pendingSeekWindowIndex;
        return i != -1 ? i : this.currentWindowIndex;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        return getContentDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        long j = this.pendingSeekPositionMs;
        if (j != C3282C.TIME_UNSET) {
            return j;
        }
        RemoteMediaClient remoteMediaClient = this.remoteMediaClient;
        if (remoteMediaClient != null) {
            return remoteMediaClient.getApproximateStreamPosition();
        }
        return this.lastReportedPositionMs;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        long bufferedPosition = getBufferedPosition();
        long currentPosition = getCurrentPosition();
        if (bufferedPosition == C3282C.TIME_UNSET || currentPosition == C3282C.TIME_UNSET) {
            return 0L;
        }
        return bufferedPosition - currentPosition;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        return getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public AudioAttributes getAudioAttributes() {
        return AudioAttributes.DEFAULT;
    }

    @Override // com.google.android.exoplayer2.Player
    public VideoSize getVideoSize() {
        return VideoSize.UNKNOWN;
    }

    @Override // com.google.android.exoplayer2.Player
    public ImmutableList<Cue> getCurrentCues() {
        return ImmutableList.m295of();
    }

    @Override // com.google.android.exoplayer2.Player
    public DeviceInfo getDeviceInfo() {
        return DeviceInfo.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInternalStateAndNotifyIfChanged() {
        if (this.remoteMediaClient == null) {
            return;
        }
        int i = this.currentWindowIndex;
        Object obj = !getCurrentTimeline().isEmpty() ? getCurrentTimeline().getPeriod(i, this.period, true).uid : null;
        final boolean z = false;
        boolean z2 = this.playbackState == 3 && this.playWhenReady.value.booleanValue();
        updatePlayerStateAndNotifyIfChanged(null);
        if (this.playbackState == 3 && this.playWhenReady.value.booleanValue()) {
            z = true;
        }
        if (z2 != z) {
            this.listeners.queueEvent(7, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$FIaaWALy0URS8MuiaR7FGJZ_f7o
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj2) {
                    ((Player.EventListener) obj2).onIsPlayingChanged(z);
                }
            });
        }
        updateRepeatModeAndNotifyIfChanged(null);
        updatePlaybackRateAndNotifyIfChanged(null);
        boolean updateTimelineAndNotifyIfChanged = updateTimelineAndNotifyIfChanged();
        Timeline currentTimeline = getCurrentTimeline();
        this.currentWindowIndex = fetchCurrentWindowIndex(this.remoteMediaClient, currentTimeline);
        Object obj2 = currentTimeline.isEmpty() ? null : currentTimeline.getPeriod(this.currentWindowIndex, this.period, true).uid;
        if (!updateTimelineAndNotifyIfChanged && !Util.areEqual(obj, obj2) && this.pendingSeekCount == 0) {
            currentTimeline.getPeriod(i, this.period, true);
            currentTimeline.getWindow(i, this.window);
            long durationMs = this.window.getDurationMs();
            final Player.PositionInfo positionInfo = new Player.PositionInfo(this.window.uid, this.period.windowIndex, this.window.mediaItem, this.period.uid, this.period.windowIndex, durationMs, durationMs, -1, -1);
            currentTimeline.getPeriod(this.currentWindowIndex, this.period, true);
            currentTimeline.getWindow(this.currentWindowIndex, this.window);
            final Player.PositionInfo positionInfo2 = new Player.PositionInfo(this.window.uid, this.period.windowIndex, this.window.mediaItem, this.period.uid, this.period.windowIndex, this.window.getDefaultPositionMs(), this.window.getDefaultPositionMs(), -1, -1);
            this.listeners.queueEvent(11, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$cY_owzBi_9cICQzQ-VY8cmx0I24
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj3) {
                    CastPlayer.lambda$updateInternalStateAndNotifyIfChanged$4(Player.PositionInfo.this, positionInfo2, (Player.EventListener) obj3);
                }
            });
            this.listeners.queueEvent(1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$f1qM2JSVFUxCHXvoUsxwY7usavo
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj3) {
                    CastPlayer.this.lambda$updateInternalStateAndNotifyIfChanged$5$CastPlayer((Player.EventListener) obj3);
                }
            });
        }
        if (updateTracksAndSelectionsAndNotifyIfChanged()) {
            this.listeners.queueEvent(2, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$3p95P3PXM8VgJi3AShEb_ygg0iQ
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj3) {
                    CastPlayer.this.lambda$updateInternalStateAndNotifyIfChanged$6$CastPlayer((Player.EventListener) obj3);
                }
            });
            this.listeners.queueEvent(2, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$_5KTJTKIa5FidrAVVZl4MGIWIVk
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj3) {
                    CastPlayer.this.lambda$updateInternalStateAndNotifyIfChanged$7$CastPlayer((Player.EventListener) obj3);
                }
            });
        }
        updateAvailableCommandsAndNotifyIfChanged();
        this.listeners.flushEvents();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateInternalStateAndNotifyIfChanged$4(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.EventListener eventListener) {
        eventListener.onPositionDiscontinuity(0);
        eventListener.onPositionDiscontinuity(positionInfo, positionInfo2, 0);
    }

    public /* synthetic */ void lambda$updateInternalStateAndNotifyIfChanged$5$CastPlayer(Player.EventListener eventListener) {
        eventListener.onMediaItemTransition(getCurrentMediaItem(), 1);
    }

    public /* synthetic */ void lambda$updateInternalStateAndNotifyIfChanged$6$CastPlayer(Player.EventListener eventListener) {
        eventListener.onTracksChanged(this.currentTrackGroups, this.currentTrackSelection);
    }

    public /* synthetic */ void lambda$updateInternalStateAndNotifyIfChanged$7$CastPlayer(Player.EventListener eventListener) {
        eventListener.onTracksInfoChanged(this.currentTracksInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull({"remoteMediaClient"})
    public void updatePlayerStateAndNotifyIfChanged(ResultCallback<?> resultCallback) {
        boolean booleanValue = this.playWhenReady.value.booleanValue();
        if (this.playWhenReady.acceptsUpdate(resultCallback)) {
            booleanValue = !this.remoteMediaClient.isPaused();
            this.playWhenReady.clearPendingResultCallback();
        }
        setPlayerStateAndNotifyIfChanged(booleanValue, booleanValue != this.playWhenReady.value.booleanValue() ? 4 : 1, fetchPlaybackState(this.remoteMediaClient));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull({"remoteMediaClient"})
    public void updatePlaybackRateAndNotifyIfChanged(ResultCallback<?> resultCallback) {
        float f;
        if (this.playbackParameters.acceptsUpdate(resultCallback)) {
            MediaStatus mediaStatus = this.remoteMediaClient.getMediaStatus();
            if (mediaStatus != null) {
                f = (float) mediaStatus.getPlaybackRate();
            } else {
                f = PlaybackParameters.DEFAULT.speed;
            }
            if (f > 0.0f) {
                setPlaybackParametersAndNotifyIfChanged(new PlaybackParameters(f));
            }
            this.playbackParameters.clearPendingResultCallback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull({"remoteMediaClient"})
    public void updateRepeatModeAndNotifyIfChanged(ResultCallback<?> resultCallback) {
        if (this.repeatMode.acceptsUpdate(resultCallback)) {
            setRepeatModeAndNotifyIfChanged(fetchRepeatMode(this.remoteMediaClient));
            this.repeatMode.clearPendingResultCallback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateTimelineAndNotifyIfChanged() {
        CastTimeline castTimeline = this.currentTimeline;
        int i = this.currentWindowIndex;
        boolean z = false;
        if (updateTimeline()) {
            final CastTimeline castTimeline2 = this.currentTimeline;
            this.listeners.queueEvent(0, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$WmBBsRS_yua8lbkNHt_nCjk2FxA
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.EventListener) obj).onTimelineChanged(Timeline.this, 1);
                }
            });
            Timeline currentTimeline = getCurrentTimeline();
            boolean z2 = !castTimeline.isEmpty() && currentTimeline.getIndexOfPeriod(Util.castNonNull(castTimeline.getPeriod(i, this.period, true).uid)) == -1;
            if (z2) {
                final Player.PositionInfo positionInfo = this.pendingMediaItemRemovalPosition;
                if (positionInfo != null) {
                    this.pendingMediaItemRemovalPosition = null;
                } else {
                    castTimeline.getPeriod(i, this.period, true);
                    castTimeline.getWindow(this.period.windowIndex, this.window);
                    positionInfo = new Player.PositionInfo(this.window.uid, this.period.windowIndex, this.window.mediaItem, this.period.uid, this.period.windowIndex, getCurrentPosition(), getContentPosition(), -1, -1);
                }
                final Player.PositionInfo currentPositionInfo = getCurrentPositionInfo();
                this.listeners.queueEvent(11, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$zCqXboP4s6rggtKfUHXrkz6qQzA
                    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        CastPlayer.lambda$updateTimelineAndNotifyIfChanged$9(Player.PositionInfo.this, currentPositionInfo, (Player.EventListener) obj);
                    }
                });
            }
            z = (currentTimeline.isEmpty() != castTimeline.isEmpty() || z2) ? true : true;
            if (z) {
                this.listeners.queueEvent(1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$i2VnMAdA0HtOjwtqEbSBm58kPL8
                    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        CastPlayer.this.lambda$updateTimelineAndNotifyIfChanged$10$CastPlayer((Player.EventListener) obj);
                    }
                });
            }
            updateAvailableCommandsAndNotifyIfChanged();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateTimelineAndNotifyIfChanged$9(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.EventListener eventListener) {
        eventListener.onPositionDiscontinuity(4);
        eventListener.onPositionDiscontinuity(positionInfo, positionInfo2, 4);
    }

    public /* synthetic */ void lambda$updateTimelineAndNotifyIfChanged$10$CastPlayer(Player.EventListener eventListener) {
        eventListener.onMediaItemTransition(getCurrentMediaItem(), 3);
    }

    private boolean updateTimeline() {
        CastTimeline castTimeline;
        CastTimeline castTimeline2 = this.currentTimeline;
        if (getMediaStatus() != null) {
            castTimeline = this.timelineTracker.getCastTimeline(this.remoteMediaClient);
        } else {
            castTimeline = CastTimeline.EMPTY_CAST_TIMELINE;
        }
        this.currentTimeline = castTimeline;
        boolean z = !castTimeline2.equals(castTimeline);
        if (z) {
            this.currentWindowIndex = fetchCurrentWindowIndex(this.remoteMediaClient, this.currentTimeline);
        }
        return z;
    }

    private boolean updateTracksAndSelectionsAndNotifyIfChanged() {
        if (this.remoteMediaClient == null) {
            return false;
        }
        MediaStatus mediaStatus = getMediaStatus();
        MediaInfo mediaInfo = mediaStatus != null ? mediaStatus.getMediaInfo() : null;
        List<MediaTrack> mediaTracks = mediaInfo != null ? mediaInfo.getMediaTracks() : null;
        if (mediaTracks == null || mediaTracks.isEmpty()) {
            boolean z = !this.currentTrackGroups.isEmpty();
            this.currentTrackGroups = TrackGroupArray.EMPTY;
            this.currentTrackSelection = EMPTY_TRACK_SELECTION_ARRAY;
            this.currentTracksInfo = TracksInfo.EMPTY;
            return z;
        }
        long[] activeTrackIds = mediaStatus.getActiveTrackIds();
        if (activeTrackIds == null) {
            activeTrackIds = EMPTY_TRACK_ID_ARRAY;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[mediaTracks.size()];
        TrackSelection[] trackSelectionArr = new TrackSelection[3];
        TracksInfo.TrackGroupInfo[] trackGroupInfoArr = new TracksInfo.TrackGroupInfo[mediaTracks.size()];
        for (int i = 0; i < mediaTracks.size(); i++) {
            MediaTrack mediaTrack = mediaTracks.get(i);
            trackGroupArr[i] = new TrackGroup(CastUtils.mediaTrackToFormat(mediaTrack));
            long id = mediaTrack.getId();
            int trackType = MimeTypes.getTrackType(mediaTrack.getContentType());
            int rendererIndexForTrackType = getRendererIndexForTrackType(trackType);
            boolean z2 = rendererIndexForTrackType != -1;
            boolean z3 = isTrackActive(id, activeTrackIds) && z2 && trackSelectionArr[rendererIndexForTrackType] == null;
            if (z3) {
                trackSelectionArr[rendererIndexForTrackType] = new CastTrackSelection(trackGroupArr[i]);
            }
            int[] iArr = new int[1];
            iArr[0] = z2 ? 4 : 0;
            trackGroupInfoArr[i] = new TracksInfo.TrackGroupInfo(trackGroupArr[i], iArr, trackType, new boolean[]{z3});
        }
        TrackGroupArray trackGroupArray = new TrackGroupArray(trackGroupArr);
        TrackSelectionArray trackSelectionArray = new TrackSelectionArray(trackSelectionArr);
        TracksInfo tracksInfo = new TracksInfo(ImmutableList.copyOf(trackGroupInfoArr));
        if (trackGroupArray.equals(this.currentTrackGroups) && trackSelectionArray.equals(this.currentTrackSelection) && tracksInfo.equals(this.currentTracksInfo)) {
            return false;
        }
        this.currentTrackSelection = trackSelectionArray;
        this.currentTrackGroups = trackGroupArray;
        this.currentTracksInfo = tracksInfo;
        return true;
    }

    private void updateAvailableCommandsAndNotifyIfChanged() {
        Player.Commands commands = this.availableCommands;
        Player.Commands availableCommands = getAvailableCommands(PERMANENT_AVAILABLE_COMMANDS);
        this.availableCommands = availableCommands;
        if (availableCommands.equals(commands)) {
            return;
        }
        this.listeners.queueEvent(13, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$lUKnzaGHqnt8ogXmT2rrRSV_D-A
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                CastPlayer.this.lambda$updateAvailableCommandsAndNotifyIfChanged$11$CastPlayer((Player.EventListener) obj);
            }
        });
    }

    public /* synthetic */ void lambda$updateAvailableCommandsAndNotifyIfChanged$11$CastPlayer(Player.EventListener eventListener) {
        eventListener.onAvailableCommandsChanged(this.availableCommands);
    }

    private PendingResult<RemoteMediaClient.MediaChannelResult> setMediaItemsInternal(MediaQueueItem[] mediaQueueItemArr, int i, long j, int i2) {
        if (this.remoteMediaClient == null || mediaQueueItemArr.length == 0) {
            return null;
        }
        if (j == C3282C.TIME_UNSET) {
            j = 0;
        }
        if (i == -1) {
            i = getCurrentMediaItemIndex();
            j = getCurrentPosition();
        }
        long j2 = j;
        if (!getCurrentTimeline().isEmpty()) {
            this.pendingMediaItemRemovalPosition = getCurrentPositionInfo();
        }
        return this.remoteMediaClient.queueLoad(mediaQueueItemArr, Math.min(i, mediaQueueItemArr.length - 1), getCastRepeatMode(i2), j2, null);
    }

    private PendingResult<RemoteMediaClient.MediaChannelResult> addMediaItemsInternal(MediaQueueItem[] mediaQueueItemArr, int i) {
        if (this.remoteMediaClient == null || getMediaStatus() == null) {
            return null;
        }
        return this.remoteMediaClient.queueInsertItems(mediaQueueItemArr, i, null);
    }

    private PendingResult<RemoteMediaClient.MediaChannelResult> moveMediaItemsInternal(int[] iArr, int i, int i2) {
        if (this.remoteMediaClient == null || getMediaStatus() == null) {
            return null;
        }
        if (i < i2) {
            i2 += iArr.length;
        }
        return this.remoteMediaClient.queueReorderItems(iArr, i2 < this.currentTimeline.getWindowCount() ? ((Integer) this.currentTimeline.getWindow(i2, this.window).uid).intValue() : 0, null);
    }

    private PendingResult<RemoteMediaClient.MediaChannelResult> removeMediaItemsInternal(int[] iArr) {
        if (this.remoteMediaClient == null || getMediaStatus() == null) {
            return null;
        }
        Timeline currentTimeline = getCurrentTimeline();
        if (!currentTimeline.isEmpty()) {
            Object castNonNull = Util.castNonNull(currentTimeline.getPeriod(getCurrentPeriodIndex(), this.period, true).uid);
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (castNonNull.equals(Integer.valueOf(iArr[i]))) {
                    this.pendingMediaItemRemovalPosition = getCurrentPositionInfo();
                    break;
                } else {
                    i++;
                }
            }
        }
        return this.remoteMediaClient.queueRemoveItems(iArr, null);
    }

    private Player.PositionInfo getCurrentPositionInfo() {
        Object obj;
        MediaItem mediaItem;
        Object obj2;
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            obj = null;
            mediaItem = null;
            obj2 = null;
        } else {
            Object obj3 = currentTimeline.getPeriod(getCurrentPeriodIndex(), this.period, true).uid;
            obj = currentTimeline.getWindow(this.period.windowIndex, this.window).uid;
            mediaItem = this.window.mediaItem;
            obj2 = obj3;
        }
        return new Player.PositionInfo(obj, getCurrentMediaItemIndex(), mediaItem, obj2, getCurrentPeriodIndex(), getCurrentPosition(), getContentPosition(), -1, -1);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Integer] */
    private void setRepeatModeAndNotifyIfChanged(final int i) {
        if (this.repeatMode.value.intValue() != i) {
            this.repeatMode.value = Integer.valueOf(i);
            this.listeners.queueEvent(8, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$5lTAJs1bZH1dRo8uEUx8vLfkYeE
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.EventListener) obj).onRepeatModeChanged(i);
                }
            });
            updateAvailableCommandsAndNotifyIfChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setPlaybackParametersAndNotifyIfChanged(final PlaybackParameters playbackParameters) {
        if (this.playbackParameters.value.equals(playbackParameters)) {
            return;
        }
        this.playbackParameters.value = playbackParameters;
        this.listeners.queueEvent(12, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$JhVKfC3-du_-9PJqYt-obg5_osA
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.EventListener) obj).onPlaybackParametersChanged(PlaybackParameters.this);
            }
        });
        updateAvailableCommandsAndNotifyIfChanged();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Boolean] */
    private void setPlayerStateAndNotifyIfChanged(final boolean z, final int i, final int i2) {
        boolean z2 = this.playWhenReady.value.booleanValue() != z;
        boolean z3 = this.playbackState != i2;
        if (z2 || z3) {
            this.playbackState = i2;
            this.playWhenReady.value = Boolean.valueOf(z);
            this.listeners.queueEvent(-1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$EQb_FQQANml6g4NKUBo-sPW1ElM
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.EventListener) obj).onPlayerStateChanged(z, i2);
                }
            });
            if (z3) {
                this.listeners.queueEvent(4, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$JyHma1pR9waeWez2h36RoMCM-s4
                    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.EventListener) obj).onPlaybackStateChanged(i2);
                    }
                });
            }
            if (z2) {
                this.listeners.queueEvent(5, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.ext.cast.-$$Lambda$CastPlayer$orniILzvKXBIYuKmpb4RlTBZP8I
                    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.EventListener) obj).onPlayWhenReadyChanged(z, i);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemoteMediaClient(RemoteMediaClient remoteMediaClient) {
        RemoteMediaClient remoteMediaClient2 = this.remoteMediaClient;
        if (remoteMediaClient2 == remoteMediaClient) {
            return;
        }
        if (remoteMediaClient2 != null) {
            remoteMediaClient2.unregisterCallback(this.statusListener);
            this.remoteMediaClient.removeProgressListener(this.statusListener);
        }
        this.remoteMediaClient = remoteMediaClient;
        if (remoteMediaClient != null) {
            SessionAvailabilityListener sessionAvailabilityListener = this.sessionAvailabilityListener;
            if (sessionAvailabilityListener != null) {
                sessionAvailabilityListener.onCastSessionAvailable();
            }
            remoteMediaClient.registerCallback(this.statusListener);
            remoteMediaClient.addProgressListener(this.statusListener, 1000L);
            updateInternalStateAndNotifyIfChanged();
            return;
        }
        updateTimelineAndNotifyIfChanged();
        SessionAvailabilityListener sessionAvailabilityListener2 = this.sessionAvailabilityListener;
        if (sessionAvailabilityListener2 != null) {
            sessionAvailabilityListener2.onCastSessionUnavailable();
        }
    }

    private MediaStatus getMediaStatus() {
        RemoteMediaClient remoteMediaClient = this.remoteMediaClient;
        if (remoteMediaClient != null) {
            return remoteMediaClient.getMediaStatus();
        }
        return null;
    }

    private static int fetchPlaybackState(RemoteMediaClient remoteMediaClient) {
        int playerState = remoteMediaClient.getPlayerState();
        if (playerState == 2 || playerState == 3) {
            return 3;
        }
        return playerState != 4 ? 1 : 2;
    }

    private static int fetchRepeatMode(RemoteMediaClient remoteMediaClient) {
        MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
        int i = 0;
        if (mediaStatus == null) {
            return 0;
        }
        int queueRepeatMode = mediaStatus.getQueueRepeatMode();
        if (queueRepeatMode != 0) {
            i = 2;
            if (queueRepeatMode != 1) {
                if (queueRepeatMode == 2) {
                    return 1;
                }
                if (queueRepeatMode != 3) {
                    throw new IllegalStateException();
                }
            }
        }
        return i;
    }

    private static int fetchCurrentWindowIndex(RemoteMediaClient remoteMediaClient, Timeline timeline) {
        if (remoteMediaClient == null) {
            return 0;
        }
        MediaQueueItem currentItem = remoteMediaClient.getCurrentItem();
        int indexOfPeriod = currentItem != null ? timeline.getIndexOfPeriod(Integer.valueOf(currentItem.getItemId())) : -1;
        if (indexOfPeriod == -1) {
            return 0;
        }
        return indexOfPeriod;
    }

    private static boolean isTrackActive(long j, long[] jArr) {
        for (long j2 : jArr) {
            if (j2 == j) {
                return true;
            }
        }
        return false;
    }

    private static int getCastRepeatMode(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return 1;
                }
                throw new IllegalArgumentException();
            }
            return 2;
        }
        return 0;
    }

    private MediaQueueItem[] toMediaQueueItems(List<MediaItem> list) {
        MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[list.size()];
        for (int i = 0; i < list.size(); i++) {
            mediaQueueItemArr[i] = this.mediaItemConverter.toMediaQueueItem(list.get(i));
        }
        return mediaQueueItemArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class StatusListener extends RemoteMediaClient.Callback implements SessionManagerListener<CastSession>, RemoteMediaClient.ProgressListener {
        @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
        public void onAdBreakStatusUpdated() {
        }

        @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
        public void onMetadataUpdated() {
        }

        @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
        public void onPreloadStatusUpdated() {
        }

        @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
        public void onSendingRemoteMediaRequest() {
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionEnding(CastSession castSession) {
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionResuming(CastSession castSession, String str) {
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionStarting(CastSession castSession) {
        }

        private StatusListener() {
        }

        @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener
        public void onProgressUpdated(long j, long j2) {
            CastPlayer.this.lastReportedPositionMs = j;
        }

        @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
        public void onStatusUpdated() {
            CastPlayer.this.updateInternalStateAndNotifyIfChanged();
        }

        @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
        public void onQueueStatusUpdated() {
            CastPlayer.this.updateTimelineAndNotifyIfChanged();
            CastPlayer.this.listeners.flushEvents();
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionStarted(CastSession castSession, String str) {
            CastPlayer.this.setRemoteMediaClient(castSession.getRemoteMediaClient());
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionResumed(CastSession castSession, boolean z) {
            CastPlayer.this.setRemoteMediaClient(castSession.getRemoteMediaClient());
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionEnded(CastSession castSession, int i) {
            CastPlayer.this.setRemoteMediaClient(null);
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionSuspended(CastSession castSession, int i) {
            CastPlayer.this.setRemoteMediaClient(null);
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionResumeFailed(CastSession castSession, int i) {
            String logString = CastUtils.getLogString(i);
            StringBuilder sb = new StringBuilder(String.valueOf(logString).length() + 47);
            sb.append("Session resume failed. Error code ");
            sb.append(i);
            sb.append(": ");
            sb.append(logString);
            Log.m383e(CastPlayer.TAG, sb.toString());
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionStartFailed(CastSession castSession, int i) {
            String logString = CastUtils.getLogString(i);
            StringBuilder sb = new StringBuilder(String.valueOf(logString).length() + 46);
            sb.append("Session start failed. Error code ");
            sb.append(i);
            sb.append(": ");
            sb.append(logString);
            Log.m383e(CastPlayer.TAG, sb.toString());
        }
    }

    /* loaded from: classes2.dex */
    private final class SeekResultCallback implements ResultCallback<RemoteMediaClient.MediaChannelResult> {
        private SeekResultCallback() {
        }

        @Override // com.google.android.gms.common.api.ResultCallback
        public void onResult(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
            int statusCode = mediaChannelResult.getStatus().getStatusCode();
            if (statusCode != 0 && statusCode != 2103) {
                String logString = CastUtils.getLogString(statusCode);
                StringBuilder sb = new StringBuilder(String.valueOf(logString).length() + 37);
                sb.append("Seek failed. Error code ");
                sb.append(statusCode);
                sb.append(": ");
                sb.append(logString);
                Log.m383e(CastPlayer.TAG, sb.toString());
            }
            if (CastPlayer.access$1106(CastPlayer.this) == 0) {
                CastPlayer castPlayer = CastPlayer.this;
                castPlayer.currentWindowIndex = castPlayer.pendingSeekWindowIndex;
                CastPlayer.this.pendingSeekWindowIndex = -1;
                CastPlayer.this.pendingSeekPositionMs = C3282C.TIME_UNSET;
                CastPlayer.this.listeners.sendEvent(-1, $$Lambda$AUixTKH215bERtTSFavke1jDtE.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class StateHolder<T> {
        public ResultCallback<RemoteMediaClient.MediaChannelResult> pendingResultCallback;
        public T value;

        public StateHolder(T t) {
            this.value = t;
        }

        public void clearPendingResultCallback() {
            this.pendingResultCallback = null;
        }

        public boolean acceptsUpdate(ResultCallback<?> resultCallback) {
            return this.pendingResultCallback == resultCallback;
        }
    }
}
