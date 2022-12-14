package com.lagradost.cloudstream3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\bL\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001f??\u0006\u0002\u0010 J\t\u0010U\u001a\u00020\u0003H??\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\rH??\u0003??\u0006\u0002\u0010.J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH??\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\rH??\u0003??\u0006\u0002\u0010.J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH??\u0003J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\tH??\u0003J\u0011\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\tH??\u0003J\t\u0010\\\u001a\u00020\u001aH??\u0003J\u0015\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001cH??\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003H??\u0003J\u0017\u0010_\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fH??\u0003J\t\u0010`\u001a\u00020\u0003H??\u0003J\t\u0010a\u001a\u00020\u0003H??\u0003J\t\u0010b\u001a\u00020\u0007H??\u0003J\u000f\u0010c\u001a\b\u0012\u0004\u0012\u00020\n0\tH??\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003H??\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\rH??\u0003??\u0006\u0002\u0010.J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003H??\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0010H??\u0003J\u009a\u0002\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\t2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\t2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fH??\u0001??\u0006\u0002\u0010iJ\u0013\u0010j\u001a\u00020\u001a2\b\u0010k\u001a\u0004\u0018\u00010lH??\u0003J\t\u0010m\u001a\u00020\rH??\u0001J\t\u0010n\u001a\u00020\u0003H??\u0001R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\tX\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0005\u001a\u00020\u0003X\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0019\u001a\u00020\u001aX\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0096\u000e??\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e??\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\b4\u0010&\"\u0004\b5\u0010(R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fX\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0096\u000e??\u0006\u0010\n\u0002\u00101\u001a\u0004\b>\u0010.\"\u0004\b?\u00100R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\tX\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\"\"\u0004\bA\u0010$R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0096\u0004??\u0006\b\n\u0000\u001a\u0004\bB\u0010&R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e??\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001cX\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\bG\u00109\"\u0004\bH\u0010;R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\"\"\u0004\bJ\u0010$R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\"\"\u0004\bL\u0010$R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e??\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010&\"\u0004\bR\u0010(R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e??\u0006\u0010\n\u0002\u00101\u001a\u0004\bS\u0010.\"\u0004\bT\u00100??\u0006o"}, m107d2 = {"Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "Lcom/lagradost/cloudstream3/LoadResponse;", "name", "", "url", "apiName", "type", "Lcom/lagradost/cloudstream3/TvType;", "episodes", "", "Lcom/lagradost/cloudstream3/Episode;", "posterUrl", "year", "", "plot", "showStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "rating", "tags", TypedValues.TransitionType.S_DURATION, "trailers", "recommendations", "Lcom/lagradost/cloudstream3/SearchResponse;", "actors", "Lcom/lagradost/cloudstream3/ActorData;", "comingSoon", "", "syncData", "", "reviewUrl", "posterHeaders", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/ShowStatus;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/util/Map;Ljava/lang/String;Ljava/util/Map;)V", "getActors", "()Ljava/util/List;", "setActors", "(Ljava/util/List;)V", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "getComingSoon", "()Z", "setComingSoon", "(Z)V", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEpisodes", "setEpisodes", "getName", "setName", "getPlot", "setPlot", "getPosterHeaders", "()Ljava/util/Map;", "setPosterHeaders", "(Ljava/util/Map;)V", "getPosterUrl", "setPosterUrl", "getRating", "setRating", "getRecommendations", "setRecommendations", "getReviewUrl", "getShowStatus", "()Lcom/lagradost/cloudstream3/ShowStatus;", "setShowStatus", "(Lcom/lagradost/cloudstream3/ShowStatus;)V", "getSyncData", "setSyncData", "getTags", "setTags", "getTrailers", "setTrailers", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "setType", "(Lcom/lagradost/cloudstream3/TvType;)V", "getUrl", "setUrl", "getYear", "setYear", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/ShowStatus;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/util/Map;Ljava/lang/String;Ljava/util/Map;)Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "equals", "other", "", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class TvSeriesLoadResponse implements LoadResponse {
    private List<ActorData> actors;
    private String apiName;
    private boolean comingSoon;
    private Integer duration;
    private List<Episode> episodes;
    private String name;
    private String plot;
    private Map<String, String> posterHeaders;
    private String posterUrl;
    private Integer rating;
    private List<? extends SearchResponse> recommendations;
    private final String reviewUrl;
    private ShowStatus showStatus;
    private Map<String, String> syncData;
    private List<String> tags;
    private List<String> trailers;
    private TvType type;
    private String url;
    private Integer year;

    public final String component1() {
        return getName();
    }

    public final Integer component10() {
        return getRating();
    }

    public final List<String> component11() {
        return getTags();
    }

    public final Integer component12() {
        return getDuration();
    }

    public final List<String> component13() {
        return getTrailers();
    }

    public final List<SearchResponse> component14() {
        return getRecommendations();
    }

    public final List<ActorData> component15() {
        return getActors();
    }

    public final boolean component16() {
        return getComingSoon();
    }

    public final Map<String, String> component17() {
        return getSyncData();
    }

    public final String component18() {
        return getReviewUrl();
    }

    public final Map<String, String> component19() {
        return getPosterHeaders();
    }

    public final String component2() {
        return getUrl();
    }

    public final String component3() {
        return getApiName();
    }

    public final TvType component4() {
        return getType();
    }

    public final List<Episode> component5() {
        return this.episodes;
    }

    public final String component6() {
        return getPosterUrl();
    }

    public final Integer component7() {
        return getYear();
    }

    public final String component8() {
        return getPlot();
    }

    public final ShowStatus component9() {
        return this.showStatus;
    }

    public final TvSeriesLoadResponse copy(String name, String url, String apiName, TvType type, List<Episode> episodes, String str, Integer num, String str2, ShowStatus showStatus, Integer num2, List<String> list, Integer num3, List<String> list2, List<? extends SearchResponse> list3, List<ActorData> list4, boolean z, Map<String, String> syncData, String str3, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        Intrinsics.checkNotNullParameter(syncData, "syncData");
        return new TvSeriesLoadResponse(name, url, apiName, type, episodes, str, num, str2, showStatus, num2, list, num3, list2, list3, list4, z, syncData, str3, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TvSeriesLoadResponse) {
            TvSeriesLoadResponse tvSeriesLoadResponse = (TvSeriesLoadResponse) obj;
            return Intrinsics.areEqual(getName(), tvSeriesLoadResponse.getName()) && Intrinsics.areEqual(getUrl(), tvSeriesLoadResponse.getUrl()) && Intrinsics.areEqual(getApiName(), tvSeriesLoadResponse.getApiName()) && getType() == tvSeriesLoadResponse.getType() && Intrinsics.areEqual(this.episodes, tvSeriesLoadResponse.episodes) && Intrinsics.areEqual(getPosterUrl(), tvSeriesLoadResponse.getPosterUrl()) && Intrinsics.areEqual(getYear(), tvSeriesLoadResponse.getYear()) && Intrinsics.areEqual(getPlot(), tvSeriesLoadResponse.getPlot()) && this.showStatus == tvSeriesLoadResponse.showStatus && Intrinsics.areEqual(getRating(), tvSeriesLoadResponse.getRating()) && Intrinsics.areEqual(getTags(), tvSeriesLoadResponse.getTags()) && Intrinsics.areEqual(getDuration(), tvSeriesLoadResponse.getDuration()) && Intrinsics.areEqual(getTrailers(), tvSeriesLoadResponse.getTrailers()) && Intrinsics.areEqual(getRecommendations(), tvSeriesLoadResponse.getRecommendations()) && Intrinsics.areEqual(getActors(), tvSeriesLoadResponse.getActors()) && getComingSoon() == tvSeriesLoadResponse.getComingSoon() && Intrinsics.areEqual(getSyncData(), tvSeriesLoadResponse.getSyncData()) && Intrinsics.areEqual(getReviewUrl(), tvSeriesLoadResponse.getReviewUrl()) && Intrinsics.areEqual(getPosterHeaders(), tvSeriesLoadResponse.getPosterHeaders());
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((getName().hashCode() * 31) + getUrl().hashCode()) * 31) + getApiName().hashCode()) * 31) + getType().hashCode()) * 31) + this.episodes.hashCode()) * 31) + (getPosterUrl() == null ? 0 : getPosterUrl().hashCode())) * 31) + (getYear() == null ? 0 : getYear().hashCode())) * 31) + (getPlot() == null ? 0 : getPlot().hashCode())) * 31;
        ShowStatus showStatus = this.showStatus;
        int hashCode2 = (((((((((((((hashCode + (showStatus == null ? 0 : showStatus.hashCode())) * 31) + (getRating() == null ? 0 : getRating().hashCode())) * 31) + (getTags() == null ? 0 : getTags().hashCode())) * 31) + (getDuration() == null ? 0 : getDuration().hashCode())) * 31) + (getTrailers() == null ? 0 : getTrailers().hashCode())) * 31) + (getRecommendations() == null ? 0 : getRecommendations().hashCode())) * 31) + (getActors() == null ? 0 : getActors().hashCode())) * 31;
        boolean comingSoon = getComingSoon();
        int i = comingSoon;
        if (comingSoon) {
            i = 1;
        }
        return ((((((hashCode2 + i) * 31) + getSyncData().hashCode()) * 31) + (getReviewUrl() == null ? 0 : getReviewUrl().hashCode())) * 31) + (getPosterHeaders() != null ? getPosterHeaders().hashCode() : 0);
    }

    public String toString() {
        return "TvSeriesLoadResponse(name=" + getName() + ", url=" + getUrl() + ", apiName=" + getApiName() + ", type=" + getType() + ", episodes=" + this.episodes + ", posterUrl=" + getPosterUrl() + ", year=" + getYear() + ", plot=" + getPlot() + ", showStatus=" + this.showStatus + ", rating=" + getRating() + ", tags=" + getTags() + ", duration=" + getDuration() + ", trailers=" + getTrailers() + ", recommendations=" + getRecommendations() + ", actors=" + getActors() + ", comingSoon=" + getComingSoon() + ", syncData=" + getSyncData() + ", reviewUrl=" + getReviewUrl() + ", posterHeaders=" + getPosterHeaders() + ')';
    }

    public TvSeriesLoadResponse(String name, String url, String apiName, TvType type, List<Episode> episodes, String str, Integer num, String str2, ShowStatus showStatus, Integer num2, List<String> list, Integer num3, List<String> list2, List<? extends SearchResponse> list3, List<ActorData> list4, boolean z, Map<String, String> syncData, String str3, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        Intrinsics.checkNotNullParameter(syncData, "syncData");
        this.name = name;
        this.url = url;
        this.apiName = apiName;
        this.type = type;
        this.episodes = episodes;
        this.posterUrl = str;
        this.year = num;
        this.plot = str2;
        this.showStatus = showStatus;
        this.rating = num2;
        this.tags = list;
        this.duration = num3;
        this.trailers = list2;
        this.recommendations = list3;
        this.actors = list4;
        this.comingSoon = z;
        this.syncData = syncData;
        this.reviewUrl = str3;
        this.posterHeaders = map;
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

    public final List<Episode> getEpisodes() {
        return this.episodes;
    }

    public final void setEpisodes(List<Episode> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.episodes = list;
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

    @Override // com.lagradost.cloudstream3.LoadResponse
    public String getPlot() {
        return this.plot;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setPlot(String str) {
        this.plot = str;
    }

    public final ShowStatus getShowStatus() {
        return this.showStatus;
    }

    public final void setShowStatus(ShowStatus showStatus) {
        this.showStatus = showStatus;
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
    public List<String> getTags() {
        return this.tags;
    }

    @Override // com.lagradost.cloudstream3.LoadResponse
    public void setTags(List<String> list) {
        this.tags = list;
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

    public /* synthetic */ TvSeriesLoadResponse(String str, String str2, String str3, TvType tvType, List list, String str4, Integer num, String str5, ShowStatus showStatus, Integer num2, List list2, Integer num3, List list3, List list4, List list5, boolean z, Map map, String str6, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, tvType, list, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : showStatus, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : list2, (i & 2048) != 0 ? null : num3, (i & 4096) != 0 ? null : list3, (i & 8192) != 0 ? null : list4, (i & 16384) != 0 ? null : list5, (32768 & i) != 0 ? false : z, (65536 & i) != 0 ? new LinkedHashMap() : map, (131072 & i) != 0 ? null : str6, (i & 262144) != 0 ? null : map2);
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
