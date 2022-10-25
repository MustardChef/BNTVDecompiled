package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: typeParameterUtils.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1 */
/* loaded from: classes4.dex */
final class C5064x246a49e2 extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
    public static final C5064x246a49e2 INSTANCE = new C5064x246a49e2();

    C5064x246a49e2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(it instanceof CallableDescriptor);
    }
}
