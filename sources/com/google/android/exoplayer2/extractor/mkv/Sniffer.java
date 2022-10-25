package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes2.dex */
final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch = new ParsableByteArray(8);

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        long readUint;
        int i;
        long length = extractorInput.getLength();
        long j = 1024;
        int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i2 != 0 && length <= 1024) {
            j = length;
        }
        int i3 = (int) j;
        extractorInput.peekFully(this.scratch.getData(), 0, 4);
        long readUnsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (readUnsignedInt != 440786851) {
            int i4 = this.peekLength + 1;
            this.peekLength = i4;
            if (i4 == i3) {
                return false;
            }
            extractorInput.peekFully(this.scratch.getData(), 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & (-256)) | (this.scratch.getData()[0] & 255);
        }
        long readUint2 = readUint(extractorInput);
        long j2 = this.peekLength;
        if (readUint2 == Long.MIN_VALUE) {
            return false;
        }
        if (i2 != 0 && j2 + readUint2 >= length) {
            return false;
        }
        while (true) {
            int i5 = this.peekLength;
            long j3 = j2 + readUint2;
            if (i5 >= j3) {
                return ((long) i5) == j3;
            } else if (readUint(extractorInput) != Long.MIN_VALUE && (readUint(extractorInput)) >= 0 && readUint <= 2147483647L) {
                if (i != 0) {
                    int i6 = (int) readUint;
                    extractorInput.advancePeekPosition(i6);
                    this.peekLength += i6;
                }
            }
        }
    }

    private long readUint(ExtractorInput extractorInput) throws IOException {
        int i = 0;
        extractorInput.peekFully(this.scratch.getData(), 0, 1);
        int i2 = this.scratch.getData()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        extractorInput.peekFully(this.scratch.getData(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.scratch.getData()[i] & 255) + (i5 << 8);
        }
        this.peekLength += i4 + 1;
        return i5;
    }
}
