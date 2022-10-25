package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.fasterxml.jackson.core.JsonPointer;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.functionTypes;
import kotlin.reflect.jvm.internal.impl.builtins.suspendFunctionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.inlineClassesUtils;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.expandedTypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtils;
import kotlin.reflect.jvm.internal.impl.utils.functions;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.DescriptorBasedTypeSignatureMappingKt */
/* loaded from: classes4.dex */
public final class descriptorBasedTypeSignatureMapping {
    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, typeSignatureMapping typesignaturemapping, Function3 function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = functions.getDO_NOTHING_3();
        }
        return mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, typesignaturemapping, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10, types: [T, java.lang.Object] */
    public static final <T> T mapType(KotlinType kotlinType, JvmTypeFactory<T> factory, TypeMappingMode mode, TypeMappingConfiguration<? extends T> typeMappingConfiguration, typeSignatureMapping<T> typesignaturemapping, Function3<? super KotlinType, ? super T, ? super TypeMappingMode, Unit> writeGenericType) {
        Object obj;
        KotlinType kotlinType2;
        Object mapType;
        Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        Intrinsics.checkNotNullParameter(writeGenericType, "writeGenericType");
        KotlinType preprocessType = typeMappingConfiguration.preprocessType(kotlinType);
        if (preprocessType != null) {
            return (T) mapType(preprocessType, factory, mode, typeMappingConfiguration, typesignaturemapping, writeGenericType);
        }
        if (functionTypes.isSuspendFunctionType(kotlinType)) {
            return (T) mapType(suspendFunctionTypes.transformSuspendFunctionToRuntimeFunctionType(kotlinType), factory, mode, typeMappingConfiguration, typesignaturemapping, writeGenericType);
        }
        KotlinType kotlinType3 = kotlinType;
        Object mapBuiltInType = TypeSignatureMappingKt.mapBuiltInType(SimpleClassicTypeSystemContext.INSTANCE, kotlinType3, factory, mode);
        if (mapBuiltInType != null) {
            ?? r9 = (Object) TypeSignatureMappingKt.boxTypeIfNeeded(factory, mapBuiltInType, mode.getNeedPrimitiveBoxing());
            writeGenericType.invoke(kotlinType, r9, mode);
            return r9;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) constructor;
            KotlinType alternativeType = intersectionTypeConstructor.getAlternativeType();
            if (alternativeType == null) {
                alternativeType = typeMappingConfiguration.commonSupertype(intersectionTypeConstructor.mo10322getSupertypes());
            }
            return (T) mapType(TypeUtils.replaceArgumentsWithStarProjections(alternativeType), factory, mode, typeMappingConfiguration, typesignaturemapping, writeGenericType);
        }
        ClassifierDescriptor declarationDescriptor = constructor.getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            throw new UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
        }
        ClassifierDescriptor classifierDescriptor = declarationDescriptor;
        if (ErrorUtils.isError(classifierDescriptor)) {
            T t = (T) factory.createObjectType("error/NonExistentClass");
            typeMappingConfiguration.processErrorType(kotlinType, (ClassDescriptor) declarationDescriptor);
            if (typesignaturemapping != 0) {
                typesignaturemapping.writeClass(t);
            }
            return t;
        }
        boolean z = declarationDescriptor instanceof ClassDescriptor;
        if (z && KotlinBuiltIns.isArray(kotlinType)) {
            if (kotlinType.getArguments().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            TypeProjection typeProjection = kotlinType.getArguments().get(0);
            KotlinType type = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "memberProjection.type");
            if (typeProjection.getProjectionKind() == Variance.IN_VARIANCE) {
                mapType = factory.createObjectType("java/lang/Object");
                if (typesignaturemapping != 0) {
                    typesignaturemapping.writeArrayType();
                    typesignaturemapping.writeClass(mapType);
                    typesignaturemapping.writeArrayEnd();
                }
            } else {
                if (typesignaturemapping != 0) {
                    typesignaturemapping.writeArrayType();
                }
                Variance projectionKind = typeProjection.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "memberProjection.projectionKind");
                mapType = mapType(type, factory, mode.toGenericArgumentMode(projectionKind, true), typeMappingConfiguration, typesignaturemapping, writeGenericType);
                if (typesignaturemapping != 0) {
                    typesignaturemapping.writeArrayEnd();
                }
            }
            return (T) factory.createFromString('[' + factory.toString(mapType));
        } else if (z) {
            if (inlineClassesUtils.isInlineClass(classifierDescriptor) && !mode.getNeedInlineClassWrapping() && (kotlinType2 = (KotlinType) expandedTypeUtils.computeExpandedTypeForInlineClass(SimpleClassicTypeSystemContext.INSTANCE, kotlinType3)) != null) {
                return (T) mapType(kotlinType2, factory, mode.wrapInlineClassesMode(), typeMappingConfiguration, typesignaturemapping, writeGenericType);
            }
            if (mode.isForAnnotationParameter() && KotlinBuiltIns.isKClass((ClassDescriptor) declarationDescriptor)) {
                obj = (Object) factory.getJavaLangClassType();
            } else {
                ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                ClassDescriptor original = classDescriptor.getOriginal();
                Intrinsics.checkNotNullExpressionValue(original, "descriptor.original");
                T predefinedTypeForClass = typeMappingConfiguration.getPredefinedTypeForClass(original);
                if (predefinedTypeForClass == null) {
                    if (classDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
                        classDescriptor = (ClassDescriptor) classDescriptor.getContainingDeclaration();
                    }
                    ClassDescriptor original2 = classDescriptor.getOriginal();
                    Intrinsics.checkNotNullExpressionValue(original2, "enumClassIfEnumEntry.original");
                    obj = (Object) factory.createObjectType(computeInternalName(original2, typeMappingConfiguration));
                } else {
                    obj = (Object) predefinedTypeForClass;
                }
            }
            writeGenericType.invoke(kotlinType, obj, mode);
            return (T) obj;
        } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
            T t2 = (T) mapType(TypeUtils.getRepresentativeUpperBound((TypeParameterDescriptor) declarationDescriptor), factory, mode, typeMappingConfiguration, null, functions.getDO_NOTHING_3());
            if (typesignaturemapping != 0) {
                Name name = declarationDescriptor.getName();
                Intrinsics.checkNotNullExpressionValue(name, "descriptor.getName()");
                typesignaturemapping.writeTypeVariable(name, t2);
            }
            return t2;
        } else if ((declarationDescriptor instanceof TypeAliasDescriptor) && mode.getMapTypeAliases()) {
            return (T) mapType(((TypeAliasDescriptor) declarationDescriptor).getExpandedType(), factory, mode, typeMappingConfiguration, typesignaturemapping, writeGenericType);
        } else {
            throw new UnsupportedOperationException("Unknown type " + kotlinType);
        }
    }

    public static final boolean hasVoidReturnType(CallableDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType returnType = descriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        if (KotlinBuiltIns.isUnit(returnType)) {
            KotlinType returnType2 = descriptor.getReturnType();
            Intrinsics.checkNotNull(returnType2);
            if (!kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(returnType2) && !(descriptor instanceof PropertyGetterDescriptor)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return computeInternalName(classDescriptor, typeMappingConfiguration);
    }

    public static final String computeInternalName(ClassDescriptor klass, TypeMappingConfiguration<?> typeMappingConfiguration) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(klass);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        DeclarationDescriptor containingDeclaration = klass.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "klass.containingDeclaration");
        String identifier = SpecialNames.safeIdentifier(klass.getName()).getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "safeIdentifier(klass.name).identifier");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
            if (fqName.isRoot()) {
                return identifier;
            }
            StringBuilder sb = new StringBuilder();
            String asString = fqName.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "fqName.asString()");
            sb.append(StringsKt.replace$default(asString, '.', (char) JsonPointer.SEPARATOR, false, 4, (Object) null));
            sb.append(JsonPointer.SEPARATOR);
            sb.append(identifier);
            return sb.toString();
        }
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + klass);
        }
        String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor);
        if (predefinedInternalNameForClass == null) {
            predefinedInternalNameForClass = computeInternalName(classDescriptor, typeMappingConfiguration);
        }
        return predefinedInternalNameForClass + Typography.dollar + identifier;
    }
}
