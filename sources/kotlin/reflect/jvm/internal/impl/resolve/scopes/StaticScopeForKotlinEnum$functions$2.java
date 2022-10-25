package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticScopeForKotlinEnum.kt */
/* loaded from: classes4.dex */
public final class StaticScopeForKotlinEnum$functions$2 extends Lambda implements Functions<List<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ StaticScopeForKotlinEnum this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticScopeForKotlinEnum$functions$2(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        super(0);
        this.this$0 = staticScopeForKotlinEnum;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends SimpleFunctionDescriptor> invoke() {
        ClassDescriptor classDescriptor;
        ClassDescriptor classDescriptor2;
        classDescriptor = this.this$0.containingClass;
        classDescriptor2 = this.this$0.containingClass;
        return CollectionsKt.listOf((Object[]) new SimpleFunctionDescriptor[]{DescriptorFactory.createEnumValueOfMethod(classDescriptor), DescriptorFactory.createEnumValuesMethod(classDescriptor2)});
    }
}
