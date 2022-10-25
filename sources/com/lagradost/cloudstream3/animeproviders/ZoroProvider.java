package com.lagradost.cloudstream3.animeproviders;

import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.gms.cast.MediaTrack;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.movieproviders.SflixProvider;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.nodes.Element;

/* compiled from: ZoroProvider.kt */
@Metadata(m108d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u0001:\u0004GHIJB\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0011\u0010-\u001a\u00020.H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J\u0019\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010,JI\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020*0;2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020*0;H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010>J\u001f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@2\u0006\u0010B\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0010\u0010C\u001a\u0004\u0018\u00010D*\u0004\u0018\u00010EH\u0002J\u000e\u0010F\u001a\u0004\u0018\u00010A*\u00020EH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R:\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001bj\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0012`\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006K"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/ZoroProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "epRegex", "Lkotlin/text/Regex;", "getEpRegex", "()Lkotlin/text/Regex;", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "hasQuickSearch", "getHasQuickSearch", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "sid", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSid", "()Ljava/util/HashMap;", "setSid", "(Ljava/util/HashMap;)V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "usesWebView", "getUsesWebView", "extractorVerifierJob", "", "extractorData", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoInterceptor", "Lokhttp3/Interceptor;", "extractorLink", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "getActor", "Lcom/lagradost/cloudstream3/Actor;", "Lorg/jsoup/nodes/Element;", "toSearchResult", "Companion", "RapidCloudResponse", "Response", "ZoroSyncData", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class ZoroProvider extends MainAPI {
    public static final Companion Companion = new Companion(null);
    private final boolean hasQuickSearch;
    private String mainUrl = "https://zoro.to";
    private String name = "Zoro";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;
    private final boolean hasDownloadSupport = true;
    private final boolean usesWebView = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});
    private final Regex epRegex = new Regex("Ep (\\d+)/");
    private HashMap<Integer, String> sid = new HashMap<>();

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
    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getUsesWebView() {
        return this.usesWebView;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* compiled from: ZoroProvider.kt */
    @Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/ZoroProvider$Companion;", "", "()V", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "t", "", "getType", "Lcom/lagradost/cloudstream3/TvType;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TvType getType(String t) {
            Intrinsics.checkNotNullParameter(t, "t");
            String str = t;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "OVA", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "Special", false, 2, (Object) null)) {
                return TvType.OVA;
            }
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "Movie", false, 2, (Object) null) ? TvType.AnimeMovie : TvType.Anime;
        }

        public final ShowStatus getStatus(String t) {
            Intrinsics.checkNotNullParameter(t, "t");
            return Intrinsics.areEqual(t, "Finished Airing") ? ShowStatus.Completed : Intrinsics.areEqual(t, "Currently Airing") ? ShowStatus.Ongoing : ShowStatus.Completed;
        }
    }

    public final Regex getEpRegex() {
        return this.epRegex;
    }

    private final SearchResponse toSearchResult(Element element) {
        String text;
        MatchResult find$default;
        List<String> groupValues;
        String str;
        ZoroProvider zoroProvider = this;
        String attr = element.select("a").attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Intrinsics.checkNotNullExpressionValue(attr, "this.select(\"a\").attr(\"href\")");
        String fixUrl = MainAPIKt.fixUrl(zoroProvider, attr);
        String title = element.select("h3.film-name").text();
        String dubSub = element.select(".film-poster > .tick.ltr").text();
        Intrinsics.checkNotNullExpressionValue(dubSub, "dubSub");
        String str2 = dubSub;
        boolean contains = StringsKt.contains((CharSequence) str2, (CharSequence) MediaTrack.ROLE_DUB, true);
        boolean contains2 = StringsKt.contains((CharSequence) str2, (CharSequence) "sub", true);
        Element selectFirst = element.selectFirst(".film-poster > .tick.rtl > .tick-eps");
        Integer intOrNull = (selectFirst == null || (text = selectFirst.text()) == null || (find$default = Regex.find$default(this.epRegex, text, 0, 2, null)) == null || (groupValues = find$default.getGroupValues()) == null || (str = groupValues.get(1)) == null) ? null : StringsKt.toIntOrNull(str);
        if (!StringsKt.contains$default((CharSequence) fixUrl, (CharSequence) "/news/", false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(title, "title");
            if (!StringsKt.equals(StringsKt.trim((CharSequence) title).toString(), "News", true)) {
                String attr2 = element.select("img").attr("data-src");
                Intrinsics.checkNotNullExpressionValue(attr2, "this.select(\"img\").attr(\"data-src\")");
                String fixUrl2 = MainAPIKt.fixUrl(zoroProvider, attr2);
                Companion companion = Companion;
                String text2 = element.select("div.fd-infor > span.fdi-item").text();
                Intrinsics.checkNotNullExpressionValue(text2, "this.select(\"div.fd-infor > span.fdi-item\").text()");
                return MainAPIKt.newAnimeSearchResponse$default(zoroProvider, title, fixUrl, companion.getType(text2), false, new ZoroProvider$toSearchResult$1(fixUrl2, contains, contains2, intOrNull), 8, null);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012d  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r29) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.animeproviders.ZoroProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ZoroProvider.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/ZoroProvider$Response;", "", "status", "", "html", "", "(ZLjava/lang/String;)V", "getHtml", "()Ljava/lang/String;", "getStatus", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Response {
        private final String html;
        private final boolean status;

        public static /* synthetic */ Response copy$default(Response response, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = response.status;
            }
            if ((i & 2) != 0) {
                str = response.html;
            }
            return response.copy(z, str);
        }

        public final boolean component1() {
            return this.status;
        }

        public final String component2() {
            return this.html;
        }

        public final Response copy(@JsonProperty("status") boolean z, @JsonProperty("html") String html) {
            Intrinsics.checkNotNullParameter(html, "html");
            return new Response(z, html);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return this.status == response.status && Intrinsics.areEqual(this.html, response.html);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z = this.status;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return (r0 * 31) + this.html.hashCode();
        }

        public String toString() {
            return "Response(status=" + this.status + ", html=" + this.html + ')';
        }

        public Response(@JsonProperty("status") boolean z, @JsonProperty("html") String html) {
            Intrinsics.checkNotNullParameter(html, "html");
            this.status = z;
            this.html = html;
        }

        public final boolean getStatus() {
            return this.status;
        }

        public final String getHtml() {
            return this.html;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0159, code lost:
        if ((r5 != null ? kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) "RAW", false, 2, (java.lang.Object) null) : false) != false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a A[SYNTHETIC] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r20, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r21) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.animeproviders.ZoroProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Actor getActor(Element element) {
        Element selectFirst;
        Element selectFirst2;
        String fixUrlNull = MainAPIKt.fixUrlNull(this, (element == null || (selectFirst2 = element.selectFirst(".pi-avatar > img")) == null) ? null : selectFirst2.attr("data-src"));
        if (fixUrlNull == null) {
            return null;
        }
        String text = (element == null || (selectFirst = element.selectFirst(".pi-detail > .pi-name")) == null) ? null : selectFirst.text();
        if (text == null) {
            return null;
        }
        return new Actor(text, fixUrlNull);
    }

    /* compiled from: ZoroProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/ZoroProvider$ZoroSyncData;", "", "malId", "", "aniListId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAniListId", "()Ljava/lang/String;", "getMalId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ZoroSyncData {
        private final String aniListId;
        private final String malId;

        public static /* synthetic */ ZoroSyncData copy$default(ZoroSyncData zoroSyncData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = zoroSyncData.malId;
            }
            if ((i & 2) != 0) {
                str2 = zoroSyncData.aniListId;
            }
            return zoroSyncData.copy(str, str2);
        }

        public final String component1() {
            return this.malId;
        }

        public final String component2() {
            return this.aniListId;
        }

        public final ZoroSyncData copy(@JsonProperty("mal_id") String str, @JsonProperty("anilist_id") String str2) {
            return new ZoroSyncData(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ZoroSyncData) {
                ZoroSyncData zoroSyncData = (ZoroSyncData) obj;
                return Intrinsics.areEqual(this.malId, zoroSyncData.malId) && Intrinsics.areEqual(this.aniListId, zoroSyncData.aniListId);
            }
            return false;
        }

        public int hashCode() {
            String str = this.malId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.aniListId;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ZoroSyncData(malId=" + this.malId + ", aniListId=" + this.aniListId + ')';
        }

        public ZoroSyncData(@JsonProperty("mal_id") String str, @JsonProperty("anilist_id") String str2) {
            this.malId = str;
            this.aniListId = str2;
        }

        public final String getMalId() {
            return this.malId;
        }

        public final String getAniListId() {
            return this.aniListId;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x043e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013a A[LOOP:3: B:37:0x0134->B:39:0x013a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0352 A[LOOP:0: B:91:0x034a->B:93:0x0352, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x038f  */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.lagradost.cloudstream3.ShowStatus, T] */
    /* JADX WARN: Type inference failed for: r0v23, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v34, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v65, types: [T] */
    /* JADX WARN: Type inference failed for: r0v76 */
    /* JADX WARN: Type inference failed for: r0v77 */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [org.jsoup.nodes.Element] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r34v1 */
    /* JADX WARN: Type inference failed for: r34v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r38v0 */
    /* JADX WARN: Type inference failed for: r38v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46, types: [org.jsoup.nodes.Element] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.util.List] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r50, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r51) {
        /*
            Method dump skipped, instructions count: 1293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.animeproviders.ZoroProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ZoroProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/ZoroProvider$RapidCloudResponse;", "", "link", "", "(Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class RapidCloudResponse {
        private final String link;

        public static /* synthetic */ RapidCloudResponse copy$default(RapidCloudResponse rapidCloudResponse, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rapidCloudResponse.link;
            }
            return rapidCloudResponse.copy(str);
        }

        public final String component1() {
            return this.link;
        }

        public final RapidCloudResponse copy(@JsonProperty("link") String link) {
            Intrinsics.checkNotNullParameter(link, "link");
            return new RapidCloudResponse(link);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RapidCloudResponse) && Intrinsics.areEqual(this.link, ((RapidCloudResponse) obj).link);
        }

        public int hashCode() {
            return this.link.hashCode();
        }

        public String toString() {
            return "RapidCloudResponse(link=" + this.link + ')';
        }

        public RapidCloudResponse(@JsonProperty("link") String link) {
            Intrinsics.checkNotNullParameter(link, "link");
            this.link = link;
        }

        public final String getLink() {
            return this.link;
        }
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object extractorVerifierJob(String str, Continuation<? super Unit> continuation) {
        String name = getName();
        Log.d(name, "Starting " + getName() + " job!");
        Object runSflixExtractorVerifierJob = SflixProvider.Companion.runSflixExtractorVerifierJob(this, str, "https://rapid-cloud.ru/", continuation);
        return runSflixExtractorVerifierJob == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? runSflixExtractorVerifierJob : Unit.INSTANCE;
    }

    public final HashMap<Integer, String> getSid() {
        return this.sid;
    }

    public final void setSid(HashMap<Integer, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.sid = hashMap;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Interceptor getVideoInterceptor(final ExtractorLink extractorLink) {
        Intrinsics.checkNotNullParameter(extractorLink, "extractorLink");
        return new Interceptor() { // from class: com.lagradost.cloudstream3.animeproviders.-$$Lambda$ZoroProvider$g52fd72XTyEcxWLUkSA_Rt71xHE
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Response m8600getVideoInterceptor$lambda14;
                m8600getVideoInterceptor$lambda14 = ZoroProvider.m8600getVideoInterceptor$lambda14(ZoroProvider.this, extractorLink, chain);
                return m8600getVideoInterceptor$lambda14;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getVideoInterceptor$lambda-14  reason: not valid java name */
    public static final okhttp3.Response m8600getVideoInterceptor$lambda14(ZoroProvider this$0, ExtractorLink extractorLink, Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extractorLink, "$extractorLink");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (StringsKt.endsWith$default(request.url().toString(), ".ts", false, 2, (Object) null) && !Intrinsics.areEqual(request.method(), "OPTIONS") && !StringsKt.contains$default((CharSequence) request.url().toString(), (CharSequence) "betterstream", false, 2, (Object) null)) {
            Request.Builder newBuilder = chain.request().newBuilder();
            String sid = this$0.sid.get(Integer.valueOf(extractorLink.getUrl().hashCode()));
            if (sid != null) {
                Intrinsics.checkNotNullExpressionValue(sid, "sid");
                newBuilder.addHeader("SID", sid);
            }
            Request build = newBuilder.build();
            Coroutines.INSTANCE.ioSafe(new ZoroProvider$getVideoInterceptor$1$1(request.newBuilder().method("OPTIONS", request.body()).build(), null));
            return chain.proceed(build);
        }
        return chain.proceed(chain.request());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013b  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r21, boolean r22, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r23, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super java.lang.Boolean> r25) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.animeproviders.ZoroProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
