package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Supervideo.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Supervideo", m98f = "Supervideo.kt", m97i = {0, 0, 0}, m96l = {20}, m95m = "getUrl$suspendImpl", m94n = {"this", "url", "extractedLinksList"}, m93s = {"L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class Supervideo$getUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Supervideo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Supervideo$getUrl$1(Supervideo supervideo, Continuation<? super Supervideo$getUrl$1> continuation) {
        super(continuation);
        this.this$0 = supervideo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Supervideo.getUrl$suspendImpl(this.this$0, (String) null, (String) null, (Continuation) this);
    }
}
