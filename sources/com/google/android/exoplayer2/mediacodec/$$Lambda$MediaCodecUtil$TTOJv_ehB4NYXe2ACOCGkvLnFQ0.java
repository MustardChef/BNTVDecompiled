package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.mediacodec.-$$Lambda$MediaCodecUtil$TTOJv_ehB4NYXe2ACOCGkvLnFQ0  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$MediaCodecUtil$TTOJv_ehB4NYXe2ACOCGkvLnFQ0 implements MediaCodecUtil.ScoreProvider {
    public static final /* synthetic */ $$Lambda$MediaCodecUtil$TTOJv_ehB4NYXe2ACOCGkvLnFQ0 INSTANCE = new $$Lambda$MediaCodecUtil$TTOJv_ehB4NYXe2ACOCGkvLnFQ0();

    private /* synthetic */ $$Lambda$MediaCodecUtil$TTOJv_ehB4NYXe2ACOCGkvLnFQ0() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider
    public final int getScore(Object obj) {
        return MediaCodecUtil.lambda$applyWorkarounds$2((MediaCodecInfo) obj);
    }
}
