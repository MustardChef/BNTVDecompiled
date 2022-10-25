package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: signatureEnhancement.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1 */
/* loaded from: classes4.dex */
final class C5130xf9f85b83 extends Lambda implements Function1<CallableMemberDescriptor, KotlinType> {

    /* renamed from: $p */
    final /* synthetic */ ValueParameterDescriptor f10656$p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5130xf9f85b83(ValueParameterDescriptor valueParameterDescriptor) {
        super(1);
        this.f10656$p = valueParameterDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public final KotlinType invoke(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KotlinType type = it.getValueParameters().get(this.f10656$p.getIndex()).getType();
        Intrinsics.checkNotNullExpressionValue(type, "it.valueParameters[p.index].type");
        return type;
    }
}
