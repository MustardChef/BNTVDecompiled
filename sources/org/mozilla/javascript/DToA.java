package org.mozilla.javascript;

import java.math.BigInteger;

/* loaded from: classes5.dex */
class DToA {
    private static final int Bias = 1023;
    private static final int Bletch = 16;
    private static final int Bndry_mask = 1048575;
    static final int DTOSTR_EXPONENTIAL = 3;
    static final int DTOSTR_FIXED = 2;
    static final int DTOSTR_PRECISION = 4;
    static final int DTOSTR_STANDARD = 0;
    static final int DTOSTR_STANDARD_EXPONENTIAL = 1;
    private static final int Exp_11 = 1072693248;
    private static final int Exp_mask = 2146435072;
    private static final int Exp_mask_shifted = 2047;
    private static final int Exp_msk1 = 1048576;
    private static final long Exp_msk1L = 4503599627370496L;
    private static final int Exp_shift = 20;
    private static final int Exp_shift1 = 20;
    private static final int Exp_shiftL = 52;
    private static final int Frac_mask = 1048575;
    private static final int Frac_mask1 = 1048575;
    private static final long Frac_maskL = 4503599627370495L;
    private static final int Int_max = 14;
    private static final int Log2P = 1;

    /* renamed from: P */
    private static final int f10718P = 53;
    private static final int Quick_max = 14;
    private static final int Sign_bit = Integer.MIN_VALUE;
    private static final int Ten_pmax = 22;
    private static final int n_bigtens = 5;
    private static final double[] tens = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};
    private static final double[] bigtens = {1.0E16d, 1.0E32d, 1.0E64d, 1.0E128d, 1.0E256d};
    private static final int[] dtoaModes = {0, 0, 3, 2, 2};

    private static char BASEDIGIT(int i) {
        return (char) (i >= 10 ? i + 87 : i + 48);
    }

    private static int hi0bits(int i) {
        int i2;
        if (((-65536) & i) == 0) {
            i <<= 16;
            i2 = 16;
        } else {
            i2 = 0;
        }
        if (((-16777216) & i) == 0) {
            i2 += 8;
            i <<= 8;
        }
        if (((-268435456) & i) == 0) {
            i2 += 4;
            i <<= 4;
        }
        if (((-1073741824) & i) == 0) {
            i2 += 2;
            i <<= 2;
        }
        if ((Integer.MIN_VALUE & i) == 0) {
            i2++;
            if ((i & 1073741824) == 0) {
                return 32;
            }
        }
        return i2;
    }

    private static int lo0bits(int i) {
        int i2 = 0;
        if ((i & 7) != 0) {
            if ((i & 1) != 0) {
                return 0;
            }
            return (i & 2) != 0 ? 1 : 2;
        }
        if ((65535 & i) == 0) {
            i >>>= 16;
            i2 = 16;
        }
        if ((i & 255) == 0) {
            i2 += 8;
            i >>>= 8;
        }
        if ((i & 15) == 0) {
            i2 += 4;
            i >>>= 4;
        }
        if ((i & 3) == 0) {
            i2 += 2;
            i >>>= 2;
        }
        if ((i & 1) == 0) {
            i2++;
            if (((i >>> 1) & 1) == 0) {
                return 32;
            }
        }
        return i2;
    }

    DToA() {
    }

    private static void stuffBits(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.math.BigInteger d2b(double r8, int[] r10, int[] r11) {
        /*
            long r8 = java.lang.Double.doubleToLongBits(r8)
            r0 = 32
            long r1 = r8 >>> r0
            int r2 = (int) r1
            int r9 = (int) r8
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r2
            r1 = 2147483647(0x7fffffff, float:NaN)
            r1 = r1 & r2
            int r1 = r1 >>> 20
            if (r1 == 0) goto L19
            r2 = 1048576(0x100000, float:1.469368E-39)
            r8 = r8 | r2
        L19:
            r2 = 1
            r3 = 4
            r4 = 0
            if (r9 == 0) goto L3d
            r5 = 8
            byte[] r5 = new byte[r5]
            int r6 = lo0bits(r9)
            int r9 = r9 >>> r6
            if (r6 == 0) goto L33
            int r7 = 32 - r6
            int r7 = r8 << r7
            r9 = r9 | r7
            stuffBits(r5, r3, r9)
            int r8 = r8 >> r6
            goto L36
        L33:
            stuffBits(r5, r3, r9)
        L36:
            stuffBits(r5, r4, r8)
            if (r8 == 0) goto L49
            r9 = 2
            goto L4a
        L3d:
            byte[] r5 = new byte[r3]
            int r9 = lo0bits(r8)
            int r8 = r8 >>> r9
            stuffBits(r5, r4, r8)
            int r6 = r9 + 32
        L49:
            r9 = 1
        L4a:
            if (r1 == 0) goto L58
            int r1 = r1 + (-1023)
            int r1 = r1 + (-52)
            int r1 = r1 + r6
            r10[r4] = r1
            int r8 = 53 - r6
            r11[r4] = r8
            goto L69
        L58:
            int r1 = r1 + (-1023)
            int r1 = r1 + (-52)
            int r1 = r1 + r2
            int r1 = r1 + r6
            r10[r4] = r1
            int r9 = r9 * 32
            int r8 = hi0bits(r8)
            int r9 = r9 - r8
            r11[r4] = r9
        L69:
            java.math.BigInteger r8 = new java.math.BigInteger
            r8.<init>(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.DToA.d2b(double, int[], int[]):java.math.BigInteger");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0115, code lost:
        if (r7 > 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0121, code lost:
        if (r9 > 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0130, code lost:
        if (r6.compareTo(r3) > 0) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0142 A[LOOP:0: B:57:0x00d9->B:86:0x0142, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String JS_dtobasestr(int r11, double r12) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.DToA.JS_dtobasestr(int, double):java.lang.String");
    }

    static int word0(double d) {
        return (int) (Double.doubleToLongBits(d) >> 32);
    }

    static double setWord0(double d, int i) {
        return Double.longBitsToDouble((Double.doubleToLongBits(d) & 4294967295L) | (i << 32));
    }

    static int word1(double d) {
        return (int) Double.doubleToLongBits(d);
    }

    static BigInteger pow5mult(BigInteger bigInteger, int i) {
        return bigInteger.multiply(BigInteger.valueOf(5L).pow(i));
    }

    static boolean roundOff(StringBuilder sb) {
        int length = sb.length();
        while (length != 0) {
            length--;
            char charAt = sb.charAt(length);
            if (charAt != '9') {
                sb.setCharAt(length, (char) (charAt + 1));
                sb.setLength(length + 1);
                return false;
            }
        }
        sb.setLength(0);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:352:0x05e6, code lost:
        if (r12 <= 0) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x05e8, code lost:
        r2 = r11.shiftLeft(1).compareTo(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x05f1, code lost:
        if (r2 > 0) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x05f3, code lost:
        if (r2 != 0) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x05f7, code lost:
        if ((r8 & 1) == 1) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x05f9, code lost:
        if (r44 == false) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x05fb, code lost:
        r0 = (char) (r8 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0600, code lost:
        if (r8 != '9') goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0602, code lost:
        r47.append('9');
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0609, code lost:
        if (roundOff(r47) == false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x060b, code lost:
        r14 = r14 + 1;
        r47.append('1');
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x0614, code lost:
        return r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0615, code lost:
        r11 = 1;
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x0618, code lost:
        r11 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0619, code lost:
        r47.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x061d, code lost:
        return r14 + r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x041f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0641 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int JS_dtoa(double r41, int r43, boolean r44, int r45, boolean[] r46, java.lang.StringBuilder r47) {
        /*
            Method dump skipped, instructions count: 1644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.DToA.JS_dtoa(double, int, boolean, int, boolean[], java.lang.StringBuilder):int");
    }

    private static void stripTrailingZeroes(StringBuilder sb) {
        int i;
        int length = sb.length();
        while (true) {
            i = length - 1;
            if (length <= 0 || sb.charAt(i) != '0') {
                break;
            }
            length = i;
        }
        sb.setLength(i + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
        if (r1 <= r13) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x005f A[LOOP:0: B:41:0x005f->B:42:0x0066, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void JS_dtostr(java.lang.StringBuilder r11, int r12, int r13, double r14) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.DToA.JS_dtostr(java.lang.StringBuilder, int, int, double):void");
    }
}
