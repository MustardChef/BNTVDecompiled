package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinDeserializers.kt */
@Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, m107d2 = {"Lcom/fasterxml/jackson/module/kotlin/ULongDeserializer;", "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;", "Lkotlin/ULong;", "()V", "deserialize", TtmlNode.TAG_P, "Lcom/fasterxml/jackson/core/JsonParser;", "ctxt", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "deserialize-ZIaKswc", "(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)J", "jackson-module-kotlin"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
public final class ULongDeserializer extends StdDeserializer<ULong> {
    public static final ULongDeserializer INSTANCE = new ULongDeserializer();

    private ULongDeserializer() {
        super(ULong.class);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public /* bridge */ /* synthetic */ Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return ULong.m9232boximpl(m8563deserializeZIaKswc(jsonParser, deserializationContext));
    }

    /* renamed from: deserialize-ZIaKswc  reason: not valid java name */
    public long m8563deserializeZIaKswc(JsonParser p, DeserializationContext ctxt) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(ctxt, "ctxt");
        BigInteger bigIntegerValue = p.getBigIntegerValue();
        Intrinsics.checkNotNullExpressionValue(bigIntegerValue, "p.bigIntegerValue");
        ULong asULong = UnsignedNumbers.asULong(bigIntegerValue);
        if (asULong != null) {
            return asULong.m9289unboximpl();
        }
        throw new InputCoercionException(p, "Numeric value (" + ((Object) p.getText()) + ") out of range of ULong (0 - 18446744073709551615).", JsonToken.VALUE_NUMBER_INT, ULong.class);
    }
}
