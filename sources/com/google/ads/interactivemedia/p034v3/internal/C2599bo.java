package com.google.ads.interactivemedia.p034v3.internal;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bo */
/* loaded from: classes2.dex */
public final class C2599bo {

    /* renamed from: a */
    public static final /* synthetic */ int f6302a = 0;

    /* renamed from: b */
    private static final byte[] f6303b = {0, 0, 0, 1};

    /* renamed from: c */
    private static final String[] f6304c = {"", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C"};

    /* renamed from: a */
    public static String m3196a(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    /* renamed from: b */
    public static String m3195b(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        Object[] objArr = new Object[5];
        objArr[0] = f6304c[i];
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Character.valueOf(true != z ? 'L' : 'H');
        objArr[4] = Integer.valueOf(i4);
        StringBuilder sb = new StringBuilder(C2628cq.m2577F("hvc1.%s%d.%X.%c%d", objArr));
        int i5 = 6;
        while (i5 > 0) {
            int i6 = i5 - 1;
            if (iArr[i6] != 0) {
                break;
            }
            i5 = i6;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i7])));
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static byte[] m3194c(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2 + 4];
        System.arraycopy(f6303b, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }
}
