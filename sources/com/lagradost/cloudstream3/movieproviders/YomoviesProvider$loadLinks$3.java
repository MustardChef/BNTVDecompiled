package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.core.JsonPointer;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.utils.Extensions;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
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
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YomoviesProvider.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "source", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.YomoviesProvider$loadLinks$3", m98f = "YomoviesProvider.kt", m97i = {}, m96l = {118}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class YomoviesProvider$loadLinks$3 extends SuspendLambda implements Function2<String, Continuation<? super Resource<? extends Object>>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ YomoviesProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public YomoviesProvider$loadLinks$3(YomoviesProvider yomoviesProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super YomoviesProvider$loadLinks$3> continuation) {
        super(2, continuation);
        this.this$0 = yomoviesProvider;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YomoviesProvider$loadLinks$3 yomoviesProvider$loadLinks$3 = new YomoviesProvider$loadLinks$3(this.this$0, this.$subtitleCallback, this.$callback, continuation);
        yomoviesProvider$loadLinks$3.L$0 = obj;
        return yomoviesProvider$loadLinks$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Resource<? extends Object>> continuation) {
        return ((YomoviesProvider$loadLinks$3) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: YomoviesProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.YomoviesProvider$loadLinks$3$1", m98f = "YomoviesProvider.kt", m97i = {}, m96l = {120, 132}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.YomoviesProvider$loadLinks$3$1 */
    /* loaded from: classes3.dex */
    public static final class C48321 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $source;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;
        final /* synthetic */ YomoviesProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48321(String str, YomoviesProvider yomoviesProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C48321> continuation) {
            super(1, continuation);
            this.$source = str;
            this.this$0 = yomoviesProvider;
            this.$subtitleCallback = function1;
            this.$callback = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C48321(this.$source, this.this$0, this.$subtitleCallback, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
            return invoke2((Continuation<Object>) continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<Object> continuation) {
            return ((C48321) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (StringsKt.startsWith$default(this.$source, "https://membed.net", false, 2, (Object) null)) {
                    Extensions.RequestCustom app = MainActivityKt.getApp();
                    String str = this.$source;
                    this.label = 1;
                    obj2 = Requests.get$default(app, str, null, this.this$0.getMainUrl() + JsonPointer.SEPARATOR, null, null, false, 0, null, 0L, null, false, this, 2042, null);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    String str2 = this.$source;
                    this.label = 2;
                    Object loadExtractor = ExtractorApiKt.loadExtractor(str2, this.this$0.getMainUrl() + JsonPointer.SEPARATOR, this.$subtitleCallback, this.$callback, this);
                    return loadExtractor == coroutine_suspended ? coroutine_suspended : loadExtractor;
                }
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
            }
            Elements select = ((NiceResponse) obj2).getDocument().select("ul.list-server-items li");
            Intrinsics.checkNotNullExpressionValue(select, "app.get(\n               …ul.list-server-items li\")");
            return ParCollections.apmap(select, new C48331(this.this$0, this.$subtitleCallback, this.$callback, null));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: YomoviesProvider.kt */
        @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.YomoviesProvider$loadLinks$3$1$1", m98f = "YomoviesProvider.kt", m97i = {}, m96l = {125}, m95m = "invokeSuspend", m94n = {}, m93s = {})
        /* renamed from: com.lagradost.cloudstream3.movieproviders.YomoviesProvider$loadLinks$3$1$1 */
        /* loaded from: classes3.dex */
        public static final class C48331 extends SuspendLambda implements Function2<Element, Continuation<? super Boolean>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ YomoviesProvider this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C48331(YomoviesProvider yomoviesProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C48331> continuation) {
                super(2, continuation);
                this.this$0 = yomoviesProvider;
                this.$subtitleCallback = function1;
                this.$callback = function12;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C48331 c48331 = new C48331(this.this$0, this.$subtitleCallback, this.$callback, continuation);
                c48331.L$0 = obj;
                return c48331;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Element element, Continuation<? super Boolean> continuation) {
                return ((C48331) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String attr = ((Element) this.L$0).attr("data-video");
                    Intrinsics.checkNotNullExpressionValue(attr, "it.attr(\"data-video\")");
                    String substringBefore$default = StringsKt.substringBefore$default(attr, "=https://msubload", (String) null, 2, (Object) null);
                    this.label = 1;
                    obj = ExtractorApiKt.loadExtractor(substringBefore$default, this.this$0.getMainUrl() + JsonPointer.SEPARATOR, this.$subtitleCallback, this.$callback, this);
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ArchComponentExt.safeApiCall(new C48321((String) this.L$0, this.this$0, this.$subtitleCallback, this.$callback, null), this);
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
