package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.Serializers;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: KotlinSerializers.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/KotlinSerializers;", "Lcom/fasterxml/jackson/databind/ser/Serializers$Base;", "()V", "findSerializer", "Lcom/fasterxml/jackson/databind/JsonSerializer;", "config", "Lcom/fasterxml/jackson/databind/SerializationConfig;", "type", "Lcom/fasterxml/jackson/databind/JavaType;", "beanDesc", "Lcom/fasterxml/jackson/databind/BeanDescription;", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class KotlinSerializers extends Serializers.Base {
    @Override // com.fasterxml.jackson.databind.ser.Serializers.Base, com.fasterxml.jackson.databind.ser.Serializers
    public JsonSerializer<?> findSerializer(SerializationConfig serializationConfig, JavaType type, BeanDescription beanDescription) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Sequence.class.isAssignableFrom(type.getRawClass())) {
            return SequenceSerializer.INSTANCE;
        }
        if (UByte.class.isAssignableFrom(type.getRawClass())) {
            return UByteSerializer.INSTANCE;
        }
        if (UShort.class.isAssignableFrom(type.getRawClass())) {
            return UShortSerializer.INSTANCE;
        }
        if (UInt.class.isAssignableFrom(type.getRawClass())) {
            return UIntSerializer.INSTANCE;
        }
        if (ULong.class.isAssignableFrom(type.getRawClass())) {
            return ULongSerializer.INSTANCE;
        }
        Class<?> rawClass = type.getRawClass();
        Intrinsics.checkNotNullExpressionValue(rawClass, "type.rawClass");
        if (Extensions.isUnboxableValueClass(rawClass)) {
            return ValueClassUnboxSerializer.INSTANCE;
        }
        return null;
    }
}
