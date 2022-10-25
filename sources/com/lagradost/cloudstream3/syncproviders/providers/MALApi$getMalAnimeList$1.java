package com.lagradost.cloudstream3.syncproviders.providers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MALApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.syncproviders.providers.MALApi", m98f = "MALApi.kt", m97i = {0, 1, 1, 1}, m96l = {430, 435}, m95m = "getMalAnimeList", m94n = {"this", "this", "fullList", "offsetRegex"}, m93s = {"L$0", "L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class MALApi$getMalAnimeList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MALApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MALApi$getMalAnimeList$1(MALApi mALApi, Continuation<? super MALApi$getMalAnimeList$1> continuation) {
        super(continuation);
        this.this$0 = mALApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object malAnimeList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        malAnimeList = this.this$0.getMalAnimeList(this);
        return malAnimeList;
    }
}
