package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: EgyBestProvider.kt */
@Metadata(m108d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 JI\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020'0%H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*J\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0013\u0010/\u001a\u0004\u0018\u000100*\u00020\bH\u0002¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0004\u0018\u000100*\u00020\bH\u0002¢\u0006\u0002\u00101J\u000e\u00103\u001a\u0004\u0018\u00010-*\u000204H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/EgyBestProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "usesWebView", "getUsesWebView", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "getIntFromText", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "getYearFromTitle", "toSearchResponse", "Lorg/jsoup/nodes/Element;", "Sources", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class EgyBestProvider extends MainAPI {
    private final boolean usesWebView;
    private String lang = "ar";
    private String mainUrl = "https://www.egy.best";
    private String name = "EgyBest";
    private final boolean hasMainPage = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.TvSeries, TvType.Movie, TvType.Anime});

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
    public boolean getUsesWebView() {
        return this.usesWebView;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer getIntFromText(String str) {
        List<String> groupValues;
        String str2;
        MatchResult find$default = Regex.find$default(new Regex("\\d+"), str, 0, 2, null);
        if (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.firstOrNull((List<? extends Object>) groupValues)) == null) {
            return null;
        }
        return StringsKt.toIntOrNull(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchResponse toSearchResponse(Element element) {
        String attr = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        if (attr == null) {
            return null;
        }
        Elements select = element.select("img");
        String attr2 = select != null ? select.attr("src") : null;
        String title = element.select("span.title").text();
        Intrinsics.checkNotNullExpressionValue(title, "title");
        Integer yearFromTitle = getYearFromTitle(title);
        TvType tvType = new Regex(".*/movie/.*|.*/masrahiya/.*").matches(attr) ? TvType.Movie : TvType.TvSeries;
        if (yearFromTitle == null) {
            Intrinsics.checkNotNullExpressionValue(title, "title");
            title = StringsKt.trim((CharSequence) ((String) StringsKt.split$default((CharSequence) title, new String[]{" ("}, false, 0, 6, (Object) null).get(0))).toString();
        }
        String title2 = title;
        String text = element.select("span.ribbon span").text();
        Intrinsics.checkNotNullExpressionValue(text, "select(\"span.ribbon span\").text()");
        String replace$default = StringsKt.replace$default(text, "-", "", false, 4, (Object) null);
        Intrinsics.checkNotNullExpressionValue(title2, "title");
        return new MovieSearchResponse(title2, attr, getName(), tvType, attr2, yearFromTitle, null, MainAPIKt.getQualityFromString(replace$default), null, 256, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.movieproviders.EgyBestProvider$getMainPage$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.movieproviders.EgyBestProvider$getMainPage$1 r2 = (com.lagradost.cloudstream3.movieproviders.EgyBestProvider$getMainPage$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.movieproviders.EgyBestProvider$getMainPage$1 r2 = new com.lagradost.cloudstream3.movieproviders.EgyBestProvider$getMainPage$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.movieproviders.EgyBestProvider r2 = (com.lagradost.cloudstream3.movieproviders.EgyBestProvider) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L6b
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            kotlin.ResultKt.throwOnFailure(r1)
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r1 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r3 = r1
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            java.lang.String r1 = r19.getMainUrl()
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
            if (r2 != r1) goto L69
            return r1
        L69:
            r1 = r2
            r2 = r0
        L6b:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            org.jsoup.nodes.Document r1 = r1.getDocument()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = "#mainLoad div.mbox"
            org.jsoup.select.Elements r1 = r1.select(r4)
            java.lang.String r4 = "doc.select(\"#mainLoad div.mbox\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            java.util.List r1 = (java.util.List) r1
            com.lagradost.cloudstream3.movieproviders.EgyBestProvider$getMainPage$2 r4 = new com.lagradost.cloudstream3.movieproviders.EgyBestProvider$getMainPage$2
            r5 = 0
            r4.<init>(r3, r2, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            com.lagradost.cloudstream3.ParCollections.apmap(r1, r4)
            com.lagradost.cloudstream3.HomePageResponse r1 = new com.lagradost.cloudstream3.HomePageResponse
            r6 = r3
            java.util.List r6 = (java.util.List) r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 30
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.EgyBestProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object search(String str, Continuation<? super List<? extends SearchResponse>> continuation) {
        String replace$default = StringsKt.replace$default(str, " ", "%20", false, 4, (Object) null);
        ArrayList arrayList = new ArrayList();
        ParCollections.apmap(CollectionsKt.listOf(getMainUrl() + "/explore/?q=" + replace$default), new EgyBestProvider$search$2(this, arrayList, null));
        return CollectionsKt.sortedWith(CollectionsKt.distinct(arrayList), new Comparator() { // from class: com.lagradost.cloudstream3.movieproviders.EgyBestProvider$search$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((SearchResponse) t).getName(), ((SearchResponse) t2).getName());
            }
        });
    }

    private final Integer getYearFromTitle(String str) {
        List<String> groupValues;
        String str2;
        MatchResult find$default = Regex.find$default(new Regex("\\(\\d{4}\\)"), str, 0, 2, null);
        if (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.firstOrNull((List<? extends Object>) groupValues)) == null) {
            return null;
        }
        return StringsKt.toIntOrNull(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0216 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x010b A[SYNTHETIC] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r26, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r27) {
        /*
            Method dump skipped, instructions count: 751
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.EgyBestProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: EgyBestProvider.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J$\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/EgyBestProvider$Sources;", "", "quality", "", "link", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "getQuality", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/EgyBestProvider$Sources;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Sources {
        private final String link;
        private final Integer quality;

        public static /* synthetic */ Sources copy$default(Sources sources, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = sources.quality;
            }
            if ((i & 2) != 0) {
                str = sources.link;
            }
            return sources.copy(num, str);
        }

        public final Integer component1() {
            return this.quality;
        }

        public final String component2() {
            return this.link;
        }

        public final Sources copy(@JsonProperty("quality") Integer num, @JsonProperty("link") String link) {
            Intrinsics.checkNotNullParameter(link, "link");
            return new Sources(num, link);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Sources) {
                Sources sources = (Sources) obj;
                return Intrinsics.areEqual(this.quality, sources.quality) && Intrinsics.areEqual(this.link, sources.link);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.quality;
            return ((num == null ? 0 : num.hashCode()) * 31) + this.link.hashCode();
        }

        public String toString() {
            return "Sources(quality=" + this.quality + ", link=" + this.link + ')';
        }

        public Sources(@JsonProperty("quality") Integer num, @JsonProperty("link") String link) {
            Intrinsics.checkNotNullParameter(link, "link");
            this.quality = num;
            this.link = link;
        }

        public final Integer getQuality() {
            return this.quality;
        }

        public final String getLink() {
            return this.link;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b0 A[LOOP:0: B:19:0x00aa->B:21:0x00b0, LOOP_END] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r21, boolean r22, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r23, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super java.lang.Boolean> r25) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.EgyBestProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
