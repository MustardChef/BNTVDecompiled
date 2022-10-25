package com.lagradost.cloudstream3.utils;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadFileWorkManager.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.DownloadFileWorkManager", m98f = "DownloadFileWorkManager.kt", m97i = {0, 0, 0}, m96l = {83}, m95m = "awaitDownload", m94n = {"isDone", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "id"}, m93s = {"L$0", "L$1", "I$0"})
/* loaded from: classes4.dex */
public final class DownloadFileWorkManager$awaitDownload$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadFileWorkManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadFileWorkManager$awaitDownload$1(DownloadFileWorkManager downloadFileWorkManager, Continuation<? super DownloadFileWorkManager$awaitDownload$1> continuation) {
        super(continuation);
        this.this$0 = downloadFileWorkManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object awaitDownload;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitDownload = this.this$0.awaitDownload(0, this);
        return awaitDownload;
    }
}
