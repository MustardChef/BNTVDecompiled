package com.lagradost.cloudstream3.p041ui.player;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlayerSubtitleHelper.kt */
@Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000bJB\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\b\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "", "name", "", "url", "origin", "Lcom/lagradost/cloudstream3/ui/player/SubtitleOrigin;", "mimeType", "isZipUrl", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/ui/player/SubtitleOrigin;Ljava/lang/String;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMimeType", "()Ljava/lang/String;", "getName", "getOrigin", "()Lcom/lagradost/cloudstream3/ui/player/SubtitleOrigin;", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/ui/player/SubtitleOrigin;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.SubtitleData */
/* loaded from: classes3.dex */
public final class SubtitleData {
    private final Boolean isZipUrl;
    private final String mimeType;
    private final String name;
    private final SubtitleOrigin origin;
    private final String url;

    public static /* synthetic */ SubtitleData copy$default(SubtitleData subtitleData, String str, String str2, SubtitleOrigin subtitleOrigin, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subtitleData.name;
        }
        if ((i & 2) != 0) {
            str2 = subtitleData.url;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            subtitleOrigin = subtitleData.origin;
        }
        SubtitleOrigin subtitleOrigin2 = subtitleOrigin;
        if ((i & 8) != 0) {
            str3 = subtitleData.mimeType;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            bool = subtitleData.isZipUrl;
        }
        return subtitleData.copy(str, str4, subtitleOrigin2, str5, bool);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.url;
    }

    public final SubtitleOrigin component3() {
        return this.origin;
    }

    public final String component4() {
        return this.mimeType;
    }

    public final Boolean component5() {
        return this.isZipUrl;
    }

    public final SubtitleData copy(String name, String url, SubtitleOrigin origin, String mimeType, Boolean bool) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return new SubtitleData(name, url, origin, mimeType, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubtitleData) {
            SubtitleData subtitleData = (SubtitleData) obj;
            return Intrinsics.areEqual(this.name, subtitleData.name) && Intrinsics.areEqual(this.url, subtitleData.url) && this.origin == subtitleData.origin && Intrinsics.areEqual(this.mimeType, subtitleData.mimeType) && Intrinsics.areEqual(this.isZipUrl, subtitleData.isZipUrl);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.name.hashCode() * 31) + this.url.hashCode()) * 31) + this.origin.hashCode()) * 31) + this.mimeType.hashCode()) * 31;
        Boolean bool = this.isZipUrl;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "SubtitleData(name=" + this.name + ", url=" + this.url + ", origin=" + this.origin + ", mimeType=" + this.mimeType + ", isZipUrl=" + this.isZipUrl + ')';
    }

    public SubtitleData(String name, String url, SubtitleOrigin origin, String mimeType, Boolean bool) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.name = name;
        this.url = url;
        this.origin = origin;
        this.mimeType = mimeType;
        this.isZipUrl = bool;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public final SubtitleOrigin getOrigin() {
        return this.origin;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public /* synthetic */ SubtitleData(String str, String str2, SubtitleOrigin subtitleOrigin, String str3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, subtitleOrigin, str3, (i & 16) != 0 ? false : bool);
    }

    public final Boolean isZipUrl() {
        return this.isZipUrl;
    }
}
