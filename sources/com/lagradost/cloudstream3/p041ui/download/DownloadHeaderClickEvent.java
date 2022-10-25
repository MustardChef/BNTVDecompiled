package com.lagradost.cloudstream3.p041ui.download;

import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadHeaderAdapter.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/DownloadHeaderClickEvent;", "", "action", "", "data", "Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadHeaderCached;", "(ILcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadHeaderCached;)V", "getAction", "()I", "getData", "()Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadHeaderCached;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadHeaderClickEvent */
/* loaded from: classes3.dex */
public final class DownloadHeaderClickEvent {
    private final int action;
    private final VideoDownloadHelper.DownloadHeaderCached data;

    public static /* synthetic */ DownloadHeaderClickEvent copy$default(DownloadHeaderClickEvent downloadHeaderClickEvent, int i, VideoDownloadHelper.DownloadHeaderCached downloadHeaderCached, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = downloadHeaderClickEvent.action;
        }
        if ((i2 & 2) != 0) {
            downloadHeaderCached = downloadHeaderClickEvent.data;
        }
        return downloadHeaderClickEvent.copy(i, downloadHeaderCached);
    }

    public final int component1() {
        return this.action;
    }

    public final VideoDownloadHelper.DownloadHeaderCached component2() {
        return this.data;
    }

    public final DownloadHeaderClickEvent copy(int i, VideoDownloadHelper.DownloadHeaderCached data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DownloadHeaderClickEvent(i, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DownloadHeaderClickEvent) {
            DownloadHeaderClickEvent downloadHeaderClickEvent = (DownloadHeaderClickEvent) obj;
            return this.action == downloadHeaderClickEvent.action && Intrinsics.areEqual(this.data, downloadHeaderClickEvent.data);
        }
        return false;
    }

    public int hashCode() {
        return (this.action * 31) + this.data.hashCode();
    }

    public String toString() {
        return "DownloadHeaderClickEvent(action=" + this.action + ", data=" + this.data + ')';
    }

    public DownloadHeaderClickEvent(int i, VideoDownloadHelper.DownloadHeaderCached data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.action = i;
        this.data = data;
    }

    public final int getAction() {
        return this.action;
    }

    public final VideoDownloadHelper.DownloadHeaderCached getData() {
        return this.data;
    }
}
