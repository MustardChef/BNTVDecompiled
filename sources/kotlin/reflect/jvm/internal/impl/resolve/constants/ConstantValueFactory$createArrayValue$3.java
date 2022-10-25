package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConstantValueFactory.kt */
/* loaded from: classes4.dex */
public final class ConstantValueFactory$createArrayValue$3 extends Lambda implements Function1<ModuleDescriptor, KotlinType> {
    final /* synthetic */ PrimitiveType $componentType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstantValueFactory$createArrayValue$3(PrimitiveType primitiveType) {
        super(1);
        this.$componentType = primitiveType;
    }

    @Override // kotlin.jvm.functions.Function1
    public final KotlinType invoke(ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType primitiveArrayKotlinType = module.getBuiltIns().getPrimitiveArrayKotlinType(this.$componentType);
        Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "module.builtIns.getPrimi…KotlinType(componentType)");
        return primitiveArrayKotlinType;
    }
}
