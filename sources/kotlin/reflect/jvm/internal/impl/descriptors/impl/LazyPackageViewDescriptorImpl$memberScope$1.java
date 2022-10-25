package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyPackageViewDescriptorImpl.kt */
/* loaded from: classes4.dex */
public final class LazyPackageViewDescriptorImpl$memberScope$1 extends Lambda implements Functions<MemberScope> {
    final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl$memberScope$1(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.this$0 = lazyPackageViewDescriptorImpl;
    }

    @Override // kotlin.jvm.functions.Functions
    public final MemberScope invoke() {
        if (this.this$0.isEmpty()) {
            return MemberScope.Empty.INSTANCE;
        }
        List<PackageFragmentDescriptor> fragments = this.this$0.getFragments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fragments, 10));
        for (PackageFragmentDescriptor packageFragmentDescriptor : fragments) {
            arrayList.add(packageFragmentDescriptor.getMemberScope());
        }
        List plus = CollectionsKt.plus((Collection<? extends SubpackagesScope>) arrayList, new SubpackagesScope(this.this$0.getModule(), this.this$0.getFqName()));
        ChainedMemberScope.Companion companion = ChainedMemberScope.Companion;
        return companion.create("package view scope for " + this.this$0.getFqName() + " in " + this.this$0.getModule().getName(), plus);
    }
}
