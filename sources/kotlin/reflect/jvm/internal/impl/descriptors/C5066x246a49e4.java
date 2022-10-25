package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* compiled from: typeParameterUtils.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3 */
/* loaded from: classes4.dex */
final class C5066x246a49e4 extends Lambda implements Function1<DeclarationDescriptor, Sequence<? extends TypeParameterDescriptor>> {
    public static final C5066x246a49e4 INSTANCE = new C5066x246a49e4();

    C5066x246a49e4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Sequence<TypeParameterDescriptor> invoke(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        List<TypeParameterDescriptor> typeParameters = ((CallableDescriptor) it).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "it as CallableDescriptor).typeParameters");
        return CollectionsKt.asSequence(typeParameters);
    }
}
