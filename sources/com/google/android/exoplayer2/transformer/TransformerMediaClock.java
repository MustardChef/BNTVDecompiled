package com.google.android.exoplayer2.transformer;

import android.util.SparseLongArray;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
final class TransformerMediaClock implements MediaClock {
    private long minTrackTimeUs;
    private final SparseLongArray trackTypeToTimeUs = new SparseLongArray();

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
    }

    public void updateTimeForTrackType(int i, long j) {
        long j2 = this.trackTypeToTimeUs.get(i, C3282C.TIME_UNSET);
        int i2 = (j2 > C3282C.TIME_UNSET ? 1 : (j2 == C3282C.TIME_UNSET ? 0 : -1));
        if (i2 == 0 || j > j2) {
            this.trackTypeToTimeUs.put(i, j);
            if (i2 == 0 || j2 == this.minTrackTimeUs) {
                this.minTrackTimeUs = Util.minValue(this.trackTypeToTimeUs);
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        return this.minTrackTimeUs;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return PlaybackParameters.DEFAULT;
    }
}
