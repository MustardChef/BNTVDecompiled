package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OkRuExtractor.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Flashvars;", "", TtmlNode.TAG_METADATA, "", "hlsManifestUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getHlsManifestUrl", "()Ljava/lang/String;", "setHlsManifestUrl", "(Ljava/lang/String;)V", "getMetadata", "setMetadata", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Flashvars {
    private String hlsManifestUrl;
    private String metadata;

    public Flashvars() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ Flashvars copy$default(Flashvars flashvars, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = flashvars.metadata;
        }
        if ((i & 2) != 0) {
            str2 = flashvars.hlsManifestUrl;
        }
        return flashvars.copy(str, str2);
    }

    public final String component1() {
        return this.metadata;
    }

    public final String component2() {
        return this.hlsManifestUrl;
    }

    public final Flashvars copy(@JsonProperty("metadata") String str, @JsonProperty("hlsManifestUrl") String str2) {
        return new Flashvars(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Flashvars) {
            Flashvars flashvars = (Flashvars) obj;
            return Intrinsics.areEqual(this.metadata, flashvars.metadata) && Intrinsics.areEqual(this.hlsManifestUrl, flashvars.hlsManifestUrl);
        }
        return false;
    }

    public int hashCode() {
        String str = this.metadata;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hlsManifestUrl;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Flashvars(metadata=" + this.metadata + ", hlsManifestUrl=" + this.hlsManifestUrl + ')';
    }

    public Flashvars(@JsonProperty("metadata") String str, @JsonProperty("hlsManifestUrl") String str2) {
        this.metadata = str;
        this.hlsManifestUrl = str2;
    }

    public /* synthetic */ Flashvars(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(String str) {
        this.metadata = str;
    }

    public final String getHlsManifestUrl() {
        return this.hlsManifestUrl;
    }

    public final void setHlsManifestUrl(String str) {
        this.hlsManifestUrl = str;
    }
}
