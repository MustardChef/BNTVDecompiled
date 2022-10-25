package com.lagradost.cloudstream3.movieproviders;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PinoyHDXyzProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PinoyHDXyzProvider", m98f = "PinoyHDXyzProvider.kt", m97i = {0, 0}, m96l = {20}, m95m = "getMainPage", m94n = {"this", TtmlNode.COMBINE_ALL}, m93s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class PinoyHDXyzProvider$getMainPage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PinoyHDXyzProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinoyHDXyzProvider$getMainPage$1(PinoyHDXyzProvider pinoyHDXyzProvider, Continuation<? super PinoyHDXyzProvider$getMainPage$1> continuation) {
        super(continuation);
        this.this$0 = pinoyHDXyzProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMainPage(this);
    }
}
