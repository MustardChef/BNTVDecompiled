package com.google.android.exoplayer2.ext.ima;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.p034v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.AdError;
import com.google.ads.interactivemedia.p034v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.p034v3.api.AdEvent;
import com.google.ads.interactivemedia.p034v3.api.AdPodInfo;
import com.google.ads.interactivemedia.p034v3.api.AdsLoader;
import com.google.ads.interactivemedia.p034v3.api.AdsManager;
import com.google.ads.interactivemedia.p034v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.p034v3.api.AdsRequest;
import com.google.ads.interactivemedia.p034v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.p034v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.p034v3.api.player.ContentProgressProvider;
import com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.p034v3.api.player.VideoProgressUpdate;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.TracksInfo;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.ext.ima.ImaUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p036ui.AdOverlayInfo;
import com.google.android.exoplayer2.p036ui.AdViewProvider;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AdTagLoader implements Player.Listener {
    private static final int AD_PROGRESS_UPDATE_INTERVAL_MS = 100;
    private static final int IMA_AD_STATE_NONE = 0;
    private static final int IMA_AD_STATE_PAUSED = 2;
    private static final int IMA_AD_STATE_PLAYING = 1;
    private static final long IMA_DURATION_UNSET = -1;
    private static final String IMA_SDK_SETTINGS_PLAYER_TYPE = "google/exo.ext.ima";
    private static final String IMA_SDK_SETTINGS_PLAYER_VERSION = "2.16.1";
    private static final String TAG = "AdTagLoader";
    private static final long THRESHOLD_AD_MATCH_US = 1000;
    private static final long THRESHOLD_AD_PRELOAD_MS = 4000;
    private static final long THRESHOLD_END_OF_CONTENT_MS = 5000;
    private final List<VideoAdPlayer.VideoAdPlayerCallback> adCallbacks;
    private final AdDisplayContainer adDisplayContainer;
    private final BiMap<AdMediaInfo, AdInfo> adInfoByAdMediaInfo;
    private AdPlaybackState adPlaybackState;
    private final DataSpec adTagDataSpec;
    private final Object adsId;
    private final AdsLoader adsLoader;
    private AdsManager adsManager;
    private boolean bufferingAd;
    private final ComponentListener componentListener;
    private final ImaUtil.Configuration configuration;
    private long contentDurationMs;
    private final List<AdsLoader.EventListener> eventListeners;
    private long fakeContentProgressElapsedRealtimeMs;
    private long fakeContentProgressOffsetMs;
    private final Handler handler;
    private AdInfo imaAdInfo;
    private AdMediaInfo imaAdMediaInfo;
    private int imaAdState;
    private final ImaUtil.ImaFactory imaFactory;
    private boolean imaPausedContent;
    private boolean isAdsManagerInitialized;
    private VideoProgressUpdate lastAdProgress;
    private VideoProgressUpdate lastContentProgress;
    private int lastVolumePercent;
    private AdsMediaSource.AdLoadException pendingAdLoadError;
    private AdInfo pendingAdPrepareErrorAdInfo;
    private Object pendingAdRequestContext;
    private long pendingContentPositionMs;
    private final Timeline.Period period;
    private Player player;
    private boolean playingAd;
    private int playingAdIndexInAdGroup;
    private boolean released;
    private boolean sentContentComplete;
    private boolean sentPendingContentPositionMs;
    private final List<String> supportedMimeTypes;
    private Timeline timeline;
    private final Runnable updateAdProgressRunnable;
    private long waitingForPreloadElapsedRealtimeMs;

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

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onIsPlayingChanged(boolean z) {
        Player.Listener.CC.$default$onIsPlayingChanged(this, z);
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
    public /* synthetic */ void onMetadata(Metadata metadata) {
        Player.Listener.CC.$default$onMetadata(this, metadata);
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

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
        Player.EventListener.CC.$default$onPlayerStateChanged(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        Player.Listener.CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPositionDiscontinuity(int i) {
        Player.EventListener.CC.$default$onPositionDiscontinuity(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onRenderedFirstFrame() {
        Player.Listener.CC.$default$onRenderedFirstFrame(this);
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

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        Player.EventListener.CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTracksInfoChanged(TracksInfo tracksInfo) {
        Player.Listener.CC.$default$onTracksInfoChanged(this, tracksInfo);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
        Player.Listener.CC.$default$onVideoSizeChanged(this, videoSize);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onVolumeChanged(float f) {
        Player.Listener.CC.$default$onVolumeChanged(this, f);
    }

    public AdTagLoader(Context context, ImaUtil.Configuration configuration, ImaUtil.ImaFactory imaFactory, List<String> list, DataSpec dataSpec, Object obj, ViewGroup viewGroup) {
        this.configuration = configuration;
        this.imaFactory = imaFactory;
        ImaSdkSettings imaSdkSettings = configuration.imaSdkSettings;
        if (imaSdkSettings == null) {
            imaSdkSettings = imaFactory.createImaSdkSettings();
            if (configuration.debugModeEnabled) {
                imaSdkSettings.setDebugMode(true);
            }
        }
        imaSdkSettings.setPlayerType(IMA_SDK_SETTINGS_PLAYER_TYPE);
        imaSdkSettings.setPlayerVersion("2.16.1");
        this.supportedMimeTypes = list;
        this.adTagDataSpec = dataSpec;
        this.adsId = obj;
        this.period = new Timeline.Period();
        this.handler = Util.createHandler(ImaUtil.getImaLooper(), null);
        ComponentListener componentListener = new ComponentListener(this, null);
        this.componentListener = componentListener;
        this.eventListeners = new ArrayList();
        ArrayList arrayList = new ArrayList(1);
        this.adCallbacks = arrayList;
        if (configuration.applicationVideoAdPlayerCallback != null) {
            arrayList.add(configuration.applicationVideoAdPlayerCallback);
        }
        this.updateAdProgressRunnable = new Runnable() { // from class: com.google.android.exoplayer2.ext.ima.-$$Lambda$AdTagLoader$Uj28cP-Y4SNtsUVDEaziIVzpb8M
            @Override // java.lang.Runnable
            public final void run() {
                AdTagLoader.this.updateAdProgress();
            }
        };
        this.adInfoByAdMediaInfo = HashBiMap.create();
        this.lastContentProgress = VideoProgressUpdate.VIDEO_TIME_NOT_READY;
        this.lastAdProgress = VideoProgressUpdate.VIDEO_TIME_NOT_READY;
        this.fakeContentProgressElapsedRealtimeMs = C3282C.TIME_UNSET;
        this.fakeContentProgressOffsetMs = C3282C.TIME_UNSET;
        this.pendingContentPositionMs = C3282C.TIME_UNSET;
        this.waitingForPreloadElapsedRealtimeMs = C3282C.TIME_UNSET;
        this.contentDurationMs = C3282C.TIME_UNSET;
        this.timeline = Timeline.EMPTY;
        this.adPlaybackState = AdPlaybackState.NONE;
        if (viewGroup != null) {
            this.adDisplayContainer = imaFactory.createAdDisplayContainer(viewGroup, componentListener);
        } else {
            this.adDisplayContainer = imaFactory.createAudioAdDisplayContainer(context, componentListener);
        }
        if (configuration.companionAdSlots != null) {
            this.adDisplayContainer.setCompanionSlots(configuration.companionAdSlots);
        }
        this.adsLoader = requestAds(context, imaSdkSettings, this.adDisplayContainer);
    }

    public com.google.ads.interactivemedia.p034v3.api.AdsLoader getAdsLoader() {
        return this.adsLoader;
    }

    public AdDisplayContainer getAdDisplayContainer() {
        return this.adDisplayContainer;
    }

    public void skipAd() {
        AdsManager adsManager = this.adsManager;
        if (adsManager != null) {
            adsManager.skip();
        }
    }

    public void focusSkipButton() {
        AdsManager adsManager = this.adsManager;
        if (adsManager != null) {
            adsManager.focus();
        }
    }

    public void addListenerWithAdView(AdsLoader.EventListener eventListener, AdViewProvider adViewProvider) {
        boolean z = !this.eventListeners.isEmpty();
        this.eventListeners.add(eventListener);
        if (z) {
            if (AdPlaybackState.NONE.equals(this.adPlaybackState)) {
                return;
            }
            eventListener.onAdPlaybackState(this.adPlaybackState);
            return;
        }
        this.lastVolumePercent = 0;
        this.lastAdProgress = VideoProgressUpdate.VIDEO_TIME_NOT_READY;
        this.lastContentProgress = VideoProgressUpdate.VIDEO_TIME_NOT_READY;
        maybeNotifyPendingAdLoadError();
        if (!AdPlaybackState.NONE.equals(this.adPlaybackState)) {
            eventListener.onAdPlaybackState(this.adPlaybackState);
        } else {
            AdsManager adsManager = this.adsManager;
            if (adsManager != null) {
                this.adPlaybackState = new AdPlaybackState(this.adsId, ImaUtil.getAdGroupTimesUsForCuePoints(adsManager.getAdCuePoints()));
                updateAdPlaybackState();
            }
        }
        for (AdOverlayInfo adOverlayInfo : adViewProvider.getAdOverlayInfos()) {
            this.adDisplayContainer.registerFriendlyObstruction(this.imaFactory.createFriendlyObstruction(adOverlayInfo.view, ImaUtil.getFriendlyObstructionPurpose(adOverlayInfo.purpose), adOverlayInfo.reasonDetail));
        }
    }

    public void maybePreloadAds(long j, long j2) {
        maybeInitializeAdsManager(j, j2);
    }

    public void activate(Player player) {
        AdInfo adInfo;
        this.player = player;
        player.addListener(this);
        boolean playWhenReady = player.getPlayWhenReady();
        onTimelineChanged(player.getCurrentTimeline(), 1);
        AdsManager adsManager = this.adsManager;
        if (AdPlaybackState.NONE.equals(this.adPlaybackState) || adsManager == null || !this.imaPausedContent) {
            return;
        }
        int adGroupIndexForPositionUs = this.adPlaybackState.getAdGroupIndexForPositionUs(Util.msToUs(getContentPeriodPositionMs(player, this.timeline, this.period)), Util.msToUs(this.contentDurationMs));
        if (adGroupIndexForPositionUs != -1 && (adInfo = this.imaAdInfo) != null && adInfo.adGroupIndex != adGroupIndexForPositionUs) {
            if (this.configuration.debugModeEnabled) {
                String valueOf = String.valueOf(this.imaAdInfo);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
                sb.append("Discarding preloaded ad ");
                sb.append(valueOf);
                Log.m385d(TAG, sb.toString());
            }
            adsManager.discardAdBreak();
        }
        if (playWhenReady) {
            adsManager.resume();
        }
    }

    public void deactivate() {
        Player player = (Player) Assertions.checkNotNull(this.player);
        if (!AdPlaybackState.NONE.equals(this.adPlaybackState) && this.imaPausedContent) {
            AdsManager adsManager = this.adsManager;
            if (adsManager != null) {
                adsManager.pause();
            }
            this.adPlaybackState = this.adPlaybackState.withAdResumePositionUs(this.playingAd ? Util.msToUs(player.getCurrentPosition()) : 0L);
        }
        this.lastVolumePercent = getPlayerVolumePercent();
        this.lastAdProgress = getAdVideoProgressUpdate();
        this.lastContentProgress = getContentVideoProgressUpdate();
        player.removeListener(this);
        this.player = null;
    }

    public void removeListener(AdsLoader.EventListener eventListener) {
        this.eventListeners.remove(eventListener);
        if (this.eventListeners.isEmpty()) {
            this.adDisplayContainer.unregisterAllFriendlyObstructions();
        }
    }

    public void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        this.pendingAdRequestContext = null;
        destroyAdsManager();
        this.adsLoader.removeAdsLoadedListener(this.componentListener);
        this.adsLoader.removeAdErrorListener(this.componentListener);
        if (this.configuration.applicationAdErrorListener != null) {
            this.adsLoader.removeAdErrorListener(this.configuration.applicationAdErrorListener);
        }
        this.adsLoader.release();
        this.imaPausedContent = false;
        this.imaAdState = 0;
        this.imaAdMediaInfo = null;
        stopUpdatingAdProgress();
        this.imaAdInfo = null;
        this.pendingAdLoadError = null;
        for (int i = 0; i < this.adPlaybackState.adGroupCount; i++) {
            this.adPlaybackState = this.adPlaybackState.withSkippedAdGroup(i);
        }
        updateAdPlaybackState();
    }

    public void handlePrepareComplete(int i, int i2) {
        AdInfo adInfo = new AdInfo(i, i2);
        if (this.configuration.debugModeEnabled) {
            String valueOf = String.valueOf(adInfo);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 12);
            sb.append("Prepared ad ");
            sb.append(valueOf);
            Log.m385d(TAG, sb.toString());
        }
        AdMediaInfo adMediaInfo = this.adInfoByAdMediaInfo.inverse().get(adInfo);
        if (adMediaInfo != null) {
            for (int i3 = 0; i3 < this.adCallbacks.size(); i3++) {
                this.adCallbacks.get(i3).onLoaded(adMediaInfo);
            }
            return;
        }
        String valueOf2 = String.valueOf(adInfo);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 23);
        sb2.append("Unexpected prepared ad ");
        sb2.append(valueOf2);
        Log.m379w(TAG, sb2.toString());
    }

    public void handlePrepareError(int i, int i2, IOException iOException) {
        if (this.player == null) {
            return;
        }
        try {
            handleAdPrepareError(i, i2, iOException);
        } catch (RuntimeException e) {
            maybeNotifyInternalError("handlePrepareError", e);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, int i) {
        if (timeline.isEmpty()) {
            return;
        }
        this.timeline = timeline;
        Player player = (Player) Assertions.checkNotNull(this.player);
        long j = timeline.getPeriod(player.getCurrentPeriodIndex(), this.period).durationUs;
        this.contentDurationMs = Util.usToMs(j);
        if (j != this.adPlaybackState.contentDurationUs) {
            this.adPlaybackState = this.adPlaybackState.withContentDurationUs(j);
            updateAdPlaybackState();
        }
        maybeInitializeAdsManager(getContentPeriodPositionMs(player, timeline, this.period), this.contentDurationMs);
        handleTimelineOrPositionChanged();
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        handleTimelineOrPositionChanged();
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackStateChanged(int i) {
        Player player = this.player;
        if (this.adsManager == null || player == null) {
            return;
        }
        if (i == 2 && !player.isPlayingAd() && isWaitingForAdToLoad()) {
            this.waitingForPreloadElapsedRealtimeMs = SystemClock.elapsedRealtime();
        } else if (i == 3) {
            this.waitingForPreloadElapsedRealtimeMs = C3282C.TIME_UNSET;
        }
        handlePlayerStateChanged(player.getPlayWhenReady(), i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onPlayWhenReadyChanged(boolean z, int i) {
        Player player;
        AdsManager adsManager = this.adsManager;
        if (adsManager == null || (player = this.player) == null) {
            return;
        }
        int i2 = this.imaAdState;
        if (i2 == 1 && !z) {
            adsManager.pause();
        } else if (i2 == 2 && z) {
            adsManager.resume();
        } else {
            handlePlayerStateChanged(z, player.getPlaybackState());
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(PlaybackException playbackException) {
        if (this.imaAdState != 0) {
            AdMediaInfo adMediaInfo = (AdMediaInfo) Assertions.checkNotNull(this.imaAdMediaInfo);
            for (int i = 0; i < this.adCallbacks.size(); i++) {
                this.adCallbacks.get(i).onError(adMediaInfo);
            }
        }
    }

    private com.google.ads.interactivemedia.p034v3.api.AdsLoader requestAds(Context context, ImaSdkSettings imaSdkSettings, AdDisplayContainer adDisplayContainer) {
        com.google.ads.interactivemedia.p034v3.api.AdsLoader createAdsLoader = this.imaFactory.createAdsLoader(context, imaSdkSettings, adDisplayContainer);
        createAdsLoader.addAdErrorListener(this.componentListener);
        if (this.configuration.applicationAdErrorListener != null) {
            createAdsLoader.addAdErrorListener(this.configuration.applicationAdErrorListener);
        }
        createAdsLoader.addAdsLoadedListener(this.componentListener);
        try {
            AdsRequest adsRequestForAdTagDataSpec = ImaUtil.getAdsRequestForAdTagDataSpec(this.imaFactory, this.adTagDataSpec);
            Object obj = new Object();
            this.pendingAdRequestContext = obj;
            adsRequestForAdTagDataSpec.setUserRequestContext(obj);
            if (this.configuration.enableContinuousPlayback != null) {
                adsRequestForAdTagDataSpec.setContinuousPlayback(this.configuration.enableContinuousPlayback.booleanValue());
            }
            if (this.configuration.vastLoadTimeoutMs != -1) {
                adsRequestForAdTagDataSpec.setVastLoadTimeout(this.configuration.vastLoadTimeoutMs);
            }
            adsRequestForAdTagDataSpec.setContentProgressProvider(this.componentListener);
            createAdsLoader.requestAds(adsRequestForAdTagDataSpec);
            return createAdsLoader;
        } catch (IOException e) {
            this.adPlaybackState = new AdPlaybackState(this.adsId, new long[0]);
            updateAdPlaybackState();
            this.pendingAdLoadError = AdsMediaSource.AdLoadException.createForAllAds(e);
            maybeNotifyPendingAdLoadError();
            return createAdsLoader;
        }
    }

    private void maybeInitializeAdsManager(long j, long j2) {
        AdsManager adsManager = this.adsManager;
        if (this.isAdsManagerInitialized || adsManager == null) {
            return;
        }
        this.isAdsManagerInitialized = true;
        AdsRenderingSettings adsRenderingSettings = setupAdsRendering(j, j2);
        if (adsRenderingSettings == null) {
            destroyAdsManager();
        } else {
            adsManager.init(adsRenderingSettings);
            adsManager.start();
            if (this.configuration.debugModeEnabled) {
                String valueOf = String.valueOf(adsRenderingSettings);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 41);
                sb.append("Initialized with ads rendering settings: ");
                sb.append(valueOf);
                Log.m385d(TAG, sb.toString());
            }
        }
        updateAdPlaybackState();
    }

    private AdsRenderingSettings setupAdsRendering(long j, long j2) {
        List<String> list;
        AdsRenderingSettings createAdsRenderingSettings = this.imaFactory.createAdsRenderingSettings();
        createAdsRenderingSettings.setEnablePreloading(true);
        if (this.configuration.adMediaMimeTypes != null) {
            list = this.configuration.adMediaMimeTypes;
        } else {
            list = this.supportedMimeTypes;
        }
        createAdsRenderingSettings.setMimeTypes(list);
        if (this.configuration.mediaLoadTimeoutMs != -1) {
            createAdsRenderingSettings.setLoadVideoTimeout(this.configuration.mediaLoadTimeoutMs);
        }
        if (this.configuration.mediaBitrate != -1) {
            createAdsRenderingSettings.setBitrateKbps(this.configuration.mediaBitrate / 1000);
        }
        createAdsRenderingSettings.setFocusSkipButtonWhenAvailable(this.configuration.focusSkipButtonWhenAvailable);
        if (this.configuration.adUiElements != null) {
            createAdsRenderingSettings.setUiElements(this.configuration.adUiElements);
        }
        int adGroupIndexForPositionUs = this.adPlaybackState.getAdGroupIndexForPositionUs(Util.msToUs(j), Util.msToUs(j2));
        if (adGroupIndexForPositionUs != -1) {
            if (!(this.adPlaybackState.getAdGroup(adGroupIndexForPositionUs).timeUs == Util.msToUs(j) || this.configuration.playAdBeforeStartPosition)) {
                adGroupIndexForPositionUs++;
            } else if (hasMidrollAdGroups(this.adPlaybackState)) {
                this.pendingContentPositionMs = j;
            }
            if (adGroupIndexForPositionUs > 0) {
                for (int i = 0; i < adGroupIndexForPositionUs; i++) {
                    this.adPlaybackState = this.adPlaybackState.withSkippedAdGroup(i);
                }
                if (adGroupIndexForPositionUs == this.adPlaybackState.adGroupCount) {
                    return null;
                }
                long j3 = this.adPlaybackState.getAdGroup(adGroupIndexForPositionUs).timeUs;
                long j4 = this.adPlaybackState.getAdGroup(adGroupIndexForPositionUs - 1).timeUs;
                if (j3 == Long.MIN_VALUE) {
                    createAdsRenderingSettings.setPlayAdsAfterTime((j4 / 1000000.0d) + 1.0d);
                } else {
                    createAdsRenderingSettings.setPlayAdsAfterTime(((j3 + j4) / 2.0d) / 1000000.0d);
                }
            }
        }
        return createAdsRenderingSettings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoProgressUpdate getContentVideoProgressUpdate() {
        boolean z = this.contentDurationMs != C3282C.TIME_UNSET;
        long j = this.pendingContentPositionMs;
        if (j != C3282C.TIME_UNSET) {
            this.sentPendingContentPositionMs = true;
        } else {
            Player player = this.player;
            if (player == null) {
                return this.lastContentProgress;
            }
            if (this.fakeContentProgressElapsedRealtimeMs != C3282C.TIME_UNSET) {
                j = this.fakeContentProgressOffsetMs + (SystemClock.elapsedRealtime() - this.fakeContentProgressElapsedRealtimeMs);
            } else if (this.imaAdState == 0 && !this.playingAd && z) {
                j = getContentPeriodPositionMs(player, this.timeline, this.period);
            } else {
                return VideoProgressUpdate.VIDEO_TIME_NOT_READY;
            }
        }
        return new VideoProgressUpdate(j, z ? this.contentDurationMs : -1L);
    }

    private VideoProgressUpdate getAdVideoProgressUpdate() {
        Player player = this.player;
        if (player == null) {
            return this.lastAdProgress;
        }
        if (this.imaAdState != 0 && this.playingAd) {
            long duration = player.getDuration();
            if (duration == C3282C.TIME_UNSET) {
                return VideoProgressUpdate.VIDEO_TIME_NOT_READY;
            }
            return new VideoProgressUpdate(this.player.getCurrentPosition(), duration);
        }
        return VideoProgressUpdate.VIDEO_TIME_NOT_READY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAdProgress() {
        VideoProgressUpdate adVideoProgressUpdate = getAdVideoProgressUpdate();
        if (this.configuration.debugModeEnabled) {
            String valueOf = String.valueOf(ImaUtil.getStringForVideoProgressUpdate(adVideoProgressUpdate));
            Log.m385d(TAG, valueOf.length() != 0 ? "Ad progress: ".concat(valueOf) : new String("Ad progress: "));
        }
        AdMediaInfo adMediaInfo = (AdMediaInfo) Assertions.checkNotNull(this.imaAdMediaInfo);
        for (int i = 0; i < this.adCallbacks.size(); i++) {
            this.adCallbacks.get(i).onAdProgress(adMediaInfo, adVideoProgressUpdate);
        }
        this.handler.removeCallbacks(this.updateAdProgressRunnable);
        this.handler.postDelayed(this.updateAdProgressRunnable, 100L);
    }

    private void stopUpdatingAdProgress() {
        this.handler.removeCallbacks(this.updateAdProgressRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPlayerVolumePercent() {
        Player player = this.player;
        if (player == null) {
            return this.lastVolumePercent;
        }
        if (player.isCommandAvailable(22)) {
            return (int) (player.getVolume() * 100.0f);
        }
        return player.getCurrentTracksInfo().isTypeSelected(1) ? 100 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAdEvent(AdEvent adEvent) {
        int adGroupIndexForCuePointTimeSeconds;
        if (this.adsManager == null) {
            return;
        }
        int i = 0;
        switch (C33531.f9664x68022ad9[adEvent.getType().ordinal()]) {
            case 1:
                String str = (String) Assertions.checkNotNull(adEvent.getAdData().get("adBreakTime"));
                if (this.configuration.debugModeEnabled) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
                    sb.append("Fetch error for ad at ");
                    sb.append(str);
                    sb.append(" seconds");
                    Log.m385d(TAG, sb.toString());
                }
                double parseDouble = Double.parseDouble(str);
                if (parseDouble == -1.0d) {
                    adGroupIndexForCuePointTimeSeconds = this.adPlaybackState.adGroupCount - 1;
                } else {
                    adGroupIndexForCuePointTimeSeconds = getAdGroupIndexForCuePointTimeSeconds(parseDouble);
                }
                markAdGroupInErrorStateAndClearPendingContentPosition(adGroupIndexForCuePointTimeSeconds);
                return;
            case 2:
                this.imaPausedContent = true;
                pauseContentInternal();
                return;
            case 3:
                while (i < this.eventListeners.size()) {
                    this.eventListeners.get(i).onAdTapped();
                    i++;
                }
                return;
            case 4:
                while (i < this.eventListeners.size()) {
                    this.eventListeners.get(i).onAdClicked();
                    i++;
                }
                return;
            case 5:
                this.imaPausedContent = false;
                resumeContentInternal();
                return;
            case 6:
                String valueOf = String.valueOf(adEvent.getAdData());
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 9);
                sb2.append("AdEvent: ");
                sb2.append(valueOf);
                Log.m381i(TAG, sb2.toString());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.ext.ima.AdTagLoader$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C33531 {

        /* renamed from: $SwitchMap$com$google$ads$interactivemedia$v3$api$AdEvent$AdEventType */
        static final /* synthetic */ int[] f9664x68022ad9;

        static {
            int[] iArr = new int[AdEvent.AdEventType.values().length];
            f9664x68022ad9 = iArr;
            try {
                iArr[AdEvent.AdEventType.AD_BREAK_FETCH_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9664x68022ad9[AdEvent.AdEventType.CONTENT_PAUSE_REQUESTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9664x68022ad9[AdEvent.AdEventType.TAPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9664x68022ad9[AdEvent.AdEventType.CLICKED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9664x68022ad9[AdEvent.AdEventType.CONTENT_RESUME_REQUESTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9664x68022ad9[AdEvent.AdEventType.LOG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void pauseContentInternal() {
        this.imaAdState = 0;
        if (this.sentPendingContentPositionMs) {
            this.pendingContentPositionMs = C3282C.TIME_UNSET;
            this.sentPendingContentPositionMs = false;
        }
    }

    private void resumeContentInternal() {
        AdInfo adInfo = this.imaAdInfo;
        if (adInfo != null) {
            this.adPlaybackState = this.adPlaybackState.withSkippedAdGroup(adInfo.adGroupIndex);
            updateAdPlaybackState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isWaitingForAdToLoad() {
        int loadingAdGroupIndex;
        Player player = this.player;
        if (player == null || (loadingAdGroupIndex = getLoadingAdGroupIndex()) == -1) {
            return false;
        }
        AdPlaybackState.AdGroup adGroup = this.adPlaybackState.getAdGroup(loadingAdGroupIndex);
        return (adGroup.count == -1 || adGroup.count == 0 || adGroup.states[0] == 0) && Util.usToMs(adGroup.timeUs) - getContentPeriodPositionMs(player, this.timeline, this.period) < this.configuration.adPreloadTimeoutMs;
    }

    private void handlePlayerStateChanged(boolean z, int i) {
        if (this.playingAd && this.imaAdState == 1) {
            boolean z2 = this.bufferingAd;
            if (!z2 && i == 2) {
                this.bufferingAd = true;
                AdMediaInfo adMediaInfo = (AdMediaInfo) Assertions.checkNotNull(this.imaAdMediaInfo);
                for (int i2 = 0; i2 < this.adCallbacks.size(); i2++) {
                    this.adCallbacks.get(i2).onBuffering(adMediaInfo);
                }
                stopUpdatingAdProgress();
            } else if (z2 && i == 3) {
                this.bufferingAd = false;
                updateAdProgress();
            }
        }
        int i3 = this.imaAdState;
        if (i3 == 0 && i == 2 && z) {
            ensureSentContentCompleteIfAtEndOfStream();
        } else if (i3 != 0 && i == 4) {
            AdMediaInfo adMediaInfo2 = this.imaAdMediaInfo;
            if (adMediaInfo2 == null) {
                Log.m379w(TAG, "onEnded without ad media info");
            } else {
                for (int i4 = 0; i4 < this.adCallbacks.size(); i4++) {
                    this.adCallbacks.get(i4).onEnded(adMediaInfo2);
                }
            }
            if (this.configuration.debugModeEnabled) {
                Log.m385d(TAG, "VideoAdPlayerCallback.onEnded in onPlaybackStateChanged");
            }
        }
    }

    private void handleTimelineOrPositionChanged() {
        Player player = this.player;
        if (this.adsManager == null || player == null) {
            return;
        }
        if (!this.playingAd && !player.isPlayingAd()) {
            ensureSentContentCompleteIfAtEndOfStream();
            if (!this.sentContentComplete && !this.timeline.isEmpty()) {
                long contentPeriodPositionMs = getContentPeriodPositionMs(player, this.timeline, this.period);
                this.timeline.getPeriod(player.getCurrentPeriodIndex(), this.period);
                if (this.period.getAdGroupIndexForPositionUs(Util.msToUs(contentPeriodPositionMs)) != -1) {
                    this.sentPendingContentPositionMs = false;
                    this.pendingContentPositionMs = contentPeriodPositionMs;
                }
            }
        }
        boolean z = this.playingAd;
        int i = this.playingAdIndexInAdGroup;
        boolean isPlayingAd = player.isPlayingAd();
        this.playingAd = isPlayingAd;
        int currentAdIndexInAdGroup = isPlayingAd ? player.getCurrentAdIndexInAdGroup() : -1;
        this.playingAdIndexInAdGroup = currentAdIndexInAdGroup;
        if (z && currentAdIndexInAdGroup != i) {
            AdMediaInfo adMediaInfo = this.imaAdMediaInfo;
            if (adMediaInfo == null) {
                Log.m379w(TAG, "onEnded without ad media info");
            } else {
                AdInfo adInfo = this.adInfoByAdMediaInfo.get(adMediaInfo);
                if (this.playingAdIndexInAdGroup == -1 || (adInfo != null && adInfo.adIndexInAdGroup < this.playingAdIndexInAdGroup)) {
                    for (int i2 = 0; i2 < this.adCallbacks.size(); i2++) {
                        this.adCallbacks.get(i2).onEnded(adMediaInfo);
                    }
                    if (this.configuration.debugModeEnabled) {
                        Log.m385d(TAG, "VideoAdPlayerCallback.onEnded in onTimelineChanged/onPositionDiscontinuity");
                    }
                }
            }
        }
        if (this.sentContentComplete || z || !this.playingAd || this.imaAdState != 0) {
            return;
        }
        AdPlaybackState.AdGroup adGroup = this.adPlaybackState.getAdGroup(player.getCurrentAdGroupIndex());
        if (adGroup.timeUs == Long.MIN_VALUE) {
            sendContentComplete();
            return;
        }
        this.fakeContentProgressElapsedRealtimeMs = SystemClock.elapsedRealtime();
        long usToMs = Util.usToMs(adGroup.timeUs);
        this.fakeContentProgressOffsetMs = usToMs;
        if (usToMs == Long.MIN_VALUE) {
            this.fakeContentProgressOffsetMs = this.contentDurationMs;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdInternal(AdMediaInfo adMediaInfo, AdPodInfo adPodInfo) {
        if (this.adsManager == null) {
            if (this.configuration.debugModeEnabled) {
                String adMediaInfoString = getAdMediaInfoString(adMediaInfo);
                String valueOf = String.valueOf(adPodInfo);
                StringBuilder sb = new StringBuilder(String.valueOf(adMediaInfoString).length() + 30 + String.valueOf(valueOf).length());
                sb.append("loadAd after release ");
                sb.append(adMediaInfoString);
                sb.append(", ad pod ");
                sb.append(valueOf);
                Log.m385d(TAG, sb.toString());
                return;
            }
            return;
        }
        int adGroupIndexForAdPod = getAdGroupIndexForAdPod(adPodInfo);
        int adPosition = adPodInfo.getAdPosition() - 1;
        AdInfo adInfo = new AdInfo(adGroupIndexForAdPod, adPosition);
        this.adInfoByAdMediaInfo.forcePut(adMediaInfo, adInfo);
        if (this.configuration.debugModeEnabled) {
            String valueOf2 = String.valueOf(getAdMediaInfoString(adMediaInfo));
            Log.m385d(TAG, valueOf2.length() != 0 ? "loadAd ".concat(valueOf2) : new String("loadAd "));
        }
        if (this.adPlaybackState.isAdInErrorState(adGroupIndexForAdPod, adPosition)) {
            return;
        }
        AdPlaybackState withAdCount = this.adPlaybackState.withAdCount(adInfo.adGroupIndex, Math.max(adPodInfo.getTotalAds(), this.adPlaybackState.getAdGroup(adInfo.adGroupIndex).states.length));
        this.adPlaybackState = withAdCount;
        AdPlaybackState.AdGroup adGroup = withAdCount.getAdGroup(adInfo.adGroupIndex);
        for (int i = 0; i < adPosition; i++) {
            if (adGroup.states[i] == 0) {
                this.adPlaybackState = this.adPlaybackState.withAdLoadError(adGroupIndexForAdPod, i);
            }
        }
        this.adPlaybackState = this.adPlaybackState.withAdUri(adInfo.adGroupIndex, adInfo.adIndexInAdGroup, Uri.parse(adMediaInfo.getUrl()));
        updateAdPlaybackState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAdInternal(AdMediaInfo adMediaInfo) {
        if (this.configuration.debugModeEnabled) {
            String valueOf = String.valueOf(getAdMediaInfoString(adMediaInfo));
            Log.m385d(TAG, valueOf.length() != 0 ? "playAd ".concat(valueOf) : new String("playAd "));
        }
        if (this.adsManager == null) {
            return;
        }
        if (this.imaAdState == 1) {
            Log.m379w(TAG, "Unexpected playAd without stopAd");
        }
        int i = 0;
        if (this.imaAdState == 0) {
            this.fakeContentProgressElapsedRealtimeMs = C3282C.TIME_UNSET;
            this.fakeContentProgressOffsetMs = C3282C.TIME_UNSET;
            this.imaAdState = 1;
            this.imaAdMediaInfo = adMediaInfo;
            this.imaAdInfo = (AdInfo) Assertions.checkNotNull(this.adInfoByAdMediaInfo.get(adMediaInfo));
            for (int i2 = 0; i2 < this.adCallbacks.size(); i2++) {
                this.adCallbacks.get(i2).onPlay(adMediaInfo);
            }
            AdInfo adInfo = this.pendingAdPrepareErrorAdInfo;
            if (adInfo != null && adInfo.equals(this.imaAdInfo)) {
                this.pendingAdPrepareErrorAdInfo = null;
                while (i < this.adCallbacks.size()) {
                    this.adCallbacks.get(i).onError(adMediaInfo);
                    i++;
                }
            }
            updateAdProgress();
        } else {
            this.imaAdState = 1;
            Assertions.checkState(adMediaInfo.equals(this.imaAdMediaInfo));
            while (i < this.adCallbacks.size()) {
                this.adCallbacks.get(i).onResume(adMediaInfo);
                i++;
            }
        }
        Player player = this.player;
        if (player == null || !player.getPlayWhenReady()) {
            ((AdsManager) Assertions.checkNotNull(this.adsManager)).pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseAdInternal(AdMediaInfo adMediaInfo) {
        if (this.configuration.debugModeEnabled) {
            String valueOf = String.valueOf(getAdMediaInfoString(adMediaInfo));
            Log.m385d(TAG, valueOf.length() != 0 ? "pauseAd ".concat(valueOf) : new String("pauseAd "));
        }
        if (this.adsManager == null || this.imaAdState == 0) {
            return;
        }
        if (this.configuration.debugModeEnabled && !adMediaInfo.equals(this.imaAdMediaInfo)) {
            String adMediaInfoString = getAdMediaInfoString(adMediaInfo);
            String adMediaInfoString2 = getAdMediaInfoString(this.imaAdMediaInfo);
            StringBuilder sb = new StringBuilder(String.valueOf(adMediaInfoString).length() + 34 + String.valueOf(adMediaInfoString2).length());
            sb.append("Unexpected pauseAd for ");
            sb.append(adMediaInfoString);
            sb.append(", expected ");
            sb.append(adMediaInfoString2);
            Log.m379w(TAG, sb.toString());
        }
        this.imaAdState = 2;
        for (int i = 0; i < this.adCallbacks.size(); i++) {
            this.adCallbacks.get(i).onPause(adMediaInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAdInternal(AdMediaInfo adMediaInfo) {
        if (this.configuration.debugModeEnabled) {
            String valueOf = String.valueOf(getAdMediaInfoString(adMediaInfo));
            Log.m385d(TAG, valueOf.length() != 0 ? "stopAd ".concat(valueOf) : new String("stopAd "));
        }
        if (this.adsManager == null) {
            return;
        }
        if (this.imaAdState == 0) {
            AdInfo adInfo = this.adInfoByAdMediaInfo.get(adMediaInfo);
            if (adInfo != null) {
                this.adPlaybackState = this.adPlaybackState.withSkippedAd(adInfo.adGroupIndex, adInfo.adIndexInAdGroup);
                updateAdPlaybackState();
                return;
            }
            return;
        }
        this.imaAdState = 0;
        stopUpdatingAdProgress();
        Assertions.checkNotNull(this.imaAdInfo);
        int i = this.imaAdInfo.adGroupIndex;
        int i2 = this.imaAdInfo.adIndexInAdGroup;
        if (this.adPlaybackState.isAdInErrorState(i, i2)) {
            return;
        }
        this.adPlaybackState = this.adPlaybackState.withPlayedAd(i, i2).withAdResumePositionUs(0L);
        updateAdPlaybackState();
        if (this.playingAd) {
            return;
        }
        this.imaAdMediaInfo = null;
        this.imaAdInfo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAdGroupLoadError(Exception exc) {
        int loadingAdGroupIndex = getLoadingAdGroupIndex();
        if (loadingAdGroupIndex == -1) {
            Log.m378w(TAG, "Unable to determine ad group index for ad group load error", exc);
            return;
        }
        markAdGroupInErrorStateAndClearPendingContentPosition(loadingAdGroupIndex);
        if (this.pendingAdLoadError == null) {
            this.pendingAdLoadError = AdsMediaSource.AdLoadException.createForAdGroup(exc, loadingAdGroupIndex);
        }
    }

    private void markAdGroupInErrorStateAndClearPendingContentPosition(int i) {
        AdPlaybackState.AdGroup adGroup = this.adPlaybackState.getAdGroup(i);
        if (adGroup.count == -1) {
            AdPlaybackState withAdCount = this.adPlaybackState.withAdCount(i, Math.max(1, adGroup.states.length));
            this.adPlaybackState = withAdCount;
            adGroup = withAdCount.getAdGroup(i);
        }
        for (int i2 = 0; i2 < adGroup.count; i2++) {
            if (adGroup.states[i2] == 0) {
                if (this.configuration.debugModeEnabled) {
                    StringBuilder sb = new StringBuilder(47);
                    sb.append("Removing ad ");
                    sb.append(i2);
                    sb.append(" in ad group ");
                    sb.append(i);
                    Log.m385d(TAG, sb.toString());
                }
                this.adPlaybackState = this.adPlaybackState.withAdLoadError(i, i2);
            }
        }
        updateAdPlaybackState();
        this.pendingContentPositionMs = C3282C.TIME_UNSET;
        this.fakeContentProgressElapsedRealtimeMs = C3282C.TIME_UNSET;
    }

    private void handleAdPrepareError(int i, int i2, Exception exc) {
        if (this.configuration.debugModeEnabled) {
            StringBuilder sb = new StringBuilder(53);
            sb.append("Prepare error for ad ");
            sb.append(i2);
            sb.append(" in group ");
            sb.append(i);
            Log.m384d(TAG, sb.toString(), exc);
        }
        if (this.adsManager == null) {
            Log.m379w(TAG, "Ignoring ad prepare error after release");
            return;
        }
        if (this.imaAdState == 0) {
            this.fakeContentProgressElapsedRealtimeMs = SystemClock.elapsedRealtime();
            long usToMs = Util.usToMs(this.adPlaybackState.getAdGroup(i).timeUs);
            this.fakeContentProgressOffsetMs = usToMs;
            if (usToMs == Long.MIN_VALUE) {
                this.fakeContentProgressOffsetMs = this.contentDurationMs;
            }
            this.pendingAdPrepareErrorAdInfo = new AdInfo(i, i2);
        } else {
            AdMediaInfo adMediaInfo = (AdMediaInfo) Assertions.checkNotNull(this.imaAdMediaInfo);
            if (i2 > this.playingAdIndexInAdGroup) {
                for (int i3 = 0; i3 < this.adCallbacks.size(); i3++) {
                    this.adCallbacks.get(i3).onEnded(adMediaInfo);
                }
            }
            this.playingAdIndexInAdGroup = this.adPlaybackState.getAdGroup(i).getFirstAdIndexToPlay();
            for (int i4 = 0; i4 < this.adCallbacks.size(); i4++) {
                this.adCallbacks.get(i4).onError((AdMediaInfo) Assertions.checkNotNull(adMediaInfo));
            }
        }
        this.adPlaybackState = this.adPlaybackState.withAdLoadError(i, i2);
        updateAdPlaybackState();
    }

    private void ensureSentContentCompleteIfAtEndOfStream() {
        if (this.sentContentComplete || this.contentDurationMs == C3282C.TIME_UNSET || this.pendingContentPositionMs != C3282C.TIME_UNSET || getContentPeriodPositionMs((Player) Assertions.checkNotNull(this.player), this.timeline, this.period) + 5000 < this.contentDurationMs) {
            return;
        }
        sendContentComplete();
    }

    private void sendContentComplete() {
        for (int i = 0; i < this.adCallbacks.size(); i++) {
            this.adCallbacks.get(i).onContentComplete();
        }
        this.sentContentComplete = true;
        if (this.configuration.debugModeEnabled) {
            Log.m385d(TAG, "adsLoader.contentComplete");
        }
        for (int i2 = 0; i2 < this.adPlaybackState.adGroupCount; i2++) {
            if (this.adPlaybackState.getAdGroup(i2).timeUs != Long.MIN_VALUE) {
                this.adPlaybackState = this.adPlaybackState.withSkippedAdGroup(i2);
            }
        }
        updateAdPlaybackState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAdPlaybackState() {
        for (int i = 0; i < this.eventListeners.size(); i++) {
            this.eventListeners.get(i).onAdPlaybackState(this.adPlaybackState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyPendingAdLoadError() {
        if (this.pendingAdLoadError != null) {
            for (int i = 0; i < this.eventListeners.size(); i++) {
                this.eventListeners.get(i).onAdLoadError(this.pendingAdLoadError, this.adTagDataSpec);
            }
            this.pendingAdLoadError = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyInternalError(String str, Exception exc) {
        String valueOf = String.valueOf(str);
        String concat = valueOf.length() != 0 ? "Internal error in ".concat(valueOf) : new String("Internal error in ");
        Log.m382e(TAG, concat, exc);
        for (int i = 0; i < this.adPlaybackState.adGroupCount; i++) {
            this.adPlaybackState = this.adPlaybackState.withSkippedAdGroup(i);
        }
        updateAdPlaybackState();
        for (int i2 = 0; i2 < this.eventListeners.size(); i2++) {
            this.eventListeners.get(i2).onAdLoadError(AdsMediaSource.AdLoadException.createForUnexpected(new RuntimeException(concat, exc)), this.adTagDataSpec);
        }
    }

    private int getAdGroupIndexForAdPod(AdPodInfo adPodInfo) {
        if (adPodInfo.getPodIndex() == -1) {
            return this.adPlaybackState.adGroupCount - 1;
        }
        return getAdGroupIndexForCuePointTimeSeconds(adPodInfo.getTimeOffset());
    }

    private int getLoadingAdGroupIndex() {
        Player player = this.player;
        if (player == null) {
            return -1;
        }
        long msToUs = Util.msToUs(getContentPeriodPositionMs(player, this.timeline, this.period));
        int adGroupIndexForPositionUs = this.adPlaybackState.getAdGroupIndexForPositionUs(msToUs, Util.msToUs(this.contentDurationMs));
        return adGroupIndexForPositionUs == -1 ? this.adPlaybackState.getAdGroupIndexAfterPositionUs(msToUs, Util.msToUs(this.contentDurationMs)) : adGroupIndexForPositionUs;
    }

    private int getAdGroupIndexForCuePointTimeSeconds(double d) {
        long round = Math.round(((float) d) * 1000000.0d);
        for (int i = 0; i < this.adPlaybackState.adGroupCount; i++) {
            long j = this.adPlaybackState.getAdGroup(i).timeUs;
            if (j != Long.MIN_VALUE && Math.abs(j - round) < 1000) {
                return i;
            }
        }
        throw new IllegalStateException("Failed to find cue point");
    }

    private String getAdMediaInfoString(AdMediaInfo adMediaInfo) {
        AdInfo adInfo = this.adInfoByAdMediaInfo.get(adMediaInfo);
        String url = adMediaInfo == null ? "null" : adMediaInfo.getUrl();
        String valueOf = String.valueOf(adInfo);
        StringBuilder sb = new StringBuilder(String.valueOf(url).length() + 15 + String.valueOf(valueOf).length());
        sb.append("AdMediaInfo[");
        sb.append(url);
        sb.append(", ");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    private static long getContentPeriodPositionMs(Player player, Timeline timeline, Timeline.Period period) {
        long contentPosition = player.getContentPosition();
        return timeline.isEmpty() ? contentPosition : contentPosition - timeline.getPeriod(player.getCurrentPeriodIndex(), period).getPositionInWindowMs();
    }

    private static boolean hasMidrollAdGroups(AdPlaybackState adPlaybackState) {
        int i = adPlaybackState.adGroupCount;
        if (i != 1) {
            return (i == 2 && adPlaybackState.getAdGroup(0).timeUs == 0 && adPlaybackState.getAdGroup(1).timeUs == Long.MIN_VALUE) ? false : true;
        }
        long j = adPlaybackState.getAdGroup(0).timeUs;
        return (j == 0 || j == Long.MIN_VALUE) ? false : true;
    }

    private void destroyAdsManager() {
        AdsManager adsManager = this.adsManager;
        if (adsManager != null) {
            adsManager.removeAdErrorListener(this.componentListener);
            if (this.configuration.applicationAdErrorListener != null) {
                this.adsManager.removeAdErrorListener(this.configuration.applicationAdErrorListener);
            }
            this.adsManager.removeAdEventListener(this.componentListener);
            if (this.configuration.applicationAdEventListener != null) {
                this.adsManager.removeAdEventListener(this.configuration.applicationAdEventListener);
            }
            this.adsManager.destroy();
            this.adsManager = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ComponentListener implements AdsLoader.AdsLoadedListener, ContentProgressProvider, AdEvent.AdEventListener, AdErrorEvent.AdErrorListener, VideoAdPlayer {
        @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
        public void release() {
        }

        private ComponentListener() {
        }

        /* synthetic */ ComponentListener(AdTagLoader adTagLoader, C33531 c33531) {
            this();
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.AdsLoader.AdsLoadedListener
        public void onAdsManagerLoaded(AdsManagerLoadedEvent adsManagerLoadedEvent) {
            AdsManager adsManager = adsManagerLoadedEvent.getAdsManager();
            if (Util.areEqual(AdTagLoader.this.pendingAdRequestContext, adsManagerLoadedEvent.getUserRequestContext())) {
                AdTagLoader.this.pendingAdRequestContext = null;
                AdTagLoader.this.adsManager = adsManager;
                adsManager.addAdErrorListener(this);
                if (AdTagLoader.this.configuration.applicationAdErrorListener != null) {
                    adsManager.addAdErrorListener(AdTagLoader.this.configuration.applicationAdErrorListener);
                }
                adsManager.addAdEventListener(this);
                if (AdTagLoader.this.configuration.applicationAdEventListener != null) {
                    adsManager.addAdEventListener(AdTagLoader.this.configuration.applicationAdEventListener);
                }
                try {
                    AdTagLoader adTagLoader = AdTagLoader.this;
                    adTagLoader.adPlaybackState = new AdPlaybackState(adTagLoader.adsId, ImaUtil.getAdGroupTimesUsForCuePoints(adsManager.getAdCuePoints()));
                    AdTagLoader.this.updateAdPlaybackState();
                    return;
                } catch (RuntimeException e) {
                    AdTagLoader.this.maybeNotifyInternalError("onAdsManagerLoaded", e);
                    return;
                }
            }
            adsManager.destroy();
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.player.ContentProgressProvider
        public VideoProgressUpdate getContentProgress() {
            VideoProgressUpdate contentVideoProgressUpdate = AdTagLoader.this.getContentVideoProgressUpdate();
            if (AdTagLoader.this.configuration.debugModeEnabled) {
                String valueOf = String.valueOf(ImaUtil.getStringForVideoProgressUpdate(contentVideoProgressUpdate));
                Log.m385d(AdTagLoader.TAG, valueOf.length() != 0 ? "Content progress: ".concat(valueOf) : new String("Content progress: "));
            }
            if (AdTagLoader.this.waitingForPreloadElapsedRealtimeMs != C3282C.TIME_UNSET) {
                if (SystemClock.elapsedRealtime() - AdTagLoader.this.waitingForPreloadElapsedRealtimeMs >= AdTagLoader.THRESHOLD_AD_PRELOAD_MS) {
                    AdTagLoader.this.waitingForPreloadElapsedRealtimeMs = C3282C.TIME_UNSET;
                    AdTagLoader.this.handleAdGroupLoadError(new IOException("Ad preloading timed out"));
                    AdTagLoader.this.maybeNotifyPendingAdLoadError();
                }
            } else if (AdTagLoader.this.pendingContentPositionMs != C3282C.TIME_UNSET && AdTagLoader.this.player != null && AdTagLoader.this.player.getPlaybackState() == 2 && AdTagLoader.this.isWaitingForAdToLoad()) {
                AdTagLoader.this.waitingForPreloadElapsedRealtimeMs = SystemClock.elapsedRealtime();
            }
            return contentVideoProgressUpdate;
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.AdEvent.AdEventListener
        public void onAdEvent(AdEvent adEvent) {
            AdEvent.AdEventType type = adEvent.getType();
            if (AdTagLoader.this.configuration.debugModeEnabled && type != AdEvent.AdEventType.AD_PROGRESS) {
                String valueOf = String.valueOf(type);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 11);
                sb.append("onAdEvent: ");
                sb.append(valueOf);
                Log.m385d(AdTagLoader.TAG, sb.toString());
            }
            try {
                AdTagLoader.this.handleAdEvent(adEvent);
            } catch (RuntimeException e) {
                AdTagLoader.this.maybeNotifyInternalError("onAdEvent", e);
            }
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.AdErrorEvent.AdErrorListener
        public void onAdError(AdErrorEvent adErrorEvent) {
            AdError error = adErrorEvent.getError();
            if (AdTagLoader.this.configuration.debugModeEnabled) {
                Log.m384d(AdTagLoader.TAG, "onAdError", error);
            }
            if (AdTagLoader.this.adsManager == null) {
                AdTagLoader.this.pendingAdRequestContext = null;
                AdTagLoader adTagLoader = AdTagLoader.this;
                adTagLoader.adPlaybackState = new AdPlaybackState(adTagLoader.adsId, new long[0]);
                AdTagLoader.this.updateAdPlaybackState();
            } else if (ImaUtil.isAdGroupLoadError(error)) {
                try {
                    AdTagLoader.this.handleAdGroupLoadError(error);
                } catch (RuntimeException e) {
                    AdTagLoader.this.maybeNotifyInternalError("onAdError", e);
                }
            }
            if (AdTagLoader.this.pendingAdLoadError == null) {
                AdTagLoader.this.pendingAdLoadError = AdsMediaSource.AdLoadException.createForAllAds(error);
            }
            AdTagLoader.this.maybeNotifyPendingAdLoadError();
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
        public void addCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback) {
            AdTagLoader.this.adCallbacks.add(videoAdPlayerCallback);
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
        public void removeCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback) {
            AdTagLoader.this.adCallbacks.remove(videoAdPlayerCallback);
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.player.AdProgressProvider
        public VideoProgressUpdate getAdProgress() {
            throw new IllegalStateException("Unexpected call to getAdProgress when using preloading");
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.player.VolumeProvider
        public int getVolume() {
            return AdTagLoader.this.getPlayerVolumePercent();
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
        public void loadAd(AdMediaInfo adMediaInfo, AdPodInfo adPodInfo) {
            try {
                AdTagLoader.this.loadAdInternal(adMediaInfo, adPodInfo);
            } catch (RuntimeException e) {
                AdTagLoader.this.maybeNotifyInternalError("loadAd", e);
            }
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
        public void playAd(AdMediaInfo adMediaInfo) {
            try {
                AdTagLoader.this.playAdInternal(adMediaInfo);
            } catch (RuntimeException e) {
                AdTagLoader.this.maybeNotifyInternalError("playAd", e);
            }
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
        public void pauseAd(AdMediaInfo adMediaInfo) {
            try {
                AdTagLoader.this.pauseAdInternal(adMediaInfo);
            } catch (RuntimeException e) {
                AdTagLoader.this.maybeNotifyInternalError("pauseAd", e);
            }
        }

        @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
        public void stopAd(AdMediaInfo adMediaInfo) {
            try {
                AdTagLoader.this.stopAdInternal(adMediaInfo);
            } catch (RuntimeException e) {
                AdTagLoader.this.maybeNotifyInternalError("stopAd", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class AdInfo {
        public final int adGroupIndex;
        public final int adIndexInAdGroup;

        public AdInfo(int i, int i2) {
            this.adGroupIndex = i;
            this.adIndexInAdGroup = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AdInfo adInfo = (AdInfo) obj;
            return this.adGroupIndex == adInfo.adGroupIndex && this.adIndexInAdGroup == adInfo.adIndexInAdGroup;
        }

        public int hashCode() {
            return (this.adGroupIndex * 31) + this.adIndexInAdGroup;
        }

        public String toString() {
            int i = this.adGroupIndex;
            int i2 = this.adIndexInAdGroup;
            StringBuilder sb = new StringBuilder(26);
            sb.append("(");
            sb.append(i);
            sb.append(", ");
            sb.append(i2);
            sb.append(')');
            return sb.toString();
        }
    }
}
