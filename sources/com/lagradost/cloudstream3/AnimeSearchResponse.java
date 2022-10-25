package com.lagradost.cloudstream3;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b2\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B«\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0003\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u0010\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0016\b\u0003\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010;\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0017\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\"J\u0011\u0010B\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u0010HÆ\u0003J´\u0001\u0010E\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0014\b\u0003\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u00102\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0003\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\t\u0010K\u001a\u00020\nHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010)R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010 R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010)R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$¨\u0006M"}, m107d2 = {"Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "Lcom/lagradost/cloudstream3/SearchResponse;", "name", "", "url", "apiName", "type", "Lcom/lagradost/cloudstream3/TvType;", "posterUrl", "year", "", "dubStatus", "Ljava/util/EnumSet;", "Lcom/lagradost/cloudstream3/DubStatus;", "otherName", "episodes", "", "id", "quality", "Lcom/lagradost/cloudstream3/SearchQuality;", "posterHeaders", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/EnumSet;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/SearchQuality;Ljava/util/Map;)V", "getApiName", "()Ljava/lang/String;", "getDubStatus", "()Ljava/util/EnumSet;", "setDubStatus", "(Ljava/util/EnumSet;)V", "getEpisodes", "()Ljava/util/Map;", "setEpisodes", "(Ljava/util/Map;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "getOtherName", "setOtherName", "(Ljava/lang/String;)V", "getPosterHeaders", "setPosterHeaders", "getPosterUrl", "setPosterUrl", "getQuality", "()Lcom/lagradost/cloudstream3/SearchQuality;", "setQuality", "(Lcom/lagradost/cloudstream3/SearchQuality;)V", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "setType", "(Lcom/lagradost/cloudstream3/TvType;)V", "getUrl", "getYear", "setYear", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/EnumSet;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/SearchQuality;Ljava/util/Map;)Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class AnimeSearchResponse implements SearchResponse {
    private final String apiName;
    private EnumSet<DubStatus> dubStatus;
    private Map<DubStatus, Integer> episodes;

    /* renamed from: id */
    private Integer f9896id;
    private final String name;
    private String otherName;
    private Map<String, String> posterHeaders;
    private String posterUrl;
    private SearchQuality quality;
    private TvType type;
    private final String url;
    private Integer year;

    public final String component1() {
        return getName();
    }

    public final Integer component10() {
        return getId();
    }

    public final SearchQuality component11() {
        return getQuality();
    }

    public final Map<String, String> component12() {
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

    public final String component5() {
        return getPosterUrl();
    }

    public final Integer component6() {
        return this.year;
    }

    public final EnumSet<DubStatus> component7() {
        return this.dubStatus;
    }

    public final String component8() {
        return this.otherName;
    }

    public final Map<DubStatus, Integer> component9() {
        return this.episodes;
    }

    public final AnimeSearchResponse copy(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("apiName") String apiName, @JsonProperty("type") TvType tvType, @JsonProperty("posterUrl") String str, @JsonProperty("year") Integer num, @JsonProperty("dubStatus") EnumSet<DubStatus> enumSet, @JsonProperty("otherName") String str2, @JsonProperty("episodes") Map<DubStatus, Integer> episodes, @JsonProperty("id") Integer num2, @JsonProperty("quality") SearchQuality searchQuality, @JsonProperty("posterHeaders") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        return new AnimeSearchResponse(name, url, apiName, tvType, str, num, enumSet, str2, episodes, num2, searchQuality, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnimeSearchResponse) {
            AnimeSearchResponse animeSearchResponse = (AnimeSearchResponse) obj;
            return Intrinsics.areEqual(getName(), animeSearchResponse.getName()) && Intrinsics.areEqual(getUrl(), animeSearchResponse.getUrl()) && Intrinsics.areEqual(getApiName(), animeSearchResponse.getApiName()) && getType() == animeSearchResponse.getType() && Intrinsics.areEqual(getPosterUrl(), animeSearchResponse.getPosterUrl()) && Intrinsics.areEqual(this.year, animeSearchResponse.year) && Intrinsics.areEqual(this.dubStatus, animeSearchResponse.dubStatus) && Intrinsics.areEqual(this.otherName, animeSearchResponse.otherName) && Intrinsics.areEqual(this.episodes, animeSearchResponse.episodes) && Intrinsics.areEqual(getId(), animeSearchResponse.getId()) && getQuality() == animeSearchResponse.getQuality() && Intrinsics.areEqual(getPosterHeaders(), animeSearchResponse.getPosterHeaders());
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((getName().hashCode() * 31) + getUrl().hashCode()) * 31) + getApiName().hashCode()) * 31) + (getType() == null ? 0 : getType().hashCode())) * 31) + (getPosterUrl() == null ? 0 : getPosterUrl().hashCode())) * 31;
        Integer num = this.year;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        EnumSet<DubStatus> enumSet = this.dubStatus;
        int hashCode3 = (hashCode2 + (enumSet == null ? 0 : enumSet.hashCode())) * 31;
        String str = this.otherName;
        return ((((((((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.episodes.hashCode()) * 31) + (getId() == null ? 0 : getId().hashCode())) * 31) + (getQuality() == null ? 0 : getQuality().hashCode())) * 31) + (getPosterHeaders() != null ? getPosterHeaders().hashCode() : 0);
    }

    public String toString() {
        return "AnimeSearchResponse(name=" + getName() + ", url=" + getUrl() + ", apiName=" + getApiName() + ", type=" + getType() + ", posterUrl=" + getPosterUrl() + ", year=" + this.year + ", dubStatus=" + this.dubStatus + ", otherName=" + this.otherName + ", episodes=" + this.episodes + ", id=" + getId() + ", quality=" + getQuality() + ", posterHeaders=" + getPosterHeaders() + ')';
    }

    public AnimeSearchResponse(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("apiName") String apiName, @JsonProperty("type") TvType tvType, @JsonProperty("posterUrl") String str, @JsonProperty("year") Integer num, @JsonProperty("dubStatus") EnumSet<DubStatus> enumSet, @JsonProperty("otherName") String str2, @JsonProperty("episodes") Map<DubStatus, Integer> episodes, @JsonProperty("id") Integer num2, @JsonProperty("quality") SearchQuality searchQuality, @JsonProperty("posterHeaders") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        this.name = name;
        this.url = url;
        this.apiName = apiName;
        this.type = tvType;
        this.posterUrl = str;
        this.year = num;
        this.dubStatus = enumSet;
        this.otherName = str2;
        this.episodes = episodes;
        this.f9896id = num2;
        this.quality = searchQuality;
        this.posterHeaders = map;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public String getUrl() {
        return this.url;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public String getApiName() {
        return this.apiName;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public TvType getType() {
        return this.type;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public void setType(TvType tvType) {
        this.type = tvType;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public String getPosterUrl() {
        return this.posterUrl;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public void setPosterUrl(String str) {
        this.posterUrl = str;
    }

    public final Integer getYear() {
        return this.year;
    }

    public final void setYear(Integer num) {
        this.year = num;
    }

    public final EnumSet<DubStatus> getDubStatus() {
        return this.dubStatus;
    }

    public final void setDubStatus(EnumSet<DubStatus> enumSet) {
        this.dubStatus = enumSet;
    }

    public final String getOtherName() {
        return this.otherName;
    }

    public final void setOtherName(String str) {
        this.otherName = str;
    }

    public /* synthetic */ AnimeSearchResponse(String str, String str2, String str3, TvType tvType, String str4, Integer num, EnumSet enumSet, String str5, Map map, Integer num2, SearchQuality searchQuality, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : tvType, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : enumSet, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? new LinkedHashMap() : map, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : searchQuality, (i & 2048) != 0 ? null : map2);
    }

    public final Map<DubStatus, Integer> getEpisodes() {
        return this.episodes;
    }

    public final void setEpisodes(Map<DubStatus, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.episodes = map;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public Integer getId() {
        return this.f9896id;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public void setId(Integer num) {
        this.f9896id = num;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public SearchQuality getQuality() {
        return this.quality;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public void setQuality(SearchQuality searchQuality) {
        this.quality = searchQuality;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public Map<String, String> getPosterHeaders() {
        return this.posterHeaders;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public void setPosterHeaders(Map<String, String> map) {
        this.posterHeaders = map;
    }
}
