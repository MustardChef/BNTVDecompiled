package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ExternalTypeHandler {
    private final JavaType _beanType;
    private final Map<String, Object> _nameToPropertyIndex;
    private final ExtTypedProperty[] _properties;
    private final TokenBuffer[] _tokens;
    private final String[] _typeIds;

    protected ExternalTypeHandler(JavaType javaType, ExtTypedProperty[] extTypedPropertyArr, Map<String, Object> map, String[] strArr, TokenBuffer[] tokenBufferArr) {
        this._beanType = javaType;
        this._properties = extTypedPropertyArr;
        this._nameToPropertyIndex = map;
        this._typeIds = strArr;
        this._tokens = tokenBufferArr;
    }

    protected ExternalTypeHandler(ExternalTypeHandler externalTypeHandler) {
        this._beanType = externalTypeHandler._beanType;
        ExtTypedProperty[] extTypedPropertyArr = externalTypeHandler._properties;
        this._properties = extTypedPropertyArr;
        this._nameToPropertyIndex = externalTypeHandler._nameToPropertyIndex;
        int length = extTypedPropertyArr.length;
        this._typeIds = new String[length];
        this._tokens = new TokenBuffer[length];
    }

    public static Builder builder(JavaType javaType) {
        return new Builder(javaType);
    }

    public ExternalTypeHandler start() {
        return new ExternalTypeHandler(this);
    }

    public boolean handleTypePropertyValue(JsonParser jsonParser, DeserializationContext deserializationContext, String str, Object obj) throws IOException {
        Object obj2 = this._nameToPropertyIndex.get(str);
        boolean z = false;
        if (obj2 == null) {
            return false;
        }
        String text = jsonParser.getText();
        if (obj2 instanceof List) {
            for (Integer num : (List) obj2) {
                if (_handleTypePropertyValue(jsonParser, deserializationContext, str, obj, text, num.intValue())) {
                    z = true;
                }
            }
            return z;
        }
        return _handleTypePropertyValue(jsonParser, deserializationContext, str, obj, text, ((Integer) obj2).intValue());
    }

    private final boolean _handleTypePropertyValue(JsonParser jsonParser, DeserializationContext deserializationContext, String str, Object obj, String str2, int i) throws IOException {
        boolean z = false;
        if (this._properties[i].hasTypePropertyName(str)) {
            if (obj != null && this._tokens[i] != null) {
                z = true;
            }
            if (z) {
                _deserializeAndSet(jsonParser, deserializationContext, obj, i, str2);
                this._tokens[i] = null;
            } else {
                this._typeIds[i] = str2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0090, code lost:
        if (r10._tokens[r0] != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0092, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a2, code lost:
        if (r10._typeIds[r0] != null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handlePropertyValue(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12, java.lang.String r13, java.lang.Object r14) throws java.io.IOException {
        /*
            r10 = this;
            java.util.Map<java.lang.String, java.lang.Object> r0 = r10._nameToPropertyIndex
            java.lang.Object r0 = r0.get(r13)
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            boolean r2 = r0 instanceof java.util.List
            r3 = 1
            if (r2 == 0) goto L6f
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r14 = r0.iterator()
            java.lang.Object r0 = r14.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler$ExtTypedProperty[] r1 = r10._properties
            int r2 = r0.intValue()
            r1 = r1[r2]
            boolean r13 = r1.hasTypePropertyName(r13)
            if (r13 == 0) goto L4d
            java.lang.String r12 = r11.getText()
            r11.skipChildren()
            java.lang.String[] r11 = r10._typeIds
            int r13 = r0.intValue()
            r11[r13] = r12
        L38:
            boolean r11 = r14.hasNext()
            if (r11 == 0) goto L6e
            java.lang.String[] r11 = r10._typeIds
            java.lang.Object r13 = r14.next()
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            r11[r13] = r12
            goto L38
        L4d:
            com.fasterxml.jackson.databind.util.TokenBuffer r11 = r12.bufferAsCopyOfValue(r11)
            com.fasterxml.jackson.databind.util.TokenBuffer[] r12 = r10._tokens
            int r13 = r0.intValue()
            r12[r13] = r11
        L59:
            boolean r12 = r14.hasNext()
            if (r12 == 0) goto L6e
            com.fasterxml.jackson.databind.util.TokenBuffer[] r12 = r10._tokens
            java.lang.Object r13 = r14.next()
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            r12[r13] = r11
            goto L59
        L6e:
            return r3
        L6f:
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler$ExtTypedProperty[] r2 = r10._properties
            r2 = r2[r0]
            boolean r13 = r2.hasTypePropertyName(r13)
            if (r13 == 0) goto L94
            java.lang.String[] r13 = r10._typeIds
            java.lang.String r2 = r11.getValueAsString()
            r13[r0] = r2
            r11.skipChildren()
            if (r14 == 0) goto La5
            com.fasterxml.jackson.databind.util.TokenBuffer[] r13 = r10._tokens
            r13 = r13[r0]
            if (r13 == 0) goto La5
        L92:
            r1 = 1
            goto La5
        L94:
            com.fasterxml.jackson.databind.util.TokenBuffer r13 = r12.bufferAsCopyOfValue(r11)
            com.fasterxml.jackson.databind.util.TokenBuffer[] r2 = r10._tokens
            r2[r0] = r13
            if (r14 == 0) goto La5
            java.lang.String[] r13 = r10._typeIds
            r13 = r13[r0]
            if (r13 == 0) goto La5
            goto L92
        La5:
            if (r1 == 0) goto Lba
            java.lang.String[] r13 = r10._typeIds
            r9 = r13[r0]
            r1 = 0
            r13[r0] = r1
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r14
            r8 = r0
            r4._deserializeAndSet(r5, r6, r7, r8, r9)
            com.fasterxml.jackson.databind.util.TokenBuffer[] r11 = r10._tokens
            r11[r0] = r1
        Lba:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.handlePropertyValue(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, java.lang.String, java.lang.Object):boolean");
    }

    public Object complete(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        int length = this._properties.length;
        for (int i = 0; i < length; i++) {
            String str = this._typeIds[i];
            ExtTypedProperty extTypedProperty = this._properties[i];
            if (str == null) {
                TokenBuffer tokenBuffer = this._tokens[i];
                if (tokenBuffer != null) {
                    if (tokenBuffer.firstToken().isScalarValue()) {
                        JsonParser asParser = tokenBuffer.asParser(jsonParser);
                        asParser.nextToken();
                        SettableBeanProperty property = extTypedProperty.getProperty();
                        Object deserializeIfNatural = TypeDeserializer.deserializeIfNatural(asParser, deserializationContext, property.getType());
                        if (deserializeIfNatural != null) {
                            property.set(obj, deserializeIfNatural);
                        }
                    }
                    if (!extTypedProperty.hasDefaultType()) {
                        deserializationContext.reportPropertyInputMismatch(this._beanType, extTypedProperty.getProperty().getName(), "Missing external type id property '%s' (and no 'defaultImpl' specified)", extTypedProperty.getTypePropertyName());
                    } else {
                        str = extTypedProperty.getDefaultTypeId();
                        if (str == null) {
                            deserializationContext.reportPropertyInputMismatch(this._beanType, extTypedProperty.getProperty().getName(), "Invalid default type id for property '%s': `null` returned by TypeIdResolver", extTypedProperty.getTypePropertyName());
                        }
                    }
                }
            } else if (this._tokens[i] == null) {
                SettableBeanProperty property2 = extTypedProperty.getProperty();
                if (property2.isRequired() || deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)) {
                    deserializationContext.reportPropertyInputMismatch(obj.getClass(), property2.getName(), "Missing property '%s' for external type id '%s'", property2.getName(), extTypedProperty.getTypePropertyName());
                }
                return obj;
            }
            _deserializeAndSet(jsonParser, deserializationContext, obj, i, str);
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
        if (r13.isEnabled(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY) != false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object complete(com.fasterxml.jackson.core.JsonParser r12, com.fasterxml.jackson.databind.DeserializationContext r13, com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer r14, com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator r15) throws java.io.IOException {
        /*
            r11 = this;
            com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler$ExtTypedProperty[] r0 = r11._properties
            int r0 = r0.length
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r3 = 0
        L7:
            if (r3 >= r0) goto Lce
            java.lang.String[] r4 = r11._typeIds
            r4 = r4[r3]
            com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler$ExtTypedProperty[] r5 = r11._properties
            r5 = r5[r3]
            r6 = 1
            if (r4 != 0) goto L47
            com.fasterxml.jackson.databind.util.TokenBuffer[] r7 = r11._tokens
            r7 = r7[r3]
            if (r7 == 0) goto Lca
            com.fasterxml.jackson.core.JsonToken r7 = r7.firstToken()
            com.fasterxml.jackson.core.JsonToken r8 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            if (r7 != r8) goto L24
            goto Lca
        L24:
            boolean r7 = r5.hasDefaultType()
            if (r7 != 0) goto L42
            com.fasterxml.jackson.databind.JavaType r7 = r11._beanType
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r8 = r5.getProperty()
            java.lang.String r8 = r8.getName()
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r9 = r5.getTypePropertyName()
            r6[r2] = r9
            java.lang.String r9 = "Missing external type id property '%s'"
            r13.reportPropertyInputMismatch(r7, r8, r9, r6)
            goto L7d
        L42:
            java.lang.String r4 = r5.getDefaultTypeId()
            goto L7d
        L47:
            com.fasterxml.jackson.databind.util.TokenBuffer[] r7 = r11._tokens
            r7 = r7[r3]
            if (r7 != 0) goto L7d
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r7 = r5.getProperty()
            boolean r8 = r7.isRequired()
            if (r8 != 0) goto L5f
            com.fasterxml.jackson.databind.DeserializationFeature r8 = com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY
            boolean r8 = r13.isEnabled(r8)
            if (r8 == 0) goto L7d
        L5f:
            com.fasterxml.jackson.databind.JavaType r8 = r11._beanType
            java.lang.String r9 = r7.getName()
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.String r7 = r7.getName()
            r10[r2] = r7
            com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler$ExtTypedProperty[] r7 = r11._properties
            r7 = r7[r3]
            java.lang.String r7 = r7.getTypePropertyName()
            r10[r6] = r7
            java.lang.String r6 = "Missing property '%s' for external type id '%s'"
            r13.reportPropertyInputMismatch(r8, r9, r6, r10)
        L7d:
            com.fasterxml.jackson.databind.util.TokenBuffer[] r6 = r11._tokens
            r6 = r6[r3]
            if (r6 == 0) goto L89
            java.lang.Object r6 = r11._deserialize(r12, r13, r3, r4)
            r1[r3] = r6
        L89:
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r6 = r5.getProperty()
            int r7 = r6.getCreatorIndex()
            if (r7 < 0) goto Lca
            r7 = r1[r3]
            r14.assignParameter(r6, r7)
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r5 = r5.getTypeProperty()
            if (r5 == 0) goto Lca
            int r6 = r5.getCreatorIndex()
            if (r6 < 0) goto Lca
            com.fasterxml.jackson.databind.JavaType r6 = r5.getType()
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            boolean r6 = r6.hasRawClass(r7)
            if (r6 == 0) goto Lb1
            goto Lc7
        Lb1:
            com.fasterxml.jackson.databind.util.TokenBuffer r6 = r13.bufferForInputBuffering(r12)
            r6.writeString(r4)
            com.fasterxml.jackson.databind.JsonDeserializer r4 = r5.getValueDeserializer()
            com.fasterxml.jackson.core.JsonParser r7 = r6.asParserOnFirstToken()
            java.lang.Object r4 = r4.deserialize(r7, r13)
            r6.close()
        Lc7:
            r14.assignParameter(r5, r4)
        Lca:
            int r3 = r3 + 1
            goto L7
        Lce:
            java.lang.Object r12 = r15.build(r13, r14)
        Ld2:
            if (r2 >= r0) goto Lea
            com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler$ExtTypedProperty[] r13 = r11._properties
            r13 = r13[r2]
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r13 = r13.getProperty()
            int r14 = r13.getCreatorIndex()
            if (r14 >= 0) goto Le7
            r14 = r1[r2]
            r13.set(r12, r14)
        Le7:
            int r2 = r2 + 1
            goto Ld2
        Lea:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.complete(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer, com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator):java.lang.Object");
    }

    protected final Object _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, int i, String str) throws IOException {
        JsonParser asParser = this._tokens[i].asParser(jsonParser);
        if (asParser.nextToken() == JsonToken.VALUE_NULL) {
            return null;
        }
        TokenBuffer bufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        bufferForInputBuffering.writeStartArray();
        bufferForInputBuffering.writeString(str);
        bufferForInputBuffering.copyCurrentStructure(asParser);
        bufferForInputBuffering.writeEndArray();
        JsonParser asParser2 = bufferForInputBuffering.asParser(jsonParser);
        asParser2.nextToken();
        return this._properties[i].getProperty().deserialize(asParser2, deserializationContext);
    }

    protected final void _deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, int i, String str) throws IOException {
        if (str == null) {
            deserializationContext.reportInputMismatch(this._beanType, "Internal error in external Type Id handling: `null` type id passed", new Object[0]);
        }
        JsonParser asParser = this._tokens[i].asParser(jsonParser);
        if (asParser.nextToken() == JsonToken.VALUE_NULL) {
            this._properties[i].getProperty().set(obj, null);
            return;
        }
        TokenBuffer bufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        bufferForInputBuffering.writeStartArray();
        bufferForInputBuffering.writeString(str);
        bufferForInputBuffering.copyCurrentStructure(asParser);
        bufferForInputBuffering.writeEndArray();
        JsonParser asParser2 = bufferForInputBuffering.asParser(jsonParser);
        asParser2.nextToken();
        this._properties[i].getProperty().deserializeAndSet(asParser2, deserializationContext, obj);
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private final JavaType _beanType;
        private final List<ExtTypedProperty> _properties = new ArrayList();
        private final Map<String, Object> _nameToPropertyIndex = new HashMap();

        protected Builder(JavaType javaType) {
            this._beanType = javaType;
        }

        public void addExternal(SettableBeanProperty settableBeanProperty, TypeDeserializer typeDeserializer) {
            Integer valueOf = Integer.valueOf(this._properties.size());
            this._properties.add(new ExtTypedProperty(settableBeanProperty, typeDeserializer));
            _addPropertyIndex(settableBeanProperty.getName(), valueOf);
            _addPropertyIndex(typeDeserializer.getPropertyName(), valueOf);
        }

        private void _addPropertyIndex(String str, Integer num) {
            Object obj = this._nameToPropertyIndex.get(str);
            if (obj == null) {
                this._nameToPropertyIndex.put(str, num);
            } else if (obj instanceof List) {
                ((List) obj).add(num);
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(obj);
                linkedList.add(num);
                this._nameToPropertyIndex.put(str, linkedList);
            }
        }

        public ExternalTypeHandler build(BeanPropertyMap beanPropertyMap) {
            int size = this._properties.size();
            ExtTypedProperty[] extTypedPropertyArr = new ExtTypedProperty[size];
            for (int i = 0; i < size; i++) {
                ExtTypedProperty extTypedProperty = this._properties.get(i);
                SettableBeanProperty find = beanPropertyMap.find(extTypedProperty.getTypePropertyName());
                if (find != null) {
                    extTypedProperty.linkTypeProperty(find);
                }
                extTypedPropertyArr[i] = extTypedProperty;
            }
            return new ExternalTypeHandler(this._beanType, extTypedPropertyArr, this._nameToPropertyIndex, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ExtTypedProperty {
        private final SettableBeanProperty _property;
        private final TypeDeserializer _typeDeserializer;
        private SettableBeanProperty _typeProperty;
        private final String _typePropertyName;

        public ExtTypedProperty(SettableBeanProperty settableBeanProperty, TypeDeserializer typeDeserializer) {
            this._property = settableBeanProperty;
            this._typeDeserializer = typeDeserializer;
            this._typePropertyName = typeDeserializer.getPropertyName();
        }

        public void linkTypeProperty(SettableBeanProperty settableBeanProperty) {
            this._typeProperty = settableBeanProperty;
        }

        public boolean hasTypePropertyName(String str) {
            return str.equals(this._typePropertyName);
        }

        public boolean hasDefaultType() {
            return this._typeDeserializer.hasDefaultImpl();
        }

        public String getDefaultTypeId() {
            Class<?> defaultImpl = this._typeDeserializer.getDefaultImpl();
            if (defaultImpl == null) {
                return null;
            }
            return this._typeDeserializer.getTypeIdResolver().idFromValueAndType(null, defaultImpl);
        }

        public String getTypePropertyName() {
            return this._typePropertyName;
        }

        public SettableBeanProperty getProperty() {
            return this._property;
        }

        public SettableBeanProperty getTypeProperty() {
            return this._typeProperty;
        }
    }
}
