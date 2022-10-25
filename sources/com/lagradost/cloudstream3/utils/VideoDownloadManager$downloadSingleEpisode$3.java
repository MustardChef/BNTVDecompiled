package com.lagradost.cloudstream3.utils;

import android.app.Notification;
import android.content.Context;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadManager.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m107d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class VideoDownloadManager$downloadSingleEpisode$3 extends Lambda implements Functions<Integer> {
    final /* synthetic */ Context $context;
    final /* synthetic */ VideoDownloadManager.DownloadEpisodeMetadata $ep;
    final /* synthetic */ String $folder;
    final /* synthetic */ ExtractorLink $link;
    final /* synthetic */ String $name;
    final /* synthetic */ Function2<Integer, Notification, Unit> $notificationCallback;
    final /* synthetic */ String $source;
    final /* synthetic */ boolean $tryResume;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoDownloadManager$downloadSingleEpisode$3(Context context, ExtractorLink extractorLink, String str, String str2, boolean z, VideoDownloadManager.DownloadEpisodeMetadata downloadEpisodeMetadata, String str3, Function2<? super Integer, ? super Notification, Unit> function2) {
        super(0);
        this.$context = context;
        this.$link = extractorLink;
        this.$name = str;
        this.$folder = str2;
        this.$tryResume = z;
        this.$ep = downloadEpisodeMetadata;
        this.$source = str3;
        this.$notificationCallback = function2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDownloadManager.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "meta", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$CreateNotificationMetadata;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadSingleEpisode$3$1 */
    /* loaded from: classes4.dex */
    public static final class C49841 extends Lambda implements Function1<VideoDownloadManager.CreateNotificationMetadata, Unit> {
        final /* synthetic */ Context $context;
        final /* synthetic */ VideoDownloadManager.DownloadEpisodeMetadata $ep;
        final /* synthetic */ ExtractorLink $link;
        final /* synthetic */ Function2<Integer, Notification, Unit> $notificationCallback;
        final /* synthetic */ String $source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C49841(Context context, String str, ExtractorLink extractorLink, VideoDownloadManager.DownloadEpisodeMetadata downloadEpisodeMetadata, Function2<? super Integer, ? super Notification, Unit> function2) {
            super(1);
            this.$context = context;
            this.$source = str;
            this.$link = extractorLink;
            this.$ep = downloadEpisodeMetadata;
            this.$notificationCallback = function2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: VideoDownloadManager.kt */
        @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        @DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadSingleEpisode$3$1$1", m98f = "VideoDownloadManager.kt", m97i = {}, m96l = {1413}, m95m = "invokeSuspend", m94n = {}, m93s = {})
        /* renamed from: com.lagradost.cloudstream3.utils.VideoDownloadManager$downloadSingleEpisode$3$1$1 */
        /* loaded from: classes4.dex */
        public static final class C49851 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ VideoDownloadManager.DownloadEpisodeMetadata $ep;
            final /* synthetic */ ExtractorLink $link;
            final /* synthetic */ VideoDownloadManager.CreateNotificationMetadata $meta;
            final /* synthetic */ Function2<Integer, Notification, Unit> $notificationCallback;
            final /* synthetic */ String $source;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C49851(Context context, String str, ExtractorLink extractorLink, VideoDownloadManager.DownloadEpisodeMetadata downloadEpisodeMetadata, VideoDownloadManager.CreateNotificationMetadata createNotificationMetadata, Function2<? super Integer, ? super Notification, Unit> function2, Continuation<? super C49851> continuation) {
                super(1, continuation);
                this.$context = context;
                this.$source = str;
                this.$link = extractorLink;
                this.$ep = downloadEpisodeMetadata;
                this.$meta = createNotificationMetadata;
                this.$notificationCallback = function2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C49851(this.$context, this.$source, this.$link, this.$ep, this.$meta, this.$notificationCallback, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C49851) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object createNotification;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    createNotification = VideoDownloadManager.INSTANCE.createNotification(this.$context, this.$source, this.$link.getName(), this.$ep, this.$meta.getType(), this.$meta.getBytesDownloaded(), this.$meta.getBytesTotal(), this.$notificationCallback, (r31 & 256) != 0 ? null : null, (r31 & 512) != 0 ? null : null, this);
                    if (createNotification == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VideoDownloadManager.CreateNotificationMetadata createNotificationMetadata) {
            invoke2(createNotificationMetadata);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(VideoDownloadManager.CreateNotificationMetadata meta) {
            Intrinsics.checkNotNullParameter(meta, "meta");
            Coroutines.INSTANCE.main(new C49851(this.$context, this.$source, this.$link, this.$ep, meta, this.$notificationCallback, null));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final Integer invoke() {
        return Integer.valueOf(VideoDownloadManager.INSTANCE.downloadThing(this.$context, this.$link, this.$name, this.$folder, "mp4", this.$tryResume, Integer.valueOf(this.$ep.getId()), new C49841(this.$context, this.$source, this.$link, this.$ep, this.$notificationCallback)));
    }
}
