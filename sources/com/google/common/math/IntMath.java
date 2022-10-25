package com.google.common.math;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;

/* loaded from: classes3.dex */
public final class IntMath {
    static final int FLOOR_SQRT_MAX_INT = 46340;
    static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
    static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;
    static final byte[] maxLog10ForLeadingZeros = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    static final int[] powersOf10 = {1, 10, 100, 1000, 10000, AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND, 1000000, 10000000, 100000000, 1000000000};
    static final int[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    private static final int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    static int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static boolean isPowerOfTwo(int i) {
        return (i > 0) & ((i & (i + (-1))) == 0);
    }

    static int lessThanBranchFree(int i, int i2) {
        return (~(~(i - i2))) >>> 31;
    }

    public static int mean(int i, int i2) {
        return (i & i2) + ((i ^ i2) >> 1);
    }

    public static int ceilingPowerOfTwo(int i) {
        MathPreconditions.checkPositive("x", i);
        if (i > 1073741824) {
            throw new ArithmeticException("ceilingPowerOfTwo(" + i + ") not representable as an int");
        }
        return 1 << (-Integer.numberOfLeadingZeros(i - 1));
    }

    public static int floorPowerOfTwo(int i) {
        MathPreconditions.checkPositive("x", i);
        return Integer.highestOneBit(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.math.IntMath$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C43071 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int log2(int i, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", i);
        switch (C43071.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, i);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static int log10(int i, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkPositive("x", i);
        int log10Floor = log10Floor(i);
        int i2 = powersOf10[log10Floor];
        switch (C43071.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(i == i2);
                return log10Floor;
            case 2:
            case 3:
                return log10Floor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(i2, i);
                return log10Floor + lessThanBranchFree;
            case 6:
            case 7:
            case 8:
                lessThanBranchFree = lessThanBranchFree(halfPowersOf10[log10Floor], i);
                return log10Floor + lessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    private static int log10Floor(int i) {
        byte b = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(i)];
        return b - lessThanBranchFree(i, powersOf10[b]);
    }

    public static int pow(int i, int i2) {
        MathPreconditions.checkNonNegative("exponent", i2);
        if (i == -2) {
            if (i2 < 32) {
                return (i2 & 1) == 0 ? 1 << i2 : -(1 << i2);
            }
            return 0;
        } else if (i == -1) {
            return (i2 & 1) == 0 ? 1 : -1;
        } else if (i == 0) {
            return i2 == 0 ? 1 : 0;
        } else if (i != 1) {
            if (i == 2) {
                if (i2 < 32) {
                    return 1 << i2;
                }
                return 0;
            }
            int i3 = 1;
            while (i2 != 0) {
                if (i2 == 1) {
                    return i * i3;
                }
                i3 *= (i2 & 1) == 0 ? 1 : i;
                i *= i;
                i2 >>= 1;
            }
            return i3;
        } else {
            return 1;
        }
    }

    public static int sqrt(int i, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkNonNegative("x", i);
        int sqrtFloor = sqrtFloor(i);
        switch (C43071.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(sqrtFloor * sqrtFloor == i);
                return sqrtFloor;
            case 2:
            case 3:
                return sqrtFloor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(sqrtFloor * sqrtFloor, i);
                return sqrtFloor + lessThanBranchFree;
            case 6:
            case 7:
            case 8:
                lessThanBranchFree = lessThanBranchFree((sqrtFloor * sqrtFloor) + sqrtFloor, i);
                return sqrtFloor + lessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    private static int sqrtFloor(int i) {
        return (int) Math.sqrt(i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        if (((r7 == java.math.RoundingMode.HALF_EVEN) & ((r0 & 1) != 0)) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
        if (r1 > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (r5 > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
        if (r5 < 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int divide(int r5, int r6, java.math.RoundingMode r7) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r7)
            if (r6 == 0) goto L5c
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto Le
            return r0
        Le:
            r5 = r5 ^ r6
            int r5 = r5 >> 31
            r2 = 1
            r5 = r5 | r2
            int[] r3 = com.google.common.math.IntMath.C43071.$SwitchMap$java$math$RoundingMode
            int r4 = r7.ordinal()
            r3 = r3[r4]
            r4 = 0
            switch(r3) {
                case 1: goto L50;
                case 2: goto L57;
                case 3: goto L4d;
                case 4: goto L58;
                case 5: goto L4a;
                case 6: goto L25;
                case 7: goto L25;
                case 8: goto L25;
                default: goto L1f;
            }
        L1f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L25:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L47
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L58
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L3b
            r6 = 1
            goto L3c
        L3b:
            r6 = 0
        L3c:
            r7 = r0 & 1
            if (r7 == 0) goto L42
            r7 = 1
            goto L43
        L42:
            r7 = 0
        L43:
            r6 = r6 & r7
            if (r6 == 0) goto L57
            goto L58
        L47:
            if (r1 <= 0) goto L57
            goto L58
        L4a:
            if (r5 <= 0) goto L57
            goto L58
        L4d:
            if (r5 >= 0) goto L57
            goto L58
        L50:
            if (r1 != 0) goto L53
            goto L54
        L53:
            r2 = 0
        L54:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r2)
        L57:
            r2 = 0
        L58:
            if (r2 == 0) goto L5b
            int r0 = r0 + r5
        L5b:
            return r0
        L5c:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.divide(int, int, java.math.RoundingMode):int");
    }

    public static int mod(int i, int i2) {
        if (i2 <= 0) {
            throw new ArithmeticException("Modulus " + i2 + " must be > 0");
        }
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    public static int gcd(int i, int i2) {
        MathPreconditions.checkNonNegative("a", i);
        MathPreconditions.checkNonNegative("b", i2);
        if (i == 0) {
            return i2;
        }
        if (i2 == 0) {
            return i;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
        int i3 = i >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(i2);
        int i4 = i2 >> numberOfTrailingZeros2;
        while (i3 != i4) {
            int i5 = i3 - i4;
            int i6 = (i5 >> 31) & i5;
            int i7 = (i5 - i6) - i6;
            i4 += i6;
            i3 = i7 >> Integer.numberOfTrailingZeros(i7);
        }
        return i3 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static int checkedAdd(int i, int i2) {
        long j = i + i2;
        int i3 = (int) j;
        MathPreconditions.checkNoOverflow(j == ((long) i3), "checkedAdd", i, i2);
        return i3;
    }

    public static int checkedSubtract(int i, int i2) {
        long j = i - i2;
        int i3 = (int) j;
        MathPreconditions.checkNoOverflow(j == ((long) i3), "checkedSubtract", i, i2);
        return i3;
    }

    public static int checkedMultiply(int i, int i2) {
        long j = i * i2;
        int i3 = (int) j;
        MathPreconditions.checkNoOverflow(j == ((long) i3), "checkedMultiply", i, i2);
        return i3;
    }

    public static int checkedPow(int i, int i2) {
        MathPreconditions.checkNonNegative("exponent", i2);
        if (i == -2) {
            MathPreconditions.checkNoOverflow(i2 < 32, "checkedPow", i, i2);
            return (i2 & 1) == 0 ? 1 << i2 : (-1) << i2;
        } else if (i == -1) {
            return (i2 & 1) == 0 ? 1 : -1;
        } else if (i == 0) {
            return i2 == 0 ? 1 : 0;
        } else if (i != 1) {
            if (i == 2) {
                MathPreconditions.checkNoOverflow(i2 < 31, "checkedPow", i, i2);
                return 1 << i2;
            }
            int i3 = 1;
            while (i2 != 0) {
                if (i2 == 1) {
                    return checkedMultiply(i3, i);
                }
                if ((i2 & 1) != 0) {
                    i3 = checkedMultiply(i3, i);
                }
                i2 >>= 1;
                if (i2 > 0) {
                    MathPreconditions.checkNoOverflow((-46340 <= i) & (i <= FLOOR_SQRT_MAX_INT), "checkedPow", i, i2);
                    i *= i;
                }
            }
            return i3;
        } else {
            return 1;
        }
    }

    public static int saturatedAdd(int i, int i2) {
        return Ints.saturatedCast(i + i2);
    }

    public static int saturatedSubtract(int i, int i2) {
        return Ints.saturatedCast(i - i2);
    }

    public static int saturatedMultiply(int i, int i2) {
        return Ints.saturatedCast(i * i2);
    }

    public static int saturatedPow(int i, int i2) {
        MathPreconditions.checkNonNegative("exponent", i2);
        if (i == -2) {
            return i2 >= 32 ? (i2 & 1) + Integer.MAX_VALUE : (i2 & 1) == 0 ? 1 << i2 : (-1) << i2;
        } else if (i == -1) {
            return (i2 & 1) == 0 ? 1 : -1;
        } else if (i == 0) {
            return i2 == 0 ? 1 : 0;
        } else if (i != 1) {
            if (i == 2) {
                if (i2 >= 31) {
                    return Integer.MAX_VALUE;
                }
                return 1 << i2;
            }
            int i3 = ((i >>> 31) & i2 & 1) + Integer.MAX_VALUE;
            int i4 = 1;
            while (i2 != 0) {
                if (i2 == 1) {
                    return saturatedMultiply(i4, i);
                }
                if ((i2 & 1) != 0) {
                    i4 = saturatedMultiply(i4, i);
                }
                i2 >>= 1;
                if (i2 > 0) {
                    if ((-46340 > i) || (i > FLOOR_SQRT_MAX_INT)) {
                        return i3;
                    }
                    i *= i;
                }
            }
            return i4;
        } else {
            return 1;
        }
    }

    public static int factorial(int i) {
        MathPreconditions.checkNonNegative("n", i);
        int[] iArr = factorials;
        if (i < iArr.length) {
            return iArr[i];
        }
        return Integer.MAX_VALUE;
    }

    public static int binomial(int i, int i2) {
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", i2);
        int i3 = 0;
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        int[] iArr = biggestBinomials;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Integer.MAX_VALUE;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                long j = 1;
                while (i3 < i2) {
                    i3++;
                    j = (j * (i - i3)) / i3;
                }
                return (int) j;
            }
            return i;
        }
        return 1;
    }

    public static boolean isPrime(int i) {
        return LongMath.isPrime(i);
    }

    private IntMath() {
    }
}
