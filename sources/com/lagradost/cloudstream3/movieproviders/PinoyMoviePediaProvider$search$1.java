package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PinoyMoviePediaProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PinoyMoviePediaProvider", m98f = "PinoyMoviePediaProvider.kt", m97i = {0}, m96l = {86}, m95m = "search", m94n = {"this"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class PinoyMoviePediaProvider$search$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PinoyMoviePediaProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinoyMoviePediaProvider$search$1(PinoyMoviePediaProvider pinoyMoviePediaProvider, Continuation<? super PinoyMoviePediaProvider$search$1> continuation) {
        super(continuation);
        this.this$0 = pinoyMoviePediaProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.search(null, this);
    }
}
