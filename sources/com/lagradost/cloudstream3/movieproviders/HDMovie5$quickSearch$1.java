package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HDMovie5.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.HDMovie5", m98f = "HDMovie5.kt", m97i = {0}, m96l = {59}, m95m = "quickSearch", m94n = {"this"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class HDMovie5$quickSearch$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HDMovie5 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HDMovie5$quickSearch$1(HDMovie5 hDMovie5, Continuation<? super HDMovie5$quickSearch$1> continuation) {
        super(continuation);
        this.this$0 = hDMovie5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.quickSearch(null, this);
    }
}
