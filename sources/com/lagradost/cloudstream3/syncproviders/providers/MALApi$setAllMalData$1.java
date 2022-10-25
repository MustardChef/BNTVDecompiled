package com.lagradost.cloudstream3.syncproviders.providers;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MALApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.syncproviders.providers.MALApi", m98f = "MALApi.kt", m97i = {0, 0, 0, 0, 1, 1, 1}, m96l = {481, 483}, m95m = "setAllMalData", m94n = {"this", "user", "isDone", FirebaseAnalytics.Param.INDEX, "this", "user", FirebaseAnalytics.Param.INDEX}, m93s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0"})
/* loaded from: classes3.dex */
public final class MALApi$setAllMalData$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MALApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MALApi$setAllMalData$1(MALApi mALApi, Continuation<? super MALApi$setAllMalData$1> continuation) {
        super(continuation);
        this.this$0 = mALApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setAllMalData(this);
    }
}
