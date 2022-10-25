package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ContextClassReceiver.kt */
/* loaded from: classes4.dex */
public final class ContextClassReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final ClassDescriptor classDescriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextClassReceiver(ClassDescriptor classDescriptor, KotlinType receiverType, ReceiverValue receiverValue) {
        super(receiverType, receiverValue);
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(receiverType, "receiverType");
        this.classDescriptor = classDescriptor;
    }

    public String toString() {
        return getType() + ": Ctx { " + this.classDescriptor + " }";
    }
}
