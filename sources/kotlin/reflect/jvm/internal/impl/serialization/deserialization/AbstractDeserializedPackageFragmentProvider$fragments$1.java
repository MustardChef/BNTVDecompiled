package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* loaded from: classes4.dex */
final class AbstractDeserializedPackageFragmentProvider$fragments$1 extends Lambda implements Function1<FqName, PackageFragmentDescriptor> {
    final /* synthetic */ AbstractDeserializedPackageFragmentProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractDeserializedPackageFragmentProvider$fragments$1(AbstractDeserializedPackageFragmentProvider abstractDeserializedPackageFragmentProvider) {
        super(1);
        this.this$0 = abstractDeserializedPackageFragmentProvider;
    }

    @Override // kotlin.jvm.functions.Function1
    public final PackageFragmentDescriptor invoke(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        DeserializedPackageFragment findPackage = this.this$0.findPackage(fqName);
        if (findPackage != null) {
            findPackage.initialize(this.this$0.getComponents());
        } else {
            findPackage = null;
        }
        return findPackage;
    }
}
