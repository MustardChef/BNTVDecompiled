package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SubtitleFile;
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
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PelisflixProvider.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PelisflixProvider$loadLinks$2$1", m98f = "PelisflixProvider.kt", m97i = {}, m96l = {200}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class PelisflixProvider$loadLinks$2$1 extends SuspendLambda implements Function2<Element, Continuation<? super List<? extends Boolean>>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $data;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PelisflixProvider$loadLinks$2$1(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super PelisflixProvider$loadLinks$2$1> continuation) {
        super(2, continuation);
        this.$data = str;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PelisflixProvider$loadLinks$2$1 pelisflixProvider$loadLinks$2$1 = new PelisflixProvider$loadLinks$2$1(this.$data, this.$subtitleCallback, this.$callback, continuation);
        pelisflixProvider$loadLinks$2$1.L$0 = obj;
        return pelisflixProvider$loadLinks$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Element element, Continuation<? super List<? extends Boolean>> continuation) {
        return invoke2(element, (Continuation<? super List<Boolean>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Element element, Continuation<? super List<Boolean>> continuation) {
        return ((PelisflixProvider$loadLinks$2$1) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object post$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String iframe = ((Element) this.L$0).attr("src");
            Intrinsics.checkNotNullExpressionValue(iframe, "iframe");
            String replace$default = StringsKt.replace$default(iframe, "/stream/index.php?h=", "", false, 4, (Object) null);
            Extensions.RequestCustom app = MainActivityKt.getApp();
            Tuples[] tuplesArr = {TuplesKt.m100to(HttpHeaders.HOST, "pelisflix.li"), TuplesKt.m100to("User-Agent", MainAPIKt.USER_AGENT), TuplesKt.m100to("Accept", "ext/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"), TuplesKt.m100to(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.5"), TuplesKt.m100to("Content-Type", "application/x-www-form-urlencoded"), TuplesKt.m100to(HttpHeaders.ORIGIN, "null"), TuplesKt.m100to(HttpHeaders.DNT, "1"), TuplesKt.m100to("Connection", "keep-alive"), TuplesKt.m100to("Upgrade-Insecure-Requests", "1"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_DEST, "iframe"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_MODE, "navigate"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_SITE, HttpHeaders.ReferrerPolicyValues.SAME_ORIGIN), TuplesKt.m100to(HttpHeaders.SEC_FETCH_USER, "?1"), TuplesKt.m100to(HttpHeaders.PRAGMA, "no-cache"), TuplesKt.m100to("Cache-Control", "no-cache"), TuplesKt.m100to(HttpHeaders.f9840TE, "trailers")};
            this.label = 1;
            post$default = Requests.post$default(app, "https://pelisflix.li/stream/r.php", MapsKt.mapOf(tuplesArr), null, MapsKt.mapOf(new Tuples("h", replace$default)), null, MapsKt.mapOf(new Tuples("h", replace$default)), null, null, null, false, 0, null, 0L, null, false, this, 32212, null);
            if (post$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            post$default = obj;
        }
        return ParCollections.apmap(((NiceResponse) post$default).getOkhttpResponse().headers().values(FirebaseAnalytics.Param.LOCATION), new C48131(this.$data, this.$subtitleCallback, this.$callback, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PelisflixProvider.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "link", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PelisflixProvider$loadLinks$2$1$1", m98f = "PelisflixProvider.kt", m97i = {}, m96l = {bqk.f6560bT}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.PelisflixProvider$loadLinks$2$1$1 */
    /* loaded from: classes3.dex */
    public static final class C48131 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $data;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48131(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C48131> continuation) {
            super(2, continuation);
            this.$data = str;
            this.$subtitleCallback = function1;
            this.$callback = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C48131 c48131 = new C48131(this.$data, this.$subtitleCallback, this.$callback, continuation);
            c48131.L$0 = obj;
            return c48131;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Boolean> continuation) {
            return ((C48131) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ExtractorApiKt.loadExtractor(StringsKt.replace$default((String) this.L$0, "#bu", "", false, 4, (Object) null), this.$data, this.$subtitleCallback, this.$callback, this);
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
