package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.StreamingcommunityProvider", m98f = "StreamingcommunityProvider.kt", m97i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m96l = {bqk.f6533at, bqk.f6538ay, 305}, m95m = "load", m94n = {"this", "url", "this", "url", "document", "poster", "this", "url", "document", "poster", "datajs", "type", "trailerurl", "year", "listacorr", "destination$iv$iv", "name", "img", "number", "ip", "idcorr"}, m93s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "J$0"})
/* loaded from: classes3.dex */
public final class StreamingcommunityProvider$load$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
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
    final /* synthetic */ StreamingcommunityProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamingcommunityProvider$load$1(StreamingcommunityProvider streamingcommunityProvider, Continuation<? super StreamingcommunityProvider$load$1> continuation) {
        super(continuation);
        this.this$0 = streamingcommunityProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.load(null, this);
    }
}
