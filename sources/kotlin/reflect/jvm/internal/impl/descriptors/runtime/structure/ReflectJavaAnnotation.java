package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArguments;
import kotlin.reflect.jvm.internal.impl.load.java.structure.annotationArguments;
import kotlin.reflect.jvm.internal.impl.load.java.structure.javaElements;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotation.kt */
/* loaded from: classes4.dex */
public final class ReflectJavaAnnotation extends ReflectJavaElement implements javaElements {
    private final Annotation annotation;

    public ReflectJavaAnnotation(Annotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        this.annotation = annotation;
    }

    public final Annotation getAnnotation() {
        return this.annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.javaElements
    public boolean isFreshlySupportedTypeUseAnnotation() {
        return javaElements.DefaultImpls.isFreshlySupportedTypeUseAnnotation(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.javaElements
    public boolean isIdeExternalAnnotation() {
        return javaElements.DefaultImpls.isIdeExternalAnnotation(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.javaElements
    public Collection<annotationArguments> getArguments() {
        Method[] declaredMethods = JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(this.annotation)).getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        Method[] methodArr = declaredMethods;
        ArrayList arrayList = new ArrayList(methodArr.length);
        for (Method method : methodArr) {
            ReflectJavaAnnotationArguments.Factory factory = ReflectJavaAnnotationArguments.Factory;
            Object invoke = method.invoke(this.annotation, new Object[0]);
            Intrinsics.checkNotNullExpressionValue(invoke, "method.invoke(annotation)");
            arrayList.add(factory.create(invoke, Name.identifier(method.getName())));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.javaElements
    public ClassId getClassId() {
        return reflectClassUtil.getClassId(JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(this.annotation)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.javaElements
    public ReflectJavaClass resolve() {
        return new ReflectJavaClass(JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(this.annotation)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaAnnotation) && Intrinsics.areEqual(this.annotation, ((ReflectJavaAnnotation) obj).annotation);
    }

    public int hashCode() {
        return this.annotation.hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + this.annotation;
    }
}
