package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaClassDescriptor.kt */
/* loaded from: classes4.dex */
public final class LazyJavaClassDescriptor$scopeHolder$1 extends Lambda implements Function1<KotlinTypeRefiner, LazyJavaClassMemberScope> {
    final /* synthetic */ LazyJavaClassDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor$scopeHolder$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(1);
        this.this$0 = lazyJavaClassDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public final LazyJavaClassMemberScope invoke(KotlinTypeRefiner it) {
        LazyJavaClassMemberScope lazyJavaClassMemberScope;
        Intrinsics.checkNotNullParameter(it, "it");
        LazyJavaResolverContext lazyJavaResolverContext = this.this$0.f10647c;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.this$0;
        LazyJavaClassDescriptor lazyJavaClassDescriptor2 = lazyJavaClassDescriptor;
        JavaClass jClass = lazyJavaClassDescriptor.getJClass();
        boolean z = this.this$0.additionalSupertypeClassDescriptor != null;
        lazyJavaClassMemberScope = this.this$0.unsubstitutedMemberScope;
        return new LazyJavaClassMemberScope(lazyJavaResolverContext, lazyJavaClassDescriptor2, jClass, z, lazyJavaClassMemberScope);
    }
}
