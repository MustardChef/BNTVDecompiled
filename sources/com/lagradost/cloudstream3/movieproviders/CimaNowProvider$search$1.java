package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CimaNowProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CimaNowProvider", m98f = "CimaNowProvider.kt", m97i = {0, 0, 0}, m96l = {60}, m95m = "search", m94n = {"this", "query", "result"}, m93s = {"L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class CimaNowProvider$search$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CimaNowProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CimaNowProvider$search$1(CimaNowProvider cimaNowProvider, Continuation<? super CimaNowProvider$search$1> continuation) {
        super(continuation);
        this.this$0 = cimaNowProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.search(null, this);
    }
}
