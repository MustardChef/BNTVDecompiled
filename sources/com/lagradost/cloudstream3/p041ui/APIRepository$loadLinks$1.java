package com.lagradost.cloudstream3.p041ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: APIRepository.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.APIRepository", m98f = "APIRepository.kt", m97i = {}, m96l = {121}, m95m = "loadLinks", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.APIRepository$loadLinks$1 */
/* loaded from: classes.dex */
public final class APIRepository$loadLinks$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ APIRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APIRepository$loadLinks$1(APIRepository aPIRepository, Continuation<? super APIRepository$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = aPIRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLinks(null, false, null, null, this);
    }
}
