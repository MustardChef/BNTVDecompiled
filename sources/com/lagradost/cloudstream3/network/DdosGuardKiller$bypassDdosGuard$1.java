package com.lagradost.cloudstream3.network;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DdosGuardKiller.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.network.DdosGuardKiller", m98f = "DdosGuardKiller.kt", m97i = {0, 0, 1, 1, 2}, m96l = {38, 47, 61}, m95m = "bypassDdosGuard", m94n = {"this", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "this", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "$this$await$iv"}, m93s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
/* loaded from: classes3.dex */
public final class DdosGuardKiller$bypassDdosGuard$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DdosGuardKiller this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DdosGuardKiller$bypassDdosGuard$1(DdosGuardKiller ddosGuardKiller, Continuation<? super DdosGuardKiller$bypassDdosGuard$1> continuation) {
        super(continuation);
        this.this$0 = ddosGuardKiller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object bypassDdosGuard;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        bypassDdosGuard = this.this$0.bypassDdosGuard(null, this);
        return bypassDdosGuard;
    }
}
