package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.movieproviders.PinoyMoviesEsProvider;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.List;
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
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PinoyMoviesEsProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "datapost", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PinoyMoviesEsProvider$load$2", m98f = "PinoyMoviesEsProvider.kt", m97i = {}, m96l = {200}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class PinoyMoviesEsProvider$load$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $listOfLinks;
    final /* synthetic */ String $url;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinoyMoviesEsProvider$load$2(String str, List<String> list, Continuation<? super PinoyMoviesEsProvider$load$2> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$listOfLinks = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PinoyMoviesEsProvider$load$2 pinoyMoviesEsProvider$load$2 = new PinoyMoviesEsProvider$load$2(this.$url, this.$listOfLinks, continuation);
        pinoyMoviesEsProvider$load$2.L$0 = obj;
        return pinoyMoviesEsProvider$load$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((PinoyMoviesEsProvider$load$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object post$default;
        String text;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = false;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Map mapOf = MapsKt.mapOf(new Tuples("action", "doo_player_ajax"), new Tuples("post", (String) this.L$0), new Tuples("nume", "1"), new Tuples("type", "movie"));
            this.label = 1;
            post$default = Requests.post$default(MainActivityKt.getApp(), "https://pinoymovies.es/wp-admin/admin-ajax.php ", null, this.$url, null, null, mapOf, null, null, null, false, 0, null, 0L, null, false, this, 32730, null);
            if (post$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            post$default = obj;
        }
        Elements select = ((NiceResponse) post$default).getDocument().select("body");
        PinoyMoviesEsProvider.EmbedUrl embedUrl = null;
        String obj2 = (select == null || (text = select.text()) == null) ? null : StringsKt.trim((CharSequence) text).toString();
        String str = obj2;
        if (!((str == null || StringsKt.isBlank(str)) ? true : true)) {
            AppUtils appUtils = AppUtils.INSTANCE;
            if (obj2 != null) {
                try {
                    embedUrl = MainAPIKt.getMapper().readValue(obj2, new TypeReference<PinoyMoviesEsProvider.EmbedUrl>() { // from class: com.lagradost.cloudstream3.movieproviders.PinoyMoviesEsProvider$load$2$invokeSuspend$$inlined$tryParseJson$1
                    });
                } catch (Exception unused) {
                }
            }
            PinoyMoviesEsProvider.EmbedUrl embedUrl2 = embedUrl;
            if (embedUrl2 != null) {
                boxing.boxBoolean(this.$listOfLinks.add(embedUrl2.getEmbed_url()));
            }
        }
        return Unit.INSTANCE;
    }
}
