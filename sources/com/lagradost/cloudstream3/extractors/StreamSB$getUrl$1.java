package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StreamSB.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.StreamSB", m98f = "StreamSB.kt", m97i = {0, 0, 0, 1, 1, 1, 1, 1}, m96l = {106, 111}, m95m = "getUrl$suspendImpl", m94n = {"this", "url", "headers", "this", "url", "headers", "urltext", "mapped"}, m93s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes3.dex */
public final class StreamSB$getUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamSB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamSB$getUrl$1(StreamSB streamSB, Continuation<? super StreamSB$getUrl$1> continuation) {
        super(continuation);
        this.this$0 = streamSB;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StreamSB.getUrl$suspendImpl(this.this$0, (String) null, (String) null, (Continuation) this);
    }
}
