package com.lagradost.cloudstream3.p041ui.download;

import com.lagradost.cloudstream3.p041ui.download.EasyDownloadButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadChildAdapter.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "", "action", "", "data", "Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton$IMinimumData;", "(ILcom/lagradost/cloudstream3/ui/download/EasyDownloadButton$IMinimumData;)V", "getAction", "()I", "getData", "()Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton$IMinimumData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadClickEvent */
/* loaded from: classes3.dex */
public final class DownloadClickEvent {
    private final int action;
    private final EasyDownloadButton.IMinimumData data;

    public static /* synthetic */ DownloadClickEvent copy$default(DownloadClickEvent downloadClickEvent, int i, EasyDownloadButton.IMinimumData iMinimumData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = downloadClickEvent.action;
        }
        if ((i2 & 2) != 0) {
            iMinimumData = downloadClickEvent.data;
        }
        return downloadClickEvent.copy(i, iMinimumData);
    }

    public final int component1() {
        return this.action;
    }

    public final EasyDownloadButton.IMinimumData component2() {
        return this.data;
    }

    public final DownloadClickEvent copy(int i, EasyDownloadButton.IMinimumData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DownloadClickEvent(i, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DownloadClickEvent) {
            DownloadClickEvent downloadClickEvent = (DownloadClickEvent) obj;
            return this.action == downloadClickEvent.action && Intrinsics.areEqual(this.data, downloadClickEvent.data);
        }
        return false;
    }

    public int hashCode() {
        return (this.action * 31) + this.data.hashCode();
    }

    public String toString() {
        return "DownloadClickEvent(action=" + this.action + ", data=" + this.data + ')';
    }

    public DownloadClickEvent(int i, EasyDownloadButton.IMinimumData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.action = i;
        this.data = data;
    }

    public final int getAction() {
        return this.action;
    }

    public final EasyDownloadButton.IMinimumData getData() {
        return this.data;
    }
}
