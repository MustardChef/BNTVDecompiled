package com.lagradost.cloudstream3.utils;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExtractorApi.kt */
@Metadata(m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\nHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006+"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/ExtractorLinkPlayList;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "source", "", "name", "playlist", "", "Lcom/lagradost/cloudstream3/utils/PlayListItem;", "referer", "quality", "", "isM3u8", "", "headers", "", "extractorData", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;IZLjava/util/Map;Ljava/lang/String;)V", "getExtractorData", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "()Z", "getName", "getPlaylist", "()Ljava/util/List;", "getQuality", "()I", "getReferer", "getSource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ExtractorLinkPlayList extends ExtractorLink {
    private final String extractorData;
    private final Map<String, String> headers;
    private final boolean isM3u8;
    private final String name;
    private final List<PlayListItem> playlist;
    private final int quality;
    private final String referer;
    private final String source;

    public final String component1() {
        return getSource();
    }

    public final String component2() {
        return getName();
    }

    public final List<PlayListItem> component3() {
        return this.playlist;
    }

    public final String component4() {
        return getReferer();
    }

    public final int component5() {
        return getQuality();
    }

    public final boolean component6() {
        return isM3u8();
    }

    public final Map<String, String> component7() {
        return getHeaders();
    }

    public final String component8() {
        return getExtractorData();
    }

    public final ExtractorLinkPlayList copy(String source, String name, List<PlayListItem> playlist, String referer, int i, boolean z, Map<String, String> headers, String str) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(playlist, "playlist");
        Intrinsics.checkNotNullParameter(referer, "referer");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new ExtractorLinkPlayList(source, name, playlist, referer, i, z, headers, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExtractorLinkPlayList) {
            ExtractorLinkPlayList extractorLinkPlayList = (ExtractorLinkPlayList) obj;
            return Intrinsics.areEqual(getSource(), extractorLinkPlayList.getSource()) && Intrinsics.areEqual(getName(), extractorLinkPlayList.getName()) && Intrinsics.areEqual(this.playlist, extractorLinkPlayList.playlist) && Intrinsics.areEqual(getReferer(), extractorLinkPlayList.getReferer()) && getQuality() == extractorLinkPlayList.getQuality() && isM3u8() == extractorLinkPlayList.isM3u8() && Intrinsics.areEqual(getHeaders(), extractorLinkPlayList.getHeaders()) && Intrinsics.areEqual(getExtractorData(), extractorLinkPlayList.getExtractorData());
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((getSource().hashCode() * 31) + getName().hashCode()) * 31) + this.playlist.hashCode()) * 31) + getReferer().hashCode()) * 31) + getQuality()) * 31;
        boolean isM3u8 = isM3u8();
        int i = isM3u8;
        if (isM3u8) {
            i = 1;
        }
        return ((((hashCode + i) * 31) + getHeaders().hashCode()) * 31) + (getExtractorData() == null ? 0 : getExtractorData().hashCode());
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorLink
    public String toString() {
        return "ExtractorLinkPlayList(source=" + getSource() + ", name=" + getName() + ", playlist=" + this.playlist + ", referer=" + getReferer() + ", quality=" + getQuality() + ", isM3u8=" + isM3u8() + ", headers=" + getHeaders() + ", extractorData=" + getExtractorData() + ')';
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorLink
    public String getSource() {
        return this.source;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorLink
    public String getName() {
        return this.name;
    }

    public final List<PlayListItem> getPlaylist() {
        return this.playlist;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorLink, com.lagradost.cloudstream3.utils.VideoDownloadManager.IDownloadableMinimum
    public String getReferer() {
        return this.referer;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorLink
    public int getQuality() {
        return this.quality;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorLink
    public boolean isM3u8() {
        return this.isM3u8;
    }

    public /* synthetic */ ExtractorLinkPlayList(String str, String str2, List list, String str3, int i, boolean z, Map map, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, str3, i, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? MapsKt.emptyMap() : map, (i2 & 128) != 0 ? null : str4);
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorLink, com.lagradost.cloudstream3.utils.VideoDownloadManager.IDownloadableMinimum
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorLink
    public String getExtractorData() {
        return this.extractorData;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtractorLinkPlayList(String source, String name, List<PlayListItem> playlist, String referer, int i, boolean z, Map<String, String> headers, String str) {
        super(source, name, "", referer, i, z, headers, str);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(playlist, "playlist");
        Intrinsics.checkNotNullParameter(referer, "referer");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.source = source;
        this.name = name;
        this.playlist = playlist;
        this.referer = referer;
        this.quality = i;
        this.isM3u8 = z;
        this.headers = headers;
        this.extractorData = str;
    }
}
