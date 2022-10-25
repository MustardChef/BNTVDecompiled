package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes4.dex */
public final class DeserializedMemberScope$NoReorderImplementation$allFunctions$2 extends Lambda implements Functions<List<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$allFunctions$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.this$0 = noReorderImplementation;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends SimpleFunctionDescriptor> invoke() {
        List declaredFunctions;
        List computeAllNonDeclaredFunctions;
        declaredFunctions = this.this$0.getDeclaredFunctions();
        computeAllNonDeclaredFunctions = this.this$0.computeAllNonDeclaredFunctions();
        return CollectionsKt.plus((Collection) declaredFunctions, (Iterable) computeAllNonDeclaredFunctions);
    }
}
