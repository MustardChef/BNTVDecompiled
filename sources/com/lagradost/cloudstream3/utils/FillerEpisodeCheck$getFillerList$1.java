package com.lagradost.cloudstream3.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FillerEpisodeCheck.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.FillerEpisodeCheck", m98f = "FillerEpisodeCheck.kt", m97i = {0}, m96l = {22}, m95m = "getFillerList", m94n = {"this"}, m93s = {"L$0"})
/* loaded from: classes4.dex */
public final class FillerEpisodeCheck$getFillerList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FillerEpisodeCheck this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FillerEpisodeCheck$getFillerList$1(FillerEpisodeCheck fillerEpisodeCheck, Continuation<? super FillerEpisodeCheck$getFillerList$1> continuation) {
        super(continuation);
        this.this$0 = fillerEpisodeCheck;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fillerList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fillerList = this.this$0.getFillerList(this);
        return fillerList;
    }
}
