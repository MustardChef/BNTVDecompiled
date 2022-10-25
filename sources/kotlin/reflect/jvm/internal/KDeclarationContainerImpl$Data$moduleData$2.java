package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KDeclarationContainerImpl.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "kotlin.jvm.PlatformType", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class KDeclarationContainerImpl$Data$moduleData$2 extends Lambda implements Functions<RuntimeModuleData> {
    final /* synthetic */ KDeclarationContainerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KDeclarationContainerImpl$Data$moduleData$2(KDeclarationContainerImpl kDeclarationContainerImpl) {
        super(0);
        this.this$0 = kDeclarationContainerImpl;
    }

    @Override // kotlin.jvm.functions.Functions
    public final RuntimeModuleData invoke() {
        return moduleByClassLoader.getOrCreateModule(this.this$0.getJClass());
    }
}
