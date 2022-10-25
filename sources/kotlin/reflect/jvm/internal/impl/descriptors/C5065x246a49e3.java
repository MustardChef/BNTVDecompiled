package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: typeParameterUtils.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2 */
/* loaded from: classes4.dex */
final class C5065x246a49e3 extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
    public static final C5065x246a49e3 INSTANCE = new C5065x246a49e3();

    C5065x246a49e3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(!(it instanceof ConstructorDescriptor));
    }
}
