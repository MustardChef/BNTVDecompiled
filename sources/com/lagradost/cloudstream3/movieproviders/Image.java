package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Image;", "", "imageableID", "", "imageableType", "", "serverID", "proxyID", "url", "type", "(JLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "getImageableID", "()J", "getImageableType", "()Ljava/lang/String;", "getProxyID", "getServerID", "getType", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Image {
    private final long imageableID;
    private final String imageableType;
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

    public final Image copy(@JsonProperty("imageable_id") long j, @JsonProperty("imageable_type") String imageableType, @JsonProperty("server_id") long j2, @JsonProperty("proxy_id") long j3, @JsonProperty("url") String url, @JsonProperty("type") String type) {
        Intrinsics.checkNotNullParameter(imageableType, "imageableType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        return new Image(j, imageableType, j2, j3, url, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Image) {
            Image image = (Image) obj;
            return this.imageableID == image.imageableID && Intrinsics.areEqual(this.imageableType, image.imageableType) && this.serverID == image.serverID && this.proxyID == image.proxyID && Intrinsics.areEqual(this.url, image.url) && Intrinsics.areEqual(this.type, image.type);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.imageableID) * 31) + this.imageableType.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.serverID)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.proxyID)) * 31) + this.url.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "Image(imageableID=" + this.imageableID + ", imageableType=" + this.imageableType + ", serverID=" + this.serverID + ", proxyID=" + this.proxyID + ", url=" + this.url + ", type=" + this.type + ')';
    }

    public Image(@JsonProperty("imageable_id") long j, @JsonProperty("imageable_type") String imageableType, @JsonProperty("server_id") long j2, @JsonProperty("proxy_id") long j3, @JsonProperty("url") String url, @JsonProperty("type") String type) {
        Intrinsics.checkNotNullParameter(imageableType, "imageableType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        this.imageableID = j;
        this.imageableType = imageableType;
        this.serverID = j2;
        this.proxyID = j3;
        this.url = url;
        this.type = type;
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
}
