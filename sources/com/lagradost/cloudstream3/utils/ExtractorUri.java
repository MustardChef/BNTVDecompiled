package com.lagradost.cloudstream3.utils;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.TvType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExtractorApi.kt */
@Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u008e\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\nHÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0015\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00064"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "name", "", "basePath", "relativePath", "displayName", "id", "", "parentId", "episode", "season", "headerName", "tvType", "Lcom/lagradost/cloudstream3/TvType;", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;)V", "getBasePath", "()Ljava/lang/String;", "getDisplayName", "getEpisode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeaderName", "getId", "getName", "getParentId", "getRelativePath", "getSeason", "getTvType", "()Lcom/lagradost/cloudstream3/TvType;", "getUri", "()Landroid/net/Uri;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;)Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ExtractorUri {
    private final String basePath;
    private final String displayName;
    private final Integer episode;
    private final String headerName;

    /* renamed from: id */
    private final Integer f10026id;
    private final String name;
    private final Integer parentId;
    private final String relativePath;
    private final Integer season;
    private final TvType tvType;
    private final Uri uri;

    public final Uri component1() {
        return this.uri;
    }

    public final String component10() {
        return this.headerName;
    }

    public final TvType component11() {
        return this.tvType;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.basePath;
    }

    public final String component4() {
        return this.relativePath;
    }

    public final String component5() {
        return this.displayName;
    }

    public final Integer component6() {
        return this.f10026id;
    }

    public final Integer component7() {
        return this.parentId;
    }

    public final Integer component8() {
        return this.episode;
    }

    public final Integer component9() {
        return this.season;
    }

    public final ExtractorUri copy(Uri uri, String name, String str, String str2, String str3, Integer num, Integer num2, Integer num3, Integer num4, String str4, TvType tvType) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(name, "name");
        return new ExtractorUri(uri, name, str, str2, str3, num, num2, num3, num4, str4, tvType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExtractorUri) {
            ExtractorUri extractorUri = (ExtractorUri) obj;
            return Intrinsics.areEqual(this.uri, extractorUri.uri) && Intrinsics.areEqual(this.name, extractorUri.name) && Intrinsics.areEqual(this.basePath, extractorUri.basePath) && Intrinsics.areEqual(this.relativePath, extractorUri.relativePath) && Intrinsics.areEqual(this.displayName, extractorUri.displayName) && Intrinsics.areEqual(this.f10026id, extractorUri.f10026id) && Intrinsics.areEqual(this.parentId, extractorUri.parentId) && Intrinsics.areEqual(this.episode, extractorUri.episode) && Intrinsics.areEqual(this.season, extractorUri.season) && Intrinsics.areEqual(this.headerName, extractorUri.headerName) && this.tvType == extractorUri.tvType;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.uri.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.basePath;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.relativePath;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.displayName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.f10026id;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.parentId;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.episode;
        int hashCode7 = (hashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.season;
        int hashCode8 = (hashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str4 = this.headerName;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        TvType tvType = this.tvType;
        return hashCode9 + (tvType != null ? tvType.hashCode() : 0);
    }

    public String toString() {
        return "ExtractorUri(uri=" + this.uri + ", name=" + this.name + ", basePath=" + this.basePath + ", relativePath=" + this.relativePath + ", displayName=" + this.displayName + ", id=" + this.f10026id + ", parentId=" + this.parentId + ", episode=" + this.episode + ", season=" + this.season + ", headerName=" + this.headerName + ", tvType=" + this.tvType + ')';
    }

    public ExtractorUri(Uri uri, String name, String str, String str2, String str3, Integer num, Integer num2, Integer num3, Integer num4, String str4, TvType tvType) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(name, "name");
        this.uri = uri;
        this.name = name;
        this.basePath = str;
        this.relativePath = str2;
        this.displayName = str3;
        this.f10026id = num;
        this.parentId = num2;
        this.episode = num3;
        this.season = num4;
        this.headerName = str4;
        this.tvType = tvType;
    }

    public /* synthetic */ ExtractorUri(Uri uri, String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, Integer num4, String str5, TvType tvType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : num3, (i & 256) != 0 ? null : num4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : tvType);
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final String getName() {
        return this.name;
    }

    public final String getBasePath() {
        return this.basePath;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Integer getId() {
        return this.f10026id;
    }

    public final Integer getParentId() {
        return this.parentId;
    }

    public final Integer getEpisode() {
        return this.episode;
    }

    public final Integer getSeason() {
        return this.season;
    }

    public final String getHeaderName() {
        return this.headerName;
    }

    public final TvType getTvType() {
        return this.tvType;
    }
}
