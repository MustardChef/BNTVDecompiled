package com.lagradost.cloudstream3.syncproviders.providers;

import com.lagradost.cloudstream3.syncproviders.providers.AniListApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AniListApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion", m98f = "AniListApi.kt", m97i = {}, m96l = {258}, m95m = "searchShows", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class AniListApi$Companion$searchShows$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AniListApi.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AniListApi$Companion$searchShows$1(AniListApi.Companion companion, Continuation<? super AniListApi$Companion$searchShows$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.searchShows(null, this);
    }
}
