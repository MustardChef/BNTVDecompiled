package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadPropertyConstant$1 */
/* loaded from: classes4.dex */
final class C5134xb4efac6 extends Lambda implements Function2<AbstractBinaryClassAnnotationAndConstantLoader.Storage<? extends A, ? extends C>, MemberSignature, C> {
    public static final C5134xb4efac6 INSTANCE = new C5134xb4efac6();

    C5134xb4efac6() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, MemberSignature memberSignature) {
        return invoke((AbstractBinaryClassAnnotationAndConstantLoader.Storage<? extends A, ? extends Object>) obj, memberSignature);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [C, java.lang.Object] */
    public final C invoke(AbstractBinaryClassAnnotationAndConstantLoader.Storage<? extends A, ? extends C> loadConstantFromProperty, MemberSignature it) {
        Intrinsics.checkNotNullParameter(loadConstantFromProperty, "$this$loadConstantFromProperty");
        Intrinsics.checkNotNullParameter(it, "it");
        return loadConstantFromProperty.getPropertyConstants().get(it);
    }
}
