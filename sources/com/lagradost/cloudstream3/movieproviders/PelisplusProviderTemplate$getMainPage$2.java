package com.lagradost.cloudstream3.movieproviders;

import androidx.mediarouter.media.MediaRouterJellybean;
import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PelisplusProviderTemplate.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "url", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PelisplusProviderTemplate$getMainPage$2", m98f = "PelisplusProviderTemplate.kt", m97i = {}, m96l = {150}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class PelisplusProviderTemplate$getMainPage$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<HomePageList> $homePageList;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PelisplusProviderTemplate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PelisplusProviderTemplate$getMainPage$2(PelisplusProviderTemplate pelisplusProviderTemplate, ArrayList<HomePageList> arrayList, Continuation<? super PelisplusProviderTemplate$getMainPage$2> continuation) {
        super(2, continuation);
        this.this$0 = pelisplusProviderTemplate;
        this.$homePageList = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PelisplusProviderTemplate$getMainPage$2 pelisplusProviderTemplate$getMainPage$2 = new PelisplusProviderTemplate$getMainPage$2(this.this$0, this.$homePageList, continuation);
        pelisplusProviderTemplate$getMainPage$2.L$0 = obj;
        return pelisplusProviderTemplate$getMainPage$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((PelisplusProviderTemplate$getMainPage$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String cleanName;
        String cleanName2;
        SearchResponse movieSearchResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), str, null, null, null, null, false, 0, null, 20L, null, false, this, 1790, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        Elements select = Jsoup.parse(((NiceResponse) obj2).getText()).select("div.main-inner");
        if (select != null) {
            PelisplusProviderTemplate pelisplusProviderTemplate = this.this$0;
            ArrayList<HomePageList> arrayList = this.$homePageList;
            for (Element element : select) {
                String text = element.select(".widget-title").text();
                Intrinsics.checkNotNullExpressionValue(text, "inner.select(\".widget-title\").text()");
                cleanName = pelisplusProviderTemplate.cleanName(text);
                Elements select2 = element.select(".video-block");
                Intrinsics.checkNotNullExpressionValue(select2, "inner.select(\".video-block\")");
                Elements elements = select2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
                for (Element element2 : elements) {
                    String attr = element2.select("a").attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
                    Intrinsics.checkNotNullExpressionValue(attr, "it.select(\"a\").attr(\"href\")");
                    String fixUrl = MainAPIKt.fixUrl(pelisplusProviderTemplate, attr);
                    String attr2 = element2.select(".picture > img").attr("src");
                    Intrinsics.checkNotNullExpressionValue(attr2, "it.select(\".picture > img\").attr(\"src\")");
                    String replace$default = StringsKt.replace$default(attr2, "//img", "https://img", false, 4, (Object) null);
                    String text2 = element2.select("div.name").text();
                    Intrinsics.checkNotNullExpressionValue(text2, "it.select(\"div.name\").text()");
                    cleanName2 = pelisplusProviderTemplate.cleanName(text2);
                    String str2 = cleanName2;
                    boolean z = false;
                    if ((StringsKt.contains$default((CharSequence) str2, (CharSequence) "Temporada", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "Capítulo", false, 2, (Object) null)) ? true : true) {
                        movieSearchResponse = new TvSeriesSearchResponse(cleanName2, fixUrl, pelisplusProviderTemplate.getName(), TvType.TvSeries, replace$default, null, null, null, null, null, MediaRouterJellybean.DEVICE_OUT_BLUETOOTH, null);
                    } else {
                        movieSearchResponse = new MovieSearchResponse(cleanName2, fixUrl, pelisplusProviderTemplate.getName(), TvType.Movie, replace$default, null, null, null, null, 384, null);
                    }
                    arrayList2.add(movieSearchResponse);
                }
                arrayList.add(new HomePageList(cleanName, arrayList2, null, null, null, 28, null));
            }
            return Unit.INSTANCE;
        }
        return null;
    }
}
