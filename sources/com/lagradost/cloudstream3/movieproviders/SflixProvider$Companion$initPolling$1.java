package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.movieproviders.SflixProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SflixProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion", m98f = "SflixProvider.kt", m97i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3}, m96l = {485, 486, 495, 505}, m95m = "initPolling", m94n = {"this", "extractorData", "headers", "this", "extractorData", "headers", "data", "this", "extractorData", "headers", "data", "data", "reconnectSid"}, m93s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
/* loaded from: classes3.dex */
public final class SflixProvider$Companion$initPolling$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SflixProvider.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SflixProvider$Companion$initPolling$1(SflixProvider.Companion companion, Continuation<? super SflixProvider$Companion$initPolling$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object initPolling;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        initPolling = this.this$0.initPolling(null, null, this);
        return initPolling;
    }
}
