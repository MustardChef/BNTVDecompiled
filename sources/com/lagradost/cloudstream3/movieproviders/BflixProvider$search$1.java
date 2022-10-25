package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BflixProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.BflixProvider", m98f = "BflixProvider.kt", m97i = {0}, m96l = {173}, m95m = "search$suspendImpl", m94n = {"this"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class BflixProvider$search$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BflixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BflixProvider$search$1(BflixProvider bflixProvider, Continuation<? super BflixProvider$search$1> continuation) {
        super(continuation);
        this.this$0 = bflixProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BflixProvider.search$suspendImpl(this.this$0, (String) null, (Continuation) this);
    }
}
