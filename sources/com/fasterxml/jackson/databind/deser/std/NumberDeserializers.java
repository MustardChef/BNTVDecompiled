package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.p033io.NumberInput;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class NumberDeserializers {
    private static final HashSet<String> _classNames = new HashSet<>();

    static {
        Class[] clsArr = {Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class};
        for (int i = 0; i < 11; i++) {
            _classNames.add(clsArr[i].getName());
        }
    }

    public static JsonDeserializer<?> find(Class<?> cls, String str) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return IntegerDeserializer.primitiveInstance;
            }
            if (cls == Boolean.TYPE) {
                return BooleanDeserializer.primitiveInstance;
            }
            if (cls == Long.TYPE) {
                return LongDeserializer.primitiveInstance;
            }
            if (cls == Double.TYPE) {
                return DoubleDeserializer.primitiveInstance;
            }
            if (cls == Character.TYPE) {
                return CharacterDeserializer.primitiveInstance;
            }
            if (cls == Byte.TYPE) {
                return ByteDeserializer.primitiveInstance;
            }
            if (cls == Short.TYPE) {
                return ShortDeserializer.primitiveInstance;
            }
            if (cls == Float.TYPE) {
                return FloatDeserializer.primitiveInstance;
            }
            if (cls == Void.TYPE) {
                return NullifyingDeserializer.instance;
            }
        } else if (!_classNames.contains(str)) {
            return null;
        } else {
            if (cls == Integer.class) {
                return IntegerDeserializer.wrapperInstance;
            }
            if (cls == Boolean.class) {
                return BooleanDeserializer.wrapperInstance;
            }
            if (cls == Long.class) {
                return LongDeserializer.wrapperInstance;
            }
            if (cls == Double.class) {
                return DoubleDeserializer.wrapperInstance;
            }
            if (cls == Character.class) {
                return CharacterDeserializer.wrapperInstance;
            }
            if (cls == Byte.class) {
                return ByteDeserializer.wrapperInstance;
            }
            if (cls == Short.class) {
                return ShortDeserializer.wrapperInstance;
            }
            if (cls == Float.class) {
                return FloatDeserializer.wrapperInstance;
            }
            if (cls == Number.class) {
                return NumberDeserializer.instance;
            }
            if (cls == BigDecimal.class) {
                return BigDecimalDeserializer.instance;
            }
            if (cls == BigInteger.class) {
                return BigIntegerDeserializer.instance;
            }
        }
        throw new IllegalArgumentException("Internal error: can't find deserializer for " + cls.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static abstract class PrimitiveOrWrapperDeserializer<T> extends StdScalarDeserializer<T> {
        private static final long serialVersionUID = 1;
        protected final T _emptyValue;
        protected final LogicalType _logicalType;
        protected final T _nullValue;
        protected final boolean _primitive;

        protected PrimitiveOrWrapperDeserializer(Class<T> cls, LogicalType logicalType, T t, T t2) {
            super((Class<?>) cls);
            this._logicalType = logicalType;
            this._nullValue = t;
            this._emptyValue = t2;
            this._primitive = cls.isPrimitive();
        }

        @Deprecated
        protected PrimitiveOrWrapperDeserializer(Class<T> cls, T t, T t2) {
            this(cls, LogicalType.OtherScalar, t, t2);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
        public AccessPattern getNullAccessPattern() {
            if (this._primitive) {
                return AccessPattern.DYNAMIC;
            }
            if (this._nullValue == null) {
                return AccessPattern.ALWAYS_NULL;
            }
            return AccessPattern.CONSTANT;
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
        public final T getNullValue(DeserializationContext deserializationContext) throws JsonMappingException {
            if (this._primitive && deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
                deserializationContext.reportInputMismatch(this, "Cannot map `null` into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", ClassUtil.classNameOf(handledType()));
            }
            return this._nullValue;
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
            return this._emptyValue;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public final LogicalType logicalType() {
            return this._logicalType;
        }
    }

    @JacksonStdImpl
    /* loaded from: classes2.dex */
    public static final class BooleanDeserializer extends PrimitiveOrWrapperDeserializer<Boolean> {
        private static final long serialVersionUID = 1;
        static final BooleanDeserializer primitiveInstance = new BooleanDeserializer(Boolean.TYPE, Boolean.FALSE);
        static final BooleanDeserializer wrapperInstance = new BooleanDeserializer(Boolean.class, null);

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        public BooleanDeserializer(Class<Boolean> cls, Boolean bool) {
            super(cls, LogicalType.Boolean, bool, Boolean.FALSE);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            JsonToken currentToken = jsonParser.currentToken();
            if (currentToken == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (currentToken == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            if (this._primitive) {
                return Boolean.valueOf(_parseBooleanPrimitive(jsonParser, deserializationContext));
            }
            return _parseBoolean(jsonParser, deserializationContext, this._valueClass);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public Boolean deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
            JsonToken currentToken = jsonParser.currentToken();
            if (currentToken == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (currentToken == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            if (this._primitive) {
                return Boolean.valueOf(_parseBooleanPrimitive(jsonParser, deserializationContext));
            }
            return _parseBoolean(jsonParser, deserializationContext, this._valueClass);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes2.dex */
    public static class ByteDeserializer extends PrimitiveOrWrapperDeserializer<Byte> {
        private static final long serialVersionUID = 1;
        static final ByteDeserializer primitiveInstance = new ByteDeserializer(Byte.TYPE, (byte) 0);
        static final ByteDeserializer wrapperInstance = new ByteDeserializer(Byte.class, null);

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        public ByteDeserializer(Class<Byte> cls, Byte b) {
            super(cls, LogicalType.Integer, b, (byte) 0);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Byte deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.isExpectedNumberIntToken()) {
                return Byte.valueOf(jsonParser.getByteValue());
            }
            if (this._primitive) {
                return Byte.valueOf(_parseBytePrimitive(jsonParser, deserializationContext));
            }
            return _parseByte(jsonParser, deserializationContext);
        }

        protected Byte _parseByte(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String extractScalarFromObject;
            int currentTokenId = jsonParser.currentTokenId();
            if (currentTokenId == 1) {
                extractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
            } else if (currentTokenId == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            } else {
                if (currentTokenId == 11) {
                    return getNullValue(deserializationContext);
                }
                if (currentTokenId != 6) {
                    if (currentTokenId != 7) {
                        if (currentTokenId == 8) {
                            CoercionAction _checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, this._valueClass);
                            if (_checkFloatToIntCoercion == CoercionAction.AsNull) {
                                return getNullValue(deserializationContext);
                            }
                            if (_checkFloatToIntCoercion == CoercionAction.AsEmpty) {
                                return (Byte) getEmptyValue(deserializationContext);
                            }
                            return Byte.valueOf(jsonParser.getByteValue());
                        }
                        return (Byte) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                    }
                    return Byte.valueOf(jsonParser.getByteValue());
                }
                extractScalarFromObject = jsonParser.getText();
            }
            CoercionAction _checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, extractScalarFromObject);
            if (_checkFromStringCoercion == CoercionAction.AsNull) {
                return getNullValue(deserializationContext);
            }
            if (_checkFromStringCoercion == CoercionAction.AsEmpty) {
                return (Byte) getEmptyValue(deserializationContext);
            }
            String trim = extractScalarFromObject.trim();
            if (_checkTextualNull(deserializationContext, trim)) {
                return getNullValue(deserializationContext);
            }
            try {
                int parseInt = NumberInput.parseInt(trim);
                if (_byteOverflow(parseInt)) {
                    return (Byte) deserializationContext.handleWeirdStringValue(this._valueClass, trim, "overflow, value cannot be represented as 8-bit value", new Object[0]);
                }
                return Byte.valueOf((byte) parseInt);
            } catch (IllegalArgumentException unused) {
                return (Byte) deserializationContext.handleWeirdStringValue(this._valueClass, trim, "not a valid Byte value", new Object[0]);
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes2.dex */
    public static class ShortDeserializer extends PrimitiveOrWrapperDeserializer<Short> {
        private static final long serialVersionUID = 1;
        static final ShortDeserializer primitiveInstance = new ShortDeserializer(Short.TYPE, 0);
        static final ShortDeserializer wrapperInstance = new ShortDeserializer(Short.class, null);

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        public ShortDeserializer(Class<Short> cls, Short sh) {
            super(cls, LogicalType.Integer, sh, (short) 0);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Short deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.isExpectedNumberIntToken()) {
                return Short.valueOf(jsonParser.getShortValue());
            }
            if (this._primitive) {
                return Short.valueOf(_parseShortPrimitive(jsonParser, deserializationContext));
            }
            return _parseShort(jsonParser, deserializationContext);
        }

        protected Short _parseShort(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String extractScalarFromObject;
            int currentTokenId = jsonParser.currentTokenId();
            if (currentTokenId == 1) {
                extractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
            } else if (currentTokenId == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            } else {
                if (currentTokenId == 11) {
                    return getNullValue(deserializationContext);
                }
                if (currentTokenId != 6) {
                    if (currentTokenId != 7) {
                        if (currentTokenId == 8) {
                            CoercionAction _checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, this._valueClass);
                            if (_checkFloatToIntCoercion == CoercionAction.AsNull) {
                                return getNullValue(deserializationContext);
                            }
                            if (_checkFloatToIntCoercion == CoercionAction.AsEmpty) {
                                return (Short) getEmptyValue(deserializationContext);
                            }
                            return Short.valueOf(jsonParser.getShortValue());
                        }
                        return (Short) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                    }
                    return Short.valueOf(jsonParser.getShortValue());
                }
                extractScalarFromObject = jsonParser.getText();
            }
            CoercionAction _checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, extractScalarFromObject);
            if (_checkFromStringCoercion == CoercionAction.AsNull) {
                return getNullValue(deserializationContext);
            }
            if (_checkFromStringCoercion == CoercionAction.AsEmpty) {
                return (Short) getEmptyValue(deserializationContext);
            }
            String trim = extractScalarFromObject.trim();
            if (_checkTextualNull(deserializationContext, trim)) {
                return getNullValue(deserializationContext);
            }
            try {
                int parseInt = NumberInput.parseInt(trim);
                if (_shortOverflow(parseInt)) {
                    return (Short) deserializationContext.handleWeirdStringValue(this._valueClass, trim, "overflow, value cannot be represented as 16-bit value", new Object[0]);
                }
                return Short.valueOf((short) parseInt);
            } catch (IllegalArgumentException unused) {
                return (Short) deserializationContext.handleWeirdStringValue(this._valueClass, trim, "not a valid Short value", new Object[0]);
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes2.dex */
    public static class CharacterDeserializer extends PrimitiveOrWrapperDeserializer<Character> {
        private static final long serialVersionUID = 1;
        static final CharacterDeserializer primitiveInstance = new CharacterDeserializer(Character.TYPE, 0);
        static final CharacterDeserializer wrapperInstance = new CharacterDeserializer(Character.class, null);

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        public CharacterDeserializer(Class<Character> cls, Character ch) {
            super(cls, LogicalType.Integer, ch, (char) 0);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Character deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String extractScalarFromObject;
            int currentTokenId = jsonParser.currentTokenId();
            if (currentTokenId == 1) {
                extractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
            } else if (currentTokenId == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            } else {
                if (currentTokenId == 11) {
                    if (this._primitive) {
                        _verifyNullForPrimitive(deserializationContext);
                    }
                    return getNullValue(deserializationContext);
                } else if (currentTokenId != 6) {
                    if (currentTokenId == 7) {
                        CoercionAction findCoercionAction = deserializationContext.findCoercionAction(logicalType(), this._valueClass, CoercionInputShape.Integer);
                        int i = C22871.$SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[findCoercionAction.ordinal()];
                        if (i == 1) {
                            Class<?> cls = this._valueClass;
                            Number numberValue = jsonParser.getNumberValue();
                            _checkCoercionFail(deserializationContext, findCoercionAction, cls, numberValue, "Integer value (" + jsonParser.getText() + ")");
                        } else if (i != 2) {
                            if (i == 3) {
                                return (Character) getEmptyValue(deserializationContext);
                            }
                            int intValue = jsonParser.getIntValue();
                            if (intValue >= 0 && intValue <= 65535) {
                                return Character.valueOf((char) intValue);
                            }
                            return (Character) deserializationContext.handleWeirdNumberValue(handledType(), Integer.valueOf(intValue), "value outside valid Character range (0x0000 - 0xFFFF)", new Object[0]);
                        }
                        return getNullValue(deserializationContext);
                    }
                    return (Character) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                } else {
                    extractScalarFromObject = jsonParser.getText();
                }
            }
            if (extractScalarFromObject.length() == 1) {
                return Character.valueOf(extractScalarFromObject.charAt(0));
            }
            CoercionAction _checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, extractScalarFromObject);
            if (_checkFromStringCoercion == CoercionAction.AsNull) {
                return getNullValue(deserializationContext);
            }
            if (_checkFromStringCoercion == CoercionAction.AsEmpty) {
                return (Character) getEmptyValue(deserializationContext);
            }
            String trim = extractScalarFromObject.trim();
            if (_checkTextualNull(deserializationContext, trim)) {
                return getNullValue(deserializationContext);
            }
            return (Character) deserializationContext.handleWeirdStringValue(handledType(), trim, "Expected either Integer value code or 1-character String", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fasterxml.jackson.databind.deser.std.NumberDeserializers$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C22871 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction;

        static {
            int[] iArr = new int[CoercionAction.values().length];
            $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction = iArr;
            try {
                iArr[CoercionAction.Fail.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[CoercionAction.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[CoercionAction.AsEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes2.dex */
    public static final class IntegerDeserializer extends PrimitiveOrWrapperDeserializer<Integer> {
        private static final long serialVersionUID = 1;
        static final IntegerDeserializer primitiveInstance = new IntegerDeserializer(Integer.TYPE, 0);
        static final IntegerDeserializer wrapperInstance = new IntegerDeserializer(Integer.class, null);

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public boolean isCachable() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        public IntegerDeserializer(Class<Integer> cls, Integer num) {
            super(cls, LogicalType.Integer, num, 0);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.isExpectedNumberIntToken()) {
                return Integer.valueOf(jsonParser.getIntValue());
            }
            if (this._primitive) {
                return Integer.valueOf(_parseIntPrimitive(jsonParser, deserializationContext));
            }
            return _parseInteger(jsonParser, deserializationContext, Integer.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public Integer deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
            if (jsonParser.isExpectedNumberIntToken()) {
                return Integer.valueOf(jsonParser.getIntValue());
            }
            if (this._primitive) {
                return Integer.valueOf(_parseIntPrimitive(jsonParser, deserializationContext));
            }
            return _parseInteger(jsonParser, deserializationContext, Integer.class);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes2.dex */
    public static final class LongDeserializer extends PrimitiveOrWrapperDeserializer<Long> {
        private static final long serialVersionUID = 1;
        static final LongDeserializer primitiveInstance = new LongDeserializer(Long.TYPE, 0L);
        static final LongDeserializer wrapperInstance = new LongDeserializer(Long.class, null);

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public boolean isCachable() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        public LongDeserializer(Class<Long> cls, Long l) {
            super(cls, LogicalType.Integer, l, 0L);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.isExpectedNumberIntToken()) {
                return Long.valueOf(jsonParser.getLongValue());
            }
            if (this._primitive) {
                return Long.valueOf(_parseLongPrimitive(jsonParser, deserializationContext));
            }
            return _parseLong(jsonParser, deserializationContext, Long.class);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes2.dex */
    public static class FloatDeserializer extends PrimitiveOrWrapperDeserializer<Float> {
        private static final long serialVersionUID = 1;
        static final FloatDeserializer primitiveInstance = new FloatDeserializer(Float.TYPE, Float.valueOf(0.0f));
        static final FloatDeserializer wrapperInstance = new FloatDeserializer(Float.class, null);

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        public FloatDeserializer(Class<Float> cls, Float f) {
            super(cls, LogicalType.Float, f, Float.valueOf(0.0f));
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Float deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.hasToken(JsonToken.VALUE_NUMBER_FLOAT)) {
                return Float.valueOf(jsonParser.getFloatValue());
            }
            if (this._primitive) {
                return Float.valueOf(_parseFloatPrimitive(jsonParser, deserializationContext));
            }
            return _parseFloat(jsonParser, deserializationContext);
        }

        protected final Float _parseFloat(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String extractScalarFromObject;
            int currentTokenId = jsonParser.currentTokenId();
            if (currentTokenId == 1) {
                extractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
            } else if (currentTokenId == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            } else {
                if (currentTokenId == 11) {
                    return getNullValue(deserializationContext);
                }
                if (currentTokenId != 6) {
                    if (currentTokenId == 7 || currentTokenId == 8) {
                        return Float.valueOf(jsonParser.getFloatValue());
                    }
                    return (Float) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                extractScalarFromObject = jsonParser.getText();
            }
            Float _checkFloatSpecialValue = _checkFloatSpecialValue(extractScalarFromObject);
            if (_checkFloatSpecialValue != null) {
                return _checkFloatSpecialValue;
            }
            CoercionAction _checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, extractScalarFromObject);
            if (_checkFromStringCoercion == CoercionAction.AsNull) {
                return getNullValue(deserializationContext);
            }
            if (_checkFromStringCoercion == CoercionAction.AsEmpty) {
                return (Float) getEmptyValue(deserializationContext);
            }
            String trim = extractScalarFromObject.trim();
            if (_checkTextualNull(deserializationContext, trim)) {
                return getNullValue(deserializationContext);
            }
            try {
                return Float.valueOf(Float.parseFloat(trim));
            } catch (IllegalArgumentException unused) {
                return (Float) deserializationContext.handleWeirdStringValue(this._valueClass, trim, "not a valid `Float` value", new Object[0]);
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes2.dex */
    public static class DoubleDeserializer extends PrimitiveOrWrapperDeserializer<Double> {
        private static final long serialVersionUID = 1;
        static final DoubleDeserializer primitiveInstance = new DoubleDeserializer(Double.TYPE, Double.valueOf(0.0d));
        static final DoubleDeserializer wrapperInstance = new DoubleDeserializer(Double.class, null);

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        public DoubleDeserializer(Class<Double> cls, Double d) {
            super(cls, LogicalType.Float, d, Double.valueOf(0.0d));
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.hasToken(JsonToken.VALUE_NUMBER_FLOAT)) {
                return Double.valueOf(jsonParser.getDoubleValue());
            }
            if (this._primitive) {
                return Double.valueOf(_parseDoublePrimitive(jsonParser, deserializationContext));
            }
            return _parseDouble(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public Double deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
            if (jsonParser.hasToken(JsonToken.VALUE_NUMBER_FLOAT)) {
                return Double.valueOf(jsonParser.getDoubleValue());
            }
            if (this._primitive) {
                return Double.valueOf(_parseDoublePrimitive(jsonParser, deserializationContext));
            }
            return _parseDouble(jsonParser, deserializationContext);
        }

        protected final Double _parseDouble(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String extractScalarFromObject;
            int currentTokenId = jsonParser.currentTokenId();
            if (currentTokenId == 1) {
                extractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
            } else if (currentTokenId == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            } else {
                if (currentTokenId == 11) {
                    return getNullValue(deserializationContext);
                }
                if (currentTokenId != 6) {
                    if (currentTokenId == 7 || currentTokenId == 8) {
                        return Double.valueOf(jsonParser.getDoubleValue());
                    }
                    return (Double) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                extractScalarFromObject = jsonParser.getText();
            }
            Double _checkDoubleSpecialValue = _checkDoubleSpecialValue(extractScalarFromObject);
            if (_checkDoubleSpecialValue != null) {
                return _checkDoubleSpecialValue;
            }
            CoercionAction _checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, extractScalarFromObject);
            if (_checkFromStringCoercion == CoercionAction.AsNull) {
                return getNullValue(deserializationContext);
            }
            if (_checkFromStringCoercion == CoercionAction.AsEmpty) {
                return (Double) getEmptyValue(deserializationContext);
            }
            String trim = extractScalarFromObject.trim();
            if (_checkTextualNull(deserializationContext, trim)) {
                return getNullValue(deserializationContext);
            }
            try {
                return Double.valueOf(_parseDouble(trim));
            } catch (IllegalArgumentException unused) {
                return (Double) deserializationContext.handleWeirdStringValue(this._valueClass, trim, "not a valid `Double` value", new Object[0]);
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes2.dex */
    public static class NumberDeserializer extends StdScalarDeserializer<Object> {
        public static final NumberDeserializer instance = new NumberDeserializer();

        public NumberDeserializer() {
            super(Number.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public final LogicalType logicalType() {
            return LogicalType.Integer;
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String extractScalarFromObject;
            int currentTokenId = jsonParser.currentTokenId();
            if (currentTokenId == 1) {
                extractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
            } else if (currentTokenId == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            } else {
                if (currentTokenId != 6) {
                    if (currentTokenId == 7) {
                        if (deserializationContext.hasSomeOfFeatures(F_MASK_INT_COERCIONS)) {
                            return _coerceIntegral(jsonParser, deserializationContext);
                        }
                        return jsonParser.getNumberValue();
                    } else if (currentTokenId == 8) {
                        if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) && !jsonParser.isNaN()) {
                            return jsonParser.getDecimalValue();
                        }
                        return jsonParser.getNumberValue();
                    } else {
                        return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                    }
                }
                extractScalarFromObject = jsonParser.getText();
            }
            CoercionAction _checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, extractScalarFromObject);
            if (_checkFromStringCoercion == CoercionAction.AsNull) {
                return getNullValue(deserializationContext);
            }
            if (_checkFromStringCoercion == CoercionAction.AsEmpty) {
                return getEmptyValue(deserializationContext);
            }
            String trim = extractScalarFromObject.trim();
            if (_hasTextualNull(trim)) {
                return getNullValue(deserializationContext);
            }
            if (_isPosInf(trim)) {
                return Double.valueOf(Double.POSITIVE_INFINITY);
            }
            if (_isNegInf(trim)) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            if (_isNaN(trim)) {
                return Double.valueOf(Double.NaN);
            }
            try {
                if (!_isIntNumber(trim)) {
                    if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        return new BigDecimal(trim);
                    }
                    return Double.valueOf(trim);
                } else if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                    return new BigInteger(trim);
                } else {
                    long parseLong = Long.parseLong(trim);
                    if (!deserializationContext.isEnabled(DeserializationFeature.USE_LONG_FOR_INTS) && parseLong <= 2147483647L && parseLong >= -2147483648L) {
                        return Integer.valueOf((int) parseLong);
                    }
                    return Long.valueOf(parseLong);
                }
            } catch (IllegalArgumentException unused) {
                return deserializationContext.handleWeirdStringValue(this._valueClass, trim, "not a valid number", new Object[0]);
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
            int currentTokenId = jsonParser.currentTokenId();
            if (currentTokenId == 6 || currentTokenId == 7 || currentTokenId == 8) {
                return deserialize(jsonParser, deserializationContext);
            }
            return typeDeserializer.deserializeTypedFromScalar(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes2.dex */
    public static class BigIntegerDeserializer extends StdScalarDeserializer<BigInteger> {
        public static final BigIntegerDeserializer instance = new BigIntegerDeserializer();

        public BigIntegerDeserializer() {
            super(BigInteger.class);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext deserializationContext) {
            return BigInteger.ZERO;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public final LogicalType logicalType() {
            return LogicalType.Integer;
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public BigInteger deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String extractScalarFromObject;
            if (jsonParser.isExpectedNumberIntToken()) {
                return jsonParser.getBigIntegerValue();
            }
            int currentTokenId = jsonParser.currentTokenId();
            if (currentTokenId == 1) {
                extractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
            } else if (currentTokenId == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            } else {
                if (currentTokenId != 6) {
                    if (currentTokenId == 8) {
                        CoercionAction _checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, this._valueClass);
                        if (_checkFloatToIntCoercion == CoercionAction.AsNull) {
                            return getNullValue(deserializationContext);
                        }
                        if (_checkFloatToIntCoercion == CoercionAction.AsEmpty) {
                            return (BigInteger) getEmptyValue(deserializationContext);
                        }
                        return jsonParser.getDecimalValue().toBigInteger();
                    }
                    return (BigInteger) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                extractScalarFromObject = jsonParser.getText();
            }
            CoercionAction _checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, extractScalarFromObject);
            if (_checkFromStringCoercion == CoercionAction.AsNull) {
                return getNullValue(deserializationContext);
            }
            if (_checkFromStringCoercion == CoercionAction.AsEmpty) {
                return (BigInteger) getEmptyValue(deserializationContext);
            }
            String trim = extractScalarFromObject.trim();
            if (_hasTextualNull(trim)) {
                return getNullValue(deserializationContext);
            }
            try {
                return new BigInteger(trim);
            } catch (IllegalArgumentException unused) {
                return (BigInteger) deserializationContext.handleWeirdStringValue(this._valueClass, trim, "not a valid representation", new Object[0]);
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes2.dex */
    public static class BigDecimalDeserializer extends StdScalarDeserializer<BigDecimal> {
        public static final BigDecimalDeserializer instance = new BigDecimalDeserializer();

        public BigDecimalDeserializer() {
            super(BigDecimal.class);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext deserializationContext) {
            return BigDecimal.ZERO;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public final LogicalType logicalType() {
            return LogicalType.Float;
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String extractScalarFromObject;
            int currentTokenId = jsonParser.currentTokenId();
            if (currentTokenId == 1) {
                extractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
            } else if (currentTokenId == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            } else {
                if (currentTokenId != 6) {
                    if (currentTokenId == 7 || currentTokenId == 8) {
                        return jsonParser.getDecimalValue();
                    }
                    return (BigDecimal) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                extractScalarFromObject = jsonParser.getText();
            }
            CoercionAction _checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, extractScalarFromObject);
            if (_checkFromStringCoercion == CoercionAction.AsNull) {
                return getNullValue(deserializationContext);
            }
            if (_checkFromStringCoercion == CoercionAction.AsEmpty) {
                return (BigDecimal) getEmptyValue(deserializationContext);
            }
            String trim = extractScalarFromObject.trim();
            if (_hasTextualNull(trim)) {
                return getNullValue(deserializationContext);
            }
            try {
                return new BigDecimal(trim);
            } catch (IllegalArgumentException unused) {
                return (BigDecimal) deserializationContext.handleWeirdStringValue(this._valueClass, trim, "not a valid representation", new Object[0]);
            }
        }
    }
}
