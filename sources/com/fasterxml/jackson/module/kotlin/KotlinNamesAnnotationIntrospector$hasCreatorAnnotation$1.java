package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.ReflectJvmMapping;

/* compiled from: KotlinNamesAnnotationIntrospector.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m107d2 = {"<anonymous>", "", "it", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
final class KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$1 extends Lambda implements Function1<AnnotatedConstructor, Boolean> {
    final /* synthetic */ Annotated $member;
    final /* synthetic */ KotlinNamesAnnotationIntrospector this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$1(KotlinNamesAnnotationIntrospector kotlinNamesAnnotationIntrospector, Annotated annotated) {
        super(1);
        this.this$0 = kotlinNamesAnnotationIntrospector;
        this.$member = annotated;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01a8 A[SYNTHETIC] */
    @Override // kotlin.jvm.functions.Function1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean invoke(com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r12) {
        /*
            Method dump skipped, instructions count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$1.invoke(com.fasterxml.jackson.databind.introspect.AnnotatedConstructor):java.lang.Boolean");
    }

    private static final boolean invoke$isPossibleSingleString(KFunction<?> kFunction, Set<String> set) {
        boolean z;
        if (kFunction.getParameters().size() == 1 && !CollectionsKt.contains(set, kFunction.getParameters().get(0).getName()) && Intrinsics.areEqual(ReflectJvmMapping.getJavaType(kFunction.getParameters().get(0).getType()), String.class)) {
            List<Annotation> annotations = kFunction.getParameters().get(0).getAnnotations();
            if (!(annotations instanceof Collection) || !annotations.isEmpty()) {
                for (Annotation annotation : annotations) {
                    if (Intrinsics.areEqual(JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(annotation)), JsonProperty.class)) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static final Collection<KFunction<?>> invoke$filterOutSingleStringCallables(Collection<? extends KFunction<?>> collection, Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (!invoke$isPossibleSingleString((KFunction) obj, set)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
