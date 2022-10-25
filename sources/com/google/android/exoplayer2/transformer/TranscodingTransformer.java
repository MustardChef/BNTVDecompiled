package com.google.android.exoplayer2.transformer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.TracksInfo;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.transformer.FrameworkMuxer;
import com.google.android.exoplayer2.transformer.Muxer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes2.dex */
public final class TranscodingTransformer {
    public static final int PROGRESS_STATE_AVAILABLE = 1;
    public static final int PROGRESS_STATE_NO_TRANSFORMATION = 4;
    public static final int PROGRESS_STATE_UNAVAILABLE = 2;
    public static final int PROGRESS_STATE_WAITING_FOR_AVAILABILITY = 0;
    private final Clock clock;
    private final Context context;
    private Listener listener;
    private final Looper looper;
    private final MediaSourceFactory mediaSourceFactory;
    private final Muxer.Factory muxerFactory;
    private MuxerWrapper muxerWrapper;
    private ExoPlayer player;
    private int progressState;
    private final Transformation transformation;

    /* loaded from: classes2.dex */
    public interface Listener {

        /* renamed from: com.google.android.exoplayer2.transformer.TranscodingTransformer$Listener$-CC  reason: invalid class name */
        /* loaded from: classes2.dex */
        public final /* synthetic */ class CC {
            public static void $default$onTransformationCompleted(Listener listener, MediaItem mediaItem) {
            }

            public static void $default$onTransformationError(Listener listener, MediaItem mediaItem, Exception exc) {
            }
        }

        void onTransformationCompleted(MediaItem mediaItem);

        void onTransformationError(MediaItem mediaItem, Exception exc);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ProgressState {
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private String audioMimeType;
        private Clock clock;
        private Context context;
        private boolean flattenForSlowMotion;
        private Listener listener;
        private Looper looper;
        private MediaSourceFactory mediaSourceFactory;
        private Muxer.Factory muxerFactory;
        private String outputMimeType;
        private boolean removeAudio;
        private boolean removeVideo;
        private String videoMimeType;

        public Builder() {
            this.muxerFactory = new FrameworkMuxer.Factory();
            this.outputMimeType = MimeTypes.VIDEO_MP4;
            this.listener = new Listener(this) { // from class: com.google.android.exoplayer2.transformer.TranscodingTransformer.Builder.1
                @Override // com.google.android.exoplayer2.transformer.TranscodingTransformer.Listener
                public /* synthetic */ void onTransformationCompleted(MediaItem mediaItem) {
                    Listener.CC.$default$onTransformationCompleted(this, mediaItem);
                }

                @Override // com.google.android.exoplayer2.transformer.TranscodingTransformer.Listener
                public /* synthetic */ void onTransformationError(MediaItem mediaItem, Exception exc) {
                    Listener.CC.$default$onTransformationError(this, mediaItem, exc);
                }
            };
            this.looper = Util.getCurrentOrMainLooper();
            this.clock = Clock.DEFAULT;
        }

        private Builder(TranscodingTransformer transcodingTransformer) {
            this.context = transcodingTransformer.context;
            this.mediaSourceFactory = transcodingTransformer.mediaSourceFactory;
            this.muxerFactory = transcodingTransformer.muxerFactory;
            this.removeAudio = transcodingTransformer.transformation.removeAudio;
            this.removeVideo = transcodingTransformer.transformation.removeVideo;
            this.flattenForSlowMotion = transcodingTransformer.transformation.flattenForSlowMotion;
            this.outputMimeType = transcodingTransformer.transformation.outputMimeType;
            this.audioMimeType = transcodingTransformer.transformation.audioMimeType;
            this.videoMimeType = transcodingTransformer.transformation.videoMimeType;
            this.listener = transcodingTransformer.listener;
            this.looper = transcodingTransformer.looper;
            this.clock = transcodingTransformer.clock;
        }

        public Builder setContext(Context context) {
            this.context = context.getApplicationContext();
            return this;
        }

        public Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory) {
            this.mediaSourceFactory = mediaSourceFactory;
            return this;
        }

        public Builder setRemoveAudio(boolean z) {
            this.removeAudio = z;
            return this;
        }

        public Builder setRemoveVideo(boolean z) {
            this.removeVideo = z;
            return this;
        }

        public Builder setFlattenForSlowMotion(boolean z) {
            this.flattenForSlowMotion = z;
            return this;
        }

