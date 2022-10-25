package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedClassDescriptor.kt */
/* loaded from: classes4.dex */
final class DeserializedClassDescriptor$DeserializedClassMemberScope$2$1 extends Lambda implements Functions<List<? extends Name>> {
    final /* synthetic */ List<Name> $it;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$DeserializedClassMemberScope$2$1(List<Name> list) {
        super(0);
        this.$it = list;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends Name> invoke() {
        return this.$it;
    }
}
