package com.google.android.exoplayer2.ext.cast;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.gms.cast.MediaQueueItem;

/* loaded from: classes2.dex */
public interface MediaItemConverter {
    MediaItem toMediaItem(MediaQueueItem mediaQueueItem);

    MediaQueueItem toMediaQueueItem(MediaItem mediaItem);
}
