package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes4.dex */
final class DeserializedMemberScope$classNames$2 extends Lambda implements Functions<Set<? extends Name>> {
    final /* synthetic */ Functions<Collection<Name>> $classNames;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DeserializedMemberScope$classNames$2(Functions<? extends Collection<Name>> functions) {
        super(0);
        this.$classNames = functions;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Set<? extends Name> invoke() {
        return CollectionsKt.toSet(this.$classNames.invoke());
    }
}
