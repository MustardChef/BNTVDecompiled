package com.google.android.exoplayer2.extractor.mp4;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.extractor.mp4.-$$Lambda$FragmentedMp4Extractor$nTvOltF7Hh61n3UwwVozMumvhfw  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$FragmentedMp4Extractor$nTvOltF7Hh61n3UwwVozMumvhfw implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$FragmentedMp4Extractor$nTvOltF7Hh61n3UwwVozMumvhfw INSTANCE = new $$Lambda$FragmentedMp4Extractor$nTvOltF7Hh61n3UwwVozMumvhfw();

    private /* synthetic */ $$Lambda$FragmentedMp4Extractor$nTvOltF7Hh61n3UwwVozMumvhfw() {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public final Extractor[] createExtractors() {
        return FragmentedMp4Extractor.lambda$static$0();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        Extractor[] createExtractors;
        createExtractors = createExtractors();
        return createExtractors;
    }
}
