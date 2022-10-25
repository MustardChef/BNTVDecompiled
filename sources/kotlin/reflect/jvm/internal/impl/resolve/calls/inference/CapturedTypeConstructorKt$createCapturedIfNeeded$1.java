package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: CapturedTypeConstructor.kt */
/* loaded from: classes4.dex */
final class CapturedTypeConstructorKt$createCapturedIfNeeded$1 extends Lambda implements Functions<KotlinType> {
    final /* synthetic */ TypeProjection $this_createCapturedIfNeeded;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturedTypeConstructorKt$createCapturedIfNeeded$1(TypeProjection typeProjection) {
        super(0);
        this.$this_createCapturedIfNeeded = typeProjection;
    }

    @Override // kotlin.jvm.functions.Functions
    public final KotlinType invoke() {
        KotlinType type = this.$this_createCapturedIfNeeded.getType();
        Intrinsics.checkNotNullExpressionValue(type, "this@createCapturedIfNeeded.type");
        return type;
    }
}
