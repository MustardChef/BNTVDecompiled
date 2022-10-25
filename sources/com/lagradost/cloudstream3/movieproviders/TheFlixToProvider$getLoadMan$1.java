package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.internal.http.HttpStatusCodes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TheFlixToProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.TheFlixToProvider", m98f = "TheFlixToProvider.kt", m97i = {0}, m96l = {HttpStatusCodes.HTTP_INSUFFICIENT_SPACE_ON_RESOURCE, 420}, m95m = "getLoadMan", m94n = {"url"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class TheFlixToProvider$getLoadMan$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TheFlixToProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TheFlixToProvider$getLoadMan$1(TheFlixToProvider theFlixToProvider, Continuation<? super TheFlixToProvider$getLoadMan$1> continuation) {
        super(continuation);
        this.this$0 = theFlixToProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadMan;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadMan = this.this$0.getLoadMan(null, this);
        return loadMan;
    }
}
