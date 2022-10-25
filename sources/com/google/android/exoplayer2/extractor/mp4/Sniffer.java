package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes2.dex */
final class Sniffer {
    public static final int BRAND_HEIC = 1751476579;
    public static final int BRAND_QUICKTIME = 1903435808;
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Atom.TYPE_avc1, Atom.TYPE_hvc1, Atom.TYPE_hev1, Atom.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};
    private static final int SEARCH_LENGTH = 4096;

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, true, false);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, false, false);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput, boolean z) throws IOException {
        return sniffInternal(extractorInput, false, z);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z, boolean z2) throws IOException {
        boolean z3;
        long length = extractorInput.getLength();
        long j = 4096;
        long j2 = -1;
        int i = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i != 0 && length <= 4096) {
            j = length;
        }
        int i2 = (int) j;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z4 = false;
        int i3 = 0;
        boolean z5 = false;
        while (i3 < i2) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), z4 ? 1 : 0, 8, true)) {
                break;
            }
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            int i4 = 16;
            if (readUnsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                parsableByteArray.setLimit(16);
                readUnsignedInt = parsableByteArray.readLong();
            } else {
                if (readUnsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j2) {
                        readUnsignedInt = (length2 - extractorInput.getPeekPosition()) + 8;
                    }
                }
                i4 = 8;
            }
            long j3 = i4;
            if (readUnsignedInt < j3) {
                return z4;
            }
            i3 += i4;
            if (readInt == 1836019574) {
                i2 += (int) readUnsignedInt;
                if (i != 0 && i2 > length) {
                    i2 = (int) length;
                }
                j2 = -1;
            } else if (readInt == 1836019558 || readInt == 1836475768) {
                z3 = true;
                break;
            } else {
                long j4 = length;
                if ((i3 + readUnsignedInt) - j3 >= i2) {
                    break;
                }
                int i5 = (int) (readUnsignedInt - j3);
                i3 += i5;
                if (readInt == 1718909296) {
                    if (i5 < 8) {
                        return false;
                    }
                    parsableByteArray.reset(i5);
                    extractorInput.peekFully(parsableByteArray.getData(), 0, i5);
                    int i6 = i5 / 4;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= i6) {
                            break;
                        }
                        if (i7 == 1) {
                            parsableByteArray.skipBytes(4);
                        } else if (isCompatibleBrand(parsableByteArray.readInt(), z2)) {
                            z5 = true;
                            break;
                        }
                        i7++;
                    }
                    if (!z5) {
                        return false;
                    }
                } else if (i5 != 0) {
                    extractorInput.advancePeekPosition(i5);
                }
                length = j4;
                j2 = -1;
                z4 = false;
            }
        }
        z3 = false;
        return z5 && z == z3;
    }

    private static boolean isCompatibleBrand(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private Sniffer() {
    }
}
