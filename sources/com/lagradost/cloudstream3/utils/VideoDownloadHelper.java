package com.lagradost.cloudstream3.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.p041ui.download.EasyDownloadButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoDownloadHelper.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper;", "", "()V", "DownloadEpisodeCached", "DownloadHeaderCached", "ResumeWatching", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class VideoDownloadHelper {
    public static final VideoDownloadHelper INSTANCE = new VideoDownloadHelper();

    /* compiled from: VideoDownloadHelper.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006\u0012\b\b\u0001\u0010\t\u001a\u00020\u0006\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003Jr\u0010&\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\b\b\u0003\u0010\t\u001a\u00020\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001a¨\u0006."}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadEpisodeCached;", "Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton$IMinimumData;", "name", "", "poster", "episode", "", "season", "id", "parentId", "rating", "description", "cacheTime", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;IILjava/lang/Integer;Ljava/lang/String;J)V", "getCacheTime", "()J", "getDescription", "()Ljava/lang/String;", "getEpisode", "()I", "getId", "getName", "getParentId", "getPoster", "getRating", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;IILjava/lang/Integer;Ljava/lang/String;J)Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadEpisodeCached;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class DownloadEpisodeCached implements EasyDownloadButton.IMinimumData {
        private final long cacheTime;
        private final String description;
        private final int episode;

        /* renamed from: id */
        private final int f10033id;
        private final String name;
        private final int parentId;
        private final String poster;
        private final Integer rating;
        private final Integer season;

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.poster;
        }

        public final int component3() {
            return this.episode;
        }

        public final Integer component4() {
            return this.season;
        }

        public final int component5() {
            return getId();
        }

        public final int component6() {
            return this.parentId;
        }

        public final Integer component7() {
            return this.rating;
        }

        public final String component8() {
            return this.description;
        }

        public final long component9() {
            return this.cacheTime;
        }

        public final DownloadEpisodeCached copy(@JsonProperty("name") String str, @JsonProperty("poster") String str2, @JsonProperty("episode") int i, @JsonProperty("season") Integer num, @JsonProperty("id") int i2, @JsonProperty("parentId") int i3, @JsonProperty("rating") Integer num2, @JsonProperty("description") String str3, @JsonProperty("cacheTime") long j) {
            return new DownloadEpisodeCached(str, str2, i, num, i2, i3, num2, str3, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadEpisodeCached) {
                DownloadEpisodeCached downloadEpisodeCached = (DownloadEpisodeCached) obj;
                return Intrinsics.areEqual(this.name, downloadEpisodeCached.name) && Intrinsics.areEqual(this.poster, downloadEpisodeCached.poster) && this.episode == downloadEpisodeCached.episode && Intrinsics.areEqual(this.season, downloadEpisodeCached.season) && getId() == downloadEpisodeCached.getId() && this.parentId == downloadEpisodeCached.parentId && Intrinsics.areEqual(this.rating, downloadEpisodeCached.rating) && Intrinsics.areEqual(this.description, downloadEpisodeCached.description) && this.cacheTime == downloadEpisodeCached.cacheTime;
            }
            return false;
        }

        public int hashCode() {
            String str = this.name;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.poster;
            int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.episode) * 31;
            Integer num = this.season;
            int hashCode3 = (((((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + getId()) * 31) + this.parentId) * 31;
            Integer num2 = this.rating;
            int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str3 = this.description;
            return ((hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.cacheTime);
        }

        public String toString() {
            return "DownloadEpisodeCached(name=" + this.name + ", poster=" + this.poster + ", episode=" + this.episode + ", season=" + this.season + ", id=" + getId() + ", parentId=" + this.parentId + ", rating=" + this.rating + ", description=" + this.description + ", cacheTime=" + this.cacheTime + ')';
        }

        public DownloadEpisodeCached(@JsonProperty("name") String str, @JsonProperty("poster") String str2, @JsonProperty("episode") int i, @JsonProperty("season") Integer num, @JsonProperty("id") int i2, @JsonProperty("parentId") int i3, @JsonProperty("rating") Integer num2, @JsonProperty("description") String str3, @JsonProperty("cacheTime") long j) {
            this.name = str;
            this.poster = str2;
            this.episode = i;
            this.season = num;
            this.f10033id = i2;
            this.parentId = i3;
            this.rating = num2;
            this.description = str3;
            this.cacheTime = j;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPoster() {
            return this.poster;
        }

        public final int getEpisode() {
            return this.episode;
        }

        public final Integer getSeason() {
            return this.season;
        }

        @Override // com.lagradost.cloudstream3.p041ui.download.EasyDownloadButton.IMinimumData
        public int getId() {
            return this.f10033id;
        }

        public final int getParentId() {
            return this.parentId;
        }

        public final Integer getRating() {
            return this.rating;
        }

        public final String getDescription() {
            return this.description;
        }

        public final long getCacheTime() {
            return this.cacheTime;
        }
    }

    private VideoDownloadHelper() {
    }

    /* compiled from: VideoDownloadHelper.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JQ\u0010 \u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006&"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadHeaderCached;", "", "apiName", "", "url", "type", "Lcom/lagradost/cloudstream3/TvType;", "name", "poster", "id", "", "cacheTime", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/String;IJ)V", "getApiName", "()Ljava/lang/String;", "getCacheTime", "()J", "getId", "()I", "getName", "getPoster", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class DownloadHeaderCached {
        private final String apiName;
        private final long cacheTime;

        /* renamed from: id */
        private final int f10034id;
        private final String name;
        private final String poster;
        private final TvType type;
        private final String url;

        public final String component1() {
            return this.apiName;
        }

        public final String component2() {
            return this.url;
        }

        public final TvType component3() {
            return this.type;
        }

        public final String component4() {
            return this.name;
        }

        public final String component5() {
            return this.poster;
        }

        public final int component6() {
            return this.f10034id;
        }

        public final long component7() {
            return this.cacheTime;
        }

        public final DownloadHeaderCached copy(@JsonProperty("apiName") String apiName, @JsonProperty("url") String url, @JsonProperty("type") TvType type, @JsonProperty("name") String name, @JsonProperty("poster") String str, @JsonProperty("id") int i, @JsonProperty("cacheTime") long j) {
            Intrinsics.checkNotNullParameter(apiName, "apiName");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(name, "name");
            return new DownloadHeaderCached(apiName, url, type, name, str, i, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadHeaderCached) {
                DownloadHeaderCached downloadHeaderCached = (DownloadHeaderCached) obj;
                return Intrinsics.areEqual(this.apiName, downloadHeaderCached.apiName) && Intrinsics.areEqual(this.url, downloadHeaderCached.url) && this.type == downloadHeaderCached.type && Intrinsics.areEqual(this.name, downloadHeaderCached.name) && Intrinsics.areEqual(this.poster, downloadHeaderCached.poster) && this.f10034id == downloadHeaderCached.f10034id && this.cacheTime == downloadHeaderCached.cacheTime;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((((this.apiName.hashCode() * 31) + this.url.hashCode()) * 31) + this.type.hashCode()) * 31) + this.name.hashCode()) * 31;
            String str = this.poster;
            return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f10034id) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.cacheTime);
        }

        public String toString() {
            return "DownloadHeaderCached(apiName=" + this.apiName + ", url=" + this.url + ", type=" + this.type + ", name=" + this.name + ", poster=" + this.poster + ", id=" + this.f10034id + ", cacheTime=" + this.cacheTime + ')';
        }

        public DownloadHeaderCached(@JsonProperty("apiName") String apiName, @JsonProperty("url") String url, @JsonProperty("type") TvType type, @JsonProperty("name") String name, @JsonProperty("poster") String str, @JsonProperty("id") int i, @JsonProperty("cacheTime") long j) {
            Intrinsics.checkNotNullParameter(apiName, "apiName");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(name, "name");
            this.apiName = apiName;
            this.url = url;
            this.type = type;
            this.name = name;
            this.poster = str;
            this.f10034id = i;
            this.cacheTime = j;
        }

        public final String getApiName() {
            return this.apiName;
        }

        public final String getUrl() {
            return this.url;
        }

        public final TvType getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPoster() {
            return this.poster;
        }

        public final int getId() {
            return this.f10034id;
        }

        public final long getCacheTime() {
            return this.cacheTime;
        }
    }

    /* compiled from: VideoDownloadHelper.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JP\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$ResumeWatching;", "", "parentId", "", "episodeId", "episode", "season", "updateTime", "", "isFromDownload", "", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;JZ)V", "getEpisode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisodeId", "()Z", "getParentId", "()I", "getSeason", "getUpdateTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;JZ)Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$ResumeWatching;", "equals", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class ResumeWatching {
        private final Integer episode;
        private final Integer episodeId;
        private final boolean isFromDownload;
        private final int parentId;
        private final Integer season;
        private final long updateTime;

        public static /* synthetic */ ResumeWatching copy$default(ResumeWatching resumeWatching, int i, Integer num, Integer num2, Integer num3, long j, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = resumeWatching.parentId;
            }
            if ((i2 & 2) != 0) {
                num = resumeWatching.episodeId;
            }
            Integer num4 = num;
            if ((i2 & 4) != 0) {
                num2 = resumeWatching.episode;
            }
            Integer num5 = num2;
            if ((i2 & 8) != 0) {
                num3 = resumeWatching.season;
            }
            Integer num6 = num3;
            if ((i2 & 16) != 0) {
                j = resumeWatching.updateTime;
            }
            long j2 = j;
            if ((i2 & 32) != 0) {
                z = resumeWatching.isFromDownload;
            }
            return resumeWatching.copy(i, num4, num5, num6, j2, z);
        }

        public final int component1() {
            return this.parentId;
        }

        public final Integer component2() {
            return this.episodeId;
        }

        public final Integer component3() {
            return this.episode;
        }

        public final Integer component4() {
            return this.season;
        }

        public final long component5() {
            return this.updateTime;
        }

        public final boolean component6() {
            return this.isFromDownload;
        }

        public final ResumeWatching copy(@JsonProperty("parentId") int i, @JsonProperty("episodeId") Integer num, @JsonProperty("episode") Integer num2, @JsonProperty("season") Integer num3, @JsonProperty("updateTime") long j, @JsonProperty("isFromDownload") boolean z) {
            return new ResumeWatching(i, num, num2, num3, j, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResumeWatching) {
                ResumeWatching resumeWatching = (ResumeWatching) obj;
                return this.parentId == resumeWatching.parentId && Intrinsics.areEqual(this.episodeId, resumeWatching.episodeId) && Intrinsics.areEqual(this.episode, resumeWatching.episode) && Intrinsics.areEqual(this.season, resumeWatching.season) && this.updateTime == resumeWatching.updateTime && this.isFromDownload == resumeWatching.isFromDownload;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i = this.parentId * 31;
            Integer num = this.episodeId;
            int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.episode;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.season;
            int hashCode3 = (((hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.updateTime)) * 31;
            boolean z = this.isFromDownload;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return hashCode3 + i2;
        }

        public String toString() {
            return "ResumeWatching(parentId=" + this.parentId + ", episodeId=" + this.episodeId + ", episode=" + this.episode + ", season=" + this.season + ", updateTime=" + this.updateTime + ", isFromDownload=" + this.isFromDownload + ')';
        }

        public ResumeWatching(@JsonProperty("parentId") int i, @JsonProperty("episodeId") Integer num, @JsonProperty("episode") Integer num2, @JsonProperty("season") Integer num3, @JsonProperty("updateTime") long j, @JsonProperty("isFromDownload") boolean z) {
            this.parentId = i;
            this.episodeId = num;
            this.episode = num2;
            this.season = num3;
            this.updateTime = j;
            this.isFromDownload = z;
        }

        public final int getParentId() {
            return this.parentId;
        }

        public final Integer getEpisodeId() {
            return this.episodeId;
        }

        public final Integer getEpisode() {
            return this.episode;
        }

        public final Integer getSeason() {
            return this.season;
        }

        public final long getUpdateTime() {
            return this.updateTime;
        }

        public final boolean isFromDownload() {
            return this.isFromDownload;
        }
    }
}
