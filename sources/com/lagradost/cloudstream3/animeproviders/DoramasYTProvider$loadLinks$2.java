package com.lagradost.cloudstream3.animeproviders;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.extractors.FEmbed;
import com.lagradost.cloudstream3.utils.ExtractorApi;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DoramasYTProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.animeproviders.DoramasYTProvider$loadLinks$2", m98f = "DoramasYTProvider.kt", m97i = {}, m96l = {146, 150}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class DoramasYTProvider$loadLinks$2 extends SuspendLambda implements Function2<Element, Continuation<? super Object>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoramasYTProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DoramasYTProvider$loadLinks$2(DoramasYTProvider doramasYTProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super DoramasYTProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.this$0 = doramasYTProvider;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DoramasYTProvider$loadLinks$2 doramasYTProvider$loadLinks$2 = new DoramasYTProvider$loadLinks$2(this.this$0, this.$subtitleCallback, this.$callback, continuation);
        doramasYTProvider$loadLinks$2.L$0 = obj;
        return doramasYTProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Element element, Continuation<? super Object> continuation) {
        return invoke2(element, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Element element, Continuation<Object> continuation) {
        return ((DoramasYTProvider$loadLinks$2) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object url$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String encodedurl = ((Element) this.L$0).select(TtmlNode.TAG_P).attr("data-player");
            Intrinsics.checkNotNullExpressionValue(encodedurl, "encodedurl");
            String replace$default = StringsKt.replace$default(MainAPIKt.base64Decode(encodedurl), "https://doramasyt.com/reproductor?url=", "", false, 4, (Object) null);
            if (StringsKt.startsWith$default(replace$default, "https://www.fembed.com", false, 2, (Object) null)) {
                this.label = 1;
                url$default = ExtractorApi.getUrl$default(new FEmbed(), replace$default, null, this, 2, null);
                if (url$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 2;
                Object loadExtractor = ExtractorApiKt.loadExtractor(replace$default, this.this$0.getMainUrl(), this.$subtitleCallback, this.$callback, this);
                return loadExtractor == coroutine_suspended ? coroutine_suspended : loadExtractor;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            url$default = obj;
        } else {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Function1<ExtractorLink, Unit> function1 = this.$callback;
        for (ExtractorLink extractorLink : (Iterable) url$default) {
            function1.invoke(extractorLink);
        }
        return Unit.INSTANCE;
    }
}
