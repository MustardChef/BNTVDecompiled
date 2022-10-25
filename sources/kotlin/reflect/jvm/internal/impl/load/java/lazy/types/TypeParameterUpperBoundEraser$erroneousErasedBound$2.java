package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: TypeParameterUpperBoundEraser.kt */
/* loaded from: classes4.dex */
final class TypeParameterUpperBoundEraser$erroneousErasedBound$2 extends Lambda implements Functions<SimpleType> {
    final /* synthetic */ TypeParameterUpperBoundEraser this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeParameterUpperBoundEraser$erroneousErasedBound$2(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        super(0);
        this.this$0 = typeParameterUpperBoundEraser;
    }

    @Override // kotlin.jvm.functions.Functions
    public final SimpleType invoke() {
        return ErrorUtils.createErrorType("Can't compute erased upper bound of type parameter `" + this.this$0 + '`');
    }
}
