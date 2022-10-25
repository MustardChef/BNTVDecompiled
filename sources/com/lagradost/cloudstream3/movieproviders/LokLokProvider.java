package com.lagradost.cloudstream3.movieproviders;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.gson.Gson;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.Page;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.VPNStatus;
import com.lagradost.cloudstream3.p041ui.home.HomeParentItemAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: LokLokProvider.kt */
@Metadata(m108d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 T2\u00020\u0001:\u000fTUVWXYZ[\\]^_`abB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u001c\u0010&\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010'\u001a\u00020\bH\u0002J\u0013\u0010(\u001a\u0004\u0018\u00010)H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*J\u001b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010#\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010-JI\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\b2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020402H\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J\u0019\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010-J!\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u0006\u0010>\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010-J\u001a\u0010?\u001a\u00020@*\u00020A2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0004J\u0010\u0010D\u001a\b\u0012\u0004\u0012\u00020E0<*\u00020FJ\u0018\u0010G\u001a\b\u0012\u0004\u0012\u00020H0<*\u00020I2\u0006\u0010J\u001a\u00020\u0004J\u0010\u0010K\u001a\b\u0012\u0004\u0012\u00020=0<*\u00020LJ\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020H0<*\u00020I2\u0006\u0010J\u001a\u00020\u0004J\u0012\u0010N\u001a\u00020O*\u00020P2\u0006\u0010J\u001a\u00020\u0004J\u0016\u0010N\u001a\u00020O*\u00020Q2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%J\u0012\u0010N\u001a\u00020O*\u00020R2\u0006\u0010J\u001a\u00020\u0004J\u0012\u0010N\u001a\u00020O*\u00020S2\u0006\u0010J\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u001a\u0010\u0012\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006c"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "defaultPageUrl", "", "getDefaultPageUrl", "()Ljava/lang/String;", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "hasQuickSearch", "getHasQuickSearch", "isPremiumContent", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "vpnStatus", "Lcom/lagradost/cloudstream3/VPNStatus;", "getVpnStatus", "()Lcom/lagradost/cloudstream3/VPNStatus;", "fixUrlImageHomeLokLok", "url", "cardType", "Lcom/lagradost/cloudstream3/ui/home/ParentItemAdapter$CardType;", "fixUrlImageLokLok", "isCoverHorizontal", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPage", "Lcom/lagradost/cloudstream3/PageResponse;", "param", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "toEpisode", "Lcom/lagradost/cloudstream3/Episode;", "LEpisodeVo;", "idMovie", MonitorLogServerProtocol.PARAM_CATEGORY, "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$HomeResponse;", "toListMoviesPage", "Lcom/lagradost/cloudstream3/Page;", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$HomeCategoryResponse;", "nameApi", "toListSearchResponse", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$LokLokSearchResponse;", "toListTvShowPage", "toMovieSearchResponse", "Lcom/lagradost/cloudstream3/MovieSearchResponse;", "LLikeList;", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$RecommendContentVOItem;", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$SearchPageItem;", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$SearchResultItem;", "Companion", "Data", "DataCategory", "HomeCategoryResponse", "HomeResponse", "ItemCategory", "LokLokMovieDetailResponseData", "LokLokSearchResponse", "LokLokSource", "LokLokSourceResponse", "RecommendContentVOItem", "RecommendItem", "ScreenItem", "SearchPageItem", "SearchResultItem", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class LokLokProvider extends MainAPI {
    public static final Companion Companion = new Companion(null);
    private static final Map<String, String> HEADER_DEFAULT = MapsKt.mapOf(TuplesKt.m100to("lang", "vi"), TuplesKt.m100to("Content-Type", AbstractSpiCall.ACCEPT_JSON_VALUE), TuplesKt.m100to("versioncode", "11"), TuplesKt.m100to("clienttype", "ios_jike_default"));
    public static final String TOKEN_PLAY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJnb29nbGVJZCI6IjEwNzY4NTQ0ODc2ODgwMTUxOTYxOCIsIm5pY2tOYW1lIjoiVGl0dGlrOTg3MjM3OTIiLCJjdXJyZW50VGltZU1pbGxpcyI6MTY0NTgwNDE2NzM0NywiZXhwIjoxNjQ4Mzk2MTY3LCJ1c2VySWQiOjI3MjIyNH0.kavvmPA_5XphtK2dM4CLil_OSrVYZLHIvCH76lI8CFw";
    public static final String URL_GET_CATEGORY = "https://ga-mobile-api.loklok.tv/cms/web/pc/search/list";
    public static final String URL_GET_DETAIL = "https://ga-mobile-api.loklok.tv/cms/web/pc/movieDrama/get";
    public static final String URL_GET_LINK_PLAY = "https://ga-mobile-api.loklok.tv/cms/web/pc/movieDrama/getPlayInfo";
    public static final String URL_GET_MOVIE_IN_PAGE = "https://ga-mobile-api.loklok.tv/cms/web/pc/album/detail";
    public static final String URL_ROOT_API = "https://ga-mobile-api.loklok.tv";
    public static final String URL_SEARCH = "https://ga-mobile-api.loklok.tv/cms/web/pc/search/searchWithKeyWord";
    public static final String URL_SEARCH_DEFAULT = "https://ga-mobile-api.loklok.tv/cms/web/pc/search/search";
    private String mainUrl = "https://tiktik.pro";
    private String name = "PhimHD";
    private final boolean isPremiumContent = true;

    /* compiled from: LokLokProvider.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HomeParentItemAdapter.CardType.values().length];
            iArr[HomeParentItemAdapter.CardType.LONG_WIDTH_CARD.ordinal()] = 1;
            iArr[HomeParentItemAdapter.CardType.FULL_WIDTH_CARD.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasChromecastSupport() {
        return false;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasDownloadSupport() {
        return true;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasMainPage() {
        return true;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasQuickSearch() {
        return false;
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
    public String getDefaultPageUrl() {
        return String.valueOf(getMainUrl());
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean isPremiumContent() {
        return this.isPremiumContent;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries});
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public VPNStatus getVpnStatus() {
        return VPNStatus.None;
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$Companion;", "", "()V", "HEADER_DEFAULT", "", "", "getHEADER_DEFAULT", "()Ljava/util/Map;", "TOKEN_PLAY", "URL_GET_CATEGORY", "URL_GET_DETAIL", "URL_GET_LINK_PLAY", "URL_GET_MOVIE_IN_PAGE", "URL_ROOT_API", "URL_SEARCH", "URL_SEARCH_DEFAULT", "getIPTV", "", "listHomePageList", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/HomePageList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, String> getHEADER_DEFAULT() {
            return LokLokProvider.HEADER_DEFAULT;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getIPTV(java.util.ArrayList<com.lagradost.cloudstream3.HomePageList> r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
            /*
                r21 = this;
                r0 = r23
                boolean r1 = r0 instanceof com.lagradost.cloudstream3.movieproviders.LokLokProvider$Companion$getIPTV$1
                if (r1 == 0) goto L18
                r1 = r0
                com.lagradost.cloudstream3.movieproviders.LokLokProvider$Companion$getIPTV$1 r1 = (com.lagradost.cloudstream3.movieproviders.LokLokProvider$Companion$getIPTV$1) r1
                int r2 = r1.label
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 & r3
                if (r2 == 0) goto L18
                int r0 = r1.label
                int r0 = r0 - r3
                r1.label = r0
                r2 = r21
                goto L1f
            L18:
                com.lagradost.cloudstream3.movieproviders.LokLokProvider$Companion$getIPTV$1 r1 = new com.lagradost.cloudstream3.movieproviders.LokLokProvider$Companion$getIPTV$1
                r2 = r21
                r1.<init>(r2, r0)
            L1f:
                java.lang.Object r0 = r1.result
                java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r3 = r1.label
                r4 = 1
                if (r3 == 0) goto L41
                if (r3 != r4) goto L39
                java.lang.Object r1 = r1.L$0
                java.util.ArrayList r1 = (java.util.ArrayList) r1
                kotlin.ResultKt.throwOnFailure(r0)
                r20 = r1
                r1 = r0
                r0 = r20
                goto L70
            L39:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L41:
                kotlin.ResultKt.throwOnFailure(r0)
                com.lagradost.cloudstream3.utils.Extensions$RequestCustom r0 = com.lagradost.cloudstream3.MainActivityKt.getApp()
                r3 = r0
                com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 4
                java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.HOURS
                r12 = 0
                r14 = 0
                r17 = 1854(0x73e, float:2.598E-42)
                r18 = 0
                r0 = r22
                r1.L$0 = r0
                r1.label = r4
                java.lang.String r4 = "https://raw.githubusercontent.com/cinehubwork/abc/master/schedule.json"
                r19 = r15
                r15 = 0
                r16 = r1
                java.lang.Object r1 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
                r3 = r19
                if (r1 != r3) goto L70
                return r3
            L70:
                com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
                okhttp3.Response r1 = r1.getOkhttpResponse()
                boolean r3 = r1.isSuccessful()
                if (r3 == 0) goto La6
                okhttp3.ResponseBody r3 = r1.body()
                if (r3 == 0) goto La6
                com.google.gson.Gson r3 = new com.google.gson.Gson
                r3.<init>()
                okhttp3.ResponseBody r1 = r1.body()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                java.lang.String r1 = r1.string()
                java.lang.Class<com.phimhd.ListIPTV> r4 = com.phimhd.ListIPTV.class
                java.lang.Object r1 = r3.fromJson(r1, r4)
                com.phimhd.ListIPTV r1 = (com.phimhd.ListIPTV) r1
                java.lang.String r3 = "listIPTV"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                com.lagradost.cloudstream3.HomePageList r1 = com.phimhd.ConfigHomeKt.toHomePageList(r1)
                r0.add(r1)
            La6:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.LokLokProvider.Companion.getIPTV(java.util.ArrayList, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.ArrayList] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r21) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.LokLokProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x015f A[LOOP:0: B:27:0x0159->B:29:0x015f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02ee  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadPage(java.lang.String r30, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.PageResponse> r31) {
        /*
            Method dump skipped, instructions count: 759
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.LokLokProvider.loadPage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r25, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r26) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.LokLokProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0214  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0188 -> B:31:0x0193). Please submit an issue!!! */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r37, boolean r38, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r39, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r40, kotlin.coroutines.Continuation<? super java.lang.Boolean> r41) {
        /*
            Method dump skipped, instructions count: 589
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.LokLokProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x025a  */
    /* JADX WARN: Type inference failed for: r8v15, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v12, types: [T, java.lang.String] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r46, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r47) {
        /*
            Method dump skipped, instructions count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.LokLokProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006\u0012\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\u000e\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006#"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$RecommendItem;", "", "homeSectionName", "", "homeSectionType", "coverType", "", "homeSectionId", "refId", "recommendContentVOList", "", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$RecommendContentVOItem;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/util/List;)V", "getCoverType", "()Ljava/lang/Number;", "getHomeSectionId", "getHomeSectionName", "()Ljava/lang/String;", "getHomeSectionType", "getRecommendContentVOList", "()Ljava/util/List;", "getRefId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class RecommendItem {
        private final Number coverType;
        private final Number homeSectionId;
        private final String homeSectionName;
        private final String homeSectionType;
        private final List<RecommendContentVOItem> recommendContentVOList;
        private final Number refId;

        public static /* synthetic */ RecommendItem copy$default(RecommendItem recommendItem, String str, String str2, Number number, Number number2, Number number3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = recommendItem.homeSectionName;
            }
            if ((i & 2) != 0) {
                str2 = recommendItem.homeSectionType;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                number = recommendItem.coverType;
            }
            Number number4 = number;
            if ((i & 8) != 0) {
                number2 = recommendItem.homeSectionId;
            }
            Number number5 = number2;
            if ((i & 16) != 0) {
                number3 = recommendItem.refId;
            }
            Number number6 = number3;
            List<RecommendContentVOItem> list2 = list;
            if ((i & 32) != 0) {
                list2 = recommendItem.recommendContentVOList;
            }
            return recommendItem.copy(str, str3, number4, number5, number6, list2);
        }

        public final String component1() {
            return this.homeSectionName;
        }

        public final String component2() {
            return this.homeSectionType;
        }

        public final Number component3() {
            return this.coverType;
        }

        public final Number component4() {
            return this.homeSectionId;
        }

        public final Number component5() {
            return this.refId;
        }

        public final List<RecommendContentVOItem> component6() {
            return this.recommendContentVOList;
        }

        public final RecommendItem copy(@JsonProperty("homeSectionName") String homeSectionName, @JsonProperty("homeSectionType") String homeSectionType, @JsonProperty("coverType") Number coverType, @JsonProperty("homeSectionId") Number homeSectionId, @JsonProperty("refId") Number refId, @JsonProperty("recommendContentVOList") List<RecommendContentVOItem> recommendContentVOList) {
            Intrinsics.checkNotNullParameter(homeSectionName, "homeSectionName");
            Intrinsics.checkNotNullParameter(homeSectionType, "homeSectionType");
            Intrinsics.checkNotNullParameter(coverType, "coverType");
            Intrinsics.checkNotNullParameter(homeSectionId, "homeSectionId");
            Intrinsics.checkNotNullParameter(refId, "refId");
            Intrinsics.checkNotNullParameter(recommendContentVOList, "recommendContentVOList");
            return new RecommendItem(homeSectionName, homeSectionType, coverType, homeSectionId, refId, recommendContentVOList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RecommendItem) {
                RecommendItem recommendItem = (RecommendItem) obj;
                return Intrinsics.areEqual(this.homeSectionName, recommendItem.homeSectionName) && Intrinsics.areEqual(this.homeSectionType, recommendItem.homeSectionType) && Intrinsics.areEqual(this.coverType, recommendItem.coverType) && Intrinsics.areEqual(this.homeSectionId, recommendItem.homeSectionId) && Intrinsics.areEqual(this.refId, recommendItem.refId) && Intrinsics.areEqual(this.recommendContentVOList, recommendItem.recommendContentVOList);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.homeSectionName.hashCode() * 31) + this.homeSectionType.hashCode()) * 31) + this.coverType.hashCode()) * 31) + this.homeSectionId.hashCode()) * 31) + this.refId.hashCode()) * 31) + this.recommendContentVOList.hashCode();
        }

        public String toString() {
            return "RecommendItem(homeSectionName=" + this.homeSectionName + ", homeSectionType=" + this.homeSectionType + ", coverType=" + this.coverType + ", homeSectionId=" + this.homeSectionId + ", refId=" + this.refId + ", recommendContentVOList=" + this.recommendContentVOList + ')';
        }

        public RecommendItem(@JsonProperty("homeSectionName") String homeSectionName, @JsonProperty("homeSectionType") String homeSectionType, @JsonProperty("coverType") Number coverType, @JsonProperty("homeSectionId") Number homeSectionId, @JsonProperty("refId") Number refId, @JsonProperty("recommendContentVOList") List<RecommendContentVOItem> recommendContentVOList) {
            Intrinsics.checkNotNullParameter(homeSectionName, "homeSectionName");
            Intrinsics.checkNotNullParameter(homeSectionType, "homeSectionType");
            Intrinsics.checkNotNullParameter(coverType, "coverType");
            Intrinsics.checkNotNullParameter(homeSectionId, "homeSectionId");
            Intrinsics.checkNotNullParameter(refId, "refId");
            Intrinsics.checkNotNullParameter(recommendContentVOList, "recommendContentVOList");
            this.homeSectionName = homeSectionName;
            this.homeSectionType = homeSectionType;
            this.coverType = coverType;
            this.homeSectionId = homeSectionId;
            this.refId = refId;
            this.recommendContentVOList = recommendContentVOList;
        }

        public final String getHomeSectionName() {
            return this.homeSectionName;
        }

        public final String getHomeSectionType() {
            return this.homeSectionType;
        }

        public final Number getCoverType() {
            return this.coverType;
        }

        public final Number getHomeSectionId() {
            return this.homeSectionId;
        }

        public final Number getRefId() {
            return this.refId;
        }

        public final List<RecommendContentVOItem> getRecommendContentVOList() {
            return this.recommendContentVOList;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u0006\u0012\b\b\u0001\u0010\r\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003Jw\u0010*\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\r\u001a\u00020\u00062\b\b\u0003\u0010\u000e\u001a\u00020\u000b2\b\b\u0003\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00060"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$RecommendContentVOItem;", "", MonitorLogServerProtocol.PARAM_CATEGORY, "", "contentType", "id", "", "imageUrl", "jumpAddress", "jumpType", "needLogin", "", "resourceNum", "resourceStatus", "showMark", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Number;Ljava/lang/Number;ZLjava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getContentType", "getId", "()Ljava/lang/Number;", "getImageUrl", "getJumpAddress", "getJumpType", "getNeedLogin", "()Z", "getResourceNum", "getResourceStatus", "getShowMark", "getTitle", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class RecommendContentVOItem {
        private final String category;
        private final String contentType;

        /* renamed from: id */
        private final Number f9964id;
        private final String imageUrl;
        private final String jumpAddress;
        private final String jumpType;
        private final boolean needLogin;
        private final Number resourceNum;
        private final Number resourceStatus;
        private final boolean showMark;
        private final String title;

        public final String component1() {
            return this.category;
        }

        public final boolean component10() {
            return this.showMark;
        }

        public final String component11() {
            return this.title;
        }

        public final String component2() {
            return this.contentType;
        }

        public final Number component3() {
            return this.f9964id;
        }

        public final String component4() {
            return this.imageUrl;
        }

        public final String component5() {
            return this.jumpAddress;
        }

        public final String component6() {
            return this.jumpType;
        }

        public final boolean component7() {
            return this.needLogin;
        }

        public final Number component8() {
            return this.resourceNum;
        }

        public final Number component9() {
            return this.resourceStatus;
        }

        public final RecommendContentVOItem copy(@JsonProperty("category") String category, @JsonProperty("contentType") String contentType, @JsonProperty("id") Number id, @JsonProperty("imageUrl") String imageUrl, @JsonProperty("jumpAddress") String jumpAddress, @JsonProperty("jumpType") String jumpType, @JsonProperty("needLogin") boolean z, @JsonProperty("resourceNum") Number resourceNum, @JsonProperty("resourceStatus") Number resourceStatus, @JsonProperty("showMark") boolean z2, @JsonProperty("title") String title) {
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(jumpAddress, "jumpAddress");
            Intrinsics.checkNotNullParameter(jumpType, "jumpType");
            Intrinsics.checkNotNullParameter(resourceNum, "resourceNum");
            Intrinsics.checkNotNullParameter(resourceStatus, "resourceStatus");
            Intrinsics.checkNotNullParameter(title, "title");
            return new RecommendContentVOItem(category, contentType, id, imageUrl, jumpAddress, jumpType, z, resourceNum, resourceStatus, z2, title);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RecommendContentVOItem) {
                RecommendContentVOItem recommendContentVOItem = (RecommendContentVOItem) obj;
                return Intrinsics.areEqual(this.category, recommendContentVOItem.category) && Intrinsics.areEqual(this.contentType, recommendContentVOItem.contentType) && Intrinsics.areEqual(this.f9964id, recommendContentVOItem.f9964id) && Intrinsics.areEqual(this.imageUrl, recommendContentVOItem.imageUrl) && Intrinsics.areEqual(this.jumpAddress, recommendContentVOItem.jumpAddress) && Intrinsics.areEqual(this.jumpType, recommendContentVOItem.jumpType) && this.needLogin == recommendContentVOItem.needLogin && Intrinsics.areEqual(this.resourceNum, recommendContentVOItem.resourceNum) && Intrinsics.areEqual(this.resourceStatus, recommendContentVOItem.resourceStatus) && this.showMark == recommendContentVOItem.showMark && Intrinsics.areEqual(this.title, recommendContentVOItem.title);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((((((this.category.hashCode() * 31) + this.contentType.hashCode()) * 31) + this.f9964id.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.jumpAddress.hashCode()) * 31) + this.jumpType.hashCode()) * 31;
            boolean z = this.needLogin;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int hashCode2 = (((((hashCode + i) * 31) + this.resourceNum.hashCode()) * 31) + this.resourceStatus.hashCode()) * 31;
            boolean z2 = this.showMark;
            return ((hashCode2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.title.hashCode();
        }

        public String toString() {
            return "RecommendContentVOItem(category=" + this.category + ", contentType=" + this.contentType + ", id=" + this.f9964id + ", imageUrl=" + this.imageUrl + ", jumpAddress=" + this.jumpAddress + ", jumpType=" + this.jumpType + ", needLogin=" + this.needLogin + ", resourceNum=" + this.resourceNum + ", resourceStatus=" + this.resourceStatus + ", showMark=" + this.showMark + ", title=" + this.title + ')';
        }

        public RecommendContentVOItem(@JsonProperty("category") String category, @JsonProperty("contentType") String contentType, @JsonProperty("id") Number id, @JsonProperty("imageUrl") String imageUrl, @JsonProperty("jumpAddress") String jumpAddress, @JsonProperty("jumpType") String jumpType, @JsonProperty("needLogin") boolean z, @JsonProperty("resourceNum") Number resourceNum, @JsonProperty("resourceStatus") Number resourceStatus, @JsonProperty("showMark") boolean z2, @JsonProperty("title") String title) {
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(jumpAddress, "jumpAddress");
            Intrinsics.checkNotNullParameter(jumpType, "jumpType");
            Intrinsics.checkNotNullParameter(resourceNum, "resourceNum");
            Intrinsics.checkNotNullParameter(resourceStatus, "resourceStatus");
            Intrinsics.checkNotNullParameter(title, "title");
            this.category = category;
            this.contentType = contentType;
            this.f9964id = id;
            this.imageUrl = imageUrl;
            this.jumpAddress = jumpAddress;
            this.jumpType = jumpType;
            this.needLogin = z;
            this.resourceNum = resourceNum;
            this.resourceStatus = resourceStatus;
            this.showMark = z2;
            this.title = title;
        }

        public final String getCategory() {
            return this.category;
        }

        public final String getContentType() {
            return this.contentType;
        }

        public final Number getId() {
            return this.f9964id;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getJumpAddress() {
            return this.jumpAddress;
        }

        public final String getJumpType() {
            return this.jumpType;
        }

        public final boolean getNeedLogin() {
            return this.needLogin;
        }

        public final Number getResourceNum() {
            return this.resourceNum;
        }

        public final Number getResourceStatus() {
            return this.resourceStatus;
        }

        public final boolean getShowMark() {
            return this.showMark;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0002\u0010\rJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\u000e\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0003\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006!"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$Data;", "", "recommendItems", "", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$RecommendItem;", "page", "", "name", "", "searchResults", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$SearchResultItem;", "content", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$SearchPageItem;", "(Ljava/util/List;ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getContent", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getPage", "()I", "getRecommendItems", "getSearchResults", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Data {
        private final List<SearchPageItem> content;
        private final String name;
        private final int page;
        private final List<RecommendItem> recommendItems;
        private final List<SearchResultItem> searchResults;

        public static /* synthetic */ Data copy$default(Data data, List list, int i, String str, List list2, List list3, int i2, Object obj) {
            List<RecommendItem> list4 = list;
            if ((i2 & 1) != 0) {
                list4 = data.recommendItems;
            }
            if ((i2 & 2) != 0) {
                i = data.page;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                str = data.name;
            }
            String str2 = str;
            List<SearchResultItem> list5 = list2;
            if ((i2 & 8) != 0) {
                list5 = data.searchResults;
            }
            List list6 = list5;
            List<SearchPageItem> list7 = list3;
            if ((i2 & 16) != 0) {
                list7 = data.content;
            }
            return data.copy(list4, i3, str2, list6, list7);
        }

        public final List<RecommendItem> component1() {
            return this.recommendItems;
        }

        public final int component2() {
            return this.page;
        }

        public final String component3() {
            return this.name;
        }

        public final List<SearchResultItem> component4() {
            return this.searchResults;
        }

        public final List<SearchPageItem> component5() {
            return this.content;
        }

        public final Data copy(@JsonProperty("recommendItems") List<RecommendItem> recommendItems, @JsonProperty("page") int i, @JsonProperty("name") String name, @JsonProperty("searchResults") List<SearchResultItem> searchResults, @JsonProperty("content") List<SearchPageItem> content) {
            Intrinsics.checkNotNullParameter(recommendItems, "recommendItems");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(searchResults, "searchResults");
            Intrinsics.checkNotNullParameter(content, "content");
            return new Data(recommendItems, i, name, searchResults, content);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Data) {
                Data data = (Data) obj;
                return Intrinsics.areEqual(this.recommendItems, data.recommendItems) && this.page == data.page && Intrinsics.areEqual(this.name, data.name) && Intrinsics.areEqual(this.searchResults, data.searchResults) && Intrinsics.areEqual(this.content, data.content);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.recommendItems.hashCode() * 31) + this.page) * 31) + this.name.hashCode()) * 31) + this.searchResults.hashCode()) * 31) + this.content.hashCode();
        }

        public String toString() {
            return "Data(recommendItems=" + this.recommendItems + ", page=" + this.page + ", name=" + this.name + ", searchResults=" + this.searchResults + ", content=" + this.content + ')';
        }

        public Data(@JsonProperty("recommendItems") List<RecommendItem> recommendItems, @JsonProperty("page") int i, @JsonProperty("name") String name, @JsonProperty("searchResults") List<SearchResultItem> searchResults, @JsonProperty("content") List<SearchPageItem> content) {
            Intrinsics.checkNotNullParameter(recommendItems, "recommendItems");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(searchResults, "searchResults");
            Intrinsics.checkNotNullParameter(content, "content");
            this.recommendItems = recommendItems;
            this.page = i;
            this.name = name;
            this.searchResults = searchResults;
            this.content = content;
        }

        public final List<RecommendItem> getRecommendItems() {
            return this.recommendItems;
        }

        public final int getPage() {
            return this.page;
        }

        public final String getName() {
            return this.name;
        }

        public final List<SearchResultItem> getSearchResults() {
            return this.searchResults;
        }

        public final List<SearchPageItem> getContent() {
            return this.content;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$ItemCategory;", "", NativeProtocol.WEB_DIALOG_PARAMS, "", "name", "screeningType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getParams", "getScreeningType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ItemCategory {
        private final String name;
        private final String params;
        private final String screeningType;

        public static /* synthetic */ ItemCategory copy$default(ItemCategory itemCategory, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemCategory.params;
            }
            if ((i & 2) != 0) {
                str2 = itemCategory.name;
            }
            if ((i & 4) != 0) {
                str3 = itemCategory.screeningType;
            }
            return itemCategory.copy(str, str2, str3);
        }

        public final String component1() {
            return this.params;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.screeningType;
        }

        public final ItemCategory copy(@JsonProperty("params") String params, @JsonProperty("name") String name, @JsonProperty("screeningType") String screeningType) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(screeningType, "screeningType");
            return new ItemCategory(params, name, screeningType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ItemCategory) {
                ItemCategory itemCategory = (ItemCategory) obj;
                return Intrinsics.areEqual(this.params, itemCategory.params) && Intrinsics.areEqual(this.name, itemCategory.name) && Intrinsics.areEqual(this.screeningType, itemCategory.screeningType);
            }
            return false;
        }

        public int hashCode() {
            return (((this.params.hashCode() * 31) + this.name.hashCode()) * 31) + this.screeningType.hashCode();
        }

        public String toString() {
            return "ItemCategory(params=" + this.params + ", name=" + this.name + ", screeningType=" + this.screeningType + ')';
        }

        public ItemCategory(@JsonProperty("params") String params, @JsonProperty("name") String name, @JsonProperty("screeningType") String screeningType) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(screeningType, "screeningType");
            this.params = params;
            this.name = name;
            this.screeningType = screeningType;
        }

        public final String getParams() {
            return this.params;
        }

        public final String getName() {
            return this.name;
        }

        public final String getScreeningType() {
            return this.screeningType;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$ScreenItem;", "", "id", "", "name", "", FirebaseAnalytics.Param.ITEMS, "", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$ItemCategory;", "(ILjava/lang/String;Ljava/util/List;)V", "getId", "()I", "getItems", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ScreenItem {

        /* renamed from: id */
        private final int f9965id;
        private final List<ItemCategory> items;
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ScreenItem copy$default(ScreenItem screenItem, int i, String str, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = screenItem.f9965id;
            }
            if ((i2 & 2) != 0) {
                str = screenItem.name;
            }
            if ((i2 & 4) != 0) {
                list = screenItem.items;
            }
            return screenItem.copy(i, str, list);
        }

        public final int component1() {
            return this.f9965id;
        }

        public final String component2() {
            return this.name;
        }

        public final List<ItemCategory> component3() {
            return this.items;
        }

        public final ScreenItem copy(@JsonProperty("id") int i, @JsonProperty("name") String name, @JsonProperty("items") List<ItemCategory> items) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(items, "items");
            return new ScreenItem(i, name, items);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ScreenItem) {
                ScreenItem screenItem = (ScreenItem) obj;
                return this.f9965id == screenItem.f9965id && Intrinsics.areEqual(this.name, screenItem.name) && Intrinsics.areEqual(this.items, screenItem.items);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f9965id * 31) + this.name.hashCode()) * 31) + this.items.hashCode();
        }

        public String toString() {
            return "ScreenItem(id=" + this.f9965id + ", name=" + this.name + ", items=" + this.items + ')';
        }

        public ScreenItem(@JsonProperty("id") int i, @JsonProperty("name") String name, @JsonProperty("items") List<ItemCategory> items) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(items, "items");
            this.f9965id = i;
            this.name = name;
            this.items = items;
        }

        public final int getId() {
            return this.f9965id;
        }

        public final String getName() {
            return this.name;
        }

        public final List<ItemCategory> getItems() {
            return this.items;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$DataCategory;", "", "screeningItems", "", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$ScreenItem;", "id", "", "name", "", NativeProtocol.WEB_DIALOG_PARAMS, "(Ljava/util/List;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getParams", "getScreeningItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class DataCategory {

        /* renamed from: id */
        private final int f9963id;
        private final String name;
        private final String params;
        private final List<ScreenItem> screeningItems;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataCategory copy$default(DataCategory dataCategory, List list, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = dataCategory.screeningItems;
            }
            if ((i2 & 2) != 0) {
                i = dataCategory.f9963id;
            }
            if ((i2 & 4) != 0) {
                str = dataCategory.name;
            }
            if ((i2 & 8) != 0) {
                str2 = dataCategory.params;
            }
            return dataCategory.copy(list, i, str, str2);
        }

        public final List<ScreenItem> component1() {
            return this.screeningItems;
        }

        public final int component2() {
            return this.f9963id;
        }

        public final String component3() {
            return this.name;
        }

        public final String component4() {
            return this.params;
        }

        public final DataCategory copy(@JsonProperty("screeningItems") List<ScreenItem> screeningItems, @JsonProperty("id") int i, @JsonProperty("name") String name, @JsonProperty("params") String params) {
            Intrinsics.checkNotNullParameter(screeningItems, "screeningItems");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(params, "params");
            return new DataCategory(screeningItems, i, name, params);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DataCategory) {
                DataCategory dataCategory = (DataCategory) obj;
                return Intrinsics.areEqual(this.screeningItems, dataCategory.screeningItems) && this.f9963id == dataCategory.f9963id && Intrinsics.areEqual(this.name, dataCategory.name) && Intrinsics.areEqual(this.params, dataCategory.params);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.screeningItems.hashCode() * 31) + this.f9963id) * 31) + this.name.hashCode()) * 31) + this.params.hashCode();
        }

        public String toString() {
            return "DataCategory(screeningItems=" + this.screeningItems + ", id=" + this.f9963id + ", name=" + this.name + ", params=" + this.params + ')';
        }

        public DataCategory(@JsonProperty("screeningItems") List<ScreenItem> screeningItems, @JsonProperty("id") int i, @JsonProperty("name") String name, @JsonProperty("params") String params) {
            Intrinsics.checkNotNullParameter(screeningItems, "screeningItems");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(params, "params");
            this.screeningItems = screeningItems;
            this.f9963id = i;
            this.name = name;
            this.params = params;
        }

        public final List<ScreenItem> getScreeningItems() {
            return this.screeningItems;
        }

        public final int getId() {
            return this.f9963id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getParams() {
            return this.params;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$HomeCategoryResponse;", "", "data", "", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$DataCategory;", "code", "", "(Ljava/util/List;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class HomeCategoryResponse {
        private final String code;
        private final List<DataCategory> data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HomeCategoryResponse copy$default(HomeCategoryResponse homeCategoryResponse, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = homeCategoryResponse.data;
            }
            if ((i & 2) != 0) {
                str = homeCategoryResponse.code;
            }
            return homeCategoryResponse.copy(list, str);
        }

        public final List<DataCategory> component1() {
            return this.data;
        }

        public final String component2() {
            return this.code;
        }

        public final HomeCategoryResponse copy(@JsonProperty("data") List<DataCategory> data, @JsonProperty("code") String code) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(code, "code");
            return new HomeCategoryResponse(data, code);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HomeCategoryResponse) {
                HomeCategoryResponse homeCategoryResponse = (HomeCategoryResponse) obj;
                return Intrinsics.areEqual(this.data, homeCategoryResponse.data) && Intrinsics.areEqual(this.code, homeCategoryResponse.code);
            }
            return false;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.code.hashCode();
        }

        public String toString() {
            return "HomeCategoryResponse(data=" + this.data + ", code=" + this.code + ')';
        }

        public HomeCategoryResponse(@JsonProperty("data") List<DataCategory> data, @JsonProperty("code") String code) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(code, "code");
            this.data = data;
            this.code = code;
        }

        public final List<DataCategory> getData() {
            return this.data;
        }

        public final String getCode() {
            return this.code;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$HomeResponse;", "", "data", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$Data;", "code", "", "(Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$Data;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getData", "()Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$Data;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class HomeResponse {
        private final String code;
        private final Data data;

        public static /* synthetic */ HomeResponse copy$default(HomeResponse homeResponse, Data data, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                data = homeResponse.data;
            }
            if ((i & 2) != 0) {
                str = homeResponse.code;
            }
            return homeResponse.copy(data, str);
        }

        public final Data component1() {
            return this.data;
        }

        public final String component2() {
            return this.code;
        }

        public final HomeResponse copy(@JsonProperty("data") Data data, @JsonProperty("code") String code) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(code, "code");
            return new HomeResponse(data, code);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HomeResponse) {
                HomeResponse homeResponse = (HomeResponse) obj;
                return Intrinsics.areEqual(this.data, homeResponse.data) && Intrinsics.areEqual(this.code, homeResponse.code);
            }
            return false;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.code.hashCode();
        }

        public String toString() {
            return "HomeResponse(data=" + this.data + ", code=" + this.code + ')';
        }

        public HomeResponse(@JsonProperty("data") Data data, @JsonProperty("code") String code) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(code, "code");
            this.data = data;
            this.code = code;
        }

        public final Data getData() {
            return this.data;
        }

        public final String getCode() {
            return this.code;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$LokLokSearchResponse;", "", "data", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$Data;", "code", "", "(Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$Data;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getData", "()Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$Data;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LokLokSearchResponse {
        private final String code;
        private final Data data;

        public static /* synthetic */ LokLokSearchResponse copy$default(LokLokSearchResponse lokLokSearchResponse, Data data, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                data = lokLokSearchResponse.data;
            }
            if ((i & 2) != 0) {
                str = lokLokSearchResponse.code;
            }
            return lokLokSearchResponse.copy(data, str);
        }

        public final Data component1() {
            return this.data;
        }

        public final String component2() {
            return this.code;
        }

        public final LokLokSearchResponse copy(@JsonProperty("data") Data data, @JsonProperty("code") String code) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(code, "code");
            return new LokLokSearchResponse(data, code);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LokLokSearchResponse) {
                LokLokSearchResponse lokLokSearchResponse = (LokLokSearchResponse) obj;
                return Intrinsics.areEqual(this.data, lokLokSearchResponse.data) && Intrinsics.areEqual(this.code, lokLokSearchResponse.code);
            }
            return false;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.code.hashCode();
        }

        public String toString() {
            return "LokLokSearchResponse(data=" + this.data + ", code=" + this.code + ')';
        }

        public LokLokSearchResponse(@JsonProperty("data") Data data, @JsonProperty("code") String code) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(code, "code");
            this.data = data;
            this.code = code;
        }

        public final Data getData() {
            return this.data;
        }

        public final String getCode() {
            return this.code;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$LokLokMovieDetailResponseData;", "", "data", "LLokLokMovieDetailResponse;", "code", "", "(LLokLokMovieDetailResponse;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getData", "()LLokLokMovieDetailResponse;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LokLokMovieDetailResponseData {
        private final String code;
        private final C5587LokLokMovieDetailResponse data;

        public static /* synthetic */ LokLokMovieDetailResponseData copy$default(LokLokMovieDetailResponseData lokLokMovieDetailResponseData, C5587LokLokMovieDetailResponse c5587LokLokMovieDetailResponse, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                c5587LokLokMovieDetailResponse = lokLokMovieDetailResponseData.data;
            }
            if ((i & 2) != 0) {
                str = lokLokMovieDetailResponseData.code;
            }
            return lokLokMovieDetailResponseData.copy(c5587LokLokMovieDetailResponse, str);
        }

        public final C5587LokLokMovieDetailResponse component1() {
            return this.data;
        }

        public final String component2() {
            return this.code;
        }

        public final LokLokMovieDetailResponseData copy(@JsonProperty("data") C5587LokLokMovieDetailResponse data, @JsonProperty("code") String code) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(code, "code");
            return new LokLokMovieDetailResponseData(data, code);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LokLokMovieDetailResponseData) {
                LokLokMovieDetailResponseData lokLokMovieDetailResponseData = (LokLokMovieDetailResponseData) obj;
                return Intrinsics.areEqual(this.data, lokLokMovieDetailResponseData.data) && Intrinsics.areEqual(this.code, lokLokMovieDetailResponseData.code);
            }
            return false;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.code.hashCode();
        }

        public String toString() {
            return "LokLokMovieDetailResponseData(data=" + this.data + ", code=" + this.code + ')';
        }

        public LokLokMovieDetailResponseData(@JsonProperty("data") C5587LokLokMovieDetailResponse data, @JsonProperty("code") String code) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(code, "code");
            this.data = data;
            this.code = code;
        }

        public final C5587LokLokMovieDetailResponse getData() {
            return this.data;
        }

        public final String getCode() {
            return this.code;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$LokLokSourceResponse;", "", "data", "Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$LokLokSource;", "code", "", "(Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$LokLokSource;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getData", "()Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$LokLokSource;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LokLokSourceResponse {
        private final String code;
        private final LokLokSource data;

        public static /* synthetic */ LokLokSourceResponse copy$default(LokLokSourceResponse lokLokSourceResponse, LokLokSource lokLokSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                lokLokSource = lokLokSourceResponse.data;
            }
            if ((i & 2) != 0) {
                str = lokLokSourceResponse.code;
            }
            return lokLokSourceResponse.copy(lokLokSource, str);
        }

        public final LokLokSource component1() {
            return this.data;
        }

        public final String component2() {
            return this.code;
        }

        public final LokLokSourceResponse copy(@JsonProperty("data") LokLokSource data, @JsonProperty("code") String code) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(code, "code");
            return new LokLokSourceResponse(data, code);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LokLokSourceResponse) {
                LokLokSourceResponse lokLokSourceResponse = (LokLokSourceResponse) obj;
                return Intrinsics.areEqual(this.data, lokLokSourceResponse.data) && Intrinsics.areEqual(this.code, lokLokSourceResponse.code);
            }
            return false;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.code.hashCode();
        }

        public String toString() {
            return "LokLokSourceResponse(data=" + this.data + ", code=" + this.code + ')';
        }

        public LokLokSourceResponse(@JsonProperty("data") LokLokSource data, @JsonProperty("code") String code) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(code, "code");
            this.data = data;
            this.code = code;
        }

        public final LokLokSource getData() {
            return this.data;
        }

        public final String getCode() {
            return this.code;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$LokLokSource;", "", "mediaUrl", "", "episodeId", "currentDefinition", "businessType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;)V", "getBusinessType", "()Ljava/lang/Number;", "getCurrentDefinition", "()Ljava/lang/String;", "getEpisodeId", "getMediaUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LokLokSource {
        private final Number businessType;
        private final String currentDefinition;
        private final String episodeId;
        private final String mediaUrl;

        public static /* synthetic */ LokLokSource copy$default(LokLokSource lokLokSource, String str, String str2, String str3, Number number, int i, Object obj) {
            if ((i & 1) != 0) {
                str = lokLokSource.mediaUrl;
            }
            if ((i & 2) != 0) {
                str2 = lokLokSource.episodeId;
            }
            if ((i & 4) != 0) {
                str3 = lokLokSource.currentDefinition;
            }
            if ((i & 8) != 0) {
                number = lokLokSource.businessType;
            }
            return lokLokSource.copy(str, str2, str3, number);
        }

        public final String component1() {
            return this.mediaUrl;
        }

        public final String component2() {
            return this.episodeId;
        }

        public final String component3() {
            return this.currentDefinition;
        }

        public final Number component4() {
            return this.businessType;
        }

        public final LokLokSource copy(@JsonProperty("mediaUrl") String mediaUrl, @JsonProperty("episodeId") String episodeId, @JsonProperty("currentDefinition") String currentDefinition, @JsonProperty("businessType") Number businessType) {
            Intrinsics.checkNotNullParameter(mediaUrl, "mediaUrl");
            Intrinsics.checkNotNullParameter(episodeId, "episodeId");
            Intrinsics.checkNotNullParameter(currentDefinition, "currentDefinition");
            Intrinsics.checkNotNullParameter(businessType, "businessType");
            return new LokLokSource(mediaUrl, episodeId, currentDefinition, businessType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LokLokSource) {
                LokLokSource lokLokSource = (LokLokSource) obj;
                return Intrinsics.areEqual(this.mediaUrl, lokLokSource.mediaUrl) && Intrinsics.areEqual(this.episodeId, lokLokSource.episodeId) && Intrinsics.areEqual(this.currentDefinition, lokLokSource.currentDefinition) && Intrinsics.areEqual(this.businessType, lokLokSource.businessType);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.mediaUrl.hashCode() * 31) + this.episodeId.hashCode()) * 31) + this.currentDefinition.hashCode()) * 31) + this.businessType.hashCode();
        }

        public String toString() {
            return "LokLokSource(mediaUrl=" + this.mediaUrl + ", episodeId=" + this.episodeId + ", currentDefinition=" + this.currentDefinition + ", businessType=" + this.businessType + ')';
        }

        public LokLokSource(@JsonProperty("mediaUrl") String mediaUrl, @JsonProperty("episodeId") String episodeId, @JsonProperty("currentDefinition") String currentDefinition, @JsonProperty("businessType") Number businessType) {
            Intrinsics.checkNotNullParameter(mediaUrl, "mediaUrl");
            Intrinsics.checkNotNullParameter(episodeId, "episodeId");
            Intrinsics.checkNotNullParameter(currentDefinition, "currentDefinition");
            Intrinsics.checkNotNullParameter(businessType, "businessType");
            this.mediaUrl = mediaUrl;
            this.episodeId = episodeId;
            this.currentDefinition = currentDefinition;
            this.businessType = businessType;
        }

        public final String getMediaUrl() {
            return this.mediaUrl;
        }

        public final String getEpisodeId() {
            return this.episodeId;
        }

        public final String getCurrentDefinition() {
            return this.currentDefinition;
        }

        public final Number getBusinessType() {
            return this.businessType;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006'"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$SearchResultItem;", "", "coverVerticalUrl", "", "coverHorizontalUrl", "name", "id", "", "domainType", "", "releaseTime", "sort", TypedValues.TransitionType.S_DURATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCoverHorizontalUrl", "()Ljava/lang/String;", "getCoverVerticalUrl", "getDomainType", "()I", "getDuration", "getId", "()Ljava/lang/Number;", "getName", "getReleaseTime", "getSort", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SearchResultItem {
        private final String coverHorizontalUrl;
        private final String coverVerticalUrl;
        private final int domainType;
        private final String duration;

        /* renamed from: id */
        private final Number f9966id;
        private final String name;
        private final String releaseTime;
        private final String sort;

        public final String component1() {
            return this.coverVerticalUrl;
        }

        public final String component2() {
            return this.coverHorizontalUrl;
        }

        public final String component3() {
            return this.name;
        }

        public final Number component4() {
            return this.f9966id;
        }

        public final int component5() {
            return this.domainType;
        }

        public final String component6() {
            return this.releaseTime;
        }

        public final String component7() {
            return this.sort;
        }

        public final String component8() {
            return this.duration;
        }

        public final SearchResultItem copy(@JsonProperty("coverVerticalUrl") String coverVerticalUrl, @JsonProperty("coverHorizontalUrl") String coverHorizontalUrl, @JsonProperty("name") String name, @JsonProperty("id") Number id, @JsonProperty("domainType") int i, @JsonProperty("releaseTime") String releaseTime, @JsonProperty("sort") String sort, @JsonProperty("duration") String duration) {
            Intrinsics.checkNotNullParameter(coverVerticalUrl, "coverVerticalUrl");
            Intrinsics.checkNotNullParameter(coverHorizontalUrl, "coverHorizontalUrl");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(releaseTime, "releaseTime");
            Intrinsics.checkNotNullParameter(sort, "sort");
            Intrinsics.checkNotNullParameter(duration, "duration");
            return new SearchResultItem(coverVerticalUrl, coverHorizontalUrl, name, id, i, releaseTime, sort, duration);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SearchResultItem) {
                SearchResultItem searchResultItem = (SearchResultItem) obj;
                return Intrinsics.areEqual(this.coverVerticalUrl, searchResultItem.coverVerticalUrl) && Intrinsics.areEqual(this.coverHorizontalUrl, searchResultItem.coverHorizontalUrl) && Intrinsics.areEqual(this.name, searchResultItem.name) && Intrinsics.areEqual(this.f9966id, searchResultItem.f9966id) && this.domainType == searchResultItem.domainType && Intrinsics.areEqual(this.releaseTime, searchResultItem.releaseTime) && Intrinsics.areEqual(this.sort, searchResultItem.sort) && Intrinsics.areEqual(this.duration, searchResultItem.duration);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((this.coverVerticalUrl.hashCode() * 31) + this.coverHorizontalUrl.hashCode()) * 31) + this.name.hashCode()) * 31) + this.f9966id.hashCode()) * 31) + this.domainType) * 31) + this.releaseTime.hashCode()) * 31) + this.sort.hashCode()) * 31) + this.duration.hashCode();
        }

        public String toString() {
            return "SearchResultItem(coverVerticalUrl=" + this.coverVerticalUrl + ", coverHorizontalUrl=" + this.coverHorizontalUrl + ", name=" + this.name + ", id=" + this.f9966id + ", domainType=" + this.domainType + ", releaseTime=" + this.releaseTime + ", sort=" + this.sort + ", duration=" + this.duration + ')';
        }

        public SearchResultItem(@JsonProperty("coverVerticalUrl") String coverVerticalUrl, @JsonProperty("coverHorizontalUrl") String coverHorizontalUrl, @JsonProperty("name") String name, @JsonProperty("id") Number id, @JsonProperty("domainType") int i, @JsonProperty("releaseTime") String releaseTime, @JsonProperty("sort") String sort, @JsonProperty("duration") String duration) {
            Intrinsics.checkNotNullParameter(coverVerticalUrl, "coverVerticalUrl");
            Intrinsics.checkNotNullParameter(coverHorizontalUrl, "coverHorizontalUrl");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(releaseTime, "releaseTime");
            Intrinsics.checkNotNullParameter(sort, "sort");
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.coverVerticalUrl = coverVerticalUrl;
            this.coverHorizontalUrl = coverHorizontalUrl;
            this.name = name;
            this.f9966id = id;
            this.domainType = i;
            this.releaseTime = releaseTime;
            this.sort = sort;
            this.duration = duration;
        }

        public final String getCoverVerticalUrl() {
            return this.coverVerticalUrl;
        }

        public final String getCoverHorizontalUrl() {
            return this.coverHorizontalUrl;
        }

        public final String getName() {
            return this.name;
        }

        public final Number getId() {
            return this.f9966id;
        }

        public final int getDomainType() {
            return this.domainType;
        }

        public final String getReleaseTime() {
            return this.releaseTime;
        }

        public final String getSort() {
            return this.sort;
        }

        public final String getDuration() {
            return this.duration;
        }
    }

    /* compiled from: LokLokProvider.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\tHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006$"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LokLokProvider$SearchPageItem;", "", "image", "", "introduction", "name", "contentId", "", "domainType", "", "releaseTime", "sort", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;ILjava/lang/String;Ljava/lang/String;)V", "getContentId", "()Ljava/lang/Number;", "getDomainType", "()I", "getImage", "()Ljava/lang/String;", "getIntroduction", "getName", "getReleaseTime", "getSort", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SearchPageItem {
        private final Number contentId;
        private final int domainType;
        private final String image;
        private final String introduction;
        private final String name;
        private final String releaseTime;
        private final String sort;

        public static /* synthetic */ SearchPageItem copy$default(SearchPageItem searchPageItem, String str, String str2, String str3, Number number, int i, String str4, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = searchPageItem.image;
            }
            if ((i2 & 2) != 0) {
                str2 = searchPageItem.introduction;
            }
            String str6 = str2;
            if ((i2 & 4) != 0) {
                str3 = searchPageItem.name;
            }
            String str7 = str3;
            if ((i2 & 8) != 0) {
                number = searchPageItem.contentId;
            }
            Number number2 = number;
            if ((i2 & 16) != 0) {
                i = searchPageItem.domainType;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                str4 = searchPageItem.releaseTime;
            }
            String str8 = str4;
            if ((i2 & 64) != 0) {
                str5 = searchPageItem.sort;
            }
            return searchPageItem.copy(str, str6, str7, number2, i3, str8, str5);
        }

        public final String component1() {
            return this.image;
        }

        public final String component2() {
            return this.introduction;
        }

        public final String component3() {
            return this.name;
        }

        public final Number component4() {
            return this.contentId;
        }

        public final int component5() {
            return this.domainType;
        }

        public final String component6() {
            return this.releaseTime;
        }

        public final String component7() {
            return this.sort;
        }

        public final SearchPageItem copy(@JsonProperty("image") String image, @JsonProperty("introduction") String introduction, @JsonProperty("name") String name, @JsonProperty("contentId") Number contentId, @JsonProperty("domainType") int i, @JsonProperty("releaseTime") String releaseTime, @JsonProperty("sort") String sort) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(introduction, "introduction");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(contentId, "contentId");
            Intrinsics.checkNotNullParameter(releaseTime, "releaseTime");
            Intrinsics.checkNotNullParameter(sort, "sort");
            return new SearchPageItem(image, introduction, name, contentId, i, releaseTime, sort);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SearchPageItem) {
                SearchPageItem searchPageItem = (SearchPageItem) obj;
                return Intrinsics.areEqual(this.image, searchPageItem.image) && Intrinsics.areEqual(this.introduction, searchPageItem.introduction) && Intrinsics.areEqual(this.name, searchPageItem.name) && Intrinsics.areEqual(this.contentId, searchPageItem.contentId) && this.domainType == searchPageItem.domainType && Intrinsics.areEqual(this.releaseTime, searchPageItem.releaseTime) && Intrinsics.areEqual(this.sort, searchPageItem.sort);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((this.image.hashCode() * 31) + this.introduction.hashCode()) * 31) + this.name.hashCode()) * 31) + this.contentId.hashCode()) * 31) + this.domainType) * 31) + this.releaseTime.hashCode()) * 31) + this.sort.hashCode();
        }

        public String toString() {
            return "SearchPageItem(image=" + this.image + ", introduction=" + this.introduction + ", name=" + this.name + ", contentId=" + this.contentId + ", domainType=" + this.domainType + ", releaseTime=" + this.releaseTime + ", sort=" + this.sort + ')';
        }

        public SearchPageItem(@JsonProperty("image") String image, @JsonProperty("introduction") String introduction, @JsonProperty("name") String name, @JsonProperty("contentId") Number contentId, @JsonProperty("domainType") int i, @JsonProperty("releaseTime") String releaseTime, @JsonProperty("sort") String sort) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(introduction, "introduction");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(contentId, "contentId");
            Intrinsics.checkNotNullParameter(releaseTime, "releaseTime");
            Intrinsics.checkNotNullParameter(sort, "sort");
            this.image = image;
            this.introduction = introduction;
            this.name = name;
            this.contentId = contentId;
            this.domainType = i;
            this.releaseTime = releaseTime;
            this.sort = sort;
        }

        public final String getImage() {
            return this.image;
        }

        public final String getIntroduction() {
            return this.introduction;
        }

        public final String getName() {
            return this.name;
        }

        public final Number getContentId() {
            return this.contentId;
        }

        public final int getDomainType() {
            return this.domainType;
        }

        public final String getReleaseTime() {
            return this.releaseTime;
        }

        public final String getSort() {
            return this.sort;
        }
    }

    public static /* synthetic */ MovieSearchResponse toMovieSearchResponse$default(LokLokProvider lokLokProvider, RecommendContentVOItem recommendContentVOItem, HomeParentItemAdapter.CardType cardType, int i, Object obj) {
        if ((i & 1) != 0) {
            cardType = HomeParentItemAdapter.CardType.NORMAL_CARD;
        }
        return lokLokProvider.toMovieSearchResponse(recommendContentVOItem, cardType);
    }

    public final MovieSearchResponse toMovieSearchResponse(RecommendContentVOItem recommendContentVOItem, HomeParentItemAdapter.CardType cardType) {
        Intrinsics.checkNotNullParameter(recommendContentVOItem, "<this>");
        String title = recommendContentVOItem.getTitle();
        return new MovieSearchResponse(title, recommendContentVOItem.getId() + Typography.amp + recommendContentVOItem.getCategory(), getName(), TvType.Movie, fixUrlImageHomeLokLok(recommendContentVOItem.getImageUrl(), cardType), null, Integer.valueOf(recommendContentVOItem.getId().intValue()), null, null, 384, null);
    }

    static /* synthetic */ String fixUrlImageHomeLokLok$default(LokLokProvider lokLokProvider, String str, HomeParentItemAdapter.CardType cardType, int i, Object obj) {
        if ((i & 2) != 0) {
            cardType = HomeParentItemAdapter.CardType.NORMAL_CARD;
        }
        return lokLokProvider.fixUrlImageHomeLokLok(str, cardType);
    }

    private final String fixUrlImageHomeLokLok(String str, HomeParentItemAdapter.CardType cardType) {
        int i = cardType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cardType.ordinal()];
        String str2 = (i == 1 || i == 2) ? "?imageMogr2/format/webp" : "?imageView2/1/w/380/h/532/format/webp/interlace/1/ignore-error/1/q/90!/format/webp";
        return str + str2;
    }

    static /* synthetic */ String fixUrlImageLokLok$default(LokLokProvider lokLokProvider, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return lokLokProvider.fixUrlImageLokLok(str, z);
    }

    private final String fixUrlImageLokLok(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(z ? "?imageMogr2/gravity/Center/thumbnail/750x/crop/750x421/interlace/1/background/Z3JheQ==/ignore-error/1" : "?imageView2/1/w/380/h/532/format/webp/interlace/1/ignore-error/1/q/90!/format/webp");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.util.List] */
    public final List<HomePageList> toHomePageList(HomeResponse homeResponse) {
        HomeParentItemAdapter.CardType cardType;
        Intrinsics.checkNotNullParameter(homeResponse, "<this>");
        List<RecommendItem> recommendItems = homeResponse.getData().getRecommendItems();
        if (recommendItems == null || recommendItems.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : homeResponse.getData().getRecommendItems()) {
            if (Intrinsics.areEqual(((RecommendItem) obj).getHomeSectionType(), "SINGLE_ALBUM")) {
                arrayList.add(obj);
            }
        }
        ArrayList<RecommendItem> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (RecommendItem recommendItem : arrayList2) {
            if (recommendItem.getHomeSectionId() != null && recommendItem.getHomeSectionId().intValue() == 80375) {
                cardType = HomeParentItemAdapter.CardType.BIG_CARD;
            } else if (recommendItem.getCoverType() != null && recommendItem.getCoverType().intValue() == 0) {
                cardType = HomeParentItemAdapter.CardType.LONG_WIDTH_CARD;
            } else if (recommendItem.getHomeSectionId() != null && recommendItem.getHomeSectionId().intValue() == 80393) {
                cardType = HomeParentItemAdapter.CardType.TOP_CARD;
            } else {
                cardType = HomeParentItemAdapter.CardType.NORMAL_CARD;
            }
            HomeParentItemAdapter.CardType cardType2 = cardType;
            List<RecommendContentVOItem> recommendContentVOList = recommendItem.getRecommendContentVOList();
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(recommendContentVOList, 10));
            for (RecommendContentVOItem recommendContentVOItem : recommendContentVOList) {
                arrayList4.add(toMovieSearchResponse(recommendContentVOItem, cardType2));
            }
            ArrayList arrayList5 = arrayList4;
            ArrayList subList = (cardType2 != HomeParentItemAdapter.CardType.TOP_CARD || arrayList5.size() <= 9) ? arrayList5 : arrayList5.subList(0, 9);
            Regex regex = new Regex("LokLok");
            String replace = new Regex("Loklok").replace(new Regex("LOKLOK").replace(regex.replace(recommendItem.getHomeSectionName(), getName()), getName()), getName());
            arrayList3.add(new HomePageList(replace, subList, recommendItem.getRefId() + "&0", getName(), cardType2));
        }
        return arrayList3;
    }

    public final MovieSearchResponse toMovieSearchResponse(SearchResultItem searchResultItem, String nameApi) {
        Intrinsics.checkNotNullParameter(searchResultItem, "<this>");
        Intrinsics.checkNotNullParameter(nameApi, "nameApi");
        String name = searchResultItem.getName();
        StringBuilder sb = new StringBuilder();
        sb.append(searchResultItem.getId());
        sb.append(Typography.amp);
        sb.append(searchResultItem.getDomainType());
        return new MovieSearchResponse(name, sb.toString(), nameApi, TvType.Movie, fixUrlImageLokLok$default(this, searchResultItem.getCoverVerticalUrl(), false, 2, null), null, Integer.valueOf(searchResultItem.getId().intValue()), null, null, 384, null);
    }

    public final List<SearchResponse> toListSearchResponse(LokLokSearchResponse lokLokSearchResponse) {
        Intrinsics.checkNotNullParameter(lokLokSearchResponse, "<this>");
        List<SearchResultItem> searchResults = lokLokSearchResponse.getData().getSearchResults();
        if (!(searchResults == null || searchResults.isEmpty())) {
            List<SearchResultItem> searchResults2 = lokLokSearchResponse.getData().getSearchResults();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(searchResults2, 10));
            for (SearchResultItem searchResultItem : searchResults2) {
                arrayList.add(toMovieSearchResponse(searchResultItem, getName()));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public final MovieSearchResponse toMovieSearchResponse(LikeList likeList, String nameApi) {
        Intrinsics.checkNotNullParameter(likeList, "<this>");
        Intrinsics.checkNotNullParameter(nameApi, "nameApi");
        String name = likeList.getName();
        if (name == null) {
            name = "";
        }
        String str = name;
        return new MovieSearchResponse(str, likeList.getId() + Typography.amp + likeList.getCategory(), nameApi, TvType.Movie, fixUrlImageLokLok$default(this, likeList.getCoverVerticalUrl(), false, 2, null), null, null, null, null, 448, null);
    }

    public final Episode toEpisode(EpisodeVo episodeVo, String idMovie, String category) {
        Intrinsics.checkNotNullParameter(episodeVo, "<this>");
        Intrinsics.checkNotNullParameter(idMovie, "idMovie");
        Intrinsics.checkNotNullParameter(category, "category");
        String name = episodeVo.getName();
        return new Episode(idMovie + Typography.amp + category + Typography.amp + new Gson().toJson(episodeVo), name, 1, null, null, null, null, null, 184, null);
    }

    public final MovieSearchResponse toMovieSearchResponse(SearchPageItem searchPageItem, String nameApi) {
        Intrinsics.checkNotNullParameter(searchPageItem, "<this>");
        Intrinsics.checkNotNullParameter(nameApi, "nameApi");
        String name = searchPageItem.getName();
        StringBuilder sb = new StringBuilder();
        sb.append(searchPageItem.getContentId());
        sb.append(Typography.amp);
        sb.append(searchPageItem.getDomainType());
        return new MovieSearchResponse(name, sb.toString(), nameApi, TvType.Movie, fixUrlImageLokLok$default(this, searchPageItem.getImage(), false, 2, null), null, Integer.valueOf(searchPageItem.getContentId().intValue()), null, null, 384, null);
    }

    public final List<Page> toListTvShowPage(HomeCategoryResponse homeCategoryResponse, String nameApi) {
        ArrayList arrayList;
        Object obj;
        List<ItemCategory> items;
        boolean z;
        Intrinsics.checkNotNullParameter(homeCategoryResponse, "<this>");
        Intrinsics.checkNotNullParameter(nameApi, "nameApi");
        ArrayList arrayList2 = new ArrayList();
        List<DataCategory> data = homeCategoryResponse.getData();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data, 10));
        for (DataCategory dataCategory : data) {
            if (dataCategory.getId() == 2) {
                Iterator<T> it = dataCategory.getScreeningItems().iterator();
                while (true) {
                    arrayList = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((ScreenItem) obj).getId() == 5) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                ScreenItem screenItem = (ScreenItem) obj;
                if (screenItem != null && (items = screenItem.getItems()) != null) {
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj2 : items) {
                        if (!StringsKt.isBlank(((ItemCategory) obj2).getParams())) {
                            arrayList4.add(obj2);
                        }
                    }
                    arrayList = arrayList4;
                }
                if (arrayList != null) {
                    ArrayList<ItemCategory> arrayList5 = arrayList;
                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                    for (ItemCategory itemCategory : arrayList5) {
                        arrayList6.add(new Page(itemCategory.getName(), "TV,SETI,MINISERIES,VARIETY,TALK,COMIC,DOCUMENTARY*" + itemCategory.getParams() + '*', false, nameApi, null, 16, null));
                    }
                    arrayList2.addAll(arrayList6);
                }
            }
            arrayList3.add(Unit.INSTANCE);
        }
        return arrayList2;
    }

    public final List<Page> toListMoviesPage(HomeCategoryResponse homeCategoryResponse, String nameApi) {
        ArrayList arrayList;
        Object obj;
        List<ItemCategory> items;
        boolean z;
        Intrinsics.checkNotNullParameter(homeCategoryResponse, "<this>");
        Intrinsics.checkNotNullParameter(nameApi, "nameApi");
        ArrayList arrayList2 = new ArrayList();
        List<DataCategory> data = homeCategoryResponse.getData();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data, 10));
        for (DataCategory dataCategory : data) {
            if (dataCategory.getId() == 1) {
                Iterator<T> it = dataCategory.getScreeningItems().iterator();
                while (true) {
                    arrayList = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((ScreenItem) obj).getId() == 2) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                ScreenItem screenItem = (ScreenItem) obj;
                if (screenItem != null && (items = screenItem.getItems()) != null) {
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj2 : items) {
                        if (!StringsKt.isBlank(((ItemCategory) obj2).getParams())) {
                            arrayList4.add(obj2);
                        }
                    }
                    arrayList = arrayList4;
                }
                if (arrayList != null) {
                    ArrayList<ItemCategory> arrayList5 = arrayList;
                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                    for (ItemCategory itemCategory : arrayList5) {
                        arrayList6.add(new Page(itemCategory.getName(), "MOVIE,TVSPECIAL*" + itemCategory.getParams() + '*', false, nameApi, null, 16, null));
                    }
                    arrayList2.addAll(arrayList6);
                }
            }
            arrayList3.add(Unit.INSTANCE);
        }
        return arrayList2;
    }
}
