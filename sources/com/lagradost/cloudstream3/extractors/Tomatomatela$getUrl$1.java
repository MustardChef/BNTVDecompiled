package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Tomatomatela.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Tomatomatela", m98f = "Tomatomatela.kt", m97i = {0}, m96l = {27}, m95m = "getUrl$suspendImpl", m94n = {"this"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class Tomatomatela$getUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Tomatomatela this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tomatomatela$getUrl$1(Tomatomatela tomatomatela, Continuation<? super Tomatomatela$getUrl$1> continuation) {
        super(continuation);
        this.this$0 = tomatomatela;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Tomatomatela.getUrl$suspendImpl(this.this$0, (String) null, (String) null, (Continuation) this);
    }
}
