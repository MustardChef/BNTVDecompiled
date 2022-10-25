package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ConstantValueFactory.kt */
/* loaded from: classes4.dex */
final class ConstantValueFactory$createArrayValue$1 extends Lambda implements Function1<ModuleDescriptor, KotlinType> {
    final /* synthetic */ KotlinType $type;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstantValueFactory$createArrayValue$1(KotlinType kotlinType) {
        super(1);
        this.$type = kotlinType;
    }

    @Override // kotlin.jvm.functions.Function1
    public final KotlinType invoke(ModuleDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this.$type;
    }
}
