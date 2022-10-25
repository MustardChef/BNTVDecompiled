package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.util.List;

/* loaded from: classes2.dex */
public interface MediaSourceFactory {
    public static final MediaSourceFactory UNSUPPORTED = new MediaSourceFactory() { // from class: com.google.android.exoplayer2.source.MediaSourceFactory.1
        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public /* synthetic */ MediaSource createMediaSource(Uri uri) {
            return CC.$default$createMediaSource(this, uri);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public MediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public MediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public MediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public MediaSourceFactory setDrmUserAgent(String str) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public MediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public /* synthetic */ MediaSourceFactory setStreamKeys(List list) {
            return CC.$default$setStreamKeys(this, list);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public MediaSource createMediaSource(MediaItem mediaItem) {
            throw new UnsupportedOperationException();
        }
    };

    @Deprecated
    MediaSource createMediaSource(Uri uri);

    MediaSource createMediaSource(MediaItem mediaItem);

    int[] getSupportedTypes();

    @Deprecated
    MediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory);

    @Deprecated
    MediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager);

    MediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider);

    @Deprecated
    MediaSourceFactory setDrmUserAgent(String str);

    MediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    @Deprecated
    MediaSourceFactory setStreamKeys(List<StreamKey> list);

    /* renamed from: com.google.android.exoplayer2.source.MediaSourceFactory$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        @Deprecated
        public static MediaSourceFactory $default$setStreamKeys(MediaSourceFactory mediaSourceFactory, List list) {
            return mediaSourceFactory;
        }

        @Deprecated
        public static MediaSource $default$createMediaSource(MediaSourceFactory _this, Uri uri) {
            return _this.createMediaSource(MediaItem.fromUri(uri));
        }
    }
}
