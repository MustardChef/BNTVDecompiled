package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.mediacodec.-$$Lambda$MediaCodecUtil$M5hE_IS4eQaB5hthj0ANtGFbvtc  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$MediaCodecUtil$M5hE_IS4eQaB5hthj0ANtGFbvtc implements MediaCodecUtil.ScoreProvider {
    public static final /* synthetic */ $$Lambda$MediaCodecUtil$M5hE_IS4eQaB5hthj0ANtGFbvtc INSTANCE = new $$Lambda$MediaCodecUtil$M5hE_IS4eQaB5hthj0ANtGFbvtc();

    private /* synthetic */ $$Lambda$MediaCodecUtil$M5hE_IS4eQaB5hthj0ANtGFbvtc() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider
    public final int getScore(Object obj) {
        return MediaCodecUtil.lambda$applyWorkarounds$1((MediaCodecInfo) obj);
    }
}
