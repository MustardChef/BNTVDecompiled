package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* compiled from: JvmBuiltIns.kt */
/* loaded from: classes4.dex */
final class JvmBuiltIns$initialize$1 extends Lambda implements Functions<JvmBuiltIns.Settings> {
    final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
    final /* synthetic */ ModuleDescriptor $moduleDescriptor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns$initialize$1(ModuleDescriptor moduleDescriptor, boolean z) {
        super(0);
        this.$moduleDescriptor = moduleDescriptor;
        this.$isAdditionalBuiltInsFeatureSupported = z;
    }

    @Override // kotlin.jvm.functions.Functions
    public final JvmBuiltIns.Settings invoke() {
        return new JvmBuiltIns.Settings(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
    }
}
