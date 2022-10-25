package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Genre;", "", "name", "", "pivot", "Lcom/lagradost/cloudstream3/movieproviders/Pivot;", "(Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/Pivot;)V", "getName", "()Ljava/lang/String;", "getPivot", "()Lcom/lagradost/cloudstream3/movieproviders/Pivot;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Genre {
    private final String name;
    private final Pivot pivot;

    public static /* synthetic */ Genre copy$default(Genre genre, String str, Pivot pivot, int i, Object obj) {
        if ((i & 1) != 0) {
            str = genre.name;
        }
        if ((i & 2) != 0) {
            pivot = genre.pivot;
        }
        return genre.copy(str, pivot);
    }

    public final String component1() {
        return this.name;
    }

    public final Pivot component2() {
        return this.pivot;
    }

    public final Genre copy(@JsonProperty("name") String name, @JsonProperty("pivot") Pivot pivot) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(pivot, "pivot");
        return new Genre(name, pivot);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Genre) {
            Genre genre = (Genre) obj;
            return Intrinsics.areEqual(this.name, genre.name) && Intrinsics.areEqual(this.pivot, genre.pivot);
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.pivot.hashCode();
    }

    public String toString() {
        return "Genre(name=" + this.name + ", pivot=" + this.pivot + ')';
    }

    public Genre(@JsonProperty("name") String name, @JsonProperty("pivot") Pivot pivot) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(pivot, "pivot");
        this.name = name;
        this.pivot = pivot;
    }

    public final String getName() {
        return this.name;
    }

    public final Pivot getPivot() {
        return this.pivot;
    }
}
