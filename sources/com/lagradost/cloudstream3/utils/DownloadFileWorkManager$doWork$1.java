package com.lagradost.cloudstream3.utils;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadFileWorkManager.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.DownloadFileWorkManager", m98f = "DownloadFileWorkManager.kt", m97i = {0, 0, 1, 1, 2, 2}, m96l = {31, 46, 49}, m95m = "doWork", m94n = {"this", SDKConstants.PARAM_KEY, "this", SDKConstants.PARAM_KEY, "this", SDKConstants.PARAM_KEY}, m93s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes4.dex */
public final class DownloadFileWorkManager$doWork$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadFileWorkManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadFileWorkManager$doWork$1(DownloadFileWorkManager downloadFileWorkManager, Continuation<? super DownloadFileWorkManager$doWork$1> continuation) {
        super(continuation);
        this.this$0 = downloadFileWorkManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
