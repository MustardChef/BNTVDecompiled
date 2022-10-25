package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.ReflectJvmMapping;

/* compiled from: KotlinAnnotationIntrospector.kt */
@Metadata(m108d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0007*\u00020\u001dH\u0002¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0007*\u00020 H\u0002¢\u0006\u0002\u0010!J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0007*\u00020\"H\u0002¢\u0006\u0002\u0010#J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0007*\u00020 H\u0002¢\u0006\u0002\u0010!J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0007*\u00020$H\u0002¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030'H\u0002J\u0018\u0010+\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030'2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010,\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030'2\u0006\u0010(\u001a\u00020)H\u0002J\f\u0010-\u001a\u00020\u0007*\u00020.H\u0002J\u0013\u0010/\u001a\u0004\u0018\u00010\u0007*\u000200H\u0002¢\u0006\u0002\u00101J\u0013\u0010/\u001a\u0004\u0018\u00010\u0007*\u00020\u001dH\u0002¢\u0006\u0002\u0010\u001eJ\u0014\u00102\u001a\u00020\u0007*\n\u0012\u0002\b\u0003\u0012\u0002\b\u000303H\u0002J\u0010\u00104\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/KotlinAnnotationIntrospector;", "Lcom/fasterxml/jackson/databind/introspect/NopAnnotationIntrospector;", "context", "Lcom/fasterxml/jackson/databind/Module$SetupContext;", "cache", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "nullToEmptyCollection", "", "nullToEmptyMap", "nullIsSameAsDefault", "(Lcom/fasterxml/jackson/databind/Module$SetupContext;Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;ZZZ)V", "findCreatorAnnotation", "Lcom/fasterxml/jackson/annotation/JsonCreator$Mode;", "config", "Lcom/fasterxml/jackson/databind/cfg/MapperConfig;", "a", "Lcom/fasterxml/jackson/databind/introspect/Annotated;", "findSubtypes", "", "Lcom/fasterxml/jackson/databind/jsontype/NamedType;", "hasRequiredMarker", "m", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Ljava/lang/Boolean;", "requiredAnnotationOrNullability", "byAnnotation", "byNullability", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "getRequiredMarkerFromAccessorLikeMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)Ljava/lang/Boolean;", "getRequiredMarkerFromCorrespondingAccessor", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Ljava/lang/Boolean;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;)Ljava/lang/Boolean;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;)Ljava/lang/Boolean;", "isConstructorParameterRequired", "Lkotlin/reflect/KFunction;", FirebaseAnalytics.Param.INDEX, "", "isGetterLike", "isMethodParameterRequired", "isParameterRequired", "isRequired", "Lkotlin/reflect/KType;", "isRequiredByAnnotation", "Ljava/lang/reflect/AccessibleObject;", "(Ljava/lang/reflect/AccessibleObject;)Ljava/lang/Boolean;", "isRequiredByNullability", "Lkotlin/reflect/KProperty1;", "isSetterLike", "Companion", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class KotlinAnnotationIntrospector extends NopAnnotationIntrospector {
    public static final Companion Companion = new Companion(null);
    private static final KType UNIT_TYPE = KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Unit.class), null, false, null, 7, null);
    private final ReflectionCache cache;
    private final Module.SetupContext context;
    private final boolean nullIsSameAsDefault;
    private final boolean nullToEmptyCollection;
    private final boolean nullToEmptyMap;

    public KotlinAnnotationIntrospector(Module.SetupContext context, ReflectionCache cache, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.context = context;
        this.cache = cache;
        this.nullToEmptyCollection = z;
        this.nullToEmptyMap = z2;
        this.nullIsSameAsDefault = z3;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean hasRequiredMarker(AnnotatedMember m) {
        Intrinsics.checkNotNullParameter(m, "m");
        return this.cache.javaMemberIsRequired(m, new KotlinAnnotationIntrospector$hasRequiredMarker$hasRequired$1(this, m));
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonCreator.Mode findCreatorAnnotation(MapperConfig<?> config, Annotated a) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(a, "a");
        return super.findCreatorAnnotation(config, a);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public List<NamedType> findSubtypes(Annotated a) {
        Intrinsics.checkNotNullParameter(a, "a");
        Class<?> it = a.getRawType();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!KotlinModuleKt.isKotlinClass(it)) {
            it = null;
        }
        if (it == null) {
            return null;
        }
        List<KClass> sealedSubclasses = JvmClassMapping.getKotlinClass(it).getSealedSubclasses();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sealedSubclasses, 10));
        for (KClass kClass : sealedSubclasses) {
            arrayList.add(new NamedType(JvmClassMapping.getJavaClass(kClass)));
        }
        List<NamedType> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        return mutableList.isEmpty() ? null : mutableList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean hasRequiredMarker(AnnotatedField annotatedField) {
        KType returnType;
        Member member = annotatedField.getMember();
        Objects.requireNonNull(member, "null cannot be cast to non-null type java.lang.reflect.Field");
        Boolean isRequiredByAnnotation = isRequiredByAnnotation((Field) member);
        Member member2 = annotatedField.getMember();
        Objects.requireNonNull(member2, "null cannot be cast to non-null type java.lang.reflect.Field");
        KProperty<?> kotlinProperty = ReflectJvmMapping.getKotlinProperty((Field) member2);
        Boolean bool = null;
        if (kotlinProperty != null && (returnType = kotlinProperty.getReturnType()) != null) {
            bool = Boolean.valueOf(isRequired(returnType));
        }
        return requiredAnnotationOrNullability(isRequiredByAnnotation, bool);
    }

    private final Boolean isRequiredByAnnotation(AccessibleObject accessibleObject) {
        JsonProperty jsonProperty;
        Annotation[] annotations = accessibleObject.getAnnotations();
        if (annotations == null) {
            return null;
        }
        int length = annotations.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                jsonProperty = null;
                break;
            }
            jsonProperty = annotations[i];
            if (Intrinsics.areEqual(JvmClassMapping.getAnnotationClass(jsonProperty), Reflection.getOrCreateKotlinClass(JsonProperty.class))) {
                break;
            }
            i++;
        }
        if (jsonProperty == null) {
            return null;
        }
        return Boolean.valueOf(jsonProperty.required());
    }

    private final Boolean requiredAnnotationOrNullability(Boolean bool, Boolean bool2) {
        if (bool == null || bool2 == null) {
            return bool2 != null ? bool2 : bool;
        }
        return Boolean.valueOf(bool.booleanValue() || bool2.booleanValue());
    }

    private final Boolean isRequiredByAnnotation(Method method) {
        JsonProperty jsonProperty;
        Annotation[] annotations = method.getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "this.annotations");
        Annotation[] annotationArr = annotations;
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                jsonProperty = null;
                break;
            }
            jsonProperty = annotationArr[i];
            if (Intrinsics.areEqual(JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(jsonProperty)), JsonProperty.class)) {
                break;
            }
            i++;
        }
        JsonProperty jsonProperty2 = jsonProperty instanceof JsonProperty ? jsonProperty : null;
        if (jsonProperty2 == null) {
            return null;
        }
        return Boolean.valueOf(jsonProperty2.required());
    }

    private final boolean isRequiredByNullability(KProperty1<?, ?> kProperty1) {
        return isRequired(kProperty1.getReturnType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean hasRequiredMarker(AnnotatedMethod annotatedMethod) {
        Boolean requiredMarkerFromCorrespondingAccessor = getRequiredMarkerFromCorrespondingAccessor(annotatedMethod);
        if (requiredMarkerFromCorrespondingAccessor == null) {
            Method member = annotatedMethod.getMember();
            Intrinsics.checkNotNullExpressionValue(member, "this.member");
            return getRequiredMarkerFromAccessorLikeMethod(member);
        }
        return requiredMarkerFromCorrespondingAccessor;
    }

    private final Boolean getRequiredMarkerFromCorrespondingAccessor(AnnotatedMethod annotatedMethod) {
        KProperty1<?, ?> kProperty1;
        KMutableProperty1 kMutableProperty1;
        Class<?> declaringClass = annotatedMethod.getMember().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "member.declaringClass");
        Iterator it = KClasses.getDeclaredMemberProperties(JvmClassMapping.getKotlinClass(declaringClass)).iterator();
        do {
            if (!it.hasNext()) {
                return null;
            }
            kProperty1 = (KProperty1) it.next();
            if (Intrinsics.areEqual(ReflectJvmMapping.getJavaGetter(kProperty1), annotatedMethod.getMember())) {
                break;
            }
            kMutableProperty1 = kProperty1 instanceof KMutableProperty1 ? (KMutableProperty1) kProperty1 : null;
        } while (!Intrinsics.areEqual(kMutableProperty1 != null ? ReflectJvmMapping.getJavaSetter(kMutableProperty1) : null, annotatedMethod.getMember()));
        Method member = annotatedMethod.getMember();
        Intrinsics.checkNotNullExpressionValue(member, "this.member");
        return requiredAnnotationOrNullability(isRequiredByAnnotation(member), Boolean.valueOf(isRequiredByNullability(kProperty1)));
    }

    private final Boolean getRequiredMarkerFromAccessorLikeMethod(Method method) {
        KFunction<?> kotlinFunction = ReflectJvmMapping.getKotlinFunction(method);
        if (kotlinFunction == null) {
            return null;
        }
        Boolean isRequiredByAnnotation = isRequiredByAnnotation(method);
        if (isGetterLike(kotlinFunction)) {
            return requiredAnnotationOrNullability(isRequiredByAnnotation, Boolean.valueOf(isRequired(kotlinFunction.getReturnType())));
        }
        if (isSetterLike(kotlinFunction)) {
            return requiredAnnotationOrNullability(isRequiredByAnnotation, Boolean.valueOf(isMethodParameterRequired(kotlinFunction, 0)));
        }
        return null;
    }

    private final boolean isGetterLike(KFunction<?> kFunction) {
        return kFunction.getParameters().size() == 1;
    }

    private final boolean isSetterLike(KFunction<?> kFunction) {
        return kFunction.getParameters().size() == 2 && Intrinsics.areEqual(kFunction.getReturnType(), UNIT_TYPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean hasRequiredMarker(AnnotatedParameter annotatedParameter) {
        Member member = annotatedParameter.getMember();
        JsonProperty jsonProperty = (JsonProperty) annotatedParameter.getAnnotation(JsonProperty.class);
        Boolean bool = null;
        Boolean valueOf = jsonProperty == null ? null : Boolean.valueOf(jsonProperty.required());
        if (member instanceof Constructor) {
            Intrinsics.checkNotNullExpressionValue(member, "member");
            KFunction<?> kotlinFunction = ReflectJvmMapping.getKotlinFunction((Constructor) member);
            if (kotlinFunction != null) {
                bool = Boolean.valueOf(isConstructorParameterRequired(kotlinFunction, annotatedParameter.getIndex()));
            }
        } else if (member instanceof Method) {
            Intrinsics.checkNotNullExpressionValue(member, "member");
            KFunction<?> kotlinFunction2 = ReflectJvmMapping.getKotlinFunction((Method) member);
            if (kotlinFunction2 != null) {
                bool = Boolean.valueOf(isMethodParameterRequired(kotlinFunction2, annotatedParameter.getIndex()));
            }
        }
        return requiredAnnotationOrNullability(valueOf, bool);
    }

    private final boolean isConstructorParameterRequired(KFunction<?> kFunction, int i) {
        return isParameterRequired(kFunction, i);
    }

    private final boolean isMethodParameterRequired(KFunction<?> kFunction, int i) {
        return isParameterRequired(kFunction, i + 1);
    }

    private final boolean isParameterRequired(KFunction<?> kFunction, int i) {
        KParameter kParameter = kFunction.getParameters().get(i);
        KType type = kParameter.getType();
        Type javaType = ReflectJvmMapping.getJavaType(type);
        boolean isPrimitive = javaType instanceof Class ? ((Class) javaType).isPrimitive() : false;
        if (type.isMarkedNullable() || kParameter.isOptional()) {
            return false;
        }
        return !isPrimitive || this.context.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
    }

    private final boolean isRequired(KType kType) {
        return !kType.isMarkedNullable();
    }

    /* compiled from: KotlinAnnotationIntrospector.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/KotlinAnnotationIntrospector$Companion;", "", "()V", "UNIT_TYPE", "Lkotlin/reflect/KType;", "getUNIT_TYPE", "()Lkotlin/reflect/KType;", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KType getUNIT_TYPE() {
            return KotlinAnnotationIntrospector.UNIT_TYPE;
        }
    }
}
