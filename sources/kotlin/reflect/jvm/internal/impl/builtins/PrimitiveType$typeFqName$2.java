package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PrimitiveType.kt */
/* loaded from: classes4.dex */
final class PrimitiveType$typeFqName$2 extends Lambda implements Functions<FqName> {
    final /* synthetic */ PrimitiveType this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveType$typeFqName$2(PrimitiveType primitiveType) {
        super(0);
        this.this$0 = primitiveType;
    }

    @Override // kotlin.jvm.functions.Functions
    public final FqName invoke() {
        FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(this.this$0.getTypeName());
        Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
        return child;
    }
}
