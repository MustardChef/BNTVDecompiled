package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class WritableObjectId {
    public final ObjectIdGenerator<?> generator;

    /* renamed from: id */
    public Object f2798id;
    protected boolean idWritten = false;

    public WritableObjectId(ObjectIdGenerator<?> objectIdGenerator) {
        this.generator = objectIdGenerator;
    }

    public boolean writeAsId(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, ObjectIdWriter objectIdWriter) throws IOException {
        if (this.f2798id != null) {
            if (this.idWritten || objectIdWriter.alwaysAsId) {
                if (jsonGenerator.canWriteObjectId()) {
                    jsonGenerator.writeObjectRef(String.valueOf(this.f2798id));
                    return true;
                }
                objectIdWriter.serializer.serialize(this.f2798id, jsonGenerator, serializerProvider);
                return true;
            }
            return false;
        }
        return false;
    }

    public Object generateId(Object obj) {
        if (this.f2798id == null) {
            this.f2798id = this.generator.generateId(obj);
        }
        return this.f2798id;
    }

    public void writeAsField(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, ObjectIdWriter objectIdWriter) throws IOException {
        this.idWritten = true;
        if (jsonGenerator.canWriteObjectId()) {
            Object obj = this.f2798id;
            jsonGenerator.writeObjectId(obj == null ? null : String.valueOf(obj));
            return;
        }
        SerializableString serializableString = objectIdWriter.propertyName;
        if (serializableString != null) {
            jsonGenerator.writeFieldName(serializableString);
            objectIdWriter.serializer.serialize(this.f2798id, jsonGenerator, serializerProvider);
        }
    }
}
