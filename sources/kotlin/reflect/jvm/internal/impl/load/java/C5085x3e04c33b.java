package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: specialBuiltinMembers.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1 */
/* loaded from: classes4.dex */
public final class C5085x3e04c33b extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public static final C5085x3e04c33b INSTANCE = new C5085x3e04c33b();

    C5085x3e04c33b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(CallableMemberDescriptor it) {
        boolean hasErasedValueParametersInJava;
        Intrinsics.checkNotNullParameter(it, "it");
        hasErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getHasErasedValueParametersInJava(it);
        return Boolean.valueOf(hasErasedValueParametersInJava);
    }
}
