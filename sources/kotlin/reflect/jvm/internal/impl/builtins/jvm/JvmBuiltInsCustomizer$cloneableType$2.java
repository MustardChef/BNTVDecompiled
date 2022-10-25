package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.findClassInModule;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmBuiltInsCustomizer.kt */
/* loaded from: classes4.dex */
public final class JvmBuiltInsCustomizer$cloneableType$2 extends Lambda implements Functions<SimpleType> {
    final /* synthetic */ StorageManager $storageManager;
    final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$cloneableType$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, StorageManager storageManager) {
        super(0);
        this.this$0 = jvmBuiltInsCustomizer;
        this.$storageManager = storageManager;
    }

    @Override // kotlin.jvm.functions.Functions
    public final SimpleType invoke() {
        JvmBuiltIns.Settings settings;
        JvmBuiltIns.Settings settings2;
        settings = this.this$0.getSettings();
        ModuleDescriptor ownerModuleDescriptor = settings.getOwnerModuleDescriptor();
        ClassId cloneable_class_id = JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_CLASS_ID();
        StorageManager storageManager = this.$storageManager;
        settings2 = this.this$0.getSettings();
        return findClassInModule.findNonGenericClassAcrossDependencies(ownerModuleDescriptor, cloneable_class_id, new NotFoundClasses(storageManager, settings2.getOwnerModuleDescriptor())).getDefaultType();
    }
}
