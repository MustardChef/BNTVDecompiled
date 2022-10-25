package io.reactivex.rxjava3.internal.util;

/* loaded from: classes4.dex */
public final class Pow2 {
    public static boolean isPowerOfTwo(final int value) {
        return (value & (value + (-1))) == 0;
    }

    private Pow2() {
        throw new IllegalStateException("No instances!");
    }

    public static int roundToPowerOfTwo(final int value) {
        return 1 << (32 - Integer.numberOfLeadingZeros(value - 1));
    }
}
