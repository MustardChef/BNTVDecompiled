package com.google.ads.interactivemedia.p034v3.api.player;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate */
/* loaded from: classes2.dex */
public final class VideoProgressUpdate {
    public static final VideoProgressUpdate VIDEO_TIME_NOT_READY = new VideoProgressUpdate(-1, -1);
    private final long currentTimeMs;
    private final long durationMs;

    public VideoProgressUpdate(long j, long j2) {
        this.currentTimeMs = j;
        this.durationMs = j2;
    }

    private float getCurrentTimeSecondsFloat() {
        return ((float) this.currentTimeMs) / 1000.0f;
    }

    private float getDurationSecondsFloat() {
        return ((float) this.durationMs) / 1000.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            VideoProgressUpdate videoProgressUpdate = (VideoProgressUpdate) obj;
            return this.currentTimeMs == videoProgressUpdate.currentTimeMs && this.durationMs == videoProgressUpdate.durationMs;
        }
        return false;
    }

    @Deprecated
    public float getCurrentTime() {
        return getCurrentTimeSecondsFloat();
    }

    public long getCurrentTimeMs() {
        return this.currentTimeMs;
    }

    @Deprecated
    public float getDuration() {
        return getDurationSecondsFloat();
    }

    public long getDurationMs() {
        return this.durationMs;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.currentTimeMs), Long.valueOf(this.durationMs)});
    }
}
