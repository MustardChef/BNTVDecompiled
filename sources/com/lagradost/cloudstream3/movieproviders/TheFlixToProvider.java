package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.common.net.HttpHeaders;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: TheFlixToProvider.kt */
@Metadata(m108d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 22\u00020\u0001:\u001a23456789:;<=>?@ABCDEFGHIJKB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001aH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0011\u0010 \u001a\u00020!H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u001b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001e\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJI\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00042\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020*0(H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010-J\u001f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u00101\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006L"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasMainPage", "", "getHasMainPage", "()Z", "instantLinkLoading", "getInstantLinkLoading", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "cleanTitle", "title", "getCookies", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoadMan", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadMain;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "Companion", "Docs", "Episodes", "Genres", "HomeJson", "HomeProps", "LoadMain", "LoadPageProps", "LoadProps", "MoviesListNewArrivals", "MoviesListTrending", "PageProps", "RecommendationsList", "RuntimeConfig", "RuntimeConfigData", "SearchJson", "SearchMainList", "SearchPageProps", "SearchProps", "Seasons", HttpHeaders.SERVER, "TheFlixMetadata", "TmdbServer", "TvsListNewEpisodes", "TvsListTrending", "VideoData", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class TheFlixToProvider extends MainAPI {
    public static final Companion Companion = new Companion(null);
    private static Map<String, String> latestCookies = MapsKt.emptyMap();
    private final boolean instantLinkLoading;
    private String name = "TheFlix.to";
    private String mainUrl = "https://theflix.to";
    private final boolean hasMainPage = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries});

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TvType.values().length];
            iArr[TvType.TvSeries.ordinal()] = 1;
            iArr[TvType.Movie.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Companion;", "", "()V", "latestCookies", "", "", "getLatestCookies", "()Ljava/util/Map;", "setLatestCookies", "(Ljava/util/Map;)V", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, String> getLatestCookies() {
            return TheFlixToProvider.latestCookies;
        }

        public final void setLatestCookies(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            TheFlixToProvider.latestCookies = map;
        }
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
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$HomeJson;", "", "props", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$HomeProps;", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$HomeProps;)V", "getProps", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$HomeProps;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class HomeJson {
        private final HomeProps props;

        public HomeJson() {
            this(null, 1, null);
        }

        public static /* synthetic */ HomeJson copy$default(HomeJson homeJson, HomeProps homeProps, int i, Object obj) {
            if ((i & 1) != 0) {
                homeProps = homeJson.props;
            }
            return homeJson.copy(homeProps);
        }

        public final HomeProps component1() {
            return this.props;
        }

        public final HomeJson copy(@JsonProperty("props") HomeProps props) {
            Intrinsics.checkNotNullParameter(props, "props");
            return new HomeJson(props);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HomeJson) && Intrinsics.areEqual(this.props, ((HomeJson) obj).props);
        }

        public int hashCode() {
            return this.props.hashCode();
        }

        public String toString() {
            return "HomeJson(props=" + this.props + ')';
        }

        public HomeJson(@JsonProperty("props") HomeProps props) {
            Intrinsics.checkNotNullParameter(props, "props");
            this.props = props;
        }

        public /* synthetic */ HomeJson(HomeProps homeProps, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new HomeProps(null, 1, null) : homeProps);
        }

        public final HomeProps getProps() {
            return this.props;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$HomeProps;", "", "pageProps", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$PageProps;", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$PageProps;)V", "getPageProps", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$PageProps;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class HomeProps {
        private final PageProps pageProps;

        public HomeProps() {
            this(null, 1, null);
        }

        public static /* synthetic */ HomeProps copy$default(HomeProps homeProps, PageProps pageProps, int i, Object obj) {
            if ((i & 1) != 0) {
                pageProps = homeProps.pageProps;
            }
            return homeProps.copy(pageProps);
        }

        public final PageProps component1() {
            return this.pageProps;
        }

        public final HomeProps copy(@JsonProperty("pageProps") PageProps pageProps) {
            Intrinsics.checkNotNullParameter(pageProps, "pageProps");
            return new HomeProps(pageProps);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HomeProps) && Intrinsics.areEqual(this.pageProps, ((HomeProps) obj).pageProps);
        }

        public int hashCode() {
            return this.pageProps.hashCode();
        }

        public String toString() {
            return "HomeProps(pageProps=" + this.pageProps + ')';
        }

        public HomeProps(@JsonProperty("pageProps") PageProps pageProps) {
            Intrinsics.checkNotNullParameter(pageProps, "pageProps");
            this.pageProps = pageProps;
        }

        public /* synthetic */ HomeProps(PageProps pageProps, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new PageProps(null, null, null, null, 15, null) : pageProps);
        }

        public final PageProps getPageProps() {
            return this.pageProps;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$PageProps;", "", "moviesListTrending", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$MoviesListTrending;", "moviesListNewArrivals", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$MoviesListNewArrivals;", "tvsListTrending", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TvsListTrending;", "tvsListNewEpisodes", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TvsListNewEpisodes;", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$MoviesListTrending;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$MoviesListNewArrivals;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TvsListTrending;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TvsListNewEpisodes;)V", "getMoviesListNewArrivals", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$MoviesListNewArrivals;", "getMoviesListTrending", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$MoviesListTrending;", "getTvsListNewEpisodes", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TvsListNewEpisodes;", "getTvsListTrending", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TvsListTrending;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class PageProps {
        private final MoviesListNewArrivals moviesListNewArrivals;
        private final MoviesListTrending moviesListTrending;
        private final TvsListNewEpisodes tvsListNewEpisodes;
        private final TvsListTrending tvsListTrending;

        public PageProps() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ PageProps copy$default(PageProps pageProps, MoviesListTrending moviesListTrending, MoviesListNewArrivals moviesListNewArrivals, TvsListTrending tvsListTrending, TvsListNewEpisodes tvsListNewEpisodes, int i, Object obj) {
            if ((i & 1) != 0) {
                moviesListTrending = pageProps.moviesListTrending;
            }
            if ((i & 2) != 0) {
                moviesListNewArrivals = pageProps.moviesListNewArrivals;
            }
            if ((i & 4) != 0) {
                tvsListTrending = pageProps.tvsListTrending;
            }
            if ((i & 8) != 0) {
                tvsListNewEpisodes = pageProps.tvsListNewEpisodes;
            }
            return pageProps.copy(moviesListTrending, moviesListNewArrivals, tvsListTrending, tvsListNewEpisodes);
        }

        public final MoviesListTrending component1() {
            return this.moviesListTrending;
        }

        public final MoviesListNewArrivals component2() {
            return this.moviesListNewArrivals;
        }

        public final TvsListTrending component3() {
            return this.tvsListTrending;
        }

        public final TvsListNewEpisodes component4() {
            return this.tvsListNewEpisodes;
        }

        public final PageProps copy(@JsonProperty("moviesListTrending") MoviesListTrending moviesListTrending, @JsonProperty("moviesListNewArrivals") MoviesListNewArrivals moviesListNewArrivals, @JsonProperty("tvsListTrending") TvsListTrending tvsListTrending, @JsonProperty("tvsListNewEpisodes") TvsListNewEpisodes tvsListNewEpisodes) {
            Intrinsics.checkNotNullParameter(moviesListTrending, "moviesListTrending");
            Intrinsics.checkNotNullParameter(moviesListNewArrivals, "moviesListNewArrivals");
            Intrinsics.checkNotNullParameter(tvsListTrending, "tvsListTrending");
            Intrinsics.checkNotNullParameter(tvsListNewEpisodes, "tvsListNewEpisodes");
            return new PageProps(moviesListTrending, moviesListNewArrivals, tvsListTrending, tvsListNewEpisodes);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PageProps) {
                PageProps pageProps = (PageProps) obj;
                return Intrinsics.areEqual(this.moviesListTrending, pageProps.moviesListTrending) && Intrinsics.areEqual(this.moviesListNewArrivals, pageProps.moviesListNewArrivals) && Intrinsics.areEqual(this.tvsListTrending, pageProps.tvsListTrending) && Intrinsics.areEqual(this.tvsListNewEpisodes, pageProps.tvsListNewEpisodes);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.moviesListTrending.hashCode() * 31) + this.moviesListNewArrivals.hashCode()) * 31) + this.tvsListTrending.hashCode()) * 31) + this.tvsListNewEpisodes.hashCode();
        }

        public String toString() {
            return "PageProps(moviesListTrending=" + this.moviesListTrending + ", moviesListNewArrivals=" + this.moviesListNewArrivals + ", tvsListTrending=" + this.tvsListTrending + ", tvsListNewEpisodes=" + this.tvsListNewEpisodes + ')';
        }

        public PageProps(@JsonProperty("moviesListTrending") MoviesListTrending moviesListTrending, @JsonProperty("moviesListNewArrivals") MoviesListNewArrivals moviesListNewArrivals, @JsonProperty("tvsListTrending") TvsListTrending tvsListTrending, @JsonProperty("tvsListNewEpisodes") TvsListNewEpisodes tvsListNewEpisodes) {
            Intrinsics.checkNotNullParameter(moviesListTrending, "moviesListTrending");
            Intrinsics.checkNotNullParameter(moviesListNewArrivals, "moviesListNewArrivals");
            Intrinsics.checkNotNullParameter(tvsListTrending, "tvsListTrending");
            Intrinsics.checkNotNullParameter(tvsListNewEpisodes, "tvsListNewEpisodes");
            this.moviesListTrending = moviesListTrending;
            this.moviesListNewArrivals = moviesListNewArrivals;
            this.tvsListTrending = tvsListTrending;
            this.tvsListNewEpisodes = tvsListNewEpisodes;
        }

        public /* synthetic */ PageProps(MoviesListTrending moviesListTrending, MoviesListNewArrivals moviesListNewArrivals, TvsListTrending tvsListTrending, TvsListNewEpisodes tvsListNewEpisodes, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new MoviesListTrending(null, null, null, null, null, null, 63, null) : moviesListTrending, (i & 2) != 0 ? new MoviesListNewArrivals(null, null, null, null, null, null, 63, null) : moviesListNewArrivals, (i & 4) != 0 ? new TvsListTrending(null, null, null, null, null, null, 63, null) : tvsListTrending, (i & 8) != 0 ? new TvsListNewEpisodes(null, null, null, null, null, null, 63, null) : tvsListNewEpisodes);
        }

        public final MoviesListTrending getMoviesListTrending() {
            return this.moviesListTrending;
        }

        public final MoviesListNewArrivals getMoviesListNewArrivals() {
            return this.moviesListNewArrivals;
        }

        public final TvsListTrending getTvsListTrending() {
            return this.tvsListTrending;
        }

        public final TvsListNewEpisodes getTvsListNewEpisodes() {
            return this.tvsListNewEpisodes;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003Jd\u0010\u001e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$MoviesListTrending;", "", "docs", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Docs;", "Lkotlin/collections/ArrayList;", "total", "", "page", "limit", "pages", "type", "", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getDocs", "()Ljava/util/ArrayList;", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPage", "getPages", "getTotal", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$MoviesListTrending;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MoviesListTrending {
        private final ArrayList<Docs> docs;
        private final Integer limit;
        private final Integer page;
        private final Integer pages;
        private final Integer total;
        private final String type;

        public MoviesListTrending() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ MoviesListTrending copy$default(MoviesListTrending moviesListTrending, ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, Object obj) {
            ArrayList<Docs> arrayList2 = arrayList;
            if ((i & 1) != 0) {
                arrayList2 = moviesListTrending.docs;
            }
            if ((i & 2) != 0) {
                num = moviesListTrending.total;
            }
            Integer num5 = num;
            if ((i & 4) != 0) {
                num2 = moviesListTrending.page;
            }
            Integer num6 = num2;
            if ((i & 8) != 0) {
                num3 = moviesListTrending.limit;
            }
            Integer num7 = num3;
            if ((i & 16) != 0) {
                num4 = moviesListTrending.pages;
            }
            Integer num8 = num4;
            if ((i & 32) != 0) {
                str = moviesListTrending.type;
            }
            return moviesListTrending.copy(arrayList2, num5, num6, num7, num8, str);
        }

        public final ArrayList<Docs> component1() {
            return this.docs;
        }

        public final Integer component2() {
            return this.total;
        }

        public final Integer component3() {
            return this.page;
        }

        public final Integer component4() {
            return this.limit;
        }

        public final Integer component5() {
            return this.pages;
        }

        public final String component6() {
            return this.type;
        }

        public final MoviesListTrending copy(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            return new MoviesListTrending(docs, num, num2, num3, num4, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MoviesListTrending) {
                MoviesListTrending moviesListTrending = (MoviesListTrending) obj;
                return Intrinsics.areEqual(this.docs, moviesListTrending.docs) && Intrinsics.areEqual(this.total, moviesListTrending.total) && Intrinsics.areEqual(this.page, moviesListTrending.page) && Intrinsics.areEqual(this.limit, moviesListTrending.limit) && Intrinsics.areEqual(this.pages, moviesListTrending.pages) && Intrinsics.areEqual(this.type, moviesListTrending.type);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.docs.hashCode() * 31;
            Integer num = this.total;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.page;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.limit;
            int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.pages;
            int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
            String str = this.type;
            return hashCode5 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "MoviesListTrending(docs=" + this.docs + ", total=" + this.total + ", page=" + this.page + ", limit=" + this.limit + ", pages=" + this.pages + ", type=" + this.type + ')';
        }

        public MoviesListTrending(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            this.docs = docs;
            this.total = num;
            this.page = num2;
            this.limit = num3;
            this.pages = num4;
            this.type = str;
        }

        public /* synthetic */ MoviesListTrending(ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) == 0 ? str : null);
        }

        public final ArrayList<Docs> getDocs() {
            return this.docs;
        }

        public final Integer getTotal() {
            return this.total;
        }

        public final Integer getPage() {
            return this.page;
        }

        public final Integer getLimit() {
            return this.limit;
        }

        public final Integer getPages() {
            return this.pages;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003Jd\u0010\u001e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$MoviesListNewArrivals;", "", "docs", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Docs;", "Lkotlin/collections/ArrayList;", "total", "", "page", "limit", "pages", "type", "", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getDocs", "()Ljava/util/ArrayList;", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPage", "getPages", "getTotal", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$MoviesListNewArrivals;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MoviesListNewArrivals {
        private final ArrayList<Docs> docs;
        private final Integer limit;
        private final Integer page;
        private final Integer pages;
        private final Integer total;
        private final String type;

        public MoviesListNewArrivals() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ MoviesListNewArrivals copy$default(MoviesListNewArrivals moviesListNewArrivals, ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, Object obj) {
            ArrayList<Docs> arrayList2 = arrayList;
            if ((i & 1) != 0) {
                arrayList2 = moviesListNewArrivals.docs;
            }
            if ((i & 2) != 0) {
                num = moviesListNewArrivals.total;
            }
            Integer num5 = num;
            if ((i & 4) != 0) {
                num2 = moviesListNewArrivals.page;
            }
            Integer num6 = num2;
            if ((i & 8) != 0) {
                num3 = moviesListNewArrivals.limit;
            }
            Integer num7 = num3;
            if ((i & 16) != 0) {
                num4 = moviesListNewArrivals.pages;
            }
            Integer num8 = num4;
            if ((i & 32) != 0) {
                str = moviesListNewArrivals.type;
            }
            return moviesListNewArrivals.copy(arrayList2, num5, num6, num7, num8, str);
        }

        public final ArrayList<Docs> component1() {
            return this.docs;
        }

        public final Integer component2() {
            return this.total;
        }

        public final Integer component3() {
            return this.page;
        }

        public final Integer component4() {
            return this.limit;
        }

        public final Integer component5() {
            return this.pages;
        }

        public final String component6() {
            return this.type;
        }

        public final MoviesListNewArrivals copy(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            return new MoviesListNewArrivals(docs, num, num2, num3, num4, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MoviesListNewArrivals) {
                MoviesListNewArrivals moviesListNewArrivals = (MoviesListNewArrivals) obj;
                return Intrinsics.areEqual(this.docs, moviesListNewArrivals.docs) && Intrinsics.areEqual(this.total, moviesListNewArrivals.total) && Intrinsics.areEqual(this.page, moviesListNewArrivals.page) && Intrinsics.areEqual(this.limit, moviesListNewArrivals.limit) && Intrinsics.areEqual(this.pages, moviesListNewArrivals.pages) && Intrinsics.areEqual(this.type, moviesListNewArrivals.type);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.docs.hashCode() * 31;
            Integer num = this.total;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.page;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.limit;
            int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.pages;
            int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
            String str = this.type;
            return hashCode5 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "MoviesListNewArrivals(docs=" + this.docs + ", total=" + this.total + ", page=" + this.page + ", limit=" + this.limit + ", pages=" + this.pages + ", type=" + this.type + ')';
        }

        public MoviesListNewArrivals(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            this.docs = docs;
            this.total = num;
            this.page = num2;
            this.limit = num3;
            this.pages = num4;
            this.type = str;
        }

        public /* synthetic */ MoviesListNewArrivals(ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) == 0 ? str : null);
        }

        public final ArrayList<Docs> getDocs() {
            return this.docs;
        }

        public final Integer getTotal() {
            return this.total;
        }

        public final Integer getPage() {
            return this.page;
        }

        public final Integer getLimit() {
            return this.limit;
        }

        public final Integer getPages() {
            return this.pages;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003Jd\u0010\u001e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TvsListTrending;", "", "docs", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Docs;", "Lkotlin/collections/ArrayList;", "total", "", "page", "limit", "pages", "type", "", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getDocs", "()Ljava/util/ArrayList;", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPage", "getPages", "getTotal", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TvsListTrending;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class TvsListTrending {
        private final ArrayList<Docs> docs;
        private final Integer limit;
        private final Integer page;
        private final Integer pages;
        private final Integer total;
        private final String type;

        public TvsListTrending() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ TvsListTrending copy$default(TvsListTrending tvsListTrending, ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, Object obj) {
            ArrayList<Docs> arrayList2 = arrayList;
            if ((i & 1) != 0) {
                arrayList2 = tvsListTrending.docs;
            }
            if ((i & 2) != 0) {
                num = tvsListTrending.total;
            }
            Integer num5 = num;
            if ((i & 4) != 0) {
                num2 = tvsListTrending.page;
            }
            Integer num6 = num2;
            if ((i & 8) != 0) {
                num3 = tvsListTrending.limit;
            }
            Integer num7 = num3;
            if ((i & 16) != 0) {
                num4 = tvsListTrending.pages;
            }
            Integer num8 = num4;
            if ((i & 32) != 0) {
                str = tvsListTrending.type;
            }
            return tvsListTrending.copy(arrayList2, num5, num6, num7, num8, str);
        }

        public final ArrayList<Docs> component1() {
            return this.docs;
        }

        public final Integer component2() {
            return this.total;
        }

        public final Integer component3() {
            return this.page;
        }

        public final Integer component4() {
            return this.limit;
        }

        public final Integer component5() {
            return this.pages;
        }

        public final String component6() {
            return this.type;
        }

        public final TvsListTrending copy(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            return new TvsListTrending(docs, num, num2, num3, num4, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TvsListTrending) {
                TvsListTrending tvsListTrending = (TvsListTrending) obj;
                return Intrinsics.areEqual(this.docs, tvsListTrending.docs) && Intrinsics.areEqual(this.total, tvsListTrending.total) && Intrinsics.areEqual(this.page, tvsListTrending.page) && Intrinsics.areEqual(this.limit, tvsListTrending.limit) && Intrinsics.areEqual(this.pages, tvsListTrending.pages) && Intrinsics.areEqual(this.type, tvsListTrending.type);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.docs.hashCode() * 31;
            Integer num = this.total;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.page;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.limit;
            int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.pages;
            int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
            String str = this.type;
            return hashCode5 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "TvsListTrending(docs=" + this.docs + ", total=" + this.total + ", page=" + this.page + ", limit=" + this.limit + ", pages=" + this.pages + ", type=" + this.type + ')';
        }

        public TvsListTrending(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            this.docs = docs;
            this.total = num;
            this.page = num2;
            this.limit = num3;
            this.pages = num4;
            this.type = str;
        }

        public /* synthetic */ TvsListTrending(ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) == 0 ? str : null);
        }

        public final ArrayList<Docs> getDocs() {
            return this.docs;
        }

        public final Integer getTotal() {
            return this.total;
        }

        public final Integer getPage() {
            return this.page;
        }

        public final Integer getLimit() {
            return this.limit;
        }

        public final Integer getPages() {
            return this.pages;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003Jd\u0010\u001e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TvsListNewEpisodes;", "", "docs", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Docs;", "Lkotlin/collections/ArrayList;", "total", "", "page", "limit", "pages", "type", "", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getDocs", "()Ljava/util/ArrayList;", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPage", "getPages", "getTotal", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TvsListNewEpisodes;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class TvsListNewEpisodes {
        private final ArrayList<Docs> docs;
        private final Integer limit;
        private final Integer page;
        private final Integer pages;
        private final Integer total;
        private final String type;

        public TvsListNewEpisodes() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ TvsListNewEpisodes copy$default(TvsListNewEpisodes tvsListNewEpisodes, ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, Object obj) {
            ArrayList<Docs> arrayList2 = arrayList;
            if ((i & 1) != 0) {
                arrayList2 = tvsListNewEpisodes.docs;
            }
            if ((i & 2) != 0) {
                num = tvsListNewEpisodes.total;
            }
            Integer num5 = num;
            if ((i & 4) != 0) {
                num2 = tvsListNewEpisodes.page;
            }
            Integer num6 = num2;
            if ((i & 8) != 0) {
                num3 = tvsListNewEpisodes.limit;
            }
            Integer num7 = num3;
            if ((i & 16) != 0) {
                num4 = tvsListNewEpisodes.pages;
            }
            Integer num8 = num4;
            if ((i & 32) != 0) {
                str = tvsListNewEpisodes.type;
            }
            return tvsListNewEpisodes.copy(arrayList2, num5, num6, num7, num8, str);
        }

        public final ArrayList<Docs> component1() {
            return this.docs;
        }

        public final Integer component2() {
            return this.total;
        }

        public final Integer component3() {
            return this.page;
        }

        public final Integer component4() {
            return this.limit;
        }

        public final Integer component5() {
            return this.pages;
        }

        public final String component6() {
            return this.type;
        }

        public final TvsListNewEpisodes copy(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            return new TvsListNewEpisodes(docs, num, num2, num3, num4, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TvsListNewEpisodes) {
                TvsListNewEpisodes tvsListNewEpisodes = (TvsListNewEpisodes) obj;
                return Intrinsics.areEqual(this.docs, tvsListNewEpisodes.docs) && Intrinsics.areEqual(this.total, tvsListNewEpisodes.total) && Intrinsics.areEqual(this.page, tvsListNewEpisodes.page) && Intrinsics.areEqual(this.limit, tvsListNewEpisodes.limit) && Intrinsics.areEqual(this.pages, tvsListNewEpisodes.pages) && Intrinsics.areEqual(this.type, tvsListNewEpisodes.type);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.docs.hashCode() * 31;
            Integer num = this.total;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.page;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.limit;
            int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.pages;
            int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
            String str = this.type;
            return hashCode5 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "TvsListNewEpisodes(docs=" + this.docs + ", total=" + this.total + ", page=" + this.page + ", limit=" + this.limit + ", pages=" + this.pages + ", type=" + this.type + ')';
        }

        public TvsListNewEpisodes(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            this.docs = docs;
            this.total = num;
            this.page = num2;
            this.limit = num3;
            this.pages = num4;
            this.type = str;
        }

        public /* synthetic */ TvsListNewEpisodes(ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) == 0 ? str : null);
        }

        public final ArrayList<Docs> getDocs() {
            return this.docs;
        }

        public final Integer getTotal() {
            return this.total;
        }

        public final Integer getPage() {
            return this.page;
        }

        public final Integer getLimit() {
            return this.limit;
        }

        public final Integer getPages() {
            return this.pages;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u001c\b\u0003\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0019¢\u0006\u0002\u0010\u001aJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010=\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u001d\u0010>\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0019HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jö\u0001\u0010G\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u001c\b\u0003\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0019HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020\u00162\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\bHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010%\u001a\u0004\b.\u0010$R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR%\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0019¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010+\u001a\u0004\b3\u0010*R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010%\u001a\u0004\b4\u0010$¨\u0006M"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Docs;", "", "name", "", "originalLanguage", "popularity", "", "runtime", "", "status", "voteAverage", "voteCount", "cast", "director", "overview", "posterUrl", "releaseDate", "createdAt", "updatedAt", "conversionDate", "id", "available", "", "videos", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/ArrayList;)V", "getAvailable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCast", "()Ljava/lang/String;", "getConversionDate", "getCreatedAt", "getDirector", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getOriginalLanguage", "getOverview", "getPopularity", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPosterUrl", "getReleaseDate", "getRuntime", "getStatus", "getUpdatedAt", "getVideos", "()Ljava/util/ArrayList;", "getVoteAverage", "getVoteCount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/ArrayList;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Docs;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Docs {
        private final Boolean available;
        private final String cast;
        private final String conversionDate;
        private final String createdAt;
        private final String director;

        /* renamed from: id */
        private final Integer f9982id;
        private final String name;
        private final String originalLanguage;
        private final String overview;
        private final Double popularity;
        private final String posterUrl;
        private final String releaseDate;
        private final Integer runtime;
        private final String status;
        private final String updatedAt;
        private final ArrayList<String> videos;
        private final Double voteAverage;
        private final Integer voteCount;

        public Docs() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
        }

        public final String component1() {
            return this.name;
        }

        public final String component10() {
            return this.overview;
        }

        public final String component11() {
            return this.posterUrl;
        }

        public final String component12() {
            return this.releaseDate;
        }

        public final String component13() {
            return this.createdAt;
        }

        public final String component14() {
            return this.updatedAt;
        }

        public final String component15() {
            return this.conversionDate;
        }

        public final Integer component16() {
            return this.f9982id;
        }

        public final Boolean component17() {
            return this.available;
        }

        public final ArrayList<String> component18() {
            return this.videos;
        }

        public final String component2() {
            return this.originalLanguage;
        }

        public final Double component3() {
            return this.popularity;
        }

        public final Integer component4() {
            return this.runtime;
        }

        public final String component5() {
            return this.status;
        }

        public final Double component6() {
            return this.voteAverage;
        }

        public final Integer component7() {
            return this.voteCount;
        }

        public final String component8() {
            return this.cast;
        }

        public final String component9() {
            return this.director;
        }

        public final Docs copy(@JsonProperty("name") String name, @JsonProperty("originalLanguage") String str, @JsonProperty("popularity") Double d, @JsonProperty("runtime") Integer num, @JsonProperty("status") String str2, @JsonProperty("voteAverage") Double d2, @JsonProperty("voteCount") Integer num2, @JsonProperty("cast") String str3, @JsonProperty("director") String str4, @JsonProperty("overview") String str5, @JsonProperty("posterUrl") String str6, @JsonProperty("releaseDate") String str7, @JsonProperty("createdAt") String str8, @JsonProperty("updatedAt") String str9, @JsonProperty("conversionDate") String str10, @JsonProperty("id") Integer num3, @JsonProperty("available") Boolean bool, @JsonProperty("videos") ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Docs(name, str, d, num, str2, d2, num2, str3, str4, str5, str6, str7, str8, str9, str10, num3, bool, arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Docs) {
                Docs docs = (Docs) obj;
                return Intrinsics.areEqual(this.name, docs.name) && Intrinsics.areEqual(this.originalLanguage, docs.originalLanguage) && Intrinsics.areEqual((Object) this.popularity, (Object) docs.popularity) && Intrinsics.areEqual(this.runtime, docs.runtime) && Intrinsics.areEqual(this.status, docs.status) && Intrinsics.areEqual((Object) this.voteAverage, (Object) docs.voteAverage) && Intrinsics.areEqual(this.voteCount, docs.voteCount) && Intrinsics.areEqual(this.cast, docs.cast) && Intrinsics.areEqual(this.director, docs.director) && Intrinsics.areEqual(this.overview, docs.overview) && Intrinsics.areEqual(this.posterUrl, docs.posterUrl) && Intrinsics.areEqual(this.releaseDate, docs.releaseDate) && Intrinsics.areEqual(this.createdAt, docs.createdAt) && Intrinsics.areEqual(this.updatedAt, docs.updatedAt) && Intrinsics.areEqual(this.conversionDate, docs.conversionDate) && Intrinsics.areEqual(this.f9982id, docs.f9982id) && Intrinsics.areEqual(this.available, docs.available) && Intrinsics.areEqual(this.videos, docs.videos);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.name.hashCode() * 31;
            String str = this.originalLanguage;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Double d = this.popularity;
            int hashCode3 = (hashCode2 + (d == null ? 0 : d.hashCode())) * 31;
            Integer num = this.runtime;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.status;
            int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Double d2 = this.voteAverage;
            int hashCode6 = (hashCode5 + (d2 == null ? 0 : d2.hashCode())) * 31;
            Integer num2 = this.voteCount;
            int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str3 = this.cast;
            int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.director;
            int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.overview;
            int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.posterUrl;
            int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.releaseDate;
            int hashCode12 = (hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.createdAt;
            int hashCode13 = (hashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.updatedAt;
            int hashCode14 = (hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.conversionDate;
            int hashCode15 = (hashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
            Integer num3 = this.f9982id;
            int hashCode16 = (hashCode15 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Boolean bool = this.available;
            int hashCode17 = (hashCode16 + (bool == null ? 0 : bool.hashCode())) * 31;
            ArrayList<String> arrayList = this.videos;
            return hashCode17 + (arrayList != null ? arrayList.hashCode() : 0);
        }

        public String toString() {
            return "Docs(name=" + this.name + ", originalLanguage=" + this.originalLanguage + ", popularity=" + this.popularity + ", runtime=" + this.runtime + ", status=" + this.status + ", voteAverage=" + this.voteAverage + ", voteCount=" + this.voteCount + ", cast=" + this.cast + ", director=" + this.director + ", overview=" + this.overview + ", posterUrl=" + this.posterUrl + ", releaseDate=" + this.releaseDate + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", conversionDate=" + this.conversionDate + ", id=" + this.f9982id + ", available=" + this.available + ", videos=" + this.videos + ')';
        }

        public Docs(@JsonProperty("name") String name, @JsonProperty("originalLanguage") String str, @JsonProperty("popularity") Double d, @JsonProperty("runtime") Integer num, @JsonProperty("status") String str2, @JsonProperty("voteAverage") Double d2, @JsonProperty("voteCount") Integer num2, @JsonProperty("cast") String str3, @JsonProperty("director") String str4, @JsonProperty("overview") String str5, @JsonProperty("posterUrl") String str6, @JsonProperty("releaseDate") String str7, @JsonProperty("createdAt") String str8, @JsonProperty("updatedAt") String str9, @JsonProperty("conversionDate") String str10, @JsonProperty("id") Integer num3, @JsonProperty("available") Boolean bool, @JsonProperty("videos") ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.originalLanguage = str;
            this.popularity = d;
            this.runtime = num;
            this.status = str2;
            this.voteAverage = d2;
            this.voteCount = num2;
            this.cast = str3;
            this.director = str4;
            this.overview = str5;
            this.posterUrl = str6;
            this.releaseDate = str7;
            this.createdAt = str8;
            this.updatedAt = str9;
            this.conversionDate = str10;
            this.f9982id = num3;
            this.available = bool;
            this.videos = arrayList;
        }

        public /* synthetic */ Docs(String str, String str2, Double d, Integer num, String str3, Double d2, Integer num2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num3, Boolean bool, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new String() : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : d2, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : num3, (i & 65536) != 0 ? null : bool, (i & 131072) != 0 ? new ArrayList() : arrayList);
        }

        public final String getName() {
            return this.name;
        }

        public final String getOriginalLanguage() {
            return this.originalLanguage;
        }

        public final Double getPopularity() {
            return this.popularity;
        }

        public final Integer getRuntime() {
            return this.runtime;
        }

        public final String getStatus() {
            return this.status;
        }

        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        public final Integer getVoteCount() {
            return this.voteCount;
        }

        public final String getCast() {
            return this.cast;
        }

        public final String getDirector() {
            return this.director;
        }

        public final String getOverview() {
            return this.overview;
        }

        public final String getPosterUrl() {
            return this.posterUrl;
        }

        public final String getReleaseDate() {
            return this.releaseDate;
        }

        public final String getCreatedAt() {
            return this.createdAt;
        }

        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        public final String getConversionDate() {
            return this.conversionDate;
        }

        public final Integer getId() {
            return this.f9982id;
        }

        public final Boolean getAvailable() {
            return this.available;
        }

        public final ArrayList<String> getVideos() {
            return this.videos;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getCookies(kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> r25) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.TheFlixToProvider.getCookies(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0273  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r31) {
        /*
            Method dump skipped, instructions count: 633
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.TheFlixToProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchJson;", "", "props", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchProps;", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchProps;)V", "getProps", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchProps;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SearchJson {
        private final SearchProps props;

        public SearchJson() {
            this(null, 1, null);
        }

        public static /* synthetic */ SearchJson copy$default(SearchJson searchJson, SearchProps searchProps, int i, Object obj) {
            if ((i & 1) != 0) {
                searchProps = searchJson.props;
            }
            return searchJson.copy(searchProps);
        }

        public final SearchProps component1() {
            return this.props;
        }

        public final SearchJson copy(@JsonProperty("props") SearchProps props) {
            Intrinsics.checkNotNullParameter(props, "props");
            return new SearchJson(props);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SearchJson) && Intrinsics.areEqual(this.props, ((SearchJson) obj).props);
        }

        public int hashCode() {
            return this.props.hashCode();
        }

        public String toString() {
            return "SearchJson(props=" + this.props + ')';
        }

        public SearchJson(@JsonProperty("props") SearchProps props) {
            Intrinsics.checkNotNullParameter(props, "props");
            this.props = props;
        }

        public /* synthetic */ SearchJson(SearchProps searchProps, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new SearchProps(null, 1, null) : searchProps);
        }

        public final SearchProps getProps() {
            return this.props;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchProps;", "", "pageProps", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchPageProps;", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchPageProps;)V", "getPageProps", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchPageProps;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SearchProps {
        private final SearchPageProps pageProps;

        public SearchProps() {
            this(null, 1, null);
        }

        public static /* synthetic */ SearchProps copy$default(SearchProps searchProps, SearchPageProps searchPageProps, int i, Object obj) {
            if ((i & 1) != 0) {
                searchPageProps = searchProps.pageProps;
            }
            return searchProps.copy(searchPageProps);
        }

        public final SearchPageProps component1() {
            return this.pageProps;
        }

        public final SearchProps copy(@JsonProperty("pageProps") SearchPageProps pageProps) {
            Intrinsics.checkNotNullParameter(pageProps, "pageProps");
            return new SearchProps(pageProps);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SearchProps) && Intrinsics.areEqual(this.pageProps, ((SearchProps) obj).pageProps);
        }

        public int hashCode() {
            return this.pageProps.hashCode();
        }

        public String toString() {
            return "SearchProps(pageProps=" + this.pageProps + ')';
        }

        public SearchProps(@JsonProperty("pageProps") SearchPageProps pageProps) {
            Intrinsics.checkNotNullParameter(pageProps, "pageProps");
            this.pageProps = pageProps;
        }

        public /* synthetic */ SearchProps(SearchPageProps searchPageProps, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new SearchPageProps(null, 1, null) : searchPageProps);
        }

        public final SearchPageProps getPageProps() {
            return this.pageProps;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchPageProps;", "", "mainList", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchMainList;", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchMainList;)V", "getMainList", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchMainList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SearchPageProps {
        private final SearchMainList mainList;

        public SearchPageProps() {
            this(null, 1, null);
        }

        public static /* synthetic */ SearchPageProps copy$default(SearchPageProps searchPageProps, SearchMainList searchMainList, int i, Object obj) {
            if ((i & 1) != 0) {
                searchMainList = searchPageProps.mainList;
            }
            return searchPageProps.copy(searchMainList);
        }

        public final SearchMainList component1() {
            return this.mainList;
        }

        public final SearchPageProps copy(@JsonProperty("mainList") SearchMainList mainList) {
            Intrinsics.checkNotNullParameter(mainList, "mainList");
            return new SearchPageProps(mainList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SearchPageProps) && Intrinsics.areEqual(this.mainList, ((SearchPageProps) obj).mainList);
        }

        public int hashCode() {
            return this.mainList.hashCode();
        }

        public String toString() {
            return "SearchPageProps(mainList=" + this.mainList + ')';
        }

        public SearchPageProps(@JsonProperty("mainList") SearchMainList mainList) {
            Intrinsics.checkNotNullParameter(mainList, "mainList");
            this.mainList = mainList;
        }

        public /* synthetic */ SearchPageProps(SearchMainList searchMainList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new SearchMainList(null, null, null, null, null, null, 63, null) : searchMainList);
        }

        public final SearchMainList getMainList() {
            return this.mainList;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003Jd\u0010\u001e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchMainList;", "", "docs", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Docs;", "Lkotlin/collections/ArrayList;", "total", "", "page", "limit", "pages", "type", "", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getDocs", "()Ljava/util/ArrayList;", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPage", "getPages", "getTotal", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$SearchMainList;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SearchMainList {
        private final ArrayList<Docs> docs;
        private final Integer limit;
        private final Integer page;
        private final Integer pages;
        private final Integer total;
        private final String type;

        public SearchMainList() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ SearchMainList copy$default(SearchMainList searchMainList, ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, Object obj) {
            ArrayList<Docs> arrayList2 = arrayList;
            if ((i & 1) != 0) {
                arrayList2 = searchMainList.docs;
            }
            if ((i & 2) != 0) {
                num = searchMainList.total;
            }
            Integer num5 = num;
            if ((i & 4) != 0) {
                num2 = searchMainList.page;
            }
            Integer num6 = num2;
            if ((i & 8) != 0) {
                num3 = searchMainList.limit;
            }
            Integer num7 = num3;
            if ((i & 16) != 0) {
                num4 = searchMainList.pages;
            }
            Integer num8 = num4;
            if ((i & 32) != 0) {
                str = searchMainList.type;
            }
            return searchMainList.copy(arrayList2, num5, num6, num7, num8, str);
        }

        public final ArrayList<Docs> component1() {
            return this.docs;
        }

        public final Integer component2() {
            return this.total;
        }

        public final Integer component3() {
            return this.page;
        }

        public final Integer component4() {
            return this.limit;
        }

        public final Integer component5() {
            return this.pages;
        }

        public final String component6() {
            return this.type;
        }

        public final SearchMainList copy(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            return new SearchMainList(docs, num, num2, num3, num4, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SearchMainList) {
                SearchMainList searchMainList = (SearchMainList) obj;
                return Intrinsics.areEqual(this.docs, searchMainList.docs) && Intrinsics.areEqual(this.total, searchMainList.total) && Intrinsics.areEqual(this.page, searchMainList.page) && Intrinsics.areEqual(this.limit, searchMainList.limit) && Intrinsics.areEqual(this.pages, searchMainList.pages) && Intrinsics.areEqual(this.type, searchMainList.type);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.docs.hashCode() * 31;
            Integer num = this.total;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.page;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.limit;
            int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.pages;
            int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
            String str = this.type;
            return hashCode5 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "SearchMainList(docs=" + this.docs + ", total=" + this.total + ", page=" + this.page + ", limit=" + this.limit + ", pages=" + this.pages + ", type=" + this.type + ')';
        }

        public SearchMainList(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            this.docs = docs;
            this.total = num;
            this.page = num2;
            this.limit = num3;
            this.pages = num4;
            this.type = str;
        }

        public /* synthetic */ SearchMainList(ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) == 0 ? str : null);
        }

        public final ArrayList<Docs> getDocs() {
            return this.docs;
        }

        public final Integer getTotal() {
            return this.total;
        }

        public final Integer getPage() {
            return this.page;
        }

        public final Integer getLimit() {
            return this.limit;
        }

        public final Integer getPages() {
            return this.pages;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object search(String str, Continuation<? super List<? extends SearchResponse>> continuation) {
        ArrayList arrayList = new ArrayList();
        ParCollections.apmap(CollectionsKt.listOf((Object[]) new String[]{getMainUrl() + "/movies/trending?search=" + str, getMainUrl() + "/tv-shows/trending?search=" + str}), new TheFlixToProvider$search$2(this, arrayList, null));
        return arrayList;
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0010Jn\u0010#\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\t\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadMain;", "", "props", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadProps;", "page", "", "buildId", "runtimeConfig", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfig;", "isFallback", "", "gssp", "customServer", "appGip", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadProps;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfig;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAppGip", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBuildId", "()Ljava/lang/String;", "getCustomServer", "getGssp", "getPage", "getProps", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadProps;", "getRuntimeConfig", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadProps;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfig;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadMain;", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LoadMain {
        private final Boolean appGip;
        private final String buildId;
        private final Boolean customServer;
        private final Boolean gssp;
        private final Boolean isFallback;
        private final String page;
        private final LoadProps props;
        private final RuntimeConfig runtimeConfig;

        public LoadMain() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public final LoadProps component1() {
            return this.props;
        }

        public final String component2() {
            return this.page;
        }

        public final String component3() {
            return this.buildId;
        }

        public final RuntimeConfig component4() {
            return this.runtimeConfig;
        }

        public final Boolean component5() {
            return this.isFallback;
        }

        public final Boolean component6() {
            return this.gssp;
        }

        public final Boolean component7() {
            return this.customServer;
        }

        public final Boolean component8() {
            return this.appGip;
        }

        public final LoadMain copy(@JsonProperty("props") LoadProps loadProps, @JsonProperty("page") String str, @JsonProperty("buildId") String str2, @JsonProperty("runtimeConfig") RuntimeConfig runtimeConfig, @JsonProperty("isFallback") Boolean bool, @JsonProperty("gssp") Boolean bool2, @JsonProperty("customServer") Boolean bool3, @JsonProperty("appGip") Boolean bool4) {
            return new LoadMain(loadProps, str, str2, runtimeConfig, bool, bool2, bool3, bool4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadMain) {
                LoadMain loadMain = (LoadMain) obj;
                return Intrinsics.areEqual(this.props, loadMain.props) && Intrinsics.areEqual(this.page, loadMain.page) && Intrinsics.areEqual(this.buildId, loadMain.buildId) && Intrinsics.areEqual(this.runtimeConfig, loadMain.runtimeConfig) && Intrinsics.areEqual(this.isFallback, loadMain.isFallback) && Intrinsics.areEqual(this.gssp, loadMain.gssp) && Intrinsics.areEqual(this.customServer, loadMain.customServer) && Intrinsics.areEqual(this.appGip, loadMain.appGip);
            }
            return false;
        }

        public int hashCode() {
            LoadProps loadProps = this.props;
            int hashCode = (loadProps == null ? 0 : loadProps.hashCode()) * 31;
            String str = this.page;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.buildId;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            RuntimeConfig runtimeConfig = this.runtimeConfig;
            int hashCode4 = (hashCode3 + (runtimeConfig == null ? 0 : runtimeConfig.hashCode())) * 31;
            Boolean bool = this.isFallback;
            int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.gssp;
            int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.customServer;
            int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.appGip;
            return hashCode7 + (bool4 != null ? bool4.hashCode() : 0);
        }

        public String toString() {
            return "LoadMain(props=" + this.props + ", page=" + this.page + ", buildId=" + this.buildId + ", runtimeConfig=" + this.runtimeConfig + ", isFallback=" + this.isFallback + ", gssp=" + this.gssp + ", customServer=" + this.customServer + ", appGip=" + this.appGip + ')';
        }

        public LoadMain(@JsonProperty("props") LoadProps loadProps, @JsonProperty("page") String str, @JsonProperty("buildId") String str2, @JsonProperty("runtimeConfig") RuntimeConfig runtimeConfig, @JsonProperty("isFallback") Boolean bool, @JsonProperty("gssp") Boolean bool2, @JsonProperty("customServer") Boolean bool3, @JsonProperty("appGip") Boolean bool4) {
            this.props = loadProps;
            this.page = str;
            this.buildId = str2;
            this.runtimeConfig = runtimeConfig;
            this.isFallback = bool;
            this.gssp = bool2;
            this.customServer = bool3;
            this.appGip = bool4;
        }

        public /* synthetic */ LoadMain(LoadProps loadProps, String str, String str2, RuntimeConfig runtimeConfig, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new LoadProps(null, null, 3, null) : loadProps, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? new RuntimeConfig(null, null, null, null, 15, null) : runtimeConfig, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : bool3, (i & 128) == 0 ? bool4 : null);
        }

        public final LoadProps getProps() {
            return this.props;
        }

        public final String getPage() {
            return this.page;
        }

        public final String getBuildId() {
            return this.buildId;
        }

        public final RuntimeConfig getRuntimeConfig() {
            return this.runtimeConfig;
        }

        public final Boolean isFallback() {
            return this.isFallback;
        }

        public final Boolean getGssp() {
            return this.gssp;
        }

        public final Boolean getCustomServer() {
            return this.customServer;
        }

        public final Boolean getAppGip() {
            return this.appGip;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadProps;", "", "pageProps", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadPageProps;", "_NSSP", "", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadPageProps;Ljava/lang/Boolean;)V", "get_NSSP", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPageProps", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadPageProps;", "component1", "component2", "copy", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadPageProps;Ljava/lang/Boolean;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadProps;", "equals", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LoadProps {
        private final Boolean _NSSP;
        private final LoadPageProps pageProps;

        public LoadProps() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ LoadProps copy$default(LoadProps loadProps, LoadPageProps loadPageProps, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                loadPageProps = loadProps.pageProps;
            }
            if ((i & 2) != 0) {
                bool = loadProps._NSSP;
            }
            return loadProps.copy(loadPageProps, bool);
        }

        public final LoadPageProps component1() {
            return this.pageProps;
        }

        public final Boolean component2() {
            return this._NSSP;
        }

        public final LoadProps copy(@JsonProperty("pageProps") LoadPageProps loadPageProps, @JsonProperty("__N_SSP") Boolean bool) {
            return new LoadProps(loadPageProps, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadProps) {
                LoadProps loadProps = (LoadProps) obj;
                return Intrinsics.areEqual(this.pageProps, loadProps.pageProps) && Intrinsics.areEqual(this._NSSP, loadProps._NSSP);
            }
            return false;
        }

        public int hashCode() {
            LoadPageProps loadPageProps = this.pageProps;
            int hashCode = (loadPageProps == null ? 0 : loadPageProps.hashCode()) * 31;
            Boolean bool = this._NSSP;
            return hashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "LoadProps(pageProps=" + this.pageProps + ", _NSSP=" + this._NSSP + ')';
        }

        public LoadProps(@JsonProperty("pageProps") LoadPageProps loadPageProps, @JsonProperty("__N_SSP") Boolean bool) {
            this.pageProps = loadPageProps;
            this._NSSP = bool;
        }

        public /* synthetic */ LoadProps(LoadPageProps loadPageProps, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new LoadPageProps(null, null, null, null, 15, null) : loadPageProps, (i & 2) != 0 ? null : bool);
        }

        public final LoadPageProps getPageProps() {
            return this.pageProps;
        }

        public final Boolean get_NSSP() {
            return this._NSSP;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u001c\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001d\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0003JK\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u001c\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$LoadPageProps;", "", "selectedTv", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TheFlixMetadata;", "movie", "recommendationsList", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RecommendationsList;", "basePageSegments", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TheFlixMetadata;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TheFlixMetadata;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RecommendationsList;Ljava/util/ArrayList;)V", "getBasePageSegments", "()Ljava/util/ArrayList;", "getMovie", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TheFlixMetadata;", "getRecommendationsList", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RecommendationsList;", "getSelectedTv", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LoadPageProps {
        private final ArrayList<String> basePageSegments;
        private final TheFlixMetadata movie;
        private final RecommendationsList recommendationsList;
        private final TheFlixMetadata selectedTv;

        public LoadPageProps() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LoadPageProps copy$default(LoadPageProps loadPageProps, TheFlixMetadata theFlixMetadata, TheFlixMetadata theFlixMetadata2, RecommendationsList recommendationsList, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                theFlixMetadata = loadPageProps.selectedTv;
            }
            if ((i & 2) != 0) {
                theFlixMetadata2 = loadPageProps.movie;
            }
            if ((i & 4) != 0) {
                recommendationsList = loadPageProps.recommendationsList;
            }
            if ((i & 8) != 0) {
                arrayList = loadPageProps.basePageSegments;
            }
            return loadPageProps.copy(theFlixMetadata, theFlixMetadata2, recommendationsList, arrayList);
        }

        public final TheFlixMetadata component1() {
            return this.selectedTv;
        }

        public final TheFlixMetadata component2() {
            return this.movie;
        }

        public final RecommendationsList component3() {
            return this.recommendationsList;
        }

        public final ArrayList<String> component4() {
            return this.basePageSegments;
        }

        public final LoadPageProps copy(@JsonProperty("selectedTv") TheFlixMetadata theFlixMetadata, @JsonProperty("movie") TheFlixMetadata theFlixMetadata2, @JsonProperty("recommendationsList") RecommendationsList recommendationsList, @JsonProperty("basePageSegments") ArrayList<String> arrayList) {
            return new LoadPageProps(theFlixMetadata, theFlixMetadata2, recommendationsList, arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadPageProps) {
                LoadPageProps loadPageProps = (LoadPageProps) obj;
                return Intrinsics.areEqual(this.selectedTv, loadPageProps.selectedTv) && Intrinsics.areEqual(this.movie, loadPageProps.movie) && Intrinsics.areEqual(this.recommendationsList, loadPageProps.recommendationsList) && Intrinsics.areEqual(this.basePageSegments, loadPageProps.basePageSegments);
            }
            return false;
        }

        public int hashCode() {
            TheFlixMetadata theFlixMetadata = this.selectedTv;
            int hashCode = (theFlixMetadata == null ? 0 : theFlixMetadata.hashCode()) * 31;
            TheFlixMetadata theFlixMetadata2 = this.movie;
            int hashCode2 = (hashCode + (theFlixMetadata2 == null ? 0 : theFlixMetadata2.hashCode())) * 31;
            RecommendationsList recommendationsList = this.recommendationsList;
            int hashCode3 = (hashCode2 + (recommendationsList == null ? 0 : recommendationsList.hashCode())) * 31;
            ArrayList<String> arrayList = this.basePageSegments;
            return hashCode3 + (arrayList != null ? arrayList.hashCode() : 0);
        }

        public String toString() {
            return "LoadPageProps(selectedTv=" + this.selectedTv + ", movie=" + this.movie + ", recommendationsList=" + this.recommendationsList + ", basePageSegments=" + this.basePageSegments + ')';
        }

        public LoadPageProps(@JsonProperty("selectedTv") TheFlixMetadata theFlixMetadata, @JsonProperty("movie") TheFlixMetadata theFlixMetadata2, @JsonProperty("recommendationsList") RecommendationsList recommendationsList, @JsonProperty("basePageSegments") ArrayList<String> arrayList) {
            this.selectedTv = theFlixMetadata;
            this.movie = theFlixMetadata2;
            this.recommendationsList = recommendationsList;
            this.basePageSegments = arrayList;
        }

        public /* synthetic */ LoadPageProps(TheFlixMetadata theFlixMetadata, TheFlixMetadata theFlixMetadata2, RecommendationsList recommendationsList, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            LoadPageProps loadPageProps;
            ArrayList arrayList2;
            TheFlixMetadata theFlixMetadata3 = (i & 1) != 0 ? new TheFlixMetadata(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null) : theFlixMetadata;
            TheFlixMetadata theFlixMetadata4 = (i & 2) != 0 ? new TheFlixMetadata(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null) : theFlixMetadata2;
            RecommendationsList recommendationsList2 = (i & 4) != 0 ? new RecommendationsList(null, null, null, null, null, null, 63, null) : recommendationsList;
            if ((i & 8) != 0) {
                arrayList2 = new ArrayList();
                loadPageProps = this;
            } else {
                loadPageProps = this;
                arrayList2 = arrayList;
            }
            new LoadPageProps(theFlixMetadata3, theFlixMetadata4, recommendationsList2, arrayList2);
        }

        public final TheFlixMetadata getSelectedTv() {
            return this.selectedTv;
        }

        public final TheFlixMetadata getMovie() {
            return this.movie;
        }

        public final RecommendationsList getRecommendationsList() {
            return this.recommendationsList;
        }

        public final ArrayList<String> getBasePageSegments() {
            return this.basePageSegments;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b>\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u001c\b\u0003\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b\u0012\u001c\b\u0003\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001b\u0012\u001c\b\u0003\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001b\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010 J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010H\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010\"J\u001d\u0010I\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001bHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010K\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001bHÆ\u0003J\u001d\u0010L\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001bHÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)JÌ\u0002\u0010U\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\b\u0003\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\u001c\b\u0003\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001b2\u001c\b\u0003\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001b2\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\u00172\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020\u0003HÖ\u0001J\t\u0010Z\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R%\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010*\u001a\u0004\b-\u0010)R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010*\u001a\u0004\b/\u0010)R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010*\u001a\u0004\b0\u0010)R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010*\u001a\u0004\b8\u0010)R%\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R%\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010,R\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00105\u001a\u0004\b=\u00104R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010*\u001a\u0004\b>\u0010)¨\u0006["}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TheFlixMetadata;", "", "episodeRuntime", "", "name", "", "numberOfSeasons", "numberOfEpisodes", "originalLanguage", "popularity", "", "status", "voteAverage", "voteCount", "cast", "director", "overview", "posterUrl", "releaseDate", "createdAt", "updatedAt", "id", "available", "", "genres", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Genres;", "Lkotlin/collections/ArrayList;", "seasons", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Seasons;", "videos", "runtime", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Integer;)V", "getAvailable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCast", "()Ljava/lang/String;", "getCreatedAt", "getDirector", "getEpisodeRuntime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGenres", "()Ljava/util/ArrayList;", "getId", "getName", "getNumberOfEpisodes", "getNumberOfSeasons", "getOriginalLanguage", "getOverview", "getPopularity", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPosterUrl", "getReleaseDate", "getRuntime", "getSeasons", "getStatus", "getUpdatedAt", "getVideos", "getVoteAverage", "getVoteCount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TheFlixMetadata;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class TheFlixMetadata {
        private final Boolean available;
        private final String cast;
        private final String createdAt;
        private final String director;
        private final Integer episodeRuntime;
        private final ArrayList<Genres> genres;

        /* renamed from: id */
        private final Integer f9986id;
        private final String name;
        private final Integer numberOfEpisodes;
        private final Integer numberOfSeasons;
        private final String originalLanguage;
        private final String overview;
        private final Double popularity;
        private final String posterUrl;
        private final String releaseDate;
        private final Integer runtime;
        private final ArrayList<Seasons> seasons;
        private final String status;
        private final String updatedAt;
        private final ArrayList<String> videos;
        private final Double voteAverage;
        private final Integer voteCount;

        public TheFlixMetadata() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        }

        public final Integer component1() {
            return this.episodeRuntime;
        }

        public final String component10() {
            return this.cast;
        }

        public final String component11() {
            return this.director;
        }

        public final String component12() {
            return this.overview;
        }

        public final String component13() {
            return this.posterUrl;
        }

        public final String component14() {
            return this.releaseDate;
        }

        public final String component15() {
            return this.createdAt;
        }

        public final String component16() {
            return this.updatedAt;
        }

        public final Integer component17() {
            return this.f9986id;
        }

        public final Boolean component18() {
            return this.available;
        }

        public final ArrayList<Genres> component19() {
            return this.genres;
        }

        public final String component2() {
            return this.name;
        }

        public final ArrayList<Seasons> component20() {
            return this.seasons;
        }

        public final ArrayList<String> component21() {
            return this.videos;
        }

        public final Integer component22() {
            return this.runtime;
        }

        public final Integer component3() {
            return this.numberOfSeasons;
        }

        public final Integer component4() {
            return this.numberOfEpisodes;
        }

        public final String component5() {
            return this.originalLanguage;
        }

        public final Double component6() {
            return this.popularity;
        }

        public final String component7() {
            return this.status;
        }

        public final Double component8() {
            return this.voteAverage;
        }

        public final Integer component9() {
            return this.voteCount;
        }

        public final TheFlixMetadata copy(@JsonProperty("episodeRuntime") Integer num, @JsonProperty("name") String str, @JsonProperty("numberOfSeasons") Integer num2, @JsonProperty("numberOfEpisodes") Integer num3, @JsonProperty("originalLanguage") String str2, @JsonProperty("popularity") Double d, @JsonProperty("status") String str3, @JsonProperty("voteAverage") Double d2, @JsonProperty("voteCount") Integer num4, @JsonProperty("cast") String str4, @JsonProperty("director") String str5, @JsonProperty("overview") String str6, @JsonProperty("posterUrl") String str7, @JsonProperty("releaseDate") String str8, @JsonProperty("createdAt") String str9, @JsonProperty("updatedAt") String str10, @JsonProperty("id") Integer num5, @JsonProperty("available") Boolean bool, @JsonProperty("genres") ArrayList<Genres> arrayList, @JsonProperty("seasons") ArrayList<Seasons> arrayList2, @JsonProperty("videos") ArrayList<String> arrayList3, @JsonProperty("runtime") Integer num6) {
            return new TheFlixMetadata(num, str, num2, num3, str2, d, str3, d2, num4, str4, str5, str6, str7, str8, str9, str10, num5, bool, arrayList, arrayList2, arrayList3, num6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TheFlixMetadata) {
                TheFlixMetadata theFlixMetadata = (TheFlixMetadata) obj;
                return Intrinsics.areEqual(this.episodeRuntime, theFlixMetadata.episodeRuntime) && Intrinsics.areEqual(this.name, theFlixMetadata.name) && Intrinsics.areEqual(this.numberOfSeasons, theFlixMetadata.numberOfSeasons) && Intrinsics.areEqual(this.numberOfEpisodes, theFlixMetadata.numberOfEpisodes) && Intrinsics.areEqual(this.originalLanguage, theFlixMetadata.originalLanguage) && Intrinsics.areEqual((Object) this.popularity, (Object) theFlixMetadata.popularity) && Intrinsics.areEqual(this.status, theFlixMetadata.status) && Intrinsics.areEqual((Object) this.voteAverage, (Object) theFlixMetadata.voteAverage) && Intrinsics.areEqual(this.voteCount, theFlixMetadata.voteCount) && Intrinsics.areEqual(this.cast, theFlixMetadata.cast) && Intrinsics.areEqual(this.director, theFlixMetadata.director) && Intrinsics.areEqual(this.overview, theFlixMetadata.overview) && Intrinsics.areEqual(this.posterUrl, theFlixMetadata.posterUrl) && Intrinsics.areEqual(this.releaseDate, theFlixMetadata.releaseDate) && Intrinsics.areEqual(this.createdAt, theFlixMetadata.createdAt) && Intrinsics.areEqual(this.updatedAt, theFlixMetadata.updatedAt) && Intrinsics.areEqual(this.f9986id, theFlixMetadata.f9986id) && Intrinsics.areEqual(this.available, theFlixMetadata.available) && Intrinsics.areEqual(this.genres, theFlixMetadata.genres) && Intrinsics.areEqual(this.seasons, theFlixMetadata.seasons) && Intrinsics.areEqual(this.videos, theFlixMetadata.videos) && Intrinsics.areEqual(this.runtime, theFlixMetadata.runtime);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.episodeRuntime;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.name;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num2 = this.numberOfSeasons;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.numberOfEpisodes;
            int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str2 = this.originalLanguage;
            int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Double d = this.popularity;
            int hashCode6 = (hashCode5 + (d == null ? 0 : d.hashCode())) * 31;
            String str3 = this.status;
            int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Double d2 = this.voteAverage;
            int hashCode8 = (hashCode7 + (d2 == null ? 0 : d2.hashCode())) * 31;
            Integer num4 = this.voteCount;
            int hashCode9 = (hashCode8 + (num4 == null ? 0 : num4.hashCode())) * 31;
            String str4 = this.cast;
            int hashCode10 = (hashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.director;
            int hashCode11 = (hashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.overview;
            int hashCode12 = (hashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.posterUrl;
            int hashCode13 = (hashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.releaseDate;
            int hashCode14 = (hashCode13 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.createdAt;
            int hashCode15 = (hashCode14 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.updatedAt;
            int hashCode16 = (hashCode15 + (str10 == null ? 0 : str10.hashCode())) * 31;
            Integer num5 = this.f9986id;
            int hashCode17 = (hashCode16 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Boolean bool = this.available;
            int hashCode18 = (hashCode17 + (bool == null ? 0 : bool.hashCode())) * 31;
            ArrayList<Genres> arrayList = this.genres;
            int hashCode19 = (hashCode18 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
            ArrayList<Seasons> arrayList2 = this.seasons;
            int hashCode20 = (hashCode19 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
            ArrayList<String> arrayList3 = this.videos;
            int hashCode21 = (hashCode20 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
            Integer num6 = this.runtime;
            return hashCode21 + (num6 != null ? num6.hashCode() : 0);
        }

        public String toString() {
            return "TheFlixMetadata(episodeRuntime=" + this.episodeRuntime + ", name=" + this.name + ", numberOfSeasons=" + this.numberOfSeasons + ", numberOfEpisodes=" + this.numberOfEpisodes + ", originalLanguage=" + this.originalLanguage + ", popularity=" + this.popularity + ", status=" + this.status + ", voteAverage=" + this.voteAverage + ", voteCount=" + this.voteCount + ", cast=" + this.cast + ", director=" + this.director + ", overview=" + this.overview + ", posterUrl=" + this.posterUrl + ", releaseDate=" + this.releaseDate + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", id=" + this.f9986id + ", available=" + this.available + ", genres=" + this.genres + ", seasons=" + this.seasons + ", videos=" + this.videos + ", runtime=" + this.runtime + ')';
        }

        public TheFlixMetadata(@JsonProperty("episodeRuntime") Integer num, @JsonProperty("name") String str, @JsonProperty("numberOfSeasons") Integer num2, @JsonProperty("numberOfEpisodes") Integer num3, @JsonProperty("originalLanguage") String str2, @JsonProperty("popularity") Double d, @JsonProperty("status") String str3, @JsonProperty("voteAverage") Double d2, @JsonProperty("voteCount") Integer num4, @JsonProperty("cast") String str4, @JsonProperty("director") String str5, @JsonProperty("overview") String str6, @JsonProperty("posterUrl") String str7, @JsonProperty("releaseDate") String str8, @JsonProperty("createdAt") String str9, @JsonProperty("updatedAt") String str10, @JsonProperty("id") Integer num5, @JsonProperty("available") Boolean bool, @JsonProperty("genres") ArrayList<Genres> arrayList, @JsonProperty("seasons") ArrayList<Seasons> arrayList2, @JsonProperty("videos") ArrayList<String> arrayList3, @JsonProperty("runtime") Integer num6) {
            this.episodeRuntime = num;
            this.name = str;
            this.numberOfSeasons = num2;
            this.numberOfEpisodes = num3;
            this.originalLanguage = str2;
            this.popularity = d;
            this.status = str3;
            this.voteAverage = d2;
            this.voteCount = num4;
            this.cast = str4;
            this.director = str5;
            this.overview = str6;
            this.posterUrl = str7;
            this.releaseDate = str8;
            this.createdAt = str9;
            this.updatedAt = str10;
            this.f9986id = num5;
            this.available = bool;
            this.genres = arrayList;
            this.seasons = arrayList2;
            this.videos = arrayList3;
            this.runtime = num6;
        }

        public final Integer getEpisodeRuntime() {
            return this.episodeRuntime;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getNumberOfSeasons() {
            return this.numberOfSeasons;
        }

        public final Integer getNumberOfEpisodes() {
            return this.numberOfEpisodes;
        }

        public final String getOriginalLanguage() {
            return this.originalLanguage;
        }

        public final Double getPopularity() {
            return this.popularity;
        }

        public final String getStatus() {
            return this.status;
        }

        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        public final Integer getVoteCount() {
            return this.voteCount;
        }

        public final String getCast() {
            return this.cast;
        }

        public final String getDirector() {
            return this.director;
        }

        public final String getOverview() {
            return this.overview;
        }

        public final String getPosterUrl() {
            return this.posterUrl;
        }

        public final String getReleaseDate() {
            return this.releaseDate;
        }

        public final String getCreatedAt() {
            return this.createdAt;
        }

        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        public final Integer getId() {
            return this.f9986id;
        }

        public final Boolean getAvailable() {
            return this.available;
        }

        public /* synthetic */ TheFlixMetadata(Integer num, String str, Integer num2, Integer num3, String str2, Double d, String str3, Double d2, Integer num4, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num5, Boolean bool, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Integer num6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : d, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : d2, (i & 256) != 0 ? null : num4, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : str5, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : str9, (i & 32768) != 0 ? null : str10, (i & 65536) != 0 ? null : num5, (i & 131072) != 0 ? null : bool, (i & 262144) != 0 ? new ArrayList() : arrayList, (i & 524288) != 0 ? new ArrayList() : arrayList2, (i & 1048576) != 0 ? new ArrayList() : arrayList3, (i & 2097152) != 0 ? null : num6);
        }

        public final ArrayList<Genres> getGenres() {
            return this.genres;
        }

        public final ArrayList<Seasons> getSeasons() {
            return this.seasons;
        }

        public final ArrayList<String> getVideos() {
            return this.videos;
        }

        public final Integer getRuntime() {
            return this.runtime;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0003\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0098\u0001\u0010*\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\u001c\b\u0003\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R%\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00061"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Seasons;", "", "name", "", "numberOfEpisodes", "", "seasonNumber", "overview", "posterUrl", "releaseDate", "createdAt", "updatedAt", "id", "episodes", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Episodes;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;)V", "getCreatedAt", "()Ljava/lang/String;", "getEpisodes", "()Ljava/util/ArrayList;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getNumberOfEpisodes", "getOverview", "getPosterUrl", "getReleaseDate", "getSeasonNumber", "getUpdatedAt", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Seasons;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Seasons {
        private final String createdAt;
        private final ArrayList<Episodes> episodes;

        /* renamed from: id */
        private final Integer f9985id;
        private final String name;
        private final Integer numberOfEpisodes;
        private final String overview;
        private final String posterUrl;
        private final String releaseDate;
        private final Integer seasonNumber;
        private final String updatedAt;

        public Seasons() {
            this(null, null, null, null, null, null, null, null, null, null, AnalyticsListener.EVENT_DROPPED_VIDEO_FRAMES, null);
        }

        public final String component1() {
            return this.name;
        }

        public final ArrayList<Episodes> component10() {
            return this.episodes;
        }

        public final Integer component2() {
            return this.numberOfEpisodes;
        }

        public final Integer component3() {
            return this.seasonNumber;
        }

        public final String component4() {
            return this.overview;
        }

        public final String component5() {
            return this.posterUrl;
        }

        public final String component6() {
            return this.releaseDate;
        }

        public final String component7() {
            return this.createdAt;
        }

        public final String component8() {
            return this.updatedAt;
        }

        public final Integer component9() {
            return this.f9985id;
        }

        public final Seasons copy(@JsonProperty("name") String str, @JsonProperty("numberOfEpisodes") Integer num, @JsonProperty("seasonNumber") Integer num2, @JsonProperty("overview") String str2, @JsonProperty("posterUrl") String str3, @JsonProperty("releaseDate") String str4, @JsonProperty("createdAt") String str5, @JsonProperty("updatedAt") String str6, @JsonProperty("id") Integer num3, @JsonProperty("episodes") ArrayList<Episodes> arrayList) {
            return new Seasons(str, num, num2, str2, str3, str4, str5, str6, num3, arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Seasons) {
                Seasons seasons = (Seasons) obj;
                return Intrinsics.areEqual(this.name, seasons.name) && Intrinsics.areEqual(this.numberOfEpisodes, seasons.numberOfEpisodes) && Intrinsics.areEqual(this.seasonNumber, seasons.seasonNumber) && Intrinsics.areEqual(this.overview, seasons.overview) && Intrinsics.areEqual(this.posterUrl, seasons.posterUrl) && Intrinsics.areEqual(this.releaseDate, seasons.releaseDate) && Intrinsics.areEqual(this.createdAt, seasons.createdAt) && Intrinsics.areEqual(this.updatedAt, seasons.updatedAt) && Intrinsics.areEqual(this.f9985id, seasons.f9985id) && Intrinsics.areEqual(this.episodes, seasons.episodes);
            }
            return false;
        }

        public int hashCode() {
            String str = this.name;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.numberOfEpisodes;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.seasonNumber;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str2 = this.overview;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.posterUrl;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.releaseDate;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.createdAt;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.updatedAt;
            int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Integer num3 = this.f9985id;
            int hashCode9 = (hashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
            ArrayList<Episodes> arrayList = this.episodes;
            return hashCode9 + (arrayList != null ? arrayList.hashCode() : 0);
        }

        public String toString() {
            return "Seasons(name=" + this.name + ", numberOfEpisodes=" + this.numberOfEpisodes + ", seasonNumber=" + this.seasonNumber + ", overview=" + this.overview + ", posterUrl=" + this.posterUrl + ", releaseDate=" + this.releaseDate + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", id=" + this.f9985id + ", episodes=" + this.episodes + ')';
        }

        public Seasons(@JsonProperty("name") String str, @JsonProperty("numberOfEpisodes") Integer num, @JsonProperty("seasonNumber") Integer num2, @JsonProperty("overview") String str2, @JsonProperty("posterUrl") String str3, @JsonProperty("releaseDate") String str4, @JsonProperty("createdAt") String str5, @JsonProperty("updatedAt") String str6, @JsonProperty("id") Integer num3, @JsonProperty("episodes") ArrayList<Episodes> arrayList) {
            this.name = str;
            this.numberOfEpisodes = num;
            this.seasonNumber = num2;
            this.overview = str2;
            this.posterUrl = str3;
            this.releaseDate = str4;
            this.createdAt = str5;
            this.updatedAt = str6;
            this.f9985id = num3;
            this.episodes = arrayList;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getNumberOfEpisodes() {
            return this.numberOfEpisodes;
        }

        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        public final String getOverview() {
            return this.overview;
        }

        public final String getPosterUrl() {
            return this.posterUrl;
        }

        public final String getReleaseDate() {
            return this.releaseDate;
        }

        public final String getCreatedAt() {
            return this.createdAt;
        }

        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        public final Integer getId() {
            return this.f9985id;
        }

        public /* synthetic */ Seasons(String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, Integer num3, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) == 0 ? num3 : null, (i & 512) != 0 ? new ArrayList() : arrayList);
        }

        public final ArrayList<Episodes> getEpisodes() {
            return this.episodes;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0003\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u001d\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0011HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¤\u0001\u0010/\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u001c\b\u0003\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0011HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R%\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0016¨\u00066"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Episodes;", "", "episodeNumber", "", "name", "", "seasonNumber", "voteAverage", "", "voteCount", "overview", "releaseDate", "createdAt", "updatedAt", "id", "videos", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;)V", "getCreatedAt", "()Ljava/lang/String;", "getEpisodeNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getName", "getOverview", "getReleaseDate", "getSeasonNumber", "getUpdatedAt", "getVideos", "()Ljava/util/ArrayList;", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVoteCount", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Episodes;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Episodes {
        private final String createdAt;
        private final Integer episodeNumber;

        /* renamed from: id */
        private final Integer f9983id;
        private final String name;
        private final String overview;
        private final String releaseDate;
        private final Integer seasonNumber;
        private final String updatedAt;
        private final ArrayList<String> videos;
        private final Double voteAverage;
        private final Integer voteCount;

        public Episodes() {
            this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }

        public final Integer component1() {
            return this.episodeNumber;
        }

        public final Integer component10() {
            return this.f9983id;
        }

        public final ArrayList<String> component11() {
            return this.videos;
        }

        public final String component2() {
            return this.name;
        }

        public final Integer component3() {
            return this.seasonNumber;
        }

        public final Double component4() {
            return this.voteAverage;
        }

        public final Integer component5() {
            return this.voteCount;
        }

        public final String component6() {
            return this.overview;
        }

        public final String component7() {
            return this.releaseDate;
        }

        public final String component8() {
            return this.createdAt;
        }

        public final String component9() {
            return this.updatedAt;
        }

        public final Episodes copy(@JsonProperty("episodeNumber") Integer num, @JsonProperty("name") String str, @JsonProperty("seasonNumber") Integer num2, @JsonProperty("voteAverage") Double d, @JsonProperty("voteCount") Integer num3, @JsonProperty("overview") String str2, @JsonProperty("releaseDate") String str3, @JsonProperty("createdAt") String str4, @JsonProperty("updatedAt") String str5, @JsonProperty("id") Integer num4, @JsonProperty("videos") ArrayList<String> arrayList) {
            return new Episodes(num, str, num2, d, num3, str2, str3, str4, str5, num4, arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Episodes) {
                Episodes episodes = (Episodes) obj;
                return Intrinsics.areEqual(this.episodeNumber, episodes.episodeNumber) && Intrinsics.areEqual(this.name, episodes.name) && Intrinsics.areEqual(this.seasonNumber, episodes.seasonNumber) && Intrinsics.areEqual((Object) this.voteAverage, (Object) episodes.voteAverage) && Intrinsics.areEqual(this.voteCount, episodes.voteCount) && Intrinsics.areEqual(this.overview, episodes.overview) && Intrinsics.areEqual(this.releaseDate, episodes.releaseDate) && Intrinsics.areEqual(this.createdAt, episodes.createdAt) && Intrinsics.areEqual(this.updatedAt, episodes.updatedAt) && Intrinsics.areEqual(this.f9983id, episodes.f9983id) && Intrinsics.areEqual(this.videos, episodes.videos);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.episodeNumber;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.name;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num2 = this.seasonNumber;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Double d = this.voteAverage;
            int hashCode4 = (hashCode3 + (d == null ? 0 : d.hashCode())) * 31;
            Integer num3 = this.voteCount;
            int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str2 = this.overview;
            int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.releaseDate;
            int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.createdAt;
            int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.updatedAt;
            int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num4 = this.f9983id;
            int hashCode10 = (hashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
            ArrayList<String> arrayList = this.videos;
            return hashCode10 + (arrayList != null ? arrayList.hashCode() : 0);
        }

        public String toString() {
            return "Episodes(episodeNumber=" + this.episodeNumber + ", name=" + this.name + ", seasonNumber=" + this.seasonNumber + ", voteAverage=" + this.voteAverage + ", voteCount=" + this.voteCount + ", overview=" + this.overview + ", releaseDate=" + this.releaseDate + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", id=" + this.f9983id + ", videos=" + this.videos + ')';
        }

        public Episodes(@JsonProperty("episodeNumber") Integer num, @JsonProperty("name") String str, @JsonProperty("seasonNumber") Integer num2, @JsonProperty("voteAverage") Double d, @JsonProperty("voteCount") Integer num3, @JsonProperty("overview") String str2, @JsonProperty("releaseDate") String str3, @JsonProperty("createdAt") String str4, @JsonProperty("updatedAt") String str5, @JsonProperty("id") Integer num4, @JsonProperty("videos") ArrayList<String> arrayList) {
            this.episodeNumber = num;
            this.name = str;
            this.seasonNumber = num2;
            this.voteAverage = d;
            this.voteCount = num3;
            this.overview = str2;
            this.releaseDate = str3;
            this.createdAt = str4;
            this.updatedAt = str5;
            this.f9983id = num4;
            this.videos = arrayList;
        }

        public final Integer getEpisodeNumber() {
            return this.episodeNumber;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        public final Integer getVoteCount() {
            return this.voteCount;
        }

        public final String getOverview() {
            return this.overview;
        }

        public final String getReleaseDate() {
            return this.releaseDate;
        }

        public final String getCreatedAt() {
            return this.createdAt;
        }

        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        public final Integer getId() {
            return this.f9983id;
        }

        public /* synthetic */ Episodes(Integer num, String str, Integer num2, Double d, Integer num3, String str2, String str3, String str4, String str5, Integer num4, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) == 0 ? num4 : null, (i & 1024) != 0 ? new ArrayList() : arrayList);
        }

        public final ArrayList<String> getVideos() {
            return this.videos;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Genres;", "", "name", "", "id", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Genres;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Genres {

        /* renamed from: id */
        private final Integer f9984id;
        private final String name;

        public Genres() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Genres copy$default(Genres genres, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = genres.name;
            }
            if ((i & 2) != 0) {
                num = genres.f9984id;
            }
            return genres.copy(str, num);
        }

        public final String component1() {
            return this.name;
        }

        public final Integer component2() {
            return this.f9984id;
        }

        public final Genres copy(@JsonProperty("name") String str, @JsonProperty("id") Integer num) {
            return new Genres(str, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Genres) {
                Genres genres = (Genres) obj;
                return Intrinsics.areEqual(this.name, genres.name) && Intrinsics.areEqual(this.f9984id, genres.f9984id);
            }
            return false;
        }

        public int hashCode() {
            String str = this.name;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.f9984id;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "Genres(name=" + this.name + ", id=" + this.f9984id + ')';
        }

        public Genres(@JsonProperty("name") String str, @JsonProperty("id") Integer num) {
            this.name = str;
            this.f9984id = num;
        }

        public /* synthetic */ Genres(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getId() {
            return this.f9984id;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfig;", "", "AddThisService", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfigData;", "Application", "GtmService", "Services", "(Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfigData;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfigData;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfigData;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfigData;)V", "getAddThisService", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfigData;", "getApplication", "getGtmService", "getServices", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class RuntimeConfig {
        private final RuntimeConfigData AddThisService;
        private final RuntimeConfigData Application;
        private final RuntimeConfigData GtmService;
        private final RuntimeConfigData Services;

        public RuntimeConfig() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ RuntimeConfig copy$default(RuntimeConfig runtimeConfig, RuntimeConfigData runtimeConfigData, RuntimeConfigData runtimeConfigData2, RuntimeConfigData runtimeConfigData3, RuntimeConfigData runtimeConfigData4, int i, Object obj) {
            if ((i & 1) != 0) {
                runtimeConfigData = runtimeConfig.AddThisService;
            }
            if ((i & 2) != 0) {
                runtimeConfigData2 = runtimeConfig.Application;
            }
            if ((i & 4) != 0) {
                runtimeConfigData3 = runtimeConfig.GtmService;
            }
            if ((i & 8) != 0) {
                runtimeConfigData4 = runtimeConfig.Services;
            }
            return runtimeConfig.copy(runtimeConfigData, runtimeConfigData2, runtimeConfigData3, runtimeConfigData4);
        }

        public final RuntimeConfigData component1() {
            return this.AddThisService;
        }

        public final RuntimeConfigData component2() {
            return this.Application;
        }

        public final RuntimeConfigData component3() {
            return this.GtmService;
        }

        public final RuntimeConfigData component4() {
            return this.Services;
        }

        public final RuntimeConfig copy(@JsonProperty("AddThisService") RuntimeConfigData runtimeConfigData, @JsonProperty("Application") RuntimeConfigData runtimeConfigData2, @JsonProperty("GtmService") RuntimeConfigData runtimeConfigData3, @JsonProperty("Services") RuntimeConfigData runtimeConfigData4) {
            return new RuntimeConfig(runtimeConfigData, runtimeConfigData2, runtimeConfigData3, runtimeConfigData4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RuntimeConfig) {
                RuntimeConfig runtimeConfig = (RuntimeConfig) obj;
                return Intrinsics.areEqual(this.AddThisService, runtimeConfig.AddThisService) && Intrinsics.areEqual(this.Application, runtimeConfig.Application) && Intrinsics.areEqual(this.GtmService, runtimeConfig.GtmService) && Intrinsics.areEqual(this.Services, runtimeConfig.Services);
            }
            return false;
        }

        public int hashCode() {
            RuntimeConfigData runtimeConfigData = this.AddThisService;
            int hashCode = (runtimeConfigData == null ? 0 : runtimeConfigData.hashCode()) * 31;
            RuntimeConfigData runtimeConfigData2 = this.Application;
            int hashCode2 = (hashCode + (runtimeConfigData2 == null ? 0 : runtimeConfigData2.hashCode())) * 31;
            RuntimeConfigData runtimeConfigData3 = this.GtmService;
            int hashCode3 = (hashCode2 + (runtimeConfigData3 == null ? 0 : runtimeConfigData3.hashCode())) * 31;
            RuntimeConfigData runtimeConfigData4 = this.Services;
            return hashCode3 + (runtimeConfigData4 != null ? runtimeConfigData4.hashCode() : 0);
        }

        public String toString() {
            return "RuntimeConfig(AddThisService=" + this.AddThisService + ", Application=" + this.Application + ", GtmService=" + this.GtmService + ", Services=" + this.Services + ')';
        }

        public RuntimeConfig(@JsonProperty("AddThisService") RuntimeConfigData runtimeConfigData, @JsonProperty("Application") RuntimeConfigData runtimeConfigData2, @JsonProperty("GtmService") RuntimeConfigData runtimeConfigData3, @JsonProperty("Services") RuntimeConfigData runtimeConfigData4) {
            this.AddThisService = runtimeConfigData;
            this.Application = runtimeConfigData2;
            this.GtmService = runtimeConfigData3;
            this.Services = runtimeConfigData4;
        }

        public /* synthetic */ RuntimeConfig(RuntimeConfigData runtimeConfigData, RuntimeConfigData runtimeConfigData2, RuntimeConfigData runtimeConfigData3, RuntimeConfigData runtimeConfigData4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            RuntimeConfig runtimeConfig;
            RuntimeConfigData runtimeConfigData5;
            RuntimeConfigData runtimeConfigData6 = (i & 1) != 0 ? new RuntimeConfigData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null) : runtimeConfigData;
            RuntimeConfigData runtimeConfigData7 = (i & 2) != 0 ? new RuntimeConfigData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null) : runtimeConfigData2;
            RuntimeConfigData runtimeConfigData8 = (i & 4) != 0 ? new RuntimeConfigData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null) : runtimeConfigData3;
            if ((i & 8) != 0) {
                runtimeConfigData5 = new RuntimeConfigData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
                runtimeConfig = this;
            } else {
                runtimeConfig = this;
                runtimeConfigData5 = runtimeConfigData4;
            }
            new RuntimeConfig(runtimeConfigData6, runtimeConfigData7, runtimeConfigData8, runtimeConfigData5);
        }

        public final RuntimeConfigData getAddThisService() {
            return this.AddThisService;
        }

        public final RuntimeConfigData getApplication() {
            return this.Application;
        }

        public final RuntimeConfigData getGtmService() {
            return this.GtmService;
        }

        public final RuntimeConfigData getServices() {
            return this.Services;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¶\u0001\u00106\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b'\u0010\u0018¨\u0006="}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfigData;", "", "PublicId", "", "ContentUsageType", "IsDevelopmentMode", "", "IsDevelopmentOrProductionMode", "IsProductionMode", "IsStagingMode", "IsTestMode", "Mode", "Name", "Url", "UseFilterInfoInUrl", "TrackingId", HttpHeaders.SERVER, "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Server;", "TmdbServer", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TmdbServer;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Server;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TmdbServer;)V", "getContentUsageType", "()Ljava/lang/String;", "getIsDevelopmentMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIsDevelopmentOrProductionMode", "getIsProductionMode", "getIsStagingMode", "getIsTestMode", "getMode", "getName", "getPublicId", "getServer", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Server;", "getTmdbServer", "()Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TmdbServer;", "getTrackingId", "getUrl", "getUseFilterInfoInUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Server;Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TmdbServer;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RuntimeConfigData;", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class RuntimeConfigData {
        private final String ContentUsageType;
        private final Boolean IsDevelopmentMode;
        private final Boolean IsDevelopmentOrProductionMode;
        private final Boolean IsProductionMode;
        private final Boolean IsStagingMode;
        private final Boolean IsTestMode;
        private final String Mode;
        private final String Name;
        private final String PublicId;
        private final Server Server;
        private final TmdbServer TmdbServer;
        private final String TrackingId;
        private final String Url;
        private final Boolean UseFilterInfoInUrl;

        public RuntimeConfigData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        }

        public final String component1() {
            return this.PublicId;
        }

        public final String component10() {
            return this.Url;
        }

        public final Boolean component11() {
            return this.UseFilterInfoInUrl;
        }

        public final String component12() {
            return this.TrackingId;
        }

        public final Server component13() {
            return this.Server;
        }

        public final TmdbServer component14() {
            return this.TmdbServer;
        }

        public final String component2() {
            return this.ContentUsageType;
        }

        public final Boolean component3() {
            return this.IsDevelopmentMode;
        }

        public final Boolean component4() {
            return this.IsDevelopmentOrProductionMode;
        }

        public final Boolean component5() {
            return this.IsProductionMode;
        }

        public final Boolean component6() {
            return this.IsStagingMode;
        }

        public final Boolean component7() {
            return this.IsTestMode;
        }

        public final String component8() {
            return this.Mode;
        }

        public final String component9() {
            return this.Name;
        }

        public final RuntimeConfigData copy(@JsonProperty("PublicId") String str, @JsonProperty("ContentUsageType") String str2, @JsonProperty("IsDevelopmentMode") Boolean bool, @JsonProperty("IsDevelopmentOrProductionMode") Boolean bool2, @JsonProperty("IsProductionMode") Boolean bool3, @JsonProperty("IsStagingMode") Boolean bool4, @JsonProperty("IsTestMode") Boolean bool5, @JsonProperty("Mode") String str3, @JsonProperty("Name") String str4, @JsonProperty("Url") String str5, @JsonProperty("UseFilterInfoInUrl") Boolean bool6, @JsonProperty("TrackingId") String str6, @JsonProperty("Server") Server server, @JsonProperty("TmdbServer") TmdbServer tmdbServer) {
            return new RuntimeConfigData(str, str2, bool, bool2, bool3, bool4, bool5, str3, str4, str5, bool6, str6, server, tmdbServer);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RuntimeConfigData) {
                RuntimeConfigData runtimeConfigData = (RuntimeConfigData) obj;
                return Intrinsics.areEqual(this.PublicId, runtimeConfigData.PublicId) && Intrinsics.areEqual(this.ContentUsageType, runtimeConfigData.ContentUsageType) && Intrinsics.areEqual(this.IsDevelopmentMode, runtimeConfigData.IsDevelopmentMode) && Intrinsics.areEqual(this.IsDevelopmentOrProductionMode, runtimeConfigData.IsDevelopmentOrProductionMode) && Intrinsics.areEqual(this.IsProductionMode, runtimeConfigData.IsProductionMode) && Intrinsics.areEqual(this.IsStagingMode, runtimeConfigData.IsStagingMode) && Intrinsics.areEqual(this.IsTestMode, runtimeConfigData.IsTestMode) && Intrinsics.areEqual(this.Mode, runtimeConfigData.Mode) && Intrinsics.areEqual(this.Name, runtimeConfigData.Name) && Intrinsics.areEqual(this.Url, runtimeConfigData.Url) && Intrinsics.areEqual(this.UseFilterInfoInUrl, runtimeConfigData.UseFilterInfoInUrl) && Intrinsics.areEqual(this.TrackingId, runtimeConfigData.TrackingId) && Intrinsics.areEqual(this.Server, runtimeConfigData.Server) && Intrinsics.areEqual(this.TmdbServer, runtimeConfigData.TmdbServer);
            }
            return false;
        }

        public int hashCode() {
            String str = this.PublicId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.ContentUsageType;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.IsDevelopmentMode;
            int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.IsDevelopmentOrProductionMode;
            int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.IsProductionMode;
            int hashCode5 = (hashCode4 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.IsStagingMode;
            int hashCode6 = (hashCode5 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.IsTestMode;
            int hashCode7 = (hashCode6 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            String str3 = this.Mode;
            int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.Name;
            int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.Url;
            int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Boolean bool6 = this.UseFilterInfoInUrl;
            int hashCode11 = (hashCode10 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            String str6 = this.TrackingId;
            int hashCode12 = (hashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Server server = this.Server;
            int hashCode13 = (hashCode12 + (server == null ? 0 : server.hashCode())) * 31;
            TmdbServer tmdbServer = this.TmdbServer;
            return hashCode13 + (tmdbServer != null ? tmdbServer.hashCode() : 0);
        }

        public String toString() {
            return "RuntimeConfigData(PublicId=" + this.PublicId + ", ContentUsageType=" + this.ContentUsageType + ", IsDevelopmentMode=" + this.IsDevelopmentMode + ", IsDevelopmentOrProductionMode=" + this.IsDevelopmentOrProductionMode + ", IsProductionMode=" + this.IsProductionMode + ", IsStagingMode=" + this.IsStagingMode + ", IsTestMode=" + this.IsTestMode + ", Mode=" + this.Mode + ", Name=" + this.Name + ", Url=" + this.Url + ", UseFilterInfoInUrl=" + this.UseFilterInfoInUrl + ", TrackingId=" + this.TrackingId + ", Server=" + this.Server + ", TmdbServer=" + this.TmdbServer + ')';
        }

        public RuntimeConfigData(@JsonProperty("PublicId") String str, @JsonProperty("ContentUsageType") String str2, @JsonProperty("IsDevelopmentMode") Boolean bool, @JsonProperty("IsDevelopmentOrProductionMode") Boolean bool2, @JsonProperty("IsProductionMode") Boolean bool3, @JsonProperty("IsStagingMode") Boolean bool4, @JsonProperty("IsTestMode") Boolean bool5, @JsonProperty("Mode") String str3, @JsonProperty("Name") String str4, @JsonProperty("Url") String str5, @JsonProperty("UseFilterInfoInUrl") Boolean bool6, @JsonProperty("TrackingId") String str6, @JsonProperty("Server") Server server, @JsonProperty("TmdbServer") TmdbServer tmdbServer) {
            this.PublicId = str;
            this.ContentUsageType = str2;
            this.IsDevelopmentMode = bool;
            this.IsDevelopmentOrProductionMode = bool2;
            this.IsProductionMode = bool3;
            this.IsStagingMode = bool4;
            this.IsTestMode = bool5;
            this.Mode = str3;
            this.Name = str4;
            this.Url = str5;
            this.UseFilterInfoInUrl = bool6;
            this.TrackingId = str6;
            this.Server = server;
            this.TmdbServer = tmdbServer;
        }

        public final String getPublicId() {
            return this.PublicId;
        }

        public final String getContentUsageType() {
            return this.ContentUsageType;
        }

        public final Boolean getIsDevelopmentMode() {
            return this.IsDevelopmentMode;
        }

        public final Boolean getIsDevelopmentOrProductionMode() {
            return this.IsDevelopmentOrProductionMode;
        }

        public final Boolean getIsProductionMode() {
            return this.IsProductionMode;
        }

        public final Boolean getIsStagingMode() {
            return this.IsStagingMode;
        }

        public final Boolean getIsTestMode() {
            return this.IsTestMode;
        }

        public final String getMode() {
            return this.Mode;
        }

        public final String getName() {
            return this.Name;
        }

        public final String getUrl() {
            return this.Url;
        }

        public final Boolean getUseFilterInfoInUrl() {
            return this.UseFilterInfoInUrl;
        }

        public final String getTrackingId() {
            return this.TrackingId;
        }

        public /* synthetic */ RuntimeConfigData(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str3, String str4, String str5, Boolean bool6, String str6, Server server, TmdbServer tmdbServer, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : bool3, (i & 32) != 0 ? null : bool4, (i & 64) != 0 ? null : bool5, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : bool6, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? new Server(null, 1, null) : server, (i & 8192) != 0 ? new TmdbServer(null, 1, null) : tmdbServer);
        }

        public final Server getServer() {
            return this.Server;
        }

        public final TmdbServer getTmdbServer() {
            return this.TmdbServer;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$TmdbServer;", "", "Url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class TmdbServer {
        private final String Url;

        public TmdbServer() {
            this(null, 1, null);
        }

        public static /* synthetic */ TmdbServer copy$default(TmdbServer tmdbServer, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tmdbServer.Url;
            }
            return tmdbServer.copy(str);
        }

        public final String component1() {
            return this.Url;
        }

        public final TmdbServer copy(@JsonProperty("Url") String str) {
            return new TmdbServer(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TmdbServer) && Intrinsics.areEqual(this.Url, ((TmdbServer) obj).Url);
        }

        public int hashCode() {
            String str = this.Url;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "TmdbServer(Url=" + this.Url + ')';
        }

        public TmdbServer(@JsonProperty("Url") String str) {
            this.Url = str;
        }

        public /* synthetic */ TmdbServer(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getUrl() {
            return this.Url;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Server;", "", "Url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Server {
        private final String Url;

        public Server() {
            this(null, 1, null);
        }

        public static /* synthetic */ Server copy$default(Server server, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = server.Url;
            }
            return server.copy(str);
        }

        public final String component1() {
            return this.Url;
        }

        public final Server copy(@JsonProperty("Url") String str) {
            return new Server(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Server) && Intrinsics.areEqual(this.Url, ((Server) obj).Url);
        }

        public int hashCode() {
            String str = this.Url;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Server(Url=" + this.Url + ')';
        }

        public Server(@JsonProperty("Url") String str) {
            this.Url = str;
        }

        public /* synthetic */ Server(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getUrl() {
            return this.Url;
        }
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003Jd\u0010\u001e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RecommendationsList;", "", "docs", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$Docs;", "Lkotlin/collections/ArrayList;", "total", "", "page", "limit", "pages", "type", "", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getDocs", "()Ljava/util/ArrayList;", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPage", "getPages", "getTotal", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$RecommendationsList;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class RecommendationsList {
        private final ArrayList<Docs> docs;
        private final Integer limit;
        private final Integer page;
        private final Integer pages;
        private final Integer total;
        private final String type;

        public RecommendationsList() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ RecommendationsList copy$default(RecommendationsList recommendationsList, ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, Object obj) {
            ArrayList<Docs> arrayList2 = arrayList;
            if ((i & 1) != 0) {
                arrayList2 = recommendationsList.docs;
            }
            if ((i & 2) != 0) {
                num = recommendationsList.total;
            }
            Integer num5 = num;
            if ((i & 4) != 0) {
                num2 = recommendationsList.page;
            }
            Integer num6 = num2;
            if ((i & 8) != 0) {
                num3 = recommendationsList.limit;
            }
            Integer num7 = num3;
            if ((i & 16) != 0) {
                num4 = recommendationsList.pages;
            }
            Integer num8 = num4;
            if ((i & 32) != 0) {
                str = recommendationsList.type;
            }
            return recommendationsList.copy(arrayList2, num5, num6, num7, num8, str);
        }

        public final ArrayList<Docs> component1() {
            return this.docs;
        }

        public final Integer component2() {
            return this.total;
        }

        public final Integer component3() {
            return this.page;
        }

        public final Integer component4() {
            return this.limit;
        }

        public final Integer component5() {
            return this.pages;
        }

        public final String component6() {
            return this.type;
        }

        public final RecommendationsList copy(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            return new RecommendationsList(docs, num, num2, num3, num4, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RecommendationsList) {
                RecommendationsList recommendationsList = (RecommendationsList) obj;
                return Intrinsics.areEqual(this.docs, recommendationsList.docs) && Intrinsics.areEqual(this.total, recommendationsList.total) && Intrinsics.areEqual(this.page, recommendationsList.page) && Intrinsics.areEqual(this.limit, recommendationsList.limit) && Intrinsics.areEqual(this.pages, recommendationsList.pages) && Intrinsics.areEqual(this.type, recommendationsList.type);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.docs.hashCode() * 31;
            Integer num = this.total;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.page;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.limit;
            int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.pages;
            int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
            String str = this.type;
            return hashCode5 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "RecommendationsList(docs=" + this.docs + ", total=" + this.total + ", page=" + this.page + ", limit=" + this.limit + ", pages=" + this.pages + ", type=" + this.type + ')';
        }

        public RecommendationsList(@JsonProperty("docs") ArrayList<Docs> docs, @JsonProperty("total") Integer num, @JsonProperty("page") Integer num2, @JsonProperty("limit") Integer num3, @JsonProperty("pages") Integer num4, @JsonProperty("type") String str) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            this.docs = docs;
            this.total = num;
            this.page = num2;
            this.limit = num3;
            this.pages = num4;
            this.type = str;
        }

        public /* synthetic */ RecommendationsList(ArrayList arrayList, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) == 0 ? str : null);
        }

        public final ArrayList<Docs> getDocs() {
            return this.docs;
        }

        public final Integer getTotal() {
            return this.total;
        }

        public final Integer getPage() {
            return this.page;
        }

        public final Integer getLimit() {
            return this.limit;
        }

        public final Integer getPages() {
            return this.pages;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String cleanTitle(String str) {
        String substringBefore$default = StringsKt.substringBefore$default(str, "/season", (String) null, 2, (Object) null);
        if (new Regex("\\..\\.").containsMatchIn(substringBefore$default)) {
            String lowerCase = StringsKt.replace$default(new Regex("(:|-&)").replace(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.removeSuffix(substringBefore$default, (CharSequence) "."), " - ", "-", false, 4, (Object) null), ".", "-", false, 4, (Object) null), " ", "-", false, 4, (Object) null), "-&", "", false, 4, (Object) null), ""), "'", "-", false, 4, (Object) null).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return lowerCase;
        }
        String lowerCase2 = StringsKt.replace$default(new Regex("(:|-&|\\.)").replace(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, " - ", "-", false, 4, (Object) null), " ", "-", false, 4, (Object) null), "-&", "", false, 4, (Object) null), "/", "-", false, 4, (Object) null), ""), "'", "-", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getLoadMan(java.lang.String r20, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.movieproviders.TheFlixToProvider.LoadMain> r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.movieproviders.TheFlixToProvider$getLoadMan$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.movieproviders.TheFlixToProvider$getLoadMan$1 r2 = (com.lagradost.cloudstream3.movieproviders.TheFlixToProvider$getLoadMan$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.movieproviders.TheFlixToProvider$getLoadMan$1 r2 = new com.lagradost.cloudstream3.movieproviders.TheFlixToProvider$getLoadMan$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L42
            if (r3 == r5) goto L39
            if (r3 != r4) goto L31
            kotlin.ResultKt.throwOnFailure(r1)
            goto L7d
        L31:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L39:
            java.lang.Object r3 = r2.L$0
            java.lang.String r3 = (java.lang.String) r3
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r3
            goto L52
        L42:
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r20
            r2.L$0 = r1
            r2.label = r5
            java.lang.Object r3 = r0.getCookies(r2)
            if (r3 != r15) goto L52
            return r15
        L52:
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            java.util.Map<java.lang.String, java.lang.String> r5 = com.lagradost.cloudstream3.movieproviders.TheFlixToProvider.latestCookies
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r17 = 2044(0x7fc, float:2.864E-42)
            r18 = 0
            r14 = 0
            r2.L$0 = r14
            r2.label = r4
            r4 = r1
            r1 = 0
            r14 = r1
            r1 = r15
            r15 = r16
            r16 = r2
            java.lang.Object r2 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            if (r2 != r1) goto L7c
            return r1
        L7c:
            r1 = r2
        L7d:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            org.jsoup.nodes.Document r1 = r1.getDocument()
            java.lang.String r2 = "script[type=application/json]"
            org.jsoup.nodes.Element r1 = r1.selectFirst(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = r1.data()
            com.lagradost.cloudstream3.utils.AppUtils r2 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            java.lang.String r2 = "script"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.fasterxml.jackson.databind.json.JsonMapper r2 = com.lagradost.cloudstream3.MainAPIKt.getMapper()
            com.fasterxml.jackson.databind.ObjectMapper r2 = (com.fasterxml.jackson.databind.ObjectMapper) r2
            com.lagradost.cloudstream3.movieproviders.TheFlixToProvider$getLoadMan$$inlined$parseJson$1 r3 = new com.lagradost.cloudstream3.movieproviders.TheFlixToProvider$getLoadMan$$inlined$parseJson$1
            r3.<init>()
            com.fasterxml.jackson.core.type.TypeReference r3 = (com.fasterxml.jackson.core.type.TypeReference) r3
            java.lang.Object r1 = r2.readValue(r1, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.TheFlixToProvider.getLoadMan(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0208  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.util.List] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r40, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r41) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.TheFlixToProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: TheFlixToProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TheFlixToProvider$VideoData;", "", "url", "", "id", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class VideoData {

        /* renamed from: id */
        private final String f9987id;
        private final String type;
        private final String url;

        public VideoData() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ VideoData copy$default(VideoData videoData, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = videoData.url;
            }
            if ((i & 2) != 0) {
                str2 = videoData.f9987id;
            }
            if ((i & 4) != 0) {
                str3 = videoData.type;
            }
            return videoData.copy(str, str2, str3);
        }

        public final String component1() {
            return this.url;
        }

        public final String component2() {
            return this.f9987id;
        }

        public final String component3() {
            return this.type;
        }

        public final VideoData copy(@JsonProperty("url") String str, @JsonProperty("id") String str2, @JsonProperty("type") String str3) {
            return new VideoData(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VideoData) {
                VideoData videoData = (VideoData) obj;
                return Intrinsics.areEqual(this.url, videoData.url) && Intrinsics.areEqual(this.f9987id, videoData.f9987id) && Intrinsics.areEqual(this.type, videoData.type);
            }
            return false;
        }

        public int hashCode() {
            String str = this.url;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f9987id;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.type;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "VideoData(url=" + this.url + ", id=" + this.f9987id + ", type=" + this.type + ')';
        }

        public VideoData(@JsonProperty("url") String str, @JsonProperty("id") String str2, @JsonProperty("type") String str3) {
            this.url = str;
            this.f9987id = str2;
            this.type = str3;
        }

        public /* synthetic */ VideoData(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getId() {
            return this.f9987id;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0178  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r23, boolean r24, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r25, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r26, kotlin.coroutines.Continuation<? super java.lang.Boolean> r27) {
        /*
            Method dump skipped, instructions count: 547
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.TheFlixToProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
