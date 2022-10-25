package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class JDKValueInstantiators {
    public static ValueInstantiator findStdValueInstantiator(DeserializationConfig deserializationConfig, Class<?> cls) {
        if (cls == JsonLocation.class) {
            return new JsonLocationInstantiator();
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (cls == ArrayList.class) {
                return ArrayListInstantiator.INSTANCE;
            }
            if (Collections.EMPTY_SET.getClass() == cls) {
                return new ConstantValueInstantiator(Collections.EMPTY_SET);
            }
            if (Collections.EMPTY_LIST.getClass() == cls) {
                return new ConstantValueInstantiator(Collections.EMPTY_LIST);
            }
            return null;
        } else if (Map.class.isAssignableFrom(cls)) {
            if (cls == LinkedHashMap.class) {
                return LinkedHashMapInstantiator.INSTANCE;
            }
            if (cls == HashMap.class) {
                return HashMapInstantiator.INSTANCE;
            }
            if (Collections.EMPTY_MAP.getClass() == cls) {
                return new ConstantValueInstantiator(Collections.EMPTY_MAP);
            }
            return null;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private static class ArrayListInstantiator extends ValueInstantiator.Base implements Serializable {
        public static final ArrayListInstantiator INSTANCE = new ArrayListInstantiator();
        private static final long serialVersionUID = 2;

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateUsingDefault() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canInstantiate() {
            return true;
        }

        public ArrayListInstantiator() {
            super(ArrayList.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) throws IOException {
            return new ArrayList();
        }
    }

    /* loaded from: classes2.dex */
    private static class HashMapInstantiator extends ValueInstantiator.Base implements Serializable {
        public static final HashMapInstantiator INSTANCE = new HashMapInstantiator();
        private static final long serialVersionUID = 2;

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateUsingDefault() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canInstantiate() {
            return true;
        }

        public HashMapInstantiator() {
            super(HashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) throws IOException {
            return new HashMap();
        }
    }

    /* loaded from: classes2.dex */
    private static class LinkedHashMapInstantiator extends ValueInstantiator.Base implements Serializable {
        public static final LinkedHashMapInstantiator INSTANCE = new LinkedHashMapInstantiator();
        private static final long serialVersionUID = 2;

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateUsingDefault() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canInstantiate() {
            return true;
        }

        public LinkedHashMapInstantiator() {
            super(LinkedHashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) throws IOException {
            return new LinkedHashMap();
        }
    }

    /* loaded from: classes2.dex */
    private static class ConstantValueInstantiator extends ValueInstantiator.Base implements Serializable {
        private static final long serialVersionUID = 2;
        protected final Object _value;

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canCreateUsingDefault() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public boolean canInstantiate() {
            return true;
        }

        public ConstantValueInstantiator(Object obj) {
            super(obj.getClass());
            this._value = obj;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) throws IOException {
            return this._value;
        }
    }
}
