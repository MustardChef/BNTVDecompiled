package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;

@JacksonStdImpl
/* loaded from: classes2.dex */
public class StdValueInstantiator extends ValueInstantiator implements Serializable {
    private static final long serialVersionUID = 1;
    protected SettableBeanProperty[] _arrayDelegateArguments;
    protected AnnotatedWithParams _arrayDelegateCreator;
    protected JavaType _arrayDelegateType;
    protected SettableBeanProperty[] _constructorArguments;
    protected AnnotatedWithParams _defaultCreator;
    protected SettableBeanProperty[] _delegateArguments;
    protected AnnotatedWithParams _delegateCreator;
    protected JavaType _delegateType;
    protected AnnotatedWithParams _fromBigDecimalCreator;
    protected AnnotatedWithParams _fromBigIntegerCreator;
    protected AnnotatedWithParams _fromBooleanCreator;
    protected AnnotatedWithParams _fromDoubleCreator;
    protected AnnotatedWithParams _fromIntCreator;
    protected AnnotatedWithParams _fromLongCreator;
    protected AnnotatedWithParams _fromStringCreator;
    protected final Class<?> _valueClass;
    protected final String _valueTypeDesc;
    protected AnnotatedWithParams _withArgsCreator;

    /* JADX WARN: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r2v0, types: [java.lang.Class<?>, java.lang.Class] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public StdValueInstantiator(com.fasterxml.jackson.databind.DeserializationConfig r1, java.lang.Class r2) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.String r1 = com.fasterxml.jackson.databind.util.ClassUtil.nameOf(r2)
            r0._valueTypeDesc = r1
            if (r2 != 0) goto Ld
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
        Ld:
            r0._valueClass = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdValueInstantiator.<init>(com.fasterxml.jackson.databind.DeserializationConfig, java.lang.Class):void");
    }

    public StdValueInstantiator(DeserializationConfig deserializationConfig, JavaType javaType) {
        this._valueTypeDesc = javaType == null ? "UNKNOWN TYPE" : javaType.toString();
        this._valueClass = javaType == null ? Object.class : javaType.getRawClass();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StdValueInstantiator(StdValueInstantiator stdValueInstantiator) {
        this._valueTypeDesc = stdValueInstantiator._valueTypeDesc;
        this._valueClass = stdValueInstantiator._valueClass;
        this._defaultCreator = stdValueInstantiator._defaultCreator;
        this._constructorArguments = stdValueInstantiator._constructorArguments;
        this._withArgsCreator = stdValueInstantiator._withArgsCreator;
        this._delegateType = stdValueInstantiator._delegateType;
        this._delegateCreator = stdValueInstantiator._delegateCreator;
        this._delegateArguments = stdValueInstantiator._delegateArguments;
        this._arrayDelegateType = stdValueInstantiator._arrayDelegateType;
        this._arrayDelegateCreator = stdValueInstantiator._arrayDelegateCreator;
        this._arrayDelegateArguments = stdValueInstantiator._arrayDelegateArguments;
        this._fromStringCreator = stdValueInstantiator._fromStringCreator;
        this._fromIntCreator = stdValueInstantiator._fromIntCreator;
        this._fromLongCreator = stdValueInstantiator._fromLongCreator;
        this._fromBigIntegerCreator = stdValueInstantiator._fromBigIntegerCreator;
        this._fromDoubleCreator = stdValueInstantiator._fromDoubleCreator;
        this._fromBigDecimalCreator = stdValueInstantiator._fromBigDecimalCreator;
        this._fromBooleanCreator = stdValueInstantiator._fromBooleanCreator;
    }

    public void configureFromObjectSettings(AnnotatedWithParams annotatedWithParams, AnnotatedWithParams annotatedWithParams2, JavaType javaType, SettableBeanProperty[] settableBeanPropertyArr, AnnotatedWithParams annotatedWithParams3, SettableBeanProperty[] settableBeanPropertyArr2) {
        this._defaultCreator = annotatedWithParams;
        this._delegateCreator = annotatedWithParams2;
        this._delegateType = javaType;
        this._delegateArguments = settableBeanPropertyArr;
        this._withArgsCreator = annotatedWithParams3;
        this._constructorArguments = settableBeanPropertyArr2;
    }

    public void configureFromArraySettings(AnnotatedWithParams annotatedWithParams, JavaType javaType, SettableBeanProperty[] settableBeanPropertyArr) {
        this._arrayDelegateCreator = annotatedWithParams;
        this._arrayDelegateType = javaType;
        this._arrayDelegateArguments = settableBeanPropertyArr;
    }

    public void configureFromStringCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromStringCreator = annotatedWithParams;
    }

    public void configureFromIntCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromIntCreator = annotatedWithParams;
    }

    public void configureFromLongCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromLongCreator = annotatedWithParams;
    }

    public void configureFromBigIntegerCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromBigIntegerCreator = annotatedWithParams;
    }

    public void configureFromDoubleCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromDoubleCreator = annotatedWithParams;
    }

    public void configureFromBigDecimalCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromBigDecimalCreator = annotatedWithParams;
    }

    public void configureFromBooleanCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromBooleanCreator = annotatedWithParams;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public String getValueTypeDesc() {
        return this._valueTypeDesc;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Class<?> getValueClass() {
        return this._valueClass;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromString() {
        return this._fromStringCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromInt() {
        return this._fromIntCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromLong() {
        return this._fromLongCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromBigInteger() {
        return this._fromBigIntegerCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromDouble() {
        return this._fromDoubleCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromBigDecimal() {
        return this._fromBigDecimalCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromBoolean() {
        return this._fromBooleanCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateUsingDefault() {
        return this._defaultCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateUsingDelegate() {
        return this._delegateType != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateUsingArrayDelegate() {
        return this._arrayDelegateType != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromObjectWith() {
        return this._withArgsCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canInstantiate() {
        return canCreateUsingDefault() || canCreateUsingDelegate() || canCreateUsingArrayDelegate() || canCreateFromObjectWith() || canCreateFromString() || canCreateFromInt() || canCreateFromLong() || canCreateFromDouble() || canCreateFromBoolean();
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public JavaType getDelegateType(DeserializationConfig deserializationConfig) {
        return this._delegateType;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public JavaType getArrayDelegateType(DeserializationConfig deserializationConfig) {
        return this._arrayDelegateType;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig deserializationConfig) {
        return this._constructorArguments;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createUsingDefault(DeserializationContext deserializationContext) throws IOException {
        AnnotatedWithParams annotatedWithParams = this._defaultCreator;
        if (annotatedWithParams == null) {
            return super.createUsingDefault(deserializationContext);
        }
        try {
            return annotatedWithParams.call();
        } catch (Exception e) {
            return deserializationContext.handleInstantiationProblem(this._valueClass, null, rewrapCtorProblem(deserializationContext, e));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromObjectWith(DeserializationContext deserializationContext, Object[] objArr) throws IOException {
        AnnotatedWithParams annotatedWithParams = this._withArgsCreator;
        if (annotatedWithParams == null) {
            return super.createFromObjectWith(deserializationContext, objArr);
        }
        try {
            return annotatedWithParams.call(objArr);
        } catch (Exception e) {
            return deserializationContext.handleInstantiationProblem(this._valueClass, objArr, rewrapCtorProblem(deserializationContext, e));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createUsingDelegate(DeserializationContext deserializationContext, Object obj) throws IOException {
        AnnotatedWithParams annotatedWithParams;
        AnnotatedWithParams annotatedWithParams2 = this._delegateCreator;
        if (annotatedWithParams2 == null && (annotatedWithParams = this._arrayDelegateCreator) != null) {
            return _createUsingDelegate(annotatedWithParams, this._arrayDelegateArguments, deserializationContext, obj);
        }
        return _createUsingDelegate(annotatedWithParams2, this._delegateArguments, deserializationContext, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createUsingArrayDelegate(DeserializationContext deserializationContext, Object obj) throws IOException {
        AnnotatedWithParams annotatedWithParams = this._arrayDelegateCreator;
        if (annotatedWithParams == null && this._delegateCreator != null) {
            return createUsingDelegate(deserializationContext, obj);
        }
        return _createUsingDelegate(annotatedWithParams, this._arrayDelegateArguments, deserializationContext, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromString(DeserializationContext deserializationContext, String str) throws IOException {
        AnnotatedWithParams annotatedWithParams = this._fromStringCreator;
        if (annotatedWithParams != null) {
            try {
                return annotatedWithParams.call1(str);
            } catch (Throwable th) {
                return deserializationContext.handleInstantiationProblem(this._fromStringCreator.getDeclaringClass(), str, rewrapCtorProblem(deserializationContext, th));
            }
        }
        return super.createFromString(deserializationContext, str);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromInt(DeserializationContext deserializationContext, int i) throws IOException {
        if (this._fromIntCreator != null) {
            Integer valueOf = Integer.valueOf(i);
            try {
                return this._fromIntCreator.call1(valueOf);
            } catch (Throwable th) {
                return deserializationContext.handleInstantiationProblem(this._fromIntCreator.getDeclaringClass(), valueOf, rewrapCtorProblem(deserializationContext, th));
            }
        } else if (this._fromLongCreator != null) {
            Long valueOf2 = Long.valueOf(i);
            try {
                return this._fromLongCreator.call1(valueOf2);
            } catch (Throwable th2) {
                return deserializationContext.handleInstantiationProblem(this._fromLongCreator.getDeclaringClass(), valueOf2, rewrapCtorProblem(deserializationContext, th2));
            }
        } else if (this._fromBigIntegerCreator != null) {
            BigInteger valueOf3 = BigInteger.valueOf(i);
            try {
                return this._fromBigIntegerCreator.call1(valueOf3);
            } catch (Throwable th3) {
                return deserializationContext.handleInstantiationProblem(this._fromBigIntegerCreator.getDeclaringClass(), valueOf3, rewrapCtorProblem(deserializationContext, th3));
            }
        } else {
            return super.createFromInt(deserializationContext, i);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromLong(DeserializationContext deserializationContext, long j) throws IOException {
        if (this._fromLongCreator != null) {
            Long valueOf = Long.valueOf(j);
            try {
                return this._fromLongCreator.call1(valueOf);
            } catch (Throwable th) {
                return deserializationContext.handleInstantiationProblem(this._fromLongCreator.getDeclaringClass(), valueOf, rewrapCtorProblem(deserializationContext, th));
            }
        } else if (this._fromBigIntegerCreator != null) {
            BigInteger valueOf2 = BigInteger.valueOf(j);
            try {
                return this._fromBigIntegerCreator.call1(valueOf2);
            } catch (Throwable th2) {
                return deserializationContext.handleInstantiationProblem(this._fromBigIntegerCreator.getDeclaringClass(), valueOf2, rewrapCtorProblem(deserializationContext, th2));
            }
        } else {
            return super.createFromLong(deserializationContext, j);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromBigInteger(DeserializationContext deserializationContext, BigInteger bigInteger) throws IOException {
        AnnotatedWithParams annotatedWithParams = this._fromBigIntegerCreator;
        if (annotatedWithParams != null) {
            try {
                return annotatedWithParams.call1(bigInteger);
            } catch (Throwable th) {
                return deserializationContext.handleInstantiationProblem(this._fromBigIntegerCreator.getDeclaringClass(), bigInteger, rewrapCtorProblem(deserializationContext, th));
            }
        }
        return super.createFromBigInteger(deserializationContext, bigInteger);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromDouble(DeserializationContext deserializationContext, double d) throws IOException {
        if (this._fromDoubleCreator != null) {
            Double valueOf = Double.valueOf(d);
            try {
                return this._fromDoubleCreator.call1(valueOf);
            } catch (Throwable th) {
                return deserializationContext.handleInstantiationProblem(this._fromDoubleCreator.getDeclaringClass(), valueOf, rewrapCtorProblem(deserializationContext, th));
            }
        } else if (this._fromBigDecimalCreator != null) {
            BigDecimal valueOf2 = BigDecimal.valueOf(d);
            try {
                return this._fromBigDecimalCreator.call1(valueOf2);
            } catch (Throwable th2) {
                return deserializationContext.handleInstantiationProblem(this._fromBigDecimalCreator.getDeclaringClass(), valueOf2, rewrapCtorProblem(deserializationContext, th2));
            }
        } else {
            return super.createFromDouble(deserializationContext, d);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromBigDecimal(DeserializationContext deserializationContext, BigDecimal bigDecimal) throws IOException {
        Double tryConvertToDouble;
        AnnotatedWithParams annotatedWithParams = this._fromBigDecimalCreator;
        if (annotatedWithParams != null) {
            try {
                return annotatedWithParams.call1(bigDecimal);
            } catch (Throwable th) {
                return deserializationContext.handleInstantiationProblem(this._fromBigDecimalCreator.getDeclaringClass(), bigDecimal, rewrapCtorProblem(deserializationContext, th));
            }
        } else if (this._fromDoubleCreator != null && (tryConvertToDouble = tryConvertToDouble(bigDecimal)) != null) {
            try {
                return this._fromDoubleCreator.call1(tryConvertToDouble);
            } catch (Throwable th2) {
                return deserializationContext.handleInstantiationProblem(this._fromDoubleCreator.getDeclaringClass(), tryConvertToDouble, rewrapCtorProblem(deserializationContext, th2));
            }
        } else {
            return super.createFromBigDecimal(deserializationContext, bigDecimal);
        }
    }

    static Double tryConvertToDouble(BigDecimal bigDecimal) {
        double doubleValue = bigDecimal.doubleValue();
        if (Double.isInfinite(doubleValue)) {
            return null;
        }
        return Double.valueOf(doubleValue);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromBoolean(DeserializationContext deserializationContext, boolean z) throws IOException {
        if (this._fromBooleanCreator == null) {
            return super.createFromBoolean(deserializationContext, z);
        }
        Boolean valueOf = Boolean.valueOf(z);
        try {
            return this._fromBooleanCreator.call1(valueOf);
        } catch (Throwable th) {
            return deserializationContext.handleInstantiationProblem(this._fromBooleanCreator.getDeclaringClass(), valueOf, rewrapCtorProblem(deserializationContext, th));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public AnnotatedWithParams getDelegateCreator() {
        return this._delegateCreator;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public AnnotatedWithParams getArrayDelegateCreator() {
        return this._arrayDelegateCreator;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public AnnotatedWithParams getDefaultCreator() {
        return this._defaultCreator;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public AnnotatedWithParams getWithArgsCreator() {
        return this._withArgsCreator;
    }

    @Deprecated
    protected JsonMappingException wrapException(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof JsonMappingException) {
                return (JsonMappingException) th2;
            }
        }
        return new JsonMappingException((Closeable) null, "Instantiation of " + getValueTypeDesc() + " value failed: " + ClassUtil.exceptionMessage(th), th);
    }

    @Deprecated
    protected JsonMappingException unwrapAndWrapException(DeserializationContext deserializationContext, Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof JsonMappingException) {
                return (JsonMappingException) th2;
            }
        }
        return deserializationContext.instantiationException(getValueClass(), th);
    }

    protected JsonMappingException wrapAsJsonMappingException(DeserializationContext deserializationContext, Throwable th) {
        if (th instanceof JsonMappingException) {
            return (JsonMappingException) th;
        }
        return deserializationContext.instantiationException(getValueClass(), th);
    }

    protected JsonMappingException rewrapCtorProblem(DeserializationContext deserializationContext, Throwable th) {
        Throwable cause;
        if (((th instanceof ExceptionInInitializerError) || (th instanceof InvocationTargetException)) && (cause = th.getCause()) != null) {
            th = cause;
        }
        return wrapAsJsonMappingException(deserializationContext, th);
    }

    private Object _createUsingDelegate(AnnotatedWithParams annotatedWithParams, SettableBeanProperty[] settableBeanPropertyArr, DeserializationContext deserializationContext, Object obj) throws IOException {
        if (annotatedWithParams == null) {
            throw new IllegalStateException("No delegate constructor for " + getValueTypeDesc());
        }
        try {
            if (settableBeanPropertyArr == null) {
                return annotatedWithParams.call1(obj);
            }
            int length = settableBeanPropertyArr.length;
            Object[] objArr = new Object[length];
            for (int i = 0; i < length; i++) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
                if (settableBeanProperty == null) {
                    objArr[i] = obj;
                } else {
                    objArr[i] = deserializationContext.findInjectableValue(settableBeanProperty.getInjectableValueId(), settableBeanProperty, null);
                }
            }
            return annotatedWithParams.call(objArr);
        } catch (Throwable th) {
            throw rewrapCtorProblem(deserializationContext, th);
        }
    }
}
