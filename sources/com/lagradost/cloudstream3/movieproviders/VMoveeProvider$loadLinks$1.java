package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VMoveeProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.VMoveeProvider", m98f = "VMoveeProvider.kt", m97i = {0, 0, 1, 1, 2, 2}, m96l = {72, 84, 88}, m95m = "loadLinks", m94n = {"this", "callback", "this", "callback", "this", "callback"}, m93s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes3.dex */
public final class VMoveeProvider$loadLinks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VMoveeProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VMoveeProvider$loadLinks$1(VMoveeProvider vMoveeProvider, Continuation<? super VMoveeProvider$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = vMoveeProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLinks(null, false, null, null, this);
    }
}
