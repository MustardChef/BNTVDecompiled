package com.lagradost.cloudstream3.movieproviders;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.gms.cast.MediaTrack;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;

/* compiled from: PhimmoichillProvider.kt */
@Metadata(m108d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003345B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u0011\u0010\u001c\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"JI\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00042\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020)0'H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010,J\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"J\f\u00101\u001a\u00020/*\u000202H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/PhimmoichillProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasDownloadSupport", "", "getHasDownloadSupport", "()Z", "hasMainPage", "getHasMainPage", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "decode", TvContractCompat.PARAM_INPUT, "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "toSearchResult", "Lorg/jsoup/nodes/Element;", "DataM3u", "ResponseM3u", "Segment", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class PhimmoichillProvider extends MainAPI {
    private String mainUrl = "https://phimmoichills.net";
    private String name = "Phimmoichill";
    private final boolean hasMainPage = true;
    private String lang = "vi";
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r29) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String decode(String str) {
        return URLDecoder.decode(str, "utf-8");
    }

    private final SearchResponse toSearchResult(Element element) {
        List<String> groupValues;
        String str;
        String text;
        Element selectFirst = element.selectFirst("p,h3");
        Integer num = null;
        String valueOf = String.valueOf((selectFirst == null || (text = selectFirst.text()) == null) ? null : StringsKt.trim((CharSequence) text).toString());
        PhimmoichillProvider phimmoichillProvider = this;
        Element selectFirst2 = element.selectFirst("a");
        Intrinsics.checkNotNull(selectFirst2);
        String attr = selectFirst2.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Intrinsics.checkNotNullExpressionValue(attr, "this.selectFirst(\"a\")!!.attr(\"href\")");
        String fixUrl = MainAPIKt.fixUrl(phimmoichillProvider, attr);
        Element selectFirst3 = element.selectFirst("img");
        Intrinsics.checkNotNull(selectFirst3);
        String attr2 = selectFirst3.attr("src");
        Intrinsics.checkNotNullExpressionValue(attr2, "this.selectFirst(\"img\")!!.attr(\"src\")");
        String decode = decode(StringsKt.substringAfter$default(attr2, "url=", (String) null, 2, (Object) null));
        String temp = element.select("span.label").text();
        Intrinsics.checkNotNullExpressionValue(temp, "temp");
        String str2 = temp;
        if (new Regex("\\d").containsMatchIn(str2)) {
            MatchResult find$default = Regex.find$default(new Regex("(\\((\\d+))|(\\s(\\d+))"), str2, 0, 2, null);
            if (find$default != null && (groupValues = find$default.getGroupValues()) != null) {
                List<String> list = groupValues;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String str3 : list) {
                    arrayList.add(new Regex("\\(|\\s").replace(str3, ""));
                }
                List distinct = CollectionsKt.distinct(arrayList);
                if (distinct != null && (str = (String) CollectionsKt.firstOrNull((List<? extends Object>) distinct)) != null) {
                    num = StringsKt.toIntOrNull(str);
                }
            }
            return MainAPIKt.newAnimeSearchResponse$default(phimmoichillProvider, valueOf, fixUrl, TvType.TvSeries, false, new PhimmoichillProvider$toSearchResult$1(decode, num), 8, null);
        }
        return MainAPIKt.newMovieSearchResponse$default(phimmoichillProvider, valueOf, fixUrl, TvType.Movie, false, new PhimmoichillProvider$toSearchResult$2(decode, StringsKt.trim((CharSequence) new Regex("(-.*)|(\\|.*)|(?i)(VietSub.*)|(?i)(Thuyết.*)").replace(str2, "")).toString()), 8, null);
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
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider$search$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider$search$1 r2 = (com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider$search$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider$search$1 r2 = new com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider$search$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider r2 = (com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider) r2
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
            java.lang.String r3 = "/tim-kiem/"
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
            java.lang.String r3 = "ul.list-film li"
            org.jsoup.select.Elements r1 = r1.select(r3)
            java.lang.String r3 = "document.select(\"ul.list-film li\")"
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
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0131 A[LOOP:1: B:31:0x012b->B:33:0x0131, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01f0 A[LOOP:2: B:48:0x01ea->B:50:0x01f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0225 A[LOOP:3: B:52:0x021f->B:54:0x0225, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02ef A[LOOP:0: B:62:0x02e9->B:64:0x02ef, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0382  */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v41, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.util.List] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r40, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r41) {
        /*
            Method dump skipped, instructions count: 962
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x018c  */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x016c -> B:28:0x016f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0182 -> B:30:0x0185). Please submit an issue!!! */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r45, boolean r46, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r47, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r48, kotlin.coroutines.Continuation<? super java.lang.Boolean> r49) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: PhimmoichillProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/PhimmoichillProvider$Segment;", "", "du", "", "link", "(Ljava/lang/String;Ljava/lang/String;)V", "getDu", "()Ljava/lang/String;", "getLink", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Segment {

        /* renamed from: du */
        private final String f9969du;
        private final String link;

        public static /* synthetic */ Segment copy$default(Segment segment, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = segment.f9969du;
            }
            if ((i & 2) != 0) {
                str2 = segment.link;
            }
            return segment.copy(str, str2);
        }

        public final String component1() {
            return this.f9969du;
        }

        public final String component2() {
            return this.link;
        }

        public final Segment copy(@JsonProperty("du") String du, @JsonProperty("link") String link) {
            Intrinsics.checkNotNullParameter(du, "du");
            Intrinsics.checkNotNullParameter(link, "link");
            return new Segment(du, link);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Segment) {
                Segment segment = (Segment) obj;
                return Intrinsics.areEqual(this.f9969du, segment.f9969du) && Intrinsics.areEqual(this.link, segment.link);
            }
            return false;
        }

        public int hashCode() {
            return (this.f9969du.hashCode() * 31) + this.link.hashCode();
        }

        public String toString() {
            return "Segment(du=" + this.f9969du + ", link=" + this.link + ')';
        }

        public Segment(@JsonProperty("du") String du, @JsonProperty("link") String link) {
            Intrinsics.checkNotNullParameter(du, "du");
            Intrinsics.checkNotNullParameter(link, "link");
            this.f9969du = du;
            this.link = link;
        }

        public final String getDu() {
            return this.f9969du;
        }

        public final String getLink() {
            return this.link;
        }
    }

    /* compiled from: PhimmoichillProvider.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/PhimmoichillProvider$DataM3u;", "", "segments", "", "Lcom/lagradost/cloudstream3/movieproviders/PhimmoichillProvider$Segment;", "(Ljava/util/List;)V", "getSegments", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class DataM3u {
        private final List<Segment> segments;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataM3u copy$default(DataM3u dataM3u, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = dataM3u.segments;
            }
            return dataM3u.copy(list);
        }

        public final List<Segment> component1() {
            return this.segments;
        }

        public final DataM3u copy(@JsonProperty("segments") List<Segment> list) {
            return new DataM3u(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DataM3u) && Intrinsics.areEqual(this.segments, ((DataM3u) obj).segments);
        }

        public int hashCode() {
            List<Segment> list = this.segments;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "DataM3u(segments=" + this.segments + ')';
        }

        public DataM3u(@JsonProperty("segments") List<Segment> list) {
            this.segments = list;
        }

        public final List<Segment> getSegments() {
            return this.segments;
        }
    }

    /* compiled from: PhimmoichillProvider.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/PhimmoichillProvider$ResponseM3u;", "", MediaTrack.ROLE_MAIN, "Lcom/lagradost/cloudstream3/movieproviders/PhimmoichillProvider$DataM3u;", "(Lcom/lagradost/cloudstream3/movieproviders/PhimmoichillProvider$DataM3u;)V", "getMain", "()Lcom/lagradost/cloudstream3/movieproviders/PhimmoichillProvider$DataM3u;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResponseM3u {
        private final DataM3u main;

        public static /* synthetic */ ResponseM3u copy$default(ResponseM3u responseM3u, DataM3u dataM3u, int i, Object obj) {
            if ((i & 1) != 0) {
                dataM3u = responseM3u.main;
            }
            return responseM3u.copy(dataM3u);
        }

        public final DataM3u component1() {
            return this.main;
        }

        public final ResponseM3u copy(@JsonProperty("2048p") DataM3u dataM3u) {
            return new ResponseM3u(dataM3u);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ResponseM3u) && Intrinsics.areEqual(this.main, ((ResponseM3u) obj).main);
        }

        public int hashCode() {
            DataM3u dataM3u = this.main;
            if (dataM3u == null) {
                return 0;
            }
            return dataM3u.hashCode();
        }

        public String toString() {
            return "ResponseM3u(main=" + this.main + ')';
        }

        public ResponseM3u(@JsonProperty("2048p") DataM3u dataM3u) {
            this.main = dataM3u;
        }

        public final DataM3u getMain() {
            return this.main;
        }
    }
}
