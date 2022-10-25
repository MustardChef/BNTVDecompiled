package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: DeserializedClassDescriptor.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1 */
/* loaded from: classes4.dex */
final class C5235x65bb8e11 extends Lambda implements Functions<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ ProtoBuf.EnumEntry $proto;
    final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5235x65bb8e11(DeserializedClassDescriptor deserializedClassDescriptor, ProtoBuf.EnumEntry enumEntry) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
        this.$proto = enumEntry;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends AnnotationDescriptor> invoke() {
        return CollectionsKt.toList(this.this$0.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(this.this$0.getThisAsProtoContainer$deserialization(), this.$proto));
    }
}
