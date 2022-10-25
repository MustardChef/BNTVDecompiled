package kotlin.reflect.jvm.internal.impl.types;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter */
/* loaded from: classes4.dex */
public interface TypeCapabilities {
    boolean isTypeParameter();

    KotlinType substitutionResult(KotlinType kotlinType);
}
