package com.lagradost.cloudstream3.utils;

import android.app.Notification;
import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadManager.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadCheck$1", m98f = "VideoDownloadManager.kt", m97i = {0}, m96l = {1454}, m95m = "invokeSuspend", m94n = {FirebaseAnalytics.Param.INDEX}, m93s = {"I$0"})
/* loaded from: classes4.dex */
public final class VideoDownloadManager$downloadCheck$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $id;
    final /* synthetic */ VideoDownloadManager.DownloadItem $item;
    final /* synthetic */ Function2<Integer, Notification, Unit> $notificationCallback;
    final /* synthetic */ VideoDownloadManager.DownloadResumePackage $pkg;
    int I$0;
    int I$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoDownloadManager$downloadCheck$1(VideoDownloadManager.DownloadResumePackage downloadResumePackage, VideoDownloadManager.DownloadItem downloadItem, int i, Context context, Function2<? super Integer, ? super Notification, Unit> function2, Continuation<? super VideoDownloadManager$downloadCheck$1> continuation) {
        super(1, continuation);
        this.$pkg = downloadResumePackage;
        this.$item = downloadItem;
        this.$id = i;
        this.$context = context;
        this.$notificationCallback = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new VideoDownloadManager$downloadCheck$1(this.$pkg, this.$item, this.$id, this.$context, this.$notificationCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((VideoDownloadManager$downloadCheck$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046 A[Catch: Exception -> 0x00c3, all -> 0x00e6, TRY_ENTER, TryCatch #1 {all -> 0x00e6, blocks: (B:32:0x00ab, B:34:0x00af, B:36:0x00b5, B:18:0x0046, B:25:0x0065, B:29:0x008f, B:21:0x005c, B:45:0x00ca), top: B:51:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af A[Catch: Exception -> 0x00c3, all -> 0x00e6, TryCatch #1 {all -> 0x00e6, blocks: (B:32:0x00ab, B:34:0x00af, B:36:0x00b5, B:18:0x0046, B:25:0x0065, B:29:0x008f, B:21:0x005c, B:45:0x00ca), top: B:51:0x000b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00a8 -> B:52:0x00ab). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadCheck$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
