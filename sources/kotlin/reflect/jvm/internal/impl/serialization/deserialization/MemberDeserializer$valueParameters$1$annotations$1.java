package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MemberDeserializer.kt */
/* loaded from: classes4.dex */
public final class MemberDeserializer$valueParameters$1$annotations$1 extends Lambda implements Functions<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ MessageLite $callable;
    final /* synthetic */ ProtoContainer $containerOfCallable;

    /* renamed from: $i */
    final /* synthetic */ int f10667$i;
    final /* synthetic */ AnnotatedCallableKind $kind;
    final /* synthetic */ ProtoBuf.ValueParameter $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$valueParameters$1$annotations$1(MemberDeserializer memberDeserializer, ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf.ValueParameter valueParameter) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$containerOfCallable = protoContainer;
        this.$callable = messageLite;
        this.$kind = annotatedCallableKind;
        this.f10667$i = i;
        this.$proto = valueParameter;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends AnnotationDescriptor> invoke() {
        DeserializationContext deserializationContext;
        deserializationContext = this.this$0.f10666c;
        return CollectionsKt.toList(deserializationContext.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(this.$containerOfCallable, this.$callable, this.$kind, this.f10667$i, this.$proto));
    }
}
