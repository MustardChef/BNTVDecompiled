package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* loaded from: classes4.dex */
final class JvmBuiltInsCustomizer$isMutabilityViolation$1<N> implements DFS.Neighbors {
    public static final JvmBuiltInsCustomizer$isMutabilityViolation$1<N> INSTANCE = new JvmBuiltInsCustomizer$isMutabilityViolation$1<>();

    JvmBuiltInsCustomizer$isMutabilityViolation$1() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
    public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.getOriginal().getOverriddenDescriptors();
    }
}
