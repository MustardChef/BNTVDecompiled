package com.lagradost.cloudstream3.subtitles;

import com.lagradost.cloudstream3.TvType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractSubtitleEntities.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, m107d2 = {"Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities;", "", "()V", "SubtitleEntity", "SubtitleSearch", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class AbstractSubtitleEntities {

    /* compiled from: AbstractSubtitleEntities.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\rJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013Jd\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\nHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u00064"}, m107d2 = {"Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleEntity;", "", "idPrefix", "", "name", "lang", "data", "type", "Lcom/lagradost/cloudstream3/TvType;", "epNumber", "", "seasonNumber", "year", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "getEpNumber", "()Ljava/lang/Integer;", "setEpNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIdPrefix", "setIdPrefix", "getLang", "setLang", "getName", "setName", "getSeasonNumber", "setSeasonNumber", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "setType", "(Lcom/lagradost/cloudstream3/TvType;)V", "getYear", "setYear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleEntity;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SubtitleEntity {
        private String data;
        private Integer epNumber;
        private String idPrefix;
        private String lang;
        private String name;
        private Integer seasonNumber;
        private TvType type;
        private Integer year;

        public final String component1() {
            return this.idPrefix;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.lang;
        }

        public final String component4() {
            return this.data;
        }

        public final TvType component5() {
            return this.type;
        }

        public final Integer component6() {
            return this.epNumber;
        }

        public final Integer component7() {
            return this.seasonNumber;
        }

        public final Integer component8() {
            return this.year;
        }

        public final SubtitleEntity copy(String idPrefix, String name, String lang, String data, TvType type, Integer num, Integer num2, Integer num3) {
            Intrinsics.checkNotNullParameter(idPrefix, "idPrefix");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lang, "lang");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(type, "type");
            return new SubtitleEntity(idPrefix, name, lang, data, type, num, num2, num3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SubtitleEntity) {
                SubtitleEntity subtitleEntity = (SubtitleEntity) obj;
                return Intrinsics.areEqual(this.idPrefix, subtitleEntity.idPrefix) && Intrinsics.areEqual(this.name, subtitleEntity.name) && Intrinsics.areEqual(this.lang, subtitleEntity.lang) && Intrinsics.areEqual(this.data, subtitleEntity.data) && this.type == subtitleEntity.type && Intrinsics.areEqual(this.epNumber, subtitleEntity.epNumber) && Intrinsics.areEqual(this.seasonNumber, subtitleEntity.seasonNumber) && Intrinsics.areEqual(this.year, subtitleEntity.year);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((((((this.idPrefix.hashCode() * 31) + this.name.hashCode()) * 31) + this.lang.hashCode()) * 31) + this.data.hashCode()) * 31) + this.type.hashCode()) * 31;
            Integer num = this.epNumber;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.seasonNumber;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.year;
            return hashCode3 + (num3 != null ? num3.hashCode() : 0);
        }

        public String toString() {
            return "SubtitleEntity(idPrefix=" + this.idPrefix + ", name=" + this.name + ", lang=" + this.lang + ", data=" + this.data + ", type=" + this.type + ", epNumber=" + this.epNumber + ", seasonNumber=" + this.seasonNumber + ", year=" + this.year + ')';
        }

        public SubtitleEntity(String idPrefix, String name, String lang, String data, TvType type, Integer num, Integer num2, Integer num3) {
            Intrinsics.checkNotNullParameter(idPrefix, "idPrefix");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lang, "lang");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(type, "type");
            this.idPrefix = idPrefix;
            this.name = name;
            this.lang = lang;
            this.data = data;
            this.type = type;
            this.epNumber = num;
            this.seasonNumber = num2;
            this.year = num3;
        }

        public final String getIdPrefix() {
            return this.idPrefix;
        }

        public final void setIdPrefix(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.idPrefix = str;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getLang() {
            return this.lang;
        }

        public final void setLang(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lang = str;
        }

        public final String getData() {
            return this.data;
        }

        public final void setData(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.data = str;
        }

        public /* synthetic */ SubtitleEntity(String str, String str2, String str3, String str4, TvType tvType, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "en" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? TvType.Movie : tvType, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : num2, (i & 128) == 0 ? num3 : null);
        }

        public final TvType getType() {
            return this.type;
        }

        public final void setType(TvType tvType) {
            Intrinsics.checkNotNullParameter(tvType, "<set-?>");
            this.type = tvType;
        }

        public final Integer getEpNumber() {
            return this.epNumber;
        }

        public final void setEpNumber(Integer num) {
            this.epNumber = num;
        }

        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        public final void setSeasonNumber(Integer num) {
            this.seasonNumber = num;
        }

        public final Integer getYear() {
            return this.year;
        }

        public final void setYear(Integer num) {
            this.year = num;
        }
    }

    /* compiled from: AbstractSubtitleEntities.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJT\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\u001e\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006-"}, m107d2 = {"Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleSearch;", "", "query", "", "imdb", "", "lang", "epNumber", "", "seasonNumber", "year", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEpNumber", "()Ljava/lang/Integer;", "setEpNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getImdb", "()Ljava/lang/Long;", "setImdb", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "getQuery", "setQuery", "getSeasonNumber", "setSeasonNumber", "getYear", "setYear", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleSearch;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SubtitleSearch {
        private Integer epNumber;
        private Long imdb;
        private String lang;
        private String query;
        private Integer seasonNumber;
        private Integer year;

        public SubtitleSearch() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ SubtitleSearch copy$default(SubtitleSearch subtitleSearch, String str, Long l, String str2, Integer num, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitleSearch.query;
            }
            if ((i & 2) != 0) {
                l = subtitleSearch.imdb;
            }
            Long l2 = l;
            if ((i & 4) != 0) {
                str2 = subtitleSearch.lang;
            }
            String str3 = str2;
            if ((i & 8) != 0) {
                num = subtitleSearch.epNumber;
            }
            Integer num4 = num;
            if ((i & 16) != 0) {
                num2 = subtitleSearch.seasonNumber;
            }
            Integer num5 = num2;
            if ((i & 32) != 0) {
                num3 = subtitleSearch.year;
            }
            return subtitleSearch.copy(str, l2, str3, num4, num5, num3);
        }

        public final String component1() {
            return this.query;
        }

        public final Long component2() {
            return this.imdb;
        }

        public final String component3() {
            return this.lang;
        }

        public final Integer component4() {
            return this.epNumber;
        }

        public final Integer component5() {
            return this.seasonNumber;
        }

        public final Integer component6() {
            return this.year;
        }

        public final SubtitleSearch copy(String query, Long l, String str, Integer num, Integer num2, Integer num3) {
            Intrinsics.checkNotNullParameter(query, "query");
            return new SubtitleSearch(query, l, str, num, num2, num3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SubtitleSearch) {
                SubtitleSearch subtitleSearch = (SubtitleSearch) obj;
                return Intrinsics.areEqual(this.query, subtitleSearch.query) && Intrinsics.areEqual(this.imdb, subtitleSearch.imdb) && Intrinsics.areEqual(this.lang, subtitleSearch.lang) && Intrinsics.areEqual(this.epNumber, subtitleSearch.epNumber) && Intrinsics.areEqual(this.seasonNumber, subtitleSearch.seasonNumber) && Intrinsics.areEqual(this.year, subtitleSearch.year);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.query.hashCode() * 31;
            Long l = this.imdb;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.lang;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.epNumber;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.seasonNumber;
            int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.year;
            return hashCode5 + (num3 != null ? num3.hashCode() : 0);
        }

        public String toString() {
            return "SubtitleSearch(query=" + this.query + ", imdb=" + this.imdb + ", lang=" + this.lang + ", epNumber=" + this.epNumber + ", seasonNumber=" + this.seasonNumber + ", year=" + this.year + ')';
        }

        public SubtitleSearch(String query, Long l, String str, Integer num, Integer num2, Integer num3) {
            Intrinsics.checkNotNullParameter(query, "query");
            this.query = query;
            this.imdb = l;
            this.lang = str;
            this.epNumber = num;
            this.seasonNumber = num2;
            this.year = num3;
        }

        public /* synthetic */ SubtitleSearch(String str, Long l, String str2, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) == 0 ? num3 : null);
        }

        public final String getQuery() {
            return this.query;
        }

        public final void setQuery(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.query = str;
        }

        public final Long getImdb() {
            return this.imdb;
        }

        public final void setImdb(Long l) {
            this.imdb = l;
        }

        public final String getLang() {
            return this.lang;
        }

        public final void setLang(String str) {
            this.lang = str;
        }

        public final Integer getEpNumber() {
            return this.epNumber;
        }

        public final void setEpNumber(Integer num) {
            this.epNumber = num;
        }

        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        public final void setSeasonNumber(Integer num) {
            this.seasonNumber = num;
        }

        public final Integer getYear() {
            return this.year;
        }

        public final void setYear(Integer num) {
            this.year = num;
        }
    }
}
