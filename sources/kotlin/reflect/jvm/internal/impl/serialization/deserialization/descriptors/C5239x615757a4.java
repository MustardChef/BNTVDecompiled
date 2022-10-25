package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$functionsByName$2 */
/* loaded from: classes4.dex */
public final class C5239x615757a4 extends Lambda implements Functions<Map<Name, ? extends List<? extends SimpleFunctionDescriptor>>> {
    final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5239x615757a4(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.this$0 = noReorderImplementation;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Map<Name, ? extends List<? extends SimpleFunctionDescriptor>> invoke() {
        List allFunctions;
        allFunctions = this.this$0.getAllFunctions();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : allFunctions) {
            Name name = ((SimpleFunctionDescriptor) obj).getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        return linkedHashMap;
    }
}
