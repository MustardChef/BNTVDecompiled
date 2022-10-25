package org.mozilla.javascript.v8dtoa;

/* loaded from: classes5.dex */
public class DoubleHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int kDenormalExponent = -1074;
    private static final int kExponentBias = 1075;
    static final long kExponentMask = 9218868437227405312L;
    static final long kHiddenBit = 4503599627370496L;
    static final long kSignMask = Long.MIN_VALUE;
    static final long kSignificandMask = 4503599627370495L;
    private static final int kSignificandSize = 52;

    static boolean isDenormal(long j) {
        return (j & kExponentMask) == 0;
    }

    static boolean isInfinite(long j) {
        return (j & kExponentMask) == kExponentMask && (j & kSignificandMask) == 0;
    }

    static boolean isNan(long j) {
        return (j & kExponentMask) == kExponentMask && (j & kSignificandMask) != 0;
    }

    static boolean isSpecial(long j) {
        return (j & kExponentMask) == kExponentMask;
    }

    static int sign(long j) {
        return (j & Long.MIN_VALUE) == 0 ? 1 : -1;
    }

    static DiyFp asDiyFp(long j) {
        return new DiyFp(significand(j), exponent(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DiyFp asNormalizedDiyFp(long j) {
        long significand = significand(j);
        int exponent = exponent(j);
        while ((kHiddenBit & significand) == 0) {
            significand <<= 1;
            exponent--;
        }
        return new DiyFp(significand << 11, exponent - 11);
    }

    static int exponent(long j) {
        return isDenormal(j) ? kDenormalExponent : ((int) (((j & kExponentMask) >>> 52) & 4294967295L)) - 1075;
    }

    static long significand(long j) {
        long j2 = kSignificandMask & j;
        return !isDenormal(j) ? j2 + kHiddenBit : j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void normalizedBoundaries(long j, DiyFp diyFp, DiyFp diyFp2) {
        DiyFp asDiyFp = asDiyFp(j);
        boolean z = asDiyFp.m35f() == kHiddenBit;
        diyFp2.setF((asDiyFp.m35f() << 1) + 1);
        diyFp2.setE(asDiyFp.m36e() - 1);
        diyFp2.normalize();
        if (z && asDiyFp.m36e() != kDenormalExponent) {
            diyFp.setF((asDiyFp.m35f() << 2) - 1);
            diyFp.setE(asDiyFp.m36e() - 2);
        } else {
            diyFp.setF((asDiyFp.m35f() << 1) - 1);
            diyFp.setE(asDiyFp.m36e() - 1);
        }
        diyFp.setF(diyFp.m35f() << (diyFp.m36e() - diyFp2.m36e()));
        diyFp.setE(diyFp2.m36e());
    }
}
