package com.lagradost.cloudstream3.utils;

import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExtractorApi.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$IDownloadableMinimum;", "source", "", "name", "url", "referer", "quality", "", "isM3u8", "", "headers", "", "extractorData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/Map;Ljava/lang/String;)V", "getExtractorData", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "()Z", "getName", "getQuality", "()I", "getReferer", "getSource", "getUrl", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public class ExtractorLink implements VideoDownloadManager.IDownloadableMinimum {
    private final String extractorData;
    private final Map<String, String> headers;
    private final boolean isM3u8;
    private final String name;
    private final int quality;
    private final String referer;
    private final String source;
    private final String url;

    public ExtractorLink(String source, String name, String url, String referer, int i, boolean z, Map<String, String> headers, String str) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(referer, "referer");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.source = source;
        this.name = name;
        this.url = url;
        this.referer = referer;
        this.quality = i;
        this.isM3u8 = z;
        this.headers = headers;
        this.extractorData = str;
    }

    public String getSource() {
        return this.source;
    }

    public String getName() {
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

    public int getQuality() {
        return this.quality;
    }

    public boolean isM3u8() {
        return this.isM3u8;
    }

    public /* synthetic */ ExtractorLink(String str, String str2, String str3, String str4, int i, boolean z, Map map, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? MapsKt.emptyMap() : map, (i2 & 128) != 0 ? null : str5);
    }

    @Override // com.lagradost.cloudstream3.utils.VideoDownloadManager.IDownloadableMinimum
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getExtractorData() {
        return this.extractorData;
    }

    public String toString() {
        return "ExtractorLink(name=" + getName() + ", url=" + getUrl() + ", referer=" + getReferer() + ", isM3u8=" + isM3u8() + ')';
    }
}
