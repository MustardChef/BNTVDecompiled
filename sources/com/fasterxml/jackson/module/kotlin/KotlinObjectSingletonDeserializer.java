package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinObjectSingletonDeserializer.kt */
@Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00012\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/KotlinObjectSingletonDeserializer;", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "", "Lcom/fasterxml/jackson/databind/deser/ContextualDeserializer;", "Lcom/fasterxml/jackson/databind/deser/ResolvableDeserializer;", "singletonInstance", "defaultDeserializer", "(Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JsonDeserializer;)V", "createContextual", "ctxt", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "property", "Lcom/fasterxml/jackson/databind/BeanProperty;", "deserialize", TtmlNode.TAG_P, "Lcom/fasterxml/jackson/core/JsonParser;", "resolve", "", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class KotlinObjectSingletonDeserializer extends JsonDeserializer<Object> implements ContextualDeserializer, ResolvableDeserializer {
    private final JsonDeserializer<?> defaultDeserializer;
    private final Object singletonInstance;

    public KotlinObjectSingletonDeserializer(Object singletonInstance, JsonDeserializer<?> defaultDeserializer) {
        Intrinsics.checkNotNullParameter(singletonInstance, "singletonInstance");
        Intrinsics.checkNotNullParameter(defaultDeserializer, "defaultDeserializer");
        this.singletonInstance = singletonInstance;
        this.defaultDeserializer = defaultDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.ResolvableDeserializer
    public void resolve(DeserializationContext deserializationContext) {
        JsonDeserializer<?> jsonDeserializer = this.defaultDeserializer;
        if (jsonDeserializer instanceof ResolvableDeserializer) {
            ((ResolvableDeserializer) jsonDeserializer).resolve(deserializationContext);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer<?> jsonDeserializer = this.defaultDeserializer;
        if (jsonDeserializer instanceof ContextualDeserializer) {
            JsonDeserializer<?> createContextual = ((ContextualDeserializer) jsonDeserializer).createContextual(deserializationContext, beanProperty);
            Intrinsics.checkNotNullExpressionValue(createContextual, "defaultDeserializer.crea…ontextual(ctxt, property)");
            return KotlinObjectSingletonDeserializerKt.asSingletonDeserializer(createContextual, this.singletonInstance);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser p, DeserializationContext ctxt) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(ctxt, "ctxt");
        this.defaultDeserializer.deserialize(p, ctxt);
        return this.singletonInstance;
    }
}
