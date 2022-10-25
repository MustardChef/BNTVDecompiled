package com.lagradost.cloudstream3.utils;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadManager.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.VideoDownloadManager", m98f = "VideoDownloadManager.kt", m97i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m96l = {307}, m95m = "createNotification", m94n = {"this", "context", "linkName", "ep", ServerProtocol.DIALOG_PARAM_STATE, "notificationCallback", "hlsProgress", "hlsTotal", "builder", "rowTwo", "downloadFormat", "progress", "total"}, m93s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "J$0", "J$1"})
/* loaded from: classes4.dex */
public final class VideoDownloadManager$createNotification$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoDownloadManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadManager$createNotification$1(VideoDownloadManager videoDownloadManager, Continuation<? super VideoDownloadManager$createNotification$1> continuation) {
        super(continuation);
        this.this$0 = videoDownloadManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object createNotification;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        createNotification = this.this$0.createNotification(null, null, null, null, null, 0L, 0L, null, null, null, this);
        return createNotification;
    }
}
