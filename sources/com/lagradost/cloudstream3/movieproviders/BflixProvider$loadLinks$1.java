package com.lagradost.cloudstream3.movieproviders;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BflixProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.BflixProvider", m98f = "BflixProvider.kt", m97i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, m96l = {FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 347, 372, 384}, m95m = "loadLinks$suspendImpl", m94n = {"this", "data", "subtitleCallback", "callback", "this", "data", "subtitleCallback", "callback", "this", "data", "subtitleCallback", "callback", "destination$iv$iv", "jsonservers", "destination$iv$iv", "this", "data", "subtitleCallback", "callback", "destination$iv$iv"}, m93s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes3.dex */
public final class BflixProvider$loadLinks$1 extends ContinuationImpl {
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
    final /* synthetic */ BflixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BflixProvider$loadLinks$1(BflixProvider bflixProvider, Continuation<? super BflixProvider$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = bflixProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BflixProvider.loadLinks$suspendImpl(this.this$0, (String) null, false, (Function1) null, (Function1) null, (Continuation) this);
    }
}
