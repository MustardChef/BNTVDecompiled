package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt */
/* loaded from: classes4.dex */
public final class overridingUtils {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> collection, Function1<? super H, ? extends CallableDescriptor> descriptorByHandle) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        SmartSet create = SmartSet.Companion.create();
        while (true) {
            LinkedList linkedList2 = linkedList;
            if (!linkedList2.isEmpty()) {
                Object first = CollectionsKt.first((List<? extends Object>) linkedList);
                SmartSet create2 = SmartSet.Companion.create();
                Collection<? super H> extractMembersOverridableInBothWays = OverridingUtil.extractMembersOverridableInBothWays(first, linkedList2, descriptorByHandle, new C5222x410e6287(create2));
                Intrinsics.checkNotNullExpressionValue(extractMembersOverridableInBothWays, "val conflictedHandles = …nflictedHandles.add(it) }");
                if (extractMembersOverridableInBothWays.size() == 1 && create2.isEmpty()) {
                    Object single = CollectionsKt.single(extractMembersOverridableInBothWays);
                    Intrinsics.checkNotNullExpressionValue(single, "overridableGroup.single()");
                    create.add(single);
                } else {
                    Object obj = (Object) OverridingUtil.selectMostSpecificMember(extractMembersOverridableInBothWays, descriptorByHandle);
                    Intrinsics.checkNotNullExpressionValue(obj, "selectMostSpecificMember…roup, descriptorByHandle)");
                    CallableDescriptor invoke = descriptorByHandle.invoke(obj);
                    for (Object it : extractMembersOverridableInBothWays) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        if (!OverridingUtil.isMoreSpecific(invoke, descriptorByHandle.invoke(it))) {
                            create2.add(it);
                        }
                    }
                    SmartSet smartSet = create2;
                    if (!smartSet.isEmpty()) {
                        create.addAll(smartSet);
                    }
                    create.add(obj);
                }
            } else {
                return create;
            }
        }
    }
}
