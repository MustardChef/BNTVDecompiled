package com.google.android.exoplayer2.ext.cast;

import android.util.SparseArray;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.ext.cast.CastTimeline;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import java.util.HashSet;

/* loaded from: classes2.dex */
final class CastTimelineTracker {
    private final SparseArray<CastTimeline.ItemData> itemIdToData = new SparseArray<>();

    public CastTimeline getCastTimeline(RemoteMediaClient remoteMediaClient) {
        int[] itemIds = remoteMediaClient.getMediaQueue().getItemIds();
        if (itemIds.length > 0) {
            removeUnusedItemDataEntries(itemIds);
        }
        MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
        if (mediaStatus == null) {
            return CastTimeline.EMPTY_CAST_TIMELINE;
        }
        updateItemData(mediaStatus.getCurrentItemId(), mediaStatus.getMediaInfo(), C3282C.TIME_UNSET);
        for (MediaQueueItem mediaQueueItem : mediaStatus.getQueueItems()) {
            updateItemData(mediaQueueItem.getItemId(), mediaQueueItem.getMedia(), (long) (mediaQueueItem.getStartTime() * 1000000.0d));
        }
        return new CastTimeline(itemIds, this.itemIdToData);
    }

    private void updateItemData(int i, MediaInfo mediaInfo, long j) {
        boolean z;
        CastTimeline.ItemData itemData = this.itemIdToData.get(i, CastTimeline.ItemData.EMPTY);
        long streamDurationUs = CastUtils.getStreamDurationUs(mediaInfo);
        if (streamDurationUs == C3282C.TIME_UNSET) {
            streamDurationUs = itemData.durationUs;
        }
        if (mediaInfo == null) {
            z = itemData.isLive;
        } else {
            z = mediaInfo.getStreamType() == 2;
        }
        if (j == C3282C.TIME_UNSET) {
            j = itemData.defaultPositionUs;
        }
        this.itemIdToData.put(i, itemData.copyWithNewValues(streamDurationUs, j, z));
    }

    private void removeUnusedItemDataEntries(int[] iArr) {
        HashSet hashSet = new HashSet(iArr.length * 2);
        int i = 0;
        for (int i2 : iArr) {
            hashSet.add(Integer.valueOf(i2));
        }
        while (i < this.itemIdToData.size()) {
            if (hashSet.contains(Integer.valueOf(this.itemIdToData.keyAt(i)))) {
                i++;
            } else {
                this.itemIdToData.removeAt(i);
            }
        }
    }
}
