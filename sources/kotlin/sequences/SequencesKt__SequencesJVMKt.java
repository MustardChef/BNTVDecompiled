package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Enumeration;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SequencesJVM.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b¨\u0006\u0004"}, m107d2 = {"asSequence", "Lkotlin/sequences/Sequence;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Enumeration;", "kotlin-stdlib"}, m106k = 5, m105mv = {1, 6, 0}, m103xi = 49, m102xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes4.dex */
public class SequencesKt__SequencesJVMKt extends SequencesKt__SequenceBuilderKt {
    private static final <T> Sequence<T> asSequence(Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        return SequencesKt.asSequence(CollectionsKt.iterator(enumeration));
    }
}