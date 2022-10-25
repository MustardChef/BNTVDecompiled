package kotlin;

import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UIntArray.kt */
@Metadata(m108d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0007\u001a\u001f\u0010\b\u001a\u00020\u00012\n\u0010\t\u001a\u00020\u0001\"\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\f"}, m107d2 = {"UIntArray", "Lkotlin/UIntArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/UInt;", "(ILkotlin/jvm/functions/Function1;)[I", "uintArrayOf", MessengerShareContentUtility.ELEMENTS, "uintArrayOf--ajY-9A", "([I)[I", "kotlin-stdlib"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class UIntArrayKt {
    /* renamed from: uintArrayOf--ajY-9A  reason: not valid java name */
    private static final int[] m9230uintArrayOfajY9A(int... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements;
    }

    private static final int[] UIntArray(int i, Function1<? super Integer, UInt> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = init.invoke(Integer.valueOf(i2)).m9211unboximpl();
        }
        return UIntArray.m9214constructorimpl(iArr);
    }
}
