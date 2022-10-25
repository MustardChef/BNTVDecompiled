package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.UtfEncodingKt */
/* loaded from: classes4.dex */
public final class utfEncoding {
    public static final byte[] stringsToBytes(String[] strings) {
        int i;
        Intrinsics.checkNotNullParameter(strings, "strings");
        int i2 = 0;
        for (String str : strings) {
            i2 += str.length();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (String str2 : strings) {
            int length = str2.length() - 1;
            if (length >= 0) {
                int i4 = 0;
                while (true) {
                    i = i3 + 1;
                    bArr[i3] = (byte) str2.charAt(i4);
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                    i3 = i;
                }
                i3 = i;
            }
        }
        return bArr;
    }
}
