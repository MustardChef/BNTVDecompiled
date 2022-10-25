package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class FlvExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = $$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs.INSTANCE;
    private static final int FLV_HEADER_SIZE = 9;
    private static final int FLV_TAG = 4607062;
    private static final int FLV_TAG_HEADER_SIZE = 11;
    private static final int STATE_READING_FLV_HEADER = 1;
    private static final int STATE_READING_TAG_DATA = 4;
    private static final int STATE_READING_TAG_HEADER = 3;
    private static final int STATE_SKIPPING_TO_TAG_HEADER = 2;
    private static final int TAG_TYPE_AUDIO = 8;
    private static final int TAG_TYPE_SCRIPT_DATA = 18;
    private static final int TAG_TYPE_VIDEO = 9;
    private AudioTagPayloadReader audioReader;
    private int bytesToNextTagHeader;
    private ExtractorOutput extractorOutput;
    private long mediaTagTimestampOffsetUs;
    private boolean outputFirstSample;
    private boolean outputSeekMap;
    private int tagDataSize;
    private long tagTimestampUs;
    private int tagType;
    private VideoTagPayloadReader videoReader;
    private final ParsableByteArray scratch = new ParsableByteArray(4);
    private final ParsableByteArray headerBuffer = new ParsableByteArray(9);
    private final ParsableByteArray tagHeaderBuffer = new ParsableByteArray(11);
    private final ParsableByteArray tagData = new ParsableByteArray();
    private final ScriptTagPayloadReader metadataReader = new ScriptTagPayloadReader();
    private int state = 1;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FlvExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        extractorInput.peekFully(this.scratch.getData(), 0, 3);
        this.scratch.setPosition(0);
        if (this.scratch.readUnsignedInt24() != FLV_TAG) {
            return false;
        }
        extractorInput.peekFully(this.scratch.getData(), 0, 2);
        this.scratch.setPosition(0);
        if ((this.scratch.readUnsignedShort() & 250) != 0) {
            return false;
        }
        extractorInput.peekFully(this.scratch.getData(), 0, 4);
        this.scratch.setPosition(0);
        int readInt = this.scratch.readInt();
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(readInt);
        extractorInput.peekFully(this.scratch.getData(), 0, 4);
        this.scratch.setPosition(0);
        return this.scratch.readInt() == 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        if (j == 0) {
            this.state = 1;
            this.outputFirstSample = false;
        } else {
            this.state = 3;
        }
        this.bytesToNextTagHeader = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkStateNotNull(this.extractorOutput);
        while (true) {
            int i = this.state;
            if (i != 1) {
                if (i == 2) {
                    skipToTagHeader(extractorInput);
                } else if (i != 3) {
                    if (i == 4) {
                        if (readTagData(extractorInput)) {
                            return 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (!readTagHeader(extractorInput)) {
                    return -1;
                }
            } else if (!readFlvHeader(extractorInput)) {
                return -1;
            }
        }
    }

    @RequiresNonNull({"extractorOutput"})
    private boolean readFlvHeader(ExtractorInput extractorInput) throws IOException {
        if (extractorInput.readFully(this.headerBuffer.getData(), 0, 9, true)) {
            this.headerBuffer.setPosition(0);
            this.headerBuffer.skipBytes(4);
            int readUnsignedByte = this.headerBuffer.readUnsignedByte();
            boolean z = (readUnsignedByte & 4) != 0;
            boolean z2 = (readUnsignedByte & 1) != 0;
            if (z && this.audioReader == null) {
                this.audioReader = new AudioTagPayloadReader(this.extractorOutput.track(8, 1));
            }
            if (z2 && this.videoReader == null) {
                this.videoReader = new VideoTagPayloadReader(this.extractorOutput.track(9, 2));
            }
            this.extractorOutput.endTracks();
            this.bytesToNextTagHeader = (this.headerBuffer.readInt() - 9) + 4;
            this.state = 2;
            return true;
        }
        return false;
    }

    private void skipToTagHeader(ExtractorInput extractorInput) throws IOException {
        extractorInput.skipFully(this.bytesToNextTagHeader);
        this.bytesToNextTagHeader = 0;
        this.state = 3;
    }

    private boolean readTagHeader(ExtractorInput extractorInput) throws IOException {
        if (extractorInput.readFully(this.tagHeaderBuffer.getData(), 0, 11, true)) {
            this.tagHeaderBuffer.setPosition(0);
            this.tagType = this.tagHeaderBuffer.readUnsignedByte();
            this.tagDataSize = this.tagHeaderBuffer.readUnsignedInt24();
            this.tagTimestampUs = this.tagHeaderBuffer.readUnsignedInt24();
            this.tagTimestampUs = ((this.tagHeaderBuffer.readUnsignedByte() << 24) | this.tagTimestampUs) * 1000;
            this.tagHeaderBuffer.skipBytes(3);
            this.state = 4;
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean readTagData(com.google.android.exoplayer2.extractor.ExtractorInput r10) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.getCurrentTimestampUs()
            int r2 = r9.tagType
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = 0
            r6 = 1
            r7 = 8
            if (r2 != r7) goto L24
            com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader r7 = r9.audioReader
            if (r7 == 0) goto L24
            r9.ensureReadyForMediaOutput()
            com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader r2 = r9.audioReader
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r9.prepareTagData(r10)
            boolean r5 = r2.consume(r10, r0)
        L22:
            r10 = 1
            goto L75
        L24:
            r7 = 9
            if (r2 != r7) goto L3a
            com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader r7 = r9.videoReader
            if (r7 == 0) goto L3a
            r9.ensureReadyForMediaOutput()
            com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader r2 = r9.videoReader
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r9.prepareTagData(r10)
            boolean r5 = r2.consume(r10, r0)
            goto L22
        L3a:
            r7 = 18
            if (r2 != r7) goto L6f
            boolean r2 = r9.outputSeekMap
            if (r2 != 0) goto L6f
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r2 = r9.metadataReader
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r9.prepareTagData(r10)
            boolean r5 = r2.consume(r10, r0)
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r10 = r9.metadataReader
            long r0 = r10.getDurationUs()
            int r10 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r10 == 0) goto L22
            com.google.android.exoplayer2.extractor.ExtractorOutput r10 = r9.extractorOutput
            com.google.android.exoplayer2.extractor.IndexSeekMap r2 = new com.google.android.exoplayer2.extractor.IndexSeekMap
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r7 = r9.metadataReader
            long[] r7 = r7.getKeyFrameTagPositions()
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r8 = r9.metadataReader
            long[] r8 = r8.getKeyFrameTimesUs()
            r2.<init>(r7, r8, r0)
            r10.seekMap(r2)
            r9.outputSeekMap = r6
            goto L22
        L6f:
            int r0 = r9.tagDataSize
            r10.skipFully(r0)
            r10 = 0
        L75:
            boolean r0 = r9.outputFirstSample
            if (r0 != 0) goto L8f
            if (r5 == 0) goto L8f
            r9.outputFirstSample = r6
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r0 = r9.metadataReader
            long r0 = r0.getDurationUs()
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 != 0) goto L8b
            long r0 = r9.tagTimestampUs
            long r0 = -r0
            goto L8d
        L8b:
            r0 = 0
        L8d:
            r9.mediaTagTimestampOffsetUs = r0
        L8f:
            r0 = 4
            r9.bytesToNextTagHeader = r0
            r0 = 2
            r9.state = r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.flv.FlvExtractor.readTagData(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    private ParsableByteArray prepareTagData(ExtractorInput extractorInput) throws IOException {
        if (this.tagDataSize > this.tagData.capacity()) {
            ParsableByteArray parsableByteArray = this.tagData;
            parsableByteArray.reset(new byte[Math.max(parsableByteArray.capacity() * 2, this.tagDataSize)], 0);
        } else {
            this.tagData.setPosition(0);
        }
        this.tagData.setLimit(this.tagDataSize);
        extractorInput.readFully(this.tagData.getData(), 0, this.tagDataSize);
        return this.tagData;
    }

    @RequiresNonNull({"extractorOutput"})
    private void ensureReadyForMediaOutput() {
        if (this.outputSeekMap) {
            return;
        }
        this.extractorOutput.seekMap(new SeekMap.Unseekable(C3282C.TIME_UNSET));
        this.outputSeekMap = true;
    }

    private long getCurrentTimestampUs() {
        if (this.outputFirstSample) {
            return this.mediaTagTimestampOffsetUs + this.tagTimestampUs;
        }
        if (this.metadataReader.getDurationUs() == C3282C.TIME_UNSET) {
            return 0L;
        }
        return this.tagTimestampUs;
    }
}
