package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.extractors.Cinestart;
import com.lagradost.cloudstream3.utils.Extensions;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CinecalidadProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CinecalidadProvider$loadLinks$3", m98f = "CinecalidadProvider.kt", m97i = {0, 1}, m96l = {201, 203}, m95m = "invokeSuspend", m94n = {"url", "url"}, m93s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class CinecalidadProvider$loadLinks$3 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $data;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CinecalidadProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CinecalidadProvider$loadLinks$3(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, CinecalidadProvider cinecalidadProvider, String str, Continuation<? super CinecalidadProvider$loadLinks$3> continuation) {
        super(2, continuation);
        this.$subtitleCallback = function1;
        this.$callback = function12;
        this.this$0 = cinecalidadProvider;
        this.$data = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CinecalidadProvider$loadLinks$3 cinecalidadProvider$loadLinks$3 = new CinecalidadProvider$loadLinks$3(this.$subtitleCallback, this.$callback, this.this$0, this.$data, continuation);
        cinecalidadProvider$loadLinks$3.L$0 = obj;
        return cinecalidadProvider$loadLinks$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Element element, Continuation<? super Unit> continuation) {
        return ((CinecalidadProvider$loadLinks$3) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String url;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String url2 = ((Element) this.L$0).attr("data-option");
            Intrinsics.checkNotNullExpressionValue(url2, "url");
            if (StringsKt.startsWith$default(url2, "https://cinestart.net", false, 2, (Object) null)) {
                this.L$0 = url2;
                this.label = 1;
                if (new Cinestart().getSafeUrl(url2, null, this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.L$0 = url2;
                this.label = 2;
                if (ExtractorApiKt.loadExtractor(url2, this.this$0.getMainUrl(), this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            url = url2;
        } else if (i == 1 || i == 2) {
            url = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        if (StringsKt.startsWith$default(url, "https://cinecalidad.lol", false, 2, (Object) null)) {
            ParCollections.apmap(SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("(https:\\/\\/cinecalidad\\.lol\\/play\\/\\?h=[a-zA-Z0-9]{0,8}[a-zA-Z0-9_-]+)"), url, 0, 2, null), C47791.INSTANCE)), new C47802(this.$data, this.this$0, this.$subtitleCallback, this.$callback, null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CinecalidadProvider.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.movieproviders.CinecalidadProvider$loadLinks$3$1 */
    /* loaded from: classes3.dex */
    public static final class C47791 extends Lambda implements Function1<MatchResult, String> {
        public static final C47791 INSTANCE = new C47791();

        C47791() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(MatchResult it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return StringsKt.replace$default(it.getValue(), "/play/", "/play/r.php", false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CinecalidadProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "", "it", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CinecalidadProvider$loadLinks$3$2", m98f = "CinecalidadProvider.kt", m97i = {}, m96l = {bqk.f6551bK}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.CinecalidadProvider$loadLinks$3$2 */
    /* loaded from: classes3.dex */
    public static final class C47802 extends SuspendLambda implements Function2<String, Continuation<? super List<? extends Unit>>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $data;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CinecalidadProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C47802(String str, CinecalidadProvider cinecalidadProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C47802> continuation) {
            super(2, continuation);
            this.$data = str;
            this.this$0 = cinecalidadProvider;
            this.$subtitleCallback = function1;
            this.$callback = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C47802 c47802 = new C47802(this.$data, this.this$0, this.$subtitleCallback, this.$callback, continuation);
            c47802.L$0 = obj;
            return c47802;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super List<? extends Unit>> continuation) {
            return invoke2(str, (Continuation<? super List<Unit>>) continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(String str, Continuation<? super List<Unit>> continuation) {
            return ((C47802) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = (String) this.L$0;
                Extensions.RequestCustom app = MainActivityKt.getApp();
                Tuples[] tuplesArr = {TuplesKt.m100to(HttpHeaders.HOST, "cinecalidad.lol"), TuplesKt.m100to("User-Agent", MainAPIKt.USER_AGENT), TuplesKt.m100to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"), TuplesKt.m100to(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.5"), TuplesKt.m100to(HttpHeaders.DNT, "1"), TuplesKt.m100to("Connection", "keep-alive"), TuplesKt.m100to(HttpHeaders.REFERER, this.$data), TuplesKt.m100to("Upgrade-Insecure-Requests", "1"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_DEST, "iframe"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_MODE, "navigate"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_SITE, HttpHeaders.ReferrerPolicyValues.SAME_ORIGIN), TuplesKt.m100to(HttpHeaders.SEC_FETCH_USER, "?1")};
                this.label = 1;
                obj2 = Requests.get$default(app, str, MapsKt.mapOf(tuplesArr), null, null, null, false, 0, null, 0L, null, false, this, 2012, null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
            }
            return ParCollections.apmap(((NiceResponse) obj2).getOkhttpResponse().headers().values(FirebaseAnalytics.Param.LOCATION), new C47811(this.this$0, this.$subtitleCallback, this.$callback, null));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CinecalidadProvider.kt */
        @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "extractedurl", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CinecalidadProvider$loadLinks$3$2$1", m98f = "CinecalidadProvider.kt", m97i = {}, m96l = {bqk.f6597cd}, m95m = "invokeSuspend", m94n = {}, m93s = {})
        /* renamed from: com.lagradost.cloudstream3.movieproviders.CinecalidadProvider$loadLinks$3$2$1 */
        /* loaded from: classes3.dex */
        public static final class C47811 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CinecalidadProvider this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C47811(CinecalidadProvider cinecalidadProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C47811> continuation) {
                super(2, continuation);
                this.this$0 = cinecalidadProvider;
                this.$subtitleCallback = function1;
                this.$callback = function12;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C47811 c47811 = new C47811(this.this$0, this.$subtitleCallback, this.$callback, continuation);
                c47811.L$0 = obj;
                return c47811;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(String str, Continuation<? super Unit> continuation) {
                return ((C47811) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String str = (String) this.L$0;
                    if (StringsKt.contains$default((CharSequence) str, (CharSequence) "cinestart", false, 2, (Object) null)) {
                        this.label = 1;
                        if (ExtractorApiKt.loadExtractor(str, this.this$0.getMainUrl(), this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
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
    }
}
