package com.lagradost.cloudstream3;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0016\b\u0003\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0017\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u0080\u0001\u00104\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0003\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\nHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0012R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016¨\u0006<"}, m107d2 = {"Lcom/lagradost/cloudstream3/MovieSearchResponse;", "Lcom/lagradost/cloudstream3/SearchResponse;", "name", "", "url", "apiName", "type", "Lcom/lagradost/cloudstream3/TvType;", "posterUrl", "year", "", "id", "quality", "Lcom/lagradost/cloudstream3/SearchQuality;", "posterHeaders", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/SearchQuality;Ljava/util/Map;)V", "getApiName", "()Ljava/lang/String;", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "getPosterHeaders", "()Ljava/util/Map;", "setPosterHeaders", "(Ljava/util/Map;)V", "getPosterUrl", "setPosterUrl", "(Ljava/lang/String;)V", "getQuality", "()Lcom/lagradost/cloudstream3/SearchQuality;", "setQuality", "(Lcom/lagradost/cloudstream3/SearchQuality;)V", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "setType", "(Lcom/lagradost/cloudstream3/TvType;)V", "getUrl", "getYear", "setYear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/SearchQuality;Ljava/util/Map;)Lcom/lagradost/cloudstream3/MovieSearchResponse;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MovieSearchResponse implements SearchResponse {
    private final String apiName;

    /* renamed from: id */
    private Integer f9900id;
    private final String name;
    private Map<String, String> posterHeaders;
    private String posterUrl;
    private SearchQuality quality;
    private TvType type;
    private final String url;
    private Integer year;

    public final String component1() {
        return getName();
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

    public final Integer component7() {
        return getId();
    }

    public final SearchQuality component8() {
        return getQuality();
    }

    public final Map<String, String> component9() {
        return getPosterHeaders();
    }

    public final MovieSearchResponse copy(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("apiName") String apiName, @JsonProperty("type") TvType tvType, @JsonProperty("posterUrl") String str, @JsonProperty("year") Integer num, @JsonProperty("id") Integer num2, @JsonProperty("quality") SearchQuality searchQuality, @JsonProperty("posterHeaders") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        return new MovieSearchResponse(name, url, apiName, tvType, str, num, num2, searchQuality, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MovieSearchResponse) {
            MovieSearchResponse movieSearchResponse = (MovieSearchResponse) obj;
            return Intrinsics.areEqual(getName(), movieSearchResponse.getName()) && Intrinsics.areEqual(getUrl(), movieSearchResponse.getUrl()) && Intrinsics.areEqual(getApiName(), movieSearchResponse.getApiName()) && getType() == movieSearchResponse.getType() && Intrinsics.areEqual(getPosterUrl(), movieSearchResponse.getPosterUrl()) && Intrinsics.areEqual(this.year, movieSearchResponse.year) && Intrinsics.areEqual(getId(), movieSearchResponse.getId()) && getQuality() == movieSearchResponse.getQuality() && Intrinsics.areEqual(getPosterHeaders(), movieSearchResponse.getPosterHeaders());
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((getName().hashCode() * 31) + getUrl().hashCode()) * 31) + getApiName().hashCode()) * 31) + (getType() == null ? 0 : getType().hashCode())) * 31) + (getPosterUrl() == null ? 0 : getPosterUrl().hashCode())) * 31;
        Integer num = this.year;
        return ((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + (getId() == null ? 0 : getId().hashCode())) * 31) + (getQuality() == null ? 0 : getQuality().hashCode())) * 31) + (getPosterHeaders() != null ? getPosterHeaders().hashCode() : 0);
    }

    public String toString() {
        return "MovieSearchResponse(name=" + getName() + ", url=" + getUrl() + ", apiName=" + getApiName() + ", type=" + getType() + ", posterUrl=" + getPosterUrl() + ", year=" + this.year + ", id=" + getId() + ", quality=" + getQuality() + ", posterHeaders=" + getPosterHeaders() + ')';
    }

    public MovieSearchResponse(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("apiName") String apiName, @JsonProperty("type") TvType tvType, @JsonProperty("posterUrl") String str, @JsonProperty("year") Integer num, @JsonProperty("id") Integer num2, @JsonProperty("quality") SearchQuality searchQuality, @JsonProperty("posterHeaders") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        this.name = name;
        this.url = url;
        this.apiName = apiName;
        this.type = tvType;
        this.posterUrl = str;
        this.year = num;
        this.f9900id = num2;
        this.quality = searchQuality;
        this.posterHeaders = map;
    }

    public /* synthetic */ MovieSearchResponse(String str, String str2, String str3, TvType tvType, String str4, Integer num, Integer num2, SearchQuality searchQuality, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : tvType, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : searchQuality, (i & 256) != 0 ? null : map);
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

    @Override // com.lagradost.cloudstream3.SearchResponse
    public Integer getId() {
        return this.f9900id;
    }

    @Override // com.lagradost.cloudstream3.SearchResponse
    public void setId(Integer num) {
        this.f9900id = num;
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
