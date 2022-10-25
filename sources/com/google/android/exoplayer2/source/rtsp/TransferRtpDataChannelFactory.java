package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;

/* loaded from: classes2.dex */
final class TransferRtpDataChannelFactory implements RtpDataChannel.Factory {
    private static final int INTERLEAVED_CHANNELS_PER_TRACK = 2;
    private final long timeoutMs;

    @Override // com.google.android.exoplayer2.source.rtsp.RtpDataChannel.Factory
    public /* synthetic */ RtpDataChannel.Factory createFallbackDataChannelFactory() {
        return RtpDataChannel.Factory.CC.$default$createFallbackDataChannelFactory(this);
    }

    public TransferRtpDataChannelFactory(long j) {
        this.timeoutMs = j;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.RtpDataChannel.Factory
    public RtpDataChannel createAndOpenDataChannel(int i) {
        TransferRtpDataChannel transferRtpDataChannel = new TransferRtpDataChannel(this.timeoutMs);
        transferRtpDataChannel.open(RtpUtils.getIncomingRtpDataSpec(i * 2));
        return transferRtpDataChannel;
    }
}
