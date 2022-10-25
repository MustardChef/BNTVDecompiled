package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedClassDescriptor.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 */
/* loaded from: classes4.dex */
public final class C5234xaf8327b7 extends Lambda implements Function1<Name, ClassDescriptor> {
    final /* synthetic */ DeserializedClassDescriptor.EnumEntryClassDescriptors this$0;
    final /* synthetic */ DeserializedClassDescriptor this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5234xaf8327b7(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors, DeserializedClassDescriptor deserializedClassDescriptor) {
        super(1);
        this.this$0 = enumEntryClassDescriptors;
        this.this$1 = deserializedClassDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ClassDescriptor invoke(Name name) {
        Map map;
        EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor;
        NotNullLazyValue notNullLazyValue;
        Intrinsics.checkNotNullParameter(name, "name");
        map = this.this$0.enumEntryProtos;
        ProtoBuf.EnumEntry enumEntry = (ProtoBuf.EnumEntry) map.get(name);
        if (enumEntry != null) {
            DeserializedClassDescriptor deserializedClassDescriptor = this.this$1;
            notNullLazyValue = this.this$0.enumMemberNames;
            enumEntrySyntheticClassDescriptor = EnumEntrySyntheticClassDescriptor.create(deserializedClassDescriptor.getC().getStorageManager(), deserializedClassDescriptor, name, notNullLazyValue, new DeserializedAnnotations(deserializedClassDescriptor.getC().getStorageManager(), new C5235x65bb8e11(deserializedClassDescriptor, enumEntry)), SourceElement.NO_SOURCE);
        } else {
            enumEntrySyntheticClassDescriptor = null;
        }
        return enumEntrySyntheticClassDescriptor;
    }
}
