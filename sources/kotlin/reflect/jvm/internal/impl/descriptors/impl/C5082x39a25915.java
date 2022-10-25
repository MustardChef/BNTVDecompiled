package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModuleDescriptorImpl.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2 */
/* loaded from: classes4.dex */
public final class C5082x39a25915 extends Lambda implements Functions<CompositePackageFragmentProvider> {
    final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5082x39a25915(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(0);
        this.this$0 = moduleDescriptorImpl;
    }

    @Override // kotlin.jvm.functions.Functions
    public final CompositePackageFragmentProvider invoke() {
        ModuleDependencies moduleDependencies;
        String id;
        PackageFragmentProvider packageFragmentProvider;
        moduleDependencies = this.this$0.dependencies;
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        if (moduleDependencies == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Dependencies of module ");
            id = moduleDescriptorImpl.getId();
            sb.append(id);
            sb.append(" were not set before querying module content");
            throw new AssertionError(sb.toString());
        }
        List<ModuleDescriptorImpl> allDependencies = moduleDependencies.getAllDependencies();
        this.this$0.assertValid();
        allDependencies.contains(this.this$0);
        List<ModuleDescriptorImpl> list = allDependencies;
        for (ModuleDescriptorImpl moduleDescriptorImpl2 : list) {
            moduleDescriptorImpl2.isInitialized();
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ModuleDescriptorImpl moduleDescriptorImpl3 : list) {
            packageFragmentProvider = moduleDescriptorImpl3.packageFragmentProviderForModuleContent;
            Intrinsics.checkNotNull(packageFragmentProvider);
            arrayList.add(packageFragmentProvider);
        }
        return new CompositePackageFragmentProvider(arrayList, "CompositeProvider@ModuleDescriptor for " + this.this$0.getName());
    }
}
