package com.lagradost.cloudstream3.extractors;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pelisplus.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "api", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Pelisplus$getUrl$4$2$2", m98f = "Pelisplus.kt", m97i = {}, m96l = {89}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class Pelisplus$getUrl$4$2$2 extends SuspendLambda implements Function2<ExtractorApi, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $extractorUrl;
    final /* synthetic */ String $link;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Pelisplus$getUrl$4$2$2(String str, String str2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Pelisplus$getUrl$4$2$2> continuation) {
        super(2, continuation);
        this.$link = str;
        this.$extractorUrl = str2;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Pelisplus$getUrl$4$2$2 pelisplus$getUrl$4$2$2 = new Pelisplus$getUrl$4$2$2(this.$link, this.$extractorUrl, this.$subtitleCallback, this.$callback, continuation);
        pelisplus$getUrl$4$2$2.L$0 = obj;
        return pelisplus$getUrl$4$2$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ExtractorApi extractorApi, Continuation<? super Unit> continuation) {
        return ((Pelisplus$getUrl$4$2$2) create(extractorApi, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ExtractorApi extractorApi = (ExtractorApi) this.L$0;
            String link = this.$link;
            Intrinsics.checkNotNullExpressionValue(link, "link");
            if (StringsKt.startsWith$default(link, extractorApi.getMainUrl(), false, 2, (Object) null)) {
                String link2 = this.$link;
                Intrinsics.checkNotNullExpressionValue(link2, "link");
                this.label = 1;
                if (extractorApi.getSafeUrl(link2, this.$extractorUrl, this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
