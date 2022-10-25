package com.fasterxml.jackson.module.kotlin;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;

/* compiled from: KotlinDeserializers.kt */
@Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/RegexDeserializer;", "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;", "Lkotlin/text/Regex;", "()V", "deserialize", TtmlNode.TAG_P, "Lcom/fasterxml/jackson/core/JsonParser;", "ctxt", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class RegexDeserializer extends StdDeserializer<Regex> {
    public static final RegexDeserializer INSTANCE = new RegexDeserializer();

    private RegexDeserializer() {
        super(Regex.class);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Regex deserialize(JsonParser p, DeserializationContext ctxt) {
        Set emptySet;
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(ctxt, "ctxt");
        JsonNode readTree = ctxt.readTree(p);
        if (readTree.isTextual()) {
            String asText = readTree.asText();
            Intrinsics.checkNotNullExpressionValue(asText, "node.asText()");
            return new Regex(asText);
        } else if (readTree.isObject()) {
            String pattern = readTree.get("pattern").asText();
            if (readTree.has(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS)) {
                JsonNode jsonNode = readTree.get(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                if (!jsonNode.isArray()) {
                    throw new IllegalStateException(Intrinsics.stringPlus("Expected an array of strings for RegexOptions, but type was ", readTree.getNodeType()));
                }
                Iterator<JsonNode> elements = jsonNode.elements();
                Intrinsics.checkNotNullExpressionValue(elements, "optionsNode.elements()");
                emptySet = SequencesKt.toSet(SequencesKt.map(SequencesKt.asSequence(elements), RegexDeserializer$deserialize$options$1.INSTANCE));
            } else {
                emptySet = SetsKt.emptySet();
            }
            Intrinsics.checkNotNullExpressionValue(pattern, "pattern");
            return new Regex(pattern, emptySet);
        } else {
            throw new IllegalStateException(Intrinsics.stringPlus("Expected a string or an object to deserialize a Regex, but type was ", readTree.getNodeType()));
        }
    }
}
