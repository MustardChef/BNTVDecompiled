package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface JsonSerializable {

    /* loaded from: classes2.dex */
    public static abstract class Base implements JsonSerializable {
        public boolean isEmpty(SerializerProvider serializerProvider) {
            return false;
        }
    }

    void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException;
}
