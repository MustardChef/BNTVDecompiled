package com.lagradost.cloudstream3.utils;

import android.app.Notification;
import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.lagradost.cloudstream3.AcraApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadFileWorkManager.kt */
@Metadata(m108d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/DownloadFileWorkManager;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "getContext", "()Landroid/content/Context;", "awaitDownload", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleNotification", "notification", "Landroid/app/Notification;", "removeKeys", SDKConstants.PARAM_KEY, "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class DownloadFileWorkManager extends CoroutineWorker {
    private final Context context;
    private final WorkerParameters workerParams;

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadFileWorkManager(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.context = context;
        this.workerParams = workerParams;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|(1:(5:(1:(1:12)(2:19|20))(1:21)|13|14|15|16)(4:22|23|15|16))(8:24|25|26|27|(2:29|(2:31|(1:33)))(1:(5:36|37|38|39|(12:41|42|43|44|45|(1:47)(2:58|59)|48|(2:50|(1:52))(1:(2:55|(1:57)))|53|14|15|16)(11:62|43|44|45|(0)(0)|48|(0)(0)|53|14|15|16)))|34|15|16)|72|67|(1:69)|70|71))|73|6|7|(0)(0)|72|67|(0)|70|71) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105 A[Catch: Exception -> 0x0116, TRY_LEAVE, TryCatch #3 {Exception -> 0x0116, blocks: (B:43:0x00fa, B:46:0x0105), top: B:76:0x00fa }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011a A[Catch: Exception -> 0x019a, TryCatch #1 {Exception -> 0x019a, blocks: (B:25:0x0071, B:28:0x0091, B:30:0x00a7, B:34:0x00bc, B:42:0x00e9, B:48:0x0116, B:50:0x011a, B:54:0x0153), top: B:73:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a4  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.lagradost.cloudstream3.utils.DownloadFileWorkManager] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r21) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.DownloadFileWorkManager.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void removeKeys(String str) {
        AcraApplication.Companion.removeKey(VideoDownloadManager.WORK_KEY_INFO, str);
        AcraApplication.Companion.removeKey(VideoDownloadManager.WORK_KEY_PACKAGE, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object awaitDownload(int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.lagradost.cloudstream3.utils.DownloadFileWorkManager$awaitDownload$1
            if (r0 == 0) goto L14
            r0 = r9
            com.lagradost.cloudstream3.utils.DownloadFileWorkManager$awaitDownload$1 r0 = (com.lagradost.cloudstream3.utils.DownloadFileWorkManager$awaitDownload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.lagradost.cloudstream3.utils.DownloadFileWorkManager$awaitDownload$1 r0 = new com.lagradost.cloudstream3.utils.DownloadFileWorkManager$awaitDownload$1
            r0.<init>(r7, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            int r8 = r0.I$0
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r4 = (kotlin.jvm.internal.Ref.BooleanRef) r4
            kotlin.ResultKt.throwOnFailure(r9)
            goto L55
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$BooleanRef r9 = new kotlin.jvm.internal.Ref$BooleanRef
            r9.<init>()
            com.lagradost.cloudstream3.utils.DownloadFileWorkManager$awaitDownload$listener$1 r2 = new com.lagradost.cloudstream3.utils.DownloadFileWorkManager$awaitDownload$listener$1
            r2.<init>(r8, r9)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            com.lagradost.cloudstream3.utils.VideoDownloadManager r4 = com.lagradost.cloudstream3.utils.VideoDownloadManager.INSTANCE
            com.lagradost.cloudstream3.utils.Event r4 = r4.getDownloadStatusEvent()
            r4.plusAssign(r2)
            r4 = r9
        L55:
            boolean r9 = r4.element
            if (r9 != 0) goto L80
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r5 = "AWAITING "
            r9.append(r5)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            java.io.PrintStream r5 = java.lang.System.out
            r5.println(r9)
            r5 = 1000(0x3e8, double:4.94E-321)
            r0.L$0 = r4
            r0.L$1 = r2
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r9 != r1) goto L55
            return r1
        L80:
            com.lagradost.cloudstream3.utils.VideoDownloadManager r8 = com.lagradost.cloudstream3.utils.VideoDownloadManager.INSTANCE
            com.lagradost.cloudstream3.utils.Event r8 = r8.getDownloadStatusEvent()
            r8.minusAssign(r2)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.DownloadFileWorkManager.awaitDownload(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleNotification(int i, Notification notification) {
        Coroutines.INSTANCE.main(new DownloadFileWorkManager$handleNotification$1(this, i, notification, null));
    }
}
