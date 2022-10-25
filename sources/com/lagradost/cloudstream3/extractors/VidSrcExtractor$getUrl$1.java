package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VidSrcExtractor.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.VidSrcExtractor", m98f = "VidSrcExtractor.kt", m97i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, m96l = {36, 43}, m95m = "getUrl$suspendImpl", m94n = {"this", "url", "subtitleCallback", "callback", "this", "url", "subtitleCallback", "callback", "destination$iv$iv"}, m93s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes3.dex */
public final class VidSrcExtractor$getUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VidSrcExtractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VidSrcExtractor$getUrl$1(VidSrcExtractor vidSrcExtractor, Continuation<? super VidSrcExtractor$getUrl$1> continuation) {
        super(continuation);
        this.this$0 = vidSrcExtractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VidSrcExtractor.getUrl$suspendImpl(this.this$0, (String) null, (String) null, (Function1) null, (Function1) null, (Continuation) this);
    }
}
