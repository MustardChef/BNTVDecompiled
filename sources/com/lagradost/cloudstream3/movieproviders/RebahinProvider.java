package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.messaging.Constants;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: RebahinProvider.kt */
@Metadata(m108d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u000689:;<=B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJA\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001e0!2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001e0!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%JQ\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001e0!2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001e0!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0019\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010+JI\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00042\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001e0!2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001e0!H\u0096@ø\u0001\u0000¢\u0006\u0002\u00101J\u001f\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u00105\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010+J\f\u00106\u001a\u000204*\u000207H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/RebahinProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasDownloadSupport", "", "getHasDownloadSupport", "()Z", "hasMainPage", "getHasMainPage", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeKotakAjairSource", "", "url", "subCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "sourceCallback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeLokalSource", "ref", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "callback", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "toSearchResult", "Lorg/jsoup/nodes/Element;", "Captions", "Data", "Player", "ResponseKotakAjair", "ResponseLocal", "Tracks", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class RebahinProvider extends MainAPI {
    private String mainUrl = "http://167.88.14.149";
    private String name = "Rebahin";
    private final boolean hasMainPage = true;
    private String lang = "id";
    private final boolean hasDownloadSupport = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AsianDrama});

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

    /* JADX WARN: Can't wrap try/catch for region: R(14:9|(3:10|11|12)|(1:13)|14|(3:17|18|15)|48|49|50|51|52|53|23|24|(7:26|27|28|29|30|31|(1:33)(13:35|13|14|(1:15)|48|49|50|51|52|53|23|24|(2:42|(2:44|45)(2:46|47))(0)))(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:26|27|28|29|30|31|(1:33)(13:35|13|14|(1:15)|48|49|50|51|52|53|23|24|(2:42|(2:44|45)(2:46|47))(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01d5, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01d9, code lost:
        r14 = r15;
        r15 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01dc, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01dd, code lost:
        r14 = r25;
        r15 = r26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0174 -> B:58:0x017a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01e7 -> B:49:0x01ec). Please submit an issue!!! */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r29) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.RebahinProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final SearchResponse toSearchResult(Element element) {
        Element selectFirst = element.selectFirst("span.mli-info > h2");
        Intrinsics.checkNotNull(selectFirst);
        String text = selectFirst.text();
        Intrinsics.checkNotNullExpressionValue(text, "this.selectFirst(\"span.mli-info > h2\")!!.text()");
        String obj = StringsKt.trim((CharSequence) text).toString();
        Element selectFirst2 = element.selectFirst("a");
        Intrinsics.checkNotNull(selectFirst2);
        String href = selectFirst2.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Elements select = element.select("span.mli-quality");
        Intrinsics.checkNotNullExpressionValue(select, "this.select(\"span.mli-quality\")");
        if ((select.isEmpty() ^ true ? TvType.Movie : TvType.TvSeries) == TvType.Movie) {
            String attr = element.select("img").attr("src");
            String text2 = element.select("span.mli-quality").text();
            Intrinsics.checkNotNullExpressionValue(text2, "this.select(\"span.mli-quality\").text()");
            SearchQuality qualityFromString = MainAPIKt.getQualityFromString(StringsKt.trim((CharSequence) text2).toString());
            Intrinsics.checkNotNullExpressionValue(href, "href");
            return MainAPIKt.newMovieSearchResponse$default(this, obj, href, TvType.Movie, false, new RebahinProvider$toSearchResult$1(attr, qualityFromString), 8, null);
        }
        String attr2 = element.select("img").attr("src");
        if (attr2.length() == 0) {
            attr2 = element.select("img").attr("data-original");
        }
        String text3 = element.select("div.mli-eps > span").text();
        Intrinsics.checkNotNullExpressionValue(text3, "this.select(\"div.mli-eps > span\").text()");
        Integer intOrNull = StringsKt.toIntOrNull(new Regex("[^0-9]").replace(text3, ""));
        Intrinsics.checkNotNullExpressionValue(href, "href");
        return MainAPIKt.newAnimeSearchResponse$default(this, obj, href, TvType.TvSeries, false, new RebahinProvider$toSearchResult$2(attr2, intOrNull), 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa A[LOOP:0: B:19:0x00a4->B:21:0x00aa, LOOP_END] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r20, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.movieproviders.RebahinProvider$search$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.movieproviders.RebahinProvider$search$1 r2 = (com.lagradost.cloudstream3.movieproviders.RebahinProvider$search$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.movieproviders.RebahinProvider$search$1 r2 = new com.lagradost.cloudstream3.movieproviders.RebahinProvider$search$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.movieproviders.RebahinProvider r2 = (com.lagradost.cloudstream3.movieproviders.RebahinProvider) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L80
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r19.getMainUrl()
            r1.append(r3)
            java.lang.String r3 = "/?s="
            r1.append(r3)
            r3 = r20
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            r17 = 2046(0x7fe, float:2.867E-42)
            r18 = 0
            r2.L$0 = r0
            r2.label = r4
            r4 = r1
            r1 = r15
            r15 = r16
            r16 = r2
            java.lang.Object r2 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            if (r2 != r1) goto L7e
            return r1
        L7e:
            r1 = r2
            r2 = r0
        L80:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            org.jsoup.nodes.Document r1 = r1.getDocument()
            java.lang.String r3 = "div.ml-item"
            org.jsoup.select.Elements r1 = r1.select(r3)
            java.lang.String r3 = "document.select(\"div.ml-item\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r4)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r1 = r1.iterator()
        La4:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto Lbd
            java.lang.Object r4 = r1.next()
            org.jsoup.nodes.Element r4 = (org.jsoup.nodes.Element) r4
            java.lang.String r5 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.lagradost.cloudstream3.SearchResponse r4 = r2.toSearchResult(r4)
            r3.add(r4)
            goto La4
        Lbd:
            java.util.List r3 = (java.util.List) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.RebahinProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0183 A[LOOP:6: B:23:0x017d->B:25:0x0183, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x027c A[LOOP:7: B:47:0x0276->B:49:0x027c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0358 A[LOOP:1: B:57:0x0352->B:59:0x0358, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0568 A[LOOP:0: B:87:0x0562->B:89:0x0568, LOOP_END] */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v43, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.util.List] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r45, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r46) {
        /*
            Method dump skipped, instructions count: 1446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.RebahinProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01e4 A[LOOP:0: B:36:0x01de->B:38:0x01e4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0265 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x01ac -> B:35:0x01b2). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x02f3 -> B:58:0x02fd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeLokalSource(java.lang.String r44, java.lang.String r45, java.lang.String r46, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r47, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r48, kotlin.coroutines.Continuation<? super kotlin.Unit> r49) {
        /*
            Method dump skipped, instructions count: 789
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.RebahinProvider.invokeLokalSource(java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeKotakAjairSource(java.lang.String r30, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r31, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r32, kotlin.coroutines.Continuation<? super kotlin.Unit> r33) {
        /*
            Method dump skipped, instructions count: 575
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.RebahinProvider.invokeKotakAjairSource(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object loadLinks(String str, boolean z, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Boolean> continuation) {
        List<String> split$default = StringsKt.split$default((CharSequence) StringsKt.removeSurrounding(str, (CharSequence) "[", (CharSequence) "]"), new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str2 : split$default) {
            arrayList.add(StringsKt.trim((CharSequence) str2).toString());
        }
        ParCollections.apmap(arrayList, new RebahinProvider$loadLinks$3(this, function1, function12, null));
        return boxing.boxBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RebahinProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/RebahinProvider$ResponseLocal;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResponseLocal {
        private final String file;
        private final String label;
        private final String type;

        public static /* synthetic */ ResponseLocal copy$default(ResponseLocal responseLocal, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = responseLocal.file;
            }
            if ((i & 2) != 0) {
                str2 = responseLocal.label;
            }
            if ((i & 4) != 0) {
                str3 = responseLocal.type;
            }
            return responseLocal.copy(str, str2, str3);
        }

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.label;
        }

        public final String component3() {
            return this.type;
        }

        public final ResponseLocal copy(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            return new ResponseLocal(file, label, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResponseLocal) {
                ResponseLocal responseLocal = (ResponseLocal) obj;
                return Intrinsics.areEqual(this.file, responseLocal.file) && Intrinsics.areEqual(this.label, responseLocal.label) && Intrinsics.areEqual(this.type, responseLocal.type);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.file.hashCode() * 31) + this.label.hashCode()) * 31;
            String str = this.type;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ResponseLocal(file=" + this.file + ", label=" + this.label + ", type=" + this.type + ')';
        }

        public ResponseLocal(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            this.file = file;
            this.label = label;
            this.type = str;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RebahinProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/RebahinProvider$Tracks;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "kind", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getKind", "getLabel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Tracks {
        private final String file;
        private final String kind;
        private final String label;

        public static /* synthetic */ Tracks copy$default(Tracks tracks, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tracks.file;
            }
            if ((i & 2) != 0) {
                str2 = tracks.label;
            }
            if ((i & 4) != 0) {
                str3 = tracks.kind;
            }
            return tracks.copy(str, str2, str3);
        }

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.label;
        }

        public final String component3() {
            return this.kind;
        }

        public final Tracks copy(@JsonProperty("file") String file, @JsonProperty("label") String str, @JsonProperty("kind") String str2) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new Tracks(file, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Tracks) {
                Tracks tracks = (Tracks) obj;
                return Intrinsics.areEqual(this.file, tracks.file) && Intrinsics.areEqual(this.label, tracks.label) && Intrinsics.areEqual(this.kind, tracks.kind);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.file.hashCode() * 31;
            String str = this.label;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.kind;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Tracks(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ')';
        }

        public Tracks(@JsonProperty("file") String file, @JsonProperty("label") String str, @JsonProperty("kind") String str2) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
            this.label = str;
            this.kind = str2;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getKind() {
            return this.kind;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RebahinProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/RebahinProvider$Captions;", "", "id", "", "hash", "language", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHash", "()Ljava/lang/String;", "getId", "getLanguage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Captions {
        private final String hash;

        /* renamed from: id */
        private final String f9970id;
        private final String language;

        public static /* synthetic */ Captions copy$default(Captions captions, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = captions.f9970id;
            }
            if ((i & 2) != 0) {
                str2 = captions.hash;
            }
            if ((i & 4) != 0) {
                str3 = captions.language;
            }
            return captions.copy(str, str2, str3);
        }

        public final String component1() {
            return this.f9970id;
        }

        public final String component2() {
            return this.hash;
        }

        public final String component3() {
            return this.language;
        }

        public final Captions copy(@JsonProperty("id") String id, @JsonProperty("hash") String hash, @JsonProperty("language") String language) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(language, "language");
            return new Captions(id, hash, language);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Captions) {
                Captions captions = (Captions) obj;
                return Intrinsics.areEqual(this.f9970id, captions.f9970id) && Intrinsics.areEqual(this.hash, captions.hash) && Intrinsics.areEqual(this.language, captions.language);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f9970id.hashCode() * 31) + this.hash.hashCode()) * 31) + this.language.hashCode();
        }

        public String toString() {
            return "Captions(id=" + this.f9970id + ", hash=" + this.hash + ", language=" + this.language + ')';
        }

        public Captions(@JsonProperty("id") String id, @JsonProperty("hash") String hash, @JsonProperty("language") String language) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(language, "language");
            this.f9970id = id;
            this.hash = hash;
            this.language = language;
        }

        public final String getId() {
            return this.f9970id;
        }

        public final String getHash() {
            return this.hash;
        }

        public final String getLanguage() {
            return this.language;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RebahinProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/RebahinProvider$Data;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "(Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Data {
        private final String file;
        private final String label;

        public static /* synthetic */ Data copy$default(Data data, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.file;
            }
            if ((i & 2) != 0) {
                str2 = data.label;
            }
            return data.copy(str, str2);
        }

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.label;
        }

        public final Data copy(@JsonProperty("file") String file, @JsonProperty("label") String label) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            return new Data(file, label);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Data) {
                Data data = (Data) obj;
                return Intrinsics.areEqual(this.file, data.file) && Intrinsics.areEqual(this.label, data.label);
            }
            return false;
        }

        public int hashCode() {
            return (this.file.hashCode() * 31) + this.label.hashCode();
        }

        public String toString() {
            return "Data(file=" + this.file + ", label=" + this.label + ')';
        }

        public Data(@JsonProperty("file") String file, @JsonProperty("label") String label) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            this.file = file;
            this.label = label;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RebahinProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/RebahinProvider$Player;", "", "poster_file", "", "(Ljava/lang/String;)V", "getPoster_file", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Player {
        private final String poster_file;

        public static /* synthetic */ Player copy$default(Player player, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = player.poster_file;
            }
            return player.copy(str);
        }

        public final String component1() {
            return this.poster_file;
        }

        public final Player copy(@JsonProperty("poster_file") String poster_file) {
            Intrinsics.checkNotNullParameter(poster_file, "poster_file");
            return new Player(poster_file);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Player) && Intrinsics.areEqual(this.poster_file, ((Player) obj).poster_file);
        }

        public int hashCode() {
            return this.poster_file.hashCode();
        }

        public String toString() {
            return "Player(poster_file=" + this.poster_file + ')';
        }

        public Player(@JsonProperty("poster_file") String poster_file) {
            Intrinsics.checkNotNullParameter(poster_file, "poster_file");
            this.poster_file = poster_file;
        }

        public final String getPoster_file() {
            return this.poster_file;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RebahinProvider.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/RebahinProvider$ResponseKotakAjair;", "", "success", "", "player", "Lcom/lagradost/cloudstream3/movieproviders/RebahinProvider$Player;", "data", "", "Lcom/lagradost/cloudstream3/movieproviders/RebahinProvider$Data;", "captions", "Lcom/lagradost/cloudstream3/movieproviders/RebahinProvider$Captions;", "(ZLcom/lagradost/cloudstream3/movieproviders/RebahinProvider$Player;Ljava/util/List;Ljava/util/List;)V", "getCaptions", "()Ljava/util/List;", "getData", "getPlayer", "()Lcom/lagradost/cloudstream3/movieproviders/RebahinProvider$Player;", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResponseKotakAjair {
        private final List<Captions> captions;
        private final List<Data> data;
        private final Player player;
        private final boolean success;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ResponseKotakAjair copy$default(ResponseKotakAjair responseKotakAjair, boolean z, Player player, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = responseKotakAjair.success;
            }
            if ((i & 2) != 0) {
                player = responseKotakAjair.player;
            }
            if ((i & 4) != 0) {
                list = responseKotakAjair.data;
            }
            if ((i & 8) != 0) {
                list2 = responseKotakAjair.captions;
            }
            return responseKotakAjair.copy(z, player, list, list2);
        }

        public final boolean component1() {
            return this.success;
        }

        public final Player component2() {
            return this.player;
        }

        public final List<Data> component3() {
            return this.data;
        }

        public final List<Captions> component4() {
            return this.captions;
        }

        public final ResponseKotakAjair copy(@JsonProperty("success") boolean z, @JsonProperty("player") Player player, @JsonProperty("data") List<Data> list, @JsonProperty("captions") List<Captions> list2) {
            Intrinsics.checkNotNullParameter(player, "player");
            return new ResponseKotakAjair(z, player, list, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResponseKotakAjair) {
                ResponseKotakAjair responseKotakAjair = (ResponseKotakAjair) obj;
                return this.success == responseKotakAjair.success && Intrinsics.areEqual(this.player, responseKotakAjair.player) && Intrinsics.areEqual(this.data, responseKotakAjair.data) && Intrinsics.areEqual(this.captions, responseKotakAjair.captions);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z = this.success;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int hashCode = ((r0 * 31) + this.player.hashCode()) * 31;
            List<Data> list = this.data;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            List<Captions> list2 = this.captions;
            return hashCode2 + (list2 != null ? list2.hashCode() : 0);
        }

        public String toString() {
            return "ResponseKotakAjair(success=" + this.success + ", player=" + this.player + ", data=" + this.data + ", captions=" + this.captions + ')';
        }

        public ResponseKotakAjair(@JsonProperty("success") boolean z, @JsonProperty("player") Player player, @JsonProperty("data") List<Data> list, @JsonProperty("captions") List<Captions> list2) {
            Intrinsics.checkNotNullParameter(player, "player");
            this.success = z;
            this.player = player;
            this.data = list;
            this.captions = list2;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final Player getPlayer() {
            return this.player;
        }

        public final List<Data> getData() {
            return this.data;
        }

        public final List<Captions> getCaptions() {
            return this.captions;
        }
    }
}
