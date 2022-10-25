package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* compiled from: ReflectJavaConstructor.kt */
/* loaded from: classes4.dex */
public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    private final Constructor<?> member;

    public ReflectJavaConstructor(Constructor<?> member) {
        Intrinsics.checkNotNullParameter(member, "member");
        this.member = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Constructor<?> getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    public List<JavaValueParameter> getValueParameters() {
        Type[] realTypes = getMember().getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(realTypes, "types");
        if (realTypes.length == 0) {
            return CollectionsKt.emptyList();
        }
        Class<?> declaringClass = getMember().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            realTypes = (Type[]) ArraysKt.copyOfRange(realTypes, 1, realTypes.length);
        }
        Annotation[][] realAnnotations = getMember().getParameterAnnotations();
        Annotation[][] annotationArr = realAnnotations;
        if (annotationArr.length < realTypes.length) {
            throw new IllegalStateException("Illegal generic signature: " + getMember());
        }
        if (annotationArr.length > realTypes.length) {
            Intrinsics.checkNotNullExpressionValue(realAnnotations, "annotations");
            realAnnotations = (Annotation[][]) ArraysKt.copyOfRange(annotationArr, annotationArr.length - realTypes.length, annotationArr.length);
        }
        Intrinsics.checkNotNullExpressionValue(realTypes, "realTypes");
        Intrinsics.checkNotNullExpressionValue(realAnnotations, "realAnnotations");
        return getValueParameters(realTypes, realAnnotations, getMember().isVarArgs());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = getMember().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        TypeVariable<Constructor<?>>[] typeVariableArr = typeParameters;
        ArrayList arrayList = new ArrayList(typeVariableArr.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeVariableArr) {
            arrayList.add(new ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }
}
