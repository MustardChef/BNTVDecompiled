package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinKeyDeserializers.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/KotlinKeyDeserializers;", "Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializers;", "()V", "findKeyDeserializer", "Lcom/fasterxml/jackson/databind/KeyDeserializer;", "type", "Lcom/fasterxml/jackson/databind/JavaType;", "config", "Lcom/fasterxml/jackson/databind/DeserializationConfig;", "beanDesc", "Lcom/fasterxml/jackson/databind/BeanDescription;", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class KotlinKeyDeserializers extends StdKeyDeserializers {
    public static final KotlinKeyDeserializers INSTANCE = new KotlinKeyDeserializers();

    private KotlinKeyDeserializers() {
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers, com.fasterxml.jackson.databind.deser.KeyDeserializers
    public KeyDeserializer findKeyDeserializer(JavaType type, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        Intrinsics.checkNotNullParameter(type, "type");
        Class<?> rawClass = type.getRawClass();
        if (Intrinsics.areEqual(rawClass, UByte.class)) {
            return UByteKeyDeserializer.INSTANCE;
        }
        if (Intrinsics.areEqual(rawClass, UShort.class)) {
            return UShortKeyDeserializer.INSTANCE;
        }
        if (Intrinsics.areEqual(rawClass, UInt.class)) {
            return UIntKeyDeserializer.INSTANCE;
        }
        if (Intrinsics.areEqual(rawClass, ULong.class)) {
            return ULongKeyDeserializer.INSTANCE;
        }
        return null;
    }
}
