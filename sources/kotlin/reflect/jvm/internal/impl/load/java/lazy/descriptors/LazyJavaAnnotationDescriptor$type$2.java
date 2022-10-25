package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.javaElements;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaAnnotationDescriptor.kt */
/* loaded from: classes4.dex */
public final class LazyJavaAnnotationDescriptor$type$2 extends Lambda implements Functions<SimpleType> {
    final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotationDescriptor$type$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    @Override // kotlin.jvm.functions.Functions
    public final SimpleType invoke() {
        LazyJavaResolverContext lazyJavaResolverContext;
        javaElements javaelements;
        LazyJavaResolverContext lazyJavaResolverContext2;
        javaElements javaelements2;
        FqName fqName = this.this$0.getFqName();
        if (fqName == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No fqName: ");
            javaelements2 = this.this$0.javaAnnotation;
            sb.append(javaelements2);
            return ErrorUtils.createErrorType(sb.toString());
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        lazyJavaResolverContext = this.this$0.f10646c;
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, lazyJavaResolverContext.getModule().getBuiltIns(), null, 4, null);
        if (mapJavaToKotlin$default == null) {
            javaelements = this.this$0.javaAnnotation;
            JavaClass resolve = javaelements.resolve();
            if (resolve != null) {
                lazyJavaResolverContext2 = this.this$0.f10646c;
                mapJavaToKotlin$default = lazyJavaResolverContext2.getComponents().getModuleClassResolver().resolveClass(resolve);
            } else {
                mapJavaToKotlin$default = null;
            }
            if (mapJavaToKotlin$default == null) {
                mapJavaToKotlin$default = this.this$0.createTypeForMissingDependencies(fqName);
            }
        }
        return mapJavaToKotlin$default.getDefaultType();
    }
}
