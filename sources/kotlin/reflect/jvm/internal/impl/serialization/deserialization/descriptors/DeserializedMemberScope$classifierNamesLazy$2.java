package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes4.dex */
public final class DeserializedMemberScope$classifierNamesLazy$2 extends Lambda implements Functions<Set<? extends Name>> {
    final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$classifierNamesLazy$2(DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.this$0 = deserializedMemberScope;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Set<? extends Name> invoke() {
        DeserializedMemberScope.Implementation implementation;
        Set<Name> nonDeclaredClassifierNames = this.this$0.getNonDeclaredClassifierNames();
        if (nonDeclaredClassifierNames == null) {
            return null;
        }
        Set<Name> classNames$deserialization = this.this$0.getClassNames$deserialization();
        implementation = this.this$0.impl;
        return SetsKt.plus(SetsKt.plus((Set) classNames$deserialization, (Iterable) implementation.getTypeAliasNames()), (Iterable) nonDeclaredClassifierNames);
    }
}
