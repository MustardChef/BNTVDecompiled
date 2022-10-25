package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Acefile.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Acefile", m98f = "Acefile.kt", m97i = {0, 0, 1, 1, 1}, m96l = {14, 19}, m95m = "getUrl", m94n = {"this", "sources", "this", "sources", "destination$iv$iv"}, m93s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class Acefile$getUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Acefile this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Acefile$getUrl$1(Acefile acefile, Continuation<? super Acefile$getUrl$1> continuation) {
        super(continuation);
        this.this$0 = acefile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getUrl(null, null, this);
    }
}
