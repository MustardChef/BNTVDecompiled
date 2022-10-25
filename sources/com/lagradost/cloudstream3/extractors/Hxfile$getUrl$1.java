package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hxfile.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Hxfile", m98f = "Hxfile.kt", m97i = {0, 0, 0}, m96l = {44}, m95m = "getUrl$suspendImpl", m94n = {"this", "url", "sources"}, m93s = {"L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class Hxfile$getUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Hxfile this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Hxfile$getUrl$1(Hxfile hxfile, Continuation<? super Hxfile$getUrl$1> continuation) {
        super(continuation);
        this.this$0 = hxfile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Hxfile.getUrl$suspendImpl(this.this$0, (String) null, (String) null, (Continuation) this);
    }
}
