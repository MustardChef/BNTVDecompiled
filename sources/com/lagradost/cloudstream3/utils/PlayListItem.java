package com.lagradost.cloudstream3.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExtractorApi.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/PlayListItem;", "", "url", "", "durationUs", "", "(Ljava/lang/String;J)V", "getDurationUs", "()J", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class PlayListItem {
    private final long durationUs;
    private final String url;

    public static /* synthetic */ PlayListItem copy$default(PlayListItem playListItem, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playListItem.url;
        }
        if ((i & 2) != 0) {
            j = playListItem.durationUs;
        }
        return playListItem.copy(str, j);
    }

    public final String component1() {
        return this.url;
    }

    public final long component2() {
        return this.durationUs;
    }

    public final PlayListItem copy(String url, long j) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new PlayListItem(url, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlayListItem) {
            PlayListItem playListItem = (PlayListItem) obj;
            return Intrinsics.areEqual(this.url, playListItem.url) && this.durationUs == playListItem.durationUs;
        }
        return false;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.durationUs);
    }

    public String toString() {
        return "PlayListItem(url=" + this.url + ", durationUs=" + this.durationUs + ')';
    }

    public PlayListItem(String url, long j) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.durationUs = j;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getDurationUs() {
        return this.durationUs;
    }
}
