package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.common.base.Supplier;
import java.util.List;

/* loaded from: classes2.dex */
public interface ExoPlayer extends Player {
    public static final long DEFAULT_DETACH_SURFACE_TIMEOUT_MS = 2000;
    public static final long DEFAULT_RELEASE_TIMEOUT_MS = 500;

    @Deprecated
    /* loaded from: classes2.dex */
    public interface AudioComponent {
        @Deprecated
        void clearAuxEffectInfo();

        @Deprecated
        AudioAttributes getAudioAttributes();

        @Deprecated
        int getAudioSessionId();

        @Deprecated
        boolean getSkipSilenceEnabled();

        @Deprecated
        float getVolume();

        @Deprecated
        void setAudioAttributes(AudioAttributes audioAttributes, boolean z);

        @Deprecated
        void setAudioSessionId(int i);

        @Deprecated
        void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

        @Deprecated
        void setSkipSilenceEnabled(boolean z);

        @Deprecated
        void setVolume(float f);
    }

    /* loaded from: classes2.dex */
    public interface AudioOffloadListener {

        /* renamed from: com.google.android.exoplayer2.ExoPlayer$AudioOffloadListener$-CC  reason: invalid class name */
        /* loaded from: classes2.dex */
        public final /* synthetic */ class CC {
            public static void $default$onExperimentalOffloadSchedulingEnabledChanged(AudioOffloadListener audioOffloadListener, boolean z) {
            }

            public static void $default$onExperimentalSleepingForOffloadChanged(AudioOffloadListener audioOffloadListener, boolean z) {
            }
        }

        void onExperimentalOffloadSchedulingEnabledChanged(boolean z);