        public Builder setOutputMimeType(String str) {
            this.outputMimeType = str;
            return this;
        }

        public Builder setVideoMimeType(String str) {
            this.videoMimeType = str;
            return this;
        }

        public Builder setAudioMimeType(String str) {
            this.audioMimeType = str;
            return this;
        }

        public Builder setListener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder setLooper(Looper looper) {
            this.looper = looper;
            return this;
        }

        Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        Builder setMuxerFactory(Muxer.Factory factory) {
            this.muxerFactory = factory;
            return this;
        }

        public TranscodingTransformer build() {
            Assertions.checkStateNotNull(this.context);
            if (this.mediaSourceFactory == null) {
                DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
                if (this.flattenForSlowMotion) {
                    defaultExtractorsFactory.setMp4ExtractorFlags(4);
                }
                this.mediaSourceFactory = new DefaultMediaSourceFactory(this.context, defaultExtractorsFactory);
            }
            boolean supportsOutputMimeType = this.muxerFactory.supportsOutputMimeType(this.outputMimeType);
            String valueOf = String.valueOf(this.outputMimeType);
            Assertions.checkState(supportsOutputMimeType, valueOf.length() != 0 ? "Unsupported output MIME type: ".concat(valueOf) : new String("Unsupported output MIME type: "));
            String str = this.audioMimeType;
            if (str != null) {
                checkSampleMimeType(str);
            }
            String str2 = this.videoMimeType;
            if (str2 != null) {
                checkSampleMimeType(str2);
            }
            return new TranscodingTransformer(this.context, this.mediaSourceFactory, this.muxerFactory, new Transformation(this.removeAudio, this.removeVideo, this.flattenForSlowMotion, this.outputMimeType, this.audioMimeType, this.videoMimeType), this.listener, this.looper, this.clock);
        }

