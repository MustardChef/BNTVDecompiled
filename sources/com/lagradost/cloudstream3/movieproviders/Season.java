package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003Js\u0010%\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u000e\b\u0003\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006,"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Season;", "", "id", "", "name", "", "plot", "date", "number", "title_id", "createdAt", "updatedAt", "episodes", "", "Lcom/lagradost/cloudstream3/movieproviders/Episodejson;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCreatedAt", "()Ljava/lang/String;", "getDate", "getEpisodes", "()Ljava/util/List;", "getId", "()J", "getName", "getNumber", "getPlot", "getTitle_id", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Season {
    private final String createdAt;
    private final String date;
    private final List<Episodejson> episodes;

    /* renamed from: id */
    private final long f9971id;
    private final String name;
    private final long number;
    private final String plot;
    private final long title_id;
    private final String updatedAt;

    public final long component1() {
        return this.f9971id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.plot;
    }

    public final String component4() {
        return this.date;
    }

    public final long component5() {
        return this.number;
    }

    public final long component6() {
        return this.title_id;
    }

    public final String component7() {
        return this.createdAt;
    }

    public final String component8() {
        return this.updatedAt;
    }

    public final List<Episodejson> component9() {
        return this.episodes;
    }

    public final Season copy(@JsonProperty("id") long j, @JsonProperty("name") String str, @JsonProperty("plot") String str2, @JsonProperty("date") String str3, @JsonProperty("number") long j2, @JsonProperty("title_id") long j3, @JsonProperty("createdAt") String str4, @JsonProperty("updated_at") String str5, @JsonProperty("episodes") List<Episodejson> episodes) {
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        return new Season(j, str, str2, str3, j2, j3, str4, str5, episodes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Season) {
            Season season = (Season) obj;
            return this.f9971id == season.f9971id && Intrinsics.areEqual(this.name, season.name) && Intrinsics.areEqual(this.plot, season.plot) && Intrinsics.areEqual(this.date, season.date) && this.number == season.number && this.title_id == season.title_id && Intrinsics.areEqual(this.createdAt, season.createdAt) && Intrinsics.areEqual(this.updatedAt, season.updatedAt) && Intrinsics.areEqual(this.episodes, season.episodes);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f9971id) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.plot;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.date;
        int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.number)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.title_id)) * 31;
        String str4 = this.createdAt;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.updatedAt;
        return ((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.episodes.hashCode();
    }

    public String toString() {
        return "Season(id=" + this.f9971id + ", name=" + this.name + ", plot=" + this.plot + ", date=" + this.date + ", number=" + this.number + ", title_id=" + this.title_id + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", episodes=" + this.episodes + ')';
    }

    public Season(@JsonProperty("id") long j, @JsonProperty("name") String str, @JsonProperty("plot") String str2, @JsonProperty("date") String str3, @JsonProperty("number") long j2, @JsonProperty("title_id") long j3, @JsonProperty("createdAt") String str4, @JsonProperty("updated_at") String str5, @JsonProperty("episodes") List<Episodejson> episodes) {
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        this.f9971id = j;
        this.name = str;
        this.plot = str2;
        this.date = str3;
        this.number = j2;
        this.title_id = j3;
        this.createdAt = str4;
        this.updatedAt = str5;
        this.episodes = episodes;
    }

    public /* synthetic */ Season(long j, String str, String str2, String str3, long j2, long j3, String str4, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, j2, j3, (i & 64) != 0 ? "" : str4, (i & 128) != 0 ? "" : str5, list);
    }

    public final long getId() {
        return this.f9971id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlot() {
        return this.plot;
    }

    public final String getDate() {
        return this.date;
    }

    public final long getNumber() {
        return this.number;
    }

    public final long getTitle_id() {
        return this.title_id;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final List<Episodejson> getEpisodes() {
        return this.episodes;
    }
}
