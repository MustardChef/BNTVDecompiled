package com.lagradost.cloudstream3.syncproviders.providers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MALApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.syncproviders.providers.MALApi", m98f = "MALApi.kt", m97i = {}, m96l = {622}, m95m = "setScoreRequest", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class MALApi$setScoreRequest$2 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MALApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MALApi$setScoreRequest$2(MALApi mALApi, Continuation<? super MALApi$setScoreRequest$2> continuation) {
        super(continuation);
        this.this$0 = mALApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object scoreRequest;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        scoreRequest = this.this$0.setScoreRequest(0, (String) null, (Integer) null, (Integer) null, this);
        return scoreRequest;
    }
}
