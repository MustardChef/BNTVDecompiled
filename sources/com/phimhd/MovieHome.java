package com.phimhd;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigHome.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, m107d2 = {"Lcom/phimhd/MovieHome;", "", "title", "", "urlDetail", "urlPhoto", "urlStream", "isSponsor", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getTitle", "()Ljava/lang/String;", "getUrlDetail", "getUrlPhoto", "getUrlStream", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class MovieHome {
    private final boolean isSponsor;
    private final String title;
    private final String urlDetail;
    private final String urlPhoto;
    private final String urlStream;

    public static /* synthetic */ MovieHome copy$default(MovieHome movieHome, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = movieHome.title;
        }
        if ((i & 2) != 0) {
            str2 = movieHome.urlDetail;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = movieHome.urlPhoto;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = movieHome.urlStream;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = movieHome.isSponsor;
        }
        return movieHome.copy(str, str5, str6, str7, z);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.urlDetail;
    }

    public final String component3() {
        return this.urlPhoto;
    }

    public final String component4() {
        return this.urlStream;
    }

    public final boolean component5() {
        return this.isSponsor;
    }

    public final MovieHome copy(@JsonProperty("title") String title, @JsonProperty("urlDetail") String urlDetail, @JsonProperty("urlPhoto") String urlPhoto, @JsonProperty("urlStream") String urlStream, @JsonProperty("isSponsor") boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(urlDetail, "urlDetail");
        Intrinsics.checkNotNullParameter(urlPhoto, "urlPhoto");
        Intrinsics.checkNotNullParameter(urlStream, "urlStream");
        return new MovieHome(title, urlDetail, urlPhoto, urlStream, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MovieHome) {
            MovieHome movieHome = (MovieHome) obj;
            return Intrinsics.areEqual(this.title, movieHome.title) && Intrinsics.areEqual(this.urlDetail, movieHome.urlDetail) && Intrinsics.areEqual(this.urlPhoto, movieHome.urlPhoto) && Intrinsics.areEqual(this.urlStream, movieHome.urlStream) && this.isSponsor == movieHome.isSponsor;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.title.hashCode() * 31) + this.urlDetail.hashCode()) * 31) + this.urlPhoto.hashCode()) * 31) + this.urlStream.hashCode()) * 31;
        boolean z = this.isSponsor;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "MovieHome(title=" + this.title + ", urlDetail=" + this.urlDetail + ", urlPhoto=" + this.urlPhoto + ", urlStream=" + this.urlStream + ", isSponsor=" + this.isSponsor + ')';
    }

    public MovieHome(@JsonProperty("title") String title, @JsonProperty("urlDetail") String urlDetail, @JsonProperty("urlPhoto") String urlPhoto, @JsonProperty("urlStream") String urlStream, @JsonProperty("isSponsor") boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(urlDetail, "urlDetail");
        Intrinsics.checkNotNullParameter(urlPhoto, "urlPhoto");
        Intrinsics.checkNotNullParameter(urlStream, "urlStream");
        this.title = title;
        this.urlDetail = urlDetail;
        this.urlPhoto = urlPhoto;
        this.urlStream = urlStream;
        this.isSponsor = z;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrlDetail() {
        return this.urlDetail;
    }

    public final String getUrlPhoto() {
        return this.urlPhoto;
    }

    public final String getUrlStream() {
        return this.urlStream;
    }

    public final boolean isSponsor() {
        return this.isSponsor;
    }
}
