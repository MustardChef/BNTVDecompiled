package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\nHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018Jn\u0010%\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0003\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Moviedata;", "", "id", "", "name", "", "type", "releaseDate", "seasonsCount", "genres", "", "Lcom/lagradost/cloudstream3/movieproviders/Genre;", "votes", "Lcom/lagradost/cloudstream3/movieproviders/Vote;", "runtime", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)V", "getGenres", "()Ljava/util/List;", "getId", "()J", "getName", "()Ljava/lang/String;", "getReleaseDate", "getRuntime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSeasonsCount", "getType", "getVotes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)Lcom/lagradost/cloudstream3/movieproviders/Moviedata;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Moviedata {
    private final List<Genre> genres;

    /* renamed from: id */
    private final long f9968id;
    private final String name;
    private final String releaseDate;
    private final Long runtime;
    private final Long seasonsCount;
    private final String type;
    private final List<Vote> votes;

    public final long component1() {
        return this.f9968id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.releaseDate;
    }

    public final Long component5() {
        return this.seasonsCount;
    }

    public final List<Genre> component6() {
        return this.genres;
    }

    public final List<Vote> component7() {
        return this.votes;
    }

    public final Long component8() {
        return this.runtime;
    }

    public final Moviedata copy(@JsonProperty("id") long j, @JsonProperty("name") String name, @JsonProperty("type") String type, @JsonProperty("release_date") String releaseDate, @JsonProperty("seasons_count") Long l, @JsonProperty("genres") List<Genre> genres, @JsonProperty("votes") List<Vote> votes, @JsonProperty("runtime") Long l2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(releaseDate, "releaseDate");
        Intrinsics.checkNotNullParameter(genres, "genres");
        Intrinsics.checkNotNullParameter(votes, "votes");
        return new Moviedata(j, name, type, releaseDate, l, genres, votes, l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Moviedata) {
            Moviedata moviedata = (Moviedata) obj;
            return this.f9968id == moviedata.f9968id && Intrinsics.areEqual(this.name, moviedata.name) && Intrinsics.areEqual(this.type, moviedata.type) && Intrinsics.areEqual(this.releaseDate, moviedata.releaseDate) && Intrinsics.areEqual(this.seasonsCount, moviedata.seasonsCount) && Intrinsics.areEqual(this.genres, moviedata.genres) && Intrinsics.areEqual(this.votes, moviedata.votes) && Intrinsics.areEqual(this.runtime, moviedata.runtime);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f9968id) * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31) + this.releaseDate.hashCode()) * 31;
        Long l = this.seasonsCount;
        int hashCode2 = (((((hashCode + (l == null ? 0 : l.hashCode())) * 31) + this.genres.hashCode()) * 31) + this.votes.hashCode()) * 31;
        Long l2 = this.runtime;
        return hashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        return "Moviedata(id=" + this.f9968id + ", name=" + this.name + ", type=" + this.type + ", releaseDate=" + this.releaseDate + ", seasonsCount=" + this.seasonsCount + ", genres=" + this.genres + ", votes=" + this.votes + ", runtime=" + this.runtime + ')';
    }

    public Moviedata(@JsonProperty("id") long j, @JsonProperty("name") String name, @JsonProperty("type") String type, @JsonProperty("release_date") String releaseDate, @JsonProperty("seasons_count") Long l, @JsonProperty("genres") List<Genre> genres, @JsonProperty("votes") List<Vote> votes, @JsonProperty("runtime") Long l2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(releaseDate, "releaseDate");
        Intrinsics.checkNotNullParameter(genres, "genres");
        Intrinsics.checkNotNullParameter(votes, "votes");
        this.f9968id = j;
        this.name = name;
        this.type = type;
        this.releaseDate = releaseDate;
        this.seasonsCount = l;
        this.genres = genres;
        this.votes = votes;
        this.runtime = l2;
    }

    public /* synthetic */ Moviedata(long j, String str, String str2, String str3, Long l, List list, List list2, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, str3, (i & 16) != 0 ? null : l, list, list2, (i & 128) != 0 ? null : l2);
    }

    public final long getId() {
        return this.f9968id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final Long getSeasonsCount() {
        return this.seasonsCount;
    }

    public final List<Genre> getGenres() {
        return this.genres;
    }

    public final List<Vote> getVotes() {
        return this.votes;
    }

    public final Long getRuntime() {
        return this.runtime;
    }
}
