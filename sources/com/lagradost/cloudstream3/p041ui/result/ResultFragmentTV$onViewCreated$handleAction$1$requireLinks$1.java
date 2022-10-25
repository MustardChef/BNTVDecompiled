package com.lagradost.cloudstream3.p041ui.result;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultFragmentTV.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$handleAction$1", m98f = "ResultFragmentTV.kt", m97i = {0, 0, 0, 0, 0}, m96l = {944}, m95m = "invokeSuspend$requireLinks", m94n = {"this$0", "currentLinks", "currentSubs", "loadingDialog", "currentLoad"}, m93s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$handleAction$1$requireLinks$1 */
/* loaded from: classes4.dex */
public final class ResultFragmentTV$onViewCreated$handleAction$1$requireLinks$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultFragmentTV$onViewCreated$handleAction$1$requireLinks$1(Continuation<? super ResultFragmentTV$onViewCreated$handleAction$1$requireLinks$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object invokeSuspend$requireLinks;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        invokeSuspend$requireLinks = ResultFragmentTV$onViewCreated$handleAction$1.invokeSuspend$requireLinks(null, null, null, null, null, false, false, this);
        return invokeSuspend$requireLinks;
    }
}
