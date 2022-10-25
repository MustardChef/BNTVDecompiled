package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PelisplusProviderTemplate.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PelisplusProviderTemplate", m98f = "PelisplusProviderTemplate.kt", m97i = {0, 0, 0, 0}, m96l = {bqk.f6543bC}, m95m = "loadLinks$suspendImpl", m94n = {"this", "data", "subtitleCallback", "callback"}, m93s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes3.dex */
public final class PelisplusProviderTemplate$loadLinks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PelisplusProviderTemplate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PelisplusProviderTemplate$loadLinks$1(PelisplusProviderTemplate pelisplusProviderTemplate, Continuation<? super PelisplusProviderTemplate$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = pelisplusProviderTemplate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PelisplusProviderTemplate.loadLinks$suspendImpl(this.this$0, (String) null, false, (Function1) null, (Function1) null, (Continuation) this);
    }
}
