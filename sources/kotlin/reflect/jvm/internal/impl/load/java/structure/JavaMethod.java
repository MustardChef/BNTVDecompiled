package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;

/* compiled from: javaElements.kt */
/* loaded from: classes4.dex */
public interface JavaMethod extends JavaMember, JavaTypeParameterListOwner {
    annotationArguments getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    JavaType getReturnType();

    List<JavaValueParameter> getValueParameters();

    /* compiled from: javaElements.kt */
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean getHasAnnotationParameterDefaultValue(JavaMethod javaMethod) {
            return javaMethod.getAnnotationParameterDefaultValue() != null;
        }
    }
}
