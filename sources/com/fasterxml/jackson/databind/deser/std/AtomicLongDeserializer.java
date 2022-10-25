package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class AtomicLongDeserializer extends StdScalarDeserializer<AtomicLong> {
    private static final long serialVersionUID = 1;

    public AtomicLongDeserializer() {
        super(AtomicLong.class);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public AtomicLong deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.isExpectedNumberIntToken()) {
            return new AtomicLong(jsonParser.getLongValue());
        }
        Long _parseLong = _parseLong(jsonParser, deserializationContext, AtomicLong.class);
        if (_parseLong == null) {
            return null;
        }
        return new AtomicLong(_parseLong.intValue());
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Integer;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return new AtomicLong();
    }
}
