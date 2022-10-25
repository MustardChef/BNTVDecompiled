package com.lagradost.cloudstream3.utils;

import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadManager.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadHLS$notificationCoroutine$1", m98f = "VideoDownloadManager.kt", m97i = {0}, m96l = {1237}, m95m = "invokeSuspend", m94n = {"i"}, m93s = {"I$0"})
/* loaded from: classes4.dex */
public final class VideoDownloadManager$downloadHLS$notificationCoroutine$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $bytesDownloaded;
    final /* synthetic */ Function1<VideoDownloadManager.CreateNotificationMetadata, Unit> $createNotificationCallback;
    final /* synthetic */ Ref.BooleanRef $isDone;
    final /* synthetic */ Ref.BooleanRef $isFailed;
    final /* synthetic */ Ref.BooleanRef $isPaused;
    final /* synthetic */ Integer $parentId;
    final /* synthetic */ long $totalTs;
    final /* synthetic */ Ref.LongRef $tsProgress;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoDownloadManager$downloadHLS$notificationCoroutine$1(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Integer num, Function1<? super VideoDownloadManager.CreateNotificationMetadata, Unit> function1, Ref.LongRef longRef, long j, Ref.LongRef longRef2, Continuation<? super VideoDownloadManager$downloadHLS$notificationCoroutine$1> continuation) {
        super(1, continuation);
        this.$isDone = booleanRef;
        this.$isFailed = booleanRef2;
        this.$isPaused = booleanRef3;
        this.$parentId = num;
        this.$createNotificationCallback = function1;
        this.$bytesDownloaded = longRef;
        this.$totalTs = j;
        this.$tsProgress = longRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new VideoDownloadManager$downloadHLS$notificationCoroutine$1(this.$isDone, this.$isFailed, this.$isPaused, this.$parentId, this.$createNotificationCallback, this.$bytesDownloaded, this.$totalTs, this.$tsProgress, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((VideoDownloadManager$downloadHLS$notificationCoroutine$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0037 -> B:13:0x0038). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0049 -> B:18:0x004c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L1a
            if (r1 != r2) goto L12
            int r1 = r12.I$0
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r12
            goto L4c
        L12:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1a:
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r12
        L1e:
            kotlin.jvm.internal.Ref$BooleanRef r1 = r13.$isDone
            boolean r1 = r1.element
            if (r1 != 0) goto L37
            kotlin.jvm.internal.Ref$BooleanRef r3 = r13.$isDone
            kotlin.jvm.internal.Ref$BooleanRef r4 = r13.$isFailed
            kotlin.jvm.internal.Ref$BooleanRef r5 = r13.$isPaused
            java.lang.Integer r6 = r13.$parentId
            kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.VideoDownloadManager$CreateNotificationMetadata, kotlin.Unit> r7 = r13.$createNotificationCallback
            kotlin.jvm.internal.Ref$LongRef r8 = r13.$bytesDownloaded
            long r9 = r13.$totalTs
            kotlin.jvm.internal.Ref$LongRef r11 = r13.$tsProgress
            com.lagradost.cloudstream3.utils.VideoDownloadManager.m9023access$downloadHLS$updateNotification22(r3, r4, r5, r6, r7, r8, r9, r11)
        L37:
            r1 = 1
        L38:
            r3 = 11
            if (r1 >= r3) goto L1e
            r3 = 100
            r5 = r13
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r13.I$0 = r1
            r13.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r5)
            if (r3 != r0) goto L4c
            return r0
        L4c:
            int r1 = r1 + r2
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadHLS$notificationCoroutine$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
