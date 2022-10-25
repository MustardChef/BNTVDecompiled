package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntegerLiteralTypeConstructor.kt */
/* loaded from: classes4.dex */
public final class IntegerLiteralTypeConstructor$supertypes$2 extends Lambda implements Functions<List<SimpleType>> {
    final /* synthetic */ IntegerLiteralTypeConstructor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntegerLiteralTypeConstructor$supertypes$2(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        super(0);
        this.this$0 = integerLiteralTypeConstructor;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<SimpleType> invoke() {
        SimpleType simpleType;
        boolean isContainsOnlyUnsignedTypes;
        SimpleType defaultType = this.this$0.getBuiltIns().getComparable().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "builtIns.comparable.defaultType");
        Variance variance = Variance.IN_VARIANCE;
        simpleType = this.this$0.type;
        List<SimpleType> mutableListOf = CollectionsKt.mutableListOf(TypeSubstitutionKt.replace$default(defaultType, CollectionsKt.listOf(new TypeProjectionImpl(variance, simpleType)), null, 2, null));
        isContainsOnlyUnsignedTypes = this.this$0.isContainsOnlyUnsignedTypes();
        if (!isContainsOnlyUnsignedTypes) {
            mutableListOf.add(this.this$0.getBuiltIns().getNumberType());
        }
        return mutableListOf;
    }
}
