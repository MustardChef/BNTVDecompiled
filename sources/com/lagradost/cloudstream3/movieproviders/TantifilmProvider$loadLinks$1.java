package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TantiFilmProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.TantifilmProvider", m98f = "TantiFilmProvider.kt", m97i = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, m96l = {bqk.f6565bY, bqk.f6598ce, 234, 235}, m95m = "loadLinks", m94n = {"this", "data", "subtitleCallback", "callback", "data", "subtitleCallback", "callback", "data", "subtitleCallback", "callback", "data", "subtitleCallback", "callback"}, m93s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class TantifilmProvider$loadLinks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TantiFilmProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TantifilmProvider$loadLinks$1(TantiFilmProvider tantiFilmProvider, Continuation<? super TantifilmProvider$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = tantiFilmProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLinks(null, false, null, null, this);
    }
}
