package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HDMProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.HDMProvider", m98f = "HDMProvider.kt", m97i = {0, 0, 0}, m96l = {41}, m95m = "loadLinks", m94n = {"this", "callback", "slug"}, m93s = {"L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class HDMProvider$loadLinks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HDMProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HDMProvider$loadLinks$1(HDMProvider hDMProvider, Continuation<? super HDMProvider$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = hDMProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLinks(null, false, null, null, this);
    }
}
