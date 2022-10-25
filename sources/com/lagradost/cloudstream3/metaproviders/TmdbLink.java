package com.lagradost.cloudstream3.metaproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TmdbProvider.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/metaproviders/TmdbLink;", "", "imdbID", "", "tmdbID", "", "episode", "season", "movieName", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getEpisode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImdbID", "()Ljava/lang/String;", "getMovieName", "getSeason", "getTmdbID", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/lagradost/cloudstream3/metaproviders/TmdbLink;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class TmdbLink {
    private final Integer episode;
    private final String imdbID;
    private final String movieName;
    private final Integer season;
    private final Integer tmdbID;

    public static /* synthetic */ TmdbLink copy$default(TmdbLink tmdbLink, String str, Integer num, Integer num2, Integer num3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tmdbLink.imdbID;
        }
        if ((i & 2) != 0) {
            num = tmdbLink.tmdbID;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = tmdbLink.episode;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            num3 = tmdbLink.season;
        }
        Integer num6 = num3;
        if ((i & 16) != 0) {
            str2 = tmdbLink.movieName;
        }
        return tmdbLink.copy(str, num4, num5, num6, str2);
    }

    public final String component1() {
        return this.imdbID;
    }

    public final Integer component2() {
        return this.tmdbID;
    }

    public final Integer component3() {
        return this.episode;
    }

    public final Integer component4() {
        return this.season;
    }

    public final String component5() {
        return this.movieName;
    }

    public final TmdbLink copy(@JsonProperty("imdbID") String str, @JsonProperty("tmdbID") Integer num, @JsonProperty("episode") Integer num2, @JsonProperty("season") Integer num3, @JsonProperty("movieName") String str2) {
        return new TmdbLink(str, num, num2, num3, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TmdbLink) {
            TmdbLink tmdbLink = (TmdbLink) obj;
            return Intrinsics.areEqual(this.imdbID, tmdbLink.imdbID) && Intrinsics.areEqual(this.tmdbID, tmdbLink.tmdbID) && Intrinsics.areEqual(this.episode, tmdbLink.episode) && Intrinsics.areEqual(this.season, tmdbLink.season) && Intrinsics.areEqual(this.movieName, tmdbLink.movieName);
        }
        return false;
    }

    public int hashCode() {
        String str = this.imdbID;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.tmdbID;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.episode;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.season;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.movieName;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "TmdbLink(imdbID=" + this.imdbID + ", tmdbID=" + this.tmdbID + ", episode=" + this.episode + ", season=" + this.season + ", movieName=" + this.movieName + ')';
    }

    public TmdbLink(@JsonProperty("imdbID") String str, @JsonProperty("tmdbID") Integer num, @JsonProperty("episode") Integer num2, @JsonProperty("season") Integer num3, @JsonProperty("movieName") String str2) {
        this.imdbID = str;
        this.tmdbID = num;
        this.episode = num2;
        this.season = num3;
        this.movieName = str2;
    }

    public /* synthetic */ TmdbLink(String str, Integer num, Integer num2, Integer num3, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, num, num2, num3, (i & 16) != 0 ? null : str2);
    }

    public final String getImdbID() {
        return this.imdbID;
    }

    public final Integer getTmdbID() {
        return this.tmdbID;
    }

    public final Integer getEpisode() {
        return this.episode;
    }

    public final Integer getSeason() {
        return this.season;
    }

    public final String getMovieName() {
        return this.movieName;
    }
}
