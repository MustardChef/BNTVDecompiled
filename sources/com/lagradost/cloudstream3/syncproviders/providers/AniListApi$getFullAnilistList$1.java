package com.lagradost.cloudstream3.syncproviders.providers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AniListApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.syncproviders.providers.AniListApi", m98f = "AniListApi.kt", m97i = {}, m96l = {684}, m95m = "getFullAnilistList", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class AniListApi$getFullAnilistList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AniListApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AniListApi$getFullAnilistList$1(AniListApi aniListApi, Continuation<? super AniListApi$getFullAnilistList$1> continuation) {
        super(continuation);
        this.this$0 = aniListApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fullAnilistList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fullAnilistList = this.this$0.getFullAnilistList(this);
        return fullAnilistList;
    }
}
