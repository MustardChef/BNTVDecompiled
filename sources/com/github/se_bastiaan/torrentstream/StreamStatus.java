package com.github.se_bastiaan.torrentstream;

/* loaded from: classes2.dex */
public class StreamStatus {
    public final int bufferProgress;
    public final int downloadSpeed;
    public final float progress;
    public final int seeds;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamStatus(float f, int i, int i2, int i3) {
        this.progress = f;
        this.bufferProgress = i;
        this.seeds = i2;
        this.downloadSpeed = i3;
    }
}
