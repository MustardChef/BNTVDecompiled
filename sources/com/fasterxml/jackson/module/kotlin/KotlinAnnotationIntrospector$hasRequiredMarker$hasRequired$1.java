package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: KotlinAnnotationIntrospector.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m107d2 = {"<anonymous>", "", "it", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
final class KotlinAnnotationIntrospector$hasRequiredMarker$hasRequired$1 extends Lambda implements Function1<AnnotatedMember, Boolean> {

    /* renamed from: $m */
    final /* synthetic */ AnnotatedMember f2802$m;
    final /* synthetic */ KotlinAnnotationIntrospector this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinAnnotationIntrospector$hasRequiredMarker$hasRequired$1(KotlinAnnotationIntrospector kotlinAnnotationIntrospector, AnnotatedMember annotatedMember) {
        super(1);
        this.this$0 = kotlinAnnotationIntrospector;
        this.f2802$m = annotatedMember;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(AnnotatedMember it) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(it, "it");
        Boolean bool = null;
        try {
            z = this.this$0.nullToEmptyCollection;
            if (z && this.f2802$m.getType().isCollectionLikeType()) {
                bool = false;
            } else {
                z2 = this.this$0.nullToEmptyMap;
                if (z2 && this.f2802$m.getType().isMapLikeType()) {
                    bool = false;
                } else {
                    Class<?> declaringClass = this.f2802$m.getMember().getDeclaringClass();
                    Intrinsics.checkNotNullExpressionValue(declaringClass, "m.member.declaringClass");
                    if (KotlinModuleKt.isKotlinClass(declaringClass)) {
                        AnnotatedMember annotatedMember = this.f2802$m;
                        if (annotatedMember instanceof AnnotatedField) {
                            bool = this.this$0.hasRequiredMarker((AnnotatedField) annotatedMember);
                        } else if (annotatedMember instanceof AnnotatedMethod) {
                            bool = this.this$0.hasRequiredMarker((AnnotatedMethod) annotatedMember);
                        } else if (annotatedMember instanceof AnnotatedParameter) {
                            bool = this.this$0.hasRequiredMarker((AnnotatedParameter) annotatedMember);
                        }
                    }
                }
            }
            return bool;
        } catch (UnsupportedOperationException unused) {
            return bool;
        }
    }
}
