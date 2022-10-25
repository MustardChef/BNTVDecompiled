package com.google.android.exoplayer2.ext.cast;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class CastTimeline extends Timeline {
    public static final CastTimeline EMPTY_CAST_TIMELINE = new CastTimeline(new int[0], new SparseArray());
    private final long[] defaultPositionsUs;
    private final long[] durationsUs;
    private final int[] ids;
    private final SparseIntArray idsToIndex;
    private final boolean[] isLive;

    /* loaded from: classes2.dex */
    public static final class ItemData {
        public static final ItemData EMPTY = new ItemData(C3282C.TIME_UNSET, C3282C.TIME_UNSET, false);
        public final long defaultPositionUs;
        public final long durationUs;
        public final boolean isLive;

        public ItemData(long j, long j2, boolean z) {
            this.durationUs = j;
            this.defaultPositionUs = j2;
            this.isLive = z;
        }

        public ItemData copyWithNewValues(long j, long j2, boolean z) {
            return (j == this.durationUs && j2 == this.defaultPositionUs && z == this.isLive) ? this : new ItemData(j, j2, z);
        }
    }

    public CastTimeline(int[] iArr, SparseArray<ItemData> sparseArray) {
        int length = iArr.length;
        this.idsToIndex = new SparseIntArray(length);
        this.ids = Arrays.copyOf(iArr, length);
        this.durationsUs = new long[length];
        this.defaultPositionsUs = new long[length];
        this.isLive = new boolean[length];
        int i = 0;
        while (true) {
            int[] iArr2 = this.ids;
            if (i >= iArr2.length) {
                return;
            }
            int i2 = iArr2[i];
            this.idsToIndex.put(i2, i);
            ItemData itemData = sparseArray.get(i2, ItemData.EMPTY);
            this.durationsUs[i] = itemData.durationUs;
            this.defaultPositionsUs[i] = itemData.defaultPositionUs == C3282C.TIME_UNSET ? 0L : itemData.defaultPositionUs;
            this.isLive[i] = itemData.isLive;
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return this.ids.length;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        long j2 = this.durationsUs[i];
        boolean z = j2 == C3282C.TIME_UNSET;
        MediaItem build = new MediaItem.Builder().setUri(Uri.EMPTY).setTag(Integer.valueOf(this.ids[i])).build();
        return window.set(Integer.valueOf(this.ids[i]), build, null, C3282C.TIME_UNSET, C3282C.TIME_UNSET, C3282C.TIME_UNSET, !z, z, this.isLive[i] ? build.liveConfiguration : null, this.defaultPositionsUs[i], j2, i, i, 0L);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return this.ids.length;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        int i2 = this.ids[i];
        return period.set(Integer.valueOf(i2), Integer.valueOf(i2), i, this.durationsUs[i], 0L);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object obj) {
        if (obj instanceof Integer) {
            return this.idsToIndex.get(((Integer) obj).intValue(), -1);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Integer getUidOfPeriod(int i) {
        return Integer.valueOf(this.ids[i]);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CastTimeline) {
            CastTimeline castTimeline = (CastTimeline) obj;
            return Arrays.equals(this.ids, castTimeline.ids) && Arrays.equals(this.durationsUs, castTimeline.durationsUs) && Arrays.equals(this.defaultPositionsUs, castTimeline.defaultPositionsUs) && Arrays.equals(this.isLive, castTimeline.isLive);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int hashCode() {
        return (((((Arrays.hashCode(this.ids) * 31) + Arrays.hashCode(this.durationsUs)) * 31) + Arrays.hashCode(this.defaultPositionsUs)) * 31) + Arrays.hashCode(this.isLive);
    }
}
