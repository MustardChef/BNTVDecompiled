package com.fasterxml.jackson.module.kotlin;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinModule.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m107d2 = {"metadataFqName", "", "isKotlinClass", "", "Ljava/lang/Class;", "jackson-module-kotlin"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class KotlinModuleKt {
    private static final String metadataFqName = "kotlin.Metadata";

    public static final boolean isKotlinClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "declaredAnnotations");
        for (Annotation annotation : declaredAnnotations) {
            if (Intrinsics.areEqual(JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(annotation)).getName(), metadataFqName)) {
                return true;
            }
        }
        return false;
    }
}
