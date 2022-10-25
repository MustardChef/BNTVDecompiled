package com.lagradost.cloudstream3.utils;

import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadManager.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "event", "Lkotlin/Pair;", "", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadActionType;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class VideoDownloadManager$downloadThing$downloadEventListener$1 extends Lambda implements Function1<Tuples<? extends Integer, ? extends VideoDownloadManager.DownloadActionType>, Unit> {
    final /* synthetic */ Ref.LongRef $bytesDownloaded;
    final /* synthetic */ long $bytesTotal;
    final /* synthetic */ Function1<VideoDownloadManager.CreateNotificationMetadata, Unit> $createNotificationCallback;
    final /* synthetic */ Ref.BooleanRef $isDone;
    final /* synthetic */ Ref.BooleanRef $isFailed;
    final /* synthetic */ Ref.BooleanRef $isPaused;
    final /* synthetic */ Ref.BooleanRef $isStopped;
    final /* synthetic */ Integer $parentId;

    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoDownloadManager.DownloadActionType.values().length];
            iArr[VideoDownloadManager.DownloadActionType.Pause.ordinal()] = 1;
            iArr[VideoDownloadManager.DownloadActionType.Stop.ordinal()] = 2;
            iArr[VideoDownloadManager.DownloadActionType.Resume.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoDownloadManager$downloadThing$downloadEventListener$1(Integer num, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Ref.BooleanRef booleanRef4, Function1<? super VideoDownloadManager.CreateNotificationMetadata, Unit> function1, Ref.LongRef longRef, long j) {
        super(1);
        this.$parentId = num;
        this.$isPaused = booleanRef;
        this.$isStopped = booleanRef2;
        this.$isDone = booleanRef3;
        this.$isFailed = booleanRef4;
        this.$createNotificationCallback = function1;
        this.$bytesDownloaded = longRef;
        this.$bytesTotal = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends Integer, ? extends VideoDownloadManager.DownloadActionType> tuples) {
        invoke2((Tuples<Integer, ? extends VideoDownloadManager.DownloadActionType>) tuples);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples<Integer, ? extends VideoDownloadManager.DownloadActionType> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int intValue = event.getFirst().intValue();
        Integer num = this.$parentId;
        if (num != null && intValue == num.intValue()) {
            int i = WhenMappings.$EnumSwitchMapping$0[event.getSecond().ordinal()];
            if (i == 1) {
                this.$isPaused.element = true;
                VideoDownloadManager.downloadThing$updateNotification(this.$isDone, this.$isStopped, this.$isFailed, this.$isPaused, this.$parentId, this.$createNotificationCallback, this.$bytesDownloaded, this.$bytesTotal);
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.$isPaused.element = false;
                VideoDownloadManager.downloadThing$updateNotification(this.$isDone, this.$isStopped, this.$isFailed, this.$isPaused, this.$parentId, this.$createNotificationCallback, this.$bytesDownloaded, this.$bytesTotal);
            } else {
                this.$isStopped.element = true;
                VideoDownloadManager.downloadThing$updateNotification(this.$isDone, this.$isStopped, this.$isFailed, this.$isPaused, this.$parentId, this.$createNotificationCallback, this.$bytesDownloaded, this.$bytesTotal);
                AcraApplication.Companion.removeKey("download_resume", String.valueOf(event.getFirst().intValue()));
                VideoDownloadManager.INSTANCE.saveQueue();
            }
        }
    }
}
