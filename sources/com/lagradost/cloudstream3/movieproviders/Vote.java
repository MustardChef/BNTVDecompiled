package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Vote;", "", "title_id", "", "average", "", "count", "type", "(JLjava/lang/String;JLjava/lang/String;)V", "getAverage", "()Ljava/lang/String;", "getCount", "()J", "getTitle_id", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Vote {
    private final String average;
    private final long count;
    private final long title_id;
    private final String type;

    public static /* synthetic */ Vote copy$default(Vote vote, long j, String str, long j2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = vote.title_id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = vote.average;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            j2 = vote.count;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            str2 = vote.type;
        }
        return vote.copy(j3, str3, j4, str2);
    }

    public final long component1() {
        return this.title_id;
    }

    public final String component2() {
        return this.average;
    }

    public final long component3() {
        return this.count;
    }

    public final String component4() {
        return this.type;
    }

    public final Vote copy(@JsonProperty("title_id") long j, @JsonProperty("average") String average, @JsonProperty("count") long j2, @JsonProperty("type") String type) {
        Intrinsics.checkNotNullParameter(average, "average");
        Intrinsics.checkNotNullParameter(type, "type");
        return new Vote(j, average, j2, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Vote) {
            Vote vote = (Vote) obj;
            return this.title_id == vote.title_id && Intrinsics.areEqual(this.average, vote.average) && this.count == vote.count && Intrinsics.areEqual(this.type, vote.type);
        }
        return false;
    }

    public int hashCode() {
        return (((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.title_id) * 31) + this.average.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.count)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "Vote(title_id=" + this.title_id + ", average=" + this.average + ", count=" + this.count + ", type=" + this.type + ')';
    }

    public Vote(@JsonProperty("title_id") long j, @JsonProperty("average") String average, @JsonProperty("count") long j2, @JsonProperty("type") String type) {
        Intrinsics.checkNotNullParameter(average, "average");
        Intrinsics.checkNotNullParameter(type, "type");
        this.title_id = j;
        this.average = average;
        this.count = j2;
        this.type = type;
    }

    public final long getTitle_id() {
        return this.title_id;
    }

    public final String getAverage() {
        return this.average;
    }

    public final long getCount() {
        return this.count;
    }

    public final String getType() {
        return this.type;
    }
}