        void onExperimentalSleepingForOffloadChanged(boolean z);
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface DeviceComponent {
        @Deprecated
        void decreaseDeviceVolume();

        @Deprecated
        DeviceInfo getDeviceInfo();

        @Deprecated
        int getDeviceVolume();

        @Deprecated
        void increaseDeviceVolume();

        @Deprecated
        boolean isDeviceMuted();

        @Deprecated
        void setDeviceMuted(boolean z);

        @Deprecated
        void setDeviceVolume(int i);
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface TextComponent {
        @Deprecated
        List<Cue> getCurrentCues();
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface VideoComponent {
        @Deprecated
        void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

        @Deprecated
        void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void clearVideoSurface();

        @Deprecated
        void clearVideoSurface(Surface surface);

        @Deprecated
        void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder);

        @Deprecated
        void clearVideoSurfaceView(SurfaceView surfaceView);

        @Deprecated
        void clearVideoTextureView(TextureView textureView);

        @Deprecated
        int getVideoChangeFrameRateStrategy();

        @Deprecated
        int getVideoScalingMode();

        @Deprecated
        VideoSize getVideoSize();

        @Deprecated
        void setCameraMotionListener(CameraMotionListener cameraMotionListener);

        @Deprecated
        void setVideoChangeFrameRateStrategy(int i);

        @Deprecated
        void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void setVideoScalingMode(int i);

        @Deprecated
        void setVideoSurface(Surface surface);

        @Deprecated
        void setVideoSurfaceHolder(SurfaceHolder surfaceHolder);

        @Deprecated
        void setVideoSurfaceView(SurfaceView surfaceView);

        @Deprecated
        void setVideoTextureView(TextureView textureView);
    }

    void addAnalyticsListener(AnalyticsListener analyticsListener);

    void addAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    @Deprecated
    void addListener(Player.EventListener eventListener);

    void addMediaSource(int i, MediaSource mediaSource);

    void addMediaSource(MediaSource mediaSource);

    void addMediaSources(int i, List<MediaSource> list);

    void addMediaSources(List<MediaSource> list);

    void clearAuxEffectInfo();

    void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

    void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    PlayerMessage createMessage(PlayerMessage.Target target);

    boolean experimentalIsSleepingForOffload();

    void experimentalSetOffloadSchedulingEnabled(boolean z);

    AnalyticsCollector getAnalyticsCollector();

    @Deprecated
    AudioComponent getAudioComponent();

    DecoderCounters getAudioDecoderCounters();

    Format getAudioFormat();

    int getAudioSessionId();

    Clock getClock();

    @Deprecated
    DeviceComponent getDeviceComponent();

    boolean getPauseAtEndOfMediaItems();

    Looper getPlaybackLooper();

    @Override // com.google.android.exoplayer2.Player
    ExoPlaybackException getPlayerError();

    int getRendererCount();

    int getRendererType(int i);

    SeekParameters getSeekParameters();

    boolean getSkipSilenceEnabled();

    @Deprecated
    TextComponent getTextComponent();

    TrackSelector getTrackSelector();

    int getVideoChangeFrameRateStrategy();

    @Deprecated
    VideoComponent getVideoComponent();

    DecoderCounters getVideoDecoderCounters();

    Format getVideoFormat();

    int getVideoScalingMode();

    @Deprecated
    void prepare(MediaSource mediaSource);

    @Deprecated
    void prepare(MediaSource mediaSource, boolean z, boolean z2);

    void removeAnalyticsListener(AnalyticsListener analyticsListener);

    void removeAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    @Deprecated
    void removeListener(Player.EventListener eventListener);

    @Deprecated
    void retry();

    void setAudioAttributes(AudioAttributes audioAttributes, boolean z);

    void setAudioSessionId(int i);

    void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

    void setCameraMotionListener(CameraMotionListener cameraMotionListener);

    void setForegroundMode(boolean z);

    void setHandleAudioBecomingNoisy(boolean z);

    @Deprecated
    void setHandleWakeLock(boolean z);

    void setMediaSource(MediaSource mediaSource);

    void setMediaSource(MediaSource mediaSource, long j);

    void setMediaSource(MediaSource mediaSource, boolean z);

    void setMediaSources(List<MediaSource> list);

    void setMediaSources(List<MediaSource> list, int i, long j);

    void setMediaSources(List<MediaSource> list, boolean z);

    void setPauseAtEndOfMediaItems(boolean z);

    void setPriorityTaskManager(PriorityTaskManager priorityTaskManager);

    void setSeekParameters(SeekParameters seekParameters);

    void setShuffleOrder(ShuffleOrder shuffleOrder);

    void setSkipSilenceEnabled(boolean z);

    @Deprecated
    void setThrowsWhenUsingWrongThread(boolean z);

    void setVideoChangeFrameRateStrategy(int i);

    void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    void setVideoScalingMode(int i);

    void setWakeMode(int i);

    /* renamed from: com.google.android.exoplayer2.ExoPlayer$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        Supplier<AnalyticsCollector> analyticsCollectorSupplier;
        AudioAttributes audioAttributes;
        Supplier<BandwidthMeter> bandwidthMeterSupplier;
        boolean buildCalled;
        Clock clock;
        final Context context;
        long detachSurfaceTimeoutMs;
        long foregroundModeTimeoutMs;
        boolean handleAudioBecomingNoisy;
        boolean handleAudioFocus;
        LivePlaybackSpeedControl livePlaybackSpeedControl;
        Supplier<LoadControl> loadControlSupplier;
        Looper looper;
        Supplier<MediaSourceFactory> mediaSourceFactorySupplier;
        boolean pauseAtEndOfMediaItems;
        PriorityTaskManager priorityTaskManager;
        long releaseTimeoutMs;
        Supplier<RenderersFactory> renderersFactorySupplier;
        long seekBackIncrementMs;
        long seekForwardIncrementMs;
        SeekParameters seekParameters;
        boolean skipSilenceEnabled;
        Supplier<TrackSelector> trackSelectorSupplier;
        boolean useLazyPreparation;
        int videoChangeFrameRateStrategy;
        int videoScalingMode;
        int wakeMode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ TrackSelector lambda$new$10(TrackSelector trackSelector) {
            return trackSelector;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ LoadControl lambda$new$11(LoadControl loadControl) {
            return loadControl;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ BandwidthMeter lambda$new$12(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ AnalyticsCollector lambda$new$13(AnalyticsCollector analyticsCollector) {
            return analyticsCollector;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ RenderersFactory lambda$new$2(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ MediaSourceFactory lambda$new$5(MediaSourceFactory mediaSourceFactory) {
            return mediaSourceFactory;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ RenderersFactory lambda$new$6(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ MediaSourceFactory lambda$new$7(MediaSourceFactory mediaSourceFactory) {
            return mediaSourceFactory;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ RenderersFactory lambda$new$8(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ MediaSourceFactory lambda$new$9(MediaSourceFactory mediaSourceFactory) {
            return mediaSourceFactory;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ AnalyticsCollector lambda$setAnalyticsCollector$22(AnalyticsCollector analyticsCollector) {
            return analyticsCollector;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ BandwidthMeter lambda$setBandwidthMeter$21(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ LoadControl lambda$setLoadControl$20(LoadControl loadControl) {
            return loadControl;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ MediaSourceFactory lambda$setMediaSourceFactory$18(MediaSourceFactory mediaSourceFactory) {
            return mediaSourceFactory;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ RenderersFactory lambda$setRenderersFactory$17(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ TrackSelector lambda$setTrackSelector$19(TrackSelector trackSelector) {
            return trackSelector;
        }

        public Builder(final Context context) {
            this(context, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$Hq25N4QETpUymWCg70DLpzhHWhs
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$0(context);
                }
            }, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$gb4jgpJhXYOlsAi9aXNjytItYTE
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$1(context);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ RenderersFactory lambda$new$0(Context context) {
            return new DefaultRenderersFactory(context);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ MediaSourceFactory lambda$new$1(Context context) {
            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
        }

        public Builder(final Context context, final RenderersFactory renderersFactory) {
            this(context, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$wgX52bOwJN_SxWy-wq4KmaBRPbk
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$2(RenderersFactory.this);
                }
            }, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$sq1fE5SicIidCQgqmJp-rK6K9AQ
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$3(context);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ MediaSourceFactory lambda$new$3(Context context) {
            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
        }

        public Builder(final Context context, final MediaSourceFactory mediaSourceFactory) {
            this(context, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$cE0gQaOEGre8JbWgQcbqLA9QzwU
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$4(context);
                }
            }, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$xtGJEq_JUxVuGsC4a11PwS5hK3s
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$5(MediaSourceFactory.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ RenderersFactory lambda$new$4(Context context) {
            return new DefaultRenderersFactory(context);
        }

        public Builder(Context context, final RenderersFactory renderersFactory, final MediaSourceFactory mediaSourceFactory) {
            this(context, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$-20PXyNKLUvSsFndoLKShjDf3xg
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$6(RenderersFactory.this);
                }
            }, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$wWN4ZKMQtjFishtl4NlUuB9IVvU
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$7(MediaSourceFactory.this);
                }
            });
        }

        public Builder(Context context, final RenderersFactory renderersFactory, final MediaSourceFactory mediaSourceFactory, final TrackSelector trackSelector, final LoadControl loadControl, final BandwidthMeter bandwidthMeter, final AnalyticsCollector analyticsCollector) {
            this(context, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$_vjDsacr1VX7EACpX86I7y_s60A
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$8(RenderersFactory.this);
                }
            }, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$QOKDdRoXYy0ihDGRTxJ0aYi6C9c
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$9(MediaSourceFactory.this);
                }
            }, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$jomvW7jCElzwjkby_I-IEkKNkNU
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$10(TrackSelector.this);
                }
            }, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$C-5Ffb4z3uoaL1oyuSYPz9pS68g
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$11(LoadControl.this);
                }
            }, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$vV2ws6spu9HrllkAonla3cX5pAE
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$12(BandwidthMeter.this);
                }
            }, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$kTsitbT6AzZXGzRsceCmiDsBBnI
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$13(AnalyticsCollector.this);
                }
            });
        }

        private Builder(final Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSourceFactory> supplier2) {
            this(context, supplier, supplier2, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$VJChOQKhf8DO5Hd-j4AFJoKd82c
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$new$14(context);
                }
            }, $$Lambda$A5vWwxwB6PLyKjOomyZpgFGPiMI.INSTANCE, new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$BYXub_ihc_-ya6fF9TdbhhGDr50
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    BandwidthMeter singletonInstance;
                    singletonInstance = DefaultBandwidthMeter.getSingletonInstance(context);
                    return singletonInstance;
                }
            }, (Supplier<AnalyticsCollector>) null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ TrackSelector lambda$new$14(Context context) {
            return new DefaultTrackSelector(context);
        }

        private Builder(Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSourceFactory> supplier2, Supplier<TrackSelector> supplier3, Supplier<LoadControl> supplier4, Supplier<BandwidthMeter> supplier5, Supplier<AnalyticsCollector> supplier6) {
            this.context = context;
            this.renderersFactorySupplier = supplier;
            this.mediaSourceFactorySupplier = supplier2;
            this.trackSelectorSupplier = supplier3;
            this.loadControlSupplier = supplier4;
            this.bandwidthMeterSupplier = supplier5;
            this.analyticsCollectorSupplier = supplier6 == null ? new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$vWLSKjcwJsClT86BqJCO3sF9yT0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.this.lambda$new$16$ExoPlayer$Builder();
                }
            } : supplier6;
            this.looper = Util.getCurrentOrMainLooper();
            this.audioAttributes = AudioAttributes.DEFAULT;
            this.wakeMode = 0;
            this.videoScalingMode = 1;
            this.videoChangeFrameRateStrategy = 0;
            this.useLazyPreparation = true;
            this.seekParameters = SeekParameters.DEFAULT;
            this.seekBackIncrementMs = 5000L;
            this.seekForwardIncrementMs = C3282C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
            this.livePlaybackSpeedControl = new DefaultLivePlaybackSpeedControl.Builder().build();
            this.clock = Clock.DEFAULT;
            this.releaseTimeoutMs = 500L;
            this.detachSurfaceTimeoutMs = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        }

        public /* synthetic */ AnalyticsCollector lambda$new$16$ExoPlayer$Builder() {
            return new AnalyticsCollector((Clock) Assertions.checkNotNull(this.clock));
        }

        public Builder experimentalSetForegroundModeTimeoutMs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.foregroundModeTimeoutMs = j;
            return this;
        }

