package com.lagradost.cloudstream3.movieproviders;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PelisplusHDProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PelisplusHDProvider", m98f = "PelisplusHDProvider.kt", m97i = {0, 0}, m96l = {21}, m95m = "getMainPage", m94n = {"this", FirebaseAnalytics.Param.ITEMS}, m93s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class PelisplusHDProvider$getMainPage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PelisplusHDProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PelisplusHDProvider$getMainPage$1(PelisplusHDProvider pelisplusHDProvider, Continuation<? super PelisplusHDProvider$getMainPage$1> continuation) {
        super(continuation);
        this.this$0 = pelisplusHDProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMainPage(this);
    }
}