package com.lagradost.cloudstream3.p041ui.result;

import android.content.Context;
import com.lagradost.cloudstream3.utils.ExtractorSubtitleLink;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion$downloadSubtitle$2", m98f = "ResultFragmentTV.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion$downloadSubtitle$2 */
/* loaded from: classes4.dex */
public final class ResultFragmentTV$Companion$downloadSubtitle$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $folder;
    final /* synthetic */ ExtractorSubtitleLink $link;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$Companion$downloadSubtitle$2(Context context, ExtractorSubtitleLink extractorSubtitleLink, String str, String str2, Continuation<? super ResultFragmentTV$Companion$downloadSubtitle$2> continuation) {
        super(1, continuation);
        this.$context = context;
        this.$link = extractorSubtitleLink;
        this.$fileName = str;
        this.$folder = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ResultFragmentTV$Companion$downloadSubtitle$2(this.$context, this.$link, this.$fileName, this.$folder, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ResultFragmentTV$Companion$downloadSubtitle$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$CreateNotificationMetadata;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion$downloadSubtitle$2$1 */
    /* loaded from: classes4.dex */
    public static final class C49431 extends Lambda implements Function1<VideoDownloadManager.CreateNotificationMetadata, Unit> {
        public static final C49431 INSTANCE = new C49431();

        C49431() {
            super(1);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(VideoDownloadManager.CreateNotificationMetadata it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VideoDownloadManager.CreateNotificationMetadata createNotificationMetadata) {
            invoke2(createNotificationMetadata);
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            VideoDownloadManager videoDownloadManager = VideoDownloadManager.INSTANCE;
            Context context = this.$context;
            if (context == null) {
                return Unit.INSTANCE;
            }
            ExtractorSubtitleLink extractorSubtitleLink = this.$link;
            videoDownloadManager.downloadThing(context, extractorSubtitleLink, this.$fileName + ' ' + this.$link.getName(), this.$folder, StringsKt.contains$default((CharSequence) this.$link.getUrl(), (CharSequence) ".srt", false, 2, (Object) null) ? ".srt" : "vtt", false, null, C49431.INSTANCE);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
