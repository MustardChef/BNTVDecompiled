package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrailersTwoProvider.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/QueryParameters;", "", "imdbid", "", "(Ljava/lang/String;)V", "getImdbid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class QueryParameters {
    private final String imdbid;

    public static /* synthetic */ QueryParameters copy$default(QueryParameters queryParameters, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = queryParameters.imdbid;
        }
        return queryParameters.copy(str);
    }

    public final String component1() {
        return this.imdbid;
    }

    public final QueryParameters copy(@JsonProperty("imdbid") String str) {
        return new QueryParameters(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QueryParameters) && Intrinsics.areEqual(this.imdbid, ((QueryParameters) obj).imdbid);
    }

    public int hashCode() {
        String str = this.imdbid;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "QueryParameters(imdbid=" + this.imdbid + ')';
    }

    public QueryParameters(@JsonProperty("imdbid") String str) {
        this.imdbid = str;
    }

    public final String getImdbid() {
        return this.imdbid;
    }
}
