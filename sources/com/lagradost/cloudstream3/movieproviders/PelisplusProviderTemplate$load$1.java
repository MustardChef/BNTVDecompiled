package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PelisplusProviderTemplate.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PelisplusProviderTemplate", m98f = "PelisplusProviderTemplate.kt", m97i = {0, 0}, m96l = {73}, m95m = "load$suspendImpl", m94n = {"this", "url"}, m93s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class PelisplusProviderTemplate$load$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PelisplusProviderTemplate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PelisplusProviderTemplate$load$1(PelisplusProviderTemplate pelisplusProviderTemplate, Continuation<? super PelisplusProviderTemplate$load$1> continuation) {
        super(continuation);
        this.this$0 = pelisplusProviderTemplate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PelisplusProviderTemplate.load$suspendImpl(this.this$0, (String) null, (Continuation) this);
    }
}
