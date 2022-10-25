package com.lagradost.cloudstream3.extractors.helper;

import com.lagradost.cloudstream3.extractors.helper.VstreamhubHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VstreamhubHelper.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.helper.VstreamhubHelper$Companion", m98f = "VstreamhubHelper.kt", m97i = {0, 0, 0, 1, 1, 1}, m96l = {21, 49}, m95m = "getUrls", m94n = {"url", "subtitleCallback", "callback", "url", "subtitleCallback", "callback"}, m93s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class VstreamhubHelper$Companion$getUrls$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VstreamhubHelper.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VstreamhubHelper$Companion$getUrls$1(VstreamhubHelper.Companion companion, Continuation<? super VstreamhubHelper$Companion$getUrls$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getUrls(null, null, null, this);
    }
}
