package kotlin.collections;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedUtils;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, m107d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", TtmlNode.RIGHT, "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: kotlin.collections.UArraySortingKt */
/* loaded from: classes4.dex */
public final class UArraySorting {
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    private static final int m9514partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m9141getw2LRezQ = UByteArray.m9141getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m9141getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m9141getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m9141getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m9141getw2LRezQ2 = UByteArray.m9141getw2LRezQ(bArr, i);
                UByteArray.m9146setVurrAj0(bArr, i, UByteArray.m9141getw2LRezQ(bArr, i2));
                UByteArray.m9146setVurrAj0(bArr, i2, m9141getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    private static final void m9518quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m9514partition4UcCI2c = m9514partition4UcCI2c(bArr, i, i2);
        int i3 = m9514partition4UcCI2c - 1;
        if (i < i3) {
            m9518quickSort4UcCI2c(bArr, i, i3);
        }
        if (m9514partition4UcCI2c < i2) {
            m9518quickSort4UcCI2c(bArr, m9514partition4UcCI2c, i2);
        }
    }

    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    private static final int m9515partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m9401getMh2AYeg = UShortArray.m9401getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m9401getMh2AYeg2 = UShortArray.m9401getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = m9401getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m9401getMh2AYeg2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m9401getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m9401getMh2AYeg3 = UShortArray.m9401getMh2AYeg(sArr, i);
                UShortArray.m9406set01HTLdE(sArr, i, UShortArray.m9401getMh2AYeg(sArr, i2));
                UShortArray.m9406set01HTLdE(sArr, i2, m9401getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    private static final void m9519quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m9515partitionAa5vz7o = m9515partitionAa5vz7o(sArr, i, i2);
        int i3 = m9515partitionAa5vz7o - 1;
        if (i < i3) {
            m9519quickSortAa5vz7o(sArr, i, i3);
        }
        if (m9515partitionAa5vz7o < i2) {
            m9519quickSortAa5vz7o(sArr, m9515partitionAa5vz7o, i2);
        }
    }

    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    private static final int m9516partitionoBK06Vg(int[] iArr, int i, int i2) {
        int m9219getpVg5ArA = UIntArray.m9219getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedUtils.uintCompare(UIntArray.m9219getpVg5ArA(iArr, i), m9219getpVg5ArA) < 0) {
                i++;
            }
            while (UnsignedUtils.uintCompare(UIntArray.m9219getpVg5ArA(iArr, i2), m9219getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m9219getpVg5ArA2 = UIntArray.m9219getpVg5ArA(iArr, i);
                UIntArray.m9224setVXSXFK8(iArr, i, UIntArray.m9219getpVg5ArA(iArr, i2));
                UIntArray.m9224setVXSXFK8(iArr, i2, m9219getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    private static final void m9520quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m9516partitionoBK06Vg = m9516partitionoBK06Vg(iArr, i, i2);
        int i3 = m9516partitionoBK06Vg - 1;
        if (i < i3) {
            m9520quickSortoBK06Vg(iArr, i, i3);
        }
        if (m9516partitionoBK06Vg < i2) {
            m9520quickSortoBK06Vg(iArr, m9516partitionoBK06Vg, i2);
        }
    }

    /* renamed from: partition--nroSd4  reason: not valid java name */
    private static final int m9513partitionnroSd4(long[] jArr, int i, int i2) {
        long m9297getsVKNKU = ULongArray.m9297getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedUtils.ulongCompare(ULongArray.m9297getsVKNKU(jArr, i), m9297getsVKNKU) < 0) {
                i++;
            }
            while (UnsignedUtils.ulongCompare(ULongArray.m9297getsVKNKU(jArr, i2), m9297getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m9297getsVKNKU2 = ULongArray.m9297getsVKNKU(jArr, i);
                ULongArray.m9302setk8EXiF4(jArr, i, ULongArray.m9297getsVKNKU(jArr, i2));
                ULongArray.m9302setk8EXiF4(jArr, i2, m9297getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    private static final void m9517quickSortnroSd4(long[] jArr, int i, int i2) {
        int m9513partitionnroSd4 = m9513partitionnroSd4(jArr, i, i2);
        int i3 = m9513partitionnroSd4 - 1;
        if (i < i3) {
            m9517quickSortnroSd4(jArr, i, i3);
        }
        if (m9513partitionnroSd4 < i2) {
            m9517quickSortnroSd4(jArr, m9513partitionnroSd4, i2);
        }
    }

    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m9522sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m9518quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m9523sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m9519quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m9524sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m9520quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m9521sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m9517quickSortnroSd4(array, i, i2 - 1);
    }
}
