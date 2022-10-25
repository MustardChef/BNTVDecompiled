package com.google.android.exoplayer2.extractor.p035ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.extractor.ts.-$$Lambda$TsExtractor$bYe9QyXe_uycRO2Fcb-UvfjPyNo  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$TsExtractor$bYe9QyXe_uycRO2FcbUvfjPyNo implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$TsExtractor$bYe9QyXe_uycRO2FcbUvfjPyNo INSTANCE = new $$Lambda$TsExtractor$bYe9QyXe_uycRO2FcbUvfjPyNo();

    private /* synthetic */ $$Lambda$TsExtractor$bYe9QyXe_uycRO2FcbUvfjPyNo() {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public final Extractor[] createExtractors() {
        return TsExtractor.lambda$static$0();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        Extractor[] createExtractors;
        createExtractors = createExtractors();
        return createExtractors;
    }
}
