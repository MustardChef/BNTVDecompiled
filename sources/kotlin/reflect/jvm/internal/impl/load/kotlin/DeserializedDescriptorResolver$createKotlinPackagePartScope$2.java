package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedDescriptorResolver.kt */
/* loaded from: classes4.dex */
final class DeserializedDescriptorResolver$createKotlinPackagePartScope$2 extends Lambda implements Functions<Collection<? extends Name>> {
    public static final DeserializedDescriptorResolver$createKotlinPackagePartScope$2 INSTANCE = new DeserializedDescriptorResolver$createKotlinPackagePartScope$2();

    DeserializedDescriptorResolver$createKotlinPackagePartScope$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Functions
    public final Collection<? extends Name> invoke() {
        return CollectionsKt.emptyList();
    }
}
