package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.TvType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FilmanProvider.kt */
@Metadata(m108d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0018\u001a\u00020\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJI\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00042\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020%0#H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/FilmanProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class FilmanProvider extends MainAPI {
    private String mainUrl = "https://filman.cc";
    private String name = "filman.cc";
    private String lang = "pl";
    private final boolean hasMainPage = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries});

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
    public String getLang() {
        return this.lang;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r26) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.FilmanProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
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
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.movieproviders.FilmanProvider$search$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.movieproviders.FilmanProvider$search$1 r2 = (com.lagradost.cloudstream3.movieproviders.FilmanProvider$search$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.movieproviders.FilmanProvider$search$1 r2 = new com.lagradost.cloudstream3.movieproviders.FilmanProvider$search$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r14 = 1
            if (r3 == 0) goto L3a
            if (r3 != r14) goto L32
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.movieproviders.FilmanProvider r2 = (com.lagradost.cloudstream3.movieproviders.FilmanProvider) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L81
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
            java.lang.String r3 = "/wyszukiwarka?phrase="
            r1.append(r3)
            r3 = r20
            r1.append(r3)
            java.lang.String r4 = r1.toString()
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r1 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r3 = r1
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r1 = 0
            r16 = 0
            r17 = 2046(0x7fe, float:2.867E-42)
            r18 = 0
            r2.L$0 = r0
            r2.label = r14
            r14 = r1
            r1 = r15
            r15 = r16
            r16 = r2
            java.lang.Object r2 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            if (r2 != r1) goto L7f
            return r1
        L7f:
            r1 = r2
            r2 = r0
        L81:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            org.jsoup.nodes.Document r1 = r1.getDocument()
            java.lang.String r3 = "#advanced-search > div"
            org.jsoup.select.Elements r1 = r1.select(r3)
            r3 = 1
            java.lang.Object r3 = r1.get(r3)
            org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3
            java.lang.String r4 = "#item-list > div:not(.clearfix)"
            org.jsoup.select.Elements r3 = r3.select(r4)
            r5 = 3
            java.lang.Object r1 = r1.get(r5)
            org.jsoup.nodes.Element r1 = (org.jsoup.nodes.Element) r1
            org.jsoup.select.Elements r1 = r1.select(r4)
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto Lb7
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto Lb7
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            return r1
        Lb7:
            com.lagradost.cloudstream3.TvType r4 = com.lagradost.cloudstream3.TvType.Movie
            java.lang.String r5 = "movies"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            java.util.List r3 = search$getVideos(r2, r4, r3)
            java.util.Collection r3 = (java.util.Collection) r3
            com.lagradost.cloudstream3.TvType r4 = com.lagradost.cloudstream3.TvType.TvSeries
            java.lang.String r5 = "series"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            java.util.List r1 = search$getVideos(r2, r4, r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r1 = kotlin.collections.CollectionsKt.plus(r3, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.FilmanProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x000f A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.lagradost.cloudstream3.SearchResponse] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.lagradost.cloudstream3.SearchResponse] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.List<com.lagradost.cloudstream3.SearchResponse> search$getVideos(com.lagradost.cloudstream3.movieproviders.FilmanProvider r18, com.lagradost.cloudstream3.TvType r19, org.jsoup.select.Elements r20) {
        /*
            r0 = r20
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        Lf:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Lc4
            java.lang.Object r2 = r0.next()
            org.jsoup.nodes.Element r2 = (org.jsoup.nodes.Element) r2
            java.lang.String r3 = ".poster > a"
            org.jsoup.nodes.Element r3 = r2.selectFirst(r3)
            r4 = 0
            if (r3 == 0) goto L2c
            java.lang.String r5 = "href"
            java.lang.String r3 = r3.attr(r5)
            r7 = r3
            goto L2d
        L2c:
            r7 = r4
        L2d:
            if (r7 != 0) goto L33
        L2f:
            r3 = r19
            goto Lbd
        L33:
            java.lang.String r3 = "i.selectFirst(\".poster >…?: return@mapNotNull null"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            java.lang.String r3 = ".poster > a > img"
            org.jsoup.nodes.Element r3 = r2.selectFirst(r3)
            if (r3 == 0) goto L5a
            java.lang.String r5 = "src"
            java.lang.String r8 = r3.attr(r5)
            if (r8 == 0) goto L5a
            java.lang.String r3 = "attr(\"src\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r9 = "/thumb/"
            java.lang.String r10 = "/big/"
            java.lang.String r3 = kotlin.text.StringsKt.replace$default(r8, r9, r10, r11, r12, r13)
            r10 = r3
            goto L5b
        L5a:
            r10 = r4
        L5b:
            java.lang.String r3 = ".film_title"
            org.jsoup.nodes.Element r3 = r2.selectFirst(r3)
            if (r3 == 0) goto L69
            java.lang.String r3 = r3.text()
            r6 = r3
            goto L6a
        L69:
            r6 = r4
        L6a:
            if (r6 != 0) goto L6d
            goto L2f
        L6d:
            java.lang.String r3 = "i.selectFirst(\".film_tit…?: return@mapNotNull null"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            java.lang.String r3 = ".film_year"
            org.jsoup.nodes.Element r2 = r2.selectFirst(r3)
            if (r2 == 0) goto L89
            java.lang.String r2 = r2.text()
            if (r2 == 0) goto L89
            java.lang.String r3 = "text()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r2)
        L89:
            r11 = r4
            com.lagradost.cloudstream3.TvType r2 = com.lagradost.cloudstream3.TvType.TvSeries
            r3 = r19
            if (r3 != r2) goto La7
            com.lagradost.cloudstream3.TvSeriesSearchResponse r2 = new com.lagradost.cloudstream3.TvSeriesSearchResponse
            java.lang.String r8 = r18.getName()
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 896(0x380, float:1.256E-42)
            r17 = 0
            r5 = r2
            r9 = r19
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            com.lagradost.cloudstream3.SearchResponse r2 = (com.lagradost.cloudstream3.SearchResponse) r2
            goto Lbc
        La7:
            com.lagradost.cloudstream3.MovieSearchResponse r2 = new com.lagradost.cloudstream3.MovieSearchResponse
            java.lang.String r8 = r18.getName()
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 448(0x1c0, float:6.28E-43)
            r16 = 0
            r5 = r2
            r9 = r19
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            com.lagradost.cloudstream3.SearchResponse r2 = (com.lagradost.cloudstream3.SearchResponse) r2
        Lbc:
            r4 = r2
        Lbd:
            if (r4 == 0) goto Lf
            r1.add(r4)
            goto Lf
        Lc4:
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.FilmanProvider.search$getVideos(com.lagradost.cloudstream3.movieproviders.FilmanProvider, com.lagradost.cloudstream3.TvType, org.jsoup.select.Elements):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0233  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r42, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r43) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.FilmanProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ad  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r23, boolean r24, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r25, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r26, kotlin.coroutines.Continuation<? super java.lang.Boolean> r27) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.FilmanProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
