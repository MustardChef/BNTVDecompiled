package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeCapabilities.kt */
/* loaded from: classes4.dex */
public final class TypeCapabilitiesKt {
    public static final boolean isCustomTypeParameter(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        TypeCapabilities typeCapabilities = unwrap instanceof TypeCapabilities ? (TypeCapabilities) unwrap : null;
        if (typeCapabilities != null) {
            return typeCapabilities.isTypeParameter();
        }
        return false;
    }

    public static final TypeCapabilities getCustomTypeParameter(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        TypeCapabilities typeCapabilities = unwrap instanceof TypeCapabilities ? (TypeCapabilities) unwrap : null;
        if (typeCapabilities == null || !typeCapabilities.isTypeParameter()) {
            return null;
        }
        return typeCapabilities;
    }
}
