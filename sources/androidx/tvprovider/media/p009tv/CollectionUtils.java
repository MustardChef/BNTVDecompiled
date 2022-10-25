package androidx.tvprovider.media.p009tv;

import java.util.Arrays;

/* renamed from: androidx.tvprovider.media.tv.CollectionUtils */
/* loaded from: classes.dex */
public class CollectionUtils {
    public static <T> T[] concatAll(T[] tArr, T[]... tArr2) {
        int length = tArr.length;
        for (T[] tArr3 : tArr2) {
            length += tArr3.length;
        }
        T[] tArr4 = (T[]) Arrays.copyOf(tArr, length);
        int length2 = tArr.length;
        for (T[] tArr5 : tArr2) {
            System.arraycopy(tArr5, 0, tArr4, length2, tArr5.length);
            length2 += tArr5.length;
        }
        return tArr4;
    }

    private CollectionUtils() {
    }
}
