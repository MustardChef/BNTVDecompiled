package kotlin.internal;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedUtils;

@Metadata(m108d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m107d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", TtmlNode.START, TtmlNode.END, "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: kotlin.internal.UProgressionUtilKt */
/* loaded from: classes4.dex */
public final class UProgressionUtil {
    /* renamed from: differenceModulo-WZ9TVnA  reason: not valid java name */
    private static final int m10254differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int m9414uintRemainderJ1ME1BU = UnsignedUtils.m9414uintRemainderJ1ME1BU(i, i3);
        int m9414uintRemainderJ1ME1BU2 = UnsignedUtils.m9414uintRemainderJ1ME1BU(i2, i3);
        int uintCompare = UnsignedUtils.uintCompare(m9414uintRemainderJ1ME1BU, m9414uintRemainderJ1ME1BU2);
        int m9160constructorimpl = UInt.m9160constructorimpl(m9414uintRemainderJ1ME1BU - m9414uintRemainderJ1ME1BU2);
        return uintCompare >= 0 ? m9160constructorimpl : UInt.m9160constructorimpl(m9160constructorimpl + i3);
    }

    /* renamed from: differenceModulo-sambcqE  reason: not valid java name */
    private static final long m10255differenceModulosambcqE(long j, long j2, long j3) {
        long m9416ulongRemaindereb3DHEI = UnsignedUtils.m9416ulongRemaindereb3DHEI(j, j3);
        long m9416ulongRemaindereb3DHEI2 = UnsignedUtils.m9416ulongRemaindereb3DHEI(j2, j3);
        int ulongCompare = UnsignedUtils.ulongCompare(m9416ulongRemaindereb3DHEI, m9416ulongRemaindereb3DHEI2);
        long m9238constructorimpl = ULong.m9238constructorimpl(m9416ulongRemaindereb3DHEI - m9416ulongRemaindereb3DHEI2);
        return ulongCompare >= 0 ? m9238constructorimpl : ULong.m9238constructorimpl(m9238constructorimpl + j3);
    }

    /* renamed from: getProgressionLastElement-Nkh28Cs  reason: not valid java name */
    public static final int m10257getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            return UnsignedUtils.uintCompare(i, i2) >= 0 ? i2 : UInt.m9160constructorimpl(i2 - m10254differenceModuloWZ9TVnA(i2, i, UInt.m9160constructorimpl(i3)));
        } else if (i3 < 0) {
            return UnsignedUtils.uintCompare(i, i2) <= 0 ? i2 : UInt.m9160constructorimpl(i2 + m10254differenceModuloWZ9TVnA(i, i2, UInt.m9160constructorimpl(-i3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    /* renamed from: getProgressionLastElement-7ftBX0g  reason: not valid java name */
    public static final long m10256getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i > 0) {
            return UnsignedUtils.ulongCompare(j, j2) >= 0 ? j2 : ULong.m9238constructorimpl(j2 - m10255differenceModulosambcqE(j2, j, ULong.m9238constructorimpl(j3)));
        } else if (i < 0) {
            return UnsignedUtils.ulongCompare(j, j2) <= 0 ? j2 : ULong.m9238constructorimpl(j2 + m10255differenceModulosambcqE(j, j2, ULong.m9238constructorimpl(-j3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
