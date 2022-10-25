package com.lagradost.cloudstream3.p041ui.result;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.TvType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0002\u0010\u0017J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010#J\t\u00105\u001a\u00020\u0015HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010*J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003Jº\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00132\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0007HÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\u0012\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006E"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "", "headerName", "", "name", "poster", "episode", "", "season", "data", "apiName", "id", FirebaseAnalytics.Param.INDEX, "position", "", TypedValues.TransitionType.S_DURATION, "rating", "description", "isFiller", "", "tvType", "Lcom/lagradost/cloudstream3/TvType;", "parentId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;IIJJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/lagradost/cloudstream3/TvType;I)V", "getApiName", "()Ljava/lang/String;", "getData", "getDescription", "getDuration", "()J", "getEpisode", "()I", "getHeaderName", "getId", "getIndex", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getParentId", "getPosition", "getPoster", "getRating", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason", "getTvType", "()Lcom/lagradost/cloudstream3/TvType;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;IIJJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/lagradost/cloudstream3/TvType;I)Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultEpisode */
/* loaded from: classes4.dex */
public final class ResultEpisode {
    private final String apiName;
    private final String data;
    private final String description;
    private final long duration;
    private final int episode;
    private final String headerName;

    /* renamed from: id */
    private final int f10017id;
    private final int index;
    private final Boolean isFiller;
    private final String name;
    private final int parentId;
    private final long position;
    private final String poster;
    private final Integer rating;
    private final Integer season;
    private final TvType tvType;

    public final String component1() {
        return this.headerName;
    }

    public final long component10() {
        return this.position;
    }

    public final long component11() {
        return this.duration;
    }

    public final Integer component12() {
        return this.rating;
    }

    public final String component13() {
        return this.description;
    }

    public final Boolean component14() {
        return this.isFiller;
    }

    public final TvType component15() {
        return this.tvType;
    }

    public final int component16() {
        return this.parentId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.poster;
    }

    public final int component4() {
        return this.episode;
    }

    public final Integer component5() {
        return this.season;
    }

    public final String component6() {
        return this.data;
    }

    public final String component7() {
        return this.apiName;
    }

    public final int component8() {
        return this.f10017id;
    }

    public final int component9() {
        return this.index;
    }

    public final ResultEpisode copy(String headerName, String str, String str2, int i, Integer num, String data, String apiName, int i2, int i3, long j, long j2, Integer num2, String str3, Boolean bool, TvType tvType, int i4) {
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(tvType, "tvType");
        return new ResultEpisode(headerName, str, str2, i, num, data, apiName, i2, i3, j, j2, num2, str3, bool, tvType, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResultEpisode) {
            ResultEpisode resultEpisode = (ResultEpisode) obj;
            return Intrinsics.areEqual(this.headerName, resultEpisode.headerName) && Intrinsics.areEqual(this.name, resultEpisode.name) && Intrinsics.areEqual(this.poster, resultEpisode.poster) && this.episode == resultEpisode.episode && Intrinsics.areEqual(this.season, resultEpisode.season) && Intrinsics.areEqual(this.data, resultEpisode.data) && Intrinsics.areEqual(this.apiName, resultEpisode.apiName) && this.f10017id == resultEpisode.f10017id && this.index == resultEpisode.index && this.position == resultEpisode.position && this.duration == resultEpisode.duration && Intrinsics.areEqual(this.rating, resultEpisode.rating) && Intrinsics.areEqual(this.description, resultEpisode.description) && Intrinsics.areEqual(this.isFiller, resultEpisode.isFiller) && this.tvType == resultEpisode.tvType && this.parentId == resultEpisode.parentId;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.headerName.hashCode() * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.poster;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.episode) * 31;
        Integer num = this.season;
        int hashCode4 = (((((((((((((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + this.data.hashCode()) * 31) + this.apiName.hashCode()) * 31) + this.f10017id) * 31) + this.index) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.position)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.duration)) * 31;
        Integer num2 = this.rating;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isFiller;
        return ((((hashCode6 + (bool != null ? bool.hashCode() : 0)) * 31) + this.tvType.hashCode()) * 31) + this.parentId;
    }

    public String toString() {
        return "ResultEpisode(headerName=" + this.headerName + ", name=" + this.name + ", poster=" + this.poster + ", episode=" + this.episode + ", season=" + this.season + ", data=" + this.data + ", apiName=" + this.apiName + ", id=" + this.f10017id + ", index=" + this.index + ", position=" + this.position + ", duration=" + this.duration + ", rating=" + this.rating + ", description=" + this.description + ", isFiller=" + this.isFiller + ", tvType=" + this.tvType + ", parentId=" + this.parentId + ')';
    }

    public ResultEpisode(String headerName, String str, String str2, int i, Integer num, String data, String apiName, int i2, int i3, long j, long j2, Integer num2, String str3, Boolean bool, TvType tvType, int i4) {
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(tvType, "tvType");
        this.headerName = headerName;
        this.name = str;
        this.poster = str2;
        this.episode = i;
        this.season = num;
        this.data = data;
        this.apiName = apiName;
        this.f10017id = i2;
        this.index = i3;
        this.position = j;
        this.duration = j2;
        this.rating = num2;
        this.description = str3;
        this.isFiller = bool;
        this.tvType = tvType;
        this.parentId = i4;
    }

    public final String getHeaderName() {
        return this.headerName;
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

    public final String getData() {
        return this.data;
    }

    public final String getApiName() {
        return this.apiName;
    }

    public final int getId() {
        return this.f10017id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getPosition() {
        return this.position;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final Integer getRating() {
        return this.rating;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Boolean isFiller() {
        return this.isFiller;
    }

    public final TvType getTvType() {
        return this.tvType;
    }

    public final int getParentId() {
        return this.parentId;
    }
}
