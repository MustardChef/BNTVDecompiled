package com.google.android.exoplayer2.transformer;

import android.util.SparseIntArray;
import android.util.SparseLongArray;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.transformer.Muxer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class MuxerWrapper {
    private static final long MAX_TRACK_WRITE_AHEAD_US = Util.msToUs(500);
    private final String containerMimeType;
    private boolean isReady;
    private long minTrackTimeUs;
    private final Muxer muxer;
    private final Muxer.Factory muxerFactory;
    private int trackCount;
    private int trackFormatCount;
    private final SparseIntArray trackTypeToIndex = new SparseIntArray();
    private final SparseLongArray trackTypeToTimeUs = new SparseLongArray();
    private int previousTrackType = -2;

    public MuxerWrapper(Muxer muxer, Muxer.Factory factory, String str) {
        this.muxer = muxer;
        this.muxerFactory = factory;
        this.containerMimeType = str;
    }

    public void registerTrack() {
        Assertions.checkState(this.trackFormatCount == 0, "Tracks cannot be registered after track formats have been added.");
        this.trackCount++;
    }

    public boolean supportsSampleMimeType(String str) {
        return this.muxerFactory.supportsSampleMimeType(str, this.containerMimeType);
    }

    public void addTrackFormat(Format format) {
        Assertions.checkState(this.trackCount > 0, "All tracks should be registered before the formats are added.");
        Assertions.checkState(this.trackFormatCount < this.trackCount, "All track formats have already been added.");
        String str = format.sampleMimeType;
        boolean z = MimeTypes.isAudio(str) || MimeTypes.isVideo(str);
        String valueOf = String.valueOf(str);
        Assertions.checkState(z, valueOf.length() != 0 ? "Unsupported track format: ".concat(valueOf) : new String("Unsupported track format: "));
        int trackType = MimeTypes.getTrackType(str);
        boolean z2 = this.trackTypeToIndex.get(trackType, -1) == -1;
        StringBuilder sb = new StringBuilder(44);
        sb.append("There is already a track of type ");
        sb.append(trackType);
        Assertions.checkState(z2, sb.toString());
        this.trackTypeToIndex.put(trackType, this.muxer.addTrack(format));
        this.trackTypeToTimeUs.put(trackType, 0L);
        int i = this.trackFormatCount + 1;
        this.trackFormatCount = i;
        if (i == this.trackCount) {
            this.isReady = true;
        }
    }

    public boolean writeSample(int i, ByteBuffer byteBuffer, boolean z, long j) {
        int i2 = this.trackTypeToIndex.get(i, -1);
        boolean z2 = i2 != -1;
        StringBuilder sb = new StringBuilder(68);
        sb.append("Could not write sample because there is no track of type ");
        sb.append(i);
        Assertions.checkState(z2, sb.toString());
        if (canWriteSampleOfType(i)) {
            if (byteBuffer == null) {
                return true;
            }
            this.muxer.writeSampleData(i2, byteBuffer, z, j);
            this.trackTypeToTimeUs.put(i, j);
            this.previousTrackType = i;
            return true;
        }
        return false;
    }

    public void endTrack(int i) {
        this.trackTypeToIndex.delete(i);
        this.trackTypeToTimeUs.delete(i);
    }

    public void release(boolean z) {
        this.isReady = false;
        this.muxer.release(z);
    }

    public int getTrackCount() {
        return this.trackCount;
    }

    private boolean canWriteSampleOfType(int i) {
        long j = this.trackTypeToTimeUs.get(i, C3282C.TIME_UNSET);
        Assertions.checkState(j != C3282C.TIME_UNSET);
        if (this.isReady) {
            if (this.trackTypeToTimeUs.size() == 1) {
                return true;
            }
            if (i != this.previousTrackType) {
                this.minTrackTimeUs = Util.minValue(this.trackTypeToTimeUs);
            }
            return j - this.minTrackTimeUs <= MAX_TRACK_WRITE_AHEAD_US;
        }
        return false;
    }
}
