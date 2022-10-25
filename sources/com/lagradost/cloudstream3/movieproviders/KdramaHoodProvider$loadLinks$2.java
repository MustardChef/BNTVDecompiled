package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.extractors.XStreamCdn;
import com.lagradost.cloudstream3.extractors.helper.AsianEmbedHelper;
import com.lagradost.cloudstream3.movieproviders.KdramaHoodProvider;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
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
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: KdramaHoodProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "item", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.KdramaHoodProvider$loadLinks$2", m98f = "KdramaHoodProvider.kt", m97i = {}, m96l = {bqk.f6536aw, 283, 288}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class KdramaHoodProvider$loadLinks$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Ref.IntRef $count;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KdramaHoodProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KdramaHoodProvider$loadLinks$2(Ref.IntRef intRef, KdramaHoodProvider kdramaHoodProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super KdramaHoodProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.$count = intRef;
        this.this$0 = kdramaHoodProvider;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KdramaHoodProvider$loadLinks$2 kdramaHoodProvider$loadLinks$2 = new KdramaHoodProvider$loadLinks$2(this.$count, this.this$0, this.$subtitleCallback, this.$callback, continuation);
        kdramaHoodProvider$loadLinks$2.L$0 = obj;
        return kdramaHoodProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((KdramaHoodProvider$loadLinks$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object url$default;
        String value;
        String value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            String str2 = str;
            if (!StringsKt.isBlank(str2)) {
                this.$count.element++;
                if (StringsKt.startsWith$default(str, this.this$0.getMainUrl(), false, 2, (Object) null)) {
                    String substring = str.substring(this.this$0.getMainUrl().length());
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    try {
                        MatchResult find$default = Regex.find$default(new Regex("(?<=sources: )([\\s\\S]*?)(?<=])"), substring, 0, 2, null);
                        if (find$default != null && (value2 = find$default.getValue()) != null) {
                            Function1<ExtractorLink, Unit> function1 = this.$callback;
                            KdramaHoodProvider kdramaHoodProvider = this.this$0;
                            AppUtils appUtils = AppUtils.INSTANCE;
                            for (KdramaHoodProvider.ResponseDatas responseDatas : (Iterable) MainAPIKt.getMapper().readValue(value2, new TypeReference<List<? extends KdramaHoodProvider.ResponseDatas>>() { // from class: com.lagradost.cloudstream3.movieproviders.KdramaHoodProvider$loadLinks$2$invokeSuspend$lambda-1$$inlined$parseJson$1
                            })) {
                                function1.invoke(new ExtractorLink(kdramaHoodProvider.getName(), kdramaHoodProvider.getName(), responseDatas.getFile(), kdramaHoodProvider.getMainUrl(), ExtractorApiKt.getQualityFromName(responseDatas.getLabel()), false, null, null, 224, null));
                            }
                        }
                    } catch (Exception e) {
                        ArchComponentExt.logError(e);
                    }
                    try {
                        MatchResult find$default2 = Regex.find$default(new Regex("(?<=tracks: )([\\s\\S]*?)(?<=])"), substring, 0, 2, null);
                        if (find$default2 != null && (value = find$default2.getValue()) != null) {
                            Function1<SubtitleFile, Unit> function12 = this.$subtitleCallback;
                            String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(value, "file:", "\"file\":", false, 4, (Object) null), "label:", "\"label\":", false, 4, (Object) null), "kind:", "\"kind\":", false, 4, (Object) null);
                            AppUtils appUtils2 = AppUtils.INSTANCE;
                            for (KdramaHoodProvider.ResponseDatas responseDatas2 : (Iterable) MainAPIKt.getMapper().readValue(replace$default, new TypeReference<List<? extends KdramaHoodProvider.ResponseDatas>>() { // from class: com.lagradost.cloudstream3.movieproviders.KdramaHoodProvider$loadLinks$2$invokeSuspend$lambda-3$$inlined$parseJson$1
                            })) {
                                function12.invoke(new SubtitleFile(responseDatas2.getLabel(), responseDatas2.getFile(), null, 4, null));
                            }
                        }
                    } catch (Exception e2) {
                        ArchComponentExt.logError(e2);
                    }
                } else {
                    String fixUrl = MainAPIKt.fixUrl(this.this$0, StringsKt.trim((CharSequence) str2).toString());
                    if (StringsKt.startsWith$default(fixUrl, "https://asianembed.io", false, 2, (Object) null)) {
                        this.label = 1;
                        if (AsianEmbedHelper.Companion.getUrls(fixUrl, this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (StringsKt.startsWith$default(fixUrl, "https://embedsito.com", false, 2, (Object) null)) {
                        XStreamCdn xStreamCdn = new XStreamCdn();
                        xStreamCdn.setDomainUrl("embedsito.com");
                        this.label = 2;
                        url$default = ExtractorApi.getUrl$default(xStreamCdn, fixUrl, null, this, 2, null);
                        if (url$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.label = 3;
                        if (ExtractorApiKt.loadExtractor(fixUrl, this.this$0.getMainUrl(), this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                url$default = obj;
            } else if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
        Function1<ExtractorLink, Unit> function13 = this.$callback;
        for (ExtractorLink extractorLink : (Iterable) url$default) {
            function13.invoke(extractorLink);
        }
        return Unit.INSTANCE;
    }
}
