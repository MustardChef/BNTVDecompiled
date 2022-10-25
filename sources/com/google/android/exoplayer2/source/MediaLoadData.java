package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.Format;

/* loaded from: classes2.dex */
public final class MediaLoadData {
    public final int dataType;
    public final long mediaEndTimeMs;
    public final long mediaStartTimeMs;
    public final Format trackFormat;
    public final Object trackSelectionData;
    public final int trackSelectionReason;
    public final int trackType;

    public MediaLoadData(int i) {
        this(i, -1, null, 0, null, C3282C.TIME_UNSET, C3282C.TIME_UNSET);
    }

    public MediaLoadData(int i, int i2, Format format, int i3, Object obj, long j, long j2) {
        this.dataType = i;
        this.trackType = i2;
        this.trackFormat = format;
        this.trackSelectionReason = i3;
        this.trackSelectionData = obj;
        this.mediaStartTimeMs = j;
        this.mediaEndTimeMs = j2;
    }
}
