package com.google.android.exoplayer2.ext.cast;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
class CastTrackSelection implements TrackSelection {
    private final TrackGroup trackGroup;

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getIndexInTrackGroup(int i) {
        return i == 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getType() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int indexOf(int i) {
        return i == 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int length() {
        return 1;
    }

    public CastTrackSelection(TrackGroup trackGroup) {
        this.trackGroup = trackGroup;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public Format getFormat(int i) {
        Assertions.checkArgument(i == 0);
        return this.trackGroup.getFormat(0);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int indexOf(Format format) {
        return format == this.trackGroup.getFormat(0) ? 0 : -1;
    }

    public int hashCode() {
        return System.identityHashCode(this.trackGroup);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.trackGroup == ((CastTrackSelection) obj).trackGroup;
    }
}
