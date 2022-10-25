package com.google.android.exoplayer2.extractor.flac;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.extractor.flac.-$$Lambda$FlacExtractor$fh3RYYIyjNVY7ZLQFS_1oTiu7io  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$FlacExtractor$fh3RYYIyjNVY7ZLQFS_1oTiu7io implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$FlacExtractor$fh3RYYIyjNVY7ZLQFS_1oTiu7io INSTANCE = new $$Lambda$FlacExtractor$fh3RYYIyjNVY7ZLQFS_1oTiu7io();

    private /* synthetic */ $$Lambda$FlacExtractor$fh3RYYIyjNVY7ZLQFS_1oTiu7io() {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public final Extractor[] createExtractors() {
        return FlacExtractor.lambda$static$0();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        Extractor[] createExtractors;
        createExtractors = createExtractors();
        return createExtractors;
    }
}
