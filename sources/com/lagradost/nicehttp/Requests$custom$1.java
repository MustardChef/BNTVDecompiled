package com.lagradost.nicehttp;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Requests.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.nicehttp.Requests", m98f = "Requests.kt", m97i = {0}, m96l = {581}, m95m = "custom", m94n = {"$this$await$iv"}, m93s = {"L$0"})
/* loaded from: classes4.dex */
public final class Requests$custom$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Requests this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Requests$custom$1(Requests requests, Continuation<? super Requests$custom$1> continuation) {
        super(continuation);
        this.this$0 = requests;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.custom(null, null, null, null, null, null, null, null, null, null, false, 0, null, 0L, null, false, this);
    }
}
