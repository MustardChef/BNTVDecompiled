package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IHaveNoTvProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.IHaveNoTvProvider", m98f = "IHaveNoTvProvider.kt", m97i = {0, 0}, m96l = {bqk.f6552bL, bqk.f6576bj}, m95m = "loadLinks", m94n = {"subtitleCallback", "callback"}, m93s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class IHaveNoTvProvider$loadLinks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IHaveNoTvProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IHaveNoTvProvider$loadLinks$1(IHaveNoTvProvider iHaveNoTvProvider, Continuation<? super IHaveNoTvProvider$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = iHaveNoTvProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLinks(null, false, null, null, this);
    }
}
