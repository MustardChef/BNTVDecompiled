package com.lagradost.cloudstream3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\bU\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¿\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010#¢\u0006\u0002\u0010$J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0003J\u0011\u0010c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010e\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00102J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0003J\u0011\u0010g\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0010HÆ\u0003J\u0011\u0010h\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0010HÆ\u0003J\t\u0010i\u001a\u00020\u001fHÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010m\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010#HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\tHÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00102J\u001b\u0010t\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000eHÆ\u0003JÐ\u0002\u0010u\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00102\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010#HÆ\u0001¢\u0006\u0002\u0010vJ\u0013\u0010w\u001a\u00020\u001f2\b\u0010x\u001a\u0004\u0018\u00010yHÖ\u0003J\t\u0010z\u001a\u00020\fHÖ\u0001J\t\u0010{\u001a\u00020\u0003HÖ\u0001R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0007\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u001e\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010*\"\u0004\b7\u0010,R,\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010*\"\u0004\b=\u0010,R\u001a\u0010\u0005\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010*\"\u0004\b?\u0010,R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010*\"\u0004\bA\u0010,R(\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00109\"\u0004\bC\u0010;R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010*\"\u0004\bE\u0010,R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\bF\u00102\"\u0004\bG\u00104R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010&\"\u0004\bI\u0010(R\u0016\u0010!\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010*R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR&\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00109\"\u0004\bP\u0010;R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010&\"\u0004\bR\u0010(R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010&\"\u0004\bT\u0010(R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010&\"\u0004\bV\u0010(R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010\u0006\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010*\"\u0004\b\\\u0010,R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b]\u00102\"\u0004\b^\u00104¨\u0006|"}, m107d2 = {"Lcom/lagradost/cloudstream3/AnimeLoadResponse;", "Lcom/lagradost/cloudstream3/LoadResponse;", "engName", "", "japName", "name", "url", "apiName", "type", "Lcom/lagradost/cloudstream3/TvType;", "posterUrl", "year", "", "episodes", "", "Lcom/lagradost/cloudstream3/DubStatus;", "", "Lcom/lagradost/cloudstream3/Episode;", "showStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "plot", "tags", "synonyms", "rating", TypedValues.TransitionType.S_DURATION, "trailers", "recommendations", "Lcom/lagradost/cloudstream3/SearchResponse;", "actors", "Lcom/lagradost/cloudstream3/ActorData;", "comingSoon", "", "syncData", "reviewUrl", "posterHeaders", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Lcom/lagradost/cloudstream3/ShowStatus;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/util/Map;Ljava/lang/String;Ljava/util/Map;)V", "getActors", "()Ljava/util/List;", "setActors", "(Ljava/util/List;)V", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "getComingSoon", "()Z", "setComingSoon", "(Z)V", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEngName", "setEngName", "getEpisodes", "()Ljava/util/Map;", "setEpisodes", "(Ljava/util/Map;)V", "getJapName", "setJapName", "getName", "setName", "getPlot", "setPlot", "getPosterHeaders", "setPosterHeaders", "getPosterUrl", "setPosterUrl", "getRating", "setRating", "getRecommendations", "setRecommendations", "getReviewUrl", "getShowStatus", "()Lcom/lagradost/cloudstream3/ShowStatus;", "setShowStatus", "(Lcom/lagradost/cloudstream3/ShowStatus;)V", "getSyncData", "setSyncData", "getSynonyms", "setSynonyms", "getTags", "setTags", "getTrailers", "setTrailers", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "setType", "(Lcom/lagradost/cloudstream3/TvType;)V", "getUrl", "setUrl", "getYear", "setYear", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Lcom/lagradost/cloudstream3/ShowStatus;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/util/Map;Ljava/lang/String;Ljava/util/Map;)Lcom/lagradost/cloudstream3/AnimeLoadResponse;", "equals", "other", "", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class AnimeLoadResponse implements LoadResponse {
    private List<ActorData> actors;
    private String apiName;
    private boolean comingSoon;
    private Integer duration;
    private String engName;
    private Map<DubStatus, List<Episode>> episodes;
    private String japName;
    private String name;
    private String plot;
    private Map<String, String> posterHeaders;
    private String posterUrl;
    private Integer rating;
    private List<? extends SearchResponse> recommendations;
    private final String reviewUrl;
    private ShowStatus showStatus;
    private Map<String, String> syncData;
    private List<String> synonyms;
    private List<String> tags;
    private List<String> trailers;
    private TvType type;
    private String url;
    private Integer year;

    public final String component1() {
        return this.engName;
    }

    public final ShowStatus component10() {
        return this.showStatus;
    }

    public final String component11() {
        return getPlot();
    }

    public final List<String> component12() {
        return getTags();
    }

    public final List<String> component13() {
        return this.synonyms;
    }

    public final Integer component14() {
        return getRating();
    }

    public final Integer component15() {
        return getDuration();
    }

    public final List<String> component16() {
        return getTrailers();
    }

    public final List<SearchResponse> component17() {
        return getRecommendations();
    }

    public final List<ActorData> component18() {
        return getActors();
    }

    public final boolean component19() {
        return getComingSoon();
    }

    public final String component2() {
        return this.japName;
    }

    public final Map<String, String> component20() {
        return getSyncData();
    }

    public final String component21() {
        return getReviewUrl();
    }

    public final Map<String, String> component22() {
        return getPosterHeaders();
    }

    public final String component3() {
        return getName();
    }

    public final String component4() {
        return getUrl();
    }

    public final String component5() {
        return getApiName();
    }

    public final TvType component6() {
        return getType();
    }

    public final String component7() {
        return getPosterUrl();
    }

    public final Integer component8() {
        return getYear();
    }

    public final Map<DubStatus, List<Episode>> component9() {
        return this.episodes;
    }

    public final AnimeLoadResponse copy(String str, String str2, String name, String url, String apiName, TvType type, String str3, Integer num, Map<DubStatus, List<Episode>> episodes, ShowStatus showStatus, String str4, List<String> list, List<String> list2, Integer num2, Integer num3, List<String> list3, List<? extends SearchResponse> list4, List<ActorData> list5, boolean z, Map<String, String> syncData, String str5, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        Intrinsics.checkNotNullParameter(syncData, "syncData");
        return new AnimeLoadResponse(str, str2, name, url, apiName, type, str3, num, episodes, showStatus, str4, list, list2, num2, num3, list3, list4, list5, z, syncData, str5, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnimeLoadResponse) {
            AnimeLoadResponse animeLoadResponse = (AnimeLoadResponse) obj;
            return Intrinsics.areEqual(this.engName, animeLoadResponse.engName) && Intrinsics.areEqual(this.japName, animeLoadResponse.japName) && Intrinsics.areEqual(getName(), animeLoadResponse.getName()) && Intrinsics.areEqual(getUrl(), animeLoadResponse.getUrl()) && Intrinsics.areEqual(getApiName(), animeLoadResponse.getApiName()) && getType() == animeLoadResponse.getType() && Intrinsics.areEqual(getPosterUrl(), animeLoadResponse.getPosterUrl()) && Intrinsics.areEqual(getYear(), animeLoadResponse.getYear()) && Intrinsics.areEqual(this.episodes, animeLoadResponse.episodes) && this.showStatus == animeLoadResponse.showStatus && Intrinsics.areEqual(getPlot(), animeLoadResponse.getPlot()) && Intrinsics.areEqual(getTags(), animeLoadResponse.getTags()) && Intrinsics.areEqual(this.synonyms, animeLoadResponse.synonyms) && Intrinsics.areEqual(getRating(), animeLoadResponse.getRating()) && Intrinsics.areEqual(getDuration(), animeLoadResponse.getDuration()) && Intrinsics.areEqual(getTrailers(), animeLoadResponse.getTrailers()) && Intrinsics.areEqual(getRecommendations(), animeLoadResponse.getRecommendations()) && Intrinsics.areEqual(getActors(), animeLoadResponse.getActors()) && getComingSoon() == animeLoadResponse.getComingSoon() && Intrinsics.areEqual(getSyncData(), animeLoadResponse.getSyncData()) && Intrinsics.areEqual(getReviewUrl(), animeLoadResponse.getReviewUrl()) && Intrinsics.areEqual(getPosterHeaders(), animeLoadResponse.getPosterHeaders());
        }
        return false;
    }

    public int hashCode() {
        String str = this.engName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.japName;
        int hashCode2 = (((((((((((((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + getName().hashCode()) * 31) + getUrl().hashCode()) * 31) + getApiName().hashCode()) * 31) + getType().hashCode()) * 31) + (getPosterUrl() == null ? 0 : getPosterUrl().hashCode())) * 31) + (getYear() == null ? 0 : getYear().hashCode())) * 31) + this.episodes.hashCode()) * 31;
        ShowStatus showStatus = this.showStatus;
        int hashCode3 = (((((hashCode2 + (showStatus == null ? 0 : showStatus.hashCode())) * 31) + (getPlot() == null ? 0 : getPlot().hashCode())) * 31) + (getTags() == null ? 0 : getTags().hashCode())) * 31;
        List<String> list = this.synonyms;
        int hashCode4 = (((((((((((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + (getRating() == null ? 0 : getRating().hashCode())) * 31) + (getDuration() == null ? 0 : getDuration().hashCode())) * 31) + (getTrailers() == null ? 0 : getTrailers().hashCode())) * 31) + (getRecommendations() == null ? 0 : getRecommendations().hashCode())) * 31) + (getActors() == null ? 0 : getActors().hashCode())) * 31;
        boolean comingSoon = getComingSoon();
        int i = comingSoon;
        if (comingSoon) {
            i = 1;
        }
        return ((((((hashCode4 + i) * 31) + getSyncData().hashCode()) * 31) + (getReviewUrl() == null ? 0 : getReviewUrl().hashCode())) * 31) + (getPosterHeaders() != null ? getPosterHeaders().hashCode() : 0);
    }

    public String toString() {
        return "AnimeLoadResponse(engName=" + this.engName + ", japName=" + this.japName + ", name=" + getName() + ", url=" + getUrl() + ", apiName=" + getApiName() + ", type=" + getType() + ", posterUrl=" + getPosterUrl() + ", year=" + getYear() + ", episodes=" + this.episodes + ", showStatus=" + this.showStatus + ", plot=" + getPlot() + ", tags=" + getTags() + ", synonyms=" + this.synonyms + ", rating=" + getRating() + ", duration=" + getDuration() + ", trailers=" + getTrailers() + ", recommendations=" + getRecommendations() + ", actors=" + getActors() + ", comingSoon=" + getComingSoon() + ", syncData=" + getSyncData() + ", reviewUrl=" + getReviewUrl() + ", posterHeaders=" + getPosterHeaders() + ')';
    }

    public AnimeLoadResponse(String str, String str2, String name, String url, String apiName, TvType type, String str3, Integer num, Map<DubStatus, List<Episode>> episodes, ShowStatus showStatus, String str4, List<String> list, List<String> list2, Integer num2, Integer num3, List<String> list3, List<? extends SearchResponse> list4, List<ActorData> list5, boolean z, Map<String, String> syncData, String str5, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        Intrinsics.checkNotNullParameter(syncData, "syncData");
        this.engName = str;
        this.japName = str2;
        this.name = name;
        this.url = url;
        this.apiName = apiName;
        this.type = type;
        this.posterUrl = str3;
        this.year = num;
        this.episodes = episodes;
        this.showStatus = showStatus;
        this.plot = str4;
        this.tags = list;
        this.synonyms = list2;
        this.rating = num2;
        this.duration = num3;
        this.trailers = list3;
        this.recommendations = list4;
        this.actors = list5;
        this.comingSoon = z;
        this.syncData = syncData;
        this.reviewUrl = str5;
        this.posterHeaders = map;
    }

    public final String getEngName() {
        return this.engName;
    }

    public final void setEngName(String str) {
        this.engName = str;
    }

    public final String getJapName() {
        return this.japName;
    }

    public final void setJapName(String str) {
        this.japName = str;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public String getUrl() {
        return this.url;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public String getApiName() {
        return this.apiName;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setApiName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.apiName = str;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public TvType getType() {
        return this.type;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setType(TvType tvType) {
        Intrinsics.checkNotNullParameter(tvType, "<set-?>");
        this.type = tvType;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public String getPosterUrl() {
        return this.posterUrl;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setPosterUrl(String str) {
        this.posterUrl = str;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public Integer getYear() {
        return this.year;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setYear(Integer num) {
        this.year = num;
    }

    public /* synthetic */ AnimeLoadResponse(String str, String str2, String str3, String str4, String str5, TvType tvType, String str6, Integer num, Map map, ShowStatus showStatus, String str7, List list, List list2, Integer num2, Integer num3, List list3, List list4, List list5, boolean z, Map map2, String str8, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, str3, str4, str5, tvType, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : num, (i & 256) != 0 ? new LinkedHashMap() : map, (i & 512) != 0 ? null : showStatus, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : list, (i & 4096) != 0 ? null : list2, (i & 8192) != 0 ? null : num2, (i & 16384) != 0 ? null : num3, (32768 & i) != 0 ? null : list3, (65536 & i) != 0 ? null : list4, (131072 & i) != 0 ? null : list5, (262144 & i) != 0 ? false : z, (524288 & i) != 0 ? new LinkedHashMap() : map2, (1048576 & i) != 0 ? null : str8, (i & 2097152) != 0 ? null : map3);
    }

    public final Map<DubStatus, List<Episode>> getEpisodes() {
        return this.episodes;
    }

    public final void setEpisodes(Map<DubStatus, List<Episode>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.episodes = map;
    }

    public final ShowStatus getShowStatus() {
        return this.showStatus;
    }

    public final void setShowStatus(ShowStatus showStatus) {
        this.showStatus = showStatus;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public String getPlot() {
        return this.plot;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setPlot(String str) {
        this.plot = str;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public List<String> getTags() {
        return this.tags;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setTags(List<String> list) {
        this.tags = list;
    }

    public final List<String> getSynonyms() {
        return this.synonyms;
    }

    public final void setSynonyms(List<String> list) {
        this.synonyms = list;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public Integer getRating() {
        return this.rating;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setRating(Integer num) {
        this.rating = num;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public Integer getDuration() {
        return this.duration;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setDuration(Integer num) {
        this.duration = num;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public List<String> getTrailers() {
        return this.trailers;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setTrailers(List<String> list) {
        this.trailers = list;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public List<SearchResponse> getRecommendations() {
        return this.recommendations;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setRecommendations(List<? extends SearchResponse> list) {
        this.recommendations = list;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public List<ActorData> getActors() {
        return this.actors;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setActors(List<ActorData> list) {
        this.actors = list;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public boolean getComingSoon() {
        return this.comingSoon;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setComingSoon(boolean z) {
        this.comingSoon = z;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public Map<String, String> getSyncData() {
        return this.syncData;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setSyncData(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.syncData = map;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public String getReviewUrl() {
        return this.reviewUrl;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public Map<String, String> getPosterHeaders() {
        return this.posterHeaders;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setPosterHeaders(Map<String, String> map) {
        this.posterHeaders = map;
    }
}
