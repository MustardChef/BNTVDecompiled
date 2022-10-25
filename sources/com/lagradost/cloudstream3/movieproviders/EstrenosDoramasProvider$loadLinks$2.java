package com.lagradost.cloudstream3.movieproviders;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.Extensions;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
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
/* compiled from: EstrenosDoramasProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", TtmlNode.RUBY_CONTAINER, "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2", m98f = "EstrenosDoramasProvider.kt", m97i = {0}, m96l = {192}, m95m = "invokeSuspend", m94n = {"directlink"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class EstrenosDoramasProvider$loadLinks$2 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $data;
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EstrenosDoramasProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EstrenosDoramasProvider$loadLinks$2(EstrenosDoramasProvider estrenosDoramasProvider, String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Map<String, String> map, Continuation<? super EstrenosDoramasProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.this$0 = estrenosDoramasProvider;
        this.$data = str;
        this.$subtitleCallback = function1;
        this.$callback = function12;
        this.$headers = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EstrenosDoramasProvider$loadLinks$2 estrenosDoramasProvider$loadLinks$2 = new EstrenosDoramasProvider$loadLinks$2(this.this$0, this.$data, this.$subtitleCallback, this.$callback, this.$headers, continuation);
        estrenosDoramasProvider$loadLinks$2.L$0 = obj;
        return estrenosDoramasProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Element element, Continuation<? super Unit> continuation) {
        return ((EstrenosDoramasProvider$loadLinks$2) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String attr = ((Element) this.L$0).attr("src");
            Intrinsics.checkNotNullExpressionValue(attr, "container.attr(\"src\")");
            String fixUrl = MainAPIKt.fixUrl(this.this$0, attr);
            this.L$0 = fixUrl;
            this.label = 1;
            if (ExtractorApiKt.loadExtractor(fixUrl, this.$data, this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = fixUrl;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        String str2 = str;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "/repro/amz/", false, 2, (Object) null)) {
            ParCollections.apmap(SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("https:\\/\\/repro3\\.estrenosdoramas\\.us\\/repro\\/amz\\/examples\\/.*\\.php\\?key=.*$"), str2, 0, 2, null), C47971.INSTANCE)), new C47982(this.$headers, this.this$0, this.$callback, null));
        }
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "reproducir14", false, 2, (Object) null)) {
            ParCollections.apmap(SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("(https:\\/\\/repro.\\.estrenosdoramas\\.us\\/repro\\/reproducir14\\.php\\?key=[a-zA-Z0-9]{0,8}[a-zA-Z0-9_-]+)"), str2, 0, 2, null), C47993.INSTANCE)), new C48004(this.$headers, this.$data, this.$subtitleCallback, this.$callback, null));
        }
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "reproducir120", false, 2, (Object) null)) {
            ParCollections.apmap(SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("(https:\\/\\/repro3.estrenosdoramas.us\\/repro\\/reproducir120\\.php\\?\\nkey=[a-zA-Z0-9]{0,8}[a-zA-Z0-9_-]+)"), str2, 0, 2, null), C48015.INSTANCE)), new C48026(this.$headers, this.this$0, this.$callback, null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EstrenosDoramasProvider.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2$1 */
    /* loaded from: classes3.dex */
    public static final class C47971 extends Lambda implements Function1<MatchResult, String> {
        public static final C47971 INSTANCE = new C47971();

        C47971() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(MatchResult it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new Regex("https:\\/\\/repro3\\.estrenosdoramas\\.us\\/repro\\/amz\\/examples\\/.*\\.php\\?key=").replace(it.getValue(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EstrenosDoramasProvider.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", SDKConstants.PARAM_KEY, ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2$2", m98f = "EstrenosDoramasProvider.kt", m97i = {}, m96l = {199}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2$2 */
    /* loaded from: classes3.dex */
    public static final class C47982 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Map<String, String> $headers;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ EstrenosDoramasProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C47982(Map<String, String> map, EstrenosDoramasProvider estrenosDoramasProvider, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C47982> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.this$0 = estrenosDoramasProvider;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C47982 c47982 = new C47982(this.$headers, this.this$0, this.$callback, continuation);
            c47982.L$0 = obj;
            return c47982;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return ((C47982) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object post$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Extensions.RequestCustom app = MainActivityKt.getApp();
                Map<String, String> map = this.$headers;
                Tuples[] tuplesArr = {new Tuples(SDKConstants.PARAM_KEY, (String) this.L$0), new Tuples("token", "MDAwMDAwMDAwMA==")};
                this.label = 1;
                post$default = Requests.post$default(app, "https://repro3.estrenosdoramas.us/repro/amz/examples/player/api/indexDCA.php", map, null, null, null, MapsKt.mapOf(tuplesArr), null, null, null, false, 0, null, 0L, null, false, this, 32220, null);
                if (post$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                post$default = obj;
            }
            String text = ((NiceResponse) post$default).getText();
            AppUtils appUtils = AppUtils.INSTANCE;
            String base64Decode = MainAPIKt.base64Decode(((EstrenosDoramasProvider.ReproDoramas) MainAPIKt.getMapper().readValue(text, new TypeReference<EstrenosDoramasProvider.ReproDoramas>() { // from class: com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2$2$invokeSuspend$$inlined$parseJson$1
            })).getLink());
            String str = base64Decode;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "m3u8", false, 2, (Object) null)) {
                EstrenosDoramasProvider estrenosDoramasProvider = this.this$0;
                estrenosDoramasProvider.cleanExtractor(estrenosDoramasProvider.getName(), this.this$0.getName(), base64Decode, "https://repro3.estrenosdoramas.us", StringsKt.contains$default((CharSequence) str, (CharSequence) ".m3u8", false, 2, (Object) null), this.$callback);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EstrenosDoramasProvider.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2$3 */
    /* loaded from: classes3.dex */
    public static final class C47993 extends Lambda implements Function1<MatchResult, String> {
        public static final C47993 INSTANCE = new C47993();

        C47993() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(MatchResult it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EstrenosDoramasProvider.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2$4", m98f = "EstrenosDoramasProvider.kt", m97i = {}, m96l = {bqk.f6562bV, bqk.f6526am, bqk.f6541bA}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2$4 */
    /* loaded from: classes3.dex */
    public static final class C48004 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $data;
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48004(Map<String, String> map, String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C48004> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.$data = str;
            this.$subtitleCallback = function1;
            this.$callback = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C48004 c48004 = new C48004(this.$headers, this.$data, this.$subtitleCallback, this.$callback, continuation);
            c48004.L$0 = obj;
            return c48004;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Boolean> continuation) {
            return ((C48004) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0117 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r31) {
            /*
                Method dump skipped, instructions count: 281
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2.C48004.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EstrenosDoramasProvider.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2$5 */
    /* loaded from: classes3.dex */
    public static final class C48015 extends Lambda implements Function1<MatchResult, String> {
        public static final C48015 INSTANCE = new C48015();

        C48015() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(MatchResult it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EstrenosDoramasProvider.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2$6", m98f = "EstrenosDoramasProvider.kt", m97i = {}, m96l = {bqk.f6602ci, 255}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$loadLinks$2$6 */
    /* loaded from: classes3.dex */
    public static final class C48026 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Map<String, String> $headers;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ EstrenosDoramasProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48026(Map<String, String> map, EstrenosDoramasProvider estrenosDoramasProvider, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C48026> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.this$0 = estrenosDoramasProvider;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C48026 c48026 = new C48026(this.$headers, this.this$0, this.$callback, continuation);
            c48026.L$0 = obj;
            return c48026;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return ((C48026) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object post$default;
            String replace$default;
            String substringBefore$default;
            String substringBefore$default2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = (String) this.L$0;
                this.label = 1;
                obj2 = Requests.get$default(MainActivityKt.getApp(), str, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    post$default = obj;
                    String text = ((NiceResponse) post$default).getText();
                    replace$default = StringsKt.replace$default(StringsKt.substringBefore$default(StringsKt.substringAfter$default(text, "\"{file:'", (String) null, 2, (Object) null), "',label:", (String) null, 2, (Object) null), "\\/", "/", false, 4, (Object) null);
                    substringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfter$default(text, ",label:'", (String) null, 2, (Object) null), "',type:", (String) null, 2, (Object) null);
                    substringBefore$default2 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(text, "type: '", (String) null, 2, (Object) null), "'}\"", (String) null, 2, (Object) null);
                    if ((!StringsKt.isBlank(replace$default)) && !StringsKt.contains((CharSequence) substringBefore$default, (CharSequence) "File not found", true)) {
                        EstrenosDoramasProvider estrenosDoramasProvider = this.this$0;
                        estrenosDoramasProvider.cleanExtractor("Movil", "Movil " + substringBefore$default, replace$default, "", !StringsKt.contains$default((CharSequence) substringBefore$default2, (CharSequence) "mp4", false, 2, (Object) null), this.$callback);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
            }
            String text2 = ((NiceResponse) obj2).getText();
            String substringBefore$default3 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(text2, "var videoid = '", (String) null, 2, (Object) null), "';", (String) null, 2, (Object) null);
            String substringBefore$default4 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(text2, "var tokens = '", (String) null, 2, (Object) null), "';", (String) null, 2, (Object) null);
            String substringBefore$default5 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(text2, "{ acc: \"", (String) null, 2, (Object) null), "\", id:", (String) null, 2, (Object) null);
            Extensions.RequestCustom app = MainActivityKt.getApp();
            Map<String, String> map = this.$headers;
            Tuples[] tuplesArr = {new Tuples("acc", substringBefore$default5), new Tuples("id", substringBefore$default3), new Tuples("tk", substringBefore$default4)};
            this.label = 2;
            post$default = Requests.post$default(app, "https://repro3.estrenosdoramas.us/repro/api3.php", map, null, null, null, MapsKt.mapOf(tuplesArr), null, null, null, false, 0, null, 0L, null, false, this, 32220, null);
            if (post$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            String text3 = ((NiceResponse) post$default).getText();
            replace$default = StringsKt.replace$default(StringsKt.substringBefore$default(StringsKt.substringAfter$default(text3, "\"{file:'", (String) null, 2, (Object) null), "',label:", (String) null, 2, (Object) null), "\\/", "/", false, 4, (Object) null);
            substringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfter$default(text3, ",label:'", (String) null, 2, (Object) null), "',type:", (String) null, 2, (Object) null);
            substringBefore$default2 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(text3, "type: '", (String) null, 2, (Object) null), "'}\"", (String) null, 2, (Object) null);
            if (!StringsKt.isBlank(replace$default)) {
                EstrenosDoramasProvider estrenosDoramasProvider2 = this.this$0;
                estrenosDoramasProvider2.cleanExtractor("Movil", "Movil " + substringBefore$default, replace$default, "", !StringsKt.contains$default((CharSequence) substringBefore$default2, (CharSequence) "mp4", false, 2, (Object) null), this.$callback);
            }
            return Unit.INSTANCE;
        }
    }
}
