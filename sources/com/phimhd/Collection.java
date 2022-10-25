package com.phimhd;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigHome.kt */
@Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, m107d2 = {"Lcom/phimhd/Collection;", "", "name", "", "urlDetail", "movies", "", "Lcom/phimhd/MovieHome;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getMovies", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getUrlDetail", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Collection {
    private final List<MovieHome> movies;
    private final String name;
    private final String urlDetail;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Collection copy$default(Collection collection, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = collection.name;
        }
        if ((i & 2) != 0) {
            str2 = collection.urlDetail;
        }
        if ((i & 4) != 0) {
            list = collection.movies;
        }
        return collection.copy(str, str2, list);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.urlDetail;
    }

    public final List<MovieHome> component3() {
        return this.movies;
    }

    public final Collection copy(@JsonProperty("name") String name, @JsonProperty("urlDetail") String urlDetail, @JsonProperty("movies") List<MovieHome> movies) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(urlDetail, "urlDetail");
        Intrinsics.checkNotNullParameter(movies, "movies");
        return new Collection(name, urlDetail, movies);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            return Intrinsics.areEqual(this.name, collection.name) && Intrinsics.areEqual(this.urlDetail, collection.urlDetail) && Intrinsics.areEqual(this.movies, collection.movies);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.urlDetail.hashCode()) * 31) + this.movies.hashCode();
    }

    public String toString() {
        return "Collection(name=" + this.name + ", urlDetail=" + this.urlDetail + ", movies=" + this.movies + ')';
    }

    public Collection(@JsonProperty("name") String name, @JsonProperty("urlDetail") String urlDetail, @JsonProperty("movies") List<MovieHome> movies) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(urlDetail, "urlDetail");
        Intrinsics.checkNotNullParameter(movies, "movies");
        this.name = name;
        this.urlDetail = urlDetail;
        this.movies = movies;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrlDetail() {
        return this.urlDetail;
    }

    public final List<MovieHome> getMovies() {
        return this.movies;
    }
}
