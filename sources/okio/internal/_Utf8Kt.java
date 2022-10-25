package okio.internal;

import com.fasterxml.jackson.core.base.GeneratorBase;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

/* compiled from: -Utf8.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, m107d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class _Utf8Kt {
    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x009d, code lost:
        if (((r16[r5] & 192) == 128) == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0123, code lost:
        if (((r16[r5] & 192) == 128) == false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String commonToUtf8String(byte[] r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        if (length > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                char charAt = str.charAt(i3);
                if (Intrinsics.compare((int) charAt, 128) >= 0) {
                    int length2 = str.length();
                    int i5 = i3;
                    while (i3 < length2) {
                        char charAt2 = str.charAt(i3);
                        if (Intrinsics.compare((int) charAt2, 128) < 0) {
                            int i6 = i5 + 1;
                            bArr[i5] = (byte) charAt2;
                            i3++;
                            while (true) {
                                i5 = i6;
                                if (i3 < length2 && Intrinsics.compare((int) str.charAt(i3), 128) < 0) {
                                    i6 = i5 + 1;
                                    bArr[i5] = (byte) str.charAt(i3);
                                    i3++;
                                }
                            }
                        } else {
                            if (Intrinsics.compare((int) charAt2, 2048) < 0) {
                                int i7 = i5 + 1;
                                bArr[i5] = (byte) ((charAt2 >> 6) | 192);
                                i = i7 + 1;
                                bArr[i7] = (byte) ((charAt2 & '?') | 128);
                            } else {
                                boolean z = true;
                                if (55296 <= charAt2 && charAt2 <= 57343) {
                                    if (Intrinsics.compare((int) charAt2, (int) GeneratorBase.SURR1_LAST) <= 0 && length2 > (i2 = i3 + 1)) {
                                        char charAt3 = str.charAt(i2);
                                        if ((56320 > charAt3 || charAt3 > 57343) ? false : false) {
                                            int charAt4 = ((charAt2 << '\n') + str.charAt(i2)) - 56613888;
                                            int i8 = i5 + 1;
                                            bArr[i5] = (byte) ((charAt4 >> 18) | 240);
                                            int i9 = i8 + 1;
                                            bArr[i8] = (byte) (((charAt4 >> 12) & 63) | 128);
                                            int i10 = i9 + 1;
                                            bArr[i9] = (byte) (((charAt4 >> 6) & 63) | 128);
                                            i = i10 + 1;
                                            bArr[i10] = (byte) ((charAt4 & 63) | 128);
                                            i3 += 2;
                                            i5 = i;
                                        }
                                    }
                                    i = i5 + 1;
                                    bArr[i5] = Utf8.REPLACEMENT_BYTE;
                                } else {
                                    int i11 = i5 + 1;
                                    bArr[i5] = (byte) ((charAt2 >> '\f') | 224);
                                    int i12 = i11 + 1;
                                    bArr[i11] = (byte) (((charAt2 >> 6) & 63) | 128);
                                    i = i12 + 1;
                                    bArr[i12] = (byte) ((charAt2 & '?') | 128);
                                }
                            }
                            i3++;
                            i5 = i;
                        }
                    }
                    byte[] copyOf = Arrays.copyOf(bArr, i5);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                    return copyOf;
                }
                bArr[i3] = (byte) charAt;
                if (i4 >= length) {
                    break;
                }
                i3 = i4;
            }
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }
}