        public Builder setRenderersFactory(final RenderersFactory renderersFactory) {
            Assertions.checkState(!this.buildCalled);
            this.renderersFactorySupplier = new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$2XqihFO2mzZBpMHIkrUv0dXN1Gw
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$setRenderersFactory$17(RenderersFactory.this);
                }
            };
            return this;
        }

        public Builder setMediaSourceFactory(final MediaSourceFactory mediaSourceFactory) {
            Assertions.checkState(!this.buildCalled);
            this.mediaSourceFactorySupplier = new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$-RLRy3nPFaycfQCv2hYtcmTA8mg
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$setMediaSourceFactory$18(MediaSourceFactory.this);
                }
            };
            return this;
        }

        public Builder setTrackSelector(final TrackSelector trackSelector) {
            Assertions.checkState(!this.buildCalled);
            this.trackSelectorSupplier = new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$RYwIwTeu50scpSuZsVNDzVFwr60
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$setTrackSelector$19(TrackSelector.this);
                }
            };
            return this;
        }

        public Builder setLoadControl(final LoadControl loadControl) {
            Assertions.checkState(!this.buildCalled);
            this.loadControlSupplier = new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$9hlAh6cs3hgJlw7DN7aVYdEydys
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$setLoadControl$20(LoadControl.this);
                }
            };
            return this;
        }

        public Builder setBandwidthMeter(final BandwidthMeter bandwidthMeter) {
            Assertions.checkState(!this.buildCalled);
            this.bandwidthMeterSupplier = new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$1q5jzMPfSnX0RZ2moRnlzmOsxHw
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$setBandwidthMeter$21(BandwidthMeter.this);
                }
            };
            return this;
        }

        public Builder setLooper(Looper looper) {
            Assertions.checkState(!this.buildCalled);
            this.looper = looper;
            return this;
        }

        public Builder setAnalyticsCollector(final AnalyticsCollector analyticsCollector) {
            Assertions.checkState(!this.buildCalled);
            this.analyticsCollectorSupplier = new Supplier() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayer$Builder$EMszQg-7UyQGqIJTHJunP0Ae9BA
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.lambda$setAnalyticsCollector$22(AnalyticsCollector.this);
                }
            };
            return this;
        }

        public Builder setPriorityTaskManager(PriorityTaskManager priorityTaskManager) {
            Assertions.checkState(!this.buildCalled);
            this.priorityTaskManager = priorityTaskManager;
            return this;
        }

        public Builder setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.audioAttributes = audioAttributes;
            this.handleAudioFocus = z;
            return this;
        }

        public Builder setWakeMode(int i) {
            Assertions.checkState(!this.buildCalled);
            this.wakeMode = i;
            return this;
        }

        public Builder setHandleAudioBecomingNoisy(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.handleAudioBecomingNoisy = z;
            return this;
        }

        public Builder setSkipSilenceEnabled(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.skipSilenceEnabled = z;
            return this;
        }

        public Builder setVideoScalingMode(int i) {
            Assertions.checkState(!this.buildCalled);
            this.videoScalingMode = i;
            return this;
        }

        public Builder setVideoChangeFrameRateStrategy(int i) {
            Assertions.checkState(!this.buildCalled);
            this.videoChangeFrameRateStrategy = i;
            return this;
        }

        public Builder setUseLazyPreparation(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.useLazyPreparation = z;
            return this;
        }

        public Builder setSeekParameters(SeekParameters seekParameters) {
            Assertions.checkState(!this.buildCalled);
            this.seekParameters = seekParameters;
            return this;
        }

        public Builder setSeekBackIncrementMs(long j) {
            Assertions.checkArgument(j > 0);
            Assertions.checkState(true ^ this.buildCalled);
            this.seekBackIncrementMs = j;
            return this;
        }

        public Builder setSeekForwardIncrementMs(long j) {
            Assertions.checkArgument(j > 0);
            Assertions.checkState(true ^ this.buildCalled);
            this.seekForwardIncrementMs = j;
            return this;
        }

        public Builder setReleaseTimeoutMs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.releaseTimeoutMs = j;
            return this;
        }

        public Builder setDetachSurfaceTimeoutMs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.detachSurfaceTimeoutMs = j;
            return this;
        }

        public Builder setPauseAtEndOfMediaItems(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.pauseAtEndOfMediaItems = z;
            return this;
        }

        public Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            Assertions.checkState(!this.buildCalled);
            this.livePlaybackSpeedControl = livePlaybackSpeedControl;
            return this;
        }

        public Builder setClock(Clock clock) {
            Assertions.checkState(!this.buildCalled);
            this.clock = clock;
            return this;
        }

        public ExoPlayer build() {
            return buildSimpleExoPlayer();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SimpleExoPlayer buildSimpleExoPlayer() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new SimpleExoPlayer(this);
        }
    }
}
