package com.lagradost.cloudstream3.p041ui.livetv;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LiveTvViewModel.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.livetv.LiveTvViewModel", m98f = "LiveTvViewModel.kt", m97i = {}, m96l = {29}, m95m = "getIPTV", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.livetv.LiveTvViewModel$getIPTV$1 */
/* loaded from: classes3.dex */
public final class LiveTvViewModel$getIPTV$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveTvViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveTvViewModel$getIPTV$1(LiveTvViewModel liveTvViewModel, Continuation<? super LiveTvViewModel$getIPTV$1> continuation) {
        super(continuation);
        this.this$0 = liveTvViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getIPTV(this);
    }
}
