package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class PropertySerializerMap {
    protected final boolean _resetWhenFull;

    public abstract PropertySerializerMap newWith(Class<?> cls, JsonSerializer<Object> jsonSerializer);

    public abstract JsonSerializer<Object> serializerFor(Class<?> cls);

    protected PropertySerializerMap(boolean z) {
        this._resetWhenFull = z;
    }

    protected PropertySerializerMap(PropertySerializerMap propertySerializerMap) {
        this._resetWhenFull = propertySerializerMap._resetWhenFull;
    }

    public final SerializerAndMapResult findAndAddPrimarySerializer(Class<?> cls, SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> findPrimaryPropertySerializer = serializerProvider.findPrimaryPropertySerializer(cls, beanProperty);
        return new SerializerAndMapResult(findPrimaryPropertySerializer, newWith(cls, findPrimaryPropertySerializer));
    }

    public final SerializerAndMapResult findAndAddPrimarySerializer(JavaType javaType, SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> findPrimaryPropertySerializer = serializerProvider.findPrimaryPropertySerializer(javaType, beanProperty);
        return new SerializerAndMapResult(findPrimaryPropertySerializer, newWith(javaType.getRawClass(), findPrimaryPropertySerializer));
    }

    public final SerializerAndMapResult findAndAddSecondarySerializer(Class<?> cls, SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> findContentValueSerializer = serializerProvider.findContentValueSerializer(cls, beanProperty);
        return new SerializerAndMapResult(findContentValueSerializer, newWith(cls, findContentValueSerializer));
    }

    public final SerializerAndMapResult findAndAddSecondarySerializer(JavaType javaType, SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> findContentValueSerializer = serializerProvider.findContentValueSerializer(javaType, beanProperty);
        return new SerializerAndMapResult(findContentValueSerializer, newWith(javaType.getRawClass(), findContentValueSerializer));
    }

    public final SerializerAndMapResult findAndAddRootValueSerializer(Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        JsonSerializer<Object> findTypedValueSerializer = serializerProvider.findTypedValueSerializer(cls, false, (BeanProperty) null);
        return new SerializerAndMapResult(findTypedValueSerializer, newWith(cls, findTypedValueSerializer));
    }

    public final SerializerAndMapResult findAndAddRootValueSerializer(JavaType javaType, SerializerProvider serializerProvider) throws JsonMappingException {
        JsonSerializer<Object> findTypedValueSerializer = serializerProvider.findTypedValueSerializer(javaType, false, (BeanProperty) null);
        return new SerializerAndMapResult(findTypedValueSerializer, newWith(javaType.getRawClass(), findTypedValueSerializer));
    }

    public final SerializerAndMapResult findAndAddKeySerializer(Class<?> cls, SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> findKeySerializer = serializerProvider.findKeySerializer(cls, beanProperty);
        return new SerializerAndMapResult(findKeySerializer, newWith(cls, findKeySerializer));
    }

    public final SerializerAndMapResult addSerializer(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
        return new SerializerAndMapResult(jsonSerializer, newWith(cls, jsonSerializer));
    }

    public final SerializerAndMapResult addSerializer(JavaType javaType, JsonSerializer<Object> jsonSerializer) {
        return new SerializerAndMapResult(jsonSerializer, newWith(javaType.getRawClass(), jsonSerializer));
    }

    public static PropertySerializerMap emptyForProperties() {
        return Empty.FOR_PROPERTIES;
    }

    public static PropertySerializerMap emptyForRootValues() {
        return Empty.FOR_ROOT_VALUES;
    }

    /* loaded from: classes2.dex */
    public static final class SerializerAndMapResult {
        public final PropertySerializerMap map;
        public final JsonSerializer<Object> serializer;

        public SerializerAndMapResult(JsonSerializer<Object> jsonSerializer, PropertySerializerMap propertySerializerMap) {
            this.serializer = jsonSerializer;
            this.map = propertySerializerMap;
        }
    }

    /* loaded from: classes2.dex */
    private static final class TypeAndSerializer {
        public final JsonSerializer<Object> serializer;
        public final Class<?> type;

        public TypeAndSerializer(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            this.type = cls;
            this.serializer = jsonSerializer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Empty extends PropertySerializerMap {
        public static final Empty FOR_PROPERTIES = new Empty(false);
        public static final Empty FOR_ROOT_VALUES = new Empty(true);

        @Override // com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap
        public JsonSerializer<Object> serializerFor(Class<?> cls) {
            return null;
        }

        protected Empty(boolean z) {
            super(z);
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap
        public PropertySerializerMap newWith(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new Single(this, cls, jsonSerializer);
        }
    }

    /* loaded from: classes2.dex */
    private static final class Single extends PropertySerializerMap {
        private final JsonSerializer<Object> _serializer;
        private final Class<?> _type;

        public Single(PropertySerializerMap propertySerializerMap, Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            super(propertySerializerMap);
            this._type = cls;
            this._serializer = jsonSerializer;
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap
        public JsonSerializer<Object> serializerFor(Class<?> cls) {
            if (cls == this._type) {
                return this._serializer;
            }
            return null;
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap
        public PropertySerializerMap newWith(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new Double(this, this._type, this._serializer, cls, jsonSerializer);
        }
    }

    /* loaded from: classes2.dex */
    private static final class Double extends PropertySerializerMap {
        private final JsonSerializer<Object> _serializer1;
        private final JsonSerializer<Object> _serializer2;
        private final Class<?> _type1;
        private final Class<?> _type2;

        public Double(PropertySerializerMap propertySerializerMap, Class<?> cls, JsonSerializer<Object> jsonSerializer, Class<?> cls2, JsonSerializer<Object> jsonSerializer2) {
            super(propertySerializerMap);
            this._type1 = cls;
            this._serializer1 = jsonSerializer;
            this._type2 = cls2;
            this._serializer2 = jsonSerializer2;
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap
        public JsonSerializer<Object> serializerFor(Class<?> cls) {
            if (cls == this._type1) {
                return this._serializer1;
            }
            if (cls == this._type2) {
                return this._serializer2;
            }
            return null;
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap
        public PropertySerializerMap newWith(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new Multi(this, new TypeAndSerializer[]{new TypeAndSerializer(this._type1, this._serializer1), new TypeAndSerializer(this._type2, this._serializer2), new TypeAndSerializer(cls, jsonSerializer)});
        }
    }

    /* loaded from: classes2.dex */
    private static final class Multi extends PropertySerializerMap {
        private static final int MAX_ENTRIES = 8;
        private final TypeAndSerializer[] _entries;

        public Multi(PropertySerializerMap propertySerializerMap, TypeAndSerializer[] typeAndSerializerArr) {
            super(propertySerializerMap);
            this._entries = typeAndSerializerArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0065 A[ORIG_RETURN, RETURN] */
        @Override // com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> serializerFor(java.lang.Class<?> r3) {
            /*
                r2 = this;
                com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap$TypeAndSerializer[] r0 = r2._entries
                r1 = 0
                r0 = r0[r1]
                java.lang.Class<?> r1 = r0.type
                if (r1 != r3) goto Lc
                com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r3 = r0.serializer
                return r3
            Lc:
                com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap$TypeAndSerializer[] r0 = r2._entries
                r1 = 1
                r0 = r0[r1]
                java.lang.Class<?> r1 = r0.type
                if (r1 != r3) goto L18
                com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r3 = r0.serializer
                return r3
            L18:
                com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap$TypeAndSerializer[] r0 = r2._entries
                r1 = 2
                r0 = r0[r1]
                java.lang.Class<?> r1 = r0.type
                if (r1 != r3) goto L24
                com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r3 = r0.serializer
                return r3
            L24:
                com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap$TypeAndSerializer[] r0 = r2._entries
                int r1 = r0.length
                switch(r1) {
                    case 4: goto L59;
                    case 5: goto L4d;
                    case 6: goto L41;
                    case 7: goto L35;
                    case 8: goto L2b;
                    default: goto L2a;
                }
            L2a:
                goto L65
            L2b:
                r1 = 7
                r0 = r0[r1]
                java.lang.Class<?> r1 = r0.type
                if (r1 != r3) goto L35
                com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r3 = r0.serializer
                return r3
            L35:
                com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap$TypeAndSerializer[] r0 = r2._entries
                r1 = 6
                r0 = r0[r1]
                java.lang.Class<?> r1 = r0.type
                if (r1 != r3) goto L41
                com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r3 = r0.serializer
                return r3
            L41:
                com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap$TypeAndSerializer[] r0 = r2._entries
                r1 = 5
                r0 = r0[r1]
                java.lang.Class<?> r1 = r0.type
                if (r1 != r3) goto L4d
                com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r3 = r0.serializer
                return r3
            L4d:
                com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap$TypeAndSerializer[] r0 = r2._entries
                r1 = 4
                r0 = r0[r1]
                java.lang.Class<?> r1 = r0.type
                if (r1 != r3) goto L59
                com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r3 = r0.serializer
                return r3
            L59:
                com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap$TypeAndSerializer[] r0 = r2._entries
                r1 = 3
                r0 = r0[r1]
                java.lang.Class<?> r1 = r0.type
                if (r1 != r3) goto L65
                com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r3 = r0.serializer
                return r3
            L65:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Multi.serializerFor(java.lang.Class):com.fasterxml.jackson.databind.JsonSerializer");
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap
        public PropertySerializerMap newWith(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            TypeAndSerializer[] typeAndSerializerArr = this._entries;
            int length = typeAndSerializerArr.length;
            if (length == 8) {
                return this._resetWhenFull ? new Single(this, cls, jsonSerializer) : this;
            }
            TypeAndSerializer[] typeAndSerializerArr2 = (TypeAndSerializer[]) Arrays.copyOf(typeAndSerializerArr, length + 1);
            typeAndSerializerArr2[length] = new TypeAndSerializer(cls, jsonSerializer);
            return new Multi(this, typeAndSerializerArr2);
        }
    }
}
