package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.MainAPIKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PelisplusProviderTemplate.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PelisplusProviderTemplate$loadLinks$4", m98f = "PelisplusProviderTemplate.kt", m97i = {0}, m96l = {bqk.f6603cj, 254}, m95m = "invokeSuspend", m94n = {"serverid"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class PelisplusProviderTemplate$loadLinks$4 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $data;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PelisplusProviderTemplate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PelisplusProviderTemplate$loadLinks$4(PelisplusProviderTemplate pelisplusProviderTemplate, String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super PelisplusProviderTemplate$loadLinks$4> continuation) {
        super(2, continuation);
        this.this$0 = pelisplusProviderTemplate;
        this.$data = str;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PelisplusProviderTemplate$loadLinks$4 pelisplusProviderTemplate$loadLinks$4 = new PelisplusProviderTemplate$loadLinks$4(this.this$0, this.$data, this.$subtitleCallback, this.$callback, continuation);
        pelisplusProviderTemplate$loadLinks$4.L$0 = obj;
        return pelisplusProviderTemplate$loadLinks$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Element element, Continuation<? super Unit> continuation) {
        return ((PelisplusProviderTemplate$loadLinks$4) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String replace$default;
        Object pelisStream;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String attr = ((Element) this.L$0).attr("data-video");
            Intrinsics.checkNotNullExpressionValue(attr, "it.attr(\"data-video\")");
            replace$default = StringsKt.replace$default(MainAPIKt.fixUrl(this.this$0, attr), "streaming.php", "play", false, 4, (Object) null);
            this.L$0 = replace$default;
            this.label = 1;
            if (ExtractorApiKt.loadExtractor(replace$default, this.$data, this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            replace$default = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (StringsKt.contains$default((CharSequence) replace$default, (CharSequence) "pelisplus.icu", false, 2, (Object) null)) {
            this.L$0 = null;
            this.label = 2;
            pelisStream = this.this$0.getPelisStream(replace$default, this.$callback, this);
            if (pelisStream == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
