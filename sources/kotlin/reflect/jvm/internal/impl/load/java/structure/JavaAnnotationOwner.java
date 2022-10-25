package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: javaElements.kt */
/* loaded from: classes4.dex */
public interface JavaAnnotationOwner extends JavaElement {
    javaElements findAnnotation(FqName fqName);

    Collection<javaElements> getAnnotations();

    boolean isDeprecatedInJavaDoc();
}
