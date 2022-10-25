package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.source.hls.playlist.-$$Lambda$v4Cu38iwTNBS0lObDF_BajWNhwg  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$v4Cu38iwTNBS0lObDF_BajWNhwg implements HlsPlaylistTracker.Factory {
    public static final /* synthetic */ $$Lambda$v4Cu38iwTNBS0lObDF_BajWNhwg INSTANCE = new $$Lambda$v4Cu38iwTNBS0lObDF_BajWNhwg();

    private /* synthetic */ $$Lambda$v4Cu38iwTNBS0lObDF_BajWNhwg() {
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory
    public final HlsPlaylistTracker createTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        return new DefaultHlsPlaylistTracker(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory);
    }
}
