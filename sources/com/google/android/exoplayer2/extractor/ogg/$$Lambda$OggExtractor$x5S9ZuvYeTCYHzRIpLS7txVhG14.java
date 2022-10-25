package com.google.android.exoplayer2.extractor.ogg;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.extractor.ogg.-$$Lambda$OggExtractor$x5S9ZuvYeTCYHzRIpLS7txVhG14  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$OggExtractor$x5S9ZuvYeTCYHzRIpLS7txVhG14 implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$OggExtractor$x5S9ZuvYeTCYHzRIpLS7txVhG14 INSTANCE = new $$Lambda$OggExtractor$x5S9ZuvYeTCYHzRIpLS7txVhG14();

    private /* synthetic */ $$Lambda$OggExtractor$x5S9ZuvYeTCYHzRIpLS7txVhG14() {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public final Extractor[] createExtractors() {
        return OggExtractor.lambda$static$0();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        Extractor[] createExtractors;
        createExtractors = createExtractors();
        return createExtractors;
    }
}
