package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TheFlixToProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.TheFlixToProvider", m98f = "TheFlixToProvider.kt", m97i = {}, m96l = {120}, m95m = "getCookies", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class TheFlixToProvider$getCookies$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TheFlixToProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TheFlixToProvider$getCookies$1(TheFlixToProvider theFlixToProvider, Continuation<? super TheFlixToProvider$getCookies$1> continuation) {
        super(continuation);
        this.this$0 = theFlixToProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object cookies;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        cookies = this.this$0.getCookies(this);
        return cookies;
    }
}
