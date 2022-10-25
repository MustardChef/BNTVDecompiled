package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.messaging.Constants;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;

/* compiled from: IdlixProvider.kt */
@Metadata(m108d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\b;<=>?@ABB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u0011\u0010\u001c\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0002JA\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\n2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\"0%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\"0%H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)JA\u0010*\u001a\u00020\"2\u0006\u0010#\u001a\u00020\n2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\"0%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\"0%H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)JA\u0010+\u001a\u00020\"2\u0006\u0010#\u001a\u00020\n2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\"0%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\"0%H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0019\u0010,\u001a\u00020-2\u0006\u0010#\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010.JI\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u00042\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\"0%2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\"0%H\u0096@ø\u0001\u0000¢\u0006\u0002\u00104J\u001f\u00105\u001a\b\u0012\u0004\u0012\u000207062\u0006\u00108\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010.J\f\u00109\u001a\u000207*\u00020:H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006C"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasDownloadSupport", "", "getHasDownloadSupport", "()Z", "hasMainPage", "getHasMainPage", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getLanguage", "str", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProperLink", ShareConstants.MEDIA_URI, "invokeCdnSource", "", "url", "subCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "sourceCallback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeLaviolaSource", "invokeLokalSource", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "callback", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "toSearchResult", "Lorg/jsoup/nodes/Element;", "Captions", "Data", "Player", "ResponseCdn", "ResponseHash", "ResponseLaviolaSource", "ResponseSource", "Tracks", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class IdlixProvider extends MainAPI {
    private String mainUrl = "https://94.103.82.88";
    private String name = "Idlix";
    private final boolean hasMainPage = true;
    private String lang = "id";
    private final boolean hasDownloadSupport = true;
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
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.IdlixProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getProperLink(String str) {
        List<String> groupValues;
        List<String> groupValues2;
        String str2 = str;
        String str3 = null;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "/episode/", false, 2, (Object) null)) {
            MatchResult find$default = Regex.find$default(new Regex("(.+?)-season"), StringsKt.substringAfter$default(str, getMainUrl() + "/episode/", (String) null, 2, (Object) null), 0, 2, null);
            if (find$default != null && (groupValues2 = find$default.getGroupValues()) != null) {
                str3 = groupValues2.get(1);
            }
            String valueOf = String.valueOf(str3);
            return getMainUrl() + "/tvseries/" + valueOf;
        } else if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "/season/", false, 2, (Object) null)) {
            MatchResult find$default2 = Regex.find$default(new Regex("(.+?)-season"), StringsKt.substringAfter$default(str, getMainUrl() + "/season/", (String) null, 2, (Object) null), 0, 2, null);
            if (find$default2 != null && (groupValues = find$default2.getGroupValues()) != null) {
                str3 = groupValues.get(1);
            }
            String valueOf2 = String.valueOf(str3);
            return getMainUrl() + "/tvseries/" + valueOf2;
        } else {
            return str;
        }
    }

    private final SearchResponse toSearchResult(Element element) {
        Element selectFirst = element.selectFirst("h3 > a");
        Intrinsics.checkNotNull(selectFirst);
        String text = selectFirst.text();
        Intrinsics.checkNotNullExpressionValue(text, "this.selectFirst(\"h3 > a\")!!.text()");
        String obj = StringsKt.trim((CharSequence) new Regex("\\(\\d{4}\\)").replace(text, "")).toString();
        Element selectFirst2 = element.selectFirst("h3 > a");
        Intrinsics.checkNotNull(selectFirst2);
        String attr = selectFirst2.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Intrinsics.checkNotNullExpressionValue(attr, "this.selectFirst(\"h3 > a\")!!.attr(\"href\")");
        return MainAPIKt.newMovieSearchResponse$default(this, obj, getProperLink(attr), TvType.Movie, false, new IdlixProvider$toSearchResult$1(element.select("div.poster > img").attr("src").toString(), MainAPIKt.getQualityFromString(element.select("span.quality").text())), 8, null);
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
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.IdlixProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dc A[LOOP:0: B:27:0x00d6->B:29:0x00dc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01b0 A[LOOP:1: B:51:0x01a8->B:53:0x01b0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0298 A[EDGE_INSN: B:73:0x0298->B:62:0x0298 ?: BREAK  , SYNTHETIC] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r35, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r36) {
        /*
            Method dump skipped, instructions count: 966
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.IdlixProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getLanguage(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "indonesia", false, 2, (Object) null)) {
            String lowerCase2 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "bahasa", false, 2, (Object) null)) {
                return str;
            }
        }
        return "Indonesian";
    }

    /* compiled from: IdlixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$ResponseHash;", "", "embed_url", "", "type", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmbed_url", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResponseHash {
        private final String embed_url;
        private final String type;

        public static /* synthetic */ ResponseHash copy$default(ResponseHash responseHash, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = responseHash.embed_url;
            }
            if ((i & 2) != 0) {
                str2 = responseHash.type;
            }
            return responseHash.copy(str, str2);
        }

        public final String component1() {
            return this.embed_url;
        }

        public final String component2() {
            return this.type;
        }

        public final ResponseHash copy(@JsonProperty("embed_url") String embed_url, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(embed_url, "embed_url");
            return new ResponseHash(embed_url, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResponseHash) {
                ResponseHash responseHash = (ResponseHash) obj;
                return Intrinsics.areEqual(this.embed_url, responseHash.embed_url) && Intrinsics.areEqual(this.type, responseHash.type);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.embed_url.hashCode() * 31;
            String str = this.type;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ResponseHash(embed_url=" + this.embed_url + ", type=" + this.type + ')';
        }

        public ResponseHash(@JsonProperty("embed_url") String embed_url, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(embed_url, "embed_url");
            this.embed_url = embed_url;
            this.type = str;
        }

        public final String getEmbed_url() {
            return this.embed_url;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: IdlixProvider.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$ResponseSource;", "", "hls", "", "videoSource", "", "securedLink", "(ZLjava/lang/String;Ljava/lang/String;)V", "getHls", "()Z", "getSecuredLink", "()Ljava/lang/String;", "getVideoSource", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResponseSource {
        private final boolean hls;
        private final String securedLink;
        private final String videoSource;

        public static /* synthetic */ ResponseSource copy$default(ResponseSource responseSource, boolean z, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = responseSource.hls;
            }
            if ((i & 2) != 0) {
                str = responseSource.videoSource;
            }
            if ((i & 4) != 0) {
                str2 = responseSource.securedLink;
            }
            return responseSource.copy(z, str, str2);
        }

        public final boolean component1() {
            return this.hls;
        }

        public final String component2() {
            return this.videoSource;
        }

        public final String component3() {
            return this.securedLink;
        }

        public final ResponseSource copy(@JsonProperty("hls") boolean z, @JsonProperty("videoSource") String videoSource, @JsonProperty("securedLink") String str) {
            Intrinsics.checkNotNullParameter(videoSource, "videoSource");
            return new ResponseSource(z, videoSource, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResponseSource) {
                ResponseSource responseSource = (ResponseSource) obj;
                return this.hls == responseSource.hls && Intrinsics.areEqual(this.videoSource, responseSource.videoSource) && Intrinsics.areEqual(this.securedLink, responseSource.securedLink);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z = this.hls;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int hashCode = ((r0 * 31) + this.videoSource.hashCode()) * 31;
            String str = this.securedLink;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ResponseSource(hls=" + this.hls + ", videoSource=" + this.videoSource + ", securedLink=" + this.securedLink + ')';
        }

        public ResponseSource(@JsonProperty("hls") boolean z, @JsonProperty("videoSource") String videoSource, @JsonProperty("securedLink") String str) {
            Intrinsics.checkNotNullParameter(videoSource, "videoSource");
            this.hls = z;
            this.videoSource = videoSource;
            this.securedLink = str;
        }

        public final boolean getHls() {
            return this.hls;
        }

        public final String getVideoSource() {
            return this.videoSource;
        }

        public final String getSecuredLink() {
            return this.securedLink;
        }
    }

    /* compiled from: IdlixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$Tracks;", "", "kind", "", "file", Constants.ScionAnalytics.PARAM_LABEL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getKind", "getLabel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Tracks {
        private final String file;
        private final String kind;
        private final String label;

        public static /* synthetic */ Tracks copy$default(Tracks tracks, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tracks.kind;
            }
            if ((i & 2) != 0) {
                str2 = tracks.file;
            }
            if ((i & 4) != 0) {
                str3 = tracks.label;
            }
            return tracks.copy(str, str2, str3);
        }

        public final String component1() {
            return this.kind;
        }

        public final String component2() {
            return this.file;
        }

        public final String component3() {
            return this.label;
        }

        public final Tracks copy(@JsonProperty("kind") String str, @JsonProperty("file") String file, @JsonProperty("label") String str2) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new Tracks(str, file, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Tracks) {
                Tracks tracks = (Tracks) obj;
                return Intrinsics.areEqual(this.kind, tracks.kind) && Intrinsics.areEqual(this.file, tracks.file) && Intrinsics.areEqual(this.label, tracks.label);
            }
            return false;
        }

        public int hashCode() {
            String str = this.kind;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.file.hashCode()) * 31;
            String str2 = this.label;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Tracks(kind=" + this.kind + ", file=" + this.file + ", label=" + this.label + ')';
        }

        public Tracks(@JsonProperty("kind") String str, @JsonProperty("file") String file, @JsonProperty("label") String str2) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.kind = str;
            this.file = file;
            this.label = str2;
        }

        public final String getKind() {
            return this.kind;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0193 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01d7 A[LOOP:0: B:25:0x01d1->B:27:0x01d7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02ac A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeLokalSource(java.lang.String r28, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r29, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r30, kotlin.coroutines.Continuation<? super kotlin.Unit> r31) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.IdlixProvider.invokeLokalSource(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: IdlixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$ResponseLaviolaSource;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "(Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResponseLaviolaSource {
        private final String file;
        private final String label;

        public static /* synthetic */ ResponseLaviolaSource copy$default(ResponseLaviolaSource responseLaviolaSource, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = responseLaviolaSource.file;
            }
            if ((i & 2) != 0) {
                str2 = responseLaviolaSource.label;
            }
            return responseLaviolaSource.copy(str, str2);
        }

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.label;
        }

        public final ResponseLaviolaSource copy(@JsonProperty("file") String file, @JsonProperty("label") String str) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new ResponseLaviolaSource(file, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResponseLaviolaSource) {
                ResponseLaviolaSource responseLaviolaSource = (ResponseLaviolaSource) obj;
                return Intrinsics.areEqual(this.file, responseLaviolaSource.file) && Intrinsics.areEqual(this.label, responseLaviolaSource.label);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.file.hashCode() * 31;
            String str = this.label;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ResponseLaviolaSource(file=" + this.file + ", label=" + this.label + ')';
        }

        public ResponseLaviolaSource(@JsonProperty("file") String file, @JsonProperty("label") String str) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
            this.label = str;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0253 A[LOOP:0: B:39:0x024d->B:41:0x0253, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0194 -> B:32:0x01b3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x020d -> B:38:0x021d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x02ca -> B:45:0x02ce). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x03ae -> B:63:0x03ba). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeLaviolaSource(java.lang.String r45, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r46, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r47, kotlin.coroutines.Continuation<? super kotlin.Unit> r48) {
        /*
            Method dump skipped, instructions count: 979
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.IdlixProvider.invokeLaviolaSource(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdlixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$Captions;", "", "id", "", "hash", "language", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHash", "()Ljava/lang/String;", "getId", "getLanguage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Captions {
        private final String hash;

        /* renamed from: id */
        private final String f9962id;
        private final String language;

        public static /* synthetic */ Captions copy$default(Captions captions, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = captions.f9962id;
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
            return this.f9962id;
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
                return Intrinsics.areEqual(this.f9962id, captions.f9962id) && Intrinsics.areEqual(this.hash, captions.hash) && Intrinsics.areEqual(this.language, captions.language);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f9962id.hashCode() * 31) + this.hash.hashCode()) * 31) + this.language.hashCode();
        }

        public String toString() {
            return "Captions(id=" + this.f9962id + ", hash=" + this.hash + ", language=" + this.language + ')';
        }

        public Captions(@JsonProperty("id") String id, @JsonProperty("hash") String hash, @JsonProperty("language") String language) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(language, "language");
            this.f9962id = id;
            this.hash = hash;
            this.language = language;
        }

        public final String getId() {
            return this.f9962id;
        }

        public final String getHash() {
            return this.hash;
        }

        public final String getLanguage() {
            return this.language;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdlixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$Data;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "(Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
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
    /* compiled from: IdlixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$Player;", "", "poster_file", "", "(Ljava/lang/String;)V", "getPoster_file", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
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
    /* compiled from: IdlixProvider.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$ResponseCdn;", "", "success", "", "player", "Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$Player;", "data", "", "Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$Data;", "captions", "Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$Captions;", "(ZLcom/lagradost/cloudstream3/movieproviders/IdlixProvider$Player;Ljava/util/List;Ljava/util/List;)V", "getCaptions", "()Ljava/util/List;", "getData", "getPlayer", "()Lcom/lagradost/cloudstream3/movieproviders/IdlixProvider$Player;", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResponseCdn {
        private final List<Captions> captions;
        private final List<Data> data;
        private final Player player;
        private final boolean success;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ResponseCdn copy$default(ResponseCdn responseCdn, boolean z, Player player, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = responseCdn.success;
            }
            if ((i & 2) != 0) {
                player = responseCdn.player;
            }
            if ((i & 4) != 0) {
                list = responseCdn.data;
            }
            if ((i & 8) != 0) {
                list2 = responseCdn.captions;
            }
            return responseCdn.copy(z, player, list, list2);
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

        public final ResponseCdn copy(@JsonProperty("success") boolean z, @JsonProperty("player") Player player, @JsonProperty("data") List<Data> list, @JsonProperty("captions") List<Captions> list2) {
            Intrinsics.checkNotNullParameter(player, "player");
            return new ResponseCdn(z, player, list, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResponseCdn) {
                ResponseCdn responseCdn = (ResponseCdn) obj;
                return this.success == responseCdn.success && Intrinsics.areEqual(this.player, responseCdn.player) && Intrinsics.areEqual(this.data, responseCdn.data) && Intrinsics.areEqual(this.captions, responseCdn.captions);
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
            return "ResponseCdn(success=" + this.success + ", player=" + this.player + ", data=" + this.data + ", captions=" + this.captions + ')';
        }

        public ResponseCdn(@JsonProperty("success") boolean z, @JsonProperty("player") Player player, @JsonProperty("data") List<Data> list, @JsonProperty("captions") List<Captions> list2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeCdnSource(java.lang.String r30, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r31, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r32, kotlin.coroutines.Continuation<? super kotlin.Unit> r33) {
        /*
            Method dump skipped, instructions count: 551
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.IdlixProvider.invokeCdnSource(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00dc A[LOOP:0: B:23:0x00d6->B:25:0x00dc, LOOP_END] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r21, boolean r22, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r23, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super java.lang.Boolean> r25) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.IdlixProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
