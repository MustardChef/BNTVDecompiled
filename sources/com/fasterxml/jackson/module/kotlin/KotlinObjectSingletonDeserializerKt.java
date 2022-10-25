package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.JsonDeserializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinObjectSingletonDeserializer.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m107d2 = {"asSingletonDeserializer", "Lcom/fasterxml/jackson/module/kotlin/KotlinObjectSingletonDeserializer;", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "singleton", "", "jackson-module-kotlin"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class KotlinObjectSingletonDeserializerKt {
    public static final KotlinObjectSingletonDeserializer asSingletonDeserializer(JsonDeserializer<?> jsonDeserializer, Object singleton) {
        Intrinsics.checkNotNullParameter(jsonDeserializer, "<this>");
        Intrinsics.checkNotNullParameter(singleton, "singleton");
        return new KotlinObjectSingletonDeserializer(singleton, jsonDeserializer);
    }
}
