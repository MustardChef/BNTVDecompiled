package com.lagradost.cloudstream3.utils;

import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExtractorApi.kt */
@Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J=\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/ExtractorSubtitleLink;", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$IDownloadableMinimum;", "name", "", "url", "referer", "headers", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getHeaders", "()Ljava/util/Map;", "getName", "()Ljava/lang/String;", "getReferer", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ExtractorSubtitleLink implements VideoDownloadManager.IDownloadableMinimum {
    private final Map<String, String> headers;
    private final String name;
    private final String referer;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtractorSubtitleLink copy$default(ExtractorSubtitleLink extractorSubtitleLink, String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = extractorSubtitleLink.name;
        }
        if ((i & 2) != 0) {
            str2 = extractorSubtitleLink.getUrl();
        }
        if ((i & 4) != 0) {
            str3 = extractorSubtitleLink.getReferer();
        }
        if ((i & 8) != 0) {
            map = extractorSubtitleLink.getHeaders();
        }
        return extractorSubtitleLink.copy(str, str2, str3, map);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return getUrl();
    }

    public final String component3() {
        return getReferer();
    }

    public final Map<String, String> component4() {
        return getHeaders();
    }

    public final ExtractorSubtitleLink copy(String name, String url, String referer, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(referer, "referer");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new ExtractorSubtitleLink(name, url, referer, headers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExtractorSubtitleLink) {
            ExtractorSubtitleLink extractorSubtitleLink = (ExtractorSubtitleLink) obj;
            return Intrinsics.areEqual(this.name, extractorSubtitleLink.name) && Intrinsics.areEqual(getUrl(), extractorSubtitleLink.getUrl()) && Intrinsics.areEqual(getReferer(), extractorSubtitleLink.getReferer()) && Intrinsics.areEqual(getHeaders(), extractorSubtitleLink.getHeaders());
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + getUrl().hashCode()) * 31) + getReferer().hashCode()) * 31) + getHeaders().hashCode();
    }

    public String toString() {
        return "ExtractorSubtitleLink(name=" + this.name + ", url=" + getUrl() + ", referer=" + getReferer() + ", headers=" + getHeaders() + ')';
    }

    public ExtractorSubtitleLink(String name, String url, String referer, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(referer, "referer");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.name = name;
        this.url = url;
        this.referer = referer;
        this.headers = headers;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.utils.VideoDownloadManager.IDownloadableMinimum
    public String getUrl() {
        return this.url;
    }

    @Override // com.lagradost.cloudstream3.utils.VideoDownloadManager.IDownloadableMinimum
    public String getReferer() {
        return this.referer;
    }

    public /* synthetic */ ExtractorSubtitleLink(String str, String str2, String str3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? MapsKt.emptyMap() : map);
    }

    @Override // com.lagradost.cloudstream3.utils.VideoDownloadManager.IDownloadableMinimum
    public Map<String, String> getHeaders() {
        return this.headers;
    }
}
