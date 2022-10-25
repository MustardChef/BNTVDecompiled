package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.JsonNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.RegexOption;

/* compiled from: KotlinDeserializers.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, m107d2 = {"<anonymous>", "Lkotlin/text/RegexOption;", "it", "Lcom/fasterxml/jackson/databind/JsonNode;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
final class RegexDeserializer$deserialize$options$1 extends Lambda implements Function1<JsonNode, RegexOption> {
    public static final RegexDeserializer$deserialize$options$1 INSTANCE = new RegexDeserializer$deserialize$options$1();

    RegexDeserializer$deserialize$options$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final RegexOption invoke(JsonNode jsonNode) {
        String asText = jsonNode.asText();
        Intrinsics.checkNotNullExpressionValue(asText, "it.asText()");
        return RegexOption.valueOf(asText);
    }
}
