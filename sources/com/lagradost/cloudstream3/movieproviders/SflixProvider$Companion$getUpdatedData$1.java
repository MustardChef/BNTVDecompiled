package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.movieproviders.SflixProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SflixProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion", m98f = "SflixProvider.kt", m97i = {0}, m96l = {469}, m95m = "getUpdatedData", m94n = {"data"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class SflixProvider$Companion$getUpdatedData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SflixProvider.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SflixProvider$Companion$getUpdatedData$1(SflixProvider.Companion companion, Continuation<? super SflixProvider$Companion$getUpdatedData$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object updatedData;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updatedData = this.this$0.getUpdatedData(null, null, null, this);
        return updatedData;
    }
}
