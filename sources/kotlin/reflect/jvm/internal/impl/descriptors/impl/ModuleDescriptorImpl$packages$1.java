package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModuleDescriptorImpl.kt */
/* loaded from: classes4.dex */
public final class ModuleDescriptorImpl$packages$1 extends Lambda implements Function1<FqName, PackageViewDescriptor> {
    final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl$packages$1(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(1);
        this.this$0 = moduleDescriptorImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final PackageViewDescriptor invoke(FqName fqName) {
        PackageViewDescriptorFactory packageViewDescriptorFactory;
        StorageManager storageManager;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        packageViewDescriptorFactory = this.this$0.packageViewDescriptorFactory;
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        storageManager = moduleDescriptorImpl.storageManager;
        return packageViewDescriptorFactory.compute(moduleDescriptorImpl, fqName, storageManager);
    }
}
