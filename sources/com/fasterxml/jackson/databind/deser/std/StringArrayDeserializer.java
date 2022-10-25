package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.util.Objects;

@JacksonStdImpl
/* loaded from: classes2.dex */
public final class StringArrayDeserializer extends StdDeserializer<String[]> implements ContextualDeserializer {
    private static final String[] NO_STRINGS = new String[0];
    public static final StringArrayDeserializer instance = new StringArrayDeserializer();
    private static final long serialVersionUID = 2;
    protected JsonDeserializer<String> _elementDeserializer;
    protected final NullValueProvider _nullProvider;
    protected final boolean _skipNullValues;
    protected final Boolean _unwrapSingle;

    public StringArrayDeserializer() {
        this(null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected StringArrayDeserializer(JsonDeserializer<?> jsonDeserializer, NullValueProvider nullValueProvider, Boolean bool) {
        super(String[].class);
        this._elementDeserializer = jsonDeserializer;
        this._nullProvider = nullValueProvider;
        this._unwrapSingle = bool;
        this._skipNullValues = NullsConstantProvider.isSkipper(nullValueProvider);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Array;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return NO_STRINGS;
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        JsonDeserializer<?> handleSecondaryContextualization;
        JsonDeserializer<?> findConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, beanProperty, this._elementDeserializer);
        JavaType constructType = deserializationContext.constructType(String.class);
        if (findConvertingContentDeserializer == null) {
            handleSecondaryContextualization = deserializationContext.findContextualValueDeserializer(constructType, beanProperty);
        } else {
            handleSecondaryContextualization = deserializationContext.handleSecondaryContextualization(findConvertingContentDeserializer, beanProperty, constructType);
        }
        Boolean findFormatFeature = findFormatFeature(deserializationContext, beanProperty, String[].class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        NullValueProvider findContentNullProvider = findContentNullProvider(deserializationContext, beanProperty, handleSecondaryContextualization);
        if (handleSecondaryContextualization != null && isDefaultDeserializer(handleSecondaryContextualization)) {
            handleSecondaryContextualization = null;
        }
        return (this._elementDeserializer == handleSecondaryContextualization && Objects.equals(this._unwrapSingle, findFormatFeature) && this._nullProvider == findContentNullProvider) ? this : new StringArrayDeserializer(handleSecondaryContextualization, findContentNullProvider, findFormatFeature);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int i;
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext);
        }
        if (this._elementDeserializer != null) {
            return _deserializeCustom(jsonParser, deserializationContext, null);
        }
        ObjectBuffer leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] resetAndStart = leaseObjectBuffer.resetAndStart();
        int i2 = 0;
        while (true) {
            try {
                String nextTextValue = jsonParser.nextTextValue();
                try {
                    if (nextTextValue == null) {
                        JsonToken currentToken = jsonParser.currentToken();
                        if (currentToken != JsonToken.END_ARRAY) {
                            if (currentToken == JsonToken.VALUE_NULL) {
                                if (!this._skipNullValues) {
                                    nextTextValue = (String) this._nullProvider.getNullValue(deserializationContext);
                                }
                            } else {
                                nextTextValue = _parseString(jsonParser, deserializationContext);
                            }
                        } else {
                            String[] strArr = (String[]) leaseObjectBuffer.completeAndClearBuffer(resetAndStart, i2, String.class);
                            deserializationContext.returnObjectBuffer(leaseObjectBuffer);
                            return strArr;
                        }
                    }
                    resetAndStart[i2] = nextTextValue;
                    i2 = i;
                } catch (Exception e) {
                    e = e;
                    i2 = i;
                    throw JsonMappingException.wrapWithPath(e, resetAndStart, leaseObjectBuffer.bufferedSize() + i2);
                }
                if (i2 >= resetAndStart.length) {
                    resetAndStart = leaseObjectBuffer.appendCompletedChunk(resetAndStart);
                    i2 = 0;
                }
                i = i2 + 1;
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    protected final String[] _deserializeCustom(JsonParser jsonParser, DeserializationContext deserializationContext, String[] strArr) throws IOException {
        int length;
        Object[] resetAndStart;
        String deserialize;
        int i;
        ObjectBuffer leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        if (strArr == null) {
            resetAndStart = leaseObjectBuffer.resetAndStart();
            length = 0;
        } else {
            length = strArr.length;
            resetAndStart = leaseObjectBuffer.resetAndStart(strArr, length);
        }
        JsonDeserializer<String> jsonDeserializer = this._elementDeserializer;
        while (true) {
            try {
                try {
                    if (jsonParser.nextTextValue() == null) {
                        JsonToken currentToken = jsonParser.currentToken();
                        if (currentToken != JsonToken.END_ARRAY) {
                            if (currentToken == JsonToken.VALUE_NULL) {
                                if (!this._skipNullValues) {
                                    deserialize = (String) this._nullProvider.getNullValue(deserializationContext);
                                }
                            } else {
                                deserialize = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                            }
                        } else {
                            String[] strArr2 = (String[]) leaseObjectBuffer.completeAndClearBuffer(resetAndStart, length, String.class);
                            deserializationContext.returnObjectBuffer(leaseObjectBuffer);
                            return strArr2;
                        }
                    } else {
                        deserialize = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                    }
                    resetAndStart[length] = deserialize;
                    length = i;
                } catch (Exception e) {
                    e = e;
                    length = i;
                    throw JsonMappingException.wrapWithPath(e, String.class, length);
                }
                if (length >= resetAndStart.length) {
                    resetAndStart = leaseObjectBuffer.appendCompletedChunk(resetAndStart);
                    length = 0;
                }
                i = length + 1;
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, String[] strArr) throws IOException {
        if (!jsonParser.isExpectedStartArrayToken()) {
            String[] handleNonArray = handleNonArray(jsonParser, deserializationContext);
            if (handleNonArray == null) {
                return strArr;
            }
            int length = strArr.length;
            String[] strArr2 = new String[handleNonArray.length + length];
            System.arraycopy(strArr, 0, strArr2, 0, length);
            System.arraycopy(handleNonArray, 0, strArr2, length, handleNonArray.length);
            return strArr2;
        } else if (this._elementDeserializer != null) {
            return _deserializeCustom(jsonParser, deserializationContext, strArr);
        } else {
            ObjectBuffer leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
            int length2 = strArr.length;
            Object[] resetAndStart = leaseObjectBuffer.resetAndStart(strArr, length2);
            while (true) {
                try {
                    String nextTextValue = jsonParser.nextTextValue();
                    if (nextTextValue == null) {
                        JsonToken currentToken = jsonParser.currentToken();
                        if (currentToken != JsonToken.END_ARRAY) {
                            if (currentToken == JsonToken.VALUE_NULL) {
                                if (this._skipNullValues) {
                                    return NO_STRINGS;
                                }
                                nextTextValue = (String) this._nullProvider.getNullValue(deserializationContext);
                            } else {
                                nextTextValue = _parseString(jsonParser, deserializationContext);
                            }
                        } else {
                            String[] strArr3 = (String[]) leaseObjectBuffer.completeAndClearBuffer(resetAndStart, length2, String.class);
                            deserializationContext.returnObjectBuffer(leaseObjectBuffer);
                            return strArr3;
                        }
                    }
                    if (length2 >= resetAndStart.length) {
                        resetAndStart = leaseObjectBuffer.appendCompletedChunk(resetAndStart);
                        length2 = 0;
                    }
                    int i = length2 + 1;
                    try {
                        resetAndStart[length2] = nextTextValue;
                        length2 = i;
                    } catch (Exception e) {
                        e = e;
                        length2 = i;
                        throw JsonMappingException.wrapWithPath(e, resetAndStart, leaseObjectBuffer.bufferedSize() + length2);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }
    }

    private final String[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String _parseString;
        if (this._unwrapSingle == Boolean.TRUE || (this._unwrapSingle == null && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            if (jsonParser.hasToken(JsonToken.VALUE_NULL)) {
                _parseString = (String) this._nullProvider.getNullValue(deserializationContext);
            } else {
                _parseString = _parseString(jsonParser, deserializationContext);
            }
            return new String[]{_parseString};
        } else if (jsonParser.hasToken(JsonToken.VALUE_STRING)) {
            return _deserializeFromString(jsonParser, deserializationContext);
        } else {
            return (String[]) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
        }
    }
}
