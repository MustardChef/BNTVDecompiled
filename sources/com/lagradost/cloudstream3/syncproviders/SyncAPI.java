package com.lagradost.cloudstream3.syncproviders;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.TvType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SyncAPI.kt */
@Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0004\u0016\u0017\u0018\u0019J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ!\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/SyncAPI;", "Lcom/lagradost/cloudstream3/syncproviders/OAuth2API;", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "getIdFromUrl", "url", "getResult", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncResult;", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;", "score", "", "status", "(Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;", "name", "SyncNextAiring", "SyncResult", "SyncSearchResult", "SyncStatus", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public interface SyncAPI extends OAuth2API {
    String getIdFromUrl(String str);

    String getMainUrl();

    Object getResult(String str, Continuation<? super SyncResult> continuation);

    Object getStatus(String str, Continuation<? super SyncStatus> continuation);

    Object score(String str, SyncStatus syncStatus, Continuation<? super Boolean> continuation);

    Object search(String str, Continuation<? super List<SyncSearchResult>> continuation);

    /* compiled from: SyncAPI.kt */
    @Metadata(m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0017\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0014J~\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u000fHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0012¨\u0006<"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;", "Lcom/lagradost/cloudstream3/SearchResponse;", "name", "", "apiName", "syncId", "url", "posterUrl", "type", "Lcom/lagradost/cloudstream3/TvType;", "quality", "Lcom/lagradost/cloudstream3/SearchQuality;", "posterHeaders", "", "id", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Lcom/lagradost/cloudstream3/SearchQuality;Ljava/util/Map;Ljava/lang/Integer;)V", "getApiName", "()Ljava/lang/String;", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "getPosterHeaders", "()Ljava/util/Map;", "setPosterHeaders", "(Ljava/util/Map;)V", "getPosterUrl", "setPosterUrl", "(Ljava/lang/String;)V", "getQuality", "()Lcom/lagradost/cloudstream3/SearchQuality;", "setQuality", "(Lcom/lagradost/cloudstream3/SearchQuality;)V", "getSyncId", "setSyncId", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "setType", "(Lcom/lagradost/cloudstream3/TvType;)V", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Lcom/lagradost/cloudstream3/SearchQuality;Ljava/util/Map;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SyncSearchResult implements SearchResponse {
        private final String apiName;

        /* renamed from: id */
        private Integer f9991id;
        private final String name;
        private Map<String, String> posterHeaders;
        private String posterUrl;
        private SearchQuality quality;
        private String syncId;
        private TvType type;
        private final String url;

        public final String component1() {
            return getName();
        }

        public final String component2() {
            return getApiName();
        }

        public final String component3() {
            return this.syncId;
        }

        public final String component4() {
            return getUrl();
        }

        public final String component5() {
            return getPosterUrl();
        }

        public final TvType component6() {
            return getType();
        }

        public final SearchQuality component7() {
            return getQuality();
        }

        public final Map<String, String> component8() {
            return getPosterHeaders();
        }

        public final Integer component9() {
            return getId();
        }

        public final SyncSearchResult copy(String name, String apiName, String syncId, String url, String str, TvType tvType, SearchQuality searchQuality, Map<String, String> map, Integer num) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(apiName, "apiName");
            Intrinsics.checkNotNullParameter(syncId, "syncId");
            Intrinsics.checkNotNullParameter(url, "url");
            return new SyncSearchResult(name, apiName, syncId, url, str, tvType, searchQuality, map, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SyncSearchResult) {
                SyncSearchResult syncSearchResult = (SyncSearchResult) obj;
                return Intrinsics.areEqual(getName(), syncSearchResult.getName()) && Intrinsics.areEqual(getApiName(), syncSearchResult.getApiName()) && Intrinsics.areEqual(this.syncId, syncSearchResult.syncId) && Intrinsics.areEqual(getUrl(), syncSearchResult.getUrl()) && Intrinsics.areEqual(getPosterUrl(), syncSearchResult.getPosterUrl()) && getType() == syncSearchResult.getType() && getQuality() == syncSearchResult.getQuality() && Intrinsics.areEqual(getPosterHeaders(), syncSearchResult.getPosterHeaders()) && Intrinsics.areEqual(getId(), syncSearchResult.getId());
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((getName().hashCode() * 31) + getApiName().hashCode()) * 31) + this.syncId.hashCode()) * 31) + getUrl().hashCode()) * 31) + (getPosterUrl() == null ? 0 : getPosterUrl().hashCode())) * 31) + (getType() == null ? 0 : getType().hashCode())) * 31) + (getQuality() == null ? 0 : getQuality().hashCode())) * 31) + (getPosterHeaders() == null ? 0 : getPosterHeaders().hashCode())) * 31) + (getId() != null ? getId().hashCode() : 0);
        }

        public String toString() {
            return "SyncSearchResult(name=" + getName() + ", apiName=" + getApiName() + ", syncId=" + this.syncId + ", url=" + getUrl() + ", posterUrl=" + getPosterUrl() + ", type=" + getType() + ", quality=" + getQuality() + ", posterHeaders=" + getPosterHeaders() + ", id=" + getId() + ')';
        }

        public SyncSearchResult(String name, String apiName, String syncId, String url, String str, TvType tvType, SearchQuality searchQuality, Map<String, String> map, Integer num) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(apiName, "apiName");
            Intrinsics.checkNotNullParameter(syncId, "syncId");
            Intrinsics.checkNotNullParameter(url, "url");
            this.name = name;
            this.apiName = apiName;
            this.syncId = syncId;
            this.url = url;
            this.posterUrl = str;
            this.type = tvType;
            this.quality = searchQuality;
            this.posterHeaders = map;
            this.f9991id = num;
        }

        public /* synthetic */ SyncSearchResult(String str, String str2, String str3, String str4, String str5, TvType tvType, SearchQuality searchQuality, Map map, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, (i & 32) != 0 ? null : tvType, (i & 64) != 0 ? null : searchQuality, (i & 128) != 0 ? null : map, (i & 256) != 0 ? null : num);
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getName() {
            return this.name;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getApiName() {
            return this.apiName;
        }

        public final String getSyncId() {
            return this.syncId;
        }

        public final void setSyncId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.syncId = str;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getUrl() {
            return this.url;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getPosterUrl() {
            return this.posterUrl;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setPosterUrl(String str) {
            this.posterUrl = str;
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

        @Override // com.lagradost.cloudstream3.SearchResponse
        public Integer getId() {
            return this.f9991id;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setId(Integer num) {
            this.f9991id = num;
        }
    }

    /* compiled from: SyncAPI.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncNextAiring;", "", "episode", "", "unixTime", "", "(IJ)V", "getEpisode", "()I", "getUnixTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SyncNextAiring {
        private final int episode;
        private final long unixTime;

        public static /* synthetic */ SyncNextAiring copy$default(SyncNextAiring syncNextAiring, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = syncNextAiring.episode;
            }
            if ((i2 & 2) != 0) {
                j = syncNextAiring.unixTime;
            }
            return syncNextAiring.copy(i, j);
        }

        public final int component1() {
            return this.episode;
        }

        public final long component2() {
            return this.unixTime;
        }

        public final SyncNextAiring copy(int i, long j) {
            return new SyncNextAiring(i, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SyncNextAiring) {
                SyncNextAiring syncNextAiring = (SyncNextAiring) obj;
                return this.episode == syncNextAiring.episode && this.unixTime == syncNextAiring.unixTime;
            }
            return false;
        }

        public int hashCode() {
            return (this.episode * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.unixTime);
        }

        public String toString() {
            return "SyncNextAiring(episode=" + this.episode + ", unixTime=" + this.unixTime + ')';
        }

        public SyncNextAiring(int i, long j) {
            this.episode = i;
            this.unixTime = j;
        }

        public final int getEpisode() {
            return this.episode;
        }

        public final long getUnixTime() {
            return this.unixTime;
        }
    }

    /* compiled from: SyncAPI.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJH\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0006\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u000f¨\u0006#"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;", "", "status", "", "score", "watchedEpisodes", "isFavorite", "", "maxEpisodes", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "()Ljava/lang/Boolean;", "setFavorite", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMaxEpisodes", "()Ljava/lang/Integer;", "setMaxEpisodes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getScore", "getStatus", "()I", "getWatchedEpisodes", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;", "equals", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SyncStatus {
        private Boolean isFavorite;
        private Integer maxEpisodes;
        private final Integer score;
        private final int status;
        private final Integer watchedEpisodes;

        public static /* synthetic */ SyncStatus copy$default(SyncStatus syncStatus, int i, Integer num, Integer num2, Boolean bool, Integer num3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = syncStatus.status;
            }
            if ((i2 & 2) != 0) {
                num = syncStatus.score;
            }
            Integer num4 = num;
            if ((i2 & 4) != 0) {
                num2 = syncStatus.watchedEpisodes;
            }
            Integer num5 = num2;
            if ((i2 & 8) != 0) {
                bool = syncStatus.isFavorite;
            }
            Boolean bool2 = bool;
            if ((i2 & 16) != 0) {
                num3 = syncStatus.maxEpisodes;
            }
            return syncStatus.copy(i, num4, num5, bool2, num3);
        }

        public final int component1() {
            return this.status;
        }

        public final Integer component2() {
            return this.score;
        }

        public final Integer component3() {
            return this.watchedEpisodes;
        }

        public final Boolean component4() {
            return this.isFavorite;
        }

        public final Integer component5() {
            return this.maxEpisodes;
        }

        public final SyncStatus copy(int i, Integer num, Integer num2, Boolean bool, Integer num3) {
            return new SyncStatus(i, num, num2, bool, num3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SyncStatus) {
                SyncStatus syncStatus = (SyncStatus) obj;
                return this.status == syncStatus.status && Intrinsics.areEqual(this.score, syncStatus.score) && Intrinsics.areEqual(this.watchedEpisodes, syncStatus.watchedEpisodes) && Intrinsics.areEqual(this.isFavorite, syncStatus.isFavorite) && Intrinsics.areEqual(this.maxEpisodes, syncStatus.maxEpisodes);
            }
            return false;
        }

        public int hashCode() {
            int i = this.status * 31;
            Integer num = this.score;
            int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.watchedEpisodes;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Boolean bool = this.isFavorite;
            int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            Integer num3 = this.maxEpisodes;
            return hashCode3 + (num3 != null ? num3.hashCode() : 0);
        }

        public String toString() {
            return "SyncStatus(status=" + this.status + ", score=" + this.score + ", watchedEpisodes=" + this.watchedEpisodes + ", isFavorite=" + this.isFavorite + ", maxEpisodes=" + this.maxEpisodes + ')';
        }

        public SyncStatus(int i, Integer num, Integer num2, Boolean bool, Integer num3) {
            this.status = i;
            this.score = num;
            this.watchedEpisodes = num2;
            this.isFavorite = bool;
            this.maxEpisodes = num3;
        }

        public /* synthetic */ SyncStatus(int i, Integer num, Integer num2, Boolean bool, Integer num3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, num, num2, (i2 & 8) != 0 ? null : bool, (i2 & 16) != 0 ? null : num3);
        }

        public final int getStatus() {
            return this.status;
        }

        public final Integer getScore() {
            return this.score;
        }

        public final Integer getWatchedEpisodes() {
            return this.watchedEpisodes;
        }

        public final Boolean isFavorite() {
            return this.isFavorite;
        }

        public final void setFavorite(Boolean bool) {
            this.isFavorite = bool;
        }

        public final Integer getMaxEpisodes() {
            return this.maxEpisodes;
        }

        public final void setMaxEpisodes(Integer num) {
            this.maxEpisodes = num;
        }
    }

    /* compiled from: SyncAPI.kt */
    @Metadata(m108d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bY\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000f¢\u0006\u0002\u0010 J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\u0011\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u0011\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010;J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010e\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00103J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000fHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010i\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0011\u0010j\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000fHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0011\u0010q\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J¦\u0002\u0010r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010sJ\u0013\u0010t\u001a\u00020\u00142\b\u0010u\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010v\u001a\u00020\u0005HÖ\u0001J\t\u0010w\u001a\u00020\u0003HÖ\u0001R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010*\"\u0004\b:\u0010,R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b\u0013\u0010;\"\u0004\b<\u0010=R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010*\"\u0004\bH\u0010,R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010D\"\u0004\bJ\u0010FR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\bK\u0010.\"\u0004\bL\u00100R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\"\"\u0004\bN\u0010$R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\bO\u00103\"\u0004\bP\u00105R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\"\"\u0004\bR\u0010$R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\"\"\u0004\bT\u0010$R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010*\"\u0004\bV\u0010,R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010*\"\u0004\bX\u0010,R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\bY\u0010.\"\u0004\bZ\u00100R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010*\"\u0004\b\\\u0010,¨\u0006x"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncResult;", "", "id", "", "totalEpisodes", "", "title", "publicScore", TypedValues.TransitionType.S_DURATION, "synopsis", "airStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "nextAiring", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncNextAiring;", "studio", "", "genres", "synonyms", "trailerUrl", "isAdult", "", "posterUrl", "backgroundPosterUrl", "startDate", "", "endDate", "recommendations", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;", "nextSeason", "prevSeason", "actors", "Lcom/lagradost/cloudstream3/ActorData;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/ShowStatus;Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncNextAiring;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;Ljava/util/List;)V", "getActors", "()Ljava/util/List;", "setActors", "(Ljava/util/List;)V", "getAirStatus", "()Lcom/lagradost/cloudstream3/ShowStatus;", "setAirStatus", "(Lcom/lagradost/cloudstream3/ShowStatus;)V", "getBackgroundPosterUrl", "()Ljava/lang/String;", "setBackgroundPosterUrl", "(Ljava/lang/String;)V", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEndDate", "()Ljava/lang/Long;", "setEndDate", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getGenres", "setGenres", "getId", "setId", "()Ljava/lang/Boolean;", "setAdult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNextAiring", "()Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncNextAiring;", "setNextAiring", "(Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncNextAiring;)V", "getNextSeason", "()Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;", "setNextSeason", "(Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;)V", "getPosterUrl", "setPosterUrl", "getPrevSeason", "setPrevSeason", "getPublicScore", "setPublicScore", "getRecommendations", "setRecommendations", "getStartDate", "setStartDate", "getStudio", "setStudio", "getSynonyms", "setSynonyms", "getSynopsis", "setSynopsis", "getTitle", "setTitle", "getTotalEpisodes", "setTotalEpisodes", "getTrailerUrl", "setTrailerUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/ShowStatus;Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncNextAiring;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;Ljava/util/List;)Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncResult;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SyncResult {
        private List<ActorData> actors;
        private ShowStatus airStatus;
        private String backgroundPosterUrl;
        private Integer duration;
        private Long endDate;
        private List<String> genres;

        /* renamed from: id */
        private String f9990id;
        private Boolean isAdult;
        private SyncNextAiring nextAiring;
        private SyncSearchResult nextSeason;
        private String posterUrl;
        private SyncSearchResult prevSeason;
        private Integer publicScore;
        private List<SyncSearchResult> recommendations;
        private Long startDate;
        private List<String> studio;
        private List<String> synonyms;
        private String synopsis;
        private String title;
        private Integer totalEpisodes;
        private String trailerUrl;

        public final String component1() {
            return this.f9990id;
        }

        public final List<String> component10() {
            return this.genres;
        }

        public final List<String> component11() {
            return this.synonyms;
        }

        public final String component12() {
            return this.trailerUrl;
        }

        public final Boolean component13() {
            return this.isAdult;
        }

        public final String component14() {
            return this.posterUrl;
        }

        public final String component15() {
            return this.backgroundPosterUrl;
        }

        public final Long component16() {
            return this.startDate;
        }

        public final Long component17() {
            return this.endDate;
        }

        public final List<SyncSearchResult> component18() {
            return this.recommendations;
        }

        public final SyncSearchResult component19() {
            return this.nextSeason;
        }

        public final Integer component2() {
            return this.totalEpisodes;
        }

        public final SyncSearchResult component20() {
            return this.prevSeason;
        }

        public final List<ActorData> component21() {
            return this.actors;
        }

        public final String component3() {
            return this.title;
        }

        public final Integer component4() {
            return this.publicScore;
        }

        public final Integer component5() {
            return this.duration;
        }

        public final String component6() {
            return this.synopsis;
        }

        public final ShowStatus component7() {
            return this.airStatus;
        }

        public final SyncNextAiring component8() {
            return this.nextAiring;
        }

        public final List<String> component9() {
            return this.studio;
        }

        public final SyncResult copy(String id, Integer num, String str, Integer num2, Integer num3, String str2, ShowStatus showStatus, SyncNextAiring syncNextAiring, List<String> list, List<String> list2, List<String> list3, String str3, Boolean bool, String str4, String str5, Long l, Long l2, List<SyncSearchResult> list4, SyncSearchResult syncSearchResult, SyncSearchResult syncSearchResult2, List<ActorData> list5) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new SyncResult(id, num, str, num2, num3, str2, showStatus, syncNextAiring, list, list2, list3, str3, bool, str4, str5, l, l2, list4, syncSearchResult, syncSearchResult2, list5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SyncResult) {
                SyncResult syncResult = (SyncResult) obj;
                return Intrinsics.areEqual(this.f9990id, syncResult.f9990id) && Intrinsics.areEqual(this.totalEpisodes, syncResult.totalEpisodes) && Intrinsics.areEqual(this.title, syncResult.title) && Intrinsics.areEqual(this.publicScore, syncResult.publicScore) && Intrinsics.areEqual(this.duration, syncResult.duration) && Intrinsics.areEqual(this.synopsis, syncResult.synopsis) && this.airStatus == syncResult.airStatus && Intrinsics.areEqual(this.nextAiring, syncResult.nextAiring) && Intrinsics.areEqual(this.studio, syncResult.studio) && Intrinsics.areEqual(this.genres, syncResult.genres) && Intrinsics.areEqual(this.synonyms, syncResult.synonyms) && Intrinsics.areEqual(this.trailerUrl, syncResult.trailerUrl) && Intrinsics.areEqual(this.isAdult, syncResult.isAdult) && Intrinsics.areEqual(this.posterUrl, syncResult.posterUrl) && Intrinsics.areEqual(this.backgroundPosterUrl, syncResult.backgroundPosterUrl) && Intrinsics.areEqual(this.startDate, syncResult.startDate) && Intrinsics.areEqual(this.endDate, syncResult.endDate) && Intrinsics.areEqual(this.recommendations, syncResult.recommendations) && Intrinsics.areEqual(this.nextSeason, syncResult.nextSeason) && Intrinsics.areEqual(this.prevSeason, syncResult.prevSeason) && Intrinsics.areEqual(this.actors, syncResult.actors);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f9990id.hashCode() * 31;
            Integer num = this.totalEpisodes;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.title;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num2 = this.publicScore;
            int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.duration;
            int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str2 = this.synopsis;
            int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
            ShowStatus showStatus = this.airStatus;
            int hashCode7 = (hashCode6 + (showStatus == null ? 0 : showStatus.hashCode())) * 31;
            SyncNextAiring syncNextAiring = this.nextAiring;
            int hashCode8 = (hashCode7 + (syncNextAiring == null ? 0 : syncNextAiring.hashCode())) * 31;
            List<String> list = this.studio;
            int hashCode9 = (hashCode8 + (list == null ? 0 : list.hashCode())) * 31;
            List<String> list2 = this.genres;
            int hashCode10 = (hashCode9 + (list2 == null ? 0 : list2.hashCode())) * 31;
            List<String> list3 = this.synonyms;
            int hashCode11 = (hashCode10 + (list3 == null ? 0 : list3.hashCode())) * 31;
            String str3 = this.trailerUrl;
            int hashCode12 = (hashCode11 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.isAdult;
            int hashCode13 = (hashCode12 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str4 = this.posterUrl;
            int hashCode14 = (hashCode13 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.backgroundPosterUrl;
            int hashCode15 = (hashCode14 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Long l = this.startDate;
            int hashCode16 = (hashCode15 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.endDate;
            int hashCode17 = (hashCode16 + (l2 == null ? 0 : l2.hashCode())) * 31;
            List<SyncSearchResult> list4 = this.recommendations;
            int hashCode18 = (hashCode17 + (list4 == null ? 0 : list4.hashCode())) * 31;
            SyncSearchResult syncSearchResult = this.nextSeason;
            int hashCode19 = (hashCode18 + (syncSearchResult == null ? 0 : syncSearchResult.hashCode())) * 31;
            SyncSearchResult syncSearchResult2 = this.prevSeason;
            int hashCode20 = (hashCode19 + (syncSearchResult2 == null ? 0 : syncSearchResult2.hashCode())) * 31;
            List<ActorData> list5 = this.actors;
            return hashCode20 + (list5 != null ? list5.hashCode() : 0);
        }

        public String toString() {
            return "SyncResult(id=" + this.f9990id + ", totalEpisodes=" + this.totalEpisodes + ", title=" + this.title + ", publicScore=" + this.publicScore + ", duration=" + this.duration + ", synopsis=" + this.synopsis + ", airStatus=" + this.airStatus + ", nextAiring=" + this.nextAiring + ", studio=" + this.studio + ", genres=" + this.genres + ", synonyms=" + this.synonyms + ", trailerUrl=" + this.trailerUrl + ", isAdult=" + this.isAdult + ", posterUrl=" + this.posterUrl + ", backgroundPosterUrl=" + this.backgroundPosterUrl + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", recommendations=" + this.recommendations + ", nextSeason=" + this.nextSeason + ", prevSeason=" + this.prevSeason + ", actors=" + this.actors + ')';
        }

        public SyncResult(String id, Integer num, String str, Integer num2, Integer num3, String str2, ShowStatus showStatus, SyncNextAiring syncNextAiring, List<String> list, List<String> list2, List<String> list3, String str3, Boolean bool, String str4, String str5, Long l, Long l2, List<SyncSearchResult> list4, SyncSearchResult syncSearchResult, SyncSearchResult syncSearchResult2, List<ActorData> list5) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.f9990id = id;
            this.totalEpisodes = num;
            this.title = str;
            this.publicScore = num2;
            this.duration = num3;
            this.synopsis = str2;
            this.airStatus = showStatus;
            this.nextAiring = syncNextAiring;
            this.studio = list;
            this.genres = list2;
            this.synonyms = list3;
            this.trailerUrl = str3;
            this.isAdult = bool;
            this.posterUrl = str4;
            this.backgroundPosterUrl = str5;
            this.startDate = l;
            this.endDate = l2;
            this.recommendations = list4;
            this.nextSeason = syncSearchResult;
            this.prevSeason = syncSearchResult2;
            this.actors = list5;
        }

        public /* synthetic */ SyncResult(String str, Integer num, String str2, Integer num2, Integer num3, String str3, ShowStatus showStatus, SyncNextAiring syncNextAiring, List list, List list2, List list3, String str4, Boolean bool, String str5, String str6, Long l, Long l2, List list4, SyncSearchResult syncSearchResult, SyncSearchResult syncSearchResult2, List list5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : showStatus, (i & 128) != 0 ? null : syncNextAiring, (i & 256) != 0 ? null : list, (i & 512) != 0 ? null : list2, (i & 1024) != 0 ? null : list3, (i & 2048) != 0 ? null : str4, (i & 4096) != 0 ? null : bool, (i & 8192) != 0 ? null : str5, (i & 16384) != 0 ? null : str6, (i & 32768) != 0 ? null : l, (i & 65536) != 0 ? null : l2, (i & 131072) != 0 ? null : list4, (i & 262144) != 0 ? null : syncSearchResult, (i & 524288) != 0 ? null : syncSearchResult2, (i & 1048576) == 0 ? list5 : null);
        }

        public final String getId() {
            return this.f9990id;
        }

        public final void setId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f9990id = str;
        }

        public final Integer getTotalEpisodes() {
            return this.totalEpisodes;
        }

        public final void setTotalEpisodes(Integer num) {
            this.totalEpisodes = num;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final Integer getPublicScore() {
            return this.publicScore;
        }

        public final void setPublicScore(Integer num) {
            this.publicScore = num;
        }

        public final Integer getDuration() {
            return this.duration;
        }

        public final void setDuration(Integer num) {
            this.duration = num;
        }

        public final String getSynopsis() {
            return this.synopsis;
        }

        public final void setSynopsis(String str) {
            this.synopsis = str;
        }

        public final ShowStatus getAirStatus() {
            return this.airStatus;
        }

        public final void setAirStatus(ShowStatus showStatus) {
            this.airStatus = showStatus;
        }

        public final SyncNextAiring getNextAiring() {
            return this.nextAiring;
        }

        public final void setNextAiring(SyncNextAiring syncNextAiring) {
            this.nextAiring = syncNextAiring;
        }

        public final List<String> getStudio() {
            return this.studio;
        }

        public final void setStudio(List<String> list) {
            this.studio = list;
        }

        public final List<String> getGenres() {
            return this.genres;
        }

        public final void setGenres(List<String> list) {
            this.genres = list;
        }

        public final List<String> getSynonyms() {
            return this.synonyms;
        }

        public final void setSynonyms(List<String> list) {
            this.synonyms = list;
        }

        public final String getTrailerUrl() {
            return this.trailerUrl;
        }

        public final void setTrailerUrl(String str) {
            this.trailerUrl = str;
        }

        public final Boolean isAdult() {
            return this.isAdult;
        }

        public final void setAdult(Boolean bool) {
            this.isAdult = bool;
        }

        public final String getPosterUrl() {
            return this.posterUrl;
        }

        public final void setPosterUrl(String str) {
            this.posterUrl = str;
        }

        public final String getBackgroundPosterUrl() {
            return this.backgroundPosterUrl;
        }

        public final void setBackgroundPosterUrl(String str) {
            this.backgroundPosterUrl = str;
        }

        public final Long getStartDate() {
            return this.startDate;
        }

        public final void setStartDate(Long l) {
            this.startDate = l;
        }

        public final Long getEndDate() {
            return this.endDate;
        }

        public final void setEndDate(Long l) {
            this.endDate = l;
        }

        public final List<SyncSearchResult> getRecommendations() {
            return this.recommendations;
        }

        public final void setRecommendations(List<SyncSearchResult> list) {
            this.recommendations = list;
        }

        public final SyncSearchResult getNextSeason() {
            return this.nextSeason;
        }

        public final void setNextSeason(SyncSearchResult syncSearchResult) {
            this.nextSeason = syncSearchResult;
        }

        public final SyncSearchResult getPrevSeason() {
            return this.prevSeason;
        }

        public final void setPrevSeason(SyncSearchResult syncSearchResult) {
            this.prevSeason = syncSearchResult;
        }

        public final List<ActorData> getActors() {
            return this.actors;
        }

        public final void setActors(List<ActorData> list) {
            this.actors = list;
        }
    }
}
