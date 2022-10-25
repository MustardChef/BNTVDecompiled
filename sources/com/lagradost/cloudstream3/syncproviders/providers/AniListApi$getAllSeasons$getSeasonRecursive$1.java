package com.lagradost.cloudstream3.syncproviders.providers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AniListApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.syncproviders.providers.AniListApi", m98f = "AniListApi.kt", m97i = {0, 1}, m96l = {770, 776}, m95m = "getAllSeasons$getSeasonRecursive", m94n = {"seasons", "seasons"}, m93s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class AniListApi$getAllSeasons$getSeasonRecursive$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AniListApi$getAllSeasons$getSeasonRecursive$1(Continuation<? super AniListApi$getAllSeasons$getSeasonRecursive$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object allSeasons$getSeasonRecursive;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        allSeasons$getSeasonRecursive = AniListApi.getAllSeasons$getSeasonRecursive(null, 0, this);
        return allSeasons$getSeasonRecursive;
    }
}
