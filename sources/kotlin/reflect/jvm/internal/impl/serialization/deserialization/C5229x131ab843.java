package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2 */
/* loaded from: classes4.dex */
public final class C5229x131ab843 extends Lambda implements Function1<ProtoBuf.Type, Integer> {
    public static final C5229x131ab843 INSTANCE = new C5229x131ab843();

    C5229x131ab843() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(ProtoBuf.Type it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Integer.valueOf(it.getArgumentCount());
    }
}
