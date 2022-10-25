package com.lagradost.cloudstream3.syncproviders.providers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MALApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.syncproviders.providers.MALApi", m98f = "MALApi.kt", m97i = {0}, m96l = {467}, m95m = "getDataAboutMalId", m94n = {"this"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class MALApi$getDataAboutMalId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MALApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MALApi$getDataAboutMalId$1(MALApi mALApi, Continuation<? super MALApi$getDataAboutMalId$1> continuation) {
        super(continuation);
        this.this$0 = mALApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object dataAboutMalId;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        dataAboutMalId = this.this$0.getDataAboutMalId(0, this);
        return dataAboutMalId;
    }
}
