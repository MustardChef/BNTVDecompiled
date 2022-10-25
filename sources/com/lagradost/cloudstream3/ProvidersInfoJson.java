package com.lagradost.cloudstream3;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u001f"}, m107d2 = {"Lcom/lagradost/cloudstream3/ProvidersInfoJson;", "", "name", "", "url", "credentials", "status", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getCredentials", "()Ljava/lang/String;", "setCredentials", "(Ljava/lang/String;)V", "getName", "setName", "getStatus", "()I", "setStatus", "(I)V", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class ProvidersInfoJson {
    private String credentials;
    private String name;
    private int status;
    private String url;

    public static /* synthetic */ ProvidersInfoJson copy$default(ProvidersInfoJson providersInfoJson, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = providersInfoJson.name;
        }
        if ((i2 & 2) != 0) {
            str2 = providersInfoJson.url;
        }
        if ((i2 & 4) != 0) {
            str3 = providersInfoJson.credentials;
        }
        if ((i2 & 8) != 0) {
            i = providersInfoJson.status;
        }
        return providersInfoJson.copy(str, str2, str3, i);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.credentials;
    }

    public final int component4() {
        return this.status;
    }

    public final ProvidersInfoJson copy(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("credentials") String str, @JsonProperty("status") int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        return new ProvidersInfoJson(name, url, str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProvidersInfoJson) {
            ProvidersInfoJson providersInfoJson = (ProvidersInfoJson) obj;
            return Intrinsics.areEqual(this.name, providersInfoJson.name) && Intrinsics.areEqual(this.url, providersInfoJson.url) && Intrinsics.areEqual(this.credentials, providersInfoJson.credentials) && this.status == providersInfoJson.status;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.url.hashCode()) * 31;
        String str = this.credentials;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.status;
    }

    public String toString() {
        return "ProvidersInfoJson(name=" + this.name + ", url=" + this.url + ", credentials=" + this.credentials + ", status=" + this.status + ')';
    }

    public ProvidersInfoJson(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("credentials") String str, @JsonProperty("status") int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        this.name = name;
        this.url = url;
        this.credentials = str;
        this.status = i;
    }

    public /* synthetic */ ProvidersInfoJson(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? null : str3, i);
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

    public final String getCredentials() {
        return this.credentials;
    }

    public final void setCredentials(String str) {
        this.credentials = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }
}
