package com.fasterxml.jackson.module.kotlin;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMapping;

/* compiled from: KotlinBeanDeserializerModifier.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¨\u0006\u0004"}, m107d2 = {"objectSingletonInstance", "", "beanClass", "Ljava/lang/Class;", "jackson-module-kotlin"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class KotlinBeanDeserializerModifierKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object objectSingletonInstance(Class<?> cls) {
        if (KotlinModuleKt.isKotlinClass(cls)) {
            return JvmClassMapping.getKotlinClass(cls).getObjectInstance();
        }
        return null;
    }
}
