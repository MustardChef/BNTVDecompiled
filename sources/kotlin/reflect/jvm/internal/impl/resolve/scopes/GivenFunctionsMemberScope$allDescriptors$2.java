package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GivenFunctionsMemberScope.kt */
/* loaded from: classes4.dex */
public final class GivenFunctionsMemberScope$allDescriptors$2 extends Lambda implements Functions<List<? extends DeclarationDescriptor>> {
    final /* synthetic */ GivenFunctionsMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GivenFunctionsMemberScope$allDescriptors$2(GivenFunctionsMemberScope givenFunctionsMemberScope) {
        super(0);
        this.this$0 = givenFunctionsMemberScope;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends DeclarationDescriptor> invoke() {
        List createFakeOverrides;
        List<FunctionDescriptor> computeDeclaredFunctions = this.this$0.computeDeclaredFunctions();
        List<FunctionDescriptor> list = computeDeclaredFunctions;
        createFakeOverrides = this.this$0.createFakeOverrides(computeDeclaredFunctions);
        return CollectionsKt.plus((Collection) list, (Iterable) createFakeOverrides);
    }
}
