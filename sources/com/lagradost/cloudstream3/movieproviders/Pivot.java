package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Pivot;", "", "titleID", "", "genreID", "(JJ)V", "getGenreID", "()J", "getTitleID", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Pivot {
    private final long genreID;
    private final long titleID;

    public static /* synthetic */ Pivot copy$default(Pivot pivot, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pivot.titleID;
        }
        if ((i & 2) != 0) {
            j2 = pivot.genreID;
        }
        return pivot.copy(j, j2);
    }

    public final long component1() {
        return this.titleID;
    }

    public final long component2() {
        return this.genreID;
    }

    public final Pivot copy(@JsonProperty("titleID") long j, @JsonProperty("genreID") long j2) {
        return new Pivot(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pivot) {
            Pivot pivot = (Pivot) obj;
            return this.titleID == pivot.titleID && this.genreID == pivot.genreID;
        }
        return false;
    }

    public int hashCode() {
        return (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.titleID) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.genreID);
    }

    public String toString() {
        return "Pivot(titleID=" + this.titleID + ", genreID=" + this.genreID + ')';
    }

    public Pivot(@JsonProperty("titleID") long j, @JsonProperty("genreID") long j2) {
        this.titleID = j;
        this.genreID = j2;
    }

    public final long getTitleID() {
        return this.titleID;
    }

    public final long getGenreID() {
        return this.genreID;
    }
}
