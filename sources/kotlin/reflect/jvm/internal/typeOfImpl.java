package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtils;

@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\bH\u0002¨\u0006\t"}, m107d2 = {"createMutableCollectionKType", "Lkotlin/reflect/KType;", "type", "createNothingType", "createPlatformKType", "lowerBound", "upperBound", "readOnlyToMutable", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: kotlin.reflect.jvm.internal.TypeOfImplKt */
/* loaded from: classes4.dex */
public final class typeOfImpl {
    public static final KType createPlatformKType(KType lowerBound, KType upperBound) {
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        return new KTypeImpl(KotlinTypeFactory.flexibleType((SimpleType) ((KTypeImpl) lowerBound).getType(), (SimpleType) ((KTypeImpl) upperBound).getType()), null, 2, null);
    }

    public static final KType createMutableCollectionKType(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KotlinType type2 = ((KTypeImpl) type).getType();
        if (!(type2 instanceof SimpleType)) {
            throw new IllegalArgumentException(("Non-simple type cannot be a mutable collection type: " + type).toString());
        }
        ClassifierDescriptor declarationDescriptor = type2.getConstructor().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor == null) {
            throw new IllegalArgumentException("Non-class type cannot be a mutable collection type: " + type);
        }
        SimpleType simpleType = (SimpleType) type2;
        TypeConstructor typeConstructor = readOnlyToMutable(classDescriptor).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "classifier.readOnlyToMutable().typeConstructor");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default(simpleType, (Annotations) null, typeConstructor, (List) null, false, 26, (Object) null), null, 2, null);
    }

    private static final ClassDescriptor readOnlyToMutable(ClassDescriptor classDescriptor) {
        ClassDescriptor classDescriptor2 = classDescriptor;
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtils.getFqNameUnsafe(classDescriptor2));
        if (readOnlyToMutable == null) {
            throw new IllegalArgumentException("Not a readonly collection: " + classDescriptor);
        }
        ClassDescriptor builtInClassByFqName = DescriptorUtils.getBuiltIns(classDescriptor2).getBuiltInClassByFqName(readOnlyToMutable);
        Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.getBuiltInClassByFqName(fqName)");
        return builtInClassByFqName;
    }

    public static final KType createNothingType(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KotlinType type2 = ((KTypeImpl) type).getType();
        if (!(type2 instanceof SimpleType)) {
            throw new IllegalArgumentException(("Non-simple type cannot be a Nothing type: " + type).toString());
        }
        SimpleType simpleType = (SimpleType) type2;
        TypeConstructor typeConstructor = TypeUtils.getBuiltIns(type2).getNothing().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "kotlinType.builtIns.nothing.typeConstructor");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default(simpleType, (Annotations) null, typeConstructor, (List) null, false, 26, (Object) null), null, 2, null);
    }
}
