package com.lagradost.cloudstream3.p041ui.player;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomSubtitleDecoderFactory.kt */
@Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/CustomSubtitleDecoderFactory;", "Lcom/google/android/exoplayer2/text/SubtitleDecoderFactory;", "()V", "createDecoder", "Lcom/google/android/exoplayer2/text/SubtitleDecoder;", "format", "Lcom/google/android/exoplayer2/Format;", "supportsFormat", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.CustomSubtitleDecoderFactory */
/* loaded from: classes3.dex */
public final class CustomSubtitleDecoderFactory implements SubtitleDecoderFactory {
    @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
    public boolean supportsFormat(Format format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return CollectionsKt.contains(CollectionsKt.listOf((Object[]) new String[]{MimeTypes.TEXT_VTT, MimeTypes.TEXT_SSA, MimeTypes.APPLICATION_TTML, MimeTypes.APPLICATION_MP4VTT, MimeTypes.APPLICATION_SUBRIP}), format.sampleMimeType);
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
    public SubtitleDecoder createDecoder(Format format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return new CustomDecoder();
    }
}
