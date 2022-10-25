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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pelisplus.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "api", "Lcom/lagradost/cloudstream3/extractors/MultiQuality;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Pelisplus$getUrl$2", m98f = "Pelisplus.kt", m97i = {}, m96l = {40}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class Pelisplus$getUrl$2 extends SuspendLambda implements Function2<MultiQuality, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $id;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Pelisplus$getUrl$2(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Pelisplus$getUrl$2> continuation) {
        super(2, continuation);
        this.$id = str;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Pelisplus$getUrl$2 pelisplus$getUrl$2 = new Pelisplus$getUrl$2(this.$id, this.$subtitleCallback, this.$callback, continuation);
        pelisplus$getUrl$2.L$0 = obj;
        return pelisplus$getUrl$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MultiQuality multiQuality, Continuation<? super Unit> continuation) {
        return ((Pelisplus$getUrl$2) create(multiQuality, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MultiQuality multiQuality = (MultiQuality) this.L$0;
            MultiQuality multiQuality2 = multiQuality;
            this.label = 1;
            if (ExtractorApi.getSafeUrl$default(multiQuality2, multiQuality.getExtractorUrl(this.$id), null, this.$subtitleCallback, this.$callback, this, 2, null) == coroutine_suspended) {
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
