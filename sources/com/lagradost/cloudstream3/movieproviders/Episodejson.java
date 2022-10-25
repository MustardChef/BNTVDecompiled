package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\b\u001a\u00020\u00032\u000e\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006#"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Episodejson;", "", "id", "", "number", "name", "", "plot", "seasonID", "images", "", "Lcom/lagradost/cloudstream3/movieproviders/ImageSeason;", "(JJLjava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getId", "()J", "getImages", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getNumber", "getPlot", "getSeasonID", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Episodejson {

    /* renamed from: id */
    private final long f9960id;
    private final List<ImageSeason> images;
    private final String name;
    private final long number;
    private final String plot;
    private final long seasonID;

    public final long component1() {
        return this.f9960id;
    }

    public final long component2() {
        return this.number;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.plot;
    }

    public final long component5() {
        return this.seasonID;
    }

    public final List<ImageSeason> component6() {
        return this.images;
    }

    public final Episodejson copy(@JsonProperty("id") long j, @JsonProperty("number") long j2, @JsonProperty("name") String str, @JsonProperty("plot") String str2, @JsonProperty("season_id") long j3, @JsonProperty("images") List<ImageSeason> images) {
        Intrinsics.checkNotNullParameter(images, "images");
        return new Episodejson(j, j2, str, str2, j3, images);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Episodejson) {
            Episodejson episodejson = (Episodejson) obj;
            return this.f9960id == episodejson.f9960id && this.number == episodejson.number && Intrinsics.areEqual(this.name, episodejson.name) && Intrinsics.areEqual(this.plot, episodejson.plot) && this.seasonID == episodejson.seasonID && Intrinsics.areEqual(this.images, episodejson.images);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f9960id) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.number)) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.plot;
        return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.seasonID)) * 31) + this.images.hashCode();
    }

    public String toString() {
        return "Episodejson(id=" + this.f9960id + ", number=" + this.number + ", name=" + this.name + ", plot=" + this.plot + ", seasonID=" + this.seasonID + ", images=" + this.images + ')';
    }

    public Episodejson(@JsonProperty("id") long j, @JsonProperty("number") long j2, @JsonProperty("name") String str, @JsonProperty("plot") String str2, @JsonProperty("season_id") long j3, @JsonProperty("images") List<ImageSeason> images) {
        Intrinsics.checkNotNullParameter(images, "images");
        this.f9960id = j;
        this.number = j2;
        this.name = str;
        this.plot = str2;
        this.seasonID = j3;
        this.images = images;
    }

    public /* synthetic */ Episodejson(long j, long j2, String str, String str2, long j3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, j3, list);
    }

    public final long getId() {
        return this.f9960id;
    }

    public final long getNumber() {
        return this.number;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlot() {
        return this.plot;
    }

    public final long getSeasonID() {
        return this.seasonID;
    }

    public final List<ImageSeason> getImages() {
        return this.images;
    }
}
