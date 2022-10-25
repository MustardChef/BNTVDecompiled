package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import java.util.List;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.source.chunk.-$$Lambda$MediaParserChunkExtractor$e9RPEH8uAeNNF1m6s2mFK50OGvQ  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$MediaParserChunkExtractor$e9RPEH8uAeNNF1m6s2mFK50OGvQ implements ChunkExtractor.Factory {
    public static final /* synthetic */ $$Lambda$MediaParserChunkExtractor$e9RPEH8uAeNNF1m6s2mFK50OGvQ INSTANCE = new $$Lambda$MediaParserChunkExtractor$e9RPEH8uAeNNF1m6s2mFK50OGvQ();

    private /* synthetic */ $$Lambda$MediaParserChunkExtractor$e9RPEH8uAeNNF1m6s2mFK50OGvQ() {
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor.Factory
    public final ChunkExtractor createProgressiveMediaExtractor(int i, Format format, boolean z, List list, TrackOutput trackOutput) {
        return MediaParserChunkExtractor.lambda$static$0(i, format, z, list, trackOutput);
    }
}
