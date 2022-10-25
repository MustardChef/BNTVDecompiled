package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DescriptorUtils.kt */
/* loaded from: classes4.dex */
public final class DescriptorUtilsKt$declaresOrInheritsDefaultValue$1<N> implements DFS.Neighbors {
    public static final DescriptorUtilsKt$declaresOrInheritsDefaultValue$1<N> INSTANCE = new DescriptorUtilsKt$declaresOrInheritsDefaultValue$1<>();

    DescriptorUtilsKt$declaresOrInheritsDefaultValue$1() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
    public final Iterable<ValueParameterDescriptor> getNeighbors(ValueParameterDescriptor valueParameterDescriptor) {
        Collection<ValueParameterDescriptor> overriddenDescriptors = valueParameterDescriptor.getOverriddenDescriptors();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (ValueParameterDescriptor valueParameterDescriptor2 : overriddenDescriptors) {
            arrayList.add(valueParameterDescriptor2.getOriginal());
        }
        return arrayList;
    }
}
