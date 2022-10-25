package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: MeloMovieProvider.kt */
@Metadata(m108d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002,-B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018JI\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00042\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001f0\u001dH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020)0$2\u0006\u0010*\u001a\u00020+H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/MeloMovieProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasQuickSearch", "getHasQuickSearch", "instantLinkLoading", "getInstantLinkLoading", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "fixUrl", "url", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "quickSearch", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "search", "serializeData", "Lcom/lagradost/cloudstream3/movieproviders/MeloMovieProvider$MeloMovieLink;", "element", "Lorg/jsoup/nodes/Element;", "MeloMovieLink", "MeloMovieSearchResult", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MeloMovieProvider extends MainAPI {
    private final boolean hasChromecastSupport;
    private String name = "MeloMovie";
    private String mainUrl = "https://melomovie.com";
    private final boolean instantLinkLoading = true;
    private final boolean hasQuickSearch = true;

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
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setMainUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainUrl = str;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    /* compiled from: MeloMovieProvider.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011JB\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/MeloMovieProvider$MeloMovieSearchResult;", "", "id", "", "imdbId", "", "title", "type", "year", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "getId", "()I", "getImdbId", "()Ljava/lang/String;", "getTitle", "getType", "getYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/MeloMovieProvider$MeloMovieSearchResult;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MeloMovieSearchResult {

        /* renamed from: id */
        private final int f9967id;
        private final String imdbId;
        private final String title;
        private final int type;
        private final Integer year;

        public static /* synthetic */ MeloMovieSearchResult copy$default(MeloMovieSearchResult meloMovieSearchResult, int i, String str, String str2, int i2, Integer num, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = meloMovieSearchResult.f9967id;
            }
            if ((i3 & 2) != 0) {
                str = meloMovieSearchResult.imdbId;
            }
            String str3 = str;
            if ((i3 & 4) != 0) {
                str2 = meloMovieSearchResult.title;
            }
            String str4 = str2;
            if ((i3 & 8) != 0) {
                i2 = meloMovieSearchResult.type;
            }
            int i4 = i2;
            if ((i3 & 16) != 0) {
                num = meloMovieSearchResult.year;
            }
            return meloMovieSearchResult.copy(i, str3, str4, i4, num);
        }

        public final int component1() {
            return this.f9967id;
        }

        public final String component2() {
            return this.imdbId;
        }

        public final String component3() {
            return this.title;
        }

        public final int component4() {
            return this.type;
        }

        public final Integer component5() {
            return this.year;
        }

        public final MeloMovieSearchResult copy(@JsonProperty("id") int i, @JsonProperty("imdb_code") String imdbId, @JsonProperty("title") String title, @JsonProperty("type") int i2, @JsonProperty("year") Integer num) {
            Intrinsics.checkNotNullParameter(imdbId, "imdbId");
            Intrinsics.checkNotNullParameter(title, "title");
            return new MeloMovieSearchResult(i, imdbId, title, i2, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MeloMovieSearchResult) {
                MeloMovieSearchResult meloMovieSearchResult = (MeloMovieSearchResult) obj;
                return this.f9967id == meloMovieSearchResult.f9967id && Intrinsics.areEqual(this.imdbId, meloMovieSearchResult.imdbId) && Intrinsics.areEqual(this.title, meloMovieSearchResult.title) && this.type == meloMovieSearchResult.type && Intrinsics.areEqual(this.year, meloMovieSearchResult.year);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((((this.f9967id * 31) + this.imdbId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.type) * 31;
            Integer num = this.year;
            return hashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "MeloMovieSearchResult(id=" + this.f9967id + ", imdbId=" + this.imdbId + ", title=" + this.title + ", type=" + this.type + ", year=" + this.year + ')';
        }

        public MeloMovieSearchResult(@JsonProperty("id") int i, @JsonProperty("imdb_code") String imdbId, @JsonProperty("title") String title, @JsonProperty("type") int i2, @JsonProperty("year") Integer num) {
            Intrinsics.checkNotNullParameter(imdbId, "imdbId");
            Intrinsics.checkNotNullParameter(title, "title");
            this.f9967id = i;
            this.imdbId = imdbId;
            this.title = title;
            this.type = i2;
            this.year = num;
        }

        public final int getId() {
            return this.f9967id;
        }

        public final String getImdbId() {
            return this.imdbId;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getType() {
            return this.type;
        }

        public final Integer getYear() {
            return this.year;
        }
    }

    /* compiled from: MeloMovieProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/MeloMovieProvider$MeloMovieLink;", "", "name", "", "link", "(Ljava/lang/String;Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MeloMovieLink {
        private final String link;
        private final String name;

        public static /* synthetic */ MeloMovieLink copy$default(MeloMovieLink meloMovieLink, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = meloMovieLink.name;
            }
            if ((i & 2) != 0) {
                str2 = meloMovieLink.link;
            }
            return meloMovieLink.copy(str, str2);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.link;
        }

        public final MeloMovieLink copy(@JsonProperty("name") String name, @JsonProperty("link") String link) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(link, "link");
            return new MeloMovieLink(name, link);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MeloMovieLink) {
                MeloMovieLink meloMovieLink = (MeloMovieLink) obj;
                return Intrinsics.areEqual(this.name, meloMovieLink.name) && Intrinsics.areEqual(this.link, meloMovieLink.link);
            }
            return false;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.link.hashCode();
        }

        public String toString() {
            return "MeloMovieLink(name=" + this.name + ", link=" + this.link + ')';
        }

        public MeloMovieLink(@JsonProperty("name") String name, @JsonProperty("link") String link) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(link, "link");
            this.name = name;
            this.link = link;
        }

        public final String getName() {
            return this.name;
        }

        public final String getLink() {
            return this.link;
        }
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object quickSearch(String str, Continuation<? super List<? extends SearchResponse>> continuation) {
        return search(str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b5  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r22, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r23) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.MeloMovieProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String fixUrl(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (StringsKt.startsWith$default(str, "//", false, 2, (Object) null)) {
            return "http:" + str;
        } else if (StringsKt.startsWith$default(str, "http", false, 2, (Object) null)) {
            return str;
        } else {
            return "http://" + str;
        }
    }

    private final List<MeloMovieLink> serializeData(Element element) {
        MeloMovieLink meloMovieLink;
        Elements eps = element.select("> tbody > tr");
        Intrinsics.checkNotNullExpressionValue(eps, "eps");
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = eps.iterator();
        while (true) {
            int i = 1;
            if (!it.hasNext()) {
                break;
            }
            try {
                Elements select = it.next().select("> td");
                if (select.size() != 5) {
                    i = 0;
                }
                String name = select.get(i).text();
                Element last = select.last();
                Intrinsics.checkNotNull(last);
                Element selectFirst = last.selectFirst("> a");
                Intrinsics.checkNotNull(selectFirst);
                String attr = selectFirst.attr("data-lnk");
                Intrinsics.checkNotNullExpressionValue(attr, "tds.last()!!.selectFirst(\"> a\")!!.attr(\"data-lnk\")");
                String fixUrl = fixUrl(StringsKt.replace$default(attr, " ", "%20", false, 4, (Object) null));
                Intrinsics.checkNotNullExpressionValue(name, "name");
                meloMovieLink = new MeloMovieLink(name, fixUrl);
            } catch (Exception unused) {
                meloMovieLink = new MeloMovieLink("", "");
            }
            arrayList.add(meloMovieLink);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            MeloMovieLink meloMovieLink2 = (MeloMovieLink) obj;
            if ((Intrinsics.areEqual(meloMovieLink2.getLink(), "") || Intrinsics.areEqual(meloMovieLink2.getName(), "")) ? false : true) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object loadLinks(String str, boolean z, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Boolean> continuation) {
        AppUtils appUtils = AppUtils.INSTANCE;
        for (MeloMovieLink meloMovieLink : (List) MainAPIKt.getMapper().readValue(str, new TypeReference<List<? extends MeloMovieLink>>() { // from class: com.lagradost.cloudstream3.movieproviders.MeloMovieProvider$loadLinks$$inlined$parseJson$1
        })) {
            function12.invoke(new ExtractorLink(getName(), meloMovieLink.getName(), meloMovieLink.getLink(), "", ExtractorApiKt.getQualityFromName(meloMovieLink.getName()), false, null, null, 192, null));
        }
        return boxing.boxBoolean(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01eb A[RETURN] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r27, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r28) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.MeloMovieProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final String load$findUsingRegex(String str, String str2) {
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        String value;
        MatchResult find$default = Regex.find$default(new Regex(str2), str, 0, 2, null);
        if (find$default == null || (groups = find$default.getGroups()) == null || (matchGroup = groups.get(1)) == null || (value = matchGroup.getValue()) == null) {
            return null;
        }
        return value;
    }
}
