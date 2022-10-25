package com.lagradost.cloudstream3.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExtractorApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.ExtractorApi", m98f = "ExtractorApi.kt", m97i = {0}, m96l = {385}, m95m = "getUrl$suspendImpl", m94n = {"callback"}, m93s = {"L$0"})
/* loaded from: classes4.dex */
public final class ExtractorApi$getUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExtractorApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtractorApi$getUrl$1(ExtractorApi extractorApi, Continuation<? super ExtractorApi$getUrl$1> continuation) {
        super(continuation);
        this.this$0 = extractorApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ExtractorApi.getUrl$suspendImpl(this.this$0, null, null, null, null, this);
    }
}
