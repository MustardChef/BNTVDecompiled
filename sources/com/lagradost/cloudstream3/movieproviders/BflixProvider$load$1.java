package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BflixProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.BflixProvider", m98f = "BflixProvider.kt", m97i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, m96l = {bqk.f6553bM, bqk.f6543bC}, m95m = "load$suspendImpl", m94n = {"this", "url", "this", "url", "soup", "title", "description", "poster", "tags"}, m93s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
/* loaded from: classes3.dex */
public final class BflixProvider$load$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BflixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BflixProvider$load$1(BflixProvider bflixProvider, Continuation<? super BflixProvider$load$1> continuation) {
        super(continuation);
        this.this$0 = bflixProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BflixProvider.load$suspendImpl(this.this$0, (String) null, (Continuation) this);
    }
}
