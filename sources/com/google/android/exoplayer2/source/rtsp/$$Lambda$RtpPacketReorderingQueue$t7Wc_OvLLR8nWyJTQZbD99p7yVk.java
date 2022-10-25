package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtpPacketReorderingQueue;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.source.rtsp.-$$Lambda$RtpPacketReorderingQueue$t7Wc_OvLLR8nWyJTQZbD99p7yVk  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$RtpPacketReorderingQueue$t7Wc_OvLLR8nWyJTQZbD99p7yVk implements Comparator {
    public static final /* synthetic */ $$Lambda$RtpPacketReorderingQueue$t7Wc_OvLLR8nWyJTQZbD99p7yVk INSTANCE = new $$Lambda$RtpPacketReorderingQueue$t7Wc_OvLLR8nWyJTQZbD99p7yVk();

    private /* synthetic */ $$Lambda$RtpPacketReorderingQueue$t7Wc_OvLLR8nWyJTQZbD99p7yVk() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int calculateSequenceNumberShift;
        calculateSequenceNumberShift = RtpPacketReorderingQueue.calculateSequenceNumberShift(((RtpPacketReorderingQueue.RtpPacketContainer) obj).packet.sequenceNumber, ((RtpPacketReorderingQueue.RtpPacketContainer) obj2).packet.sequenceNumber);
        return calculateSequenceNumberShift;
    }
}
