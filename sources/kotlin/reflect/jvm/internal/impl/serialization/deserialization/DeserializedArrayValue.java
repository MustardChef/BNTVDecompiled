package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DeserializedArrayValue.kt */
/* loaded from: classes4.dex */
public final class DeserializedArrayValue extends ArrayValue {
    private final KotlinType type;

    /* compiled from: DeserializedArrayValue.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedArrayValue$1 */
    /* loaded from: classes4.dex */
    static final class C52231 extends Lambda implements Function1<ModuleDescriptor, KotlinType> {
        final /* synthetic */ KotlinType $type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C52231(KotlinType kotlinType) {
            super(1);
            this.$type = kotlinType;
        }

        @Override // kotlin.jvm.functions.Function1
        public final KotlinType invoke(ModuleDescriptor it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this.$type;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedArrayValue(List<? extends ConstantValue<?>> value, KotlinType type) {
        super(value, new C52231(type));
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    public final KotlinType getType() {
        return this.type;
    }
}
