package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TwoEmbedProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.TwoEmbedProvider", m98f = "TwoEmbedProvider.kt", m97i = {0, 0, 0, 0}, m96l = {55}, m95m = "loadLinks", m94n = {"this", "subtitleCallback", "callback", "embedUrl"}, m93s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes3.dex */
public final class TwoEmbedProvider$loadLinks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TwoEmbedProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoEmbedProvider$loadLinks$1(TwoEmbedProvider twoEmbedProvider, Continuation<? super TwoEmbedProvider$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = twoEmbedProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLinks(null, false, null, null, this);
    }
}
