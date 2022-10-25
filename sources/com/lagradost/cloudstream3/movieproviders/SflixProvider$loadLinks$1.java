package com.lagradost.cloudstream3.movieproviders;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SflixProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SflixProvider", m98f = "SflixProvider.kt", m97i = {0, 0, 0, 0, 0}, m96l = {TypedValues.AttributesType.TYPE_PIVOT_TARGET}, m95m = "loadLinks$suspendImpl", m94n = {"this", "data", "subtitleCallback", "callback", "prefix"}, m93s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes3.dex */
public final class SflixProvider$loadLinks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SflixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SflixProvider$loadLinks$1(SflixProvider sflixProvider, Continuation<? super SflixProvider$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = sflixProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SflixProvider.loadLinks$suspendImpl(this.this$0, (String) null, false, (Function1) null, (Function1) null, (Continuation) this);
    }
}
