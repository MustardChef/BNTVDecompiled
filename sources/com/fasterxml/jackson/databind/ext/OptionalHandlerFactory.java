package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class OptionalHandlerFactory implements Serializable {
    private static final Class<?> CLASS_DOM_DOCUMENT;
    private static final Class<?> CLASS_DOM_NODE;
    private static final String CLS_NAME_JAVA_SQL_BLOB = "java.sql.Blob";
    private static final String CLS_NAME_JAVA_SQL_DATE = "java.sql.Date";
    private static final String CLS_NAME_JAVA_SQL_SERIALBLOB = "javax.sql.rowset.serial.SerialBlob";
    private static final String CLS_NAME_JAVA_SQL_TIME = "java.sql.Time";
    private static final String CLS_NAME_JAVA_SQL_TIMESTAMP = "java.sql.Timestamp";
    private static final String DESERIALIZERS_FOR_JAVAX_XML = "com.fasterxml.jackson.databind.ext.CoreXMLDeserializers";
    private static final String DESERIALIZER_FOR_DOM_DOCUMENT = "com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer";
    private static final String DESERIALIZER_FOR_DOM_NODE = "com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer";
    private static final String PACKAGE_PREFIX_JAVAX_XML = "javax.xml.";
    private static final String SERIALIZERS_FOR_JAVAX_XML = "com.fasterxml.jackson.databind.ext.CoreXMLSerializers";
    private static final String SERIALIZER_FOR_DOM_NODE = "com.fasterxml.jackson.databind.ext.DOMSerializer";
    private static final Java7Handlers _jdk7Helper;
    public static final OptionalHandlerFactory instance;
    private static final long serialVersionUID = 1;
    private final Map<String, String> _sqlDeserializers;
    private final Map<String, Object> _sqlSerializers;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0006
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    static {
        /*
            r0 = 0
            java.lang.Class<org.w3c.dom.Node> r1 = org.w3c.dom.Node.class
            java.lang.Class<org.w3c.dom.Document> r2 = org.w3c.dom.Document.class
            goto L8
        L6:
            r1 = r0
        L7:
            r2 = r0
        L8:
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.CLASS_DOM_NODE = r1
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.CLASS_DOM_DOCUMENT = r2
            com.fasterxml.jackson.databind.ext.Java7Handlers r0 = com.fasterxml.jackson.databind.ext.Java7Handlers.instance()     // Catch: java.lang.Throwable -> L10
        L10:
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory._jdk7Helper = r0
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory r0 = new com.fasterxml.jackson.databind.ext.OptionalHandlerFactory
            r0.<init>()
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.instance = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.<clinit>():void");
    }

    protected OptionalHandlerFactory() {
        HashMap hashMap = new HashMap();
        this._sqlDeserializers = hashMap;
        hashMap.put(CLS_NAME_JAVA_SQL_DATE, "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        hashMap.put(CLS_NAME_JAVA_SQL_TIMESTAMP, "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap hashMap2 = new HashMap();
        this._sqlSerializers = hashMap2;
        hashMap2.put(CLS_NAME_JAVA_SQL_TIMESTAMP, DateSerializer.instance);
        hashMap2.put(CLS_NAME_JAVA_SQL_DATE, "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        hashMap2.put(CLS_NAME_JAVA_SQL_TIME, "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        hashMap2.put(CLS_NAME_JAVA_SQL_BLOB, "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        hashMap2.put(CLS_NAME_JAVA_SQL_SERIALBLOB, "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    public JsonSerializer<?> findSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        Object instantiate;
        JsonSerializer<?> serializerForJavaNioFilePath;
        Class<?> rawClass = javaType.getRawClass();
        if (_IsXOfY(rawClass, CLASS_DOM_NODE)) {
            return (JsonSerializer) instantiate(SERIALIZER_FOR_DOM_NODE, javaType);
        }
        Java7Handlers java7Handlers = _jdk7Helper;
        if (java7Handlers == null || (serializerForJavaNioFilePath = java7Handlers.getSerializerForJavaNioFilePath(rawClass)) == null) {
            String name = rawClass.getName();
            Object obj = this._sqlSerializers.get(name);
            if (obj != null) {
                if (obj instanceof JsonSerializer) {
                    return (JsonSerializer) obj;
                }
                return (JsonSerializer) instantiate((String) obj, javaType);
            } else if ((name.startsWith(PACKAGE_PREFIX_JAVAX_XML) || hasSuperClassStartingWith(rawClass, PACKAGE_PREFIX_JAVAX_XML)) && (instantiate = instantiate(SERIALIZERS_FOR_JAVAX_XML, javaType)) != null) {
                return ((Serializers) instantiate).findSerializer(serializationConfig, javaType, beanDescription);
            } else {
                return null;
            }
        }
        return serializerForJavaNioFilePath;
    }

    public JsonDeserializer<?> findDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        Object instantiate;
        JsonDeserializer<?> deserializerForJavaNioFilePath;
        Class<?> rawClass = javaType.getRawClass();
        Java7Handlers java7Handlers = _jdk7Helper;
        if (java7Handlers == null || (deserializerForJavaNioFilePath = java7Handlers.getDeserializerForJavaNioFilePath(rawClass)) == null) {
            if (_IsXOfY(rawClass, CLASS_DOM_NODE)) {
                return (JsonDeserializer) instantiate(DESERIALIZER_FOR_DOM_NODE, javaType);
            }
            if (_IsXOfY(rawClass, CLASS_DOM_DOCUMENT)) {
                return (JsonDeserializer) instantiate(DESERIALIZER_FOR_DOM_DOCUMENT, javaType);
            }
            String name = rawClass.getName();
            String str = this._sqlDeserializers.get(name);
            if (str != null) {
                return (JsonDeserializer) instantiate(str, javaType);
            }
            if ((name.startsWith(PACKAGE_PREFIX_JAVAX_XML) || hasSuperClassStartingWith(rawClass, PACKAGE_PREFIX_JAVAX_XML)) && (instantiate = instantiate(DESERIALIZERS_FOR_JAVAX_XML, javaType)) != null) {
                return ((Deserializers) instantiate).findBeanDeserializer(javaType, deserializationConfig, beanDescription);
            }
            return null;
        }
        return deserializerForJavaNioFilePath;
    }

    public boolean hasDeserializerFor(Class<?> cls) {
        if (_IsXOfY(cls, CLASS_DOM_NODE) || _IsXOfY(cls, CLASS_DOM_DOCUMENT)) {
            return true;
        }
        String name = cls.getName();
        if (name.startsWith(PACKAGE_PREFIX_JAVAX_XML) || hasSuperClassStartingWith(cls, PACKAGE_PREFIX_JAVAX_XML)) {
            return true;
        }
        return this._sqlDeserializers.containsKey(name);
    }

    private boolean _IsXOfY(Class<?> cls, Class<?> cls2) {
        return cls2 != null && cls2.isAssignableFrom(cls);
    }

    private Object instantiate(String str, JavaType javaType) {
        try {
            return instantiate(Class.forName(str), javaType);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to find class `" + str + "` for handling values of type " + ClassUtil.getTypeDescription(javaType) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    private Object instantiate(Class<?> cls, JavaType javaType) {
        try {
            return ClassUtil.createInstance(cls, false);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to create instance of `" + cls.getName() + "` for handling values of type " + ClassUtil.getTypeDescription(javaType) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    private boolean hasSuperClassStartingWith(Class<?> cls, String str) {
        do {
            cls = cls.getSuperclass();
            if (cls == null || cls == Object.class) {
                return false;
            }
        } while (!cls.getName().startsWith(str));
        return true;
    }
}
