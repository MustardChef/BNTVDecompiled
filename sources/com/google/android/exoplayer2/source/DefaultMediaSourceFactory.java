package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.p036ui.AdViewProvider;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.text.SubtitleExtractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private static final String TAG = "DefaultMediaSourceFactory";
    private AdViewProvider adViewProvider;
    private AdsLoaderProvider adsLoaderProvider;
    private final DataSource.Factory dataSourceFactory;
    private final DelegateFactoryLoader delegateFactoryLoader;
    private long liveMaxOffsetMs;
    private float liveMaxSpeed;
    private long liveMinOffsetMs;
    private float liveMinSpeed;
    private long liveTargetOffsetMs;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private boolean useProgressiveMediaSourceForSubtitles;

    /* loaded from: classes2.dex */
    public interface AdsLoaderProvider {
        AdsLoader getAdsLoader(MediaItem.AdsConfiguration adsConfiguration);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public /* synthetic */ MediaSource createMediaSource(Uri uri) {
        return MediaSourceFactory.CC.$default$createMediaSource(this, uri);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    @Deprecated
    public /* bridge */ /* synthetic */ MediaSourceFactory setStreamKeys(List list) {
        return setStreamKeys((List<StreamKey>) list);
    }

    public DefaultMediaSourceFactory(Context context) {
        this(new DefaultDataSource.Factory(context));
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this(new DefaultDataSource.Factory(context), extractorsFactory);
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, new DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.dataSourceFactory = factory;
        this.delegateFactoryLoader = new DelegateFactoryLoader(factory, extractorsFactory);
        this.liveTargetOffsetMs = C3282C.TIME_UNSET;
        this.liveMinOffsetMs = C3282C.TIME_UNSET;
        this.liveMaxOffsetMs = C3282C.TIME_UNSET;
        this.liveMinSpeed = -3.4028235E38f;
        this.liveMaxSpeed = -3.4028235E38f;
    }

    public DefaultMediaSourceFactory experimentalUseProgressiveMediaSourceForSubtitles(boolean z) {
        this.useProgressiveMediaSourceForSubtitles = z;
        return this;
    }

    public DefaultMediaSourceFactory setAdsLoaderProvider(AdsLoaderProvider adsLoaderProvider) {
        this.adsLoaderProvider = adsLoaderProvider;
        return this;
    }

    public DefaultMediaSourceFactory setAdViewProvider(AdViewProvider adViewProvider) {
        this.adViewProvider = adViewProvider;
        return this;
    }

    public DefaultMediaSourceFactory setLiveTargetOffsetMs(long j) {
        this.liveTargetOffsetMs = j;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinOffsetMs(long j) {
        this.liveMinOffsetMs = j;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxOffsetMs(long j) {
        this.liveMaxOffsetMs = j;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinSpeed(float f) {
        this.liveMinSpeed = f;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxSpeed(float f) {
        this.liveMaxSpeed = f;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    @Deprecated
    public DefaultMediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
        this.delegateFactoryLoader.setDrmHttpDataSourceFactory(factory);
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    @Deprecated
    public DefaultMediaSourceFactory setDrmUserAgent(String str) {
        this.delegateFactoryLoader.setDrmUserAgent(str);
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    @Deprecated
    public DefaultMediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager) {
        this.delegateFactoryLoader.setDrmSessionManager(drmSessionManager);
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public DefaultMediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
        this.delegateFactoryLoader.setDrmSessionManagerProvider(drmSessionManagerProvider);
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public DefaultMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.delegateFactoryLoader.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    @Deprecated
    public DefaultMediaSourceFactory setStreamKeys(List<StreamKey> list) {
        this.delegateFactoryLoader.setStreamKeys(list);
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public int[] getSupportedTypes() {
        return this.delegateFactoryLoader.getSupportedTypes();
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public MediaSource createMediaSource(MediaItem mediaItem) {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(mediaItem.localConfiguration.uri, mediaItem.localConfiguration.mimeType);
        MediaSourceFactory mediaSourceFactory = this.delegateFactoryLoader.getMediaSourceFactory(inferContentTypeForUriAndMimeType);
        StringBuilder sb = new StringBuilder(68);
        sb.append("No suitable media source factory found for content type: ");
        sb.append(inferContentTypeForUriAndMimeType);
        Assertions.checkStateNotNull(mediaSourceFactory, sb.toString());
        MediaItem.LiveConfiguration.Builder buildUpon = mediaItem.liveConfiguration.buildUpon();
        if (mediaItem.liveConfiguration.targetOffsetMs == C3282C.TIME_UNSET) {
            buildUpon.setTargetOffsetMs(this.liveTargetOffsetMs);
        }
        if (mediaItem.liveConfiguration.minPlaybackSpeed == -3.4028235E38f) {
            buildUpon.setMinPlaybackSpeed(this.liveMinSpeed);
        }
        if (mediaItem.liveConfiguration.maxPlaybackSpeed == -3.4028235E38f) {
            buildUpon.setMaxPlaybackSpeed(this.liveMaxSpeed);
        }
        if (mediaItem.liveConfiguration.minOffsetMs == C3282C.TIME_UNSET) {
            buildUpon.setMinOffsetMs(this.liveMinOffsetMs);
        }
        if (mediaItem.liveConfiguration.maxOffsetMs == C3282C.TIME_UNSET) {
            buildUpon.setMaxOffsetMs(this.liveMaxOffsetMs);
        }
        MediaItem.LiveConfiguration build = buildUpon.build();
        if (!build.equals(mediaItem.liveConfiguration)) {
            mediaItem = mediaItem.buildUpon().setLiveConfiguration(build).build();
        }
        MediaSource createMediaSource = mediaSourceFactory.createMediaSource(mediaItem);
        ImmutableList<MediaItem.SubtitleConfiguration> immutableList = ((MediaItem.LocalConfiguration) Util.castNonNull(mediaItem.localConfiguration)).subtitleConfigurations;
        if (!immutableList.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[immutableList.size() + 1];
            mediaSourceArr[0] = createMediaSource;
            for (int i = 0; i < immutableList.size(); i++) {
                if (this.useProgressiveMediaSourceForSubtitles) {
                    final Format build2 = new Format.Builder().setSampleMimeType(immutableList.get(i).mimeType).setLanguage(immutableList.get(i).language).setSelectionFlags(immutableList.get(i).selectionFlags).setRoleFlags(immutableList.get(i).roleFlags).setLabel(immutableList.get(i).label).build();
                    mediaSourceArr[i + 1] = new ProgressiveMediaSource.Factory(this.dataSourceFactory, new ExtractorsFactory() { // from class: com.google.android.exoplayer2.source.-$$Lambda$DefaultMediaSourceFactory$kCLgPvx_eEewdVW5S-3ZC0F5E4I
                        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
                        public final Extractor[] createExtractors() {
                            return DefaultMediaSourceFactory.lambda$createMediaSource$0(Format.this);
                        }

                        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
                        public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
                            Extractor[] createExtractors;
                            createExtractors = createExtractors();
                            return createExtractors;
                        }
                    }).createMediaSource(MediaItem.fromUri(immutableList.get(i).uri.toString()));
                } else {
                    mediaSourceArr[i + 1] = new SingleSampleMediaSource.Factory(this.dataSourceFactory).setLoadErrorHandlingPolicy(this.loadErrorHandlingPolicy).createMediaSource(immutableList.get(i), C3282C.TIME_UNSET);
                }
            }
            createMediaSource = new MergingMediaSource(mediaSourceArr);
        }
        return maybeWrapWithAdsMediaSource(mediaItem, maybeClipMediaSource(mediaItem, createMediaSource));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Extractor[] lambda$createMediaSource$0(Format format) {
        Extractor unknownSubtitlesExtractor;
        Extractor[] extractorArr = new Extractor[1];
        if (SubtitleDecoderFactory.DEFAULT.supportsFormat(format)) {
            unknownSubtitlesExtractor = new SubtitleExtractor(SubtitleDecoderFactory.DEFAULT.createDecoder(format), format);
        } else {
            unknownSubtitlesExtractor = new UnknownSubtitlesExtractor(format);
        }
        extractorArr[0] = unknownSubtitlesExtractor;
        return extractorArr;
    }

    private static MediaSource maybeClipMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        return (mediaItem.clippingConfiguration.startPositionMs == 0 && mediaItem.clippingConfiguration.endPositionMs == Long.MIN_VALUE && !mediaItem.clippingConfiguration.relativeToDefaultPosition) ? mediaSource : new ClippingMediaSource(mediaSource, Util.msToUs(mediaItem.clippingConfiguration.startPositionMs), Util.msToUs(mediaItem.clippingConfiguration.endPositionMs), !mediaItem.clippingConfiguration.startsAtKeyFrame, mediaItem.clippingConfiguration.relativeToLiveWindow, mediaItem.clippingConfiguration.relativeToDefaultPosition);
    }

    private MediaSource maybeWrapWithAdsMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        Object m292of;
        Assertions.checkNotNull(mediaItem.localConfiguration);
        MediaItem.AdsConfiguration adsConfiguration = mediaItem.localConfiguration.adsConfiguration;
        if (adsConfiguration == null) {
            return mediaSource;
        }
        AdsLoaderProvider adsLoaderProvider = this.adsLoaderProvider;
        AdViewProvider adViewProvider = this.adViewProvider;
        if (adsLoaderProvider == null || adViewProvider == null) {
            Log.m379w(TAG, "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        AdsLoader adsLoader = adsLoaderProvider.getAdsLoader(adsConfiguration);
        if (adsLoader == null) {
            Log.m379w(TAG, "Playing media without ads, as no AdsLoader was provided.");
            return mediaSource;
        }
        DataSpec dataSpec = new DataSpec(adsConfiguration.adTagUri);
        if (adsConfiguration.adsId != null) {
            m292of = adsConfiguration.adsId;
        } else {
            m292of = ImmutableList.m292of((Uri) mediaItem.mediaId, mediaItem.localConfiguration.uri, adsConfiguration.adTagUri);
        }
        return new AdsMediaSource(mediaSource, dataSpec, m292of, this, adsLoader, adViewProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class DelegateFactoryLoader {
        private final DataSource.Factory dataSourceFactory;
        private HttpDataSource.Factory drmHttpDataSourceFactory;
        private DrmSessionManager drmSessionManager;
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private final ExtractorsFactory extractorsFactory;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private List<StreamKey> streamKeys;
        private String userAgent;
        private final Map<Integer, Supplier<MediaSourceFactory>> mediaSourceFactorySuppliers = new HashMap();
        private final Set<Integer> supportedTypes = new HashSet();
        private final Map<Integer, MediaSourceFactory> mediaSourceFactories = new HashMap();

        public DelegateFactoryLoader(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
            this.dataSourceFactory = factory;
            this.extractorsFactory = extractorsFactory;
        }

        public int[] getSupportedTypes() {
            ensureAllSuppliersAreLoaded();
            return Ints.toArray(this.supportedTypes);
        }

        public MediaSourceFactory getMediaSourceFactory(int i) {
            MediaSourceFactory mediaSourceFactory = this.mediaSourceFactories.get(Integer.valueOf(i));
            if (mediaSourceFactory != null) {
                return mediaSourceFactory;
            }
            Supplier<MediaSourceFactory> maybeLoadSupplier = maybeLoadSupplier(i);
            if (maybeLoadSupplier == null) {
                return null;
            }
            MediaSourceFactory mediaSourceFactory2 = maybeLoadSupplier.get();
            HttpDataSource.Factory factory = this.drmHttpDataSourceFactory;
            if (factory != null) {
                mediaSourceFactory2.setDrmHttpDataSourceFactory(factory);
            }
            String str = this.userAgent;
            if (str != null) {
                mediaSourceFactory2.setDrmUserAgent(str);
            }
            DrmSessionManager drmSessionManager = this.drmSessionManager;
            if (drmSessionManager != null) {
                mediaSourceFactory2.setDrmSessionManager(drmSessionManager);
            }
            DrmSessionManagerProvider drmSessionManagerProvider = this.drmSessionManagerProvider;
            if (drmSessionManagerProvider != null) {
                mediaSourceFactory2.setDrmSessionManagerProvider(drmSessionManagerProvider);
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
            if (loadErrorHandlingPolicy != null) {
                mediaSourceFactory2.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
            }
            List<StreamKey> list = this.streamKeys;
            if (list != null) {
                mediaSourceFactory2.setStreamKeys(list);
            }
            this.mediaSourceFactories.put(Integer.valueOf(i), mediaSourceFactory2);
            return mediaSourceFactory2;
        }

        public void setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
            this.drmHttpDataSourceFactory = factory;
            for (MediaSourceFactory mediaSourceFactory : this.mediaSourceFactories.values()) {
                mediaSourceFactory.setDrmHttpDataSourceFactory(factory);
            }
        }

        public void setDrmUserAgent(String str) {
            this.userAgent = str;
            for (MediaSourceFactory mediaSourceFactory : this.mediaSourceFactories.values()) {
                mediaSourceFactory.setDrmUserAgent(str);
            }
        }

        public void setDrmSessionManager(DrmSessionManager drmSessionManager) {
            this.drmSessionManager = drmSessionManager;
            for (MediaSourceFactory mediaSourceFactory : this.mediaSourceFactories.values()) {
                mediaSourceFactory.setDrmSessionManager(drmSessionManager);
            }
        }

        public void setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.drmSessionManagerProvider = drmSessionManagerProvider;
            for (MediaSourceFactory mediaSourceFactory : this.mediaSourceFactories.values()) {
                mediaSourceFactory.setDrmSessionManagerProvider(drmSessionManagerProvider);
            }
        }

        public void setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            for (MediaSourceFactory mediaSourceFactory : this.mediaSourceFactories.values()) {
                mediaSourceFactory.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
            }
        }

        public void setStreamKeys(List<StreamKey> list) {
            this.streamKeys = list;
            for (MediaSourceFactory mediaSourceFactory : this.mediaSourceFactories.values()) {
                mediaSourceFactory.setStreamKeys(list);
            }
        }

        private void ensureAllSuppliersAreLoaded() {
            maybeLoadSupplier(0);
            maybeLoadSupplier(1);
            maybeLoadSupplier(2);
            maybeLoadSupplier(3);
            maybeLoadSupplier(4);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSourceFactory> maybeLoadSupplier(int r4) {
            /*
                r3 = this;
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSourceFactory>> r0 = r3.mediaSourceFactorySuppliers
                java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L19
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSourceFactory>> r0 = r3.mediaSourceFactorySuppliers
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                java.lang.Object r4 = r0.get(r4)
                com.google.common.base.Supplier r4 = (com.google.common.base.Supplier) r4
                return r4
            L19:
                r0 = 0
                if (r4 == 0) goto L68
                r1 = 1
                if (r4 == r1) goto L56
                r1 = 2
                if (r4 == r1) goto L44
                r1 = 3
                if (r4 == r1) goto L32
                r1 = 4
                if (r4 == r1) goto L29
                goto L7a
            L29:
                com.google.android.exoplayer2.source.-$$Lambda$DefaultMediaSourceFactory$DelegateFactoryLoader$gdERsPgH7r-Wu2Z9VR9CHROGEdY r1 = new com.google.android.exoplayer2.source.-$$Lambda$DefaultMediaSourceFactory$DelegateFactoryLoader$gdERsPgH7r-Wu2Z9VR9CHROGEdY     // Catch: java.lang.ClassNotFoundException -> L30
                r1.<init>()     // Catch: java.lang.ClassNotFoundException -> L30
                r0 = r1
                goto L7a
            L30:
                goto L7a
            L32:
                java.lang.String r1 = "com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> L30
                java.lang.Class<com.google.android.exoplayer2.source.MediaSourceFactory> r2 = com.google.android.exoplayer2.source.MediaSourceFactory.class
                java.lang.Class r1 = r1.asSubclass(r2)     // Catch: java.lang.ClassNotFoundException -> L30
                com.google.android.exoplayer2.source.-$$Lambda$DefaultMediaSourceFactory$DelegateFactoryLoader$IlmOOqWLChyzy_fdcHu6gKh-0_c r2 = new com.google.android.exoplayer2.source.-$$Lambda$DefaultMediaSourceFactory$DelegateFactoryLoader$IlmOOqWLChyzy_fdcHu6gKh-0_c     // Catch: java.lang.ClassNotFoundException -> L30
                r2.<init>()     // Catch: java.lang.ClassNotFoundException -> L30
                goto L79
            L44:
                java.lang.String r1 = "com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> L30
                java.lang.Class<com.google.android.exoplayer2.source.MediaSourceFactory> r2 = com.google.android.exoplayer2.source.MediaSourceFactory.class
                java.lang.Class r1 = r1.asSubclass(r2)     // Catch: java.lang.ClassNotFoundException -> L30
                com.google.android.exoplayer2.source.-$$Lambda$DefaultMediaSourceFactory$DelegateFactoryLoader$Zys7Fcgje0BjJDyMiyzrPubbrc8 r2 = new com.google.android.exoplayer2.source.-$$Lambda$DefaultMediaSourceFactory$DelegateFactoryLoader$Zys7Fcgje0BjJDyMiyzrPubbrc8     // Catch: java.lang.ClassNotFoundException -> L30
                r2.<init>()     // Catch: java.lang.ClassNotFoundException -> L30
                goto L79
            L56:
                java.lang.String r1 = "com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> L30
                java.lang.Class<com.google.android.exoplayer2.source.MediaSourceFactory> r2 = com.google.android.exoplayer2.source.MediaSourceFactory.class
                java.lang.Class r1 = r1.asSubclass(r2)     // Catch: java.lang.ClassNotFoundException -> L30
                com.google.android.exoplayer2.source.-$$Lambda$DefaultMediaSourceFactory$DelegateFactoryLoader$c8x7rtBlOYszlPM2-g-aORHqJt8 r2 = new com.google.android.exoplayer2.source.-$$Lambda$DefaultMediaSourceFactory$DelegateFactoryLoader$c8x7rtBlOYszlPM2-g-aORHqJt8     // Catch: java.lang.ClassNotFoundException -> L30
                r2.<init>()     // Catch: java.lang.ClassNotFoundException -> L30
                goto L79
            L68:
                java.lang.String r1 = "com.google.android.exoplayer2.source.dash.DashMediaSource$Factory"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> L30
                java.lang.Class<com.google.android.exoplayer2.source.MediaSourceFactory> r2 = com.google.android.exoplayer2.source.MediaSourceFactory.class
                java.lang.Class r1 = r1.asSubclass(r2)     // Catch: java.lang.ClassNotFoundException -> L30
                com.google.android.exoplayer2.source.-$$Lambda$DefaultMediaSourceFactory$DelegateFactoryLoader$k3rc5Z4CUbRPrN3p_fi-hs-vF0s r2 = new com.google.android.exoplayer2.source.-$$Lambda$DefaultMediaSourceFactory$DelegateFactoryLoader$k3rc5Z4CUbRPrN3p_fi-hs-vF0s     // Catch: java.lang.ClassNotFoundException -> L30
                r2.<init>()     // Catch: java.lang.ClassNotFoundException -> L30
            L79:
                r0 = r2
            L7a:
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSourceFactory>> r1 = r3.mediaSourceFactorySuppliers
                java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
                r1.put(r2, r0)
                if (r0 == 0) goto L8e
                java.util.Set<java.lang.Integer> r1 = r3.supportedTypes
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                r1.add(r4)
            L8e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.DefaultMediaSourceFactory.DelegateFactoryLoader.maybeLoadSupplier(int):com.google.common.base.Supplier");
        }

        /* renamed from: lambda$maybeLoadSupplier$0$DefaultMediaSourceFactory$DelegateFactoryLoader */
        public /* synthetic */ MediaSourceFactory m399xc5bf4cc5(Class cls) {
            return DefaultMediaSourceFactory.newInstance(cls, this.dataSourceFactory);
        }

        /* renamed from: lambda$maybeLoadSupplier$1$DefaultMediaSourceFactory$DelegateFactoryLoader */
        public /* synthetic */ MediaSourceFactory m398xc548e6c6(Class cls) {
            return DefaultMediaSourceFactory.newInstance(cls, this.dataSourceFactory);
        }

        /* renamed from: lambda$maybeLoadSupplier$2$DefaultMediaSourceFactory$DelegateFactoryLoader */
        public /* synthetic */ MediaSourceFactory m397xc4d280c7(Class cls) {
            return DefaultMediaSourceFactory.newInstance(cls, this.dataSourceFactory);
        }

        /* renamed from: lambda$maybeLoadSupplier$4$DefaultMediaSourceFactory$DelegateFactoryLoader */
        public /* synthetic */ MediaSourceFactory m396xc3e5b4c9() {
            return new ProgressiveMediaSource.Factory(this.dataSourceFactory, this.extractorsFactory);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class UnknownSubtitlesExtractor implements Extractor {
        private final Format format;

        @Override // com.google.android.exoplayer2.extractor.Extractor
        public void release() {
        }

        @Override // com.google.android.exoplayer2.extractor.Extractor
        public void seek(long j, long j2) {
        }

        @Override // com.google.android.exoplayer2.extractor.Extractor
        public boolean sniff(ExtractorInput extractorInput) {
            return true;
        }

        public UnknownSubtitlesExtractor(Format format) {
            this.format = format;
        }

        @Override // com.google.android.exoplayer2.extractor.Extractor
        public void init(ExtractorOutput extractorOutput) {
            TrackOutput track = extractorOutput.track(0, 3);
            extractorOutput.seekMap(new SeekMap.Unseekable(C3282C.TIME_UNSET));
            extractorOutput.endTracks();
            track.format(this.format.buildUpon().setSampleMimeType(MimeTypes.TEXT_UNKNOWN).setCodecs(this.format.sampleMimeType).build());
        }

        @Override // com.google.android.exoplayer2.extractor.Extractor
        public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
            return extractorInput.skip(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaSourceFactory newInstance(Class<? extends MediaSourceFactory> cls, DataSource.Factory factory) {
        try {
            return cls.getConstructor(DataSource.Factory.class).newInstance(factory);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaSourceFactory newInstance(Class<? extends MediaSourceFactory> cls) {
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
