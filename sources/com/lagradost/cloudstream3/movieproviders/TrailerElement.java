package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b<\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00104\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jæ\u0001\u0010?\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b&\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b*\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b,\u0010\u001c¨\u0006G"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TrailerElement;", "", "id", "", "url", "", "host", "videoableID", "videoableType", "createdAt", "updatedAt", "size", "createdBy", "serverID", "name", "quality", "originalName", "views", "public", "proxyID", "proxyDefaultID", "scwsID", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getCreatedAt", "()Ljava/lang/String;", "getCreatedBy", "getHost", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "getOriginalName", "()Ljava/lang/Object;", "getProxyDefaultID", "getProxyID", "getPublic", "getQuality", "getScwsID", "getServerID", "getSize", "getUpdatedAt", "getUrl", "getVideoableID", "getVideoableType", "getViews", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/lagradost/cloudstream3/movieproviders/TrailerElement;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class TrailerElement {
    private final String createdAt;
    private final String createdBy;
    private final String host;

    /* renamed from: id */
    private final Long f9988id;
    private final String name;
    private final Object originalName;
    private final Object proxyDefaultID;
    private final Object proxyID;

    /* renamed from: public  reason: not valid java name */
    private final Long f10816public;
    private final String quality;
    private final Object scwsID;
    private final Long serverID;
    private final String size;
    private final String updatedAt;
    private final String url;
    private final Long videoableID;
    private final String videoableType;
    private final Long views;

    public TrailerElement() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    public final Long component1() {
        return this.f9988id;
    }

    public final Long component10() {
        return this.serverID;
    }

    public final String component11() {
        return this.name;
    }

    public final String component12() {
        return this.quality;
    }

    public final Object component13() {
        return this.originalName;
    }

    public final Long component14() {
        return this.views;
    }

    public final Long component15() {
        return this.f10816public;
    }

    public final Object component16() {
        return this.proxyID;
    }

    public final Object component17() {
        return this.proxyDefaultID;
    }

    public final Object component18() {
        return this.scwsID;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.host;
    }

    public final Long component4() {
        return this.videoableID;
    }

    public final String component5() {
        return this.videoableType;
    }

    public final String component6() {
        return this.createdAt;
    }

    public final String component7() {
        return this.updatedAt;
    }

    public final String component8() {
        return this.size;
    }

    public final String component9() {
        return this.createdBy;
    }

    public final TrailerElement copy(@JsonProperty("id") Long l, @JsonProperty("url") String str, @JsonProperty("host") String str2, @JsonProperty("videoable_id") Long l2, @JsonProperty("videoable_type") String str3, @JsonProperty("created_at") String str4, @JsonProperty("updated_at") String str5, @JsonProperty("size") String str6, @JsonProperty("created_by") String str7, @JsonProperty("server_id") Long l3, @JsonProperty("name") String str8, @JsonProperty("quality") String str9, @JsonProperty("original_name") Object obj, @JsonProperty("views") Long l4, @JsonProperty("public") Long l5, @JsonProperty("proxy_id") Object obj2, @JsonProperty("proxy_default_id") Object obj3, @JsonProperty("scws_id") Object obj4) {
        return new TrailerElement(l, str, str2, l2, str3, str4, str5, str6, str7, l3, str8, str9, obj, l4, l5, obj2, obj3, obj4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TrailerElement) {
            TrailerElement trailerElement = (TrailerElement) obj;
            return Intrinsics.areEqual(this.f9988id, trailerElement.f9988id) && Intrinsics.areEqual(this.url, trailerElement.url) && Intrinsics.areEqual(this.host, trailerElement.host) && Intrinsics.areEqual(this.videoableID, trailerElement.videoableID) && Intrinsics.areEqual(this.videoableType, trailerElement.videoableType) && Intrinsics.areEqual(this.createdAt, trailerElement.createdAt) && Intrinsics.areEqual(this.updatedAt, trailerElement.updatedAt) && Intrinsics.areEqual(this.size, trailerElement.size) && Intrinsics.areEqual(this.createdBy, trailerElement.createdBy) && Intrinsics.areEqual(this.serverID, trailerElement.serverID) && Intrinsics.areEqual(this.name, trailerElement.name) && Intrinsics.areEqual(this.quality, trailerElement.quality) && Intrinsics.areEqual(this.originalName, trailerElement.originalName) && Intrinsics.areEqual(this.views, trailerElement.views) && Intrinsics.areEqual(this.f10816public, trailerElement.f10816public) && Intrinsics.areEqual(this.proxyID, trailerElement.proxyID) && Intrinsics.areEqual(this.proxyDefaultID, trailerElement.proxyDefaultID) && Intrinsics.areEqual(this.scwsID, trailerElement.scwsID);
        }
        return false;
    }

    public int hashCode() {
        Long l = this.f9988id;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.url;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.host;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.videoableID;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str3 = this.videoableType;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.createdAt;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.updatedAt;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.size;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.createdBy;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l3 = this.serverID;
        int hashCode10 = (hashCode9 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str8 = this.name;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.quality;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Object obj = this.originalName;
        int hashCode13 = (hashCode12 + (obj == null ? 0 : obj.hashCode())) * 31;
        Long l4 = this.views;
        int hashCode14 = (hashCode13 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.f10816public;
        int hashCode15 = (hashCode14 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Object obj2 = this.proxyID;
        int hashCode16 = (hashCode15 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.proxyDefaultID;
        int hashCode17 = (hashCode16 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
        Object obj4 = this.scwsID;
        return hashCode17 + (obj4 != null ? obj4.hashCode() : 0);
    }

    public String toString() {
        return "TrailerElement(id=" + this.f9988id + ", url=" + this.url + ", host=" + this.host + ", videoableID=" + this.videoableID + ", videoableType=" + this.videoableType + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", size=" + this.size + ", createdBy=" + this.createdBy + ", serverID=" + this.serverID + ", name=" + this.name + ", quality=" + this.quality + ", originalName=" + this.originalName + ", views=" + this.views + ", public=" + this.f10816public + ", proxyID=" + this.proxyID + ", proxyDefaultID=" + this.proxyDefaultID + ", scwsID=" + this.scwsID + ')';
    }

    public TrailerElement(@JsonProperty("id") Long l, @JsonProperty("url") String str, @JsonProperty("host") String str2, @JsonProperty("videoable_id") Long l2, @JsonProperty("videoable_type") String str3, @JsonProperty("created_at") String str4, @JsonProperty("updated_at") String str5, @JsonProperty("size") String str6, @JsonProperty("created_by") String str7, @JsonProperty("server_id") Long l3, @JsonProperty("name") String str8, @JsonProperty("quality") String str9, @JsonProperty("original_name") Object obj, @JsonProperty("views") Long l4, @JsonProperty("public") Long l5, @JsonProperty("proxy_id") Object obj2, @JsonProperty("proxy_default_id") Object obj3, @JsonProperty("scws_id") Object obj4) {
        this.f9988id = l;
        this.url = str;
        this.host = str2;
        this.videoableID = l2;
        this.videoableType = str3;
        this.createdAt = str4;
        this.updatedAt = str5;
        this.size = str6;
        this.createdBy = str7;
        this.serverID = l3;
        this.name = str8;
        this.quality = str9;
        this.originalName = obj;
        this.views = l4;
        this.f10816public = l5;
        this.proxyID = obj2;
        this.proxyDefaultID = obj3;
        this.scwsID = obj4;
    }

    public /* synthetic */ TrailerElement(Long l, String str, String str2, Long l2, String str3, String str4, String str5, String str6, String str7, Long l3, String str8, String str9, Object obj, Long l4, Long l5, Object obj2, Object obj3, Object obj4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : l3, (i & 1024) != 0 ? null : str8, (i & 2048) != 0 ? null : str9, (i & 4096) != 0 ? null : obj, (i & 8192) != 0 ? null : l4, (i & 16384) != 0 ? null : l5, (i & 32768) != 0 ? null : obj2, (i & 65536) != 0 ? null : obj3, (i & 131072) != 0 ? null : obj4);
    }

    public final Long getId() {
        return this.f9988id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getHost() {
        return this.host;
    }

    public final Long getVideoableID() {
        return this.videoableID;
    }

    public final String getVideoableType() {
        return this.videoableType;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getSize() {
        return this.size;
    }

    public final String getCreatedBy() {
        return this.createdBy;
    }

    public final Long getServerID() {
        return this.serverID;
    }

    public final String getName() {
        return this.name;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final Object getOriginalName() {
        return this.originalName;
    }

    public final Long getViews() {
        return this.views;
    }

    public final Long getPublic() {
        return this.f10816public;
    }

    public final Object getProxyID() {
        return this.proxyID;
    }

    public final Object getProxyDefaultID() {
        return this.proxyDefaultID;
    }

    public final Object getScwsID() {
        return this.scwsID;
    }
}
