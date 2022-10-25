package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiplexProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.MultiplexProvider", m98f = "MultiplexProvider.kt", m97i = {0, 0, 1, 1, 2, 2, 3, 3, 3, 3, 3}, m96l = {170, 173, 178, 182}, m95m = "loadLinks", m94n = {"this", "callback", "this", "callback", "this", "callback", "this", "callback", "destination$iv$iv", "destination$iv$iv", "m3u"}, m93s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$6"})
/* loaded from: classes3.dex */
public final class MultiplexProvider$loadLinks$1 extends ContinuationImpl {
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
    final /* synthetic */ MultiplexProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiplexProvider$loadLinks$1(MultiplexProvider multiplexProvider, Continuation<? super MultiplexProvider$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = multiplexProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLinks(null, false, null, null, this);
    }
}
