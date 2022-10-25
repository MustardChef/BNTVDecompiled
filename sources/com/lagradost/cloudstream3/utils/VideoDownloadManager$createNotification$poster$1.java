package com.lagradost.cloudstream3.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadManager.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.VideoDownloadManager$createNotification$poster$1", m98f = "VideoDownloadManager.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes4.dex */
public final class VideoDownloadManager$createNotification$poster$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ VideoDownloadManager.DownloadEpisodeMetadata $ep;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadManager$createNotification$poster$1(Context context, VideoDownloadManager.DownloadEpisodeMetadata downloadEpisodeMetadata, Continuation<? super VideoDownloadManager$createNotification$poster$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$ep = downloadEpisodeMetadata;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDownloadManager$createNotification$poster$1(this.$context, this.$ep, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((VideoDownloadManager$createNotification$poster$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Bitmap imageBitmapFromUrl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            imageBitmapFromUrl = VideoDownloadManager.INSTANCE.getImageBitmapFromUrl(this.$context, this.$ep.getPoster());
            return imageBitmapFromUrl;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
