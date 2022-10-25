package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedClassDescriptor.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 */
/* loaded from: classes4.dex */
public final class C5232xfdb95347 extends Lambda implements Functions<Collection<? extends KotlinType>> {
    final /* synthetic */ DeserializedClassDescriptor.DeserializedClassMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5232xfdb95347(DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
        super(0);
        this.this$0 = deserializedClassMemberScope;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Collection<? extends KotlinType> invoke() {
        KotlinTypeRefiner kotlinTypeRefiner;
        DeserializedClassDescriptor classDescriptor;
        kotlinTypeRefiner = this.this$0.kotlinTypeRefiner;
        classDescriptor = this.this$0.getClassDescriptor();
        return kotlinTypeRefiner.refineSupertypes(classDescriptor);
    }
}
