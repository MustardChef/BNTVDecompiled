package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VfFilmProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.VfFilmProvider", m98f = "VfFilmProvider.kt", m97i = {}, m96l = {63, 66}, m95m = "getDirect", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class VfFilmProvider$getDirect$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VfFilmProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VfFilmProvider$getDirect$1(VfFilmProvider vfFilmProvider, Continuation<? super VfFilmProvider$getDirect$1> continuation) {
        super(continuation);
        this.this$0 = vfFilmProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object direct;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        direct = this.this$0.getDirect(null, this);
        return direct;
    }
}
