package com.lagradost.cloudstream3.p041ui.download;

import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadChildAdapter.kt */
@Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/VisualDownloadChildCached;", "", "currentBytes", "", "totalBytes", "data", "Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadEpisodeCached;", "(JJLcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadEpisodeCached;)V", "getCurrentBytes", "()J", "getData", "()Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadEpisodeCached;", "getTotalBytes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.VisualDownloadChildCached */
/* loaded from: classes3.dex */
public final class VisualDownloadChildCached {
    private final long currentBytes;
    private final VideoDownloadHelper.DownloadEpisodeCached data;
    private final long totalBytes;

    public static /* synthetic */ VisualDownloadChildCached copy$default(VisualDownloadChildCached visualDownloadChildCached, long j, long j2, VideoDownloadHelper.DownloadEpisodeCached downloadEpisodeCached, int i, Object obj) {
        if ((i & 1) != 0) {
            j = visualDownloadChildCached.currentBytes;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = visualDownloadChildCached.totalBytes;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            downloadEpisodeCached = visualDownloadChildCached.data;
        }
        return visualDownloadChildCached.copy(j3, j4, downloadEpisodeCached);
    }

    public final long component1() {
        return this.currentBytes;
    }

    public final long component2() {
        return this.totalBytes;
    }

    public final VideoDownloadHelper.DownloadEpisodeCached component3() {
        return this.data;
    }

    public final VisualDownloadChildCached copy(long j, long j2, VideoDownloadHelper.DownloadEpisodeCached data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new VisualDownloadChildCached(j, j2, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VisualDownloadChildCached) {
            VisualDownloadChildCached visualDownloadChildCached = (VisualDownloadChildCached) obj;
            return this.currentBytes == visualDownloadChildCached.currentBytes && this.totalBytes == visualDownloadChildCached.totalBytes && Intrinsics.areEqual(this.data, visualDownloadChildCached.data);
        }
        return false;
    }

    public int hashCode() {
        return (((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.currentBytes) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.totalBytes)) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "VisualDownloadChildCached(currentBytes=" + this.currentBytes + ", totalBytes=" + this.totalBytes + ", data=" + this.data + ')';
    }

    public VisualDownloadChildCached(long j, long j2, VideoDownloadHelper.DownloadEpisodeCached data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.currentBytes = j;
        this.totalBytes = j2;
        this.data = data;
    }

    public final long getCurrentBytes() {
        return this.currentBytes;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final VideoDownloadHelper.DownloadEpisodeCached getData() {
        return this.data;
    }
}
