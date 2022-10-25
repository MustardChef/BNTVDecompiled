package com.lagradost.cloudstream3.movieproviders;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BongNgoProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.BongNgoProvider", m98f = "BongNgoProvider.kt", m97i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, m96l = {201, bqk.f6553bM, bqk.f6536aw, TypedValues.AttributesType.TYPE_PIVOT_TARGET}, m95m = "loadLinks", m94n = {"this", "subtitleCallback", "callback", "this", "subtitleCallback", "callback", "this", "subtitleCallback", "callback", "source", "listSourceFinal", "itemSource", "subtitleList", "urlPlaylist", FirebaseAnalytics.Param.INDEX, "this", "subtitleCallback", "callback", "source", "listSourceFinal", FirebaseAnalytics.Param.INDEX}, m93s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
/* loaded from: classes3.dex */
public final class BongNgoProvider$loadLinks$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BongNgoProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BongNgoProvider$loadLinks$1(BongNgoProvider bongNgoProvider, Continuation<? super BongNgoProvider$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = bongNgoProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLinks(null, false, null, null, this);
    }
}
