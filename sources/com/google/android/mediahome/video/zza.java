package com.google.android.mediahome.video;

import java.util.Arrays;

/* compiled from: com.google.android.mediahome:video@@1.0.0 */
/* loaded from: classes3.dex */
final class zza {
    public static <T> T[] zza(T[] tArr, T[]... tArr2) {
        int length = tArr.length;
        for (int i = 0; i <= 0; i++) {
            length += tArr2[i].length;
        }
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, length);
        int length2 = tArr.length;
        for (int i2 = 0; i2 <= 0; i2++) {
            T[] tArr4 = tArr2[i2];
            int length3 = tArr4.length;
            System.arraycopy(tArr4, 0, tArr3, length2, length3);
            length2 += length3;
        }
        return tArr3;
    }
}
