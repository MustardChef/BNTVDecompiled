package com.google.zxing.datamatrix.encoder;

import com.google.ads.interactivemedia.p034v3.internal.bqk;

/* loaded from: classes3.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{bqk.f6562bV, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, bqk.f6587bu, bqk.f6595cb, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, bqk.f6552bL, 97, 178, 100, bqk.f6541bA}, new int[]{156, 97, 192, bqk.f6603cj, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, bqk.f6552bL, 109, 129, 94, 254, bqk.f6560bT, 48, 90, 188}, new int[]{15, 195, 244, 9, bqk.f6598ce, 71, 168, 2, 188, 160, 153, 145, bqk.f6604ck, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, bqk.f6602ci, bqk.f6587bu, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{bqk.f6550bJ, bqk.f6597cd, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, bqk.f6552bL, 141, 136, 120, 151, bqk.f6598ce, 168, 93, 255}, new int[]{245, 127, bqk.f6541bA, bqk.f6576bj, 130, 250, 162, 181, 102, 120, 84, 179, bqk.f6558bR, bqk.f6602ci, 80, 182, bqk.f6565bY, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, bqk.f6560bT, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, bqk.f6594ca, 105, 122, 2, 245, 133, bqk.f6541bA, 8, 175, 95, 100, 9, 167, 105, bqk.f6553bM, 111, 57, 121, 21, 1, bqk.f6604ck, 57, 54, 101, bqk.f6595cb, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, bqk.f6587bu, 96, 32, 117, 22, 238, 133, 238, bqk.f6597cd, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, bqk.f6552bL, 92, bqk.f6604ck, bqk.f6560bT, 19}, new int[]{175, 9, bqk.f6587bu, 238, 12, 17, bqk.f6558bR, 208, 100, 29, 175, 170, bqk.f6596cc, 192, bqk.f6554bN, 235, 150, 159, 36, bqk.f6587bu, 38, 200, 132, 54, bqk.f6562bV, 146, bqk.f6576bj, 234, 117, 203, 29, bqk.f6526am, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, bqk.f6594ca, 28, 155, 43, 203, 107, bqk.f6598ce, 53, 143, 46}, new int[]{bqk.f6541bA, 93, 169, 50, 144, bqk.f6549bI, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, bqk.f6596cc, 245, 63, 197, 190, 250, 106, 185, bqk.f6559bS, 175, 64, 114, 71, 161, 44, 147, 6, 27, bqk.f6576bj, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, bqk.f6526am, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{bqk.f6558bR, bqk.f6562bV, 173, 89, bqk.f6602ci, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, bqk.f6552bL, 136, bqk.f6595cb, 180, 234, 197, 158, 177, 68, 122, 93, bqk.f6552bL, 15, 160, bqk.f6543bC, bqk.f6567ba, 66, 139, 153, 185, 202, 167, 179, 25, bqk.f6558bR, bqk.f6526am, 96, bqk.f6549bI, bqk.f6597cd, 136, bqk.f6587bu, 239, 181, 241, 59, 52, 172, 25, 49, bqk.f6526am, bqk.f6550bJ, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int[] iArr3 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String createECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = i3;
                int i6 = 0;
                while (i5 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i5, createECCBlock.charAt(i6));
                    i5 += interleavedBlockCount;
                    i6++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            } else if (iArr[i4] == i3) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i3)));
        }
        int[] iArr2 = FACTORS[i4];
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = 0;
        }
        for (int i6 = i; i6 < i + i2; i6++) {
            int i7 = i3 - 1;
            int charAt = cArr[i7] ^ charSequence.charAt(i6);
            while (i7 > 0) {
                if (charAt != 0 && iArr2[i7] != 0) {
                    char c = cArr[i7 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i7] = (char) (c ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i7]]) % 255]);
                } else {
                    cArr[i7] = cArr[i7 - 1];
                }
                i7--;
            }
            if (charAt != 0 && iArr2[0] != 0) {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
            } else {
                cArr[0] = 0;
            }
        }
        char[] cArr2 = new char[i3];
        for (int i8 = 0; i8 < i3; i8++) {
            cArr2[i8] = cArr[(i3 - i8) - 1];
        }
        return String.valueOf(cArr2);
    }
}
