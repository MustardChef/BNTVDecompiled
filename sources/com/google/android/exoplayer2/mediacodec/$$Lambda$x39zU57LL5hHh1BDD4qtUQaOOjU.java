package com.google.android.exoplayer2.mediacodec;

import java.util.List;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.mediacodec.-$$Lambda$x39zU57LL5hHh1BDD4qtUQaOOjU  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$x39zU57LL5hHh1BDD4qtUQaOOjU implements MediaCodecSelector {
    public static final /* synthetic */ $$Lambda$x39zU57LL5hHh1BDD4qtUQaOOjU INSTANCE = new $$Lambda$x39zU57LL5hHh1BDD4qtUQaOOjU();

    private /* synthetic */ $$Lambda$x39zU57LL5hHh1BDD4qtUQaOOjU() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
    public final List getDecoderInfos(String str, boolean z, boolean z2) {
        return MediaCodecUtil.getDecoderInfos(str, z, z2);
    }
}
