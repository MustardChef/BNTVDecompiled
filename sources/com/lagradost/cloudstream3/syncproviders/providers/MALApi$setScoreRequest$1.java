package com.lagradost.cloudstream3.syncproviders.providers;

import com.lagradost.cloudstream3.syncproviders.providers.MALApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MALApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.syncproviders.providers.MALApi", m98f = "MALApi.kt", m97i = {0, 0}, m96l = {589}, m95m = "setScoreRequest", m94n = {"this", "id"}, m93s = {"L$0", "I$0"})
/* loaded from: classes3.dex */
public final class MALApi$setScoreRequest$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MALApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MALApi$setScoreRequest$1(MALApi mALApi, Continuation<? super MALApi$setScoreRequest$1> continuation) {
        super(continuation);
        this.this$0 = mALApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object scoreRequest;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        scoreRequest = this.this$0.setScoreRequest(0, (MALApi.MalStatusType) null, (Integer) null, (Integer) null, this);
        return scoreRequest;
    }
}
