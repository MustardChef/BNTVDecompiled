package com.google.android.exoplayer2.ext.ima;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.p034v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.p034v3.api.AdEvent;
import com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.p034v3.api.AdsRequest;
import com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.p034v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.p034v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.p034v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.p034v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.p034v3.api.UiElement;
import com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer;
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
import com.google.android.exoplayer2.ext.ima.ImaUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p036ui.AdViewProvider;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ImaAdsLoader implements Player.Listener, AdsLoader {
    private final HashMap<Object, AdTagLoader> adTagLoaderByAdsId;
    private final HashMap<AdsMediaSource, AdTagLoader> adTagLoaderByAdsMediaSource;
    private final ImaUtil.Configuration configuration;
    private final Context context;
    private AdTagLoader currentAdTagLoader;
    private final ImaUtil.ImaFactory imaFactory;
    private Player nextPlayer;
    private final Timeline.Period period;
    private Player player;
    private List<String> supportedMimeTypes;
    private boolean wasSetPlayerCalled;
    private final Timeline.Window window;

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
    public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
        Player.Listener.CC.$default$onPlayWhenReadyChanged(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        Player.Listener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackStateChanged(int i) {
        Player.Listener.CC.$default$onPlaybackStateChanged(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        Player.Listener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
        Player.Listener.CC.$default$onPlayerError(this, playbackException);
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

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ima");
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public static final long DEFAULT_AD_PRELOAD_TIMEOUT_MS = 10000;
        private AdErrorEvent.AdErrorListener adErrorListener;
        private AdEvent.AdEventListener adEventListener;
        private List<String> adMediaMimeTypes;
        private Set<UiElement> adUiElements;
        private Collection<CompanionAdSlot> companionAdSlots;
        private final Context context;
        private boolean debugModeEnabled;
        private Boolean enableContinuousPlayback;
        private ImaSdkSettings imaSdkSettings;
        private VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback;
        private long adPreloadTimeoutMs = 10000;
        private int vastLoadTimeoutMs = -1;
        private int mediaLoadTimeoutMs = -1;
        private int mediaBitrate = -1;
        private boolean focusSkipButtonWhenAvailable = true;
        private boolean playAdBeforeStartPosition = true;
        private ImaUtil.ImaFactory imaFactory = new DefaultImaFactory();

        public Builder(Context context) {
            this.context = ((Context) Assertions.checkNotNull(context)).getApplicationContext();
        }

        public Builder setImaSdkSettings(ImaSdkSettings imaSdkSettings) {
            this.imaSdkSettings = (ImaSdkSettings) Assertions.checkNotNull(imaSdkSettings);
            return this;
        }

        public Builder setAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
            this.adErrorListener = (AdErrorEvent.AdErrorListener) Assertions.checkNotNull(adErrorListener);
            return this;
        }

        public Builder setAdEventListener(AdEvent.AdEventListener adEventListener) {
            this.adEventListener = (AdEvent.AdEventListener) Assertions.checkNotNull(adEventListener);
            return this;
        }

        public Builder setVideoAdPlayerCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback) {
            this.videoAdPlayerCallback = (VideoAdPlayer.VideoAdPlayerCallback) Assertions.checkNotNull(videoAdPlayerCallback);
            return this;
        }

        public Builder setAdUiElements(Set<UiElement> set) {
            this.adUiElements = ImmutableSet.copyOf((Collection) Assertions.checkNotNull(set));
            return this;
        }

        public Builder setCompanionAdSlots(Collection<CompanionAdSlot> collection) {
            this.companionAdSlots = ImmutableList.copyOf((Collection) Assertions.checkNotNull(collection));
            return this;
        }

        public Builder setAdMediaMimeTypes(List<String> list) {
            this.adMediaMimeTypes = ImmutableList.copyOf((Collection) Assertions.checkNotNull(list));
            return this;
        }

        public Builder setEnableContinuousPlayback(boolean z) {
            this.enableContinuousPlayback = Boolean.valueOf(z);
            return this;
        }

        public Builder setAdPreloadTimeoutMs(long j) {
            Assertions.checkArgument(j == C3282C.TIME_UNSET || j > 0);
            this.adPreloadTimeoutMs = j;
            return this;
        }

        public Builder setVastLoadTimeoutMs(int i) {
            Assertions.checkArgument(i > 0);
            this.vastLoadTimeoutMs = i;
            return this;
        }

        public Builder setMediaLoadTimeoutMs(int i) {
            Assertions.checkArgument(i > 0);
            this.mediaLoadTimeoutMs = i;
            return this;
        }

        public Builder setMaxMediaBitrate(int i) {
            Assertions.checkArgument(i > 0);
            this.mediaBitrate = i;
            return this;
        }

        public Builder setFocusSkipButtonWhenAvailable(boolean z) {
            this.focusSkipButtonWhenAvailable = z;
            return this;
        }

        public Builder setPlayAdBeforeStartPosition(boolean z) {
            this.playAdBeforeStartPosition = z;
            return this;
        }

        public Builder setDebugModeEnabled(boolean z) {
            this.debugModeEnabled = z;
            return this;
        }

        Builder setImaFactory(ImaUtil.ImaFactory imaFactory) {
            this.imaFactory = (ImaUtil.ImaFactory) Assertions.checkNotNull(imaFactory);
            return this;
        }

        public ImaAdsLoader build() {
            return new ImaAdsLoader(this.context, new ImaUtil.Configuration(this.adPreloadTimeoutMs, this.vastLoadTimeoutMs, this.mediaLoadTimeoutMs, this.focusSkipButtonWhenAvailable, this.playAdBeforeStartPosition, this.mediaBitrate, this.enableContinuousPlayback, this.adMediaMimeTypes, this.adUiElements, this.companionAdSlots, this.adErrorListener, this.adEventListener, this.videoAdPlayerCallback, this.imaSdkSettings, this.debugModeEnabled), this.imaFactory);
        }
    }

    private ImaAdsLoader(Context context, ImaUtil.Configuration configuration, ImaUtil.ImaFactory imaFactory) {
        this.context = context.getApplicationContext();
        this.configuration = configuration;
        this.imaFactory = imaFactory;
        this.supportedMimeTypes = ImmutableList.m295of();
        this.adTagLoaderByAdsId = new HashMap<>();
        this.adTagLoaderByAdsMediaSource = new HashMap<>();
        this.period = new Timeline.Period();
        this.window = new Timeline.Window();
    }

    public com.google.ads.interactivemedia.p034v3.api.AdsLoader getAdsLoader() {
        AdTagLoader adTagLoader = this.currentAdTagLoader;
        if (adTagLoader != null) {
            return adTagLoader.getAdsLoader();
        }
        return null;
    }

    public AdDisplayContainer getAdDisplayContainer() {
        AdTagLoader adTagLoader = this.currentAdTagLoader;
        if (adTagLoader != null) {
            return adTagLoader.getAdDisplayContainer();
        }
        return null;
    }

    public void requestAds(DataSpec dataSpec, Object obj, ViewGroup viewGroup) {
        if (this.adTagLoaderByAdsId.containsKey(obj)) {
            return;
        }
        this.adTagLoaderByAdsId.put(obj, new AdTagLoader(this.context, this.configuration, this.imaFactory, this.supportedMimeTypes, dataSpec, obj, viewGroup));
    }

    public void skipAd() {
        AdTagLoader adTagLoader = this.currentAdTagLoader;
        if (adTagLoader != null) {
            adTagLoader.skipAd();
        }
    }

    public void focusSkipButton() {
        AdTagLoader adTagLoader = this.currentAdTagLoader;
        if (adTagLoader != null) {
            adTagLoader.focusSkipButton();
        }
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void setPlayer(Player player) {
        boolean z = false;
        Assertions.checkState(Looper.myLooper() == ImaUtil.getImaLooper());
        Assertions.checkState((player == null || player.getApplicationLooper() == ImaUtil.getImaLooper()) ? true : true);
        this.nextPlayer = player;
        this.wasSetPlayerCalled = true;
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void setSupportedContentTypes(int... iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i == 0) {
                arrayList.add(MimeTypes.APPLICATION_MPD);
            } else if (i == 2) {
                arrayList.add(MimeTypes.APPLICATION_M3U8);
            } else if (i == 4) {
                arrayList.addAll(Arrays.asList(MimeTypes.VIDEO_MP4, MimeTypes.VIDEO_WEBM, MimeTypes.VIDEO_H263, MimeTypes.AUDIO_MP4, MimeTypes.AUDIO_MPEG));
            }
        }
        this.supportedMimeTypes = Collections.unmodifiableList(arrayList);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void start(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, AdsLoader.EventListener eventListener) {
        Assertions.checkState(this.wasSetPlayerCalled, "Set player using adsLoader.setPlayer before preparing the player.");
        if (this.adTagLoaderByAdsMediaSource.isEmpty()) {
            Player player = this.nextPlayer;
            this.player = player;
            if (player == null) {
                return;
            }
            player.addListener(this);
        }
        AdTagLoader adTagLoader = this.adTagLoaderByAdsId.get(obj);
        if (adTagLoader == null) {
            requestAds(dataSpec, obj, adViewProvider.getAdViewGroup());
            adTagLoader = this.adTagLoaderByAdsId.get(obj);
        }
        this.adTagLoaderByAdsMediaSource.put(adsMediaSource, (AdTagLoader) Assertions.checkNotNull(adTagLoader));
        adTagLoader.addListenerWithAdView(eventListener, adViewProvider);
        maybeUpdateCurrentAdTagLoader();
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void stop(AdsMediaSource adsMediaSource, AdsLoader.EventListener eventListener) {
        AdTagLoader remove = this.adTagLoaderByAdsMediaSource.remove(adsMediaSource);
        maybeUpdateCurrentAdTagLoader();
        if (remove != null) {
            remove.removeListener(eventListener);
        }
        if (this.player == null || !this.adTagLoaderByAdsMediaSource.isEmpty()) {
            return;
        }
        this.player.removeListener(this);
        this.player = null;
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void release() {
        Player player = this.player;
        if (player != null) {
            player.removeListener(this);
            this.player = null;
            maybeUpdateCurrentAdTagLoader();
        }
        this.nextPlayer = null;
        for (AdTagLoader adTagLoader : this.adTagLoaderByAdsMediaSource.values()) {
            adTagLoader.release();
        }
        this.adTagLoaderByAdsMediaSource.clear();
        for (AdTagLoader adTagLoader2 : this.adTagLoaderByAdsId.values()) {
            adTagLoader2.release();
        }
        this.adTagLoaderByAdsId.clear();
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void handlePrepareComplete(AdsMediaSource adsMediaSource, int i, int i2) {
        if (this.player == null) {
            return;
        }
        ((AdTagLoader) Assertions.checkNotNull(this.adTagLoaderByAdsMediaSource.get(adsMediaSource))).handlePrepareComplete(i, i2);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void handlePrepareError(AdsMediaSource adsMediaSource, int i, int i2, IOException iOException) {
        if (this.player == null) {
            return;
        }
        ((AdTagLoader) Assertions.checkNotNull(this.adTagLoaderByAdsMediaSource.get(adsMediaSource))).handlePrepareError(i, i2, iOException);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, int i) {
        if (timeline.isEmpty()) {
            return;
        }
        maybeUpdateCurrentAdTagLoader();
        maybePreloadNextPeriodAds();
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        maybeUpdateCurrentAdTagLoader();
        maybePreloadNextPeriodAds();
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onShuffleModeEnabledChanged(boolean z) {
        maybePreloadNextPeriodAds();
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onRepeatModeChanged(int i) {
        maybePreloadNextPeriodAds();
    }

    private void maybeUpdateCurrentAdTagLoader() {
        AdTagLoader adTagLoader = this.currentAdTagLoader;
        AdTagLoader currentAdTagLoader = getCurrentAdTagLoader();
        if (Util.areEqual(adTagLoader, currentAdTagLoader)) {
            return;
        }
        if (adTagLoader != null) {
            adTagLoader.deactivate();
        }
        this.currentAdTagLoader = currentAdTagLoader;
        if (currentAdTagLoader != null) {
            currentAdTagLoader.activate((Player) Assertions.checkNotNull(this.player));
        }
    }

    private AdTagLoader getCurrentAdTagLoader() {
        Object adsId;
        AdTagLoader adTagLoader;
        Player player = this.player;
        if (player == null) {
            return null;
        }
        Timeline currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty() || (adsId = currentTimeline.getPeriod(player.getCurrentPeriodIndex(), this.period).getAdsId()) == null || (adTagLoader = this.adTagLoaderByAdsId.get(adsId)) == null || !this.adTagLoaderByAdsMediaSource.containsValue(adTagLoader)) {
            return null;
        }
        return adTagLoader;
    }

    private void maybePreloadNextPeriodAds() {
        int nextPeriodIndex;
        AdTagLoader adTagLoader;
        Player player = this.player;
        if (player == null) {
            return;
        }
        Timeline currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty() || (nextPeriodIndex = currentTimeline.getNextPeriodIndex(player.getCurrentPeriodIndex(), this.period, this.window, player.getRepeatMode(), player.getShuffleModeEnabled())) == -1) {
            return;
        }
        currentTimeline.getPeriod(nextPeriodIndex, this.period);
        Object adsId = this.period.getAdsId();
        if (adsId == null || (adTagLoader = this.adTagLoaderByAdsId.get(adsId)) == null || adTagLoader == this.currentAdTagLoader) {
            return;
        }
        Timeline.Window window = this.window;
        Timeline.Period period = this.period;
        adTagLoader.maybePreloadAds(Util.usToMs(((Long) currentTimeline.getPeriodPosition(window, period, period.windowIndex, C3282C.TIME_UNSET).second).longValue()), Util.usToMs(this.period.durationUs));
    }

    /* loaded from: classes2.dex */
    private static final class DefaultImaFactory implements ImaUtil.ImaFactory {
        private DefaultImaFactory() {
        }

        @Override // com.google.android.exoplayer2.ext.ima.ImaUtil.ImaFactory
        public ImaSdkSettings createImaSdkSettings() {
            ImaSdkSettings createImaSdkSettings = ImaSdkFactory.getInstance().createImaSdkSettings();
            createImaSdkSettings.setLanguage(Util.getSystemLanguageCodes()[0]);
            return createImaSdkSettings;
        }

        @Override // com.google.android.exoplayer2.ext.ima.ImaUtil.ImaFactory
        public AdsRenderingSettings createAdsRenderingSettings() {
            return ImaSdkFactory.getInstance().createAdsRenderingSettings();
        }

        @Override // com.google.android.exoplayer2.ext.ima.ImaUtil.ImaFactory
        public AdDisplayContainer createAdDisplayContainer(ViewGroup viewGroup, VideoAdPlayer videoAdPlayer) {
            return ImaSdkFactory.createAdDisplayContainer(viewGroup, videoAdPlayer);
        }

        @Override // com.google.android.exoplayer2.ext.ima.ImaUtil.ImaFactory
        public AdDisplayContainer createAudioAdDisplayContainer(Context context, VideoAdPlayer videoAdPlayer) {
            return ImaSdkFactory.createAudioAdDisplayContainer(context, videoAdPlayer);
        }

        @Override // com.google.android.exoplayer2.ext.ima.ImaUtil.ImaFactory
        public FriendlyObstruction createFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
            return ImaSdkFactory.getInstance().createFriendlyObstruction(view, friendlyObstructionPurpose, str);
        }

        @Override // com.google.android.exoplayer2.ext.ima.ImaUtil.ImaFactory
        public AdsRequest createAdsRequest() {
            return ImaSdkFactory.getInstance().createAdsRequest();
        }

        @Override // com.google.android.exoplayer2.ext.ima.ImaUtil.ImaFactory
        public com.google.ads.interactivemedia.p034v3.api.AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, AdDisplayContainer adDisplayContainer) {
            return ImaSdkFactory.getInstance().createAdsLoader(context, imaSdkSettings, adDisplayContainer);
        }
    }
}
