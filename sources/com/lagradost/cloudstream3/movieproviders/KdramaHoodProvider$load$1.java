package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KdramaHoodProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.KdramaHoodProvider", m98f = "KdramaHoodProvider.kt", m97i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m96l = {97, 155}, m95m = "load", m94n = {"this", "url", "this", "url", "title", "poster", "descript", "year", "recs", "destination$iv$iv", "listOfLinks", "count"}, m93s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "I$0"})
/* loaded from: classes3.dex */
public final class KdramaHoodProvider$load$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KdramaHoodProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KdramaHoodProvider$load$1(KdramaHoodProvider kdramaHoodProvider, Continuation<? super KdramaHoodProvider$load$1> continuation) {
        super(continuation);
        this.this$0 = kdramaHoodProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.load(null, this);
    }
}
