package com.fasterxml.jackson.databind.deser;

import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public abstract class ValueInstantiator {

    /* loaded from: classes2.dex */
    public interface Gettable {
        ValueInstantiator getValueInstantiator();
    }

    public boolean canCreateFromBigDecimal() {
        return false;
    }

    public boolean canCreateFromBigInteger() {
        return false;
    }

    public boolean canCreateFromBoolean() {
        return false;
    }

    public boolean canCreateFromDouble() {
        return false;
    }

    public boolean canCreateFromInt() {
        return false;
    }

    public boolean canCreateFromLong() {
        return false;
    }

    public boolean canCreateFromObjectWith() {
        return false;
    }

    public boolean canCreateFromString() {
        return false;
    }

    public boolean canCreateUsingArrayDelegate() {
        return false;
    }

    public boolean canCreateUsingDelegate() {
        return false;
    }

    public ValueInstantiator createContextual(DeserializationContext deserializationContext, BeanDescription beanDescription) throws JsonMappingException {
        return this;
    }

    public AnnotatedWithParams getArrayDelegateCreator() {
        return null;
    }

    public JavaType getArrayDelegateType(DeserializationConfig deserializationConfig) {
        return null;
    }

    public AnnotatedWithParams getDefaultCreator() {
        return null;
    }

    public AnnotatedWithParams getDelegateCreator() {
        return null;
    }

    public JavaType getDelegateType(DeserializationConfig deserializationConfig) {
        return null;
    }

    public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig deserializationConfig) {
        return null;
    }

    public AnnotatedWithParams getWithArgsCreator() {
        return null;
    }

    public Class<?> getValueClass() {
        return Object.class;
    }

    public String getValueTypeDesc() {
        Class<?> valueClass = getValueClass();
        return valueClass == null ? "UNKNOWN" : valueClass.getName();
    }

    public boolean canInstantiate() {
        return canCreateUsingDefault() || canCreateUsingDelegate() || canCreateUsingArrayDelegate() || canCreateFromObjectWith() || canCreateFromString() || canCreateFromInt() || canCreateFromLong() || canCreateFromDouble() || canCreateFromBoolean();
    }

    public boolean canCreateUsingDefault() {
        return getDefaultCreator() != null;
    }

    public Object createUsingDefault(DeserializationContext deserializationContext) throws IOException {
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, null, "no default no-arguments constructor found", new Object[0]);
    }

    public Object createFromObjectWith(DeserializationContext deserializationContext, Object[] objArr) throws IOException {
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, null, "no creator with arguments specified", new Object[0]);
    }

    public Object createFromObjectWith(DeserializationContext deserializationContext, SettableBeanProperty[] settableBeanPropertyArr, PropertyValueBuffer propertyValueBuffer) throws IOException {
        return createFromObjectWith(deserializationContext, propertyValueBuffer.getParameters(settableBeanPropertyArr));
    }

    public Object createUsingDelegate(DeserializationContext deserializationContext, Object obj) throws IOException {
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, null, "no delegate creator specified", new Object[0]);
    }

    public Object createUsingArrayDelegate(DeserializationContext deserializationContext, Object obj) throws IOException {
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, null, "no array delegate creator specified", new Object[0]);
    }

    public Object createFromString(DeserializationContext deserializationContext, String str) throws IOException {
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, deserializationContext.getParser(), "no String-argument constructor/factory method to deserialize from String value ('%s')", str);
    }

    public Object createFromInt(DeserializationContext deserializationContext, int i) throws IOException {
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, null, "no int/Int-argument constructor/factory method to deserialize from Number value (%s)", Integer.valueOf(i));
    }

    public Object createFromLong(DeserializationContext deserializationContext, long j) throws IOException {
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, null, "no long/Long-argument constructor/factory method to deserialize from Number value (%s)", Long.valueOf(j));
    }

    public Object createFromBigInteger(DeserializationContext deserializationContext, BigInteger bigInteger) throws IOException {
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, null, "no BigInteger-argument constructor/factory method to deserialize from Number value (%s)", bigInteger);
    }

    public Object createFromDouble(DeserializationContext deserializationContext, double d) throws IOException {
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, null, "no double/Double-argument constructor/factory method to deserialize from Number value (%s)", Double.valueOf(d));
    }

    public Object createFromBigDecimal(DeserializationContext deserializationContext, BigDecimal bigDecimal) throws IOException {
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, null, "no BigDecimal/double/Double-argument constructor/factory method to deserialize from Number value (%s)", bigDecimal);
    }

    public Object createFromBoolean(DeserializationContext deserializationContext, boolean z) throws IOException {
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, null, "no boolean/Boolean-argument constructor/factory method to deserialize from boolean value (%s)", Boolean.valueOf(z));
    }

    @Deprecated
    protected Object _createFromStringFallbacks(DeserializationContext deserializationContext, String str) throws IOException {
        if (str.isEmpty() && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) {
            return null;
        }
        if (canCreateFromBoolean() && deserializationContext.findCoercionAction(LogicalType.Boolean, Boolean.class, CoercionInputShape.String) == CoercionAction.TryConvert) {
            String trim = str.trim();
            if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(trim)) {
                return createFromBoolean(deserializationContext, true);
            }
            if ("false".equals(trim)) {
                return createFromBoolean(deserializationContext, false);
            }
        }
        return deserializationContext.handleMissingInstantiator(getValueClass(), this, deserializationContext.getParser(), "no String-argument constructor/factory method to deserialize from String value ('%s')", str);
    }

    /* loaded from: classes2.dex */
    public static class Base extends ValueInstantiator implements Serializable {
        private static final long serialVersionUID = 1;
        protected final Class<?> _valueType;

        public Base(Class<?> cls) {
            this._valueType = cls;
        }

        public Base(JavaType javaType) {
            this._valueType = javaType.getRawClass();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public String getValueTypeDesc() {
            return this._valueType.getName();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Class<?> getValueClass() {
            return this._valueType;
        }
    }

    /* loaded from: classes2.dex */
    public static class Delegating extends ValueInstantiator implements Serializable {
        private static final long serialVersionUID = 1;
        protected final ValueInstantiator _delegate;

        protected Delegating(ValueInstantiator valueInstantiator) {
            this._delegate = valueInstantiator;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public ValueInstantiator createContextual(DeserializationContext deserializationContext, BeanDescription beanDescription) throws JsonMappingException {
            ValueInstantiator createContextual = this._delegate.createContextual(deserializationContext, beanDescription);
            return createContextual == this._delegate ? this : new Delegating(createContextual);
        }

        protected ValueInstantiator delegate() {
            return this._delegate;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Class<?> getValueClass() {
            return delegate().getValueClass();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public String getValueTypeDesc() {
            return delegate().getValueTypeDesc();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canInstantiate() {
            return delegate().canInstantiate();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateFromString() {
            return delegate().canCreateFromString();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateFromInt() {
            return delegate().canCreateFromInt();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateFromLong() {
            return delegate().canCreateFromLong();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateFromDouble() {
            return delegate().canCreateFromDouble();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateFromBoolean() {
            return delegate().canCreateFromBoolean();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateUsingDefault() {
            return delegate().canCreateUsingDefault();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateUsingDelegate() {
            return delegate().canCreateUsingDelegate();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateUsingArrayDelegate() {
            return delegate().canCreateUsingArrayDelegate();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateFromObjectWith() {
            return delegate().canCreateFromObjectWith();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig deserializationConfig) {
            return delegate().getFromObjectArguments(deserializationConfig);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public JavaType getDelegateType(DeserializationConfig deserializationConfig) {
            return delegate().getDelegateType(deserializationConfig);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public JavaType getArrayDelegateType(DeserializationConfig deserializationConfig) {
            return delegate().getArrayDelegateType(deserializationConfig);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) throws IOException {
            return delegate().createUsingDefault(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createFromObjectWith(DeserializationContext deserializationContext, Object[] objArr) throws IOException {
            return delegate().createFromObjectWith(deserializationContext, objArr);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createFromObjectWith(DeserializationContext deserializationContext, SettableBeanProperty[] settableBeanPropertyArr, PropertyValueBuffer propertyValueBuffer) throws IOException {
            return delegate().createFromObjectWith(deserializationContext, settableBeanPropertyArr, propertyValueBuffer);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDelegate(DeserializationContext deserializationContext, Object obj) throws IOException {
            return delegate().createUsingDelegate(deserializationContext, obj);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingArrayDelegate(DeserializationContext deserializationContext, Object obj) throws IOException {
            return delegate().createUsingArrayDelegate(deserializationContext, obj);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createFromString(DeserializationContext deserializationContext, String str) throws IOException {
            return delegate().createFromString(deserializationContext, str);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createFromInt(DeserializationContext deserializationContext, int i) throws IOException {
            return delegate().createFromInt(deserializationContext, i);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createFromLong(DeserializationContext deserializationContext, long j) throws IOException {
            return delegate().createFromLong(deserializationContext, j);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createFromBigInteger(DeserializationContext deserializationContext, BigInteger bigInteger) throws IOException {
            return delegate().createFromBigInteger(deserializationContext, bigInteger);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createFromDouble(DeserializationContext deserializationContext, double d) throws IOException {
            return delegate().createFromDouble(deserializationContext, d);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createFromBigDecimal(DeserializationContext deserializationContext, BigDecimal bigDecimal) throws IOException {
            return delegate().createFromBigDecimal(deserializationContext, bigDecimal);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createFromBoolean(DeserializationContext deserializationContext, boolean z) throws IOException {
            return delegate().createFromBoolean(deserializationContext, z);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public AnnotatedWithParams getDefaultCreator() {
            return delegate().getDefaultCreator();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public AnnotatedWithParams getDelegateCreator() {
            return delegate().getDelegateCreator();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public AnnotatedWithParams getArrayDelegateCreator() {
            return delegate().getArrayDelegateCreator();
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public AnnotatedWithParams getWithArgsCreator() {
            return delegate().getWithArgsCreator();
        }
    }
}
