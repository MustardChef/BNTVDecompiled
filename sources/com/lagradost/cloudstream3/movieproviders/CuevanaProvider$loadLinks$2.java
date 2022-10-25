package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.movieproviders.CuevanaProvider;
import com.lagradost.cloudstream3.utils.AppUtils;
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
/* compiled from: CuevanaProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2", m98f = "CuevanaProvider.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class CuevanaProvider$loadLinks$2 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $data;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CuevanaProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CuevanaProvider$loadLinks$2(CuevanaProvider cuevanaProvider, String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super CuevanaProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.this$0 = cuevanaProvider;
        this.$data = str;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CuevanaProvider$loadLinks$2 cuevanaProvider$loadLinks$2 = new CuevanaProvider$loadLinks$2(this.this$0, this.$data, this.$subtitleCallback, this.$callback, continuation);
        cuevanaProvider$loadLinks$2.L$0 = obj;
        return cuevanaProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Element element, Continuation<? super Unit> continuation) {
        return ((CuevanaProvider$loadLinks$2) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String attr = ((Element) this.L$0).attr("data-src");
            Intrinsics.checkNotNullExpressionValue(attr, "it.attr(\"data-src\")");
            String fixUrl = MainAPIKt.fixUrl(this.this$0, attr);
            if (StringsKt.contains$default((CharSequence) fixUrl, (CharSequence) "api.cuevana3.me/fembed/", false, 2, (Object) null)) {
                ParCollections.apmap(SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("(https.\\/\\/api\\.cuevana3\\.me\\/fembed\\/\\?h=[a-zA-Z0-9]{0,8}[a-zA-Z0-9_-]+)"), fixUrl, 0, 2, null), C47831.INSTANCE)), new C47842(this.$data, this.$subtitleCallback, this.$callback, null));
            }
            if (StringsKt.contains$default((CharSequence) fixUrl, (CharSequence) "tomatomatela", false, 2, (Object) null)) {
                ParCollections.apmap(SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("(\\/\\/apialfa.tomatomatela.com\\/ir\\/player.php\\?h=[a-zA-Z0-9]{0,8}[a-zA-Z0-9_-]+)"), fixUrl, 0, 2, null), C47853.INSTANCE)), new C47864(this.$data, this.$subtitleCallback, this.$callback, null));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CuevanaProvider.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "femreg", "Lkotlin/text/MatchResult;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$1 */
    /* loaded from: classes3.dex */
    public static final class C47831 extends Lambda implements Function1<MatchResult, String> {
        public static final C47831 INSTANCE = new C47831();

        C47831() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(MatchResult femreg) {
            Intrinsics.checkNotNullParameter(femreg, "femreg");
            return femreg.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CuevanaProvider.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "fem", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$2", m98f = "CuevanaProvider.kt", m97i = {}, m96l = {208, bqk.f6596cc}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$2 */
    /* loaded from: classes3.dex */
    public static final class C47842 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $data;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C47842(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C47842> continuation) {
            super(2, continuation);
            this.$data = str;
            this.$subtitleCallback = function1;
            this.$callback = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C47842 c47842 = new C47842(this.$data, this.$subtitleCallback, this.$callback, continuation);
            c47842.L$0 = obj;
            return c47842;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return ((C47842) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object post$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String replace$default = StringsKt.replace$default((String) this.L$0, "https://api.cuevana3.me/fembed/?h=", "", false, 4, (Object) null);
                Extensions.RequestCustom app = MainActivityKt.getApp();
                Tuples[] tuplesArr = {TuplesKt.m100to(HttpHeaders.HOST, "api.cuevana3.me"), TuplesKt.m100to("User-Agent", MainAPIKt.USER_AGENT), TuplesKt.m100to("Accept", "application/json, text/javascript, */*; q=0.01"), TuplesKt.m100to(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.5"), TuplesKt.m100to("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"), TuplesKt.m100to(HttpHeaders.X_REQUESTED_WITH, "XMLHttpRequest"), TuplesKt.m100to(HttpHeaders.ORIGIN, "https://api.cuevana3.me"), TuplesKt.m100to(HttpHeaders.DNT, "1"), TuplesKt.m100to("Connection", "keep-alive"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_DEST, "empty"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_MODE, "cors"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_SITE, HttpHeaders.ReferrerPolicyValues.SAME_ORIGIN)};
                this.label = 1;
                post$default = Requests.post$default(app, "https://api.cuevana3.me/fembed/api.php", MapsKt.mapOf(tuplesArr), null, null, null, MapsKt.mapOf(new Tuples("h", replace$default)), null, null, null, false, 0, null, 0L, null, false, this, 32220, null);
                if (post$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                post$default = obj;
            }
            String text = ((NiceResponse) post$default).getText();
            AppUtils appUtils = AppUtils.INSTANCE;
            String url = ((CuevanaProvider.Femcuevana) MainAPIKt.getMapper().readValue(text, new TypeReference<CuevanaProvider.Femcuevana>() { // from class: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$2$invokeSuspend$$inlined$parseJson$1
            })).getUrl();
            if (StringsKt.contains$default((CharSequence) url, (CharSequence) "fembed", false, 2, (Object) null)) {
                this.label = 2;
                if (ExtractorApiKt.loadExtractor(url, this.$data, this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CuevanaProvider.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "tomreg", "Lkotlin/text/MatchResult;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$3 */
    /* loaded from: classes3.dex */
    public static final class C47853 extends Lambda implements Function1<MatchResult, String> {
        public static final C47853 INSTANCE = new C47853();

        C47853() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(MatchResult tomreg) {
            Intrinsics.checkNotNullParameter(tomreg, "tomreg");
            return tomreg.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CuevanaProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "", "tom", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4", m98f = "CuevanaProvider.kt", m97i = {}, m96l = {241}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4 */
    /* loaded from: classes3.dex */
    public static final class C47864 extends SuspendLambda implements Function2<String, Continuation<? super List<? extends Unit>>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $data;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C47864(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C47864> continuation) {
            super(2, continuation);
            this.$data = str;
            this.$subtitleCallback = function1;
            this.$callback = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C47864 c47864 = new C47864(this.$data, this.$subtitleCallback, this.$callback, continuation);
            c47864.L$0 = obj;
            return c47864;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super List<? extends Unit>> continuation) {
            return invoke2(str, (Continuation<? super List<Unit>>) continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(String str, Continuation<? super List<Unit>> continuation) {
            return ((C47864) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object post$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String replace$default = StringsKt.replace$default((String) this.L$0, "//apialfa.tomatomatela.com/ir/player.php?h=", "", false, 4, (Object) null);
                Extensions.RequestCustom app = MainActivityKt.getApp();
                Tuples[] tuplesArr = {TuplesKt.m100to(HttpHeaders.HOST, "apialfa.tomatomatela.com"), TuplesKt.m100to("User-Agent", MainAPIKt.USER_AGENT), TuplesKt.m100to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"), TuplesKt.m100to(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.5"), TuplesKt.m100to("Content-Type", "application/x-www-form-urlencoded"), TuplesKt.m100to(HttpHeaders.ORIGIN, "null"), TuplesKt.m100to(HttpHeaders.DNT, "1"), TuplesKt.m100to("Connection", "keep-alive"), TuplesKt.m100to("Upgrade-Insecure-Requests", "1"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_DEST, "iframe"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_MODE, "navigate"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_SITE, HttpHeaders.ReferrerPolicyValues.SAME_ORIGIN)};
                this.label = 1;
                post$default = Requests.post$default(app, "https://apialfa.tomatomatela.com/ir/rd.php", MapsKt.mapOf(tuplesArr), null, null, null, MapsKt.mapOf(new Tuples("url", replace$default)), null, null, null, false, 0, null, 0L, null, false, this, 32220, null);
                if (post$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                post$default = obj;
            }
            return ParCollections.apmap(((NiceResponse) post$default).getOkhttpResponse().headers().values(FirebaseAnalytics.Param.LOCATION), new C47871(this.$data, this.$subtitleCallback, this.$callback, null));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CuevanaProvider.kt */
        @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "loc", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1", m98f = "CuevanaProvider.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
        /* renamed from: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1 */
        /* loaded from: classes3.dex */
        public static final class C47871 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ String $data;
            final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C47871(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C47871> continuation) {
                super(2, continuation);
                this.$data = str;
                this.$subtitleCallback = function1;
                this.$callback = function12;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C47871 c47871 = new C47871(this.$data, this.$subtitleCallback, this.$callback, continuation);
                c47871.L$0 = obj;
                return c47871;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(String str, Continuation<? super Unit> continuation) {
                return ((C47871) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    String str = (String) this.L$0;
                    if (StringsKt.contains$default((CharSequence) str, (CharSequence) "goto_ddh.php", false, 2, (Object) null)) {
                        ParCollections.apmap(SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("(\\/\\/api.cuevana3.me\\/ir\\/goto_ddh.php\\?h=[a-zA-Z0-9]{0,8}[a-zA-Z0-9_-]+)"), str, 0, 2, null), C47881.INSTANCE)), new C47892(this.$data, this.$subtitleCallback, this.$callback, null));
                    }
                    if (StringsKt.contains$default((CharSequence) str, (CharSequence) "index.php?h=", false, 2, (Object) null)) {
                        ParCollections.apmap(SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("(\\/\\/api.cuevana3.me\\/sc\\/index.php\\?h=[a-zA-Z0-9]{0,8}[a-zA-Z0-9_-]+)"), str, 0, 2, null), C47913.INSTANCE)), new C47924(this.$data, this.$subtitleCallback, this.$callback, null));
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: CuevanaProvider.kt */
            @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "goreg", "Lkotlin/text/MatchResult;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
            /* renamed from: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1$1 */
            /* loaded from: classes3.dex */
            public static final class C47881 extends Lambda implements Function1<MatchResult, String> {
                public static final C47881 INSTANCE = new C47881();

                C47881() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(MatchResult goreg) {
                    Intrinsics.checkNotNullParameter(goreg, "goreg");
                    return StringsKt.replace$default(goreg.getValue(), "//api.cuevana3.me/ir/goto_ddh.php?h=", "", false, 4, (Object) null);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: CuevanaProvider.kt */
            @Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "", "gotolink", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
            @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1$2", m98f = "CuevanaProvider.kt", m97i = {}, m96l = {bqk.f6615cv}, m95m = "invokeSuspend", m94n = {}, m93s = {})
            /* renamed from: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1$2 */
            /* loaded from: classes3.dex */
            public static final class C47892 extends SuspendLambda implements Function2<String, Continuation<? super List<? extends Boolean>>, Object> {
                final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
                final /* synthetic */ String $data;
                final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
                /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C47892(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C47892> continuation) {
                    super(2, continuation);
                    this.$data = str;
                    this.$subtitleCallback = function1;
                    this.$callback = function12;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C47892 c47892 = new C47892(this.$data, this.$subtitleCallback, this.$callback, continuation);
                    c47892.L$0 = obj;
                    return c47892;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super List<? extends Boolean>> continuation) {
                    return invoke2(str, (Continuation<? super List<Boolean>>) continuation);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final Object invoke2(String str, Continuation<? super List<Boolean>> continuation) {
                    return ((C47892) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object post$default;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Extensions.RequestCustom app = MainActivityKt.getApp();
                        Tuples[] tuplesArr = {TuplesKt.m100to(HttpHeaders.HOST, "api.cuevana3.me"), TuplesKt.m100to("User-Agent", MainAPIKt.USER_AGENT), TuplesKt.m100to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"), TuplesKt.m100to(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.5"), TuplesKt.m100to("Content-Type", "application/x-www-form-urlencoded"), TuplesKt.m100to(HttpHeaders.ORIGIN, "null"), TuplesKt.m100to(HttpHeaders.DNT, "1"), TuplesKt.m100to("Connection", "keep-alive"), TuplesKt.m100to("Upgrade-Insecure-Requests", "1"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_DEST, "iframe"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_MODE, "navigate"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_SITE, HttpHeaders.ReferrerPolicyValues.SAME_ORIGIN)};
                        this.label = 1;
                        post$default = Requests.post$default(app, "https://api.cuevana3.me/ir/redirect_ddh.php", MapsKt.mapOf(tuplesArr), null, null, null, MapsKt.mapOf(new Tuples("url", (String) this.L$0)), null, null, null, false, 0, null, 0L, null, false, this, 32220, null);
                        if (post$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                        post$default = obj;
                    }
                    return ParCollections.apmap(((NiceResponse) post$default).getOkhttpResponse().headers().values(FirebaseAnalytics.Param.LOCATION), new C47901(this.$data, this.$subtitleCallback, this.$callback, null));
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: CuevanaProvider.kt */
                @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "golink", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
                @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1$2$1", m98f = "CuevanaProvider.kt", m97i = {}, m96l = {284}, m95m = "invokeSuspend", m94n = {}, m93s = {})
                /* renamed from: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1$2$1 */
                /* loaded from: classes3.dex */
                public static final class C47901 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
                    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
                    final /* synthetic */ String $data;
                    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
                    /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C47901(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C47901> continuation) {
                        super(2, continuation);
                        this.$data = str;
                        this.$subtitleCallback = function1;
                        this.$callback = function12;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C47901 c47901 = new C47901(this.$data, this.$subtitleCallback, this.$callback, continuation);
                        c47901.L$0 = obj;
                        return c47901;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(String str, Continuation<? super Boolean> continuation) {
                        return ((C47901) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            obj = ExtractorApiKt.loadExtractor((String) this.L$0, this.$data, this.$subtitleCallback, this.$callback, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: CuevanaProvider.kt */
            @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "indreg", "Lkotlin/text/MatchResult;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
            /* renamed from: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1$3 */
            /* loaded from: classes3.dex */
            public static final class C47913 extends Lambda implements Function1<MatchResult, String> {
                public static final C47913 INSTANCE = new C47913();

                C47913() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(MatchResult indreg) {
                    Intrinsics.checkNotNullParameter(indreg, "indreg");
                    return StringsKt.replace$default(indreg.getValue(), "//api.cuevana3.me/sc/index.php?h=", "", false, 4, (Object) null);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: CuevanaProvider.kt */
            @Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "", "inlink", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
            @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1$4", m98f = "CuevanaProvider.kt", m97i = {}, m96l = {294}, m95m = "invokeSuspend", m94n = {}, m93s = {})
            /* renamed from: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1$4 */
            /* loaded from: classes3.dex */
            public static final class C47924 extends SuspendLambda implements Function2<String, Continuation<? super List<? extends Boolean>>, Object> {
                final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
                final /* synthetic */ String $data;
                final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
                /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C47924(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C47924> continuation) {
                    super(2, continuation);
                    this.$data = str;
                    this.$subtitleCallback = function1;
                    this.$callback = function12;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C47924 c47924 = new C47924(this.$data, this.$subtitleCallback, this.$callback, continuation);
                    c47924.L$0 = obj;
                    return c47924;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super List<? extends Boolean>> continuation) {
                    return invoke2(str, (Continuation<? super List<Boolean>>) continuation);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final Object invoke2(String str, Continuation<? super List<Boolean>> continuation) {
                    return ((C47924) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object post$default;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Extensions.RequestCustom app = MainActivityKt.getApp();
                        Tuples[] tuplesArr = {TuplesKt.m100to(HttpHeaders.HOST, "api.cuevana3.me"), TuplesKt.m100to("User-Agent", MainAPIKt.USER_AGENT), TuplesKt.m100to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"), TuplesKt.m100to(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.5"), TuplesKt.m100to(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br"), TuplesKt.m100to("Content-Type", "application/x-www-form-urlencoded"), TuplesKt.m100to(HttpHeaders.ORIGIN, "null"), TuplesKt.m100to(HttpHeaders.DNT, "1"), TuplesKt.m100to("Connection", "keep-alive"), TuplesKt.m100to("Upgrade-Insecure-Requests", "1"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_DEST, "iframe"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_MODE, "navigate"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_SITE, HttpHeaders.ReferrerPolicyValues.SAME_ORIGIN), TuplesKt.m100to(HttpHeaders.SEC_FETCH_USER, "?1")};
                        this.label = 1;
                        post$default = Requests.post$default(app, "https://api.cuevana3.me/sc/r.php", MapsKt.mapOf(tuplesArr), null, null, null, MapsKt.mapOf(new Tuples("h", (String) this.L$0)), null, null, null, false, 0, null, 0L, null, false, this, 32220, null);
                        if (post$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                        post$default = obj;
                    }
                    return ParCollections.apmap(((NiceResponse) post$default).getOkhttpResponse().headers().values(FirebaseAnalytics.Param.LOCATION), new C47931(this.$data, this.$subtitleCallback, this.$callback, null));
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: CuevanaProvider.kt */
                @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "link", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
                @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1$4$1", m98f = "CuevanaProvider.kt", m97i = {}, m96l = {314}, m95m = "invokeSuspend", m94n = {}, m93s = {})
                /* renamed from: com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2$4$1$4$1 */
                /* loaded from: classes3.dex */
                public static final class C47931 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
                    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
                    final /* synthetic */ String $data;
                    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
                    /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C47931(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C47931> continuation) {
                        super(2, continuation);
                        this.$data = str;
                        this.$subtitleCallback = function1;
                        this.$callback = function12;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C47931 c47931 = new C47931(this.$data, this.$subtitleCallback, this.$callback, continuation);
                        c47931.L$0 = obj;
                        return c47931;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(String str, Continuation<? super Boolean> continuation) {
                        return ((C47931) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            obj = ExtractorApiKt.loadExtractor((String) this.L$0, this.$data, this.$subtitleCallback, this.$callback, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }
            }
        }
    }
}
