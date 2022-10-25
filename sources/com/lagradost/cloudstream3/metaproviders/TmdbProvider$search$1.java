package com.lagradost.cloudstream3.metaproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TmdbProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.metaproviders.TmdbProvider", m98f = "TmdbProvider.kt", m97i = {0}, m96l = {359}, m95m = "search$suspendImpl", m94n = {"this"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class TmdbProvider$search$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TmdbProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TmdbProvider$search$1(TmdbProvider tmdbProvider, Continuation<? super TmdbProvider$search$1> continuation) {
        super(continuation);
        this.this$0 = tmdbProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TmdbProvider.search$suspendImpl(this.this$0, (String) null, (Continuation) this);
    }
}
