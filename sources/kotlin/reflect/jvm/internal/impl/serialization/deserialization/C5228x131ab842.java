package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.protoTypeTableUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1 */
/* loaded from: classes4.dex */
public final class C5228x131ab842 extends Lambda implements Function1<ProtoBuf.Type, ProtoBuf.Type> {
    final /* synthetic */ TypeDeserializer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5228x131ab842(TypeDeserializer typeDeserializer) {
        super(1);
        this.this$0 = typeDeserializer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ProtoBuf.Type invoke(ProtoBuf.Type it) {
        DeserializationContext deserializationContext;
        Intrinsics.checkNotNullParameter(it, "it");
        deserializationContext = this.this$0.f10668c;
        return protoTypeTableUtil.outerType(it, deserializationContext.getTypeTable());
    }
}
