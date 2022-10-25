package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
public final class RtpUtils {
    private static final String RTP_ANY_INCOMING_IPV4 = "rtp://0.0.0.0";

    public static DataSpec getIncomingRtpDataSpec(int i) {
        return new DataSpec(Uri.parse(Util.formatInvariant("%s:%d", RTP_ANY_INCOMING_IPV4, Integer.valueOf(i))));
    }

    private RtpUtils() {
    }
}
