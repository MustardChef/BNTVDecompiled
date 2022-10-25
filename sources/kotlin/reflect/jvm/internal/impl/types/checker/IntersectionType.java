package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt */
/* loaded from: classes4.dex */
public final class IntersectionType {
    public static final UnwrappedType intersectTypes(List<? extends UnwrappedType> types) {
        SimpleType lowerBound;
        Intrinsics.checkNotNullParameter(types, "types");
        int size = types.size();
        if (size != 0) {
            if (size == 1) {
                return (UnwrappedType) CollectionsKt.single((List<? extends Object>) types);
            }
            List<? extends UnwrappedType> list = types;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            boolean z = false;
            boolean z2 = false;
            for (UnwrappedType unwrappedType : list) {
                z = z || KotlinTypeKt.isError(unwrappedType);
                if (unwrappedType instanceof SimpleType) {
                    lowerBound = (SimpleType) unwrappedType;
                } else if (unwrappedType instanceof FlexibleType) {
                    if (DynamicTypesKt.isDynamic(unwrappedType)) {
                        return unwrappedType;
                    }
                    lowerBound = ((FlexibleType) unwrappedType).getLowerBound();
                    z2 = true;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList.add(lowerBound);
            }
            ArrayList arrayList2 = arrayList;
            if (z) {
                SimpleType createErrorType = ErrorUtils.createErrorType("Intersection of error types: " + types);
                Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(\"Interse… of error types: $types\")");
                return createErrorType;
            } else if (!z2) {
                return TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList2);
            } else {
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (UnwrappedType unwrappedType2 : list) {
                    arrayList3.add(FlexibleTypesKt.upperIfFlexible(unwrappedType2));
                }
                return KotlinTypeFactory.flexibleType(TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList2), TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList3));
            }
        }
        throw new IllegalStateException("Expected some types".toString());
    }
}
