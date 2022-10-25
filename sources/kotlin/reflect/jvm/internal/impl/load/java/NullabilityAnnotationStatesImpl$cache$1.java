package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtil;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
/* loaded from: classes4.dex */
final class NullabilityAnnotationStatesImpl$cache$1 extends Lambda implements Function1<FqName, T> {
    final /* synthetic */ NullabilityAnnotationStatesImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NullabilityAnnotationStatesImpl$cache$1(NullabilityAnnotationStatesImpl<T> nullabilityAnnotationStatesImpl) {
        super(1);
        this.this$0 = nullabilityAnnotationStatesImpl;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final T invoke(FqName it) {
        Intrinsics.checkNotNullExpressionValue(it, "it");
        return FqNamesUtil.findValueForMostSpecificFqname(it, this.this$0.getStates());
    }
}
