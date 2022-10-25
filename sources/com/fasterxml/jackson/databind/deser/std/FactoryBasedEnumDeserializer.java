package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;

/* loaded from: classes2.dex */
class FactoryBasedEnumDeserializer extends StdDeserializer<Object> implements ContextualDeserializer {
    private static final long serialVersionUID = 1;
    protected final SettableBeanProperty[] _creatorProps;
    protected final JsonDeserializer<?> _deser;
    protected final AnnotatedMethod _factory;
    protected final boolean _hasArgs;
    protected final JavaType _inputType;
    private transient PropertyBasedCreator _propCreator;
    protected final ValueInstantiator _valueInstantiator;

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return true;
    }

    public FactoryBasedEnumDeserializer(Class<?> cls, AnnotatedMethod annotatedMethod, JavaType javaType, ValueInstantiator valueInstantiator, SettableBeanProperty[] settableBeanPropertyArr) {
        super(cls);
        this._factory = annotatedMethod;
        this._hasArgs = true;
        this._inputType = (javaType.hasRawClass(String.class) || javaType.hasRawClass(CharSequence.class)) ? null : javaType;
        this._deser = null;
        this._valueInstantiator = valueInstantiator;
        this._creatorProps = settableBeanPropertyArr;
    }

    public FactoryBasedEnumDeserializer(Class<?> cls, AnnotatedMethod annotatedMethod) {
        super(cls);
        this._factory = annotatedMethod;
        this._hasArgs = false;
        this._inputType = null;
        this._deser = null;
        this._valueInstantiator = null;
        this._creatorProps = null;
    }

    protected FactoryBasedEnumDeserializer(FactoryBasedEnumDeserializer factoryBasedEnumDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(factoryBasedEnumDeserializer._valueClass);
        this._inputType = factoryBasedEnumDeserializer._inputType;
        this._factory = factoryBasedEnumDeserializer._factory;
        this._hasArgs = factoryBasedEnumDeserializer._hasArgs;
        this._valueInstantiator = factoryBasedEnumDeserializer._valueInstantiator;
        this._creatorProps = factoryBasedEnumDeserializer._creatorProps;
        this._deser = jsonDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        return (this._deser == null && this._inputType != null && this._creatorProps == null) ? new FactoryBasedEnumDeserializer(this, deserializationContext.findContextualValueDeserializer(this._inputType, beanProperty)) : this;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.FALSE;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Enum;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object valueAsString;
        JsonDeserializer<?> jsonDeserializer = this._deser;
        if (jsonDeserializer != null) {
            valueAsString = jsonDeserializer.deserialize(jsonParser, deserializationContext);
        } else if (this._hasArgs) {
            if (this._creatorProps != null) {
                if (!jsonParser.isExpectedStartObjectToken()) {
                    JavaType valueType = getValueType(deserializationContext);
                    deserializationContext.reportInputMismatch(valueType, "Input mismatch reading Enum %s: properties-based `@JsonCreator` (%s) expects JSON Object (JsonToken.START_OBJECT), got JsonToken.%s", ClassUtil.getTypeDescription(valueType), this._factory, jsonParser.currentToken());
                }
                if (this._propCreator == null) {
                    this._propCreator = PropertyBasedCreator.construct(deserializationContext, this._valueInstantiator, this._creatorProps, deserializationContext.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
                }
                jsonParser.nextToken();
                return deserializeEnumUsingPropertyBased(jsonParser, deserializationContext, this._propCreator);
            }
            valueAsString = jsonParser.getValueAsString();
        } else {
            jsonParser.skipChildren();
            try {
                return this._factory.call();
            } catch (Exception e) {
                return deserializationContext.handleInstantiationProblem(this._valueClass, null, ClassUtil.throwRootCauseIfIOE(e));
            }
        }
        try {
            return this._factory.callOnWith(this._valueClass, valueAsString);
        } catch (Exception e2) {
            Throwable throwRootCauseIfIOE = ClassUtil.throwRootCauseIfIOE(e2);
            if ((throwRootCauseIfIOE instanceof IllegalArgumentException) && deserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            return deserializationContext.handleInstantiationProblem(this._valueClass, valueAsString, throwRootCauseIfIOE);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        if (this._deser == null) {
            return deserialize(jsonParser, deserializationContext);
        }
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    protected Object deserializeEnumUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext, PropertyBasedCreator propertyBasedCreator) throws IOException {
        PropertyValueBuffer startBuilding = propertyBasedCreator.startBuilding(jsonParser, deserializationContext, null);
        JsonToken currentToken = jsonParser.currentToken();
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.currentName();
            jsonParser.nextToken();
            SettableBeanProperty findCreatorProperty = propertyBasedCreator.findCreatorProperty(currentName);
            if (!startBuilding.readIdProperty(currentName) || findCreatorProperty != null) {
                if (findCreatorProperty != null) {
                    startBuilding.assignParameter(findCreatorProperty, _deserializeWithErrorWrapping(jsonParser, deserializationContext, findCreatorProperty));
                } else {
                    jsonParser.skipChildren();
                }
            }
            currentToken = jsonParser.nextToken();
        }
        return propertyBasedCreator.build(deserializationContext, startBuilding);
    }

    protected final Object _deserializeWithErrorWrapping(JsonParser jsonParser, DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) throws IOException {
        try {
            return settableBeanProperty.deserialize(jsonParser, deserializationContext);
        } catch (Exception e) {
            return wrapAndThrow(e, handledType(), settableBeanProperty.getName(), deserializationContext);
        }
    }

    protected Object wrapAndThrow(Throwable th, Object obj, String str, DeserializationContext deserializationContext) throws IOException {
        throw JsonMappingException.wrapWithPath(throwOrReturnThrowable(th, deserializationContext), obj, str);
    }

    private Throwable throwOrReturnThrowable(Throwable th, DeserializationContext deserializationContext) throws IOException {
        Throwable rootCause = ClassUtil.getRootCause(th);
        ClassUtil.throwIfError(rootCause);
        boolean z = deserializationContext == null || deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS);
        if (rootCause instanceof IOException) {
            if (!z || !(rootCause instanceof JacksonException)) {
                throw ((IOException) rootCause);
            }
        } else if (!z) {
            ClassUtil.throwIfRTE(rootCause);
        }
        return rootCause;
    }
}
