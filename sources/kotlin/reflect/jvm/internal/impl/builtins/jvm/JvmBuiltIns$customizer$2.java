package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmBuiltIns.kt */
/* loaded from: classes4.dex */
public final class JvmBuiltIns$customizer$2 extends Lambda implements Functions<JvmBuiltInsCustomizer> {
    final /* synthetic */ StorageManager $storageManager;
    final /* synthetic */ JvmBuiltIns this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns$customizer$2(JvmBuiltIns jvmBuiltIns, StorageManager storageManager) {
        super(0);
        this.this$0 = jvmBuiltIns;
        this.$storageManager = storageManager;
    }

    @Override // kotlin.jvm.functions.Functions
    public final JvmBuiltInsCustomizer invoke() {
        ModuleDescriptorImpl builtInsModule = this.this$0.getBuiltInsModule();
        Intrinsics.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
        return new JvmBuiltInsCustomizer(builtInsModule, this.$storageManager, new C50441(this.this$0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltIns.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$customizer$2$1 */
    /* loaded from: classes4.dex */
    public static final class C50441 extends Lambda implements Functions<JvmBuiltIns.Settings> {
        final /* synthetic */ JvmBuiltIns this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C50441(JvmBuiltIns jvmBuiltIns) {
            super(0);
            this.this$0 = jvmBuiltIns;
        }

        @Override // kotlin.jvm.functions.Functions
        public final JvmBuiltIns.Settings invoke() {
            Functions functions;
            functions = this.this$0.settingsComputation;
            if (functions == null) {
                throw new AssertionError("JvmBuiltins instance has not been initialized properly");
            }
            JvmBuiltIns.Settings settings = (JvmBuiltIns.Settings) functions.invoke();
            this.this$0.settingsComputation = null;
            return settings;
        }
    }
}
