package com.lagradost.cloudstream3.movieproviders;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BflixProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.BflixProvider", m98f = "BflixProvider.kt", m97i = {0, 0}, m96l = {25}, m95m = "getMainPage$suspendImpl", m94n = {"this", FirebaseAnalytics.Param.ITEMS}, m93s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class BflixProvider$getMainPage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BflixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BflixProvider$getMainPage$1(BflixProvider bflixProvider, Continuation<? super BflixProvider$getMainPage$1> continuation) {
        super(continuation);
        this.this$0 = bflixProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BflixProvider.getMainPage$suspendImpl(this.this$0, (Continuation) this);
    }
}
