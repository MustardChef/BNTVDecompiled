package com.google.android.exoplayer2.extractor.wav;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.extractor.wav.-$$Lambda$WavExtractor$Qwcn1NjCsgxYvA5Vzd4jHyQOX2k  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$WavExtractor$Qwcn1NjCsgxYvA5Vzd4jHyQOX2k implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$WavExtractor$Qwcn1NjCsgxYvA5Vzd4jHyQOX2k INSTANCE = new $$Lambda$WavExtractor$Qwcn1NjCsgxYvA5Vzd4jHyQOX2k();

    private /* synthetic */ $$Lambda$WavExtractor$Qwcn1NjCsgxYvA5Vzd4jHyQOX2k() {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public final Extractor[] createExtractors() {
        return WavExtractor.lambda$static$0();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        Extractor[] createExtractors;
        createExtractors = createExtractors();
        return createExtractors;
    }
}
