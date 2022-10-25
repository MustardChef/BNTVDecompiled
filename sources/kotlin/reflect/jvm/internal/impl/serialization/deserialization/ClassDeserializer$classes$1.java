package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClassDeserializer.kt */
/* loaded from: classes4.dex */
public final class ClassDeserializer$classes$1 extends Lambda implements Function1<ClassDeserializer.ClassKey, ClassDescriptor> {
    final /* synthetic */ ClassDeserializer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassDeserializer$classes$1(ClassDeserializer classDeserializer) {
        super(1);
        this.this$0 = classDeserializer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ClassDescriptor invoke(ClassDeserializer.ClassKey key) {
        ClassDescriptor createClass;
        Intrinsics.checkNotNullParameter(key, "key");
        createClass = this.this$0.createClass(key);
        return createClass;
    }
}
