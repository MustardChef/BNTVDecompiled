package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IdlixProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.IdlixProvider", m98f = "IdlixProvider.kt", m97i = {0, 0, 0, 0, 0}, m96l = {295}, m95m = "invokeCdnSource", m94n = {"this", "url", "subCallback", "sourceCallback", "domainUrl"}, m93s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes3.dex */
public final class IdlixProvider$invokeCdnSource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IdlixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdlixProvider$invokeCdnSource$1(IdlixProvider idlixProvider, Continuation<? super IdlixProvider$invokeCdnSource$1> continuation) {
        super(continuation);
        this.this$0 = idlixProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object invokeCdnSource;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        invokeCdnSource = this.this$0.invokeCdnSource(null, null, null, this);
        return invokeCdnSource;
    }
}