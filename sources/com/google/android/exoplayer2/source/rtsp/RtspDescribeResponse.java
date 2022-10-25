package com.google.android.exoplayer2.source.rtsp;

/* loaded from: classes2.dex */
final class RtspDescribeResponse {
    public final SessionDescription sessionDescription;
    public final int status;

    public RtspDescribeResponse(int i, SessionDescription sessionDescription) {
        this.status = i;
        this.sessionDescription = sessionDescription;
    }
}
