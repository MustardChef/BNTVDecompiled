package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.List;
import java.util.Map;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.source.hls.-$$Lambda$MediaParserHlsMediaChunkExtractor$tIcZLmO66nAXq4SUmxZvvvSByuU */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3471x60d8cfd6 implements HlsExtractorFactory {
    public static final /* synthetic */ C3471x60d8cfd6 INSTANCE = new C3471x60d8cfd6();

    private /* synthetic */ C3471x60d8cfd6() {
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    public final HlsMediaChunkExtractor createExtractor(Uri uri, Format format, List list, TimestampAdjuster timestampAdjuster, Map map, ExtractorInput extractorInput) {
        return MediaParserHlsMediaChunkExtractor.lambda$static$0(uri, format, list, timestampAdjuster, map, extractorInput);
    }
}
