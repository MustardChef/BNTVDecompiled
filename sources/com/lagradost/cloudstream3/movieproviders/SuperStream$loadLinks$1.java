package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SuperStream.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SuperStream", m98f = "SuperStream.kt", m97i = {0, 0, 0, 0, 1}, m96l = {683, 691}, m95m = "loadLinks", m94n = {"this", "subtitleCallback", "callback", "parsed", "subtitleCallback"}, m93s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
/* loaded from: classes3.dex */
public final class SuperStream$loadLinks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SuperStream this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperStream$loadLinks$1(SuperStream superStream, Continuation<? super SuperStream$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = superStream;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLinks(null, false, null, null, this);
    }
}
