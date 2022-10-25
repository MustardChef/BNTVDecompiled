package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.Serializers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinKeySerializers.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/KotlinKeySerializers;", "Lcom/fasterxml/jackson/databind/ser/Serializers$Base;", "()V", "findSerializer", "Lcom/fasterxml/jackson/databind/JsonSerializer;", "config", "Lcom/fasterxml/jackson/databind/SerializationConfig;", "type", "Lcom/fasterxml/jackson/databind/JavaType;", "beanDesc", "Lcom/fasterxml/jackson/databind/BeanDescription;", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class KotlinKeySerializers extends Serializers.Base {
    @Override // com.fasterxml.jackson.databind.ser.Serializers.Base, com.fasterxml.jackson.databind.ser.Serializers
    public JsonSerializer<?> findSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(beanDesc, "beanDesc");
        Class<?> rawClass = type.getRawClass();
        Intrinsics.checkNotNullExpressionValue(rawClass, "type.rawClass");
        if (Extensions.isUnboxableValueClass(rawClass)) {
            return ValueClassUnboxKeySerializer.INSTANCE;
        }
        return null;
    }
}
