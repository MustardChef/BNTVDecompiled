package com.phimhd;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigHome.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001e"}, m107d2 = {"Lcom/phimhd/Banner;", "", "title", "", "urlPhoto", TvContractCompat.Channels.Logo.CONTENT_DIRECTORY, "isSponsor", "", "urlStream", "urlDetail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getLogo", "()Ljava/lang/String;", "getTitle", "getUrlDetail", "getUrlPhoto", "getUrlStream", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Banner {
    private final boolean isSponsor;
    private final String logo;
    private final String title;
    private final String urlDetail;
    private final String urlPhoto;
    private final String urlStream;

    public static /* synthetic */ Banner copy$default(Banner banner, String str, String str2, String str3, boolean z, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = banner.title;
        }
        if ((i & 2) != 0) {
            str2 = banner.urlPhoto;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = banner.logo;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            z = banner.isSponsor;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str4 = banner.urlStream;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = banner.urlDetail;
        }
        return banner.copy(str, str6, str7, z2, str8, str5);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.urlPhoto;
    }

    public final String component3() {
        return this.logo;
    }

    public final boolean component4() {
        return this.isSponsor;
    }

    public final String component5() {
        return this.urlStream;
    }

    public final String component6() {
        return this.urlDetail;
    }

    public final Banner copy(@JsonProperty("title") String title, @JsonProperty("urlPhoto") String urlPhoto, @JsonProperty("logo") String logo, @JsonProperty("isSponsor") boolean z, @JsonProperty("urlStream") String str, @JsonProperty("urlDetail") String str2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(urlPhoto, "urlPhoto");
        Intrinsics.checkNotNullParameter(logo, "logo");
        return new Banner(title, urlPhoto, logo, z, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Banner) {
            Banner banner = (Banner) obj;
            return Intrinsics.areEqual(this.title, banner.title) && Intrinsics.areEqual(this.urlPhoto, banner.urlPhoto) && Intrinsics.areEqual(this.logo, banner.logo) && this.isSponsor == banner.isSponsor && Intrinsics.areEqual(this.urlStream, banner.urlStream) && Intrinsics.areEqual(this.urlDetail, banner.urlDetail);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.urlPhoto.hashCode()) * 31) + this.logo.hashCode()) * 31;
        boolean z = this.isSponsor;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        String str = this.urlStream;
        int hashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.urlDetail;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Banner(title=" + this.title + ", urlPhoto=" + this.urlPhoto + ", logo=" + this.logo + ", isSponsor=" + this.isSponsor + ", urlStream=" + this.urlStream + ", urlDetail=" + this.urlDetail + ')';
    }

    public Banner(@JsonProperty("title") String title, @JsonProperty("urlPhoto") String urlPhoto, @JsonProperty("logo") String logo, @JsonProperty("isSponsor") boolean z, @JsonProperty("urlStream") String str, @JsonProperty("urlDetail") String str2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(urlPhoto, "urlPhoto");
        Intrinsics.checkNotNullParameter(logo, "logo");
        this.title = title;
        this.urlPhoto = urlPhoto;
        this.logo = logo;
        this.isSponsor = z;
        this.urlStream = str;
        this.urlDetail = str2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrlPhoto() {
        return this.urlPhoto;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final boolean isSponsor() {
        return this.isSponsor;
    }

    public final String getUrlStream() {
        return this.urlStream;
    }

    public final String getUrlDetail() {
        return this.urlDetail;
    }
}
