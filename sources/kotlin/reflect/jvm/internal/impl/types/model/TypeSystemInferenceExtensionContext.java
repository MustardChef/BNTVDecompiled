package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* compiled from: TypeSystemContext.kt */
/* loaded from: classes4.dex */
public interface TypeSystemInferenceExtensionContext extends TypeSystemCommonSuperTypesContext, TypeSystemContext {

    /* compiled from: TypeSystemContext.kt */
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, SimpleTypeMarker receiver, TypeConstructorMarker constructor) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            return TypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(typeSystemInferenceExtensionContext, receiver, constructor);
        }

        public static TypeArgumentMarker get(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, TypeArgumentListMarker receiver, int i) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.get(typeSystemInferenceExtensionContext, receiver, i);
        }

        public static TypeArgumentMarker getArgumentOrNull(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, SimpleTypeMarker receiver, int i) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.getArgumentOrNull(typeSystemInferenceExtensionContext, receiver, i);
        }

        public static boolean hasFlexibleNullability(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.hasFlexibleNullability(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isCapturedType(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.isCapturedType(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isClassType(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.isClassType(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isDefinitelyNotNullType(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.isDefinitelyNotNullType(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isDynamic(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.isDynamic(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isIntegerLiteralType(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.isIntegerLiteralType(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isMarkedNullable(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.isMarkedNullable(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isNothing(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.isNothing(typeSystemInferenceExtensionContext, receiver);
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.lowerBoundIfFlexible(typeSystemInferenceExtensionContext, receiver);
        }

        public static int size(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, TypeArgumentListMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.size(typeSystemInferenceExtensionContext, receiver);
        }

        public static TypeConstructorMarker typeConstructor(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.typeConstructor(typeSystemInferenceExtensionContext, receiver);
        }

        public static SimpleTypeMarker upperBoundIfFlexible(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return TypeSystemContext.DefaultImpls.upperBoundIfFlexible(typeSystemInferenceExtensionContext, receiver);
        }
    }
}
