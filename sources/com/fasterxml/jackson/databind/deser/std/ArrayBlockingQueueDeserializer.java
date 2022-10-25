package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes2.dex */
public class ArrayBlockingQueueDeserializer extends CollectionDeserializer {
    private static final long serialVersionUID = 1;

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    protected Collection<Object> createDefaultInstance(DeserializationContext deserializationContext) throws IOException {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    protected /* bridge */ /* synthetic */ CollectionDeserializer withResolved(JsonDeserializer jsonDeserializer, JsonDeserializer jsonDeserializer2, TypeDeserializer typeDeserializer, NullValueProvider nullValueProvider, Boolean bool) {
        return withResolved((JsonDeserializer<?>) jsonDeserializer, (JsonDeserializer<?>) jsonDeserializer2, typeDeserializer, nullValueProvider, bool);
    }

    public ArrayBlockingQueueDeserializer(JavaType javaType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, ValueInstantiator valueInstantiator) {
        super(javaType, jsonDeserializer, typeDeserializer, valueInstantiator);
    }

    protected ArrayBlockingQueueDeserializer(JavaType javaType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, ValueInstantiator valueInstantiator, JsonDeserializer<Object> jsonDeserializer2, NullValueProvider nullValueProvider, Boolean bool) {
        super(javaType, jsonDeserializer, typeDeserializer, valueInstantiator, jsonDeserializer2, nullValueProvider, bool);
    }

    protected ArrayBlockingQueueDeserializer(ArrayBlockingQueueDeserializer arrayBlockingQueueDeserializer) {
        super(arrayBlockingQueueDeserializer);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    protected ArrayBlockingQueueDeserializer withResolved(JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, TypeDeserializer typeDeserializer, NullValueProvider nullValueProvider, Boolean bool) {
        return new ArrayBlockingQueueDeserializer(this._containerType, jsonDeserializer2, typeDeserializer, this._valueInstantiator, jsonDeserializer, nullValueProvider, bool);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    public Collection<Object> _deserializeFromArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        Collection<Object> _deserializeFromArray = super._deserializeFromArray(jsonParser, deserializationContext, collection);
        if (_deserializeFromArray.isEmpty()) {
            return new ArrayBlockingQueue(1, false);
        }
        return new ArrayBlockingQueue(_deserializeFromArray.size(), false, _deserializeFromArray);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }
}
