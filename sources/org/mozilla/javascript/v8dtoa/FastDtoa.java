package org.mozilla.javascript.v8dtoa;

/* loaded from: classes5.dex */
public class FastDtoa {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int kFastDtoaMaximalLength = 17;
    static final int kTen4 = 10000;
    static final int kTen5 = 100000;
    static final int kTen6 = 1000000;
    static final int kTen7 = 10000000;
    static final int kTen8 = 100000000;
    static final int kTen9 = 1000000000;
    static final int maximal_target_exponent = -32;
    static final int minimal_target_exponent = -60;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static long biggestPowerTen(int r11, int r12) {
        /*
            r0 = 1000000000(0x3b9aca00, float:0.0047237873)
            r1 = 100000000(0x5f5e100, float:2.3122341E-35)
            r2 = 10000000(0x989680, float:1.4012985E-38)
            r3 = 1000000(0xf4240, float:1.401298E-39)
            r4 = 100000(0x186a0, float:1.4013E-40)
            r5 = 10000(0x2710, float:1.4013E-41)
            r6 = 1000(0x3e8, float:1.401E-42)
            r7 = 100
            r8 = 10
            r9 = 1
            r10 = 0
            switch(r12) {
                case 0: goto L5c;
                case 1: goto L58;
                case 2: goto L58;
                case 3: goto L58;
                case 4: goto L53;
                case 5: goto L53;
                case 6: goto L53;
                case 7: goto L4d;
                case 8: goto L4d;
                case 9: goto L4d;
                case 10: goto L47;
                case 11: goto L47;
                case 12: goto L47;
                case 13: goto L47;
                case 14: goto L41;
                case 15: goto L41;
                case 16: goto L41;
                case 17: goto L3a;
                case 18: goto L3a;
                case 19: goto L3a;
                case 20: goto L33;
                case 21: goto L33;
                case 22: goto L33;
                case 23: goto L33;
                case 24: goto L2c;
                case 25: goto L2c;
                case 26: goto L2c;
                case 27: goto L24;
                case 28: goto L24;
                case 29: goto L24;
                case 30: goto L1f;
                case 31: goto L1f;
                case 32: goto L1f;
                default: goto L1c;
            }
        L1c:
            r0 = 0
        L1d:
            r9 = 0
            goto L5e
        L1f:
            if (r0 > r11) goto L24
            r9 = 9
            goto L5e
        L24:
            if (r1 > r11) goto L2c
            r9 = 8
            r0 = 100000000(0x5f5e100, float:2.3122341E-35)
            goto L5e
        L2c:
            if (r2 > r11) goto L33
            r9 = 7
            r0 = 10000000(0x989680, float:1.4012985E-38)
            goto L5e
        L33:
            if (r3 > r11) goto L3a
            r9 = 6
            r0 = 1000000(0xf4240, float:1.401298E-39)
            goto L5e
        L3a:
            if (r4 > r11) goto L41
            r9 = 5
            r0 = 100000(0x186a0, float:1.4013E-40)
            goto L5e
        L41:
            if (r5 > r11) goto L47
            r9 = 4
            r0 = 10000(0x2710, float:1.4013E-41)
            goto L5e
        L47:
            if (r6 > r11) goto L4d
            r9 = 3
            r0 = 1000(0x3e8, float:1.401E-42)
            goto L5e
        L4d:
            if (r7 > r11) goto L53
            r9 = 2
            r0 = 100
            goto L5e
        L53:
            if (r8 > r11) goto L58
            r0 = 10
            goto L5e
        L58:
            if (r9 > r11) goto L5c
            r0 = 1
            goto L1d
        L5c:
            r9 = -1
            r0 = 0
        L5e:
            long r11 = (long) r0
            r0 = 32
            long r11 = r11 << r0
            r0 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = (long) r9
            long r0 = r0 & r2
            long r11 = r11 | r0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.v8dtoa.FastDtoa.biggestPowerTen(int, int):long");
    }

    private static boolean uint64_lte(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i != 0) {
            if (!(((j < 0) ^ (i < 0)) ^ (j2 < 0))) {
                return false;
            }
        }
        return true;
    }

    static boolean roundWeed(FastDtoaBuilder fastDtoaBuilder, long j, long j2, long j3, long j4, long j5) {
        long j6 = j - j5;
        long j7 = j + j5;
        long j8 = j3;
        while (j8 < j6 && j2 - j8 >= j4) {
            long j9 = j8 + j4;
            if (j9 >= j6 && j6 - j8 < j9 - j6) {
                break;
            }
            fastDtoaBuilder.decreaseLast();
            j8 = j9;
        }
        if (j8 < j7 && j2 - j8 >= j4) {
            long j10 = j8 + j4;
            if (j10 < j7 || j7 - j8 > j10 - j7) {
                return false;
            }
        }
        return 2 * j5 <= j8 && j8 <= j2 - (4 * j5);
    }

    static boolean digitGen(DiyFp diyFp, DiyFp diyFp2, DiyFp diyFp3, FastDtoaBuilder fastDtoaBuilder, int i) {
        DiyFp diyFp4 = new DiyFp(diyFp.m35f() - 1, diyFp.m36e());
        DiyFp diyFp5 = new DiyFp(diyFp3.m35f() + 1, diyFp3.m36e());
        DiyFp minus = DiyFp.minus(diyFp5, diyFp4);
        DiyFp diyFp6 = new DiyFp(1 << (-diyFp2.m36e()), diyFp2.m36e());
        int m35f = (int) ((diyFp5.m35f() >>> (-diyFp6.m36e())) & 4294967295L);
        long m35f2 = diyFp5.m35f() & (diyFp6.m35f() - 1);
        long biggestPowerTen = biggestPowerTen(m35f, 64 - (-diyFp6.m36e()));
        int i2 = (int) ((biggestPowerTen >>> 32) & 4294967295L);
        int i3 = ((int) (biggestPowerTen & 4294967295L)) + 1;
        while (i3 > 0) {
            fastDtoaBuilder.append((char) ((m35f / i2) + 48));
            m35f %= i2;
            i3--;
            long j = (m35f << (-diyFp6.m36e())) + m35f2;
            if (j < minus.m35f()) {
                fastDtoaBuilder.point = (fastDtoaBuilder.end - i) + i3;
                return roundWeed(fastDtoaBuilder, DiyFp.minus(diyFp5, diyFp2).m35f(), minus.m35f(), j, i2 << (-diyFp6.m36e()), 1L);
            }
            i2 /= 10;
        }
        long j2 = 1;
        while (true) {
            long j3 = m35f2 * 5;
            j2 *= 5;
            minus.setF(minus.m35f() * 5);
            minus.setE(minus.m36e() + 1);
            diyFp6.setF(diyFp6.m35f() >>> 1);
            diyFp6.setE(diyFp6.m36e() + 1);
            fastDtoaBuilder.append((char) (((int) ((j3 >>> (-diyFp6.m36e())) & 4294967295L)) + 48));
            m35f2 = j3 & (diyFp6.m35f() - 1);
            i3--;
            if (m35f2 < minus.m35f()) {
                fastDtoaBuilder.point = (fastDtoaBuilder.end - i) + i3;
                return roundWeed(fastDtoaBuilder, DiyFp.minus(diyFp5, diyFp2).m35f() * j2, minus.m35f(), m35f2, diyFp6.m35f(), j2);
            }
        }
    }

    static boolean grisu3(double d, FastDtoaBuilder fastDtoaBuilder) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        DiyFp asNormalizedDiyFp = DoubleHelper.asNormalizedDiyFp(doubleToLongBits);
        DiyFp diyFp = new DiyFp();
        DiyFp diyFp2 = new DiyFp();
        DoubleHelper.normalizedBoundaries(doubleToLongBits, diyFp, diyFp2);
        DiyFp diyFp3 = new DiyFp();
        int cachedPower = CachedPowers.getCachedPower(asNormalizedDiyFp.m36e() + 64, minimal_target_exponent, maximal_target_exponent, diyFp3);
        return digitGen(DiyFp.times(diyFp, diyFp3), DiyFp.times(asNormalizedDiyFp, diyFp3), DiyFp.times(diyFp2, diyFp3), fastDtoaBuilder, cachedPower);
    }

    public static boolean dtoa(double d, FastDtoaBuilder fastDtoaBuilder) {
        return grisu3(d, fastDtoaBuilder);
    }

    public static String numberToString(double d) {
        FastDtoaBuilder fastDtoaBuilder = new FastDtoaBuilder();
        if (numberToString(d, fastDtoaBuilder)) {
            return fastDtoaBuilder.format();
        }
        return null;
    }

    public static boolean numberToString(double d, FastDtoaBuilder fastDtoaBuilder) {
        fastDtoaBuilder.reset();
        if (d < 0.0d) {
            fastDtoaBuilder.append('-');
            d = -d;
        }
        return dtoa(d, fastDtoaBuilder);
    }
}
