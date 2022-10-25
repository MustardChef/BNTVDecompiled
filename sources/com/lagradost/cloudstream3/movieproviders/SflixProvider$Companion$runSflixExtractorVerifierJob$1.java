package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.movieproviders.SflixProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SflixProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion", m98f = "SflixProvider.kt", m97i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4}, m96l = {530, 553, 552, 566, 576}, m95m = "runSflixExtractorVerifierJob", m94n = {"this", "api", "extractorData", "headers", "data", "reconnectSid", "this", "api", "extractorData", "headers", "data", "reconnectSid", "reconnect", "newAuth", "url", "interval", "this", "api", "extractorData", "headers", "data", "reconnectSid", "reconnect", "newAuth", "url", "interval", "this", "api", "extractorData", "headers", "data", "reconnectSid", "reconnect", "newAuth", "interval", "start$iv", "this", "api", "extractorData", "headers", "data", "reconnectSid", "reconnect", "newAuth", "interval"}, m93s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0"})
/* loaded from: classes3.dex */
public final class SflixProvider$Companion$runSflixExtractorVerifierJob$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SflixProvider.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SflixProvider$Companion$runSflixExtractorVerifierJob$1(SflixProvider.Companion companion, Continuation<? super SflixProvider$Companion$runSflixExtractorVerifierJob$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runSflixExtractorVerifierJob(null, null, null, this);
    }
}
