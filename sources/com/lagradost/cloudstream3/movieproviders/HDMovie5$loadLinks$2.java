package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.movieproviders.HDMovie5;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
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
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jsoup.Jsoup;

/* compiled from: HDMovie5.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, m107d2 = {"<anonymous>", "", FirebaseAnalytics.Param.INDEX, "", "it", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.HDMovie5$loadLinks$2", m98f = "HDMovie5.kt", m97i = {}, m96l = {140, 152}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class HDMovie5$loadLinks$2 extends SuspendLambda implements Function3<Integer, String, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HDMovie5 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HDMovie5$loadLinks$2(HDMovie5 hDMovie5, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super HDMovie5$loadLinks$2> continuation) {
        super(3, continuation);
        this.this$0 = hDMovie5;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    public final Object invoke(int i, String str, Continuation<? super Boolean> continuation) {
        HDMovie5$loadLinks$2 hDMovie5$loadLinks$2 = new HDMovie5$loadLinks$2(this.this$0, this.$subtitleCallback, this.$callback, continuation);
        hDMovie5$loadLinks$2.I$0 = i;
        hDMovie5$loadLinks$2.L$0 = str;
        return hDMovie5$loadLinks$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, Continuation<? super Boolean> continuation) {
        return invoke(num.intValue(), str, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object post$default;
        Object obj2;
        String embedURL;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = this.I$0;
            Tuples[] tuplesArr = {TuplesKt.m100to("action", "doo_player_ajax"), TuplesKt.m100to("post", (String) this.L$0), TuplesKt.m100to("nume", String.valueOf(i2 + 1)), TuplesKt.m100to("type", "movie")};
            this.label = 1;
            post$default = Requests.post$default(MainActivityKt.getApp(), this.this$0.getMainUrl() + "/wp-admin/admin-ajax.php", null, null, null, null, MapsKt.mapOf(tuplesArr), null, null, null, false, 0, null, 0L, null, false, this, 32734, null);
            if (post$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            post$default = obj;
        }
        try {
            obj2 = Requests.Companion.getMapper().readValue(((NiceResponse) post$default).getText(), new TypeReference<HDMovie5.PlayerAjaxResponse>() { // from class: com.lagradost.cloudstream3.movieproviders.HDMovie5$loadLinks$2$invokeSuspend$$inlined$parsedSafe$1
            });
        } catch (Exception e) {
            e.printStackTrace();
            obj2 = null;
        }
        HDMovie5.PlayerAjaxResponse playerAjaxResponse = (HDMovie5.PlayerAjaxResponse) obj2;
        if (playerAjaxResponse == null || (embedURL = playerAjaxResponse.getEmbedURL()) == null) {
            return boxing.boxBoolean(false);
        }
        String link = Jsoup.parse(embedURL).select("iframe").attr("src");
        Intrinsics.checkNotNullExpressionValue(link, "link");
        String httpsify = ExtractorApiKt.httpsify(link);
        this.label = 2;
        Object loadExtractor = ExtractorApiKt.loadExtractor(httpsify, this.this$0.getMainUrl() + JsonPointer.SEPARATOR, this.$subtitleCallback, this.$callback, this);
        return loadExtractor == coroutine_suspended ? coroutine_suspended : loadExtractor;
    }
}
