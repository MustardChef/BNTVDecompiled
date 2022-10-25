package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RebahinProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.RebahinProvider", m98f = "RebahinProvider.kt", m97i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m96l = {167, 179}, m95m = "invokeLokalSource", m94n = {"name", "ref", "subCallback", "sourceCallback", "name", "ref", "subCallback", "sourceCallback", "destination$iv$iv", "script", "source"}, m93s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7"})
/* loaded from: classes3.dex */
public final class RebahinProvider$invokeLokalSource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RebahinProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RebahinProvider$invokeLokalSource$1(RebahinProvider rebahinProvider, Continuation<? super RebahinProvider$invokeLokalSource$1> continuation) {
        super(continuation);
        this.this$0 = rebahinProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object invokeLokalSource;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        invokeLokalSource = this.this$0.invokeLokalSource(null, null, null, null, null, this);
        return invokeLokalSource;
    }
}
