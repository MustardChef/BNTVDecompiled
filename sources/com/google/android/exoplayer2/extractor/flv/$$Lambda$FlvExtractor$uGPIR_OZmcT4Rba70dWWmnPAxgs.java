package com.google.android.exoplayer2.extractor.flv;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.extractor.flv.-$$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs INSTANCE = new $$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs();

    private /* synthetic */ $$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs() {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public final Extractor[] createExtractors() {
        return FlvExtractor.lambda$static$0();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        Extractor[] createExtractors;
        createExtractors = createExtractors();
        return createExtractors;
    }
}
