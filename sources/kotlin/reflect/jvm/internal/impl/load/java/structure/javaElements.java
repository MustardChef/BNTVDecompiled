package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation */
/* loaded from: classes4.dex */
public interface javaElements extends JavaElement {

    /* compiled from: javaElements.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation$DefaultImpls */
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean isFreshlySupportedTypeUseAnnotation(javaElements javaelements) {
            return false;
        }

        public static boolean isIdeExternalAnnotation(javaElements javaelements) {
            return false;
        }
    }

    Collection<annotationArguments> getArguments();

    ClassId getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    JavaClass resolve();
}
