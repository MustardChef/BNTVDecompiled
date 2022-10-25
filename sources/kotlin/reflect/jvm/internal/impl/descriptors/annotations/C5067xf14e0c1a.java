package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: annotationUtil.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1 */
/* loaded from: classes4.dex */
final class C5067xf14e0c1a extends Lambda implements Function1<ModuleDescriptor, KotlinType> {
    final /* synthetic */ KotlinBuiltIns $this_createDeprecatedAnnotation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5067xf14e0c1a(KotlinBuiltIns kotlinBuiltIns) {
        super(1);
        this.$this_createDeprecatedAnnotation = kotlinBuiltIns;
    }

    @Override // kotlin.jvm.functions.Function1
    public final KotlinType invoke(ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType arrayType = module.getBuiltIns().getArrayType(Variance.INVARIANT, this.$this_createDeprecatedAnnotation.getStringType());
        Intrinsics.checkNotNullExpressionValue(arrayType, "module.builtIns.getArray…ce.INVARIANT, stringType)");
        return arrayType;
    }
}
