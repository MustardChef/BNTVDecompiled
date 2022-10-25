package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.BeanUtil;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: KotlinNamesAnnotationIntrospector.kt */
@Metadata(m108d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007¢\u0006\u0002\u0010\tJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020 H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/KotlinNamesAnnotationIntrospector;", "Lcom/fasterxml/jackson/databind/introspect/NopAnnotationIntrospector;", "module", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "cache", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "ignoredClassesForImplyingJsonCreator", "", "Lkotlin/reflect/KClass;", "(Lcom/fasterxml/jackson/module/kotlin/KotlinModule;Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;Ljava/util/Set;)V", "getCache", "()Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "getIgnoredClassesForImplyingJsonCreator", "()Ljava/util/Set;", "getModule", "()Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "findImplicitPropertyName", "", "member", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;", "findKotlinParameterName", "param", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;", "findRenameByField", "Lcom/fasterxml/jackson/databind/PropertyName;", "config", "Lcom/fasterxml/jackson/databind/cfg/MapperConfig;", "field", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;", "implName", "hasCreatorAnnotation", "", "Lcom/fasterxml/jackson/databind/introspect/Annotated;", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class KotlinNamesAnnotationIntrospector extends NopAnnotationIntrospector {
    private final ReflectionCache cache;
    private final Set<KClass<?>> ignoredClassesForImplyingJsonCreator;
    private final KotlinModule module;

    /* JADX WARN: Multi-variable type inference failed */
    public KotlinNamesAnnotationIntrospector(KotlinModule module, ReflectionCache cache, Set<? extends KClass<?>> ignoredClassesForImplyingJsonCreator) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(ignoredClassesForImplyingJsonCreator, "ignoredClassesForImplyingJsonCreator");
        this.module = module;
        this.cache = cache;
        this.ignoredClassesForImplyingJsonCreator = ignoredClassesForImplyingJsonCreator;
    }

    public final ReflectionCache getCache() {
        return this.cache;
    }

    public final Set<KClass<?>> getIgnoredClassesForImplyingJsonCreator() {
        return this.ignoredClassesForImplyingJsonCreator;
    }

    public final KotlinModule getModule() {
        return this.module;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findImplicitPropertyName(AnnotatedMember member) {
        String str;
        Intrinsics.checkNotNullParameter(member, "member");
        if (!(member instanceof AnnotatedMethod)) {
            if (member instanceof AnnotatedParameter) {
                return findKotlinParameterName((AnnotatedParameter) member);
            }
            return null;
        }
        AnnotatedMethod annotatedMethod = (AnnotatedMethod) member;
        String name = annotatedMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name, "member.name");
        if (StringsKt.contains$default((CharSequence) name, '-', false, 2, (Object) null) && annotatedMethod.getParameterCount() == 0) {
            String name2 = annotatedMethod.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "member.name");
            if (StringsKt.startsWith$default(name2, "get", false, 2, (Object) null)) {
                String name3 = annotatedMethod.getName();
                Intrinsics.checkNotNullExpressionValue(name3, "member.name");
                str = StringsKt.substringAfter$default(name3, "get", (String) null, 2, (Object) null);
            } else {
                String name4 = annotatedMethod.getName();
                Intrinsics.checkNotNullExpressionValue(name4, "member.name");
                if (StringsKt.startsWith$default(name4, "is", false, 2, (Object) null)) {
                    String name5 = annotatedMethod.getName();
                    Intrinsics.checkNotNullExpressionValue(name5, "member.name");
                    str = StringsKt.substringAfter$default(name5, "is", (String) null, 2, (Object) null);
                } else {
                    str = null;
                }
            }
            if (str == null) {
                return null;
            }
            if (str.length() > 0) {
                StringBuilder sb = new StringBuilder();
                char charAt = str.charAt(0);
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                sb.append(CharsKt.lowercase(charAt, locale).toString());
                String substring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring);
                str = sb.toString();
            }
            if (str == null) {
                return null;
            }
            return StringsKt.substringBefore$default(str, '-', (String) null, 2, (Object) null);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findRenameByField(MapperConfig<?> config, AnnotatedField field, PropertyName implName) {
        String stdManglePropertyName;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(implName, "implName");
        String origSimple = implName.getSimpleName();
        Class<?> declaringClass = field.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "field.declaringClass");
        if (KotlinModuleKt.isKotlinClass(declaringClass)) {
            Intrinsics.checkNotNullExpressionValue(origSimple, "origSimple");
            if (StringsKt.startsWith$default(origSimple, "is", false, 2, (Object) null) && (stdManglePropertyName = BeanUtil.stdManglePropertyName(origSimple, 2)) != null && !stdManglePropertyName.equals(origSimple)) {
                return PropertyName.construct(stdManglePropertyName);
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public boolean hasCreatorAnnotation(Annotated member) {
        Intrinsics.checkNotNullParameter(member, "member");
        if (member instanceof AnnotatedConstructor) {
            AnnotatedConstructor annotatedConstructor = (AnnotatedConstructor) member;
            if (annotatedConstructor.getDeclaringClass().isEnum() || annotatedConstructor.getParameterCount() <= 0) {
                return false;
            }
            Class<?> declaringClass = annotatedConstructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "member.declaringClass");
            if (KotlinModuleKt.isKotlinClass(declaringClass)) {
                return this.cache.checkConstructorIsCreatorAnnotated(annotatedConstructor, new KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$1(this, member));
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008a A[Catch: KotlinReflectionInternalError -> 0x00c0, TryCatch #1 {KotlinReflectionInternalError -> 0x00c0, blocks: (B:31:0x0068, B:41:0x0086, B:43:0x008a, B:54:0x00a8, B:57:0x00af, B:60:0x00b8, B:61:0x00bd, B:47:0x0098, B:50:0x009f, B:44:0x0091, B:34:0x0072, B:37:0x0079, B:40:0x0082), top: B:69:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091 A[Catch: KotlinReflectionInternalError -> 0x00c0, TryCatch #1 {KotlinReflectionInternalError -> 0x00c0, blocks: (B:31:0x0068, B:41:0x0086, B:43:0x008a, B:54:0x00a8, B:57:0x00af, B:60:0x00b8, B:61:0x00bd, B:47:0x0098, B:50:0x009f, B:44:0x0091, B:34:0x0072, B:37:0x0079, B:40:0x0082), top: B:69:0x0068 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String findKotlinParameterName(com.fasterxml.jackson.databind.introspect.AnnotatedParameter r6) {
        /*
            r5 = this;
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r1 = "param.declaringClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = com.fasterxml.jackson.module.kotlin.KotlinModuleKt.isKotlinClass(r0)
            r1 = 0
            if (r0 == 0) goto Lc6
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r0 = r6.getOwner()
            java.lang.reflect.Member r0 = r0.getMember()
            boolean r2 = r0 instanceof java.lang.reflect.Constructor
            r3 = 0
            if (r2 == 0) goto L64
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            java.lang.Class[] r2 = r0.getParameterTypes()
            int r2 = r2.length
            kotlin.reflect.KFunction r4 = kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(r0)     // Catch: java.lang.Throwable -> L37
            if (r4 != 0) goto L2b
            goto L38
        L2b:
            java.util.List r4 = r4.getParameters()     // Catch: java.lang.Throwable -> L37
            if (r4 != 0) goto L32
            goto L38
        L32:
            int r3 = r4.size()     // Catch: java.lang.Throwable -> L37
            goto L38
        L37:
        L38:
            if (r3 <= 0) goto L60
            if (r3 != r2) goto L60
            kotlin.reflect.KFunction r0 = kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(r0)
            if (r0 != 0) goto L44
            goto Lc8
        L44:
            java.util.List r0 = r0.getParameters()
            if (r0 != 0) goto L4c
            goto Lc8
        L4c:
            int r6 = r6.getIndex()
            java.lang.Object r6 = r0.get(r6)
            kotlin.reflect.KParameter r6 = (kotlin.reflect.KParameter) r6
            if (r6 != 0) goto L5a
            goto Lc8
        L5a:
            java.lang.String r1 = r6.getName()
            goto Lc8
        L60:
            java.lang.String r1 = (java.lang.String) r1
            goto Lc8
        L64:
            boolean r2 = r0 instanceof java.lang.reflect.Method
            if (r2 == 0) goto Lc3
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            kotlin.reflect.KFunction r0 = kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(r0)     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r0 != 0) goto L72
        L70:
            r2 = r1
            goto L86
        L72:
            java.util.List r2 = r0.getParameters()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r2 != 0) goto L79
            goto L70
        L79:
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r2)     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            kotlin.reflect.KParameter r2 = (kotlin.reflect.KParameter) r2     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r2 != 0) goto L82
            goto L70
        L82:
            kotlin.reflect.KParameter$Kind r2 = r2.getKind()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
        L86:
            kotlin.reflect.KParameter$Kind r4 = kotlin.reflect.KParameter.Kind.VALUE     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r2 == r4) goto L91
            int r6 = r6.getIndex()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            int r6 = r6 + 1
            goto L95
        L91:
            int r6 = r6.getIndex()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
        L95:
            if (r0 != 0) goto L98
            goto La3
        L98:
            java.util.List r2 = r0.getParameters()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r2 != 0) goto L9f
            goto La3
        L9f:
            int r3 = r2.size()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
        La3:
            if (r3 <= r6) goto Lbd
            if (r0 != 0) goto La8
            goto Lc8
        La8:
            java.util.List r0 = r0.getParameters()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r0 != 0) goto Laf
            goto Lc8
        Laf:
            java.lang.Object r6 = r0.get(r6)     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            kotlin.reflect.KParameter r6 = (kotlin.reflect.KParameter) r6     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r6 != 0) goto Lb8
            goto Lc8
        Lb8:
            java.lang.String r1 = r6.getName()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            goto Lc8
        Lbd:
            java.lang.String r1 = (java.lang.String) r1     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            goto Lc8
        Lc0:
            java.lang.String r1 = (java.lang.String) r1
            goto Lc8
        Lc3:
            java.lang.String r1 = (java.lang.String) r1
            goto Lc8
        Lc6:
            java.lang.String r1 = (java.lang.String) r1
        Lc8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector.findKotlinParameterName(com.fasterxml.jackson.databind.introspect.AnnotatedParameter):java.lang.String");
    }
}
