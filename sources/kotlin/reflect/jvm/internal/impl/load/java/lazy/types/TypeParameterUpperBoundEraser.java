package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtils;

/* compiled from: TypeParameterUpperBoundEraser.kt */
/* loaded from: classes4.dex */
public final class TypeParameterUpperBoundEraser {
    private final Lazy erroneousErasedBound$delegate;
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;
    private final RawType rawSubstitution;
    private final LockBasedStorageManager storage;

    public TypeParameterUpperBoundEraser() {
        this(null, 1, null);
    }

    public TypeParameterUpperBoundEraser(RawType rawType) {
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Type parameter upper bound erasion results");
        this.storage = lockBasedStorageManager;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new TypeParameterUpperBoundEraser$erroneousErasedBound$2(this));
        this.rawSubstitution = rawType == null ? new RawType(this) : rawType;
        MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> createMemoizedFunction = lockBasedStorageManager.createMemoizedFunction(new TypeParameterUpperBoundEraser$getErasedUpperBound$1(this));
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunction, "storage.createMemoizedFu… isRaw, typeAttr) }\n    }");
        this.getErasedUpperBound = createMemoizedFunction;
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(RawType rawType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : rawType);
    }

    private final SimpleType getErroneousErasedBound() {
        return (SimpleType) this.erroneousErasedBound$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeParameterUpperBoundEraser.kt */
    /* loaded from: classes4.dex */
    public static final class DataToEraseUpperBound {
        private final boolean isRaw;
        private final JavaTypeAttributes typeAttr;
        private final TypeParameterDescriptor typeParameter;

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", isRaw=" + this.isRaw + ", typeAttr=" + this.typeAttr + ')';
        }

        public DataToEraseUpperBound(TypeParameterDescriptor typeParameter, boolean z, JavaTypeAttributes typeAttr) {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
            this.typeParameter = typeParameter;
            this.isRaw = z;
            this.typeAttr = typeAttr;
        }

        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public final boolean isRaw() {
            return this.isRaw;
        }

        public final JavaTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof DataToEraseUpperBound) {
                DataToEraseUpperBound dataToEraseUpperBound = (DataToEraseUpperBound) obj;
                return Intrinsics.areEqual(dataToEraseUpperBound.typeParameter, this.typeParameter) && dataToEraseUpperBound.isRaw == this.isRaw && dataToEraseUpperBound.typeAttr.getFlexibility() == this.typeAttr.getFlexibility() && dataToEraseUpperBound.typeAttr.getHowThisTypeIsUsed() == this.typeAttr.getHowThisTypeIsUsed() && dataToEraseUpperBound.typeAttr.isForAnnotationParameter() == this.typeAttr.isForAnnotationParameter() && Intrinsics.areEqual(dataToEraseUpperBound.typeAttr.getDefaultType(), this.typeAttr.getDefaultType());
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.typeParameter.hashCode();
            int i = hashCode + (hashCode * 31) + (this.isRaw ? 1 : 0);
            int hashCode2 = i + (i * 31) + this.typeAttr.getFlexibility().hashCode();
            int hashCode3 = hashCode2 + (hashCode2 * 31) + this.typeAttr.getHowThisTypeIsUsed().hashCode();
            int i2 = hashCode3 + (hashCode3 * 31) + (this.typeAttr.isForAnnotationParameter() ? 1 : 0);
            int i3 = i2 * 31;
            SimpleType defaultType = this.typeAttr.getDefaultType();
            return i2 + i3 + (defaultType != null ? defaultType.hashCode() : 0);
        }
    }

    public final KotlinType getErasedUpperBound$descriptors_jvm(TypeParameterDescriptor typeParameter, boolean z, JavaTypeAttributes typeAttr) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
        return this.getErasedUpperBound.invoke(new DataToEraseUpperBound(typeParameter, z, typeAttr));
    }

    private final KotlinType getDefaultType(JavaTypeAttributes javaTypeAttributes) {
        KotlinType replaceArgumentsWithStarProjections;
        SimpleType defaultType = javaTypeAttributes.getDefaultType();
        if (defaultType == null || (replaceArgumentsWithStarProjections = TypeUtils.replaceArgumentsWithStarProjections(defaultType)) == null) {
            SimpleType erroneousErasedBound = getErroneousErasedBound();
            Intrinsics.checkNotNullExpressionValue(erroneousErasedBound, "erroneousErasedBound");
            return erroneousErasedBound;
        }
        return replaceArgumentsWithStarProjections;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor typeParameterDescriptor, boolean z, JavaTypeAttributes javaTypeAttributes) {
        TypeProjection computeProjection;
        Set<TypeParameterDescriptor> visitedTypeParameters = javaTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor.getOriginal())) {
            return getDefaultType(javaTypeAttributes);
        }
        SimpleType defaultType = typeParameterDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
        Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds = TypeUtils.extractTypeParametersFromUpperBounds(defaultType, visitedTypeParameters);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(extractTypeParametersFromUpperBounds, 10)), 16));
        for (TypeParameterDescriptor typeParameterDescriptor2 : extractTypeParametersFromUpperBounds) {
            if (visitedTypeParameters == null || !visitedTypeParameters.contains(typeParameterDescriptor2)) {
                RawType rawType = this.rawSubstitution;
                JavaTypeAttributes withFlexibility = z ? javaTypeAttributes : javaTypeAttributes.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
                KotlinType erasedUpperBound$descriptors_jvm = getErasedUpperBound$descriptors_jvm(typeParameterDescriptor2, z, javaTypeAttributes.withNewVisitedTypeParameter(typeParameterDescriptor));
                Intrinsics.checkNotNullExpressionValue(erasedUpperBound$descriptors_jvm, "getErasedUpperBound(it, …Parameter(typeParameter))");
                computeProjection = rawType.computeProjection(typeParameterDescriptor2, withFlexibility, erasedUpperBound$descriptors_jvm);
            } else {
                computeProjection = JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor2, javaTypeAttributes);
            }
            Tuples m100to = TuplesKt.m100to(typeParameterDescriptor2.getTypeConstructor(), computeProjection);
            linkedHashMap.put(m100to.getFirst(), m100to.getSecond());
        }
        TypeSubstitutor create = TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, linkedHashMap, false, 2, null));
        Intrinsics.checkNotNullExpressionValue(create, "create(TypeConstructorSu…rsMap(erasedUpperBounds))");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
        KotlinType firstUpperBound = (KotlinType) CollectionsKt.first((List<? extends Object>) upperBounds);
        if (firstUpperBound.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
            Intrinsics.checkNotNullExpressionValue(firstUpperBound, "firstUpperBound");
            return TypeUtils.replaceArgumentsWithStarProjectionOrMapped(firstUpperBound, create, linkedHashMap, Variance.OUT_VARIANCE, javaTypeAttributes.getVisitedTypeParameters());
        }
        Set<TypeParameterDescriptor> visitedTypeParameters2 = javaTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters2 == null) {
            visitedTypeParameters2 = SetsKt.setOf(this);
        }
        ClassifierDescriptor declarationDescriptor = firstUpperBound.getConstructor().getDeclarationDescriptor();
        Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) declarationDescriptor;
            if (!visitedTypeParameters2.contains(typeParameterDescriptor3)) {
                List<KotlinType> upperBounds2 = typeParameterDescriptor3.getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds2, "current.upperBounds");
                KotlinType nextUpperBound = (KotlinType) CollectionsKt.first((List<? extends Object>) upperBounds2);
                if (nextUpperBound.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
                    Intrinsics.checkNotNullExpressionValue(nextUpperBound, "nextUpperBound");
                    return TypeUtils.replaceArgumentsWithStarProjectionOrMapped(nextUpperBound, create, linkedHashMap, Variance.OUT_VARIANCE, javaTypeAttributes.getVisitedTypeParameters());
                }
                declarationDescriptor = nextUpperBound.getConstructor().getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            } else {
                return getDefaultType(javaTypeAttributes);
            }
        }
    }
}
