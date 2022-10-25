package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes4.dex */
public final class JavaAnnotationDescriptor$type$2 extends Lambda implements Functions<SimpleType> {

    /* renamed from: $c */
    final /* synthetic */ LazyJavaResolverContext f10641$c;
    final /* synthetic */ JavaAnnotationDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaAnnotationDescriptor$type$2(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationDescriptor javaAnnotationDescriptor) {
        super(0);
        this.f10641$c = lazyJavaResolverContext;
        this.this$0 = javaAnnotationDescriptor;
    }

    @Override // kotlin.jvm.functions.Functions
    public final SimpleType invoke() {
        SimpleType defaultType = this.f10641$c.getModule().getBuiltIns().getBuiltInClassByFqName(this.this$0.getFqName()).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "c.module.builtIns.getBui…qName(fqName).defaultType");
        return defaultType;
    }
}
