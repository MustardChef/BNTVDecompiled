package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaPackageScope.kt */
/* loaded from: classes4.dex */
public final class LazyJavaPackageScope$knownClassNamesInPackage$1 extends Lambda implements Functions<Set<? extends String>> {

    /* renamed from: $c */
    final /* synthetic */ LazyJavaResolverContext f10652$c;
    final /* synthetic */ LazyJavaPackageScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope$knownClassNamesInPackage$1(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaPackageScope lazyJavaPackageScope) {
        super(0);
        this.f10652$c = lazyJavaResolverContext;
        this.this$0 = lazyJavaPackageScope;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Set<? extends String> invoke() {
        return this.f10652$c.getComponents().getFinder().knownClassNamesInPackage(this.this$0.getOwnerDescriptor().getFqName());
    }
}
