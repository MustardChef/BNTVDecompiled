package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* loaded from: classes4.dex */
public final class JvmBuiltInClassDescriptorFactory$cloneable$2 extends Lambda implements Functions<ClassDescriptorImpl> {
    final /* synthetic */ StorageManager $storageManager;
    final /* synthetic */ JvmBuiltInClassDescriptorFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInClassDescriptorFactory$cloneable$2(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory, StorageManager storageManager) {
        super(0);
        this.this$0 = jvmBuiltInClassDescriptorFactory;
        this.$storageManager = storageManager;
    }

    @Override // kotlin.jvm.functions.Functions
    public final ClassDescriptorImpl invoke() {
        Function1 function1;
        ModuleDescriptor moduleDescriptor;
        Name name;
        ModuleDescriptor moduleDescriptor2;
        function1 = this.this$0.computeContainingDeclaration;
        moduleDescriptor = this.this$0.moduleDescriptor;
        DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) function1.invoke(moduleDescriptor);
        name = JvmBuiltInClassDescriptorFactory.CLONEABLE_NAME;
        Modality modality = Modality.ABSTRACT;
        ClassKind classKind = ClassKind.INTERFACE;
        moduleDescriptor2 = this.this$0.moduleDescriptor;
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(declarationDescriptor, name, modality, classKind, CollectionsKt.listOf(moduleDescriptor2.getBuiltIns().getAnyType()), SourceElement.NO_SOURCE, false, this.$storageManager);
        classDescriptorImpl.initialize(new CloneableClassScope(this.$storageManager, classDescriptorImpl), SetsKt.emptySet(), null);
        return classDescriptorImpl;
    }
}
