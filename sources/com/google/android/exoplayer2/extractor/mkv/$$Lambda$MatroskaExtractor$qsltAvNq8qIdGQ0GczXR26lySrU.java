package com.google.android.exoplayer2.extractor.mkv;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.extractor.mkv.-$$Lambda$MatroskaExtractor$qsltAvNq8qIdGQ0GczXR26lySrU  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$MatroskaExtractor$qsltAvNq8qIdGQ0GczXR26lySrU implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$MatroskaExtractor$qsltAvNq8qIdGQ0GczXR26lySrU INSTANCE = new $$Lambda$MatroskaExtractor$qsltAvNq8qIdGQ0GczXR26lySrU();

    private /* synthetic */ $$Lambda$MatroskaExtractor$qsltAvNq8qIdGQ0GczXR26lySrU() {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public final Extractor[] createExtractors() {
        return MatroskaExtractor.lambda$static$0();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        Extractor[] createExtractors;
        createExtractors = createExtractors();
        return createExtractors;
    }
}
