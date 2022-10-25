package com.frostwire.jlibtorrent;

import com.google.common.base.Ascii;

/* loaded from: classes2.dex */
final class Hex {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private Hex() {
    }

    public static byte[] decode(char[] cArr) {
        int length = cArr.length;
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            i = i3 + 1;
            bArr[i2] = (byte) (((toDigit(cArr[i], i) << 4) | toDigit(cArr[i3], i3)) & 255);
            i2++;
        }
        return bArr;
    }

    public static byte[] decode(String str) {
        return decode(str.toCharArray());
    }

    public static String encode(byte[] bArr) {
        return new String(encode(bArr, DIGITS_LOWER));
    }

    private static char[] encode(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & Ascii.f9766SI];
        }
        return cArr2;
    }

    private static int toDigit(char c, int i) {
        int digit = Character.digit(c, 16);
        if (digit != -1) {
            return digit;
        }
        throw new IllegalArgumentException("Illegal hexadecimal character " + c + " at index " + i);
    }
}
