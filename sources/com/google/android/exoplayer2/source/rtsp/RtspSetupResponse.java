package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtspMessageUtil;

/* loaded from: classes2.dex */
final class RtspSetupResponse {
    public final RtspMessageUtil.RtspSessionHeader sessionHeader;
    public final int status;
    public final String transport;

    public RtspSetupResponse(int i, RtspMessageUtil.RtspSessionHeader rtspSessionHeader, String str) {
        this.status = i;
        this.sessionHeader = rtspSessionHeader;
        this.transport = str;
    }
}
