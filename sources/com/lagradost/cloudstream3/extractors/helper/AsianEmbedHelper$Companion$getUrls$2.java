package com.lagradost.cloudstream3.extractors.helper;

import android.util.Log;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
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
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsianEmbedHelper.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.helper.AsianEmbedHelper$Companion$getUrls$2", m98f = "AsianEmbedHelper.kt", m97i = {0}, m96l = {25}, m95m = "invokeSuspend", m94n = {"datavid"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class AsianEmbedHelper$Companion$getUrls$2 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    final /* synthetic */ String $url;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AsianEmbedHelper$Companion$getUrls$2(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super AsianEmbedHelper$Companion$getUrls$2> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AsianEmbedHelper$Companion$getUrls$2 asianEmbedHelper$Companion$getUrls$2 = new AsianEmbedHelper$Companion$getUrls$2(this.$url, this.$subtitleCallback, this.$callback, continuation);
        asianEmbedHelper$Companion$getUrls$2.L$0 = obj;
        return asianEmbedHelper$Companion$getUrls$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Element element, Continuation<? super Unit> continuation) {
        return ((AsianEmbedHelper$Companion$getUrls$2) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String attr = ((Element) this.L$0).attr("data-video");
            if (attr == null) {
                attr = "";
            }
            if (!StringsKt.isBlank(attr)) {
                this.L$0 = attr;
                this.label = 1;
                Object loadExtractor = ExtractorApiKt.loadExtractor(attr, this.$url, this.$subtitleCallback, this.$callback, this);
                if (loadExtractor == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = attr;
                obj = loadExtractor;
            }
            return Unit.INSTANCE;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        Log.i("AsianEmbed", "Result => (" + booleanValue + ") (datavid) " + str);
        return Unit.INSTANCE;
    }
}
