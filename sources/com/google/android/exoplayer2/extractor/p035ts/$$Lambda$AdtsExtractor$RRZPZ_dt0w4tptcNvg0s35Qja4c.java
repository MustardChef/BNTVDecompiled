package com.google.android.exoplayer2.extractor.p035ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.extractor.ts.-$$Lambda$AdtsExtractor$RRZPZ_dt0w4tptcNvg0s35Qja4c  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$AdtsExtractor$RRZPZ_dt0w4tptcNvg0s35Qja4c implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$AdtsExtractor$RRZPZ_dt0w4tptcNvg0s35Qja4c INSTANCE = new $$Lambda$AdtsExtractor$RRZPZ_dt0w4tptcNvg0s35Qja4c();

    private /* synthetic */ $$Lambda$AdtsExtractor$RRZPZ_dt0w4tptcNvg0s35Qja4c() {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public final Extractor[] createExtractors() {
        return AdtsExtractor.lambda$static$0();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        Extractor[] createExtractors;
        createExtractors = createExtractors();
        return createExtractors;
    }
}