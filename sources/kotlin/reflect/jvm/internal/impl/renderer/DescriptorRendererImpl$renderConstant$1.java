package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DescriptorRendererImpl.kt */
/* loaded from: classes4.dex */
public final class DescriptorRendererImpl$renderConstant$1 extends Lambda implements Function1<ConstantValue<?>, CharSequence> {
    final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$renderConstant$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.this$0 = descriptorRendererImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(ConstantValue<?> it) {
        String renderConstant;
        Intrinsics.checkNotNullParameter(it, "it");
        renderConstant = this.this$0.renderConstant(it);
        return renderConstant;
    }
}
