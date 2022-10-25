package com.lagradost.cloudstream3.utils;

import android.app.Notification;
import android.content.Context;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: VideoDownloadManager.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadCheck$1$connectionResult$1", m98f = "VideoDownloadManager.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes4.dex */
final class VideoDownloadManager$downloadCheck$1$connectionResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ VideoDownloadManager.DownloadItem $item;
    final /* synthetic */ ExtractorLink $link;
    final /* synthetic */ Function2<Integer, Notification, Unit> $notificationCallback;
    final /* synthetic */ boolean $resume;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoDownloadManager$downloadCheck$1$connectionResult$1(Context context, VideoDownloadManager.DownloadItem downloadItem, ExtractorLink extractorLink, Function2<? super Integer, ? super Notification, Unit> function2, boolean z, Continuation<? super VideoDownloadManager$downloadCheck$1$connectionResult$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$item = downloadItem;
        this.$link = extractorLink;
        this.$notificationCallback = function2;
        this.$resume = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDownloadManager$downloadCheck$1$connectionResult$1(this.$context, this.$item, this.$link, this.$notificationCallback, this.$resume, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((VideoDownloadManager$downloadCheck$1$connectionResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return ArchComponentExt.normalSafeApiCall(new C49821(this.$context, this.$item, this.$link, this.$notificationCallback, this.$resume));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m107d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadCheck$1$connectionResult$1$1 */
    /* loaded from: classes4.dex */
    public static final class C49821 extends Lambda implements Functions<Integer> {
        final /* synthetic */ Context $context;
        final /* synthetic */ VideoDownloadManager.DownloadItem $item;
        final /* synthetic */ ExtractorLink $link;
        final /* synthetic */ Function2<Integer, Notification, Unit> $notificationCallback;
        final /* synthetic */ boolean $resume;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C49821(Context context, VideoDownloadManager.DownloadItem downloadItem, ExtractorLink extractorLink, Function2<? super Integer, ? super Notification, Unit> function2, boolean z) {
            super(0);
            this.$context = context;
            this.$item = downloadItem;
            this.$link = extractorLink;
            this.$notificationCallback = function2;
            this.$resume = z;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Functions
        public final Integer invoke() {
            int downloadSingleEpisode;
            downloadSingleEpisode = VideoDownloadManager.INSTANCE.downloadSingleEpisode(this.$context, this.$item.getSource(), this.$item.getFolder(), this.$item.getEp(), this.$link, this.$notificationCallback, this.$resume);
            Integer valueOf = Integer.valueOf(downloadSingleEpisode);
            int intValue = valueOf.intValue();
            System.out.println((Object) ("Single episode finished with return code: " + intValue));
            return valueOf;
        }
    }
}
