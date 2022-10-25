package com.lagradost.cloudstream3.p041ui.download;

import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadHeaderAdapter.kt */
@Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006$"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/VisualDownloadHeaderCached;", "", "currentOngoingDownloads", "", "totalDownloads", "totalBytes", "", "currentBytes", "data", "Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadHeaderCached;", "child", "Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadEpisodeCached;", "(IIJJLcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadHeaderCached;Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadEpisodeCached;)V", "getChild", "()Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadEpisodeCached;", "getCurrentBytes", "()J", "getCurrentOngoingDownloads", "()I", "getData", "()Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadHeaderCached;", "getTotalBytes", "getTotalDownloads", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.VisualDownloadHeaderCached */
/* loaded from: classes3.dex */
public final class VisualDownloadHeaderCached {
    private final VideoDownloadHelper.DownloadEpisodeCached child;
    private final long currentBytes;
    private final int currentOngoingDownloads;
    private final VideoDownloadHelper.DownloadHeaderCached data;
    private final long totalBytes;
    private final int totalDownloads;

    public final int component1() {
        return this.currentOngoingDownloads;
    }

    public final int component2() {
        return this.totalDownloads;
    }

    public final long component3() {
        return this.totalBytes;
    }

    public final long component4() {
        return this.currentBytes;
    }

    public final VideoDownloadHelper.DownloadHeaderCached component5() {
        return this.data;
    }

    public final VideoDownloadHelper.DownloadEpisodeCached component6() {
        return this.child;
    }

    public final VisualDownloadHeaderCached copy(int i, int i2, long j, long j2, VideoDownloadHelper.DownloadHeaderCached data, VideoDownloadHelper.DownloadEpisodeCached downloadEpisodeCached) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new VisualDownloadHeaderCached(i, i2, j, j2, data, downloadEpisodeCached);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VisualDownloadHeaderCached) {
            VisualDownloadHeaderCached visualDownloadHeaderCached = (VisualDownloadHeaderCached) obj;
            return this.currentOngoingDownloads == visualDownloadHeaderCached.currentOngoingDownloads && this.totalDownloads == visualDownloadHeaderCached.totalDownloads && this.totalBytes == visualDownloadHeaderCached.totalBytes && this.currentBytes == visualDownloadHeaderCached.currentBytes && Intrinsics.areEqual(this.data, visualDownloadHeaderCached.data) && Intrinsics.areEqual(this.child, visualDownloadHeaderCached.child);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((this.currentOngoingDownloads * 31) + this.totalDownloads) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.totalBytes)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.currentBytes)) * 31) + this.data.hashCode()) * 31;
        VideoDownloadHelper.DownloadEpisodeCached downloadEpisodeCached = this.child;
        return hashCode + (downloadEpisodeCached == null ? 0 : downloadEpisodeCached.hashCode());
    }

    public String toString() {
        return "VisualDownloadHeaderCached(currentOngoingDownloads=" + this.currentOngoingDownloads + ", totalDownloads=" + this.totalDownloads + ", totalBytes=" + this.totalBytes + ", currentBytes=" + this.currentBytes + ", data=" + this.data + ", child=" + this.child + ')';
    }

    public VisualDownloadHeaderCached(int i, int i2, long j, long j2, VideoDownloadHelper.DownloadHeaderCached data, VideoDownloadHelper.DownloadEpisodeCached downloadEpisodeCached) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.currentOngoingDownloads = i;
        this.totalDownloads = i2;
        this.totalBytes = j;
        this.currentBytes = j2;
        this.data = data;
        this.child = downloadEpisodeCached;
    }

    public final int getCurrentOngoingDownloads() {
        return this.currentOngoingDownloads;
    }

    public final int getTotalDownloads() {
        return this.totalDownloads;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final long getCurrentBytes() {
        return this.currentBytes;
    }

    public final VideoDownloadHelper.DownloadHeaderCached getData() {
        return this.data;
    }

    public final VideoDownloadHelper.DownloadEpisodeCached getChild() {
        return this.child;
    }
}
