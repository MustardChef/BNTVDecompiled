package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.javaElements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaAnnotations.kt */
/* loaded from: classes4.dex */
public final class LazyJavaAnnotations$annotationDescriptors$1 extends Lambda implements Function1<javaElements, AnnotationDescriptor> {
    final /* synthetic */ LazyJavaAnnotations this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotations$annotationDescriptors$1(LazyJavaAnnotations lazyJavaAnnotations) {
        super(1);
        this.this$0 = lazyJavaAnnotations;
    }

    @Override // kotlin.jvm.functions.Function1
    public final AnnotationDescriptor invoke(javaElements annotation) {
        LazyJavaResolverContext lazyJavaResolverContext;
        boolean z;
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.INSTANCE;
        lazyJavaResolverContext = this.this$0.f10642c;
        z = this.this$0.areAnnotationsFreshlySupported;
        return javaAnnotationMapper.mapOrResolveJavaAnnotation(annotation, lazyJavaResolverContext, z);
    }
}
