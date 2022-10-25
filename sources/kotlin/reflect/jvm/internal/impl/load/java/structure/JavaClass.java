package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: javaElements.kt */
/* loaded from: classes4.dex */
public interface JavaClass extends JavaClassifier, JavaModifierListOwner, JavaTypeParameterListOwner {
    Collection<JavaConstructor> getConstructors();

    Collection<JavaField> getFields();

    FqName getFqName();

    Collection<Name> getInnerClassNames();

    LightClassOriginKind getLightClassOriginKind();

    Collection<JavaMethod> getMethods();

    JavaClass getOuterClass();

    Collection<JavaClassifierType> getPermittedTypes();

    Collection<JavaRecordComponent> getRecordComponents();

    Collection<JavaClassifierType> getSupertypes();

    boolean hasDefaultConstructor();

    boolean isAnnotationType();

    boolean isEnum();

    boolean isInterface();

    boolean isRecord();

    boolean isSealed();
}
