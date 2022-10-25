package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: KotlinValueInstantiator.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/KotlinInstantiators;", "Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;", "cache", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "nullToEmptyCollection", "", "nullToEmptyMap", "nullIsSameAsDefault", "strictNullChecks", "(Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;ZZZZ)V", "findValueInstantiator", "Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;", "deserConfig", "Lcom/fasterxml/jackson/databind/DeserializationConfig;", "beanDescriptor", "Lcom/fasterxml/jackson/databind/BeanDescription;", "defaultInstantiator", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class KotlinInstantiators implements ValueInstantiators {
    private final ReflectionCache cache;
    private final boolean nullIsSameAsDefault;
    private final boolean nullToEmptyCollection;
    private final boolean nullToEmptyMap;
    private final boolean strictNullChecks;

    public KotlinInstantiators(ReflectionCache cache, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.cache = cache;
        this.nullToEmptyCollection = z;
        this.nullToEmptyMap = z2;
        this.nullIsSameAsDefault = z3;
        this.strictNullChecks = z4;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiators
    public ValueInstantiator findValueInstantiator(DeserializationConfig deserConfig, BeanDescription beanDescriptor, ValueInstantiator defaultInstantiator) {
        Intrinsics.checkNotNullParameter(deserConfig, "deserConfig");
        Intrinsics.checkNotNullParameter(beanDescriptor, "beanDescriptor");
        Intrinsics.checkNotNullParameter(defaultInstantiator, "defaultInstantiator");
        Class<?> beanClass = beanDescriptor.getBeanClass();
        Intrinsics.checkNotNullExpressionValue(beanClass, "beanDescriptor.beanClass");
        if (KotlinModuleKt.isKotlinClass(beanClass)) {
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(defaultInstantiator.getClass()), Reflection.getOrCreateKotlinClass(StdValueInstantiator.class))) {
                return new KotlinValueInstantiator((StdValueInstantiator) defaultInstantiator, this.cache, this.nullToEmptyCollection, this.nullToEmptyMap, this.nullIsSameAsDefault, this.strictNullChecks);
            }
            throw new IllegalStateException("KotlinValueInstantiator requires that the default ValueInstantiator is StdValueInstantiator");
        }
        return defaultInstantiator;
    }
}
