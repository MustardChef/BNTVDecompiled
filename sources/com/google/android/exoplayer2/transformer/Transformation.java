package com.google.android.exoplayer2.transformer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Transformation {
    public final String audioMimeType;
    public final boolean flattenForSlowMotion;
    public final String outputMimeType;
    public final boolean removeAudio;
    public final boolean removeVideo;
    public final String videoMimeType;

    public Transformation(boolean z, boolean z2, boolean z3, String str, String str2, String str3) {
        this.removeAudio = z;
        this.removeVideo = z2;
        this.flattenForSlowMotion = z3;
        this.outputMimeType = str;
        this.audioMimeType = str2;
        this.videoMimeType = str3;
    }
}