        private void checkSampleMimeType(String str) {
            boolean supportsSampleMimeType = this.muxerFactory.supportsSampleMimeType(str, this.outputMimeType);
            String str2 = this.outputMimeType;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54 + String.valueOf(str2).length());
            sb.append("Unsupported sample MIME type ");
            sb.append(str);
            sb.append(" for container MIME type ");
            sb.append(str2);
            Assertions.checkState(supportsSampleMimeType, sb.toString());
        }
    }

    private TranscodingTransformer(Context context, MediaSourceFactory mediaSourceFactory, Muxer.Factory factory, Transformation transformation, Listener listener, Looper looper, Clock clock) {
        Assertions.checkState((transformation.removeAudio && transformation.removeVideo) ? false : true, "Audio and video cannot both be removed.");
        this.context = context;
        this.mediaSourceFactory = mediaSourceFactory;
        this.muxerFactory = factory;
        this.transformation = transformation;
        this.listener = listener;
        this.looper = looper;
        this.clock = clock;
        this.progressState = 4;
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public void setListener(Listener listener) {
        verifyApplicationThread();
        this.listener = listener;
    }

    public void startTransformation(MediaItem mediaItem, String str) throws IOException {
        startTransformation(mediaItem, this.muxerFactory.create(str, this.transformation.outputMimeType));
    }

    public void startTransformation(MediaItem mediaItem, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        startTransformation(mediaItem, this.muxerFactory.create(parcelFileDescriptor, this.transformation.outputMimeType));
    }

    private void startTransformation(MediaItem mediaItem, Muxer muxer) {
        verifyApplicationThread();
        if (this.player != null) {
            throw new IllegalStateException("There is already a transformation in progress.");
        }
        MuxerWrapper muxerWrapper = new MuxerWrapper(muxer, this.muxerFactory, this.transformation.outputMimeType);
        this.muxerWrapper = muxerWrapper;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(this.context);
        defaultTrackSelector.setParameters(new DefaultTrackSelector.ParametersBuilder(this.context).setForceHighestSupportedBitrate(true).build());
        DefaultLoadControl build = new DefaultLoadControl.Builder().setBufferDurationsMs(50000, 50000, 250, 500).build();
        Context context = this.context;
        ExoPlayer build2 = new ExoPlayer.Builder(context, new TranscodingTransformerRenderersFactory(context, muxerWrapper, this.transformation)).setMediaSourceFactory(this.mediaSourceFactory).setTrackSelector(defaultTrackSelector).setLoadControl(build).setLooper(this.looper).setClock(this.clock).build();
        this.player = build2;
        build2.setMediaItem(mediaItem);
        this.player.addListener((Player.Listener) new TranscodingTransformerPlayerListener(mediaItem, muxerWrapper));
        this.player.prepare();
        this.progressState = 0;
    }

    public Looper getApplicationLooper() {
        return this.looper;
    }

    public int getProgress(ProgressHolder progressHolder) {
        verifyApplicationThread();
        if (this.progressState == 1) {
            Player player = (Player) Assertions.checkNotNull(this.player);
            progressHolder.progress = Math.min((int) ((player.getCurrentPosition() * 100) / player.getDuration()), 99);
        }
        return this.progressState;
    }

    public void cancel() {
        releaseResources(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseResources(boolean z) {
        verifyApplicationThread();
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.release();
            this.player = null;
        }
        MuxerWrapper muxerWrapper = this.muxerWrapper;
        if (muxerWrapper != null) {
            muxerWrapper.release(z);
            this.muxerWrapper = null;
        }
        this.progressState = 4;
    }

    private void verifyApplicationThread() {
        if (Looper.myLooper() != this.looper) {
            throw new IllegalStateException("Transcoding Transformer is accessed on the wrong thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class TranscodingTransformerRenderersFactory implements RenderersFactory {
        private final Context context;
        private final TransformerMediaClock mediaClock = new TransformerMediaClock();
        private final MuxerWrapper muxerWrapper;
        private final Transformation transformation;

        public TranscodingTransformerRenderersFactory(Context context, MuxerWrapper muxerWrapper, Transformation transformation) {
            this.context = context;
            this.muxerWrapper = muxerWrapper;
            this.transformation = transformation;
        }

        @Override // com.google.android.exoplayer2.RenderersFactory
        public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
            char c = 1;
            Renderer[] rendererArr = new Renderer[(this.transformation.removeAudio || this.transformation.removeVideo) ? 1 : 2];
            if (this.transformation.removeAudio) {
                c = 0;
            } else {
                rendererArr[0] = new TransformerAudioRenderer(this.muxerWrapper, this.mediaClock, this.transformation);
            }
            if (!this.transformation.removeVideo) {
                rendererArr[c] = new TransformerTranscodingVideoRenderer(this.context, this.muxerWrapper, this.mediaClock, this.transformation);
            }
            return rendererArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class TranscodingTransformerPlayerListener implements Player.Listener {
        private final MediaItem mediaItem;
        private final MuxerWrapper muxerWrapper;

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

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            Player.Listener.CC.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
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

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
            Player.Listener.CC.$default$onVideoSizeChanged(this, videoSize);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onVolumeChanged(float f) {
            Player.Listener.CC.$default$onVolumeChanged(this, f);
        }

        public TranscodingTransformerPlayerListener(MediaItem mediaItem, MuxerWrapper muxerWrapper) {
            this.mediaItem = mediaItem;
            this.muxerWrapper = muxerWrapper;
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            if (i == 4) {
                handleTransformationEnded(null);
            }
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, int i) {
            if (TranscodingTransformer.this.progressState != 0) {
                return;
            }
            Timeline.Window window = new Timeline.Window();
            timeline.getWindow(0, window);
            if (window.isPlaceholder) {
                return;
            }
            long j = window.durationUs;
            TranscodingTransformer.this.progressState = (j <= 0 || j == C3282C.TIME_UNSET) ? 2 : 1;
            ((ExoPlayer) Assertions.checkNotNull(TranscodingTransformer.this.player)).play();
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onTracksInfoChanged(TracksInfo tracksInfo) {
            if (this.muxerWrapper.getTrackCount() == 0) {
                handleTransformationEnded(new IllegalStateException("The output does not contain any tracks. Check that at least one of the input sample formats is supported."));
            }
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayerError(PlaybackException playbackException) {
            handleTransformationEnded(playbackException);
        }

        private void handleTransformationEnded(Exception exc) {
            try {
                TranscodingTransformer.this.releaseResources(false);
            } catch (IllegalStateException e) {
                if (exc == null) {
                    exc = e;
                }
            }
            if (exc == null) {
                TranscodingTransformer.this.listener.onTransformationCompleted(this.mediaItem);
            } else {
                TranscodingTransformer.this.listener.onTransformationError(this.mediaItem, exc);
            }
        }
    }
}
