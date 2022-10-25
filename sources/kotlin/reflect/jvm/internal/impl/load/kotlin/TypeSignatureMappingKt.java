package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.typeEnhancementUtils;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;

/* compiled from: typeSignatureMapping.kt */
/* loaded from: classes4.dex */
public final class TypeSignatureMappingKt {
    public static final <T> T boxTypeIfNeeded(JvmTypeFactory<T> jvmTypeFactory, T possiblyPrimitiveType, boolean z) {
        Intrinsics.checkNotNullParameter(jvmTypeFactory, "<this>");
        Intrinsics.checkNotNullParameter(possiblyPrimitiveType, "possiblyPrimitiveType");
        return z ? jvmTypeFactory.boxType(possiblyPrimitiveType) : possiblyPrimitiveType;
    }

    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker type, JvmTypeFactory<T> typeFactory, TypeMappingMode mode) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(typeFactory, "typeFactory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(type);
        if (typeSystemCommonBackendContext.isClassTypeConstructor(typeConstructor)) {
            PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(typeConstructor);
            boolean z = true;
            if (primitiveType != null) {
                T createPrimitiveType = typeFactory.createPrimitiveType(primitiveType);
                if (!typeSystemCommonBackendContext.isNullableType(type) && !typeEnhancementUtils.hasEnhancedNullability(typeSystemCommonBackendContext, type)) {
                    z = false;
                }
                return (T) boxTypeIfNeeded(typeFactory, createPrimitiveType, z);
            }
            PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(typeConstructor);
            if (primitiveArrayType != null) {
                return typeFactory.createFromString('[' + JvmPrimitiveType.get(primitiveArrayType).getDesc());
            }
            if (typeSystemCommonBackendContext.isUnderKotlinPackage(typeConstructor)) {
                FqNameUnsafe classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(typeConstructor);
                ClassId mapKotlinToJava = classFqNameUnsafe != null ? JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(classFqNameUnsafe) : null;
                if (mapKotlinToJava != null) {
                    if (!mode.getKotlinCollectionsToJavaCollections()) {
                        List<JavaToKotlinClassMap.PlatformMutabilityMapping> mutabilityMappings = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
                        if (!(mutabilityMappings instanceof Collection) || !mutabilityMappings.isEmpty()) {
                            for (JavaToKotlinClassMap.PlatformMutabilityMapping platformMutabilityMapping : mutabilityMappings) {
                                if (Intrinsics.areEqual(platformMutabilityMapping.getJavaClass(), mapKotlinToJava)) {
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            return null;
                        }
                    }
                    String internalName = JvmClassName.byClassId(mapKotlinToJava).getInternalName();
                    Intrinsics.checkNotNullExpressionValue(internalName, "byClassId(classId).internalName");
                    return typeFactory.createObjectType(internalName);
                }
            }
            return null;
        }
        return null;
    }
}
