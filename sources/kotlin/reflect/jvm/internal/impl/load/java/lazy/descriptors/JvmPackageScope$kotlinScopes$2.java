package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.scopeUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmPackageScope.kt */
/* loaded from: classes4.dex */
public final class JvmPackageScope$kotlinScopes$2 extends Lambda implements Functions<MemberScope[]> {
    final /* synthetic */ JvmPackageScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmPackageScope$kotlinScopes$2(JvmPackageScope jvmPackageScope) {
        super(0);
        this.this$0 = jvmPackageScope;
    }

    @Override // kotlin.jvm.functions.Functions
    public final MemberScope[] invoke() {
        LazyJavaPackageFragment lazyJavaPackageFragment;
        LazyJavaResolverContext lazyJavaResolverContext;
        LazyJavaPackageFragment lazyJavaPackageFragment2;
        lazyJavaPackageFragment = this.this$0.packageFragment;
        JvmPackageScope jvmPackageScope = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (KotlinJvmBinaryClass kotlinJvmBinaryClass : lazyJavaPackageFragment.getBinaryClasses$descriptors_jvm().values()) {
            lazyJavaResolverContext = jvmPackageScope.f10645c;
            DeserializedDescriptorResolver deserializedDescriptorResolver = lazyJavaResolverContext.getComponents().getDeserializedDescriptorResolver();
            lazyJavaPackageFragment2 = jvmPackageScope.packageFragment;
            MemberScope createKotlinPackagePartScope = deserializedDescriptorResolver.createKotlinPackagePartScope(lazyJavaPackageFragment2, kotlinJvmBinaryClass);
            if (createKotlinPackagePartScope != null) {
                arrayList.add(createKotlinPackagePartScope);
            }
        }
        Object[] array = scopeUtils.listOfNonEmptyScopes(arrayList).toArray(new MemberScope[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (MemberScope[]) array;
    }
}
