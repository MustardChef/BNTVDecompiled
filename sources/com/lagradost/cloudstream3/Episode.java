package com.lagradost.cloudstream3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0013Jl\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0006HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001c¨\u00065"}, m107d2 = {"Lcom/lagradost/cloudstream3/Episode;", "", "data", "", "name", "season", "", "episode", "posterUrl", "rating", "description", "date", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "getDate", "()Ljava/lang/Long;", "setDate", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDescription", "setDescription", "getEpisode", "()Ljava/lang/Integer;", "setEpisode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "setName", "getPosterUrl", "setPosterUrl", "getRating", "setRating", "getSeason", "setSeason", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)Lcom/lagradost/cloudstream3/Episode;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Episode {
    private String data;
    private Long date;
    private String description;
    private Integer episode;
    private String name;
    private String posterUrl;
    private Integer rating;
    private Integer season;

    public final String component1() {
        return this.data;
    }

    public final String component2() {
        return this.name;
    }

    public final Integer component3() {
        return this.season;
    }

    public final Integer component4() {
        return this.episode;
    }

    public final String component5() {
        return this.posterUrl;
    }

    public final Integer component6() {
        return this.rating;
    }

    public final String component7() {
        return this.description;
    }

    public final Long component8() {
        return this.date;
    }

    public final Episode copy(String data, String str, Integer num, Integer num2, String str2, Integer num3, String str3, Long l) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new Episode(data, str, num, num2, str2, num3, str3, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Episode) {
            Episode episode = (Episode) obj;
            return Intrinsics.areEqual(this.data, episode.data) && Intrinsics.areEqual(this.name, episode.name) && Intrinsics.areEqual(this.season, episode.season) && Intrinsics.areEqual(this.episode, episode.episode) && Intrinsics.areEqual(this.posterUrl, episode.posterUrl) && Intrinsics.areEqual(this.rating, episode.rating) && Intrinsics.areEqual(this.description, episode.description) && Intrinsics.areEqual(this.date, episode.date);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.data.hashCode() * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.season;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.episode;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.posterUrl;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.rating;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.description;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.date;
        return hashCode7 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "Episode(data=" + this.data + ", name=" + this.name + ", season=" + this.season + ", episode=" + this.episode + ", posterUrl=" + this.posterUrl + ", rating=" + this.rating + ", description=" + this.description + ", date=" + this.date + ')';
    }

    public Episode(String data, String str, Integer num, Integer num2, String str2, Integer num3, String str3, Long l) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.name = str;
        this.season = num;
        this.episode = num2;
        this.posterUrl = str2;
        this.rating = num3;
        this.description = str3;
        this.date = l;
    }

    public /* synthetic */ Episode(String str, String str2, Integer num, Integer num2, String str3, Integer num3, String str4, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : str4, (i & 128) == 0 ? l : null);
    }

    public final String getData() {
        return this.data;
    }

    public final void setData(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.data = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Integer getSeason() {
        return this.season;
    }

    public final void setSeason(Integer num) {
        this.season = num;
    }

    public final Integer getEpisode() {
        return this.episode;
    }

    public final void setEpisode(Integer num) {
        this.episode = num;
    }

    public final String getPosterUrl() {
        return this.posterUrl;
    }

    public final void setPosterUrl(String str) {
        this.posterUrl = str;
    }

    public final Integer getRating() {
        return this.rating;
    }

    public final void setRating(Integer num) {
        this.rating = num;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final Long getDate() {
        return this.date;
    }

    public final void setDate(Long l) {
        this.date = l;
    }
}
