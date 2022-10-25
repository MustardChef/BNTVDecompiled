package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
public final class RtpAc3Reader implements RtpPayloadReader {
    private static final int AC3_FRAME_TYPE_COMPLETE_FRAME = 0;
    private static final int AC3_FRAME_TYPE_INITIAL_FRAGMENT_A = 1;
    private static final int AC3_FRAME_TYPE_INITIAL_FRAGMENT_B = 2;
    private static final int AC3_FRAME_TYPE_NON_INITIAL_FRAGMENT = 3;
    private static final int AC3_PAYLOAD_HEADER_SIZE = 2;
    private int numBytesPendingMetadataOutput;
    private final RtpPayloadFormat payloadFormat;
    private long sampleTimeUsOfFramePendingMetadataOutput;
    private long startTimeOffsetUs;
    private TrackOutput trackOutput;
    private final ParsableBitArray scratchBitBuffer = new ParsableBitArray();
    private long firstReceivedTimestamp = C3282C.TIME_UNSET;

    public RtpAc3Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void createTracks(ExtractorOutput extractorOutput, int i) {
        TrackOutput track = extractorOutput.track(i, 1);
        this.trackOutput = track;
        track.format(this.payloadFormat.format);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void onReceivingFirstPacket(long j, int i) {
        Assertions.checkState(this.firstReceivedTimestamp == C3282C.TIME_UNSET);
        this.firstReceivedTimestamp = j;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void consume(ParsableByteArray parsableByteArray, long j, int i, boolean z) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 255;
        long sampleTimeUs = toSampleTimeUs(this.startTimeOffsetUs, j, this.firstReceivedTimestamp, this.payloadFormat.clockRate);
        if (readUnsignedByte == 0) {
            maybeOutputSampleMetadata();
            if (readUnsignedByte2 == 1) {
                processSingleFramePacket(parsableByteArray, sampleTimeUs);
                return;
            } else {
                processMultiFramePacket(parsableByteArray, readUnsignedByte2, sampleTimeUs);
                return;
            }
        }
        if (readUnsignedByte == 1 || readUnsignedByte == 2) {
            maybeOutputSampleMetadata();
        } else if (readUnsignedByte != 3) {
            throw new IllegalArgumentException(String.valueOf(readUnsignedByte));
        }
        processFragmentedPacket(parsableByteArray, z, readUnsignedByte, sampleTimeUs);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.firstReceivedTimestamp = j;
        this.startTimeOffsetUs = j2;
    }

    private void processSingleFramePacket(ParsableByteArray parsableByteArray, long j) {
        int bytesLeft = parsableByteArray.bytesLeft();
        ((TrackOutput) Assertions.checkNotNull(this.trackOutput)).sampleData(parsableByteArray, bytesLeft);
        ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata(j, 1, bytesLeft, 0, null);
    }

    private void processMultiFramePacket(ParsableByteArray parsableByteArray, int i, long j) {
        this.scratchBitBuffer.reset(parsableByteArray.getData());
        this.scratchBitBuffer.skipBytes(2);
        for (int i2 = 0; i2 < i; i2++) {
            Ac3Util.SyncFrameInfo parseAc3SyncframeInfo = Ac3Util.parseAc3SyncframeInfo(this.scratchBitBuffer);
            ((TrackOutput) Assertions.checkNotNull(this.trackOutput)).sampleData(parsableByteArray, parseAc3SyncframeInfo.frameSize);
            ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata(j, 1, parseAc3SyncframeInfo.frameSize, 0, null);
            j += (parseAc3SyncframeInfo.sampleCount / parseAc3SyncframeInfo.sampleRate) * 1000000;
            this.scratchBitBuffer.skipBytes(parseAc3SyncframeInfo.frameSize);
        }
    }

    private void processFragmentedPacket(ParsableByteArray parsableByteArray, boolean z, int i, long j) {
        int bytesLeft = parsableByteArray.bytesLeft();
        ((TrackOutput) Assertions.checkNotNull(this.trackOutput)).sampleData(parsableByteArray, bytesLeft);
        this.numBytesPendingMetadataOutput += bytesLeft;
        this.sampleTimeUsOfFramePendingMetadataOutput = j;
        if (z && i == 3) {
            outputSampleMetadataForFragmentedPackets();
        }
    }

    private void maybeOutputSampleMetadata() {
        if (this.numBytesPendingMetadataOutput > 0) {
            outputSampleMetadataForFragmentedPackets();
        }
    }

    private void outputSampleMetadataForFragmentedPackets() {
        ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata(this.sampleTimeUsOfFramePendingMetadataOutput, 1, this.numBytesPendingMetadataOutput, 0, null);
        this.numBytesPendingMetadataOutput = 0;
    }

    private static long toSampleTimeUs(long j, long j2, long j3, int i) {
        return j + Util.scaleLargeTimestamp(j2 - j3, 1000000L, i);
    }
}
