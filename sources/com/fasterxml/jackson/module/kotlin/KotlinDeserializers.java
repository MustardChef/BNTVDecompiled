package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.Deserializers;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.Regex;

/* compiled from: KotlinDeserializers.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/KotlinDeserializers;", "Lcom/fasterxml/jackson/databind/deser/Deserializers$Base;", "()V", "findBeanDeserializer", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "type", "Lcom/fasterxml/jackson/databind/JavaType;", "config", "Lcom/fasterxml/jackson/databind/DeserializationConfig;", "beanDesc", "Lcom/fasterxml/jackson/databind/BeanDescription;", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class KotlinDeserializers extends Deserializers.Base {
    @Override // com.fasterxml.jackson.databind.deser.Deserializers.Base, com.fasterxml.jackson.databind.deser.Deserializers
    public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type.isInterface() && Intrinsics.areEqual(type.getRawClass(), Sequence.class)) {
            return SequenceDeserializer.INSTANCE;
        }
        if (Intrinsics.areEqual(type.getRawClass(), Regex.class)) {
            return RegexDeserializer.INSTANCE;
        }
        if (Intrinsics.areEqual(type.getRawClass(), UByte.class)) {
            return UByteDeserializer.INSTANCE;
        }
        if (Intrinsics.areEqual(type.getRawClass(), UShort.class)) {
            return UShortDeserializer.INSTANCE;
        }
        if (Intrinsics.areEqual(type.getRawClass(), UInt.class)) {
            return UIntDeserializer.INSTANCE;
        }
        if (Intrinsics.areEqual(type.getRawClass(), ULong.class)) {
            return ULongDeserializer.INSTANCE;
        }
        return null;
    }
}
