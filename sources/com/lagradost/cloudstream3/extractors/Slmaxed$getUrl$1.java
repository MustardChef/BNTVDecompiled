package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Streamlare.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Slmaxed", m98f = "Streamlare.kt", m97i = {0, 0}, m96l = {42}, m95m = "getUrl$suspendImpl", m94n = {"this", "url"}, m93s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class Slmaxed$getUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Slmaxed this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Slmaxed$getUrl$1(Slmaxed slmaxed, Continuation<? super Slmaxed$getUrl$1> continuation) {
        super(continuation);
        this.this$0 = slmaxed;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Slmaxed.getUrl$suspendImpl(this.this$0, (String) null, (String) null, (Continuation) this);
    }
}
