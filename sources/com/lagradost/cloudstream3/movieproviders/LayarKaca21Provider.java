package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Metadata(m108d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 JI\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020'0%H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*J\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J\f\u0010/\u001a\u00020-*\u000200H\u0002J\f\u00101\u001a\u00020-*\u000200H\u0002J\f\u00102\u001a\u00020-*\u000200H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LayarKacaProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasDownloadSupport", "", "getHasDownloadSupport", "()Z", "hasMainPage", "getHasMainPage", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "toBottomSearchResult", "Lorg/jsoup/nodes/Element;", "toMainSearchResult", "toTopSearchResult", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.movieproviders.LayarKacaProvider */
/* loaded from: classes3.dex */
public final class LayarKaca21Provider extends MainAPI {
    private String mainUrl = "https://lk21.xn--6frz82g";
    private String name = "LayarKaca";
    private final boolean hasMainPage = true;
    private String lang = "id";
    private final boolean hasDownloadSupport = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries, TvType.AsianDrama});

    @Override // com.lagradost.cloudstream3.MainAPI
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setMainUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainUrl = str;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public String getLang() {
        return this.lang;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019d  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r29) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.LayarKaca21Provider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final SearchResponse toTopSearchResult(Element element) {
        Element selectFirst = element.selectFirst("h3.caption");
        Intrinsics.checkNotNull(selectFirst);
        String text = selectFirst.text();
        Intrinsics.checkNotNullExpressionValue(text, "this.selectFirst(\"h3.caption\")!!.text()");
        String obj = StringsKt.trim((CharSequence) text).toString();
        Element selectFirst2 = element.selectFirst("a");
        Intrinsics.checkNotNull(selectFirst2);
        String href = selectFirst2.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        LayarKaca21Provider layarKaca21Provider = this;
        Element selectFirst3 = element.selectFirst("a > img");
        String fixUrl = MainAPIKt.fixUrl(layarKaca21Provider, String.valueOf(selectFirst3 != null ? selectFirst3.attr("src") : null));
        Elements select = element.select("div.quality-top");
        Intrinsics.checkNotNullExpressionValue(select, "this.select(\"div.quality-top\")");
        if ((select.isEmpty() ^ true ? TvType.Movie : TvType.TvSeries) == TvType.Movie) {
            String text2 = element.select("div.quality-top").text();
            Intrinsics.checkNotNullExpressionValue(text2, "this.select(\"div.quality-top\").text()");
            SearchQuality qualityFromString = MainAPIKt.getQualityFromString(StringsKt.trim((CharSequence) text2).toString());
            Intrinsics.checkNotNullExpressionValue(href, "href");
            return MainAPIKt.newMovieSearchResponse$default(layarKaca21Provider, obj, href, TvType.Movie, false, new LayarKacaProvider$toTopSearchResult$1(fixUrl, qualityFromString), 8, null);
        }
        String text3 = element.select("div.last-episode > span").text();
        Intrinsics.checkNotNullExpressionValue(text3, "this.select(\"div.last-episode > span\").text()");
        Integer intOrNull = StringsKt.toIntOrNull(text3);
        Intrinsics.checkNotNullExpressionValue(href, "href");
        return MainAPIKt.newAnimeSearchResponse$default(layarKaca21Provider, obj, href, TvType.TvSeries, false, new LayarKacaProvider$toTopSearchResult$2(fixUrl, intOrNull), 8, null);
    }

    private final SearchResponse toMainSearchResult(Element element) {
        Element selectFirst = element.selectFirst("h3.caption");
        Intrinsics.checkNotNull(selectFirst);
        String text = selectFirst.text();
        Intrinsics.checkNotNullExpressionValue(text, "this.selectFirst(\"h3.caption\")!!.text()");
        String obj = StringsKt.trim((CharSequence) text).toString();
        Element selectFirst2 = element.selectFirst("a");
        Intrinsics.checkNotNull(selectFirst2);
        String href = selectFirst2.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        LayarKaca21Provider layarKaca21Provider = this;
        String fixUrl = MainAPIKt.fixUrl(layarKaca21Provider, element.select("a > img").attr("src").toString());
        String text2 = element.select("div.quality-top").text();
        Intrinsics.checkNotNullExpressionValue(text2, "this.select(\"div.quality-top\").text()");
        SearchQuality qualityFromString = MainAPIKt.getQualityFromString(StringsKt.trim((CharSequence) text2).toString());
        Intrinsics.checkNotNullExpressionValue(href, "href");
        return MainAPIKt.newMovieSearchResponse$default(layarKaca21Provider, obj, href, TvType.Movie, false, new LayarKacaProvider$toMainSearchResult$1(fixUrl, qualityFromString), 8, null);
    }

    private final SearchResponse toBottomSearchResult(Element element) {
        Element selectFirst = element.selectFirst("h1.grid-title > a");
        Intrinsics.checkNotNull(selectFirst);
        String ownText = selectFirst.ownText();
        Intrinsics.checkNotNullExpressionValue(ownText, "this.selectFirst(\"h1.grid-title > a\")!!.ownText()");
        String obj = StringsKt.trim((CharSequence) ownText).toString();
        Element selectFirst2 = element.selectFirst("h1.grid-title > a");
        Intrinsics.checkNotNull(selectFirst2);
        String href = selectFirst2.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        LayarKaca21Provider layarKaca21Provider = this;
        Element selectFirst3 = element.selectFirst(".grid-poster > a > img");
        String fixUrl = MainAPIKt.fixUrl(layarKaca21Provider, String.valueOf(selectFirst3 != null ? selectFirst3.attr("src") : null));
        Elements select = element.select("div.quality");
        Intrinsics.checkNotNullExpressionValue(select, "this.select(\"div.quality\")");
        if ((select.isEmpty() ^ true ? TvType.Movie : TvType.TvSeries) == TvType.Movie) {
            String text = element.select("div.quality").text();
            Intrinsics.checkNotNullExpressionValue(text, "this.select(\"div.quality\").text()");
            SearchQuality qualityFromString = MainAPIKt.getQualityFromString(StringsKt.trim((CharSequence) text).toString());
            Intrinsics.checkNotNullExpressionValue(href, "href");
            return MainAPIKt.newMovieSearchResponse$default(layarKaca21Provider, obj, href, TvType.Movie, false, new LayarKacaProvider$toBottomSearchResult$1(fixUrl, qualityFromString), 8, null);
        }
        Intrinsics.checkNotNullExpressionValue(href, "href");
        return MainAPIKt.newTvSeriesSearchResponse$default(layarKaca21Provider, obj, href, TvType.TvSeries, false, new LayarKacaProvider$toBottomSearchResult$2(fixUrl), 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r20, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r21) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.LayarKaca21Provider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d2 A[LOOP:0: B:25:0x00cc->B:27:0x00d2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a5 A[LOOP:1: B:49:0x019f->B:51:0x01a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0323  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r38, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r39) {
        /*
            Method dump skipped, instructions count: 836
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.LayarKaca21Provider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0151  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r21, boolean r22, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r23, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super java.lang.Boolean> r25) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.LayarKaca21Provider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
