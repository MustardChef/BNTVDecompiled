package com.fasterxml.jackson.module.kotlin;

import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001a\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0004ø\u0001\u0000\u001a\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0007ø\u0001\u0000\u001a\u000f\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0001ø\u0001\u0000\u001a\u000f\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\fø\u0001\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m107d2 = {"uLongMaxValue", "Ljava/math/BigInteger;", "asUByte", "Lkotlin/UByte;", "", "asUInt", "Lkotlin/UInt;", "", "asULong", "Lkotlin/ULong;", "asUShort", "Lkotlin/UShort;", "", "jackson-module-kotlin"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: com.fasterxml.jackson.module.kotlin.UnsignedNumbersKt */
/* loaded from: classes2.dex */
public final class UnsignedNumbers {
    private static final BigInteger uLongMaxValue;

    public static final UByte asUByte(short s) {
        if (s < 0 || s > ((short) (((short) (-1)) & 255))) {
            return null;
        }
        return UByte.m9078boximpl(UByte.m9084constructorimpl((byte) s));
    }

    public static final UShort asUShort(int i) {
        if (i < 0 || i > 65535) {
            return null;
        }
        return UShort.m9338boximpl(UShort.m9344constructorimpl((short) i));
    }

    public static final UInt asUInt(long j) {
        if (j < 0 || j > ((-1) & 4294967295L)) {
            return null;
        }
        return UInt.m9154boximpl(UInt.m9160constructorimpl((int) j));
    }

    static {
        String unsignedString;
        unsignedString = C$r8$backportedMethods$utility$Long$2$toUnsignedStringWithRadix.toUnsignedString(-1L, 10);
        uLongMaxValue = new BigInteger(unsignedString);
    }

    public static final ULong asULong(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        if (bigInteger.compareTo(BigInteger.ZERO) < 0 || bigInteger.compareTo(uLongMaxValue) > 0) {
            return null;
        }
        return ULong.m9232boximpl(ULong.m9238constructorimpl(bigInteger.longValue()));
    }
}
