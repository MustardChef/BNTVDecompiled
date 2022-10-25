package com.fasterxml.jackson.core.p033io;

import java.math.BigDecimal;
import java.util.Arrays;

/* renamed from: com.fasterxml.jackson.core.io.BigDecimalParser */
/* loaded from: classes2.dex */
public final class BigDecimalParser {
    private final char[] chars;

    BigDecimalParser(char[] cArr) {
        this.chars = cArr;
    }

    public static BigDecimal parse(String str) {
        return parse(str.toCharArray());
    }

    public static BigDecimal parse(char[] cArr, int i, int i2) {
        if (i > 0 || i2 != cArr.length) {
            cArr = Arrays.copyOfRange(cArr, i, i2 + i);
        }
        return parse(cArr);
    }

    public static BigDecimal parse(char[] cArr) {
        int length = cArr.length;
        try {
            if (length < 500) {
                return new BigDecimal(cArr);
            }
            return new BigDecimalParser(cArr).parseBigDecimal(length / 10);
        } catch (NumberFormatException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Not a valid number representation";
            }
            throw new NumberFormatException("Value \"" + new String(cArr) + "\" can not be represented as `java.math.BigDecimal`, reason: " + message);
        }
    }

    private BigDecimal parseBigDecimal(int i) {
        int i2;
        int i3;
        BigDecimal bigDecimalRec;
        int length = this.chars.length;
        int i4 = -1;
        int i5 = 0;
        int i6 = -1;
        boolean z = false;
        boolean z2 = false;
        int i7 = 0;
        boolean z3 = false;
        for (int i8 = 0; i8 < length; i8++) {
            char c = this.chars[i8];
            if (c != '+') {
                if (c == 'E' || c == 'e') {
                    if (i4 >= 0) {
                        throw new NumberFormatException("Multiple exponent markers");
                    }
                    i4 = i8;
                } else if (c != '-') {
                    if (c != '.') {
                        if (i6 >= 0 && i4 == -1) {
                            i5++;
                        }
                    } else if (i6 >= 0) {
                        throw new NumberFormatException("Multiple decimal points");
                    } else {
                        i6 = i8;
                    }
                } else if (i4 >= 0) {
                    if (z2) {
                        throw new NumberFormatException("Multiple signs in exponent");
                    }
                    z2 = true;
                } else if (z) {
                    throw new NumberFormatException("Multiple signs in number");
                } else {
                    i7 = i8 + 1;
                    z = true;
                    z3 = true;
                }
            } else if (i4 >= 0) {
                if (z2) {
                    throw new NumberFormatException("Multiple signs in exponent");
                }
                z2 = true;
            } else if (z) {
                throw new NumberFormatException("Multiple signs in number");
            } else {
                i7 = i8 + 1;
                z = true;
            }
        }
        if (i4 >= 0) {
            i2 = 1;
            i3 = Integer.parseInt(new String(this.chars, i4 + 1, (length - i4) - 1));
            i5 = adjustScale(i5, i3);
            length = i4;
        } else {
            i2 = 1;
            i3 = 0;
        }
        if (i6 >= 0) {
            int i9 = (length - i6) - i2;
            bigDecimalRec = toBigDecimalRec(i7, i6 - i7, i3, i).add(toBigDecimalRec(i6 + i2, i9, i3 - i9, i));
        } else {
            bigDecimalRec = toBigDecimalRec(i7, length - i7, i3, i);
        }
        if (i5 != 0) {
            bigDecimalRec = bigDecimalRec.setScale(i5);
        }
        return z3 ? bigDecimalRec.negate() : bigDecimalRec;
    }

    private int adjustScale(int i, long j) {
        long j2 = i - j;
        if (j2 > 2147483647L || j2 < -2147483648L) {
            throw new NumberFormatException("Scale out of range: " + j2 + " while adjusting scale " + i + " to exponent " + j);
        }
        return (int) j2;
    }

    private BigDecimal toBigDecimalRec(int i, int i2, int i3, int i4) {
        if (i2 <= i4) {
            return i2 == 0 ? BigDecimal.ZERO : new BigDecimal(this.chars, i, i2).movePointRight(i3);
        }
        int i5 = i2 / 2;
        return toBigDecimalRec(i, i5, (i3 + i2) - i5, i4).add(toBigDecimalRec(i + i5, i2 - i5, i3, i4));
    }
}
