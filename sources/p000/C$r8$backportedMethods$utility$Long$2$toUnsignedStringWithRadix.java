package p000;

/* renamed from: $r8$backportedMethods$utility$Long$2$toUnsignedStringWithRadix  reason: invalid class name */
/* loaded from: classes.dex */
public /* synthetic */ class C$r8$backportedMethods$utility$Long$2$toUnsignedStringWithRadix {
    public static /* synthetic */ String toUnsignedString(long j, int i) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 == 0) {
            return "0";
        }
        if (i2 > 0) {
            return Long.toString(j, i);
        }
        i = (i < 2 || i > 36) ? 10 : 10;
        int i3 = 64;
        char[] cArr = new char[64];
        int i4 = i - 1;
        if ((i & i4) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i3--;
                cArr[i3] = Character.forDigit(((int) j) & i4, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            long divideUnsigned = (i & 1) == 0 ? (j >>> 1) / (i >>> 1) : C$r8$backportedMethods$utility$Long$2$divideUnsigned.divideUnsigned(j, i);
            long j2 = i;
            i3 = 63;
            cArr[63] = Character.forDigit((int) (j - (divideUnsigned * j2)), i);
            while (divideUnsigned > 0) {
                i3--;
                cArr[i3] = Character.forDigit((int) (divideUnsigned % j2), i);
                divideUnsigned /= j2;
            }
        }
        return new String(cArr, i3, 64 - i3);
    }
}
