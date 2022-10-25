package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.common.net.HttpHeaders;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: HDrezkaProvider.kt */
@Metadata(m108d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0005>?@ABB\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b0!H\u0002J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0002J\u0010\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\u0011\u0010'\u001a\u00020(H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020\nH\u0002JH\u0010,\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u001b0!2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b0!H\u0002J\u0019\u00100\u001a\u0002012\u0006\u0010\u001d\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u00102JI\u00103\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\n2\u0006\u00104\u001a\u00020\u00042\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u001b0!2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b0!H\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J\u001f\u00108\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010;\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u00102J\f\u0010<\u001a\u00020:*\u00020=H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006C"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/HDrezkaProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasDownloadSupport", "", "getHasDownloadSupport", "()Z", "hasMainPage", "getHasMainPage", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "cleanCallback", "", "source", "url", "quality", "isM3u8", "sourceCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "decryptStreamUrl", "data", "getLanguage", "str", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuality", "", "invokeSources", "subtitle", "subCallback", "Lcom/lagradost/cloudstream3/SubtitleFile;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "isCasting", "subtitleCallback", "callback", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "toSearchResult", "Lorg/jsoup/nodes/Element;", "Data", "LocalSources", HttpHeaders.SERVER, "Sources", HttpHeaders.TRAILER, "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class HDrezkaProvider extends MainAPI {
    private String mainUrl = "https://hdrezka19139.org";
    private String name = "HDrezka";
    private final boolean hasMainPage = true;
    private String lang = "ru";
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

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object getMainPage(Continuation<? super HomePageResponse> continuation) {
        ArrayList arrayList = new ArrayList();
        ParCollections.apmap(CollectionsKt.listOf((Object[]) new Tuples[]{new Tuples("фильмы", getMainUrl() + "/films/?filter=watching"), new Tuples("сериалы", getMainUrl() + "/series/?filter=watching"), new Tuples("мультфильмы", getMainUrl() + "/cartoons/?filter=watching"), new Tuples("аниме", getMainUrl() + "/animation/?filter=watching")}), new HDrezkaProvider$getMainPage$2(arrayList, this, null));
        if (arrayList.size() <= 0) {
            throw new ErrorLoadingException(null, 1, null);
        }
        return new HomePageResponse(arrayList, null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchResponse toSearchResult(Element element) {
        String text;
        Element selectFirst = element.selectFirst("div.b-content__inline_item-link > a");
        String valueOf = String.valueOf((selectFirst == null || (text = selectFirst.text()) == null) ? null : StringsKt.trim((CharSequence) text).toString());
        Element selectFirst2 = element.selectFirst("a");
        String valueOf2 = String.valueOf(selectFirst2 != null ? selectFirst2.attr(ShareConstants.WEB_DIALOG_PARAM_HREF) : null);
        String attr = element.select("img").attr("src");
        Elements select = element.select("span.info");
        Intrinsics.checkNotNullExpressionValue(select, "this.select(\"span.info\")");
        if ((select.isEmpty() ^ true ? TvType.TvSeries : TvType.Movie) == TvType.Movie) {
            return MainAPIKt.newMovieSearchResponse$default(this, valueOf, valueOf2, TvType.Movie, false, new HDrezkaProvider$toSearchResult$1(attr), 8, null);
        }
        String text2 = element.select("span.info").text();
        Intrinsics.checkNotNullExpressionValue(text2, "this.select(\"span.info\").text()");
        return MainAPIKt.newAnimeSearchResponse$default(this, valueOf, valueOf2, TvType.TvSeries, false, new HDrezkaProvider$toSearchResult$2(attr, StringsKt.toIntOrNull(new Regex("[^0-9]").replace(StringsKt.substringAfter$default(text2, ",", (String) null, 2, (Object) null), ""))), 8, null);
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
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$search$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$search$1 r2 = (com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$search$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$search$1 r2 = new com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$search$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.movieproviders.HDrezkaProvider r2 = (com.lagradost.cloudstream3.movieproviders.HDrezkaProvider) r2
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
            java.lang.String r3 = "/search/?do=search&subaction=search&q="
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
            java.lang.String r3 = "div.b-content__inline_items div.b-content__inline_item"
            org.jsoup.select.Elements r1 = r1.select(r3)
            java.lang.String r3 = "document.select(\"div.b-c….b-content__inline_item\")"
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
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.HDrezkaProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0173 A[LOOP:5: B:37:0x016d->B:39:0x0173, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0268 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x034a A[LOOP:1: B:86:0x0344->B:88:0x034a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03ac  */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r43, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r44) {
        /*
            Method dump skipped, instructions count: 1397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.HDrezkaProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final List<String> decryptStreamUrl$getTrash(List<String> list, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if (1 <= i) {
            while (true) {
                arrayList.add(list);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        ArrayList next = it.next();
        while (it.hasNext()) {
            List list2 = (List) it.next();
            ArrayList arrayList2 = new ArrayList();
            for (String str : (List) next) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(str + ((String) it2.next()));
                }
            }
            next = arrayList2;
        }
        return (List) next;
    }

    private final String decryptStreamUrl(String str) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"@", "#", "!", "^", "$"});
        List<String> plus = CollectionsKt.plus((Collection) decryptStreamUrl$getTrash(listOf, 2), (Iterable) decryptStreamUrl$getTrash(listOf, 3));
        String joinToString$default = CollectionsKt.joinToString$default(StringsKt.split$default((CharSequence) StringsKt.replace$default(str, "#h", "", false, 4, (Object) null), new String[]{"//_//"}, false, 0, 6, (Object) null), "", null, null, 0, null, null, 62, null);
        String str2 = joinToString$default;
        for (String str3 : plus) {
            byte[] bytes = str3.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            str2 = StringsKt.replace$default(str2, MainAPIKt.base64Encode(bytes), "", false, 4, (Object) null);
        }
        return MainAPIKt.base64Decode(str2);
    }

    private final void cleanCallback(String str, String str2, String str3, boolean z, Function1<? super ExtractorLink, Unit> function1) {
        function1.invoke(new ExtractorLink(str, str, str2, getMainUrl() + JsonPointer.SEPARATOR, getQuality(str3), z, MapsKt.mapOf(TuplesKt.m100to(HttpHeaders.ORIGIN, getMainUrl())), null, 128, null));
    }

    private final String getLanguage(String str) {
        return Intrinsics.areEqual(str, "Русский") ? "Russian" : Intrinsics.areEqual(str, "Українська") ? "Ukrainian" : str;
    }

    private final int getQuality(String str) {
        switch (str.hashCode()) {
            case -1762539867:
                if (str.equals("1080p Ultra")) {
                    return Qualities.P1080.getValue();
                }
                break;
            case 1572835:
                if (str.equals("360p")) {
                    return Qualities.P240.getValue();
                }
                break;
            case 1604548:
                if (str.equals("480p")) {
                    return Qualities.P360.getValue();
                }
                break;
            case 1688155:
                if (str.equals("720p")) {
                    return Qualities.P480.getValue();
                }
                break;
            case 46737913:
                if (str.equals("1080p")) {
                    return Qualities.P720.getValue();
                }
                break;
        }
        return ExtractorApiKt.getQualityFromName(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeSources(String str, String str2, String str3, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12) {
        List<String> groupValues;
        String str4;
        List<String> groupValues2;
        List<String> split$default = StringsKt.split$default((CharSequence) decryptStreamUrl(str2), new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str5 : split$default) {
            MatchResult find$default = Regex.find$default(new Regex("\\[([0-9]*p.*?)]"), str5, 0, 2, null);
            String obj = StringsKt.trim((CharSequence) String.valueOf((find$default == null || (groupValues2 = find$default.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues2, 1))).toString();
            List<String> split$default2 = StringsKt.split$default((CharSequence) StringsKt.replace$default(str5, '[' + obj + ']', "", false, 4, (Object) null), new String[]{"or"}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default2, 10));
            for (String str6 : split$default2) {
                arrayList2.add(StringsKt.trim((CharSequence) str6).toString());
            }
            ArrayList<String> arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            for (String str7 : arrayList3) {
                if (StringsKt.endsWith$default(str7, ".m3u8", false, 2, (Object) null)) {
                    str4 = obj;
                    cleanCallback(str + " (Main)", str7, obj, true, function12);
                } else {
                    str4 = obj;
                    cleanCallback(str + " (Backup)", str7, str4, false, function12);
                }
                arrayList4.add(Unit.INSTANCE);
                obj = str4;
            }
            arrayList.add(arrayList4);
        }
        List<String> split$default3 = StringsKt.split$default((CharSequence) str3, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default3, 10));
        for (String str8 : split$default3) {
            MatchResult find$default2 = Regex.find$default(new Regex("\\[(.*)]"), str8, 0, 2, null);
            String valueOf = String.valueOf((find$default2 == null || (groupValues = find$default2.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues, 1));
            function1.invoke(new SubtitleFile(getLanguage(valueOf), StringsKt.trim((CharSequence) StringsKt.replace$default(str8, '[' + valueOf + ']', "", false, 4, (Object) null)).toString(), null, 4, null));
            arrayList5.add(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0156 A[SYNTHETIC] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r25, boolean r26, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r27, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super java.lang.Boolean> r29) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.HDrezkaProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: HDrezkaProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/HDrezkaProvider$LocalSources;", "", "streams", "", "subtitle", "(Ljava/lang/String;Ljava/lang/Object;)V", "getStreams", "()Ljava/lang/String;", "getSubtitle", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LocalSources {
        private final String streams;
        private final Object subtitle;

        public static /* synthetic */ LocalSources copy$default(LocalSources localSources, String str, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = localSources.streams;
            }
            if ((i & 2) != 0) {
                obj = localSources.subtitle;
            }
            return localSources.copy(str, obj);
        }

        public final String component1() {
            return this.streams;
        }

        public final Object component2() {
            return this.subtitle;
        }

        public final LocalSources copy(@JsonProperty("streams") String streams, @JsonProperty("subtitle") Object obj) {
            Intrinsics.checkNotNullParameter(streams, "streams");
            return new LocalSources(streams, obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LocalSources) {
                LocalSources localSources = (LocalSources) obj;
                return Intrinsics.areEqual(this.streams, localSources.streams) && Intrinsics.areEqual(this.subtitle, localSources.subtitle);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.streams.hashCode() * 31;
            Object obj = this.subtitle;
            return hashCode + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "LocalSources(streams=" + this.streams + ", subtitle=" + this.subtitle + ')';
        }

        public LocalSources(@JsonProperty("streams") String streams, @JsonProperty("subtitle") Object obj) {
            Intrinsics.checkNotNullParameter(streams, "streams");
            this.streams = streams;
            this.subtitle = obj;
        }

        public final String getStreams() {
            return this.streams;
        }

        public final Object getSubtitle() {
            return this.subtitle;
        }
    }

    /* compiled from: HDrezkaProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/HDrezkaProvider$Sources;", "", "url", "", "subtitle", "(Ljava/lang/String;Ljava/lang/Object;)V", "getSubtitle", "()Ljava/lang/Object;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Sources {
        private final Object subtitle;
        private final String url;

        public static /* synthetic */ Sources copy$default(Sources sources, String str, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = sources.url;
            }
            if ((i & 2) != 0) {
                obj = sources.subtitle;
            }
            return sources.copy(str, obj);
        }

        public final String component1() {
            return this.url;
        }

        public final Object component2() {
            return this.subtitle;
        }

        public final Sources copy(@JsonProperty("url") String url, @JsonProperty("subtitle") Object obj) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new Sources(url, obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Sources) {
                Sources sources = (Sources) obj;
                return Intrinsics.areEqual(this.url, sources.url) && Intrinsics.areEqual(this.subtitle, sources.subtitle);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.url.hashCode() * 31;
            Object obj = this.subtitle;
            return hashCode + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "Sources(url=" + this.url + ", subtitle=" + this.subtitle + ')';
        }

        public Sources(@JsonProperty("url") String url, @JsonProperty("subtitle") Object obj) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.subtitle = obj;
        }

        public final String getUrl() {
            return this.url;
        }

        public final Object getSubtitle() {
            return this.subtitle;
        }
    }

    /* compiled from: HDrezkaProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/HDrezkaProvider$Server;", "", "translator_name", "", "translator_id", "camrip", "ads", "director", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAds", "()Ljava/lang/String;", "getCamrip", "getDirector", "getTranslator_id", "getTranslator_name", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Server {
        private final String ads;
        private final String camrip;
        private final String director;
        private final String translator_id;
        private final String translator_name;

        public static /* synthetic */ Server copy$default(Server server, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = server.translator_name;
            }
            if ((i & 2) != 0) {
                str2 = server.translator_id;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = server.camrip;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = server.ads;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = server.director;
            }
            return server.copy(str, str6, str7, str8, str5);
        }

        public final String component1() {
            return this.translator_name;
        }

        public final String component2() {
            return this.translator_id;
        }

        public final String component3() {
            return this.camrip;
        }

        public final String component4() {
            return this.ads;
        }

        public final String component5() {
            return this.director;
        }

        public final Server copy(@JsonProperty("translator_name") String str, @JsonProperty("translator_id") String str2, @JsonProperty("camrip") String str3, @JsonProperty("ads") String str4, @JsonProperty("director") String str5) {
            return new Server(str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Server) {
                Server server = (Server) obj;
                return Intrinsics.areEqual(this.translator_name, server.translator_name) && Intrinsics.areEqual(this.translator_id, server.translator_id) && Intrinsics.areEqual(this.camrip, server.camrip) && Intrinsics.areEqual(this.ads, server.ads) && Intrinsics.areEqual(this.director, server.director);
            }
            return false;
        }

        public int hashCode() {
            String str = this.translator_name;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.translator_id;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.camrip;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.ads;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.director;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "Server(translator_name=" + this.translator_name + ", translator_id=" + this.translator_id + ", camrip=" + this.camrip + ", ads=" + this.ads + ", director=" + this.director + ')';
        }

        public Server(@JsonProperty("translator_name") String str, @JsonProperty("translator_id") String str2, @JsonProperty("camrip") String str3, @JsonProperty("ads") String str4, @JsonProperty("director") String str5) {
            this.translator_name = str;
            this.translator_id = str2;
            this.camrip = str3;
            this.ads = str4;
            this.director = str5;
        }

        public final String getTranslator_name() {
            return this.translator_name;
        }

        public final String getTranslator_id() {
            return this.translator_id;
        }

        public final String getCamrip() {
            return this.camrip;
        }

        public final String getAds() {
            return this.ads;
        }

        public final String getDirector() {
            return this.director;
        }
    }

    /* compiled from: HDrezkaProvider.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jc\u0010\u001d\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/HDrezkaProvider$Data;", "", "id", "", "favs", "server", "", "Lcom/lagradost/cloudstream3/movieproviders/HDrezkaProvider$Server;", "season", "episode", "action", "ref", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getEpisode", "getFavs", "getId", "getRef", "getSeason", "getServer", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Data {
        private final String action;
        private final String episode;
        private final String favs;

        /* renamed from: id */
        private final String f9961id;
        private final String ref;
        private final String season;
        private final List<Server> server;

        public static /* synthetic */ Data copy$default(Data data, String str, String str2, List list, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.f9961id;
            }
            if ((i & 2) != 0) {
                str2 = data.favs;
            }
            String str7 = str2;
            List<Server> list2 = list;
            if ((i & 4) != 0) {
                list2 = data.server;
            }
            List list3 = list2;
            if ((i & 8) != 0) {
                str3 = data.season;
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                str4 = data.episode;
            }
            String str9 = str4;
            if ((i & 32) != 0) {
                str5 = data.action;
            }
            String str10 = str5;
            if ((i & 64) != 0) {
                str6 = data.ref;
            }
            return data.copy(str, str7, list3, str8, str9, str10, str6);
        }

        public final String component1() {
            return this.f9961id;
        }

        public final String component2() {
            return this.favs;
        }

        public final List<Server> component3() {
            return this.server;
        }

        public final String component4() {
            return this.season;
        }

        public final String component5() {
            return this.episode;
        }

        public final String component6() {
            return this.action;
        }

        public final String component7() {
            return this.ref;
        }

        public final Data copy(@JsonProperty("id") String str, @JsonProperty("favs") String str2, @JsonProperty("server") List<Server> list, @JsonProperty("season") String str3, @JsonProperty("episode") String str4, @JsonProperty("action") String str5, @JsonProperty("ref") String str6) {
            return new Data(str, str2, list, str3, str4, str5, str6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Data) {
                Data data = (Data) obj;
                return Intrinsics.areEqual(this.f9961id, data.f9961id) && Intrinsics.areEqual(this.favs, data.favs) && Intrinsics.areEqual(this.server, data.server) && Intrinsics.areEqual(this.season, data.season) && Intrinsics.areEqual(this.episode, data.episode) && Intrinsics.areEqual(this.action, data.action) && Intrinsics.areEqual(this.ref, data.ref);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f9961id;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.favs;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            List<Server> list = this.server;
            int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            String str3 = this.season;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.episode;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.action;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.ref;
            return hashCode6 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            return "Data(id=" + this.f9961id + ", favs=" + this.favs + ", server=" + this.server + ", season=" + this.season + ", episode=" + this.episode + ", action=" + this.action + ", ref=" + this.ref + ')';
        }

        public Data(@JsonProperty("id") String str, @JsonProperty("favs") String str2, @JsonProperty("server") List<Server> list, @JsonProperty("season") String str3, @JsonProperty("episode") String str4, @JsonProperty("action") String str5, @JsonProperty("ref") String str6) {
            this.f9961id = str;
            this.favs = str2;
            this.server = list;
            this.season = str3;
            this.episode = str4;
            this.action = str5;
            this.ref = str6;
        }

        public final String getId() {
            return this.f9961id;
        }

        public final String getFavs() {
            return this.favs;
        }

        public final List<Server> getServer() {
            return this.server;
        }

        public final String getSeason() {
            return this.season;
        }

        public final String getEpisode() {
            return this.episode;
        }

        public final String getAction() {
            return this.action;
        }

        public final String getRef() {
            return this.ref;
        }
    }

    /* compiled from: HDrezkaProvider.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/HDrezkaProvider$Trailer;", "", "success", "", "code", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/HDrezkaProvider$Trailer;", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Trailer {
        private final String code;
        private final Boolean success;

        public static /* synthetic */ Trailer copy$default(Trailer trailer, Boolean bool, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = trailer.success;
            }
            if ((i & 2) != 0) {
                str = trailer.code;
            }
            return trailer.copy(bool, str);
        }

        public final Boolean component1() {
            return this.success;
        }

        public final String component2() {
            return this.code;
        }

        public final Trailer copy(@JsonProperty("success") Boolean bool, @JsonProperty("code") String str) {
            return new Trailer(bool, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Trailer) {
                Trailer trailer = (Trailer) obj;
                return Intrinsics.areEqual(this.success, trailer.success) && Intrinsics.areEqual(this.code, trailer.code);
            }
            return false;
        }

        public int hashCode() {
            Boolean bool = this.success;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.code;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Trailer(success=" + this.success + ", code=" + this.code + ')';
        }

        public Trailer(@JsonProperty("success") Boolean bool, @JsonProperty("code") String str) {
            this.success = bool;
            this.code = str;
        }

        public final Boolean getSuccess() {
            return this.success;
        }

        public final String getCode() {
            return this.code;
        }
    }
}
