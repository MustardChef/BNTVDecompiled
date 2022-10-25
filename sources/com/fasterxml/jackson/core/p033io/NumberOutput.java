package com.fasterxml.jackson.core.p033io;

import androidx.exifinterface.media.ExifInterface;

/* renamed from: com.fasterxml.jackson.core.io.NumberOutput */
/* loaded from: classes2.dex */
public final class NumberOutput {
    private static int BILLION = 1000000000;
    private static long BILLION_L = 1000000000;
    private static long MAX_INT_AS_LONG = 2147483647L;
    private static int MILLION = 1000000;
    private static long MIN_INT_AS_LONG = -2147483648L;
    static final String SMALLEST_INT = String.valueOf(Integer.MIN_VALUE);
    static final String SMALLEST_LONG = String.valueOf(Long.MIN_VALUE);
    private static final int[] TRIPLET_TO_CHARS = new int[1000];
    private static final String[] sSmallIntStrs;
    private static final String[] sSmallIntStrs2;

    static {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                int i4 = 0;
                while (i4 < 10) {
                    TRIPLET_TO_CHARS[i] = ((i2 + 48) << 16) | ((i3 + 48) << 8) | (i4 + 48);
                    i4++;
                    i++;
                }
            }
        }
        sSmallIntStrs = new String[]{"0", "1", ExifInterface.GPS_MEASUREMENT_2D, "3", "4", "5", "6", "7", "8", "9", "10"};
        sSmallIntStrs2 = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    public static int outputInt(int i, char[] cArr, int i2) {
        int i3;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return _outputSmallestI(cArr, i2);
            }
            cArr[i2] = '-';
            i = -i;
            i2++;
        }
        if (i < MILLION) {
            if (i >= 1000) {
                int i4 = i / 1000;
                return _full3(i - (i4 * 1000), cArr, _leading3(i4, cArr, i2));
            } else if (i < 10) {
                cArr[i2] = (char) (i + 48);
                return i2 + 1;
            } else {
                return _leading3(i, cArr, i2);
            }
        }
        int i5 = BILLION;
        if (i >= i5) {
            int i6 = i - i5;
            if (i6 >= i5) {
                i6 -= i5;
                i3 = i2 + 1;
                cArr[i2] = '2';
            } else {
                i3 = i2 + 1;
                cArr[i2] = '1';
            }
            return _outputFullBillion(i6, cArr, i3);
        }
        int i7 = i / 1000;
        int i8 = i7 / 1000;
        return _full3(i - (i7 * 1000), cArr, _full3(i7 - (i8 * 1000), cArr, _leading3(i8, cArr, i2)));
    }

    public static int outputInt(int i, byte[] bArr, int i2) {
        int i3;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return _outputSmallestI(bArr, i2);
            }
            bArr[i2] = 45;
            i = -i;
            i2++;
        }
        if (i < MILLION) {
            if (i >= 1000) {
                int i4 = i / 1000;
                return _full3(i - (i4 * 1000), bArr, _leading3(i4, bArr, i2));
            } else if (i < 10) {
                int i5 = i2 + 1;
                bArr[i2] = (byte) (i + 48);
                return i5;
            } else {
                return _leading3(i, bArr, i2);
            }
        }
        int i6 = BILLION;
        if (i >= i6) {
            int i7 = i - i6;
            if (i7 >= i6) {
                i7 -= i6;
                i3 = i2 + 1;
                bArr[i2] = 50;
            } else {
                i3 = i2 + 1;
                bArr[i2] = 49;
            }
            return _outputFullBillion(i7, bArr, i3);
        }
        int i8 = i / 1000;
        int i9 = i8 / 1000;
        return _full3(i - (i8 * 1000), bArr, _full3(i8 - (i9 * 1000), bArr, _leading3(i9, bArr, i2)));
    }

    public static int outputLong(long j, char[] cArr, int i) {
        int _outputFullBillion;
        if (j < 0) {
            if (j > MIN_INT_AS_LONG) {
                return outputInt((int) j, cArr, i);
            }
            if (j == Long.MIN_VALUE) {
                return _outputSmallestL(cArr, i);
            }
            cArr[i] = '-';
            j = -j;
            i++;
        } else if (j <= MAX_INT_AS_LONG) {
            return outputInt((int) j, cArr, i);
        }
        long j2 = BILLION_L;
        long j3 = j / j2;
        long j4 = j - (j3 * j2);
        if (j3 < j2) {
            _outputFullBillion = _outputUptoBillion((int) j3, cArr, i);
        } else {
            long j5 = j3 / j2;
            int _leading3 = _leading3((int) j5, cArr, i);
            _outputFullBillion = _outputFullBillion((int) (j3 - (j2 * j5)), cArr, _leading3);
        }
        return _outputFullBillion((int) j4, cArr, _outputFullBillion);
    }

    public static int outputLong(long j, byte[] bArr, int i) {
        int _outputFullBillion;
        if (j < 0) {
            if (j > MIN_INT_AS_LONG) {
                return outputInt((int) j, bArr, i);
            }
            if (j == Long.MIN_VALUE) {
                return _outputSmallestL(bArr, i);
            }
            bArr[i] = 45;
            j = -j;
            i++;
        } else if (j <= MAX_INT_AS_LONG) {
            return outputInt((int) j, bArr, i);
        }
        long j2 = BILLION_L;
        long j3 = j / j2;
        long j4 = j - (j3 * j2);
        if (j3 < j2) {
            _outputFullBillion = _outputUptoBillion((int) j3, bArr, i);
        } else {
            long j5 = j3 / j2;
            int _leading3 = _leading3((int) j5, bArr, i);
            _outputFullBillion = _outputFullBillion((int) (j3 - (j2 * j5)), bArr, _leading3);
        }
        return _outputFullBillion((int) j4, bArr, _outputFullBillion);
    }

    public static String toString(int i) {
        String[] strArr = sSmallIntStrs;
        if (i < strArr.length) {
            if (i >= 0) {
                return strArr[i];
            }
            int i2 = (-i) - 1;
            String[] strArr2 = sSmallIntStrs2;
            if (i2 < strArr2.length) {
                return strArr2[i2];
            }
        }
        return Integer.toString(i);
    }

    public static String toString(long j) {
        if (j <= 2147483647L && j >= -2147483648L) {
            return toString((int) j);
        }
        return Long.toString(j);
    }

    public static String toString(double d) {
        return Double.toString(d);
    }

    public static String toString(float f) {
        return Float.toString(f);
    }

    public static boolean notFinite(double d) {
        return Double.isNaN(d) || Double.isInfinite(d);
    }

    public static boolean notFinite(float f) {
        return Float.isNaN(f) || Float.isInfinite(f);
    }

    private static int _outputUptoBillion(int i, char[] cArr, int i2) {
        if (i < MILLION) {
            if (i < 1000) {
                return _leading3(i, cArr, i2);
            }
            int i3 = i / 1000;
            return _outputUptoMillion(cArr, i2, i3, i - (i3 * 1000));
        }
        int i4 = i / 1000;
        int i5 = i - (i4 * 1000);
        int i6 = i4 / 1000;
        int _leading3 = _leading3(i6, cArr, i2);
        int[] iArr = TRIPLET_TO_CHARS;
        int i7 = iArr[i4 - (i6 * 1000)];
        int i8 = _leading3 + 1;
        cArr[_leading3] = (char) (i7 >> 16);
        int i9 = i8 + 1;
        cArr[i8] = (char) ((i7 >> 8) & 127);
        int i10 = i9 + 1;
        cArr[i9] = (char) (i7 & 127);
        int i11 = iArr[i5];
        int i12 = i10 + 1;
        cArr[i10] = (char) (i11 >> 16);
        int i13 = i12 + 1;
        cArr[i12] = (char) ((i11 >> 8) & 127);
        int i14 = i13 + 1;
        cArr[i13] = (char) (i11 & 127);
        return i14;
    }

    private static int _outputFullBillion(int i, char[] cArr, int i2) {
        int i3 = i / 1000;
        int i4 = i - (i3 * 1000);
        int i5 = i3 / 1000;
        int[] iArr = TRIPLET_TO_CHARS;
        int i6 = iArr[i5];
        int i7 = i2 + 1;
        cArr[i2] = (char) (i6 >> 16);
        int i8 = i7 + 1;
        cArr[i7] = (char) ((i6 >> 8) & 127);
        int i9 = i8 + 1;
        cArr[i8] = (char) (i6 & 127);
        int i10 = iArr[i3 - (i5 * 1000)];
        int i11 = i9 + 1;
        cArr[i9] = (char) (i10 >> 16);
        int i12 = i11 + 1;
        cArr[i11] = (char) ((i10 >> 8) & 127);
        int i13 = i12 + 1;
        cArr[i12] = (char) (i10 & 127);
        int i14 = iArr[i4];
        int i15 = i13 + 1;
        cArr[i13] = (char) (i14 >> 16);
        int i16 = i15 + 1;
        cArr[i15] = (char) ((i14 >> 8) & 127);
        int i17 = i16 + 1;
        cArr[i16] = (char) (i14 & 127);
        return i17;
    }

    private static int _outputUptoBillion(int i, byte[] bArr, int i2) {
        if (i < MILLION) {
            if (i < 1000) {
                return _leading3(i, bArr, i2);
            }
            int i3 = i / 1000;
            return _outputUptoMillion(bArr, i2, i3, i - (i3 * 1000));
        }
        int i4 = i / 1000;
        int i5 = i - (i4 * 1000);
        int i6 = i4 / 1000;
        int _leading3 = _leading3(i6, bArr, i2);
        int[] iArr = TRIPLET_TO_CHARS;
        int i7 = iArr[i4 - (i6 * 1000)];
        int i8 = _leading3 + 1;
        bArr[_leading3] = (byte) (i7 >> 16);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) i7;
        int i11 = iArr[i5];
        int i12 = i10 + 1;
        bArr[i10] = (byte) (i11 >> 16);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i11 >> 8);
        int i14 = i13 + 1;
        bArr[i13] = (byte) i11;
        return i14;
    }

    private static int _outputFullBillion(int i, byte[] bArr, int i2) {
        int i3 = i / 1000;
        int i4 = i - (i3 * 1000);
        int i5 = i3 / 1000;
        int i6 = i3 - (i5 * 1000);
        int[] iArr = TRIPLET_TO_CHARS;
        int i7 = iArr[i5];
        int i8 = i2 + 1;
        bArr[i2] = (byte) (i7 >> 16);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) i7;
        int i11 = iArr[i6];
        int i12 = i10 + 1;
        bArr[i10] = (byte) (i11 >> 16);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i11 >> 8);
        int i14 = i13 + 1;
        bArr[i13] = (byte) i11;
        int i15 = iArr[i4];
        int i16 = i14 + 1;
        bArr[i14] = (byte) (i15 >> 16);
        int i17 = i16 + 1;
        bArr[i16] = (byte) (i15 >> 8);
        int i18 = i17 + 1;
        bArr[i17] = (byte) i15;
        return i18;
    }

    private static int _outputUptoMillion(char[] cArr, int i, int i2, int i3) {
        int[] iArr = TRIPLET_TO_CHARS;
        int i4 = iArr[i2];
        if (i2 > 9) {
            if (i2 > 99) {
                cArr[i] = (char) (i4 >> 16);
                i++;
            }
            cArr[i] = (char) ((i4 >> 8) & 127);
            i++;
        }
        int i5 = i + 1;
        cArr[i] = (char) (i4 & 127);
        int i6 = iArr[i3];
        int i7 = i5 + 1;
        cArr[i5] = (char) (i6 >> 16);
        int i8 = i7 + 1;
        cArr[i7] = (char) ((i6 >> 8) & 127);
        int i9 = i8 + 1;
        cArr[i8] = (char) (i6 & 127);
        return i9;
    }

    private static int _outputUptoMillion(byte[] bArr, int i, int i2, int i3) {
        int[] iArr = TRIPLET_TO_CHARS;
        int i4 = iArr[i2];
        if (i2 > 9) {
            if (i2 > 99) {
                bArr[i] = (byte) (i4 >> 16);
                i++;
            }
            bArr[i] = (byte) (i4 >> 8);
            i++;
        }
        int i5 = i + 1;
        bArr[i] = (byte) i4;
        int i6 = iArr[i3];
        int i7 = i5 + 1;
        bArr[i5] = (byte) (i6 >> 16);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (i6 >> 8);
        int i9 = i8 + 1;
        bArr[i8] = (byte) i6;
        return i9;
    }

    private static int _leading3(int i, char[] cArr, int i2) {
        int i3 = TRIPLET_TO_CHARS[i];
        if (i > 9) {
            if (i > 99) {
                cArr[i2] = (char) (i3 >> 16);
                i2++;
            }
            cArr[i2] = (char) ((i3 >> 8) & 127);
            i2++;
        }
        int i4 = i2 + 1;
        cArr[i2] = (char) (i3 & 127);
        return i4;
    }

    private static int _leading3(int i, byte[] bArr, int i2) {
        int i3 = TRIPLET_TO_CHARS[i];
        if (i > 9) {
            if (i > 99) {
                bArr[i2] = (byte) (i3 >> 16);
                i2++;
            }
            bArr[i2] = (byte) (i3 >> 8);
            i2++;
        }
        int i4 = i2 + 1;
        bArr[i2] = (byte) i3;
        return i4;
    }

    private static int _full3(int i, char[] cArr, int i2) {
        int i3 = TRIPLET_TO_CHARS[i];
        int i4 = i2 + 1;
        cArr[i2] = (char) (i3 >> 16);
        int i5 = i4 + 1;
        cArr[i4] = (char) ((i3 >> 8) & 127);
        int i6 = i5 + 1;
        cArr[i5] = (char) (i3 & 127);
        return i6;
    }

    private static int _full3(int i, byte[] bArr, int i2) {
        int i3 = TRIPLET_TO_CHARS[i];
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 >> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i3;
        return i6;
    }

    private static int _outputSmallestL(char[] cArr, int i) {
        String str = SMALLEST_LONG;
        int length = str.length();
        str.getChars(0, length, cArr, i);
        return i + length;
    }

    private static int _outputSmallestL(byte[] bArr, int i) {
        int length = SMALLEST_LONG.length();
        int i2 = 0;
        while (i2 < length) {
            bArr[i] = (byte) SMALLEST_LONG.charAt(i2);
            i2++;
            i++;
        }
        return i;
    }

    private static int _outputSmallestI(char[] cArr, int i) {
        String str = SMALLEST_INT;
        int length = str.length();
        str.getChars(0, length, cArr, i);
        return i + length;
    }

    private static int _outputSmallestI(byte[] bArr, int i) {
        int length = SMALLEST_INT.length();
        int i2 = 0;
        while (i2 < length) {
            bArr[i] = (byte) SMALLEST_INT.charAt(i2);
            i2++;
            i++;
        }
        return i;
    }
}
