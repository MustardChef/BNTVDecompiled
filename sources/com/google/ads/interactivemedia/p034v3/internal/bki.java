package com.google.ads.interactivemedia.p034v3.internal;

import java.util.TimeZone;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bki */
/* loaded from: classes2.dex */
public final class bki {

    /* renamed from: a */
    private static final TimeZone f5940a = TimeZone.getTimeZone("UTC");

    /* JADX WARN: Removed duplicated region for block: B:59:0x00e3 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01e6, NumberFormatException -> 0x01e8, IndexOutOfBoundsException -> 0x01ea, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01e6, blocks: (B:3:0x0005, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0035, B:13:0x003b, B:17:0x0051, B:19:0x0061, B:20:0x0063, B:22:0x006f, B:23:0x0071, B:25:0x0077, B:29:0x0081, B:34:0x0091, B:36:0x0099, B:37:0x009d, B:39:0x00a3, B:44:0x00b0, B:46:0x00ba, B:57:0x00dd, B:59:0x00e3, B:61:0x00ea, B:89:0x01ac, B:66:0x00f6, B:67:0x0113, B:68:0x0114, B:70:0x011e, B:71:0x0128, B:73:0x0135, B:76:0x013e, B:78:0x014a, B:80:0x0154, B:82:0x0162, B:85:0x0171, B:86:0x01a6, B:79:0x014f, B:88:0x01a9, B:91:0x01de, B:92:0x01e5, B:50:0x00ca, B:51:0x00cd, B:45:0x00b5), top: B:108:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01de A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01e6, NumberFormatException -> 0x01e8, IndexOutOfBoundsException -> 0x01ea, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01e6, blocks: (B:3:0x0005, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0035, B:13:0x003b, B:17:0x0051, B:19:0x0061, B:20:0x0063, B:22:0x006f, B:23:0x0071, B:25:0x0077, B:29:0x0081, B:34:0x0091, B:36:0x0099, B:37:0x009d, B:39:0x00a3, B:44:0x00b0, B:46:0x00ba, B:57:0x00dd, B:59:0x00e3, B:61:0x00ea, B:89:0x01ac, B:66:0x00f6, B:67:0x0113, B:68:0x0114, B:70:0x011e, B:71:0x0128, B:73:0x0135, B:76:0x013e, B:78:0x014a, B:80:0x0154, B:82:0x0162, B:85:0x0171, B:86:0x01a6, B:79:0x014f, B:88:0x01a9, B:91:0x01de, B:92:0x01e5, B:50:0x00ca, B:51:0x00cd, B:45:0x00b5), top: B:108:0x0005 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date m3610a(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bki.m3610a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    /* renamed from: b */
    private static int m3609b(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                String valueOf = String.valueOf(str.substring(i, i2));
                throw new NumberFormatException(valueOf.length() != 0 ? "Invalid number: ".concat(valueOf) : new String("Invalid number: "));
            }
            i3 = -digit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                String valueOf2 = String.valueOf(str.substring(i, i2));
                throw new NumberFormatException(valueOf2.length() != 0 ? "Invalid number: ".concat(valueOf2) : new String("Invalid number: "));
            }
            i3 = (i3 * 10) - digit2;
            i4 = i5;
        }
        return -i3;
    }

    /* renamed from: c */
    private static boolean m3608c(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }
}
