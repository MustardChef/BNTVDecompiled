package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/ImageSeason;", "", "imageableID", "", "imageableType", "", "serverID", "proxyID", "url", "type", "originalURL", "(JLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageableID", "()J", "getImageableType", "()Ljava/lang/String;", "getOriginalURL", "getProxyID", "getServerID", "getType", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class ImageSeason {
    private final long imageableID;
    private final String imageableType;
    private final String originalURL;
    private final long proxyID;
    private final long serverID;
    private final String type;
    private final String url;

    public final long component1() {
        return this.imageableID;
    }

    public final String component2() {
        return this.imageableType;
    }

    public final long component3() {
        return this.serverID;
    }

    public final long component4() {
        return this.proxyID;
    }

    public final String component5() {
        return this.url;
    }

    public final String component6() {
        return this.type;
    }

    public final String component7() {
        return this.originalURL;
    }

    public final ImageSeason copy(@JsonProperty("imageable_id") long j, @JsonProperty("imageable_type") String imageableType, @JsonProperty("server_id") long j2, @JsonProperty("proxy_id") long j3, @JsonProperty("url") String url, @JsonProperty("type") String type, @JsonProperty("original_url") String originalURL) {
        Intrinsics.checkNotNullParameter(imageableType, "imageableType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(originalURL, "originalURL");
        return new ImageSeason(j, imageableType, j2, j3, url, type, originalURL);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageSeason) {
            ImageSeason imageSeason = (ImageSeason) obj;
            return this.imageableID == imageSeason.imageableID && Intrinsics.areEqual(this.imageableType, imageSeason.imageableType) && this.serverID == imageSeason.serverID && this.proxyID == imageSeason.proxyID && Intrinsics.areEqual(this.url, imageSeason.url) && Intrinsics.areEqual(this.type, imageSeason.type) && Intrinsics.areEqual(this.originalURL, imageSeason.originalURL);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.imageableID) * 31) + this.imageableType.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.serverID)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.proxyID)) * 31) + this.url.hashCode()) * 31) + this.type.hashCode()) * 31) + this.originalURL.hashCode();
    }

    public String toString() {
        return "ImageSeason(imageableID=" + this.imageableID + ", imageableType=" + this.imageableType + ", serverID=" + this.serverID + ", proxyID=" + this.proxyID + ", url=" + this.url + ", type=" + this.type + ", originalURL=" + this.originalURL + ')';
    }

    public ImageSeason(@JsonProperty("imageable_id") long j, @JsonProperty("imageable_type") String imageableType, @JsonProperty("server_id") long j2, @JsonProperty("proxy_id") long j3, @JsonProperty("url") String url, @JsonProperty("type") String type, @JsonProperty("original_url") String originalURL) {
        Intrinsics.checkNotNullParameter(imageableType, "imageableType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(originalURL, "originalURL");
        this.imageableID = j;
        this.imageableType = imageableType;
        this.serverID = j2;
        this.proxyID = j3;
        this.url = url;
        this.type = type;
        this.originalURL = originalURL;
    }

    public final long getImageableID() {
        return this.imageableID;
    }

    public final String getImageableType() {
        return this.imageableType;
    }

    public final long getServerID() {
        return this.serverID;
    }

    public final long getProxyID() {
        return this.proxyID;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getType() {
        return this.type;
    }

    public final String getOriginalURL() {
        return this.originalURL;
    }
}
