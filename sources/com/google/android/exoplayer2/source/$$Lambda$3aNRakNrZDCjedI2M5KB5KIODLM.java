package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.source.-$$Lambda$3aNRakNrZDCjedI2M5KB5KIODLM  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$3aNRakNrZDCjedI2M5KB5KIODLM implements ProgressiveMediaExtractor.Factory {
    public static final /* synthetic */ $$Lambda$3aNRakNrZDCjedI2M5KB5KIODLM INSTANCE = new $$Lambda$3aNRakNrZDCjedI2M5KB5KIODLM();

    private /* synthetic */ $$Lambda$3aNRakNrZDCjedI2M5KB5KIODLM() {
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor.Factory
    public final ProgressiveMediaExtractor createProgressiveMediaExtractor() {
        return new MediaParserExtractorAdapter();
    }
}
