package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes2.dex */
public final class DefaultRtpPayloadReaderFactory implements RtpPayloadReader.Factory {
    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader.Factory
    public RtpPayloadReader createPayloadReader(RtpPayloadFormat rtpPayloadFormat) {
        String str = (String) Assertions.checkNotNull(rtpPayloadFormat.format.sampleMimeType);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -53558318:
                if (str.equals(MimeTypes.AUDIO_AAC)) {
                    c = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c = 1;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new RtpAacReader(rtpPayloadFormat);
            case 1:
                return new RtpAc3Reader(rtpPayloadFormat);
            case 2:
                return new RtpH264Reader(rtpPayloadFormat);
            default:
                return null;
        }
    }
}
