package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.io.IOException;

/* loaded from: classes2.dex */
final class UnexpectedSampleTimestampException extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final MediaChunk mediaChunk;
    public final long rejectedSampleTimeUs;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UnexpectedSampleTimestampException(com.google.android.exoplayer2.source.chunk.MediaChunk r9, long r10, long r12) {
        /*
            r8 = this;
            long r0 = com.google.android.exoplayer2.util.Util.usToMs(r12)
            long r2 = r9.startTimeUs
            long r4 = r9.endTimeUs
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r7 = 103(0x67, float:1.44E-43)
            r6.<init>(r7)
            java.lang.String r7 = "Unexpected sample timestamp: "
            r6.append(r7)
            r6.append(r0)
            java.lang.String r0 = " in chunk ["
            r6.append(r0)
            r6.append(r2)
            java.lang.String r0 = ", "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r0 = "]"
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r8.<init>(r0)
            r8.mediaChunk = r9
            r8.lastAcceptedSampleTimeUs = r10
            r8.rejectedSampleTimeUs = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.UnexpectedSampleTimestampException.<init>(com.google.android.exoplayer2.source.chunk.MediaChunk, long, long):void");
    }
}
