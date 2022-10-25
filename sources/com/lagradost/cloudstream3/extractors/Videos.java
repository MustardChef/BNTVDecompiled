package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OkRuExtractor.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ:\u0010\u001e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012¨\u0006$"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Videos;", "", "name", "", "url", "seekSchema", "", "disallowed", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getDisallowed", "()Ljava/lang/Boolean;", "setDisallowed", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getSeekSchema", "()Ljava/lang/Integer;", "setSeekSchema", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/lagradost/cloudstream3/extractors/Videos;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Videos {
    private Boolean disallowed;
    private String name;
    private Integer seekSchema;
    private String url;

    public static /* synthetic */ Videos copy$default(Videos videos, String str, String str2, Integer num, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videos.name;
        }
        if ((i & 2) != 0) {
            str2 = videos.url;
        }
        if ((i & 4) != 0) {
            num = videos.seekSchema;
        }
        if ((i & 8) != 0) {
            bool = videos.disallowed;
        }
        return videos.copy(str, str2, num, bool);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.url;
    }

    public final Integer component3() {
        return this.seekSchema;
    }

    public final Boolean component4() {
        return this.disallowed;
    }

    public final Videos copy(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("seekSchema") Integer num, @JsonProperty("disallowed") Boolean bool) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        return new Videos(name, url, num, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Videos) {
            Videos videos = (Videos) obj;
            return Intrinsics.areEqual(this.name, videos.name) && Intrinsics.areEqual(this.url, videos.url) && Intrinsics.areEqual(this.seekSchema, videos.seekSchema) && Intrinsics.areEqual(this.disallowed, videos.disallowed);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.url.hashCode()) * 31;
        Integer num = this.seekSchema;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.disallowed;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "Videos(name=" + this.name + ", url=" + this.url + ", seekSchema=" + this.seekSchema + ", disallowed=" + this.disallowed + ')';
    }

    public Videos(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("seekSchema") Integer num, @JsonProperty("disallowed") Boolean bool) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        this.name = name;
        this.url = url;
        this.seekSchema = num;
        this.disallowed = bool;
    }

    public /* synthetic */ Videos(String str, String str2, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : bool);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final Integer getSeekSchema() {
        return this.seekSchema;
    }

    public final void setSeekSchema(Integer num) {
        this.seekSchema = num;
    }

    public final Boolean getDisallowed() {
        return this.disallowed;
    }

    public final void setDisallowed(Boolean bool) {
        this.disallowed = bool;
    }
}
