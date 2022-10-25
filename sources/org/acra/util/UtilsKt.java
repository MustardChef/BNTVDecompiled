package org.acra.util;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utils.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u0002H\u0003\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\b0\u0007H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, m107d2 = {"mapNotNullToSparseArray", "Landroid/util/SparseArray;", "R", ExifInterface.GPS_DIRECTION_TRUE, "", "", "transform", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "acra-core_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class UtilsKt {
    public static final <T, R> SparseArray<R> mapNotNullToSparseArray(Iterable<? extends T> iterable, Function1<? super T, ? extends Tuples<Integer, ? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        SparseArray<R> sparseArray = new SparseArray<>();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Tuples<Integer, ? extends R> invoke = transform.invoke((T) it.next());
            if (invoke != null) {
                sparseArray.put(invoke.component1().intValue(), invoke.component2());
            }
        }
        return sparseArray;
    }
}
