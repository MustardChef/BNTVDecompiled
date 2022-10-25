package com.lagradost.cloudstream3.p041ui.player;

import android.os.Looper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.text.TextOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;

/* compiled from: CustomTextRenderer.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\f\u001a\u00020\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/CustomTextRenderer;", "Lcom/lagradost/cloudstream3/ui/player/NonFinalTextRenderer;", TypedValues.CycleType.S_WAVE_OFFSET, "", AgentOptions.OUTPUT, "Lcom/google/android/exoplayer2/text/TextOutput;", "outputLooper", "Landroid/os/Looper;", "decoderFactory", "Lcom/google/android/exoplayer2/text/SubtitleDecoderFactory;", "(JLcom/google/android/exoplayer2/text/TextOutput;Landroid/os/Looper;Lcom/google/android/exoplayer2/text/SubtitleDecoderFactory;)V", "offsetPositionUs", "getRenderOffsetMs", "render", "", "positionUs", "elapsedRealtimeUs", "setRenderOffsetMs", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.CustomTextRenderer */
/* loaded from: classes3.dex */
public final class CustomTextRenderer extends NonFinalTextRenderer {
    private long offsetPositionUs;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ CustomTextRenderer(long r7, com.google.android.exoplayer2.text.TextOutput r9, android.os.Looper r10, com.google.android.exoplayer2.text.SubtitleDecoderFactory r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r12 = r12 & 8
            if (r12 == 0) goto Lb
            com.google.android.exoplayer2.text.SubtitleDecoderFactory r11 = com.google.android.exoplayer2.text.SubtitleDecoderFactory.DEFAULT
            java.lang.String r12 = "DEFAULT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
        Lb:
            r5 = r11
            r0 = r6
            r1 = r7
            r3 = r9
            r4 = r10
            r0.<init>(r1, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.CustomTextRenderer.<init>(long, com.google.android.exoplayer2.text.TextOutput, android.os.Looper, com.google.android.exoplayer2.text.SubtitleDecoderFactory, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTextRenderer(long j, TextOutput textOutput, Looper looper, SubtitleDecoderFactory decoderFactory) {
        super(textOutput, looper, decoderFactory);
        Intrinsics.checkNotNullParameter(decoderFactory, "decoderFactory");
        setRenderOffsetMs(j);
    }

    public final void setRenderOffsetMs(long j) {
        this.offsetPositionUs = j * 1000;
    }

    public final long getRenderOffsetMs() {
        return this.offsetPositionUs / 1000;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.NonFinalTextRenderer, com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        long j3 = this.offsetPositionUs;
        super.render(j + j3, j2 + j3);
    }
}
